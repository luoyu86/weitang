package com.chinavisionary.core.app.ad;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import com.chinavisionary.core.app.ad.base.BaseAd;

/* JADX INFO: loaded from: classes.dex */
public class BannerAd extends BaseAd {
    private ADSuyiBannerAd mADSuyiBannerAd;
    private ViewGroup mFrameLayout;

    public BannerAd(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release(boolean z) {
        ADSuyiBannerAd aDSuyiBannerAd = this.mADSuyiBannerAd;
        if (aDSuyiBannerAd != null) {
            aDSuyiBannerAd.release();
            this.mADSuyiBannerAd = null;
        }
        ViewGroup viewGroup = this.mFrameLayout;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (z) {
                ViewGroup viewGroup2 = this.mFrameLayout;
                viewGroup2.addView(createBannerAdDefaultView(viewGroup2.getContext()));
            }
        }
    }

    public void loadBannerAd(Fragment fragment, ViewGroup viewGroup) {
        this.TAG = getClass().getSimpleName() + "_postId = " + this.mAdPostId;
        this.mFrameLayout = viewGroup;
        ADSuyiBannerAd aDSuyiBannerAd = new ADSuyiBannerAd(fragment, viewGroup);
        this.mADSuyiBannerAd = aDSuyiBannerAd;
        aDSuyiBannerAd.setListener(new ADSuyiBannerAdListener() { // from class: com.chinavisionary.core.app.ad.BannerAd.1
            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdClick(ADSuyiAdInfo aDSuyiAdInfo) {
                BannerAd.this.d("onAdClick...");
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdClose(ADSuyiAdInfo aDSuyiAdInfo) {
                BannerAd.this.d("onAdClose...");
                BannerAd.this.release(false);
                if (aDSuyiAdInfo != null) {
                    aDSuyiAdInfo.release();
                }
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdExpose(ADSuyiAdInfo aDSuyiAdInfo) {
                BannerAd.this.d("onAdExpose...");
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
            public void onAdFailed(ADSuyiError aDSuyiError) {
                if (aDSuyiError != null) {
                    String string = aDSuyiError.toString();
                    BannerAd.this.d("onAdFailed..." + string);
                }
                BannerAd.this.release(true);
            }

            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener
            public void onAdReceive(ADSuyiAdInfo aDSuyiAdInfo) {
                BannerAd.this.d("onAdReceive...");
            }
        });
        this.mADSuyiBannerAd.loadAd(this.mAdPostId);
    }
}
