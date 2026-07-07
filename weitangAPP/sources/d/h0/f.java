package d.h0;

import d.k0.d.t;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class f<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<T> f12576a;

    public f(Comparator<T> comparator) {
        t.checkNotNullParameter(comparator, "comparator");
        this.f12576a = comparator;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.f12576a.compare(t2, t);
    }

    public final Comparator<T> getComparator() {
        return this.f12576a;
    }

    @Override // java.util.Comparator
    public final Comparator<T> reversed() {
        return this.f12576a;
    }
}
