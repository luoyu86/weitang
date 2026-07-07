package f;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface t extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(c cVar, long j) throws IOException;

    u timeout();
}
