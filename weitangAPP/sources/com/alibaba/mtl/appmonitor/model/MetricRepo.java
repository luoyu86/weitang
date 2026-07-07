package com.alibaba.mtl.appmonitor.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MetricRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MetricRepo f4516a;
    public List<Metric> metrics;

    private MetricRepo(int i2) {
        this.metrics = new ArrayList(i2);
    }

    public static MetricRepo getRepo() {
        if (f4516a == null) {
            f4516a = new MetricRepo(3);
        }
        return f4516a;
    }

    public void add(Metric metric) {
        if (this.metrics.contains(metric)) {
            return;
        }
        this.metrics.add(metric);
    }

    public Metric getMetric(String str, String str2) {
        List<Metric> list;
        if (str != null && str2 != null && (list = this.metrics) != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Metric metric = this.metrics.get(i2);
                if (metric != null && metric.getModule().equals(str) && metric.getMonitorPoint().equals(str2)) {
                    return metric;
                }
            }
        }
        return null;
    }

    public boolean remove(Metric metric) {
        if (this.metrics.contains(metric)) {
            return this.metrics.remove(metric);
        }
        return true;
    }

    public static MetricRepo getRepo(int i2) {
        return new MetricRepo(i2);
    }
}
