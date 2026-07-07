package cn.admobiletop.adsuyi.ad.data;

import android.view.View;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeVideoListener;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiNativeAdInfo extends ADSuyiAdInfo {
    boolean isNativeExpress();

    boolean isVideo();

    void registerCloseView(View view);

    void setVideoListener(ADSuyiNativeVideoListener aDSuyiNativeVideoListener);
}
