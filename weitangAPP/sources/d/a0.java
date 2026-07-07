package d;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements Comparable<a0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12415a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final short f12416b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public /* synthetic */ a0(short s) {
        this.f12416b = s;
    }

    public static int b(short s, short s2) {
        return d.k0.d.t.compare(s & 65535, s2 & 65535);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ a0 m94boximpl(short s) {
        return new a0(s);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m95constructorimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m96equalsimpl(short s, Object obj) {
        return (obj instanceof a0) && s == ((a0) obj).m100unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m97equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m98hashCodeimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m99toStringimpl(short s) {
        return String.valueOf(s & 65535);
    }

    public final int a(short s) {
        return b(this.f12416b, s);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a0 a0Var) {
        return a(a0Var.m100unboximpl());
    }

    public boolean equals(Object obj) {
        return m96equalsimpl(this.f12416b, obj);
    }

    public int hashCode() {
        return m98hashCodeimpl(this.f12416b);
    }

    public String toString() {
        return m99toStringimpl(this.f12416b);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m100unboximpl() {
        return this.f12416b;
    }
}
