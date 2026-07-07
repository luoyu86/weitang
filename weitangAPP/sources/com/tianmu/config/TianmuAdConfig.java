package com.tianmu.config;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuAdConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile TianmuAdConfig f11951b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11952a;

    private TianmuAdConfig() {
    }

    public static TianmuAdConfig getInstance() {
        if (f11951b == null) {
            synchronized (TianmuAdConfig.class) {
                if (f11951b == null) {
                    f11951b = new TianmuAdConfig();
                }
            }
        }
        return f11951b;
    }

    public String getMachineId() {
        return this.f11952a;
    }

    public void initMachineId(String str) {
        this.f11952a = str;
    }
}
