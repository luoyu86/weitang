package com.tianmu.biz.utils;

import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.utils.TianmuLogUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null) {
            return;
        }
        try {
            String strB = com.tianmu.c.d.a.b(jSONObject.toString(), com.tianmu.c.d.c.a(str));
            if (strB != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", str);
                jSONObject2.put(com.alipay.sdk.m.p0.b.f5579d, strB);
                b(jSONObject2.toString());
                TianmuLogUtil.d("saveAdConfigMapData...");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static com.tianmu.c.i.b b() {
        String strC = i0.a().c(c());
        if (strC != null) {
            try {
                JSONObject jSONObject = new JSONObject(strC);
                String strA = n.a(jSONObject.optString("key"), jSONObject.optString(com.alipay.sdk.m.p0.b.f5579d));
                if (strA == null) {
                    return null;
                }
                return n.f(new JSONObject(strA));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static String c() {
        return "TIANMU_ADMAP_CONFIG_DATA_" + TianmuSDK.getInstance().getAppId();
    }

    public static String d() {
        return i0.a().c("SP_MAP_DATA_TAG");
    }

    public static boolean e() {
        return i0.a().c(c()) != null;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a();
        }
        i0.a().d(c(), str);
    }

    public static void a(String str) {
        TianmuLogUtil.iD("response config map tag : " + str);
        i0.a().d("SP_MAP_DATA_TAG", str);
    }

    public static void a() {
        TianmuLogUtil.iD("response config map tag clear");
        i0.a().d("SP_MAP_DATA_TAG", null);
    }
}
