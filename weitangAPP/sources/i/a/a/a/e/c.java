package i.a.a.a.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(8)
public class c extends b {
    public final ScaleGestureDetector j;

    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            c.this.f14909a.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public c(Context context) {
        super(context);
        this.j = new ScaleGestureDetector(context, new a());
    }

    @Override // i.a.a.a.e.a, i.a.a.a.e.d
    public boolean isScaling() {
        return this.j.isInProgress();
    }

    @Override // i.a.a.a.e.b, i.a.a.a.e.a, i.a.a.a.e.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.j.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
