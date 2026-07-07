package g.a.b;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class b extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f13593a;

    public b(String str) {
        super(str);
    }

    public b(String str, Throwable th) {
        super(str);
        this.f13593a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f13593a;
    }
}
