package c.l.a;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedDrawable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f2830a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f2831b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f2832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f2833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f2834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f2837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f2838i;
    public final Matrix j;
    public final RectF k;
    public Shader.TileMode l;
    public Shader.TileMode m;
    public boolean n;
    public float o;
    public final boolean[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2839q;
    public float r;
    public ColorStateList s;
    public ImageView.ScaleType t;

    /* JADX INFO: renamed from: c.l.a.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0043a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2840a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f2840a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2840a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2840a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2840a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2840a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2840a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2840a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f2832c = rectF;
        this.f2837h = new RectF();
        this.j = new Matrix();
        this.k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = tileMode;
        this.m = tileMode;
        this.n = true;
        this.o = 0.0f;
        this.p = new boolean[]{true, true, true, true};
        this.f2839q = false;
        this.r = 0.0f;
        this.s = ColorStateList.valueOf(-16777216);
        this.t = ImageView.ScaleType.FIT_CENTER;
        this.f2833d = bitmap;
        int width = bitmap.getWidth();
        this.f2835f = width;
        int height = bitmap.getHeight();
        this.f2836g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f2834e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f2838i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.r);
    }

    public static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(int i2, boolean[] zArr) {
        int length = zArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                return true;
            }
            if (zArr[i3] != (i3 == i2)) {
                return false;
            }
            i3++;
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.w(RoundedDrawable.TAG, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static a fromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    public static Drawable fromDrawable(Drawable drawable) {
        if (drawable == null || (drawable instanceof a)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
            return bitmapDrawableToBitmap != null ? new a(bitmapDrawableToBitmap) : drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), fromDrawable(layerDrawable.getDrawable(i2)));
        }
        return layerDrawable;
    }

    public final void d(Canvas canvas) {
        if (a(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.f2831b;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float fWidth = rectF.width() + f2;
        float fHeight = this.f2831b.height() + f3;
        float f4 = this.o;
        if (!this.p[0]) {
            this.k.set(f2, f3, f2 + f4, f3 + f4);
            canvas.drawRect(this.k, this.f2834e);
        }
        if (!this.p[1]) {
            this.k.set(fWidth - f4, f3, fWidth, f4);
            canvas.drawRect(this.k, this.f2834e);
        }
        if (!this.p[2]) {
            this.k.set(fWidth - f4, fHeight - f4, fWidth, fHeight);
            canvas.drawRect(this.k, this.f2834e);
        }
        if (this.p[3]) {
            return;
        }
        this.k.set(f2, fHeight - f4, f4 + f2, fHeight);
        canvas.drawRect(this.k, this.f2834e);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.f2833d, this.l, this.m);
            Shader.TileMode tileMode = this.l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.f2834e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.f2839q) {
            if (this.r <= 0.0f) {
                canvas.drawOval(this.f2831b, this.f2834e);
                return;
            } else {
                canvas.drawOval(this.f2831b, this.f2834e);
                canvas.drawOval(this.f2837h, this.f2838i);
                return;
            }
        }
        if (!b(this.p)) {
            canvas.drawRect(this.f2831b, this.f2834e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.f2837h, this.f2838i);
                return;
            }
            return;
        }
        float f2 = this.o;
        if (this.r <= 0.0f) {
            canvas.drawRoundRect(this.f2831b, f2, f2, this.f2834e);
            d(canvas);
        } else {
            canvas.drawRoundRect(this.f2831b, f2, f2, this.f2834e);
            canvas.drawRoundRect(this.f2837h, f2, f2, this.f2838i);
            d(canvas);
            e(canvas);
        }
    }

    public final void e(Canvas canvas) {
        float f2;
        if (a(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.f2831b;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float fWidth = rectF.width() + f3;
        float fHeight = f4 + this.f2831b.height();
        float f5 = this.o;
        float f6 = this.r / 2.0f;
        if (!this.p[0]) {
            canvas.drawLine(f3 - f6, f4, f3 + f5, f4, this.f2838i);
            canvas.drawLine(f3, f4 - f6, f3, f4 + f5, this.f2838i);
        }
        if (!this.p[1]) {
            canvas.drawLine((fWidth - f5) - f6, f4, fWidth, f4, this.f2838i);
            canvas.drawLine(fWidth, f4 - f6, fWidth, f4 + f5, this.f2838i);
        }
        if (this.p[2]) {
            f2 = f5;
        } else {
            f2 = f5;
            canvas.drawLine((fWidth - f5) - f6, fHeight, fWidth + f6, fHeight, this.f2838i);
            canvas.drawLine(fWidth, fHeight - f2, fWidth, fHeight, this.f2838i);
        }
        if (this.p[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, fHeight, f3 + f2, fHeight, this.f2838i);
        canvas.drawLine(f3, fHeight - f2, f3, fHeight, this.f2838i);
    }

    public final void f() {
        float fWidth;
        float fHeight;
        int i2 = C0043a.f2840a[this.t.ordinal()];
        if (i2 == 1) {
            this.f2837h.set(this.f2830a);
            RectF rectF = this.f2837h;
            float f2 = this.r;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            this.j.reset();
            this.j.setTranslate((int) (((this.f2837h.width() - this.f2835f) * 0.5f) + 0.5f), (int) (((this.f2837h.height() - this.f2836g) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f2837h.set(this.f2830a);
            RectF rectF2 = this.f2837h;
            float f3 = this.r;
            rectF2.inset(f3 / 2.0f, f3 / 2.0f);
            this.j.reset();
            float fWidth2 = 0.0f;
            if (this.f2835f * this.f2837h.height() > this.f2837h.width() * this.f2836g) {
                fWidth = this.f2837h.height() / this.f2836g;
                fWidth2 = (this.f2837h.width() - (this.f2835f * fWidth)) * 0.5f;
                fHeight = 0.0f;
            } else {
                fWidth = this.f2837h.width() / this.f2835f;
                fHeight = (this.f2837h.height() - (this.f2836g * fWidth)) * 0.5f;
            }
            this.j.setScale(fWidth, fWidth);
            Matrix matrix = this.j;
            float f4 = this.r;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f4 / 2.0f), ((int) (fHeight + 0.5f)) + (f4 / 2.0f));
        } else if (i2 == 3) {
            this.j.reset();
            float fMin = (((float) this.f2835f) > this.f2830a.width() || ((float) this.f2836g) > this.f2830a.height()) ? Math.min(this.f2830a.width() / this.f2835f, this.f2830a.height() / this.f2836g) : 1.0f;
            float fWidth3 = (int) (((this.f2830a.width() - (this.f2835f * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.f2830a.height() - (this.f2836g * fMin)) * 0.5f) + 0.5f);
            this.j.setScale(fMin, fMin);
            this.j.postTranslate(fWidth3, fHeight2);
            this.f2837h.set(this.f2832c);
            this.j.mapRect(this.f2837h);
            RectF rectF3 = this.f2837h;
            float f5 = this.r;
            rectF3.inset(f5 / 2.0f, f5 / 2.0f);
            this.j.setRectToRect(this.f2832c, this.f2837h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f2837h.set(this.f2832c);
            this.j.setRectToRect(this.f2832c, this.f2830a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.f2837h);
            RectF rectF4 = this.f2837h;
            float f6 = this.r;
            rectF4.inset(f6 / 2.0f, f6 / 2.0f);
            this.j.setRectToRect(this.f2832c, this.f2837h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f2837h.set(this.f2832c);
            this.j.setRectToRect(this.f2832c, this.f2830a, Matrix.ScaleToFit.START);
            this.j.mapRect(this.f2837h);
            RectF rectF5 = this.f2837h;
            float f7 = this.r;
            rectF5.inset(f7 / 2.0f, f7 / 2.0f);
            this.j.setRectToRect(this.f2832c, this.f2837h, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f2837h.set(this.f2832c);
            this.j.setRectToRect(this.f2832c, this.f2830a, Matrix.ScaleToFit.CENTER);
            this.j.mapRect(this.f2837h);
            RectF rectF6 = this.f2837h;
            float f8 = this.r;
            rectF6.inset(f8 / 2.0f, f8 / 2.0f);
            this.j.setRectToRect(this.f2832c, this.f2837h, Matrix.ScaleToFit.FILL);
        } else {
            this.f2837h.set(this.f2830a);
            RectF rectF7 = this.f2837h;
            float f9 = this.r;
            rectF7.inset(f9 / 2.0f, f9 / 2.0f);
            this.j.reset();
            this.j.setRectToRect(this.f2832c, this.f2837h, Matrix.ScaleToFit.FILL);
        }
        this.f2831b.set(this.f2837h);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2834e.getAlpha();
    }

    public int getBorderColor() {
        return this.s.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.s;
    }

    public float getBorderWidth() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f2834e.getColorFilter();
    }

    public float getCornerRadius() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2836g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2835f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ImageView.ScaleType getScaleType() {
        return this.t;
    }

    public Bitmap getSourceBitmap() {
        return this.f2833d;
    }

    public Shader.TileMode getTileModeX() {
        return this.l;
    }

    public Shader.TileMode getTileModeY() {
        return this.m;
    }

    public boolean isOval() {
        return this.f2839q;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f2830a.set(rect);
        f();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.f2838i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f2838i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f2834e.setAlpha(i2);
        invalidateSelf();
    }

    public a setBorderColor(@ColorInt int i2) {
        return setBorderColor(ColorStateList.valueOf(i2));
    }

    public a setBorderWidth(float f2) {
        this.r = f2;
        this.f2838i.setStrokeWidth(f2);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2834e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public a setCornerRadius(float f2) {
        setCornerRadius(f2, f2, f2, f2);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f2834e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f2834e.setFilterBitmap(z);
        invalidateSelf();
    }

    public a setOval(boolean z) {
        this.f2839q = z;
        return this;
    }

    public a setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            f();
        }
        return this;
    }

    public a setTileModeX(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public a setTileModeY(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public Bitmap toBitmap() {
        return drawableToBitmap(this);
    }

    public float getCornerRadius(int i2) {
        if (this.p[i2]) {
            return this.o;
        }
        return 0.0f;
    }

    public a setBorderColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.f2838i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public a setCornerRadius(int i2, float f2) {
        if (f2 != 0.0f) {
            float f3 = this.o;
            if (f3 != 0.0f && f3 != f2) {
                throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
            }
        }
        if (f2 == 0.0f) {
            if (c(i2, this.p)) {
                this.o = 0.0f;
            }
            this.p[i2] = false;
        } else {
            if (this.o == 0.0f) {
                this.o = f2;
            }
            this.p[i2] = true;
        }
        return this;
    }

    public a setCornerRadius(float f2, float f3, float f4, float f5) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f5));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(fFloatValue) && !Float.isNaN(fFloatValue) && fFloatValue >= 0.0f) {
                    this.o = fFloatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: " + fFloatValue);
                }
            } else {
                this.o = 0.0f;
            }
            boolean[] zArr = this.p;
            zArr[0] = f2 > 0.0f;
            zArr[1] = f3 > 0.0f;
            zArr[2] = f4 > 0.0f;
            zArr[3] = f5 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }
}
