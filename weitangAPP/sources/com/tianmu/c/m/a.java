package com.tianmu.c.m;

import android.os.Handler;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.tianmu.ad.BannerAd;
import com.tianmu.ad.bean.BannerAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.BannerAdListener;
import com.tianmu.c.b.g;
import com.tianmu.utils.TianmuAdUtil;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.tianmu.c.c.c<com.tianmu.c.c.f, BannerAdInfo, BannerAdListener, BannerAd> implements BannerAdListener {
    private boolean p;

    public a(BannerAd bannerAd, Handler handler) {
        super(bannerAd, handler);
        this.p = true;
    }

    @Override // com.tianmu.c.c.c, com.tianmu.ad.listener.AdInfoListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdReceive(BannerAdInfo bannerAdInfo) {
        if (h()) {
            c().clear();
            a(false);
        }
        super.onAdReceive(bannerAdInfo);
    }

    @Override // com.tianmu.c.c.e
    public void m() {
        g.a(ILivePush.ClickType.CLOSE, 1, e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.tianmu.ad.base.BaseAd] */
    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        if (!h() && !TianmuAdUtil.isReleased(d()) && ((BannerAd) d()).getContainer() != null) {
            ((BannerAd) d()).getContainer().removeAllViews();
        }
        if (h() && !g() && !TianmuAdUtil.isReleased(this.f11236b)) {
            a(tianmuError);
        } else {
            super.onAdFailed(tianmuError);
            TianmuLogUtil.d(tianmuError.toString());
        }
    }

    @Override // com.tianmu.c.c.c
    public void q() {
        if (this.p) {
            this.p = false;
        } else {
            g.a("request", 1, e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.IBaseRelease
    public void release() {
        BannerAd bannerAd = (BannerAd) d();
        if (bannerAd != null && bannerAd.getContainer() != null) {
            bannerAd.getContainer().removeAllViews();
        }
        super.release();
    }

    @Override // com.tianmu.c.c.e
    public com.tianmu.c.c.f a() {
        return new com.tianmu.c.c.f();
    }
}
