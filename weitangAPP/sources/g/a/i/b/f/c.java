package g.a.i.b.f;

/* JADX INFO: loaded from: classes3.dex */
public class c extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[][] f14409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[] f14410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public short[][] f14411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short[] f14412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f14413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a[] f14414h;

    public c(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, a[] aVarArr) {
        super(true, iArr[iArr.length - 1] - iArr[0]);
        this.f14409c = sArr;
        this.f14410d = sArr2;
        this.f14411e = sArr3;
        this.f14412f = sArr4;
        this.f14413g = iArr;
        this.f14414h = aVarArr;
    }

    public short[] getB1() {
        return this.f14410d;
    }

    public short[] getB2() {
        return this.f14412f;
    }

    public short[][] getInvA1() {
        return this.f14409c;
    }

    public short[][] getInvA2() {
        return this.f14411e;
    }

    public a[] getLayers() {
        return this.f14414h;
    }

    public int[] getVi() {
        return this.f14413g;
    }
}
