package cn.admobiletop.adsuyi.adapter.toutiao;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniterExtParams;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterSetting;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.adapter.toutiao.c.d;
import cn.admobiletop.adsuyi.adapter.toutiao.e.a;
import cn.admobiletop.adsuyi.adapter.toutiao.loader.BannerAdLoader;
import cn.admobiletop.adsuyi.adapter.toutiao.loader.DrawVodAdLoader;
import cn.admobiletop.adsuyi.adapter.toutiao.loader.FullScreenVodAdLoader;
import cn.admobiletop.adsuyi.adapter.toutiao.loader.InterstitialAdLoader;
import cn.admobiletop.adsuyi.adapter.toutiao.loader.NativeAdLoader;
import cn.admobiletop.adsuyi.adapter.toutiao.loader.RewardVodAdLoader;
import cn.admobiletop.adsuyi.adapter.toutiao.loader.SplashAdLoader;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.alipay.sdk.m.p0.b;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiIniter implements ADSuyiAdapterIniter, ADSuyiAdapterSetting {
    public static final String PLATFORM = "toutiao";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f3864a = {"3.8.1.12061"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3865b = false;

    public static void setInited(boolean z) {
        f3865b = z;
    }

    public final String a(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put(b.f5579d, str);
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public String getAdapterVersion() {
        return "5.9.0.8.01161";
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public List<String> getSupportADSuyiSdkVersions() {
        return Arrays.asList(f3864a);
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
        if (ADSuyiAdType.TYPE_DRAW_VOD.equals(str)) {
            return new DrawVodAdLoader();
        }
        return null;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public void init(ADSuyiPlatform aDSuyiPlatform, ADSuyiAdapterIniterExtParams aDSuyiAdapterIniterExtParams) {
        if (f3865b || aDSuyiPlatform == null || !aDSuyiPlatform.check() || TextUtils.isEmpty(aDSuyiPlatform.getAppId())) {
            return;
        }
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            ADSuyiLogUtil.d("toutiao 头条初始化过滤，安卓5.1及以下设备存在系统webview的问题");
        } else {
            d.a().a(aDSuyiPlatform.getAppId(), aDSuyiPlatform.getAppKey());
            f3865b = true;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter
    public boolean inited() {
        return f3865b;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterSetting
    public void setPersonalizedAdEnabled(boolean z) {
        String strA = a(z ? "1" : "0");
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(strA).build());
    }
}
