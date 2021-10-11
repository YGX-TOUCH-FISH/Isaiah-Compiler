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
		RULE_forInit = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare", "digitType", "arrayType", "varType", "retType", 
			"value", "parameterList", "expressionList", "block", "statement", "expression", 
			"forInit"
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Semi) | (1L << Identifier))) != 0)) {
				{
				{
				setState(26);
				declare();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new EmptyDeclareContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new AssignDeclareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				varType();
				setState(36);
				match(Identifier);
				setState(37);
				match(Assign);
				setState(38);
				expression(0);
				}
				break;
			case 3:
				_localctx = new ListDeclareContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				varType();
				setState(41);
				match(Identifier);
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(42);
					match(Comma);
					setState(43);
					match(Identifier);
					}
					}
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				_localctx = new ClassDeclareContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(Class);
				setState(50);
				match(Identifier);
				setState(51);
				match(LeftBrace);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Semi) | (1L << Identifier))) != 0)) {
					{
					{
					setState(52);
					declare();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				match(RightBrace);
				}
				break;
			case 5:
				_localctx = new FuncDeclareContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(59);
				retType();
				setState(60);
				match(Identifier);
				setState(61);
				parameterList();
				setState(62);
				block();
				}
				break;
			case 6:
				_localctx = new ConstrDeclareContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				match(Identifier);
				setState(65);
				match(LeftParen);
				setState(66);
				match(RightParen);
				setState(67);
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
			setState(70);
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
			setState(73);
			digitType();
			setState(74);
			match(LeftBracket);
			setState(75);
			match(RightBracket);
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
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
					setState(77);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(78);
					match(LeftBracket);
					setState(79);
					match(RightBracket);
					}
					} 
				}
				setState(84);
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
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				digitType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
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
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				varType();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
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
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new VariValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(IntConst);
				}
				break;
			case 3:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				match(StringConst);
				}
				break;
			case 4:
				_localctx = new TrueValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				match(True);
				}
				break;
			case 5:
				_localctx = new FalseValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				match(False);
				}
				break;
			case 6:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				match(Null);
				}
				break;
			case 7:
				_localctx = new NewWrong2Context(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				match(New);
				setState(100);
				digitType();
				setState(103); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(101);
						match(LeftBracket);
						setState(102);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(105); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(107);
						match(LeftBracket);
						setState(108);
						expression(0);
						setState(109);
						match(RightBracket);
						}
						} 
					}
					setState(115);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				}
				break;
			case 8:
				_localctx = new NewWrongContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(116);
				match(New);
				setState(117);
				digitType();
				setState(122); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(118);
						match(LeftBracket);
						setState(119);
						expression(0);
						setState(120);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(124); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(128); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(126);
						match(LeftBracket);
						setState(127);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(130); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(136); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(132);
						match(LeftBracket);
						setState(133);
						expression(0);
						setState(134);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(138); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 9:
				_localctx = new NewArrayContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(140);
				match(New);
				setState(141);
				digitType();
				setState(146); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(142);
						match(LeftBracket);
						setState(143);
						expression(0);
						setState(144);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(148); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(150);
						match(LeftBracket);
						setState(151);
						match(RightBracket);
						}
						} 
					}
					setState(156);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				break;
			case 10:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(157);
				match(New);
				setState(158);
				match(Identifier);
				setState(161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(159);
					match(LeftParen);
					setState(160);
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
				setState(163);
				match(Identifier);
				setState(164);
				expressionList();
				}
				break;
			case 12:
				_localctx = new LambdaValContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(165);
				match(T__0);
				setState(166);
				parameterList();
				setState(167);
				match(T__1);
				setState(168);
				block();
				setState(169);
				expressionList();
				}
				break;
			case 13:
				_localctx = new ThisValContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(171);
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
			setState(174);
			match(LeftParen);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(175);
				varType();
				setState(176);
				match(Identifier);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(177);
					match(Comma);
					setState(178);
					varType();
					setState(179);
					match(Identifier);
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(188);
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
			setState(190);
			match(LeftParen);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(191);
				expression(0);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(192);
					match(Comma);
					setState(193);
					expression(0);
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(201);
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
			setState(203);
			match(LeftBrace);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << True) | (1L << False) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Semi) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(204);
				statement();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				varType();
				setState(214);
				match(Identifier);
				setState(215);
				match(Assign);
				setState(216);
				expression(0);
				setState(217);
				match(Semi);
				}
				break;
			case 3:
				_localctx = new ListStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				varType();
				setState(220);
				match(Identifier);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(221);
					match(Comma);
					setState(222);
					match(Identifier);
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(228);
				match(Semi);
				}
				break;
			case 4:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				expression(0);
				setState(231);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new CondStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(233);
				match(If);
				setState(234);
				match(LeftParen);
				setState(235);
				expression(0);
				setState(236);
				match(RightParen);
				setState(237);
				statement();
				setState(240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(238);
					match(Else);
					setState(239);
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
				setState(242);
				match(While);
				setState(243);
				match(LeftParen);
				setState(244);
				expression(0);
				setState(245);
				match(RightParen);
				setState(246);
				statement();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(248);
				match(For);
				setState(249);
				match(LeftParen);
				setState(250);
				forInit();
				setState(251);
				match(Semi);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(252);
					expression(0);
					}
				}

				setState(255);
				match(Semi);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(256);
					expression(0);
					}
				}

				setState(259);
				match(RightParen);
				setState(260);
				statement();
				}
				break;
			case 8:
				_localctx = new RetStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(262);
				match(Return);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(263);
					expression(0);
					}
				}

				setState(266);
				match(Semi);
				}
				break;
			case 9:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(267);
				match(Break);
				setState(268);
				match(Semi);
				}
				break;
			case 10:
				_localctx = new ContinStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(269);
				match(Continue);
				setState(270);
				match(Semi);
				}
				break;
			case 11:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(271);
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
		public TerminalNode Dot() { return getToken(IsaiahParser.Dot, 0); }
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
			setState(286);
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

				setState(275);
				value();
				}
				break;
			case LeftParen:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				match(LeftParen);
				setState(277);
				expression(0);
				setState(278);
				match(RightParen);
				}
				break;
			case Not:
			case Tilde:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280);
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
				setState(281);
				expression(15);
				}
				break;
			case Plus:
			case Minus:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
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
				setState(283);
				expression(14);
				}
				break;
			case SelfPlus:
			case SelfMinus:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
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
				setState(285);
				expression(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(333);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(331);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(289);
						match(Dot);
						setState(290);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(292);
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
						setState(293);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(295);
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
						setState(296);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(298);
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
						setState(299);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(301);
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
						setState(302);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(304);
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
						setState(305);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(307);
						match(And);
						setState(308);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(310);
						match(Caret);
						setState(311);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(313);
						match(Or);
						setState(314);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(316);
						match(AndAnd);
						setState(317);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(319);
						match(OrOr);
						setState(320);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(322);
						match(Assign);
						setState(323);
						expression(1);
						}
						break;
					case 13:
						{
						_localctx = new IndexExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(325);
						match(LeftBracket);
						setState(326);
						expression(0);
						setState(327);
						match(RightBracket);
						}
						break;
					case 14:
						{
						_localctx = new SuffixExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(330);
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
				setState(335);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << Plus) | (1L << SelfPlus) | (1L << Minus) | (1L << SelfMinus) | (1L << Not) | (1L << Tilde) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(336);
				expression(0);
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(337);
					match(Comma);
					setState(338);
					expression(0);
					}
					}
					setState(343);
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
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u015d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\3\3"+
		"\3\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3G\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5S\n\5\f\5\16"+
		"\5V\13\5\3\6\3\6\5\6Z\n\6\3\7\3\7\5\7^\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\6\bj\n\b\r\b\16\bk\3\b\3\b\3\b\3\b\7\br\n\b\f\b\16\bu\13"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\6\b}\n\b\r\b\16\b~\3\b\3\b\6\b\u0083\n\b\r"+
		"\b\16\b\u0084\3\b\3\b\3\b\3\b\6\b\u008b\n\b\r\b\16\b\u008c\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\6\b\u0095\n\b\r\b\16\b\u0096\3\b\3\b\7\b\u009b\n\b\f\b\16"+
		"\b\u009e\13\b\3\b\3\b\3\b\3\b\5\b\u00a4\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u00af\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b8\n\t\f\t"+
		"\16\t\u00bb\13\t\5\t\u00bd\n\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u00c5\n\n\f"+
		"\n\16\n\u00c8\13\n\5\n\u00ca\n\n\3\n\3\n\3\13\3\13\7\13\u00d0\n\13\f\13"+
		"\16\13\u00d3\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\7\f\u00e2\n\f\f\f\16\f\u00e5\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00f3\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0100\n\f\3\f\3\f\5\f\u0104\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u010b\n"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0113\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0121\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u014e"+
		"\n\r\f\r\16\r\u0151\13\r\3\16\3\16\3\16\7\16\u0156\n\16\f\16\16\16\u0159"+
		"\13\16\5\16\u015b\n\16\3\16\2\4\b\30\17\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\2\n\4\2\5\7==\3\2/\60\4\2##%%\4\2$$&&\3\2\')\3\2!\"\3\2\35 \3\2\66"+
		"\67\2\u0196\2\37\3\2\2\2\4F\3\2\2\2\6H\3\2\2\2\bJ\3\2\2\2\nY\3\2\2\2\f"+
		"]\3\2\2\2\16\u00ae\3\2\2\2\20\u00b0\3\2\2\2\22\u00c0\3\2\2\2\24\u00cd"+
		"\3\2\2\2\26\u0112\3\2\2\2\30\u0120\3\2\2\2\32\u015a\3\2\2\2\34\36\5\4"+
		"\3\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37"+
		"\3\2\2\2\"#\7\2\2\3#\3\3\2\2\2$G\7\63\2\2%&\5\n\6\2&\'\7=\2\2\'(\7\65"+
		"\2\2()\5\30\r\2)G\3\2\2\2*+\5\n\6\2+\60\7=\2\2,-\7\64\2\2-/\7=\2\2.,\3"+
		"\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61G\3\2\2\2\62\60\3\2\2\2"+
		"\63\64\7\24\2\2\64\65\7=\2\2\659\7\33\2\2\668\5\4\3\2\67\66\3\2\2\28;"+
		"\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<G\7\34\2\2=>\5\f\7"+
		"\2>?\7=\2\2?@\5\20\t\2@A\5\24\13\2AG\3\2\2\2BC\7=\2\2CD\7\27\2\2DE\7\30"+
		"\2\2EG\5\24\13\2F$\3\2\2\2F%\3\2\2\2F*\3\2\2\2F\63\3\2\2\2F=\3\2\2\2F"+
		"B\3\2\2\2G\5\3\2\2\2HI\t\2\2\2I\7\3\2\2\2JK\b\5\1\2KL\5\6\4\2LM\7\31\2"+
		"\2MN\7\32\2\2NT\3\2\2\2OP\f\3\2\2PQ\7\31\2\2QS\7\32\2\2RO\3\2\2\2SV\3"+
		"\2\2\2TR\3\2\2\2TU\3\2\2\2U\t\3\2\2\2VT\3\2\2\2WZ\5\6\4\2XZ\5\b\5\2YW"+
		"\3\2\2\2YX\3\2\2\2Z\13\3\2\2\2[^\5\n\6\2\\^\7\t\2\2][\3\2\2\2]\\\3\2\2"+
		"\2^\r\3\2\2\2_\u00af\7=\2\2`\u00af\7>\2\2a\u00af\7?\2\2b\u00af\7\n\2\2"+
		"c\u00af\7\13\2\2d\u00af\7\b\2\2ef\7\23\2\2fi\5\6\4\2gh\7\31\2\2hj\7\32"+
		"\2\2ig\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2ls\3\2\2\2mn\7\31\2\2no\5"+
		"\30\r\2op\7\32\2\2pr\3\2\2\2qm\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t"+
		"\u00af\3\2\2\2us\3\2\2\2vw\7\23\2\2w|\5\6\4\2xy\7\31\2\2yz\5\30\r\2z{"+
		"\7\32\2\2{}\3\2\2\2|x\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082"+
		"\3\2\2\2\u0080\u0081\7\31\2\2\u0081\u0083\7\32\2\2\u0082\u0080\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u008a"+
		"\3\2\2\2\u0086\u0087\7\31\2\2\u0087\u0088\5\30\r\2\u0088\u0089\7\32\2"+
		"\2\u0089\u008b\3\2\2\2\u008a\u0086\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u00af\3\2\2\2\u008e\u008f\7\23\2\2"+
		"\u008f\u0094\5\6\4\2\u0090\u0091\7\31\2\2\u0091\u0092\5\30\r\2\u0092\u0093"+
		"\7\32\2\2\u0093\u0095\3\2\2\2\u0094\u0090\3\2\2\2\u0095\u0096\3\2\2\2"+
		"\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009c\3\2\2\2\u0098\u0099"+
		"\7\31\2\2\u0099\u009b\7\32\2\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2"+
		"\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00af\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a0\7\23\2\2\u00a0\u00a3\7=\2\2\u00a1\u00a2\7\27\2\2"+
		"\u00a2\u00a4\7\30\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00af"+
		"\3\2\2\2\u00a5\u00a6\7=\2\2\u00a6\u00af\5\22\n\2\u00a7\u00a8\7\3\2\2\u00a8"+
		"\u00a9\5\20\t\2\u00a9\u00aa\7\4\2\2\u00aa\u00ab\5\24\13\2\u00ab\u00ac"+
		"\5\22\n\2\u00ac\u00af\3\2\2\2\u00ad\u00af\7\25\2\2\u00ae_\3\2\2\2\u00ae"+
		"`\3\2\2\2\u00aea\3\2\2\2\u00aeb\3\2\2\2\u00aec\3\2\2\2\u00aed\3\2\2\2"+
		"\u00aee\3\2\2\2\u00aev\3\2\2\2\u00ae\u008e\3\2\2\2\u00ae\u009f\3\2\2\2"+
		"\u00ae\u00a5\3\2\2\2\u00ae\u00a7\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\17"+
		"\3\2\2\2\u00b0\u00bc\7\27\2\2\u00b1\u00b2\5\n\6\2\u00b2\u00b9\7=\2\2\u00b3"+
		"\u00b4\7\64\2\2\u00b4\u00b5\5\n\6\2\u00b5\u00b6\7=\2\2\u00b6\u00b8\3\2"+
		"\2\2\u00b7\u00b3\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00b1\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7\30\2\2\u00bf"+
		"\21\3\2\2\2\u00c0\u00c9\7\27\2\2\u00c1\u00c6\5\30\r\2\u00c2\u00c3\7\64"+
		"\2\2\u00c3\u00c5\5\30\r\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c9\u00c1\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\7\30\2\2\u00cc\23\3\2\2\2\u00cd\u00d1\7\33\2\2\u00ce\u00d0\5\26"+
		"\f\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7\34"+
		"\2\2\u00d5\25\3\2\2\2\u00d6\u0113\7\63\2\2\u00d7\u00d8\5\n\6\2\u00d8\u00d9"+
		"\7=\2\2\u00d9\u00da\7\65\2\2\u00da\u00db\5\30\r\2\u00db\u00dc\7\63\2\2"+
		"\u00dc\u0113\3\2\2\2\u00dd\u00de\5\n\6\2\u00de\u00e3\7=\2\2\u00df\u00e0"+
		"\7\64\2\2\u00e0\u00e2\7=\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e6\u00e7\7\63\2\2\u00e7\u0113\3\2\2\2\u00e8\u00e9\5\30\r\2\u00e9"+
		"\u00ea\7\63\2\2\u00ea\u0113\3\2\2\2\u00eb\u00ec\7\f\2\2\u00ec\u00ed\7"+
		"\27\2\2\u00ed\u00ee\5\30\r\2\u00ee\u00ef\7\30\2\2\u00ef\u00f2\5\26\f\2"+
		"\u00f0\u00f1\7\r\2\2\u00f1\u00f3\5\26\f\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3"+
		"\3\2\2\2\u00f3\u0113\3\2\2\2\u00f4\u00f5\7\17\2\2\u00f5\u00f6\7\27\2\2"+
		"\u00f6\u00f7\5\30\r\2\u00f7\u00f8\7\30\2\2\u00f8\u00f9\5\26\f\2\u00f9"+
		"\u0113\3\2\2\2\u00fa\u00fb\7\16\2\2\u00fb\u00fc\7\27\2\2\u00fc\u00fd\5"+
		"\32\16\2\u00fd\u00ff\7\63\2\2\u00fe\u0100\5\30\r\2\u00ff\u00fe\3\2\2\2"+
		"\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103\7\63\2\2\u0102\u0104"+
		"\5\30\r\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2"+
		"\u0105\u0106\7\30\2\2\u0106\u0107\5\26\f\2\u0107\u0113\3\2\2\2\u0108\u010a"+
		"\7\22\2\2\u0109\u010b\5\30\r\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2"+
		"\u010b\u010c\3\2\2\2\u010c\u0113\7\63\2\2\u010d\u010e\7\20\2\2\u010e\u0113"+
		"\7\63\2\2\u010f\u0110\7\21\2\2\u0110\u0113\7\63\2\2\u0111\u0113\5\24\13"+
		"\2\u0112\u00d6\3\2\2\2\u0112\u00d7\3\2\2\2\u0112\u00dd\3\2\2\2\u0112\u00e8"+
		"\3\2\2\2\u0112\u00eb\3\2\2\2\u0112\u00f4\3\2\2\2\u0112\u00fa\3\2\2\2\u0112"+
		"\u0108\3\2\2\2\u0112\u010d\3\2\2\2\u0112\u010f\3\2\2\2\u0112\u0111\3\2"+
		"\2\2\u0113\27\3\2\2\2\u0114\u0115\b\r\1\2\u0115\u0121\5\16\b\2\u0116\u0117"+
		"\7\27\2\2\u0117\u0118\5\30\r\2\u0118\u0119\7\30\2\2\u0119\u0121\3\2\2"+
		"\2\u011a\u011b\t\3\2\2\u011b\u0121\5\30\r\21\u011c\u011d\t\4\2\2\u011d"+
		"\u0121\5\30\r\20\u011e\u011f\t\5\2\2\u011f\u0121\5\30\r\17\u0120\u0114"+
		"\3\2\2\2\u0120\u0116\3\2\2\2\u0120\u011a\3\2\2\2\u0120\u011c\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0121\u014f\3\2\2\2\u0122\u0123\f\22\2\2\u0123\u0124\7"+
		"\26\2\2\u0124\u014e\5\30\r\23\u0125\u0126\f\r\2\2\u0126\u0127\t\6\2\2"+
		"\u0127\u014e\5\30\r\16\u0128\u0129\f\f\2\2\u0129\u012a\t\4\2\2\u012a\u014e"+
		"\5\30\r\r\u012b\u012c\f\13\2\2\u012c\u012d\t\7\2\2\u012d\u014e\5\30\r"+
		"\f\u012e\u012f\f\n\2\2\u012f\u0130\t\b\2\2\u0130\u014e\5\30\r\13\u0131"+
		"\u0132\f\t\2\2\u0132\u0133\t\t\2\2\u0133\u014e\5\30\r\n\u0134\u0135\f"+
		"\b\2\2\u0135\u0136\7*\2\2\u0136\u014e\5\30\r\t\u0137\u0138\f\7\2\2\u0138"+
		"\u0139\7.\2\2\u0139\u014e\5\30\r\b\u013a\u013b\f\6\2\2\u013b\u013c\7+"+
		"\2\2\u013c\u014e\5\30\r\7\u013d\u013e\f\5\2\2\u013e\u013f\7,\2\2\u013f"+
		"\u014e\5\30\r\6\u0140\u0141\f\4\2\2\u0141\u0142\7-\2\2\u0142\u014e\5\30"+
		"\r\5\u0143\u0144\f\3\2\2\u0144\u0145\7\65\2\2\u0145\u014e\5\30\r\3\u0146"+
		"\u0147\f\23\2\2\u0147\u0148\7\31\2\2\u0148\u0149\5\30\r\2\u0149\u014a"+
		"\7\32\2\2\u014a\u014e\3\2\2\2\u014b\u014c\f\16\2\2\u014c\u014e\t\5\2\2"+
		"\u014d\u0122\3\2\2\2\u014d\u0125\3\2\2\2\u014d\u0128\3\2\2\2\u014d\u012b"+
		"\3\2\2\2\u014d\u012e\3\2\2\2\u014d\u0131\3\2\2\2\u014d\u0134\3\2\2\2\u014d"+
		"\u0137\3\2\2\2\u014d\u013a\3\2\2\2\u014d\u013d\3\2\2\2\u014d\u0140\3\2"+
		"\2\2\u014d\u0143\3\2\2\2\u014d\u0146\3\2\2\2\u014d\u014b\3\2\2\2\u014e"+
		"\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\31\3\2\2"+
		"\2\u0151\u014f\3\2\2\2\u0152\u0157\5\30\r\2\u0153\u0154\7\64\2\2\u0154"+
		"\u0156\5\30\r\2\u0155\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3"+
		"\2\2\2\u0157\u0158\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u015a"+
		"\u0152\3\2\2\2\u015a\u015b\3\2\2\2\u015b\33\3\2\2\2\"\37\609FTY]ks~\u0084"+
		"\u008c\u0096\u009c\u00a3\u00ae\u00b9\u00bc\u00c6\u00c9\u00d1\u00e3\u00f2"+
		"\u00ff\u0103\u010a\u0112\u0120\u014d\u014f\u0157\u015a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}