package com.chinavisionary.core.app.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import com.chinavisionary.core.app.ad.base.BaseAd;
import com.chinavisionary.core.app.ad.callback.ISplashHideCallback;

/* JADX INFO: loaded from: classes.dex */
public class SplashAd extends BaseAd {
    private ADSuyiSplashAd mADSuyiSplashAd;
    private ViewGroup mAdSplashViewGroup;

    public SplashAd(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printAdWH() {
        int childCount = this.mAdSplashViewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.mAdSplashViewGroup.getChildAt(i2);
            d("printAdWH childView = " + childAt.getWidth() + " x " + childAt.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAd() {
        ViewGroup viewGroup = this.mAdSplashViewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.mAdSplashViewGroup.setVisibility(8);
        }
        ADSuyiSplashAd aDSuyiSplashAd = this.mADSuyiSplashAd;
        if (aDSuyiSplashAd != null) {
            aDSuyiSplashAd.release();
            this.mADSuyiSplashAd = null;
        }
    }

    public void addSplashAd(Activity activity, ViewGroup viewGroup, final ISplashHideCallback iSplashHideCallback) {
        this.TAG = "SplashAd";
        this.mAdSplashViewGroup = viewGroup;
        ADSuyiSplashAd aDSuyiSplashAd = new ADSuyiSplashAd(activity, viewGroup);
        this.mADSuyiSplashAd = aDSuyiSplashAd;
        aDSuyiSplashAd.setListener(new ADSuyiSplashAdListener() { // from class: com.chinavisionary.core.app.ad.SplashAd.1
            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener
            public void onADTick(long j) {
                SplashAd.this.d("onADTick countdownSeconds = " + j);
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdClick(ADSuyiAdInfo aDSuyiAdInfo) {
                SplashAd.this.d("onAdClick");
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdClose(ADSuyiAdInfo aDSuyiAdInfo) {
                SplashAd.this.d("onAdClose");
                SplashAd.this.releaseAd();
                ISplashHideCallback iSplashHideCallback2 = iSplashHideCallback;
                if (iSplashHideCallback2 != null) {
                    iSplashHideCallback2.onHide();
                }
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdExpose(ADSuyiAdInfo aDSuyiAdInfo) {
                SplashAd.this.d("onAdExpose");
                SplashAd.this.printAdWH();
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdFailed(ADSuyiError aDSuyiError) {
                if (aDSuyiError != null) {
                    SplashAd.this.d("onAdFailed = " + aDSuyiError);
                }
                SplashAd.this.releaseAd();
                ISplashHideCallback iSplashHideCallback2 = iSplashHideCallback;
                if (iSplashHideCallback2 != null) {
                    iSplashHideCallback2.onHide();
                }
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener
            public void onAdReceive(ADSuyiAdInfo aDSuyiAdInfo) {
                SplashAd.this.d("onAdReceive");
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoSkipListener
            public void onAdSkip(ADSuyiAdInfo aDSuyiAdInfo) {
                SplashAd.this.d("onAdSkip");
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener
            public void onReward(ADSuyiAdInfo aDSuyiAdInfo) {
                SplashAd.this.d("onReward");
            }
        });
        this.mADSuyiSplashAd.loadAd(this.mAdPostId);
    }
}
