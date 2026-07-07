package d.k0.d;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f12661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12662b;

    public z(Class<?> cls, String str) {
        t.checkNotNullParameter(cls, "jClass");
        t.checkNotNullParameter(str, "moduleName");
        this.f12661a = cls;
        this.f12662b = str;
    }

    public boolean equals(Object obj) {
        return (obj instanceof z) && t.areEqual(getJClass(), ((z) obj).getJClass());
    }

    @Override // d.k0.d.m
    public Class<?> getJClass() {
        return this.f12661a;
    }

    @Override // d.k0.d.m, d.n0.d
    public Collection<d.n0.a<?>> getMembers() {
        throw new d.k0.b();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
