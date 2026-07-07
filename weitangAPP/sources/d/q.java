package d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class q<T> implements g<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d.k0.c.a<? extends T> f12950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f12951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12952c;

    public q(d.k0.c.a<? extends T> aVar, Object obj) {
        d.k0.d.t.checkNotNullParameter(aVar, "initializer");
        this.f12950a = aVar;
        this.f12951b = z.f12971a;
        this.f12952c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new b(getValue());
    }

    @Override // d.g
    public T getValue() {
        T tInvoke;
        T t = (T) this.f12951b;
        z zVar = z.f12971a;
        if (t != zVar) {
            return t;
        }
        synchronized (this.f12952c) {
            tInvoke = (T) this.f12951b;
            if (tInvoke == zVar) {
                d.k0.c.a<? extends T> aVar = this.f12950a;
                d.k0.d.t.checkNotNull(aVar);
                tInvoke = aVar.invoke();
                this.f12951b = tInvoke;
                this.f12950a = null;
            }
        }
        return tInvoke;
    }

    @Override // d.g
    public boolean isInitialized() {
        return this.f12951b != z.f12971a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ q(d.k0.c.a aVar, Object obj, int i2, d.k0.d.p pVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
