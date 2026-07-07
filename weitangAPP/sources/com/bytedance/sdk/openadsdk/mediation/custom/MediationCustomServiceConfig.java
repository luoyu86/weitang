package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes.dex */
public final class MediationCustomServiceConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6429a;
    private int bl;
    private String n;
    private String ok;
    private int s;

    public MediationCustomServiceConfig(String str, String str2, int i2, int i3, String str3) {
        this.ok = str;
        this.f6429a = str2;
        this.bl = i2;
        this.s = i3;
        this.n = str3;
    }

    public String getADNNetworkName() {
        return this.ok;
    }

    public String getADNNetworkSlotId() {
        return this.f6429a;
    }

    public int getAdStyleType() {
        return this.bl;
    }

    public String getCustomAdapterJson() {
        return this.n;
    }

    public int getSubAdtype() {
        return this.s;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.ok + "', mADNNetworkSlotId='" + this.f6429a + "', mAdStyleType=" + this.bl + ", mSubAdtype=" + this.s + ", mCustomAdapterJson='" + this.n + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.ok = valueSet.stringValue(8003);
            this.f6429a = valueSet.stringValue(2);
            this.bl = valueSet.intValue(8008);
            this.s = valueSet.intValue(8094);
            this.n = valueSet.stringValue(8547);
        }
    }
}
