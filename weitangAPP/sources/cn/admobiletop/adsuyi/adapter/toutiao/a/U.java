package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: loaded from: classes.dex */
public class U extends C0273c<ADSuyiSplashAdListener, TTNativeExpressAd> implements ADSuyiSplashAdInfo, TTNativeExpressAd.ExpressAdInteractionListener {
    public boolean k;
    public ADSuyiSplashAdContainer l;

    public U(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        if (getAdListener() != 0) {
            ((ADSuyiSplashAdListener) getAdListener()).onAdClick(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        if (getAdListener() != 0) {
            ((ADSuyiSplashAdListener) getAdListener()).onAdExpose(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        if (getAdListener() != 0) {
            ((ADSuyiSplashAdListener) getAdListener()).onAdFailed(new ADSuyiError(i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        ADSuyiSplashAdContainer aDSuyiSplashAdContainer = this.l;
        if (aDSuyiSplashAdContainer != null) {
            aDSuyiSplashAdContainer.setAlpha(1.0f);
        } else if (getAdListener() != 0) {
            ((ADSuyiSplashAdListener) getAdListener()).onAdFailed(new ADSuyiError(-1, "广告容器异常"));
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo
    public void showSplash(ADSuyiSplashAdContainer aDSuyiSplashAdContainer) {
        if (aDSuyiSplashAdContainer == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        this.l = aDSuyiSplashAdContainer;
        aDSuyiSplashAdContainer.setAlpha(0.0f);
        getAdapterAdInfo().setExpressInteractionListener(this);
        LinearLayout linearLayout = new LinearLayout(aDSuyiSplashAdContainer.getContext());
        linearLayout.setGravity(17);
        aDSuyiSplashAdContainer.addView(linearLayout, 0, new ViewGroup.LayoutParams(-1, -1));
        ADSuyiViewUtil.addAdViewToAdContainer(linearLayout, getAdapterAdInfo().getExpressAdView());
        getAdapterAdInfo().render();
        aDSuyiSplashAdContainer.addActionButtonView();
        aDSuyiSplashAdContainer.forceAddSkipView();
        this.k = true;
    }
}
