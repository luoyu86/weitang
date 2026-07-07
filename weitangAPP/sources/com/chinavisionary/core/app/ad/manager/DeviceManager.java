package com.chinavisionary.core.app.ad.manager;

/* JADX INFO: loaded from: classes.dex */
public class DeviceManager {
    private static volatile DeviceManager instance;
    private String aaid;
    private String oaid;
    private String vaid;

    public static DeviceManager getInstance() {
        if (instance == null) {
            synchronized (DeviceManager.class) {
                if (instance == null) {
                    instance = new DeviceManager();
                }
            }
        }
        return instance;
    }

    public String getAaid() {
        return this.aaid;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getVaid() {
        return this.vaid;
    }

    public void setAaid(String str) {
        this.aaid = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setVaid(String str) {
        this.vaid = str;
    }
}
