package g.a.i.d.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14647a;

    public abstract q add(q qVar);

    public abstract boolean equals(Object obj);

    public abstract byte[] getEncoded();

    public final int getLength() {
        return this.f14647a;
    }

    public abstract int hashCode();

    public abstract boolean isZero();

    public abstract q multiply(l lVar);

    public abstract String toString();
}
