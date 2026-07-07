package com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bl implements MediationFullScreenManager {
    private final Bridge ok;

    public bl(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager
    public void destroy() {
        this.ok.call(270007, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        List arrayList = (List) this.ok.call(270002, c.d.a.a.a.a.a.ok(0).a(), List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new a((Bridge) it.next()));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        return new ok((Bridge) this.ok.call(270004, c.d.a.a.a.a.a.ok(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        List arrayList = (List) this.ok.call(270005, c.d.a.a.a.a.a.ok(0).a(), List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new ok((Bridge) it.next()));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        List arrayList = (List) this.ok.call(270003, c.d.a.a.a.a.a.ok(0).a(), List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new ok((Bridge) it.next()));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        return new ok((Bridge) this.ok.call(270006, c.d.a.a.a.a.a.ok(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        return ((Boolean) this.ok.call(270001, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }
}
