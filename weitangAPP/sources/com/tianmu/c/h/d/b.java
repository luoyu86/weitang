package com.tianmu.c.h.d;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.receiver.PackageInstallReceiver;
import com.tianmu.biz.utils.s0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f11645b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11646a;

    private b() {
        try {
            this.f11646a = TianmuSDK.getInstance().getContext().getPackageName();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
            TianmuSDK.getInstance().getContext().registerReceiver(new PackageInstallReceiver(), intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static b a() {
        if (f11645b == null) {
            synchronized (b.class) {
                if (f11645b == null) {
                    f11645b = new b();
                }
            }
        }
        return f11645b;
    }

    private void b(com.tianmu.c.h.a.c cVar, String str, boolean z, String str2) {
        if (cVar != null) {
            cVar.a(str, z, str2);
        }
    }

    public void c(String str, String str2, String str3, boolean z) {
        com.tianmu.c.h.a.c cVarB = a.c().b(str, str3);
        String strA = com.tianmu.c.h.b.a.a(cVarB.f(), TianmuSDK.getInstance().getContext());
        cVarB.a(0L);
        try {
            File file = new File(strA);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
        cVarB.m();
        com.tianmu.c.h.a.c.a(this.f11646a, str, str3);
    }

    public void b(String str, String str2, String str3, boolean z) {
        com.tianmu.c.h.a.c cVarB = a.c().b(str, str3);
        if (cVarB != null) {
            b(cVarB, str2, z, str);
        } else {
            a("广告下载异常");
            com.tianmu.c.h.a.c.b(this.f11646a, str, str3);
        }
    }

    public void a(String str, String str2, String str3, String str4, boolean z, String str5) {
        try {
            String strA = a.c().a(str);
            if (TextUtils.isEmpty(strA)) {
                a("下载地址有误");
                com.tianmu.c.h.a.c.b(this.f11646a, str2, str4);
            } else if (a.c().b(str2) == null) {
                a("下载信息有误");
                com.tianmu.c.h.a.c.b(this.f11646a, str2, str4);
            } else {
                com.tianmu.c.h.a.c cVarB = a.c().b(str2, str4);
                if (cVarB == null) {
                    cVarB = a.c().a(str2, strA, str4, this.f11646a, str5);
                }
                b(cVarB, str3, z, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            a("下载失败了");
            com.tianmu.c.h.a.c.b(this.f11646a, str2, str4);
        }
    }

    private void a(com.tianmu.c.h.a.c cVar, String str, boolean z, String str2) {
        if (cVar != null) {
            cVar.b(str, z, str2);
        }
    }

    private void a(String str) {
        s0.a(str);
    }

    public void a(String str, String str2, String str3, boolean z) {
        com.tianmu.c.h.a.c cVarB = a.c().b(str, str3);
        if (cVarB == null) {
            a("广告暂停下载异常");
            com.tianmu.c.h.a.c.b(this.f11646a, str, str3);
        } else {
            a(cVarB, str2, z, str);
        }
    }
}
