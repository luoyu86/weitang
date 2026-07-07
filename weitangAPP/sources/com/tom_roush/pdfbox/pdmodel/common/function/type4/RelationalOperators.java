package com.tom_roush.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public class RelationalOperators {

    public static abstract class AbstractNumberComparisonOperator implements Operator {
        private AbstractNumberComparisonOperator() {
        }

        public abstract boolean compare(Number number, Number number2);

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            stack.push(Boolean.valueOf(compare((Number) stack.pop(), (Number) stack.pop())));
        }
    }

    public static class Eq implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            stack.push(Boolean.valueOf(isEqual(stack.pop(), stack.pop())));
        }

        public boolean isEqual(Object obj, Object obj2) {
            return ((obj instanceof Number) && (obj2 instanceof Number)) ? ((Number) obj).floatValue() == ((Number) obj2).floatValue() : obj.equals(obj2);
        }
    }

    public static class Ge extends AbstractNumberComparisonOperator {
        public Ge() {
            super();
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.RelationalOperators.AbstractNumberComparisonOperator
        public boolean compare(Number number, Number number2) {
            return number.floatValue() >= number2.floatValue();
        }
    }

    public static class Gt extends AbstractNumberComparisonOperator {
        public Gt() {
            super();
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.RelationalOperators.AbstractNumberComparisonOperator
        public boolean compare(Number number, Number number2) {
            return number.floatValue() > number2.floatValue();
        }
    }

    public static class Le extends AbstractNumberComparisonOperator {
        public Le() {
            super();
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.RelationalOperators.AbstractNumberComparisonOperator
        public boolean compare(Number number, Number number2) {
            return number.floatValue() <= number2.floatValue();
        }
    }

    public static class Lt extends AbstractNumberComparisonOperator {
        public Lt() {
            super();
        }

        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.RelationalOperators.AbstractNumberComparisonOperator
        public boolean compare(Number number, Number number2) {
            return number.floatValue() < number2.floatValue();
        }
    }

    public static class Ne extends Eq {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.RelationalOperators.Eq
        public boolean isEqual(Object obj, Object obj2) {
            return !super.isEqual(obj, obj2);
        }
    }

    private RelationalOperators() {
    }
}
