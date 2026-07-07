package g.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class k extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Exception f13689a;

    public k(String str) {
        super(str);
    }

    public k(String str, Exception exc) {
        super(str);
        this.f13689a = exc;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f13689a;
    }

    public Exception getUnderlyingException() {
        return this.f13689a;
    }
}
