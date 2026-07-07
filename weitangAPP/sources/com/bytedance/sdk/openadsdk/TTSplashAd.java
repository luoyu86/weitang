package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface TTSplashAd extends TTClientBidding {

    public interface AdInteractionListener {
        void onAdClicked(View view, int i2);

        void onAdShow(View view, int i2);

        void onAdSkip();

        void onAdTimeOver();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    MediationSplashManager getMediationManager();

    int[] getSplashClickEyeSizeToDp();

    View getSplashView();

    void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setNotAllowSdkCountdown();

    void setSplashCardListener(ISplashCardListener iSplashCardListener);

    void setSplashClickEyeListener(ISplashClickEyeListener iSplashClickEyeListener);

    void setSplashInteractionListener(AdInteractionListener adInteractionListener);

    void splashClickEyeAnimationFinish();

    void startClickEye();

    void startClickEye(boolean z);
}
