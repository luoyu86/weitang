package com.tianmu.ad.model;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface INativeAd {
    void destroy();

    String getAppIconUrl();

    String getAppName();

    String getDeepLinkUrl();

    String getDesc();

    String getImageUrl();

    List<String> getImageUrlList();

    String getLandingPageUrl();

    String getTitle();

    boolean isLandscape();

    boolean isVideo();

    void readyTouch(View view);
}
