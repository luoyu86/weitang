package g.a.i.b.c;

import g.a.i.d.a.n;

/* JADX INFO: loaded from: classes3.dex */
public class e implements g.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.d.e f14384e;

    public e() {
        this(11, 50);
    }

    public e(int i2) {
        this(i2, (g.a.d.e) null);
    }

    public e(int i2, int i3) {
        this(i2, i3, (g.a.d.e) null);
    }

    public e(int i2, int i3, int i4) {
        this(i2, i3, i4, null);
    }

    public e(int i2, int i3, int i4, g.a.d.e eVar) {
        this.f14380a = i2;
        if (i2 < 1) {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i2 > 32) {
            throw new IllegalArgumentException(" m is too large");
        }
        int i5 = 1 << i2;
        this.f14382c = i5;
        this.f14381b = i3;
        if (i3 < 0) {
            throw new IllegalArgumentException("t must be positive");
        }
        if (i3 > i5) {
            throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        if (n.degree(i4) != i2 || !n.isIrreducible(i4)) {
            throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
        }
        this.f14383d = i4;
        this.f14384e = eVar;
    }

    public e(int i2, int i3, g.a.d.e eVar) {
        if (i2 < 1) {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i2 > 32) {
            throw new IllegalArgumentException("m is too large");
        }
        this.f14380a = i2;
        int i4 = 1 << i2;
        this.f14382c = i4;
        if (i3 < 0) {
            throw new IllegalArgumentException("t must be positive");
        }
        if (i3 > i4) {
            throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        this.f14381b = i3;
        this.f14383d = n.getIrreduciblePolynomial(i2);
        this.f14384e = eVar;
    }

    public e(int i2, g.a.d.e eVar) {
        if (i2 < 1) {
            throw new IllegalArgumentException("key size must be positive");
        }
        this.f14380a = 0;
        this.f14382c = 1;
        while (true) {
            int i3 = this.f14382c;
            if (i3 >= i2) {
                int i4 = i3 >>> 1;
                this.f14381b = i4;
                int i5 = this.f14380a;
                this.f14381b = i4 / i5;
                this.f14383d = n.getIrreduciblePolynomial(i5);
                this.f14384e = eVar;
                return;
            }
            this.f14382c = i3 << 1;
            this.f14380a++;
        }
    }

    public e(g.a.d.e eVar) {
        this(11, 50, eVar);
    }

    public int getFieldPoly() {
        return this.f14383d;
    }

    public int getM() {
        return this.f14380a;
    }

    public int getN() {
        return this.f14382c;
    }

    public int getT() {
        return this.f14381b;
    }
}
