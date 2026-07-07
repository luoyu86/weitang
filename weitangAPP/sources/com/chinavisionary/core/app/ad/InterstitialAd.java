package com.chinavisionary.core.app.ad;

import android.app.Activity;
import cn.admobiletop.adsuyi.ad.ADSuyiInterstitialAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.chinavisionary.core.app.ad.base.BaseAd;

/* JADX INFO: loaded from: classes.dex */
public class InterstitialAd extends BaseAd {
    private ADSuyiInterstitialAd mADSuyiInterstitialAd;
    private ADSuyiInterstitialAdInfo mADSuyiInterstitialAdInfo;

    public InterstitialAd(String str) {
        super(str);
    }

    private void loadAd() {
        ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo = this.mADSuyiInterstitialAdInfo;
        if (aDSuyiInterstitialAdInfo != null) {
            aDSuyiInterstitialAdInfo.release();
            this.mADSuyiInterstitialAdInfo = null;
        }
        this.mADSuyiInterstitialAd.loadAd(this.mAdPostId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        ADSuyiInterstitialAd aDSuyiInterstitialAd = this.mADSuyiInterstitialAd;
        if (aDSuyiInterstitialAd != null) {
            aDSuyiInterstitialAd.release();
            this.mADSuyiInterstitialAd = null;
        }
        ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo = this.mADSuyiInterstitialAdInfo;
        if (aDSuyiInterstitialAdInfo != null) {
            aDSuyiInterstitialAdInfo.release();
            this.mADSuyiInterstitialAdInfo = null;
        }
    }

    public void addInterstitialAd(final Activity activity) {
        this.TAG = getClass().getSimpleName();
        this.mADSuyiInterstitialAd = new ADSuyiInterstitialAd(activity);
        this.mADSuyiInterstitialAd.setLocalExtraParams(new ADSuyiExtraParams.Builder().setVideoWithMute(false).build());
        this.mADSuyiInterstitialAd.setListener(new ADSuyiInterstitialAdListener() { // from class: com.chinavisionary.core.app.ad.InterstitialAd.1
            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdFailed(ADSuyiError aDSuyiError) {
                if (aDSuyiError != null) {
                    String string = aDSuyiError.toString();
                    InterstitialAd.this.d("onAdFailed..." + string);
                }
                InterstitialAd.this.release();
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener
            public void onAdReady(ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo) {
                InterstitialAd.this.d("onAdReady...");
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdClick(ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo) {
                InterstitialAd.this.d("onAdClick...");
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdClose(ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo) {
                InterstitialAd.this.d("onAdClose...");
                InterstitialAd.this.release();
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdExpose(ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo) {
                InterstitialAd.this.d("onAdExpose...");
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener
            public void onAdReceive(ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo) {
                InterstitialAd.this.mADSuyiInterstitialAdInfo = aDSuyiInterstitialAdInfo;
                InterstitialAd.this.d("onAdReceive...");
                ADSuyiAdUtil.showInterstitialAdConvenient(activity, aDSuyiInterstitialAdInfo);
            }
        });
        loadAd();
    }
}
