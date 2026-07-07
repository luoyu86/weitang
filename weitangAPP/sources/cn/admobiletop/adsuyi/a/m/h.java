package cn.admobiletop.adsuyi.a.m;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.l.s;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static cn.admobiletop.adsuyi.a.g.a a(String str) {
        String strB = s.a().b(b());
        if (strB != null) {
            try {
                JSONObject jSONObject = new JSONObject(strB);
                String strA = d.a(jSONObject.optString("key"), jSONObject.optString(com.alipay.sdk.m.p0.b.f5579d));
                if (strA == null) {
                    return null;
                }
                return d.a(str, new JSONObject(strA), true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void b(String str) {
        s.a().d(b(), str);
    }

    public static String b() {
        return "ADSUYI_INIT_DATA_" + ADSuyiSdk.getInstance().getAppId();
    }

    public static void a(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null) {
            return;
        }
        try {
            String strB = cn.admobiletop.adsuyi.a.d.a.b(jSONObject.toString(), cn.admobiletop.adsuyi.a.d.b.a(str));
            if (strB != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", str);
                jSONObject2.put(com.alipay.sdk.m.p0.b.f5579d, strB);
                b(jSONObject2.toString());
                ADSuyiLogUtil.d("saveInitData...");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
