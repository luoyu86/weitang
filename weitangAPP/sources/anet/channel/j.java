package anet.channel;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            anet.channel.b.a aVar = new anet.channel.b.a();
            aVar.a();
            a.a.n.b.addCache(aVar, new k(this), 1);
        } catch (Exception unused) {
        }
    }
}
