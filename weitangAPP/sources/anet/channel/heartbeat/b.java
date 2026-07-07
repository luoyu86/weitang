package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b implements IHeartbeat, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Session f485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f486b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f487c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f488d = 0;

    private void a(long j) {
        try {
            this.f486b = System.currentTimeMillis() + j;
            ThreadPoolExecutorFactory.submitScheduledTask(this, j + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.e("awcn.DefaultHeartbeatImpl", "Submit heartbeat task failed.", this.f485a.p, e2, new Object[0]);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f486b = System.currentTimeMillis() + this.f488d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f487c) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.f486b - 1000) {
            a(this.f486b - jCurrentTimeMillis);
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground()) {
            Session session = this.f485a;
            ALog.e("awcn.DefaultHeartbeatImpl", "close session in background", session.p, "session", session);
            this.f485a.close(false);
        } else {
            if (ALog.isPrintLog(1)) {
                Session session2 = this.f485a;
                ALog.d("awcn.DefaultHeartbeatImpl", "heartbeat", session2.p, "session", session2);
            }
            this.f485a.ping(true);
            a(this.f488d);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        Objects.requireNonNull(session, "session is null");
        this.f485a = session;
        long heartbeat = session.getConnStrategy().getHeartbeat();
        this.f488d = heartbeat;
        if (heartbeat <= 0) {
            this.f488d = 45000L;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat start", session.p, "session", session, "interval", Long.valueOf(this.f488d));
        a(this.f488d);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Session session = this.f485a;
        if (session == null) {
            return;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat stop", session.p, "session", session);
        this.f487c = true;
    }
}
