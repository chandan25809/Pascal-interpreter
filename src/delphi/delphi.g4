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
