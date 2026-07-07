package g.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class h extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Exception f13661a;

    public h(String str) {
        super(str);
    }

    public h(String str, Exception exc) {
        super(str);
        this.f13661a = exc;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f13661a;
    }

    public Exception getUnderlyingException() {
        return this.f13661a;
    }
}
