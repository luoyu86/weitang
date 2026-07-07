package com.chinavisionary.microtang.merchant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.e.a.d.q;

/* JADX INFO: loaded from: classes.dex */
public class MerchantConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7941b;

    public MerchantConstraintLayout(Context context) {
        super(context);
        this.f7940a = 60;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.Class<com.chinavisionary.microtang.merchant.view.MerchantConstraintLayout> r0 = com.chinavisionary.microtang.merchant.view.MerchantConstraintLayout.class
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r1 = "dispatchTouchEvent"
            c.e.a.d.q.d(r0, r1)
            int r0 = r5.getAction()
            if (r0 == 0) goto L47
            r1 = 2
            if (r0 == r1) goto L15
            goto L4e
        L15:
            float r0 = r5.getY()
            int r0 = (int) r0
            java.lang.Class<com.chinavisionary.microtang.merchant.view.MerchantConstraintLayout> r1 = com.chinavisionary.microtang.merchant.view.MerchantConstraintLayout.class
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "dispatchTouchEvent mLastY:"
            r2.append(r3)
            int r3 = r4.f7941b
            r2.append(r3)
            java.lang.String r3 = ", y :"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            c.e.a.d.q.d(r1, r2)
            int r1 = r4.f7941b
            int r1 = r1 - r0
            int r0 = r4.f7940a
            if (r1 <= r0) goto L4e
            r0 = 1
            goto L4f
        L47:
            float r0 = r5.getY()
            int r0 = (int) r0
            r4.f7941b = r0
        L4e:
            r0 = 0
        L4f:
            if (r0 == 0) goto L52
            goto L56
        L52:
            boolean r0 = super.dispatchTouchEvent(r5)
        L56:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.microtang.merchant.view.MerchantConstraintLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        q.d(MerchantConstraintLayout.class.getSimpleName(), "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        q.d(MerchantConstraintLayout.class.getSimpleName(), "onTouchEvent");
        return super.onTouchEvent(motionEvent);
    }

    public MerchantConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7940a = 60;
    }

    public MerchantConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7940a = 60;
    }
}
