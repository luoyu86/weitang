package com.tom_roush.pdfbox.pdmodel.common.function.type4;

import com.tom_roush.pdfbox.pdmodel.common.function.type4.ArithmeticOperators;
import com.tom_roush.pdfbox.pdmodel.common.function.type4.BitwiseOperators;
import com.tom_roush.pdfbox.pdmodel.common.function.type4.ConditionalOperators;
import com.tom_roush.pdfbox.pdmodel.common.function.type4.RelationalOperators;
import com.tom_roush.pdfbox.pdmodel.common.function.type4.StackOperators;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Operators {
    private final Map<String, Operator> operators;
    private static final Operator ABS = new ArithmeticOperators.Abs();
    private static final Operator ADD = new ArithmeticOperators.Add();
    private static final Operator ATAN = new ArithmeticOperators.Atan();
    private static final Operator CEILING = new ArithmeticOperators.Ceiling();
    private static final Operator COS = new ArithmeticOperators.Cos();
    private static final Operator CVI = new ArithmeticOperators.Cvi();
    private static final Operator CVR = new ArithmeticOperators.Cvr();
    private static final Operator DIV = new ArithmeticOperators.Div();
    private static final Operator EXP = new ArithmeticOperators.Exp();
    private static final Operator FLOOR = new ArithmeticOperators.Floor();
    private static final Operator IDIV = new ArithmeticOperators.IDiv();
    private static final Operator LN = new ArithmeticOperators.Ln();
    private static final Operator LOG = new ArithmeticOperators.Log();
    private static final Operator MOD = new ArithmeticOperators.Mod();
    private static final Operator MUL = new ArithmeticOperators.Mul();
    private static final Operator NEG = new ArithmeticOperators.Neg();
    private static final Operator ROUND = new ArithmeticOperators.Round();
    private static final Operator SIN = new ArithmeticOperators.Sin();
    private static final Operator SQRT = new ArithmeticOperators.Sqrt();
    private static final Operator SUB = new ArithmeticOperators.Sub();
    private static final Operator TRUNCATE = new ArithmeticOperators.Truncate();
    private static final Operator AND = new BitwiseOperators.And();
    private static final Operator BITSHIFT = new BitwiseOperators.Bitshift();
    private static final Operator EQ = new RelationalOperators.Eq();
    private static final Operator FALSE = new BitwiseOperators.False();
    private static final Operator GE = new RelationalOperators.Ge();
    private static final Operator GT = new RelationalOperators.Gt();
    private static final Operator LE = new RelationalOperators.Le();
    private static final Operator LT = new RelationalOperators.Lt();
    private static final Operator NE = new RelationalOperators.Ne();
    private static final Operator NOT = new BitwiseOperators.Not();
    private static final Operator OR = new BitwiseOperators.Or();
    private static final Operator TRUE = new BitwiseOperators.True();
    private static final Operator XOR = new BitwiseOperators.Xor();
    private static final Operator IF = new ConditionalOperators.If();
    private static final Operator IFELSE = new ConditionalOperators.IfElse();
    private static final Operator COPY = new StackOperators.Copy();
    private static final Operator DUP = new StackOperators.Dup();
    private static final Operator EXCH = new StackOperators.Exch();
    private static final Operator INDEX = new StackOperators.Index();
    private static final Operator POP = new StackOperators.Pop();
    private static final Operator ROLL = new StackOperators.Roll();

    public Operators() {
        HashMap map = new HashMap();
        this.operators = map;
        map.put("add", ADD);
        map.put("abs", ABS);
        map.put("atan", ATAN);
        map.put("ceiling", CEILING);
        map.put("cos", COS);
        map.put("cvi", CVI);
        map.put("cvr", CVR);
        map.put("div", DIV);
        map.put("exp", EXP);
        map.put("floor", FLOOR);
        map.put("idiv", IDIV);
        map.put("ln", LN);
        map.put("log", LOG);
        map.put("mod", MOD);
        map.put("mul", MUL);
        map.put("neg", NEG);
        map.put("round", ROUND);
        map.put("sin", SIN);
        map.put("sqrt", SQRT);
        map.put("sub", SUB);
        map.put("truncate", TRUNCATE);
        map.put("and", AND);
        map.put("bitshift", BITSHIFT);
        map.put("eq", EQ);
        map.put("false", FALSE);
        map.put("ge", GE);
        map.put("gt", GT);
        map.put("le", LE);
        map.put("lt", LT);
        map.put("ne", NE);
        map.put("not", NOT);
        map.put("or", OR);
        map.put("true", TRUE);
        map.put("xor", XOR);
        map.put("if", IF);
        map.put("ifelse", IFELSE);
        map.put("copy", COPY);
        map.put("dup", DUP);
        map.put("exch", EXCH);
        map.put("index", INDEX);
        map.put("pop", POP);
        map.put("roll", ROLL);
    }

    public Operator getOperator(String str) {
        return this.operators.get(str);
    }
}
