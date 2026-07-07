package com.bytedance.sdk.openadsdk.bl.ok;

import android.util.Pair;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ISplashCardListener;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.h.ok.ok.ok.kf;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import com.bytedance.sdk.openadsdk.mediation.ok.ok.bl;
import com.bytedance.sdk.openadsdk.mediation.ok.ok.n;
import com.bytedance.sdk.openadsdk.mediation.ok.ok.s;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ok {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok$ok, reason: collision with other inner class name */
    public static class C0111ok implements TTAdNative {
        private final ok ok;

        public C0111ok(ok okVar) {
            this.ok = okVar;
        }

        private ValueSet ok(AdSlot adSlot) {
            c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(com.bytedance.sdk.openadsdk.bl.ok.bl.a.a(adSlot));
            aVarOk.ok(8302, MediationAdClassLoader.getInstance());
            if (adSlot.getMediationAdSlot() != null) {
                aVarOk.ok(260026, new n(adSlot.getMediationAdSlot()));
                aVarOk.ok(260027, adSlot.getMediationAdSlot());
            }
            return aVarOk.a();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.ok.q(ok(adSlot), new com.bytedance.sdk.openadsdk.h.ok.ok.ok.n(nativeExpressAdListener));
            } catch (Exception e2) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    nativeExpressAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.ok.bl(ok(adSlot), new com.bytedance.sdk.openadsdk.mediation.ok.ok.a(drawFeedAdListener));
            } catch (Exception e2) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    drawFeedAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.ok.p(ok(adSlot), new com.bytedance.sdk.openadsdk.h.ok.ok.ok.n(nativeExpressAdListener));
            } catch (Exception e2) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    nativeExpressAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.ok.ok(ok(adSlot), new bl(feedAdListener));
            } catch (Exception e2) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    feedAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.ok.kf(ok(adSlot), new s(fullScreenVideoAdListener));
            } catch (Exception e2) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    fullScreenVideoAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.ok.s(ok(adSlot), new com.bytedance.sdk.openadsdk.h.ok.ok.ok.s(nativeAdListener));
            } catch (Exception e2) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    nativeAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.ok.h(ok(adSlot), new com.bytedance.sdk.openadsdk.h.ok.ok.ok.n(nativeExpressAdListener));
            } catch (Exception e2) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    nativeExpressAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.ok.n(ok(adSlot), new kf(rewardVideoAdListener));
            } catch (Exception e2) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    rewardVideoAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
            ok(adSlot, splashAdListener, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.ok.a(ok(adSlot), new bl(feedAdListener));
            } catch (Exception e2) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairOk = this.ok.ok(e2);
                    feedAdListener.onError(((Integer) pairOk.first).intValue(), (String) pairOk.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i2) {
            try {
                this.ok.ok(ok(adSlot), new a(cSJSplashAdListener), i2);
            } catch (Exception e2) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> pairOk = this.ok.ok(e2);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) pairOk.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) pairOk.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            ok(adSlot, splashAdListener, -1);
        }

        private void ok(AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, int i2) {
            loadSplashAd(adSlot, new TTAdNative.CSJSplashAdListener() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.2
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadFail(CSJAdError cSJAdError) {
                    String msg;
                    if (splashAdListener != null) {
                        int code = -1;
                        if (cSJAdError != null) {
                            code = cSJAdError.getCode();
                            msg = cSJAdError.getMsg();
                        } else {
                            msg = "splash load fail";
                        }
                        if (code == 23) {
                            splashAdListener.onTimeout();
                        } else {
                            splashAdListener.onError(code, msg);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                    String msg;
                    if (splashAdListener != null) {
                        int code = -1;
                        if (cSJAdError != null) {
                            code = cSJAdError.getCode();
                            msg = cSJAdError.getMsg();
                        } else {
                            msg = "splash render fail";
                        }
                        if (code == 23) {
                            splashAdListener.onTimeout();
                        } else {
                            splashAdListener.onError(code, msg);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                    if (splashAdListener == null) {
                        return;
                    }
                    splashAdListener.onSplashAdLoad(C0111ok.this.ok(cSJSplashAd));
                }
            }, i2);
        }

        public TTSplashAd ok(final CSJSplashAd cSJSplashAd) {
            if (cSJSplashAd == null) {
                return null;
            }
            final TTSplashAd.AdInteractionListener[] adInteractionListenerArr = new TTSplashAd.AdInteractionListener[1];
            return new TTSplashAd() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.3
                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public int getInteractionType() {
                    CSJSplashAd cSJSplashAd2 = cSJSplashAd;
                    if (cSJSplashAd2 == null) {
                        return 0;
                    }
                    return cSJSplashAd2.getInteractionType();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public Map<String, Object> getMediaExtraInfo() {
                    return cSJSplashAd.getMediaExtraInfo();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public MediationSplashManager getMediationManager() {
                    return cSJSplashAd.getMediationManager();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public int[] getSplashClickEyeSizeToDp() {
                    return cSJSplashAd.getSplashClickEyeSizeToDp();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public View getSplashView() {
                    CSJSplashAd cSJSplashAd2 = cSJSplashAd;
                    if (cSJSplashAd2 == null) {
                        return null;
                    }
                    return cSJSplashAd2.getSplashView();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void loss(Double d2, String str, String str2) {
                    cSJSplashAd.loss(d2, str, str2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
                    cSJSplashAd.setAdInteractionListener(tTAdInteractionListener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
                    if (tTAppDownloadListener == null) {
                        return;
                    }
                    cSJSplashAd.setDownloadListener(tTAppDownloadListener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setNotAllowSdkCountdown() {
                    cSJSplashAd.hideSkipButton();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void setPrice(Double d2) {
                    cSJSplashAd.setPrice(d2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashCardListener(final ISplashCardListener iSplashCardListener) {
                    if (iSplashCardListener == null) {
                        return;
                    }
                    cSJSplashAd.setSplashCardListener(new CSJSplashAd.SplashCardListener() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.3.3
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardClick() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            TTSplashAd.AdInteractionListener[] adInteractionListenerArr2 = adInteractionListenerArr;
                            if (adInteractionListenerArr2[0] != null) {
                                adInteractionListenerArr2[0].onAdClicked(cSJSplashAd.getSplashView(), cSJSplashAd.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardClose() {
                            iSplashCardListener.onSplashClickEyeClose();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardReadyToShow(CSJSplashAd cSJSplashAd2) {
                            iSplashCardListener.setSupportSplashClickEye(true);
                            iSplashCardListener.onSplashEyeReady();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashClickEyeListener(final ISplashClickEyeListener iSplashClickEyeListener) {
                    if (iSplashClickEyeListener == null) {
                        return;
                    }
                    cSJSplashAd.setSplashClickEyeListener(new CSJSplashAd.SplashClickEyeListener() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.3.2
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeClick() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            TTSplashAd.AdInteractionListener[] adInteractionListenerArr2 = adInteractionListenerArr;
                            if (adInteractionListenerArr2[0] != null) {
                                adInteractionListenerArr2[0].onAdClicked(cSJSplashAd.getSplashView(), cSJSplashAd.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeClose() {
                            iSplashClickEyeListener.onSplashClickEyeAnimationFinish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd2) {
                            iSplashClickEyeListener.isSupportSplashClickEye(true);
                            iSplashClickEyeListener.onSplashClickEyeAnimationStart();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashInteractionListener(final TTSplashAd.AdInteractionListener adInteractionListener) {
                    CSJSplashAd cSJSplashAd2;
                    if (adInteractionListener == null || (cSJSplashAd2 = cSJSplashAd) == null) {
                        return;
                    }
                    adInteractionListenerArr[0] = adInteractionListener;
                    cSJSplashAd2.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.bytedance.sdk.openadsdk.bl.ok.ok.ok.3.1
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClick(CSJSplashAd cSJSplashAd3) {
                            if (cSJSplashAd3 == null) {
                                adInteractionListener.onAdClicked(null, -1);
                            } else {
                                adInteractionListener.onAdClicked(cSJSplashAd3.getSplashView(), cSJSplashAd3.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClose(CSJSplashAd cSJSplashAd3, int i2) {
                            if (i2 == 1) {
                                adInteractionListener.onAdSkip();
                            } else if (i2 == 2 || i2 == 4) {
                                adInteractionListener.onAdTimeOver();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdShow(CSJSplashAd cSJSplashAd3) {
                            if (cSJSplashAd3 == null) {
                                adInteractionListener.onAdShow(null, -1);
                            } else {
                                adInteractionListener.onAdShow(cSJSplashAd3.getSplashView(), cSJSplashAd3.getInteractionType());
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void splashClickEyeAnimationFinish() {
                    cSJSplashAd.showSplashClickEyeView(null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void startClickEye(boolean z) {
                    cSJSplashAd.startClickEye();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void win(Double d2) {
                    cSJSplashAd.win(d2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void startClickEye() {
                    cSJSplashAd.startClickEye();
                }
            };
        }
    }

    public abstract void a(ValueSet valueSet, Bridge bridge);

    public abstract void bl(ValueSet valueSet, Bridge bridge);

    public abstract void h(ValueSet valueSet, Bridge bridge);

    public abstract void kf(ValueSet valueSet, Bridge bridge);

    public abstract void n(ValueSet valueSet, Bridge bridge);

    public abstract Pair<Integer, String> ok(Exception exc);

    public TTAdNative ok() {
        return new C0111ok(this);
    }

    public abstract void ok(ValueSet valueSet, Bridge bridge);

    public abstract void ok(ValueSet valueSet, Bridge bridge, int i2);

    public abstract void p(ValueSet valueSet, Bridge bridge);

    public abstract void q(ValueSet valueSet, Bridge bridge);

    public abstract void s(ValueSet valueSet, Bridge bridge);
}
