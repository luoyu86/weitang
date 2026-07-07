package com.alibaba.mtl.log.sign;

import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.j;

/* JADX INFO: loaded from: classes.dex */
public class BaseRequestAuth implements IRequestAuth {
    private boolean E;
    private String ac;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4578g;

    public BaseRequestAuth(String str, String str2) {
        this.f4578g = null;
        this.ac = null;
        this.E = false;
        this.f4578g = str;
        this.ac = str2;
    }

    public String getAppSecret() {
        return this.ac;
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getAppkey() {
        return this.f4578g;
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getSign(String str) {
        if (this.f4578g == null || this.ac == null) {
            i.a("BaseRequestAuth", "There is no appkey,please check it!");
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

    public BaseRequestAuth(String str, String str2, boolean z) {
        this.f4578g = null;
        this.ac = null;
        this.E = false;
        this.f4578g = str;
        this.ac = str2;
        this.E = z;
    }
}
