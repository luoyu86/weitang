package c.i.b;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f2614a = new n();

    @Deprecated
    public n() {
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof n);
    }

    public int hashCode() {
        return n.class.hashCode();
    }

    @Override // c.i.b.l
    public n deepCopy() {
        return f2614a;
    }
}
