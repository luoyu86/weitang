package i.a.a.a.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f14909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f14912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f14913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f14914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14915g;

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f14913e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f14912d = viewConfiguration.getScaledTouchSlop();
    }

    public float a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    public float b(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // i.a.a.a.e.d
    public boolean isDragging() {
        return this.f14915g;
    }

    @Override // i.a.a.a.e.d
    public boolean isScaling() {
        return false;
    }

    @Override // i.a.a.a.e.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        if (action == 0) {
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f14914f = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            } else {
                i.a.a.a.f.a.getLogger().i("CupcakeGestureDetector", "Velocity tracker is null");
            }
            this.f14910b = a(motionEvent);
            this.f14911c = b(motionEvent);
            this.f14915g = false;
        } else if (action == 1) {
            if (this.f14915g && this.f14914f != null) {
                this.f14910b = a(motionEvent);
                this.f14911c = b(motionEvent);
                this.f14914f.addMovement(motionEvent);
                this.f14914f.computeCurrentVelocity(1000);
                float xVelocity = this.f14914f.getXVelocity();
                float yVelocity = this.f14914f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f14913e) {
                    this.f14909a.onFling(this.f14910b, this.f14911c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f14914f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f14914f = null;
            }
        } else if (action == 2) {
            float fA = a(motionEvent);
            float fB = b(motionEvent);
            float f2 = fA - this.f14910b;
            float f3 = fB - this.f14911c;
            if (!this.f14915g) {
                this.f14915g = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f14912d);
            }
            if (this.f14915g) {
                this.f14909a.onDrag(f2, f3);
                this.f14910b = fA;
                this.f14911c = fB;
                VelocityTracker velocityTracker3 = this.f14914f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f14914f) != null) {
            velocityTracker.recycle();
            this.f14914f = null;
        }
        return true;
    }

    @Override // i.a.a.a.e.d
    public void setOnGestureListener(e eVar) {
        this.f14909a = eVar;
    }
}
