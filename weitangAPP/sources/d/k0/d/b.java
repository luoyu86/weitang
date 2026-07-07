package d.k0.d;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends d.g0.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f12614b;

    public b(byte[] bArr) {
        t.checkNotNullParameter(bArr, "array");
        this.f12614b = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12613a < this.f12614b.length;
    }

    @Override // d.g0.p
    public byte nextByte() {
        try {
            byte[] bArr = this.f12614b;
            int i2 = this.f12613a;
            this.f12613a = i2 + 1;
            return bArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12613a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
