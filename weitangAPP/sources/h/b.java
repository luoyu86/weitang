package h;

import java.io.IOException;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
public interface b<T> extends Cloneable {
    void cancel();

    b<T> clone();

    void enqueue(d<T> dVar);

    l<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
