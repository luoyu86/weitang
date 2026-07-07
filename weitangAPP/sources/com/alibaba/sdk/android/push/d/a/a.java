package com.alibaba.sdk.android.push.d.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.sdk.android.ams.common.util.StringUtil;
import com.alibaba.sdk.android.man.util.MANConfig;
import com.alibaba.sdk.android.push.common.util.AppInfoUtil;
import com.alibaba.sdk.android.push.common.util.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.sdk.android.ams.common.b.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4907b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4908c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4909d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f4906a = com.alibaba.sdk.android.ams.common.a.a.h();

    private static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    private static String b(Context context, String str) {
        try {
            return context.getResources().getString(a(context, str));
        } catch (Exception unused) {
            return null;
        }
    }

    private String f() {
        return "mps_deviceId_" + a();
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String a() {
        if (!StringUtil.isEmpty(this.f4907b)) {
            return this.f4907b;
        }
        String strA = com.alibaba.sdk.android.ams.common.a.a.a(MANConfig.MAN_APPKEY_META_DATA_KEY);
        this.f4907b = strA;
        if (!StringUtil.isEmpty(strA)) {
            return this.f4907b;
        }
        String strB = b(com.alibaba.sdk.android.ams.common.a.a.a(), "ams_appKey");
        this.f4907b = strB;
        return strB;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        arrayList.add("appSecret");
        Collections.sort(arrayList);
        for (String str2 : arrayList) {
            if (!str2.equals("VipRequestType")) {
                boolean zEquals = "appSecret".equals(str2);
                sb.append(str2);
                sb.append(zEquals ? d() : map.get(str2));
            }
        }
        if (map.containsKey("VipRequestType")) {
            int i2 = Integer.parseInt(map.get("VipRequestType"));
            map.remove("VipRequestType");
            if (i2 > d.b()) {
                return com.alibaba.sdk.android.ams.common.util.b.a().a(sb.toString());
            }
        }
        return com.alibaba.sdk.android.ams.common.util.b.a().b(sb.toString());
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void a(String str) {
        this.f4909d = str;
        this.f4906a.edit().putString(f(), str).putLong("mps_device_store_time", System.currentTimeMillis()).commit();
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void a(String str, String str2) {
        this.f4906a.edit().putString(str, str2).commit();
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String b() {
        String str = this.f4909d;
        if (str != null) {
            return str;
        }
        String string = this.f4906a.getString(f(), "");
        if (System.currentTimeMillis() - this.f4906a.getLong("mps_device_store_time", 0L) > 604800000) {
            return "";
        }
        this.f4909d = string;
        return string;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void b(String str) {
        this.f4906a.edit().putString("mps_utdid", str).commit();
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String c() {
        return this.f4906a.getString("mps_utdid", "");
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String c(String str) {
        return this.f4906a.getString(str, "");
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String d() {
        if (!StringUtil.isEmpty(this.f4908c)) {
            return this.f4908c;
        }
        String strA = com.alibaba.sdk.android.ams.common.a.a.a(MANConfig.MAN_APPSECRET_META_DATA_KEY);
        this.f4908c = strA;
        if (!StringUtil.isEmpty(strA)) {
            return this.f4908c;
        }
        String strB = b(com.alibaba.sdk.android.ams.common.a.a.a(), "ams_appSecret");
        this.f4908c = strB;
        return strB;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void d(String str) {
        this.f4907b = str;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String e() {
        return AppInfoUtil.getAppVersionName(com.alibaba.sdk.android.ams.common.a.a.a());
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void e(String str) {
        this.f4908c = str;
    }
}
