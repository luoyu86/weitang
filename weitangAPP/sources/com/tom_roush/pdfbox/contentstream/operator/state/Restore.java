package com.tom_roush.pdfbox.contentstream.operator.state;

import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor;
import com.tom_roush.pdfbox.cos.COSBase;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Restore extends OperatorProcessor {
    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public String getName() {
        return OperatorName.RESTORE;
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.OperatorProcessor
    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (this.context.getGraphicsStackSize() <= 1) {
            throw new EmptyGraphicsStackException();
        }
        this.context.restoreGraphicsState();
    }
}
