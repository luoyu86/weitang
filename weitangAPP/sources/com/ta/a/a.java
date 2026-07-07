package com.ta.a;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10186a = new a();
    private Context mContext = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f141a = 0;

    private a() {
    }

    public static a a() {
        return f10186a;
    }

    public Context getContext() {
        return this.mContext;
    }

    public synchronized void a(Context context) {
        if (this.mContext == null) {
            if (context == null) {
                return;
            }
            if (context.getApplicationContext() != null) {
                this.mContext = context.getApplicationContext();
            } else {
                this.mContext = context;
            }
        }
    }

    public void a(long j) {
        this.f141a = j - System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m76a() {
        return System.currentTimeMillis() + this.f141a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m77a() {
        return "" + m76a();
    }
}
