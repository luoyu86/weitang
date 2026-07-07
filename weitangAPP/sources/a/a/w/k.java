package a.a.w;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.a.q.g f275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a.a.s.a f276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile AtomicBoolean f278d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile a f279e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Future f280f = null;

    public k(a.a.q.g gVar, a.a.s.a aVar) {
        this.f275a = gVar;
        this.f277c = gVar.f222i;
        this.f276b = aVar;
    }

    public void a() {
        Future future = this.f280f;
        if (future != null) {
            future.cancel(true);
            this.f280f = null;
        }
    }

    public void b() {
        if (this.f279e != null) {
            this.f279e.cancel();
            this.f279e = null;
        }
    }
}
