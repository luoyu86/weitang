package com.tom_roush.pdfbox.contentstream.operator.graphics;

import android.graphics.PointF;
import android.util.Log;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSNumber;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CurveToReplicateInitialPoint extends GraphicsOperatorProcessor {
    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public String getName() {
        return "v";
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
            PointF currentPoint = ((GraphicsOperatorProcessor) this).context.getCurrentPoint();
            PointF pointFTransformedPoint = ((GraphicsOperatorProcessor) this).context.transformedPoint(cOSNumber.floatValue(), cOSNumber2.floatValue());
            PointF pointFTransformedPoint2 = ((GraphicsOperatorProcessor) this).context.transformedPoint(cOSNumber3.floatValue(), cOSNumber4.floatValue());
            if (currentPoint != null) {
                ((GraphicsOperatorProcessor) this).context.curveTo(currentPoint.x, currentPoint.y, pointFTransformedPoint.x, pointFTransformedPoint.y, pointFTransformedPoint2.x, pointFTransformedPoint2.y);
                return;
            }
            Log.w("PdfBox-Android", "curveTo (" + pointFTransformedPoint2.x + "," + pointFTransformedPoint2.y + ") without initial MoveTo");
            ((GraphicsOperatorProcessor) this).context.moveTo(pointFTransformedPoint2.x, pointFTransformedPoint2.y);
        }
    }
}
