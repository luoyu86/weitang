package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiActionType;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeVideoListener;
import cn.admobiletop.adsuyi.util.ADSuyiToastUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends b<ADSuyiNativeAdListener, NativeUnifiedADData> implements ADSuyiNativeFeedAdInfo, NativeADEventListener, NativeADMediaListener {
    public ADSuyiNativeAd k;
    public boolean l;
    public cn.admobiletop.adsuyi.adapter.gdt.widget.c m;
    public ADSuyiNativeVideoListener n;
    public VideoOption o;

    public h(boolean z, String str, ADSuyiNativeAd aDSuyiNativeAd) {
        super(str);
        this.l = z;
        this.k = aDSuyiNativeAd;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(NativeUnifiedADData nativeUnifiedADData) {
        super.setAdapterAdInfo(nativeUnifiedADData);
        if (nativeUnifiedADData == null || !cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            return;
        }
        nativeUnifiedADData.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
    }

    public final String b() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        if (3 != getAdapterAdInfo().getAdPatternType()) {
            return getAdapterAdInfo().getImgUrl();
        }
        List<String> imgList = getAdapterAdInfo().getImgList();
        if (imgList == null || imgList.size() <= 0) {
            return null;
        }
        return imgList.get(0);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public int getActionType() {
        return -1;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public String getCtaText() {
        return ADSuyiActionType.getActionTex(getActionType(), getAdapterAdInfo() == null ? null : getAdapterAdInfo().getCTAText());
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public String getDesc() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getDesc();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public String getIconUrl() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getIconUrl();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public String getImageUrl() {
        return b();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public List<String> getImageUrlList() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getImgList();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public View getMediaView(@NonNull ViewGroup viewGroup) {
        ADSuyiViewUtil.releaseClickTouchListener(viewGroup, new View[0]);
        if (!isVideo()) {
            return null;
        }
        if (this.o == null) {
            this.o = cn.admobiletop.adsuyi.adapter.gdt.e.e.a(this.l);
        }
        cn.admobiletop.adsuyi.adapter.gdt.widget.c cVarA = cn.admobiletop.adsuyi.adapter.gdt.c.e.a().a(viewGroup, this.k);
        this.m = cVarA;
        return cVarA;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public String getTitle() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getTitle();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public boolean hasMediaView() {
        return isVideo();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isNativeExpress() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isVideo() {
        return getAdapterAdInfo() != null && 2 == getAdapterAdInfo().getAdPatternType();
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdClick(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdExpose(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onCloseClick(View view) {
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdClose(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoClicked() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoCompleted() {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.n;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoComplete(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoError(AdError adError) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.n;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoError(this, new ADSuyiError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoaded(int i2) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.n;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoLoad(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoPause() {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.n;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoPause(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoReady() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoResume() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStart() {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.n;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoStart(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStop() {
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, View... viewArr) {
        ADSuyiViewUtil.releaseClickTouchListener(viewGroup, viewArr);
        if (viewGroup == null || getAdapterAdInfo() == null) {
            return;
        }
        if (!(viewGroup instanceof NativeAdContainer)) {
            if (ADSuyiSdk.getInstance().isDebug()) {
                ADSuyiToastUtil.show(ADSuyiSdk.getInstance().getContext(), "广点通自渲染2.0广告，registerViewForInteraction传入的ViewGroup必须是NativeAdContainer");
                return;
            }
            return;
        }
        getAdapterAdInfo().setNativeAdEventListener(this);
        List<View> listAsList = null;
        if (viewArr != null && viewArr.length > 0) {
            listAsList = Arrays.asList(viewArr);
        }
        getAdapterAdInfo().bindAdToView(viewGroup.getContext(), (NativeAdContainer) viewGroup, new FrameLayout.LayoutParams(0, 0), listAsList);
        cn.admobiletop.adsuyi.adapter.gdt.widget.c cVar = this.m;
        if (cVar != null && cVar.getMediaView() != null && isVideo()) {
            getAdapterAdInfo().bindMediaView(this.m.getMediaView(), this.o, this);
        }
        getAdapterAdInfo().setVideoMute(this.l);
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().destroy();
            setAdapterAdInfo(null);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public void setVideoListener(ADSuyiNativeVideoListener aDSuyiNativeVideoListener) {
        if (isVideo()) {
            this.n = aDSuyiNativeVideoListener;
        }
    }

    public void a() {
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().resume();
        }
    }
}
