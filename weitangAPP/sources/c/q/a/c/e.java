package c.q.a.c;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public enum e {
    INSTANCE;


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f3126b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f3127c = new AtomicBoolean(true);

    e() {
    }

    public boolean getIsCanWriter() {
        return this.f3126b.get();
    }

    public boolean getIsRetryConnect() {
        return this.f3127c.get();
    }

    public void updateBoolean(boolean z) {
        this.f3126b.getAndSet(z);
    }

    public void updateRetryConnectBoolean(boolean z) {
        this.f3127c.getAndSet(z);
    }
}
