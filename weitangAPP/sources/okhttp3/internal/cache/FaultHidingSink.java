package okhttp3.internal.cache;

import f.c;
import f.g;
import f.s;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class FaultHidingSink extends g {
    private boolean hasErrors;

    public FaultHidingSink(s sVar) {
        super(sVar);
    }

    @Override // f.g, f.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.hasErrors = true;
            onException(e2);
        }
    }

    @Override // f.g, f.s, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.hasErrors = true;
            onException(e2);
        }
    }

    public void onException(IOException iOException) {
    }

    @Override // f.g, f.s
    public void write(c cVar, long j) throws IOException {
        if (this.hasErrors) {
            cVar.skip(j);
            return;
        }
        try {
            super.write(cVar, j);
        } catch (IOException e2) {
            this.hasErrors = true;
            onException(e2);
        }
    }
}
