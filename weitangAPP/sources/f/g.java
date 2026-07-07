package f;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements s {
    private final s delegate;

    public g(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = sVar;
    }

    @Override // f.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final s delegate() {
        return this.delegate;
    }

    @Override // f.s, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // f.s
    public u timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }

    @Override // f.s
    public void write(c cVar, long j) throws IOException {
        this.delegate.write(cVar, j);
    }
}
