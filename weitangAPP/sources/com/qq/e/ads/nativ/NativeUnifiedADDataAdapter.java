package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NativeUnifiedADData f9613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NativeADEventListener f9614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NativeADMediaListener f9615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DownloadConfirmListener f9616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NegativeFeedbackListener f9617e;

    public class UnifiedAdListener implements ADListener {
        public UnifiedAdListener() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeUnifiedADDataAdapter.a(NativeUnifiedADDataAdapter.this, aDEvent) || NativeUnifiedADDataAdapter.b(NativeUnifiedADDataAdapter.this, aDEvent)) {
                return;
            }
            NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = NativeUnifiedADDataAdapter.this;
            Objects.requireNonNull(nativeUnifiedADDataAdapter);
            NativeUnifiedADDataAdapter.c(nativeUnifiedADDataAdapter, aDEvent);
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.f9613a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener());
        }
    }

    public static boolean a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f9614b != null) {
            int type = aDEvent.getType();
            if (type == 103) {
                nativeUnifiedADDataAdapter.f9614b.onADExposed();
            } else if (type == 105) {
                NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.f9614b;
                if (nativeADEventListener instanceof NativeADEventListenerWithClickInfo) {
                    ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.f9614b).onADClicked((View) aDEvent.getParam(View.class));
                } else {
                    nativeADEventListener.onADClicked();
                }
            } else if (type == 107) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeUnifiedADDataAdapter.f9614b.onADError(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 111) {
                nativeUnifiedADDataAdapter.f9614b.onADStatusChanged();
            }
            return true;
        }
        return false;
    }

    public static boolean b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f9615c != null) {
            switch (aDEvent.getType()) {
                case 201:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        nativeUnifiedADDataAdapter.f9615c.onVideoLoaded(num.intValue());
                    }
                    return true;
                case AdEventType.VIDEO_START /* 202 */:
                    nativeUnifiedADDataAdapter.f9615c.onVideoStart();
                    return true;
                case AdEventType.VIDEO_RESUME /* 203 */:
                    nativeUnifiedADDataAdapter.f9615c.onVideoResume();
                    return true;
                case AdEventType.VIDEO_PAUSE /* 204 */:
                    nativeUnifiedADDataAdapter.f9615c.onVideoPause();
                    return true;
                case AdEventType.VIDEO_STOP /* 205 */:
                    nativeUnifiedADDataAdapter.f9615c.onVideoStop();
                    return true;
                case 206:
                    nativeUnifiedADDataAdapter.f9615c.onVideoCompleted();
                    return true;
                case AdEventType.VIDEO_ERROR /* 207 */:
                    Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                    if (num2 != null) {
                        nativeUnifiedADDataAdapter.f9615c.onVideoError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    }
                    return true;
                case AdEventType.VIDEO_CLICKED /* 208 */:
                    nativeUnifiedADDataAdapter.f9615c.onVideoClicked();
                    return true;
                case AdEventType.VIDEO_INIT /* 209 */:
                    nativeUnifiedADDataAdapter.f9615c.onVideoInit();
                    return true;
                case AdEventType.VIDEO_READY /* 210 */:
                    nativeUnifiedADDataAdapter.f9615c.onVideoReady();
                    return true;
                case AdEventType.VIDEO_LOADING /* 211 */:
                    nativeUnifiedADDataAdapter.f9615c.onVideoLoading();
                    return true;
            }
        }
        return false;
    }

    public static boolean c(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f9617e == null || aDEvent.getType() != 304) {
            return false;
        }
        nativeUnifiedADDataAdapter.f9617e.onComplainSuccess();
        return true;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        this.f9613a.bindAdToCustomVideo(viewGroup, context, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f9613a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.f9613a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.f9613a.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i2) {
        this.f9613a.bindImageViews(list, i2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        this.f9613a.bindImageViews(list, bArr);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f9615c = nativeADMediaListener;
        this.f9613a.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.f9613a.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f9613a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f9613a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f9613a.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f9613a.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return this.f9613a.getAppMiitInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f9613a.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f9613a.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f9613a.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return this.f9613a.getButtonText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f9613a.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        return this.f9613a.getCustomizeVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f9613a.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f9613a.getDownloadCount();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f9613a.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.f9613a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f9613a.getExtraInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f9613a.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f9613a.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f9613a.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f9613a.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f9613a.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f9613a.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f9613a.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f9613a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f9613a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f9613a.isAppAd();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.f9613a.isValid();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.f9613a.isWeChatCanvasAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f9613a.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f9616d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.f9613a.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f9613a.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.f9613a.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f9613a.resumeVideo();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i2, int i3, String str) {
        this.f9613a.sendLossNotification(i2, i3, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f9613a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i2) {
        this.f9613a.sendWinNotification(i2);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f9613a.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i2) {
        this.f9613a.setBidECPM(i2);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f9616d = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.f9613a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f9614b = nativeADEventListener;
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f9617e = negativeFeedbackListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.f9613a.setVideoMute(z);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f9613a.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f9613a.stopVideo();
    }
}
