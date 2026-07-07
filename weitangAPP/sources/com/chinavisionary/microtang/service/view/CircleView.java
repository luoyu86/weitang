package com.chinavisionary.microtang.service.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes2.dex */
public class CircleView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8488a;

    public CircleView(Context context) {
        super(context);
    }

    public final void a(Canvas canvas) {
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f8488a = i4 - i2;
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
