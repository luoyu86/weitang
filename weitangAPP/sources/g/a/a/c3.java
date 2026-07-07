package g.a.a;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c3 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f13056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13057b;

    public c3(InputStream inputStream, int i2) {
        this.f13056a = inputStream;
        this.f13057b = i2;
    }

    public int a() {
        return this.f13057b;
    }

    public void b(boolean z) {
        InputStream inputStream = this.f13056a;
        if (inputStream instanceof z2) {
            ((z2) inputStream).d(z);
        }
    }
}
