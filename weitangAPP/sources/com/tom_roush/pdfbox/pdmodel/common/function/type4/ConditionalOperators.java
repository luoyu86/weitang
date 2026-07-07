package com.tom_roush.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public class ConditionalOperators {

    public static class If implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            InstructionSequence instructionSequence = (InstructionSequence) stack.pop();
            if (((Boolean) stack.pop()).booleanValue()) {
                instructionSequence.execute(executionContext);
            }
        }
    }

    public static class IfElse implements Operator {
        @Override // com.tom_roush.pdfbox.pdmodel.common.function.type4.Operator
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            InstructionSequence instructionSequence = (InstructionSequence) stack.pop();
            InstructionSequence instructionSequence2 = (InstructionSequence) stack.pop();
            if (((Boolean) stack.pop()).booleanValue()) {
                instructionSequence2.execute(executionContext);
            } else {
                instructionSequence.execute(executionContext);
            }
        }
    }

    private ConditionalOperators() {
    }
}
