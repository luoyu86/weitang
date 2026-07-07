package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.log.d.i;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: classes.dex */
public enum f {
    ALARM(65501, 30, "alarmData", 5000),
    COUNTER(65502, 30, "counterData", 5000),
    OFFLINE_COUNTER(65133, 30, "counterData", 5000),
    STAT(65503, 30, "statData", 5000);

    public static String TAG = "EventType";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4482e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4483h;
    private int k;
    private String t;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4484i = 25;
    private int j = BaseTransientBottomBar.ANIMATION_FADE_DURATION;
    private boolean m = true;

    f(int i2, int i3, String str, int i4) {
        this.f4482e = i2;
        this.f4483h = i3;
        this.t = str;
        this.k = i4;
    }

    public int a() {
        return this.f4482e;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public int c() {
        return this.f4484i;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public boolean isOpen() {
        return this.m;
    }

    public void setStatisticsInterval(int i2) {
        this.f4484i = i2;
        this.j = i2;
    }

    public static f a(int i2) {
        for (f fVar : values()) {
            if (fVar != null && fVar.a() == i2) {
                return fVar;
            }
        }
        return null;
    }

    public int b() {
        return this.f4483h;
    }

    public void c(int i2) {
        this.k = i2;
    }

    public void b(int i2) {
        i.a(TAG, "[setTriggerCount]", this.t, i2 + "");
        this.f4483h = i2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m20a() {
        return this.t;
    }
}
