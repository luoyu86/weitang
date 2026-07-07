package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a implements IHeartbeat, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Session f483a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f484b = false;

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f484b) {
            return;
        }
        this.f483a.ping(true);
        ThreadPoolExecutorFactory.submitScheduledTask(this, 45000L, TimeUnit.MILLISECONDS);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        Objects.requireNonNull(session, "session is null");
        this.f483a = session;
        run();
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.f484b = true;
    }
}
