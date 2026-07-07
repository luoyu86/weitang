package d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class m<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f12675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f12676b;

    public m(A a2, B b2) {
        this.f12675a = a2;
        this.f12676b = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ m copy$default(m mVar, Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = mVar.f12675a;
        }
        if ((i2 & 2) != 0) {
            obj2 = mVar.f12676b;
        }
        return mVar.copy(obj, obj2);
    }

    public final A component1() {
        return this.f12675a;
    }

    public final B component2() {
        return this.f12676b;
    }

    public final m<A, B> copy(A a2, B b2) {
        return new m<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return d.k0.d.t.areEqual(this.f12675a, mVar.f12675a) && d.k0.d.t.areEqual(this.f12676b, mVar.f12676b);
    }

    public final A getFirst() {
        return this.f12675a;
    }

    public final B getSecond() {
        return this.f12676b;
    }

    public int hashCode() {
        A a2 = this.f12675a;
        int iHashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.f12676b;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f12675a + ", " + this.f12676b + ')';
    }
}
