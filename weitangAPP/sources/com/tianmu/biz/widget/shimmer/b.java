package com.tianmu.biz.widget.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f11200a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f11201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f11202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Matrix f11203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private ValueAnimator f11204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private com.tianmu.biz.widget.shimmer.a f11205f;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.invalidateSelf();
        }
    }

    public b() {
        Paint paint = new Paint();
        this.f11201b = paint;
        this.f11202c = new Rect();
        this.f11203d = new Matrix();
        paint.setAntiAlias(true);
    }

    private float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    private void e() {
        com.tianmu.biz.widget.shimmer.a aVar;
        Shader radialGradient;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (iWidth == 0 || iHeight == 0 || (aVar = this.f11205f) == null) {
            return;
        }
        int iB = aVar.b(iWidth);
        int iA = this.f11205f.a(iHeight);
        com.tianmu.biz.widget.shimmer.a aVar2 = this.f11205f;
        boolean z = true;
        if (aVar2.f11194f != 1) {
            int i2 = aVar2.f11191c;
            if (i2 != 1 && i2 != 3) {
                z = false;
            }
            if (z) {
                iB = 0;
            }
            if (!z) {
                iA = 0;
            }
            float f2 = iA;
            com.tianmu.biz.widget.shimmer.a aVar3 = this.f11205f;
            radialGradient = new LinearGradient(0.0f, 0.0f, iB, f2, aVar3.f11190b, aVar3.f11189a, Shader.TileMode.CLAMP);
        } else {
            float f3 = iA / 2.0f;
            float fMax = (float) (((double) Math.max(iB, iA)) / Math.sqrt(2.0d));
            com.tianmu.biz.widget.shimmer.a aVar4 = this.f11205f;
            radialGradient = new RadialGradient(iB / 2.0f, f3, fMax, aVar4.f11190b, aVar4.f11189a, Shader.TileMode.CLAMP);
        }
        this.f11201b.setShader(radialGradient);
    }

    private void f() {
        boolean zIsStarted;
        if (this.f11205f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f11204e;
        if (valueAnimator != null) {
            zIsStarted = valueAnimator.isStarted();
            this.f11204e.cancel();
            this.f11204e.removeAllUpdateListeners();
        } else {
            zIsStarted = false;
        }
        com.tianmu.biz.widget.shimmer.a aVar = this.f11205f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, (aVar.t / aVar.s) + 1.0f);
        this.f11204e = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatMode(this.f11205f.r);
        this.f11204e.setRepeatCount(this.f11205f.f11198q);
        ValueAnimator valueAnimator2 = this.f11204e;
        com.tianmu.biz.widget.shimmer.a aVar2 = this.f11205f;
        valueAnimator2.setDuration(aVar2.s + aVar2.t);
        this.f11204e.addUpdateListener(this.f11200a);
        if (zIsStarted) {
            this.f11204e.start();
        }
    }

    public void a(@Nullable com.tianmu.biz.widget.shimmer.a aVar) {
        this.f11205f = aVar;
        if (aVar != null) {
            this.f11201b.setXfermode(new PorterDuffXfermode(aVar.p ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        e();
        f();
        invalidateSelf();
    }

    public void b() {
        com.tianmu.biz.widget.shimmer.a aVar;
        ValueAnimator valueAnimator = this.f11204e;
        if (valueAnimator == null || valueAnimator.isStarted() || (aVar = this.f11205f) == null || !aVar.o || getCallback() == null) {
            return;
        }
        this.f11204e.start();
    }

    public void c() {
        if (this.f11204e == null || a() || getCallback() == null) {
            return;
        }
        this.f11204e.start();
    }

    public void d() {
        if (this.f11204e == null || !a()) {
            return;
        }
        this.f11204e.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float fA;
        float fA2;
        if (this.f11205f == null || this.f11201b.getShader() == null) {
            return;
        }
        float fTan = (float) Math.tan(Math.toRadians(this.f11205f.m));
        float fHeight = this.f11202c.height() + (this.f11202c.width() * fTan);
        float fWidth = this.f11202c.width() + (fTan * this.f11202c.height());
        ValueAnimator valueAnimator = this.f11204e;
        float f2 = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i2 = this.f11205f.f11191c;
        if (i2 != 1) {
            if (i2 == 2) {
                fA2 = a(fWidth, -fWidth, animatedFraction);
            } else if (i2 != 3) {
                fA2 = a(-fWidth, fWidth, animatedFraction);
            } else {
                fA = a(fHeight, -fHeight, animatedFraction);
            }
            f2 = fA2;
            fA = 0.0f;
        } else {
            fA = a(-fHeight, fHeight, animatedFraction);
        }
        this.f11203d.reset();
        this.f11203d.setRotate(this.f11205f.m, this.f11202c.width() / 2.0f, this.f11202c.height() / 2.0f);
        this.f11203d.postTranslate(f2, fA);
        this.f11201b.getShader().setLocalMatrix(this.f11203d);
        canvas.drawRect(this.f11202c, this.f11201b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        com.tianmu.biz.widget.shimmer.a aVar = this.f11205f;
        return (aVar == null || !(aVar.n || aVar.p)) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f11202c.set(0, 0, rect.width(), rect.height());
        e();
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public boolean a() {
        ValueAnimator valueAnimator = this.f11204e;
        return valueAnimator != null && valueAnimator.isStarted();
    }
}
