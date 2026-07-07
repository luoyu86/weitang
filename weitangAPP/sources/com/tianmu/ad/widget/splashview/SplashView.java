package com.tianmu.ad.widget.splashview;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.R;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.SplashAd;
import com.tianmu.ad.bean.SplashAdInfo;
import com.tianmu.ad.widget.splashview.base.SplashExposeView;
import com.tianmu.ad.widget.splashview.config.SplashConstant;
import com.tianmu.biz.bean.InterstitialStyleBean;
import com.tianmu.biz.utils.q0;
import com.tianmu.biz.widget.d;
import com.tianmu.biz.widget.e;
import com.tianmu.biz.widget.gravityrotation.GravityRotationView;
import com.tianmu.biz.widget.gravityrotation.a;
import com.tianmu.biz.widget.j;
import com.tianmu.biz.widget.k;
import com.tianmu.biz.widget.n.a;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.b;
import com.tianmu.c.f.g0;
import com.tianmu.c.f.v0;
import com.tianmu.c.l.c;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SplashView extends SplashExposeView {
    private a A;
    private GravityRotationView B;
    private GravityRotationView C;
    private com.tianmu.biz.widget.o.a D;
    private c E;
    private final com.tianmu.c.i.c p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final j f10779q;
    private boolean r;
    private boolean s;
    private int[] t;
    public com.tianmu.biz.widget.n.a u;
    public e v;
    private View w;
    private k x;
    private com.tianmu.biz.widget.c y;
    private int z;

    public SplashView(@NonNull SplashAd splashAd, @NonNull SplashAdInfo splashAdInfo, @NonNull com.tianmu.c.i.c cVar, @NonNull j jVar) {
        super(splashAd, splashAdInfo);
        this.r = false;
        this.t = new int[]{com.tianmu.c.f.c.k, com.tianmu.c.f.c.l, com.tianmu.c.f.c.m};
        this.E = new c() { // from class: com.tianmu.ad.widget.splashview.SplashView.6
            @Override // com.tianmu.c.l.c
            public void onClick(View view, int i2) {
                SplashView.this.a(i2);
            }
        };
        this.p = cVar;
        this.f10779q = jVar;
        preInit();
    }

    private void d() {
        com.tianmu.c.i.a aVarF;
        try {
            String strQ = q();
            com.tianmu.c.i.c cVar = this.p;
            if (cVar == null || !cVar.I() || (aVarF = this.p.f()) == null || aVarF.l()) {
                return;
            }
            SpannableStringBuilder spannableStringBuilderA = q0.a(getContext(), aVarF, false, new q0.c() { // from class: com.tianmu.ad.widget.splashview.SplashView.4
                @Override // com.tianmu.biz.utils.q0.c
                public void click() {
                    if (SplashView.this.f10779q != null) {
                        SplashView.this.f10779q.h();
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            TextView textView = new TextView(getContext());
            textView.setTextSize(12.0f);
            textView.setTextColor(-855638017);
            textView.setPadding(TianmuDisplayUtil.dp2px(15), TianmuDisplayUtil.dp2px(5), TianmuDisplayUtil.dp2px(67), TianmuDisplayUtil.dp2px(15));
            textView.setLayoutParams(layoutParams);
            if (!"0002".equals(strQ)) {
                textView.setBackgroundResource(b.f11260a);
            }
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableStringBuilderA);
            addView(textView);
        } catch (Exception unused) {
        }
    }

    private void e() {
        com.tianmu.c.i.c cVar;
        if (getAd() == null || (cVar = this.p) == null) {
            a(false);
            return;
        }
        int iS = cVar.s();
        int iT = this.p.t();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        e eVarA = new e.c(d.class).a((ViewGroup) relativeLayout).a("splash").b(iS).c(iT).d(-2).a(-2).g(TianmuDisplayUtil.getScreenWidth() / 3).a(this.E).c(this.p.C()).a(this.p.B()).b(((SplashAd) getAd()).sensorDisable()).e(100).e(true).a(new InterstitialStyleBean()).d(true).a(true).a();
        this.v = eVarA;
        ((d) eVarA).a(new d.b() { // from class: com.tianmu.ad.widget.splashview.SplashView.2
            @Override // com.tianmu.biz.widget.d.b
            public void onAction(boolean z) {
                SplashView.this.a(z);
            }

            @Override // com.tianmu.biz.widget.d.b
            public void onAddArcViewTips() {
                SplashView.this.f();
            }
        });
        this.v.m();
        this.v.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TextView textView = new TextView(getContext());
        textView.setText("点击前往三方应用或查看详情页");
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = TianmuDisplayUtil.dp2px(56);
        textView.setLayoutParams(layoutParams);
        addView(textView);
    }

    private void g() {
        a(o(), -1);
    }

    private void h() {
        com.tianmu.c.i.c cVar = this.p;
        if (cVar == null || cVar.p() == null || this.p.p().size() == 0) {
            return;
        }
        com.tianmu.biz.widget.o.a aVar = new com.tianmu.biz.widget.o.a(getContext());
        this.D = aVar;
        aVar.a(this.p.p());
        this.D.a(new c() { // from class: com.tianmu.ad.widget.splashview.SplashView.3
            @Override // com.tianmu.c.l.c
            public void onClick(View view, int i2) {
                SplashView.this.a(999);
            }
        });
        addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void i() {
        if (v()) {
            return;
        }
        com.tianmu.biz.widget.c cVar = this.y;
        if (cVar != null && this.B == null) {
            this.B = cVar.b();
        }
        if (this.A == null) {
            this.A = new a(getContext());
        }
        GravityRotationView gravityRotationView = this.B;
        if (gravityRotationView == null || this.C == null) {
            return;
        }
        gravityRotationView.a(Boolean.FALSE);
        this.C.a(Boolean.TRUE);
        this.A.a();
        this.A.a(this.B, this.C);
    }

    private void j() {
        com.tianmu.c.i.c cVar;
        boolean z;
        if (getAd() == null || (cVar = this.p) == null) {
            g();
            return;
        }
        int iS = cVar.s();
        int iT = this.p.t();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        if (iS == 6) {
            if (((SplashAd) getAd()).sensorDisable()) {
                g();
            } else {
                a("摇一摇或" + o(), R.drawable.tianmu_shake_phone);
            }
            z = false;
        } else {
            g();
            z = true;
        }
        e eVarA = new e.c(e.class).a((ViewGroup) relativeLayout).a("splash").b(iS).c(iT).d(-2).a(-2).g(TianmuDisplayUtil.getScreenWidth() / 3).a(this.E).c(this.p.C()).a(this.p.B()).b(((SplashAd) getAd()).sensorDisable()).e(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME).a(new InterstitialStyleBean()).d(z).a(true).a();
        this.v = eVarA;
        eVarA.m();
        this.v.q();
    }

    private void k() {
        if (this.p == null) {
            return;
        }
        this.w = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(g0.f11374a, (ViewGroup) this, false);
        int iDp2px = getContext().getResources().getDisplayMetrics().widthPixels - TianmuDisplayUtil.dp2px(76);
        RoundedImageView roundedImageView = (RoundedImageView) this.w.findViewById(g0.f11375b);
        TextView textView = (TextView) this.w.findViewById(g0.f11376c);
        TianmuSDK.getInstance().getImageLoader().loadImage(getContext(), this.p.getImageUrl(), roundedImageView, this.imageLoaderCallback);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) roundedImageView.getLayoutParams();
        layoutParams.width = iDp2px;
        layoutParams.height = (iDp2px * 9) / 16;
        roundedImageView.setLayoutParams(layoutParams);
        roundedImageView.a(TianmuDisplayUtil.dp2px(8));
        textView.setText(TextUtils.isEmpty(this.p.getDesc()) ? this.p.getTitle() : this.p.getDesc());
        setBackgroundResource(this.t[(int) ((Math.random() * ((double) 3)) + ((double) 0))]);
        addView(this.w);
    }

    private void l() {
        com.tianmu.c.i.c cVar = this.p;
        if (cVar != null && !TextUtils.isEmpty(cVar.e())) {
            TianmuViewUtil.addDefaultAdTargetViewToBottomRight(this.p.e(), this, 20);
        }
        com.tianmu.c.i.c cVar2 = this.p;
        if (cVar2 == null || TextUtils.isEmpty(cVar2.c())) {
            return;
        }
        TianmuViewUtil.addDefaultAdTargetViewToTop(this.p.c(), this, 20, this.z);
    }

    private void m() {
        if (this.x == null) {
            this.x = new k(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.x.setLayoutParams(layoutParams);
            addView(this.x);
            this.x.a(TianmuDisplayUtil.dp2px(36));
            this.x.c();
            a((View) this.x, true);
        }
    }

    private void n() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(v0.f11525a, (ViewGroup) this, false);
        this.w = viewInflate;
        TianmuSDK.getInstance().getImageLoader().loadImage(getContext(), this.p.getImageUrl(), (ImageView) viewInflate.findViewById(v0.f11526b), this.imageLoaderCallback);
        addView(SplashConstant.StyleId.TYPE_GRAVITY.equals(q()) ? p() : this.w);
    }

    private String o() {
        com.tianmu.c.i.c cVar = this.p;
        if (cVar != null) {
            return cVar.C();
        }
        return null;
    }

    private View p() {
        if (this.C == null) {
            this.C = new GravityRotationView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(-TianmuDisplayUtil.dp2px(15), -TianmuDisplayUtil.dp2px(6), -TianmuDisplayUtil.dp2px(15), -TianmuDisplayUtil.dp2px(6));
            this.C.setLayoutParams(layoutParams);
            this.C.addView(this.w);
        }
        return this.C;
    }

    private String q() {
        try {
            return this.p.d().a();
        } catch (Exception unused) {
            return "0001";
        }
    }

    private void r() {
        com.tianmu.c.i.c cVar = this.p;
        if (cVar == null || 4 != cVar.w()) {
            n();
        } else {
            k();
        }
    }

    private void s() {
        r();
        t();
        l();
        d();
    }

    private void t() {
        w();
        String strQ = q();
        strQ.hashCode();
        switch (strQ) {
            case "0001":
                j();
                break;
            case "0002":
                m();
                e();
                break;
            case "0003":
                j();
                i();
                break;
        }
    }

    private void u() {
        if (this.p != null) {
            TianmuSDK.getInstance().getImageLoader().preloadImage(getContext(), this.p.getImageUrl(), new ImageView(getContext()));
        }
    }

    private boolean v() {
        if (getAd() == null) {
            return false;
        }
        return getAd().sensorDisable();
    }

    private void w() {
        setOnClickListener(null);
    }

    public void c() {
        h();
    }

    public void init() {
        s();
    }

    @Override // com.tianmu.ad.widget.splashview.base.SplashExposeView
    public void onExposureError(int i2, String str) {
        j jVar = this.f10779q;
        if (jVar != null) {
            jVar.a(i2, str);
        }
    }

    public void preInit() {
        u();
    }

    @Override // com.tianmu.ad.widget.splashview.base.SplashExposeView, com.tianmu.ad.base.BaseView
    public void release() {
        super.release();
        this.E = null;
        a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            this.A = null;
        }
        com.tianmu.biz.widget.o.a aVar2 = this.D;
        if (aVar2 != null) {
            aVar2.b();
            this.D = null;
        }
        k kVar = this.x;
        if (kVar != null) {
            kVar.b();
            this.x = null;
        }
        com.tianmu.biz.widget.n.a aVar3 = this.u;
        if (aVar3 != null) {
            aVar3.b();
            this.u = null;
        }
        e eVar = this.v;
        if (eVar != null) {
            eVar.p();
            this.v = null;
        }
        com.tianmu.biz.widget.c cVar = this.y;
        if (cVar != null) {
            cVar.d();
            this.y = null;
        }
        TianmuViewUtil.removeSelfFromParent(this);
        removeAllViews();
    }

    @Override // com.tianmu.ad.widget.splashview.base.SplashExposeView
    public void render() {
        super.render();
        c();
    }

    public void setClosePosition(int i2) {
        this.z = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(boolean z) {
        k kVar = this.x;
        if (kVar != null) {
            kVar.a(0);
            this.x.a(this, z);
            k kVar2 = this.x;
            kVar2.a(kVar2, true);
            this.x.a(new a.InterfaceC0198a() { // from class: com.tianmu.ad.widget.splashview.SplashView.1
                @Override // com.tianmu.biz.widget.n.a.InterfaceC0198a
                public void onClick(ViewGroup viewGroup, int i2) {
                    SplashView.this.a(i2);
                }
            });
        }
    }

    private void a(String str, int i2) {
        com.tianmu.biz.widget.c cVar = new com.tianmu.biz.widget.c(getContext(), str);
        this.y = cVar;
        cVar.c(i2);
        if (this.r) {
            this.y.e();
        }
        this.y.b(200);
        addView(this.y, TianmuViewUtil.getSplashHotAreaViewLayoutParams());
        a(this.y.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (this.s) {
            return;
        }
        this.s = true;
        if (getAdInfo() != null && this.p != null && getAdInfo().getAdInfoStatus(this.p.u()) != null) {
            getAdInfo().getAdInfoStatus(this.p.u()).a(true);
        }
        onAdExpose();
        if (getAd() != null) {
            getAd().onAdClick(this, getAdInfo(), i2);
        }
        j jVar = this.f10779q;
        if (jVar != null) {
            jVar.cancelTask();
            this.f10779q.cancelCountDown();
            this.f10779q.setNeedToMain();
        }
    }

    private void a(View view, boolean z) {
        if (z) {
            view.setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.widget.splashview.SplashView.5
                @Override // com.tianmu.c.l.a
                public void onSingleClick(View view2) {
                    SplashView.this.a(0);
                }
            });
        }
    }
}
