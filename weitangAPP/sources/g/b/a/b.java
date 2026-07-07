package g.b.a;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f14676a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f14677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f14678c;

    public b(c cVar) {
        this.f14677b = cVar;
    }

    @Override // g.b.a.l
    public void enqueue(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            this.f14676a.a(jVarA);
            if (!this.f14678c) {
                this.f14678c = true;
                this.f14677b.c().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVarC;
        while (true) {
            try {
                jVarC = this.f14676a.c(1000);
            } catch (InterruptedException e2) {
                this.f14677b.getLogger().log(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f14678c = false;
            }
            if (jVarC == null) {
                synchronized (this) {
                    jVarC = this.f14676a.b();
                    if (jVarC == null) {
                        return;
                    }
                    this.f14678c = false;
                }
            }
            this.f14677b.e(jVarC);
        }
    }
}
