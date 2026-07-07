package d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class r<A, B, C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f12953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f12954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f12955c;

    public r(A a2, B b2, C c2) {
        this.f12953a = a2;
        this.f12954b = b2;
        this.f12955c = c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r copy$default(r rVar, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
        if ((i2 & 1) != 0) {
            obj = rVar.f12953a;
        }
        if ((i2 & 2) != 0) {
            obj2 = rVar.f12954b;
        }
        if ((i2 & 4) != 0) {
            obj3 = rVar.f12955c;
        }
        return rVar.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.f12953a;
    }

    public final B component2() {
        return this.f12954b;
    }

    public final C component3() {
        return this.f12955c;
    }

    public final r<A, B, C> copy(A a2, B b2, C c2) {
        return new r<>(a2, b2, c2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return d.k0.d.t.areEqual(this.f12953a, rVar.f12953a) && d.k0.d.t.areEqual(this.f12954b, rVar.f12954b) && d.k0.d.t.areEqual(this.f12955c, rVar.f12955c);
    }

    public final A getFirst() {
        return this.f12953a;
    }

    public final B getSecond() {
        return this.f12954b;
    }

    public final C getThird() {
        return this.f12955c;
    }

    public int hashCode() {
        A a2 = this.f12953a;
        int iHashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.f12954b;
        int iHashCode2 = (iHashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.f12955c;
        return iHashCode2 + (c2 != null ? c2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f12953a + ", " + this.f12954b + ", " + this.f12955c + ')';
    }
}
