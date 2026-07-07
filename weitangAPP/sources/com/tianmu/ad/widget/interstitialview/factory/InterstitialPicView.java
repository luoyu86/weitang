package com.tianmu.ad.widget.interstitialview.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.widget.interstitialview.InterstitialView;
import com.tianmu.biz.bean.InterstitialStyleBean;
import com.tianmu.c.f.c0;
import com.tianmu.utils.TianmuDisplayUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialPicView extends InterstitialBase {
    public InterstitialPicView(InterstitialView interstitialView, InterstitialAdInfo interstitialAdInfo) {
        super(interstitialView, interstitialAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a(TianmuDisplayUtil.dp2px(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME), "", new InterstitialStyleBean(), TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, true, false);
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
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(c0.f11286b, (ViewGroup) this.p, false);
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
        this.f10712h.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialPicView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewTreeObserver viewTreeObserver = InterstitialPicView.this.f10712h.getViewTreeObserver();
                if (!viewTreeObserver.isAlive()) {
                    return true;
                }
                viewTreeObserver.removeOnPreDrawListener(this);
                if (InterstitialPicView.this.isHalf()) {
                    ViewGroup.LayoutParams layoutParams = InterstitialPicView.this.f10712h.getLayoutParams();
                    int width = InterstitialPicView.this.f10712h.getWidth();
                    int i2 = (width * 16) / 9;
                    layoutParams.height = i2;
                    InterstitialPicView.this.f10712h.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = InterstitialPicView.this.f10711g.getLayoutParams();
                    layoutParams2.width = width;
                    InterstitialPicView.this.f10711g.setLayoutParams(layoutParams2);
                    InterstitialPicView interstitialPicView = InterstitialPicView.this;
                    interstitialPicView.A = width;
                    interstitialPicView.B = i2;
                    interstitialPicView.a(TianmuDisplayUtil.dp2px(50) + ((TianmuDisplayUtil.getScreenHeight() - i2) / 2), TianmuDisplayUtil.dp2px(27), -1);
                } else {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) InterstitialPicView.this.f10711g.getLayoutParams();
                    layoutParams3.width = -1;
                    layoutParams3.height = -1;
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = 0;
                    layoutParams3.leftMargin = 0;
                    layoutParams3.rightMargin = 0;
                    InterstitialPicView.this.f10711g.setLayoutParams(layoutParams3);
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) InterstitialPicView.this.f10713i.getLayoutParams();
                    layoutParams4.rightMargin = TianmuDisplayUtil.dp2px(20);
                    layoutParams4.bottomMargin = TianmuDisplayUtil.dp2px(20);
                    InterstitialPicView.this.f10713i.setLayoutParams(layoutParams4);
                    InterstitialPicView interstitialPicView2 = InterstitialPicView.this;
                    interstitialPicView2.A = interstitialPicView2.f10714q.getWidth();
                    InterstitialPicView interstitialPicView3 = InterstitialPicView.this;
                    interstitialPicView3.B = interstitialPicView3.f10714q.getHeight();
                    InterstitialPicView.this.a(TianmuDisplayUtil.dp2px(60), TianmuDisplayUtil.dp2px(20), -1);
                }
                InterstitialPicView.this.e();
                InterstitialPicView.this.a();
                InterstitialPicView interstitialPicView4 = InterstitialPicView.this;
                RelativeLayout relativeLayout = interstitialPicView4.f10711g;
                interstitialPicView4.b(relativeLayout, relativeLayout, interstitialPicView4.isHalf() ? 5 : 50, InterstitialPicView.this.isHalf() ? 5 : 30, InterstitialPicView.this.getClosePosition());
                InterstitialPicView interstitialPicView5 = InterstitialPicView.this;
                RelativeLayout relativeLayout2 = interstitialPicView5.f10711g;
                interstitialPicView5.a(relativeLayout2, relativeLayout2, interstitialPicView5.isHalf() ? 10 : 50, InterstitialPicView.this.isHalf() ? 10 : 30, InterstitialPicView.this.getClosePosition());
                InterstitialPicView interstitialPicView6 = InterstitialPicView.this;
                interstitialPicView6.addAppInfo(-1, interstitialPicView6.isHalf() ? InterstitialPicView.this.b() : TianmuDisplayUtil.dp2px(50) + InterstitialPicView.this.b());
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
