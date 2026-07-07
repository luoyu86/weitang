package g.a.i.d.a;

import java.lang.reflect.Array;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f14627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f14628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public l f14629c;

        public a(c cVar, c cVar2, l lVar) {
            this.f14627a = cVar;
            this.f14628b = cVar2;
            this.f14629c = lVar;
        }

        public c getFirstMatrix() {
            return this.f14627a;
        }

        public l getPermutation() {
            return this.f14629c;
        }

        public c getSecondMatrix() {
            return this.f14628b;
        }
    }

    public static a computeSystematicForm(c cVar, SecureRandom secureRandom) {
        l lVar;
        c cVar2;
        c leftSubMatrix;
        boolean z;
        int numColumns = cVar.getNumColumns();
        c cVar3 = null;
        do {
            lVar = new l(numColumns, secureRandom);
            cVar2 = (c) cVar.rightMultiply(lVar);
            leftSubMatrix = cVar2.getLeftSubMatrix();
            z = true;
            try {
                cVar3 = (c) leftSubMatrix.computeInverse();
            } catch (ArithmeticException unused) {
                z = false;
            }
        } while (!z);
        return new a(leftSubMatrix, ((c) cVar3.rightMultiply(cVar2)).getRightSubMatrix(), lVar);
    }

    public static c createCanonicalCheckMatrix(e eVar, m mVar) {
        int degree = eVar.getDegree();
        int i2 = 1 << degree;
        int degree2 = mVar.getDegree();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, degree2, i2);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, degree2, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[0][i3] = eVar.inverse(mVar.evaluateAt(i3));
        }
        for (int i4 = 1; i4 < degree2; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                iArr2[i4][i5] = eVar.mult(iArr2[i4 - 1][i5], i5);
            }
        }
        for (int i6 = 0; i6 < degree2; i6++) {
            for (int i7 = 0; i7 < i2; i7++) {
                for (int i8 = 0; i8 <= i6; i8++) {
                    iArr[i6][i7] = eVar.add(iArr[i6][i7], eVar.mult(iArr2[i8][i7], mVar.getCoefficient((degree2 + i8) - i6)));
                }
            }
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) int.class, degree2 * degree, (i2 + 31) >>> 5);
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = i9 >>> 5;
            int i11 = 1 << (i9 & 31);
            for (int i12 = 0; i12 < degree2; i12++) {
                int i13 = iArr[i12][i9];
                for (int i14 = 0; i14 < degree; i14++) {
                    if (((i13 >>> i14) & 1) != 0) {
                        int[] iArr4 = iArr3[(((i12 + 1) * degree) - i14) - 1];
                        iArr4[i10] = iArr4[i10] ^ i11;
                    }
                }
            }
        }
        return new c(i2, iArr3);
    }

    public static d syndromeDecode(d dVar, e eVar, m mVar, m[] mVarArr) {
        int degree = 1 << eVar.getDegree();
        d dVar2 = new d(degree);
        if (!dVar.isZero()) {
            m[] mVarArrModPolynomialToFracton = new m(dVar.toExtensionFieldVector(eVar)).modInverse(mVar).addMonomial(1).modSquareRootMatrix(mVarArr).modPolynomialToFracton(mVar);
            m mVarAdd = mVarArrModPolynomialToFracton[0].multiply(mVarArrModPolynomialToFracton[0]).add(mVarArrModPolynomialToFracton[1].multiply(mVarArrModPolynomialToFracton[1]).multWithMonomial(1));
            m mVarMultWithElement = mVarAdd.multWithElement(eVar.inverse(mVarAdd.getHeadCoefficient()));
            for (int i2 = 0; i2 < degree; i2++) {
                if (mVarMultWithElement.evaluateAt(i2) == 0) {
                    dVar2.setBit(i2);
                }
            }
        }
        return dVar2;
    }
}
