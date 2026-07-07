package d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class e0<T> implements g<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d.k0.c.a<? extends T> f12428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12429b;

    public e0(d.k0.c.a<? extends T> aVar) {
        d.k0.d.t.checkNotNullParameter(aVar, "initializer");
        this.f12428a = aVar;
        this.f12429b = z.f12971a;
    }

    private final Object writeReplace() {
        return new b(getValue());
    }

    @Override // d.g
    public T getValue() {
        if (this.f12429b == z.f12971a) {
            d.k0.c.a<? extends T> aVar = this.f12428a;
            d.k0.d.t.checkNotNull(aVar);
            this.f12429b = aVar.invoke();
            this.f12428a = null;
        }
        return (T) this.f12429b;
    }

    @Override // d.g
    public boolean isInitialized() {
        return this.f12429b != z.f12971a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
