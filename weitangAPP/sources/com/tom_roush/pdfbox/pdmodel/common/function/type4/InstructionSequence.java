package com.tom_roush.pdfbox.pdmodel.common.function.type4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public class InstructionSequence {
    private final List<Object> instructions = new ArrayList();

    public void addBoolean(boolean z) {
        this.instructions.add(Boolean.valueOf(z));
    }

    public void addInteger(int i2) {
        this.instructions.add(Integer.valueOf(i2));
    }

    public void addName(String str) {
        this.instructions.add(str);
    }

    public void addProc(InstructionSequence instructionSequence) {
        this.instructions.add(instructionSequence);
    }

    public void addReal(float f2) {
        this.instructions.add(Float.valueOf(f2));
    }

    public void execute(ExecutionContext executionContext) {
        Stack<Object> stack = executionContext.getStack();
        for (Object obj : this.instructions) {
            if (obj instanceof String) {
                String str = (String) obj;
                Operator operator = executionContext.getOperators().getOperator(str);
                if (operator == null) {
                    throw new UnsupportedOperationException("Unknown operator or name: " + str);
                }
                operator.execute(executionContext);
            } else {
                stack.push(obj);
            }
        }
        while (!stack.isEmpty() && (stack.peek() instanceof InstructionSequence)) {
            ((InstructionSequence) stack.pop()).execute(executionContext);
        }
    }
}
