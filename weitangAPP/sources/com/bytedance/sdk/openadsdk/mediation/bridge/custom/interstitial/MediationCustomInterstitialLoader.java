package com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial;

import android.app.Activity;
import androidx.core.view.PointerIconCompat;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationCustomInterstitialLoader extends MediationCustomAdBaseLoader {
    public final void callInterstitialAdClick() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_VERTICAL_TEXT, null, String.class);
        }
    }

    public final void callInterstitialAdLeftApplication() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, String.class);
        }
    }

    public final void callInterstitialAdOpened() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null, String.class);
        }
    }

    public final void callInterstitialClosed() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null, String.class);
        }
    }

    public final void callInterstitialShow() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            bridge.call(PointerIconCompat.TYPE_TEXT, null, String.class);
        }
    }

    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            this.mGmAdLoader.call(8107, MediationValueSetBuilder.create().build(), String.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public final <T> T callMethod(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 != 8113) {
            if (i2 != 8121) {
                return null;
            }
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader isReadyCondition");
            return (T) isReadyCondition();
        }
        MediationApiLog.i("TTMediationSDK", "MediationCustomInterstitialLoader showAd");
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
