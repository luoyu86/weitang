package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c implements IHeartbeat, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Session f489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f490b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f491c = System.currentTimeMillis();

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f491c = System.currentTimeMillis() + 45000;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f490b) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.f491c - 1000) {
            ThreadPoolExecutorFactory.submitScheduledTask(this, this.f491c - jCurrentTimeMillis, TimeUnit.MILLISECONDS);
        } else {
            this.f489a.close(false);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        Objects.requireNonNull(session, "session is null");
        this.f489a = session;
        this.f491c = System.currentTimeMillis() + 45000;
        ThreadPoolExecutorFactory.submitScheduledTask(this, 45000L, TimeUnit.MILLISECONDS);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.f490b = true;
    }
}
