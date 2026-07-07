package g.a.i.b.g;

/* JADX INFO: loaded from: classes3.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14422c;

    public c(byte[] bArr) {
        super(false, null);
        this.f14422c = g.a.j.a.clone(bArr);
    }

    public c(byte[] bArr, String str) {
        super(false, str);
        this.f14422c = g.a.j.a.clone(bArr);
    }

    public byte[] getKeyData() {
        return g.a.j.a.clone(this.f14422c);
    }
}
