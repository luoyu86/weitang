package okhttp3;

import f.f;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i2, @Nullable String str);

    long queueSize();

    Request request();

    boolean send(f fVar);

    boolean send(String str);
}
