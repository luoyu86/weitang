package com.tom_roush.pdfbox.contentstream.operator.graphics;

import android.graphics.PointF;
import com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSNumber;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CurveToReplicateFinalPoint extends GraphicsOperatorProcessor {
    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public String getName() {
        return OperatorName.CURVE_TO_REPLICATE_FINAL_POINT;
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (list.size() < 4) {
            throw new MissingOperandException(operator, list);
        }
        if (checkArrayTypesClass(list, COSNumber.class)) {
            COSNumber cOSNumber = (COSNumber) list.get(0);
            COSNumber cOSNumber2 = (COSNumber) list.get(1);
            COSNumber cOSNumber3 = (COSNumber) list.get(2);
            COSNumber cOSNumber4 = (COSNumber) list.get(3);
            PointF pointFTransformedPoint = ((GraphicsOperatorProcessor) this).context.transformedPoint(cOSNumber.floatValue(), cOSNumber2.floatValue());
            PointF pointFTransformedPoint2 = ((GraphicsOperatorProcessor) this).context.transformedPoint(cOSNumber3.floatValue(), cOSNumber4.floatValue());
            PDFGraphicsStreamEngine pDFGraphicsStreamEngine = ((GraphicsOperatorProcessor) this).context;
            float f2 = pointFTransformedPoint.x;
            float f3 = pointFTransformedPoint.y;
            float f4 = pointFTransformedPoint2.x;
            float f5 = pointFTransformedPoint2.y;
            pDFGraphicsStreamEngine.curveTo(f2, f3, f4, f5, f4, f5);
        }
    }
}
