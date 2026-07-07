package c.i.b.a0;

import com.alipay.sdk.m.u.i;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f2578a = new String[128];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f2579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Writer f2580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f2581d = new int[32];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2582e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2586i;
    public String j;
    public boolean k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f2578a[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f2578a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f2579b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        f(6);
        this.f2584g = ":";
        this.k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f2580c = writer;
    }

    public final void a() throws IOException {
        int iPeek = peek();
        if (iPeek == 5) {
            this.f2580c.write(44);
        } else if (iPeek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        d();
        g(4);
    }

    public final void b() throws IOException {
        int iPeek = peek();
        if (iPeek == 1) {
            g(2);
            d();
            return;
        }
        if (iPeek == 2) {
            this.f2580c.append(',');
            d();
        } else {
            if (iPeek == 4) {
                this.f2580c.append((CharSequence) this.f2584g);
                g(5);
                return;
            }
            if (iPeek != 6) {
                if (iPeek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f2585h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            g(7);
        }
    }

    public c beginArray() throws IOException {
        i();
        return e(1, "[");
    }

    public c beginObject() throws IOException {
        i();
        return e(3, "{");
    }

    public final c c(int i2, int i3, String str) throws IOException {
        int iPeek = peek();
        if (iPeek != i3 && iPeek != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        }
        this.f2582e--;
        if (iPeek == i3) {
            d();
        }
        this.f2580c.write(str);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2580c.close();
        int i2 = this.f2582e;
        if (i2 > 1 || (i2 == 1 && this.f2581d[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f2582e = 0;
    }

    public final void d() throws IOException {
        if (this.f2583f == null) {
            return;
        }
        this.f2580c.write("\n");
        int i2 = this.f2582e;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f2580c.write(this.f2583f);
        }
    }

    public final c e(int i2, String str) throws IOException {
        b();
        f(i2);
        this.f2580c.write(str);
        return this;
    }

    public c endArray() throws IOException {
        return c(1, 2, "]");
    }

    public c endObject() throws IOException {
        return c(3, 5, i.f5699d);
    }

    public final void f(int i2) {
        int i3 = this.f2582e;
        int[] iArr = this.f2581d;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f2581d = iArr2;
        }
        int[] iArr3 = this.f2581d;
        int i4 = this.f2582e;
        this.f2582e = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f2582e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f2580c.flush();
    }

    public final void g(int i2) {
        this.f2581d[this.f2582e - 1] = i2;
    }

    public final boolean getSerializeNulls() {
        return this.k;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f2586i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = c.i.b.a0.c.f2579b
            goto L9
        L7:
            java.lang.String[] r0 = c.i.b.a0.c.f2578a
        L9:
            java.io.Writer r1 = r8.f2580c
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f2580c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f2580c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f2580c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f2580c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.i.b.a0.c.h(java.lang.String):void");
    }

    public final void i() throws IOException {
        if (this.j != null) {
            a();
            h(this.j);
            this.j = null;
        }
    }

    public final boolean isHtmlSafe() {
        return this.f2586i;
    }

    public boolean isLenient() {
        return this.f2585h;
    }

    public c jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        i();
        b();
        this.f2580c.append((CharSequence) str);
        return this;
    }

    public c name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.j != null) {
            throw new IllegalStateException();
        }
        if (this.f2582e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j = str;
        return this;
    }

    public c nullValue() throws IOException {
        if (this.j != null) {
            if (!this.k) {
                this.j = null;
                return this;
            }
            i();
        }
        b();
        this.f2580c.write("null");
        return this;
    }

    public final int peek() {
        int i2 = this.f2582e;
        if (i2 != 0) {
            return this.f2581d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void setHtmlSafe(boolean z) {
        this.f2586i = z;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.f2583f = null;
            this.f2584g = ":";
        } else {
            this.f2583f = str;
            this.f2584g = ": ";
        }
    }

    public final void setLenient(boolean z) {
        this.f2585h = z;
    }

    public final void setSerializeNulls(boolean z) {
        this.k = z;
    }

    public c value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        i();
        b();
        h(str);
        return this;
    }

    public c value(boolean z) throws IOException {
        i();
        b();
        this.f2580c.write(z ? "true" : "false");
        return this;
    }

    public c value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        i();
        b();
        this.f2580c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c value(double d2) throws IOException {
        i();
        if (!this.f2585h && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        b();
        this.f2580c.append((CharSequence) Double.toString(d2));
        return this;
    }

    public c value(long j) throws IOException {
        i();
        b();
        this.f2580c.write(Long.toString(j));
        return this;
    }

    public c value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        i();
        String string = number.toString();
        if (!this.f2585h && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        b();
        this.f2580c.append((CharSequence) string);
        return this;
    }
}
