package com.tianmu.ad.widget.splashview.base;

import androidx.annotation.NonNull;
import com.tianmu.ad.SplashAd;
import com.tianmu.ad.bean.SplashAdInfo;
import com.tianmu.ad.widget.splashview.SplashView;
import com.tianmu.c.c.g;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSplashAdViewContainer extends g<SplashView, SplashAd, SplashAdInfo> {
    public int t;

    public BaseSplashAdViewContainer(@NonNull SplashAd splashAd, @NonNull SplashAdInfo splashAdInfo) {
        super(splashAd.getContext(), splashAd, splashAdInfo);
        this.t = -1;
    }

    public int e() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        if (f() || ((SplashAd) this.n).getAdPosId() == null) {
            this.t = 0;
            return 0;
        }
        if (((SplashAd) this.n).getAdPosId().e() == 2) {
            this.t = !new Random().nextBoolean() ? 1 : 0;
        } else {
            this.t = ((SplashAd) this.n).getAdPosId().e();
        }
        return this.t;
    }

    public boolean f() {
        AD ad = this.n;
        return (ad == 0 || ((SplashAd) ad).getSkipView() == null) ? false : true;
    }

    @Override // com.tianmu.c.c.g
    public abstract void init();

    @Override // com.tianmu.c.c.g
    public abstract void render();
}
