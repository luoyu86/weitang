package d.p0;

import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class z extends y {
    public static final SortedSet<Character> toSortedSet(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$toSortedSet");
        return (SortedSet) a0.toCollection(charSequence, new TreeSet());
    }
}
