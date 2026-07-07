package com.tianmu.c.b;

import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.utils.TianmuLogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static void a(String str, String str2, int i2, String str3) {
        if (TextUtils.isEmpty(TianmuSDK.getInstance().getAppId())) {
            return;
        }
        HashMap map = new HashMap(3);
        map.put("adPositionId", str2);
        map.put("number", Integer.valueOf(i2));
        map.put("traceId", str3);
        if (TianmuLogUtil.needShowLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adPositionId", str2);
                jSONObject.put("number", i2);
                jSONObject.put("traceId", str3);
                TianmuLogUtil.d("-------------- " + jSONObject.toString() + " --------------");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
