package com.qq.e.comm.constants;

/* JADX INFO: loaded from: classes2.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9660b;

    LoginType(int i2) {
        this.f9660b = i2;
        ordinal();
    }

    public int getValue() {
        return this.f9660b;
    }
}
