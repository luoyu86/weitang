package g.a.i.d.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14638b;

    public abstract k computeInverse();

    public abstract byte[] getEncoded();

    public int getNumColumns() {
        return this.f14638b;
    }

    public int getNumRows() {
        return this.f14637a;
    }

    public abstract boolean isZero();

    public abstract q leftMultiply(q qVar);

    public abstract k rightMultiply(k kVar);

    public abstract k rightMultiply(l lVar);

    public abstract q rightMultiply(q qVar);

    public abstract String toString();
}
