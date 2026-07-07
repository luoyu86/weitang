package cn.admobiletop.adsuyi.ad.widget.roundimage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
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

/* JADX INFO: loaded from: classes.dex */
public class RoundedImageView extends ImageView {
    public static final float DEFAULT_BORDER_WIDTH = 0.0f;
    public static final float DEFAULT_RADIUS = 0.0f;
    public static final String TAG = "RoundedImageView";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f3607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f3608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f3609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorFilter f3611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f3613i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public ImageView.ScaleType o;
    public Shader.TileMode p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Shader.TileMode f3614q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f3606b = true;
    public static final Shader.TileMode DEFAULT_TILE_MODE = Shader.TileMode.CLAMP;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageView.ScaleType[] f3605a = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedImageView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3615a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f3615a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3615a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3615a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3615a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3615a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3615a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3615a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.f3607c = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f3609e = ColorStateList.valueOf(-16777216);
        this.f3610f = 0.0f;
        this.f3611g = null;
        this.f3612h = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.o = ImageView.ScaleType.CENTER_CROP;
        Shader.TileMode tileMode = DEFAULT_TILE_MODE;
        this.p = tileMode;
        this.f3614q = tileMode;
    }

    public final void a() {
        Drawable drawable = this.f3613i;
        if (drawable == null || !this.f3612h) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f3613i = drawableMutate;
        if (this.j) {
            drawableMutate.setColorFilter(this.f3611g);
        }
    }

    public final void b(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof RoundedDrawable) {
            RoundedDrawable roundedDrawable = (RoundedDrawable) drawable;
            roundedDrawable.setScaleType(scaleType).setBorderWidth(this.f3610f).setBorderColor(this.f3609e).setOval(this.k).setTileModeX(this.p).setTileModeY(this.f3614q);
            float[] fArr = this.f3607c;
            if (fArr != null) {
                roundedDrawable.setCornerRadius(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            a();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                b(layerDrawable.getDrawable(i2), scaleType);
            }
        }
    }

    public final void c(boolean z) {
        if (this.l) {
            if (z) {
                this.f3608d = RoundedDrawable.fromDrawable(this.f3608d);
            }
            b(this.f3608d, ImageView.ScaleType.FIT_XY);
        }
    }

    public final Drawable d() {
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
                Log.w(TAG, "Unable to find resource: " + this.n, e2);
                this.n = 0;
            }
        }
        return RoundedDrawable.fromDrawable(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public final Drawable e() {
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
                Log.w(TAG, "Unable to find resource: " + this.m, e2);
                this.m = 0;
            }
        }
        return RoundedDrawable.fromDrawable(drawable);
    }

    public final void f() {
        b(this.f3613i, this.o);
    }

    @ColorInt
    public int getBorderColor() {
        return this.f3609e.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f3609e;
    }

    public float getBorderWidth() {
        return this.f3610f;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f2 : this.f3607c) {
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
        return this.f3614q;
    }

    public boolean isOval() {
        return this.k;
    }

    public void mutateBackground(boolean z) {
        if (this.l == z) {
            return;
        }
        this.l = z;
        c(true);
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
        this.f3608d = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f3608d = drawable;
        c(true);
        super.setBackgroundDrawable(this.f3608d);
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        if (this.n != i2) {
            this.n = i2;
            Drawable drawableD = d();
            this.f3608d = drawableD;
            setBackgroundDrawable(drawableD);
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
        if (this.f3611g != colorFilter) {
            this.f3611g = colorFilter;
            this.j = true;
            this.f3612h = true;
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
        this.f3613i = RoundedDrawable.fromBitmap(bitmap);
        f();
        super.setImageDrawable(this.f3613i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.m = 0;
        this.f3613i = RoundedDrawable.fromDrawable(drawable);
        f();
        super.setImageDrawable(this.f3613i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        if (this.m != i2) {
            this.m = i2;
            this.f3613i = e();
            f();
            super.setImageDrawable(this.f3613i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.k = z;
        f();
        c(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!f3606b && scaleType == null) {
            throw new AssertionError();
        }
        if (this.o != scaleType) {
            this.o = scaleType;
            switch (AnonymousClass1.f3615a[scaleType.ordinal()]) {
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
            f();
            c(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.p == tileMode) {
            return;
        }
        this.p = tileMode;
        f();
        c(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.f3614q == tileMode) {
            return;
        }
        this.f3614q = tileMode;
        f();
        c(false);
        invalidate();
    }

    public float getCornerRadius(int i2) {
        return this.f3607c[i2];
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f3609e.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f3609e = colorStateList;
        f();
        c(false);
        if (this.f3610f > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f2) {
        if (this.f3610f == f2) {
            return;
        }
        this.f3610f = f2;
        f();
        c(false);
        invalidate();
    }

    public void setCornerRadius(int i2, float f2) {
        float[] fArr = this.f3607c;
        if (fArr[i2] == f2) {
            return;
        }
        fArr[i2] = f2;
        f();
        c(false);
        invalidate();
    }

    public void setCornerRadiusDimen(int i2, @DimenRes int i3) {
        setCornerRadius(i2, getResources().getDimensionPixelSize(i3));
    }

    public void setCornerRadius(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f3607c;
        if (fArr[0] == f2 && fArr[1] == f3 && fArr[2] == f5 && fArr[3] == f4) {
            return;
        }
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[3] = f4;
        fArr[2] = f5;
        f();
        c(false);
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3607c = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f3609e = ColorStateList.valueOf(-16777216);
        this.f3610f = 0.0f;
        this.f3611g = null;
        this.f3612h = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.o = ImageView.ScaleType.CENTER_CROP;
        Shader.TileMode tileMode = DEFAULT_TILE_MODE;
        this.p = tileMode;
        this.f3614q = tileMode;
    }
}
