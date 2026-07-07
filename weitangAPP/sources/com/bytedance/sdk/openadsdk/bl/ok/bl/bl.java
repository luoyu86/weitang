package com.bytedance.sdk.openadsdk.bl.ok.bl;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* JADX INFO: loaded from: classes.dex */
public class bl {
    public static final ValueSet ok(LocationProvider locationProvider) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok();
        if (locationProvider == null) {
            return null;
        }
        aVarOk.ok(262001, locationProvider.getLatitude());
        aVarOk.ok(262002, locationProvider.getLongitude());
        return aVarOk.a();
    }
}
