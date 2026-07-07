package d.k0.d;

import d.n0.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 extends l implements d.n0.k {
    public d0() {
    }

    @Override // d.k0.d.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d.n0.k b() {
        return (d.n0.k) super.b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            return getOwner().equals(d0Var.getOwner()) && getName().equals(d0Var.getName()) && getSignature().equals(d0Var.getSignature()) && t.areEqual(getBoundReceiver(), d0Var.getBoundReceiver());
        }
        if (obj instanceof d.n0.k) {
            return obj.equals(compute());
        }
        return false;
    }

    public abstract /* synthetic */ k.a<V> getGetter();

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // d.n0.k
    public boolean isConst() {
        return b().isConst();
    }

    @Override // d.n0.k
    public boolean isLateinit() {
        return b().isLateinit();
    }

    public String toString() {
        d.n0.a aVarCompute = compute();
        if (aVarCompute != this) {
            return aVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public d0(Object obj) {
        super(obj);
    }

    public d0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }
}
