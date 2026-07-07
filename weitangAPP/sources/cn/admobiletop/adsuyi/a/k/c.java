package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.ad.ADSuyiDrawVodAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: loaded from: classes.dex */
public class c extends cn.admobiletop.adsuyi.a.b.a<cn.admobiletop.adsuyi.a.g.h, ADSuyiDrawVodAdInfo, ADSuyiDrawVodAdListener, ADSuyiDrawVodAd> implements ADSuyiDrawVodAdListener {
    public c(ADSuyiDrawVodAd aDSuyiDrawVodAd, Handler handler) {
        super(aDSuyiDrawVodAd, handler);
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    public boolean l0() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener
    public void onRenderFailed(ADSuyiDrawVodAdInfo aDSuyiDrawVodAdInfo, ADSuyiError aDSuyiError) {
        cn.admobiletop.adsuyi.a.g.h hVar;
        if (aDSuyiDrawVodAdInfo == null || E() == null || (hVar = (cn.admobiletop.adsuyi.a.g.h) o(aDSuyiDrawVodAdInfo)) == null || hVar.d()) {
            return;
        }
        hVar.d(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiDrawVodAdListener) a0()).onRenderFailed(aDSuyiDrawVodAdInfo, aDSuyiError);
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.g.h n() {
        return new cn.admobiletop.adsuyi.a.g.h();
    }
}
