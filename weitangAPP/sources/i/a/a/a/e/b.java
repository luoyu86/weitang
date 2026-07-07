package i.a.a.a.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(5)
public class b extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14917i;

    public b(Context context) {
        super(context);
        this.f14916h = -1;
        this.f14917i = 0;
    }

    @Override // i.a.a.a.e.a
    public float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f14917i);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // i.a.a.a.e.a
    public float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f14917i);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    @Override // i.a.a.a.e.a, i.a.a.a.e.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.f14916h = -1;
            } else if (action == 6) {
                int pointerIndex = i.a.a.a.a.getPointerIndex(motionEvent.getAction());
                if (motionEvent.getPointerId(pointerIndex) == this.f14916h) {
                    int i2 = pointerIndex != 0 ? 0 : 1;
                    this.f14916h = motionEvent.getPointerId(i2);
                    this.f14910b = motionEvent.getX(i2);
                    this.f14911c = motionEvent.getY(i2);
                }
            }
        } else {
            this.f14916h = motionEvent.getPointerId(0);
        }
        int i3 = this.f14916h;
        this.f14917i = motionEvent.findPointerIndex(i3 != -1 ? i3 : 0);
        return super.onTouchEvent(motionEvent);
    }
}
