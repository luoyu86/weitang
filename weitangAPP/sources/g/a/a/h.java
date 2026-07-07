package g.a.a;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g[] f13097a = new g[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g[] f13098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13100d;

    public h() {
        this(10);
    }

    public h(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("'initialCapacity' must not be negative");
        }
        this.f13098b = i2 == 0 ? f13097a : new g[i2];
        this.f13099c = 0;
        this.f13100d = false;
    }

    public static g[] a(g[] gVarArr) {
        return gVarArr.length < 1 ? f13097a : (g[]) gVarArr.clone();
    }

    public void add(g gVar) {
        Objects.requireNonNull(gVar, "'element' cannot be null");
        int length = this.f13098b.length;
        int i2 = this.f13099c + 1;
        if (this.f13100d | (i2 > length)) {
            d(i2);
        }
        this.f13098b[this.f13099c] = gVar;
        this.f13099c = i2;
    }

    public void addAll(h hVar) {
        Objects.requireNonNull(hVar, "'other' cannot be null");
        c(hVar.f13098b, "'other' elements cannot be null");
    }

    public void addAll(g[] gVarArr) {
        Objects.requireNonNull(gVarArr, "'others' cannot be null");
        c(gVarArr, "'others' elements cannot be null");
    }

    public g[] b() {
        int i2 = this.f13099c;
        if (i2 == 0) {
            return f13097a;
        }
        g[] gVarArr = new g[i2];
        System.arraycopy(this.f13098b, 0, gVarArr, 0, i2);
        return gVarArr;
    }

    public final void c(g[] gVarArr, String str) {
        int length = gVarArr.length;
        if (length < 1) {
            return;
        }
        int length2 = this.f13098b.length;
        int i2 = this.f13099c + length;
        int i3 = 0;
        if ((i2 > length2) | this.f13100d) {
            d(i2);
        }
        do {
            g gVar = gVarArr[i3];
            Objects.requireNonNull(gVar, str);
            this.f13098b[this.f13099c + i3] = gVar;
            i3++;
        } while (i3 < length);
        this.f13099c = i2;
    }

    public final void d(int i2) {
        g[] gVarArr = new g[Math.max(this.f13098b.length, i2 + (i2 >> 1))];
        System.arraycopy(this.f13098b, 0, gVarArr, 0, this.f13099c);
        this.f13098b = gVarArr;
        this.f13100d = false;
    }

    public g[] e() {
        int i2 = this.f13099c;
        if (i2 == 0) {
            return f13097a;
        }
        g[] gVarArr = this.f13098b;
        if (gVarArr.length == i2) {
            this.f13100d = true;
            return gVarArr;
        }
        g[] gVarArr2 = new g[i2];
        System.arraycopy(gVarArr, 0, gVarArr2, 0, i2);
        return gVarArr2;
    }

    public g get(int i2) {
        if (i2 < this.f13099c) {
            return this.f13098b[i2];
        }
        throw new ArrayIndexOutOfBoundsException(i2 + " >= " + this.f13099c);
    }

    public int size() {
        return this.f13099c;
    }
}
