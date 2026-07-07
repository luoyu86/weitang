package com.tom_roush.pdfbox.filter;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.vivo.identifier.IdentifierConstant;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Filter {
    public static final String SYSPROP_DEFLATELEVEL = "com.tom_roush.pdfbox.filter.deflatelevel";

    public static int getCompressionLevel() {
        int i2;
        try {
            i2 = Integer.parseInt(System.getProperty(SYSPROP_DEFLATELEVEL, IdentifierConstant.OAID_STATE_DEFAULT));
        } catch (NumberFormatException e2) {
            Log.w("PdfBox-Android", e2.getMessage(), e2);
            i2 = -1;
        }
        return Math.max(-1, Math.min(9, i2));
    }

    public abstract DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException;

    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2, DecodeOptions decodeOptions) throws IOException {
        return decode(inputStream, outputStream, cOSDictionary, i2);
    }

    public abstract void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException;

    public final void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException {
        encode(inputStream, outputStream, cOSDictionary.asUnmodifiableDictionary());
    }

    public COSDictionary getDecodeParams(COSDictionary cOSDictionary, int i2) {
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(COSName.F, COSName.FILTER);
        COSBase dictionaryObject2 = cOSDictionary.getDictionaryObject(COSName.DP, COSName.DECODE_PARMS);
        if ((dictionaryObject instanceof COSName) && (dictionaryObject2 instanceof COSDictionary)) {
            return (COSDictionary) dictionaryObject2;
        }
        boolean z = dictionaryObject instanceof COSArray;
        if (z && (dictionaryObject2 instanceof COSArray)) {
            COSArray cOSArray = (COSArray) dictionaryObject2;
            if (i2 < cOSArray.size() && (cOSArray.getObject(i2) instanceof COSDictionary)) {
                return (COSDictionary) cOSArray.getObject(i2);
            }
        } else if (dictionaryObject2 != null && !z && !(dictionaryObject2 instanceof COSArray)) {
            Log.e("PdfBox-Android", "Expected DecodeParams to be an Array or Dictionary but found " + dictionaryObject2.getClass().getName());
        }
        return new COSDictionary();
    }
}
