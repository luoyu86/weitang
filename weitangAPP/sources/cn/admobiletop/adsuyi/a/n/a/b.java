package cn.admobiletop.adsuyi.a.n.a;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f3441a;

    public b(h hVar) {
        this.f3441a = hVar;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f3441a.c((int) (motionEvent2.getX() - motionEvent.getX()), (int) (motionEvent2.getY() - motionEvent.getY()));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f3441a.f3458i = motionEvent.getX();
        this.f3441a.j = motionEvent.getY();
        this.f3441a.m(false);
        return true;
    }
}
