package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes.dex */
public class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeExpressAdInfo f3813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TianmuError f3814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f3815c;

    public m(n nVar, NativeExpressAdInfo nativeExpressAdInfo, TianmuError tianmuError) {
        this.f3815c = nVar;
        this.f3813a = nativeExpressAdInfo;
        this.f3814b = tianmuError;
    }

    @Override // java.lang.Runnable
    public void run() {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (this.f3815c.getAdListener() == 0 || this.f3815c.f3817e == null || this.f3813a == null || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3815c.f3817e, this.f3813a)) == null || this.f3814b == null) {
            return;
        }
        ((ADSuyiNativeAdListener) this.f3815c.getAdListener()).onRenderFailed(aDSuyiNativeAdInfo, new ADSuyiError(this.f3814b.getCode(), this.f3814b.getError()));
    }
}
