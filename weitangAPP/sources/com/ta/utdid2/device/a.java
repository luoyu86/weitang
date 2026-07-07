package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import com.ta.a.b.h;
import com.ta.a.c.f;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10213a = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f10214c = 3000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10215d = "";

    private a() {
    }

    public static a a() {
        return f10213a;
    }

    private void f() {
        f.e();
        if (TextUtils.isEmpty(this.f10215d)) {
            return;
        }
        try {
            final Context context = com.ta.a.a.a().getContext();
            boolean zM82c = c.m82c(context);
            f.m80a("", "isMainProcess", Boolean.valueOf(zM82c));
            if (zM82c) {
                new Thread(new Runnable() { // from class: com.ta.utdid2.device.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Thread.sleep(a.f10214c);
                        } catch (Exception unused) {
                        }
                        if (com.ta.a.b.e.m78a(context)) {
                            new h(context).run();
                        } else {
                            f.m80a("", "unable upload!");
                        }
                    }
                }).start();
            }
        } catch (Throwable th) {
            f.m80a("", th);
        }
    }

    private String l() {
        if (com.ta.a.a.a().getContext() == null) {
            return "";
        }
        String strD = com.ta.a.b.e.d();
        if (!d.m83c(strD)) {
            return null;
        }
        f.m80a("AppUtdid", "read utdid from V5AppFile");
        d.setType(7);
        return strD;
    }

    public synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.f10215d)) {
            return this.f10215d;
        }
        try {
            com.ta.a.c.c.c();
            String strL = l();
            if (TextUtils.isEmpty(strL)) {
                strL = d.a(context).getValue();
            }
            if (TextUtils.isEmpty(strL)) {
                return "ffffffffffffffffffffffff";
            }
            this.f10215d = strL;
            f();
            return this.f10215d;
        } catch (Throwable th) {
            try {
                f.a("AppUtdid", th, new Object[0]);
                return "ffffffffffffffffffffffff";
            } finally {
                com.ta.a.c.c.d();
            }
        }
    }

    public synchronized String m() {
        return this.f10215d;
    }
}
