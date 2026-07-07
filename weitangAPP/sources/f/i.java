package f;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class i extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f12994a;

    public i(u uVar) {
        if (uVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f12994a = uVar;
    }

    @Override // f.u
    public u clearDeadline() {
        return this.f12994a.clearDeadline();
    }

    @Override // f.u
    public u clearTimeout() {
        return this.f12994a.clearTimeout();
    }

    @Override // f.u
    public long deadlineNanoTime() {
        return this.f12994a.deadlineNanoTime();
    }

    public final u delegate() {
        return this.f12994a;
    }

    @Override // f.u
    public boolean hasDeadline() {
        return this.f12994a.hasDeadline();
    }

    public final i setDelegate(u uVar) {
        if (uVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f12994a = uVar;
        return this;
    }

    @Override // f.u
    public void throwIfReached() throws IOException {
        this.f12994a.throwIfReached();
    }

    @Override // f.u
    public u timeout(long j, TimeUnit timeUnit) {
        return this.f12994a.timeout(j, timeUnit);
    }

    @Override // f.u
    public long timeoutNanos() {
        return this.f12994a.timeoutNanos();
    }

    @Override // f.u
    public u deadlineNanoTime(long j) {
        return this.f12994a.deadlineNanoTime(j);
    }
}
