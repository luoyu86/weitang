package com.bytedance.sdk.openadsdk.bl.ok.bl;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final ValueSet a(final AdSlot adSlot) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok();
        if (adSlot == null) {
            return null;
        }
        aVarOk.ok(260001, adSlot.getAdId());
        aVarOk.ok(260002, adSlot.getCreativeId());
        aVarOk.ok(260003, adSlot.getExt());
        aVarOk.ok(260004, adSlot.getCodeId());
        aVarOk.ok(260005, adSlot.isAutoPlay());
        aVarOk.ok(260006, adSlot.getImgAcceptedWidth());
        aVarOk.ok(260007, adSlot.getImgAcceptedHeight());
        aVarOk.ok(260008, adSlot.getExpressViewAcceptedWidth());
        aVarOk.ok(260009, adSlot.getExpressViewAcceptedHeight());
        aVarOk.ok(260010, adSlot.isSupportDeepLink());
        aVarOk.ok(260011, adSlot.isSupportRenderConrol());
        aVarOk.ok(2600012, adSlot.getAdCount());
        aVarOk.ok(260013, adSlot.getMediaExtra());
        aVarOk.ok(260014, adSlot.getUserID());
        aVarOk.ok(260015, adSlot.getOrientation());
        aVarOk.ok(260016, adSlot.getNativeAdType());
        aVarOk.ok(260017, adSlot.getExternalABVid());
        aVarOk.ok(260018, adSlot.getAdloadSeq());
        aVarOk.ok(260019, adSlot.getPrimeRit());
        aVarOk.ok(260020, adSlot.getAdType());
        aVarOk.ok(260021, adSlot.getBidAdm());
        aVarOk.ok(260022, adSlot.getUserData());
        aVarOk.ok(260023, adSlot.getAdLoadType());
        aVarOk.ok(260024, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.a.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public String get() {
                return adSlot.getRewardName();
            }
        });
        aVarOk.ok(260025, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.a.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adSlot.getRewardAmount());
            }
        });
        aVarOk.ok(260026, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.a.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(adSlot.isSupportIconStyle());
            }
        });
        aVarOk.ok(260026, adSlot.getMediationAdSlot());
        return aVarOk.a();
    }
}
