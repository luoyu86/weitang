package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sun.mail.imap.IMAPStore;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f6341a;
    private static final List<Pair<String, JSONObject>> bl = new CopyOnWriteArrayList();
    public static final Map<String, String> ok = new HashMap();

    public static void a(String str, JSONObject jSONObject) {
        bl.add(new Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject kf(String str, JSONObject jSONObject) {
        String str2 = "5.9.0.8";
        JSONObject jSONObject2 = new JSONObject();
        try {
            int i2 = Build.VERSION.SDK_INT;
            jSONObject.put("os_api", i2);
            jSONObject.put("support_abi", Arrays.toString(i2 >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            jSONObject2.put("ad_sdk_version", "5.9.0.8");
            String strOk = s.ok("com.byted.pangle.m");
            if (!TextUtils.isEmpty(strOk)) {
                str2 = strOk;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put(com.alipay.sdk.m.t.a.k, System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = ok;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Constants.KEY_MODEL, Build.MODEL);
            jSONObject3.put(IMAPStore.ID_VENDOR, Build.MANUFACTURER);
            jSONObject3.put(Constants.KEY_IMEI, map.get(Constants.KEY_IMEI));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private static void n(final String str, final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.n.ok.ok().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ArrayList arrayList = new ArrayList();
                arrayList.add(a.kf(str, jSONObject));
                a.a(arrayList);
            }
        });
    }

    private static void s(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            n(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString("event_name", str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(Bundle.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(List<JSONObject> list) throws Throwable {
        if (list == null) {
            return;
        }
        if (f6341a == null) {
            f6341a = TTAppContextHolder.getContext().getSharedPreferences("tt_sdk_settings_other", 0);
        }
        String str = String.format("https://%s%s", f6341a.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = bl;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(kf((String) pair.first, (JSONObject) pair.second));
                }
                bl.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.a.bl.ok().ok(true, str, com.bytedance.sdk.openadsdk.api.plugin.bl.a.ok(jSONObject).toString().getBytes());
    }

    public static void ok(int i2, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MediationConstant.EXTRA_DURATION, Long.valueOf(j));
            jSONObject.putOpt("code", Integer.valueOf(i2));
            jSONObject.putOpt(Constants.SHARED_MESSAGE_ID_FILE, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        n("plugin_load_failed", jSONObject);
    }

    public static void ok(String str, JSONObject jSONObject) {
        s("zeus_" + str, jSONObject);
    }

    public static void ok() {
        List<Pair<String, JSONObject>> list = bl;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    s((String) pair.first, (JSONObject) pair.second);
                }
            }
            bl.clear();
        } catch (Exception unused) {
        }
    }

    public static void ok(AdConfig adConfig) {
        String str;
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = ok;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        if (pluginUpdateConfig != 0) {
            str = pluginUpdateConfig + "";
        } else {
            str = "2";
        }
        map.put("plugin_update_conf", str);
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put("oaid", customController.getDevOaid());
                map.put(Constants.KEY_IMEI, customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}
