package com.tianmu.c.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tianmu.TianmuSDK;
import com.tianmu.utils.TianmuLogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void a(String str, int i2, String str2) {
        if (TextUtils.isEmpty(TianmuSDK.getInstance().getAppId())) {
            return;
        }
        HashMap map = new HashMap(4);
        map.put("event", str);
        map.put("number", Integer.valueOf(i2));
        map.put("traceId", str2);
        if (TianmuLogUtil.needShowLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", str);
                jSONObject.put("number", i2);
                jSONObject.put("traceId", str2);
                TianmuLogUtil.d("-------------- " + jSONObject.toString() + " --------------");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(String str, int i2, String str2, int i3, int i4) {
        if (TextUtils.isEmpty(TianmuSDK.getInstance().getAppId())) {
            return;
        }
        HashMap map = new HashMap(4);
        map.put("event", str);
        map.put("number", Integer.valueOf(i2));
        map.put("traceId", str2);
        HashMap map2 = new HashMap(2);
        map2.put(MediationConstant.KEY_REASON, Integer.valueOf(i3));
        map2.put("otherBidPrice", Integer.valueOf(i4));
        map.put("winFail", map2);
        if (TianmuLogUtil.needShowLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", str);
                jSONObject.put("number", i2);
                jSONObject.put("traceId", str2);
                jSONObject.put(MediationConstant.KEY_REASON, i3);
                jSONObject.put("otherBidPrice", i4);
                TianmuLogUtil.d("-------------- " + jSONObject.toString() + " --------------");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
