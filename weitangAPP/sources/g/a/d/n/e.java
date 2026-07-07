package g.a.d.n;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f13810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13811c;

    public e(byte[] bArr, int i2) {
        this(bArr, i2, -1);
    }

    public e(byte[] bArr, int i2, int i3) {
        this.f13810b = g.a.j.a.clone(bArr);
        this.f13811c = i2;
        this.f13809a = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (eVar.f13811c != this.f13811c) {
            return false;
        }
        return g.a.j.a.areEqual(this.f13810b, eVar.f13810b);
    }

    public int getCounter() {
        return this.f13811c;
    }

    public byte[] getSeed() {
        return g.a.j.a.clone(this.f13810b);
    }

    public int getUsageIndex() {
        return this.f13809a;
    }

    public int hashCode() {
        return this.f13811c ^ g.a.j.a.hashCode(this.f13810b);
    }
}
