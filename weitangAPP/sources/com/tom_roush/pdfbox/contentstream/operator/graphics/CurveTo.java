package com.tom_roush.pdfbox.contentstream.operator.graphics;

import android.graphics.PointF;
import android.util.Log;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSNumber;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CurveTo extends GraphicsOperatorProcessor {
    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public String getName() {
        return OperatorName.CURVE_TO;
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (list.size() < 6) {
            throw new MissingOperandException(operator, list);
        }
        if (checkArrayTypesClass(list, COSNumber.class)) {
            COSNumber cOSNumber = (COSNumber) list.get(0);
            COSNumber cOSNumber2 = (COSNumber) list.get(1);
            COSNumber cOSNumber3 = (COSNumber) list.get(2);
            COSNumber cOSNumber4 = (COSNumber) list.get(3);
            COSNumber cOSNumber5 = (COSNumber) list.get(4);
            COSNumber cOSNumber6 = (COSNumber) list.get(5);
            PointF pointFTransformedPoint = ((GraphicsOperatorProcessor) this).context.transformedPoint(cOSNumber.floatValue(), cOSNumber2.floatValue());
            PointF pointFTransformedPoint2 = ((GraphicsOperatorProcessor) this).context.transformedPoint(cOSNumber3.floatValue(), cOSNumber4.floatValue());
            PointF pointFTransformedPoint3 = ((GraphicsOperatorProcessor) this).context.transformedPoint(cOSNumber5.floatValue(), cOSNumber6.floatValue());
            if (((GraphicsOperatorProcessor) this).context.getCurrentPoint() != null) {
                ((GraphicsOperatorProcessor) this).context.curveTo(pointFTransformedPoint.x, pointFTransformedPoint.y, pointFTransformedPoint2.x, pointFTransformedPoint2.y, pointFTransformedPoint3.x, pointFTransformedPoint3.y);
                return;
            }
            Log.w("PdfBox-Android", "curveTo (" + pointFTransformedPoint3.x + "," + pointFTransformedPoint3.y + ") without initial MoveTo");
            ((GraphicsOperatorProcessor) this).context.moveTo(pointFTransformedPoint3.x, pointFTransformedPoint3.y);
        }
    }
}
