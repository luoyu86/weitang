package d;

import d.n;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final Object createFailure(Throwable th) {
        d.k0.d.t.checkNotNullParameter(th, "exception");
        return new n.b(th);
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof n.b) {
            throw ((n.b) obj).exception;
        }
    }
}
