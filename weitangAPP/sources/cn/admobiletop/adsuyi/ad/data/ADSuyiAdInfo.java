package cn.admobiletop.adsuyi.ad.data;

import androidx.annotation.DrawableRes;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAdInfo extends IBaseRelease {
    String getPlatform();

    @DrawableRes
    int getPlatformIcon();

    String getPlatformPosId();

    boolean isReleased();

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    void release();
}
