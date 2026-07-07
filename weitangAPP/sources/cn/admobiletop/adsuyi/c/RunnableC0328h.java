package cn.admobiletop.adsuyi.c;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0328h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f4224a;

    public RunnableC0328h(N n) {
        this.f4224a = n;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new IllegalStateException("Transformation " + this.f4224a.a() + " mutated input Bitmap but failed to recycle the original.");
    }
}
