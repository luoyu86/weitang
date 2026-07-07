package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import com.bytedance.sdk.openadsdk.mediation.ok.ok.k;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediationCustomNativeAd implements Bridge, IMediationCustomNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f6419a;
    private String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6421i;
    private MediationCustomNativeDislikeDialog io;
    private int j;
    private String k;
    private String kf;
    private String n;
    private double ok;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f6422q;
    private int r;
    private List<String> rh;
    private String s;
    private String t;
    private int td;
    private Bridge u;
    private int x;
    private double z;
    private MediationNativeAdAppInfo zz;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i2 == 8127) {
            this.u = (Bridge) valueSet.objectValue(8034, Bridge.class);
        } else if (i2 == 6083) {
            render();
        } else {
            if (i2 == 6081) {
                return (T) getExpressView();
            }
            if (i2 == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder((Bridge) valueSet.objectValue(8071, Bridge.class)));
            } else {
                if (i2 == 8135) {
                    return (T) Boolean.valueOf(hasDislike());
                }
                if (i2 == 8149) {
                    onPause();
                } else if (i2 == 8148) {
                    onResume();
                } else if (i2 == 8109) {
                    onDestroy();
                } else {
                    if (i2 == 8121) {
                        return (T) isReadyCondition();
                    }
                    if (i2 == 8194) {
                        String strStringValue = valueSet.stringValue(8036);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.io;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(strStringValue, map);
                        }
                    } else if (i2 == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.io;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new k(dislikeDialog);
                        }
                    } else {
                        if (i2 == 8320) {
                            return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                        }
                        if (i2 == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i2 == 8225) {
                            MediationApiLog.i("TTMediationSDK", "MediationCustomNativeAd receiveBidResult");
                            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdClick() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8130, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8113, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8184, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i2, String str) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8038, i2);
            mediationValueSetBuilderCreate.add(8039, str);
            this.u.call(8132, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8185, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j, long j2) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8062, j);
            mediationValueSetBuilderCreate.add(8063, j2);
            this.u.call(8187, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8062, j);
            mediationValueSetBuilderCreate.add(8063, j2);
            mediationValueSetBuilderCreate.add(8066, str);
            mediationValueSetBuilderCreate.add(8056, str2);
            this.u.call(8157, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j, String str, String str2) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8062, j);
            mediationValueSetBuilderCreate.add(8066, str);
            mediationValueSetBuilderCreate.add(8056, str2);
            this.u.call(8155, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j, long j2, String str, String str2) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8062, j);
            mediationValueSetBuilderCreate.add(8063, j2);
            mediationValueSetBuilderCreate.add(8066, str);
            mediationValueSetBuilderCreate.add(8056, str2);
            this.u.call(8158, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8152, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8066, str);
            mediationValueSetBuilderCreate.add(8056, str2);
            this.u.call(8156, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i2, String str) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8042, view);
            mediationValueSetBuilderCreate.add(8014, i2);
            mediationValueSetBuilderCreate.add(8015, str);
            this.u.call(8134, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f2, float f3) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8040, f2);
            mediationValueSetBuilderCreate.add(8041, f3);
            this.u.call(8133, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8118, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i2, String str) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8014, i2);
            mediationValueSetBuilderCreate.add(8015, str);
            this.u.call(8117, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8146, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j, long j2) {
        if (this.u != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8072, j);
            mediationValueSetBuilderCreate.add(8073, j2);
            this.u.call(8154, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8150, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        Bridge bridge = this.u;
        if (bridge != null) {
            bridge.call(8145, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        Bridge bridge = this.u;
        if (bridge != null) {
            return ((Integer) bridge.call(8226, null, Integer.class)).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return null;
    }

    public ValueSet getValueSet() {
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8016, this.ok);
        mediationValueSetBuilderCreate.add(8006, this.f6419a);
        mediationValueSetBuilderCreate.add(8045, this.bl);
        mediationValueSetBuilderCreate.add(8046, this.s);
        mediationValueSetBuilderCreate.add(8048, this.n);
        mediationValueSetBuilderCreate.add(8050, this.kf);
        mediationValueSetBuilderCreate.add(8051, this.p);
        mediationValueSetBuilderCreate.add(8052, this.f6420h);
        mediationValueSetBuilderCreate.add(8061, this.f6422q);
        mediationValueSetBuilderCreate.add(8054, this.k);
        mediationValueSetBuilderCreate.add(8420, this.r);
        mediationValueSetBuilderCreate.add(8421, this.j);
        mediationValueSetBuilderCreate.add(8082, this.z);
        mediationValueSetBuilderCreate.add(8053, this.rh);
        mediationValueSetBuilderCreate.add(8049, this.t);
        mediationValueSetBuilderCreate.add(8033, this.f6421i);
        mediationValueSetBuilderCreate.add(8060, this.x);
        mediationValueSetBuilderCreate.add(8059, this.td);
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.zz;
        if (mediationNativeAdAppInfo != null) {
            mediationValueSetBuilderCreate.add(8315, new MediationNativeAppInfoImpl(mediationNativeAdAppInfo));
        }
        return mediationValueSetBuilderCreate.build();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        Bridge bridge = this.u;
        if (bridge != null) {
            return ((Boolean) bridge.call(8110, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isServerBidding() {
        Bridge bridge = this.u;
        if (bridge != null) {
            return ((Boolean) bridge.call(8136, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        Bridge bridge = this.u;
        if (bridge != null) {
            return ((Boolean) bridge.call(8160, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void receiveBidResult(boolean z, double d2, int i2, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.f6422q = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i2) {
        this.x = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d2) {
        this.ok = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.s = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        Bridge bridge = this.u;
        if (bridge != null) {
            this.io = mediationCustomNativeDislikeDialog;
            bridge.call(6085, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z) {
        this.f6421i = z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.n = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i2) {
        this.p = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.rh = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.kf = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i2) {
        this.f6420h = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i2) {
        this.td = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.f6419a = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.zz = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.k = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.t = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d2) {
        this.z = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.bl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i2) {
        this.j = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i2) {
        this.r = i2;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return getValueSet();
    }
}
