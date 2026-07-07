package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ok implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.h.ok f9950a;
    public final String bl;
    public final Context ok;

    public ok(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        this.ok = context;
        this.f9950a = okVar;
        this.bl = str;
    }

    public boolean ok() {
        if (this.ok == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return a().resolveActivity(this.ok.getPackageManager()) != null;
    }
}
