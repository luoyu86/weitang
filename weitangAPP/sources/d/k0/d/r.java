package d.k0.d;

/* JADX INFO: loaded from: classes2.dex */
public class r extends l implements q, d.n0.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12659h;

    public r(int i2) {
        this(i2, l.NO_RECEIVER, null, null, null, 0);
    }

    @Override // d.k0.d.l
    public d.n0.a a() {
        return f0.function(this);
    }

    @Override // d.k0.d.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d.n0.e b() {
        return (d.n0.e) super.b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return t.areEqual(getOwner(), rVar.getOwner()) && getName().equals(rVar.getName()) && getSignature().equals(rVar.getSignature()) && this.f12659h == rVar.f12659h && this.f12658g == rVar.f12658g && t.areEqual(getBoundReceiver(), rVar.getBoundReceiver());
        }
        if (obj instanceof d.n0.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // d.k0.d.q
    public int getArity() {
        return this.f12658g;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // d.n0.e
    public boolean isExternal() {
        return b().isExternal();
    }

    @Override // d.n0.e
    public boolean isInfix() {
        return b().isInfix();
    }

    @Override // d.n0.e
    public boolean isInline() {
        return b().isInline();
    }

    @Override // d.n0.e
    public boolean isOperator() {
        return b().isOperator();
    }

    @Override // d.k0.d.l, d.n0.a
    public boolean isSuspend() {
        return b().isSuspend();
    }

    public String toString() {
        d.n0.a aVarCompute = compute();
        if (aVarCompute != this) {
            return aVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public r(int i2, Object obj) {
        this(i2, obj, null, null, null, 0);
    }

    public r(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f12658g = i2;
        this.f12659h = i3 >> 1;
    }
}
