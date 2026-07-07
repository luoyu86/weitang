package com.alibaba.sdk.android.utils.crashdefend;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5038b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f139b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f140b;
    public int crashCount;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5039c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f5040d = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SDKMessageCallback f137a = null;

    public Object clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e2) {
            Log.e("CrashSDK", "clone fail:", e2);
            return null;
        }
    }
}
