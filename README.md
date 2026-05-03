# Delphi-style Pascal interpreter (Java + ANTLR 4)

Small educational interpreter that parses **Object Pascal–like** `.pas` programs with [`delphi.g4`](src/delphi/delphi.g4) and walks the parse tree with a [`Interpreter`](src/delphi/Interpreter.java) listener.

## Grammar (`delphi.g4`)

The canonical grammar lives at [`src/delphi/delphi.g4`](src/delphi/delphi.g4). The block below is the same source so you can read the language without opening the file; if they disagree, trust **`delphi.g4`**.

```antlr
grammar delphi;

program
    : classDeclaration* variableDeclaration* 'begin' statement* 'end' '.'
    ;

classDeclaration
    : 'class' ID '{' classBody '}' '.'
    ;

classBody
    : (fieldDeclaration | methodDeclaration | constructorDeclaration | destructorDeclaration)*
    ;

fieldDeclaration
    : ('private' | 'public') ID ':' typeName ';'
    ;

methodDeclaration
    : ('private' | 'public') ('procedure' | 'function') ID paramList? (':' typeName)? ';' block
    ;

constructorDeclaration
    : 'constructor' (ID | 'Create') paramList? ';' block
    ;

destructorDeclaration
    : 'destructor' ID ';' block
    ;

paramList
    : '(' param? (',' param)* ')'
    ;

param
    : ID ':' typeName
    ;

block
    : 'begin' statement* 'end' ';'
    ;

statement
    : assignment
    | methodCall
    | variableDeclaration
    | returnStatement
    | printStatement
    ;

assignment
    : ID ':=' expr ';'
    ;

variableDeclaration
    : 'var' ID ':' typeName ';'
    ;

methodCall
    : ID '.' ID '(' exprList? ')' ';'
    | ID '(' exprList? ')' ';'
    ;

returnStatement
    : 'return' expr ';'
    ;

exprList
    : expr (',' expr)*
    ;

expr
    : INT                                  #intExpr
    | STRING                               #stringExpr
    | BOOL                                 #boolExpr
    | ID                                   #idExpr
    | ID '.' ('Create' | ID) '(' exprList? ')' #createExpr // Fixed .Create() calls
    | ID '.' ID '(' exprList? ')'          #methodExpr
    ;

typeName
    : 'integer'
    | 'boolean'
    | 'string'
    | ID
    ;

printStatement
    : 'writeln' '(' expr ')' ';'
    ;

// Lexer Rules
ID      : [a-zA-Z_][a-zA-Z_0-9]* ;
INT     : [0-9]+ ;
STRING  : '"' .*? '"' ;
BOOL    : 'true' | 'false' ;
WS      : [ \t\r\n]+ -> skip ;
COMMENT : '//' ~[\r\n]* -> skip ;
```

**Surface syntax notes implied by the grammar**

- Program shape: zero or more `class … { … }.` declarations, zero or more `var` lines, then `begin` … `end.` (no `program Name;` header).
- Classes use **curly braces** `{` `}` and end the class with **`.`** after `}`.
- Output is **`writeln(` … `);`** only (case-sensitive in the lexer literals).
- String literals use **double quotes** `"…"`, not Pascal single quotes.
- Comment lines: `//` through end of line.

## Prerequisites

- **Java JDK** (for `javac` and `java`)
- **[ANTLR 4](https://github.com/antlr/antlr4)** runtime:
  - A single `antlr-4.*-complete.jar` on disk ( Classpath includes this JAR.)

The examples below use:

```bash
export ANTLR_JAR="/usr/local/lib/antlr-4.13.2-complete.jar"
```

Adjust `ANTLR_JAR` if your JAR lives elsewhere (`JAVA_CP` in the test script works the same way).

## Compile the generated lexer, parser, and interpreter

From the repo root:

```bash
javac -cp "$ANTLR_JAR" -d src/ src/delphi/*.java
```

This emits `.class` files under `src/`, alongside the existing sources.

## Regenerate the lexer and parser after editing the grammar

The checked-in grammar file is **`src/delphi/delphi.g4`** (not `delphi.g`).

From the repo root:

```bash
java -jar "$ANTLR_JAR" -Dlanguage=Java -listener -visitor src/delphi/delphi.g4 -o src/delphi
```

If you use the `antlr4` script instead of `java -jar`:

```bash
cd src/delphi
antlr4 -Dlanguage=Java -listener -visitor delphi.g4
```

The interpreter subclasses `delphiBaseListener`, so regenerate with **listener** support (shown above). `-visitor` is optional (adds visitor classes).

Then recompile with `javac` as in the previous section.

## Run a program

Inputs are **`program`** rules: optional classes, optional `var` lines, then `begin` … `end.`

```bash
java -cp "$ANTLR_JAR:src/" Main path/to/program.pas
```

Example:

```bash
java -cp "$ANTLR_JAR:src/" Main test/test1.pas
```

Expected standard output:

```text
10
```

## Run the golden-output test suite

The tests compare **stdout only** against files in [`test/expected/`](test/expected/).

```bash
./scripts/run-tests.sh
```

Override the JAR or classpath when needed:

```bash
ANTLR_JAR=/path/to/antlr-4.13.2-complete.jar ./scripts/run-tests.sh
```

## Included tests

| Program | Intended behavior (stdout; plus notes) |
|--------|----------------------------------------|
| `test/test1.pas` | `MyClass`: `setX(10)`, `getX()` prints **`10`** (see interpreter special-case for `setX`/`getX`). |
| `test/test2.pas` | Demonstrates **pre-order traversal** of the parse tree inside class declarations; **`newName`** is printed while the tree is walked, not from realistic “call Main then call methods” execution. |
| `test/test_print.pas` | `writeln` of a string and an integer from the main block. |
| `test/test_vars.pas` | Global variable declarations, assignments, and `writeln`. |
| `test/test_myclass_twice.pas` | Two `MyClass` instances with different `setX` values; two `getX` lines. |
| `test/test_bool_print.pas` | `writeln` of boolean literals. |

Expected bytes for each test are in `test/expected/<name>.expected`.

## Known limitations

- Execution follows **ANTLR’s parse-tree walk** (roughly pre-order), not a full procedure call stack. Method bodies on classes are visited when the tree is walked, not only when a call appears in `begin` … `end`.
- **Object method calls** are only implemented in a narrow way: `setX` updates a field named `x`, and `getX` prints that field. Other methods are not generally executed on call.
- **Expressions** in the grammar are mostly literals, identifiers, and `Instance.Create()`; there is no general arithmetic (`+`, `-`, …) in `expr`.
- **Main** must be the default package; keep `java -cp …:src/` with `Main` on the classpath as built above.

## Layout

- `src/delphi/delphi.g4` — grammar  
- `src/delphi/Interpreter.java` — `delphiBaseListener` implementation  
- `src/delphi/Main.java` — driver  
- `test/*.pas` — sample programs  
- `test/expected/*.expected` — exact expected stdout for `scripts/run-tests.sh`
