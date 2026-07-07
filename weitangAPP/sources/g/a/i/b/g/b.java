package g.a.i.b.g;

/* JADX INFO: loaded from: classes3.dex */
public class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14421c;

    public b(byte[] bArr) {
        super(true, null);
        this.f14421c = g.a.j.a.clone(bArr);
    }

    public b(byte[] bArr, String str) {
        super(true, str);
        this.f14421c = g.a.j.a.clone(bArr);
    }

    public byte[] getKeyData() {
        return g.a.j.a.clone(this.f14421c);
    }
}
