// Generated from E:/SJTU/3CompilerWorkplace/src/Parser\Isaiah.g4 by ANTLR 4.9.1
package Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsaiahParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_declare = 1, RULE_digitType = 2, RULE_arrayType = 3, 
		RULE_varType = 4, RULE_retType = 5, RULE_value = 6, RULE_parameterList = 7, 
		RULE_expressionList = 8, RULE_block = 9, RULE_statement = 10, RULE_expression = 11, 
		RULE_forInit = 12, RULE_forCond = 13, RULE_forIncre = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare", "digitType", "arrayType", "varType", "retType", 
			"value", "parameterList", "expressionList", "block", "statement", "expression", 
			"forInit", "forCond", "forIncre"
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

	@Override
	public String getGrammarFileName() { return "Isaiah.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IsaiahParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(IsaiahParser.EOF, 0); }
		public List<DeclareContext> declare() {
			return getRuleContexts(DeclareContext.class);
		}
		public DeclareContext declare(int i) {
			return getRuleContext(DeclareContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Semi) | (1L << Identifier))) != 0)) {
				{
				{
				setState(30);
				declare();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(EOF);
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

	public static class DeclareContext extends ParserRuleContext {
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
	 
		public DeclareContext() { }
		public void copyFrom(DeclareContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyDeclareContext extends DeclareContext {
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public EmptyDeclareContext(DeclareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterEmptyDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitEmptyDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitEmptyDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignDeclareContext extends DeclareContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(IsaiahParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public AssignDeclareContext(DeclareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterAssignDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitAssignDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitAssignDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncDeclareContext extends DeclareContext {
		public RetTypeContext retType() {
			return getRuleContext(RetTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDeclareContext(DeclareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterFuncDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitFuncDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitFuncDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstrDeclareContext extends DeclareContext {
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstrDeclareContext(DeclareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterConstrDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitConstrDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitConstrDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListDeclareContext extends DeclareContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(IsaiahParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(IsaiahParser.Identifier, i);
		}
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(IsaiahParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(IsaiahParser.Comma, i);
		}
		public ListDeclareContext(DeclareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterListDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitListDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitListDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDeclareContext extends DeclareContext {
		public TerminalNode Class() { return getToken(IsaiahParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(IsaiahParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(IsaiahParser.RightBrace, 0); }
		public List<DeclareContext> declare() {
			return getRuleContexts(DeclareContext.class);
		}
		public DeclareContext declare(int i) {
			return getRuleContext(DeclareContext.class,i);
		}
		public ClassDeclareContext(DeclareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterClassDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitClassDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitClassDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declare);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new EmptyDeclareContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new AssignDeclareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				varType();
				setState(40);
				match(Identifier);
				setState(41);
				match(Assign);
				setState(42);
				expression(0);
				setState(43);
				match(Semi);
				}
				break;
			case 3:
				_localctx = new ListDeclareContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				varType();
				setState(46);
				match(Identifier);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(47);
					match(Comma);
					setState(48);
					match(Identifier);
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(Semi);
				}
				break;
			case 4:
				_localctx = new ClassDeclareContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				match(Class);
				setState(57);
				match(Identifier);
				setState(58);
				match(LeftBrace);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Semi) | (1L << Identifier))) != 0)) {
					{
					{
					setState(59);
					declare();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(RightBrace);
				}
				break;
			case 5:
				_localctx = new FuncDeclareContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				retType();
				setState(67);
				match(Identifier);
				setState(68);
				parameterList();
				setState(69);
				block();
				}
				break;
			case 6:
				_localctx = new ConstrDeclareContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				match(Identifier);
				setState(72);
				match(LeftParen);
				setState(73);
				match(RightParen);
				setState(74);
				block();
				}
				break;
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

	public static class DigitTypeContext extends ParserRuleContext {
		public TerminalNode Bool() { return getToken(IsaiahParser.Bool, 0); }
		public TerminalNode Int() { return getToken(IsaiahParser.Int, 0); }
		public TerminalNode String() { return getToken(IsaiahParser.String, 0); }
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public DigitTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digitType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterDigitType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitDigitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitDigitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitTypeContext digitType() throws RecognitionException {
		DigitTypeContext _localctx = new DigitTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_digitType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) ) {
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public DigitTypeContext digitType() {
			return getRuleContext(DigitTypeContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(IsaiahParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(IsaiahParser.RightBracket, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		return arrayType(0);
	}

	private ArrayTypeContext arrayType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, _parentState);
		ArrayTypeContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_arrayType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(80);
			digitType();
			setState(81);
			match(LeftBracket);
			setState(82);
			match(RightBracket);
			}
			_ctx.stop = _input.LT(-1);
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arrayType);
					setState(84);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(85);
					match(LeftBracket);
					setState(86);
					match(RightBracket);
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public DigitTypeContext digitType() {
			return getRuleContext(DigitTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varType);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				digitType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				arrayType(0);
				}
				break;
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

	public static class RetTypeContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode Void() { return getToken(IsaiahParser.Void, 0); }
		public RetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterRetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitRetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitRetType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetTypeContext retType() throws RecognitionException {
		RetTypeContext _localctx = new RetTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_retType);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				varType();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(Void);
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntValContext extends ValueContext {
		public TerminalNode IntConst() { return getToken(IsaiahParser.IntConst, 0); }
		public IntValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterIntVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitIntVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullValContext extends ValueContext {
		public TerminalNode Null() { return getToken(IsaiahParser.Null, 0); }
		public NullValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterNullVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitNullVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitNullVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncValContext extends ValueContext {
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FuncValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterFuncVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitFuncVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitFuncVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariValContext extends ValueContext {
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public VariValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterVariVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitVariVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitVariVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringValContext extends ValueContext {
		public TerminalNode StringConst() { return getToken(IsaiahParser.StringConst, 0); }
		public StringValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterStringVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitStringVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitStringVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueValContext extends ValueContext {
		public TerminalNode True() { return getToken(IsaiahParser.True, 0); }
		public TrueValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterTrueVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitTrueVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitTrueVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayContext extends ValueContext {
		public TerminalNode New() { return getToken(IsaiahParser.New, 0); }
		public DigitTypeContext digitType() {
			return getRuleContext(DigitTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(IsaiahParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(IsaiahParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(IsaiahParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(IsaiahParser.RightBracket, i);
		}
		public NewArrayContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterNewArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitNewArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitNewArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewWrongContext extends ValueContext {
		public TerminalNode New() { return getToken(IsaiahParser.New, 0); }
		public DigitTypeContext digitType() {
			return getRuleContext(DigitTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(IsaiahParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(IsaiahParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(IsaiahParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(IsaiahParser.RightBracket, i);
		}
		public NewWrongContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterNewWrong(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitNewWrong(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitNewWrong(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisValContext extends ValueContext {
		public TerminalNode This() { return getToken(IsaiahParser.This, 0); }
		public ThisValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterThisVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitThisVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitThisVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewWrong2Context extends ValueContext {
		public TerminalNode New() { return getToken(IsaiahParser.New, 0); }
		public DigitTypeContext digitType() {
			return getRuleContext(DigitTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(IsaiahParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(IsaiahParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(IsaiahParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(IsaiahParser.RightBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NewWrong2Context(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterNewWrong2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitNewWrong2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitNewWrong2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewClassContext extends ValueContext {
		public TerminalNode New() { return getToken(IsaiahParser.New, 0); }
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public NewClassContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterNewClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitNewClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitNewClass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaValContext extends ValueContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LambdaValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterLambdaVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitLambdaVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitLambdaVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseValContext extends ValueContext {
		public TerminalNode False() { return getToken(IsaiahParser.False, 0); }
		public FalseValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterFalseVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitFalseVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitFalseVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			int _alt;
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new VariValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(IntConst);
				}
				break;
			case 3:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(StringConst);
				}
				break;
			case 4:
				_localctx = new TrueValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				match(True);
				}
				break;
			case 5:
				_localctx = new FalseValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(104);
				match(False);
				}
				break;
			case 6:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(105);
				match(Null);
				}
				break;
			case 7:
				_localctx = new NewWrong2Context(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(106);
				match(New);
				setState(107);
				digitType();
				setState(110); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(108);
						match(LeftBracket);
						setState(109);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(112); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(114);
						match(LeftBracket);
						setState(115);
						expression(0);
						setState(116);
						match(RightBracket);
						}
						} 
					}
					setState(122);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				}
				break;
			case 8:
				_localctx = new NewWrongContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(123);
				match(New);
				setState(124);
				digitType();
				setState(129); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(125);
						match(LeftBracket);
						setState(126);
						expression(0);
						setState(127);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(131); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(135); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(133);
						match(LeftBracket);
						setState(134);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(137); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(143); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(139);
						match(LeftBracket);
						setState(140);
						expression(0);
						setState(141);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(145); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 9:
				_localctx = new NewArrayContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(147);
				match(New);
				setState(148);
				digitType();
				setState(153); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(149);
						match(LeftBracket);
						setState(150);
						expression(0);
						setState(151);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(155); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(157);
						match(LeftBracket);
						setState(158);
						match(RightBracket);
						}
						} 
					}
					setState(163);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				break;
			case 10:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(164);
				match(New);
				setState(165);
				match(Identifier);
				setState(168);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(166);
					match(LeftParen);
					setState(167);
					match(RightParen);
					}
					break;
				}
				}
				break;
			case 11:
				_localctx = new FuncValContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(170);
				match(Identifier);
				setState(171);
				expressionList();
				}
				break;
			case 12:
				_localctx = new LambdaValContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(172);
				match(T__0);
				setState(173);
				parameterList();
				setState(174);
				match(T__1);
				setState(175);
				block();
				setState(176);
				expressionList();
				}
				break;
			case 13:
				_localctx = new ThisValContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(178);
				match(This);
				}
				break;
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

	public static class ParameterListContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(IsaiahParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(IsaiahParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(IsaiahParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(IsaiahParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(LeftParen);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(182);
				varType();
				setState(183);
				match(Identifier);
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(184);
					match(Comma);
					setState(185);
					varType();
					setState(186);
					match(Identifier);
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(195);
			match(RightParen);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(IsaiahParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(IsaiahParser.Comma, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(LeftParen);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(198);
				expression(0);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(199);
					match(Comma);
					setState(200);
					expression(0);
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(208);
			match(RightParen);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(IsaiahParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(IsaiahParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(LeftBrace);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << True) | (1L << False) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Semi) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(211);
				statement();
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
			match(RightBrace);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RetStmtContext extends StatementContext {
		public TerminalNode Return() { return getToken(IsaiahParser.Return, 0); }
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RetStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterRetStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitRetStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitRetStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListStmtContext extends StatementContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(IsaiahParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(IsaiahParser.Identifier, i);
		}
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(IsaiahParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(IsaiahParser.Comma, i);
		}
		public ListStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterListStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitListStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitListStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStmtContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public ExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStmtContext extends StatementContext {
		public TerminalNode For() { return getToken(IsaiahParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<TerminalNode> Semi() { return getTokens(IsaiahParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(IsaiahParser.Semi, i);
		}
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForCondContext forCond() {
			return getRuleContext(ForCondContext.class,0);
		}
		public ForIncreContext forIncre() {
			return getRuleContext(ForIncreContext.class,0);
		}
		public ForStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StatementContext {
		public TerminalNode While() { return getToken(IsaiahParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmtContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinStmtContext extends StatementContext {
		public TerminalNode Continue() { return getToken(IsaiahParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public ContinStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterContinStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitContinStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitContinStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStmtContext extends StatementContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(IsaiahParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public AssignStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStmtContext extends StatementContext {
		public TerminalNode Break() { return getToken(IsaiahParser.Break, 0); }
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public BreakStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyStmtContext extends StatementContext {
		public TerminalNode Semi() { return getToken(IsaiahParser.Semi, 0); }
		public EmptyStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterEmptyStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitEmptyStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitEmptyStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondStmtContext extends StatementContext {
		public TerminalNode If() { return getToken(IsaiahParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(IsaiahParser.Else, 0); }
		public CondStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterCondStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitCondStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitCondStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				varType();
				setState(221);
				match(Identifier);
				setState(222);
				match(Assign);
				setState(223);
				expression(0);
				setState(224);
				match(Semi);
				}
				break;
			case 3:
				_localctx = new ListStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				varType();
				setState(227);
				match(Identifier);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(228);
					match(Comma);
					setState(229);
					match(Identifier);
					}
					}
					setState(234);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(235);
				match(Semi);
				}
				break;
			case 4:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				expression(0);
				setState(238);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new CondStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
				match(If);
				setState(241);
				match(LeftParen);
				setState(242);
				expression(0);
				setState(243);
				match(RightParen);
				setState(244);
				statement();
				setState(247);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(245);
					match(Else);
					setState(246);
					statement();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(249);
				match(While);
				setState(250);
				match(LeftParen);
				setState(251);
				expression(0);
				setState(252);
				match(RightParen);
				setState(253);
				statement();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(255);
				match(For);
				setState(256);
				match(LeftParen);
				setState(257);
				forInit();
				setState(258);
				match(Semi);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(259);
					forCond();
					}
				}

				setState(262);
				match(Semi);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(263);
					forIncre();
					}
				}

				setState(266);
				match(RightParen);
				setState(267);
				statement();
				}
				break;
			case 8:
				_localctx = new RetStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(269);
				match(Return);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(270);
					expression(0);
					}
				}

				setState(273);
				match(Semi);
				}
				break;
			case 9:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(274);
				match(Break);
				setState(275);
				match(Semi);
				}
				break;
			case 10:
				_localctx = new ContinStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(276);
				match(Continue);
				setState(277);
				match(Semi);
				}
				break;
			case 11:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(278);
				block();
				}
				break;
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IndexExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(IsaiahParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(IsaiahParser.RightBracket, 0); }
		public IndexExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitIndexExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SelfPlus() { return getToken(IsaiahParser.SelfPlus, 0); }
		public TerminalNode SelfMinus() { return getToken(IsaiahParser.SelfMinus, 0); }
		public PrefixExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExprContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitValueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Not() { return getToken(IsaiahParser.Not, 0); }
		public TerminalNode Tilde() { return getToken(IsaiahParser.Tilde, 0); }
		public TerminalNode Plus() { return getToken(IsaiahParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(IsaiahParser.Minus, 0); }
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SelfPlus() { return getToken(IsaiahParser.SelfPlus, 0); }
		public TerminalNode SelfMinus() { return getToken(IsaiahParser.SelfMinus, 0); }
		public SuffixExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterSuffixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitSuffixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitSuffixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(IsaiahParser.Mul, 0); }
		public TerminalNode Div() { return getToken(IsaiahParser.Div, 0); }
		public TerminalNode Mod() { return getToken(IsaiahParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(IsaiahParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(IsaiahParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(IsaiahParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(IsaiahParser.RightShift, 0); }
		public TerminalNode Less() { return getToken(IsaiahParser.Less, 0); }
		public TerminalNode Greater() { return getToken(IsaiahParser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(IsaiahParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(IsaiahParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(IsaiahParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(IsaiahParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(IsaiahParser.And, 0); }
		public TerminalNode Caret() { return getToken(IsaiahParser.Caret, 0); }
		public TerminalNode Or() { return getToken(IsaiahParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(IsaiahParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(IsaiahParser.OrOr, 0); }
		public TerminalNode Assign() { return getToken(IsaiahParser.Assign, 0); }
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(IsaiahParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public CallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExpressionContext {
		public TerminalNode LeftParen() { return getToken(IsaiahParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(IsaiahParser.RightParen, 0); }
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case Null:
			case True:
			case False:
			case New:
			case This:
			case Identifier:
			case IntConst:
			case StringConst:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(282);
				value();
				}
				break;
			case LeftParen:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				match(LeftParen);
				setState(284);
				expression(0);
				setState(285);
				match(RightParen);
				}
				break;
			case Not:
			case Tilde:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Not || _la==Tilde) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(288);
				expression(15);
				}
				break;
			case Plus:
			case Minus:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(290);
				expression(14);
				}
				break;
			case SelfPlus:
			case SelfMinus:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfPlus || _la==SelfMinus) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(292);
				expression(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(349);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(296);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(297);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(298);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(299);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(300);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(301);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(302);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(303);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(304);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(305);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << LessEqual) | (1L << Greater) | (1L << GreaterEqual))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(306);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(307);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(308);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(309);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(310);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(311);
						match(And);
						setState(312);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(313);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(314);
						match(Caret);
						setState(315);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(316);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(317);
						match(Or);
						setState(318);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(319);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(320);
						match(AndAnd);
						setState(321);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(323);
						match(OrOr);
						setState(324);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(325);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(326);
						match(Assign);
						setState(327);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new IndexExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(329);
						match(LeftBracket);
						setState(330);
						expression(0);
						setState(331);
						match(RightBracket);
						}
						break;
					case 13:
						{
						_localctx = new CallExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(334);
						match(Dot);
						setState(335);
						match(Identifier);
						setState(337);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
						case 1:
							{
							setState(336);
							expressionList();
							}
							break;
						}
						}
						break;
					case 14:
						{
						_localctx = new CallExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(339);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(340);
						match(Dot);
						setState(341);
						match(LeftParen);
						setState(342);
						match(Identifier);
						setState(344);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LeftParen) {
							{
							setState(343);
							expressionList();
							}
						}

						setState(346);
						match(RightParen);
						}
						break;
					case 15:
						{
						_localctx = new SuffixExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(348);
						((SuffixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfPlus || _la==SelfMinus) ) {
							((SuffixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(IsaiahParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(IsaiahParser.Comma, i);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(354);
				expression(0);
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(355);
					match(Comma);
					setState(356);
					expression(0);
					}
					}
					setState(361);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ForCondContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterForCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitForCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitForCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForCondContext forCond() throws RecognitionException {
		ForCondContext _localctx = new ForCondContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forCond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			expression(0);
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

	public static class ForIncreContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForIncreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forIncre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterForIncre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitForIncre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitForIncre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForIncreContext forIncre() throws RecognitionException {
		ForIncreContext _localctx = new ForIncreContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forIncre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			expression(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return arrayType_sempred((ArrayTypeContext)_localctx, predIndex);
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arrayType_sempred(ArrayTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 18);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		case 15:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u0173\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2\16"+
		"\2%\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\64\n"+
		"\3\f\3\16\3\67\13\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3N\n\3\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\7\5Z\n\5\f\5\16\5]\13\5\3\6\3\6\5\6a\n\6\3\7\3\7\5"+
		"\7e\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\bq\n\b\r\b\16\br\3\b"+
		"\3\b\3\b\3\b\7\by\n\b\f\b\16\b|\13\b\3\b\3\b\3\b\3\b\3\b\3\b\6\b\u0084"+
		"\n\b\r\b\16\b\u0085\3\b\3\b\6\b\u008a\n\b\r\b\16\b\u008b\3\b\3\b\3\b\3"+
		"\b\6\b\u0092\n\b\r\b\16\b\u0093\3\b\3\b\3\b\3\b\3\b\3\b\6\b\u009c\n\b"+
		"\r\b\16\b\u009d\3\b\3\b\7\b\u00a2\n\b\f\b\16\b\u00a5\13\b\3\b\3\b\3\b"+
		"\3\b\5\b\u00ab\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00b6\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00bf\n\t\f\t\16\t\u00c2\13\t\5\t\u00c4"+
		"\n\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u00cc\n\n\f\n\16\n\u00cf\13\n\5\n\u00d1"+
		"\n\n\3\n\3\n\3\13\3\13\7\13\u00d7\n\13\f\13\16\13\u00da\13\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00e9\n\f\f\f\16\f\u00ec"+
		"\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00fa\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0107\n\f\3\f\3\f\5\f\u010b"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u0112\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u011a"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0128\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0154\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u015b\n"+
		"\r\3\r\3\r\3\r\7\r\u0160\n\r\f\r\16\r\u0163\13\r\3\16\3\16\3\16\7\16\u0168"+
		"\n\16\f\16\16\16\u016b\13\16\5\16\u016d\n\16\3\17\3\17\3\20\3\20\3\20"+
		"\2\4\b\30\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\n\4\2\5\7==\3\2"+
		"/\60\4\2##%%\4\2$$&&\3\2\')\3\2!\"\3\2\35 \3\2\66\67\2\u01ad\2#\3\2\2"+
		"\2\4M\3\2\2\2\6O\3\2\2\2\bQ\3\2\2\2\n`\3\2\2\2\fd\3\2\2\2\16\u00b5\3\2"+
		"\2\2\20\u00b7\3\2\2\2\22\u00c7\3\2\2\2\24\u00d4\3\2\2\2\26\u0119\3\2\2"+
		"\2\30\u0127\3\2\2\2\32\u016c\3\2\2\2\34\u016e\3\2\2\2\36\u0170\3\2\2\2"+
		" \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2"+
		"\2&\'\7\2\2\3\'\3\3\2\2\2(N\7\63\2\2)*\5\n\6\2*+\7=\2\2+,\7\65\2\2,-\5"+
		"\30\r\2-.\7\63\2\2.N\3\2\2\2/\60\5\n\6\2\60\65\7=\2\2\61\62\7\64\2\2\62"+
		"\64\7=\2\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66"+
		"8\3\2\2\2\67\65\3\2\2\289\7\63\2\29N\3\2\2\2:;\7\24\2\2;<\7=\2\2<@\7\33"+
		"\2\2=?\5\4\3\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2"+
		"\2\2CN\7\34\2\2DE\5\f\7\2EF\7=\2\2FG\5\20\t\2GH\5\24\13\2HN\3\2\2\2IJ"+
		"\7=\2\2JK\7\27\2\2KL\7\30\2\2LN\5\24\13\2M(\3\2\2\2M)\3\2\2\2M/\3\2\2"+
		"\2M:\3\2\2\2MD\3\2\2\2MI\3\2\2\2N\5\3\2\2\2OP\t\2\2\2P\7\3\2\2\2QR\b\5"+
		"\1\2RS\5\6\4\2ST\7\31\2\2TU\7\32\2\2U[\3\2\2\2VW\f\3\2\2WX\7\31\2\2XZ"+
		"\7\32\2\2YV\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\t\3\2\2\2][\3\2\2"+
		"\2^a\5\6\4\2_a\5\b\5\2`^\3\2\2\2`_\3\2\2\2a\13\3\2\2\2be\5\n\6\2ce\7\t"+
		"\2\2db\3\2\2\2dc\3\2\2\2e\r\3\2\2\2f\u00b6\7=\2\2g\u00b6\7>\2\2h\u00b6"+
		"\7?\2\2i\u00b6\7\n\2\2j\u00b6\7\13\2\2k\u00b6\7\b\2\2lm\7\23\2\2mp\5\6"+
		"\4\2no\7\31\2\2oq\7\32\2\2pn\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2sz\3"+
		"\2\2\2tu\7\31\2\2uv\5\30\r\2vw\7\32\2\2wy\3\2\2\2xt\3\2\2\2y|\3\2\2\2"+
		"zx\3\2\2\2z{\3\2\2\2{\u00b6\3\2\2\2|z\3\2\2\2}~\7\23\2\2~\u0083\5\6\4"+
		"\2\177\u0080\7\31\2\2\u0080\u0081\5\30\r\2\u0081\u0082\7\32\2\2\u0082"+
		"\u0084\3\2\2\2\u0083\177\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2"+
		"\2\u0085\u0086\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0088\7\31\2\2\u0088"+
		"\u008a\7\32\2\2\u0089\u0087\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3"+
		"\2\2\2\u008b\u008c\3\2\2\2\u008c\u0091\3\2\2\2\u008d\u008e\7\31\2\2\u008e"+
		"\u008f\5\30\r\2\u008f\u0090\7\32\2\2\u0090\u0092\3\2\2\2\u0091\u008d\3"+
		"\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u00b6\3\2\2\2\u0095\u0096\7\23\2\2\u0096\u009b\5\6\4\2\u0097\u0098\7"+
		"\31\2\2\u0098\u0099\5\30\r\2\u0099\u009a\7\32\2\2\u009a\u009c\3\2\2\2"+
		"\u009b\u0097\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u00a3\3\2\2\2\u009f\u00a0\7\31\2\2\u00a0\u00a2\7\32\2\2"+
		"\u00a1\u009f\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4"+
		"\3\2\2\2\u00a4\u00b6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7\23\2\2"+
		"\u00a7\u00aa\7=\2\2\u00a8\u00a9\7\27\2\2\u00a9\u00ab\7\30\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00b6\3\2\2\2\u00ac\u00ad\7=\2\2\u00ad"+
		"\u00b6\5\22\n\2\u00ae\u00af\7\3\2\2\u00af\u00b0\5\20\t\2\u00b0\u00b1\7"+
		"\4\2\2\u00b1\u00b2\5\24\13\2\u00b2\u00b3\5\22\n\2\u00b3\u00b6\3\2\2\2"+
		"\u00b4\u00b6\7\25\2\2\u00b5f\3\2\2\2\u00b5g\3\2\2\2\u00b5h\3\2\2\2\u00b5"+
		"i\3\2\2\2\u00b5j\3\2\2\2\u00b5k\3\2\2\2\u00b5l\3\2\2\2\u00b5}\3\2\2\2"+
		"\u00b5\u0095\3\2\2\2\u00b5\u00a6\3\2\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00ae"+
		"\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\17\3\2\2\2\u00b7\u00c3\7\27\2\2\u00b8"+
		"\u00b9\5\n\6\2\u00b9\u00c0\7=\2\2\u00ba\u00bb\7\64\2\2\u00bb\u00bc\5\n"+
		"\6\2\u00bc\u00bd\7=\2\2\u00bd\u00bf\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00b8\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\7\30\2\2\u00c6\21\3\2\2\2\u00c7\u00d0\7\27"+
		"\2\2\u00c8\u00cd\5\30\r\2\u00c9\u00ca\7\64\2\2\u00ca\u00cc\5\30\r\2\u00cb"+
		"\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00c8\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\7\30\2\2\u00d3\23\3\2\2"+
		"\2\u00d4\u00d8\7\33\2\2\u00d5\u00d7\5\26\f\2\u00d6\u00d5\3\2\2\2\u00d7"+
		"\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7\34\2\2\u00dc\25\3\2\2\2\u00dd\u011a"+
		"\7\63\2\2\u00de\u00df\5\n\6\2\u00df\u00e0\7=\2\2\u00e0\u00e1\7\65\2\2"+
		"\u00e1\u00e2\5\30\r\2\u00e2\u00e3\7\63\2\2\u00e3\u011a\3\2\2\2\u00e4\u00e5"+
		"\5\n\6\2\u00e5\u00ea\7=\2\2\u00e6\u00e7\7\64\2\2\u00e7\u00e9\7=\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7\63\2\2\u00ee"+
		"\u011a\3\2\2\2\u00ef\u00f0\5\30\r\2\u00f0\u00f1\7\63\2\2\u00f1\u011a\3"+
		"\2\2\2\u00f2\u00f3\7\f\2\2\u00f3\u00f4\7\27\2\2\u00f4\u00f5\5\30\r\2\u00f5"+
		"\u00f6\7\30\2\2\u00f6\u00f9\5\26\f\2\u00f7\u00f8\7\r\2\2\u00f8\u00fa\5"+
		"\26\f\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u011a\3\2\2\2\u00fb"+
		"\u00fc\7\17\2\2\u00fc\u00fd\7\27\2\2\u00fd\u00fe\5\30\r\2\u00fe\u00ff"+
		"\7\30\2\2\u00ff\u0100\5\26\f\2\u0100\u011a\3\2\2\2\u0101\u0102\7\16\2"+
		"\2\u0102\u0103\7\27\2\2\u0103\u0104\5\32\16\2\u0104\u0106\7\63\2\2\u0105"+
		"\u0107\5\34\17\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3"+
		"\2\2\2\u0108\u010a\7\63\2\2\u0109\u010b\5\36\20\2\u010a\u0109\3\2\2\2"+
		"\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\7\30\2\2\u010d\u010e"+
		"\5\26\f\2\u010e\u011a\3\2\2\2\u010f\u0111\7\22\2\2\u0110\u0112\5\30\r"+
		"\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u011a"+
		"\7\63\2\2\u0114\u0115\7\20\2\2\u0115\u011a\7\63\2\2\u0116\u0117\7\21\2"+
		"\2\u0117\u011a\7\63\2\2\u0118\u011a\5\24\13\2\u0119\u00dd\3\2\2\2\u0119"+
		"\u00de\3\2\2\2\u0119\u00e4\3\2\2\2\u0119\u00ef\3\2\2\2\u0119\u00f2\3\2"+
		"\2\2\u0119\u00fb\3\2\2\2\u0119\u0101\3\2\2\2\u0119\u010f\3\2\2\2\u0119"+
		"\u0114\3\2\2\2\u0119\u0116\3\2\2\2\u0119\u0118\3\2\2\2\u011a\27\3\2\2"+
		"\2\u011b\u011c\b\r\1\2\u011c\u0128\5\16\b\2\u011d\u011e\7\27\2\2\u011e"+
		"\u011f\5\30\r\2\u011f\u0120\7\30\2\2\u0120\u0128\3\2\2\2\u0121\u0122\t"+
		"\3\2\2\u0122\u0128\5\30\r\21\u0123\u0124\t\4\2\2\u0124\u0128\5\30\r\20"+
		"\u0125\u0126\t\5\2\2\u0126\u0128\5\30\r\17\u0127\u011b\3\2\2\2\u0127\u011d"+
		"\3\2\2\2\u0127\u0121\3\2\2\2\u0127\u0123\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u0161\3\2\2\2\u0129\u012a\f\r\2\2\u012a\u012b\t\6\2\2\u012b\u0160\5\30"+
		"\r\16\u012c\u012d\f\f\2\2\u012d\u012e\t\4\2\2\u012e\u0160\5\30\r\r\u012f"+
		"\u0130\f\13\2\2\u0130\u0131\t\7\2\2\u0131\u0160\5\30\r\f\u0132\u0133\f"+
		"\n\2\2\u0133\u0134\t\b\2\2\u0134\u0160\5\30\r\13\u0135\u0136\f\t\2\2\u0136"+
		"\u0137\t\t\2\2\u0137\u0160\5\30\r\n\u0138\u0139\f\b\2\2\u0139\u013a\7"+
		"*\2\2\u013a\u0160\5\30\r\t\u013b\u013c\f\7\2\2\u013c\u013d\7.\2\2\u013d"+
		"\u0160\5\30\r\b\u013e\u013f\f\6\2\2\u013f\u0140\7+\2\2\u0140\u0160\5\30"+
		"\r\7\u0141\u0142\f\5\2\2\u0142\u0143\7,\2\2\u0143\u0160\5\30\r\6\u0144"+
		"\u0145\f\4\2\2\u0145\u0146\7-\2\2\u0146\u0160\5\30\r\5\u0147\u0148\f\3"+
		"\2\2\u0148\u0149\7\65\2\2\u0149\u0160\5\30\r\3\u014a\u014b\f\24\2\2\u014b"+
		"\u014c\7\31\2\2\u014c\u014d\5\30\r\2\u014d\u014e\7\32\2\2\u014e\u0160"+
		"\3\2\2\2\u014f\u0150\f\23\2\2\u0150\u0151\7\26\2\2\u0151\u0153\7=\2\2"+
		"\u0152\u0154\5\22\n\2\u0153\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0160"+
		"\3\2\2\2\u0155\u0156\f\22\2\2\u0156\u0157\7\26\2\2\u0157\u0158\7\27\2"+
		"\2\u0158\u015a\7=\2\2\u0159\u015b\5\22\n\2\u015a\u0159\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u0160\7\30\2\2\u015d\u015e\f\16\2\2"+
		"\u015e\u0160\t\5\2\2\u015f\u0129\3\2\2\2\u015f\u012c\3\2\2\2\u015f\u012f"+
		"\3\2\2\2\u015f\u0132\3\2\2\2\u015f\u0135\3\2\2\2\u015f\u0138\3\2\2\2\u015f"+
		"\u013b\3\2\2\2\u015f\u013e\3\2\2\2\u015f\u0141\3\2\2\2\u015f\u0144\3\2"+
		"\2\2\u015f\u0147\3\2\2\2\u015f\u014a\3\2\2\2\u015f\u014f\3\2\2\2\u015f"+
		"\u0155\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2"+
		"\2\2\u0161\u0162\3\2\2\2\u0162\31\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0169"+
		"\5\30\r\2\u0165\u0166\7\64\2\2\u0166\u0168\5\30\r\2\u0167\u0165\3\2\2"+
		"\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016d"+
		"\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u0164\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\33\3\2\2\2\u016e\u016f\5\30\r\2\u016f\35\3\2\2\2\u0170\u0171\5\30\r\2"+
		"\u0171\37\3\2\2\2$#\65@M[`drz\u0085\u008b\u0093\u009d\u00a3\u00aa\u00b5"+
		"\u00c0\u00c3\u00cd\u00d0\u00d8\u00ea\u00f9\u0106\u010a\u0111\u0119\u0127"+
		"\u0153\u015a\u015f\u0161\u0169\u016c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}