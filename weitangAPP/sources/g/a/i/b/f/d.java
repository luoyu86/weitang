package g.a.i.b.f;

/* JADX INFO: loaded from: classes3.dex */
public class d extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[][] f14415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[][] f14416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public short[] f14417e;

    public d(int i2, short[][] sArr, short[][] sArr2, short[] sArr3) {
        super(false, i2);
        this.f14415c = sArr;
        this.f14416d = sArr2;
        this.f14417e = sArr3;
    }

    public short[][] getCoeffQuadratic() {
        return this.f14415c;
    }

    public short[] getCoeffScalar() {
        return this.f14417e;
    }

    public short[][] getCoeffSingular() {
        return this.f14416d;
    }
}
