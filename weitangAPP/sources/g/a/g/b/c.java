package g.a.g.b;

/* JADX INFO: loaded from: classes3.dex */
public class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f14184a;

    public c(int[] iArr) {
        this.f14184a = g.a.j.a.clone(iArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return g.a.j.a.areEqual(this.f14184a, ((c) obj).f14184a);
        }
        return false;
    }

    @Override // g.a.g.b.e
    public int getDegree() {
        return this.f14184a[r0.length - 1];
    }

    @Override // g.a.g.b.e
    public int[] getExponentsPresent() {
        return g.a.j.a.clone(this.f14184a);
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f14184a);
    }
}
