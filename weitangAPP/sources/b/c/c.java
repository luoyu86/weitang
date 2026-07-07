package b.c;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> extends AbstractList<T> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f779a;

    public c(T[] tArr) {
        this.f779a = tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        for (T t : this.f779a) {
            if (t == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        return this.f779a[i2];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f779a.length;
    }
}
