package g.a.j.r;

/* JADX INFO: loaded from: classes3.dex */
public class b extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f14665a;

    public b(String str, Throwable th) {
        super(str);
        this.f14665a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f14665a;
    }
}
