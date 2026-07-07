package cn.admobiletop.adsuyi.a.k.a;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class c implements ADSuyiBidAdapterCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ADSuyiPlatformPosId f3350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3351b;

    public c(e eVar, ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        this.f3351b = eVar;
        this.f3350a = aDSuyiPlatformPosId;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback
    public void onFailed(String str, String str2) {
        ADSuyiLogUtil.d(str + " 平台的竞价失败，" + str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3351b.f3360h.remove(str);
        this.f3351b.E();
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback
    public void onSuccess(ADSuyiBidResponsed aDSuyiBidResponsed) {
        ADSuyiLogUtil.d(aDSuyiBidResponsed.getPlatform() + " 平台的竞价返回值，" + aDSuyiBidResponsed.getCPM());
        this.f3351b.g(aDSuyiBidResponsed, this.f3350a);
    }
}
