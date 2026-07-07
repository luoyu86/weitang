package com.tianmu.biz.widget.roundimage;

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
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedDrawable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f11175a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f11176b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f11177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bitmap f11178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f11179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f11181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f11182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f11183i;
    private final Matrix j;
    private final RectF k;
    private Shader.TileMode l;
    private Shader.TileMode m;
    private boolean n;
    private float o;
    private final boolean[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f11184q;
    private float r;
    private ColorStateList s;
    private ImageView.ScaleType t;

    /* JADX INFO: renamed from: com.tianmu.biz.widget.roundimage.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0203a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11185a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f11185a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11185a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11185a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11185a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11185a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11185a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11185a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f11177c = rectF;
        this.f11182h = new RectF();
        this.j = new Matrix();
        this.k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = tileMode;
        this.m = tileMode;
        this.n = true;
        this.o = 0.0f;
        this.p = new boolean[]{true, true, true, true};
        this.f11184q = false;
        this.r = 0.0f;
        this.s = ColorStateList.valueOf(-16777216);
        this.t = ImageView.ScaleType.FIT_CENTER;
        this.f11178d = bitmap;
        int width = bitmap.getWidth();
        this.f11180f = width;
        int height = bitmap.getHeight();
        this.f11181g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f11179e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f11183i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.r);
    }

    public static a a(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    public static Drawable b(Drawable drawable) {
        if (drawable == null || (drawable instanceof a)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapA = a(drawable);
            return bitmapA != null ? new a(bitmapA) : drawable;
        }
        Drawable.ConstantState constantState = drawable.mutate().getConstantState();
        if (constantState != null) {
            drawable = constantState.newDrawable();
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), b(layerDrawable.getDrawable(i2)));
        }
        return layerDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.f11178d, this.l, this.m);
            Shader.TileMode tileMode = this.l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.f11179e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.f11184q) {
            if (this.r <= 0.0f) {
                canvas.drawOval(this.f11176b, this.f11179e);
                return;
            } else {
                canvas.drawOval(this.f11176b, this.f11179e);
                canvas.drawOval(this.f11182h, this.f11183i);
                return;
            }
        }
        if (!b(this.p)) {
            canvas.drawRect(this.f11176b, this.f11179e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.f11182h, this.f11183i);
                return;
            }
            return;
        }
        float f2 = this.o;
        if (this.r <= 0.0f) {
            canvas.drawRoundRect(this.f11176b, f2, f2, this.f11179e);
            a(canvas);
        } else {
            canvas.drawRoundRect(this.f11176b, f2, f2, this.f11179e);
            canvas.drawRoundRect(this.f11182h, f2, f2, this.f11183i);
            a(canvas);
            b(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f11179e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f11179e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11181g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11180f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f11175a.set(rect);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.f11183i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f11183i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f11179e.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f11179e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f11179e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f11179e.setFilterBitmap(z);
        invalidateSelf();
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.w(RoundedDrawable.TAG, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    private void b(Canvas canvas) {
        float f2;
        if (a(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.f11176b;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float fWidth = rectF.width() + f3;
        float fHeight = f4 + this.f11176b.height();
        float f5 = this.o;
        float f6 = this.r / 2.0f;
        if (!this.p[0]) {
            canvas.drawLine(f3 - f6, f4, f3 + f5, f4, this.f11183i);
            canvas.drawLine(f3, f4 - f6, f3, f4 + f5, this.f11183i);
        }
        if (!this.p[1]) {
            canvas.drawLine((fWidth - f5) - f6, f4, fWidth, f4, this.f11183i);
            canvas.drawLine(fWidth, f4 - f6, fWidth, f4 + f5, this.f11183i);
        }
        if (this.p[2]) {
            f2 = f5;
        } else {
            f2 = f5;
            canvas.drawLine((fWidth - f5) - f6, fHeight, fWidth + f6, fHeight, this.f11183i);
            canvas.drawLine(fWidth, fHeight - f2, fWidth, fHeight, this.f11183i);
        }
        if (this.p[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, fHeight, f3 + f2, fHeight, this.f11183i);
        canvas.drawLine(f3, fHeight - f2, f3, fHeight, this.f11183i);
    }

    private void a() {
        float fWidth;
        float fHeight;
        int i2 = C0203a.f11185a[this.t.ordinal()];
        if (i2 == 1) {
            this.f11182h.set(this.f11175a);
            RectF rectF = this.f11182h;
            float f2 = this.r / 2.0f;
            rectF.inset(f2, f2);
            this.j.reset();
            this.j.setTranslate((int) (((this.f11182h.width() - this.f11180f) * 0.5f) + 0.5f), (int) (((this.f11182h.height() - this.f11181g) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f11182h.set(this.f11175a);
            RectF rectF2 = this.f11182h;
            float f3 = this.r / 2.0f;
            rectF2.inset(f3, f3);
            this.j.reset();
            float fWidth2 = 0.0f;
            if (this.f11180f * this.f11182h.height() > this.f11182h.width() * this.f11181g) {
                fWidth = this.f11182h.height() / this.f11181g;
                fWidth2 = (this.f11182h.width() - (this.f11180f * fWidth)) * 0.5f;
                fHeight = 0.0f;
            } else {
                fWidth = this.f11182h.width() / this.f11180f;
                fHeight = (this.f11182h.height() - (this.f11181g * fWidth)) * 0.5f;
            }
            this.j.setScale(fWidth, fWidth);
            Matrix matrix = this.j;
            float f4 = this.r / 2.0f;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + f4, ((int) (fHeight + 0.5f)) + f4);
        } else if (i2 == 3) {
            this.j.reset();
            float fMin = (((float) this.f11180f) > this.f11175a.width() || ((float) this.f11181g) > this.f11175a.height()) ? Math.min(this.f11175a.width() / this.f11180f, this.f11175a.height() / this.f11181g) : 1.0f;
            float fWidth3 = (int) (((this.f11175a.width() - (this.f11180f * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.f11175a.height() - (this.f11181g * fMin)) * 0.5f) + 0.5f);
            this.j.setScale(fMin, fMin);
            this.j.postTranslate(fWidth3, fHeight2);
            this.f11182h.set(this.f11177c);
            this.j.mapRect(this.f11182h);
            RectF rectF3 = this.f11182h;
            float f5 = this.r / 2.0f;
            rectF3.inset(f5, f5);
            this.j.setRectToRect(this.f11177c, this.f11182h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f11182h.set(this.f11177c);
            this.j.setRectToRect(this.f11177c, this.f11175a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.f11182h);
            RectF rectF4 = this.f11182h;
            float f6 = this.r / 2.0f;
            rectF4.inset(f6, f6);
            this.j.setRectToRect(this.f11177c, this.f11182h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f11182h.set(this.f11177c);
            this.j.setRectToRect(this.f11177c, this.f11175a, Matrix.ScaleToFit.START);
            this.j.mapRect(this.f11182h);
            RectF rectF5 = this.f11182h;
            float f7 = this.r / 2.0f;
            rectF5.inset(f7, f7);
            this.j.setRectToRect(this.f11177c, this.f11182h, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f11182h.set(this.f11177c);
            this.j.setRectToRect(this.f11177c, this.f11175a, Matrix.ScaleToFit.CENTER);
            this.j.mapRect(this.f11182h);
            RectF rectF6 = this.f11182h;
            float f8 = this.r / 2.0f;
            rectF6.inset(f8, f8);
            this.j.setRectToRect(this.f11177c, this.f11182h, Matrix.ScaleToFit.FILL);
        } else {
            this.f11182h.set(this.f11175a);
            RectF rectF7 = this.f11182h;
            float f9 = this.r / 2.0f;
            rectF7.inset(f9, f9);
            this.j.reset();
            this.j.setRectToRect(this.f11177c, this.f11182h, Matrix.ScaleToFit.FILL);
        }
        this.f11176b.set(this.f11182h);
        this.n = true;
    }

    public a b(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private void a(Canvas canvas) {
        if (a(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.f11176b;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float fWidth = rectF.width() + f2;
        float fHeight = this.f11176b.height() + f3;
        float f4 = this.o;
        if (!this.p[0]) {
            this.k.set(f2, f3, f2 + f4, f3 + f4);
            canvas.drawRect(this.k, this.f11179e);
        }
        if (!this.p[1]) {
            this.k.set(fWidth - f4, f3, fWidth, f4);
            canvas.drawRect(this.k, this.f11179e);
        }
        if (!this.p[2]) {
            this.k.set(fWidth - f4, fHeight - f4, fWidth, fHeight);
            canvas.drawRect(this.k, this.f11179e);
        }
        if (this.p[3]) {
            return;
        }
        this.k.set(f2, fHeight - f4, f4 + f2, fHeight);
        canvas.drawRect(this.k, this.f11179e);
    }

    public a a(float f2, float f3, float f4, float f5) {
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

    public a a(float f2) {
        this.r = f2;
        this.f11183i.setStrokeWidth(f2);
        return this;
    }

    public a a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.f11183i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public a a(boolean z) {
        this.f11184q = z;
        return this;
    }

    public a a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            a();
        }
        return this;
    }

    public a a(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
