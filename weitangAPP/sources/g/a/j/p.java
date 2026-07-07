package g.a.j;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public interface p extends Iterable {
    boolean add(String str);

    String get(int i2);

    @Override // java.lang.Iterable
    /* synthetic */ Iterator<T> iterator();

    int size();

    String[] toStringArray();

    String[] toStringArray(int i2, int i3);
}
