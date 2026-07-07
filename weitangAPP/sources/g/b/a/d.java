package g.b.a;

import android.os.Looper;
import g.b.a.g;
import g.b.a.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f14697a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14702f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14705i;
    public List<Class<?>> k;
    public List<g.b.a.s.b> l;
    public g m;
    public h n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14698b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14699c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14700d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14701e = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14703g = true;
    public ExecutorService j = f14697a;

    public Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public d addIndex(g.b.a.s.b bVar) {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        this.l.add(bVar);
        return this;
    }

    public g b() {
        g gVar = this.m;
        return gVar != null ? gVar : (!g.a.isAndroidLogAvailable() || a() == null) ? new g.b() : new g.a("EventBus");
    }

    public c build() {
        return new c(this);
    }

    public h c() {
        Object objA;
        h hVar = this.n;
        if (hVar != null) {
            return hVar;
        }
        if (!g.a.isAndroidLogAvailable() || (objA = a()) == null) {
            return null;
        }
        return new h.a((Looper) objA);
    }

    public d eventInheritance(boolean z) {
        this.f14703g = z;
        return this;
    }

    public d executorService(ExecutorService executorService) {
        this.j = executorService;
        return this;
    }

    public d ignoreGeneratedIndex(boolean z) {
        this.f14704h = z;
        return this;
    }

    public c installDefaultEventBus() {
        c cVar;
        synchronized (c.class) {
            if (c.f14679a != null) {
                throw new e("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            c.f14679a = build();
            cVar = c.f14679a;
        }
        return cVar;
    }

    public d logNoSubscriberMessages(boolean z) {
        this.f14699c = z;
        return this;
    }

    public d logSubscriberExceptions(boolean z) {
        this.f14698b = z;
        return this;
    }

    public d logger(g gVar) {
        this.m = gVar;
        return this;
    }

    public d sendNoSubscriberEvent(boolean z) {
        this.f14701e = z;
        return this;
    }

    public d sendSubscriberExceptionEvent(boolean z) {
        this.f14700d = z;
        return this;
    }

    public d skipMethodVerificationFor(Class<?> cls) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(cls);
        return this;
    }

    public d strictMethodVerification(boolean z) {
        this.f14705i = z;
        return this;
    }

    public d throwSubscriberException(boolean z) {
        this.f14702f = z;
        return this;
    }
}
