package com.qq.e.mediation.interfaces;

import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseNativeUnifiedAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseNativeUnifiedAd(Context context, String str, String str2, String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract void loadData(int i2);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i2, int i3, String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i2) {
    }

    public abstract void setAdListener(ADListener aDListener);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i2) {
    }

    public abstract void setCategories(List<String> list);

    public abstract void setECPMLevel(String str);

    public abstract void setMaxVideoDuration(int i2);

    public abstract void setMinVideoDuration(int i2);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }
}
