package com.alipay.sdk.m.u;

/* JADX INFO: loaded from: classes.dex */
public enum g {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NETWORK_TYPE_20(20, "5G"),
    NONE(-1, "none");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5675b;

    g(int i2, String str) {
        this.f5674a = i2;
        this.f5675b = str;
    }

    public final int a() {
        return this.f5674a;
    }

    public final String b() {
        return this.f5675b;
    }

    public static g a(int i2) {
        for (g gVar : values()) {
            if (gVar.a() == i2) {
                return gVar;
            }
        }
        return NONE;
    }
}
