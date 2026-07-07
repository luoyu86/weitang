package cn.admobiletop.adsuyi.ad.entity;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiRewardExtra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3520b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f3523e;

    public ADSuyiRewardExtra(String str) {
        this.f3519a = str;
    }

    public String getCustom() {
        return this.f3520b;
    }

    public int getRewardAmount() {
        return this.f3522d;
    }

    public Map<String, String> getRewardCallbackExtraData() {
        return this.f3523e;
    }

    public String getRewardName() {
        return this.f3521c;
    }

    public String getUserId() {
        return this.f3519a;
    }

    public void setCustomData(String str) {
        this.f3520b = str;
    }

    public void setRewardAmount(int i2) {
        this.f3522d = i2;
    }

    public void setRewardCallbackExtraData(Map<String, String> map) {
        this.f3523e = map;
    }

    public void setRewardName(String str) {
        this.f3521c = str;
    }

    public void setUserId(String str) {
        this.f3519a = str;
    }
}
