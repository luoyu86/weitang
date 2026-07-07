package c.f.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.contrarywind.view.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f2504a;

    public a(WheelView wheelView) {
        this.f2504a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f2504a.scrollBy(f3);
        return true;
    }
}
