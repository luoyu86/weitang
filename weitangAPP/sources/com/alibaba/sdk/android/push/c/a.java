package com.alibaba.sdk.android.push.c;

import android.app.Application;
import android.content.Context;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AmsLogger f4853a = AmsLogger.getLogger("MPS:ReportManager");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f4854b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4856d = true;

    private a(Context context) {
        this.f4855c = 0L;
        if (context != null && (context.getApplicationContext() instanceof Application) && this.f4855c == 0) {
            this.f4855c = System.currentTimeMillis();
        }
    }

    public static a a() {
        return f4854b;
    }

    public static a a(Context context) {
        if (f4854b == null) {
            synchronized (a.class) {
                if (f4854b == null) {
                    f4854b = new a(context);
                }
            }
        }
        return f4854b;
    }

    public void a(String str) {
    }

    public void a(String str, String str2, int i2) {
        if (this.f4856d) {
            return;
        }
        f4853a.e("report switch turned off");
    }

    public void a(String str, String str2, long j) {
        if (this.f4856d) {
            return;
        }
        f4853a.e("report switch turned off");
    }

    public void a(String str, String str2, String str3) {
        if (this.f4856d) {
            return;
        }
        f4853a.e("report switch turned off");
    }

    public void a(String str, String str2, String str3, String str4) {
        if (this.f4856d) {
            return;
        }
        f4853a.e("report switch turned off");
    }
}
