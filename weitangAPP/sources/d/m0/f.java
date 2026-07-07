package d.m0;

import java.lang.Comparable;

/* JADX INFO: loaded from: classes2.dex */
public interface f<T extends Comparable<? super T>> extends g<T> {
    @Override // d.m0.g
    boolean contains(T t);

    @Override // d.m0.g
    /* synthetic */ T getEndInclusive();

    @Override // d.m0.g
    /* synthetic */ T getStart();

    @Override // d.m0.g
    boolean isEmpty();

    boolean lessThanOrEquals(T t, T t2);
}
