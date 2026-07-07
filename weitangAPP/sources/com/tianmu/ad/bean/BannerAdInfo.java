package com.tianmu.ad.bean;

import android.view.View;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.widget.BannerView;
import com.tianmu.c.c.e;
import com.tianmu.c.i.l;
import com.tianmu.config.TianmuErrorConfig;

/* JADX INFO: loaded from: classes2.dex */
public class BannerAdInfo extends BaseAdInfo {
    private BannerView t;

    public BannerAdInfo(e eVar) {
        super(eVar);
    }

    public View getAdView() {
        return this.t;
    }

    public void render() {
        BannerView bannerView;
        if (hasShow()) {
            a(TianmuErrorConfig.AD_ALREADY_SHOW_ERROR, TianmuErrorConfig.MSG_AD_ALREADY_SHOW_ERROR);
        } else if (isAvailable() && (bannerView = this.t) != null) {
            bannerView.render();
        }
    }

    public void setAdData(l lVar) {
        a(lVar);
    }

    public void setAdView(BannerView bannerView) {
        this.t = bannerView;
    }
}
