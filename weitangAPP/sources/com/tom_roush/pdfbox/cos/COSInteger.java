package com.tom_roush.pdfbox.cos;

import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.u.i;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class COSInteger extends COSNumber {
    private static final int HIGH = 256;
    private static final int LOW = -100;
    private final boolean isValid;
    private final long value;
    private static final COSInteger[] STATIC = new COSInteger[357];
    public static final COSInteger ZERO = get(0);
    public static final COSInteger ONE = get(1);
    public static final COSInteger TWO = get(2);
    public static final COSInteger THREE = get(3);
    public static final COSInteger OUT_OF_RANGE_MAX = getInvalid(true);
    public static final COSInteger OUT_OF_RANGE_MIN = getInvalid(false);

    private COSInteger(long j, boolean z) {
        this.value = j;
        this.isValid = z;
    }

    public static COSInteger get(long j) {
        if (-100 > j || j > 256) {
            return new COSInteger(j, true);
        }
        int i2 = ((int) j) + 100;
        COSInteger[] cOSIntegerArr = STATIC;
        if (cOSIntegerArr[i2] == null) {
            cOSIntegerArr[i2] = new COSInteger(j, true);
        }
        return cOSIntegerArr[i2];
    }

    private static COSInteger getInvalid(boolean z) {
        return z ? new COSInteger(RecyclerView.FOREVER_NS, false) : new COSInteger(Long.MIN_VALUE, false);
    }

    @Override // com.tom_roush.pdfbox.cos.COSBase
    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromInt(this);
    }

    @Override // com.tom_roush.pdfbox.cos.COSNumber
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof COSInteger) && ((COSInteger) obj).intValue() == intValue();
    }

    @Override // com.tom_roush.pdfbox.cos.COSNumber
    public float floatValue() {
        return this.value;
    }

    public int hashCode() {
        long j = this.value;
        return (int) (j ^ (j >> 32));
    }

    @Override // com.tom_roush.pdfbox.cos.COSNumber
    public int intValue() {
        return (int) this.value;
    }

    public boolean isValid() {
        return this.isValid;
    }

    @Override // com.tom_roush.pdfbox.cos.COSNumber
    public long longValue() {
        return this.value;
    }

    public String toString() {
        return "COSInt{" + this.value + i.f5699d;
    }

    public void writePDF(OutputStream outputStream) throws IOException {
        outputStream.write(String.valueOf(this.value).getBytes("ISO-8859-1"));
    }
}
