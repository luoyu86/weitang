package cn.admobiletop.adsuyi.adapter.gdt.c;

import android.animation.Animator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.admobiletop.adsuyi.adapter.gdt.c.i;

/* JADX INFO: loaded from: classes.dex */
public class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i.a f3694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f3697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int[] f3698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f3699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f3701h;

    public h(i iVar, i.a aVar, View view, ViewGroup viewGroup, float f2, int[] iArr, float f3, ViewGroup viewGroup2) {
        this.f3701h = iVar;
        this.f3694a = aVar;
        this.f3695b = view;
        this.f3696c = viewGroup;
        this.f3697d = f2;
        this.f3698e = iArr;
        this.f3699f = f3;
        this.f3700g = viewGroup2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Log.d("SplashZoomOutManager", "zoomOut onAnimationEnd");
        cn.admobiletop.adsuyi.adapter.gdt.e.f.a(this.f3695b);
        this.f3695b.setScaleX(1.0f);
        this.f3695b.setScaleY(1.0f);
        this.f3695b.setX(0.0f);
        this.f3695b.setY(0.0f);
        int[] iArr = new int[2];
        this.f3696c.getLocationOnScreen(iArr);
        float f2 = this.f3697d - iArr[0];
        int[] iArr2 = this.f3698e;
        float f3 = f2 + iArr2[0];
        float f4 = (this.f3699f - iArr[1]) + iArr2[1];
        Log.d("SplashZoomOutManager", "zoomOut distX:" + f3 + " distY:" + f4);
        Log.d("SplashZoomOutManager", "zoomOut containerScreenX:" + iArr[0] + " containerScreenY:" + iArr[1]);
        this.f3700g.addView(this.f3695b, -1, -1);
        this.f3696c.addView(this.f3700g, new FrameLayout.LayoutParams(this.f3701h.f3702a, this.f3701h.f3703b));
        this.f3700g.setTranslationX(f3);
        this.f3700g.setTranslationY(f4);
        i.a aVar = this.f3694a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Log.d("SplashZoomOutManager", "zoomOut onAnimationStart");
        i.a aVar = this.f3694a;
        if (aVar != null) {
            aVar.a(this.f3701h.f3707f);
        }
    }
}
