package f;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.UIDFolder;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.codec.net.RFC1522Codec;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f12978a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public p f12979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12980c;

    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return c.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            c.this.writeByte((int) ((byte) i2));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            c.this.write(bArr, i2, i3);
        }
    }

    public class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f12980c, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f12980c > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            return c.this.read(bArr, i2, i3);
        }
    }

    /* JADX INFO: renamed from: f.c$c, reason: collision with other inner class name */
    public static final class C0245c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f12983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f12985c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f12987e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f12986d = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12988f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12989g = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f12983a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f12983a = null;
            this.f12985c = null;
            this.f12986d = -1L;
            this.f12987e = null;
            this.f12988f = -1;
            this.f12989g = -1;
        }

        public long expandBuffer(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i2);
            }
            if (i2 > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i2);
            }
            c cVar = this.f12983a;
            if (cVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f12984b) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = cVar.f12980c;
            p pVarG = cVar.g(i2);
            int i3 = 8192 - pVarG.f13021c;
            pVarG.f13021c = 8192;
            long j2 = i3;
            this.f12983a.f12980c = j + j2;
            this.f12985c = pVarG;
            this.f12986d = j;
            this.f12987e = pVarG.f13019a;
            this.f12988f = 8192 - i3;
            this.f12989g = 8192;
            return j2;
        }

        public int next() {
            long j = this.f12986d;
            if (j != this.f12983a.f12980c) {
                return j == -1 ? seek(0L) : seek(j + ((long) (this.f12989g - this.f12988f)));
            }
            throw new IllegalStateException();
        }

        public long resizeBuffer(long j) {
            c cVar = this.f12983a;
            if (cVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f12984b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = cVar.f12980c;
            if (j <= j2) {
                if (j < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j);
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    c cVar2 = this.f12983a;
                    p pVar = cVar2.f12979b.f13025g;
                    int i2 = pVar.f13021c;
                    long j4 = i2 - pVar.f13020b;
                    if (j4 > j3) {
                        pVar.f13021c = (int) (((long) i2) - j3);
                        break;
                    }
                    cVar2.f12979b = pVar.pop();
                    q.a(pVar);
                    j3 -= j4;
                }
                this.f12985c = null;
                this.f12986d = j;
                this.f12987e = null;
                this.f12988f = -1;
                this.f12989g = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    p pVarG = this.f12983a.g(1);
                    int iMin = (int) Math.min(j5, 8192 - pVarG.f13021c);
                    int i3 = pVarG.f13021c + iMin;
                    pVarG.f13021c = i3;
                    j5 -= (long) iMin;
                    if (z) {
                        this.f12985c = pVarG;
                        this.f12986d = j2;
                        this.f12987e = pVarG.f13019a;
                        this.f12988f = i3 - iMin;
                        this.f12989g = i3;
                        z = false;
                    }
                }
            }
            this.f12983a.f12980c = j;
            return j2;
        }

        public int seek(long j) {
            if (j >= -1) {
                c cVar = this.f12983a;
                long j2 = cVar.f12980c;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.f12985c = null;
                        this.f12986d = j;
                        this.f12987e = null;
                        this.f12988f = -1;
                        this.f12989g = -1;
                        return -1;
                    }
                    long j3 = 0;
                    p pVar = cVar.f12979b;
                    p pVarPush = this.f12985c;
                    if (pVarPush != null) {
                        long j4 = this.f12986d - ((long) (this.f12988f - pVarPush.f13020b));
                        if (j4 > j) {
                            j2 = j4;
                            pVarPush = pVar;
                            pVar = pVarPush;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        pVarPush = pVar;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i2 = pVarPush.f13021c;
                            int i3 = pVarPush.f13020b;
                            if (j < ((long) (i2 - i3)) + j3) {
                                break;
                            }
                            j3 += (long) (i2 - i3);
                            pVarPush = pVarPush.f13024f;
                        }
                    } else {
                        while (j2 > j) {
                            pVar = pVar.f13025g;
                            j2 -= (long) (pVar.f13021c - pVar.f13020b);
                        }
                        pVarPush = pVar;
                        j3 = j2;
                    }
                    if (this.f12984b && pVarPush.f13022d) {
                        p pVarB = pVarPush.b();
                        c cVar2 = this.f12983a;
                        if (cVar2.f12979b == pVarPush) {
                            cVar2.f12979b = pVarB;
                        }
                        pVarPush = pVarPush.push(pVarB);
                        pVarPush.f13025g.pop();
                    }
                    this.f12985c = pVarPush;
                    this.f12986d = j;
                    this.f12987e = pVarPush.f13019a;
                    int i4 = pVarPush.f13020b + ((int) (j - j3));
                    this.f12988f = i4;
                    int i5 = pVarPush.f13021c;
                    this.f12989g = i5;
                    return i5 - i4;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.f12983a.f12980c)));
        }
    }

    public final f a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            p pVar = this.f12979b;
            if (pVar != null) {
                byte[] bArr = pVar.f13019a;
                int i2 = pVar.f13020b;
                messageDigest.update(bArr, i2, pVar.f13021c - i2);
                p pVar2 = this.f12979b;
                while (true) {
                    pVar2 = pVar2.f13024f;
                    if (pVar2 == this.f12979b) {
                        break;
                    }
                    byte[] bArr2 = pVar2.f13019a;
                    int i3 = pVar2.f13020b;
                    messageDigest.update(bArr2, i3, pVar2.f13021c - i3);
                }
            }
            return f.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final f b(String str, f fVar) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(fVar.toByteArray(), str));
            p pVar = this.f12979b;
            if (pVar != null) {
                byte[] bArr = pVar.f13019a;
                int i2 = pVar.f13020b;
                mac.update(bArr, i2, pVar.f13021c - i2);
                p pVar2 = this.f12979b;
                while (true) {
                    pVar2 = pVar2.f13024f;
                    if (pVar2 == this.f12979b) {
                        break;
                    }
                    byte[] bArr2 = pVar2.f13019a;
                    int i3 = pVar2.f13020b;
                    mac.update(bArr2, i3, pVar2.f13021c - i3);
                }
            }
            return f.of(mac.doFinal());
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // f.e, f.d
    public c buffer() {
        return this;
    }

    public final boolean c(p pVar, int i2, f fVar, int i3, int i4) {
        int i5 = pVar.f13021c;
        byte[] bArr = pVar.f13019a;
        while (i3 < i4) {
            if (i2 == i5) {
                pVar = pVar.f13024f;
                byte[] bArr2 = pVar.f13019a;
                bArr = bArr2;
                i2 = pVar.f13020b;
                i5 = pVar.f13021c;
            }
            if (bArr[i2] != fVar.getByte(i3)) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public void clear() {
        try {
            skip(this.f12980c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // f.e, f.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public long completeSegmentByteCount() {
        long j = this.f12980c;
        if (j == 0) {
            return 0L;
        }
        p pVar = this.f12979b.f13025g;
        int i2 = pVar.f13021c;
        return (i2 >= 8192 || !pVar.f13023e) ? j : j - ((long) (i2 - pVar.f13020b));
    }

    public c copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.f12980c);
    }

    public final void d(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            p pVarG = g(1);
            int i2 = inputStream.read(pVarG.f13019a, pVarG.f13021c, (int) Math.min(j, 8192 - pVarG.f13021c));
            if (i2 == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            } else {
                pVarG.f13021c += i2;
                long j2 = i2;
                this.f12980c += j2;
                j -= j2;
            }
        }
    }

    public String e(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String utf8 = readUtf8(j2);
                skip(2L);
                return utf8;
            }
        }
        String utf82 = readUtf8(j);
        skip(1L);
        return utf82;
    }

    @Override // f.d
    public d emit() {
        return this;
    }

    @Override // f.d
    public c emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.f12980c;
        if (j != cVar.f12980c) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        p pVar = this.f12979b;
        p pVar2 = cVar.f12979b;
        int i2 = pVar.f13020b;
        int i3 = pVar2.f13020b;
        while (j2 < this.f12980c) {
            long jMin = Math.min(pVar.f13021c - i2, pVar2.f13021c - i3);
            int i4 = 0;
            while (i4 < jMin) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (pVar.f13019a[i2] != pVar2.f13019a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == pVar.f13021c) {
                pVar = pVar.f13024f;
                i2 = pVar.f13020b;
            }
            if (i3 == pVar2.f13021c) {
                pVar2 = pVar2.f13024f;
                i3 = pVar2.f13020b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // f.e
    public boolean exhausted() {
        return this.f12980c == 0;
    }

    public int f(m mVar) {
        p pVar = this.f12979b;
        f[] fVarArr = mVar.f13010a;
        int length = fVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            f fVar = fVarArr[i2];
            int iMin = (int) Math.min(this.f12980c, fVar.size());
            if (iMin == 0 || c(pVar, pVar.f13020b, fVar, 0, iMin)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // f.d, f.s, java.io.Flushable
    public void flush() {
    }

    public p g(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        p pVar = this.f12979b;
        if (pVar != null) {
            p pVar2 = pVar.f13025g;
            return (pVar2.f13021c + i2 > 8192 || !pVar2.f13023e) ? pVar2.push(q.b()) : pVar2;
        }
        p pVarB = q.b();
        this.f12979b = pVarB;
        pVarB.f13025g = pVarB;
        pVarB.f13024f = pVarB;
        return pVarB;
    }

    public byte getByte(long j) {
        int i2;
        v.checkOffsetAndCount(this.f12980c, j, 1L);
        long j2 = this.f12980c;
        if (j2 - j <= j) {
            long j3 = j - j2;
            p pVar = this.f12979b;
            do {
                pVar = pVar.f13025g;
                int i3 = pVar.f13021c;
                i2 = pVar.f13020b;
                j3 += (long) (i3 - i2);
            } while (j3 < 0);
            return pVar.f13019a[i2 + ((int) j3)];
        }
        p pVar2 = this.f12979b;
        while (true) {
            int i4 = pVar2.f13021c;
            int i5 = pVar2.f13020b;
            long j4 = i4 - i5;
            if (j < j4) {
                return pVar2.f13019a[i5 + ((int) j)];
            }
            j -= j4;
            pVar2 = pVar2.f13024f;
        }
    }

    public int hashCode() {
        p pVar = this.f12979b;
        if (pVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = pVar.f13021c;
            for (int i4 = pVar.f13020b; i4 < i3; i4++) {
                i2 = (i2 * 31) + pVar.f13019a[i4];
            }
            pVar = pVar.f13024f;
        } while (pVar != this.f12979b);
        return i2;
    }

    public f hmacSha1(f fVar) {
        return b("HmacSHA1", fVar);
    }

    public f hmacSha256(f fVar) {
        return b("HmacSHA256", fVar);
    }

    public f hmacSha512(f fVar) {
        return b("HmacSHA512", fVar);
    }

    @Override // f.e
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, RecyclerView.FOREVER_NS);
    }

    @Override // f.e
    public long indexOfElement(f fVar) {
        return indexOfElement(fVar, 0L);
    }

    @Override // f.e
    public InputStream inputStream() {
        return new b();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public f md5() {
        return a(MessageDigestAlgorithms.MD5);
    }

    @Override // f.d
    public OutputStream outputStream() {
        return new a();
    }

    @Override // f.e
    public boolean rangeEquals(long j, f fVar) {
        return rangeEquals(j, fVar, 0, fVar.size());
    }

    @Override // f.e
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // f.e
    public long readAll(s sVar) throws IOException {
        long j = this.f12980c;
        if (j > 0) {
            sVar.write(this, j);
        }
        return j;
    }

    public C0245c readAndWriteUnsafe() {
        return readAndWriteUnsafe(new C0245c());
    }

    @Override // f.e
    public byte readByte() {
        long j = this.f12980c;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        p pVar = this.f12979b;
        int i2 = pVar.f13020b;
        int i3 = pVar.f13021c;
        int i4 = i2 + 1;
        byte b2 = pVar.f13019a[i2];
        this.f12980c = j - 1;
        if (i4 == i3) {
            this.f12979b = pVar.pop();
            q.a(pVar);
        } else {
            pVar.f13020b = i4;
        }
        return b2;
    }

    @Override // f.e
    public byte[] readByteArray() {
        try {
            return readByteArray(this.f12980c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // f.e
    public f readByteString() {
        return new f(readByteArray());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r1 = new f.c().writeDecimalLong(r3).writeByte((int) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r8 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    @Override // f.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f.c.readDecimalLong():long");
    }

    public c readFrom(InputStream inputStream) throws IOException {
        d(inputStream, RecyclerView.FOREVER_NS, true);
        return this;
    }

    @Override // f.e
    public void readFully(c cVar, long j) throws EOFException {
        long j2 = this.f12980c;
        if (j2 >= j) {
            cVar.write(this, j);
        } else {
            cVar.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5 A[EDGE_INSN: B:44:0x00a5->B:38:0x00a5 BREAK  A[LOOP:0: B:5:0x000b->B:46:?], SYNTHETIC] */
    @Override // f.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.f12980c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            f.p r6 = r15.f12979b
            byte[] r7 = r6.f13019a
            int r8 = r6.f13020b
            int r9 = r6.f13021c
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            f.c r0 = new f.c
            r0.<init>()
            f.c r0 = r0.writeHexadecimalUnsignedLong(r4)
            f.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            f.p r7 = r6.pop()
            r15.f12979b = r7
            f.q.a(r6)
            goto L9f
        L9d:
            r6.f13020b = r8
        L9f:
            if (r1 != 0) goto La5
            f.p r6 = r15.f12979b
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.f12980c
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f12980c = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f.c.readHexadecimalUnsignedLong():long");
    }

    @Override // f.e
    public int readInt() {
        long j = this.f12980c;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.f12980c);
        }
        p pVar = this.f12979b;
        int i2 = pVar.f13020b;
        int i3 = pVar.f13021c;
        if (i3 - i2 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = pVar.f13019a;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & 255);
        this.f12980c = j - 4;
        if (i9 == i3) {
            this.f12979b = pVar.pop();
            q.a(pVar);
        } else {
            pVar.f13020b = i9;
        }
        return i10;
    }

    @Override // f.e
    public int readIntLe() {
        return v.reverseBytesInt(readInt());
    }

    @Override // f.e
    public long readLong() {
        long j = this.f12980c;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + this.f12980c);
        }
        p pVar = this.f12979b;
        int i2 = pVar.f13020b;
        int i3 = pVar.f13021c;
        if (i3 - i2 < 8) {
            return ((((long) readInt()) & UIDFolder.MAXUID) << 32) | (UIDFolder.MAXUID & ((long) readInt()));
        }
        byte[] bArr = pVar.f13019a;
        int i4 = i2 + 1;
        long j2 = (((long) bArr[i2]) & 255) << 56;
        int i5 = i4 + 1;
        long j3 = ((((long) bArr[i4]) & 255) << 48) | j2;
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 40);
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 24);
        int i9 = i8 + 1;
        long j6 = j5 | ((((long) bArr[i8]) & 255) << 16);
        int i10 = i9 + 1;
        long j7 = j6 | ((((long) bArr[i9]) & 255) << 8);
        int i11 = i10 + 1;
        long j8 = j7 | (((long) bArr[i10]) & 255);
        this.f12980c = j - 8;
        if (i11 == i3) {
            this.f12979b = pVar.pop();
            q.a(pVar);
        } else {
            pVar.f13020b = i11;
        }
        return j8;
    }

    @Override // f.e
    public long readLongLe() {
        return v.reverseBytesLong(readLong());
    }

    @Override // f.e
    public short readShort() {
        long j = this.f12980c;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.f12980c);
        }
        p pVar = this.f12979b;
        int i2 = pVar.f13020b;
        int i3 = pVar.f13021c;
        if (i3 - i2 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = pVar.f13019a;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
        this.f12980c = j - 2;
        if (i5 == i3) {
            this.f12979b = pVar.pop();
            q.a(pVar);
        } else {
            pVar.f13020b = i5;
        }
        return (short) i6;
    }

    @Override // f.e
    public short readShortLe() {
        return v.reverseBytesShort(readShort());
    }

    @Override // f.e
    public String readString(Charset charset) {
        try {
            return readString(this.f12980c, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public C0245c readUnsafe() {
        return readUnsafe(new C0245c());
    }

    @Override // f.e
    public String readUtf8() {
        try {
            return readString(this.f12980c, v.f13030a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // f.e
    public int readUtf8CodePoint() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (this.f12980c == 0) {
            throw new EOFException();
        }
        byte b2 = getByte(0L);
        if ((b2 & 128) == 0) {
            i2 = b2 & 127;
            i3 = 1;
            i4 = 0;
        } else if ((b2 & 224) == 192) {
            i2 = b2 & 31;
            i3 = 2;
            i4 = 128;
        } else if ((b2 & 240) == 224) {
            i2 = b2 & 15;
            i3 = 3;
            i4 = 2048;
        } else {
            if ((b2 & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i2 = b2 & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j = i3;
        if (this.f12980c < j) {
            throw new EOFException("size < " + i3 + ": " + this.f12980c + " (to read code point prefixed 0x" + Integer.toHexString(b2) + ")");
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j2 = i5;
            byte b3 = getByte(j2);
            if ((b3 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i2 = (i2 << 6) | (b3 & 63);
        }
        skip(j);
        if (i2 > 1114111) {
            return 65533;
        }
        if ((i2 < 55296 || i2 > 57343) && i2 >= i4) {
            return i2;
        }
        return 65533;
    }

    @Override // f.e
    @Nullable
    public String readUtf8Line() throws EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return e(jIndexOf);
        }
        long j = this.f12980c;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // f.e
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(RecyclerView.FOREVER_NS);
    }

    @Override // f.e
    public boolean request(long j) {
        return this.f12980c >= j;
    }

    @Override // f.e
    public void require(long j) throws EOFException {
        if (this.f12980c < j) {
            throw new EOFException();
        }
    }

    @Override // f.e
    public int select(m mVar) {
        p pVar = this.f12979b;
        if (pVar == null) {
            return mVar.indexOf(f.EMPTY);
        }
        f[] fVarArr = mVar.f13010a;
        int length = fVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            f fVar = fVarArr[i2];
            if (this.f12980c >= fVar.size() && c(pVar, pVar.f13020b, fVar, 0, fVar.size())) {
                try {
                    skip(fVar.size());
                    return i2;
                } catch (EOFException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
        return -1;
    }

    public f sha1() {
        return a(MessageDigestAlgorithms.SHA_1);
    }

    public f sha256() {
        return a(MessageDigestAlgorithms.SHA_256);
    }

    public f sha512() {
        return a(MessageDigestAlgorithms.SHA_512);
    }

    public long size() {
        return this.f12980c;
    }

    @Override // f.e
    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.f12979b == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, r0.f13021c - r0.f13020b);
            long j2 = iMin;
            this.f12980c -= j2;
            j -= j2;
            p pVar = this.f12979b;
            int i2 = pVar.f13020b + iMin;
            pVar.f13020b = i2;
            if (i2 == pVar.f13021c) {
                this.f12979b = pVar.pop();
                q.a(pVar);
            }
        }
    }

    public f snapshot() {
        long j = this.f12980c;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f12980c);
    }

    @Override // f.e, f.t
    public u timeout() {
        return u.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    @Override // f.d
    public long writeAll(t tVar) throws IOException {
        if (tVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = tVar.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    public c writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.f12980c);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c m471clone() {
        c cVar = new c();
        if (this.f12980c == 0) {
            return cVar;
        }
        p pVarA = this.f12979b.a();
        cVar.f12979b = pVarA;
        pVarA.f13025g = pVarA;
        pVarA.f13024f = pVarA;
        p pVar = this.f12979b;
        while (true) {
            pVar = pVar.f13024f;
            if (pVar == this.f12979b) {
                cVar.f12980c = this.f12980c;
                return cVar;
            }
            cVar.f12979b.f13025g.push(pVar.a());
        }
    }

    public c copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        v.checkOffsetAndCount(this.f12980c, j, j2);
        if (j2 == 0) {
            return this;
        }
        p pVar = this.f12979b;
        while (true) {
            int i2 = pVar.f13021c;
            int i3 = pVar.f13020b;
            if (j < i2 - i3) {
                break;
            }
            j -= (long) (i2 - i3);
            pVar = pVar.f13024f;
        }
        while (j2 > 0) {
            int i4 = (int) (((long) pVar.f13020b) + j);
            int iMin = (int) Math.min(pVar.f13021c - i4, j2);
            outputStream.write(pVar.f13019a, i4, iMin);
            j2 -= (long) iMin;
            pVar = pVar.f13024f;
            j = 0;
        }
        return this;
    }

    @Override // f.e
    public long indexOf(byte b2, long j) {
        return indexOf(b2, j, RecyclerView.FOREVER_NS);
    }

    @Override // f.e
    public long indexOfElement(f fVar, long j) {
        int i2;
        int i3;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        p pVar = this.f12979b;
        if (pVar == null) {
            return -1L;
        }
        long j3 = this.f12980c;
        if (j3 - j < j) {
            while (j3 > j) {
                pVar = pVar.f13025g;
                j3 -= (long) (pVar.f13021c - pVar.f13020b);
            }
        } else {
            while (true) {
                long j4 = ((long) (pVar.f13021c - pVar.f13020b)) + j2;
                if (j4 >= j) {
                    break;
                }
                pVar = pVar.f13024f;
                j2 = j4;
            }
            j3 = j2;
        }
        if (fVar.size() == 2) {
            byte b2 = fVar.getByte(0);
            byte b3 = fVar.getByte(1);
            while (j3 < this.f12980c) {
                byte[] bArr = pVar.f13019a;
                i2 = (int) ((((long) pVar.f13020b) + j) - j3);
                int i4 = pVar.f13021c;
                while (i2 < i4) {
                    byte b4 = bArr[i2];
                    if (b4 == b2 || b4 == b3) {
                        i3 = pVar.f13020b;
                        return ((long) (i2 - i3)) + j3;
                    }
                    i2++;
                }
                j3 += (long) (pVar.f13021c - pVar.f13020b);
                pVar = pVar.f13024f;
                j = j3;
            }
            return -1L;
        }
        byte[] bArrE = fVar.e();
        while (j3 < this.f12980c) {
            byte[] bArr2 = pVar.f13019a;
            i2 = (int) ((((long) pVar.f13020b) + j) - j3);
            int i5 = pVar.f13021c;
            while (i2 < i5) {
                byte b5 = bArr2[i2];
                for (byte b6 : bArrE) {
                    if (b5 == b6) {
                        i3 = pVar.f13020b;
                        return ((long) (i2 - i3)) + j3;
                    }
                }
                i2++;
            }
            j3 += (long) (pVar.f13021c - pVar.f13020b);
            pVar = pVar.f13024f;
            j = j3;
        }
        return -1L;
    }

    @Override // f.e
    public boolean rangeEquals(long j, f fVar, int i2, int i3) {
        if (j < 0 || i2 < 0 || i3 < 0 || this.f12980c - j < i3 || fVar.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (getByte(((long) i4) + j) != fVar.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // f.e
    public int read(byte[] bArr, int i2, int i3) {
        v.checkOffsetAndCount(bArr.length, i2, i3);
        p pVar = this.f12979b;
        if (pVar == null) {
            return -1;
        }
        int iMin = Math.min(i3, pVar.f13021c - pVar.f13020b);
        System.arraycopy(pVar.f13019a, pVar.f13020b, bArr, i2, iMin);
        int i4 = pVar.f13020b + iMin;
        pVar.f13020b = i4;
        this.f12980c -= (long) iMin;
        if (i4 == pVar.f13021c) {
            this.f12979b = pVar.pop();
            q.a(pVar);
        }
        return iMin;
    }

    public C0245c readAndWriteUnsafe(C0245c c0245c) {
        if (c0245c.f12983a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        c0245c.f12983a = this;
        c0245c.f12984b = true;
        return c0245c;
    }

    @Override // f.e
    public f readByteString(long j) throws EOFException {
        return new f(readByteArray(j));
    }

    public c readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            d(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public C0245c readUnsafe(C0245c c0245c) {
        if (c0245c.f12983a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        c0245c.f12983a = this;
        c0245c.f12984b = false;
        return c0245c;
    }

    @Override // f.e
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = RecyclerView.FOREVER_NS;
        if (j != RecyclerView.FOREVER_NS) {
            j2 = j + 1;
        }
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return e(jIndexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return e(j2);
        }
        c cVar = new c();
        copyTo(cVar, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + cVar.readByteString().hex() + (char) 8230);
    }

    @Override // f.d
    public c writeByte(int i2) {
        p pVarG = g(1);
        byte[] bArr = pVarG.f13019a;
        int i3 = pVarG.f13021c;
        pVarG.f13021c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f12980c++;
        return this;
    }

    @Override // f.d
    public c writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        p pVarG = g(i2);
        byte[] bArr = pVarG.f13019a;
        int i3 = pVarG.f13021c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f12978a[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        pVarG.f13021c += i2;
        this.f12980c += (long) i2;
        return this;
    }

    @Override // f.d
    public c writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        p pVarG = g(iNumberOfTrailingZeros);
        byte[] bArr = pVarG.f13019a;
        int i2 = pVarG.f13021c;
        for (int i3 = (i2 + iNumberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f12978a[(int) (15 & j)];
            j >>>= 4;
        }
        pVarG.f13021c += iNumberOfTrailingZeros;
        this.f12980c += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // f.d
    public c writeInt(int i2) {
        p pVarG = g(4);
        byte[] bArr = pVarG.f13019a;
        int i3 = pVarG.f13021c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        pVarG.f13021c = i6 + 1;
        this.f12980c += 4;
        return this;
    }

    @Override // f.d
    public c writeIntLe(int i2) {
        return writeInt(v.reverseBytesInt(i2));
    }

    @Override // f.d
    public c writeLong(long j) {
        p pVarG = g(8);
        byte[] bArr = pVarG.f13019a;
        int i2 = pVarG.f13021c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j >>> 8) & 255);
        bArr[i9] = (byte) (j & 255);
        pVarG.f13021c = i9 + 1;
        this.f12980c += 8;
        return this;
    }

    @Override // f.d
    public c writeLongLe(long j) {
        return writeLong(v.reverseBytesLong(j));
    }

    @Override // f.d
    public c writeShort(int i2) {
        p pVarG = g(2);
        byte[] bArr = pVarG.f13019a;
        int i3 = pVarG.f13021c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        pVarG.f13021c = i4 + 1;
        this.f12980c += 2;
        return this;
    }

    @Override // f.d
    public c writeShortLe(int i2) {
        return writeShort((int) v.reverseBytesShort((short) i2));
    }

    public c writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        v.checkOffsetAndCount(this.f12980c, 0L, j);
        p pVar = this.f12979b;
        while (j > 0) {
            int iMin = (int) Math.min(j, pVar.f13021c - pVar.f13020b);
            outputStream.write(pVar.f13019a, pVar.f13020b, iMin);
            int i2 = pVar.f13020b + iMin;
            pVar.f13020b = i2;
            long j2 = iMin;
            this.f12980c -= j2;
            j -= j2;
            if (i2 == pVar.f13021c) {
                p pVarPop = pVar.pop();
                this.f12979b = pVarPop;
                q.a(pVar);
                pVar = pVarPop;
            }
        }
        return this;
    }

    @Override // f.d
    public c writeUtf8CodePoint(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            writeByte((i2 >> 6) | 192);
            writeByte((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 < 55296 || i2 > 57343) {
                writeByte((i2 >> 12) | 224);
                writeByte(((i2 >> 6) & 63) | 128);
                writeByte((i2 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else {
            if (i2 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
            writeByte((i2 >> 18) | 240);
            writeByte(((i2 >> 12) & 63) | 128);
            writeByte(((i2 >> 6) & 63) | 128);
            writeByte((i2 & 63) | 128);
        }
        return this;
    }

    @Override // f.e
    public long indexOf(byte b2, long j, long j2) {
        p pVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f12980c;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (pVar = this.f12979b) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    pVar = pVar.f13025g;
                    j4 -= (long) (pVar.f13021c - pVar.f13020b);
                }
            } else {
                while (true) {
                    long j6 = ((long) (pVar.f13021c - pVar.f13020b)) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    pVar = pVar.f13024f;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = pVar.f13019a;
                int iMin = (int) Math.min(pVar.f13021c, (((long) pVar.f13020b) + j5) - j4);
                for (int i2 = (int) ((((long) pVar.f13020b) + j7) - j4); i2 < iMin; i2++) {
                    if (bArr[i2] == b2) {
                        return ((long) (i2 - pVar.f13020b)) + j4;
                    }
                }
                j4 += (long) (pVar.f13021c - pVar.f13020b);
                pVar = pVar.f13024f;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f12980c), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // f.e
    public byte[] readByteArray(long j) throws EOFException {
        v.checkOffsetAndCount(this.f12980c, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // f.e
    public String readString(long j, Charset charset) throws EOFException {
        v.checkOffsetAndCount(this.f12980c, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        p pVar = this.f12979b;
        if (((long) pVar.f13020b) + j > pVar.f13021c) {
            return new String(readByteArray(j), charset);
        }
        String str = new String(pVar.f13019a, pVar.f13020b, (int) j, charset);
        int i2 = (int) (((long) pVar.f13020b) + j);
        pVar.f13020b = i2;
        this.f12980c -= j;
        if (i2 == pVar.f13021c) {
            this.f12979b = pVar.pop();
            q.a(pVar);
        }
        return str;
    }

    @Override // f.e
    public String readUtf8(long j) throws EOFException {
        return readString(j, v.f13030a);
    }

    @Override // f.d
    public c writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // f.d
    public c writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    public f snapshot(int i2) {
        if (i2 == 0) {
            return f.EMPTY;
        }
        return new r(this, i2);
    }

    @Override // f.d
    public c write(f fVar) {
        if (fVar != null) {
            fVar.f(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // f.d
    public c writeString(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i2);
        }
        if (i3 >= i2) {
            if (i3 <= str.length()) {
                if (charset != null) {
                    if (charset.equals(v.f13030a)) {
                        return writeUtf8(str, i2, i3);
                    }
                    byte[] bytes = str.substring(i2, i3).getBytes(charset);
                    return write(bytes, 0, bytes.length);
                }
                throw new IllegalArgumentException("charset == null");
            }
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
    }

    @Override // f.d
    public c writeUtf8(String str, int i2, int i3) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i2);
        }
        if (i3 >= i2) {
            if (i3 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            }
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < 128) {
                    p pVarG = g(1);
                    byte[] bArr = pVarG.f13019a;
                    int i4 = pVarG.f13021c - i2;
                    int iMin = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) cCharAt;
                    while (i5 < iMin) {
                        char cCharAt2 = str.charAt(i5);
                        if (cCharAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) cCharAt2;
                        i5++;
                    }
                    int i6 = pVarG.f13021c;
                    int i7 = (i4 + i5) - i6;
                    pVarG.f13021c = i6 + i7;
                    this.f12980c += (long) i7;
                    i2 = i5;
                } else {
                    if (cCharAt < 2048) {
                        writeByte((cCharAt >> 6) | 192);
                        writeByte((cCharAt & RFC1522Codec.SEP) | 128);
                    } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                        int i8 = i2 + 1;
                        char cCharAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                        if (cCharAt <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i9 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            writeByte((i9 >> 18) | 240);
                            writeByte(((i9 >> 12) & 63) | 128);
                            writeByte(((i9 >> 6) & 63) | 128);
                            writeByte((i9 & 63) | 128);
                            i2 += 2;
                        } else {
                            writeByte(63);
                            i2 = i8;
                        }
                    } else {
                        writeByte((cCharAt >> '\f') | 224);
                        writeByte(((cCharAt >> 6) & 63) | 128);
                        writeByte((cCharAt & RFC1522Codec.SEP) | 128);
                    }
                    i2++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
    }

    @Override // f.e
    public void readFully(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = read(bArr, i2, bArr.length - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
    }

    @Override // f.d
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // f.d
    public c write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = i3;
            v.checkOffsetAndCount(bArr.length, i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                p pVarG = g(1);
                int iMin = Math.min(i4 - i2, 8192 - pVarG.f13021c);
                System.arraycopy(bArr, i2, pVarG.f13019a, pVarG.f13021c, iMin);
                i2 += iMin;
                pVarG.f13021c += iMin;
            }
            this.f12980c += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c copyTo(c cVar, long j, long j2) {
        if (cVar != null) {
            v.checkOffsetAndCount(this.f12980c, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f12980c += j2;
            p pVar = this.f12979b;
            while (true) {
                int i2 = pVar.f13021c;
                int i3 = pVar.f13020b;
                if (j < i2 - i3) {
                    break;
                }
                j -= (long) (i2 - i3);
                pVar = pVar.f13024f;
            }
            while (j2 > 0) {
                p pVarA = pVar.a();
                int i4 = (int) (((long) pVarA.f13020b) + j);
                pVarA.f13020b = i4;
                pVarA.f13021c = Math.min(i4 + ((int) j2), pVarA.f13021c);
                p pVar2 = cVar.f12979b;
                if (pVar2 == null) {
                    pVarA.f13025g = pVarA;
                    pVarA.f13024f = pVarA;
                    cVar.f12979b = pVarA;
                } else {
                    pVar2.f13025g.push(pVarA);
                }
                j2 -= (long) (pVarA.f13021c - pVarA.f13020b);
                pVar = pVar.f13024f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        p pVar = this.f12979b;
        if (pVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), pVar.f13021c - pVar.f13020b);
        byteBuffer.put(pVar.f13019a, pVar.f13020b, iMin);
        int i2 = pVar.f13020b + iMin;
        pVar.f13020b = i2;
        this.f12980c -= (long) iMin;
        if (i2 == pVar.f13021c) {
            this.f12979b = pVar.pop();
            q.a(pVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int iRemaining = byteBuffer.remaining();
            int i2 = iRemaining;
            while (i2 > 0) {
                p pVarG = g(1);
                int iMin = Math.min(i2, 8192 - pVarG.f13021c);
                byteBuffer.get(pVarG.f13019a, pVarG.f13021c, iMin);
                i2 -= iMin;
                pVarG.f13021c += iMin;
            }
            this.f12980c += (long) iRemaining;
            return iRemaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // f.e
    public long indexOf(f fVar) throws IOException {
        return indexOf(fVar, 0L);
    }

    @Override // f.e
    public long indexOf(f fVar, long j) throws IOException {
        byte[] bArr;
        if (fVar.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j >= 0) {
            p pVar = this.f12979b;
            long j3 = -1;
            if (pVar == null) {
                return -1L;
            }
            long j4 = this.f12980c;
            if (j4 - j < j) {
                while (j4 > j) {
                    pVar = pVar.f13025g;
                    j4 -= (long) (pVar.f13021c - pVar.f13020b);
                }
            } else {
                while (true) {
                    long j5 = ((long) (pVar.f13021c - pVar.f13020b)) + j2;
                    if (j5 >= j) {
                        break;
                    }
                    pVar = pVar.f13024f;
                    j2 = j5;
                }
                j4 = j2;
            }
            byte b2 = fVar.getByte(0);
            int size = fVar.size();
            long j6 = 1 + (this.f12980c - ((long) size));
            long j7 = j;
            p pVar2 = pVar;
            long j8 = j4;
            while (j8 < j6) {
                byte[] bArr2 = pVar2.f13019a;
                int iMin = (int) Math.min(pVar2.f13021c, (((long) pVar2.f13020b) + j6) - j8);
                int i2 = (int) ((((long) pVar2.f13020b) + j7) - j8);
                while (i2 < iMin) {
                    if (bArr2[i2] == b2) {
                        bArr = bArr2;
                        if (c(pVar2, i2 + 1, fVar, 1, size)) {
                            return ((long) (i2 - pVar2.f13020b)) + j8;
                        }
                    } else {
                        bArr = bArr2;
                    }
                    i2++;
                    bArr2 = bArr;
                }
                j8 += (long) (pVar2.f13021c - pVar2.f13020b);
                pVar2 = pVar2.f13024f;
                j7 = j8;
                j3 = -1;
            }
            return j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // f.e, f.t
    public long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.f12980c;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.write(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // f.d
    public d write(t tVar, long j) throws IOException {
        while (j > 0) {
            long j2 = tVar.read(this, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
        }
        return this;
    }

    @Override // f.d, f.s
    public void write(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            v.checkOffsetAndCount(cVar.f12980c, 0L, j);
            while (j > 0) {
                p pVar = cVar.f12979b;
                if (j < pVar.f13021c - pVar.f13020b) {
                    p pVar2 = this.f12979b;
                    p pVar3 = pVar2 != null ? pVar2.f13025g : null;
                    if (pVar3 != null && pVar3.f13023e) {
                        if ((((long) pVar3.f13021c) + j) - ((long) (pVar3.f13022d ? 0 : pVar3.f13020b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            pVar.writeTo(pVar3, (int) j);
                            cVar.f12980c -= j;
                            this.f12980c += j;
                            return;
                        }
                    }
                    cVar.f12979b = pVar.split((int) j);
                }
                p pVar4 = cVar.f12979b;
                long j2 = pVar4.f13021c - pVar4.f13020b;
                cVar.f12979b = pVar4.pop();
                p pVar5 = this.f12979b;
                if (pVar5 == null) {
                    this.f12979b = pVar4;
                    pVar4.f13025g = pVar4;
                    pVar4.f13024f = pVar4;
                } else {
                    pVar5.f13025g.push(pVar4).compact();
                }
                cVar.f12980c -= j2;
                this.f12980c += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
