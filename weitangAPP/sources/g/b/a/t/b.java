package g.b.a.t;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f14748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f14750c;

    public b(Throwable th) {
        this.f14748a = th;
        this.f14749b = false;
    }

    public Object getExecutionScope() {
        return this.f14750c;
    }

    public Throwable getThrowable() {
        return this.f14748a;
    }

    public boolean isSuppressErrorUi() {
        return this.f14749b;
    }

    public void setExecutionScope(Object obj) {
        this.f14750c = obj;
    }

    public b(Throwable th, boolean z) {
        this.f14748a = th;
        this.f14749b = z;
    }
}
