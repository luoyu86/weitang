package com.tianmu.c.h.a;

import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class a extends c {
    public a(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3, str4, str5);
    }

    @Override // com.tianmu.c.h.a.c
    public void o() {
        if (TianmuSDK.getInstance().isCheckCacheApk()) {
            com.tianmu.d.c.b.a().a(this.j, f());
            super.o();
        }
    }
}
