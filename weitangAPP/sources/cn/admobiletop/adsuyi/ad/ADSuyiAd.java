package cn.admobiletop.adsuyi.ad;

import android.app.Activity;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiReleaseListener;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAd<T extends ADSuyiAdListener> {
    void addReleaseListener(ADSuyiReleaseListener aDSuyiReleaseListener);

    Activity getActivity();

    String getAdType();

    String getKey();

    T getListener();

    String getOnlySupportPlatform();

    long getTimeout();

    boolean isReleased();

    void removeReleaseListener(ADSuyiReleaseListener aDSuyiReleaseListener);

    void setOnlySupportPlatform(String str);

    void setTimeout(long j);
}
