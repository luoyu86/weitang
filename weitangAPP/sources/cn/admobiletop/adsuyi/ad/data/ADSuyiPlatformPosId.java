package cn.admobiletop.adsuyi.ad.data;

import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiPlatformPosId {
    ADSuyiAdSize getAdSize();

    String getAdType();

    String getBidToken();

    int getContentSize();

    double getECPM();

    long getFirstShowTime();

    int getFrequency();

    long getFrequencyFinishTime();

    int getFrequencyMode();

    long getId();

    long getIntervalShowTime();

    String getPlacementId();

    String getPlatform();

    String getPlatformPosId();

    int getRenderType();

    int getRequestRate();

    int getScreenOrientation();

    int getSkipShowTime();

    String getTemplate();

    boolean isBidType();

    boolean isBottom();

    boolean isFrequencyFinished();

    boolean isLoopFrequencyType();

    boolean isSplashHotAreaCtl();

    void setBidToken(String str);

    void setECPM(double d2);

    void setFrequencyFinishTime(long j);

    void setFrequencyFinished(boolean z);
}
