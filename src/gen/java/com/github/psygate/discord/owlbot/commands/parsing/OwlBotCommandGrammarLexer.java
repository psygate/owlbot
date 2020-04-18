// Generated from OwlBotCommandGrammar.g4 by ANTLR 4.8
package com.github.psygate.discord.owlbot.commands.parsing;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OwlBotCommandGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SINGLE_QUOTE_STRING=1, DOUBLE_QUOTE_STRING=2, ANYTHING_EXCEPT_WHITESPACE=3, 
		WS=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SINGLE_QUOTE", "DOUBLE_QUOTE", "EscapeSequence", "SINGLE_QUOTE_STRING", 
			"DOUBLE_QUOTE_STRING", "ANYTHING_EXCEPT_WHITESPACE", "WS"
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


	public OwlBotCommandGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "OwlBotCommandGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\68\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\7\5\34\n\5\f\5\16\5\37\13\5\3\5\3\5\3\6\3\6\3\6\7\6&"+
		"\n\6\f\6\16\6)\13\6\3\6\3\6\3\7\6\7.\n\7\r\7\16\7/\3\b\6\b\63\n\b\r\b"+
		"\16\b\64\3\b\3\b\2\2\t\3\2\5\2\7\2\t\3\13\4\r\5\17\6\3\2\7\n\2$$))^^d"+
		"dhhppttvv\6\2\f\f\17\17))^^\6\2\f\f\17\17$$^^\5\2\13\f\16\17\"\"\5\2\13"+
		"\f\17\17\"\"\2:\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21"+
		"\3\2\2\2\5\23\3\2\2\2\7\25\3\2\2\2\t\30\3\2\2\2\13\"\3\2\2\2\r-\3\2\2"+
		"\2\17\62\3\2\2\2\21\22\7)\2\2\22\4\3\2\2\2\23\24\7$\2\2\24\6\3\2\2\2\25"+
		"\26\7^\2\2\26\27\t\2\2\2\27\b\3\2\2\2\30\35\7)\2\2\31\34\n\3\2\2\32\34"+
		"\5\7\4\2\33\31\3\2\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36"+
		"\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7)\2\2!\n\3\2\2\2\"\'\7$\2\2#&\n"+
		"\4\2\2$&\5\7\4\2%#\3\2\2\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2("+
		"*\3\2\2\2)\'\3\2\2\2*+\7$\2\2+\f\3\2\2\2,.\n\5\2\2-,\3\2\2\2./\3\2\2\2"+
		"/-\3\2\2\2/\60\3\2\2\2\60\16\3\2\2\2\61\63\t\6\2\2\62\61\3\2\2\2\63\64"+
		"\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\b\b\2\2\67\20"+
		"\3\2\2\2\t\2\33\35%\'/\64\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}