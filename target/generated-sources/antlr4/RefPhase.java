import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class RefPhase extends GrummBaseListener {
    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope; // resolve symbols starting in this scope
    
    private boolean isFunctionExist(FunctionSymbol functionSymbol) {
    	boolean result = true;
    	
        if (functionSymbol == null) {
            result = false;
        }
        
        if (!(functionSymbol instanceof FunctionSymbol)) {
            result = false;
        }
        
        return result;
    }

    public RefPhase(GlobalScope globals, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.globals = globals;
    }
    public void enterFile(GrummParser.FileContext ctx) {
        currentScope = globals;
    }

    public void enterFunctionDecl(GrummParser.FunctionDeclContext ctx) {
        currentScope = scopes.get(ctx);
    }
    public void exitFunctionDecl(GrummParser.FunctionDeclContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }
	
    public void enterBlock(GrummParser.BlockContext ctx) {
        currentScope = scopes.get(ctx);
    }
    public void exitBlock(GrummParser.BlockContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    public void exitVar(GrummParser.VarContext ctx) {
        String name = ctx.ID().getSymbol().getText();
        Symbol var = currentScope.resolve(name);
        if ( var==null ) {
            CheckSymbols.error(ctx.ID().getSymbol(), "no such variable: "+name);
        }
        if ( var instanceof FunctionSymbol ) {
            CheckSymbols.error(ctx.ID().getSymbol(), name+" is not a variable");
        }
    }
    
    public void enterCallOnObject(GrummParser.CallOnObjectContext ctx) {
    	//TODO: if the object type is a string, check that the function is a defined function for strings
    	

    	//TODO: if the object type is a user-defined class, verify that the function is defined in that class
    }
    
    public void exitCall(GrummParser.CallContext ctx) {
        // verify that the function that's being called is defined
        String funcName = ctx.ID().getText();
        FunctionSymbol functionSymbol = (FunctionSymbol) currentScope.resolve(funcName);

        if (!(isFunctionExist(functionSymbol))) {
            CheckSymbols.error(ctx.ID().getSymbol(), "no such function: " + funcName);
        }

        // verify that the number of arguments to the function are correct
        int count = 0;
        for (ParseTree pt : ctx.exprList().children) {
        	if (!(pt instanceof TerminalNodeImpl)) {
        		count++;
        	}
        }
        
        if (count != functionSymbol.arguments.size()) {
        	CheckSymbols.error(ctx.ID().getSymbol(), "function '" + funcName + "' is being called with the wrong number of arguments");
        }

        //TODO: verify that the arguments to the function are the correct type
    }
}