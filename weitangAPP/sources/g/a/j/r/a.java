package g.a.j.r;

/* JADX INFO: loaded from: classes3.dex */
public class a extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f14664a;

    public a(String str, Throwable th) {
        super(str);
        this.f14664a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f14664a;
    }
}
