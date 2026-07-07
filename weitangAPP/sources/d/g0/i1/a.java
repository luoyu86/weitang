package d.g0.i1;

import d.k0.d.t;
import java.util.Map;
import java.util.Map.Entry;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends d.g0.g<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    public final boolean contains(E e2) {
        t.checkNotNullParameter(e2, "element");
        return containsEntry(e2);
    }

    public /* bridge */ boolean remove(Map.Entry entry) {
        return super.remove((Object) entry);
    }
}
