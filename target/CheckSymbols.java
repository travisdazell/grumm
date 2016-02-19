/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

public class CheckSymbols {
    public static Symbol.Type getType(int tokenType) {
        switch ( tokenType ) {
            case GrummParser.K_VOID :  return Symbol.Type.tVOID;
            case GrummParser.K_INT :   return Symbol.Type.tINT;
            case GrummParser.K_FLOAT : return Symbol.Type.tFLOAT;
            case GrummParser.K_STRING : return Symbol.Type.tSTRING;
        }
        return Symbol.Type.tINVALID;
    }

    public static void error(Token t, String msg) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                          msg);
    }

    public void process(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase def = new DefPhase();
        walker.walk(def, tree);
        // create next phase and feed symbol table info from def to ref phase
        RefPhase ref = new RefPhase(def.globals, def.scopes);
        walker.walk(ref, tree);
    }
}