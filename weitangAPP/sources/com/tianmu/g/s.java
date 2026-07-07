package com.tianmu.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tianmu.g.r;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends BitmapDrawable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Paint f12144h = new Paint();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f12146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r.e f12147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f12148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12151g;

    public s(Context context, Bitmap bitmap, Drawable drawable, r.e eVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f12151g = 255;
        this.f12145a = z2;
        this.f12146b = context.getResources().getDisplayMetrics().density;
        this.f12147c = eVar;
        if ((eVar == r.e.f12136b || z) ? false : true) {
            this.f12148d = drawable;
            this.f12150f = true;
            this.f12149e = SystemClock.uptimeMillis();
        }
    }

    public static void a(ImageView imageView, Context context, Bitmap bitmap, r.e eVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new s(context, bitmap, drawable, eVar, z, z2));
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f12150f) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f12149e) / 200.0f;
            if (fUptimeMillis >= 1.0f) {
                this.f12150f = false;
                this.f12148d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f12148d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (this.f12151g * fUptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f12151g);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f12145a) {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f12148d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f12151g = i2;
        Drawable drawable = this.f12148d;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
        super.setAlpha(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f12148d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    public static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    private void a(Canvas canvas) {
        Paint paint = f12144h;
        paint.setColor(-1);
        canvas.drawPath(a(new Point(0, 0), (int) (this.f12146b * 16.0f)), paint);
        paint.setColor(this.f12147c.f12139a);
        canvas.drawPath(a(new Point(0, 0), (int) (this.f12146b * 15.0f)), paint);
    }

    private static Path a(Point point, int i2) {
        Point point2 = new Point(point.x + i2, point.y);
        Point point3 = new Point(point.x, point.y + i2);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }
}
