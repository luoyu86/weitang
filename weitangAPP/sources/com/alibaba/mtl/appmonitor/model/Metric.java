package com.alibaba.mtl.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class Metric implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DimensionSet f4514b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private MeasureSet f50b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4515g;
    private String o;
    private String p;
    private String r;
    private String s;
    private String z;

    @Deprecated
    public Metric() {
        this.z = null;
    }

    private Measure a(String str, List<Measure> list) {
        if (list == null) {
            return null;
        }
        for (Measure measure : list) {
            if (TextUtils.equals(str, measure.name)) {
                return measure;
            }
        }
        return null;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        this.o = null;
        this.p = null;
        this.s = null;
        this.f4515g = false;
        this.f4514b = null;
        this.f50b = null;
        this.r = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Metric metric = (Metric) obj;
        String str = this.s;
        if (str == null) {
            if (metric.s != null) {
                return false;
            }
        } else if (!str.equals(metric.s)) {
            return false;
        }
        String str2 = this.o;
        if (str2 == null) {
            if (metric.o != null) {
                return false;
            }
        } else if (!str2.equals(metric.o)) {
            return false;
        }
        String str3 = this.p;
        if (str3 == null) {
            if (metric.p != null) {
                return false;
            }
        } else if (!str3.equals(metric.p)) {
            return false;
        }
        return true;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        this.o = (String) objArr[0];
        this.p = (String) objArr[1];
        if (objArr.length > 2) {
            this.s = (String) objArr[2];
        }
    }

    public DimensionSet getDimensionSet() {
        return this.f4514b;
    }

    public MeasureSet getMeasureSet() {
        return this.f50b;
    }

    public String getModule() {
        return this.o;
    }

    public String getMonitorPoint() {
        return this.p;
    }

    public synchronized String getTransactionId() {
        if (this.r == null) {
            this.r = UUID.randomUUID().toString() + "$" + this.o + "$" + this.p;
        }
        return this.r;
    }

    public int hashCode() {
        String str = this.s;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.o;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.p;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public synchronized boolean isCommitDetail() {
        if ("1".equalsIgnoreCase(this.z)) {
            return true;
        }
        if ("0".equalsIgnoreCase(this.z)) {
            return false;
        }
        return this.f4515g;
    }

    public void resetTransactionId() {
        this.r = null;
    }

    public synchronized void setCommitDetailFromConfig(String str) {
        this.z = str;
    }

    public boolean valid(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        DimensionSet dimensionSet = this.f4514b;
        boolean zValid = dimensionSet != null ? dimensionSet.valid(dimensionValueSet) : true;
        Metric metric = MetricRepo.getRepo().getMetric("config_prefix" + this.o, "config_prefix" + this.p);
        if (metric == null || metric.getMeasureSet() == null || measureValueSet == null || measureValueSet.getMap() == null || this.f50b == null) {
            MeasureSet measureSet = this.f50b;
            if (measureSet != null) {
                return zValid && measureSet.valid(measureValueSet);
            }
            return zValid;
        }
        List<Measure> measures = metric.getMeasureSet().getMeasures();
        for (String str : measureValueSet.getMap().keySet()) {
            Measure measureA = a(str, measures);
            if (measureA == null) {
                measureA = a(str, this.f50b.getMeasures());
            }
            if (measureA == null || !measureA.valid(measureValueSet.getValue(str))) {
                return false;
            }
        }
        return zValid;
    }

    public Metric(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.z = null;
        this.o = str;
        this.p = str2;
        this.f4514b = dimensionSet;
        this.f50b = measureSet;
        this.s = null;
        this.f4515g = z;
    }
}
