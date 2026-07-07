package com.tianmu.biz.widget.sway;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tianmu.c.f.d1;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class TeetertotterProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f11216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f11218c;

    public TeetertotterProgressBar(Context context) {
        super(context);
        this.f11216a = new Paint(1);
        int iDp2px = TianmuDisplayUtil.dp2px(24);
        this.f11217b = iDp2px;
        this.f11218c = iDp2px;
        a();
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.c.f11336a);
        this.f11218c = typedArrayObtainStyledAttributes.getDimension(d1.c.f11337b, this.f11217b);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f11216a.setColor(Color.parseColor("#4D000000"));
        canvas.drawCircle(this.f11218c, getHeight() / 2.0f, this.f11218c, this.f11216a);
        canvas.drawCircle(getWidth() - this.f11218c, getHeight() / 2.0f, this.f11218c, this.f11216a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
    }

    private void a() {
        this.f11216a.setStyle(Paint.Style.FILL);
    }

    public TeetertotterProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11216a = new Paint(1);
        int iDp2px = TianmuDisplayUtil.dp2px(24);
        this.f11217b = iDp2px;
        this.f11218c = iDp2px;
        a(context, attributeSet);
        a();
    }

    public TeetertotterProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11216a = new Paint(1);
        int iDp2px = TianmuDisplayUtil.dp2px(24);
        this.f11217b = iDp2px;
        this.f11218c = iDp2px;
        a(context, attributeSet);
        a();
    }
}
