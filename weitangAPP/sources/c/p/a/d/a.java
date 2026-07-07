package c.p.a.d;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    INSTANCE;


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f3054b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f3055c = new AtomicBoolean(true);

    a() {
    }

    public boolean getIsCanWriter() {
        return this.f3054b.get();
    }

    public boolean getIsRetryConnect() {
        return this.f3055c.get();
    }

    public void updateBoolean(boolean z) {
        this.f3054b.getAndSet(z);
    }

    public void updateRetryConnectBoolean(boolean z) {
        this.f3055c.getAndSet(z);
    }
}
