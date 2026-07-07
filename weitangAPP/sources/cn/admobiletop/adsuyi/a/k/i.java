package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;

/* JADX INFO: loaded from: classes.dex */
public class i extends cn.admobiletop.adsuyi.a.b.c<cn.admobiletop.adsuyi.a.g.i, ADSuyiAdInfo, ADSuyiSplashAdListener, ADSuyiSplashAd> implements ADSuyiSplashAdListener {
    public boolean K;
    public boolean L;
    public ADSuyiAdInfo M;

    public i(ADSuyiSplashAd aDSuyiSplashAd, Handler handler) {
        super(aDSuyiSplashAd, handler);
        this.K = true;
        this.L = false;
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.g.i n() {
        return new cn.admobiletop.adsuyi.a.g.i();
    }

    @Override // cn.admobiletop.adsuyi.a.b.k, cn.admobiletop.adsuyi.a.b.v
    public void a(boolean z) {
        super.a(z);
        if (!z) {
            this.K = false;
        } else {
            this.K = true;
            z0();
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    public boolean l0() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener
    public void onADTick(long j) {
        ((ADSuyiSplashAdListener) a0()).onADTick(j);
    }

    @Override // cn.admobiletop.adsuyi.a.b.k, cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdClick(ADSuyiAdInfo aDSuyiAdInfo) {
        super.onAdClick(aDSuyiAdInfo);
        this.L = true;
    }

    @Override // cn.admobiletop.adsuyi.a.b.k, cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdClose(ADSuyiAdInfo aDSuyiAdInfo) {
        this.L = true;
        z0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.a.b.k, cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdFailed(ADSuyiError aDSuyiError) {
        if (!ADSuyiAdUtil.isReleased(f0()) && ((ADSuyiSplashAd) f0()).getContainer() != null) {
            ((ADSuyiSplashAd) f0()).getContainer().removeAllViews();
            ((ADSuyiSplashAd) f0()).getContainer().release();
        }
        super.onAdFailed(aDSuyiError);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.admobiletop.adsuyi.a.b.b, cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener
    public void onAdReceive(ADSuyiAdInfo aDSuyiAdInfo) {
        if (!i0() && aDSuyiAdInfo != null) {
            this.M = aDSuyiAdInfo;
            if (f0() != 0 && ((ADSuyiSplashAd) f0()).getContainer() != null) {
                ((ADSuyiSplashAd) f0()).getContainer().render(this.M, true, (ADSuyiSplashAd) f0());
                if ((aDSuyiAdInfo instanceof ADSuyiSplashAdInfo) && ((ADSuyiSplashAd) f0()).isOnlyLoad()) {
                    ((ADSuyiSplashAd) f0()).setAdSuyiSplashAdInfo((ADSuyiSplashAdInfo) aDSuyiAdInfo);
                }
            }
        }
        super.onAdReceive(aDSuyiAdInfo);
        if (aDSuyiAdInfo == null || !(aDSuyiAdInfo instanceof ADSuyiSplashAdInfo) || ((ADSuyiSplashAd) f0()).isOnlyLoad()) {
            return;
        }
        ((ADSuyiSplashAdInfo) aDSuyiAdInfo).showSplash(((ADSuyiSplashAd) f0()).getContainer());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener
    public void onReward(ADSuyiAdInfo aDSuyiAdInfo) {
        cn.admobiletop.adsuyi.a.g.i iVar;
        if (aDSuyiAdInfo == null || E() == null || (iVar = (cn.admobiletop.adsuyi.a.g.i) o(aDSuyiAdInfo)) == null || iVar.d()) {
            return;
        }
        iVar.d(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiSplashAdListener) a0()).onReward(aDSuyiAdInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.admobiletop.adsuyi.a.b.k, cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        this.M = null;
        if (f0() != 0 && ((ADSuyiSplashAd) f0()).getContainer() != null) {
            ADSuyiViewUtil.removeSelfFromParent(((ADSuyiSplashAd) f0()).getContainer());
            ((ADSuyiSplashAd) f0()).getContainer().release(false);
        }
        super.release();
    }

    @Override // cn.admobiletop.adsuyi.a.b.c
    public boolean y0(cn.admobiletop.adsuyi.a.g.i iVar) {
        return iVar != null && iVar.a();
    }

    public final void z0() {
        if (this.K && this.L) {
            super.onAdClose(this.M);
        }
    }
}
