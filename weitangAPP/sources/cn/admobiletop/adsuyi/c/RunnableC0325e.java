package cn.admobiletop.adsuyi.c;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0325e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f4220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RuntimeException f4221b;

    public RunnableC0325e(N n, RuntimeException runtimeException) {
        this.f4220a = n;
        this.f4221b = runtimeException;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException("Transformation " + this.f4220a.a() + " crashed with exception.", this.f4221b);
    }
}
