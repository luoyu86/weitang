package d.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.m0.k f12917b;

    public h(String str, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(str, com.alipay.sdk.m.p0.b.f5579d);
        d.k0.d.t.checkNotNullParameter(kVar, "range");
        this.f12916a = str;
        this.f12917b = kVar;
    }

    public static /* synthetic */ h copy$default(h hVar, String str, d.m0.k kVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hVar.f12916a;
        }
        if ((i2 & 2) != 0) {
            kVar = hVar.f12917b;
        }
        return hVar.copy(str, kVar);
    }

    public final String component1() {
        return this.f12916a;
    }

    public final d.m0.k component2() {
        return this.f12917b;
    }

    public final h copy(String str, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(str, com.alipay.sdk.m.p0.b.f5579d);
        d.k0.d.t.checkNotNullParameter(kVar, "range");
        return new h(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return d.k0.d.t.areEqual(this.f12916a, hVar.f12916a) && d.k0.d.t.areEqual(this.f12917b, hVar.f12917b);
    }

    public final d.m0.k getRange() {
        return this.f12917b;
    }

    public final String getValue() {
        return this.f12916a;
    }

    public int hashCode() {
        String str = this.f12916a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        d.m0.k kVar = this.f12917b;
        return iHashCode + (kVar != null ? kVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.f12916a + ", range=" + this.f12917b + ")";
    }
}
