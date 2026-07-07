package com.tianmu.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.c.n.s;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuPackageUtil;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f11219a = {"splash", "interstitial"};

    public static void a(String str, String str2, com.tianmu.c.k.f.d dVar) {
        HashMap map = new HashMap();
        map.put("adPositionId", str);
        Context context = TianmuSDK.getInstance().getContext();
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            jSONArray = TianmuPackageUtil.getAppInstalledPackages(context);
            map.put("installApps", jSONArray);
        }
        String str3 = TianmuSDK.isPersonalizedAds() ? "1" : "0";
        map.put("personalAdsType", str3);
        boolean zB = s.d().b();
        map.put("supportWechat", Boolean.valueOf(zB));
        boolean zA = a(str2);
        map.put("supportMultiAd", Boolean.valueOf(zA));
        if (TianmuLogUtil.needShowLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adPositionId", str);
                jSONObject.put("installApps", jSONArray);
                jSONObject.put("personalAdsType", str3);
                jSONObject.put("supportWechat", zB);
                jSONObject.put("supportMultiAd", zA);
                TianmuLogUtil.d("-------------- " + jSONObject.toString() + " --------------");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        com.tianmu.c.k.e.e().a(c.t, map, dVar);
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(f11219a).contains(str);
    }
}
