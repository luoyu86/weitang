package com.tianmu.g;

import android.graphics.Bitmap;
import android.net.Uri;
import com.tianmu.g.r;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private static final long s = TimeUnit.SECONDS.toNanos(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f12159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d0> f12162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12164i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Bitmap.Config f12165q;
    public final r.f r;

    public String a() {
        Uri uri = this.f12159d;
        return uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(this.f12160e);
    }

    public boolean b() {
        return this.f12162g != null;
    }

    public boolean c() {
        return (this.f12163h == 0 && this.f12164i == 0) ? false : true;
    }

    public String d() {
        long jNanoTime = System.nanoTime() - this.f12157b;
        if (jNanoTime > s) {
            return g() + '+' + TimeUnit.NANOSECONDS.toSeconds(jNanoTime) + 's';
        }
        return g() + '+' + TimeUnit.NANOSECONDS.toMillis(jNanoTime) + "ms";
    }

    public boolean e() {
        return c() || this.m != 0.0f;
    }

    public boolean f() {
        return e() || b();
    }

    public String g() {
        return "[R" + this.f12156a + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i2 = this.f12160e;
        if (i2 > 0) {
            sb.append(i2);
        } else {
            sb.append(this.f12159d);
        }
        List<d0> list = this.f12162g;
        if (list != null && !list.isEmpty()) {
            for (d0 d0Var : this.f12162g) {
                sb.append(' ');
                sb.append(d0Var.a());
            }
        }
        if (this.f12161f != null) {
            sb.append(" stableKey(");
            sb.append(this.f12161f);
            sb.append(')');
        }
        if (this.f12163h > 0) {
            sb.append(" resize(");
            sb.append(this.f12163h);
            sb.append(',');
            sb.append(this.f12164i);
            sb.append(')');
        }
        if (this.j) {
            sb.append(" centerCrop");
        }
        if (this.k) {
            sb.append(" centerInside");
        }
        if (this.m != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.m);
            if (this.p) {
                sb.append(" @ ");
                sb.append(this.n);
                sb.append(',');
                sb.append(this.o);
            }
            sb.append(')');
        }
        if (this.f12165q != null) {
            sb.append(' ');
            sb.append(this.f12165q);
        }
        sb.append('}');
        return sb.toString();
    }

    private v(Uri uri, int i2, String str, List<d0> list, int i3, int i4, boolean z, boolean z2, boolean z3, float f2, float f3, float f4, boolean z4, Bitmap.Config config, r.f fVar) {
        this.f12159d = uri;
        this.f12160e = i2;
        this.f12161f = str;
        if (list == null) {
            this.f12162g = null;
        } else {
            this.f12162g = Collections.unmodifiableList(list);
        }
        this.f12163h = i3;
        this.f12164i = i4;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = f2;
        this.n = f3;
        this.o = f4;
        this.p = z4;
        this.f12165q = config;
        this.r = fVar;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f12166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f12168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f12169d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f12170e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f12171f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f12172g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f12173h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f12174i;
        private float j;
        private float k;
        private boolean l;
        private List<d0> m;
        private Bitmap.Config n;
        private r.f o;

        public b(Uri uri, int i2, Bitmap.Config config) {
            this.f12166a = uri;
            this.f12167b = i2;
            this.n = config;
        }

        public b a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i3 == 0 && i2 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.f12169d = i2;
            this.f12170e = i3;
            return this;
        }

        public b b() {
            if (this.f12172g) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f12171f = true;
            return this;
        }

        public boolean c() {
            return (this.f12166a == null && this.f12167b == 0) ? false : true;
        }

        public boolean d() {
            return (this.f12169d == 0 && this.f12170e == 0) ? false : true;
        }

        public b a(Bitmap.Config config) {
            this.n = config;
            return this;
        }

        public v a() {
            boolean z = this.f12172g;
            if (z && this.f12171f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f12171f && this.f12169d == 0 && this.f12170e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (z && this.f12169d == 0 && this.f12170e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.o == null) {
                this.o = r.f.f12141b;
            }
            return new v(this.f12166a, this.f12167b, this.f12168c, this.m, this.f12169d, this.f12170e, this.f12171f, this.f12172g, this.f12173h, this.f12174i, this.j, this.k, this.l, this.n, this.o);
        }
    }
}
