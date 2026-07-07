package com.tom_roush.pdfbox.pdmodel.common.function;

import com.tom_roush.pdfbox.cos.COSBase;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDFunctionTypeIdentity extends PDFunction {
    public PDFunctionTypeIdentity(COSBase cOSBase) {
        super(null);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public float[] eval(float[] fArr) throws IOException {
        return fArr;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public int getFunctionType() {
        throw new UnsupportedOperationException();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public String toString() {
        return "FunctionTypeIdentity";
    }
}
