package cn.admobiletop.adsuyi.ad.data;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiPosId {
    String getAdType();

    int getBiddingTimeout();

    int getCompelRefresh();

    int getFrequencyMode();

    long getGroupId();

    double getHbBidFloor();

    long getId();

    List<ADSuyiPlatformPosId> getPlatformPosIdList();

    String getPosId();

    String getRequestMode();

    int getSingleSourceTimeout();

    int getTotalTimeout();

    boolean isHeadingBid();

    boolean isLocalData();

    boolean isLoopFrequencyType();

    boolean needClick();

    boolean needFrequency();

    boolean tNeedClick();

    void updateTClick();
}
