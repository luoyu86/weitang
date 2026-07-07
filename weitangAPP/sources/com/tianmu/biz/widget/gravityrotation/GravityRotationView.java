package com.tianmu.biz.widget.gravityrotation;

import android.content.Context;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class GravityRotationView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Scroller f11005f;

    public GravityRotationView(Context context) {
        super(context);
        this.f11000a = -1;
        this.f11001b = 0;
        this.f11002c = 0;
        this.f11003d = -1;
        this.f11004e = -1;
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        this.f11005f = new Scroller(context, new LinearInterpolator());
    }

    private int c(int i2) {
        return TianmuDisplayUtil.dp2px(i2);
    }

    public int b() {
        return this.f11002c;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f11005f.computeScrollOffset()) {
            scrollTo(this.f11005f.getCurrX(), this.f11005f.getCurrY());
            postInvalidate();
        }
    }

    private void a(int i2, int i3) {
        this.f11005f.startScroll(getScrollX(), getScrollY(), i2, i3, 80);
        invalidate();
    }

    public void b(int i2) {
        this.f11002c = i2;
    }

    public void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.f11000a = 1;
        } else {
            this.f11000a = -1;
        }
    }

    public void a(float[] fArr, float[] fArr2) {
        int i2;
        int i3;
        int iC;
        float[] fArr3 = new float[3];
        float[] fArr4 = new float[9];
        SensorManager.getRotationMatrix(fArr4, null, fArr, fArr2);
        SensorManager.getOrientation(fArr4, fArr3);
        fArr3[0] = (float) Math.toDegrees(fArr3[0]);
        fArr3[1] = (float) Math.toDegrees(fArr3[1]);
        fArr3[2] = (float) Math.toDegrees(fArr3[2]);
        int i4 = (int) fArr3[1];
        int i5 = (int) fArr3[2];
        if (this.f11003d == -1 && this.f11004e == -1) {
            this.f11003d = i4;
            this.f11004e = i5;
        }
        int iAbs = Math.abs(i4 - this.f11001b);
        int iAbs2 = Math.abs(i5 - this.f11002c);
        int finalX = this.f11005f.getFinalX();
        int finalY = this.f11005f.getFinalY();
        if ((2 > iAbs2 || iAbs2 >= 40) && (2 > iAbs || iAbs >= 40)) {
            return;
        }
        int i6 = this.f11003d;
        int i7 = i4 - i6;
        if ((-40 < i7 && i7 <= 0) || (1 <= (i2 = i4 - i6) && i2 < 40)) {
            if (this.f11000a == -1) {
                iC = c(5);
            } else {
                iC = c(3);
            }
            finalY = ((iC * (-this.f11000a)) * (i4 - this.f11003d)) / 14;
        }
        int i8 = this.f11004e;
        int i9 = i5 - i8;
        if ((-40 < i9 && i9 <= 0) || (1 <= (i3 = i5 - i8) && i3 < 40)) {
            finalX = ((c(17) * this.f11000a) * (i5 - this.f11004e)) / 40;
        }
        a(finalX - getScrollX(), finalY - getScrollY());
        this.f11001b = i4;
        this.f11002c = i5;
    }

    public GravityRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11000a = -1;
        this.f11001b = 0;
        this.f11002c = 0;
        this.f11003d = -1;
        this.f11004e = -1;
        a(context, attributeSet, 0);
    }

    public GravityRotationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11000a = -1;
        this.f11001b = 0;
        this.f11002c = 0;
        this.f11003d = -1;
        this.f11004e = -1;
        a(context, attributeSet, i2);
    }

    public int a() {
        return this.f11001b;
    }

    public void a(int i2) {
        this.f11001b = i2;
    }
}
