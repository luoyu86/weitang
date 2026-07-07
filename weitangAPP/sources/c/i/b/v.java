package c.i.b;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v<T> {

    public class a extends v<T> {
        public a() {
        }

        @Override // c.i.b.v
        public T read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return (T) v.this.read(aVar);
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.nullValue();
            } else {
                v.this.write(cVar, t);
            }
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new c.i.b.a0.a(reader));
    }

    public final T fromJsonTree(l lVar) {
        try {
            return read(new c.i.b.y.m.a(lVar));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public final v<T> nullSafe() {
        return new a();
    }

    public abstract T read(c.i.b.a0.a aVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new c.i.b.a0.c(writer), t);
    }

    public final l toJsonTree(T t) {
        try {
            c.i.b.y.m.b bVar = new c.i.b.y.m.b();
            write(bVar, t);
            return bVar.get();
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public abstract void write(c.i.b.a0.c cVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
