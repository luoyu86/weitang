package g.a.a.z3;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f13584a;

    public abstract e a();

    public synchronized e getParameters() {
        if (this.f13584a == null) {
            this.f13584a = a();
        }
        return this.f13584a;
    }
}
