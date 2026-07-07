package com.tianmu.c.h.b;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.utils.TianmuLogUtil;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.c.h.a.c f11624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11625b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11626c;

    public b(com.tianmu.c.h.a.c cVar) {
        this.f11624a = cVar;
    }

    private String b() {
        File file;
        PackageInfo packageArchiveInfo;
        try {
            file = new File(a.a(this.f11624a.f(), TianmuSDK.getInstance().getContext()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String strC = (!file.exists() || (packageArchiveInfo = TianmuSDK.getInstance().getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || TextUtils.isEmpty(packageArchiveInfo.packageName)) ? null : packageArchiveInfo.packageName;
        if (this.f11624a != null && TextUtils.isEmpty(strC)) {
            strC = this.f11624a.c();
        }
        this.f11626c = TextUtils.isEmpty(strC);
        return strC;
    }

    private void c() {
        com.tianmu.c.h.a.c cVar = this.f11624a;
        if (cVar != null) {
            cVar.m();
        }
    }

    public void a(String str, long j) {
        d.a().a(new com.tianmu.c.h.a.d(this.f11624a, this, j));
    }

    public void a(String str) {
        if (this.f11624a.j() == 0) {
            this.f11624a.k();
        }
    }

    public boolean a(String str, String str2) {
        if (this.f11625b && this.f11626c) {
            TianmuLogUtil.i("下载成功但是无法获取到包名..");
            c();
            return false;
        }
        if (str == null || !str.equalsIgnoreCase(str2)) {
            return false;
        }
        com.tianmu.c.h.a.c cVar = this.f11624a;
        if (cVar == null) {
            return true;
        }
        cVar.n();
        return true;
    }

    public void a() {
        if (this.f11625b || this.f11624a == null) {
            return;
        }
        this.f11625b = true;
        String strB = b();
        com.tianmu.c.h.a.c cVar = this.f11624a;
        if (cVar != null) {
            cVar.c(strB);
        }
        com.tianmu.c.h.a.c cVar2 = this.f11624a;
        if (cVar2 != null) {
            cVar2.o();
        }
        com.tianmu.biz.utils.d.a(this.f11624a.f(), false);
    }
}
