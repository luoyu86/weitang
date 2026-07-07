package cn.admobiletop.adsuyi.c;

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
import cn.admobiletop.adsuyi.c.A;

/* JADX INFO: loaded from: classes.dex */
public final class D extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Paint f4140a = new Paint();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f4142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final A.d f4143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f4144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4147h;

    public D(Context context, Bitmap bitmap, Drawable drawable, A.d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f4147h = 255;
        this.f4141b = z2;
        this.f4142c = context.getResources().getDisplayMetrics().density;
        this.f4143d = dVar;
        if ((dVar == A.d.MEMORY || z) ? false : true) {
            this.f4144e = drawable;
            this.f4146g = true;
            this.f4145f = SystemClock.uptimeMillis();
        }
    }

    public static Path a(Point point, int i2) {
        Point point2 = new Point(point.x + i2, point.y);
        Point point3 = new Point(point.x, point.y + i2);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }

    public static void c(ImageView imageView, Context context, Bitmap bitmap, A.d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new D(context, bitmap, drawable, dVar, z, z2));
    }

    public static void d(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    public final void b(Canvas canvas) {
        Paint paint = f4140a;
        paint.setColor(-1);
        canvas.drawPath(a(new Point(0, 0), (int) (this.f4142c * 16.0f)), paint);
        paint.setColor(this.f4143d.f4132e);
        canvas.drawPath(a(new Point(0, 0), (int) (this.f4142c * 15.0f)), paint);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f4146g) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f4145f) / 200.0f;
            if (fUptimeMillis >= 1.0f) {
                this.f4146g = false;
                this.f4144e = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f4144e;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (this.f4147h * fUptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f4147h);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f4141b) {
            b(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4144e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f4147h = i2;
        Drawable drawable = this.f4144e;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
        super.setAlpha(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4144e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
