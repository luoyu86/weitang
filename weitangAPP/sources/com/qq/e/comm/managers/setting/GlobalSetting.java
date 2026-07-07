package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class GlobalSetting {
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String CONV_OPTIMIZE_KEY = "conv_opt_info";
    public static final String COPPA = "coppa";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String TT_SDK_WRAPPER = "TT";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Integer f9700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f9701b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f9702c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Integer f9703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Boolean f9704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile Boolean f9705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Boolean f9706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile Map<String, String> f9707h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile Map<String, String> f9708i = new HashMap();
    public static final Map<String, String> j = new HashMap();
    public static final JSONObject k = new JSONObject();
    public static volatile String l = null;
    public static volatile String m = null;
    public static volatile String n = null;
    public static volatile String o = null;
    public static volatile String p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f9706g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f9705f;
    }

    public static Integer getChannel() {
        return f9700a;
    }

    public static String getCustomADActivityClassName() {
        return l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return o;
    }

    public static String getCustomPortraitActivityClassName() {
        return m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f9707h);
    }

    public static Integer getPersonalizedState() {
        return f9703d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return j;
    }

    public static JSONObject getSettings() {
        return k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f9704e == null || f9704e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f9706g == null) {
            return true;
        }
        return f9706g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f9705f == null) {
            return true;
        }
        return f9705f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f9701b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f9702c;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f9704e == null) {
            f9704e = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z) {
        f9706g = Boolean.valueOf(z);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z) {
        f9705f = Boolean.valueOf(z);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            k.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e2.toString());
        }
    }

    public static void setChannel(int i2) {
        if (f9700a == null) {
            f9700a = Integer.valueOf(i2);
        }
    }

    public static void setConvOptimizeInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            k.putOpt(CONV_OPTIMIZE_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setConvOptimizeInfo错误：" + e2.toString());
        }
    }

    public static void setCustomADActivityClassName(String str) {
        l = str;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        try {
            k.putOpt("ecais", Boolean.valueOf(z));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z) {
        f9701b = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f9702c = z;
    }

    public static void setExtraUserData(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.e("参数key和value不能为空！");
                return;
            }
        }
        f9707h = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z) {
        if (map == null) {
            return;
        }
        if (z) {
            f9708i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f9708i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            k.putOpt("media_ext", new JSONObject(f9708i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i2) {
        f9703d = Integer.valueOf(i2);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        j.putAll(map);
    }
}
