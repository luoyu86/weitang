package d.g0;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class s0<E> extends d<E> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<E> f12551d;

    /* JADX WARN: Multi-variable type inference failed */
    public s0(List<? extends E> list) {
        d.k0.d.t.checkNotNullParameter(list, "list");
        this.f12551d = list;
    }

    @Override // d.g0.d, java.util.List
    public E get(int i2) {
        d.f12454a.checkElementIndex$kotlin_stdlib(i2, this.f12550c);
        return this.f12551d.get(this.f12549b + i2);
    }

    @Override // d.g0.d, d.g0.a
    public int getSize() {
        return this.f12550c;
    }

    public final void move(int i2, int i3) {
        d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, this.f12551d.size());
        this.f12549b = i2;
        this.f12550c = i3 - i2;
    }
}
