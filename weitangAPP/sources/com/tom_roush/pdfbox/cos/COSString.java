package com.tom_roush.pdfbox.cos;

import android.util.Log;
import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.util.Charsets;
import com.tom_roush.pdfbox.util.Hex;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class COSString extends COSBase {
    public static final boolean FORCE_PARSING = Boolean.getBoolean("com.tom_roush.pdfbox.forceParsing");
    private byte[] bytes;
    private boolean forceHexForm;

    public COSString(byte[] bArr) {
        setValue(bArr);
    }

    public static COSString parseHex(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder(str.trim());
        if (sb.length() % 2 != 0) {
            sb.append('0');
        }
        int length = sb.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 2;
            try {
                byteArrayOutputStream.write(Integer.parseInt(sb.substring(i2, i3), 16));
            } catch (NumberFormatException e2) {
                if (!FORCE_PARSING) {
                    throw new IOException("Invalid hex string: " + str, e2);
                }
                Log.w("PdfBox-Android", "Encountered a malformed hex string");
                byteArrayOutputStream.write(63);
            }
            i2 = i3;
        }
        return new COSString(byteArrayOutputStream.toByteArray());
    }

    @Override // com.tom_roush.pdfbox.cos.COSBase
    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromString(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof COSString)) {
            return false;
        }
        COSString cOSString = (COSString) obj;
        return getString().equals(cOSString.getString()) && this.forceHexForm == cOSString.forceHexForm;
    }

    public String getASCII() {
        return new String(this.bytes, Charsets.US_ASCII);
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public boolean getForceHexForm() {
        return this.forceHexForm;
    }

    public String getString() {
        byte[] bArr = this.bytes;
        if (bArr.length >= 2) {
            if ((bArr[0] & 255) == 254 && (bArr[1] & 255) == 255) {
                byte[] bArr2 = this.bytes;
                return new String(bArr2, 2, bArr2.length - 2, Charsets.UTF_16BE);
            }
            if ((bArr[0] & 255) == 255 && (bArr[1] & 255) == 254) {
                byte[] bArr3 = this.bytes;
                return new String(bArr3, 2, bArr3.length - 2, Charsets.UTF_16LE);
            }
        }
        return PDFDocEncoding.toString(bArr);
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes) + (this.forceHexForm ? 17 : 0);
    }

    public void setForceHexForm(boolean z) {
        this.forceHexForm = z;
    }

    public void setValue(byte[] bArr) {
        this.bytes = (byte[]) bArr.clone();
    }

    public String toHexString() {
        return Hex.getString(this.bytes);
    }

    public String toString() {
        return "COSString{" + getString() + i.f5699d;
    }

    public COSString(String str) {
        boolean z;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else {
                if (!PDFDocEncoding.containsChar(charArray[i2])) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        if (z) {
            this.bytes = PDFDocEncoding.getBytes(str);
            return;
        }
        byte[] bytes = str.getBytes(Charsets.UTF_16BE);
        byte[] bArr = new byte[bytes.length + 2];
        this.bytes = bArr;
        bArr[0] = -2;
        bArr[1] = -1;
        System.arraycopy(bytes, 0, bArr, 2, bytes.length);
    }
}
