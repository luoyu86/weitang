package com.qq.e.mediation.interfaces;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IBaseAd {
    int getECPM();

    Map<String, Object> getExtraInfo();

    String getReqId();

    void sendLossNotification(int i2, int i3, String str);

    void sendWinNotification(int i2);

    void setBidECPM(int i2);

    void setPayload(String str);
}
