package d.g0;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class v0<T> extends f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f12555a;

    public v0(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "delegate");
        this.f12555a = list;
    }

    @Override // d.g0.f, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        this.f12555a.add(y.g(this, i2), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f12555a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        return this.f12555a.get(y.f(this, i2));
    }

    @Override // d.g0.f
    public int getSize() {
        return this.f12555a.size();
    }

    @Override // d.g0.f
    public T removeAt(int i2) {
        return this.f12555a.remove(y.f(this, i2));
    }

    @Override // d.g0.f, java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        return this.f12555a.set(y.f(this, i2), t);
    }
}
