package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.d.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Long f4470a = 300000L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Metric f40a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DimensionValueSet f4471b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private MeasureValueSet f41b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Long f42b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, MeasureValue> f4472i;

    public void a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f4472i.isEmpty()) {
            this.f42b = Long.valueOf(jCurrentTimeMillis);
        }
        this.f4472i.put(str, (MeasureValue) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValue.class, Double.valueOf(jCurrentTimeMillis), Double.valueOf(jCurrentTimeMillis - this.f42b.longValue())));
    }

    public boolean c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<Measure> measures = this.f40a.getMeasureSet().getMeasures();
        if (measures != null) {
            int size = measures.size();
            for (int i2 = 0; i2 < size; i2++) {
                Measure measure = measures.get(i2);
                if (measure != null) {
                    double dDoubleValue = measure.getMax() != null ? measure.getMax().doubleValue() : f4470a.longValue();
                    MeasureValue measureValue = this.f4472i.get(measure.getName());
                    if (measureValue != null && !measureValue.isFinish() && jCurrentTimeMillis - measureValue.getValue() > dDoubleValue) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        super.clean();
        this.f40a = null;
        this.f42b = null;
        Iterator<MeasureValue> it = this.f4472i.values().iterator();
        while (it.hasNext()) {
            com.alibaba.mtl.appmonitor.c.a.a().a(it.next());
        }
        this.f4472i.clear();
        if (this.f41b != null) {
            com.alibaba.mtl.appmonitor.c.a.a().a(this.f41b);
            this.f41b = null;
        }
        if (this.f4471b != null) {
            com.alibaba.mtl.appmonitor.c.a.a().a(this.f4471b);
            this.f4471b = null;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.f4472i == null) {
            this.f4472i = new HashMap();
        }
        Metric metric = MetricRepo.getRepo().getMetric(this.o, this.p);
        this.f40a = metric;
        if (metric.getDimensionSet() != null) {
            this.f4471b = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
            this.f40a.getDimensionSet().setConstantValue(this.f4471b);
        }
        this.f41b = (MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0]);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m18a(String str) {
        MeasureValue measureValue = this.f4472i.get(str);
        if (measureValue != null) {
            double dCurrentTimeMillis = System.currentTimeMillis();
            i.a("DurationEvent", "statEvent consumeTime. module:", this.o, " monitorPoint:", this.p, " measureName:", str, " time:", Double.valueOf(dCurrentTimeMillis - measureValue.getValue()));
            measureValue.setValue(dCurrentTimeMillis - measureValue.getValue());
            measureValue.setFinish(true);
            this.f41b.setValue(str, measureValue);
            if (this.f40a.getMeasureSet().valid(this.f41b)) {
                return true;
            }
        }
        return false;
    }

    public void a(DimensionValueSet dimensionValueSet) {
        DimensionValueSet dimensionValueSet2 = this.f4471b;
        if (dimensionValueSet2 == null) {
            this.f4471b = dimensionValueSet;
        } else {
            dimensionValueSet2.addValues(dimensionValueSet);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public MeasureValueSet m17a() {
        return this.f41b;
    }

    public DimensionValueSet a() {
        return this.f4471b;
    }
}
