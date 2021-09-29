// Generated from E:/SJTU/3CompilerWorkplace/src\Isaiah.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsaiahParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, Int=33, Bool=34, String=35, Null=36, Void=37, True=38, False=39, 
		If=40, Else=41, For=42, While=43, Break=44, Continue=45, Return=46, New=47, 
		Class=48, This=49, LeftBrace=50, RightBrace=51, BlockComment=52, BlankChar=53, 
		LineComment=54, Identifier=55, IntConst=56, StringConst=57;
	public static final int
		RULE_program = 0, RULE_declare = 1, RULE_digitType = 2, RULE_arrayType = 3, 
		RULE_varType = 4, RULE_varObj = 5, RULE_retType = 6, RULE_varDeclare = 7, 
		RULE_initialPart = 8, RULE_classDeclare = 9, RULE_classIdentity = 10, 
		RULE_constructDeclare = 11, RULE_funcDeclare = 12, RULE_parameterList = 13, 
		RULE_expressionList = 14, RULE_block = 15, RULE_suite = 16, RULE_statement = 17, 
		RULE_expression = 18, RULE_constVal = 19, RULE_newExpr = 20, RULE_lambdaFunc = 21, 
		RULE_condition = 22, RULE_loop = 23, RULE_forInit = 24, RULE_jump = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare", "digitType", "arrayType", "varType", "varObj", 
			"retType", "varDeclare", "initialPart", "classDeclare", "classIdentity", 
			"constructDeclare", "funcDeclare", "parameterList", "expressionList", 
			"block", "suite", "statement", "expression", "constVal", "newExpr", "lambdaFunc", 
			"condition", "loop", "forInit", "jump"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'['", "']'", "','", "'='", "'('", "')'", "'.'", "'!'", 
			"'~'", "'+'", "'-'", "'++'", "'--'", "'*'", "'/'", "'%'", "'<<'", "'>>'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&'", "'^'", "'|'", "'&&'", 
			"'||'", "'[&]'", "'->'", "'int'", "'bool'", "'string'", "'null'", "'void'", 
			"'true'", "'false'", "'if'", "'else'", "'for'", "'while'", "'break'", 
			"'continue'", "'return'", "'new'", "'class'", "'this'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Int", "Bool", 
			"String", "Null", "Void", "True", "False", "If", "Else", "For", "While", 
			"Break", "Continue", "Return", "New", "Class", "This", "LeftBrace", "RightBrace", 
			"BlockComment", "BlankChar", "LineComment", "Identifier", "IntConst", 
			"StringConst"
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
	public String getGrammarFileName() { return "Parser/Isaiah.g4"; }

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
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
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
		public VarDeclareContext varDeclare() {
			return getRuleContext(VarDeclareContext.class,0);
		}
		public ClassDeclareContext classDeclare() {
			return getRuleContext(ClassDeclareContext.class,0);
		}
		public FuncDeclareContext funcDeclare() {
			return getRuleContext(FuncDeclareContext.class,0);
		}
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declare);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				varDeclare();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				classDeclare();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				funcDeclare();
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
			setState(66);
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
			setState(69);
			digitType();
			setState(70);
			match(T__1);
			setState(71);
			match(T__2);
			}
			_ctx.stop = _input.LT(-1);
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arrayType);
					setState(73);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(74);
					match(T__1);
					setState(75);
					match(T__2);
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				digitType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
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

	public static class VarObjContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public ConstValContext constVal() {
			return getRuleContext(ConstValContext.class,0);
		}
		public NewExprContext newExpr() {
			return getRuleContext(NewExprContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LambdaFuncContext lambdaFunc() {
			return getRuleContext(LambdaFuncContext.class,0);
		}
		public TerminalNode This() { return getToken(IsaiahParser.This, 0); }
		public VarObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varObj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterVarObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitVarObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitVarObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarObjContext varObj() throws RecognitionException {
		VarObjContext _localctx = new VarObjContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varObj);
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				constVal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				newExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				match(Identifier);
				setState(89);
				expressionList();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
				lambdaFunc();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
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
		enterRule(_localctx, 12, RULE_retType);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				varType();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
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

	public static class VarDeclareContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(IsaiahParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(IsaiahParser.Identifier, i);
		}
		public List<InitialPartContext> initialPart() {
			return getRuleContexts(InitialPartContext.class);
		}
		public InitialPartContext initialPart(int i) {
			return getRuleContext(InitialPartContext.class,i);
		}
		public VarDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterVarDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitVarDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitVarDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclareContext varDeclare() throws RecognitionException {
		VarDeclareContext _localctx = new VarDeclareContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			varType();
			setState(99);
			match(Identifier);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1 || _la==T__4) {
				{
				setState(100);
				initialPart();
				}
			}

			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(103);
				match(T__3);
				setState(104);
				match(Identifier);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1 || _la==T__4) {
					{
					setState(105);
					initialPart();
					}
				}

				}
				}
				setState(112);
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

	public static class InitialPartContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitialPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterInitialPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitInitialPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitInitialPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialPartContext initialPart() throws RecognitionException {
		InitialPartContext _localctx = new InitialPartContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_initialPart);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(T__1);
				setState(114);
				expression(0);
				setState(115);
				match(T__2);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(T__4);
				setState(118);
				expression(0);
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

	public static class ClassDeclareContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(IsaiahParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(IsaiahParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(IsaiahParser.RightBrace, 0); }
		public List<ClassIdentityContext> classIdentity() {
			return getRuleContexts(ClassIdentityContext.class);
		}
		public ClassIdentityContext classIdentity(int i) {
			return getRuleContext(ClassIdentityContext.class,i);
		}
		public ClassDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclare; }
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

	public final ClassDeclareContext classDeclare() throws RecognitionException {
		ClassDeclareContext _localctx = new ClassDeclareContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(Class);
			setState(122);
			match(Identifier);
			setState(123);
			match(LeftBrace);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(124);
				classIdentity();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
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

	public static class ClassIdentityContext extends ParserRuleContext {
		public VarDeclareContext varDeclare() {
			return getRuleContext(VarDeclareContext.class,0);
		}
		public FuncDeclareContext funcDeclare() {
			return getRuleContext(FuncDeclareContext.class,0);
		}
		public ConstructDeclareContext constructDeclare() {
			return getRuleContext(ConstructDeclareContext.class,0);
		}
		public ClassIdentityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classIdentity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterClassIdentity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitClassIdentity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitClassIdentity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassIdentityContext classIdentity() throws RecognitionException {
		ClassIdentityContext _localctx = new ClassIdentityContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classIdentity);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				varDeclare();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				funcDeclare();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				constructDeclare();
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

	public static class ConstructDeclareContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(IsaiahParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(IsaiahParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConstructDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterConstructDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitConstructDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitConstructDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructDeclareContext constructDeclare() throws RecognitionException {
		ConstructDeclareContext _localctx = new ConstructDeclareContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constructDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(Identifier);
			setState(139);
			match(T__5);
			setState(140);
			match(T__6);
			setState(141);
			match(LeftBrace);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << True) | (1L << False) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << LeftBrace) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(142);
				statement();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
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

	public static class FuncDeclareContext extends ParserRuleContext {
		public RetTypeContext retType() {
			return getRuleContext(RetTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(IsaiahParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(IsaiahParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FuncDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDeclare; }
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

	public final FuncDeclareContext funcDeclare() throws RecognitionException {
		FuncDeclareContext _localctx = new FuncDeclareContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funcDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			retType();
			setState(151);
			match(Identifier);
			setState(152);
			parameterList();
			setState(153);
			match(LeftBrace);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << True) | (1L << False) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << LeftBrace) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(154);
				statement();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
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

	public static class ParameterListContext extends ParserRuleContext {
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
		enterRule(_localctx, 26, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__5);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(163);
				varType();
				setState(164);
				match(Identifier);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(165);
					match(T__3);
					setState(166);
					varType();
					setState(167);
					match(Identifier);
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(176);
			match(T__6);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 28, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__5);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(179);
				expression(0);
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(180);
					match(T__3);
					setState(181);
					expression(0);
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(189);
			match(T__6);
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
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(LeftBrace);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << True) | (1L << False) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << LeftBrace) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(192);
				statement();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
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

	public static class SuiteContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_suite);
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				statement();
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

	public static class StatementContext extends ParserRuleContext {
		public VarDeclareContext varDeclare() {
			return getRuleContext(VarDeclareContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public JumpContext jump() {
			return getRuleContext(JumpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				varDeclare();
				setState(206);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
				expression(0);
				setState(209);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				condition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				loop();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				jump();
				setState(214);
				match(T__0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(216);
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
	public static class ValueExprContext extends ExpressionContext {
		public VarObjContext varObj() {
			return getRuleContext(VarObjContext.class,0);
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
	public static class BinaryExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
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
	public static class AssignExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
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

				setState(220);
				varObj();
				}
				break;
			case T__5:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(T__5);
				setState(222);
				expression(0);
				setState(223);
				match(T__6);
				}
				break;
			case T__8:
			case T__9:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(226);
				expression(15);
				}
				break;
			case T__10:
			case T__11:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(228);
				expression(14);
				}
				break;
			case T__12:
			case T__13:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(230);
				expression(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(287);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new CallExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(234);
						match(T__7);
						setState(235);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(237);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(238);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(239);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(240);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(243);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(245);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(246);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(248);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(249);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(250);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(251);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(252);
						match(T__25);
						setState(253);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(255);
						match(T__26);
						setState(256);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(258);
						match(T__27);
						setState(259);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(260);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(261);
						match(T__28);
						setState(262);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(263);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(264);
						match(T__29);
						setState(265);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(266);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(267);
						match(T__4);
						setState(268);
						expression(1);
						}
						break;
					case 13:
						{
						_localctx = new IndexExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(269);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(274); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(270);
								match(T__1);
								setState(271);
								expression(0);
								setState(272);
								match(T__2);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(276); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(282);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(278);
								match(T__1);
								setState(279);
								match(T__2);
								}
								} 
							}
							setState(284);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						}
						}
						break;
					case 14:
						{
						_localctx = new UnaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(286);
						((UnaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class ConstValContext extends ParserRuleContext {
		public TerminalNode IntConst() { return getToken(IsaiahParser.IntConst, 0); }
		public TerminalNode StringConst() { return getToken(IsaiahParser.StringConst, 0); }
		public TerminalNode True() { return getToken(IsaiahParser.True, 0); }
		public TerminalNode False() { return getToken(IsaiahParser.False, 0); }
		public TerminalNode Null() { return getToken(IsaiahParser.Null, 0); }
		public ConstValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterConstVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitConstVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitConstVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstValContext constVal() throws RecognitionException {
		ConstValContext _localctx = new ConstValContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << IntConst) | (1L << StringConst))) != 0)) ) {
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

	public static class NewExprContext extends ParserRuleContext {
		public NewExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpr; }
	 
		public NewExprContext() { }
		public void copyFrom(NewExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Test4Context extends NewExprContext {
		public TerminalNode New() { return getToken(IsaiahParser.New, 0); }
		public TerminalNode Identifier() { return getToken(IsaiahParser.Identifier, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public Test4Context(NewExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterTest4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitTest4(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitTest4(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Test2Context extends NewExprContext {
		public TerminalNode New() { return getToken(IsaiahParser.New, 0); }
		public DigitTypeContext digitType() {
			return getRuleContext(DigitTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Test2Context(NewExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterTest2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitTest2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitTest2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Test3Context extends NewExprContext {
		public TerminalNode New() { return getToken(IsaiahParser.New, 0); }
		public DigitTypeContext digitType() {
			return getRuleContext(DigitTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Test3Context(NewExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterTest3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitTest3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitTest3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Test1Context extends NewExprContext {
		public TerminalNode New() { return getToken(IsaiahParser.New, 0); }
		public DigitTypeContext digitType() {
			return getRuleContext(DigitTypeContext.class,0);
		}
		public Test1Context(NewExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterTest1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitTest1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitTest1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExprContext newExpr() throws RecognitionException {
		NewExprContext _localctx = new NewExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_newExpr);
		try {
			int _alt;
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new Test1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(New);
				setState(295);
				digitType();
				}
				break;
			case 2:
				_localctx = new Test2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				match(New);
				setState(297);
				digitType();
				setState(298);
				match(T__5);
				setState(299);
				expression(0);
				setState(300);
				match(T__6);
				}
				break;
			case 3:
				_localctx = new Test3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(302);
				match(New);
				setState(303);
				digitType();
				setState(308); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(304);
						match(T__1);
						setState(305);
						expression(0);
						setState(306);
						match(T__2);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(310); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(312);
						match(T__1);
						setState(313);
						match(T__2);
						}
						} 
					}
					setState(318);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			case 4:
				_localctx = new Test4Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(319);
				match(New);
				setState(320);
				match(Identifier);
				setState(321);
				parameterList();
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

	public static class LambdaFuncContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(IsaiahParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(IsaiahParser.RightBrace, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LambdaFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterLambdaFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitLambdaFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitLambdaFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaFuncContext lambdaFunc() throws RecognitionException {
		LambdaFuncContext _localctx = new LambdaFuncContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_lambdaFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(T__30);
			setState(325);
			parameterList();
			setState(326);
			match(T__31);
			setState(327);
			match(LeftBrace);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Null) | (1L << True) | (1L << False) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << LeftBrace) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(328);
				statement();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(334);
			match(RightBrace);
			setState(335);
			expressionList();
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(IsaiahParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode Else() { return getToken(IsaiahParser.Else, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(If);
			setState(338);
			match(T__5);
			setState(339);
			expression(0);
			setState(340);
			match(T__6);
			setState(341);
			suite();
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(342);
				match(Else);
				setState(343);
				suite();
				}
				break;
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

	public static class LoopContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(IsaiahParser.While, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode For() { return getToken(IsaiahParser.For, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_loop);
		int _la;
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				match(While);
				setState(347);
				match(T__5);
				setState(348);
				expression(0);
				setState(349);
				match(T__6);
				setState(350);
				suite();
				}
				break;
			case For:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				match(For);
				setState(353);
				match(T__5);
				setState(354);
				forInit();
				setState(355);
				match(T__0);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(356);
					expression(0);
					}
				}

				setState(359);
				match(T__0);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(360);
					expression(0);
					}
				}

				setState(363);
				match(T__6);
				setState(364);
				suite();
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

	public static class ForInitContext extends ParserRuleContext {
		public VarDeclareContext varDeclare() {
			return getRuleContext(VarDeclareContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 48, RULE_forInit);
		int _la;
		try {
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				varDeclare();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(369);
					expression(0);
					setState(374);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(370);
						match(T__3);
						setState(371);
						expression(0);
						}
						}
						setState(376);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

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

	public static class JumpContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(IsaiahParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Break() { return getToken(IsaiahParser.Break, 0); }
		public TerminalNode Continue() { return getToken(IsaiahParser.Continue, 0); }
		public JumpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).enterJump(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsaiahListener ) ((IsaiahListener)listener).exitJump(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsaiahVisitor ) return ((IsaiahVisitor<? extends T>)visitor).visitJump(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpContext jump() throws RecognitionException {
		JumpContext _localctx = new JumpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_jump);
		int _la;
		try {
			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Return:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				match(Return);
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__30) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					setState(382);
					expression(0);
					}
				}

				}
				break;
			case Break:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				match(Break);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 3);
				{
				setState(386);
				match(Continue);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return arrayType_sempred((ArrayTypeContext)_localctx, predIndex);
		case 18:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0188\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\5\3C\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5O\n\5\f\5\16\5"+
		"R\13\5\3\6\3\6\5\6V\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\b\3\b\5"+
		"\bc\n\b\3\t\3\t\3\t\5\th\n\t\3\t\3\t\3\t\5\tm\n\t\7\to\n\t\f\t\16\tr\13"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\5\nz\n\n\3\13\3\13\3\13\3\13\7\13\u0080\n\13"+
		"\f\13\16\13\u0083\13\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u008b\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u0092\n\r\f\r\16\r\u0095\13\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u009e\n\16\f\16\16\16\u00a1\13\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00ac\n\17\f\17\16\17\u00af\13\17\5\17"+
		"\u00b1\n\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00b9\n\20\f\20\16\20\u00bc"+
		"\13\20\5\20\u00be\n\20\3\20\3\20\3\21\3\21\7\21\u00c4\n\21\f\21\16\21"+
		"\u00c7\13\21\3\21\3\21\3\22\3\22\5\22\u00cd\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00dc\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00ea\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\6\24\u0115"+
		"\n\24\r\24\16\24\u0116\3\24\3\24\7\24\u011b\n\24\f\24\16\24\u011e\13\24"+
		"\3\24\3\24\7\24\u0122\n\24\f\24\16\24\u0125\13\24\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\6\26\u0137"+
		"\n\26\r\26\16\26\u0138\3\26\3\26\7\26\u013d\n\26\f\26\16\26\u0140\13\26"+
		"\3\26\3\26\3\26\5\26\u0145\n\26\3\27\3\27\3\27\3\27\3\27\7\27\u014c\n"+
		"\27\f\27\16\27\u014f\13\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u015b\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u0168\n\31\3\31\3\31\5\31\u016c\n\31\3\31\3\31\3\31\5\31\u0171"+
		"\n\31\3\32\3\32\3\32\3\32\7\32\u0177\n\32\f\32\16\32\u017a\13\32\5\32"+
		"\u017c\n\32\5\32\u017e\n\32\3\33\3\33\5\33\u0182\n\33\3\33\3\33\5\33\u0186"+
		"\n\33\3\33\2\4\b&\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\2\13\4\2#%99\3\2\13\f\3\2\r\16\3\2\17\20\3\2\21\23\3\2\24\25\3"+
		"\2\26\31\3\2\32\33\5\2&&():;\2\u01b3\29\3\2\2\2\4B\3\2\2\2\6D\3\2\2\2"+
		"\bF\3\2\2\2\nU\3\2\2\2\f^\3\2\2\2\16b\3\2\2\2\20d\3\2\2\2\22y\3\2\2\2"+
		"\24{\3\2\2\2\26\u008a\3\2\2\2\30\u008c\3\2\2\2\32\u0098\3\2\2\2\34\u00a4"+
		"\3\2\2\2\36\u00b4\3\2\2\2 \u00c1\3\2\2\2\"\u00cc\3\2\2\2$\u00db\3\2\2"+
		"\2&\u00e9\3\2\2\2(\u0126\3\2\2\2*\u0144\3\2\2\2,\u0146\3\2\2\2.\u0153"+
		"\3\2\2\2\60\u0170\3\2\2\2\62\u017d\3\2\2\2\64\u0185\3\2\2\2\668\5\4\3"+
		"\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<"+
		"=\7\2\2\3=\3\3\2\2\2>C\7\3\2\2?C\5\20\t\2@C\5\24\13\2AC\5\32\16\2B>\3"+
		"\2\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\5\3\2\2\2DE\t\2\2\2E\7\3\2\2\2F"+
		"G\b\5\1\2GH\5\6\4\2HI\7\4\2\2IJ\7\5\2\2JP\3\2\2\2KL\f\3\2\2LM\7\4\2\2"+
		"MO\7\5\2\2NK\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\t\3\2\2\2RP\3\2\2"+
		"\2SV\5\6\4\2TV\5\b\5\2US\3\2\2\2UT\3\2\2\2V\13\3\2\2\2W_\79\2\2X_\5(\25"+
		"\2Y_\5*\26\2Z[\79\2\2[_\5\36\20\2\\_\5,\27\2]_\7\63\2\2^W\3\2\2\2^X\3"+
		"\2\2\2^Y\3\2\2\2^Z\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\r\3\2\2\2`c\5\n\6\2a"+
		"c\7\'\2\2b`\3\2\2\2ba\3\2\2\2c\17\3\2\2\2de\5\n\6\2eg\79\2\2fh\5\22\n"+
		"\2gf\3\2\2\2gh\3\2\2\2hp\3\2\2\2ij\7\6\2\2jl\79\2\2km\5\22\n\2lk\3\2\2"+
		"\2lm\3\2\2\2mo\3\2\2\2ni\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\21\3\2"+
		"\2\2rp\3\2\2\2st\7\4\2\2tu\5&\24\2uv\7\5\2\2vz\3\2\2\2wx\7\7\2\2xz\5&"+
		"\24\2ys\3\2\2\2yw\3\2\2\2z\23\3\2\2\2{|\7\62\2\2|}\79\2\2}\u0081\7\64"+
		"\2\2~\u0080\5\26\f\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085"+
		"\7\65\2\2\u0085\25\3\2\2\2\u0086\u008b\7\3\2\2\u0087\u008b\5\20\t\2\u0088"+
		"\u008b\5\32\16\2\u0089\u008b\5\30\r\2\u008a\u0086\3\2\2\2\u008a\u0087"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\27\3\2\2\2\u008c"+
		"\u008d\79\2\2\u008d\u008e\7\b\2\2\u008e\u008f\7\t\2\2\u008f\u0093\7\64"+
		"\2\2\u0090\u0092\5$\23\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0096\u0097\7\65\2\2\u0097\31\3\2\2\2\u0098\u0099\5\16\b\2\u0099"+
		"\u009a\79\2\2\u009a\u009b\5\34\17\2\u009b\u009f\7\64\2\2\u009c\u009e\5"+
		"$\23\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\65"+
		"\2\2\u00a3\33\3\2\2\2\u00a4\u00b0\7\b\2\2\u00a5\u00a6\5\n\6\2\u00a6\u00ad"+
		"\79\2\2\u00a7\u00a8\7\6\2\2\u00a8\u00a9\5\n\6\2\u00a9\u00aa\79\2\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00a5\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\t"+
		"\2\2\u00b3\35\3\2\2\2\u00b4\u00bd\7\b\2\2\u00b5\u00ba\5&\24\2\u00b6\u00b7"+
		"\7\6\2\2\u00b7\u00b9\5&\24\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c0\7\t\2\2\u00c0\37\3\2\2\2\u00c1\u00c5\7\64\2\2\u00c2\u00c4\5$\23"+
		"\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6"+
		"\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\7\65\2\2"+
		"\u00c9!\3\2\2\2\u00ca\u00cd\5 \21\2\u00cb\u00cd\5$\23\2\u00cc\u00ca\3"+
		"\2\2\2\u00cc\u00cb\3\2\2\2\u00cd#\3\2\2\2\u00ce\u00dc\7\3\2\2\u00cf\u00d0"+
		"\5\20\t\2\u00d0\u00d1\7\3\2\2\u00d1\u00dc\3\2\2\2\u00d2\u00d3\5&\24\2"+
		"\u00d3\u00d4\7\3\2\2\u00d4\u00dc\3\2\2\2\u00d5\u00dc\5.\30\2\u00d6\u00dc"+
		"\5\60\31\2\u00d7\u00d8\5\64\33\2\u00d8\u00d9\7\3\2\2\u00d9\u00dc\3\2\2"+
		"\2\u00da\u00dc\5 \21\2\u00db\u00ce\3\2\2\2\u00db\u00cf\3\2\2\2\u00db\u00d2"+
		"\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d6\3\2\2\2\u00db\u00d7\3\2\2\2\u00db"+
		"\u00da\3\2\2\2\u00dc%\3\2\2\2\u00dd\u00de\b\24\1\2\u00de\u00ea\5\f\7\2"+
		"\u00df\u00e0\7\b\2\2\u00e0\u00e1\5&\24\2\u00e1\u00e2\7\t\2\2\u00e2\u00ea"+
		"\3\2\2\2\u00e3\u00e4\t\3\2\2\u00e4\u00ea\5&\24\21\u00e5\u00e6\t\4\2\2"+
		"\u00e6\u00ea\5&\24\20\u00e7\u00e8\t\5\2\2\u00e8\u00ea\5&\24\17\u00e9\u00dd"+
		"\3\2\2\2\u00e9\u00df\3\2\2\2\u00e9\u00e3\3\2\2\2\u00e9\u00e5\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u0123\3\2\2\2\u00eb\u00ec\f\22\2\2\u00ec\u00ed\7"+
		"\n\2\2\u00ed\u0122\5&\24\23\u00ee\u00ef\f\r\2\2\u00ef\u00f0\t\6\2\2\u00f0"+
		"\u0122\5&\24\16\u00f1\u00f2\f\f\2\2\u00f2\u00f3\t\4\2\2\u00f3\u0122\5"+
		"&\24\r\u00f4\u00f5\f\13\2\2\u00f5\u00f6\t\7\2\2\u00f6\u0122\5&\24\f\u00f7"+
		"\u00f8\f\n\2\2\u00f8\u00f9\t\b\2\2\u00f9\u0122\5&\24\13\u00fa\u00fb\f"+
		"\t\2\2\u00fb\u00fc\t\t\2\2\u00fc\u0122\5&\24\n\u00fd\u00fe\f\b\2\2\u00fe"+
		"\u00ff\7\34\2\2\u00ff\u0122\5&\24\t\u0100\u0101\f\7\2\2\u0101\u0102\7"+
		"\35\2\2\u0102\u0122\5&\24\b\u0103\u0104\f\6\2\2\u0104\u0105\7\36\2\2\u0105"+
		"\u0122\5&\24\7\u0106\u0107\f\5\2\2\u0107\u0108\7\37\2\2\u0108\u0122\5"+
		"&\24\6\u0109\u010a\f\4\2\2\u010a\u010b\7 \2\2\u010b\u0122\5&\24\5\u010c"+
		"\u010d\f\3\2\2\u010d\u010e\7\7\2\2\u010e\u0122\5&\24\3\u010f\u0114\f\23"+
		"\2\2\u0110\u0111\7\4\2\2\u0111\u0112\5&\24\2\u0112\u0113\7\5\2\2\u0113"+
		"\u0115\3\2\2\2\u0114\u0110\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u011c\3\2\2\2\u0118\u0119\7\4\2\2\u0119"+
		"\u011b\7\5\2\2\u011a\u0118\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u0122\3\2\2\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0120\f\16\2\2\u0120\u0122\t\5\2\2\u0121\u00eb\3\2\2\2\u0121\u00ee\3"+
		"\2\2\2\u0121\u00f1\3\2\2\2\u0121\u00f4\3\2\2\2\u0121\u00f7\3\2\2\2\u0121"+
		"\u00fa\3\2\2\2\u0121\u00fd\3\2\2\2\u0121\u0100\3\2\2\2\u0121\u0103\3\2"+
		"\2\2\u0121\u0106\3\2\2\2\u0121\u0109\3\2\2\2\u0121\u010c\3\2\2\2\u0121"+
		"\u010f\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0123\u0124\3\2\2\2\u0124\'\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127"+
		"\t\n\2\2\u0127)\3\2\2\2\u0128\u0129\7\61\2\2\u0129\u0145\5\6\4\2\u012a"+
		"\u012b\7\61\2\2\u012b\u012c\5\6\4\2\u012c\u012d\7\b\2\2\u012d\u012e\5"+
		"&\24\2\u012e\u012f\7\t\2\2\u012f\u0145\3\2\2\2\u0130\u0131\7\61\2\2\u0131"+
		"\u0136\5\6\4\2\u0132\u0133\7\4\2\2\u0133\u0134\5&\24\2\u0134\u0135\7\5"+
		"\2\2\u0135\u0137\3\2\2\2\u0136\u0132\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013e\3\2\2\2\u013a\u013b\7\4"+
		"\2\2\u013b\u013d\7\5\2\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0145\3\2\2\2\u0140\u013e\3\2"+
		"\2\2\u0141\u0142\7\61\2\2\u0142\u0143\79\2\2\u0143\u0145\5\34\17\2\u0144"+
		"\u0128\3\2\2\2\u0144\u012a\3\2\2\2\u0144\u0130\3\2\2\2\u0144\u0141\3\2"+
		"\2\2\u0145+\3\2\2\2\u0146\u0147\7!\2\2\u0147\u0148\5\34\17\2\u0148\u0149"+
		"\7\"\2\2\u0149\u014d\7\64\2\2\u014a\u014c\5$\23\2\u014b\u014a\3\2\2\2"+
		"\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0150"+
		"\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\7\65\2\2\u0151\u0152\5\36\20"+
		"\2\u0152-\3\2\2\2\u0153\u0154\7*\2\2\u0154\u0155\7\b\2\2\u0155\u0156\5"+
		"&\24\2\u0156\u0157\7\t\2\2\u0157\u015a\5\"\22\2\u0158\u0159\7+\2\2\u0159"+
		"\u015b\5\"\22\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b/\3\2\2\2"+
		"\u015c\u015d\7-\2\2\u015d\u015e\7\b\2\2\u015e\u015f\5&\24\2\u015f\u0160"+
		"\7\t\2\2\u0160\u0161\5\"\22\2\u0161\u0171\3\2\2\2\u0162\u0163\7,\2\2\u0163"+
		"\u0164\7\b\2\2\u0164\u0165\5\62\32\2\u0165\u0167\7\3\2\2\u0166\u0168\5"+
		"&\24\2\u0167\u0166\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\u016b\7\3\2\2\u016a\u016c\5&\24\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d\u016e\7\t\2\2\u016e\u016f\5\"\22\2\u016f"+
		"\u0171\3\2\2\2\u0170\u015c\3\2\2\2\u0170\u0162\3\2\2\2\u0171\61\3\2\2"+
		"\2\u0172\u017e\5\20\t\2\u0173\u0178\5&\24\2\u0174\u0175\7\6\2\2\u0175"+
		"\u0177\5&\24\2\u0176\u0174\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2"+
		"\2\2\u0178\u0179\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017b"+
		"\u0173\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u0172\3\2"+
		"\2\2\u017d\u017b\3\2\2\2\u017e\63\3\2\2\2\u017f\u0181\7\60\2\2\u0180\u0182"+
		"\5&\24\2\u0181\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0186\3\2\2\2\u0183"+
		"\u0186\7.\2\2\u0184\u0186\7/\2\2\u0185\u017f\3\2\2\2\u0185\u0183\3\2\2"+
		"\2\u0185\u0184\3\2\2\2\u0186\65\3\2\2\2)9BPU^bglpy\u0081\u008a\u0093\u009f"+
		"\u00ad\u00b0\u00ba\u00bd\u00c5\u00cc\u00db\u00e9\u0116\u011c\u0121\u0123"+
		"\u0138\u013e\u0144\u014d\u015a\u0167\u016b\u0170\u0178\u017b\u017d\u0181"+
		"\u0185";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}