package com.tom_roush.pdfbox.filter;

import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class DCTFilter extends Filter {
    private static final String ADOBE = "Adobe";
    private static final int POS_TRANSFORM = 11;

    private int clamp(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 255.0f) {
            f2 = 255.0f;
        }
        return (int) f2;
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2, DecodeOptions decodeOptions) throws IOException {
        IOUtils.copy(inputStream, outputStream);
        return new DecodeResult(cOSDictionary);
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        throw new UnsupportedOperationException("DCTFilter encoding not implemented, use the JPEGFactory methods instead");
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException {
        return decode(inputStream, outputStream, cOSDictionary, i2, DecodeOptions.DEFAULT);
    }
}
