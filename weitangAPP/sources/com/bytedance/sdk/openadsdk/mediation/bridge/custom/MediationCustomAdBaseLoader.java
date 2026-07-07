package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.bytedance.sdk.openadsdk.mediation.ok.ok.ok;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationCustomAdBaseLoader implements IMediationAdLoader {
    public Bridge mGmAdLoader;

    private void ok() {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8405, this);
            this.mGmAdLoader.call(8221, mediationValueSetBuilderCreate.build(), String.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 8241) {
            load((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        } else if (i2 == 8225) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i2 == 8149) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i2 == 8148) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i2 == 8109) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i2, valueSet, cls);
    }

    public final void callLoadFail(int i2, String str) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8014, i2);
            mediationValueSetBuilderCreate.add(8015, str);
            this.mGmAdLoader.call(8123, mediationValueSetBuilderCreate.build(), String.class);
        }
    }

    public abstract <T> T callMethod(int i2, ValueSet valueSet, Class<T> cls);

    public final String getAdm() {
        Bridge bridge = this.mGmAdLoader;
        return bridge != null ? (String) bridge.call(8137, null, String.class) : "";
    }

    public final int getBiddingType() {
        Integer num;
        Bridge bridge = this.mGmAdLoader;
        if (bridge == null || (num = (Integer) bridge.call(8226, null, Integer.class)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final Object getExtraDataNoParse() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return bridge.call(8224, null, Object.class);
        }
        return null;
    }

    public final Bridge getGMBridge() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return (Bridge) bridge.call(8127, null, Bridge.class);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader
    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig mediationLoaderConfigCreate = MediationLoaderConfig.create(valueSet);
        loadInner(context, ok.ok(mediationLoaderConfigCreate.getAdSlotValueSet()), new MediationCustomServiceConfig(mediationLoaderConfigCreate.getMediationCustomServiceConfigValue()), mediationLoaderConfigCreate.getGMCustomAdLoader());
    }

    public abstract void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig);

    public final void loadInner(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig, Bridge bridge) {
        this.mGmAdLoader = bridge;
        ok();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z, double d2, int i2, @Nullable Map<String, Object> map) {
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (this.mGmAdLoader == null || map == null) {
            return;
        }
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8075, map);
        this.mGmAdLoader.call(8227, mediationValueSetBuilderCreate.build(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
