package com.tianmu.ad.widget.interstitialview.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.widget.interstitialview.InterstitialView;
import com.tianmu.biz.bean.InterstitialStyleBean;
import com.tianmu.c.f.c0;
import com.tianmu.utils.TianmuDisplayUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LandscapeInterstitialPicView extends InterstitialBase {
    public LandscapeInterstitialPicView(InterstitialView interstitialView, InterstitialAdInfo interstitialAdInfo) {
        super(interstitialView, interstitialAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a((int) (((double) this.A) * 0.6d), "", new InterstitialStyleBean(), 80, false, false);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public List<View> getClickViewList() {
        return new ArrayList();
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public ViewGroup getExposureView() {
        return this.f10710f;
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public ViewGroup getFullScreenContainer() {
        return this.f10709e;
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public View getView() {
        return this.f10714q;
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void initView() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(c0.f11285a, (ViewGroup) this.p, false);
        this.f10714q = viewGroup;
        this.f10709e = (RelativeLayout) viewGroup.findViewById(c0.f11287c);
        this.f10710f = (ViewGroup) this.f10714q.findViewById(c0.f11288d);
        this.f10711g = (RelativeLayout) this.f10714q.findViewById(c0.f11289e);
        this.f10712h = (ImageView) this.f10714q.findViewById(c0.f11290f);
        this.f10713i = (TextView) this.f10714q.findViewById(c0.f11291g);
        this.z = (RelativeLayout) this.f10714q.findViewById(c0.f11292h);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setConfigView() {
        this.f10712h.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tianmu.ad.widget.interstitialview.factory.LandscapeInterstitialPicView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewTreeObserver viewTreeObserver = LandscapeInterstitialPicView.this.f10712h.getViewTreeObserver();
                if (!viewTreeObserver.isAlive()) {
                    return true;
                }
                viewTreeObserver.removeOnPreDrawListener(this);
                ViewGroup.LayoutParams layoutParams = LandscapeInterstitialPicView.this.f10712h.getLayoutParams();
                int height = LandscapeInterstitialPicView.this.f10712h.getHeight();
                int i2 = (height * 9) / 16;
                layoutParams.width = i2;
                LandscapeInterstitialPicView.this.f10712h.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = LandscapeInterstitialPicView.this.f10711g.getLayoutParams();
                layoutParams2.width = i2;
                LandscapeInterstitialPicView.this.f10711g.setLayoutParams(layoutParams2);
                LandscapeInterstitialPicView landscapeInterstitialPicView = LandscapeInterstitialPicView.this;
                landscapeInterstitialPicView.A = i2;
                landscapeInterstitialPicView.B = height;
                landscapeInterstitialPicView.a(TianmuDisplayUtil.dp2px(25), TianmuDisplayUtil.dp2px(30), TianmuDisplayUtil.dp2px(400));
                LandscapeInterstitialPicView landscapeInterstitialPicView2 = LandscapeInterstitialPicView.this;
                if (landscapeInterstitialPicView2.f10709e != null && !landscapeInterstitialPicView2.isHalf()) {
                    LandscapeInterstitialPicView.this.f10709e.setBackgroundColor(-1);
                }
                LandscapeInterstitialPicView.this.e();
                LandscapeInterstitialPicView landscapeInterstitialPicView3 = LandscapeInterstitialPicView.this;
                RelativeLayout relativeLayout = landscapeInterstitialPicView3.f10711g;
                landscapeInterstitialPicView3.b(relativeLayout, relativeLayout, 5, 5, landscapeInterstitialPicView3.getClosePosition());
                LandscapeInterstitialPicView landscapeInterstitialPicView4 = LandscapeInterstitialPicView.this;
                RelativeLayout relativeLayout2 = landscapeInterstitialPicView4.f10711g;
                landscapeInterstitialPicView4.a(relativeLayout2, relativeLayout2, 10, 10, landscapeInterstitialPicView4.getClosePosition());
                LandscapeInterstitialPicView.this.addAppInfo(TianmuDisplayUtil.dp2px(160));
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4) {
        if (c()) {
            addActionBarAni(this.f10714q, i2, i3, i4, 800L);
        }
    }
}
