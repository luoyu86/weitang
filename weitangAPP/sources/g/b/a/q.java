package g.b.a;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f14745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f14746c = true;

    public q(Object obj, o oVar) {
        this.f14744a = obj;
        this.f14745b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f14744a == qVar.f14744a && this.f14745b.equals(qVar.f14745b);
    }

    public int hashCode() {
        return this.f14744a.hashCode() + this.f14745b.f14730f.hashCode();
    }
}
