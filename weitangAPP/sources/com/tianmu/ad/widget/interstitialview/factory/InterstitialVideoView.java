package com.tianmu.ad.widget.interstitialview.factory;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Looper;
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
import com.tianmu.biz.widget.a;
import com.tianmu.biz.widget.i;
import com.tianmu.c.f.c;
import com.tianmu.c.f.e0;
import com.tianmu.c.f.s;
import com.tianmu.c.i.h;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuLogUtil;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialVideoView extends InterstitialBase implements a.InterfaceC0188a {
    private RelativeLayout H;
    private ImageView I;
    private TextView J;
    private a K;
    private h L;
    private Handler M;
    public boolean N;
    private boolean O;
    private TextView P;
    private ObjectAnimator Q;
    private boolean R;
    private int S;

    public InterstitialVideoView(InterstitialView interstitialView, InterstitialAdInfo interstitialAdInfo) {
        super(interstitialView, interstitialAdInfo);
        this.M = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a aVar = this.K;
        if (aVar == null || this.I == null) {
            return;
        }
        boolean zS = aVar.s();
        this.I.setImageResource(zS ? c.f11279e : c.f11280f);
        h hVar = this.L;
        if (hVar == null || hVar.W() == null) {
            return;
        }
        if (zS) {
            this.L.b0().d(this.L.W(), this.S);
        } else {
            this.L.b0().g(this.L.f0(), this.S);
        }
    }

    private void f() {
        try {
            ObjectAnimator objectAnimator = this.Q;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.Q = null;
            }
            TextView textView = this.P;
            if (textView != null) {
                textView.clearAnimation();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String g() {
        return this.o.getAdData() != null ? this.o.getAdData().b() : "查看详情";
    }

    private void h() {
        if (this.P != null) {
            try {
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.P, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, -10.0f), Keyframe.ofFloat(0.2f, 10.0f), Keyframe.ofFloat(0.3f, -10.0f), Keyframe.ofFloat(0.4f, 10.0f), Keyframe.ofFloat(0.5f, -10.0f), Keyframe.ofFloat(0.6f, 10.0f), Keyframe.ofFloat(0.7f, -10.0f), Keyframe.ofFloat(0.8f, 10.0f), Keyframe.ofFloat(0.9f, -10.0f), Keyframe.ofFloat(1.0f, 0.0f)));
                this.Q = objectAnimatorOfPropertyValuesHolder;
                objectAnimatorOfPropertyValuesHolder.setDuration(3000L);
                this.Q.setRepeatCount(-1);
                this.Q.start();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void i() {
        this.K.a(this);
        this.I.setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialVideoView.1
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                if (InterstitialVideoView.this.K != null) {
                    InterstitialVideoView.this.K.a(!InterstitialVideoView.this.K.s());
                    InterstitialVideoView.this.e();
                }
            }
        });
    }

    private void j() {
        a aVar = this.K;
        if (aVar != null) {
            aVar.F();
        }
    }

    private void k() {
        if (this.M != null) {
            b(false);
            this.M.postDelayed(new Runnable() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    InterstitialVideoView.this.a(false);
                }
            }, 10000L);
        }
    }

    private void l() {
        a aVar = this.K;
        if (aVar != null) {
            aVar.H();
        }
    }

    private void m() {
        if (this.K != null) {
            RelativeLayout.LayoutParams layoutParams = this.u ? new RelativeLayout.LayoutParams(-2, -1) : new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.K.setLayoutParams(layoutParams);
        }
    }

    private void n() {
        hideActionBarView();
        p();
        this.H.removeAllViews();
        i iVar = this.m;
        if (iVar != null) {
            iVar.setVisibility(0);
        }
        View viewInflate = ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(s.f11506a, (ViewGroup) null);
        this.P = (TextView) viewInflate.findViewById(s.f11507b);
        TextView textView = (TextView) viewInflate.findViewById(s.f11508c);
        TextView textView2 = (TextView) viewInflate.findViewById(s.f11509d);
        TextView textView3 = (TextView) viewInflate.findViewById(s.f11510e);
        textView.setText(this.o.getAdData().getTitle());
        textView2.setText(this.o.getAdData().getDesc());
        this.P.setText(g());
        this.H.addView(viewInflate, 0);
        textView3.setText(this.o.getAdData().e());
        h();
    }

    private void o() {
        a aVar = this.K;
        if (aVar != null) {
            aVar.I();
        }
    }

    private void p() {
        a aVar = this.K;
        if (aVar != null) {
            aVar.w();
            this.K = null;
        }
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public List<View> getClickViewList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10712h);
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
        LayoutInflater layoutInflater = (LayoutInflater) this.r.getSystemService("layout_inflater");
        if (this.u) {
            this.f10714q = (ViewGroup) layoutInflater.inflate(e0.f11344a, (ViewGroup) this.p, false);
        } else {
            this.f10714q = (ViewGroup) layoutInflater.inflate(e0.f11345b, (ViewGroup) this.p, false);
        }
        this.L = (h) this.o.getAdData();
        this.f10709e = (RelativeLayout) this.f10714q.findViewById(e0.f11346c);
        this.f10710f = (ViewGroup) this.f10714q.findViewById(e0.f11347d);
        this.f10711g = (RelativeLayout) this.f10714q.findViewById(e0.f11348e);
        this.J = (TextView) this.f10714q.findViewById(e0.f11349f);
        this.I = (ImageView) this.f10714q.findViewById(e0.f11350g);
        this.H = (RelativeLayout) this.f10714q.findViewById(e0.f11351h);
        this.f10713i = (TextView) this.f10714q.findViewById(e0.f11352i);
        this.z = (RelativeLayout) this.f10714q.findViewById(e0.j);
        h hVar = this.L;
        if (hVar != null) {
            hVar.Q();
            this.K = new a(this.r, this.L.getVideoUrl(), this.L.getImageUrl());
            m();
            this.H.addView(this.K, 0);
        }
        i();
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void onClick() {
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoCompletion(int i2) {
        TianmuLogUtil.iD("onVideoCompletion");
        a(true);
        InterstitialView interstitialView = this.p;
        if (interstitialView != null) {
            interstitialView.onVideoFinish(this.L);
        }
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoError() {
        TianmuLogUtil.iD("onVideoError");
        h hVar = this.L;
        if (hVar != null && hVar.Y() != null) {
            this.L.b0().c(this.L.Y());
        }
        InterstitialView interstitialView = this.p;
        if (interstitialView != null) {
            interstitialView.onVideoError(this.L);
        }
    }

    public boolean onVideoInfoChanged(int i2, int i3) {
        TianmuLogUtil.iD("onVideoInfoChanged");
        if (i2 == 3 || i2 == 700) {
            b(false);
            return true;
        }
        if (i2 != 701) {
            return false;
        }
        k();
        return true;
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoPause(int i2) {
        TianmuLogUtil.iD("onVideoPause");
        h hVar = this.L;
        if (hVar != null && hVar.X() != null) {
            this.L.b0().b(this.L.X());
        }
        InterstitialView interstitialView = this.p;
        if (interstitialView != null) {
            interstitialView.onVideoPause(this.L);
        }
        this.O = true;
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoPosition(int i2, int i3) {
        h hVar;
        this.S = i2;
        a(i2, i3);
        if (i2 <= 0 || i3 <= 0 || (hVar = this.L) == null || hVar.e0() == null) {
            return;
        }
        float f2 = i2 / i3;
        if (f2 >= 0.75f) {
            this.L.b0().f(this.L.e0(), i2);
        } else if (f2 >= 0.5f) {
            this.L.b0().c(this.L.U(), i2);
        } else if (f2 >= 0.25f) {
            this.L.b0().e(this.L.Z(), i2);
        }
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoPrepared(long j) {
        InterstitialAdInfo interstitialAdInfo;
        if (this.O) {
            this.K.a(this.S);
            this.O = false;
            onVideoResume(this.S);
        } else {
            TianmuLogUtil.iD("onVideoPrepared");
            a aVar = this.K;
            if (aVar != null && (interstitialAdInfo = this.o) != null) {
                aVar.a(interstitialAdInfo.isMute());
            }
        }
        b(false);
        a(0, (int) j);
        h hVar = this.L;
        if (hVar != null && hVar.m() != null) {
            this.L.b0().a(this.L);
        }
        InterstitialView interstitialView = this.p;
        if (interstitialView != null && !this.R) {
            this.R = true;
            interstitialView.onVideoStart(this.L);
        }
        h hVar2 = this.L;
        if (hVar2 == null || hVar2.d0() == null) {
            return;
        }
        this.L.b0().f(this.L.d0());
    }

    public void onVideoReplay() {
        TianmuLogUtil.iD("onVideoReplay");
    }

    public void onVideoResume(int i2) {
        h hVar = this.L;
        if (hVar != null && hVar.c0() != null) {
            this.L.b0().e(this.L.c0());
        }
        InterstitialView interstitialView = this.p;
        if (interstitialView != null) {
            interstitialView.onVideoStart(this.L);
        }
    }

    public void onVideoSizeChanged(int i2, int i3) {
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoStart() {
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void pause() {
        super.pause();
        j();
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void release() {
        super.release();
        p();
        f();
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void resume() {
        super.resume();
        l();
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setConfigView() {
        this.H.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialVideoView.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewTreeObserver viewTreeObserver = InterstitialVideoView.this.H.getViewTreeObserver();
                if (!viewTreeObserver.isAlive()) {
                    return true;
                }
                viewTreeObserver.removeOnPreDrawListener(this);
                if (InterstitialVideoView.this.isHalf()) {
                    ViewGroup.LayoutParams layoutParams = InterstitialVideoView.this.H.getLayoutParams();
                    InterstitialVideoView interstitialVideoView = InterstitialVideoView.this;
                    if (interstitialVideoView.u) {
                        int height = interstitialVideoView.H.getHeight() - TianmuDisplayUtil.dp2px(80);
                        int i2 = (height * 16) / 9;
                        InterstitialVideoView interstitialVideoView2 = InterstitialVideoView.this;
                        interstitialVideoView2.A = i2;
                        interstitialVideoView2.B = height;
                        layoutParams.width = i2;
                        interstitialVideoView2.H.setLayoutParams(layoutParams);
                        ViewGroup.LayoutParams layoutParams2 = InterstitialVideoView.this.f10711g.getLayoutParams();
                        layoutParams2.width = i2;
                        layoutParams2.height = height;
                        InterstitialVideoView.this.f10711g.setLayoutParams(layoutParams2);
                    } else {
                        int iDp2px = TianmuDisplayUtil.dp2px(25);
                        int width = InterstitialVideoView.this.H.getWidth() - (iDp2px * 2);
                        int i3 = (width * 16) / 9;
                        InterstitialVideoView interstitialVideoView3 = InterstitialVideoView.this;
                        interstitialVideoView3.A = width;
                        interstitialVideoView3.B = i3;
                        layoutParams.height = i3;
                        interstitialVideoView3.H.setLayoutParams(layoutParams);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) InterstitialVideoView.this.f10711g.getLayoutParams();
                        layoutParams3.width = width;
                        layoutParams3.leftMargin = iDp2px;
                        layoutParams3.rightMargin = iDp2px;
                        InterstitialVideoView.this.f10711g.setLayoutParams(layoutParams3);
                        InterstitialVideoView.this.a(TianmuDisplayUtil.dp2px(70) + ((TianmuDisplayUtil.getScreenHeight() - layoutParams.height) / 2), TianmuDisplayUtil.dp2px(30), -1);
                    }
                } else {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) InterstitialVideoView.this.f10711g.getLayoutParams();
                    int height2 = InterstitialVideoView.this.H.getHeight();
                    int width2 = InterstitialVideoView.this.H.getWidth();
                    InterstitialVideoView interstitialVideoView4 = InterstitialVideoView.this;
                    interstitialVideoView4.A = width2;
                    interstitialVideoView4.B = height2;
                    layoutParams4.width = width2;
                    layoutParams4.height = height2;
                    layoutParams4.topMargin = 0;
                    layoutParams4.bottomMargin = 0;
                    layoutParams4.leftMargin = 0;
                    layoutParams4.rightMargin = 0;
                    interstitialVideoView4.f10711g.setLayoutParams(layoutParams4);
                    InterstitialVideoView.this.a(TianmuDisplayUtil.dp2px(60), TianmuDisplayUtil.dp2px(20), -1);
                }
                InterstitialVideoView.this.a(TianmuDisplayUtil.dp2px(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME), "", new InterstitialStyleBean(), InterstitialVideoView.this.u ? 60 : TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, true, false);
                InterstitialVideoView interstitialVideoView5 = InterstitialVideoView.this;
                if (!interstitialVideoView5.u) {
                    interstitialVideoView5.a();
                }
                if (InterstitialVideoView.this.isHalf()) {
                    InterstitialVideoView interstitialVideoView6 = InterstitialVideoView.this;
                    RelativeLayout relativeLayout = interstitialVideoView6.f10711g;
                    interstitialVideoView6.b(relativeLayout, relativeLayout, 5, 5, interstitialVideoView6.getClosePosition());
                    InterstitialVideoView interstitialVideoView7 = InterstitialVideoView.this;
                    RelativeLayout relativeLayout2 = interstitialVideoView7.f10711g;
                    interstitialVideoView7.a(relativeLayout2, relativeLayout2, 10, 10, interstitialVideoView7.getClosePosition());
                    InterstitialVideoView interstitialVideoView8 = InterstitialVideoView.this;
                    interstitialVideoView8.addAppInfo(interstitialVideoView8.u ? TianmuDisplayUtil.dp2px(160) : -1, InterstitialVideoView.this.b());
                } else {
                    InterstitialVideoView interstitialVideoView9 = InterstitialVideoView.this;
                    RelativeLayout relativeLayout3 = interstitialVideoView9.f10711g;
                    interstitialVideoView9.b(relativeLayout3, relativeLayout3, 50, 30, interstitialVideoView9.getClosePosition());
                    InterstitialVideoView interstitialVideoView10 = InterstitialVideoView.this;
                    RelativeLayout relativeLayout4 = interstitialVideoView10.f10711g;
                    interstitialVideoView10.a(relativeLayout4, relativeLayout4, 50, 30, interstitialVideoView10.getClosePosition());
                    InterstitialVideoView interstitialVideoView11 = InterstitialVideoView.this;
                    int iDp2px2 = interstitialVideoView11.u ? TianmuDisplayUtil.dp2px(160) : -1;
                    InterstitialVideoView interstitialVideoView12 = InterstitialVideoView.this;
                    interstitialVideoView11.addAppInfo(iDp2px2, interstitialVideoView12.u ? interstitialVideoView12.b() : interstitialVideoView12.b() + TianmuDisplayUtil.dp2px(50));
                }
                return true;
            }
        });
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void setData() {
        o();
        e();
        k();
        this.f10713i.setText(this.o.getAdData().e());
    }

    private void b(boolean z) {
        Handler handler = this.M;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            if (z) {
                this.M = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4) {
        addActionBarAni(this.f10714q, i2, i3, i4, 1500L);
    }

    public synchronized void a(boolean z) {
        b(false);
        if (!this.N) {
            this.N = true;
            h hVar = this.L;
            if (hVar != null && hVar.T() != null && z) {
                this.L.b0().b(this.L.T(), this.S);
            }
            releaseInteractionView();
            p();
            n();
        }
    }

    private void a(int i2, int i3) {
        this.S = i2;
        a aVar = this.K;
        if (aVar == null || !aVar.G()) {
            return;
        }
        int i4 = (i3 - i2) / 1000;
        a(i4);
        if (i4 <= 0) {
            a(true);
        }
    }

    private void a(int i2) {
        TextView textView = this.J;
        if (textView != null) {
            textView.setText(i2 + OperatorName.CLOSE_AND_STROKE);
        }
    }
}
