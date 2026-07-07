package g.a.j;

/* JADX INFO: loaded from: classes3.dex */
public class o extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f14662a;

    public o(String str, Throwable th) {
        super(str);
        this.f14662a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f14662a;
    }
}
