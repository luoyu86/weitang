package com.bytedance.sdk.openadsdk.mediation.bridge.native_ad;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediationNativeAd implements Bridge {
    public Bridge mGMAd;
    private MediationAdLoaderImpl ok;

    public MediationNativeAd(MediationAdLoaderImpl mediationAdLoaderImpl, Bridge bridge) {
        this.ok = mediationAdLoaderImpl;
        this.mGMAd = bridge;
        ok();
    }

    private void ok() {
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8035, this);
        this.mGMAd.call(8128, mediationValueSetBuilderCreate.build(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public String getAdm() {
        MediationAdLoaderImpl mediationAdLoaderImpl = this.ok;
        return mediationAdLoaderImpl != null ? mediationAdLoaderImpl.getAdm() : "";
    }

    public double getCpm() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Double) bridge.call(8143, null, Double.class)).doubleValue();
        }
        return 0.0d;
    }

    public int getImageMode() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Integer) bridge.call(6069, null, Integer.class)).intValue();
        }
        return 0;
    }

    public boolean isClientBidding() {
        return this.ok.isClientBidding();
    }

    public boolean isExpress() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Boolean) bridge.call(8196, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isMultiBidding() {
        return this.ok.isMultiBidding();
    }

    public boolean isServerBidding() {
        return this.ok.isServerBidding();
    }

    public boolean isUseCustomVideo() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Boolean) bridge.call(8160, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public void notifyDislikeClick(String str, Map map) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8036, str);
            mediationValueSetBuilderCreate.add(8037, map);
            this.mGMAd.call(8131, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyDislikeOnCancel() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8184, null, Void.class);
        }
    }

    public void notifyDislikeOnShow() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8185, null, Void.class);
        }
    }

    public void notifyDislikeSelect(int i2, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8038, i2);
            mediationValueSetBuilderCreate.add(8039, str);
            this.mGMAd.call(8132, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyNativeValue(ValueSet valueSet) {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8140, valueSet, Void.class);
        }
    }

    public void notifyOnClickAd() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8130, null, Void.class);
        }
    }

    public void notifyOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8062, j);
            mediationValueSetBuilderCreate.add(8063, j2);
            mediationValueSetBuilderCreate.add(8066, str);
            mediationValueSetBuilderCreate.add(8056, str2);
            this.mGMAd.call(8157, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyOnDownloadFinished(long j, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8062, j);
            mediationValueSetBuilderCreate.add(8066, str);
            mediationValueSetBuilderCreate.add(8056, str2);
            this.mGMAd.call(8155, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyOnDownloadPause(long j, long j2, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8062, j);
            mediationValueSetBuilderCreate.add(8063, j2);
            mediationValueSetBuilderCreate.add(8066, str);
            mediationValueSetBuilderCreate.add(8056, str2);
            this.mGMAd.call(8158, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyOnDownloadStarted() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8153, null, Void.class);
        }
    }

    public void notifyOnIdel() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8152, null, Void.class);
        }
    }

    public void notifyOnInstalled(String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8066, str);
            mediationValueSetBuilderCreate.add(8056, str2);
            this.mGMAd.call(8156, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyOnProgressUpdate(long j, long j2, int i2, int i3) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8062, j);
            mediationValueSetBuilderCreate.add(8063, j2);
            mediationValueSetBuilderCreate.add(8064, i2);
            mediationValueSetBuilderCreate.add(8065, i3);
            this.mGMAd.call(8187, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyOnShowAd() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8113, null, Void.class);
        }
    }

    public void notifyOnVideoComplete() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8118, null, Void.class);
        }
    }

    public void notifyOnVideoError(int i2, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8014, i2);
            mediationValueSetBuilderCreate.add(8015, str);
            this.mGMAd.call(8117, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyOnVideoPause() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8146, null, Void.class);
        }
    }

    public void notifyOnVideoResume() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8150, null, Void.class);
        }
    }

    public void notifyOnVideoStart() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8145, null, Void.class);
        }
    }

    public void notifyRenderFail(View view, int i2, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8042, view);
            mediationValueSetBuilderCreate.add(8014, i2);
            mediationValueSetBuilderCreate.add(8015, str);
            this.mGMAd.call(8134, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifyRenderSuccess(float f2, float f3) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8040, f2);
            mediationValueSetBuilderCreate.add(8041, f3);
            this.mGMAd.call(8133, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void shakeViewDismissed() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8197, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
