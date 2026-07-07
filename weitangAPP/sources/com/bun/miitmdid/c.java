package com.bun.miitmdid;

import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    UNSUPPORT(-1, "unsupport"),
    HUAWEI(0, "HUAWEI"),
    XIAOMI(1, "Xiaomi"),
    VIVO(2, AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO),
    OPPO(3, AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, "samsung"),
    MEIZU(8, AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU),
    NUBIA(10, "nubia"),
    ZTE(11, "ZTE"),
    ONEPLUS(12, "OnePlus"),
    BLACKSHARK(13, "blackshark"),
    FREEMEOS(30, "freemeos"),
    PRIZE(32, "prize"),
    REALME(33, "realme"),
    HONOR(34, AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR),
    COOLPAD(35, "coolpad"),
    EEBBK(36, "EEBBK"),
    CHUANGLIAN(37, "ChuangLian"),
    CHINATELECOM(38, "ChinaTelecom"),
    OS360(39, "360UI"),
    XIAODU(40, "Xiaodu");

    public String A;
    public int z;

    c(int i2, String str) {
        this.z = i2;
        this.A = str;
    }

    public static native c a(String str);

    public static native c valueOf(String str);

    public static native c[] values();
}
