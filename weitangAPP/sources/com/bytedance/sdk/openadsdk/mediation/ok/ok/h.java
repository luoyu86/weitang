package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a {
    private Bridge ok;

    public h(Bridge bridge) {
        super(bridge);
        this.ok = bridge;
    }

    private ValueSet ok(AdSlot adSlot) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(com.bytedance.sdk.openadsdk.bl.ok.bl.a.a(adSlot));
        aVarOk.ok(8302, MediationAdClassLoader.getInstance());
        if (adSlot != null && adSlot.getMediationAdSlot() != null) {
            aVarOk.ok(260026, new n(adSlot.getMediationAdSlot()));
        }
        return aVarOk.a();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        if (this.ok != null) {
            c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
            aVarOk.ok(0, context);
            aVarOk.ok(1, ok(adSlot));
            aVarOk.ok(2, new com.bytedance.sdk.openadsdk.mediation.ok.ok.a.ok(iMediationDrawAdTokenCallback));
            aVarOk.ok(3, MediationAdClassLoader.getInstance());
            this.ok.call(270022, aVarOk.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        if (this.ok != null) {
            c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
            aVarOk.ok(0, context);
            aVarOk.ok(1, ok(adSlot));
            aVarOk.ok(2, new com.bytedance.sdk.openadsdk.mediation.ok.ok.a.bl(iMediationNativeAdTokenCallback));
            aVarOk.ok(3, MediationAdClassLoader.getInstance());
            this.ok.call(270021, aVarOk.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i2, int i3) {
        if (this.ok != null) {
            c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(4);
            aVarOk.ok(0, activity);
            if (list != null) {
                LinkedList linkedList = new LinkedList();
                Iterator<IMediationPreloadRequestInfo> it = list.iterator();
                while (it.hasNext()) {
                    linkedList.add(new p(it.next()));
                }
                aVarOk.ok(1, linkedList);
            }
            aVarOk.ok(2, i2);
            aVarOk.ok(3, i3);
            aVarOk.ok(4, MediationAdClassLoader.getInstance());
            this.ok.call(270013, aVarOk.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        if (this.ok != null) {
            c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
            aVarOk.ok(0, com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.bl.ok(mediationConfigUserInfoForSegment));
            this.ok.call(270014, aVarOk.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        if (this.ok != null) {
            c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
            aVarOk.ok(0, com.bytedance.sdk.openadsdk.bl.ok.bl.s.ok(tTCustomController));
            this.ok.call(270016, aVarOk.a(), Void.class);
        }
    }
}
