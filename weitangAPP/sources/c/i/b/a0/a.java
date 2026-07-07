package c.i.b.a0;

import c.i.b.y.e;
import com.google.zxing.oned.rss.expanded.decoders.DecodedChar;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import org.apache.commons.codec.language.bm.ResourceConstants;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f2568a = ")]}'\n".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reader f2569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2570c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f2571d = new char[1024];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2572e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2573f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2574g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2575h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2576i = 0;
    public long j;
    public int k;
    public String l;
    public int[] m;
    public int n;
    public String[] o;
    public int[] p;

    /* JADX INFO: renamed from: c.i.b.a0.a$a, reason: collision with other inner class name */
    public static class C0032a extends e {
        @Override // c.i.b.y.e
        public void promoteNameToValue(a aVar) throws IOException {
            if (aVar instanceof c.i.b.y.m.a) {
                ((c.i.b.y.m.a) aVar).promoteNameToValue();
                return;
            }
            int iC = aVar.f2576i;
            if (iC == 0) {
                iC = aVar.c();
            }
            if (iC == 13) {
                aVar.f2576i = 9;
                return;
            }
            if (iC == 12) {
                aVar.f2576i = 8;
                return;
            }
            if (iC == 14) {
                aVar.f2576i = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.peek() + aVar.f());
        }
    }

    static {
        e.f2653a = new C0032a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.m = iArr;
        this.n = 0;
        this.n = 0 + 1;
        iArr[0] = 6;
        this.o = new String[32];
        this.p = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f2569b = reader;
    }

    public final void a() throws IOException {
        if (!this.f2570c) {
            throw r("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final void b() throws IOException {
        g(true);
        int i2 = this.f2572e - 1;
        this.f2572e = i2;
        char[] cArr = f2568a;
        if (i2 + cArr.length > this.f2573f && !d(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = f2568a;
            if (i3 >= cArr2.length) {
                this.f2572e += cArr2.length;
                return;
            } else if (this.f2571d[this.f2572e + i3] != cArr2[i3]) {
                return;
            } else {
                i3++;
            }
        }
    }

    public void beginArray() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 3) {
            l(1);
            this.p[this.n - 1] = 0;
            this.f2576i = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + f());
        }
    }

    public void beginObject() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 1) {
            l(3);
            this.f2576i = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + f());
        }
    }

    public int c() throws IOException {
        int iG;
        int[] iArr = this.m;
        int i2 = this.n;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iG2 = g(true);
            if (iG2 != 44) {
                if (iG2 != 59) {
                    if (iG2 != 93) {
                        throw r("Unterminated array");
                    }
                    this.f2576i = 4;
                    return 4;
                }
                a();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5 && (iG = g(true)) != 44) {
                    if (iG != 59) {
                        if (iG != 125) {
                            throw r("Unterminated object");
                        }
                        this.f2576i = 2;
                        return 2;
                    }
                    a();
                }
                int iG3 = g(true);
                if (iG3 == 34) {
                    this.f2576i = 13;
                    return 13;
                }
                if (iG3 == 39) {
                    a();
                    this.f2576i = 12;
                    return 12;
                }
                if (iG3 == 125) {
                    if (i3 == 5) {
                        throw r("Expected name");
                    }
                    this.f2576i = 2;
                    return 2;
                }
                a();
                this.f2572e--;
                if (!e((char) iG3)) {
                    throw r("Expected name");
                }
                this.f2576i = 14;
                return 14;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iG4 = g(true);
                if (iG4 != 58) {
                    if (iG4 != 61) {
                        throw r("Expected ':'");
                    }
                    a();
                    if (this.f2572e < this.f2573f || d(1)) {
                        char[] cArr = this.f2571d;
                        int i4 = this.f2572e;
                        if (cArr[i4] == '>') {
                            this.f2572e = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.f2570c) {
                    b();
                }
                this.m[this.n - 1] = 7;
            } else if (i3 == 7) {
                if (g(false) == -1) {
                    this.f2576i = 17;
                    return 17;
                }
                a();
                this.f2572e--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iG5 = g(true);
        if (iG5 == 34) {
            this.f2576i = 9;
            return 9;
        }
        if (iG5 == 39) {
            a();
            this.f2576i = 8;
            return 8;
        }
        if (iG5 != 44 && iG5 != 59) {
            if (iG5 == 91) {
                this.f2576i = 3;
                return 3;
            }
            if (iG5 != 93) {
                if (iG5 == 123) {
                    this.f2576i = 1;
                    return 1;
                }
                this.f2572e--;
                int iJ = j();
                if (iJ != 0) {
                    return iJ;
                }
                int iK = k();
                if (iK != 0) {
                    return iK;
                }
                if (!e(this.f2571d[this.f2572e])) {
                    throw r("Expected value");
                }
                a();
                this.f2576i = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f2576i = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw r("Unexpected value");
        }
        a();
        this.f2572e--;
        this.f2576i = 7;
        return 7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2576i = 0;
        this.m[0] = 8;
        this.n = 1;
        this.f2569b.close();
    }

    public final boolean d(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f2571d;
        int i5 = this.f2575h;
        int i6 = this.f2572e;
        this.f2575h = i5 - i6;
        int i7 = this.f2573f;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f2573f = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f2573f = 0;
        }
        this.f2572e = 0;
        do {
            Reader reader = this.f2569b;
            int i9 = this.f2573f;
            int i10 = reader.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.f2573f + i10;
            this.f2573f = i3;
            if (this.f2574g == 0 && (i4 = this.f2575h) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f2572e++;
                this.f2575h = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public final boolean e(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        a();
        return false;
    }

    public void endArray() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + f());
        }
        int i2 = this.n - 1;
        this.n = i2;
        int[] iArr = this.p;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f2576i = 0;
    }

    public void endObject() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + f());
        }
        int i2 = this.n - 1;
        this.n = i2;
        this.o[i2] = null;
        int[] iArr = this.p;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f2576i = 0;
    }

    public String f() {
        return " at line " + (this.f2574g + 1) + " column " + ((this.f2572e - this.f2575h) + 1) + " path " + getPath();
    }

    public final int g(boolean z) throws IOException {
        char[] cArr = this.f2571d;
        int i2 = this.f2572e;
        int i3 = this.f2573f;
        while (true) {
            if (i2 == i3) {
                this.f2572e = i2;
                if (!d(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + f());
                }
                i2 = this.f2572e;
                i3 = this.f2573f;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f2574g++;
                this.f2575h = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f2572e = i4;
                    if (i4 == i3) {
                        this.f2572e = i4 - 1;
                        boolean zD = d(2);
                        this.f2572e++;
                        if (!zD) {
                            return c2;
                        }
                    }
                    a();
                    int i5 = this.f2572e;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f2572e = i5 + 1;
                        if (!o(ResourceConstants.EXT_CMT_END)) {
                            throw r("Unterminated comment");
                        }
                        i2 = this.f2572e + 2;
                        i3 = this.f2573f;
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f2572e = i5 + 1;
                        p();
                        i2 = this.f2572e;
                        i3 = this.f2573f;
                    }
                } else {
                    if (c2 != '#') {
                        this.f2572e = i4;
                        return c2;
                    }
                    this.f2572e = i4;
                    a();
                    p();
                    i2 = this.f2572e;
                    i3 = this.f2573f;
                }
            }
            i2 = i4;
        }
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(DecodedChar.FNC1);
        int i2 = this.n;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.m[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.p[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.o;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f2572e = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String h(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f2571d
            r1 = 0
        L3:
            int r2 = r9.f2572e
            int r3 = r9.f2573f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f2572e = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4f
            r9.f2572e = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L40
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L40:
            r1.append(r0, r3, r7)
            char r2 = r9.m()
            r1.append(r2)
            int r2 = r9.f2572e
            int r3 = r9.f2573f
            goto L7
        L4f:
            r5 = 10
            if (r2 != r5) goto L5a
            int r2 = r9.f2574g
            int r2 = r2 + r6
            r9.f2574g = r2
            r9.f2575h = r7
        L5a:
            r2 = r7
            goto L9
        L5c:
            if (r1 != 0) goto L6c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f2572e = r2
            boolean r2 = r9.d(r6)
            if (r2 == 0) goto L7a
            goto L3
        L7a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.r(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: c.i.b.a0.a.h(char):java.lang.String");
    }

    public boolean hasNext() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        return (iC == 2 || iC == 4) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        a();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String i() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.f2572e
            int r4 = r3 + r2
            int r5 = r6.f2573f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f2571d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.a()
            goto L5c
        L4e:
            char[] r3 = r6.f2571d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.d(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L7e
        L5e:
            if (r1 != 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L6b:
            char[] r3 = r6.f2571d
            int r4 = r6.f2572e
            r1.append(r3, r4, r2)
            int r3 = r6.f2572e
            int r3 = r3 + r2
            r6.f2572e = r3
            r2 = 1
            boolean r2 = r6.d(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r1 != 0) goto L8a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f2571d
            int r3 = r6.f2572e
            r1.<init>(r2, r3, r0)
            goto L95
        L8a:
            char[] r2 = r6.f2571d
            int r3 = r6.f2572e
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L95:
            int r2 = r6.f2572e
            int r2 = r2 + r0
            r6.f2572e = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.i.b.a0.a.i():java.lang.String");
    }

    public final boolean isLenient() {
        return this.f2570c;
    }

    public final int j() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f2571d[this.f2572e];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f2572e + i3 >= this.f2573f && !d(i3 + 1)) {
                return 0;
            }
            char c3 = this.f2571d[this.f2572e + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f2572e + length < this.f2573f || d(length + 1)) && e(this.f2571d[this.f2572e + length])) {
            return 0;
        }
        this.f2572e += length;
        this.f2576i = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
    
        if (e(r14) != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
    
        if (r9 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
    
        if (r10 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
    
        if (r13 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
    
        if (r11 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
    
        if (r13 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ae, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00af, code lost:
    
        r18.j = r11;
        r18.f2572e += r8;
        r18.f2576i = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bb, code lost:
    
        if (r9 == 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00be, code lost:
    
        if (r9 == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
    
        if (r9 != 7) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c4, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c6, code lost:
    
        r18.k = r8;
        r18.f2576i = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cc, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cd, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int k() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.i.b.a0.a.k():int");
    }

    public final void l(int i2) {
        int i3 = this.n;
        int[] iArr = this.m;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            int[] iArr3 = new int[i3 * 2];
            String[] strArr = new String[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.p, 0, iArr3, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr2;
            this.p = iArr3;
            this.o = strArr;
        }
        int[] iArr4 = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iArr4[i4] = i2;
    }

    public final char m() throws IOException {
        int i2;
        int i3;
        if (this.f2572e == this.f2573f && !d(1)) {
            throw r("Unterminated escape sequence");
        }
        char[] cArr = this.f2571d;
        int i4 = this.f2572e;
        int i5 = i4 + 1;
        this.f2572e = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f2574g++;
            this.f2575h = i5;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 == 'b') {
                return '\b';
            }
            if (c2 == 'f') {
                return '\f';
            }
            if (c2 == 'n') {
                return '\n';
            }
            if (c2 == 'r') {
                return '\r';
            }
            if (c2 == 't') {
                return '\t';
            }
            if (c2 != 'u') {
                throw r("Invalid escape sequence");
            }
            if (i5 + 4 > this.f2573f && !d(4)) {
                throw r("Unterminated escape sequence");
            }
            char c3 = 0;
            int i6 = this.f2572e;
            int i7 = i6 + 4;
            while (i6 < i7) {
                char c4 = this.f2571d[i6];
                char c5 = (char) (c3 << 4);
                if (c4 < '0' || c4 > '9') {
                    if (c4 >= 'a' && c4 <= 'f') {
                        i2 = c4 - 'a';
                    } else {
                        if (c4 < 'A' || c4 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f2571d, this.f2572e, 4));
                        }
                        i2 = c4 - 'A';
                    }
                    i3 = i2 + 10;
                } else {
                    i3 = c4 - '0';
                }
                c3 = (char) (c5 + i3);
                i6++;
            }
            this.f2572e += 4;
            return c3;
        }
        return c2;
    }

    public final void n(char c2) throws IOException {
        char[] cArr = this.f2571d;
        do {
            int i2 = this.f2572e;
            int i3 = this.f2573f;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f2572e = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f2572e = i4;
                    m();
                    i2 = this.f2572e;
                    i3 = this.f2573f;
                } else {
                    if (c3 == '\n') {
                        this.f2574g++;
                        this.f2575h = i4;
                    }
                    i2 = i4;
                }
            }
            this.f2572e = i2;
        } while (d(1));
        throw r("Unterminated string");
    }

    public boolean nextBoolean() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 5) {
            this.f2576i = 0;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iC == 6) {
            this.f2576i = 0;
            int[] iArr2 = this.p;
            int i3 = this.n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + f());
    }

    public double nextDouble() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            this.f2576i = 0;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.j;
        }
        if (iC == 16) {
            this.l = new String(this.f2571d, this.f2572e, this.k);
            this.f2572e += this.k;
        } else if (iC == 8 || iC == 9) {
            this.l = h(iC == 8 ? '\'' : '\"');
        } else if (iC == 10) {
            this.l = i();
        } else if (iC != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + f());
        }
        this.f2576i = 11;
        double d2 = Double.parseDouble(this.l);
        if (!this.f2570c && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new d("JSON forbids NaN and infinities: " + d2 + f());
        }
        this.l = null;
        this.f2576i = 0;
        int[] iArr2 = this.p;
        int i3 = this.n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }

    public int nextInt() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            long j = this.j;
            int i2 = (int) j;
            if (j == i2) {
                this.f2576i = 0;
                int[] iArr = this.p;
                int i3 = this.n - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.j + f());
        }
        if (iC == 16) {
            this.l = new String(this.f2571d, this.f2572e, this.k);
            this.f2572e += this.k;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + f());
            }
            if (iC == 10) {
                this.l = i();
            } else {
                this.l = h(iC == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.l);
                this.f2576i = 0;
                int[] iArr2 = this.p;
                int i5 = this.n - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f2576i = 11;
        double d2 = Double.parseDouble(this.l);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.l + f());
        }
        this.l = null;
        this.f2576i = 0;
        int[] iArr3 = this.p;
        int i7 = this.n - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public long nextLong() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            this.f2576i = 0;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.j;
        }
        if (iC == 16) {
            this.l = new String(this.f2571d, this.f2572e, this.k);
            this.f2572e += this.k;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + f());
            }
            if (iC == 10) {
                this.l = i();
            } else {
                this.l = h(iC == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.l);
                this.f2576i = 0;
                int[] iArr2 = this.p;
                int i3 = this.n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.f2576i = 11;
        double d2 = Double.parseDouble(this.l);
        long j2 = (long) d2;
        if (j2 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.l + f());
        }
        this.l = null;
        this.f2576i = 0;
        int[] iArr3 = this.p;
        int i4 = this.n - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j2;
    }

    public String nextName() throws IOException {
        String strH;
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 14) {
            strH = i();
        } else if (iC == 12) {
            strH = h('\'');
        } else {
            if (iC != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + f());
            }
            strH = h('\"');
        }
        this.f2576i = 0;
        this.o[this.n - 1] = strH;
        return strH;
    }

    public void nextNull() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 7) {
            this.f2576i = 0;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + f());
    }

    public String nextString() throws IOException {
        String str;
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 10) {
            str = i();
        } else if (iC == 8) {
            str = h('\'');
        } else if (iC == 9) {
            str = h('\"');
        } else if (iC == 11) {
            str = this.l;
            this.l = null;
        } else if (iC == 15) {
            str = Long.toString(this.j);
        } else {
            if (iC != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + f());
            }
            str = new String(this.f2571d, this.f2572e, this.k);
            this.f2572e += this.k;
        }
        this.f2576i = 0;
        int[] iArr = this.p;
        int i2 = this.n - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final boolean o(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f2572e + length > this.f2573f && !d(length)) {
                return false;
            }
            char[] cArr = this.f2571d;
            int i2 = this.f2572e;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f2571d[this.f2572e + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f2574g++;
            this.f2575h = i2 + 1;
            this.f2572e++;
        }
    }

    public final void p() throws IOException {
        char c2;
        do {
            if (this.f2572e >= this.f2573f && !d(1)) {
                return;
            }
            char[] cArr = this.f2571d;
            int i2 = this.f2572e;
            int i3 = i2 + 1;
            this.f2572e = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f2574g++;
                this.f2575h = i3;
                return;
            }
        } while (c2 != '\r');
    }

    public b peek() throws IOException {
        int iC = this.f2576i;
        if (iC == 0) {
            iC = c();
        }
        switch (iC) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f2572e
            int r2 = r1 + r0
            int r3 = r4.f2573f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f2571d
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.a()
        L4b:
            int r1 = r4.f2572e
            int r1 = r1 + r0
            r4.f2572e = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f2572e = r1
            r0 = 1
            boolean r0 = r4.d(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.i.b.a0.a.q():void");
    }

    public final IOException r(String str) throws IOException {
        throw new d(str + f());
    }

    public final void setLenient(boolean z) {
        this.f2570c = z;
    }

    public void skipValue() throws IOException {
        int i2 = 0;
        do {
            int iC = this.f2576i;
            if (iC == 0) {
                iC = c();
            }
            if (iC == 3) {
                l(1);
            } else if (iC == 1) {
                l(3);
            } else if (iC == 4 || iC == 2) {
                this.n--;
                i2--;
                this.f2576i = 0;
            } else {
                if (iC == 14 || iC == 10) {
                    q();
                } else if (iC == 8 || iC == 12) {
                    n('\'');
                } else if (iC == 9 || iC == 13) {
                    n('\"');
                } else if (iC == 16) {
                    this.f2572e += this.k;
                }
                this.f2576i = 0;
            }
            i2++;
            this.f2576i = 0;
        } while (i2 != 0);
        int[] iArr = this.p;
        int i3 = this.n;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.o[i3 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + f();
    }
}
