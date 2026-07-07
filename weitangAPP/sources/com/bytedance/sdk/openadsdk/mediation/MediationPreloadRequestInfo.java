package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdSlot f6394a;
    private List<String> bl;
    private int ok;

    public MediationPreloadRequestInfo(int i2, AdSlot adSlot, List<String> list) {
        this.ok = i2;
        this.f6394a = adSlot;
        this.bl = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.f6394a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.ok;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.bl;
    }
}
