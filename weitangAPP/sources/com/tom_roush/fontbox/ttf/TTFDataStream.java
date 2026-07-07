package com.tom_roush.fontbox.ttf;

import androidx.core.view.InputDeviceCompat;
import com.tom_roush.fontbox.util.Charsets;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTFDataStream implements Closeable {
    public abstract long getCurrentPosition() throws IOException;

    public abstract InputStream getOriginalData() throws IOException;

    public abstract long getOriginalDataSize();

    public abstract int read() throws IOException;

    public abstract int read(byte[] bArr, int i2, int i3) throws IOException;

    public byte[] read(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = read(bArr, i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        if (i3 == i2) {
            return bArr;
        }
        throw new IOException("Unexpected end of TTF stream reached");
    }

    public float read32Fixed() throws IOException {
        return (float) (((double) readSignedShort()) + (((double) readUnsignedShort()) / 65536.0d));
    }

    public Calendar readInternationalDate() throws IOException {
        long j = readLong();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(1904, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (j * 1000));
        return calendar;
    }

    public abstract long readLong() throws IOException;

    public int readSignedByte() throws IOException {
        int i2 = read();
        return i2 <= 127 ? i2 : i2 + InputDeviceCompat.SOURCE_ANY;
    }

    public abstract short readSignedShort() throws IOException;

    public String readString(int i2) throws IOException {
        return readString(i2, Charsets.ISO_8859_1);
    }

    public String readTag() throws IOException {
        return new String(read(4), Charsets.US_ASCII);
    }

    public int readUnsignedByte() throws IOException {
        int i2 = read();
        if (i2 != -1) {
            return i2;
        }
        throw new EOFException("premature EOF");
    }

    public int[] readUnsignedByteArray(int i2) throws IOException {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = read();
        }
        return iArr;
    }

    public long readUnsignedInt() throws IOException {
        long j = read();
        long j2 = read();
        long j3 = read();
        long j4 = read();
        if (j4 >= 0) {
            return (j << 24) + (j2 << 16) + (j3 << 8) + j4;
        }
        throw new EOFException();
    }

    public abstract int readUnsignedShort() throws IOException;

    public int[] readUnsignedShortArray(int i2) throws IOException {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = readUnsignedShort();
        }
        return iArr;
    }

    public abstract void seek(long j) throws IOException;

    public String readString(int i2, String str) throws IOException {
        return new String(read(i2), str);
    }

    public String readString(int i2, Charset charset) throws IOException {
        return new String(read(i2), charset);
    }
}
