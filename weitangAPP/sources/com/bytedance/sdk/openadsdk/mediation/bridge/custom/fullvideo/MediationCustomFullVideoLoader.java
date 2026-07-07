package com.bytedance.sdk.openadsdk.mediation.bridge.custom.fullvideo;

import android.app.Activity;
import androidx.core.view.PointerIconCompat;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationCustomFullVideoLoader extends MediationCustomAdBaseLoader {
    public final void callAdVideoCache() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(8112, null, String.class);
        }
    }

    public final void callFullVideoAdClick() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_VERTICAL_TEXT, null, String.class);
        }
    }

    public final void callFullVideoAdClosed() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null, String.class);
        }
    }

    public final void callFullVideoAdShow() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_TEXT, null, String.class);
        }
    }

    public final void callFullVideoComplete() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1026, null, String.class);
        }
    }

    public final void callFullVideoError() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_GRABBING, null, String.class);
        }
    }

    public final void callFullVideoRewardVerify(MediationRewardItem mediationRewardItem) {
        if (this.mGmAdLoader == null || mediationRewardItem == null) {
            return;
        }
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8017, mediationRewardItem.rewardVerify());
        mediationValueSetBuilderCreate.add(8018, mediationRewardItem.getAmount());
        mediationValueSetBuilderCreate.add(8019, mediationRewardItem.getRewardName());
        mediationValueSetBuilderCreate.add(8075, mediationRewardItem.getCustomData());
        this.mGmAdLoader.call(PointerIconCompat.TYPE_ZOOM_IN, mediationValueSetBuilderCreate.build(), String.class);
    }

    public final void callFullVideoSkippedVideo() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(1037, null, String.class);
        }
    }

    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            this.mGmAdLoader.call(8107, MediationValueSetBuilder.create().build(), String.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 != 8113) {
            if (i2 != 8121) {
                return null;
            }
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader isReadyCondition");
            return (T) isReadyCondition();
        }
        MediationApiLog.i("TTMediationSDK", "MediationCustomFullVideoLoader showAd");
        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
        if (activity == null) {
            return null;
        }
        showAd(activity);
        return null;
    }

    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public abstract void showAd(Activity activity);

    public final void callLoadSuccess(double d2) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8409, d2);
            this.mGmAdLoader.call(8107, mediationValueSetBuilderCreate.build(), String.class);
        }
    }

    public final void callLoadSuccess(Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8075, map);
            this.mGmAdLoader.call(8107, mediationValueSetBuilderCreate.build(), String.class);
        }
    }

    public final void callLoadSuccess(double d2, Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8409, d2);
            mediationValueSetBuilderCreate.add(8075, map);
            this.mGmAdLoader.call(8107, mediationValueSetBuilderCreate.build(), String.class);
        }
    }
}
