package anet.channel.detect;

/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f408a;

    public b(a aVar) {
        this.f408a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f408a.f407a.f397e.clear();
        this.f408a.f407a.f393a = 0L;
    }
}
