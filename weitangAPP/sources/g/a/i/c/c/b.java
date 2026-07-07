package g.a.i.c.c;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class b implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[][] f14609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public short[] f14610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[][] f14611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[] f14612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f14613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g.a.i.b.f.a[] f14614f;

    public b(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, g.a.i.b.f.a[] aVarArr) {
        this.f14609a = sArr;
        this.f14610b = sArr2;
        this.f14611c = sArr3;
        this.f14612d = sArr4;
        this.f14613e = iArr;
        this.f14614f = aVarArr;
    }

    public short[] getB1() {
        return this.f14610b;
    }

    public short[] getB2() {
        return this.f14612d;
    }

    public short[][] getInvA1() {
        return this.f14609a;
    }

    public short[][] getInvA2() {
        return this.f14611c;
    }

    public g.a.i.b.f.a[] getLayers() {
        return this.f14614f;
    }

    public int[] getVi() {
        return this.f14613e;
    }
}
