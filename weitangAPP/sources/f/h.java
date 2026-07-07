package f;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements t {
    private final t delegate;

    public h(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = tVar;
    }

    @Override // f.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final t delegate() {
        return this.delegate;
    }

    @Override // f.t
    public long read(c cVar, long j) throws IOException {
        return this.delegate.read(cVar, j);
    }

    @Override // f.t
    public u timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
