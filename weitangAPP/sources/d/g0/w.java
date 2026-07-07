package d.g0;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class w extends v {
    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(list, "$this$sortWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
