package c.i.b.y.m;

import c.i.b.i;
import c.i.b.l;
import c.i.b.n;
import c.i.b.o;
import c.i.b.q;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c.i.b.a0.c {
    public static final Writer l = new a();
    public static final q m = new q("closed");
    public final List<l> n;
    public String o;
    public l p;

    public static class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public b() {
        super(l);
        this.n = new ArrayList();
        this.p = n.f2614a;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c beginArray() throws IOException {
        i iVar = new i();
        k(iVar);
        this.n.add(iVar);
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c beginObject() throws IOException {
        o oVar = new o();
        k(oVar);
        this.n.add(oVar);
        return this;
    }

    @Override // c.i.b.a0.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.n.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.n.add(m);
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c endArray() throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (!(j() instanceof i)) {
            throw new IllegalStateException();
        }
        this.n.remove(r0.size() - 1);
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c endObject() throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (!(j() instanceof o)) {
            throw new IllegalStateException();
        }
        this.n.remove(r0.size() - 1);
        return this;
    }

    @Override // c.i.b.a0.c, java.io.Flushable
    public void flush() throws IOException {
    }

    public l get() {
        if (this.n.isEmpty()) {
            return this.p;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.n);
    }

    public final l j() {
        return this.n.get(r0.size() - 1);
    }

    public final void k(l lVar) {
        if (this.o != null) {
            if (!lVar.isJsonNull() || getSerializeNulls()) {
                ((o) j()).add(this.o, lVar);
            }
            this.o = null;
            return;
        }
        if (this.n.isEmpty()) {
            this.p = lVar;
            return;
        }
        l lVarJ = j();
        if (!(lVarJ instanceof i)) {
            throw new IllegalStateException();
        }
        ((i) lVarJ).add(lVar);
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c name(String str) throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (!(j() instanceof o)) {
            throw new IllegalStateException();
        }
        this.o = str;
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c nullValue() throws IOException {
        k(n.f2614a);
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        k(new q(str));
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c value(boolean z) throws IOException {
        k(new q(Boolean.valueOf(z)));
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        k(new q(bool));
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c value(double d2) throws IOException {
        if (!isLenient() && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
        }
        k(new q((Number) Double.valueOf(d2)));
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c value(long j) throws IOException {
        k(new q((Number) Long.valueOf(j)));
        return this;
    }

    @Override // c.i.b.a0.c
    public c.i.b.a0.c value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        k(new q(number));
        return this;
    }
}
