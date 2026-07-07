package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationBaseAdBridge implements Bridge {
    public Bridge mGMAd;
    private MediationAdSlotValueSet ok;

    public MediationBaseAdBridge(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
        this.mGMAd = bridge;
        this.ok = mediationAdSlotValueSet;
    }

    public double getCpm() {
        Bridge bridge = this.mGMAd;
        Double d2 = bridge != null ? (Double) bridge.call(8143, null, Double.class) : null;
        if (d2 == null) {
            return 0.0d;
        }
        return d2.doubleValue();
    }

    public Map<String, Object> getCustomData() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.ok;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getExtraObject();
        }
        return null;
    }

    public Object getGdtVideoOption() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.ok;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getGdtVideoOption();
        }
        return null;
    }

    public int getOrientation() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.ok;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getOrientation();
        }
        return 2;
    }

    public int getRewardAmount() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.ok;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRewardAmount();
        }
        return 0;
    }

    public String getRewardName() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.ok;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRewardName();
        }
        return null;
    }

    public MediationAdSlotValueSet getSlotValueSet() {
        return this.ok;
    }

    public String getUserID() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.ok;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getUserId();
        }
        return null;
    }

    public float getVolume() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.ok;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getVolume();
        }
        return 0.0f;
    }

    public abstract boolean hasDestroyed();

    public boolean isMuted() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.ok;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isMuted();
        }
        return false;
    }

    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public abstract void onDestroy();

    public void setCpm(double d2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8016, d2);
            this.mGMAd.call(8111, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void setCpmLevel(String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8058, str);
            this.mGMAd.call(8207, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void setExpress() {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8033, true);
            this.mGMAd.call(8129, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void setImageMode(int i2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8060, i2);
            this.mGMAd.call(8209, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void setLevelTag(String str) {
        if (TextUtils.isEmpty(str) || this.mGMAd == null) {
            return;
        }
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8058, str);
        this.mGMAd.call(8208, mediationValueSetBuilderCreate.build(), Void.class);
    }

    public void setSlotValueSet(MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.ok = mediationAdSlotValueSet;
    }
}
