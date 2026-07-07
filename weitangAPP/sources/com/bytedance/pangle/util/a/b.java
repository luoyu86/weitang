package com.bytedance.pangle.util.a;

import com.bytedance.pangle.util.f;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6260a = "";

    public static String[] a(File file) throws Throwable {
        String str;
        ByteBuffer byteBufferB;
        boolean z;
        String strA = "";
        try {
            byteBufferB = b(file);
        } catch (Exception unused) {
            str = "";
        }
        if (byteBufferB.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
        ByteBuffer byteBufferA = a(byteBufferB, byteBufferB.capacity() - 24);
        int i2 = 0;
        while (byteBufferA.hasRemaining()) {
            i2++;
            if (byteBufferA.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
            long j = byteBufferA.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int iPosition = byteBufferA.position() + i3;
            if (i3 > byteBufferA.remaining()) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferA.remaining());
            }
            int i4 = byteBufferA.getInt();
            if (i4 == -262969152) {
                f6260a = "V3";
            } else if (i4 == 1896449818) {
                f6260a = "V2";
            } else {
                byteBufferA.position(iPosition);
            }
            z = true;
            break;
        }
        z = false;
        if (z) {
            strA = f.a(byteBufferB.array());
            str = "";
        } else {
            str = "without v2 & v3 signature.";
        }
        return new String[]{strA, f6260a, str};
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.ByteBuffer b(java.io.File r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.a.b.b(java.io.File):java.nio.ByteBuffer");
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2) {
        if (i2 >= 8) {
            int iCapacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(8);
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    return byteBufferSlice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(iLimit);
                    byteBuffer.position(iPosition);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        throw new IllegalArgumentException("end < start: " + i2 + " < 8");
    }
}
