package com.tom_roush.pdfbox.pdmodel.common.function;

import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSFloat;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDFunctionType2 extends PDFunction {
    private final COSArray c0;
    private final COSArray c1;
    private final float exponent;

    public PDFunctionType2(COSBase cOSBase) {
        super(cOSBase);
        COSArray cOSArray = getCOSObject().getCOSArray(COSName.C0);
        if (cOSArray != null) {
            this.c0 = cOSArray;
        } else {
            this.c0 = new COSArray();
        }
        if (this.c0.size() == 0) {
            this.c0.add((COSBase) new COSFloat(0.0f));
        }
        COSArray cOSArray2 = getCOSObject().getCOSArray(COSName.C1);
        if (cOSArray2 != null) {
            this.c1 = cOSArray2;
        } else {
            this.c1 = new COSArray();
        }
        if (this.c1.size() == 0) {
            this.c1.add((COSBase) new COSFloat(1.0f));
        }
        this.exponent = getCOSObject().getFloat(COSName.N);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public float[] eval(float[] fArr) throws IOException {
        float fPow = (float) Math.pow(fArr[0], this.exponent);
        int iMin = Math.min(this.c0.size(), this.c1.size());
        float[] fArr2 = new float[iMin];
        for (int i2 = 0; i2 < iMin; i2++) {
            float fFloatValue = ((COSNumber) this.c0.get(i2)).floatValue();
            fArr2[i2] = fFloatValue + ((((COSNumber) this.c1.get(i2)).floatValue() - fFloatValue) * fPow);
        }
        return clipToRange(fArr2);
    }

    public COSArray getC0() {
        return this.c0;
    }

    public COSArray getC1() {
        return this.c1;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public int getFunctionType() {
        return 2;
    }

    public float getN() {
        return this.exponent;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public String toString() {
        return "FunctionType2{C0: " + getC0() + " C1: " + getC1() + " N: " + getN() + i.f5699d;
    }
}
