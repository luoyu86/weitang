package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX INFO: loaded from: classes.dex */
public class MediationAdSlotUtil {
    public static ValueSet getMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
        if (iMediationAdSlot == null) {
            return null;
        }
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8444, iMediationAdSlot.isMuted());
        mediationValueSetBuilderCreate.add(8445, iMediationAdSlot.isSplashShakeButton());
        mediationValueSetBuilderCreate.add(8446, iMediationAdSlot.isSplashPreLoad());
        mediationValueSetBuilderCreate.add(8447, iMediationAdSlot.getVolume());
        mediationValueSetBuilderCreate.add(8448, iMediationAdSlot.isUseSurfaceView());
        mediationValueSetBuilderCreate.add(8449, iMediationAdSlot.getExtraObject());
        mediationValueSetBuilderCreate.add(8450, iMediationAdSlot.isBidNotify());
        mediationValueSetBuilderCreate.add(8451, iMediationAdSlot.getScenarioId());
        mediationValueSetBuilderCreate.add(8454, iMediationAdSlot.isAllowShowCloseBtn());
        mediationValueSetBuilderCreate.add(8455, iMediationAdSlot.getShakeViewWidth());
        mediationValueSetBuilderCreate.add(8456, iMediationAdSlot.getShakeViewHeight());
        mediationValueSetBuilderCreate.add(8459, iMediationAdSlot.getWxAppId());
        return mediationValueSetBuilderCreate.build();
    }

    public static ValueSet getMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
        if (mediationSplashRequestInfo == null) {
            return null;
        }
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8530, mediationSplashRequestInfo.getAdnName());
        mediationValueSetBuilderCreate.add(8531, mediationSplashRequestInfo.getAdnSlotId());
        mediationValueSetBuilderCreate.add(8532, mediationSplashRequestInfo.getAppId());
        mediationValueSetBuilderCreate.add(8533, mediationSplashRequestInfo.getAppkey());
        return mediationValueSetBuilderCreate.build();
    }
}
