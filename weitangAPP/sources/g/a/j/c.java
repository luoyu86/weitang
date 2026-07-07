package g.a.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class c<T> implements n<T>, Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Collection<T> f14656a;

    public c(Collection<T> collection) {
        this.f14656a = new ArrayList(collection);
    }

    @Override // g.a.j.n
    public Collection<T> getMatches(m<T> mVar) {
        if (mVar == null) {
            return new ArrayList(this.f14656a);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : this.f14656a) {
            if (mVar.match(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return getMatches(null).iterator();
    }
}
