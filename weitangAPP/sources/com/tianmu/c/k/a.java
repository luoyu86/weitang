package com.tianmu.c.k;

import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.u0;
import com.tianmu.biz.utils.x;
import com.tianmu.c.n.k;
import com.tianmu.utils.TianmuLogUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tianmu.c.k.f.d f11776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f11777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Object> f11778d;

    public a(String str, Map<String, Object> map, Map<String, Object> map2, com.tianmu.c.k.f.d dVar) {
        this.f11775a = str;
        this.f11777c = map == null ? new HashMap<>(1) : map;
        this.f11778d = map2;
        this.f11776b = dVar;
    }

    private Map<String, String> a(String str) {
        HashMap map = new HashMap(5);
        map.put("x-tm-sdk-appid", TianmuSDK.getInstance().getAppId());
        map.put("x-tm-sdk-version", TianmuSDK.getInstance().getSdkVersion());
        map.put("x-tm-st", str);
        map.put("x-tm-ts", k.h().c() + "");
        map.put("x-tm-once", u0.a(32));
        return map;
    }

    private void d() {
        Map<String, Object> map = this.f11777c;
        if (map != null) {
            map.clear();
            this.f11777c = null;
        }
        Map<String, Object> map2 = this.f11778d;
        if (map2 != null) {
            map2.clear();
            this.f11778d = null;
        }
    }

    public abstract Map<String, Object> a();

    public String b() {
        if (Build.VERSION.SDK_INT < 24) {
            return Locale.getDefault().getLanguage();
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        return locales.size() > 0 ? locales.get(0).getLanguage() : "";
    }

    public abstract String c();

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f11775a == null) {
                return;
            }
            this.f11777c.putAll(a());
            String strA = u0.a(32);
            String strB = com.tianmu.c.d.a.b(new JSONObject(this.f11777c).toString(), strA);
            if (TextUtils.isEmpty(strB)) {
                TianmuLogUtil.e("txPkts:907");
                return;
            }
            String strB2 = com.tianmu.c.d.c.b(strA);
            if (strB2 == null) {
                TianmuLogUtil.e("rxPkts:4968");
                return;
            }
            Map<String, String> mapA = a(strB2);
            mapA.put("x-tm-sign", a(mapA, a(this.f11778d), strB));
            mapA.put("CIBA_RESPONSE_HEADER", "1");
            mapA.put(HttpHeaders.USER_AGENT, c());
            if (e.e().a() != null) {
                e.e().a().a(this.f11775a, strB, mapA, this.f11776b);
            }
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String a(Map<String, String> map, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(b(map));
        stringBuffer.append("::");
        stringBuffer.append(str);
        stringBuffer.append("|");
        stringBuffer.append(str2);
        String strA = x.a(stringBuffer.toString());
        if (strA == null) {
            return null;
        }
        return strA.toUpperCase();
    }

    private String b(Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        if (map != null) {
            treeMap.putAll(map);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str != null && str2 != null) {
                sb.append("&");
                sb.append(str);
                sb.append("=");
                sb.append(str2);
            }
        }
        return sb.toString().replaceFirst("&", "");
    }

    public static String a(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry entry : treeMap.entrySet()) {
            stringBuffer.append(((String) entry.getKey()) + "=" + entry.getValue());
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        return string.endsWith("&") ? string.substring(0, string.lastIndexOf("&")) : string;
    }
}
