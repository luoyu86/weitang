package g.a.b;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f13592a;

    public a(String str) {
        super(str);
    }

    public a(String str, Throwable th) {
        super(str);
        this.f13592a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f13592a;
    }
}
