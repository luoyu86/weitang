package g.a.d.n;

/* JADX INFO: loaded from: classes2.dex */
public class k implements g.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f13818a;

    public k(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public k(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        this.f13818a = bArr2;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
    }

    public byte[] getKey() {
        return this.f13818a;
    }
}
