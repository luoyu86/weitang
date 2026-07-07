package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class j extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f13179a;

    public j(String str) {
        super(str);
    }

    public j(String str, Throwable th) {
        super(str);
        this.f13179a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f13179a;
    }
}
