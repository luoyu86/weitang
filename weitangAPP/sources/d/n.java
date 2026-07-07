package d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class n<T> implements Serializable {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12713a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public static final class b implements Serializable {
        public final Throwable exception;

        public b(Throwable th) {
            d.k0.d.t.checkNotNullParameter(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && d.k0.d.t.areEqual(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    public /* synthetic */ n(Object obj) {
        this.f12713a = obj;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ n m378boximpl(Object obj) {
        return new n(obj);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Object m379constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m380equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof n) && d.k0.d.t.areEqual(obj, ((n) obj2).m387unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m381equalsimpl0(Object obj, Object obj2) {
        return d.k0.d.t.areEqual(obj, obj2);
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m382exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m383hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m384isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m385isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m386toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m380equalsimpl(this.f12713a, obj);
    }

    public int hashCode() {
        return m383hashCodeimpl(this.f12713a);
    }

    public String toString() {
        return m386toStringimpl(this.f12713a);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m387unboximpl() {
        return this.f12713a;
    }
}
