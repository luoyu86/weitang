package com.tom_roush.pdfbox.filter;

import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.io.IOUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class CCITTFaxFilter extends Filter {
    private void invertBitmap(byte[] bArr) {
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) ((~bArr[i2]) & 255);
        }
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException {
        long j;
        InputStream inputStream2;
        COSDictionary decodeParams = getDecodeParams(cOSDictionary, i2);
        int i3 = decodeParams.getInt(COSName.COLUMNS, 1728);
        int i4 = decodeParams.getInt(COSName.ROWS, 0);
        int iMax = cOSDictionary.getInt(COSName.HEIGHT, COSName.H, 0);
        if (i4 <= 0 || iMax <= 0) {
            iMax = Math.max(i4, iMax);
        }
        int i5 = decodeParams.getInt(COSName.K, 0);
        boolean z = decodeParams.getBoolean(COSName.ENCODED_BYTE_ALIGN, false);
        byte[] bArr = new byte[((i3 + 7) / 8) * iMax];
        int i6 = 4;
        int i7 = 3;
        if (i5 == 0) {
            byte[] bArr2 = new byte[20];
            if (inputStream.read(bArr2) != 20) {
                throw new EOFException("Can't read 20 bytes");
            }
            PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 20);
            pushbackInputStream.unread(bArr2);
            if (bArr2[0] != 0 || ((bArr2[1] >> 4) != 1 && bArr2[1] != 1)) {
                short s = (short) (((bArr2[0] << 8) + (bArr2[1] & 255)) >> 4);
                int i8 = 12;
                while (true) {
                    if (i8 >= 160) {
                        i7 = 2;
                        break;
                    }
                    s = (short) ((s << 1) + ((bArr2[i8 / 8] >> (7 - (i8 % 8))) & 1));
                    if ((s & 4095) == 1) {
                        break;
                    }
                    i8++;
                }
            }
            i6 = i7;
            j = 0;
            inputStream2 = pushbackInputStream;
        } else {
            if (i5 > 0) {
                j = 1;
                i6 = 3;
            } else {
                j = 0;
            }
            inputStream2 = inputStream;
        }
        readFromDecoderStream(new CCITTFaxDecoderStream(inputStream2, i3, i6, j, z), bArr);
        if (!decodeParams.getBoolean(COSName.BLACK_IS_1, false)) {
            invertBitmap(bArr);
        }
        outputStream.write(bArr);
        return new DecodeResult(cOSDictionary);
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        IOUtils.copy(inputStream, new CCITTFaxEncoderStream(outputStream, cOSDictionary.getInt(COSName.COLUMNS), cOSDictionary.getInt(COSName.ROWS), 1));
    }

    public void readFromDecoderStream(CCITTFaxDecoderStream cCITTFaxDecoderStream, byte[] bArr) throws IOException {
        int i2 = 0;
        do {
            int i3 = cCITTFaxDecoderStream.read(bArr, i2, bArr.length - i2);
            if (i3 <= -1) {
                return;
            } else {
                i2 += i3;
            }
        } while (i2 < bArr.length);
    }
}
