package com.tom_roush.pdfbox.filter;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.util.Hex;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class ASCIIHexFilter extends Filter {
    private static final int[] REVERSE_HEX = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private boolean isEOD(int i2) {
        return i2 == 62;
    }

    private boolean isWhitespace(int i2) {
        return i2 == 0 || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32;
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException {
        int i3;
        while (true) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                break;
            }
            while (isWhitespace(i4)) {
                i4 = inputStream.read();
            }
            if (i4 == -1 || isEOD(i4)) {
                break;
            }
            int[] iArr = REVERSE_HEX;
            if (iArr[i4] == -1) {
                Log.e("PdfBox-Android", "Invalid hex, int: " + i4 + " char: " + ((char) i4));
            }
            i3 = iArr[i4] * 16;
            int i5 = inputStream.read();
            if (i5 == -1 || isEOD(i5)) {
                break;
            }
            if (i5 >= 0) {
                if (iArr[i5] == -1) {
                    Log.e("PdfBox-Android", "Invalid hex, int: " + i5 + " char: " + ((char) i5));
                }
                i3 += iArr[i5];
            }
            outputStream.write(i3);
        }
        outputStream.write(i3);
        outputStream.flush();
        return new DecodeResult(cOSDictionary);
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        while (true) {
            int i2 = inputStream.read();
            if (i2 == -1) {
                outputStream.flush();
                return;
            }
            Hex.writeHexByte((byte) i2, outputStream);
        }
    }
}
