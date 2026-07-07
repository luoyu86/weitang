package d;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements Comparable<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12966a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12967b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public /* synthetic */ x(long j) {
        this.f12967b = j;
    }

    public static int b(long j, long j2) {
        return f0.ulongCompare(j, j2);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ x m447boximpl(long j) {
        return new x(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m448constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m449equalsimpl(long j, Object obj) {
        return (obj instanceof x) && j == ((x) obj).m453unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m450equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m451hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m452toStringimpl(long j) {
        return f0.ulongToString(j);
    }

    public final int a(long j) {
        return b(this.f12967b, j);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(x xVar) {
        return a(xVar.m453unboximpl());
    }

    public boolean equals(Object obj) {
        return m449equalsimpl(this.f12967b, obj);
    }

    public int hashCode() {
        return m451hashCodeimpl(this.f12967b);
    }

    public String toString() {
        return m452toStringimpl(this.f12967b);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m453unboximpl() {
        return this.f12967b;
    }
}
