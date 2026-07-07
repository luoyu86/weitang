package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class z extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f13556a;

    public z(String str) {
        super(str);
    }

    public z(String str, Throwable th) {
        super(str);
        this.f13556a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f13556a;
    }
}
