package com.tianmu.ad.widget.interstitialview.factory;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.widget.interstitialview.InterstitialView;
import com.tianmu.biz.bean.InterstitialStyleBean;
import com.tianmu.biz.utils.b;
import com.tianmu.biz.utils.t0;
import com.tianmu.biz.widget.e;
import com.tianmu.biz.widget.i;
import com.tianmu.biz.widget.o.a;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.d;
import com.tianmu.c.l.c;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InterstitialBase {
    public int A;
    public int B;
    public int C = 4000;
    public boolean D = true;
    private int E;
    private int F;
    private a G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RelativeLayout f10709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f10710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f10711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f10712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f10713i;
    public TextView j;
    public TextView k;
    public TextView l;
    public i m;
    public ViewGroup n;
    public InterstitialAdInfo o;
    public InterstitialView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f10714q;
    public Context r;
    public com.tianmu.listener.a s;
    public int t;
    public boolean u;
    public com.tianmu.c.l.a v;
    private com.tianmu.c.l.a w;
    public c x;
    public e y;
    public RelativeLayout z;

    public InterstitialBase(InterstitialView interstitialView, InterstitialAdInfo interstitialAdInfo) {
        this.p = interstitialView;
        this.o = interstitialAdInfo;
        this.r = interstitialView.getContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tianmu.ad.widget.interstitialview.factory.InterstitialBase create(com.tianmu.ad.widget.interstitialview.InterstitialView r1, int r2, com.tianmu.ad.bean.InterstitialAdInfo r3, com.tianmu.listener.a r4, boolean r5, int r6) {
        /*
            r0 = 1
            if (r2 == r0) goto L32
            r0 = 2
            if (r2 == r0) goto L24
            r0 = 4
            if (r2 == r0) goto L1d
            r0 = 6
            if (r2 == r0) goto L17
            r0 = 7
            if (r2 == r0) goto L11
            r1 = 0
            goto L40
        L11:
            com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeTextView r2 = new com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeTextView
            r2.<init>(r1, r3)
            goto L22
        L17:
            com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView r2 = new com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView
            r2.<init>(r1, r3)
            goto L22
        L1d:
            com.tianmu.ad.widget.interstitialview.factory.InterstitialVideoView r2 = new com.tianmu.ad.widget.interstitialview.factory.InterstitialVideoView
            r2.<init>(r1, r3)
        L22:
            r1 = r2
            goto L40
        L24:
            if (r5 == 0) goto L2c
            com.tianmu.ad.widget.interstitialview.factory.LandscapeInterstitialTopPicView r2 = new com.tianmu.ad.widget.interstitialview.factory.LandscapeInterstitialTopPicView
            r2.<init>(r1, r3)
            goto L22
        L2c:
            com.tianmu.ad.widget.interstitialview.factory.InterstitialTopPicView r2 = new com.tianmu.ad.widget.interstitialview.factory.InterstitialTopPicView
            r2.<init>(r1, r3)
            goto L22
        L32:
            if (r5 == 0) goto L3a
            com.tianmu.ad.widget.interstitialview.factory.LandscapeInterstitialPicView r2 = new com.tianmu.ad.widget.interstitialview.factory.LandscapeInterstitialPicView
            r2.<init>(r1, r3)
            goto L22
        L3a:
            com.tianmu.ad.widget.interstitialview.factory.InterstitialPicView r2 = new com.tianmu.ad.widget.interstitialview.factory.InterstitialPicView
            r2.<init>(r1, r3)
            goto L22
        L40:
            if (r1 == 0) goto L4b
            r1.setIsLandscape(r5)
            r1.setADImageLoaderCallback(r4)
            r1.setCountdownRemainTime(r6)
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.ad.widget.interstitialview.factory.InterstitialBase.create(com.tianmu.ad.widget.interstitialview.InterstitialView, int, com.tianmu.ad.bean.InterstitialAdInfo, com.tianmu.listener.a, boolean, int):com.tianmu.ad.widget.interstitialview.factory.InterstitialBase");
    }

    private void e() {
        if (this.u) {
            return;
        }
        InterstitialAdInfo interstitialAdInfo = this.o;
        if ((interstitialAdInfo == null && interstitialAdInfo.getAdData() == null) || this.o.getAdData().p() == null || this.o.getAdData().p().size() == 0) {
            return;
        }
        a aVar = new a(this.r);
        this.G = aVar;
        aVar.a(this.o.getAdData().p());
        this.G.a(this.x);
        if (getFullScreenContainer() != null) {
            getFullScreenContainer().addView(this.G, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void addActionBarAni(ViewGroup viewGroup, int i2, int i3, int i4, long j) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup actionBarView = getActionBarView();
        this.n = actionBarView;
        actionBarView.setOnClickListener(this.v);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, -2);
        layoutParams.addRule(12, viewGroup.getId());
        layoutParams.addRule(14, viewGroup.getId());
        layoutParams.bottomMargin = i2;
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.n.setVisibility(8);
        viewGroup.addView(this.n, layoutParams);
        new Handler().postDelayed(new Runnable() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialBase.1
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup2 = InterstitialBase.this.n;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                    InterstitialBase.this.n.setAnimation(b.a());
                }
            }
        }, j);
    }

    public void addAppInfo(int i2) {
        addAppInfo(i2, true, b());
    }

    public void b(ViewGroup viewGroup, ViewGroup viewGroup2, int i2, int i3, int i4) {
        int i5;
        int iDp2px;
        if (viewGroup == null || viewGroup2 == null) {
            return;
        }
        int id = viewGroup.getId();
        int id2 = viewGroup2.getId();
        i iVar = new i(this.r);
        this.m = iVar;
        int i6 = this.E;
        if (i6 > 0) {
            iVar.a(i6);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, id);
        if (i4 == 1) {
            iDp2px = TianmuDisplayUtil.dp2px(i3);
            layoutParams.addRule(5, id2);
            i5 = 0;
        } else {
            int iDp2px2 = TianmuDisplayUtil.dp2px(i3);
            layoutParams.addRule(7, id2);
            i5 = iDp2px2;
            iDp2px = 0;
        }
        layoutParams.setMargins(iDp2px, TianmuDisplayUtil.dp2px(i2), i5, 0);
        if (getFullScreenContainer() != null) {
            getFullScreenContainer().addView(this.m, layoutParams);
        }
        this.m.a(new i.b() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialBase.2
            @Override // com.tianmu.biz.widget.i.b
            public void close() {
                if (InterstitialBase.this.w != null) {
                    InterstitialBase interstitialBase = InterstitialBase.this;
                    if (interstitialBase.m != null) {
                        interstitialBase.w.onClick(InterstitialBase.this.m);
                    }
                }
            }
        });
    }

    public boolean c() {
        InterstitialAdInfo interstitialAdInfo;
        return (this.u || (interstitialAdInfo = this.o) == null || !interstitialAdInfo.isShowActionBar()) ? false : true;
    }

    public void d() {
    }

    public ViewGroup getActionBarView() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(d.f11303a, (ViewGroup) this.p, false);
        TextView textView = (TextView) viewGroup.findViewById(d.f11304b);
        TextView textView2 = (TextView) viewGroup.findViewById(d.f11305c);
        TextView textView3 = (TextView) viewGroup.findViewById(d.f11306d);
        RoundedImageView roundedImageView = (RoundedImageView) viewGroup.findViewById(d.f11307e);
        roundedImageView.a(TianmuDisplayUtil.dp2px(10));
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo != null && interstitialAdInfo.getAdData() != null) {
            textView.setText(this.o.getAdData().getAppName());
            textView2.setText(this.o.getAdData().getDesc());
            if (TextUtils.isEmpty(this.o.getAdData().getAppIconUrl())) {
                roundedImageView.setVisibility(8);
            } else {
                TianmuSDK.getInstance().getImageLoader().loadImage(this.r, this.o.getAdData().getAppIconUrl(), roundedImageView);
                roundedImageView.setVisibility(0);
            }
            textView3.setText(this.o.getAdData().b());
        }
        return viewGroup;
    }

    public abstract List<View> getClickViewList();

    public int getClosePosition() {
        return this.F;
    }

    public abstract ViewGroup getExposureView();

    public abstract ViewGroup getFullScreenContainer();

    public RelativeLayout getInterstitialContainer() {
        return this.f10711g;
    }

    public i getInterstitialSkipView() {
        return this.m;
    }

    public abstract View getView();

    public void hideActionBarView() {
        ViewGroup viewGroup = this.n;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void init() {
        initView();
        setConfigView();
    }

    public abstract void initView();

    public boolean isHalf() {
        return this.t == 1;
    }

    public void loadImage(ImageView imageView) {
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo == null || interstitialAdInfo.getAdData() == null) {
            return;
        }
        loadImage(imageView, this.o.getAdData().getImageUrl());
    }

    public void onClick() {
    }

    public void pause() {
    }

    public void release() {
        releaseInteractionView();
        a aVar = this.G;
        if (aVar != null) {
            aVar.b();
            this.G = null;
        }
        this.n = null;
        this.v = null;
        this.s = null;
        i iVar = this.m;
        if (iVar != null) {
            iVar.a();
            this.m = null;
        }
    }

    public void releaseInteractionView() {
        e eVar = this.y;
        if (eVar != null) {
            if (eVar.l() != null) {
                TianmuViewUtil.removeSelfFromParent(this.y.l());
            }
            this.y.p();
            this.y = null;
        }
    }

    public void resume() {
    }

    public void setADImageLoaderCallback(com.tianmu.listener.a aVar) {
        this.s = aVar;
    }

    public void setCloseClickListener(com.tianmu.c.l.a aVar) {
        this.w = aVar;
    }

    public void setClosePosition(int i2) {
        this.F = i2;
    }

    public abstract void setConfigView();

    public void setCountDownText(int i2) {
        i iVar = this.m;
        if (iVar != null) {
            iVar.a(i2);
        }
    }

    public void setCountdownRemainTime(int i2) {
        this.E = i2;
    }

    public void setData() {
        setMaterial();
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo != null && this.l != null && interstitialAdInfo.getAdData() != null) {
            this.l.setText(this.o.getAdData().getTitle());
        }
        InterstitialAdInfo interstitialAdInfo2 = this.o;
        if (interstitialAdInfo2 != null && this.k != null && interstitialAdInfo2.getAdData() != null) {
            this.k.setText(this.o.getAdData().getDesc());
        }
        InterstitialAdInfo interstitialAdInfo3 = this.o;
        if (interstitialAdInfo3 == null || this.f10713i == null || interstitialAdInfo3.getAdData() == null) {
            return;
        }
        this.f10713i.setText(this.o.getAdData().e());
    }

    public void setInteractClickListener(c cVar) {
        this.x = cVar;
    }

    public void setIsLandscape(boolean z) {
        int i2;
        this.f10705a = this.r.getResources().getDisplayMetrics().widthPixels;
        int i3 = this.r.getResources().getDisplayMetrics().heightPixels;
        this.f10706b = i3;
        this.u = z;
        if (!z || i3 <= (i2 = this.f10705a)) {
            return;
        }
        this.f10705a = i3;
        this.f10706b = i2;
    }

    public void setMaterial() {
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo == null || this.f10712h == null || interstitialAdInfo.getAdData() == null) {
            return;
        }
        TianmuSDK.getInstance().getImageLoader().loadImage(this.f10712h.getContext(), this.o.getAdData().getImageUrl(), this.f10712h, this.s);
    }

    public void setShowType(int i2) {
        this.t = i2;
    }

    public void setSingleClickListener(com.tianmu.c.l.a aVar) {
        this.v = aVar;
    }

    public void setSize(int i2, int i3) {
    }

    public void a() {
        e();
    }

    public void addAppInfo(int i2, int i3) {
        addAppInfo(i2, true, i3);
    }

    public void a(int i2, String str, InterstitialStyleBean interstitialStyleBean, int i3, boolean z, final boolean z2) {
        InterstitialAdInfo interstitialAdInfo;
        if (this.z == null || (interstitialAdInfo = this.o) == null || interstitialAdInfo.getAdData() == null) {
            return;
        }
        final int iS = this.o.getAdData().s();
        e eVarA = new e.c(e.class).a((ViewGroup) this.z).a("interstitial").b(iS).c(this.o.getAdData().t()).d(this.A).a(this.B).a(this.x).c(this.o.getAdData().C()).f(z).c(c()).a(this.o.getAdData().B()).b(this.p.getAd().sensorDisable()).a(new com.tianmu.biz.widget.interaction.slideanimalview.b.a()).g(i2).b(str).e(i3).a(interstitialStyleBean).a();
        this.y = eVarA;
        eVarA.m();
        this.y.q();
        if (z2 && iS == 2) {
            this.z.setBackgroundColor(Color.parseColor("#32000000"));
        }
        if (this.D) {
            new Handler().postDelayed(new Runnable() { // from class: com.tianmu.ad.widget.interstitialview.factory.InterstitialBase.3
                @Override // java.lang.Runnable
                public void run() {
                    RelativeLayout relativeLayout;
                    if (z2 && (relativeLayout = InterstitialBase.this.z) != null && iS == 2) {
                        relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
                    }
                    InterstitialBase.this.releaseInteractionView();
                    InterstitialBase.this.d();
                }
            }, this.C);
        }
    }

    public void addAppInfo(int i2, boolean z, int i3) {
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo == null || interstitialAdInfo.getAdData() == null || !this.o.getAdData().I() || this.o.getAdData().f() == null || this.o.getAdData().f().l()) {
            return;
        }
        com.tianmu.biz.widget.b bVar = new com.tianmu.biz.widget.b(this.r);
        bVar.a(this.o.getAdData().f(), i2 <= 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, -2);
        if (z) {
            layoutParams.setMargins(TianmuDisplayUtil.dp2px(10), i3, TianmuDisplayUtil.dp2px(10), 0);
        }
        this.f10709e.addView(bVar, layoutParams);
    }

    public void loadImage(ImageView imageView, String str) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        TianmuSDK.getInstance().getImageLoader().loadImage(imageView.getContext(), str, imageView, this.s);
    }

    public int b() {
        try {
            return (int) t0.d(this.r);
        } catch (Exception unused) {
            return TianmuDisplayUtil.dp2px(24);
        }
    }

    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2, int i3, int i4) {
        if (viewGroup == null || viewGroup2 == null) {
            return;
        }
        int id = viewGroup.getId();
        int id2 = viewGroup2.getId();
        TextView textView = new TextView(this.r);
        this.j = textView;
        textView.setPadding(TianmuDisplayUtil.dp2px(5), TianmuDisplayUtil.dp2px(2), TianmuDisplayUtil.dp2px(5), TianmuDisplayUtil.dp2px(2));
        this.j.setTextSize(10.0f);
        this.j.setTextColor(Color.parseColor("#D9FFFFFF"));
        this.j.setBackgroundResource(com.tianmu.c.f.c.p);
        this.j.setVisibility(8);
        this.j.setText(c1.j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, id);
        layoutParams.topMargin = TianmuDisplayUtil.dp2px(i2);
        if (i4 == 1) {
            layoutParams.rightMargin = TianmuDisplayUtil.dp2px(i3);
            layoutParams.addRule(7, id2);
        } else {
            layoutParams.leftMargin = TianmuDisplayUtil.dp2px(i3);
            layoutParams.addRule(5, id2);
        }
        if (getFullScreenContainer() != null) {
            getFullScreenContainer().addView(this.j, layoutParams);
        }
        if (TextUtils.isEmpty(this.o.getAdData().c())) {
            return;
        }
        this.j.setText(this.o.getAdData().c());
        this.j.setVisibility(0);
    }
}
