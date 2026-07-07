package cn.admobiletop.adsuyi.a.h;

import cn.admobiletop.adsuyi.a.m.j;
import cn.admobiletop.adsuyi.a.m.q;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cn.admobiletop.adsuyi.a.h.a.b f3318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f3319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Object> f3320d;

    public a(String str, Map<String, Object> map, Map<String, Object> map2, cn.admobiletop.adsuyi.a.h.a.b bVar) {
        this.f3317a = str;
        this.f3319c = map == null ? new HashMap<>(1) : map;
        this.f3320d = map2;
        this.f3318b = bVar;
    }

    public final String a(Map<String, Object> map, Map<String, Object> map2, Map<String, String> map3) {
        TreeMap treeMap = new TreeMap();
        if (map != null) {
            treeMap.putAll(map);
        }
        if (map2 != null) {
            treeMap.putAll(map2);
        }
        if (map3 != null) {
            treeMap.putAll(map3);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null && value != null) {
                sb.append("&");
                sb.append(str);
                sb.append("=");
                sb.append(value);
            }
        }
        String strA = j.a(sb.toString().replaceFirst("&", ""));
        if (strA == null) {
            return null;
        }
        return strA.toUpperCase();
    }

    public abstract Map<String, Object> a();

    public final Map<String, String> b(String str) {
        HashMap map = new HashMap(3);
        map.put("x-adm-st", str);
        map.put("x-adm-ts", cn.admobiletop.adsuyi.a.l.d.b().c() + "");
        map.put("x-adm-once", q.a(32));
        return map;
    }

    public abstract String c();

    public final void d() {
        Map<String, Object> map = this.f3319c;
        if (map != null) {
            map.clear();
            this.f3319c = null;
        }
        Map<String, Object> map2 = this.f3320d;
        if (map2 != null) {
            map2.clear();
            this.f3320d = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f3317a == null) {
                return;
            }
            this.f3319c.putAll(a());
            String strA = q.a(32);
            Map<String, String> mapB = b(strA);
            mapB.put("x-adm-sign", a(this.f3320d, this.f3319c, mapB));
            mapB.put("x-adm-sdk-version", "3.9.0.01171");
            String strB = cn.admobiletop.adsuyi.a.d.b.b(strA);
            if (strB == null) {
                return;
            }
            mapB.put("x-adm-st", strB);
            mapB.put("CIBA_RESPONSE_HEADER", "1");
            mapB.put(HttpHeaders.USER_AGENT, c());
            String strB2 = cn.admobiletop.adsuyi.a.d.a.b(new JSONObject(this.f3319c).toString(), strA);
            if (strB2 == null) {
                return;
            }
            if (d.c().a() != null) {
                d.c().a().postJson(this.f3317a, strB2, mapB, this.f3318b);
            }
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
