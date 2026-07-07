package f;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class a extends u {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @Nullable
    public static a head;
    private boolean inQueue;

    @Nullable
    private a next;
    private long timeoutAt;

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    public class C0244a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f12972a;

        public C0244a(s sVar) {
            this.f12972a = sVar;
        }

        @Override // f.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.enter();
            try {
                try {
                    this.f12972a.close();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                }
            } catch (Throwable th) {
                a.this.exit(false);
                throw th;
            }
        }

        @Override // f.s, java.io.Flushable
        public void flush() throws IOException {
            a.this.enter();
            try {
                try {
                    this.f12972a.flush();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                }
            } catch (Throwable th) {
                a.this.exit(false);
                throw th;
            }
        }

        @Override // f.s
        public u timeout() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f12972a + ")";
        }

        @Override // f.s
        public void write(f.c cVar, long j) throws IOException {
            v.checkOffsetAndCount(cVar.f12980c, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                p pVar = cVar.f12979b;
                while (true) {
                    if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        break;
                    }
                    j2 += (long) (pVar.f13021c - pVar.f13020b);
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    pVar = pVar.f13024f;
                }
                a.this.enter();
                try {
                    try {
                        this.f12972a.write(cVar, j2);
                        j -= j2;
                        a.this.exit(true);
                    } catch (IOException e2) {
                        throw a.this.exit(e2);
                    }
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }
        }
    }

    public class b implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f12974a;

        public b(t tVar) {
            this.f12974a = tVar;
        }

        @Override // f.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    this.f12974a.close();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                }
            } catch (Throwable th) {
                a.this.exit(false);
                throw th;
            }
        }

        @Override // f.t
        public long read(f.c cVar, long j) throws IOException {
            a.this.enter();
            try {
                try {
                    long j2 = this.f12974a.read(cVar, j);
                    a.this.exit(true);
                    return j2;
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                }
            } catch (Throwable th) {
                a.this.exit(false);
                throw th;
            }
        }

        @Override // f.t
        public u timeout() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f12974a + ")";
        }
    }

    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<f.a> r0 = f.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                f.a r1 = f.a.awaitTimeout()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                f.a r2 = f.a.head     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                f.a.head = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: f.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    public static a awaitTimeout() throws InterruptedException {
        a aVar = head.next;
        if (aVar == null) {
            long jNanoTime = System.nanoTime();
            a.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - jNanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long jRemainingNanos = aVar.remainingNanos(System.nanoTime());
        if (jRemainingNanos > 0) {
            long j = jRemainingNanos / 1000000;
            a.class.wait(j, (int) (jRemainingNanos - (1000000 * j)));
            return null;
        }
        head.next = aVar.next;
        aVar.next = null;
        return aVar;
    }

    private static synchronized boolean cancelScheduledTimeout(a aVar) {
        a aVar2 = head;
        while (aVar2 != null) {
            a aVar3 = aVar2.next;
            if (aVar3 == aVar) {
                aVar2.next = aVar.next;
                aVar.next = null;
                return false;
            }
            aVar2 = aVar3;
        }
        return true;
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(a aVar, long j, boolean z) {
        if (head == null) {
            head = new a();
            new c().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            aVar.timeoutAt = Math.min(j, aVar.deadlineNanoTime() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            aVar.timeoutAt = j + jNanoTime;
        } else {
            if (!z) {
                throw new AssertionError();
            }
            aVar.timeoutAt = aVar.deadlineNanoTime();
        }
        long jRemainingNanos = aVar.remainingNanos(jNanoTime);
        a aVar2 = head;
        while (true) {
            a aVar3 = aVar2.next;
            if (aVar3 == null || jRemainingNanos < aVar3.remainingNanos(jNanoTime)) {
                break;
            } else {
                aVar2 = aVar2.next;
            }
        }
        aVar.next = aVar2.next;
        aVar2.next = aVar;
        if (aVar2 == head) {
            a.class.notify();
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(com.alipay.sdk.m.m.a.h0);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final s sink(s sVar) {
        return new C0244a(sVar);
    }

    public final t source(t tVar) {
        return new b(tVar);
    }

    public void timedOut() {
    }

    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    public final IOException exit(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }
}
