package cn.admobiletop.adsuyi.a.n.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f3443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3444b;

    public d(h hVar, boolean z) {
        this.f3444b = hVar;
        this.f3443a = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f3444b.n = true;
        if (this.f3444b.getNotificationListener() != null) {
            if (this.f3443a) {
                this.f3444b.getNotificationListener().onAutoDismiss();
            } else {
                this.f3444b.getNotificationListener().onManuallyDismiss();
            }
        }
    }
}
