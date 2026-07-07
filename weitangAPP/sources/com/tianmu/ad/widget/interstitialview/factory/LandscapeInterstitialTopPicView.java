package com.tianmu.ad.widget.interstitialview.factory;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.widget.interstitialview.InterstitialView;
import com.tianmu.biz.bean.InterstitialStyleBean;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.d0;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LandscapeInterstitialTopPicView extends InterstitialBase {
    public FrameLayout H;
    public TextView I;
    public RoundedImageView J;

    public LandscapeInterstitialTopPicView(InterstitialView interstitialView, InterstitialAdInfo interstitialAdInfo) {
        super(interstitialView, interstitialAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a(this.A / 3, "", new InterstitialStyleBean(), 30, true, true);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public List<View> getClickViewList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10711g);
        return arrayList;
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
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(d0.f11308a, (ViewGroup) this.p, false);
        this.f10714q = viewGroup;
        this.f10709e = (RelativeLayout) viewGroup.findViewById(d0.f11310c);
        this.f10710f = (ViewGroup) this.f10714q.findViewById(d0.f11311d);
        this.f10711g = (RelativeLayout) this.f10714q.findViewById(d0.f11312e);
        this.H = (FrameLayout) this.f10714q.findViewById(d0.f11313f);
        this.k = (TextView) this.f10714q.findViewById(d0.f11314g);
        this.l = (TextView) this.f10714q.findViewById(d0.f11315h);
        this.f10713i = (TextView) this.f10714q.findViewById(d0.j);
        this.I = (TextView) this.f10714q.findViewById(d0.k);
        this.J = (RoundedImageView) this.f10714q.findViewById(d0.f11316i);
        this.z = (RelativeLayout) this.f10714q.findViewById(d0.l);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setConfigView() {
        this.H.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tianmu.ad.widget.interstitialview.factory.LandscapeInterstitialTopPicView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewTreeObserver viewTreeObserver = LandscapeInterstitialTopPicView.this.H.getViewTreeObserver();
                if (!viewTreeObserver.isAlive()) {
                    return true;
                }
                viewTreeObserver.removeOnPreDrawListener(this);
                int height = LandscapeInterstitialTopPicView.this.H.getHeight();
                int i2 = (height * 16) / 9;
                ViewGroup.LayoutParams layoutParams = LandscapeInterstitialTopPicView.this.H.getLayoutParams();
                layoutParams.width = i2;
                LandscapeInterstitialTopPicView.this.H.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = LandscapeInterstitialTopPicView.this.f10711g.getLayoutParams();
                layoutParams2.width = i2;
                LandscapeInterstitialTopPicView.this.f10711g.setLayoutParams(layoutParams2);
                LandscapeInterstitialTopPicView landscapeInterstitialTopPicView = LandscapeInterstitialTopPicView.this;
                landscapeInterstitialTopPicView.A = i2;
                landscapeInterstitialTopPicView.B = height;
                landscapeInterstitialTopPicView.e();
                LandscapeInterstitialTopPicView landscapeInterstitialTopPicView2 = LandscapeInterstitialTopPicView.this;
                if (landscapeInterstitialTopPicView2.f10709e != null && !landscapeInterstitialTopPicView2.isHalf()) {
                    LandscapeInterstitialTopPicView.this.f10709e.setBackgroundColor(-1);
                }
                LandscapeInterstitialTopPicView landscapeInterstitialTopPicView3 = LandscapeInterstitialTopPicView.this;
                ViewGroup viewGroup = landscapeInterstitialTopPicView3.f10710f;
                landscapeInterstitialTopPicView3.b(viewGroup, viewGroup, 5, 5, landscapeInterstitialTopPicView3.getClosePosition());
                LandscapeInterstitialTopPicView landscapeInterstitialTopPicView4 = LandscapeInterstitialTopPicView.this;
                ViewGroup viewGroup2 = landscapeInterstitialTopPicView4.f10710f;
                landscapeInterstitialTopPicView4.a(viewGroup2, viewGroup2, 10, 10, landscapeInterstitialTopPicView4.getClosePosition());
                LandscapeInterstitialTopPicView.this.addAppInfo(TianmuDisplayUtil.dp2px(160));
                return true;
            }
        });
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setData() {
        super.setData();
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo != null && interstitialAdInfo.getAdData() != null) {
            this.I.setText(this.o.getAdData().b());
        }
        InterstitialAdInfo interstitialAdInfo2 = this.o;
        if (interstitialAdInfo2 == null || interstitialAdInfo2.getAdData() == null) {
            return;
        }
        if (TextUtils.isEmpty(this.o.getAdData().getAppIconUrl())) {
            this.J.setVisibility(8);
        } else {
            TianmuSDK.getInstance().getImageLoader().loadImage(this.r, this.o.getAdData().getAppIconUrl(), this.J);
            this.J.a(TianmuDisplayUtil.dp2px(10));
        }
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setMaterial() {
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo == null || interstitialAdInfo.getAdData() == null) {
            return;
        }
        if (this.o.isVideo()) {
            TianmuViewUtil.addAdViewToAdContainer(this.H, this.o.getMediaView(this.H));
            return;
        }
        ImageView imageView = new ImageView(this.H.getContext());
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TianmuSDK.getInstance().getImageLoader().loadImage(this.r, this.o.getAdData().getImageUrl(), imageView, this.s);
        this.H.addView(imageView);
    }
}
