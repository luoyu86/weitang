package g.a.d.n;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f13803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13804b;

    public c(byte[] bArr, int i2) {
        this.f13803a = g.a.j.a.clone(bArr);
        this.f13804b = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f13804b != this.f13804b) {
            return false;
        }
        return g.a.j.a.areEqual(this.f13803a, cVar.f13803a);
    }

    public int getCounter() {
        return this.f13804b;
    }

    public byte[] getSeed() {
        return g.a.j.a.clone(this.f13803a);
    }

    public int hashCode() {
        return this.f13804b ^ g.a.j.a.hashCode(this.f13803a);
    }
}
