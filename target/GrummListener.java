// Generated from Grumm.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrummParser}.
 */
public interface GrummListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrummParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(@NotNull GrummParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(@NotNull GrummParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull GrummParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull GrummParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull GrummParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull GrummParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(@NotNull GrummParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(@NotNull GrummParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull GrummParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull GrummParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(@NotNull GrummParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(@NotNull GrummParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Index}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndex(@NotNull GrummParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndex(@NotNull GrummParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull GrummParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull GrummParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull GrummParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull GrummParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull GrummParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull GrummParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Float}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloat(@NotNull GrummParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloat(@NotNull GrummParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull GrummParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull GrummParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull GrummParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull GrummParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMult(@NotNull GrummParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMult(@NotNull GrummParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqual(@NotNull GrummParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqual(@NotNull GrummParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(@NotNull GrummParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(@NotNull GrummParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(@NotNull GrummParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(@NotNull GrummParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull GrummParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull GrummParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegate(@NotNull GrummParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link GrummParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegate(@NotNull GrummParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(@NotNull GrummParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(@NotNull GrummParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(@NotNull GrummParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(@NotNull GrummParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrummParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(@NotNull GrummParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrummParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(@NotNull GrummParser.ClassDefinitionContext ctx);
}