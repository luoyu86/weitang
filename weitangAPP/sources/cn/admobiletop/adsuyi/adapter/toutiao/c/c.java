package cn.admobiletop.adsuyi.adapter.toutiao.c;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;

/* JADX INFO: loaded from: classes.dex */
public class c extends TTCustomController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4059a;

    public c(d dVar) {
        this.f4059a = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config == null) {
            return false;
        }
        return config.isCanReadInstallList();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        if (ADSuyiSdk.getInstance().getContext() != null) {
            return ADSuyiSdk.getInstance().getAndroidId(ADSuyiSdk.getInstance().getContext());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        if (ADSuyiSdk.getInstance().getContext() != null) {
            return ADSuyiSdk.getInstance().getImei(ADSuyiSdk.getInstance().getContext());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        return ADSuyiSdk.getInstance().getOAID();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        if (ADSuyiSdk.getInstance().getContext() != null) {
            return ADSuyiSdk.getInstance().getMac(ADSuyiSdk.getInstance().getContext());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public LocationProvider getTTLocation() {
        return new b(this);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        return config == null || config.isCanUsePhoneState();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        return config == null || config.isCanUseLocation();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        return config == null || config.isCanUsePhoneState();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        return config == null || config.isCanUseWifiState();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config == null) {
            return false;
        }
        return config.isCanUseReadWriteExternal();
    }
}
