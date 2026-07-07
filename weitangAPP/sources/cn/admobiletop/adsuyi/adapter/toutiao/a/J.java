package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeVideoListener;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class J extends ca<ADSuyiNativeAdListener> implements ADSuyiNativeFeedAdInfo, TTNativeAd.ExpressRenderListener, TTNativeAd.AdInteractionListener, TTFeedAd.VideoAdListener {
    public ADSuyiNativeVideoListener k;
    public boolean l;
    public Handler m;

    public J(String str) {
        super(str);
        this.m = new Handler(Looper.getMainLooper());
    }

    public final List<String> d() {
        if (getAdapterAdInfo() == null || getAdapterAdInfo().getImageList() == null || getAdapterAdInfo().getImageList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getAdapterAdInfo().getImageList().size(); i2++) {
            arrayList.add(getAdapterAdInfo().getImageList().get(i2).getImageUrl());
        }
        return arrayList;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public int getActionType() {
        if (getAdapterAdInfo() == null) {
            return -1;
        }
        if (getAdapterAdInfo().getInteractionType() == 4) {
            return 2;
        }
        if (getAdapterAdInfo().getInteractionType() == 3) {
            return 0;
        }
        return getAdapterAdInfo().getInteractionType() == 2 ? 1 : -1;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public String getCtaText() {
        return getAdapterAdInfo() != null ? getAdapterAdInfo().getButtonText() : "查看详情";
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public String getDesc() {
        if (getAdapterAdInfo() != null) {
            return getAdapterAdInfo().getDescription();
        }
        return null;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public String getIconUrl() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getIcon().getImageUrl();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public String getImageUrl() {
        if (d() == null || d().size() <= 0) {
            return null;
        }
        return d().get(0);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public List<String> getImageUrlList() {
        return d();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public View getMediaView(@NonNull ViewGroup viewGroup) {
        if (isVideo() && getAdapterAdInfo() != null) {
            return getAdapterAdInfo().getAdView();
        }
        return null;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public String getTitle() {
        if (getAdapterAdInfo() != null) {
            return getAdapterAdInfo().getTitle();
        }
        return null;
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
        return getAdapterAdInfo() != null && 5 == getAdapterAdInfo().getImageMode();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new B(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new C(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new D(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
    public void onRenderSuccess(View view, float f2, float f3, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdComplete(TTFeedAd tTFeedAd) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new I(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdPaused(TTFeedAd tTFeedAd) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new H(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new G(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoError(int i2, int i3) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new F(this, i2, i3));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoLoad(TTFeedAd tTFeedAd) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new E(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo, cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public void registerCloseView(View view) {
        if (view != null) {
            view.setOnClickListener(new A(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, View... viewArr) {
        ADSuyiViewUtil.releaseClickTouchListener(viewGroup, viewArr);
        if (viewGroup == null || getAdapterAdInfo() == null) {
            return;
        }
        List<View> listAsList = null;
        if (viewArr != null && viewArr.length > 0) {
            listAsList = Arrays.asList(viewArr);
        }
        getAdapterAdInfo().registerViewForInteraction(viewGroup, listAsList, listAsList, this);
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.ca, cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        this.k = null;
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.m = null;
        }
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().destroy();
            setAdapterAdInfo(null);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public void setVideoListener(ADSuyiNativeVideoListener aDSuyiNativeVideoListener) {
        if (isVideo()) {
            this.k = aDSuyiNativeVideoListener;
            getAdapterAdInfo().setVideoAdListener(this);
        }
    }
}
