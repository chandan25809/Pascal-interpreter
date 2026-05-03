import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Interpreter extends delphiBaseListener {
    private Map<String, Object> variables = new HashMap<>();
    private Map<String, Map<String, Object>> objects = new HashMap<>();
    private Map<String, ClassDefinition> classes = new HashMap<>();
    private String currentObjectContext = null;

    private static class ClassDefinition {
        Map<String, String> fields = new HashMap<>();
        Map<String, MethodDefinition> methods = new HashMap<>();
    }

    private static class MethodDefinition {
        String returnType;
        Map<String, String> parameters = new HashMap<>();
    }

    @Override
    public void enterClassDeclaration(delphiParser.ClassDeclarationContext ctx) {
        String className = ctx.ID().getText();
        classes.put(className, new ClassDefinition());
    }

    @Override
    public void enterFieldDeclaration(delphiParser.FieldDeclarationContext ctx) {
        String className = getCurrentClassName(ctx);
        String fieldName = ctx.ID().getText();
        String fieldType = ctx.typeName().getText();
        if (className != null && classes.containsKey(className)) {
            classes.get(className).fields.put(fieldName, fieldType);
        }
    }

    @Override
    public void enterMethodDeclaration(delphiParser.MethodDeclarationContext ctx) {
        String className = getCurrentClassName(ctx);
        if (className == null) return;
        
        String methodName = ctx.ID().getText();
        MethodDefinition method = new MethodDefinition();
        
        if (ctx.typeName() != null) {
            method.returnType = ctx.typeName().getText();
        }
        
        if (ctx.paramList() != null) {
            for (delphiParser.ParamContext param : ctx.paramList().param()) {
                method.parameters.put(param.ID().getText(), param.typeName().getText());
            }
        }
        
        classes.get(className).methods.put(methodName, method);
    }

    // @Override
    // public void enterAssignment(delphiParser.AssignmentContext ctx) {
    //     String varName = ctx.ID().getText();
        
    //     if (ctx.expr() instanceof delphiParser.CreateExprContext) {
    //         // Handle object creation
    //         String className = ((delphiParser.CreateExprContext) ctx.expr()).ID(0).getText();
    //         objects.put(varName, new HashMap<>());
    //         return;
    //     }
        
    //     if (currentObjectContext != null && objects.containsKey(currentObjectContext)) {
    //         // We're in a method context, store in object's fields
    //         try {
    //             int value = Integer.parseInt(ctx.expr().getText());
    //             objects.get(currentObjectContext).put(varName, value);
    //         } catch (NumberFormatException e) {
    //             objects.get(currentObjectContext).put(varName, ctx.expr().getText());
    //         }
    //     } else {
    //         // Regular variable assignment
    //         try {
    //             int value = Integer.parseInt(ctx.expr().getText());
    //             variables.put(varName, value);
    //         } catch (NumberFormatException e) {
    //             variables.put(varName, ctx.expr().getText());
    //         }
    //     }
    // }

    @Override
    public void enterMethodCall(delphiParser.MethodCallContext ctx) {
        if (ctx.ID().size() < 2) return;
        
        String objectName = ctx.ID(0).getText();
        String methodName = ctx.ID(1).getText();
        
        if (objects.containsKey(objectName)) {
            Map<String, Object> objectFields = objects.get(objectName);
            currentObjectContext = objectName;
            
            if (methodName.equals("setX") && ctx.exprList() != null) {
                try {
                    String value = ctx.exprList().expr(0).getText();
                    objectFields.put("x", Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid number format in setX");
                }
            } else if (methodName.equals("getX")) {
                Object value = objectFields.get("x");
                if (value != null) {
                    System.out.println(value);
                }
            }
            
            currentObjectContext = null;
        }
    }

    private String getCurrentClassName(org.antlr.v4.runtime.ParserRuleContext ctx) {
        while (ctx != null && !(ctx instanceof delphiParser.ClassDeclarationContext)) {
            ctx = ctx.getParent();
        }
        if (ctx != null) {
            return ((delphiParser.ClassDeclarationContext) ctx).ID().getText();
        }
        return null;
    }



    
    // Resolve expressions: variables, object fields, literals
    private String evaluateExpression(delphiParser.ExprContext expr) {
        String exprText = expr.getText();

        // 1️⃣ If inside object, check object fields first (e.g. writeln(name) inside getName())
        if (currentObjectContext != null && objects.containsKey(currentObjectContext)) {
            Map<String, Object> fields = objects.get(currentObjectContext);
            if (fields.containsKey(exprText)) {
                return fields.get(exprText).toString();
            }
        }

        // 2️⃣ Handle object fields (e.g., p.name)
        if (expr instanceof delphiParser.MethodExprContext) {
            delphiParser.MethodExprContext methodExpr = (delphiParser.MethodExprContext) expr;
            String objectName = methodExpr.ID(0).getText();
            String fieldName = methodExpr.ID(1).getText();
            if (objects.containsKey(objectName) && objects.get(objectName).containsKey(fieldName)) {
                return objects.get(objectName).get(fieldName).toString();
            }
        }

        // 3️⃣ Handle standalone variables
        if (variables.containsKey(exprText)) {
            return variables.get(exprText).toString();
        }

        // 4️⃣ Handle string literals
        if (exprText.startsWith("\"") && exprText.endsWith("\"")) {
            return exprText.substring(1, exprText.length() - 1);
        }

        // 5️⃣ Handle numeric literals
        try {
            Integer.parseInt(exprText);
            return exprText;
        } catch (NumberFormatException ignored) {}

        return exprText; // Fallback
    }



    @Override
    public void enterPrintStatement(delphiParser.PrintStatementContext ctx) {
        String value = evaluateExpression(ctx.expr());
        System.out.println(value);
    }

    // @Override
    // public void enterAssignment(delphiParser.AssignmentContext ctx) {
    //     String varName = ctx.ID().getText();
    //     String value = evaluateExpression(ctx.expr());

    //     // Store object fields if in object context
    //     if (currentObjectContext != null && objects.containsKey(currentObjectContext)) {
    //         objects.get(currentObjectContext).put(varName, value);
    //     } else {
    //         variables.put(varName, value);
    //     }
    // }


    @Override
    public void enterAssignment(delphiParser.AssignmentContext ctx) {
        String varName = ctx.ID().getText();
        String value = evaluateExpression(ctx.expr());

        // Handle object creation
        if (ctx.expr() instanceof delphiParser.CreateExprContext) {
            String className = ((delphiParser.CreateExprContext) ctx.expr()).ID(0).getText();
            objects.put(varName, new HashMap<>());
            return;
        }

        // Store in object fields if inside object context
        if (currentObjectContext != null && objects.containsKey(currentObjectContext)) {
            objects.get(currentObjectContext).put(varName, value);
        } else {
            // Store as a regular variable
            variables.put(varName, value);
        }
    }

    


    public void interpret(delphiParser.ProgramContext tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
    }
}