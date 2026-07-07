package com.alibaba.sdk.android.man.crashreporter.e;

import com.tom_roush.fontbox.ttf.GlyfDescript;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.net.URLCodec;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final int H = 0;
    public static final int I = 1;
    public static final int J = 0;
    public static final int K = 2;
    public static final int L = 4;
    public static final int M = 8;
    public static final int N = 32;
    private static final int O = 76;
    public static final int URL_SAFE = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte f4713a = 61;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte f4714b = 10;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final /* synthetic */ boolean f105c = true;
    private static final String w = "US-ASCII";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f103a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte f4715c = -5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte f4716d = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static final byte[] f104b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f4715c, f4715c, -9, -9, f4715c, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f4715c, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, f4716d, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, BaseParser.ASCII_CR, 14, 15, GlyfDescript.X_DUAL, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, URLCodec.ESCAPE_CHAR, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static final byte[] f106c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private static final byte[] f107d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f4715c, f4715c, -9, -9, f4715c, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f4715c, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, f4716d, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, BaseParser.ASCII_CR, 14, 15, GlyfDescript.X_DUAL, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, URLCodec.ESCAPE_CHAR, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f4717e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f4718f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f4715c, f4715c, -9, -9, f4715c, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f4715c, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, f4716d, -9, -9, -9, 11, 12, BaseParser.ASCII_CR, 14, 15, GlyfDescript.X_DUAL, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, URLCodec.ESCAPE_CHAR, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static class a extends FilterInputStream {
        private int P;
        private int Q;
        private int R;
        private int S;
        private byte[] buffer;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4721e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f4722g;
        private int position;

        public a(InputStream inputStream) {
            this(inputStream, 0);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i2;
            if (this.position < 0) {
                if (this.f4720d) {
                    byte[] bArr = new byte[3];
                    int i3 = 0;
                    for (int i4 = 0; i4 < 3; i4++) {
                        int i5 = ((FilterInputStream) this).in.read();
                        if (i5 < 0) {
                            break;
                        }
                        bArr[i4] = (byte) i5;
                        i3++;
                    }
                    if (i3 <= 0) {
                        return -1;
                    }
                    b.a(bArr, 0, i3, this.buffer, 0, this.S);
                    this.position = 0;
                    this.Q = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i6 = 0;
                    while (i6 < 4) {
                        do {
                            i2 = ((FilterInputStream) this).in.read();
                            if (i2 < 0) {
                                break;
                            }
                        } while (this.f4722g[i2 & 127] <= -5);
                        if (i2 < 0) {
                            break;
                        }
                        bArr2[i6] = (byte) i2;
                        i6++;
                    }
                    if (i6 != 4) {
                        if (i6 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.Q = b.a(bArr2, 0, this.buffer, 0, this.S);
                    this.position = 0;
                }
            }
            int i7 = this.position;
            if (i7 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            }
            if (i7 >= this.Q) {
                return -1;
            }
            if (this.f4720d && this.f4721e && this.R >= 76) {
                this.R = 0;
                return 10;
            }
            this.R++;
            byte[] bArr3 = this.buffer;
            int i8 = i7 + 1;
            this.position = i8;
            byte b2 = bArr3[i7];
            if (i8 >= this.P) {
                this.position = -1;
            }
            return b2 & b.f4716d;
        }

        public a(InputStream inputStream, int i2) {
            super(inputStream);
            this.S = i2;
            this.f4721e = (i2 & 8) > 0;
            boolean z = (i2 & 1) > 0;
            this.f4720d = z;
            int i3 = z ? 4 : 3;
            this.P = i3;
            this.buffer = new byte[i3];
            this.position = -1;
            this.R = 0;
            this.f4722g = b.b(i2);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                int i5 = read();
                if (i5 >= 0) {
                    bArr[i2 + i4] = (byte) i5;
                    i4++;
                } else if (i4 == 0) {
                    return -1;
                }
            }
            return i4;
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.man.crashreporter.e.b$b, reason: collision with other inner class name */
    public static class C0064b extends FilterOutputStream {
        private int P;
        private int R;
        private int S;
        private byte[] buffer;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f4725f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f4726g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private byte[] f4727h;
        private int position;

        public C0064b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            f();
            super.close();
            this.buffer = null;
            ((FilterOutputStream) this).out = null;
        }

        public void f() throws IOException {
            int i2 = this.position;
            if (i2 > 0) {
                if (!this.f4723d) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(b.a(this.f4727h, this.buffer, i2, this.S));
                this.position = 0;
            }
        }

        public void g() throws IOException {
            f();
            this.f4725f = true;
        }

        public void h() {
            this.f4725f = false;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            if (this.f4725f) {
                ((FilterOutputStream) this).out.write(i2);
                return;
            }
            if (this.f4723d) {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.P;
                if (i4 >= i5) {
                    ((FilterOutputStream) this).out.write(b.a(this.f4727h, bArr, i5, this.S));
                    int i6 = this.R + 4;
                    this.R = i6;
                    if (this.f4724e && i6 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.R = 0;
                    }
                    this.position = 0;
                    return;
                }
                return;
            }
            byte[] bArr2 = this.f4726g;
            int i7 = i2 & 127;
            if (bArr2[i7] <= -5) {
                if (bArr2[i7] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
                return;
            }
            byte[] bArr3 = this.buffer;
            int i8 = this.position;
            int i9 = i8 + 1;
            this.position = i9;
            bArr3[i8] = (byte) i2;
            if (i9 >= this.P) {
                ((FilterOutputStream) this).out.write(this.f4727h, 0, b.a(bArr3, 0, this.f4727h, 0, this.S));
                this.position = 0;
            }
        }

        public C0064b(OutputStream outputStream, int i2) {
            super(outputStream);
            this.f4724e = (i2 & 8) != 0;
            boolean z = (i2 & 1) != 0;
            this.f4723d = z;
            int i3 = z ? 3 : 4;
            this.P = i3;
            this.buffer = new byte[i3];
            this.position = 0;
            this.R = 0;
            this.f4725f = false;
            this.f4727h = new byte[4];
            this.S = i2;
            this.f4726g = b.b(i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.f4725f) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }

    private b() {
    }

    private static final byte[] a(int i2) {
        return (i2 & 16) == 16 ? f106c : (i2 & 32) == 32 ? f4717e : f103a;
    }

    public static byte[] decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length, 0);
    }

    public static void f(String str, String str2) throws Throwable {
        C0064b c0064b = null;
        try {
            try {
                C0064b c0064b2 = new C0064b(new FileOutputStream(str2), 0);
                try {
                    c0064b2.write(str.getBytes("US-ASCII"));
                    try {
                        c0064b2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    c0064b = c0064b2;
                    try {
                        c0064b.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static void g(String str, String str2) throws Throwable {
        String strC = c(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(strC.getBytes("US-ASCII"));
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                    bufferedOutputStream = bufferedOutputStream2;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void h(String str, String str2) throws Throwable {
        byte[] bArrB = b(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(bArrB);
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                    bufferedOutputStream = bufferedOutputStream2;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) throws Throwable {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 1);
                int i2 = 0;
                while (true) {
                    try {
                        int i3 = aVar2.read(bArr, i2, 4096);
                        if (i3 < 0) {
                            break;
                        }
                        i2 += i3;
                    } catch (IOException e2) {
                        aVar = aVar2;
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        try {
                            aVar.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                String str2 = new String(bArr, 0, i2, "US-ASCII");
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i3 == 0) {
            return new byte[0];
        }
        if (i3 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
        byte[] bArrB = b(i4);
        byte[] bArr2 = new byte[(i3 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i6 = 0;
        int iA = 0;
        while (i2 < i5) {
            byte b2 = bArrB[bArr[i2] & f4716d];
            if (b2 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & f4716d), Integer.valueOf(i2)));
            }
            if (b2 >= -1) {
                int i7 = i6 + 1;
                bArr3[i6] = bArr[i2];
                if (i7 > 3) {
                    iA += a(bArr3, 0, bArr2, iA, i4);
                    if (bArr[i2] == 61) {
                        break;
                    }
                    i6 = 0;
                } else {
                    i6 = i7;
                }
            }
            i2++;
        }
        byte[] bArr4 = new byte[iA];
        System.arraycopy(bArr2, 0, bArr4, 0, iA);
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] a(byte[] bArr, byte[] bArr2, int i2, int i3) {
        a(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] b(int i2) {
        if ((i2 & 16) == 16) {
            return f107d;
        }
        if ((i2 & 32) == 32) {
            return f4718f;
        }
        return f104b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] bArrA = a(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
        if (i3 == 1) {
            bArr2[i4] = bArrA[i6 >>> 18];
            bArr2[i4 + 1] = bArrA[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        }
        if (i3 == 2) {
            bArr2[i4] = bArrA[i6 >>> 18];
            bArr2[i4 + 1] = bArrA[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = bArrA[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        }
        if (i3 != 3) {
            return bArr2;
        }
        bArr2[i4] = bArrA[i6 >>> 18];
        bArr2[i4 + 1] = bArrA[(i6 >>> 12) & 63];
        bArr2[i4 + 2] = bArrA[(i6 >>> 6) & 63];
        bArr2[i4 + 3] = bArrA[i6 & 63];
        return bArr2;
    }

    public static String b(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : a(bArr);
    }

    public static byte[] b(String str) throws Throwable {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                if (file.length() <= 2147483647L) {
                    byte[] bArr = new byte[(int) file.length()];
                    a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 0);
                    int i2 = 0;
                    while (true) {
                        try {
                            int i3 = aVar2.read(bArr, i2, 4096);
                            if (i3 < 0) {
                                break;
                            }
                            i2 += i3;
                        } catch (IOException e2) {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            aVar = aVar2;
                            try {
                                aVar.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    }
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    try {
                        aVar2.close();
                    } catch (Exception unused2) {
                    }
                    return bArr2;
                }
                throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            a(bArr2, bArr, iMin, 0);
            byteBuffer2.put(bArr2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:55:0x005c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static byte[] decode(java.lang.String r5, int r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Input string was null."
            java.util.Objects.requireNonNull(r5, r0)
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> Lc
            goto L10
        Lc:
            byte[] r5 = r5.getBytes()
        L10:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = decode(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L1d
            r6 = 1
            goto L1e
        L1d:
            r6 = 0
        L1e:
            if (r5 == 0) goto L90
            int r3 = r5.length
            if (r3 < r0) goto L90
            if (r6 != 0) goto L90
            r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L90
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7b
            r2.<init>()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7b
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L72
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L72
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
        L4b:
            int r0 = r4.read(r6)     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L65
            if (r0 < 0) goto L55
            r2.write(r6, r1, r0)     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L65
            goto L4b
        L55:
            byte[] r5 = r2.toByteArray()     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L65
            r2.close()     // Catch: java.lang.Exception -> L5c
        L5c:
            r4.close()     // Catch: java.lang.Exception -> L5f
        L5f:
            r3.close()     // Catch: java.lang.Exception -> L90
            goto L90
        L63:
            r5 = move-exception
            goto L70
        L65:
            r6 = move-exception
            goto L75
        L67:
            r5 = move-exception
            r4 = r0
            goto L70
        L6a:
            r6 = move-exception
            r4 = r0
            goto L75
        L6d:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L70:
            r0 = r2
            goto L86
        L72:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L75:
            r0 = r2
            goto L7e
        L77:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L86
        L7b:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L7e:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L85
            r0.close()     // Catch: java.lang.Exception -> L5c
            goto L5c
        L85:
            r5 = move-exception
        L86:
            r0.close()     // Catch: java.lang.Exception -> L89
        L89:
            r4.close()     // Catch: java.lang.Exception -> L8c
        L8c:
            r3.close()     // Catch: java.lang.Exception -> L8f
        L8f:
            throw r5
        L90:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.man.crashreporter.e.b.decode(java.lang.String, int):byte[]");
    }

    public static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            a(bArr2, bArr, iMin, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & f4716d));
            }
        }
    }

    public static String a(Serializable serializable) throws IOException {
        return a(serializable, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static String a(Serializable serializable, int i2) throws Throwable {
        ?? gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        C0064b c0064b;
        ObjectOutputStream objectOutputStream;
        Objects.requireNonNull(serializable, "Cannot serialize a null object.");
        ObjectOutputStream objectOutputStream2 = null;
        objectOutputStream2 = null;
        objectOutputStream2 = null;
        objectOutputStream2 = null;
        objectOutputStream2 = null;
        objectOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c0064b = new C0064b(byteArrayOutputStream, i2 | 1);
                try {
                    if ((i2 & 2) != 0) {
                        gZIPOutputStream = new GZIPOutputStream(c0064b);
                        try {
                            objectOutputStream2 = new ObjectOutputStream(gZIPOutputStream);
                            gZIPOutputStream = gZIPOutputStream;
                        } catch (IOException e2) {
                            e = e2;
                            objectOutputStream = objectOutputStream2;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            gZIPOutputStream = gZIPOutputStream;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                ObjectOutputStream objectOutputStream3 = objectOutputStream;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                objectOutputStream2 = objectOutputStream3;
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    c0064b.close();
                                } catch (Exception unused3) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream2.close();
                            gZIPOutputStream.close();
                            c0064b.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } else {
                        objectOutputStream2 = new ObjectOutputStream(c0064b);
                        gZIPOutputStream = 0;
                    }
                    objectOutputStream2.writeObject(serializable);
                    try {
                        objectOutputStream2.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused6) {
                    }
                    try {
                        c0064b.close();
                    } catch (Exception unused7) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused8) {
                    }
                    try {
                        return new String(byteArrayOutputStream.toByteArray(), "US-ASCII");
                    } catch (UnsupportedEncodingException unused9) {
                        return new String(byteArrayOutputStream.toByteArray());
                    }
                } catch (IOException e3) {
                    e = e3;
                    ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    objectOutputStream = objectOutputStream4;
                    gZIPOutputStream = objectOutputStream4;
                } catch (Throwable th3) {
                    th = th3;
                    gZIPOutputStream = objectOutputStream2;
                }
            } catch (IOException e4) {
                e = e4;
                gZIPOutputStream = 0;
                c0064b = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                objectOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream = 0;
                c0064b = null;
            }
        } catch (IOException e5) {
            e = e5;
            gZIPOutputStream = 0;
            objectOutputStream = null;
            c0064b = null;
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream = 0;
            byteArrayOutputStream = null;
            c0064b = null;
        }
    }

    public static String a(byte[] bArr) throws Throwable {
        String strA;
        try {
            strA = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!f105c) {
                throw new AssertionError(e2.getMessage());
            }
            strA = null;
        }
        if (f105c || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2) throws IOException {
        return a(bArr, 0, bArr.length, i2);
    }

    public static String a(byte[] bArr, int i2, int i3) throws Throwable {
        String strA;
        try {
            strA = a(bArr, i2, i3, 0);
        } catch (IOException e2) {
            if (!f105c) {
                throw new AssertionError(e2.getMessage());
            }
            strA = null;
        }
        if (f105c || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2, int i3, int i4) throws Throwable {
        byte[] bArrM53a = m53a(bArr, i2, i3, i4);
        try {
            return new String(bArrM53a, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrM53a);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m52a(byte[] bArr) {
        try {
            return m53a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (f105c) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m53a(byte[] bArr, int i2, int i3, int i4) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        C0064b c0064b;
        GZIPOutputStream gZIPOutputStream;
        Objects.requireNonNull(bArr, "Cannot serialize a null array.");
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        }
        if (i3 >= 0) {
            if (i2 + i3 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            }
            if ((i4 & 2) != 0) {
                GZIPOutputStream gZIPOutputStream2 = null;
                gZIPOutputStream2 = null;
                gZIPOutputStream2 = null;
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        c0064b = new C0064b(byteArrayOutputStream, i4 | 1);
                    } catch (IOException e2) {
                        e = e2;
                        c0064b = null;
                        gZIPOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        c0064b = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    c0064b = null;
                    gZIPOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    c0064b = null;
                }
                try {
                    gZIPOutputStream = new GZIPOutputStream(c0064b);
                    try {
                        gZIPOutputStream.write(bArr, i2, i3);
                        gZIPOutputStream.close();
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            c0064b.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e4) {
                        e = e4;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            throw e;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            gZIPOutputStream2 = gZIPOutputStream;
                            try {
                                gZIPOutputStream2.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                c0064b.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (Exception unused6) {
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        gZIPOutputStream2 = gZIPOutputStream;
                        gZIPOutputStream2.close();
                        c0064b.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    gZIPOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    gZIPOutputStream2.close();
                    c0064b.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } else {
                boolean z = (i4 & 8) != 0;
                int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
                if (z) {
                    i5 += i5 / 76;
                }
                int i6 = i5;
                byte[] bArr2 = new byte[i6];
                int i7 = i3 - 2;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (i8 < i7) {
                    int i11 = i8;
                    a(bArr, i8 + i2, 3, bArr2, i9, i4);
                    int i12 = i10 + 4;
                    if (!z || i12 < 76) {
                        i10 = i12;
                    } else {
                        bArr2[i9 + 4] = 10;
                        i9++;
                        i10 = 0;
                    }
                    i8 = i11 + 3;
                    i9 += 4;
                }
                int i13 = i8;
                if (i13 < i3) {
                    a(bArr, i13 + i2, i3 - i13, bArr2, i9, i4);
                    i9 += 4;
                }
                int i14 = i9;
                if (i14 > i6 - 1) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i14];
                System.arraycopy(bArr2, 0, bArr3, 0, i14);
                return bArr3;
            }
        } else {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        Objects.requireNonNull(bArr, "Source array was null.");
        Objects.requireNonNull(bArr2, "Destination array was null.");
        if (i2 >= 0 && (i5 = i2 + 3) < bArr.length) {
            if (i3 >= 0 && (i6 = i3 + 2) < bArr2.length) {
                byte[] bArrB = b(i4);
                int i7 = i2 + 2;
                if (bArr[i7] == 61) {
                    bArr2[i3] = (byte) ((((bArrB[bArr[i2 + 1]] & f4716d) << 12) | ((bArrB[bArr[i2]] & f4716d) << 18)) >>> 16);
                    return 1;
                }
                if (bArr[i5] == 61) {
                    int i8 = ((bArrB[bArr[i7]] & f4716d) << 6) | ((bArrB[bArr[i2 + 1]] & f4716d) << 12) | ((bArrB[bArr[i2]] & f4716d) << 18);
                    bArr2[i3] = (byte) (i8 >>> 16);
                    bArr2[i3 + 1] = (byte) (i8 >>> 8);
                    return 2;
                }
                int i9 = (bArrB[bArr[i5]] & f4716d) | ((bArrB[bArr[i2 + 1]] & f4716d) << 12) | ((bArrB[bArr[i2]] & f4716d) << 18) | ((bArrB[bArr[i7]] & f4716d) << 6);
                bArr2[i3] = (byte) (i9 >> 16);
                bArr2[i3 + 1] = (byte) (i9 >> 8);
                bArr2[i6] = (byte) i9;
                return 3;
            }
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
        }
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m51a(String str) throws IOException {
        return decode(str, 0);
    }

    public static Object a(String str) throws IOException, ClassNotFoundException {
        return a(str, 0, (ClassLoader) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static Object a(String str, int i2, final ClassLoader classLoader) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        byte[] bArrDecode = decode(str, i2);
        ByteArrayInputStream byteArrayInputStream2 = null;
        objectInputStream = null;
        objectInputStream = null;
        ObjectInputStream objectInputStream2 = null;
        byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArrDecode);
            } catch (IOException e2) {
                throw e2;
            } catch (ClassNotFoundException e3) {
                throw e3;
            } catch (Throwable th) {
                th = th;
                classLoader = 0;
            }
            try {
                if (classLoader == 0) {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } else {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream) { // from class: com.alibaba.sdk.android.man.crashreporter.e.b.1
                        @Override // java.io.ObjectInputStream
                        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
                            Class<?> cls = Class.forName(objectStreamClass.getName(), false, classLoader);
                            return cls == null ? super.resolveClass(objectStreamClass) : cls;
                        }
                    };
                }
                objectInputStream2 = objectInputStream;
                Object object = objectInputStream2.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused) {
                }
                try {
                    objectInputStream2.close();
                } catch (Exception unused2) {
                }
                return object;
            } catch (IOException e4) {
                throw e4;
            } catch (ClassNotFoundException e5) {
                throw e5;
            } catch (Throwable th2) {
                th = th2;
                classLoader = objectInputStream2;
                byteArrayInputStream2 = byteArrayInputStream;
                try {
                    byteArrayInputStream2.close();
                } catch (Exception unused3) {
                }
                try {
                    classLoader.close();
                    throw th;
                } catch (Exception unused4) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(byte[] bArr, String str) throws Throwable {
        Objects.requireNonNull(bArr, "Data to encode was null.");
        C0064b c0064b = null;
        try {
            try {
                C0064b c0064b2 = new C0064b(new FileOutputStream(str), 1);
                try {
                    c0064b2.write(bArr);
                    try {
                        c0064b2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    c0064b = c0064b2;
                    try {
                        c0064b.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }
}
