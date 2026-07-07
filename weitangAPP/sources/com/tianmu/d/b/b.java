package com.tianmu.d.b;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements GestureDetector.OnGestureListener {
    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
