package com.github.gcacace.signaturepad.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.ActivityChooserView;
import c.h.a.a.a.c;
import c.h.a.a.a.f;
import com.github.gcacace.signaturepad.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SignaturePad extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<f> f8906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f8909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f8910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f8911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f8912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f8913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<f> f8914i;
    public c.h.a.a.a.b j;
    public c.h.a.a.a.a k;
    public int l;
    public int m;
    public float n;
    public b o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f8915q;
    public int r;
    public final int s;
    public final int t;
    public final int u;
    public final float v;
    public final boolean w;
    public Paint x;
    public Bitmap y;
    public Canvas z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f8916a;

        public a(Bitmap bitmap) {
            this.f8916a = bitmap;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.h.a.a.b.b.removeOnGlobalLayoutListener(SignaturePad.this.getViewTreeObserver(), this);
            SignaturePad.this.setSignatureBitmap(this.f8916a);
        }
    }

    public interface b {
        void onClear();

        void onSigned();

        void onStartSigning();
    }

    public SignaturePad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8913h = new c();
        this.f8914i = new ArrayList();
        this.j = new c.h.a.a.a.b();
        this.k = new c.h.a.a.a.a();
        this.s = 3;
        this.t = 7;
        this.u = -16777216;
        this.v = 0.9f;
        this.w = false;
        this.x = new Paint();
        this.y = null;
        this.z = null;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SignaturePad, 0, 0);
        try {
            this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SignaturePad_penMinWidth, d(3.0f));
            this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SignaturePad_penMaxWidth, d(7.0f));
            this.x.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.SignaturePad_penColor, -16777216));
            this.n = typedArrayObtainStyledAttributes.getFloat(R.styleable.SignaturePad_velocityFilterWeight, 0.9f);
            this.p = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SignaturePad_clearOnDoubleClick, false);
            typedArrayObtainStyledAttributes.recycle();
            this.x.setAntiAlias(true);
            this.x.setStyle(Paint.Style.STROKE);
            this.x.setStrokeCap(Paint.Cap.ROUND);
            this.x.setStrokeJoin(Paint.Join.ROUND);
            this.f8912g = new RectF();
            clear();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void setIsEmpty(boolean z) {
        this.f8907b = z;
        b bVar = this.o;
        if (bVar != null) {
            if (z) {
                bVar.onClear();
            } else {
                bVar.onSigned();
            }
        }
    }

    public final void a(c.h.a.a.a.a aVar, float f2, float f3) {
        this.f8913h.append(aVar, (f2 + f3) / 2.0f);
        e();
        float strokeWidth = this.x.getStrokeWidth();
        float f4 = f3 - f2;
        float fFloor = (float) Math.floor(aVar.length());
        int i2 = 0;
        while (true) {
            float f5 = i2;
            if (f5 >= fFloor) {
                this.x.setStrokeWidth(strokeWidth);
                return;
            }
            float f6 = f5 / fFloor;
            float f7 = f6 * f6;
            float f8 = f7 * f6;
            float f9 = 1.0f - f6;
            float f10 = f9 * f9;
            float f11 = f10 * f9;
            f fVar = aVar.f2528a;
            float f12 = fVar.f2544a * f11;
            float f13 = f10 * 3.0f * f6;
            f fVar2 = aVar.f2529b;
            float f14 = f12 + (fVar2.f2544a * f13);
            float f15 = f9 * 3.0f * f7;
            f fVar3 = aVar.f2530c;
            float f16 = f14 + (fVar3.f2544a * f15);
            f fVar4 = aVar.f2531d;
            float f17 = f16 + (fVar4.f2544a * f8);
            float f18 = (f11 * fVar.f2545b) + (f13 * fVar2.f2545b) + (f15 * fVar3.f2545b) + (fVar4.f2545b * f8);
            this.x.setStrokeWidth(f2 + (f8 * f4));
            this.z.drawPoint(f17, f18, this.x);
            f(f17, f18);
            i2++;
        }
    }

    public final void b(f fVar) {
        this.f8906a.add(fVar);
        int size = this.f8906a.size();
        if (size <= 3) {
            if (size == 1) {
                f fVar2 = this.f8906a.get(0);
                this.f8906a.add(g(fVar2.f2544a, fVar2.f2545b));
                return;
            }
            return;
        }
        c.h.a.a.a.b bVarC = c(this.f8906a.get(0), this.f8906a.get(1), this.f8906a.get(2));
        f fVar3 = bVarC.f2533b;
        i(bVarC.f2532a);
        c.h.a.a.a.b bVarC2 = c(this.f8906a.get(1), this.f8906a.get(2), this.f8906a.get(3));
        f fVar4 = bVarC2.f2532a;
        i(bVarC2.f2533b);
        c.h.a.a.a.a aVar = this.k.set(this.f8906a.get(1), fVar3, fVar4, this.f8906a.get(2));
        float fVelocityFrom = aVar.f2531d.velocityFrom(aVar.f2528a);
        if (Float.isNaN(fVelocityFrom)) {
            fVelocityFrom = 0.0f;
        }
        float f2 = this.n;
        float f3 = (fVelocityFrom * f2) + ((1.0f - f2) * this.f8910e);
        float fK = k(f3);
        a(aVar, this.f8911f, fK);
        this.f8910e = f3;
        this.f8911f = fK;
        i(this.f8906a.remove(0));
        i(fVar3);
        i(fVar4);
    }

    public final c.h.a.a.a.b c(f fVar, f fVar2, f fVar3) {
        float f2 = fVar.f2544a;
        float f3 = fVar2.f2544a;
        float f4 = f2 - f3;
        float f5 = fVar.f2545b;
        float f6 = fVar2.f2545b;
        float f7 = f5 - f6;
        float f8 = fVar3.f2544a;
        float f9 = f3 - f8;
        float f10 = fVar3.f2545b;
        float f11 = f6 - f10;
        float f12 = (f2 + f3) / 2.0f;
        float f13 = (f5 + f6) / 2.0f;
        float f14 = (f3 + f8) / 2.0f;
        float f15 = (f6 + f10) / 2.0f;
        float fSqrt = (float) Math.sqrt((f4 * f4) + (f7 * f7));
        float fSqrt2 = (float) Math.sqrt((f9 * f9) + (f11 * f11));
        float f16 = f12 - f14;
        float f17 = f13 - f15;
        float f18 = fSqrt2 / (fSqrt + fSqrt2);
        if (Float.isNaN(f18)) {
            f18 = 0.0f;
        }
        float f19 = fVar2.f2544a - ((f16 * f18) + f14);
        float f20 = fVar2.f2545b - ((f17 * f18) + f15);
        return this.j.set(g(f12 + f19, f13 + f20), g(f14 + f19, f15 + f20));
    }

    public void clear() {
        this.f8913h.clear();
        this.f8906a = new ArrayList();
        this.f8910e = 0.0f;
        this.f8911f = (this.l + this.m) / 2;
        if (this.y != null) {
            this.y = null;
            e();
        }
        setIsEmpty(true);
        invalidate();
    }

    public final int d(float f2) {
        return Math.round(getContext().getResources().getDisplayMetrics().density * f2);
    }

    public final void e() {
        if (this.y == null) {
            this.y = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.z = new Canvas(this.y);
        }
    }

    public final void f(float f2, float f3) {
        RectF rectF = this.f8912g;
        if (f2 < rectF.left) {
            rectF.left = f2;
        } else if (f2 > rectF.right) {
            rectF.right = f2;
        }
        if (f3 < rectF.top) {
            rectF.top = f3;
        } else if (f3 > rectF.bottom) {
            rectF.bottom = f3;
        }
    }

    public final f g(float f2, float f3) {
        int size = this.f8914i.size();
        return (size == 0 ? new f() : this.f8914i.remove(size - 1)).set(f2, f3);
    }

    public Bitmap getSignatureBitmap() {
        Bitmap transparentSignatureBitmap = getTransparentSignatureBitmap();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(transparentSignatureBitmap.getWidth(), transparentSignatureBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(transparentSignatureBitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapCreateBitmap;
    }

    public String getSignatureSvg() {
        return this.f8913h.build(getTransparentSignatureBitmap().getWidth(), getTransparentSignatureBitmap().getHeight());
    }

    public Bitmap getTransparentSignatureBitmap() {
        e();
        return this.y;
    }

    public final boolean h() {
        if (this.p) {
            if (this.f8915q != 0 && System.currentTimeMillis() - this.f8915q > 200) {
                this.r = 0;
            }
            int i2 = this.r + 1;
            this.r = i2;
            if (i2 == 1) {
                this.f8915q = System.currentTimeMillis();
            } else if (i2 == 2 && System.currentTimeMillis() - this.f8915q < 200) {
                clear();
                return true;
            }
        }
        return false;
    }

    public final void i(f fVar) {
        this.f8914i.add(fVar);
    }

    public boolean isEmpty() {
        return this.f8907b;
    }

    public final void j(float f2, float f3) {
        this.f8912g.left = Math.min(this.f8908c, f2);
        this.f8912g.right = Math.max(this.f8908c, f2);
        this.f8912g.top = Math.min(this.f8909d, f3);
        this.f8912g.bottom = Math.max(this.f8909d, f3);
    }

    public final float k(float f2) {
        return Math.max(this.m / (f2 + 1.0f), this.l);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.y;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.x);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f8906a.clear();
            if (!h()) {
                this.f8908c = x;
                this.f8909d = y;
                b(g(x, y));
                b bVar = this.o;
                if (bVar != null) {
                    bVar.onStartSigning();
                }
                j(x, y);
                b(g(x, y));
            }
        } else if (action != 1) {
            if (action != 2) {
                return false;
            }
            j(x, y);
            b(g(x, y));
        } else {
            j(x, y);
            b(g(x, y));
            getParent().requestDisallowInterceptTouchEvent(true);
            setIsEmpty(false);
        }
        RectF rectF = this.f8912g;
        float f2 = rectF.left;
        int i2 = this.m;
        invalidate((int) (f2 - i2), (int) (rectF.top - i2), (int) (rectF.right + i2), (int) (rectF.bottom + i2));
        return true;
    }

    public void setMaxWidth(float f2) {
        this.m = d(f2);
    }

    public void setMinWidth(float f2) {
        this.l = d(f2);
    }

    public void setOnSignedListener(b bVar) {
        this.o = bVar;
    }

    public void setPenColor(int i2) {
        this.x.setColor(i2);
    }

    public void setPenColorRes(int i2) {
        try {
            setPenColor(getResources().getColor(i2));
        } catch (Resources.NotFoundException unused) {
            setPenColor(Color.parseColor("#000000"));
        }
    }

    public void setSignatureBitmap(Bitmap bitmap) {
        if (!c.h.a.a.b.a.isLaidOut(this)) {
            getViewTreeObserver().addOnGlobalLayoutListener(new a(bitmap));
            return;
        }
        clear();
        e();
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = getWidth();
        int height2 = getHeight();
        rectF.set(0.0f, 0.0f, width, height);
        rectF2.set(0.0f, 0.0f, width2, height2);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        new Canvas(this.y).drawBitmap(bitmap, matrix, null);
        setIsEmpty(false);
        invalidate();
    }

    public void setVelocityFilterWeight(float f2) {
        this.n = f2;
    }

    public Bitmap getTransparentSignatureBitmap(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (!z) {
            return getTransparentSignatureBitmap();
        }
        e();
        int height = this.y.getHeight();
        int width = this.y.getWidth();
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        boolean z6 = false;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i4 = 0; i4 < width; i4++) {
            int i5 = 0;
            while (true) {
                if (i5 >= height) {
                    z5 = false;
                    break;
                }
                if (this.y.getPixel(i4, i5) != 0) {
                    i3 = i4;
                    z6 = true;
                    z5 = true;
                    break;
                }
                i5++;
            }
            if (z5) {
                break;
            }
        }
        if (!z6) {
            return null;
        }
        for (int i6 = 0; i6 < height; i6++) {
            int i7 = i3;
            while (true) {
                if (i7 >= width) {
                    z4 = false;
                    break;
                }
                if (this.y.getPixel(i7, i6) != 0) {
                    i2 = i6;
                    z4 = true;
                    break;
                }
                i7++;
            }
            if (z4) {
                break;
            }
        }
        int i8 = Integer.MIN_VALUE;
        int i9 = Integer.MIN_VALUE;
        for (int i10 = width - 1; i10 >= i3; i10--) {
            int i11 = i2;
            while (true) {
                if (i11 >= height) {
                    z3 = false;
                    break;
                }
                if (this.y.getPixel(i10, i11) != 0) {
                    i9 = i10;
                    z3 = true;
                    break;
                }
                i11++;
            }
            if (z3) {
                break;
            }
        }
        for (int i12 = height - 1; i12 >= i2; i12--) {
            int i13 = i3;
            while (true) {
                if (i13 > i9) {
                    z2 = false;
                    break;
                }
                if (this.y.getPixel(i13, i12) != 0) {
                    i8 = i12;
                    z2 = true;
                    break;
                }
                i13++;
            }
            if (z2) {
                break;
            }
        }
        return Bitmap.createBitmap(this.y, i3, i2, i9 - i3, i8 - i2);
    }
}
