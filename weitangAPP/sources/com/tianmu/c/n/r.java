package com.tianmu.c.n;

import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.danikula.videocache.CacheListener;
import com.tianmu.danikula.videocache.HttpProxyCacheServer;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static r f11916b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HttpProxyCacheServer f11917a;

    private r() {
        if (this.f11917a != null || TianmuSDK.getInstance().getContext() == null) {
            return;
        }
        try {
            this.f11917a = new HttpProxyCacheServer.Builder(TianmuSDK.getInstance().getContext().getApplicationContext()).maxCacheSize(536870912L).build();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static r a() {
        if (f11916b == null) {
            synchronized (r.class) {
                if (f11916b == null) {
                    f11916b = new r();
                }
            }
        }
        return f11916b;
    }

    public String a(String str, CacheListener cacheListener) {
        if (this.f11917a != null && !TextUtils.isEmpty(str)) {
            if (cacheListener != null) {
                try {
                    this.f11917a.registerCacheListener(cacheListener, str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f11917a.getProxyUrl(str);
        }
        return str;
    }

    public boolean a(String str) {
        HttpProxyCacheServer httpProxyCacheServer;
        return (TextUtils.isEmpty(str) || (httpProxyCacheServer = this.f11917a) == null || !httpProxyCacheServer.isCached(str)) ? false : true;
    }

    public void a(CacheListener cacheListener) {
        HttpProxyCacheServer httpProxyCacheServer = this.f11917a;
        if (httpProxyCacheServer == null || cacheListener == null) {
            return;
        }
        try {
            httpProxyCacheServer.unregisterCacheListener(cacheListener);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
