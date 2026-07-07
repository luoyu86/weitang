package com.tianmu.c.m;

import android.os.Handler;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.InterstitialAdListener;
import com.tianmu.utils.TianmuAdUtil;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.tianmu.c.c.c<com.tianmu.c.c.f, InterstitialAdInfo, InterstitialAdListener, InterstitialAd> implements InterstitialAdListener {
    public b(InterstitialAd interstitialAd, Handler handler) {
        super(interstitialAd, handler);
    }

    @Override // com.tianmu.c.c.e
    public com.tianmu.c.c.f a() {
        return new com.tianmu.c.c.f();
    }

    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        if (h() && !g() && !TianmuAdUtil.isReleased(this.f11236b)) {
            a(tianmuError);
        } else {
            super.onAdFailed(tianmuError);
            TianmuLogUtil.d(tianmuError.toString());
        }
    }

    @Override // com.tianmu.ad.listener.InterstitialAdListener
    public void onVideoError(InterstitialAdInfo interstitialAdInfo) {
    }

    @Override // com.tianmu.ad.listener.InterstitialAdListener
    public void onVideoFinish(InterstitialAdInfo interstitialAdInfo) {
    }

    @Override // com.tianmu.ad.listener.InterstitialAdListener
    public void onVideoPause(InterstitialAdInfo interstitialAdInfo) {
    }

    @Override // com.tianmu.ad.listener.InterstitialAdListener
    public void onVideoStart(InterstitialAdInfo interstitialAdInfo) {
    }
}
