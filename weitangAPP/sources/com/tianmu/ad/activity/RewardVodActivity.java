package com.tianmu.ad.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.RewardAd;
import com.tianmu.ad.bean.RewardAdInfo;
import com.tianmu.biz.utils.q0;
import com.tianmu.biz.utils.t0;
import com.tianmu.biz.widget.a;
import com.tianmu.biz.widget.e;
import com.tianmu.biz.widget.h;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.l0;
import com.tianmu.c.i.c;
import com.tianmu.c.i.f;
import com.tianmu.c.j.b;
import com.tianmu.c.n.l;
import com.tianmu.config.TianmuImageLoader;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class RewardVodActivity extends FragmentActivity implements a.InterfaceC0188a, b {
    private static long Q = 30000;
    private boolean A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private f H;
    private RewardAd I;
    private RewardAdInfo J;
    private c K;
    public e L;
    private ObjectAnimator M;
    private com.tianmu.c.j.a N;
    private com.tianmu.biz.widget.o.a P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RelativeLayout f10584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RelativeLayout f10585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f10586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f10587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageView f10588i;
    private View j;
    private com.tianmu.biz.widget.l.b k;
    private h l;
    private RelativeLayout m;
    private FrameLayout n;
    private boolean o;
    private boolean p;
    private CountDownTimer r;
    public boolean s;
    public boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private long x;
    private boolean y;
    private boolean z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Handler f10589q = new Handler(Looper.getMainLooper());
    private com.tianmu.c.l.c O = new com.tianmu.c.l.c() { // from class: com.tianmu.ad.activity.RewardVodActivity.12
        @Override // com.tianmu.c.l.c
        public void onClick(View view, int i2) {
            if (RewardVodActivity.this.J == null || RewardVodActivity.this.I == null) {
                return;
            }
            RewardVodActivity.this.I.onAdClick(view, RewardVodActivity.this.J, i2);
        }
    };

    private void A() {
        m();
        l();
        String imageUrl = this.K.getImageUrl();
        String appIconUrl = this.K.getAppIconUrl();
        String title = this.K.getTitle();
        String desc = this.K.getDesc();
        String strN = n();
        f fVar = this.H;
        com.tianmu.biz.widget.l.b bVar = new com.tianmu.biz.widget.l.b(this, imageUrl, appIconUrl, title, desc, strN, fVar == null ? null : fVar.k0(), this.K.c(), this.H.f(), new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.RewardVodActivity.3
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                if (RewardVodActivity.this.H != null && RewardVodActivity.this.H.i0() != null) {
                    RewardVodActivity.this.H.i0().a(RewardVodActivity.this.H.S(), RewardVodActivity.this.w);
                }
                if (RewardVodActivity.this.J != null && !RewardVodActivity.this.p) {
                    RewardVodActivity.this.p = true;
                    RewardVodActivity.this.J.onAdClose();
                }
                RewardVodActivity.this.m();
                RewardVodActivity.this.finish();
            }
        }, new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.RewardVodActivity.4
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                RewardVodActivity.this.c(view);
            }
        }, new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.RewardVodActivity.5
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                RewardVodActivity.this.b(view);
            }
        });
        this.k = bVar;
        bVar.setCanceledOnTouchOutside(false);
        this.k.setCancelable(false);
        this.k.show();
        f fVar2 = this.H;
        if (fVar2 != null) {
            fVar2.readyTouch(this.k.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        e eVar = this.L;
        if (eVar == null || eVar.l() == null) {
            return;
        }
        ImageView imageView = (ImageView) findViewById(l0.s);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (imageView.getLeft() - this.L.l().getLeft()) - ((this.L.l().getWidth() - imageView.getWidth()) / 2), 0, 0.0f, 0, (imageView.getTop() - this.L.l().getTop()) - ((this.L.l().getHeight() - imageView.getHeight()) / 2));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(1000L);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tianmu.ad.activity.RewardVodActivity.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RewardVodActivity.this.C();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.L.l().startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        TranslateAnimation translateAnimation;
        if (this.H == null) {
            return;
        }
        e eVar = this.L;
        if (eVar != null) {
            eVar.r();
        }
        ImageView imageView = (ImageView) findViewById(l0.s);
        AnimationSet animationSet = new AnimationSet(true);
        imageView.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(2000L);
        animationSet.addAnimation(alphaAnimation);
        if (this.H.s() == 2 || this.H.s() == 6) {
            int iDp2px = TianmuDisplayUtil.dp2px(8);
            imageView.setPadding(iDp2px, iDp2px, iDp2px, iDp2px);
            if (this.H.t() == 21) {
                imageView.setImageResource(com.tianmu.c.f.c.s);
                translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 15.0f, 0, -15.0f);
            } else {
                imageView.setImageResource(com.tianmu.c.f.c.t);
                translateAnimation = new TranslateAnimation(0, -15.0f, 0, 15.0f, 0, 0.0f, 0, 0.0f);
            }
            translateAnimation.setRepeatMode(2);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            translateAnimation.setDuration(1000L);
            translateAnimation.setRepeatCount(-1);
            animationSet.addAnimation(translateAnimation);
        } else if (this.H.s() == 1) {
            int iDp2px2 = TianmuDisplayUtil.dp2px(8);
            imageView.setPadding(iDp2px2, iDp2px2, iDp2px2, iDp2px2);
            imageView.setImageResource(com.tianmu.c.f.c.u);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.ROTATION, 12.0f, -12.0f, 12.0f);
            this.M = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            this.M.setRepeatCount(-1);
            this.M.setDuration(400L);
            this.M.start();
        } else if (this.H.s() == 5) {
            int iDp2px3 = TianmuDisplayUtil.dp2px(8);
            imageView.setPadding(iDp2px3, iDp2px3, iDp2px3, iDp2px3);
            imageView.setImageResource(com.tianmu.c.f.c.u);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.ROTATION, 12.0f, -12.0f, 12.0f);
            this.M = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
            this.M.setRepeatCount(-1);
            this.M.setDuration(400L);
            this.M.start();
        }
        imageView.startAnimation(animationSet);
    }

    private void D() {
        a aVar = this.f10586g;
        if (aVar != null) {
            aVar.w();
        }
    }

    private void p() {
        Intent intent = getIntent();
        this.f10580a = intent.getStringExtra("AD_KEY");
        this.f10581b = intent.getStringExtra("VIDEO_URL");
        this.f10583d = intent.getBooleanExtra("IS_MUTE", false);
        this.v = intent.getBooleanExtra("IS_SHOW_RETAIN_HINT", true);
        this.I = l.a().a(this.f10580a);
        RewardAdInfo rewardAdInfoB = l.a().b(this.f10580a);
        this.J = rewardAdInfoB;
        if (rewardAdInfoB.getAdData() != null) {
            this.K = this.J.getAdData();
        }
        RewardAdInfo rewardAdInfo = this.J;
        if (rewardAdInfo == null || !(rewardAdInfo.getAdmNativeRewardAd() instanceof f)) {
            return;
        }
        f fVar = (f) this.J.getAdmNativeRewardAd();
        this.H = fVar;
        long jR = fVar.R();
        if (jR > 0) {
            Q = Math.min(jR * 1000, 30000L);
        }
    }

    private void q() {
        this.f10588i.setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.RewardVodActivity.1
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                if (RewardVodActivity.this.f10583d) {
                    RewardVodActivity.this.f10583d = false;
                } else {
                    RewardVodActivity.this.f10583d = true;
                }
                if (RewardVodActivity.this.f10586g != null) {
                    RewardVodActivity.this.f10586g.a(RewardVodActivity.this.f10583d);
                    RewardVodActivity.this.h();
                }
            }
        });
        this.f10584e.setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.RewardVodActivity.2
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                RewardVodActivity.this.c(view);
            }
        });
        f fVar = this.H;
        if (fVar != null) {
            fVar.readyTouch(this.f10584e);
        }
    }

    private void r() {
        this.E = getResources().getDisplayMetrics().widthPixels;
        int iA = t0.a((Context) this);
        this.F = iA;
        int i2 = this.E;
        this.B = i2;
        int i3 = (i2 * 16) / 9;
        this.C = i3;
        if (i3 > iA) {
            this.C = iA;
        }
        int i4 = iA - this.C;
        this.D = i4;
        if (i4 < TianmuDisplayUtil.dp2px(100)) {
            this.D = TianmuDisplayUtil.dp2px(200);
        } else if (this.D < TianmuDisplayUtil.dp2px(200)) {
            this.D = TianmuDisplayUtil.dp2px(230);
        }
        this.G = this.E;
    }

    private void s() {
        u();
        a aVar = this.f10586g;
        if (aVar != null) {
            aVar.F();
        }
    }

    public static void start(Context context, String str, String str2, int i2, boolean z, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) FullScreenVodActivity.class);
        intent.putExtra("AD_KEY", str);
        intent.putExtra("VIDEO_URL", str2);
        intent.putExtra("SKIP_TIME", i2);
        intent.putExtra("IS_MUTE", z);
        intent.putExtra("IS_SHOW_RETAIN_HINT", z2);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void t() {
        if (this.f10589q != null) {
            b(false);
            this.f10589q.postDelayed(new Runnable() { // from class: com.tianmu.ad.activity.RewardVodActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    RewardVodActivity.this.a(false);
                }
            }, 20000L);
        }
    }

    private void u() {
        cancelRewardCountDown();
    }

    private void v() {
        a(this.x);
    }

    private void w() {
        v();
        a aVar = this.f10586g;
        if (aVar != null) {
            aVar.H();
        }
    }

    private void x() {
        RewardAdInfo rewardAdInfo = this.J;
        if (rewardAdInfo == null || this.u || this.z) {
            return;
        }
        this.u = true;
        rewardAdInfo.onAdReward();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void y() {
        /*
            r6 = this;
            int r0 = com.tianmu.c.f.l0.j
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = com.tianmu.c.f.l0.r
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            com.tianmu.c.i.c r2 = r6.K
            r3 = 2
            if (r2 == 0) goto L3e
            int r2 = r2.s()
            r4 = 1
            if (r2 == r4) goto L3b
            if (r2 == r3) goto L2b
            r4 = 5
            if (r2 == r4) goto L28
            r4 = 6
            if (r2 == r4) goto L25
            goto L3e
        L25:
            java.lang.String r2 = "滑动或"
            goto L40
        L28:
            java.lang.String r2 = "扭动手机或"
            goto L40
        L2b:
            com.tianmu.c.i.c r2 = r6.K
            int r2 = r2.t()
            r4 = 21
            if (r2 != r4) goto L38
            java.lang.String r2 = "向上滑动或"
            goto L40
        L38:
            java.lang.String r2 = "向右滑动或"
            goto L40
        L3b:
            java.lang.String r2 = "摇动手机或"
            goto L40
        L3e:
            java.lang.String r2 = ""
        L40:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = r6.n()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r1.setText(r2)
            android.view.animation.AlphaAnimation r1 = new android.view.animation.AlphaAnimation
            r2 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r1.<init>(r2, r4)
            r4 = 1000(0x3e8, double:4.94E-321)
            r1.setDuration(r4)
            r2 = -1
            r1.setRepeatCount(r2)
            r1.setRepeatMode(r3)
            r0.startAnimation(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.ad.activity.RewardVodActivity.y():void");
    }

    private void z() {
        if (this.f10586g != null) {
            RelativeLayout.LayoutParams layoutParams = d() ? new RelativeLayout.LayoutParams(-2, -1) : new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.f10586g.setLayoutParams(layoutParams);
        }
    }

    public void cancelRewardCountDown() {
        CountDownTimer countDownTimer = this.r;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.r = null;
        }
    }

    public boolean d() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        setContentView(l0.f11426a);
        r();
        p();
        c();
        q();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m();
        l();
        this.O = null;
        h hVar = this.l;
        if (hVar != null) {
            TianmuViewUtil.removeSelfFromParent(hVar);
            this.l = null;
        }
        b(true);
        releaseExposeChecker();
        RelativeLayout relativeLayout = this.f10584e;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        a aVar = this.f10586g;
        if (aVar != null) {
            aVar.w();
            this.f10586g = null;
        }
        cancelRewardCountDown();
        e eVar = this.L;
        if (eVar != null) {
            eVar.p();
            this.L = null;
        }
        l.a().c(this.f10580a);
        ObjectAnimator objectAnimator = this.M;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.M = null;
        }
        com.tianmu.biz.widget.o.a aVar2 = this.P;
        if (aVar2 != null) {
            aVar2.b();
            this.P = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        s();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.y) {
            w();
        }
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoCompletion(int i2) {
        a(true);
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoError() {
        f fVar = this.H;
        if (fVar != null && fVar.i0() != null) {
            this.H.i0().c(this.H.Y());
        }
        RewardAdInfo rewardAdInfo = this.J;
        if (rewardAdInfo != null) {
            rewardAdInfo.onVideoError();
        }
        b(true);
        finish();
    }

    public boolean onVideoInfoChanged(int i2, int i3) {
        if (i2 == 3 || i2 == 700) {
            a(8);
            b(false);
            return true;
        }
        if (i2 != 701) {
            return false;
        }
        a(0);
        t();
        return true;
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoPause(int i2) {
        f fVar = this.H;
        if (fVar == null || fVar.i0() == null) {
            return;
        }
        this.H.i0().b(this.H.X());
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoPosition(int i2, int i3) {
        f fVar;
        if (getWindow().getDecorView().getVisibility() == 8) {
            s();
        }
        this.w = i2;
        a(i2, i3);
        if (i2 <= 0 || i3 <= 0 || (fVar = this.H) == null || fVar.i0() == null) {
            return;
        }
        float f2 = i2 / i3;
        if (f2 >= 0.75f) {
            this.H.i0().f(this.H.e0(), i2);
        } else if (f2 >= 0.5f) {
            this.H.i0().c(this.H.U(), i2);
        } else if (f2 >= 0.25f) {
            this.H.i0().e(this.H.Z(), i2);
        }
    }

    public void onVideoPrepared(long j) {
        b(false);
        if (!this.A) {
            a(Math.min(Q, j));
        }
        a(8);
        a(0, (int) j);
        a aVar = this.f10586g;
        if (aVar != null) {
            aVar.a(this.f10583d);
        }
        this.y = true;
    }

    public void onVideoReplay() {
        f fVar = this.H;
        if (fVar == null || fVar.i0() == null) {
            return;
        }
        this.H.i0().d(this.H.a0());
    }

    public void onVideoResume(int i2) {
        i();
        f fVar = this.H;
        if (fVar == null || fVar.i0() == null) {
            return;
        }
        this.H.i0().e(this.H.c0());
    }

    public void onVideoSizeChanged(int i2, int i3) {
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoStart() {
        i();
        f fVar = this.H;
        if (fVar == null || fVar.i0() == null) {
            return;
        }
        this.H.i0().f(this.H.d0());
    }

    @Override // com.tianmu.c.j.b
    public void onViewExpose() {
        f fVar;
        if (this.o) {
            return;
        }
        this.o = true;
        if (this.f10584e != null && (fVar = this.H) != null && fVar.i0() != null) {
            this.H.i0().a(this.H);
        }
        RewardAdInfo rewardAdInfo = this.J;
        if (rewardAdInfo != null) {
            rewardAdInfo.onAdExposure();
        }
    }

    public void releaseExposeChecker() {
        com.tianmu.c.j.a aVar = this.N;
        if (aVar != null) {
            aVar.c();
            this.N = null;
        }
    }

    public void startExposeChecker() {
        a aVar;
        com.tianmu.c.j.a aVar2 = this.N;
        if (aVar2 == null || (aVar = this.f10586g) == null) {
            return;
        }
        aVar2.a(aVar);
    }

    private void g() {
        c cVar = this.K;
        if (cVar == null || cVar.p() == null || this.K.p().size() == 0) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(l0.t);
        com.tianmu.biz.widget.o.a aVar = new com.tianmu.biz.widget.o.a(this);
        this.P = aVar;
        aVar.a(this.K.p());
        this.P.a(new com.tianmu.c.l.c() { // from class: com.tianmu.ad.activity.RewardVodActivity.14
            @Override // com.tianmu.c.l.c
            public void onClick(View view, int i2) {
                if (RewardVodActivity.this.J != null) {
                    RewardVodActivity.this.I.onAdClick(view, RewardVodActivity.this.J, 999);
                }
            }
        });
        frameLayout.addView(this.P, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a aVar = this.f10586g;
        if (aVar == null || this.f10588i == null) {
            return;
        }
        boolean zS = aVar.s();
        this.f10588i.setImageResource(zS ? com.tianmu.c.f.c.f11279e : com.tianmu.c.f.c.f11280f);
        f fVar = this.H;
        if (fVar == null || fVar.i0() == null) {
            return;
        }
        if (zS) {
            this.H.i0().d(this.H.W(), this.w);
        } else {
            this.H.i0().g(this.H.f0(), this.w);
        }
    }

    private void i() {
        if (this.o) {
            return;
        }
        releaseExposeChecker();
        com.tianmu.c.j.a aVar = new com.tianmu.c.j.a(true, this);
        this.N = aVar;
        aVar.setExposeCheckNeedTime(500L);
        startExposeChecker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        RewardAdInfo rewardAdInfo = this.J;
        if (rewardAdInfo != null && !this.p) {
            this.p = true;
            rewardAdInfo.onAdClose();
        }
        finish();
    }

    private void k() {
        try {
            this.j.setVisibility(8);
            this.m.setVisibility(8);
            this.f10587h.setVisibility(8);
            this.f10588i.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        h hVar = this.l;
        if (hVar != null) {
            hVar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.tianmu.biz.widget.l.b bVar = this.k;
        if (bVar != null) {
            bVar.dismiss();
            this.k = null;
        }
    }

    private String n() {
        f fVar = this.H;
        return fVar != null ? fVar.A() : "点击查看详情";
    }

    private void o() {
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(l0.f11432g);
        roundedImageView.a(10.0f);
        TextView textView = (TextView) findViewById(l0.f11433h);
        TextView textView2 = (TextView) findViewById(l0.f11434i);
        TextView textView3 = (TextView) findViewById(l0.m);
        TextView textView4 = (TextView) findViewById(l0.n);
        this.j = findViewById(l0.k);
        this.m = (RelativeLayout) findViewById(l0.l);
        textView.setText(this.K.getTitle());
        textView2.setText(this.K.getTitle());
        textView3.setText(this.K.e());
        if (!TextUtils.isEmpty(this.K.c())) {
            textView4.setText(this.K.c());
            textView4.setVisibility(0);
        }
        TianmuImageLoader imageLoader = TianmuSDK.getInstance().getImageLoader();
        if (!TextUtils.isEmpty(this.K.getAppIconUrl()) && imageLoader != null) {
            imageLoader.loadImage(this, this.K.getAppIconUrl(), roundedImageView);
        }
        if (this.H.f() != null) {
            TextView textView5 = (TextView) findViewById(l0.o);
            textView5.setText(q0.a(this, this.H.f(), true));
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        }
        View viewFindViewById = findViewById(l0.p);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.height = (int) (((double) this.D) * 0.3d);
        viewFindViewById.setLayoutParams(layoutParams);
        View viewFindViewById2 = findViewById(l0.f11435q);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams();
        layoutParams2.height = (int) (((double) this.D) * 0.7d);
        viewFindViewById2.setLayoutParams(layoutParams2);
    }

    public void c() {
        this.f10584e = (RelativeLayout) findViewById(l0.f11427b);
        this.f10585f = (RelativeLayout) findViewById(l0.f11428c);
        this.f10587h = (TextView) findViewById(l0.f11429d);
        this.f10588i = (ImageView) findViewById(l0.f11430e);
        this.n = (FrameLayout) findViewById(l0.f11431f);
        String str = this.f10581b;
        c cVar = this.K;
        a aVar = new a(this, str, cVar != null ? cVar.getImageUrl() : null);
        this.f10586g = aVar;
        aVar.a(this);
        ViewGroup.LayoutParams layoutParams = this.f10585f.getLayoutParams();
        layoutParams.width = this.B;
        layoutParams.height = this.C;
        this.f10585f.setLayoutParams(layoutParams);
        this.f10585f.addView(this.f10586g);
        z();
        this.f10586g.I();
        a(0);
        this.f10588i.setImageResource(this.f10583d ? com.tianmu.c.f.c.f11279e : com.tianmu.c.f.c.f11280f);
        t();
        o();
        b();
        y();
        a();
    }

    public void e() {
        if (!this.v || this.u) {
            if (!this.u) {
                this.z = true;
            }
            j();
            return;
        }
        try {
            if (this.n == null) {
                f();
                return;
            }
            if (this.l == null) {
                h hVar = new h(this, this.K.getAppIconUrl(), this.K.getTitle(), this.K.getDesc(), n(), new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.RewardVodActivity.6
                    @Override // com.tianmu.c.l.a
                    public void onSingleClick(View view) {
                        RewardVodActivity.this.j();
                    }
                }, new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.RewardVodActivity.7
                    @Override // com.tianmu.c.l.a
                    public void onSingleClick(View view) {
                        RewardVodActivity.this.c(view);
                    }
                }, new com.tianmu.c.l.a() { // from class: com.tianmu.ad.activity.RewardVodActivity.8
                    @Override // com.tianmu.c.l.a
                    public void onSingleClick(View view) {
                        RewardVodActivity.this.l();
                    }
                });
                this.l = hVar;
                TianmuViewUtil.addAdViewToAdContainer(this.n, hVar);
            }
            this.l.setVisibility(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        RewardAdInfo rewardAdInfo = this.J;
        if (rewardAdInfo != null) {
            rewardAdInfo.onVideoSkip();
        }
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        TextView textView = this.f10587h;
        if (textView != null) {
            if (!this.u && i2 != 0) {
                textView.setVisibility(0);
                this.f10587h.setText(getResources().getString(c1.f11297e).replace("%1$", String.valueOf(i2)));
            } else {
                textView.setText(c1.f11296d);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10587h.getLayoutParams();
                layoutParams.width = -2;
                this.f10587h.setLayoutParams(layoutParams);
                x();
            }
        }
    }

    private void a(int i2) {
        View view = this.j;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    private void a(int i2, int i3) {
        a aVar = this.f10586g;
        if (aVar == null || !aVar.G() || (i3 - i2) / 1000 > 0) {
            return;
        }
        a(true);
    }

    public synchronized void a(boolean z) {
        b(false);
        if (!this.s) {
            TianmuLogUtil.iD("onVideoEnd----->");
            this.s = true;
            f fVar = this.H;
            if (fVar != null && fVar.i0() != null && z) {
                this.H.i0().b(this.H.T(), this.w);
                this.H.i0().g(this.H.j0());
            }
            RewardAdInfo rewardAdInfo = this.J;
            if (rewardAdInfo != null && z) {
                rewardAdInfo.onVideoCompleted();
                x();
            }
            D();
            k();
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        f fVar = this.H;
        if (fVar != null && fVar.I() && this.H.f() != null) {
            this.H.f().a(true);
        }
        a(view);
    }

    private void b(boolean z) {
        Handler handler = this.f10589q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            if (z) {
                this.f10589q = null;
            }
        }
    }

    public void b() {
        if (this.H != null || this.I == null) {
            e eVarA = new e.c(e.class).a((ViewGroup) findViewById(l0.l)).a("rewardvod").b(this.H.s()).c(this.H.t()).d(-2).a(-2).a(this.O).b(this.I.sensorDisable()).a(new com.tianmu.biz.widget.interaction.slideanimalview.b.a(this.H.t())).g(this.G / 2).f(com.tianmu.biz.widget.n.e.a.s).e(0).a((View) this.f10586g).c(this.H.C()).a();
            this.L = eVarA;
            eVarA.q();
            if (this.L.g() != null && this.L.l() != null) {
                RelativeLayout.LayoutParams layoutParamsG = this.L.g();
                layoutParamsG.addRule(12);
                layoutParamsG.addRule(14);
                if (this.H.s() == 5 && this.H.t() == 52) {
                    layoutParamsG.bottomMargin = this.D;
                } else {
                    layoutParamsG.bottomMargin = this.D + TianmuDisplayUtil.dp2px(30);
                }
                this.L.l().setLayoutParams(layoutParamsG);
            }
            new Handler().postDelayed(new Runnable() { // from class: com.tianmu.ad.activity.RewardVodActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    RewardVodActivity.this.B();
                }
            }, 4000L);
        }
    }

    private void a(View view) {
        f fVar;
        onViewExpose();
        if (view != null && (fVar = this.H) != null && fVar.i0() != null) {
            this.H.i0().a(view, this.H);
        }
        RewardAdInfo rewardAdInfo = this.J;
        if (rewardAdInfo != null) {
            rewardAdInfo.onAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        f fVar = this.H;
        if (fVar != null && fVar.I() && this.H.f() != null) {
            this.H.f().a(false);
        }
        a(view);
    }

    private void a(long j) {
        this.A = true;
        this.x = j;
        cancelRewardCountDown();
        CountDownTimer countDownTimer = new CountDownTimer(this.x, 1000L) { // from class: com.tianmu.ad.activity.RewardVodActivity.10
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (RewardVodActivity.this.l != null) {
                    RewardVodActivity.this.l.a(0L);
                }
                RewardVodActivity.this.b(0);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                RewardVodActivity.this.x -= 1000;
                if (RewardVodActivity.this.l != null) {
                    RewardVodActivity.this.l.a((int) (RewardVodActivity.this.x / 1000));
                }
                RewardVodActivity rewardVodActivity = RewardVodActivity.this;
                rewardVodActivity.b((int) (rewardVodActivity.x / 1000));
            }
        };
        this.r = countDownTimer;
        countDownTimer.start();
    }

    public void a() {
        g();
    }
}
