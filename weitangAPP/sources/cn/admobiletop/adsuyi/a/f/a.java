package cn.admobiletop.adsuyi.a.f;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3230a;

    public a(b bVar) {
        this.f3230a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3230a.f3235d.onFinish();
    }
}
