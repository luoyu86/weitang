package d.o0;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class s extends r {

    public static final class a extends d.k0.d.u implements d.k0.c.l<Object, Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f12792b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls) {
            super(1);
            this.f12792b = cls;
        }

        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Object obj) {
            return this.f12792b.isInstance(obj);
        }
    }

    public static final <R> m<R> filterIsInstance(m<?> mVar, Class<R> cls) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterIsInstance");
        d.k0.d.t.checkNotNullParameter(cls, "klass");
        m<R> mVarFilter = t.filter(mVar, new a(cls));
        Objects.requireNonNull(mVarFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return mVarFilter;
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(m<?> mVar, C c2, Class<R> cls) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterIsInstanceTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(cls, "klass");
        for (Object obj : mVar) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toSortedSet");
        return (SortedSet) t.toCollection(mVar, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(m<? extends T> mVar, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toSortedSet");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) t.toCollection(mVar, new TreeSet(comparator));
    }
}
