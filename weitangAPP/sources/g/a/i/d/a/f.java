package g.a.i.d.a;

/* JADX INFO: loaded from: classes3.dex */
public class f extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f14625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f14626c;

    public f(e eVar, byte[] bArr) {
        this.f14625b = new e(eVar);
        int i2 = 8;
        int i3 = 1;
        while (eVar.getDegree() > i2) {
            i3++;
            i2 += 8;
        }
        if (bArr.length % i3 != 0) {
            throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
        }
        int length = bArr.length / i3;
        this.f14647a = length;
        this.f14626c = new int[length];
        int i4 = 0;
        for (int i5 = 0; i5 < this.f14626c.length; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                int[] iArr = this.f14626c;
                iArr[i5] = ((bArr[i4] & 255) << i6) | iArr[i5];
                i6 += 8;
                i4++;
            }
            if (!eVar.isElementOfThisField(this.f14626c[i5])) {
                throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
            }
        }
    }

    public f(e eVar, int[] iArr) {
        this.f14625b = eVar;
        this.f14647a = iArr.length;
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (!eVar.isElementOfThisField(iArr[length])) {
                throw new ArithmeticException("Element array is not specified over the given finite field.");
            }
        }
        this.f14626c = h.clone(iArr);
    }

    public f(f fVar) {
        this.f14625b = new e(fVar.f14625b);
        this.f14647a = fVar.f14647a;
        this.f14626c = h.clone(fVar.f14626c);
    }

    @Override // g.a.i.d.a.q
    public q add(q qVar) {
        throw new RuntimeException("not implemented");
    }

    @Override // g.a.i.d.a.q
    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f14625b.equals(fVar.f14625b)) {
            return h.equals(this.f14626c, fVar.f14626c);
        }
        return false;
    }

    @Override // g.a.i.d.a.q
    public byte[] getEncoded() {
        int i2 = 8;
        int i3 = 1;
        while (this.f14625b.getDegree() > i2) {
            i3++;
            i2 += 8;
        }
        byte[] bArr = new byte[this.f14626c.length * i3];
        int i4 = 0;
        for (int i5 = 0; i5 < this.f14626c.length; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                bArr[i4] = (byte) (this.f14626c[i5] >>> i6);
                i6 += 8;
                i4++;
            }
        }
        return bArr;
    }

    public e getField() {
        return this.f14625b;
    }

    public int[] getIntArrayForm() {
        return h.clone(this.f14626c);
    }

    @Override // g.a.i.d.a.q
    public int hashCode() {
        return (this.f14625b.hashCode() * 31) + g.a.j.a.hashCode(this.f14626c);
    }

    @Override // g.a.i.d.a.q
    public boolean isZero() {
        for (int length = this.f14626c.length - 1; length >= 0; length--) {
            if (this.f14626c[length] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // g.a.i.d.a.q
    public q multiply(l lVar) {
        int[] vector = lVar.getVector();
        int i2 = this.f14647a;
        if (i2 != vector.length) {
            throw new ArithmeticException("permutation size and vector size mismatch");
        }
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < vector.length; i3++) {
            iArr[i3] = this.f14626c[vector[i3]];
        }
        return new f(this.f14625b, iArr);
    }

    @Override // g.a.i.d.a.q
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.f14626c.length; i2++) {
            for (int i3 = 0; i3 < this.f14625b.getDegree(); i3++) {
                stringBuffer.append(((1 << (i3 & 31)) & this.f14626c[i2]) != 0 ? '1' : '0');
            }
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }
}
