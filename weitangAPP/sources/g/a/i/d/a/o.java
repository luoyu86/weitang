package g.a.i.d.a;

/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f14643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f14644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m[] f14645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m[] f14646d;

    public o(e eVar, m mVar) {
        this.f14643a = eVar;
        this.f14644b = mVar;
        b();
        a();
    }

    public static void c(m[] mVarArr, int i2, int i3) {
        m mVar = mVarArr[i2];
        mVarArr[i2] = mVarArr[i3];
        mVarArr[i3] = mVar;
    }

    public final void a() {
        int coefficient;
        int degree = this.f14644b.getDegree();
        m[] mVarArr = new m[degree];
        int i2 = degree - 1;
        for (int i3 = i2; i3 >= 0; i3--) {
            mVarArr[i3] = new m(this.f14645c[i3]);
        }
        this.f14646d = new m[degree];
        while (i2 >= 0) {
            this.f14646d[i2] = new m(this.f14643a, i2);
            i2--;
        }
        for (int i4 = 0; i4 < degree; i4++) {
            if (mVarArr[i4].getCoefficient(i4) == 0) {
                int i5 = i4 + 1;
                boolean z = false;
                while (i5 < degree) {
                    if (mVarArr[i5].getCoefficient(i4) != 0) {
                        c(mVarArr, i4, i5);
                        c(this.f14646d, i4, i5);
                        i5 = degree;
                        z = true;
                    }
                    i5++;
                }
                if (!z) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int iInverse = this.f14643a.inverse(mVarArr[i4].getCoefficient(i4));
            mVarArr[i4].multThisWithElement(iInverse);
            this.f14646d[i4].multThisWithElement(iInverse);
            for (int i6 = 0; i6 < degree; i6++) {
                if (i6 != i4 && (coefficient = mVarArr[i6].getCoefficient(i4)) != 0) {
                    m mVarMultWithElement = mVarArr[i4].multWithElement(coefficient);
                    m mVarMultWithElement2 = this.f14646d[i4].multWithElement(coefficient);
                    mVarArr[i6].addToThis(mVarMultWithElement);
                    this.f14646d[i6].addToThis(mVarMultWithElement2);
                }
            }
        }
    }

    public final void b() {
        int i2;
        int degree = this.f14644b.getDegree();
        this.f14645c = new m[degree];
        int i3 = 0;
        while (true) {
            i2 = degree >> 1;
            if (i3 >= i2) {
                break;
            }
            int i4 = i3 << 1;
            int[] iArr = new int[i4 + 1];
            iArr[i4] = 1;
            this.f14645c[i3] = new m(this.f14643a, iArr);
            i3++;
        }
        while (i2 < degree) {
            int i5 = i2 << 1;
            int[] iArr2 = new int[i5 + 1];
            iArr2[i5] = 1;
            this.f14645c[i2] = new m(this.f14643a, iArr2).mod(this.f14644b);
            i2++;
        }
    }

    public m[] getSquareRootMatrix() {
        return this.f14646d;
    }

    public m[] getSquaringMatrix() {
        return this.f14645c;
    }
}
