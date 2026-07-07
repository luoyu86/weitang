package com.tianmu.biz.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.model.IInteractionView;
import com.tianmu.ad.widget.interstitialview.InterstitialView;
import com.tianmu.ad.widget.interstitialview.base.InterstitialAutoCloseAdView;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuViewUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f extends InterstitialAutoCloseAdView implements com.tianmu.c.l.e, IInteractionView {
    private InterfaceC0190f A;
    private com.tianmu.c.l.a B;
    private com.tianmu.c.l.a C;
    private com.tianmu.c.l.c D;
    private ObjectAnimator E;
    private ObjectAnimator F;
    private boolean z;

    public class a extends com.tianmu.c.l.a {
        public a() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            f.this.m();
        }
    }

    public class b extends com.tianmu.c.l.a {
        public b() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            f.this.b(0);
        }
    }

    public class c implements com.tianmu.c.l.c {
        public c() {
        }

        @Override // com.tianmu.c.l.c
        public void onClick(View view, int i2) {
            f.this.b(i2);
        }
    }

    public class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10986b;

        public d(String str, String str2) {
            this.f10985a = str;
            this.f10986b = str2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f.this.a(this.f10986b) == null) {
                return;
            }
            TianmuViewUtil.removeSelfFromParent((View) f.this.m.get(this.f10986b));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.b(this.f10985a);
        }
    }

    public class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterstitialView f10988a;

        public e(InterstitialView interstitialView) {
            this.f10988a = interstitialView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            InterstitialView interstitialView = this.f10988a;
            if (interstitialView == null) {
                return;
            }
            TianmuViewUtil.addAdViewToAdContainer(f.this, interstitialView);
            this.f10988a.render();
        }
    }

    /* JADX INFO: renamed from: com.tianmu.biz.widget.f$f, reason: collision with other inner class name */
    public interface InterfaceC0190f {
        void onClose();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public f(InterstitialAd interstitialAd, InterstitialAdInfo interstitialAdInfo, boolean z, InterfaceC0190f interfaceC0190f, int i2) {
        super(interstitialAd, interstitialAdInfo);
        this.B = new a();
        this.C = new b();
        this.D = new c();
        ((InterstitialAdInfo) this.o).setRenderListener(this);
        this.A = interfaceC0190f;
        this.z = z;
        a(i2);
        this.m = new HashMap();
        for (String str : interstitialAdInfo.getAdDataMap().keySet()) {
            this.m.put(str, new InterstitialView(interstitialAd, interstitialAdInfo, interstitialAdInfo.getAdDataMap().get(str), this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        cancelTask();
        ADInfo adinfo = this.o;
        if (adinfo != 0 && ((InterstitialAdInfo) adinfo).getAdInfoStatus() != null) {
            ((InterstitialAdInfo) this.o).getAdInfoStatus().b(true);
        }
        AD ad = this.n;
        if (ad != 0) {
            ((InterstitialAd) ad).onAdExpose(this.o);
            ((InterstitialAd) this.n).materialSkip(this.o);
            ((InterstitialAd) this.n).onAdClose(this.o);
        }
        InterfaceC0190f interfaceC0190f = this.A;
        if (interfaceC0190f != null) {
            interfaceC0190f.onClose();
        }
    }

    @Override // com.tianmu.c.l.e
    public void a() {
    }

    @Override // com.tianmu.c.l.e
    public void b() {
    }

    public com.tianmu.c.l.a g() {
        return this.C;
    }

    @Override // com.tianmu.ad.model.IInteractionView
    public View getClickableView() {
        ADInfo adinfo;
        Map<String, V> map = this.m;
        if (map == 0 || (adinfo = this.o) == 0 || map.get(((InterstitialAdInfo) adinfo).getUseKey()) == null) {
            return null;
        }
        InterstitialView interstitialView = (InterstitialView) this.m.get(((InterstitialAdInfo) this.o).getUseKey());
        if (interstitialView.getInterstitialBase() != null) {
            return interstitialView.getInterstitialBase().getInterstitialSkipView();
        }
        return null;
    }

    public com.tianmu.c.l.a h() {
        return this.B;
    }

    public com.tianmu.c.l.c i() {
        return this.D;
    }

    @Override // com.tianmu.ad.widget.interstitialview.base.InterstitialAutoCloseAdView, com.tianmu.c.c.g
    public void init() {
        super.init();
        Map<String, V> map = this.m;
        if (map == 0 || !map.containsKey(((InterstitialAdInfo) this.o).getKey())) {
            return;
        }
        InterstitialView interstitialView = (InterstitialView) this.m.get(((InterstitialAdInfo) this.o).getKey());
        interstitialView.setCountdownRemainTime(this.w);
        interstitialView.setClosePosition(e());
        interstitialView.init();
        if (f()) {
            interstitialView.getInterstitialBase().setCountDownText(this.w);
        }
        TianmuViewUtil.addAdViewToAdContainer(this, interstitialView);
    }

    public boolean j() {
        return this.z;
    }

    public void k() {
        cancelTask();
    }

    public void l() {
        d();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            startCountDown();
        } else {
            stopCountDown();
        }
    }

    @Override // com.tianmu.ad.widget.interstitialview.base.InterstitialAutoCloseAdView, com.tianmu.ad.widget.interstitialview.base.BaseInterstitialAdViewContainer, com.tianmu.c.c.g, com.tianmu.ad.base.IBaseRelease
    public void release() {
        super.release();
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        ObjectAnimator objectAnimator = this.E;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.E = null;
        }
        ObjectAnimator objectAnimator2 = this.F;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.F = null;
        }
    }

    @Override // com.tianmu.ad.widget.interstitialview.base.InterstitialAutoCloseAdView, com.tianmu.c.c.g
    public void render() {
        super.render();
        Map<String, V> map = this.m;
        if (map != 0 && map.containsKey(((InterstitialAdInfo) this.o).getKey())) {
            ((InterstitialView) this.m.get(((InterstitialAdInfo) this.o).getKey())).render();
        }
        d();
    }

    @Override // com.tianmu.ad.widget.interstitialview.base.InterstitialAutoCloseAdView
    public void setCountDownText(int i2) {
        ADInfo adinfo;
        Map<String, V> map = this.m;
        if (map != 0 && (adinfo = this.o) != 0 && map.get(((InterstitialAdInfo) adinfo).getUseKey()) != null) {
            InterstitialView interstitialView = (InterstitialView) this.m.get(((InterstitialAdInfo) this.o).getUseKey());
            if (interstitialView.getInterstitialBase() != null) {
                interstitialView.getInterstitialBase().setCountDownText(i2);
            }
        }
        if (i2 == 0) {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        ADInfo adinfo = this.o;
        if (adinfo != 0) {
            ((InterstitialAdInfo) adinfo).getAdInfoStatus().a(true);
        }
        setStopMaterialSwitch(true);
        cancelTask();
        AD ad = this.n;
        if (ad != 0) {
            ((InterstitialAd) ad).onAdExpose(this.o);
        }
        AD ad2 = this.n;
        if (ad2 != 0) {
            ((InterstitialAd) ad2).onAdClick(this, this.o, i2);
        }
    }

    @Override // com.tianmu.c.c.g
    public void a(boolean z) {
        try {
            String useKey = ((InterstitialAdInfo) this.o).getUseKey();
            String nextKey = ((InterstitialAdInfo) this.o).getNextKey();
            Map<String, V> map = this.m;
            if (map != 0 && map.containsKey(nextKey)) {
                a(useKey, nextKey);
            } else if (z) {
                a(TianmuErrorConfig.AD_GIVE_POLISH_IMAGE_ERROR, TianmuErrorConfig.MSG_AD_GIVE_POLISH_IMAGE_ERROR);
            } else {
                a(TianmuErrorConfig.AD_FAILED_AD_RENDER_EXCEPTION, TianmuErrorConfig.MSG_AD_FAILED_AD_RENDER_EXCEPTION);
            }
        } catch (Exception unused) {
            a(TianmuErrorConfig.AD_FAILED_AD_RENDER_UNKNOWN_EXCEPTION, TianmuErrorConfig.MSG_AD_FAILED_AD_RENDER_UNKNOWN_EXCEPTION);
        }
    }

    private void a(String str, String str2) {
        if (a(str) == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.m.get(str), (Property<Object, Float>) View.ALPHA, 1.0f, 0.0f);
        this.E = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new d(str2, str));
        this.E.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        InterstitialView interstitialView;
        if (a(str) == null || (interstitialView = (InterstitialView) this.m.get(str)) == null) {
            return;
        }
        interstitialView.setCountdownRemainTime(this.w);
        interstitialView.setClosePosition(e());
        interstitialView.init();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.m.get(str), (Property<Object, Float>) View.ALPHA, 0.0f, 1.0f);
        this.F = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new e(interstitialView));
        this.F.start();
    }

    public void a(int i2, String str) {
        AD ad = this.n;
        if (ad != 0) {
            ((InterstitialAd) ad).onAdFailed(new TianmuError(i2, str));
        }
    }
}
