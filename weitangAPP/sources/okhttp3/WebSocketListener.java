package okhttp3;

import f.f;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i2, String str) {
    }

    public void onClosing(WebSocket webSocket, int i2, String str) {
    }

    public void onFailure(WebSocket webSocket, Throwable th, @Nullable Response response) {
    }

    public void onMessage(WebSocket webSocket, f fVar) {
    }

    public void onMessage(WebSocket webSocket, String str) {
    }

    public void onOpen(WebSocket webSocket, Response response) {
    }
}
