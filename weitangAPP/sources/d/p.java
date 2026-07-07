package d;

import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class p<T> implements g<T>, Serializable {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<p<?>, Object> f12876a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, OperatorName.CURVE_TO);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d.k0.c.a<? extends T> f12877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Object f12878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f12879d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public p(d.k0.c.a<? extends T> aVar) {
        d.k0.d.t.checkNotNullParameter(aVar, "initializer");
        this.f12877b = aVar;
        z zVar = z.f12971a;
        this.f12878c = zVar;
        this.f12879d = zVar;
    }

    private final Object writeReplace() {
        return new b(getValue());
    }

    @Override // d.g
    public T getValue() {
        T t = (T) this.f12878c;
        z zVar = z.f12971a;
        if (t != zVar) {
            return t;
        }
        d.k0.c.a<? extends T> aVar = this.f12877b;
        if (aVar != null) {
            T tInvoke = aVar.invoke();
            if (f12876a.compareAndSet(this, zVar, tInvoke)) {
                this.f12877b = null;
                return tInvoke;
            }
        }
        return (T) this.f12878c;
    }

    @Override // d.g
    public boolean isInitialized() {
        return this.f12878c != z.f12971a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
