package com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* JADX INFO: loaded from: classes.dex */
public class bl {
    public static final ValueSet ok(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        aVarOk.ok(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        aVarOk.ok(265001, mediationConfigUserInfoForSegment.getUserId());
        aVarOk.ok(265002, mediationConfigUserInfoForSegment.getChannel());
        aVarOk.ok(265003, mediationConfigUserInfoForSegment.getSubChannel());
        aVarOk.ok(265004, mediationConfigUserInfoForSegment.getAge());
        aVarOk.ok(265005, mediationConfigUserInfoForSegment.getGender());
        aVarOk.ok(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return aVarOk.a();
    }
}
