package g.b.a;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f14719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f14720b;

    public synchronized void a(j jVar) {
        try {
            if (jVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            j jVar2 = this.f14720b;
            if (jVar2 != null) {
                jVar2.f14718d = jVar;
                this.f14720b = jVar;
            } else {
                if (this.f14719a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f14720b = jVar;
                this.f14719a = jVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized j b() {
        j jVar;
        jVar = this.f14719a;
        if (jVar != null) {
            j jVar2 = jVar.f14718d;
            this.f14719a = jVar2;
            if (jVar2 == null) {
                this.f14720b = null;
            }
        }
        return jVar;
    }

    public synchronized j c(int i2) throws InterruptedException {
        if (this.f14719a == null) {
            wait(i2);
        }
        return b();
    }
}
