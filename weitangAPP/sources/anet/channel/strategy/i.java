package anet.channel.strategy;

/* JADX INFO: loaded from: classes.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f655a;

    public i(g gVar) {
        this.f655a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f655a.a()) {
            return;
        }
        this.f655a.f650b.c();
    }
}
