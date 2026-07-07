package com.alibaba.sdk.android.crashdefend.a;

import com.alibaba.sdk.android.crashdefend.CrashDefendCallback;

/* JADX INFO: loaded from: classes.dex */
public class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4641h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4642i = 0;
    public volatile boolean j = false;
    public CrashDefendCallback k = null;

    public Object clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e2) {
            com.alibaba.sdk.android.crashdefend.c.b.a("CrashSDK", "clone fail: ", e2);
            return null;
        }
    }
}
