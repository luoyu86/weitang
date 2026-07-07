package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeExpressAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeVideoListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiInterceptContainer;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class i extends b<ADSuyiNativeAdListener, NativeExpressADView> implements ADSuyiNativeExpressAdInfo, NativeExpressMediaListener {
    public String k;
    public ADSuyiNativeVideoListener l;
    public ADSuyiInterceptContainer m;

    public i(String str, String str2) {
        super(str2);
        this.k = str;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(NativeExpressADView nativeExpressADView) {
        super.setAdapterAdInfo(nativeExpressADView);
        if (nativeExpressADView == null || !cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            return;
        }
        nativeExpressADView.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeExpressAdInfo
    public View getNativeExpressAdView(@NonNull ViewGroup viewGroup) {
        ADSuyiViewUtil.releaseClickTouchListener(viewGroup, new View[0]);
        if (this.m == null && getAdapterAdInfo() != null) {
            ADSuyiInterceptContainer aDSuyiInterceptContainer = new ADSuyiInterceptContainer(getAdapterAdInfo().getContext());
            this.m = aDSuyiInterceptContainer;
            aDSuyiInterceptContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.m.setPosId(this.k);
            this.m.addResponseClickView(getAdapterAdInfo());
        }
        return this.m;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isVideo() {
        return (getAdapterAdInfo() == null || getAdapterAdInfo().getBoundData() == null || getAdapterAdInfo().getBoundData().getAdPatternType() != 2) ? false : true;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onCloseClick(View view) {
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdClose(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoCached(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoComplete(NativeExpressADView nativeExpressADView) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.l;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoComplete(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.l;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoError(this, new ADSuyiError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoInit(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoLoading(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPause(NativeExpressADView nativeExpressADView) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.l;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoPause(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.l;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoLoad(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoStart(NativeExpressADView nativeExpressADView) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.l;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoStart(this);
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        this.l = null;
        if (this.m != null) {
            ADSuyiViewUtil.removeSelfFromParent(new View[0]);
            this.m = null;
        }
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().destroy();
            setAdapterAdInfo(null);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeExpressAdInfo
    public void render(@NonNull ViewGroup viewGroup) {
        ADSuyiViewUtil.releaseClickTouchListener(viewGroup, new View[0]);
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().render();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public void setVideoListener(ADSuyiNativeVideoListener aDSuyiNativeVideoListener) {
        if (isVideo()) {
            this.l = aDSuyiNativeVideoListener;
            getAdapterAdInfo().setMediaListener(this);
        }
    }
}
