package g.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class p extends d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f13696b;

    public p(byte[] bArr) {
        super(1);
        this.f13696b = bArr;
    }

    @Override // g.a.c.d0, g.a.j.m
    public Object clone() {
        return new p(this.f13696b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return g.a.j.a.areEqual(this.f13696b, ((p) obj).f13696b);
        }
        return false;
    }

    public byte[] getKeyIdentifier() {
        return g.a.j.a.clone(this.f13696b);
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f13696b);
    }

    @Override // g.a.c.d0, g.a.j.m
    public boolean match(Object obj) {
        if (obj instanceof byte[]) {
            return g.a.j.a.areEqual(this.f13696b, (byte[]) obj);
        }
        if (obj instanceof q) {
            return ((q) obj).getRID().equals(this);
        }
        return false;
    }
}
