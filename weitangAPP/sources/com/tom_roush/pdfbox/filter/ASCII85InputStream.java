package com.tom_roush.pdfbox.filter;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class ASCII85InputStream extends FilterInputStream {
    private static final char NEWLINE = '\n';
    private static final char OFFSET = '!';
    private static final char PADDING_U = 'u';
    private static final char RETURN = '\r';
    private static final char SPACE = ' ';
    private static final char TERMINATOR = '~';
    private static final char Z = 'z';
    private byte[] ascii;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f12343b;
    private boolean eof;
    private int index;
    private int n;

    public ASCII85InputStream(InputStream inputStream) {
        super(inputStream);
        this.index = 0;
        this.n = 0;
        this.eof = false;
        this.ascii = new byte[5];
        this.f12343b = new byte[4];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ascii = null;
        this.eof = true;
        this.f12343b = null;
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        r13 = r14.ascii;
        r13[r2] = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r12 != 126) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        r13[r2] = 117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        r4 = r2 - 1;
        r14.n = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        if (r4 != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
    
        r14.eof = true;
        r14.ascii = null;
        r14.f12343b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0081, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0082, code lost:
    
        if (r2 >= 5) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
    
        if (r2 >= 5) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0087, code lost:
    
        r14.ascii[r2] = 117;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
    
        r14.eof = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0090, code lost:
    
        r1 = 0;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
    
        if (r4 >= 5) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0095, code lost:
    
        r5 = (byte) (r14.ascii[r4] - 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009c, code lost:
    
        if (r5 < 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a0, code lost:
    
        if (r5 > 93) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a2, code lost:
    
        r1 = (r1 * 85) + ((long) r5);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ab, code lost:
    
        r14.n = 0;
        r14.eof = true;
        r14.ascii = null;
        r14.f12343b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ba, code lost:
    
        throw new java.io.IOException("Invalid data in Ascii85 stream");
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bb, code lost:
    
        if (r10 < 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bd, code lost:
    
        r14.f12343b[r10] = (byte) (255 & r1);
        r1 = r1 >>> 8;
        r10 = r10 - 1;
     */
    @Override // java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.filter.ASCII85InputStream.read():int");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("Reset is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        return 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.eof && this.index >= this.n) {
            return -1;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.index;
            if (i5 < this.n) {
                byte[] bArr2 = this.f12343b;
                this.index = i5 + 1;
                bArr[i4 + i2] = bArr2[i5];
            } else {
                int i6 = read();
                if (i6 == -1) {
                    return i4;
                }
                bArr[i4 + i2] = (byte) i6;
            }
        }
        return i3;
    }
}
