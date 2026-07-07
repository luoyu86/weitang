package com.tianmu.ad.widget.interstitialview.base;

import androidx.annotation.NonNull;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.widget.interstitialview.InterstitialView;
import com.tianmu.c.c.g;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseInterstitialAdViewContainer extends g<InterstitialView, InterstitialAd, InterstitialAdInfo> {
    public int t;

    public BaseInterstitialAdViewContainer(@NonNull InterstitialAd interstitialAd, @NonNull InterstitialAdInfo interstitialAdInfo) {
        super(interstitialAd.getContext(), interstitialAd, interstitialAdInfo);
        this.t = -1;
    }

    public int e() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        AD ad = this.n;
        if (ad == 0 || ((InterstitialAd) ad).getAdPosId() == null) {
            this.t = 0;
            return 0;
        }
        if (((InterstitialAd) this.n).getAdPosId().e() == 2) {
            this.t = !new Random().nextBoolean() ? 1 : 0;
        } else {
            this.t = ((InterstitialAd) this.n).getAdPosId().e();
        }
        return this.t;
    }

    @Override // com.tianmu.c.c.g, com.tianmu.ad.base.IBaseRelease
    public void release() {
        super.release();
    }
}
