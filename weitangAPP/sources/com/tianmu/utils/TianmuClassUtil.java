package com.tianmu.utils;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuClassUtil {
    public static boolean classExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isImportAdmDependencies() {
        return classExists("cn.admobiletop.adsuyi.adapter.admobile.ADSuyiIniter");
    }

    public static boolean isImportTianmuAdapterDependencies() {
        return classExists("cn.admobiletop.adsuyi.adapter.tianmu.ADSuyiIniter");
    }

    public static boolean isImportWXOpenApiDependencies() {
        return classExists("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
    }
}
