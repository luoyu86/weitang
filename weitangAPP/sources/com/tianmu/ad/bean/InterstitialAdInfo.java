package com.tianmu.ad.bean;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.activity.InterstitialActivity;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.listener.InterstitialAdListener;
import com.tianmu.ad.model.ITianmuNativeVideoAd;
import com.tianmu.biz.bean.VideoAutoPlayType;
import com.tianmu.c.i.l;
import com.tianmu.c.m.b;
import com.tianmu.c.n.h;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.j.a.c.a;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialAdInfo extends BaseAdInfo {
    private InterstitialAdListener t;
    private InterstitialAd u;
    private int v;
    private int w;
    private int x;
    private String y;

    public InterstitialAdInfo(l lVar, InterstitialAdListener interstitialAdListener, InterstitialAd interstitialAd, int i2, b bVar) {
        super(bVar);
        this.y = String.valueOf(hashCode());
        a(lVar);
        this.t = interstitialAdListener;
        this.u = interstitialAd;
        this.v = i2;
    }

    public int getAutoCloseSecond() {
        return this.x;
    }

    public View getMediaView(FrameLayout frameLayout) {
        return getMediaView(frameLayout, null, 0);
    }

    public String getPosId() {
        InterstitialAd interstitialAd = this.u;
        return interstitialAd == null ? "" : interstitialAd.getPosId();
    }

    public int getShowType() {
        return this.u.getAdPosId().f();
    }

    public int getSkipShowTIme() {
        return this.v;
    }

    public boolean isShowActionBar() {
        if (getAdData() == null) {
            return false;
        }
        try {
            if (!TextUtils.isEmpty(getAdData().getTitle()) || !TextUtils.isEmpty(getAdData().getDesc())) {
                return true;
            }
            if (getAdData().f() != null) {
                if (TextUtils.isEmpty(getAdData().f().d())) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean isVideo() {
        return getAdData() != null && (getAdData() instanceof ITianmuNativeVideoAd) && getAdData().isVideo();
    }

    @Override // com.tianmu.ad.base.BaseAdInfo
    public void release() {
        super.release();
    }

    public void setAutoCloseSecond(int i2) {
        this.x = i2;
    }

    public void setShowDirection(int i2) {
        this.w = i2;
    }

    public void showInterstitial(Context context) {
        h.a().a(this.y, this.t, this.u, this);
        if (hasShow()) {
            a(TianmuErrorConfig.AD_ALREADY_SHOW_ERROR, TianmuErrorConfig.MSG_AD_ALREADY_SHOW_ERROR);
        } else if (isAvailable()) {
            if (context != null && getAdData() != null) {
                InterstitialActivity.start(context, this.y, this.w);
            }
            setHasShow(true);
        }
    }

    public View getMediaView(FrameLayout frameLayout, ViewGroup.LayoutParams layoutParams, int i2) {
        TianmuViewUtil.releaseClickTouchListener(frameLayout, new View[0]);
        if (!isVideo() || getAdData() == null || !(getAdData() instanceof com.tianmu.c.i.h)) {
            return null;
        }
        ((com.tianmu.c.i.h) getAdData()).f(false);
        return ((com.tianmu.c.i.h) getAdData()).getAdView(frameLayout.getContext(), new a(this.f10637f), VideoAutoPlayType.DEFAULT_PLAY, layoutParams, i2);
    }
}
