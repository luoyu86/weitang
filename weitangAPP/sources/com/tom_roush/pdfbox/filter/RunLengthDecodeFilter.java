package com.tom_roush.pdfbox.filter;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSDictionary;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class RunLengthDecodeFilter extends Filter {
    private static final int RUN_LENGTH_EOD = 128;

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException {
        byte[] bArr = new byte[128];
        while (true) {
            int i3 = inputStream.read();
            if (i3 == -1 || i3 == 128) {
                break;
            }
            if (i3 <= 127) {
                int i4 = i3 + 1;
                while (i4 > 0) {
                    int i5 = inputStream.read(bArr, 0, i4);
                    if (i5 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, i5);
                    i4 -= i5;
                }
            } else {
                int i6 = inputStream.read();
                if (i6 == -1) {
                    break;
                }
                for (int i7 = 0; i7 < 257 - i3; i7++) {
                    outputStream.write(i6);
                }
            }
        }
        return new DecodeResult(cOSDictionary);
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        Log.w("PdfBox-Android", "RunLengthDecodeFilter.encode is not implemented yet, skipping this stream.");
    }
}
