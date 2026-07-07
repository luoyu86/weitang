package cn.admobiletop.adsuyi.adapter.tianmu;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterSetting;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiTianmuAdapterIniter;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.adapter.tianmu.loader.BannerAdLoader;
import cn.admobiletop.adsuyi.adapter.tianmu.loader.InnerNoticeAdLoader;
import cn.admobiletop.adsuyi.adapter.tianmu.loader.InterstitialAdLoader;
import cn.admobiletop.adsuyi.adapter.tianmu.loader.NativeAdLoader;
import cn.admobiletop.adsuyi.adapter.tianmu.loader.RewardVodAdLoader;
import cn.admobiletop.adsuyi.adapter.tianmu.loader.SplashAdLoader;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import com.tianmu.TianmuSDK;
import com.tianmu.apilib.adapter.AdapterApiLoaderManager;
import com.tianmu.apilib.adapter.iiterface.IAdapterApiLoader;
import com.tianmu.config.TianmuAdConfig;
import com.tianmu.config.TianmuInitConfig;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiIniter implements ADSuyiTianmuAdapterIniter, ADSuyiAdapterSetting {
    public static final String PLATFORM = "tianmu";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f3787a = {"3.8.1.12061"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3788b = false;

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiTianmuAdapterIniter
    public boolean apiLoad(String str) {
        AdapterApiLoaderManager adapterApiLoaderManager;
        IAdapterApiLoader adapterApiLoader;
        if (ADSuyiSdk.getInstance().getContext() == null || (adapterApiLoaderManager = AdapterApiLoaderManager.getInstance()) == null || (adapterApiLoader = adapterApiLoaderManager.getAdapterApiLoader()) == null) {
            return false;
        }
        return adapterApiLoader.apiLoad(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public String getAdapterVersion() {
        return "2.2.0.02022";
    }

    public int getDownloadTipsType() {
        int downloadTip = ADSuyiSdk.getInstance().getDownloadTip();
        if (downloadTip != 0) {
            return (downloadTip == 1 || downloadTip != 2) ? 1 : 2;
        }
        return 0;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public List<String> getSupportADSuyiSdkVersions() {
        return Arrays.asList(f3787a);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public ADSuyiAdapterLoader getSuyiAdapterLoader(String str) {
        if ("banner".equals(str)) {
            return new BannerAdLoader();
        }
        if ("flow".equals(str)) {
            return new NativeAdLoader();
        }
        if (ADSuyiAdType.TYPE_SPLASH.equals(str)) {
            return new SplashAdLoader();
        }
        if ("interstitial".equals(str)) {
            return new InterstitialAdLoader();
        }
        if ("rewardvod".equals(str)) {
            return new RewardVodAdLoader();
        }
        if (ADSuyiAdType.TYPE_INNER_NOTICE.equals(str)) {
            return new InnerNoticeAdLoader();
        }
        return null;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public void init(ADSuyiPlatform aDSuyiPlatform, ADSuyiAdapterIniterExtParams aDSuyiAdapterIniterExtParams) {
        if (f3788b || aDSuyiPlatform == null || !aDSuyiPlatform.check()) {
            return;
        }
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        TianmuSDK.getInstance().init(ADSuyiSdk.getInstance().getContext(), new TianmuInitConfig.Builder().appId(aDSuyiPlatform.getAppId()).debug(config == null || config.isDebug()).isSandbox(config == null || config.isSandbox()).agreePrivacyStrategy(config == null || config.isAgreePrivacyStrategy()).isCanUseLocation(config == null || config.isCanUseLocation()).isCanUsePhoneState(config == null || config.isCanUsePhoneState()).isCanUseWifiState(config == null || config.isCanUseWifiState()).isFlag(true).setMultiprocess(config.isMultiprocess()).setTianmuCustomController(new b(this)).build(), new c(this));
        f3788b = true;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiTianmuAdapterIniter
    public void initMachineId(String str) {
        TianmuAdConfig.getInstance().initMachineId(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiTianmuAdapterIniter
    public void initQuickAppKeywords(List<String> list) {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiTianmuAdapterIniter
    public void initQuickAppMonitor(boolean z) {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public boolean inited() {
        return f3788b;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterSetting
    public void setPersonalizedAdEnabled(boolean z) {
        TianmuSDK.setPersonalizedAds(z);
    }
}
