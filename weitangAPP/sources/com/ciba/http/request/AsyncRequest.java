package com.ciba.http.request;

import android.os.Handler;
import android.text.TextUtils;
import com.ciba.http.entity.Request;
import com.ciba.http.listener.HttpListener;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncRequest extends BaseRequest implements Runnable {
    private final Handler handler;
    private final HttpListener httpListener;
    private final Map<HttpListener, List<WeakReference<Future<?>>>> listenerMap;

    public AsyncRequest(Handler handler, Request request, Map<HttpListener, List<WeakReference<Future<?>>>> map, HttpListener httpListener) {
        super(request);
        this.handler = handler;
        this.listenerMap = map;
        this.httpListener = httpListener;
    }

    private boolean canCallBack() {
        HttpListener httpListener;
        Map<HttpListener, List<WeakReference<Future<?>>>> map;
        return (this.handler == null || (httpListener = this.httpListener) == null || (map = this.listenerMap) == null || map.get(httpListener) == null) ? false : true;
    }

    private void onFailed() {
        if (canCallBack()) {
            this.handler.post(new Runnable() { // from class: com.ciba.http.request.AsyncRequest.2
                @Override // java.lang.Runnable
                public void run() {
                    HttpListener httpListener = AsyncRequest.this.httpListener;
                    AsyncRequest asyncRequest = AsyncRequest.this;
                    httpListener.onRequestFailed(asyncRequest.errorCode, asyncRequest.errorMessage);
                }
            });
        }
    }

    private void onStart() {
        if (canCallBack()) {
            this.handler.post(new Runnable() { // from class: com.ciba.http.request.AsyncRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncRequest.this.httpListener.onRequestStart();
                }
            });
        }
    }

    private void onSuccess(final String str) {
        if (canCallBack()) {
            this.handler.post(new Runnable() { // from class: com.ciba.http.request.AsyncRequest.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncRequest.this.httpListener.onRequestSuccess(str);
                    AsyncRequest asyncRequest = AsyncRequest.this;
                    if (asyncRequest.needResponseHeader) {
                        asyncRequest.httpListener.onRequestSuccess(str, AsyncRequest.this.responseHeader);
                    }
                }
            });
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        onStart();
        String strExecute = execute();
        if (this.resultCode == 200 || !TextUtils.isEmpty(strExecute)) {
            onSuccess(strExecute);
        } else {
            onFailed();
        }
    }
}
