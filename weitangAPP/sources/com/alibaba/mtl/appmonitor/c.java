package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.s;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<Integer, c> f4490f = null;
    private static boolean j = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4492e;
    private long startTime = System.currentTimeMillis();

    private c(int i2, int i3) {
        this.f4491d = 180000;
        this.f4492e = i2;
        this.f4491d = i3;
    }

    private static int a(int i2) {
        if (i2 == 65133) {
            return 11;
        }
        switch (i2) {
            case 65501:
                return 6;
            case 65502:
                return 9;
            case 65503:
                return 10;
            default:
                return 0;
        }
    }

    public static void a(int i2, int i3) {
        i.a("CommitTask", "[setStatisticsInterval] eventId" + i2 + " statisticsInterval:" + i3);
        synchronized (f4490f) {
            c cVar = f4490f.get(Integer.valueOf(i2));
            if (cVar == null) {
                if (i3 > 0) {
                    c cVar2 = new c(i2, i3 * 1000);
                    f4490f.put(Integer.valueOf(i2), cVar2);
                    i.a("CommitTask", "post next eventId" + i2 + ": uploadTask.interval " + cVar2.f4491d);
                    s.a().a(a(i2), cVar2, (long) cVar2.f4491d);
                }
            } else if (i3 > 0) {
                int i4 = i3 * 1000;
                if (cVar.f4491d != i4) {
                    s.a().f(a(i2));
                    cVar.f4491d = i4;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j2 = ((long) cVar.f4491d) - (jCurrentTimeMillis - cVar.startTime);
                    if (j2 < 0) {
                        j2 = 0;
                    }
                    i.a("CommitTask", cVar + "post next eventId" + i2 + " next:" + j2 + "  uploadTask.interval: " + cVar.f4491d);
                    s.a().a(a(i2), cVar, j2);
                    cVar.startTime = jCurrentTimeMillis;
                }
            } else {
                i.a("CommitTask", "uploadTasks.size:" + f4490f.size());
                f4490f.remove(Integer.valueOf(i2));
                i.a("CommitTask", "uploadTasks.size:" + f4490f.size());
            }
        }
    }

    public static void d() {
        for (f fVar : f.values()) {
            e.a().m19a(fVar.a());
        }
    }

    public static void destroy() {
        for (f fVar : f.values()) {
            s.a().f(a(fVar.a()));
        }
        j = false;
        f4490f = null;
    }

    public static void init() {
        if (j) {
            return;
        }
        i.a("CommitTask", "init StatisticsAlarmEvent");
        f4490f = new ConcurrentHashMap();
        for (f fVar : f.values()) {
            if (fVar.isOpen()) {
                int iA = fVar.a();
                c cVar = new c(iA, fVar.c() * 1000);
                f4490f.put(Integer.valueOf(iA), cVar);
                s.a().a(a(iA), cVar, cVar.f4491d);
            }
        }
        j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.a("CommitTask", "check&commit event:", Integer.valueOf(this.f4492e));
        e.a().m19a(this.f4492e);
        if (f4490f.containsValue(this)) {
            this.startTime = System.currentTimeMillis();
            i.a("CommitTask", "next:" + this.f4492e);
            s.a().a(a(this.f4492e), this, (long) this.f4491d);
        }
    }
}
