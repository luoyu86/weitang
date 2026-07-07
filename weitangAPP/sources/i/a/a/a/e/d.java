package i.a.a.a.e;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface d {
    boolean isDragging();

    boolean isScaling();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setOnGestureListener(e eVar);
}
