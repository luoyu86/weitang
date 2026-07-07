package cn.admobiletop.adsuyi.adapter.gdt;

import anet.channel.strategy.dispatch.DispatchConstants;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterSetting;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.adapter.gdt.loader.BannerAdLoader;
import cn.admobiletop.adsuyi.adapter.gdt.loader.DrawVodAdLoader;
import cn.admobiletop.adsuyi.adapter.gdt.loader.FullScreenVodAdLoader;
import cn.admobiletop.adsuyi.adapter.gdt.loader.InnerNoticeAdLoader;
import cn.admobiletop.adsuyi.adapter.gdt.loader.InterstitialAdLoader;
import cn.admobiletop.adsuyi.adapter.gdt.loader.NativeAdLoader;
import cn.admobiletop.adsuyi.adapter.gdt.loader.RewardVodAdLoader;
import cn.admobiletop.adsuyi.adapter.gdt.loader.SplashAdLoader;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiIniter implements ADSuyiAdapterIniter, ADSuyiAdapterSetting {
    public static final String PLATFORM = "gdt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f3616a = {"3.8.1.12061"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3617b = false;

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public String getAdapterVersion() {
        return "4.562.1432.01161";
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public List<String> getSupportADSuyiSdkVersions() {
        return Arrays.asList(f3616a);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public ADSuyiAdapterLoader getSuyiAdapterLoader(String str) {
        if (ADSuyiAdType.TYPE_SPLASH.equals(str)) {
            return new SplashAdLoader();
        }
        if ("banner".equals(str)) {
            return new BannerAdLoader();
        }
        if ("flow".equals(str)) {
            return new NativeAdLoader();
        }
        if ("rewardvod".equals(str)) {
            return new RewardVodAdLoader();
        }
        if (ADSuyiAdType.TYPE_FULLSCREEN_VOD.equals(str)) {
            return new FullScreenVodAdLoader();
        }
        if ("interstitial".equals(str)) {
            return new InterstitialAdLoader();
        }
        if (ADSuyiAdType.TYPE_INNER_NOTICE.equals(str)) {
            return new InnerNoticeAdLoader();
        }
        if (ADSuyiAdType.TYPE_DRAW_VOD.equals(str)) {
            return new DrawVodAdLoader();
        }
        return null;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public void init(ADSuyiPlatform aDSuyiPlatform, ADSuyiAdapterIniterExtParams aDSuyiAdapterIniterExtParams) {
        if (f3617b || aDSuyiPlatform == null || !aDSuyiPlatform.check()) {
            return;
        }
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        GlobalSetting.setAgreePrivacyStrategy(config == null || config.isAgreePrivacyStrategy());
        GlobalSetting.setAgreeReadDeviceId(config == null || config.isCanUsePhoneState());
        GlobalSetting.setAgreeReadAndroidId(config == null || config.isCanUsePhoneState());
        GlobalSetting.setEnableCollectAppInstallStatus(config == null || config.isCanReadInstallList());
        HashMap map = new HashMap();
        map.put("mac_address", Boolean.valueOf(config == null || config.isCanUseWifiState()));
        map.put(DispatchConstants.BSSID, Boolean.valueOf(config == null || config.isCanUseWifiState()));
        map.put("ssid", Boolean.valueOf(config == null || config.isCanUseWifiState()));
        map.put("android_id", Boolean.valueOf(config == null || config.isCanUsePhoneState()));
        map.put("device_id", Boolean.valueOf(config == null || config.isCanUsePhoneState()));
        GlobalSetting.setAgreeReadPrivacyInfo(map);
        GDTAdSdk.initWithoutStart(ADSuyiSdk.getInstance().getContext(), aDSuyiPlatform.getAppId());
        GDTAdSdk.start(new a(this));
        f3617b = true;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public boolean inited() {
        return f3617b;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterSetting
    public void setPersonalizedAdEnabled(boolean z) {
        GlobalSetting.setPersonalizedState(!z ? 1 : 0);
    }
}
