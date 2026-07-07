package com.ciba.http.client;

import android.os.Handler;
import android.os.Looper;
import com.ciba.http.entity.Request;
import com.ciba.http.listener.HttpListener;
import com.ciba.http.manager.AsyncThreadPoolManager;
import com.ciba.http.request.AsyncRequest;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncHttpClient extends BaseHttpClient<AsyncHttpClient> {
    private final Map<HttpListener, List<WeakReference<Future<?>>>> listenerMap = new WeakHashMap();
    private ThreadPoolExecutor threadPool = AsyncThreadPoolManager.getInstance().getThreadPool();
    private final Handler handler = new Handler(Looper.getMainLooper());

    private void sendRequest(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, HttpListener httpListener) {
        Request request = new Request(str, str2, getHttpConfig());
        request.setJson(str3);
        request.setRequestParams(map);
        request.setHeaders(map2);
        Future<?> futureSubmit = this.threadPool.submit(new AsyncRequest(this.handler, request, this.listenerMap, httpListener));
        if (httpListener != null) {
            List<WeakReference<Future<?>>> linkedList = this.listenerMap.get(httpListener);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.listenerMap.put(httpListener, linkedList);
            }
            linkedList.add(new WeakReference<>(futureSubmit));
        }
    }

    public void cancel(HttpListener httpListener) {
        cancel(httpListener, true);
    }

    public void cancelAll() {
        Iterator<HttpListener> it = this.listenerMap.keySet().iterator();
        while (it.hasNext()) {
            cancel(it.next(), false);
        }
        this.listenerMap.clear();
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void get(String str, Map<String, String> map, HttpListener httpListener) {
        get(str, map, getHeaders(), httpListener);
    }

    public void post(String str, Map<String, String> map, HttpListener httpListener) {
        post(str, map, getHeaders(), httpListener);
    }

    public void postJson(String str, String str2, HttpListener httpListener) {
        postJson(str, str2, getHeaders(), httpListener);
    }

    public AsyncHttpClient setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            this.threadPool = threadPoolExecutor;
        }
        return this;
    }

    public void cancel(HttpListener httpListener, boolean z) {
        if (httpListener != null) {
            List<WeakReference<Future<?>>> list = this.listenerMap.get(httpListener);
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    WeakReference<Future<?>> weakReference = list.get(i2);
                    if (weakReference != null && weakReference.get() != null) {
                        weakReference.get().cancel(true);
                    }
                }
            }
            if (z) {
                this.listenerMap.remove(httpListener);
            }
        }
    }

    public void get(String str, Map<String, String> map, Map<String, String> map2, HttpListener httpListener) {
        sendRequest("GET", str, null, map, map2, httpListener);
    }

    public void post(String str, Map<String, String> map, Map<String, String> map2, HttpListener httpListener) {
        post(str, null, map, map2, httpListener);
    }

    public void postJson(String str, String str2, Map<String, String> map, HttpListener httpListener) {
        post(str, str2, null, map, httpListener);
    }

    private void post(String str, String str2, Map<String, String> map, Map<String, String> map2, HttpListener httpListener) {
        sendRequest("POST", str, str2, map, map2, httpListener);
    }
}
