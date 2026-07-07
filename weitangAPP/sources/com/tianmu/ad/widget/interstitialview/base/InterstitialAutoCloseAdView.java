package com.tianmu.ad.widget.interstitialview.base;

import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.bean.InterstitialAdInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InterstitialAutoCloseAdView extends BaseInterstitialAdViewContainer {
    private CountDownTimer u;
    private int v;
    public int w;
    private int x;
    private boolean y;

    public InterstitialAutoCloseAdView(@NonNull InterstitialAd interstitialAd, @NonNull InterstitialAdInfo interstitialAdInfo) {
        super(interstitialAd, interstitialAdInfo);
        this.x = 1000;
    }

    private void g() {
        if (f()) {
            setCountDownText(this.v);
            this.u = new CountDownTimer(this.w * 1000, this.x) { // from class: com.tianmu.ad.widget.interstitialview.base.InterstitialAutoCloseAdView.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    InterstitialAutoCloseAdView interstitialAutoCloseAdView = InterstitialAutoCloseAdView.this;
                    interstitialAutoCloseAdView.w = 0;
                    interstitialAutoCloseAdView.setCountDownText(0);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    InterstitialAutoCloseAdView interstitialAutoCloseAdView = InterstitialAutoCloseAdView.this;
                    int i2 = interstitialAutoCloseAdView.w - 1;
                    interstitialAutoCloseAdView.w = i2;
                    interstitialAutoCloseAdView.setCountDownText(i2);
                }
            };
        }
    }

    public void a(int i2) {
        this.v = i2;
        this.w = i2;
    }

    public boolean f() {
        return this.v > 0;
    }

    @Override // com.tianmu.c.c.g
    public void init() {
        g();
    }

    @Override // com.tianmu.ad.widget.interstitialview.base.BaseInterstitialAdViewContainer, com.tianmu.c.c.g, com.tianmu.ad.base.IBaseRelease
    public void release() {
        super.release();
        stopCountDown();
        this.u = null;
    }

    @Override // com.tianmu.c.c.g
    public void render() {
        startCountDown();
    }

    public abstract void setCountDownText(int i2);

    public void startCountDown() {
        CountDownTimer countDownTimer;
        if (this.y || !f() || (countDownTimer = this.u) == null) {
            return;
        }
        this.y = true;
        countDownTimer.start();
    }

    public void stopCountDown() {
        CountDownTimer countDownTimer;
        if (this.y && (countDownTimer = this.u) != null) {
            this.y = false;
            countDownTimer.cancel();
        }
    }
}
