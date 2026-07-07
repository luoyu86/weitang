package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.mediation.ok.ok.h;
import com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a;

/* JADX INFO: loaded from: classes.dex */
public class MediationManagerVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Bridge f6393a;
    private static volatile MediationManagerVisitor ok;
    private a bl;

    private MediationManagerVisitor() {
    }

    public static MediationManagerVisitor getInstance() {
        if (ok == null) {
            synchronized (MediationManagerVisitor.class) {
                if (ok == null) {
                    ok = new MediationManagerVisitor();
                }
            }
        }
        return ok;
    }

    public synchronized IMediationManager getMediationManager() {
        if (f6393a == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mediation_manager", "mediation_manager");
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager != null) {
                f6393a = (Bridge) adManager.getExtra(null, bundle);
            }
        }
        if (f6393a == null) {
            return null;
        }
        if (this.bl == null) {
            this.bl = new h(f6393a);
        }
        return this.bl;
    }
}
