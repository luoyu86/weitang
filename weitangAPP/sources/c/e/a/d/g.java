package c.e.a.d;

import android.os.Build;
import com.chinavisionary.core.app.config.bo.AppCompatibleDeviceListVo;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.LaboratoryConfig;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile g f1205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppConfigExtVo f1207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LaboratoryConfig f1208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatibleDeviceListVo f1209e;

    public static synchronized g getInstance() {
        if (f1205a == null) {
            synchronized (g.class) {
                if (f1205a == null) {
                    f1205a = new g();
                }
            }
        }
        return f1205a;
    }

    public final void a(AppCompatibleDeviceListVo appCompatibleDeviceListVo) {
        this.f1209e = appCompatibleDeviceListVo;
    }

    public final void b(LaboratoryConfig laboratoryConfig) {
        this.f1208d = laboratoryConfig;
    }

    public AppConfigExtVo getAppConfigExtVo() {
        return this.f1207c;
    }

    public String getOAIDPemUrl() {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        if (appConfigExtVo != null) {
            return appConfigExtVo.getOaidCertUrl();
        }
        return null;
    }

    public boolean isCheckSelfLaboratory(String str) {
        LaboratoryConfig laboratoryConfig = this.f1208d;
        if (laboratoryConfig != null) {
            if (!laboratoryConfig.isAndroidTestEnable()) {
                return true;
            }
            LaboratoryConfig.AndroidBean android2 = this.f1208d.getAndroid();
            if (android2 != null && x.isNotNull(str)) {
                int minVersionCode = android2.getMinVersionCode();
                int maxVersionCode = android2.getMaxVersionCode();
                int appVersion = c.e.a.a.b.getInstance().getAppVersion();
                if (appVersion >= minVersionCode && appVersion <= maxVersionCode) {
                    List<String> userList = android2.getUserList();
                    if (o.isNotEmpty(userList) && userList.contains(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isEnableInterstitialAd() {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        return appConfigExtVo != null && this.f1206b && appConfigExtVo.isHasEnableAd() && this.f1207c.isHasEnableInterstitialAd();
    }

    public boolean isEnableLockInterstitialAd() {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        return appConfigExtVo != null && this.f1206b && appConfigExtVo.isHasEnableAd() && this.f1207c.isHasEnableLockInterstitialAd();
    }

    public boolean isEnableSplashAd() {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        return appConfigExtVo != null && this.f1206b && appConfigExtVo.isHasEnableAd() && this.f1207c.isHasEnableSplashAd();
    }

    public boolean isHasEnableActivityBannerAd() {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        return appConfigExtVo != null && this.f1206b && appConfigExtVo.isHasEnableAd() && this.f1207c.isHasEnableActivityBannerAd();
    }

    public boolean isHasEnableLifeBannerAd() {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        return appConfigExtVo != null && this.f1206b && appConfigExtVo.isHasEnableAd() && this.f1207c.isHasEnableLifeBannerAd();
    }

    public boolean isHasEnableMainBannerAd() {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        return appConfigExtVo != null && this.f1206b && appConfigExtVo.isHasEnableAd() && this.f1207c.isHasEnableMainBannerAd();
    }

    public boolean isHasEnableMeBannerAd() {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        return appConfigExtVo != null && this.f1206b && appConfigExtVo.isHasEnableAd() && this.f1207c.isHasEnableMeBannerAd();
    }

    public boolean isUpdateOAIDPem(int i2) {
        AppConfigExtVo appConfigExtVo = this.f1207c;
        return appConfigExtVo != null && appConfigExtVo.getOaidVersion() > i2;
    }

    public boolean isUseCompatible() {
        AppCompatibleDeviceListVo appCompatibleDeviceListVo = this.f1209e;
        if (appCompatibleDeviceListVo == null || !o.isNotEmpty(appCompatibleDeviceListVo.getDeviceList())) {
            return false;
        }
        return this.f1209e.getDeviceList().contains(Build.BRAND + ":" + Build.MODEL + ":" + Build.VERSION.SDK_INT);
    }

    public void setArgentPrivate(boolean z) {
        this.f1206b = z;
    }

    public void setupAppConfig(AppConfigExtVo appConfigExtVo) {
        this.f1207c = appConfigExtVo;
        if (appConfigExtVo != null) {
            b(appConfigExtVo.getLaboratoryConfig());
            a(appConfigExtVo.getAppCompatibleDeviceListVo());
        }
    }
}
