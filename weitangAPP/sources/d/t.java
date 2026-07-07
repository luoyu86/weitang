package d;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements Comparable<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12956a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f12957b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public /* synthetic */ t(byte b2) {
        this.f12957b = b2;
    }

    public static int b(byte b2, byte b3) {
        return d.k0.d.t.compare(b2 & 255, b3 & 255);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ t m399boximpl(byte b2) {
        return new t(b2);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte m400constructorimpl(byte b2) {
        return b2;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m401equalsimpl(byte b2, Object obj) {
        return (obj instanceof t) && b2 == ((t) obj).m405unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m402equalsimpl0(byte b2, byte b3) {
        return b2 == b3;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m403hashCodeimpl(byte b2) {
        return b2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m404toStringimpl(byte b2) {
        return String.valueOf(b2 & 255);
    }

    public final int a(byte b2) {
        return b(this.f12957b, b2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(t tVar) {
        return a(tVar.m405unboximpl());
    }

    public boolean equals(Object obj) {
        return m401equalsimpl(this.f12957b, obj);
    }

    public int hashCode() {
        return m403hashCodeimpl(this.f12957b);
    }

    public String toString() {
        return m404toStringimpl(this.f12957b);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte m405unboximpl() {
        return this.f12957b;
    }
}
