package com.chinavisionary.microtang.sign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;

/* JADX INFO: loaded from: classes2.dex */
public class NestedScrollWebView extends BaseWebView implements NestedScrollingChild {
    public static final String r = NestedScrollWebView.class.getSimpleName();
    public int s;
    public final int[] t;
    public final int[] u;
    public int v;
    public NestedScrollingChildHelper w;

    public NestedScrollWebView(Context context) {
        super(context);
        this.t = new int[2];
        this.u = new int[2];
        g();
    }

    private void g() {
        this.w = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.w.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.w.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.w.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.w.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.w.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.w.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                this.v = 0;
            }
            int y = (int) motionEvent.getY();
            motionEvent.offsetLocation(0.0f, this.v);
            if (actionMasked == 0) {
                this.s = y;
                startNestedScroll(3);
                return super.onTouchEvent(motionEvent);
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.s - y;
                    if (dispatchNestedPreScroll(0, i2, this.u, this.t)) {
                        i2 -= this.u[1];
                        motionEventObtain.offsetLocation(0.0f, this.t[1]);
                        this.v += this.t[1];
                    }
                    int scrollY = getScrollY();
                    this.s = y - this.t[1];
                    int iMax = Math.max(0, scrollY + i2);
                    int i3 = i2 - (iMax - scrollY);
                    if (dispatchNestedScroll(0, iMax - i3, 0, i3, this.t)) {
                        this.s = this.s - this.t[1];
                        motionEventObtain.offsetLocation(0.0f, r2[1]);
                        this.v += this.t[1];
                    }
                    if (this.u[1] != 0 || this.t[1] != 0) {
                        return false;
                    }
                    motionEventObtain.recycle();
                    return super.onTouchEvent(motionEventObtain);
                }
                if (actionMasked != 3 && actionMasked != 5) {
                    return false;
                }
            }
            stopNestedScroll();
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.w.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.w.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.w.stopNestedScroll();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new int[2];
        this.u = new int[2];
        g();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = new int[2];
        this.u = new int[2];
        g();
    }
}
