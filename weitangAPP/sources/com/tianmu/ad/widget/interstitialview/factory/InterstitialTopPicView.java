package com.tianmu.ad.widget.interstitialview.factory;

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
import com.tianmu.c.f.c0;
import com.tianmu.c.f.d0;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialTopPicView extends InterstitialBase {
    public FrameLayout H;
    public TextView I;

    public InterstitialTopPicView(InterstitialView interstitialView, InterstitialAdInfo interstitialAdInfo) {
        super(interstitialView, interstitialAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a(this.A / 2, "", new InterstitialStyleBean(), 100, true, true);
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
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(d0.f11309b, (ViewGroup) this.p, false);
        this.f10714q = viewGroup;
        this.f10709e = (RelativeLayout) viewGroup.findViewById(d0.f11310c);
        this.f10710f = (ViewGroup) this.f10714q.findViewById(d0.f11311d);
        this.f10711g = (RelativeLayout) this.f10714q.findViewById(d0.f11312e);
        this.H = (FrameLayout) this.f10714q.findViewById(d0.f11313f);
        this.k = (TextView) this.f10714q.findViewById(d0.f11314g);
        this.l = (TextView) this.f10714q.findViewById(d0.f11315h);
        this.f10713i = (TextView) this.f10714q.findViewById(d0.j);
        this.I = (TextView) this.f10714q.findViewById(d0.k);
        this.z = (RelativeLayout) this.f10714q.findViewById(c0.f11292h);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setConfigView() {
        this.H.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialTopPicView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewTreeObserver viewTreeObserver = InterstitialTopPicView.this.H.getViewTreeObserver();
                if (!viewTreeObserver.isAlive()) {
                    return true;
                }
                viewTreeObserver.removeOnPreDrawListener(this);
                int width = InterstitialTopPicView.this.H.getWidth();
                ViewGroup.LayoutParams layoutParams = InterstitialTopPicView.this.H.getLayoutParams();
                layoutParams.height = (width * 9) / 16;
                InterstitialTopPicView.this.H.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = InterstitialTopPicView.this.f10711g.getLayoutParams();
                layoutParams2.width = width;
                InterstitialTopPicView.this.f10711g.setLayoutParams(layoutParams2);
                InterstitialTopPicView interstitialTopPicView = InterstitialTopPicView.this;
                interstitialTopPicView.A = width;
                interstitialTopPicView.B = interstitialTopPicView.f10711g.getHeight() + TianmuDisplayUtil.dp2px(20);
                InterstitialTopPicView interstitialTopPicView2 = InterstitialTopPicView.this;
                interstitialTopPicView2.addActionBarAni(interstitialTopPicView2.f10714q, TianmuDisplayUtil.dp2px(60), TianmuDisplayUtil.dp2px(20), -1, 800L);
                InterstitialTopPicView.this.e();
                InterstitialTopPicView interstitialTopPicView3 = InterstitialTopPicView.this;
                if (interstitialTopPicView3.f10709e != null && !interstitialTopPicView3.isHalf()) {
                    InterstitialTopPicView.this.f10709e.setBackgroundColor(-1);
                }
                InterstitialTopPicView.this.a();
                InterstitialTopPicView interstitialTopPicView4 = InterstitialTopPicView.this;
                ViewGroup viewGroup = interstitialTopPicView4.f10710f;
                interstitialTopPicView4.b(viewGroup, viewGroup, 5, 5, interstitialTopPicView4.getClosePosition());
                InterstitialTopPicView interstitialTopPicView5 = InterstitialTopPicView.this;
                ViewGroup viewGroup2 = interstitialTopPicView5.f10710f;
                interstitialTopPicView5.a(viewGroup2, viewGroup2, 10, 10, interstitialTopPicView5.getClosePosition());
                InterstitialTopPicView.this.addAppInfo(-1);
                return true;
            }
        });
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setData() {
        super.setData();
        if (this.o.getAdData() != null) {
            this.I.setText(this.o.getAdData().b());
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
