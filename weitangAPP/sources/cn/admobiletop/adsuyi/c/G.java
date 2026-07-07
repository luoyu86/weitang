package cn.admobiletop.adsuyi.c;

import android.graphics.Bitmap;
import android.net.Uri;
import cn.admobiletop.adsuyi.c.A;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f4149a = TimeUnit.SECONDS.toNanos(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f4153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<N> f4156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4157i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final float n;
    public final float o;
    public final float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f4158q;
    public final Bitmap.Config r;
    public final A.e s;

    public String a() {
        Uri uri = this.f4153e;
        return uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(this.f4154f);
    }

    public boolean b() {
        return this.f4156h != null;
    }

    public boolean c() {
        return (this.f4157i == 0 && this.j == 0) ? false : true;
    }

    public String d() {
        long jNanoTime = System.nanoTime() - this.f4151c;
        if (jNanoTime > f4149a) {
            return g() + '+' + TimeUnit.NANOSECONDS.toSeconds(jNanoTime) + 's';
        }
        return g() + '+' + TimeUnit.NANOSECONDS.toMillis(jNanoTime) + "ms";
    }

    public boolean e() {
        return c() || this.n != 0.0f;
    }

    public boolean f() {
        return e() || b();
    }

    public String g() {
        return "[R" + this.f4150b + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i2 = this.f4154f;
        if (i2 > 0) {
            sb.append(i2);
        } else {
            sb.append(this.f4153e);
        }
        List<N> list = this.f4156h;
        if (list != null && !list.isEmpty()) {
            for (N n : this.f4156h) {
                sb.append(' ');
                sb.append(n.a());
            }
        }
        if (this.f4155g != null) {
            sb.append(" stableKey(");
            sb.append(this.f4155g);
            sb.append(')');
        }
        if (this.f4157i > 0) {
            sb.append(" resize(");
            sb.append(this.f4157i);
            sb.append(',');
            sb.append(this.j);
            sb.append(')');
        }
        if (this.k) {
            sb.append(" centerCrop");
        }
        if (this.l) {
            sb.append(" centerInside");
        }
        if (this.n != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.n);
            if (this.f4158q) {
                sb.append(" @ ");
                sb.append(this.o);
                sb.append(',');
                sb.append(this.p);
            }
            sb.append(')');
        }
        if (this.r != null) {
            sb.append(' ');
            sb.append(this.r);
        }
        sb.append('}');
        return sb.toString();
    }

    public G(Uri uri, int i2, String str, List<N> list, int i3, int i4, boolean z, boolean z2, boolean z3, float f2, float f3, float f4, boolean z4, Bitmap.Config config, A.e eVar) {
        this.f4153e = uri;
        this.f4154f = i2;
        this.f4155g = str;
        if (list == null) {
            this.f4156h = null;
        } else {
            this.f4156h = Collections.unmodifiableList(list);
        }
        this.f4157i = i3;
        this.j = i4;
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.f4158q = z4;
        this.r = config;
        this.s = eVar;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Uri f4159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4162d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4163e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f4164f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4165g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f4166h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f4167i;
        public float j;
        public float k;
        public boolean l;
        public List<N> m;
        public Bitmap.Config n;
        public A.e o;

        public a(Uri uri, int i2, Bitmap.Config config) {
            this.f4159a = uri;
            this.f4160b = i2;
            this.n = config;
        }

        public a a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i3 == 0 && i2 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.f4162d = i2;
            this.f4163e = i3;
            return this;
        }

        public boolean b() {
            return (this.f4159a == null && this.f4160b == 0) ? false : true;
        }

        public boolean c() {
            return (this.f4162d == 0 && this.f4163e == 0) ? false : true;
        }

        public G a() {
            boolean z = this.f4165g;
            if (z && this.f4164f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f4164f && this.f4162d == 0 && this.f4163e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (z && this.f4162d == 0 && this.f4163e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.o == null) {
                this.o = A.e.NORMAL;
            }
            return new G(this.f4159a, this.f4160b, this.f4161c, this.m, this.f4162d, this.f4163e, this.f4164f, this.f4165g, this.f4166h, this.f4167i, this.j, this.k, this.l, this.n, this.o);
        }
    }
}
