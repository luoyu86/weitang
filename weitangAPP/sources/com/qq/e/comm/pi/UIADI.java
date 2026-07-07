package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* JADX INFO: loaded from: classes2.dex */
public interface UIADI extends LADI {
    void close();

    void destroy();

    String getAdNetWorkName();

    int getAdPatternType();

    int getVideoDuration();

    void loadAd();

    void loadFullScreenAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i2);

    void setMinVideoDuration(int i2);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);

    void show();

    void show(Activity activity);

    void showFullScreenAD(Activity activity);
}
