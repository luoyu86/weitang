package com.tom_roush.pdfbox.pdmodel.graphics;

import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class PDLineDashPattern implements COSObjectable {
    private final float[] array;
    private final int phase;

    public PDLineDashPattern() {
        this.array = new float[0];
        this.phase = 0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSBase getCOSObject() {
        COSArray cOSArray = new COSArray();
        COSArray cOSArray2 = new COSArray();
        cOSArray2.setFloatArray(this.array);
        cOSArray.add((COSBase) cOSArray2);
        cOSArray.add((COSBase) COSInteger.get(this.phase));
        return cOSArray;
    }

    public float[] getDashArray() {
        return (float[]) this.array.clone();
    }

    public int getPhase() {
        return this.phase;
    }

    public String toString() {
        return "PDLineDashPattern{array=" + Arrays.toString(this.array) + ", phase=" + this.phase + i.f5699d;
    }

    public PDLineDashPattern(COSArray cOSArray, int i2) {
        this.array = cOSArray.toFloatArray();
        this.phase = i2;
    }
}
