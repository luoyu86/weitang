package com.tom_roush.pdfbox.pdmodel.common.function;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.pdmodel.common.PDRange;
import com.tom_roush.pdfbox.pdmodel.common.function.type4.ExecutionContext;
import com.tom_roush.pdfbox.pdmodel.common.function.type4.InstructionSequence;
import com.tom_roush.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder;
import com.tom_roush.pdfbox.pdmodel.common.function.type4.Operators;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDFunctionType4 extends PDFunction {
    private static final Operators OPERATORS = new Operators();
    private final InstructionSequence instructions;

    public PDFunctionType4(COSBase cOSBase) throws IOException {
        super(cOSBase);
        this.instructions = InstructionSequenceBuilder.parse(new String(getPDStream().toByteArray(), "ISO-8859-1"));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public float[] eval(float[] fArr) throws IOException {
        ExecutionContext executionContext = new ExecutionContext(OPERATORS);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            PDRange domainForInput = getDomainForInput(i2);
            executionContext.getStack().push(Float.valueOf(clipToRange(fArr[i2], domainForInput.getMin(), domainForInput.getMax())));
        }
        this.instructions.execute(executionContext);
        int numberOfOutputParameters = getNumberOfOutputParameters();
        int size = executionContext.getStack().size();
        if (size < numberOfOutputParameters) {
            throw new IllegalStateException("The type 4 function returned " + size + " values but the Range entry indicates that " + numberOfOutputParameters + " values be returned.");
        }
        float[] fArr2 = new float[numberOfOutputParameters];
        for (int i3 = numberOfOutputParameters - 1; i3 >= 0; i3--) {
            PDRange rangeForOutput = getRangeForOutput(i3);
            fArr2[i3] = executionContext.popReal();
            fArr2[i3] = clipToRange(fArr2[i3], rangeForOutput.getMin(), rangeForOutput.getMax());
        }
        return fArr2;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public int getFunctionType() {
        return 4;
    }
}
