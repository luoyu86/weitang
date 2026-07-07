package d.h0;

import d.k0.c.l;
import d.k0.d.t;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d.h0.a$a, reason: collision with other inner class name */
    public static final class C0237a<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l[] f12565a;

        public C0237a(l[] lVarArr) {
            this.f12565a = lVarArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.a(t, t2, this.f12565a);
        }
    }

    public static final class b<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f12566a;

        public b(Comparator comparator) {
            this.f12566a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            return this.f12566a.compare(t, t2);
        }
    }

    public static final class c<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f12567a;

        public c(Comparator comparator) {
            this.f12567a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return 1;
            }
            if (t2 == null) {
                return -1;
            }
            return this.f12567a.compare(t, t2);
        }
    }

    public static final class d<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f12568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator f12569b;

        public d(Comparator comparator, Comparator comparator2) {
            this.f12568a = comparator;
            this.f12569b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f12568a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f12569b.compare(t, t2);
        }
    }

    public static final class e<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f12570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator f12571b;

        public e(Comparator comparator, Comparator comparator2) {
            this.f12570a = comparator;
            this.f12571b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f12570a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f12571b.compare(t2, t);
        }
    }

    public static final <T> int a(T t, T t2, l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int iCompareValues = compareValues(lVar.invoke(t), lVar.invoke(t2));
            if (iCompareValues != 0) {
                return iCompareValues;
            }
        }
        return 0;
    }

    public static final <T> Comparator<T> compareBy(l<? super T, ? extends Comparable<?>>... lVarArr) {
        t.checkNotNullParameter(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return new C0237a(lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final <T> int compareValuesBy(T t, T t2, l<? super T, ? extends Comparable<?>>... lVarArr) {
        t.checkNotNullParameter(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return a(t, t2, lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        d.h0.d dVar = d.h0.d.f12574a;
        Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return dVar;
    }

    public static final <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        t.checkNotNullParameter(comparator, "comparator");
        return new b(comparator);
    }

    public static final <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
        t.checkNotNullParameter(comparator, "comparator");
        return new c(comparator);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        d.h0.e eVar = d.h0.e.f12575a;
        Objects.requireNonNull(eVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return eVar;
    }

    public static final <T> Comparator<T> reversed(Comparator<T> comparator) {
        t.checkNotNullParameter(comparator, "$this$reversed");
        if (comparator instanceof f) {
            return ((f) comparator).getComparator();
        }
        Comparator<T> fVar = d.h0.d.f12574a;
        if (t.areEqual(comparator, fVar)) {
            d.h0.e eVar = d.h0.e.f12575a;
            Objects.requireNonNull(eVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
            return eVar;
        }
        if (t.areEqual(comparator, d.h0.e.f12575a)) {
            Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        } else {
            fVar = new f<>(comparator);
        }
        return fVar;
    }

    public static final <T> Comparator<T> then(Comparator<T> comparator, Comparator<? super T> comparator2) {
        t.checkNotNullParameter(comparator, "$this$then");
        t.checkNotNullParameter(comparator2, "comparator");
        return new d(comparator, comparator2);
    }

    public static final <T> Comparator<T> thenDescending(Comparator<T> comparator, Comparator<? super T> comparator2) {
        t.checkNotNullParameter(comparator, "$this$thenDescending");
        t.checkNotNullParameter(comparator2, "comparator");
        return new e(comparator, comparator2);
    }
}
