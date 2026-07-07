package com.tianmu.ad.widget.interstitialview.factory;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.adevent.AdEventType;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.widget.interstitialview.InterstitialView;
import com.tianmu.biz.bean.InterstitialStyleBean;
import com.tianmu.biz.widget.EnvelopeView;
import com.tianmu.biz.widget.c;
import com.tianmu.biz.widget.i;
import com.tianmu.biz.widget.roundimage.RoundImageView;
import com.tianmu.c.f.b0;
import com.tianmu.utils.TianmuDisplayUtil;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialEnvelopeView extends InterstitialBase {
    private RelativeLayout H;
    public FrameLayout I;
    public View J;
    private int K;
    public int L;
    public int M;
    private int N;
    public int O;
    public int P;
    public boolean Q;
    private c R;
    public int S;
    public int T;
    public int U;
    public int V;
    private ObjectAnimator W;
    private ObjectAnimator X;
    private ObjectAnimator Y;
    private ObjectAnimator Z;
    private int a0;
    private int b0;

    public InterstitialEnvelopeView(InterstitialView interstitialView, InterstitialAdInfo interstitialAdInfo) {
        super(interstitialView, interstitialAdInfo);
        this.K = 48;
        this.L = 10;
        this.M = 48;
        this.N = 60;
    }

    private void k() {
        int iF = (int) ((((double) this.f10706b) * f()) + ((double) TianmuDisplayUtil.dp2px(10)));
        this.a0 = iF;
        b(this.f10709e, this.f10711g, TianmuDisplayUtil.px2dp(iF), 16, getClosePosition());
    }

    private void l() {
        View viewFindViewById = this.f10714q.findViewById(b0.f11269i);
        EnvelopeView envelopeView = (EnvelopeView) this.f10714q.findViewById(b0.j);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        int i2 = this.f10707c;
        this.O = i2;
        int i3 = (i2 * AdEventType.VIDEO_PRELOADED) / 321;
        this.P = i3;
        layoutParams.width = i2;
        layoutParams.height = i3;
        viewFindViewById.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) envelopeView.getLayoutParams();
        int i4 = this.f10707c;
        layoutParams2.width = i4;
        layoutParams2.height = (i4 * 60) / 109;
        layoutParams2.topMargin = (int) ((((double) this.f10706b) * (e() + f())) - ((double) layoutParams2.height));
        envelopeView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout = this.I;
        if (frameLayout == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) View.Y, TianmuDisplayUtil.dp2px(this.K), 0.0f, TianmuDisplayUtil.dp2px(this.K));
        this.W = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.W.setRepeatCount(0);
        this.W.setDuration(600L);
        this.W.start();
        i iVar = this.m;
        if (iVar != null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(iVar, (Property<i, Float>) View.Y, this.a0, r9 - TianmuDisplayUtil.dp2px(this.K), this.a0);
            this.X = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
            this.X.setRepeatCount(0);
            this.X.setDuration(600L);
            this.X.start();
        }
        TextView textView = this.j;
        if (textView != null) {
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.Y, this.b0, r9 - TianmuDisplayUtil.dp2px(this.K), this.b0);
            this.Y = objectAnimatorOfFloat3;
            objectAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
            this.Y.setRepeatCount(0);
            this.Y.setDuration(600L);
            this.Y.start();
        }
        if (!this.Q || (relativeLayout = this.z) == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(relativeLayout, (Property<RelativeLayout, Float>) View.Y, relativeLayout.getY(), this.z.getY() - TianmuDisplayUtil.dp2px(this.K), this.z.getY());
        this.Z = objectAnimatorOfFloat4;
        objectAnimatorOfFloat4.setInterpolator(new LinearInterpolator());
        this.Z.setRepeatCount(0);
        this.Z.setDuration(600L);
        this.Z.start();
    }

    private void n() {
        ObjectAnimator objectAnimator = this.W;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.W = null;
        }
        ObjectAnimator objectAnimator2 = this.X;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.X = null;
        }
        ObjectAnimator objectAnimator3 = this.Y;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
            this.Y = null;
        }
        ObjectAnimator objectAnimator4 = this.Z;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
            this.Z = null;
        }
    }

    private void o() {
        if (this.j == null) {
            return;
        }
        this.b0 = (int) ((((double) this.f10706b) * f()) + ((double) TianmuDisplayUtil.dp2px(10)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.topMargin = this.b0;
        this.j.setLayoutParams(layoutParams);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void d() {
        this.R.c();
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo == null || interstitialAdInfo.getAdData() == null) {
            return;
        }
        this.R.a(this.o.getAdData().C());
    }

    public double e() {
        return this.u ? 0.8d : 0.75d;
    }

    public double f() {
        return this.u ? 0.08d : 0.13d;
    }

    public void g() {
        InterstitialStyleBean interstitialStyleBean;
        View view;
        int iS = this.o.getAdData().s();
        if (iS != 6) {
            interstitialStyleBean = new InterstitialStyleBean();
            interstitialStyleBean.setTipsSize(15);
            interstitialStyleBean.setTipsColor("#ff333333");
            interstitialStyleBean.setShade(false);
            interstitialStyleBean.setTipsMargin(0);
            interstitialStyleBean.setTipsStyle(Typeface.DEFAULT_BOLD);
        } else {
            interstitialStyleBean = null;
        }
        InterstitialStyleBean interstitialStyleBean2 = interstitialStyleBean;
        boolean z = this.u;
        int i2 = this.A;
        a(z ? (int) (((double) i2) * 0.6d) : i2 / 2, "#000000", interstitialStyleBean2, z ? 70 : 86, !z, false);
        if (iS == 6 || this.y == null || (view = this.J) == null) {
            return;
        }
        view.setVisibility(0);
        new Handler().postDelayed(new Runnable() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView.3
            @Override // java.lang.Runnable
            public void run() {
                View view2 = InterstitialEnvelopeView.this.J;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }, this.C);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public List<View> getClickViewList() {
        return null;
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

    public void h() {
        this.f10707c = this.f10705a - TianmuDisplayUtil.dp2px(this.M);
        this.f10708d = ((int) (((double) this.f10706b) * e())) + TianmuDisplayUtil.dp2px(this.K);
        ViewGroup.LayoutParams layoutParams = this.f10711g.getLayoutParams();
        layoutParams.width = this.f10707c;
        layoutParams.height = this.f10708d;
        this.f10711g.setLayoutParams(layoutParams);
    }

    public void i() {
        this.S = this.f10707c - TianmuDisplayUtil.dp2px(16);
        this.T = this.f10708d - TianmuDisplayUtil.dp2px(this.N);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
        layoutParams.width = this.S;
        layoutParams.height = this.T;
        layoutParams.bottomMargin = TianmuDisplayUtil.dp2px(this.N);
        this.H.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
        this.U = this.S;
        int iDp2px = this.T - TianmuDisplayUtil.dp2px(this.K);
        this.V = iDp2px;
        layoutParams2.width = this.U;
        layoutParams2.height = iDp2px;
        this.I.setLayoutParams(layoutParams2);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void initView() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(b0.f11261a, (ViewGroup) this.p, false);
        this.f10714q = viewGroup;
        this.f10709e = (RelativeLayout) viewGroup.findViewById(b0.f11262b);
        this.f10710f = (ViewGroup) this.f10714q.findViewById(b0.f11263c);
        this.f10711g = (RelativeLayout) this.f10714q.findViewById(b0.f11264d);
        this.H = (RelativeLayout) this.f10714q.findViewById(b0.f11265e);
        this.I = (FrameLayout) this.f10714q.findViewById(b0.f11266f);
        this.f10713i = (TextView) this.f10714q.findViewById(b0.f11267g);
        this.z = (RelativeLayout) this.f10714q.findViewById(b0.k);
        this.J = this.f10714q.findViewById(b0.l);
        a(this.f10709e, this.f10711g, 59, 19, getClosePosition());
        if (this.u) {
            this.f10705a = (this.f10706b * 9) / 16;
            this.K = 18;
            this.L = 10;
            this.M = 0;
            this.N = 40;
            this.f10714q.findViewById(b0.f11268h).setVisibility(8);
        }
    }

    public void j() {
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo == null) {
            return;
        }
        if (interstitialAdInfo.isVideo()) {
            View mediaView = this.o.getMediaView(this.I, new ViewGroup.LayoutParams(-1, -2), 6);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 16;
            this.I.setBackgroundResource(com.tianmu.c.f.c.f11284q);
            this.I.addView(mediaView, layoutParams);
            return;
        }
        RoundImageView roundImageView = new RoundImageView(this.r);
        roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundImageView.a(this.L);
        this.I.addView(roundImageView);
        roundImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        loadImage(roundImageView);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void release() {
        super.release();
        n();
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setConfigView() {
        if (!isHalf()) {
            this.f10709e.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        h();
        l();
        i();
        if (this.o.getAdData().s() == 6) {
            a(com.tianmu.c.f.c.w, "", this.u ? 14.0f : 17.0f);
        } else {
            a(-1, "", 17.0f);
        }
        this.A = this.f10707c;
        this.B = this.f10708d;
        g();
        if (!this.u) {
            a();
        }
        k();
        o();
        new Handler().postDelayed(new Runnable() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView.1
            @Override // java.lang.Runnable
            public void run() {
                InterstitialEnvelopeView.this.m();
            }
        }, 1000L);
        new Handler().postDelayed(new Runnable() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView.2
            @Override // java.lang.Runnable
            public void run() {
                InterstitialEnvelopeView interstitialEnvelopeView = InterstitialEnvelopeView.this;
                interstitialEnvelopeView.addAppInfo(interstitialEnvelopeView.u ? TianmuDisplayUtil.dp2px(160) : -1);
            }
        }, 100L);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setData() {
        super.setData();
        j();
    }

    public void a(int i2, String str, float f2) {
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo == null || interstitialAdInfo.getAdData() == null) {
            return;
        }
        int iDp2px = TianmuDisplayUtil.dp2px(320);
        if (this.u) {
            iDp2px = TianmuDisplayUtil.dp2px(200);
        }
        c cVar = new c(this.f10709e.getContext(), str + this.o.getAdData().C());
        this.R = cVar;
        cVar.a(iDp2px, -2);
        this.R.a(com.tianmu.c.f.c.v);
        this.R.a(f2);
        if (i2 > 0) {
            this.R.c(i2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDp2px, -2);
        layoutParams.addRule(8, this.f10711g.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = TianmuDisplayUtil.dp2px(20);
        layoutParams.leftMargin = TianmuDisplayUtil.dp2px(20);
        layoutParams.rightMargin = TianmuDisplayUtil.dp2px(20);
        this.f10709e.addView(this.R, layoutParams);
    }
}
