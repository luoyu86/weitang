package g.a.i.c.c;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class c implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[][] f14615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public short[][] f14616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[] f14617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14618d;

    public c(int i2, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f14618d = i2;
        this.f14615a = sArr;
        this.f14616b = sArr2;
        this.f14617c = sArr3;
    }

    public short[][] getCoeffQuadratic() {
        return this.f14615a;
    }

    public short[] getCoeffScalar() {
        return this.f14617c;
    }

    public short[][] getCoeffSingular() {
        return this.f14616b;
    }

    public int getDocLength() {
        return this.f14618d;
    }
}
