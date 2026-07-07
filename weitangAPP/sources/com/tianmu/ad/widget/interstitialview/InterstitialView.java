package com.tianmu.ad.widget.interstitialview;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.widget.interstitialview.base.InterstitialExposeView;
import com.tianmu.ad.widget.interstitialview.factory.InterstitialBase;
import com.tianmu.biz.utils.t0;
import com.tianmu.biz.widget.f;
import com.tianmu.c.i.c;
import com.tianmu.c.i.h;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialView extends InterstitialExposeView {
    private final c p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final f f10703q;
    private InterstitialBase r;
    private ViewGroup s;
    private int t;
    private int u;

    public InterstitialView(@NonNull InterstitialAd interstitialAd, @NonNull InterstitialAdInfo interstitialAdInfo, @NonNull c cVar, @NonNull f fVar) {
        super(interstitialAd);
        setAdInfo(interstitialAdInfo);
        this.p = cVar;
        this.f10703q = fVar;
        preInit();
    }

    private int c() {
        try {
            return this.p.w();
        } catch (Exception unused) {
            return 2;
        }
    }

    private int d() {
        if (c() != 4) {
            return getAdInfo().getAdData() instanceof h ? 4 : 1;
        }
        return 2;
    }

    private int e() {
        return c() != 4 ? 6 : 7;
    }

    private String f() {
        try {
            return this.p.d().a();
        } catch (Exception unused) {
            return "0001";
        }
    }

    private void g() {
        String strF = f();
        strF.hashCode();
        InterstitialBase interstitialBaseCreate = InterstitialBase.create(this, !strF.equals("0002") ? d() : e(), getAdInfo(), this.imageLoaderCallback, this.f10703q.j(), this.t);
        this.r = interstitialBaseCreate;
        interstitialBaseCreate.setSingleClickListener(this.f10703q.g());
        this.r.setInteractClickListener(this.f10703q.i());
        this.r.setCloseClickListener(this.f10703q.h());
        this.r.setShowType(getAdInfo().getShowType());
        this.r.setClosePosition(this.u);
        this.r.init();
        this.r.setData();
        addView(this.r.getView(), new RelativeLayout.LayoutParams(-1, -1));
        this.r.setSize(t0.c(getContext()), t0.b(getContext()));
        ViewGroup exposureView = this.r.getExposureView();
        this.s = exposureView;
        exposureView.setOnClickListener(this.f10703q.g());
    }

    private void h() {
        if (this.p != null) {
            TianmuSDK.getInstance().getImageLoader().preloadImage(getContext(), this.p.getImageUrl(), new ImageView(getContext()));
        }
    }

    public InterstitialBase getInterstitialBase() {
        return this.r;
    }

    public void init() {
        g();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            InterstitialBase interstitialBase = this.r;
            if (interstitialBase != null) {
                interstitialBase.resume();
                return;
            }
            return;
        }
        InterstitialBase interstitialBase2 = this.r;
        if (interstitialBase2 != null) {
            interstitialBase2.pause();
        }
    }

    public void preInit() {
        h();
    }

    @Override // com.tianmu.ad.widget.interstitialview.base.InterstitialExposeView, com.tianmu.ad.base.BaseView
    public void release() {
        super.release();
        InterstitialBase interstitialBase = this.r;
        if (interstitialBase != null) {
            interstitialBase.release();
            this.r = null;
        }
    }

    @Override // com.tianmu.ad.widget.interstitialview.base.InterstitialExposeView
    public void render() {
        startExposeChecker();
    }

    public void setClosePosition(int i2) {
        this.u = i2;
    }

    public void setCountdownRemainTime(int i2) {
        this.t = i2;
    }
}
