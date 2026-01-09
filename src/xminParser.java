// Generated from xmin.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class xminParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, ID=35, INT_LITERAL=36, STRING_LITERAL=37, 
		WS=38, COMMENT=39, LINE_COMMENT=40;
	public static final int
		RULE_prog = 0, RULE_structDecl = 1, RULE_structField = 2, RULE_function = 3, 
		RULE_paramList = 4, RULE_param = 5, RULE_expression = 6, RULE_letExpr = 7, 
		RULE_ifExpr = 8, RULE_blockExpr = 9, RULE_logicalOrExpr = 10, RULE_logicalAndExpr = 11, 
		RULE_equalityExpr = 12, RULE_relationalExpr = 13, RULE_additiveExpr = 14, 
		RULE_multiplicativeExpr = 15, RULE_unaryExpr = 16, RULE_postfixExpr = 17, 
		RULE_postfixPart = 18, RULE_primary = 19, RULE_argList = 20, RULE_literal = 21, 
		RULE_type = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "structDecl", "structField", "function", "paramList", "param", 
			"expression", "letExpr", "ifExpr", "blockExpr", "logicalOrExpr", "logicalAndExpr", 
			"equalityExpr", "relationalExpr", "additiveExpr", "multiplicativeExpr", 
			"unaryExpr", "postfixExpr", "postfixPart", "primary", "argList", "literal", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "';'", "'('", "')'", "'='", "','", "'let'", 
			"'in'", "'if'", "'then'", "'else'", "'||'", "'&&'", "'=='", "'!='", "'<'", 
			"'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'.'", 
			"'true'", "'false'", "'null'", "'int'", "'bool'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"INT_LITERAL", "STRING_LITERAL", "WS", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "xmin.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public xminParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(xminParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<StructDeclContext> structDecl() {
			return getRuleContexts(StructDeclContext.class);
		}
		public StructDeclContext structDecl(int i) {
			return getRuleContext(StructDeclContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509442L) != 0)) {
				{
				setState(48);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__31:
				case T__32:
				case T__33:
				case ID:
					{
					setState(46);
					function();
					}
					break;
				case T__0:
					{
					setState(47);
					structDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(xminParser.ID, 0); }
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public StructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterStructDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitStructDecl(this);
		}
	}

	public final StructDeclContext structDecl() throws RecognitionException {
		StructDeclContext _localctx = new StructDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_structDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__0);
			setState(56);
			match(ID);
			setState(57);
			match(T__1);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) {
				{
				{
				setState(58);
				structField();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(T__2);
			setState(65);
			match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructFieldContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(xminParser.ID, 0); }
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterStructField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitStructField(this);
		}
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_structField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			type();
			setState(68);
			match(ID);
			setState(69);
			match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(xminParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			type();
			setState(72);
			match(ID);
			setState(73);
			match(T__4);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) {
				{
				setState(74);
				paramList();
				}
			}

			setState(77);
			match(T__5);
			setState(78);
			match(T__6);
			setState(79);
			expression();
			setState(80);
			match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitParamList(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			param();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(83);
				match(T__7);
				setState(84);
				param();
				}
				}
				setState(89);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(xminParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			type();
			setState(91);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LetExprContext letExpr() {
			return getRuleContext(LetExprContext.class,0);
		}
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public BlockExprContext blockExpr() {
			return getRuleContext(BlockExprContext.class,0);
		}
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				letExpr();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				ifExpr();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				blockExpr();
				}
				break;
			case T__4:
			case T__22:
			case T__26:
			case T__28:
			case T__29:
			case T__30:
			case ID:
			case INT_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				logicalOrExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LetExprContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(xminParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LetExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitLetExpr(this);
		}
	}

	public final LetExprContext letExpr() throws RecognitionException {
		LetExprContext _localctx = new LetExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_letExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__8);
			setState(100);
			type();
			setState(101);
			match(ID);
			setState(102);
			match(T__6);
			setState(103);
			expression();
			setState(104);
			match(T__9);
			setState(105);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfExprContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitIfExpr(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__10);
			setState(108);
			expression();
			setState(109);
			match(T__11);
			setState(110);
			expression();
			setState(111);
			match(T__12);
			setState(112);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockExprContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BlockExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterBlockExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitBlockExpr(this);
		}
	}

	public final BlockExprContext blockExpr() throws RecognitionException {
		BlockExprContext _localctx = new BlockExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blockExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__1);
			setState(115);
			expression();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(116);
				match(T__3);
				setState(117);
				expression();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExprContext extends ParserRuleContext {
		public List<LogicalAndExprContext> logicalAndExpr() {
			return getRuleContexts(LogicalAndExprContext.class);
		}
		public LogicalAndExprContext logicalAndExpr(int i) {
			return getRuleContext(LogicalAndExprContext.class,i);
		}
		public LogicalOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterLogicalOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitLogicalOrExpr(this);
		}
	}

	public final LogicalOrExprContext logicalOrExpr() throws RecognitionException {
		LogicalOrExprContext _localctx = new LogicalOrExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_logicalOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			logicalAndExpr();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(126);
				match(T__13);
				setState(127);
				logicalAndExpr();
				}
				}
				setState(132);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExprContext extends ParserRuleContext {
		public List<EqualityExprContext> equalityExpr() {
			return getRuleContexts(EqualityExprContext.class);
		}
		public EqualityExprContext equalityExpr(int i) {
			return getRuleContext(EqualityExprContext.class,i);
		}
		public LogicalAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterLogicalAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitLogicalAndExpr(this);
		}
	}

	public final LogicalAndExprContext logicalAndExpr() throws RecognitionException {
		LogicalAndExprContext _localctx = new LogicalAndExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_logicalAndExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			equalityExpr();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(134);
				match(T__14);
				setState(135);
				equalityExpr();
				}
				}
				setState(140);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ParserRuleContext {
		public List<RelationalExprContext> relationalExpr() {
			return getRuleContexts(RelationalExprContext.class);
		}
		public RelationalExprContext relationalExpr(int i) {
			return getRuleContext(RelationalExprContext.class,i);
		}
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitEqualityExpr(this);
		}
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_equalityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			relationalExpr();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15 || _la==T__16) {
				{
				{
				setState(142);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(143);
				relationalExpr();
				}
				}
				setState(148);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ParserRuleContext {
		public List<AdditiveExprContext> additiveExpr() {
			return getRuleContexts(AdditiveExprContext.class);
		}
		public AdditiveExprContext additiveExpr(int i) {
			return getRuleContext(AdditiveExprContext.class,i);
		}
		public RelationalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitRelationalExpr(this);
		}
	}

	public final RelationalExprContext relationalExpr() throws RecognitionException {
		RelationalExprContext _localctx = new RelationalExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_relationalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			additiveExpr();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3932160L) != 0)) {
				{
				{
				setState(150);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3932160L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				additiveExpr();
				}
				}
				setState(156);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ParserRuleContext {
		public List<MultiplicativeExprContext> multiplicativeExpr() {
			return getRuleContexts(MultiplicativeExprContext.class);
		}
		public MultiplicativeExprContext multiplicativeExpr(int i) {
			return getRuleContext(MultiplicativeExprContext.class,i);
		}
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitAdditiveExpr(this);
		}
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_additiveExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			multiplicativeExpr();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21 || _la==T__22) {
				{
				{
				setState(158);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(159);
				multiplicativeExpr();
				}
				}
				setState(164);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public MultiplicativeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterMultiplicativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitMultiplicativeExpr(this);
		}
	}

	public final MultiplicativeExprContext multiplicativeExpr() throws RecognitionException {
		MultiplicativeExprContext _localctx = new MultiplicativeExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multiplicativeExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			unaryExpr();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 117440512L) != 0)) {
				{
				{
				setState(166);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 117440512L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(167);
				unaryExpr();
				}
				}
				setState(172);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitUnaryExpr(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unaryExpr);
		int _la;
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__26) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(174);
				unaryExpr();
				}
				break;
			case T__4:
			case T__28:
			case T__29:
			case T__30:
			case ID:
			case INT_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				postfixExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExprContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<PostfixPartContext> postfixPart() {
			return getRuleContexts(PostfixPartContext.class);
		}
		public PostfixPartContext postfixPart(int i) {
			return getRuleContext(PostfixPartContext.class,i);
		}
		public PostfixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterPostfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitPostfixExpr(this);
		}
	}

	public final PostfixExprContext postfixExpr() throws RecognitionException {
		PostfixExprContext _localctx = new PostfixExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_postfixExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			primary();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==T__27) {
				{
				{
				setState(179);
				postfixPart();
				}
				}
				setState(184);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixPartContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode ID() { return getToken(xminParser.ID, 0); }
		public PostfixPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterPostfixPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitPostfixPart(this);
		}
	}

	public final PostfixPartContext postfixPart() throws RecognitionException {
		PostfixPartContext _localctx = new PostfixPartContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_postfixPart);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(T__4);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 244418873892L) != 0)) {
					{
					setState(186);
					argList();
					}
				}

				setState(189);
				match(T__5);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(T__27);
				setState(191);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ID() { return getToken(xminParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_primary);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
			case T__29:
			case T__30:
			case INT_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				literal();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(ID);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(T__4);
				setState(197);
				expression();
				setState(198);
				match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitArgList(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			expression();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(203);
				match(T__7);
				setState(204);
				expression();
				}
				}
				setState(209);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(xminParser.INT_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(xminParser.STRING_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 209916526592L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(xminParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof xminListener ) ((xminListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001(\u00d7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0005\u00001\b\u0000"+
		"\n\u0000\f\u00004\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001<\b\u0001\n\u0001\f\u0001?\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"L\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004V\b\u0004\n\u0004\f\u0004"+
		"Y\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006b\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\tw\b\t\n\t\f\tz\t\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u0081\b\n\n\n\f\n\u0084\t\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u0089\b\u000b\n\u000b\f\u000b\u008c\t\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u0091\b\f\n\f\f\f\u0094\t\f\u0001\r\u0001\r"+
		"\u0001\r\u0005\r\u0099\b\r\n\r\f\r\u009c\t\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00a1\b\u000e\n\u000e\f\u000e\u00a4\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u00a9\b\u000f\n\u000f\f\u000f\u00ac"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00b1\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u00b5\b\u0011\n\u0011\f\u0011\u00b8"+
		"\t\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u00bc\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00c1\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00c9\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00ce\b\u0014\n\u0014"+
		"\f\u0014\u00d1\t\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0007\u0001\u0000"+
		"\u0010\u0011\u0001\u0000\u0012\u0015\u0001\u0000\u0016\u0017\u0001\u0000"+
		"\u0018\u001a\u0002\u0000\u0017\u0017\u001b\u001b\u0002\u0000\u001d\u001f"+
		"$%\u0001\u0000 #\u00d5\u00002\u0001\u0000\u0000\u0000\u00027\u0001\u0000"+
		"\u0000\u0000\u0004C\u0001\u0000\u0000\u0000\u0006G\u0001\u0000\u0000\u0000"+
		"\bR\u0001\u0000\u0000\u0000\nZ\u0001\u0000\u0000\u0000\fa\u0001\u0000"+
		"\u0000\u0000\u000ec\u0001\u0000\u0000\u0000\u0010k\u0001\u0000\u0000\u0000"+
		"\u0012r\u0001\u0000\u0000\u0000\u0014}\u0001\u0000\u0000\u0000\u0016\u0085"+
		"\u0001\u0000\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a\u0095"+
		"\u0001\u0000\u0000\u0000\u001c\u009d\u0001\u0000\u0000\u0000\u001e\u00a5"+
		"\u0001\u0000\u0000\u0000 \u00b0\u0001\u0000\u0000\u0000\"\u00b2\u0001"+
		"\u0000\u0000\u0000$\u00c0\u0001\u0000\u0000\u0000&\u00c8\u0001\u0000\u0000"+
		"\u0000(\u00ca\u0001\u0000\u0000\u0000*\u00d2\u0001\u0000\u0000\u0000,"+
		"\u00d4\u0001\u0000\u0000\u0000.1\u0003\u0006\u0003\u0000/1\u0003\u0002"+
		"\u0001\u00000.\u0001\u0000\u0000\u00000/\u0001\u0000\u0000\u000014\u0001"+
		"\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"35\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000056\u0005\u0000\u0000"+
		"\u00016\u0001\u0001\u0000\u0000\u000078\u0005\u0001\u0000\u000089\u0005"+
		"#\u0000\u00009=\u0005\u0002\u0000\u0000:<\u0003\u0004\u0002\u0000;:\u0001"+
		"\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"+
		"\u0000@A\u0005\u0003\u0000\u0000AB\u0005\u0004\u0000\u0000B\u0003\u0001"+
		"\u0000\u0000\u0000CD\u0003,\u0016\u0000DE\u0005#\u0000\u0000EF\u0005\u0004"+
		"\u0000\u0000F\u0005\u0001\u0000\u0000\u0000GH\u0003,\u0016\u0000HI\u0005"+
		"#\u0000\u0000IK\u0005\u0005\u0000\u0000JL\u0003\b\u0004\u0000KJ\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0005\u0006\u0000\u0000NO\u0005\u0007\u0000\u0000OP\u0003\f\u0006\u0000"+
		"PQ\u0005\u0004\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000RW\u0003\n\u0005"+
		"\u0000ST\u0005\b\u0000\u0000TV\u0003\n\u0005\u0000US\u0001\u0000\u0000"+
		"\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000X\t\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0003"+
		",\u0016\u0000[\\\u0005#\u0000\u0000\\\u000b\u0001\u0000\u0000\u0000]b"+
		"\u0003\u000e\u0007\u0000^b\u0003\u0010\b\u0000_b\u0003\u0012\t\u0000`"+
		"b\u0003\u0014\n\u0000a]\u0001\u0000\u0000\u0000a^\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000b\r\u0001\u0000\u0000"+
		"\u0000cd\u0005\t\u0000\u0000de\u0003,\u0016\u0000ef\u0005#\u0000\u0000"+
		"fg\u0005\u0007\u0000\u0000gh\u0003\f\u0006\u0000hi\u0005\n\u0000\u0000"+
		"ij\u0003\f\u0006\u0000j\u000f\u0001\u0000\u0000\u0000kl\u0005\u000b\u0000"+
		"\u0000lm\u0003\f\u0006\u0000mn\u0005\f\u0000\u0000no\u0003\f\u0006\u0000"+
		"op\u0005\r\u0000\u0000pq\u0003\f\u0006\u0000q\u0011\u0001\u0000\u0000"+
		"\u0000rs\u0005\u0002\u0000\u0000sx\u0003\f\u0006\u0000tu\u0005\u0004\u0000"+
		"\u0000uw\u0003\f\u0006\u0000vt\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000{|\u0005\u0003\u0000\u0000|\u0013"+
		"\u0001\u0000\u0000\u0000}\u0082\u0003\u0016\u000b\u0000~\u007f\u0005\u000e"+
		"\u0000\u0000\u007f\u0081\u0003\u0016\u000b\u0000\u0080~\u0001\u0000\u0000"+
		"\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0015\u0001\u0000\u0000"+
		"\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u008a\u0003\u0018\f\u0000"+
		"\u0086\u0087\u0005\u000f\u0000\u0000\u0087\u0089\u0003\u0018\f\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a"+
		"\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u0017\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d"+
		"\u0092\u0003\u001a\r\u0000\u008e\u008f\u0007\u0000\u0000\u0000\u008f\u0091"+
		"\u0003\u001a\r\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0094\u0001"+
		"\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u0019\u0001\u0000\u0000\u0000\u0094\u0092\u0001"+
		"\u0000\u0000\u0000\u0095\u009a\u0003\u001c\u000e\u0000\u0096\u0097\u0007"+
		"\u0001\u0000\u0000\u0097\u0099\u0003\u001c\u000e\u0000\u0098\u0096\u0001"+
		"\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u001b\u0001"+
		"\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a2\u0003"+
		"\u001e\u000f\u0000\u009e\u009f\u0007\u0002\u0000\u0000\u009f\u00a1\u0003"+
		"\u001e\u000f\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u001d\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a5\u00aa\u0003 \u0010\u0000\u00a6\u00a7\u0007\u0003"+
		"\u0000\u0000\u00a7\u00a9\u0003 \u0010\u0000\u00a8\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u001f\u0001\u0000\u0000"+
		"\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0007\u0004\u0000"+
		"\u0000\u00ae\u00b1\u0003 \u0010\u0000\u00af\u00b1\u0003\"\u0011\u0000"+
		"\u00b0\u00ad\u0001\u0000\u0000\u0000\u00b0\u00af\u0001\u0000\u0000\u0000"+
		"\u00b1!\u0001\u0000\u0000\u0000\u00b2\u00b6\u0003&\u0013\u0000\u00b3\u00b5"+
		"\u0003$\u0012\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b7#\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b9\u00bb\u0005\u0005\u0000\u0000\u00ba\u00bc\u0003(\u0014"+
		"\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00c1\u0005\u0006\u0000"+
		"\u0000\u00be\u00bf\u0005\u001c\u0000\u0000\u00bf\u00c1\u0005#\u0000\u0000"+
		"\u00c0\u00b9\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000"+
		"\u00c1%\u0001\u0000\u0000\u0000\u00c2\u00c9\u0003*\u0015\u0000\u00c3\u00c9"+
		"\u0005#\u0000\u0000\u00c4\u00c5\u0005\u0005\u0000\u0000\u00c5\u00c6\u0003"+
		"\f\u0006\u0000\u00c6\u00c7\u0005\u0006\u0000\u0000\u00c7\u00c9\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c2\u0001\u0000\u0000\u0000\u00c8\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c4\u0001\u0000\u0000\u0000\u00c9\'\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cf\u0003\f\u0006\u0000\u00cb\u00cc\u0005\b\u0000\u0000"+
		"\u00cc\u00ce\u0003\f\u0006\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0)\u0001\u0000\u0000\u0000\u00d1\u00cf"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0007\u0005\u0000\u0000\u00d3+\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0007\u0006\u0000\u0000\u00d5-\u0001\u0000"+
		"\u0000\u0000\u001302=KWax\u0082\u008a\u0092\u009a\u00a2\u00aa\u00b0\u00b6"+
		"\u00bb\u00c0\u00c8\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}