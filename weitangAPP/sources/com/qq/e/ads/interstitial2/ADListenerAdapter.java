package com.qq.e.ads.interstitial2;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.a;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ADListenerAdapter implements ADListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnifiedInterstitialADListener f9583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UnifiedInterstitialMediaListener f9584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.qq.e.comm.listeners.ADRewardListener f9585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NegativeFeedbackListener f9586d;

    public ADListenerAdapter(UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.f9583a = unifiedInterstitialADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedInterstitialADListener unifiedInterstitialADListener;
        String str;
        if (aDEvent == null) {
        }
        int type = aDEvent.getType();
        if (type == 109) {
            UnifiedInterstitialADListener unifiedInterstitialADListener2 = this.f9583a;
            if (unifiedInterstitialADListener2 == null || !a.b(unifiedInterstitialADListener2)) {
                return;
            }
            this.f9583a.onRenderSuccess();
            return;
        }
        if (type == 110) {
            UnifiedInterstitialADListener unifiedInterstitialADListener3 = this.f9583a;
            if (unifiedInterstitialADListener3 == null || !a.a(unifiedInterstitialADListener3)) {
                return;
            }
            this.f9583a.onRenderFail();
            return;
        }
        if (type == 201) {
            UnifiedInterstitialADListener unifiedInterstitialADListener4 = this.f9583a;
            if (unifiedInterstitialADListener4 != null) {
                unifiedInterstitialADListener4.onVideoCached();
                return;
            }
            return;
        }
        if (type == 202) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener = this.f9584b;
            if (unifiedInterstitialMediaListener != null) {
                unifiedInterstitialMediaListener.onVideoStart();
                return;
            }
            return;
        }
        if (type == 204) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener2 = this.f9584b;
            if (unifiedInterstitialMediaListener2 != null) {
                unifiedInterstitialMediaListener2.onVideoPause();
                return;
            }
            return;
        }
        if (type == 206) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener3 = this.f9584b;
            if (unifiedInterstitialMediaListener3 != null) {
                unifiedInterstitialMediaListener3.onVideoComplete();
                return;
            }
            return;
        }
        if (type == 207) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener4 = this.f9584b;
            if (unifiedInterstitialMediaListener4 == null || num == null) {
                return;
            }
            unifiedInterstitialMediaListener4.onVideoError(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        switch (type) {
            case 100:
                UnifiedInterstitialADListener unifiedInterstitialADListener5 = this.f9583a;
                if (unifiedInterstitialADListener5 != null) {
                    unifiedInterstitialADListener5.onADReceive();
                }
                break;
            case 101:
                Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                if (num2 != null && (unifiedInterstitialADListener = this.f9583a) != null) {
                    unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    break;
                }
                break;
            case 102:
                UnifiedInterstitialADListener unifiedInterstitialADListener6 = this.f9583a;
                if (unifiedInterstitialADListener6 != null) {
                    unifiedInterstitialADListener6.onADOpened();
                }
                break;
            case 103:
                UnifiedInterstitialADListener unifiedInterstitialADListener7 = this.f9583a;
                if (unifiedInterstitialADListener7 != null) {
                    unifiedInterstitialADListener7.onADExposure();
                }
                break;
            case 104:
                if (this.f9585c != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                    HashMap map = new HashMap();
                    map.put("transId", str);
                    this.f9585c.onReward(map);
                    break;
                }
                break;
            case 105:
                UnifiedInterstitialADListener unifiedInterstitialADListener8 = this.f9583a;
                if (unifiedInterstitialADListener8 != null) {
                    unifiedInterstitialADListener8.onADClicked();
                }
                break;
            case 106:
                UnifiedInterstitialADListener unifiedInterstitialADListener9 = this.f9583a;
                if (unifiedInterstitialADListener9 != null) {
                    unifiedInterstitialADListener9.onADClosed();
                }
                break;
            default:
                switch (type) {
                    case AdEventType.VIDEO_INIT /* 209 */:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener5 = this.f9584b;
                        if (unifiedInterstitialMediaListener5 != null) {
                            unifiedInterstitialMediaListener5.onVideoInit();
                        }
                        break;
                    case AdEventType.VIDEO_READY /* 210 */:
                        Integer num3 = (Integer) aDEvent.getParam(Integer.class);
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener6 = this.f9584b;
                        if (unifiedInterstitialMediaListener6 != null && num3 != null) {
                            unifiedInterstitialMediaListener6.onVideoReady(num3.intValue());
                            break;
                        }
                        break;
                    case AdEventType.VIDEO_LOADING /* 211 */:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener7 = this.f9584b;
                        if (unifiedInterstitialMediaListener7 != null) {
                            unifiedInterstitialMediaListener7.onVideoLoading();
                        }
                        break;
                    default:
                        switch (type) {
                            case AdEventType.VIDEO_PAGE_OPEN /* 301 */:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener8 = this.f9584b;
                                if (unifiedInterstitialMediaListener8 != null) {
                                    unifiedInterstitialMediaListener8.onVideoPageOpen();
                                }
                                break;
                            case 302:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener9 = this.f9584b;
                                if (unifiedInterstitialMediaListener9 != null) {
                                    unifiedInterstitialMediaListener9.onVideoPageClose();
                                }
                                break;
                            case 303:
                                UnifiedInterstitialADListener unifiedInterstitialADListener10 = this.f9583a;
                                if (unifiedInterstitialADListener10 != null) {
                                    unifiedInterstitialADListener10.onADLeftApplication();
                                }
                                break;
                            case 304:
                                NegativeFeedbackListener negativeFeedbackListener = this.f9586d;
                                if (negativeFeedbackListener != null) {
                                    negativeFeedbackListener.onComplainSuccess();
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f9585c = aDRewardListener;
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f9584b = unifiedInterstitialMediaListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f9586d = negativeFeedbackListener;
    }
}
