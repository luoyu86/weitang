package c.i.b.y.m;

import c.i.b.i;
import c.i.b.l;
import c.i.b.n;
import c.i.b.o;
import c.i.b.q;
import com.google.zxing.oned.rss.expanded.decoders.DecodedChar;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c.i.b.a0.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Reader f2689q = new C0038a();
    public static final Object r = new Object();
    public Object[] s;
    public int t;
    public String[] u;
    public int[] v;

    /* JADX INFO: renamed from: c.i.b.y.m.a$a, reason: collision with other inner class name */
    public static class C0038a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    public a(l lVar) {
        super(f2689q);
        this.s = new Object[32];
        this.t = 0;
        this.u = new String[32];
        this.v = new int[32];
        v(lVar);
    }

    private String f() {
        return " at path " + getPath();
    }

    @Override // c.i.b.a0.a
    public void beginArray() throws IOException {
        s(c.i.b.a0.b.BEGIN_ARRAY);
        v(((i) t()).iterator());
        this.v[this.t - 1] = 0;
    }

    @Override // c.i.b.a0.a
    public void beginObject() throws IOException {
        s(c.i.b.a0.b.BEGIN_OBJECT);
        v(((o) t()).entrySet().iterator());
    }

    @Override // c.i.b.a0.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.s = new Object[]{r};
        this.t = 1;
    }

    @Override // c.i.b.a0.a
    public void endArray() throws IOException {
        s(c.i.b.a0.b.END_ARRAY);
        u();
        u();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // c.i.b.a0.a
    public void endObject() throws IOException {
        s(c.i.b.a0.b.END_OBJECT);
        u();
        u();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // c.i.b.a0.a
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(DecodedChar.FNC1);
        int i2 = 0;
        while (i2 < this.t) {
            Object[] objArr = this.s;
            if (objArr[i2] instanceof i) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.v[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof o) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.u;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    @Override // c.i.b.a0.a
    public boolean hasNext() throws IOException {
        c.i.b.a0.b bVarPeek = peek();
        return (bVarPeek == c.i.b.a0.b.END_OBJECT || bVarPeek == c.i.b.a0.b.END_ARRAY) ? false : true;
    }

    @Override // c.i.b.a0.a
    public boolean nextBoolean() throws IOException {
        s(c.i.b.a0.b.BOOLEAN);
        boolean asBoolean = ((q) u()).getAsBoolean();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asBoolean;
    }

    @Override // c.i.b.a0.a
    public double nextDouble() throws IOException {
        c.i.b.a0.b bVarPeek = peek();
        c.i.b.a0.b bVar = c.i.b.a0.b.NUMBER;
        if (bVarPeek != bVar && bVarPeek != c.i.b.a0.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarPeek + f());
        }
        double asDouble = ((q) t()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        u();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asDouble;
    }

    @Override // c.i.b.a0.a
    public int nextInt() throws IOException {
        c.i.b.a0.b bVarPeek = peek();
        c.i.b.a0.b bVar = c.i.b.a0.b.NUMBER;
        if (bVarPeek != bVar && bVarPeek != c.i.b.a0.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarPeek + f());
        }
        int asInt = ((q) t()).getAsInt();
        u();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asInt;
    }

    @Override // c.i.b.a0.a
    public long nextLong() throws IOException {
        c.i.b.a0.b bVarPeek = peek();
        c.i.b.a0.b bVar = c.i.b.a0.b.NUMBER;
        if (bVarPeek != bVar && bVarPeek != c.i.b.a0.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarPeek + f());
        }
        long asLong = ((q) t()).getAsLong();
        u();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asLong;
    }

    @Override // c.i.b.a0.a
    public String nextName() throws IOException {
        s(c.i.b.a0.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        String str = (String) entry.getKey();
        this.u[this.t - 1] = str;
        v(entry.getValue());
        return str;
    }

    @Override // c.i.b.a0.a
    public void nextNull() throws IOException {
        s(c.i.b.a0.b.NULL);
        u();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // c.i.b.a0.a
    public String nextString() throws IOException {
        c.i.b.a0.b bVarPeek = peek();
        c.i.b.a0.b bVar = c.i.b.a0.b.STRING;
        if (bVarPeek == bVar || bVarPeek == c.i.b.a0.b.NUMBER) {
            String asString = ((q) u()).getAsString();
            int i2 = this.t;
            if (i2 > 0) {
                int[] iArr = this.v;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return asString;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarPeek + f());
    }

    @Override // c.i.b.a0.a
    public c.i.b.a0.b peek() throws IOException {
        if (this.t == 0) {
            return c.i.b.a0.b.END_DOCUMENT;
        }
        Object objT = t();
        if (objT instanceof Iterator) {
            boolean z = this.s[this.t - 2] instanceof o;
            Iterator it = (Iterator) objT;
            if (!it.hasNext()) {
                return z ? c.i.b.a0.b.END_OBJECT : c.i.b.a0.b.END_ARRAY;
            }
            if (z) {
                return c.i.b.a0.b.NAME;
            }
            v(it.next());
            return peek();
        }
        if (objT instanceof o) {
            return c.i.b.a0.b.BEGIN_OBJECT;
        }
        if (objT instanceof i) {
            return c.i.b.a0.b.BEGIN_ARRAY;
        }
        if (!(objT instanceof q)) {
            if (objT instanceof n) {
                return c.i.b.a0.b.NULL;
            }
            if (objT == r) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        q qVar = (q) objT;
        if (qVar.isString()) {
            return c.i.b.a0.b.STRING;
        }
        if (qVar.isBoolean()) {
            return c.i.b.a0.b.BOOLEAN;
        }
        if (qVar.isNumber()) {
            return c.i.b.a0.b.NUMBER;
        }
        throw new AssertionError();
    }

    public void promoteNameToValue() throws IOException {
        s(c.i.b.a0.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        v(entry.getValue());
        v(new q((String) entry.getKey()));
    }

    public final void s(c.i.b.a0.b bVar) throws IOException {
        if (peek() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + peek() + f());
    }

    @Override // c.i.b.a0.a
    public void skipValue() throws IOException {
        if (peek() == c.i.b.a0.b.NAME) {
            nextName();
            this.u[this.t - 2] = "null";
        } else {
            u();
            int i2 = this.t;
            if (i2 > 0) {
                this.u[i2 - 1] = "null";
            }
        }
        int i3 = this.t;
        if (i3 > 0) {
            int[] iArr = this.v;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    public final Object t() {
        return this.s[this.t - 1];
    }

    @Override // c.i.b.a0.a
    public String toString() {
        return a.class.getSimpleName();
    }

    public final Object u() {
        Object[] objArr = this.s;
        int i2 = this.t - 1;
        this.t = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    public final void v(Object obj) {
        int i2 = this.t;
        Object[] objArr = this.s;
        if (i2 == objArr.length) {
            Object[] objArr2 = new Object[i2 * 2];
            int[] iArr = new int[i2 * 2];
            String[] strArr = new String[i2 * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.v, 0, iArr, 0, this.t);
            System.arraycopy(this.u, 0, strArr, 0, this.t);
            this.s = objArr2;
            this.v = iArr;
            this.u = strArr;
        }
        Object[] objArr3 = this.s;
        int i3 = this.t;
        this.t = i3 + 1;
        objArr3[i3] = obj;
    }
}
