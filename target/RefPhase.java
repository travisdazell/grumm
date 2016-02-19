/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class RefPhase extends GrummBaseListener {
    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope; // resolve symbols starting in this scope

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

    public void exitCall(GrummParser.CallContext ctx) {
        // verify that the function that's being called is defined
        String funcName = ctx.ID().getText();
        FunctionSymbol functionSymbol = (FunctionSymbol) currentScope.resolve(funcName);
        if (functionSymbol == null) {
            CheckSymbols.error(ctx.ID().getSymbol(), "no such function: " + funcName);
        }
        if (!(functionSymbol instanceof FunctionSymbol)) {
            CheckSymbols.error(ctx.ID().getSymbol(), funcName+" is not a function");
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