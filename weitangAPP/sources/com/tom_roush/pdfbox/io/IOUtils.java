package com.tom_roush.pdfbox.io;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static IOException closeAndLogException(Closeable closeable, String str, IOException iOException) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("PdfBox-Android", "Error closing " + str, e2);
            if (iOException == null) {
                return e2;
            }
        }
        return iOException;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return j;
            }
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
        }
    }

    public static long populateBuffer(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        while (length > 0) {
            int i2 = inputStream.read(bArr, bArr.length - length, length);
            if (i2 < 0) {
                break;
            }
            length -= i2;
        }
        return bArr.length - length;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
