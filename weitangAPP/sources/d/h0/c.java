package d.h0;

import d.k0.c.l;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f12573a;

    public c(l lVar) {
        this.f12573a = lVar;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues((Comparable) this.f12573a.invoke(t2), (Comparable) this.f12573a.invoke(t));
    }
}
