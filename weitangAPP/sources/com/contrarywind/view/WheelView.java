package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class WheelView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f8836a = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    public float A;
    public float B;
    public float C;
    public float D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public float N;
    public long O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public float T;
    public final float U;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f8837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f8838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f8839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GestureDetector f8840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.f.c.b f8841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScheduledExecutorService f8844i;
    public ScheduledFuture<?> j;
    public Paint k;
    public Paint l;
    public Paint m;
    public c.f.a.a n;
    public String o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8845q;
    public int r;
    public int s;
    public float t;
    public Typeface u;
    public int v;
    public int w;
    public int x;
    public float y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView.this.f8841f.onItemSelected(WheelView.this.getCurrentItem());
        }
    }

    public enum b {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum c {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public final String b(Object obj) {
        return obj == null ? "" : obj instanceof c.f.b.a ? ((c.f.b.a) obj).getPickerViewText() : obj instanceof Integer ? c(((Integer) obj).intValue()) : obj.toString();
    }

    public final String c(int i2) {
        return (i2 < 0 || i2 >= 10) ? String.valueOf(i2) : f8836a[i2];
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.j;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.j.cancel(true);
        this.j = null;
    }

    public final int d(int i2) {
        return i2 < 0 ? d(i2 + this.n.getItemsCount()) : i2 > this.n.getItemsCount() + (-1) ? d(i2 - this.n.getItemsCount()) : i2;
    }

    public final void e(Context context) {
        this.f8838c = context;
        this.f8839d = new c.f.d.b(this);
        GestureDetector gestureDetector = new GestureDetector(context, new c.f.c.a(this));
        this.f8840e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.z = true;
        this.D = 0.0f;
        this.E = -1;
        f();
    }

    public final void f() {
        Paint paint = new Paint();
        this.k = paint;
        paint.setColor(this.v);
        this.k.setAntiAlias(true);
        this.k.setTypeface(this.u);
        this.k.setTextSize(this.p);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setColor(this.w);
        this.l.setAntiAlias(true);
        this.l.setTextScaleX(1.1f);
        this.l.setTypeface(this.u);
        this.l.setTextSize(this.p);
        Paint paint3 = new Paint();
        this.m = paint3;
        paint3.setColor(this.x);
        this.m.setAntiAlias(true);
        setLayerType(1, null);
    }

    public final void g() {
        float f2 = this.y;
        if (f2 < 1.0f) {
            this.y = 1.0f;
        } else if (f2 > 4.0f) {
            this.y = 4.0f;
        }
    }

    public final c.f.a.a getAdapter() {
        return this.n;
    }

    public final int getCurrentItem() {
        int i2;
        c.f.a.a aVar = this.n;
        if (aVar == null) {
            return 0;
        }
        return (!this.z || ((i2 = this.F) >= 0 && i2 < aVar.getItemsCount())) ? Math.max(0, Math.min(this.F, this.n.getItemsCount() - 1)) : Math.max(0, Math.min(Math.abs(Math.abs(this.F) - this.n.getItemsCount()), this.n.getItemsCount() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f8839d;
    }

    public int getInitPosition() {
        return this.E;
    }

    public float getItemHeight() {
        return this.t;
    }

    public int getItemsCount() {
        c.f.a.a aVar = this.n;
        if (aVar != null) {
            return aVar.getItemsCount();
        }
        return 0;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iCeil += (int) Math.ceil(r2[i2]);
        }
        return iCeil;
    }

    public float getTotalScrollY() {
        return this.D;
    }

    public final void h() {
        Rect rect = new Rect();
        for (int i2 = 0; i2 < this.n.getItemsCount(); i2++) {
            String strB = b(this.n.getItem(i2));
            this.l.getTextBounds(strB, 0, strB.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.f8845q) {
                this.f8845q = iWidth;
            }
        }
        this.l.getTextBounds("星期", 0, 2, rect);
        int iHeight = rect.height() + 2;
        this.r = iHeight;
        this.t = this.y * iHeight;
    }

    public final void i(String str) {
        String str2;
        Rect rect = new Rect();
        this.l.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.Q;
        if (i2 == 3) {
            this.R = 0;
            return;
        }
        if (i2 == 5) {
            this.R = (this.K - rect.width()) - ((int) this.T);
            return;
        }
        if (i2 != 17) {
            return;
        }
        if (this.f8842g || (str2 = this.o) == null || str2.equals("") || !this.f8843h) {
            this.R = (int) (((double) (this.K - rect.width())) * 0.5d);
        } else {
            this.R = (int) (((double) (this.K - rect.width())) * 0.25d);
        }
    }

    public void isCenterLabel(boolean z) {
        this.f8843h = z;
    }

    public boolean isLoop() {
        return this.z;
    }

    public final void j(String str) {
        String str2;
        Rect rect = new Rect();
        this.k.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.Q;
        if (i2 == 3) {
            this.S = 0;
            return;
        }
        if (i2 == 5) {
            this.S = (this.K - rect.width()) - ((int) this.T);
            return;
        }
        if (i2 != 17) {
            return;
        }
        if (this.f8842g || (str2 = this.o) == null || str2.equals("") || !this.f8843h) {
            this.S = (int) (((double) (this.K - rect.width())) * 0.5d);
        } else {
            this.S = (int) (((double) (this.K - rect.width())) * 0.25d);
        }
    }

    public final void k() {
        if (this.n == null) {
            return;
        }
        h();
        int i2 = (int) (this.t * (this.I - 1));
        this.J = (int) (((double) (i2 * 2)) / 3.141592653589793d);
        this.L = (int) (((double) i2) / 3.141592653589793d);
        this.K = View.MeasureSpec.getSize(this.P);
        int i3 = this.J;
        float f2 = this.t;
        this.A = (i3 - f2) / 2.0f;
        float f3 = (i3 + f2) / 2.0f;
        this.B = f3;
        this.C = (f3 - ((f2 - this.r) / 2.0f)) - this.T;
        if (this.E == -1) {
            if (this.z) {
                this.E = (this.n.getItemsCount() + 1) / 2;
            } else {
                this.E = 0;
            }
        }
        this.G = this.E;
    }

    public final void l(String str) {
        Rect rect = new Rect();
        this.l.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.p;
        for (int iWidth = rect.width(); iWidth > this.K; iWidth = rect.width()) {
            i2--;
            this.l.setTextSize(i2);
            this.l.getTextBounds(str, 0, str.length(), rect);
        }
        this.k.setTextSize(i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.n == null) {
            return;
        }
        int iMin = Math.min(Math.max(0, this.E), this.n.getItemsCount() - 1);
        this.E = iMin;
        Object[] objArr = new Object[this.I];
        int i2 = (int) (this.D / this.t);
        this.H = i2;
        try {
            this.G = iMin + (i2 % this.n.getItemsCount());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.z) {
            if (this.G < 0) {
                this.G = this.n.getItemsCount() + this.G;
            }
            if (this.G > this.n.getItemsCount() - 1) {
                this.G -= this.n.getItemsCount();
            }
        } else {
            if (this.G < 0) {
                this.G = 0;
            }
            if (this.G > this.n.getItemsCount() - 1) {
                this.G = this.n.getItemsCount() - 1;
            }
        }
        float f2 = this.D % this.t;
        int i3 = 0;
        while (true) {
            int i4 = this.I;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.G - ((i4 / 2) - i3);
            if (this.z) {
                objArr[i3] = this.n.getItem(d(i5));
            } else if (i5 < 0) {
                objArr[i3] = "";
            } else if (i5 > this.n.getItemsCount() - 1) {
                objArr[i3] = "";
            } else {
                objArr[i3] = this.n.getItem(i5);
            }
            i3++;
        }
        if (this.f8837b == c.WRAP) {
            float f3 = (TextUtils.isEmpty(this.o) ? (this.K - this.f8845q) / 2 : (this.K - this.f8845q) / 4) - 12;
            float f4 = f3 <= 0.0f ? 10.0f : f3;
            float f5 = this.K - f4;
            float f6 = this.A;
            float f7 = f4;
            canvas.drawLine(f7, f6, f5, f6, this.m);
            float f8 = this.B;
            canvas.drawLine(f7, f8, f5, f8, this.m);
        } else {
            float f9 = this.A;
            canvas.drawLine(0.0f, f9, this.K, f9, this.m);
            float f10 = this.B;
            canvas.drawLine(0.0f, f10, this.K, f10, this.m);
        }
        if (!TextUtils.isEmpty(this.o) && this.f8843h) {
            canvas.drawText(this.o, (this.K - getTextWidth(this.l, this.o)) - this.T, this.C, this.l);
        }
        for (int i6 = 0; i6 < this.I; i6++) {
            canvas.save();
            double d2 = ((this.t * i6) - f2) / this.L;
            float f11 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f11 >= 90.0f || f11 <= -90.0f) {
                canvas.restore();
            } else {
                float fPow = (float) Math.pow(Math.abs(f11) / 90.0f, 2.2d);
                String strB = (this.f8843h || TextUtils.isEmpty(this.o) || TextUtils.isEmpty(b(objArr[i6]))) ? b(objArr[i6]) : b(objArr[i6]) + this.o;
                l(strB);
                i(strB);
                j(strB);
                float fCos = (float) ((((double) this.L) - (Math.cos(d2) * ((double) this.L))) - ((Math.sin(d2) * ((double) this.r)) / 2.0d));
                canvas.translate(0.0f, fCos);
                float f12 = this.A;
                if (fCos > f12 || this.r + fCos < f12) {
                    float f13 = this.B;
                    if (fCos > f13 || this.r + fCos < f13) {
                        if (fCos >= f12) {
                            int i7 = this.r;
                            if (i7 + fCos <= f13) {
                                canvas.drawText(strB, this.R, i7 - this.T, this.l);
                                this.F = this.G - ((this.I / 2) - i6);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.K, (int) this.t);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 0.8f);
                        Paint paint = this.k;
                        int i8 = this.s;
                        paint.setTextSkewX((i8 == 0 ? 0 : i8 > 0 ? 1 : -1) * (f11 <= 0.0f ? 1 : -1) * 0.5f * fPow);
                        this.k.setAlpha((int) ((1.0f - fPow) * 255.0f));
                        canvas.drawText(strB, this.S + (this.s * fPow), this.r, this.k);
                        canvas.restore();
                        canvas.restore();
                        this.l.setTextSize(this.p);
                    } else {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.K, this.B - fCos);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(strB, this.R, this.r - this.T, this.l);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.B - fCos, this.K, (int) this.t);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 0.8f);
                        canvas.drawText(strB, this.S, this.r, this.k);
                        canvas.restore();
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.K, this.A - fCos);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 0.8f);
                    canvas.drawText(strB, this.S, this.r, this.k);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.A - fCos, this.K, (int) this.t);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(strB, this.R, this.r - this.T, this.l);
                    canvas.restore();
                }
                canvas.restore();
                this.l.setTextSize(this.p);
            }
        }
    }

    public final void onItemSelected() {
        if (this.f8841f != null) {
            postDelayed(new a(), 200L);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.P = i2;
        k();
        setMeasuredDimension(this.K, this.J);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.f8840e.onTouchEvent(motionEvent);
        float f2 = (-this.E) * this.t;
        float itemsCount = ((this.n.getItemsCount() - 1) - this.E) * this.t;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.O = System.currentTimeMillis();
            cancelFuture();
            this.N = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.N - motionEvent.getRawY();
            this.N = motionEvent.getRawY();
            float f3 = this.D + rawY;
            this.D = f3;
            if (!this.z) {
                float f4 = this.t;
                if ((f3 - (f4 * 0.25f) < f2 && rawY < 0.0f) || ((f4 * 0.25f) + f3 > itemsCount && rawY > 0.0f)) {
                    this.D = f3 - rawY;
                    z = true;
                }
            }
        } else if (!zOnTouchEvent) {
            float y = motionEvent.getY();
            int i2 = this.L;
            double dAcos = Math.acos((i2 - y) / i2) * ((double) this.L);
            float f5 = this.t;
            this.M = (int) (((((int) ((dAcos + ((double) (f5 / 2.0f))) / ((double) f5))) - (this.I / 2)) * f5) - (((this.D % f5) + f5) % f5));
            if (System.currentTimeMillis() - this.O > 120) {
                smoothScroll(b.DAGGLE);
            } else {
                smoothScroll(b.CLICK);
            }
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void scrollBy(float f2) {
        cancelFuture();
        this.j = this.f8844i.scheduleWithFixedDelay(new c.f.d.a(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(c.f.a.a aVar) {
        this.n = aVar;
        k();
        invalidate();
    }

    public final void setCurrentItem(int i2) {
        this.F = i2;
        this.E = i2;
        this.D = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.z = z;
    }

    public void setDividerColor(int i2) {
        this.x = i2;
        this.m.setColor(i2);
    }

    public void setDividerType(c cVar) {
        this.f8837b = cVar;
    }

    public void setGravity(int i2) {
        this.Q = i2;
    }

    public void setIsOptions(boolean z) {
        this.f8842g = z;
    }

    public void setLabel(String str) {
        this.o = str;
    }

    public void setLineSpacingMultiplier(float f2) {
        if (f2 != 0.0f) {
            this.y = f2;
            g();
        }
    }

    public final void setOnItemSelectedListener(c.f.c.b bVar) {
        this.f8841f = bVar;
    }

    public void setTextColorCenter(int i2) {
        this.w = i2;
        this.l.setColor(i2);
    }

    public void setTextColorOut(int i2) {
        this.v = i2;
        this.k.setColor(i2);
    }

    public final void setTextSize(float f2) {
        if (f2 > 0.0f) {
            int i2 = (int) (this.f8838c.getResources().getDisplayMetrics().density * f2);
            this.p = i2;
            this.k.setTextSize(i2);
            this.l.setTextSize(this.p);
        }
    }

    public void setTextXOffset(int i2) {
        this.s = i2;
        if (i2 != 0) {
            this.l.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f2) {
        this.D = f2;
    }

    public final void setTypeface(Typeface typeface) {
        this.u = typeface;
        this.k.setTypeface(typeface);
        this.l.setTypeface(this.u);
    }

    public void smoothScroll(b bVar) {
        cancelFuture();
        if (bVar == b.FLING || bVar == b.DAGGLE) {
            float f2 = this.D;
            float f3 = this.t;
            int i2 = (int) (((f2 % f3) + f3) % f3);
            this.M = i2;
            if (i2 > f3 / 2.0f) {
                this.M = (int) (f3 - i2);
            } else {
                this.M = -i2;
            }
        }
        this.j = this.f8844i.scheduleWithFixedDelay(new c.f.d.c(this, this.M), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8842g = false;
        this.f8843h = true;
        this.f8844i = Executors.newSingleThreadScheduledExecutor();
        this.u = Typeface.MONOSPACE;
        this.y = 1.6f;
        this.I = 11;
        this.M = 0;
        this.N = 0.0f;
        this.O = 0L;
        this.Q = 17;
        this.R = 0;
        this.S = 0;
        this.U = 0.5f;
        this.p = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.T = 2.4f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.T = 3.6f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.T = 4.5f;
        } else if (2.0f <= f2 && f2 < 3.0f) {
            this.T = 6.0f;
        } else if (f2 >= 3.0f) {
            this.T = f2 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.Q = typedArrayObtainStyledAttributes.getInt(R.styleable.pickerview_wheelview_gravity, 17);
            this.v = typedArrayObtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.w = typedArrayObtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.x = typedArrayObtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.p = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_wheelview_textSize, this.p);
            this.y = typedArrayObtainStyledAttributes.getFloat(R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.y);
            typedArrayObtainStyledAttributes.recycle();
        }
        g();
        e(context);
    }
}
