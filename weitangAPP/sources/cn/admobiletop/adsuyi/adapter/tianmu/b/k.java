package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.bean.NativeAdInfo;
import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes.dex */
public class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdInfo f3806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TianmuError f3807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f3808c;

    public k(l lVar, NativeAdInfo nativeAdInfo, TianmuError tianmuError) {
        this.f3808c = lVar;
        this.f3806a = nativeAdInfo;
        this.f3807b = tianmuError;
    }

    @Override // java.lang.Runnable
    public void run() {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (this.f3808c.getAdListener() == 0 || this.f3808c.f3810e == null || this.f3806a == null || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3808c.f3810e, this.f3806a)) == null || this.f3807b == null) {
            return;
        }
        ((ADSuyiNativeAdListener) this.f3808c.getAdListener()).onRenderFailed(aDSuyiNativeAdInfo, new ADSuyiError(this.f3807b.getCode(), this.f3807b.getError()));
    }
}
