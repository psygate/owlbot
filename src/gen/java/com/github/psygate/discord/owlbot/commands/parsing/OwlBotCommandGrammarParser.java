// Generated from OwlBotCommandGrammar.g4 by ANTLR 4.8
package com.github.psygate.discord.owlbot.commands.parsing;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OwlBotCommandGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SINGLE_QUOTE_STRING=1, DOUBLE_QUOTE_STRING=2, ANYTHING_EXCEPT_WHITESPACE=3, 
		WS=4;
	public static final int
		RULE_string = 0, RULE_nonWhiteSpace = 1, RULE_argument = 2, RULE_commandName = 3, 
		RULE_parseCommand = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"string", "nonWhiteSpace", "argument", "commandName", "parseCommand"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SINGLE_QUOTE_STRING", "DOUBLE_QUOTE_STRING", "ANYTHING_EXCEPT_WHITESPACE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "OwlBotCommandGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OwlBotCommandGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode SINGLE_QUOTE_STRING() { return getToken(OwlBotCommandGrammarParser.SINGLE_QUOTE_STRING, 0); }
		public TerminalNode DOUBLE_QUOTE_STRING() { return getToken(OwlBotCommandGrammarParser.DOUBLE_QUOTE_STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			_la = _input.LA(1);
			if ( !(_la==SINGLE_QUOTE_STRING || _la==DOUBLE_QUOTE_STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonWhiteSpaceContext extends ParserRuleContext {
		public TerminalNode ANYTHING_EXCEPT_WHITESPACE() { return getToken(OwlBotCommandGrammarParser.ANYTHING_EXCEPT_WHITESPACE, 0); }
		public NonWhiteSpaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWhiteSpace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).enterNonWhiteSpace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).exitNonWhiteSpace(this);
		}
	}

	public final NonWhiteSpaceContext nonWhiteSpace() throws RecognitionException {
		NonWhiteSpaceContext _localctx = new NonWhiteSpaceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nonWhiteSpace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(ANYTHING_EXCEPT_WHITESPACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NonWhiteSpaceContext nonWhiteSpace() {
			return getRuleContext(NonWhiteSpaceContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_argument);
		try {
			setState(16);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTE_STRING:
			case DOUBLE_QUOTE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				string();
				}
				break;
			case ANYTHING_EXCEPT_WHITESPACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				nonWhiteSpace();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandNameContext extends ParserRuleContext {
		public NonWhiteSpaceContext nonWhiteSpace() {
			return getRuleContext(NonWhiteSpaceContext.class,0);
		}
		public CommandNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).enterCommandName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).exitCommandName(this);
		}
	}

	public final CommandNameContext commandName() throws RecognitionException {
		CommandNameContext _localctx = new CommandNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_commandName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			nonWhiteSpace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParseCommandContext extends ParserRuleContext {
		public CommandNameContext commandName() {
			return getRuleContext(CommandNameContext.class,0);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ParseCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).enterParseCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OwlBotCommandGrammarListener ) ((OwlBotCommandGrammarListener)listener).exitParseCommand(this);
		}
	}

	public final ParseCommandContext parseCommand() throws RecognitionException {
		ParseCommandContext _localctx = new ParseCommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parseCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			commandName();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_QUOTE_STRING) | (1L << DOUBLE_QUOTE_STRING) | (1L << ANYTHING_EXCEPT_WHITESPACE))) != 0)) {
				{
				{
				setState(21);
				argument();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\6\36\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\4\3\4\5\4\23\n\4\3\5\3"+
		"\5\3\6\3\6\7\6\31\n\6\f\6\16\6\34\13\6\3\6\2\2\7\2\4\6\b\n\2\3\3\2\3\4"+
		"\2\32\2\f\3\2\2\2\4\16\3\2\2\2\6\22\3\2\2\2\b\24\3\2\2\2\n\26\3\2\2\2"+
		"\f\r\t\2\2\2\r\3\3\2\2\2\16\17\7\5\2\2\17\5\3\2\2\2\20\23\5\2\2\2\21\23"+
		"\5\4\3\2\22\20\3\2\2\2\22\21\3\2\2\2\23\7\3\2\2\2\24\25\5\4\3\2\25\t\3"+
		"\2\2\2\26\32\5\b\5\2\27\31\5\6\4\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3"+
		"\2\2\2\32\33\3\2\2\2\33\13\3\2\2\2\34\32\3\2\2\2\4\22\32";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}