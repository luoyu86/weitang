package cn.admobiletop.adsuyi.c;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0327g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f4223a;

    public RunnableC0327g(N n) {
        this.f4223a = n;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new IllegalStateException("Transformation " + this.f4223a.a() + " returned input Bitmap but recycled it.");
    }
}
