package com.bytedance.pangle.g;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f6081a = new byte[8];

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f6082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f6083b;

        public a(ByteBuffer byteBuffer, byte[] bArr) {
            this.f6082a = byteBuffer;
            this.f6083b = bArr;
        }
    }

    public static class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ByteBuffer f6085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MessageDigest f6086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f6087d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f6088e;

        public /* synthetic */ b(byte[] bArr, ByteBuffer byteBuffer, byte b2) {
            this(bArr, byteBuffer);
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.f6084a);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.f6086c.update(byteBuffer);
                iRemaining -= iMin;
                int i2 = this.f6084a + iMin;
                this.f6084a = i2;
                if (i2 == 4096) {
                    MessageDigest messageDigest = this.f6086c;
                    byte[] bArr = this.f6087d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.f6085b.put(this.f6087d);
                    this.f6086c.update(this.f6088e);
                    this.f6084a = 0;
                }
            }
        }

        public final void b() {
            int iPosition = this.f6085b.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.f6085b.put(ByteBuffer.allocate(4096 - iPosition));
        }

        private b(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.f6087d = new byte[32];
            this.f6088e = bArr;
            this.f6085b = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            this.f6086c = messageDigest;
            messageDigest.update(bArr);
            this.f6084a = 0;
        }

        public final void a() {
            if (this.f6084a == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.f6084a);
        }
    }

    public static a a(RandomAccessFile randomAccessFile, m mVar, i iVar) throws IOException {
        int[] iArrA = a(randomAccessFile.length() - (mVar.f6096c - mVar.f6095b));
        int i2 = iArrA[iArrA.length - 1];
        int i3 = i2 + 4096;
        ByteBuffer byteBufferA = iVar.a(i3);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBufferA.order(byteOrder);
        ByteBuffer byteBufferA2 = a(byteBufferA, 0, i2);
        int i4 = i2 + 64;
        ByteBuffer byteBufferA3 = a(byteBufferA, i2, i4);
        ByteBuffer byteBufferA4 = a(byteBufferA, i4, i3);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(byteOrder);
        long j = mVar.f6095b;
        if (j % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mVar.f6095b);
        }
        long j2 = mVar.f6096c;
        if ((j2 - j) % 4096 != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mVar.f6096c - mVar.f6095b));
        }
        long j3 = j2 - j;
        int[] iArrA2 = a(randomAccessFile.length() - j3);
        if (byteBufferA2 != null) {
            byteBufferWrap.put(a(randomAccessFile, mVar, f6081a, iArrA2, byteBufferA2));
            byteBufferWrap.flip();
        }
        if (byteBufferA3 != null) {
            byteBufferA3.order(byteOrder);
            long length = randomAccessFile.length();
            byte[] bArr2 = f6081a;
            if (bArr2.length != 8) {
                throw new IllegalArgumentException("salt is not 8 bytes long");
            }
            byteBufferA3.put("TrueBrew".getBytes());
            byteBufferA3.put((byte) 1);
            byteBufferA3.put((byte) 0);
            byteBufferA3.put((byte) 12);
            byteBufferA3.put((byte) 7);
            byteBufferA3.putShort((short) 1);
            byteBufferA3.putShort((short) 1);
            byteBufferA3.putInt(0);
            byteBufferA3.putInt(0);
            byteBufferA3.putLong(length);
            byteBufferA3.put((byte) 2);
            byteBufferA3.put((byte) 0);
            byteBufferA3.put(bArr2);
            a(byteBufferA3, 22);
            byteBufferA3.flip();
        }
        if (byteBufferA4 != null) {
            byteBufferA4.order(byteOrder);
            long j4 = mVar.f6095b;
            long j5 = mVar.f6097d;
            byteBufferA4.putInt(24);
            byteBufferA4.putShort((short) 1);
            a(byteBufferA4, 2);
            byteBufferA4.putLong(j4);
            byteBufferA4.putLong(j3);
            byteBufferA4.putInt(20);
            byteBufferA4.putShort((short) 2);
            a(byteBufferA4, 2);
            byteBufferA4.putLong(j5 + 16);
            byteBufferA4.putInt(c(j4));
            a(byteBufferA4, 4);
            byteBufferA4.flip();
        }
        byteBufferA.position(i4 + byteBufferA4.limit());
        byteBufferA.putInt(byteBufferA4.limit() + 64 + 4);
        byteBufferA.flip();
        return new a(byteBufferA, bArr);
    }

    private static long b(long j) {
        return ((j + 4096) - 1) / 4096;
    }

    private static int c(long j) {
        int i2 = (int) j;
        if (i2 == j) {
            return i2;
        }
        throw new ArithmeticException("integer overflow");
    }

    private static void a(j jVar, k kVar, int i2) {
        long jA = kVar.a();
        long j = 0;
        while (jA > 0) {
            int iMin = (int) Math.min(jA, i2);
            kVar.a(jVar, j, iMin);
            long j2 = iMin;
            j += j2;
            jA -= j2;
        }
    }

    private static byte[] a(RandomAccessFile randomAccessFile, m mVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws DigestException, IOException {
        byte b2 = 0;
        b bVar = new b(bArr, a(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]), b2);
        a(bVar, new l(randomAccessFile.getFD(), 0L, mVar.f6095b), 1048576);
        long j = mVar.f6097d + 16;
        FileDescriptor fd = randomAccessFile.getFD();
        long j2 = mVar.f6096c;
        a(bVar, new l(fd, j2, j - j2), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(c(mVar.f6095b));
        byteBufferOrder.flip();
        bVar.a(byteBufferOrder);
        long j3 = j + 4;
        a(bVar, new l(randomAccessFile.getFD(), j3, randomAccessFile.length() - j3), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            bVar.a(ByteBuffer.allocate(4096 - length));
        }
        bVar.a();
        bVar.b();
        for (int length2 = iArr.length - 3; length2 >= 0; length2--) {
            int i2 = length2 + 1;
            ByteBuffer byteBufferA = a(byteBuffer, iArr[i2], iArr[length2 + 2]);
            ByteBuffer byteBufferA2 = a(byteBuffer, iArr[length2], iArr[i2]);
            h hVar = new h(byteBufferA);
            b bVar2 = new b(bArr, byteBufferA2, b2);
            a(bVar2, hVar, 4096);
            bVar2.a();
            bVar2.b();
        }
        byte[] bArr2 = new byte[32];
        b bVar3 = new b(bArr, ByteBuffer.wrap(bArr2), b2);
        bVar3.a(a(byteBuffer, 0, 4096));
        bVar3.a();
        return bArr2;
    }

    private static int[] a(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = b(j) * 32;
            arrayList.add(Long.valueOf(b(j) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i2 = 0;
        iArr[0] = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            iArr[i3] = iArr[i2] + c(((Long) arrayList.get((arrayList.size() - i2) - 1)).longValue());
            i2 = i3;
        }
        return iArr;
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2, int i3) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i3);
        byteBufferDuplicate.position(i2);
        return byteBufferDuplicate.slice();
    }

    private static void a(ByteBuffer byteBuffer, int i2) {
        byteBuffer.position(byteBuffer.position() + i2);
    }
}
