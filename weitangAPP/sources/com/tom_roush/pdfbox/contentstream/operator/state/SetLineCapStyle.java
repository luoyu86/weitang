package com.tom_roush.pdfbox.contentstream.operator.state;

import android.graphics.Paint;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSNumber;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SetLineCapStyle extends OperatorProcessor {
    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public String getName() {
        return OperatorName.SET_LINE_CAPSTYLE;
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (list.isEmpty()) {
            throw new MissingOperandException(operator, list);
        }
        int iIntValue = ((COSNumber) list.get(0)).intValue();
        this.context.getGraphicsState().setLineCap(iIntValue != 0 ? iIntValue != 1 ? iIntValue != 2 ? null : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT);
    }
}
