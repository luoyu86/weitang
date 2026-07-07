package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;

/* JADX INFO: loaded from: classes2.dex */
public class RoundedImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Shader.TileMode f9475a = Shader.TileMode.CLAMP;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImageView.ScaleType[] f9476b = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f9477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f9478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f9479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f9480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorFilter f9481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f9483i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public ImageView.ScaleType o;
    public Shader.TileMode p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Shader.TileMode f9484q;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9485a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f9485a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9485a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9485a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9485a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9485a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9485a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9485a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.f9477c = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f9479e = ColorStateList.valueOf(-16777216);
        this.f9480f = 0.0f;
        this.f9481g = null;
        this.f9482h = false;
        this.j = false;
        this.k = false;
        this.l = false;
        Shader.TileMode tileMode = f9475a;
        this.p = tileMode;
        this.f9484q = tileMode;
    }

    public static Shader.TileMode b(int i2) {
        if (i2 == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i2 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i2 != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    public final void a() {
        Drawable drawable = this.f9483i;
        if (drawable == null || !this.f9482h) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f9483i = drawableMutate;
        if (this.j) {
            drawableMutate.setColorFilter(this.f9481g);
        }
    }

    public final Drawable c() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.n;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w(cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedImageView.TAG, "Unable to find resource: " + this.n, e2);
                this.n = 0;
            }
        }
        return c.l.a.a.fromDrawable(drawable);
    }

    public final Drawable d() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.m;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w(cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedImageView.TAG, "Unable to find resource: " + this.m, e2);
                this.m = 0;
            }
        }
        return c.l.a.a.fromDrawable(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public final void e(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof c.l.a.a) {
            c.l.a.a aVar = (c.l.a.a) drawable;
            aVar.setScaleType(scaleType).setBorderWidth(this.f9480f).setBorderColor(this.f9479e).setOval(this.k).setTileModeX(this.p).setTileModeY(this.f9484q);
            float[] fArr = this.f9477c;
            if (fArr != null) {
                aVar.setCornerRadius(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            a();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                e(layerDrawable.getDrawable(i2), scaleType);
            }
        }
    }

    public final void f(boolean z) {
        if (this.l) {
            if (z) {
                this.f9478d = c.l.a.a.fromDrawable(this.f9478d);
            }
            e(this.f9478d, ImageView.ScaleType.FIT_XY);
        }
    }

    public final void g() {
        e(this.f9483i, this.o);
    }

    @ColorInt
    public int getBorderColor() {
        return this.f9479e.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f9479e;
    }

    public float getBorderWidth() {
        return this.f9480f;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f2 : this.f9477c) {
            fMax = Math.max(f2, fMax);
        }
        return fMax;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.o;
    }

    public Shader.TileMode getTileModeX() {
        return this.p;
    }

    public Shader.TileMode getTileModeY() {
        return this.f9484q;
    }

    public boolean isOval() {
        return this.k;
    }

    public void mutateBackground(boolean z) {
        if (this.l == z) {
            return;
        }
        this.l = z;
        f(true);
        invalidate();
    }

    public boolean mutatesBackground() {
        return this.l;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        this.f9478d = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f9478d = drawable;
        f(true);
        super.setBackgroundDrawable(this.f9478d);
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        if (this.n != i2) {
            this.n = i2;
            Drawable drawableC = c();
            this.f9478d = drawableC;
            setBackgroundDrawable(drawableC);
        }
    }

    public void setBorderColor(@ColorInt int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public void setBorderWidth(@DimenRes int i2) {
        setBorderWidth(getResources().getDimension(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f9481g != colorFilter) {
            this.f9481g = colorFilter;
            this.j = true;
            this.f9482h = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f2) {
        setCornerRadius(f2, f2, f2, f2);
    }

    public void setCornerRadiusDimen(@DimenRes int i2) {
        float dimension = getResources().getDimension(i2);
        setCornerRadius(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.m = 0;
        this.f9483i = c.l.a.a.fromBitmap(bitmap);
        g();
        super.setImageDrawable(this.f9483i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.m = 0;
        this.f9483i = c.l.a.a.fromDrawable(drawable);
        g();
        super.setImageDrawable(this.f9483i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        if (this.m != i2) {
            this.m = i2;
            this.f9483i = d();
            g();
            super.setImageDrawable(this.f9483i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.k = z;
        g();
        f(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.o != scaleType) {
            this.o = scaleType;
            switch (a.f9485a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            g();
            f(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.p == tileMode) {
            return;
        }
        this.p = tileMode;
        g();
        f(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.f9484q == tileMode) {
            return;
        }
        this.f9484q = tileMode;
        g();
        f(false);
        invalidate();
    }

    public float getCornerRadius(int i2) {
        return this.f9477c[i2];
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f9479e.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f9479e = colorStateList;
        g();
        f(false);
        if (this.f9480f > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f2) {
        if (this.f9480f == f2) {
            return;
        }
        this.f9480f = f2;
        g();
        f(false);
        invalidate();
    }

    public void setCornerRadius(int i2, float f2) {
        float[] fArr = this.f9477c;
        if (fArr[i2] == f2) {
            return;
        }
        fArr[i2] = f2;
        g();
        f(false);
        invalidate();
    }

    public void setCornerRadiusDimen(int i2, @DimenRes int i3) {
        setCornerRadius(i2, getResources().getDimensionPixelSize(i3));
    }

    public void setCornerRadius(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f9477c;
        if (fArr[0] == f2 && fArr[1] == f3 && fArr[2] == f5 && fArr[3] == f4) {
            return;
        }
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[3] = f4;
        fArr[2] = f5;
        g();
        f(false);
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.f9477c = fArr;
        this.f9479e = ColorStateList.valueOf(-16777216);
        this.f9480f = 0.0f;
        this.f9481g = null;
        this.f9482h = false;
        this.j = false;
        this.k = false;
        this.l = false;
        Shader.TileMode tileMode = f9475a;
        this.p = tileMode;
        this.f9484q = tileMode;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageView, i2, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
        if (i3 >= 0) {
            setScaleType(f9476b[i3]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius, -1);
        fArr[0] = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_left, -1);
        fArr[1] = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_right, -1);
        fArr[2] = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_right, -1);
        fArr[3] = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_left, -1);
        int length = fArr.length;
        boolean z = false;
        for (int i4 = 0; i4 < length; i4++) {
            float[] fArr2 = this.f9477c;
            if (fArr2[i4] < 0.0f) {
                fArr2[i4] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.f9477c.length;
            for (int i5 = 0; i5 < length2; i5++) {
                this.f9477c[i5] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_border_width, -1);
        this.f9480f = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.f9480f = 0.0f;
        }
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.RoundedImageView_riv_border_color);
        this.f9479e = colorStateList;
        if (colorStateList == null) {
            this.f9479e = ColorStateList.valueOf(-16777216);
        }
        this.l = typedArrayObtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_riv_mutate_background, false);
        this.k = typedArrayObtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_riv_oval, false);
        int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode, -2);
        if (i6 != -2) {
            setTileModeX(b(i6));
            setTileModeY(b(i6));
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode_x, -2);
        if (i7 != -2) {
            setTileModeX(b(i7));
        }
        int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode_y, -2);
        if (i8 != -2) {
            setTileModeY(b(i8));
        }
        g();
        f(true);
        if (this.l) {
            super.setBackgroundDrawable(this.f9478d);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
