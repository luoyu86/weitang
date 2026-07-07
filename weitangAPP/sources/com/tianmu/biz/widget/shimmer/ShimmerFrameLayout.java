package com.tianmu.biz.widget.shimmer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.biz.widget.shimmer.a;
import com.tianmu.c.f.d1;

/* JADX INFO: loaded from: classes2.dex */
public class ShimmerFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f11186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f11187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11188c;

    public ShimmerFrameLayout(Context context) {
        super(context);
        this.f11186a = new Paint();
        this.f11187b = new b();
        this.f11188c = true;
        a(context, null);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet) {
        setWillNotDraw(false);
        this.f11187b.setCallback(this);
        if (attributeSet == null) {
            a(new a.C0204a().a());
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.b.f11326a, 0, 0);
        try {
            int i2 = d1.b.u;
            a(((typedArrayObtainStyledAttributes.hasValue(i2) && typedArrayObtainStyledAttributes.getBoolean(i2, false)) ? new a.c() : new a.C0204a()).a(typedArrayObtainStyledAttributes).a());
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void b() {
        this.f11187b.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f11188c) {
            this.f11187b.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11187b.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f11187b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11187b;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11186a = new Paint();
        this.f11187b = new b();
        this.f11188c = true;
        a(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11186a = new Paint();
        this.f11187b = new b();
        this.f11188c = true;
        a(context, attributeSet);
    }

    public ShimmerFrameLayout a(@Nullable a aVar) {
        this.f11187b.a(aVar);
        if (aVar != null && aVar.n) {
            setLayerType(2, this.f11186a);
        } else {
            setLayerType(0, null);
        }
        return this;
    }

    public void a() {
        this.f11187b.c();
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f11186a = new Paint();
        this.f11187b = new b();
        this.f11188c = true;
        a(context, attributeSet);
    }
}
