package cn.admobiletop.adsuyi.ad.adapter;

import android.os.Handler;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;

/* JADX INFO: loaded from: classes.dex */
public abstract class ADSuyiAdapterBaseAdListener<T extends ADSuyiAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f3480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f3482c;

    public ADSuyiAdapterBaseAdListener(String str, T t) {
        this.f3481b = str;
        this.f3482c = t;
    }

    public T getAdListener() {
        return this.f3482c;
    }

    public long getAdapterTimeout(long j) {
        return (long) Math.max(2000.0f, j * 0.7f);
    }

    public abstract String getPlatform();

    public String getPlatformPosId() {
        return this.f3481b;
    }

    public void onAdFailed(int i2, String str) {
        stopTimeoutRunnable();
        T t = this.f3482c;
        if (t != null) {
            t.onAdFailed(ADSuyiError.createErrorDesc(getPlatform(), getPlatformPosId(), i2, str));
        }
    }

    public void release() {
        this.f3482c = null;
        stopTimeoutRunnable();
    }

    public void startTimeoutRunnable(long j) {
        stopTimeoutRunnable();
        Handler handler = new Handler();
        this.f3480a = handler;
        handler.postDelayed(new Runnable() { // from class: cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener.1
            @Override // java.lang.Runnable
            public void run() {
                ADSuyiAdapterBaseAdListener.this.onAdFailed(ADSuyiErrorConfig.AD_FAILED_TIME_OUT, "获取广告超时");
            }
        }, getAdapterTimeout(j));
    }

    public void stopTimeoutRunnable() {
        Handler handler = this.f3480a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3480a = null;
        }
    }
}
