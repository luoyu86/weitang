package g.a.h;

/* JADX INFO: loaded from: classes3.dex */
public class l extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f14195a;

    public l(String str) {
        super(str);
    }

    public l(String str, Throwable th) {
        super(str);
        this.f14195a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f14195a;
    }
}
