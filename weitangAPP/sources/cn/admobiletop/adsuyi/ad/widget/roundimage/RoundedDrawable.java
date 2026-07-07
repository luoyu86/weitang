package cn.admobiletop.adsuyi.ad.widget.roundimage;

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
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class RoundedDrawable extends Drawable {
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final String TAG = "RoundedDrawable";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f3594a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f3595b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f3596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f3597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f3598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f3601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f3602i;
    public final Matrix j;
    public final RectF k;
    public Shader.TileMode l;
    public Shader.TileMode m;
    public boolean n;
    public float o;
    public final boolean[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3603q;
    public float r;
    public ColorStateList s;
    public ImageView.ScaleType t;

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedDrawable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3604a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f3604a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3604a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3604a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3604a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3604a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3604a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3604a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedDrawable(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f3596c = rectF;
        this.f3601h = new RectF();
        this.j = new Matrix();
        this.k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = tileMode;
        this.m = tileMode;
        this.n = true;
        this.o = 0.0f;
        this.p = new boolean[]{true, true, true, true};
        this.f3603q = false;
        this.r = 0.0f;
        this.s = ColorStateList.valueOf(-16777216);
        this.t = ImageView.ScaleType.FIT_CENTER;
        this.f3597d = bitmap;
        int width = bitmap.getWidth();
        this.f3599f = width;
        int height = bitmap.getHeight();
        this.f3600g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f3598e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f3602i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.r);
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

    public static boolean d(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
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
        } catch (Throwable th) {
            th.printStackTrace();
            Log.w(TAG, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static boolean f(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static RoundedDrawable fromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new RoundedDrawable(bitmap);
        }
        return null;
    }

    public static Drawable fromDrawable(Drawable drawable) {
        if (drawable == null || (drawable instanceof RoundedDrawable)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
            return bitmapDrawableToBitmap != null ? new RoundedDrawable(bitmapDrawableToBitmap) : drawable;
        }
        Drawable.ConstantState constantState = drawable.mutate().getConstantState();
        if (constantState != null) {
            drawable = constantState.newDrawable();
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), fromDrawable(layerDrawable.getDrawable(i2)));
        }
        return layerDrawable;
    }

    public final void a() {
        float fWidth;
        float fHeight;
        int i2 = AnonymousClass1.f3604a[this.t.ordinal()];
        if (i2 == 1) {
            this.f3601h.set(this.f3594a);
            RectF rectF = this.f3601h;
            float f2 = this.r / 2.0f;
            rectF.inset(f2, f2);
            this.j.reset();
            this.j.setTranslate((int) (((this.f3601h.width() - this.f3599f) * 0.5f) + 0.5f), (int) (((this.f3601h.height() - this.f3600g) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f3601h.set(this.f3594a);
            RectF rectF2 = this.f3601h;
            float f3 = this.r / 2.0f;
            rectF2.inset(f3, f3);
            this.j.reset();
            float fWidth2 = 0.0f;
            if (this.f3599f * this.f3601h.height() > this.f3601h.width() * this.f3600g) {
                fWidth = this.f3601h.height() / this.f3600g;
                fWidth2 = (this.f3601h.width() - (this.f3599f * fWidth)) * 0.5f;
                fHeight = 0.0f;
            } else {
                fWidth = this.f3601h.width() / this.f3599f;
                fHeight = (this.f3601h.height() - (this.f3600g * fWidth)) * 0.5f;
            }
            this.j.setScale(fWidth, fWidth);
            Matrix matrix = this.j;
            float f4 = this.r / 2.0f;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + f4, ((int) (fHeight + 0.5f)) + f4);
        } else if (i2 == 3) {
            this.j.reset();
            float fMin = (((float) this.f3599f) > this.f3594a.width() || ((float) this.f3600g) > this.f3594a.height()) ? Math.min(this.f3594a.width() / this.f3599f, this.f3594a.height() / this.f3600g) : 1.0f;
            float fWidth3 = (int) (((this.f3594a.width() - (this.f3599f * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.f3594a.height() - (this.f3600g * fMin)) * 0.5f) + 0.5f);
            this.j.setScale(fMin, fMin);
            this.j.postTranslate(fWidth3, fHeight2);
            this.f3601h.set(this.f3596c);
            this.j.mapRect(this.f3601h);
            RectF rectF3 = this.f3601h;
            float f5 = this.r / 2.0f;
            rectF3.inset(f5, f5);
            this.j.setRectToRect(this.f3596c, this.f3601h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f3601h.set(this.f3596c);
            this.j.setRectToRect(this.f3596c, this.f3594a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.f3601h);
            RectF rectF4 = this.f3601h;
            float f6 = this.r / 2.0f;
            rectF4.inset(f6, f6);
            this.j.setRectToRect(this.f3596c, this.f3601h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f3601h.set(this.f3596c);
            this.j.setRectToRect(this.f3596c, this.f3594a, Matrix.ScaleToFit.START);
            this.j.mapRect(this.f3601h);
            RectF rectF5 = this.f3601h;
            float f7 = this.r / 2.0f;
            rectF5.inset(f7, f7);
            this.j.setRectToRect(this.f3596c, this.f3601h, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f3601h.set(this.f3596c);
            this.j.setRectToRect(this.f3596c, this.f3594a, Matrix.ScaleToFit.CENTER);
            this.j.mapRect(this.f3601h);
            RectF rectF6 = this.f3601h;
            float f8 = this.r / 2.0f;
            rectF6.inset(f8, f8);
            this.j.setRectToRect(this.f3596c, this.f3601h, Matrix.ScaleToFit.FILL);
        } else {
            this.f3601h.set(this.f3594a);
            RectF rectF7 = this.f3601h;
            float f9 = this.r / 2.0f;
            rectF7.inset(f9, f9);
            this.j.reset();
            this.j.setRectToRect(this.f3596c, this.f3601h, Matrix.ScaleToFit.FILL);
        }
        this.f3595b.set(this.f3601h);
        this.n = true;
    }

    public final void b(Canvas canvas) {
        if (d(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.f3595b;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float fWidth = rectF.width() + f2;
        float fHeight = this.f3595b.height() + f3;
        float f4 = this.o;
        if (!this.p[0]) {
            this.k.set(f2, f3, f2 + f4, f3 + f4);
            canvas.drawRect(this.k, this.f3598e);
        }
        if (!this.p[1]) {
            this.k.set(fWidth - f4, f3, fWidth, f4);
            canvas.drawRect(this.k, this.f3598e);
        }
        if (!this.p[2]) {
            this.k.set(fWidth - f4, fHeight - f4, fWidth, fHeight);
            canvas.drawRect(this.k, this.f3598e);
        }
        if (this.p[3]) {
            return;
        }
        this.k.set(f2, fHeight - f4, f4 + f2, fHeight);
        canvas.drawRect(this.k, this.f3598e);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.f3597d, this.l, this.m);
            Shader.TileMode tileMode = this.l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.f3598e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.f3603q) {
            if (this.r <= 0.0f) {
                canvas.drawOval(this.f3595b, this.f3598e);
                return;
            } else {
                canvas.drawOval(this.f3595b, this.f3598e);
                canvas.drawOval(this.f3601h, this.f3602i);
                return;
            }
        }
        if (!f(this.p)) {
            canvas.drawRect(this.f3595b, this.f3598e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.f3601h, this.f3602i);
                return;
            }
            return;
        }
        float f2 = this.o;
        if (this.r <= 0.0f) {
            canvas.drawRoundRect(this.f3595b, f2, f2, this.f3598e);
            b(canvas);
        } else {
            canvas.drawRoundRect(this.f3595b, f2, f2, this.f3598e);
            canvas.drawRoundRect(this.f3601h, f2, f2, this.f3602i);
            b(canvas);
            e(canvas);
        }
    }

    public final void e(Canvas canvas) {
        float f2;
        if (d(this.p) || this.o == 0.0f) {
            return;
        }
        RectF rectF = this.f3595b;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float fWidth = rectF.width() + f3;
        float fHeight = f4 + this.f3595b.height();
        float f5 = this.o;
        float f6 = this.r / 2.0f;
        if (!this.p[0]) {
            canvas.drawLine(f3 - f6, f4, f3 + f5, f4, this.f3602i);
            canvas.drawLine(f3, f4 - f6, f3, f4 + f5, this.f3602i);
        }
        if (!this.p[1]) {
            canvas.drawLine((fWidth - f5) - f6, f4, fWidth, f4, this.f3602i);
            canvas.drawLine(fWidth, f4 - f6, fWidth, f4 + f5, this.f3602i);
        }
        if (this.p[2]) {
            f2 = f5;
        } else {
            f2 = f5;
            canvas.drawLine((fWidth - f5) - f6, fHeight, fWidth + f6, fHeight, this.f3602i);
            canvas.drawLine(fWidth, fHeight - f2, fWidth, fHeight, this.f3602i);
        }
        if (this.p[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, fHeight, f3 + f2, fHeight, this.f3602i);
        canvas.drawLine(f3, fHeight - f2, f3, fHeight, this.f3602i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3598e.getAlpha();
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
        return this.f3598e.getColorFilter();
    }

    public float getCornerRadius() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3600g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3599f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ImageView.ScaleType getScaleType() {
        return this.t;
    }

    public Bitmap getSourceBitmap() {
        return this.f3597d;
    }

    public Shader.TileMode getTileModeX() {
        return this.l;
    }

    public Shader.TileMode getTileModeY() {
        return this.m;
    }

    public boolean isOval() {
        return this.f3603q;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f3594a.set(rect);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.f3602i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f3602i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f3598e.setAlpha(i2);
        invalidateSelf();
    }

    public RoundedDrawable setBorderColor(@ColorInt int i2) {
        return setBorderColor(ColorStateList.valueOf(i2));
    }

    public RoundedDrawable setBorderWidth(float f2) {
        this.r = f2;
        this.f3602i.setStrokeWidth(f2);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3598e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public RoundedDrawable setCornerRadius(float f2) {
        setCornerRadius(f2, f2, f2, f2);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f3598e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f3598e.setFilterBitmap(z);
        invalidateSelf();
    }

    public RoundedDrawable setOval(boolean z) {
        this.f3603q = z;
        return this;
    }

    public RoundedDrawable setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            a();
        }
        return this;
    }

    public RoundedDrawable setTileModeX(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public RoundedDrawable setTileModeY(Shader.TileMode tileMode) {
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

    public RoundedDrawable setBorderColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.f3602i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public RoundedDrawable setCornerRadius(int i2, float f2) {
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

    public RoundedDrawable setCornerRadius(float f2, float f3, float f4, float f5) {
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
