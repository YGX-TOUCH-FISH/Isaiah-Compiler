// Generated from E:/SJTU/3CompilerWorkplace/src/Parser\Isaiah.g4 by ANTLR 4.9.1
package Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsaiahLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Int=3, Bool=4, String=5, Null=6, Void=7, True=8, False=9, 
		If=10, Else=11, For=12, While=13, Break=14, Continue=15, Return=16, New=17, 
		Class=18, This=19, Dot=20, LeftParen=21, RightParen=22, LeftBracket=23, 
		RightBracket=24, LeftBrace=25, RightBrace=26, Less=27, LessEqual=28, Greater=29, 
		GreaterEqual=30, LeftShift=31, RightShift=32, Plus=33, SelfPlus=34, Minus=35, 
		SelfMinus=36, Mul=37, Div=38, Mod=39, And=40, Or=41, AndAnd=42, OrOr=43, 
		Caret=44, Not=45, Tilde=46, Question=47, Colon=48, Semi=49, Comma=50, 
		Assign=51, Equal=52, NotEqual=53, BackSlash=54, DbQuotation=55, BlockComment=56, 
		BlankChar=57, LineComment=58, Identifier=59, IntConst=60, StringConst=61;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "Int", "Bool", "String", "Null", "Void", "True", "False", 
			"If", "Else", "For", "While", "Break", "Continue", "Return", "New", "Class", 
			"This", "Dot", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"LeftShift", "RightShift", "Plus", "SelfPlus", "Minus", "SelfMinus", 
			"Mul", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", 
			"Question", "Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", 
			"BackSlash", "DbQuotation", "BlockComment", "BlankChar", "LineComment", 
			"Identifier", "IntConst", "StringConst"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[&]'", "'->'", "'int'", "'bool'", "'string'", "'null'", "'void'", 
			"'true'", "'false'", "'if'", "'else'", "'for'", "'while'", "'break'", 
			"'continue'", "'return'", "'new'", "'class'", "'this'", "'.'", "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", 
			"'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", 
			"'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", "'='", 
			"'=='", "'!='", "'\\\\'", "'\\\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "Int", "Bool", "String", "Null", "Void", "True", "False", 
			"If", "Else", "For", "While", "Break", "Continue", "Return", "New", "Class", 
			"This", "Dot", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"LeftShift", "RightShift", "Plus", "SelfPlus", "Minus", "SelfMinus", 
			"Mul", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", 
			"Question", "Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", 
			"BackSlash", "DbQuotation", "BlockComment", "BlankChar", "LineComment", 
			"Identifier", "IntConst", "StringConst"
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


	public IsaiahLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Isaiah.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u0170\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3&\3&\3\'"+
		"\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3"+
		"\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3"+
		"\67\3\67\3\67\38\38\38\39\39\39\39\79\u0139\n9\f9\169\u013c\139\39\39"+
		"\39\39\39\3:\3:\3:\3:\3;\3;\3;\3;\7;\u014b\n;\f;\16;\u014e\13;\3;\3;\3"+
		"<\3<\7<\u0154\n<\f<\16<\u0157\13<\3=\3=\7=\u015b\n=\f=\16=\u015e\13=\3"+
		"=\5=\u0161\n=\3>\3>\3>\3>\3>\3>\3>\7>\u016a\n>\f>\16>\u016d\13>\3>\3>"+
		"\3\u013a\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w=y>{?\3\2\f\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2C\\"+
		"c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\3\2\"\u0080\3\2^^\4\2^^pp\3\2$$\2\u0178"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\3}\3\2\2\2\5\u0081\3\2\2\2\7\u0084\3\2\2\2\t\u0088\3\2\2\2\13"+
		"\u008d\3\2\2\2\r\u0094\3\2\2\2\17\u0099\3\2\2\2\21\u009e\3\2\2\2\23\u00a3"+
		"\3\2\2\2\25\u00a9\3\2\2\2\27\u00ac\3\2\2\2\31\u00b1\3\2\2\2\33\u00b5\3"+
		"\2\2\2\35\u00bb\3\2\2\2\37\u00c1\3\2\2\2!\u00ca\3\2\2\2#\u00d1\3\2\2\2"+
		"%\u00d5\3\2\2\2\'\u00db\3\2\2\2)\u00e0\3\2\2\2+\u00e2\3\2\2\2-\u00e4\3"+
		"\2\2\2/\u00e6\3\2\2\2\61\u00e8\3\2\2\2\63\u00ea\3\2\2\2\65\u00ec\3\2\2"+
		"\2\67\u00ee\3\2\2\29\u00f0\3\2\2\2;\u00f3\3\2\2\2=\u00f5\3\2\2\2?\u00f8"+
		"\3\2\2\2A\u00fb\3\2\2\2C\u00fe\3\2\2\2E\u0100\3\2\2\2G\u0103\3\2\2\2I"+
		"\u0105\3\2\2\2K\u0108\3\2\2\2M\u010a\3\2\2\2O\u010c\3\2\2\2Q\u010e\3\2"+
		"\2\2S\u0110\3\2\2\2U\u0112\3\2\2\2W\u0115\3\2\2\2Y\u0118\3\2\2\2[\u011a"+
		"\3\2\2\2]\u011c\3\2\2\2_\u011e\3\2\2\2a\u0120\3\2\2\2c\u0122\3\2\2\2e"+
		"\u0124\3\2\2\2g\u0126\3\2\2\2i\u0128\3\2\2\2k\u012b\3\2\2\2m\u012e\3\2"+
		"\2\2o\u0131\3\2\2\2q\u0134\3\2\2\2s\u0142\3\2\2\2u\u0146\3\2\2\2w\u0151"+
		"\3\2\2\2y\u0160\3\2\2\2{\u0162\3\2\2\2}~\7]\2\2~\177\7(\2\2\177\u0080"+
		"\7_\2\2\u0080\4\3\2\2\2\u0081\u0082\7/\2\2\u0082\u0083\7@\2\2\u0083\6"+
		"\3\2\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087"+
		"\b\3\2\2\2\u0088\u0089\7d\2\2\u0089\u008a\7q\2\2\u008a\u008b\7q\2\2\u008b"+
		"\u008c\7n\2\2\u008c\n\3\2\2\2\u008d\u008e\7u\2\2\u008e\u008f\7v\2\2\u008f"+
		"\u0090\7t\2\2\u0090\u0091\7k\2\2\u0091\u0092\7p\2\2\u0092\u0093\7i\2\2"+
		"\u0093\f\3\2\2\2\u0094\u0095\7p\2\2\u0095\u0096\7w\2\2\u0096\u0097\7n"+
		"\2\2\u0097\u0098\7n\2\2\u0098\16\3\2\2\2\u0099\u009a\7x\2\2\u009a\u009b"+
		"\7q\2\2\u009b\u009c\7k\2\2\u009c\u009d\7f\2\2\u009d\20\3\2\2\2\u009e\u009f"+
		"\7v\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7w\2\2\u00a1\u00a2\7g\2\2\u00a2"+
		"\22\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7n\2\2\u00a6"+
		"\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a8\24\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa"+
		"\u00ab\7h\2\2\u00ab\26\3\2\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7n\2\2\u00ae"+
		"\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0\30\3\2\2\2\u00b1\u00b2\7h\2\2\u00b2"+
		"\u00b3\7q\2\2\u00b3\u00b4\7t\2\2\u00b4\32\3\2\2\2\u00b5\u00b6\7y\2\2\u00b6"+
		"\u00b7\7j\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7g\2\2"+
		"\u00ba\34\3\2\2\2\u00bb\u00bc\7d\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7"+
		"g\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7m\2\2\u00c0\36\3\2\2\2\u00c1\u00c2"+
		"\7e\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7v\2\2\u00c5"+
		"\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9\7g\2\2"+
		"\u00c9 \3\2\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7v\2"+
		"\2\u00cd\u00ce\7w\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d0\7p\2\2\u00d0\"\3"+
		"\2\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7y\2\2\u00d4"+
		"$\3\2\2\2\u00d5\u00d6\7e\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8\7c\2\2\u00d8"+
		"\u00d9\7u\2\2\u00d9\u00da\7u\2\2\u00da&\3\2\2\2\u00db\u00dc\7v\2\2\u00dc"+
		"\u00dd\7j\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7u\2\2\u00df(\3\2\2\2\u00e0"+
		"\u00e1\7\60\2\2\u00e1*\3\2\2\2\u00e2\u00e3\7*\2\2\u00e3,\3\2\2\2\u00e4"+
		"\u00e5\7+\2\2\u00e5.\3\2\2\2\u00e6\u00e7\7]\2\2\u00e7\60\3\2\2\2\u00e8"+
		"\u00e9\7_\2\2\u00e9\62\3\2\2\2\u00ea\u00eb\7}\2\2\u00eb\64\3\2\2\2\u00ec"+
		"\u00ed\7\177\2\2\u00ed\66\3\2\2\2\u00ee\u00ef\7>\2\2\u00ef8\3\2\2\2\u00f0"+
		"\u00f1\7>\2\2\u00f1\u00f2\7?\2\2\u00f2:\3\2\2\2\u00f3\u00f4\7@\2\2\u00f4"+
		"<\3\2\2\2\u00f5\u00f6\7@\2\2\u00f6\u00f7\7?\2\2\u00f7>\3\2\2\2\u00f8\u00f9"+
		"\7>\2\2\u00f9\u00fa\7>\2\2\u00fa@\3\2\2\2\u00fb\u00fc\7@\2\2\u00fc\u00fd"+
		"\7@\2\2\u00fdB\3\2\2\2\u00fe\u00ff\7-\2\2\u00ffD\3\2\2\2\u0100\u0101\7"+
		"-\2\2\u0101\u0102\7-\2\2\u0102F\3\2\2\2\u0103\u0104\7/\2\2\u0104H\3\2"+
		"\2\2\u0105\u0106\7/\2\2\u0106\u0107\7/\2\2\u0107J\3\2\2\2\u0108\u0109"+
		"\7,\2\2\u0109L\3\2\2\2\u010a\u010b\7\61\2\2\u010bN\3\2\2\2\u010c\u010d"+
		"\7\'\2\2\u010dP\3\2\2\2\u010e\u010f\7(\2\2\u010fR\3\2\2\2\u0110\u0111"+
		"\7~\2\2\u0111T\3\2\2\2\u0112\u0113\7(\2\2\u0113\u0114\7(\2\2\u0114V\3"+
		"\2\2\2\u0115\u0116\7~\2\2\u0116\u0117\7~\2\2\u0117X\3\2\2\2\u0118\u0119"+
		"\7`\2\2\u0119Z\3\2\2\2\u011a\u011b\7#\2\2\u011b\\\3\2\2\2\u011c\u011d"+
		"\7\u0080\2\2\u011d^\3\2\2\2\u011e\u011f\7A\2\2\u011f`\3\2\2\2\u0120\u0121"+
		"\7<\2\2\u0121b\3\2\2\2\u0122\u0123\7=\2\2\u0123d\3\2\2\2\u0124\u0125\7"+
		".\2\2\u0125f\3\2\2\2\u0126\u0127\7?\2\2\u0127h\3\2\2\2\u0128\u0129\7?"+
		"\2\2\u0129\u012a\7?\2\2\u012aj\3\2\2\2\u012b\u012c\7#\2\2\u012c\u012d"+
		"\7?\2\2\u012dl\3\2\2\2\u012e\u012f\7^\2\2\u012f\u0130\7^\2\2\u0130n\3"+
		"\2\2\2\u0131\u0132\7^\2\2\u0132\u0133\7$\2\2\u0133p\3\2\2\2\u0134\u0135"+
		"\7\61\2\2\u0135\u0136\7,\2\2\u0136\u013a\3\2\2\2\u0137\u0139\13\2\2\2"+
		"\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u013b\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013e\7,\2\2\u013e"+
		"\u013f\7\61\2\2\u013f\u0140\3\2\2\2\u0140\u0141\b9\2\2\u0141r\3\2\2\2"+
		"\u0142\u0143\t\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\b:\2\2\u0145t\3\2"+
		"\2\2\u0146\u0147\7\61\2\2\u0147\u0148\7\61\2\2\u0148\u014c\3\2\2\2\u0149"+
		"\u014b\n\3\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0150\b;\2\2\u0150v\3\2\2\2\u0151\u0155\t\4\2\2\u0152\u0154\t\5\2\2\u0153"+
		"\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156x\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015c\t\6\2\2\u0159\u015b"+
		"\t\7\2\2\u015a\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u0161\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0161\7\62"+
		"\2\2\u0160\u0158\3\2\2\2\u0160\u015f\3\2\2\2\u0161z\3\2\2\2\u0162\u016b"+
		"\7$\2\2\u0163\u016a\t\b\2\2\u0164\u0165\t\t\2\2\u0165\u016a\t\t\2\2\u0166"+
		"\u016a\t\n\2\2\u0167\u0168\t\t\2\2\u0168\u016a\t\13\2\2\u0169\u0163\3"+
		"\2\2\2\u0169\u0164\3\2\2\2\u0169\u0166\3\2\2\2\u0169\u0167\3\2\2\2\u016a"+
		"\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2"+
		"\2\2\u016d\u016b\3\2\2\2\u016e\u016f\7$\2\2\u016f|\3\2\2\2\n\2\u013a\u014c"+
		"\u0155\u015c\u0160\u0169\u016b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}