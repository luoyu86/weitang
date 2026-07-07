package c.i.b.y;

import c.i.b.m;
import c.i.b.n;
import c.i.b.p;
import c.i.b.t;
import com.google.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static c.i.b.l parse(c.i.b.a0.a aVar) throws p {
        boolean z;
        try {
            try {
                aVar.peek();
                z = false;
                try {
                    return TypeAdapters.X.read(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return n.f2614a;
                    }
                    throw new t(e);
                }
            } catch (c.i.b.a0.d e3) {
                throw new t(e3);
            } catch (IOException e4) {
                throw new m(e4);
            } catch (NumberFormatException e5) {
                throw new t(e5);
            }
        } catch (EOFException e6) {
            e = e6;
            z = true;
        }
    }

    public static void write(c.i.b.l lVar, c.i.b.a0.c cVar) throws IOException {
        TypeAdapters.X.write(cVar, lVar);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    public static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f2681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0037a f2682b = new C0037a();

        /* JADX INFO: renamed from: c.i.b.y.k$a$a, reason: collision with other inner class name */
        public static class C0037a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public char[] f2683a;

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.f2683a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f2683a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f2683a, i2, i3 - i2);
            }
        }

        public a(Appendable appendable) {
            this.f2681a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            C0037a c0037a = this.f2682b;
            c0037a.f2683a = cArr;
            this.f2681a.append(c0037a, i2, i3 + i2);
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.f2681a.append((char) i2);
        }
    }
}
