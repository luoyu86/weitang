package cn.admobiletop.adsuyi.a.a;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(String str, String str2, int i2, String str3, long j, String str4) {
        a(str, str2, i2, str3, 0, j, str4);
    }

    public static void a(String str, String str2, int i2, String str3, int i3, long j, String str4) {
        if (TextUtils.isEmpty(ADSuyiSdk.getInstance().getAppId())) {
            return;
        }
        HashMap map = new HashMap(4);
        map.put("adPositionId", str2);
        map.put("groupId", Long.valueOf(j));
        map.put("sceneId", str4);
        map.put("number", Integer.valueOf(i2));
        if (ADSuyiLogUtil.needShowLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adPositionId", str2);
                jSONObject.put("event", str);
                jSONObject.put("groupId", j);
                jSONObject.put("sceneId", str4);
                jSONObject.put("number", i2);
                StringBuilder sb = new StringBuilder();
                sb.append("--------------  AdPositionReport : ");
                sb.append(jSONObject.toString());
                sb.append(" --------------");
                ADSuyiLogUtil.d(sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        HashMap map2 = new HashMap(4);
        map2.put("adPositionId", str2);
        map2.put("event", str);
        map2.put("number", Integer.valueOf(i2));
        map2.put("groupId", Long.valueOf(j));
        cn.admobiletop.adsuyi.a.h.d.c().a(b.o + "?adPositionId=" + str2 + "&event=" + str + "&number=" + i2 + "&groupId=" + j, map, map2, null);
    }
}
