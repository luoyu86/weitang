package f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    public static final u NONE = new a();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public class a extends u {
        @Override // f.u
        public u deadlineNanoTime(long j) {
            return this;
        }

        @Override // f.u
        public void throwIfReached() throws IOException {
        }

        @Override // f.u
        public u timeout(long j, TimeUnit timeUnit) {
            return this;
        }
    }

    public u clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public u clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final u deadline(long j, TimeUnit timeUnit) {
        if (j > 0) {
            if (timeUnit != null) {
                return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("duration <= 0: " + j);
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public u timeout(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j = jTimeoutNanos / 1000000;
                Long.signum(j);
                obj.wait(j, (int) (jTimeoutNanos - (1000000 * j)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException(com.alipay.sdk.m.m.a.h0);
            }
        } catch (InterruptedException unused) {
            throw new InterruptedIOException("interrupted");
        }
    }

    public u deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
