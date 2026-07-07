package g.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class c extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Exception f13628b;

    public c(String str) {
        super(str);
    }

    public c(String str, Exception exc) {
        super(str);
        this.f13628b = exc;
    }

    @Override // g.a.c.k, java.lang.Throwable
    public Throwable getCause() {
        return this.f13628b;
    }

    @Override // g.a.c.k
    public Exception getUnderlyingException() {
        return this.f13628b;
    }
}
