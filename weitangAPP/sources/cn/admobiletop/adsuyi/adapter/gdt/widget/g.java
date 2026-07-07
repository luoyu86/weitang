package cn.admobiletop.adsuyi.adapter.gdt.widget;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public class g implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeDrawADInfoView f3786a;

    public g(NativeDrawADInfoView nativeDrawADInfoView) {
        this.f3786a = nativeDrawADInfoView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    @SuppressLint({"ObjectAnimatorBinding"})
    public void onAnimationEnd(Animator animator) {
        this.f3786a.f3751a.setVisibility(0);
        this.f3786a.f3754d.setVisibility(0);
        if (this.f3786a.f3758h == null) {
            NativeDrawADInfoView nativeDrawADInfoView = this.f3786a;
            nativeDrawADInfoView.f3758h = ObjectAnimator.ofInt(nativeDrawADInfoView.f3751a, "cardBackgroundColor", Color.parseColor("#19ffffff"), Color.parseColor("#3185FC")).setDuration(300L);
            this.f3786a.f3758h.setEvaluator(new ArgbEvaluator());
            this.f3786a.f3758h.setStartDelay(1700L);
        }
        this.f3786a.f3758h.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
