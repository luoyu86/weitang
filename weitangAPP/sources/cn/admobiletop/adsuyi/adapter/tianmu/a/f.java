package cn.admobiletop.adsuyi.adapter.tianmu.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeExpressAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeVideoListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiInterceptContainer;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.tianmu.ad.bean.NativeExpressAdInfo;

/* JADX INFO: loaded from: classes.dex */
public class f extends a<ADSuyiNativeAdListener, NativeExpressAdInfo> implements ADSuyiNativeExpressAdInfo {
    public String k;
    public View l;
    public ADSuyiInterceptContainer m;

    public f(String str, String str2) {
        super(str2);
        this.k = str;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeExpressAdInfo
    public View getNativeExpressAdView(@NonNull ViewGroup viewGroup) {
        ADSuyiViewUtil.releaseClickTouchListener(viewGroup, new View[0]);
        if (this.m == null && viewGroup != null) {
            this.l = getAdapterAdInfo().getNativeExpressAdView();
            if (getAdapterAdInfo() != null) {
                ADSuyiInterceptContainer aDSuyiInterceptContainer = new ADSuyiInterceptContainer(viewGroup.getContext());
                this.m = aDSuyiInterceptContainer;
                aDSuyiInterceptContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.m.setPosId(this.k);
                this.m.addResponseClickView(this.l);
            }
        }
        return this.m;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isVideo() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.adapter.tianmu.a.a, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onCloseClick(View view) {
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdClose(this);
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.tianmu.a.a, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        if (this.m != null) {
            ADSuyiViewUtil.removeSelfFromParent(new View[0]);
            this.m = null;
        }
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().release();
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
    }
}
