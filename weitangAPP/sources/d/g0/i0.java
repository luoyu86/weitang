package d.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f12469b;

    public i0(int i2, T t) {
        this.f12468a = i2;
        this.f12469b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ i0 copy$default(i0 i0Var, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i2 = i0Var.f12468a;
        }
        if ((i3 & 2) != 0) {
            obj = i0Var.f12469b;
        }
        return i0Var.copy(i2, obj);
    }

    public final int component1() {
        return this.f12468a;
    }

    public final T component2() {
        return this.f12469b;
    }

    public final i0<T> copy(int i2, T t) {
        return new i0<>(i2, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f12468a == i0Var.f12468a && d.k0.d.t.areEqual(this.f12469b, i0Var.f12469b);
    }

    public final int getIndex() {
        return this.f12468a;
    }

    public final T getValue() {
        return this.f12469b;
    }

    public int hashCode() {
        int i2 = this.f12468a * 31;
        T t = this.f12469b;
        return i2 + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.f12468a + ", value=" + this.f12469b + ")";
    }
}
