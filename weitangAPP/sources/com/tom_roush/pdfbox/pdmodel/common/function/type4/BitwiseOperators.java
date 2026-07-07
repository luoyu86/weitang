package com.tom_roush.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public class BitwiseOperators {

    public static abstract class AbstractLogicalOperator implements Operator {
        private AbstractLogicalOperator() {
        }

        public abstract boolean applyForBoolean(boolean z, boolean z2);

        public abstract int applyforInteger(int i2, int i3);

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            Object objPop = stack.pop();
            Object objPop2 = stack.pop();
            if ((objPop2 instanceof Boolean) && (objPop instanceof Boolean)) {
                stack.push(Boolean.valueOf(applyForBoolean(((Boolean) objPop2).booleanValue(), ((Boolean) objPop).booleanValue())));
            } else {
                if (!(objPop2 instanceof Integer) || !(objPop instanceof Integer)) {
                    throw new ClassCastException("Operands must be bool/bool or int/int");
                }
                stack.push(Integer.valueOf(applyforInteger(((Integer) objPop2).intValue(), ((Integer) objPop).intValue())));
            }
        }
    }

    public static class And extends AbstractLogicalOperator {
        public And() {
            super();
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.BitwiseOperators.AbstractLogicalOperator
        public boolean applyForBoolean(boolean z, boolean z2) {
            return z && z2;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.BitwiseOperators.AbstractLogicalOperator
        public int applyforInteger(int i2, int i3) {
            return i2 & i3;
        }
    }

    public static class Bitshift implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            int iIntValue = ((Integer) stack.pop()).intValue();
            int iIntValue2 = ((Integer) stack.pop()).intValue();
            if (iIntValue < 0) {
                stack.push(Integer.valueOf(iIntValue2 >> Math.abs(iIntValue)));
            } else {
                stack.push(Integer.valueOf(iIntValue2 << iIntValue));
            }
        }
    }

    public static class False implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Boolean.FALSE);
        }
    }

    public static class Not implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            Object objPop = stack.pop();
            if (objPop instanceof Boolean) {
                stack.push(Boolean.valueOf(!((Boolean) objPop).booleanValue()));
            } else {
                if (!(objPop instanceof Integer)) {
                    throw new ClassCastException("Operand must be bool or int");
                }
                stack.push(Integer.valueOf(-((Integer) objPop).intValue()));
            }
        }
    }

    public static class Or extends AbstractLogicalOperator {
        public Or() {
            super();
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.BitwiseOperators.AbstractLogicalOperator
        public boolean applyForBoolean(boolean z, boolean z2) {
            return z || z2;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.BitwiseOperators.AbstractLogicalOperator
        public int applyforInteger(int i2, int i3) {
            return i2 | i3;
        }
    }

    public static class True implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Boolean.TRUE);
        }
    }

    public static class Xor extends AbstractLogicalOperator {
        public Xor() {
            super();
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.BitwiseOperators.AbstractLogicalOperator
        public boolean applyForBoolean(boolean z, boolean z2) {
            return z ^ z2;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.BitwiseOperators.AbstractLogicalOperator
        public int applyforInteger(int i2, int i3) {
            return i2 ^ i3;
        }
    }

    private BitwiseOperators() {
    }
}
