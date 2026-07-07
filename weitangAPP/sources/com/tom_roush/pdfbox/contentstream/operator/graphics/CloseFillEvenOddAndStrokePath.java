package com.tom_roush.pdfbox.contentstream.operator.graphics;

import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSBase;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CloseFillEvenOddAndStrokePath extends GraphicsOperatorProcessor {
    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public String getName() {
        return OperatorName.CLOSE_FILL_EVEN_ODD_AND_STROKE;
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public void process(Operator operator, List<COSBase> list) throws IOException {
        ((GraphicsOperatorProcessor) this).context.processOperator(OperatorName.CLOSE_PATH, list);
        ((GraphicsOperatorProcessor) this).context.processOperator(OperatorName.FILL_EVEN_ODD_AND_STROKE, list);
    }
}
