package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.model.MetricValueSet;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.s;
import com.alibaba.mtl.log.model.LogField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f4474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private AtomicInteger f43a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f4475b = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicInteger f4476c = new AtomicInteger(0);
    private Map<UTDimensionValueSet, MetricValueSet> k = new ConcurrentHashMap();
    private Map<String, c> j = new ConcurrentHashMap();

    private e() {
    }

    public static synchronized e a() {
        if (f4474a == null) {
            f4474a = new e();
        }
        return f4474a;
    }

    private void b(String str, String str2) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric != null) {
            metric.resetTransactionId();
        }
    }

    public void g() {
        ArrayList arrayList = new ArrayList(this.j.keySet());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = (String) arrayList.get(i2);
            c cVar = this.j.get(str);
            if (cVar != null && cVar.c()) {
                this.j.remove(str);
            }
        }
    }

    private UTDimensionValueSet a(int i2, Map<String, String> map) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(UTDimensionValueSet.class, new Object[0]);
        if (map != null) {
            uTDimensionValueSet.setMap(map);
        }
        uTDimensionValueSet.setValue(LogField.ACCESS.toString(), com.alibaba.mtl.log.a.b());
        uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), com.alibaba.mtl.log.a.c());
        uTDimensionValueSet.setValue(LogField.USERID.toString(), com.alibaba.mtl.log.a.d());
        uTDimensionValueSet.setValue(LogField.USERNICK.toString(), com.alibaba.mtl.log.a.e());
        uTDimensionValueSet.setValue(LogField.EVENTID.toString(), String.valueOf(i2));
        return uTDimensionValueSet;
    }

    public void a(int i2, String str, String str2, String str3, Map<String, String> map) {
        UTDimensionValueSet uTDimensionValueSetA = a(i2, map);
        ((a) a(uTDimensionValueSetA, str, str2, str3, a.class)).e();
        if (com.alibaba.mtl.log.a.a.e()) {
            a aVar = (a) com.alibaba.mtl.appmonitor.c.a.a().a(a.class, Integer.valueOf(i2), str, str2, str3);
            aVar.e();
            com.alibaba.mtl.appmonitor.f.c.a(uTDimensionValueSetA, aVar);
        }
        a(f.a(i2), this.f43a);
    }

    public void a(int i2, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        UTDimensionValueSet uTDimensionValueSetA = a(i2, map);
        a aVar = (a) a(uTDimensionValueSetA, str, str2, str3, a.class);
        aVar.f();
        aVar.a(str4, str5);
        if (com.alibaba.mtl.log.a.a.e()) {
            a aVar2 = (a) com.alibaba.mtl.appmonitor.c.a.a().a(a.class, Integer.valueOf(i2), str, str2, str3);
            aVar2.f();
            aVar2.a(str4, str5);
            com.alibaba.mtl.appmonitor.f.c.a(uTDimensionValueSetA, aVar2);
        }
        a(f.a(i2), this.f43a);
    }

    public void a(int i2, String str, String str2, String str3, double d2, Map<String, String> map) {
        UTDimensionValueSet uTDimensionValueSetA = a(i2, map);
        ((b) a(uTDimensionValueSetA, str, str2, str3, b.class)).a(d2);
        if (com.alibaba.mtl.log.a.a.e()) {
            b bVar = (b) com.alibaba.mtl.appmonitor.c.a.a().a(b.class, Integer.valueOf(i2), str, str2, str3);
            bVar.a(d2);
            com.alibaba.mtl.appmonitor.f.c.a(uTDimensionValueSetA, bVar);
        }
        a(f.a(i2), this.f4475b);
    }

    public void a(int i2, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet, Map<String, String> map) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric != null) {
            if (metric.getDimensionSet() != null) {
                metric.getDimensionSet().setConstantValue(dimensionValueSet);
            }
            if (metric.getMeasureSet() != null) {
                metric.getMeasureSet().setConstantValue(measureValueSet);
            }
            UTDimensionValueSet uTDimensionValueSetA = a(i2, map);
            ((g) a(uTDimensionValueSetA, str, str2, (String) null, g.class)).a(dimensionValueSet, measureValueSet);
            if (com.alibaba.mtl.log.a.a.e()) {
                g gVar = (g) com.alibaba.mtl.appmonitor.c.a.a().a(g.class, Integer.valueOf(i2), str, str2);
                gVar.a(dimensionValueSet, measureValueSet);
                com.alibaba.mtl.appmonitor.f.c.a(uTDimensionValueSetA, gVar);
            }
            a(f.a(i2), this.f4476c);
            return;
        }
        i.a("EventRepo", "metric is null");
    }

    public void a(Integer num, String str, String str2, String str3) {
        String strA = a(str, str2);
        if (strA != null) {
            a(strA, num, str, str2, str3);
        }
    }

    public void a(String str, Integer num, String str2, String str3, String str4) {
        c cVar;
        Metric metric = MetricRepo.getRepo().getMetric(str2, str3);
        if (metric == null || metric.getMeasureSet() == null || metric.getMeasureSet().getMeasure(str4) == null) {
            return;
        }
        synchronized (c.class) {
            cVar = this.j.get(str);
            if (cVar == null) {
                cVar = (c) com.alibaba.mtl.appmonitor.c.a.a().a(c.class, num, str2, str3);
                this.j.put(str, cVar);
            }
        }
        cVar.a(str4);
    }

    public void a(String str, String str2, String str3) {
        String strA = a(str, str2);
        if (strA != null) {
            a(strA, str3, true, (Map<String, String>) null);
        }
    }

    public void a(String str, String str2, boolean z, Map<String, String> map) {
        c cVar = this.j.get(str);
        if (cVar == null || !cVar.m18a(str2)) {
            return;
        }
        this.j.remove(str);
        if (z) {
            b(cVar.o, cVar.p);
        }
        a(cVar.f4473e, cVar.o, cVar.p, cVar.m17a(), cVar.a(), map);
        com.alibaba.mtl.appmonitor.c.a.a().a(cVar);
    }

    public void a(String str, Integer num, String str2, String str3, DimensionValueSet dimensionValueSet) {
        c cVar;
        synchronized (c.class) {
            cVar = this.j.get(str);
            if (cVar == null) {
                cVar = (c) com.alibaba.mtl.appmonitor.c.a.a().a(c.class, num, str2, str3);
                this.j.put(str, cVar);
            }
        }
        cVar.a(dimensionValueSet);
    }

    private String a(String str, String str2) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric != null) {
            return metric.getTransactionId();
        }
        return null;
    }

    private d a(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends d> cls) {
        Integer eventId;
        MetricValueSet metricValueSet;
        if (!com.alibaba.mtl.appmonitor.f.b.c(str) || !com.alibaba.mtl.appmonitor.f.b.c(str2) || (eventId = uTDimensionValueSet.getEventId()) == null) {
            return null;
        }
        synchronized (this.k) {
            metricValueSet = this.k.get(uTDimensionValueSet);
            if (metricValueSet == null) {
                metricValueSet = (MetricValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MetricValueSet.class, new Object[0]);
                this.k.put(uTDimensionValueSet, metricValueSet);
            }
        }
        return metricValueSet.getEvent(eventId, str, str2, str3, cls);
    }

    private void a(f fVar, AtomicInteger atomicInteger) {
        int iIncrementAndGet = atomicInteger.incrementAndGet();
        i.a("EventRepo", fVar.toString(), " EVENT size:", String.valueOf(iIncrementAndGet));
        if (iIncrementAndGet >= fVar.b()) {
            i.a("EventRepo", fVar.toString(), " event size exceed trigger count.");
            atomicInteger.set(0);
            m19a(fVar.a());
        }
    }

    public Map<UTDimensionValueSet, List<d>> a(int i2) {
        HashMap map = new HashMap();
        synchronized (this.k) {
            ArrayList arrayList = new ArrayList(this.k.keySet());
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) arrayList.get(i3);
                if (uTDimensionValueSet != null && uTDimensionValueSet.getEventId().intValue() == i2) {
                    map.put(uTDimensionValueSet, this.k.get(uTDimensionValueSet).getEvents());
                    this.k.remove(uTDimensionValueSet);
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m19a(int i2) {
        final Map<UTDimensionValueSet, List<d>> mapA = a(i2);
        s.a().b(new Runnable() { // from class: com.alibaba.mtl.appmonitor.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.alibaba.mtl.appmonitor.f.c.b((Map<UTDimensionValueSet, List<d>>) mapA);
            }
        });
    }
}
