package com.qq.e.ads.banner2;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ADListenerAdapter implements ADListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnifiedBannerADListener f9530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NegativeFeedbackListener f9531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADRewardListener f9532c;

    public ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.f9530a = unifiedBannerADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedBannerADListener unifiedBannerADListener;
        String str;
        if (aDEvent == null) {
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.f9530a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onADReceive();
                return;
            }
            return;
        }
        if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null || (unifiedBannerADListener = this.f9530a) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.f9530a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
                return;
            }
            return;
        }
        if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.f9531b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            return;
        }
        switch (type) {
            case 103:
                UnifiedBannerADListener unifiedBannerADListener4 = this.f9530a;
                if (unifiedBannerADListener4 != null) {
                    unifiedBannerADListener4.onADExposure();
                }
                break;
            case 104:
                if (this.f9532c != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                    HashMap map = new HashMap();
                    map.put("transId", str);
                    this.f9532c.onReward(map);
                    break;
                }
                break;
            case 105:
                UnifiedBannerADListener unifiedBannerADListener5 = this.f9530a;
                if (unifiedBannerADListener5 != null) {
                    unifiedBannerADListener5.onADClicked();
                }
                break;
            case 106:
                UnifiedBannerADListener unifiedBannerADListener6 = this.f9530a;
                if (unifiedBannerADListener6 != null) {
                    unifiedBannerADListener6.onADClosed();
                }
                break;
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.f9532c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f9531b = negativeFeedbackListener;
    }
}
