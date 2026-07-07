package g.a.d.m;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class a extends IOException {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f13794a;

    public a(String str, Throwable th) {
        super(str);
        this.f13794a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f13794a;
    }
}
