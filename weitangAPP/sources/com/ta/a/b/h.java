package com.ta.a.b;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f10195a = false;
    private Context mContext;

    public h(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    private void a() {
        com.ta.a.c.f.e();
        if (com.ta.a.c.d.b(this.mContext) && !f10195a) {
            f10195a = true;
            try {
                b();
            } catch (Throwable unused) {
            }
            f10195a = false;
        }
    }

    private void b() {
        com.ta.a.c.f.e();
        String strE = e();
        if (TextUtils.isEmpty(strE)) {
            com.ta.a.c.f.m80a("postData is empty", new Object[0]);
        } else if (a(strE)) {
            com.ta.a.c.f.m80a("", "upload success");
        } else {
            com.ta.a.c.f.m80a("", "upload fail");
        }
    }

    private String e() {
        String strM = com.ta.utdid2.device.a.a().m();
        if (TextUtils.isEmpty(strM)) {
            return null;
        }
        String strA = com.ta.a.a.a.a(strM);
        if (com.ta.a.c.f.m81a()) {
            com.ta.a.c.f.b("", strA);
        }
        return com.ta.a.a.b.b(strA);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            com.ta.a.c.f.a("", th, new Object[0]);
        }
    }

    private boolean a(String str) throws Throwable {
        a aVarA = b.a("https://mpush-api.aliyun.com/v2.0/a/audid/req/", str, true);
        if (aVarA == null) {
            return false;
        }
        return com.ta.utdid2.device.e.a(aVarA);
    }
}
