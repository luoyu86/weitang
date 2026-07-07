package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MediationInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ValueSet f6425a;
    private ValueSet bl;
    private ValueSet ok;

    private MediationInitConfig(ValueSet valueSet) {
        this.ok = valueSet;
        if (valueSet != null) {
            this.bl = (ValueSet) valueSet.objectValue(8457, ValueSet.class);
            this.f6425a = (ValueSet) this.ok.objectValue(8475, ValueSet.class);
        }
        ok();
    }

    private void bl() {
        MediationApiLog.i("---------  sdk 初始化信息 start ----");
        MediationApiLog.i("isDebug：" + isDebug());
        MediationApiLog.i("getClassName：" + getClassName());
        MediationApiLog.i("getAppId：" + getAppId());
        MediationApiLog.i("getAppName：" + getAppName());
        MediationApiLog.i("getADNName：" + getADNName());
        MediationApiLog.i("getAppKey：" + getAppKey());
        MediationApiLog.i("getInitCallback：" + getInitCallback());
        MediationApiLog.i("getAgeGroup：" + getAgeGroup());
        MediationApiLog.i("isCustom：" + isCustom());
        MediationApiLog.i("getCustomInitConfig：" + getCustomInitConfig());
        MediationApiLog.i("getCustomInitMap：" + getCustomInitMap());
        MediationApiLog.i("getCustomGMConfiguration：" + getCustomGMConfiguration());
        MediationApiLog.i("getKsAdapterVersion：" + getKsAdapterVersion());
        MediationApiLog.i("getGromoreVersion：" + getGromoreVersion());
        MediationApiLog.i("getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        MediationApiLog.i("getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        MediationApiLog.i("getGdtAdapterVersion：" + getGdtAdapterVersion());
        MediationApiLog.i("getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        MediationApiLog.i("getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        MediationApiLog.i("getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        MediationApiLog.i("getUnityAdapterVersion：" + getUnityAdapterVersion());
        MediationApiLog.i("getMap：" + getInitAdnMap());
        MediationApiLog.i("---------  sdk 初始化信息 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double h() {
        Bridge bridge;
        ValueSet valueSetValues;
        ValueSet valueSet = this.f6425a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (valueSetValues = bridge.values()) == null) {
            return -1.0d;
        }
        return valueSetValues.doubleValue(8482);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double kf() {
        Bridge bridge;
        ValueSet valueSetValues;
        ValueSet valueSet = this.f6425a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (valueSetValues = bridge.values()) == null) {
            return -1.0d;
        }
        return valueSetValues.doubleValue(8481);
    }

    private boolean n() {
        ValueSet valueSet = this.ok;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    private void s() {
        MediationApiLog.i("---------  sdk 隐私设置 start ----");
        MediationApiLog.i("isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        MediationApiLog.i("getLocation：" + location);
        if (location != null) {
            MediationApiLog.i("getLocation getLatitude：" + location.getLatitude());
            MediationApiLog.i("getLocation getLongitude：" + location.getLongitude());
        }
        MediationApiLog.i("appList：" + appList());
        MediationApiLog.i("isCanUsePhoneState：" + isCanUsePhoneState());
        MediationApiLog.i("isLimitPersonalAds：" + isLimitPersonalAds());
        MediationApiLog.i("getDevImei：" + getDevImei());
        MediationApiLog.i("isCanUseWifiState：" + isCanUseWifiState());
        MediationApiLog.i("getMacAddress：" + getMacAddress());
        MediationApiLog.i("isCanUseWriteExternal：" + isCanUseWriteExternal());
        MediationApiLog.i("isCanUseAndroidId：" + isCanUseAndroidId());
        MediationApiLog.i("getAndroidId：" + getAndroidId());
        List<String> appList = getAppList();
        MediationApiLog.i("getAppList：" + appList);
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                MediationApiLog.i("getAppList item: " + it.next());
            }
        }
        List<String> devImeis = getDevImeis();
        MediationApiLog.i("getDevImeis：" + devImeis);
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                MediationApiLog.i("getDevImeis item: " + it2.next());
            }
        }
        MediationApiLog.i("getDevOaid：" + getDevOaid());
        MediationApiLog.i("isCanUseOaid：" + isCanUseOaid());
        MediationApiLog.i("isCanUseMacAddress：" + isCanUseMacAddress());
        MediationApiLog.i("isProgrammaticRecommend：" + isProgrammaticRecommend());
        MediationApiLog.i("isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        MediationApiLog.i("---------  sdk 隐私设置 end ----");
    }

    public boolean appList() {
        ValueSet valueSet = this.f6425a;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getADNName() {
        return n() ? this.ok.stringValue(8003) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public int getAgeGroup() {
        if (n()) {
            return this.ok.intValue(7);
        }
        return 0;
    }

    public String getAndroidId() {
        ValueSet valueSet = this.f6425a;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public String getAppId() {
        if (n()) {
            return this.ok.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        return n() ? this.ok.stringValue(8005) : "";
    }

    public List<String> getAppList() {
        Bridge bridge;
        ValueSet valueSetValues;
        ValueSet valueSet = this.f6425a;
        return (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (valueSetValues = bridge.values()) == null) ? new LinkedList() : (List) valueSetValues.objectValue(8476, List.class);
    }

    public String getAppName() {
        return n() ? this.ok.stringValue(8) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getClassName() {
        return n() ? this.ok.stringValue(8010) : "";
    }

    public Bridge getCustomGMConfiguration() {
        if (n()) {
            return (Bridge) this.ok.objectValue(8401, Bridge.class);
        }
        return null;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (n()) {
            return (MediationCustomInitConfig) this.ok.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (n()) {
            return (ValueSet) this.ok.objectValue(8545, ValueSet.class);
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (n()) {
            return (Map) this.ok.objectValue(8400, Map.class);
        }
        return null;
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.bl;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.f6425a;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Bridge bridge;
        ValueSet valueSetValues;
        ValueSet valueSet = this.f6425a;
        return (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (valueSetValues = bridge.values()) == null) ? new LinkedList() : (List) valueSetValues.objectValue(8477, List.class);
    }

    public String getDevOaid() {
        ValueSet valueSet = this.f6425a;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public boolean getHttps() {
        ValueSet valueSet = this.bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? (Map) valueSet.objectValue(8425, Map.class) : new HashMap();
    }

    public Bridge getInitCallback() {
        if (n()) {
            return (Bridge) this.ok.objectValue(8300, Bridge.class);
        }
        return null;
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.bl;
        return valueSet != null ? (Map) valueSet.objectValue(8462, Map.class) : new HashMap();
    }

    public IMediationLocation getLocation() {
        if (kf() == -1.0d || kf() == -1.0d) {
            return null;
        }
        return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
            @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
            public double getLatitude() {
                return MediationInitConfig.this.kf();
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
            public double getLongitude() {
                return MediationInitConfig.this.h();
            }
        };
    }

    public String getMacAddress() {
        ValueSet valueSet = this.f6425a;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public Bridge getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.bl;
        if (valueSet != null) {
            return (Bridge) valueSet.objectValue(8310, Bridge.class);
        }
        return null;
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.bl;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.bl;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.ok;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public ValueSet getValueSet() {
        return this.ok;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.bl;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.f6425a;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.f6425a;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseOaid() {
        Bridge bridge;
        ValueSet valueSetValues;
        ValueSet valueSet = this.f6425a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (valueSetValues = bridge.values()) == null) {
            return true;
        }
        return valueSetValues.booleanValue(8478);
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.f6425a;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.f6425a;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.f6425a;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.f6425a;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isCustom() {
        if (n()) {
            return this.ok.booleanValue(8098);
        }
        return false;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.ok;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Bridge bridge;
        ValueSet valueSetValues;
        ValueSet valueSet = this.f6425a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (valueSetValues = bridge.values()) == null) {
            return false;
        }
        return valueSetValues.booleanValue(8027);
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Bridge bridge;
        ValueSet valueSetValues;
        ValueSet valueSet = this.f6425a;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (valueSetValues = bridge.values()) == null) {
            return true;
        }
        return valueSetValues.booleanValue(8028);
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.bl;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.f6425a = valueSet;
        s();
    }

    private void a() {
        MediationApiLog.i("---------  sdk 聚合信息 start ----");
        MediationApiLog.i("getHttps：" + getHttps());
        MediationApiLog.i("getWxAppId：" + getWxAppId());
        MediationApiLog.i("getPublisherDid：" + getPublisherDid());
        MediationApiLog.i("isOpenAdnTest：" + isOpenAdnTest());
        MediationApiLog.i("getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        MediationApiLog.i("getLocalExtra：" + getLocalExtra());
        MediationApiLog.i("getCustomLocalConfig：" + getCustomLocalConfig());
        MediationApiLog.i("getOpensdkVer：" + getOpensdkVer());
        MediationApiLog.i("isWxInstalled：" + isWxInstalled());
        MediationApiLog.i("isSupportH265：" + isSupportH265());
        MediationApiLog.i("isSupportSplashZoomout：" + isSupportSplashZoomout());
        MediationApiLog.i("---------  sdk 聚合信息 end ----");
    }

    private void ok() {
        MediationApiLog.setDebug(Boolean.valueOf(isDebug()));
        bl();
        s();
        a();
    }
}
