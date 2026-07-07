package com.tom_roush.pdfbox.pdmodel.common.function.type4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public class StackOperators {

    public static class Copy implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            int iIntValue = ((Number) stack.pop()).intValue();
            if (iIntValue > 0) {
                int size = stack.size();
                stack.addAll(new ArrayList(stack.subList(size - iIntValue, size)));
            }
        }
    }

    public static class Dup implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            stack.push(stack.peek());
        }
    }

    public static class Exch implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            Object objPop = stack.pop();
            Object objPop2 = stack.pop();
            stack.push(objPop);
            stack.push(objPop2);
        }
    }

    public static class Index implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            int iIntValue = ((Number) stack.pop()).intValue();
            if (iIntValue >= 0) {
                stack.push(stack.get((stack.size() - iIntValue) - 1));
                return;
            }
            throw new IllegalArgumentException("rangecheck: " + iIntValue);
        }
    }

    public static class Pop implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().pop();
        }
    }

    public static class Roll implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            int iIntValue = ((Number) stack.pop()).intValue();
            int iIntValue2 = ((Number) stack.pop()).intValue();
            if (iIntValue == 0) {
                return;
            }
            if (iIntValue2 < 0) {
                throw new IllegalArgumentException("rangecheck: " + iIntValue2);
            }
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            if (iIntValue < 0) {
                int i3 = iIntValue2 + iIntValue;
                while (i2 < i3) {
                    linkedList2.addFirst(stack.pop());
                    i2++;
                }
                while (iIntValue < 0) {
                    linkedList.addFirst(stack.pop());
                    iIntValue++;
                }
                stack.addAll(linkedList2);
                stack.addAll(linkedList);
                return;
            }
            int i4 = iIntValue2 - iIntValue;
            while (iIntValue > 0) {
                linkedList.addFirst(stack.pop());
                iIntValue--;
            }
            while (i2 < i4) {
                linkedList2.addFirst(stack.pop());
                i2++;
            }
            stack.addAll(linkedList);
            stack.addAll(linkedList2);
        }
    }

    private StackOperators() {
    }
}
