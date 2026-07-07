package com.tianmu.biz.widget.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.tianmu.c.f.d1;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f11189a = new float[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f11190b = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColorInt
    public int f11192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColorInt
    public int f11193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f11197i;
    public float j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11198q;
    public int r;
    public long s;
    public long t;

    /* JADX INFO: renamed from: com.tianmu.biz.widget.shimmer.a$a, reason: collision with other inner class name */
    public static class C0204a extends b<C0204a> {
        public C0204a() {
            this.f11199a.p = true;
        }

        @Override // com.tianmu.biz.widget.shimmer.a.b
        public C0204a b() {
            return this;
        }
    }

    public static class c extends b<c> {
        public c() {
            this.f11199a.p = false;
        }

        @Override // com.tianmu.biz.widget.shimmer.a.b
        public c b() {
            return this;
        }

        public c g(@ColorInt int i2) {
            a aVar = this.f11199a;
            aVar.f11193e = (i2 & ViewCompat.MEASURED_SIZE_MASK) | (aVar.f11193e & (-16777216));
            return b();
        }

        public c h(@ColorInt int i2) {
            this.f11199a.f11192d = i2;
            return b();
        }

        @Override // com.tianmu.biz.widget.shimmer.a.b
        public c a(TypedArray typedArray) {
            super.a(typedArray);
            int i2 = d1.b.s;
            if (typedArray.hasValue(i2)) {
                g(typedArray.getColor(i2, this.f11199a.f11193e));
            }
            int i3 = d1.b.t;
            if (typedArray.hasValue(i3)) {
                h(typedArray.getColor(i3, this.f11199a.f11192d));
            }
            return b();
        }
    }

    public a() {
        new RectF();
        this.f11191c = 0;
        this.f11192d = -1;
        this.f11193e = 1291845631;
        this.f11194f = 0;
        this.f11195g = 0;
        this.f11196h = 0;
        this.f11197i = 1.0f;
        this.j = 1.0f;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 20.0f;
        this.n = true;
        this.o = true;
        this.p = true;
        this.f11198q = -1;
        this.r = 1;
        this.s = 1000L;
    }

    public int a(int i2) {
        int i3 = this.f11196h;
        return i3 > 0 ? i3 : Math.round(this.j * i2);
    }

    public int b(int i2) {
        int i3 = this.f11195g;
        return i3 > 0 ? i3 : Math.round(this.f11197i * i2);
    }

    public static abstract class b<T extends b<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f11199a = new a();

        public T a(TypedArray typedArray) {
            int i2 = d1.b.f11327b;
            if (typedArray.hasValue(i2)) {
                b(typedArray.getBoolean(i2, this.f11199a.n));
            }
            int i3 = d1.b.f11328c;
            if (typedArray.hasValue(i3)) {
                a(typedArray.getBoolean(i3, this.f11199a.o));
            }
            int i4 = d1.b.f11329d;
            if (typedArray.hasValue(i4)) {
                a(typedArray.getFloat(i4, 0.3f));
            }
            int i5 = d1.b.f11330e;
            if (typedArray.hasValue(i5)) {
                d(typedArray.getFloat(i5, 1.0f));
            }
            if (typedArray.hasValue(d1.b.f11331f)) {
                a(typedArray.getInt(r0, (int) this.f11199a.s));
            }
            int i6 = d1.b.f11332g;
            if (typedArray.hasValue(i6)) {
                d(typedArray.getInt(i6, this.f11199a.f11198q));
            }
            if (typedArray.hasValue(d1.b.f11333h)) {
                b(typedArray.getInt(r0, (int) this.f11199a.t));
            }
            int i7 = d1.b.f11334i;
            if (typedArray.hasValue(i7)) {
                e(typedArray.getInt(i7, this.f11199a.r));
            }
            int i8 = d1.b.j;
            if (typedArray.hasValue(i8)) {
                int i9 = typedArray.getInt(i8, this.f11199a.f11191c);
                if (i9 == 1) {
                    a(1);
                } else if (i9 == 2) {
                    a(2);
                } else if (i9 != 3) {
                    a(0);
                } else {
                    a(3);
                }
            }
            int i10 = d1.b.k;
            if (typedArray.hasValue(i10)) {
                if (typedArray.getInt(i10, this.f11199a.f11194f) != 1) {
                    f(0);
                } else {
                    f(1);
                }
            }
            int i11 = d1.b.l;
            if (typedArray.hasValue(i11)) {
                b(typedArray.getFloat(i11, this.f11199a.l));
            }
            int i12 = d1.b.m;
            if (typedArray.hasValue(i12)) {
                c(typedArray.getDimensionPixelSize(i12, this.f11199a.f11195g));
            }
            int i13 = d1.b.n;
            if (typedArray.hasValue(i13)) {
                b(typedArray.getDimensionPixelSize(i13, this.f11199a.f11196h));
            }
            int i14 = d1.b.o;
            if (typedArray.hasValue(i14)) {
                e(typedArray.getFloat(i14, this.f11199a.k));
            }
            int i15 = d1.b.p;
            if (typedArray.hasValue(i15)) {
                g(typedArray.getFloat(i15, this.f11199a.f11197i));
            }
            int i16 = d1.b.f11335q;
            if (typedArray.hasValue(i16)) {
                c(typedArray.getFloat(i16, this.f11199a.j));
            }
            int i17 = d1.b.r;
            if (typedArray.hasValue(i17)) {
                f(typedArray.getFloat(i17, this.f11199a.m));
            }
            return (T) b();
        }

        public abstract T b();

        public T b(@Px int i2) {
            if (i2 >= 0) {
                this.f11199a.f11196h = i2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid height: " + i2);
        }

        public T c(@Px int i2) {
            if (i2 >= 0) {
                this.f11199a.f11195g = i2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid width: " + i2);
        }

        public T d(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            int iA = (int) (a(0.0f, 1.0f, f2) * 255.0f);
            a aVar = this.f11199a;
            aVar.f11192d = (iA << 24) | (aVar.f11192d & ViewCompat.MEASURED_SIZE_MASK);
            return (T) b();
        }

        public T e(float f2) {
            if (f2 >= 0.0f) {
                this.f11199a.k = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f2);
        }

        public T f(int i2) {
            this.f11199a.f11194f = i2;
            return (T) b();
        }

        public T g(float f2) {
            if (f2 >= 0.0f) {
                this.f11199a.f11197i = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f2);
        }

        public T f(float f2) {
            this.f11199a.m = f2;
            return (T) b();
        }

        public T b(float f2) {
            if (f2 >= 0.0f) {
                this.f11199a.l = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f2);
        }

        public T c(float f2) {
            if (f2 >= 0.0f) {
                this.f11199a.j = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f2);
        }

        public T d(int i2) {
            this.f11199a.f11198q = i2;
            return (T) b();
        }

        public T e(int i2) {
            this.f11199a.r = i2;
            return (T) b();
        }

        public T b(boolean z) {
            this.f11199a.n = z;
            return (T) b();
        }

        public T b(long j) {
            if (j >= 0) {
                this.f11199a.t = j;
                return (T) b();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j);
        }

        public T a(int i2) {
            this.f11199a.f11191c = i2;
            return (T) b();
        }

        public T a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            int iA = (int) (a(0.0f, 1.0f, f2) * 255.0f);
            a aVar = this.f11199a;
            aVar.f11193e = (iA << 24) | (aVar.f11193e & ViewCompat.MEASURED_SIZE_MASK);
            return (T) b();
        }

        public T a(boolean z) {
            this.f11199a.o = z;
            return (T) b();
        }

        public T a(long j) {
            if (j >= 0) {
                this.f11199a.s = j;
                return (T) b();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j);
        }

        public a a() {
            this.f11199a.a();
            this.f11199a.b();
            return this.f11199a;
        }

        private static float a(float f2, float f3, float f4) {
            return Math.min(f3, Math.max(f2, f4));
        }
    }

    public void a() {
        if (this.f11194f != 1) {
            int[] iArr = this.f11190b;
            int i2 = this.f11193e;
            iArr[0] = i2;
            int i3 = this.f11192d;
            iArr[1] = i3;
            iArr[2] = i3;
            iArr[3] = i2;
            return;
        }
        int[] iArr2 = this.f11190b;
        int i4 = this.f11192d;
        iArr2[0] = i4;
        iArr2[1] = i4;
        int i5 = this.f11193e;
        iArr2[2] = i5;
        iArr2[3] = i5;
    }

    public void b() {
        if (this.f11194f != 1) {
            this.f11189a[0] = Math.max(((1.0f - this.k) - this.l) / 2.0f, 0.0f);
            this.f11189a[1] = Math.max(((1.0f - this.k) - 0.001f) / 2.0f, 0.0f);
            this.f11189a[2] = Math.min(((this.k + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.f11189a[3] = Math.min(((this.k + 1.0f) + this.l) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.f11189a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.k, 1.0f);
        this.f11189a[2] = Math.min(this.k + this.l, 1.0f);
        this.f11189a[3] = 1.0f;
    }
}
