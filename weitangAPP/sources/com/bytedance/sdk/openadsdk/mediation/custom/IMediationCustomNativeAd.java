package com.bytedance.sdk.openadsdk.mediation.custom;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IMediationCustomNativeAd {
    void callAdClick();

    void callAdShow();

    void callDislikeCancel();

    void callDislikeSelected(int i2, String str);

    void callDislikeShow();

    void callOnDownloadActive(long j, long j2);

    void callOnDownloadFailed(long j, long j2, String str, String str2);

    void callOnDownloadFinished(long j, String str, String str2);

    void callOnDownloadPaused(long j, long j2, String str, String str2);

    void callOnIdle();

    void callOnInstalled(String str, String str2);

    void callRenderFail(View view, int i2, String str);

    void callRenderSuccess(float f2, float f3);

    void callVideoCompleted();

    void callVideoError(int i2, String str);

    void callVideoPause();

    void callVideoProgressUpdate(long j, long j2);

    void callVideoResume();

    void callVideoStart();

    int getBiddingType();

    View getExpressView();

    TTFeedAd.CustomizeVideo getNativeCustomVideoReporter();

    String getVideoUrl();

    boolean hasDislike();

    boolean isClientBidding();

    MediationConstant.AdIsReadyStatus isReadyCondition();

    boolean isServerBidding();

    boolean isUseCustomVideo();

    void onDestroy();

    void onPause();

    void onResume();

    void receiveBidResult(boolean z, double d2, int i2, Map<String, Object> map);

    void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder);

    void render();

    void setActionText(String str);

    void setAdImageMode(int i2);

    void setBiddingPrice(double d2);

    void setDescription(String str);

    void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog);

    void setExpressAd(boolean z);

    void setIconUrl(String str);

    void setImageHeight(int i2);

    void setImageList(List<String> list);

    void setImageUrl(String str);

    void setImageWidth(int i2);

    void setInteractionType(int i2);

    void setMediaExtraInfo(Map<String, Object> map);

    void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo);

    void setPackageName(String str);

    void setSource(String str);

    void setStarRating(double d2);

    void setTitle(String str);

    void setVideoHeight(int i2);

    void setVideoWidth(int i2);
}
