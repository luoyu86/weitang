package com.ut.mini.core.sign;

import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.j;

/* JADX INFO: loaded from: classes2.dex */
public class UTBaseRequestAuthentication implements IUTRequestAuthentication {
    private boolean E;
    private String ac;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12359g;

    public UTBaseRequestAuthentication(String str, String str2) {
        this.f12359g = null;
        this.ac = null;
        this.E = false;
        this.f12359g = str;
        this.ac = str2;
    }

    public String getAppSecret() {
        return this.ac;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.f12359g;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        if (this.f12359g == null || this.ac == null) {
            i.a("UTBaseRequestAuthentication", "There is no appkey,please check it!");
            return null;
        }
        if (str == null) {
            return null;
        }
        return j.a(j.m30a((str + this.ac).getBytes()));
    }

    public boolean isEncode() {
        return this.E;
    }

    public UTBaseRequestAuthentication(String str, String str2, boolean z) {
        this.f12359g = null;
        this.ac = null;
        this.E = false;
        this.f12359g = str;
        this.ac = str2;
        this.E = z;
    }
}
