package com.tianmu.ad.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tianmu.ad.listener.VideoAdListener;
import com.tianmu.j.a.c.a;

/* JADX INFO: loaded from: classes2.dex */
public interface ITianmuNativeVideoAd extends INativeAd {
    void checkPlayVideo(boolean z);

    View getAdView(Context context, a aVar, int i2);

    View getAdView(Context context, a aVar, int i2, int i3);

    View getAdView(Context context, a aVar, int i2, ViewGroup.LayoutParams layoutParams, int i3);

    String getVideoCacheUrl();

    String getVideoUrl();

    void registerVideoListener(VideoAdListener videoAdListener);
}
