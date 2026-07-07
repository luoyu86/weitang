package cn.admobiletop.adsuyi.a.n.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f3446a;

    public f(g gVar) {
        this.f3446a = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f3446a.getNotificationListener() != null) {
            this.f3446a.getNotificationListener().onAutoDismiss();
        }
    }
}
