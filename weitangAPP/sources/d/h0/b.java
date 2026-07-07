package d.h0;

import d.k0.c.l;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f12572a;

    public b(l lVar) {
        this.f12572a = lVar;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues((Comparable) this.f12572a.invoke(t), (Comparable) this.f12572a.invoke(t2));
    }
}
