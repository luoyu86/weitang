package com.tom_roush.pdfbox.contentstream.operator.graphics;

import android.util.Log;
import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSBase;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ClosePath extends GraphicsOperatorProcessor {
    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public String getName() {
        return OperatorName.CLOSE_PATH;
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (((GraphicsOperatorProcessor) this).context.getCurrentPoint() == null) {
            Log.w("PdfBox-Android", "ClosePath without initial MoveTo");
        } else {
            ((GraphicsOperatorProcessor) this).context.closePath();
        }
    }
}
