package com.tianmu.ad.base;

/* JADX INFO: loaded from: classes2.dex */
public interface IBidding {
    int getBidFloor();

    int getBidPrice();

    void sendLossNotice(int i2, int i3);

    void sendWinNotice(int i2);
}
