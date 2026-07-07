package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.app.Activity;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class f extends b<ADSuyiInnerNoticeAdListener, NativeUnifiedADData> implements ADSuyiInnerNoticeAdInfo, NativeADEventListener {
    public boolean k;
    public cn.admobiletop.adsuyi.adapter.gdt.widget.a.b l;

    public f(String str) {
        super(str);
    }

    public final void a() {
        cn.admobiletop.adsuyi.adapter.gdt.widget.a.b bVar = this.l;
        if (bVar != null) {
            bVar.release();
            this.l = null;
        }
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

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        if (getAdListener() != 0) {
            ((ADSuyiInnerNoticeAdListener) getAdListener()).onAdClick(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        if (getAdListener() != 0) {
            ((ADSuyiInnerNoticeAdListener) getAdListener()).onAdFailed(new ADSuyiError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        if (getAdListener() != 0) {
            ((ADSuyiInnerNoticeAdListener) getAdListener()).onAdExpose(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        a();
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().destroy();
            setAdapterAdInfo(null);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo
    public void showInnerNoticeAd(@NonNull Activity activity) {
        if (activity == null || isReleased() || !isReady() || hasShown() || hasExpired() || getAdapterAdInfo() == null) {
            return;
        }
        this.k = true;
        cn.admobiletop.adsuyi.adapter.gdt.widget.a.b bVar = new cn.admobiletop.adsuyi.adapter.gdt.widget.a.b(activity, getAdapterAdInfo());
        this.l = bVar;
        bVar.a(new e(this));
        getAdapterAdInfo().setNativeAdEventListener(this);
        this.l.show();
        this.l.a(getAdapterAdInfo().getImgUrl(), getAdapterAdInfo().getTitle(), getAdapterAdInfo().getDesc());
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
}
