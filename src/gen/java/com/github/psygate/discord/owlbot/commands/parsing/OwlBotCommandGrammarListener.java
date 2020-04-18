// Generated from OwlBotCommandGrammar.g4 by ANTLR 4.8
package com.github.psygate.discord.owlbot.commands.parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OwlBotCommandGrammarParser}.
 */
public interface OwlBotCommandGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OwlBotCommandGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(OwlBotCommandGrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link OwlBotCommandGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(OwlBotCommandGrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link OwlBotCommandGrammarParser#nonWhiteSpace}.
	 * @param ctx the parse tree
	 */
	void enterNonWhiteSpace(OwlBotCommandGrammarParser.NonWhiteSpaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OwlBotCommandGrammarParser#nonWhiteSpace}.
	 * @param ctx the parse tree
	 */
	void exitNonWhiteSpace(OwlBotCommandGrammarParser.NonWhiteSpaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OwlBotCommandGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(OwlBotCommandGrammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OwlBotCommandGrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(OwlBotCommandGrammarParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OwlBotCommandGrammarParser#commandName}.
	 * @param ctx the parse tree
	 */
	void enterCommandName(OwlBotCommandGrammarParser.CommandNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OwlBotCommandGrammarParser#commandName}.
	 * @param ctx the parse tree
	 */
	void exitCommandName(OwlBotCommandGrammarParser.CommandNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OwlBotCommandGrammarParser#parseCommand}.
	 * @param ctx the parse tree
	 */
	void enterParseCommand(OwlBotCommandGrammarParser.ParseCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link OwlBotCommandGrammarParser#parseCommand}.
	 * @param ctx the parse tree
	 */
	void exitParseCommand(OwlBotCommandGrammarParser.ParseCommandContext ctx);
}