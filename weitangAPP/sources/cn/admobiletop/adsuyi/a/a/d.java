package cn.admobiletop.adsuyi.a.a;

import android.content.Context;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.l.k;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3175a = true;

    public static void a(cn.admobiletop.adsuyi.a.h.a.b bVar) {
        HashMap map;
        if (f3175a) {
            a(false);
            map = new HashMap();
            map.put("INIT_FIRST_REQUEST", Boolean.TRUE);
        } else {
            map = null;
        }
        cn.admobiletop.adsuyi.a.h.d.c().a(b.l, map, bVar);
    }

    public static void a(String str) {
        Context context = ADSuyiSdk.getInstance().getContext();
        if (context == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.KEY_SDK_VERSION, "3.9.0.01171");
            jSONObject.put("appVersion", ADSuyiPackageUtil.getAppVersion(context));
            jSONObject.put("osVersion", k.d().i());
            jSONObject.put("network", k.d().h(context));
            jSONObject.put("time", cn.admobiletop.adsuyi.a.m.e.a());
            jSONObject.put("detail", str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            HashMap map = new HashMap();
            map.put("items", jSONArray.toString());
            cn.admobiletop.adsuyi.a.h.d.c().a(b.p, map, null);
        } catch (Exception unused) {
        }
    }

    public static void a(boolean z) {
        f3175a = z;
    }
}
