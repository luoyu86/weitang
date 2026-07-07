package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* JADX INFO: loaded from: classes2.dex */
public interface NEADI {
    String getAdNetWorkName();

    void loadAd(int i2);

    void loadAd(int i2, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i2);

    void setMinVideoDuration(int i2);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);
}
