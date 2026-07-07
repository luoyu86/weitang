package c.i.b.a0;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends IOException {
    private static final long serialVersionUID = 1;

    public d(String str) {
        super(str);
    }

    public d(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    public d(Throwable th) {
        initCause(th);
    }
}
