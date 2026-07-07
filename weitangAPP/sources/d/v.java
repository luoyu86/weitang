package d;

import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements Comparable<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12961a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12962b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public /* synthetic */ v(int i2) {
        this.f12962b = i2;
    }

    public static int b(int i2, int i3) {
        return f0.uintCompare(i2, i3);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ v m423boximpl(int i2) {
        return new v(i2);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m424constructorimpl(int i2) {
        return i2;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m425equalsimpl(int i2, Object obj) {
        return (obj instanceof v) && i2 == ((v) obj).m429unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m426equalsimpl0(int i2, int i3) {
        return i2 == i3;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m427hashCodeimpl(int i2) {
        return i2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m428toStringimpl(int i2) {
        return String.valueOf(((long) i2) & UIDFolder.MAXUID);
    }

    public final int a(int i2) {
        return b(this.f12962b, i2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(v vVar) {
        return a(vVar.m429unboximpl());
    }

    public boolean equals(Object obj) {
        return m425equalsimpl(this.f12962b, obj);
    }

    public int hashCode() {
        return m427hashCodeimpl(this.f12962b);
    }

    public String toString() {
        return m428toStringimpl(this.f12962b);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m429unboximpl() {
        return this.f12962b;
    }
}
