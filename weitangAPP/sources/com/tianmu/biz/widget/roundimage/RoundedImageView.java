package com.tianmu.biz.widget.roundimage;

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
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes2.dex */
public class RoundedImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f11165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f11166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f11167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f11168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorFilter f11169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f11171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11173i;
    private boolean j;
    private int k;
    private int l;
    private ImageView.ScaleType m;
    private Shader.TileMode n;
    private Shader.TileMode o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ boolean f11164q = true;
    public static final Shader.TileMode p = Shader.TileMode.CLAMP;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11174a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f11174a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11174a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11174a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11174a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11174a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11174a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11174a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.FIT_XY;
        ImageView.ScaleType scaleType3 = ImageView.ScaleType.FIT_START;
        ImageView.ScaleType scaleType4 = ImageView.ScaleType.FIT_CENTER;
        ImageView.ScaleType scaleType5 = ImageView.ScaleType.FIT_END;
        ImageView.ScaleType scaleType6 = ImageView.ScaleType.CENTER;
        ImageView.ScaleType scaleType7 = ImageView.ScaleType.CENTER_CROP;
        ImageView.ScaleType scaleType8 = ImageView.ScaleType.CENTER_INSIDE;
    }

    public RoundedImageView(Context context) {
        super(context);
        this.f11165a = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f11167c = ColorStateList.valueOf(-16777216);
        this.f11168d = 0.0f;
        this.f11169e = null;
        this.f11170f = false;
        this.f11172h = false;
        this.f11173i = false;
        this.j = false;
        this.m = ImageView.ScaleType.CENTER_CROP;
        Shader.TileMode tileMode = p;
        this.n = tileMode;
        this.o = tileMode;
    }

    private void a(boolean z) {
        if (this.j) {
            if (z) {
                this.f11166b = com.tianmu.biz.widget.roundimage.a.b(this.f11166b);
            }
            a(this.f11166b, ImageView.ScaleType.FIT_XY);
        }
    }

    private Drawable b() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.l;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w(cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedImageView.TAG, "Unable to find resource: " + this.l, e2);
                this.l = 0;
            }
        }
        return com.tianmu.biz.widget.roundimage.a.b(drawable);
    }

    private Drawable c() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.k;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w(cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedImageView.TAG, "Unable to find resource: " + this.k, e2);
                this.k = 0;
            }
        }
        return com.tianmu.biz.widget.roundimage.a.b(drawable);
    }

    private void d() {
        a(this.f11171g, this.m);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.m;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        this.f11166b = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f11166b = drawable;
        a(true);
        super.setBackgroundDrawable(this.f11166b);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        if (this.l != i2) {
            this.l = i2;
            Drawable drawableB = b();
            this.f11166b = drawableB;
            setBackgroundDrawable(drawableB);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f11169e != colorFilter) {
            this.f11169e = colorFilter;
            this.f11172h = true;
            this.f11170f = true;
            a();
            invalidate();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.k = 0;
        this.f11171g = com.tianmu.biz.widget.roundimage.a.a(bitmap);
        d();
        super.setImageDrawable(this.f11171g);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.k = 0;
        this.f11171g = com.tianmu.biz.widget.roundimage.a.b(drawable);
        d();
        super.setImageDrawable(this.f11171g);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        if (this.k != i2) {
            this.k = i2;
            this.f11171g = c();
            d();
            super.setImageDrawable(this.f11171g);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!f11164q && scaleType == null) {
            throw new AssertionError();
        }
        if (this.m != scaleType) {
            this.m = scaleType;
            switch (a.f11174a[scaleType.ordinal()]) {
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
            d();
            a(false);
            invalidate();
        }
    }

    private void a() {
        Drawable drawable = this.f11171g;
        if (drawable == null || !this.f11170f) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f11171g = drawableMutate;
        if (this.f11172h) {
            drawableMutate.setColorFilter(this.f11169e);
        }
    }

    private void a(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof com.tianmu.biz.widget.roundimage.a) {
            com.tianmu.biz.widget.roundimage.a aVar = (com.tianmu.biz.widget.roundimage.a) drawable;
            aVar.a(scaleType).a(this.f11168d).a(this.f11167c).a(this.f11173i).a(this.n).b(this.o);
            float[] fArr = this.f11165a;
            if (fArr != null) {
                aVar.a(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            a();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                a(layerDrawable.getDrawable(i2), scaleType);
            }
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11165a = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f11167c = ColorStateList.valueOf(-16777216);
        this.f11168d = 0.0f;
        this.f11169e = null;
        this.f11170f = false;
        this.f11172h = false;
        this.f11173i = false;
        this.j = false;
        this.m = ImageView.ScaleType.CENTER_CROP;
        Shader.TileMode tileMode = p;
        this.n = tileMode;
        this.o = tileMode;
    }

    public void a(float f2) {
        a(f2, f2, f2, f2);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f11165a;
        if (fArr[0] == f2 && fArr[1] == f3 && fArr[2] == f5 && fArr[3] == f4) {
            return;
        }
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[3] = f4;
        fArr[2] = f5;
        d();
        a(false);
        invalidate();
    }
}
