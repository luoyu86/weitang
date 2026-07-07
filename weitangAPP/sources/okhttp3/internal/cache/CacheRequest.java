package okhttp3.internal.cache;

import f.s;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface CacheRequest {
    void abort();

    s body() throws IOException;
}
