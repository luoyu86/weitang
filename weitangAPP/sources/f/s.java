package f;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface s extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    u timeout();

    void write(c cVar, long j) throws IOException;
}
