package g.b.a;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Runnable, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f14674a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f14675b;

    public a(c cVar) {
        this.f14675b = cVar;
    }

    @Override // g.b.a.l
    public void enqueue(q qVar, Object obj) {
        this.f14674a.a(j.a(qVar, obj));
        this.f14675b.c().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVarB = this.f14674a.b();
        if (jVarB == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f14675b.e(jVarB);
    }
}
