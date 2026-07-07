package com.alibaba.sdk.android.man.crashreporter.a.c;

import android.content.Context;
import android.os.Build;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.taobao.accs.common.Constants;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.sdk.android.man.crashreporter.a.c.a.a f4697a = null;

    public byte[] a(com.alibaba.sdk.android.man.crashreporter.a.c.a.a aVar, Context context, Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> map) {
        byte[] bArrA;
        if (context == null || aVar == null || map == null) {
            bArrA = null;
        } else {
            this.f4697a = aVar;
            com.alibaba.sdk.android.man.crashreporter.b.a.e("start build crash file");
            try {
                String str = map.get(com.alibaba.sdk.android.man.crashreporter.global.a.IMSI);
                String str2 = map.get(com.alibaba.sdk.android.man.crashreporter.global.a.IMEI);
                String str3 = map.get(com.alibaba.sdk.android.man.crashreporter.global.a.UTDID);
                String str4 = map.get(com.alibaba.sdk.android.man.crashreporter.global.a.IS_BACKGROUD);
                boolean zM43a = (str4 == null || str4.length() <= 0) ? a.m43a(context) : str4.contains(com.alibaba.sdk.android.man.crashreporter.b.f95i);
                String strM44b = map.get(com.alibaba.sdk.android.man.crashreporter.global.a.ACTIVITY);
                if (strM44b == null) {
                    strM44b = a.m44b(context);
                }
                com.alibaba.sdk.android.man.crashreporter.b.a.e("start buildSysMessage");
                this.f4697a.f4696c.put("build", Build.ID);
                this.f4697a.f4696c.put(Constants.KEY_IMEI, str2 == null ? "" : str2);
                Map<String, Object> map2 = this.f4697a.f4696c;
                if (str == null) {
                    str = "";
                }
                map2.put(Constants.KEY_IMSI, str);
                Map<String, Object> map3 = this.f4697a.f4696c;
                if (str2 == null) {
                    str2 = "";
                }
                map3.put("deviceId", str2);
                Map<String, Object> map4 = this.f4697a.f4696c;
                if (str3 == null) {
                    str3 = "";
                }
                map4.put("utdid", str3);
                this.f4697a.f4696c.put(Constants.KEY_BRAND, Build.BRAND);
                this.f4697a.f4696c.put("deviceModel", map.get(com.alibaba.sdk.android.man.crashreporter.global.a.DEVICE_MODEL));
                this.f4697a.f4696c.put("cpuModel", com.alibaba.sdk.android.man.crashreporter.e.a.f());
                this.f4697a.f4696c.put("resolution", map.get(com.alibaba.sdk.android.man.crashreporter.global.a.RESOLUTION));
                this.f4697a.f4696c.put("os", "ANDROID");
                this.f4697a.f4696c.put("osVersion", Build.VERSION.RELEASE);
                this.f4697a.f4696c.put("displayName", Build.DISPLAY);
                this.f4697a.f4696c.put("firmwareName", Build.FINGERPRINT);
                this.f4697a.f4696c.put("firmwareVersion", Build.VERSION.INCREMENTAL);
                this.f4697a.f4696c.put("firmwareBuild", Build.VERSION.CODENAME);
                this.f4697a.f4696c.put("memorySizes", Double.valueOf(a.a(context)));
                this.f4697a.f4696c.put("memoryUsed", Double.valueOf(a.b(context)));
                long[] jArrA = a.a(true);
                this.f4697a.f4696c.put("internalStorageTotal", Long.valueOf(jArrA[0]));
                this.f4697a.f4696c.put("internalStorageFree", Long.valueOf(jArrA[1]));
                this.f4697a.f4696c.put("internalStorageAvailable", Long.valueOf(jArrA[2]));
                String externalStorageState = a.getExternalStorageState();
                this.f4697a.f4696c.put("externalStorageState", externalStorageState);
                if ("mounted".equals(externalStorageState)) {
                    long[] jArrA2 = a.a(false);
                    this.f4697a.f4696c.put("externalStorageTotal", Long.valueOf(jArrA2[0]));
                    this.f4697a.f4696c.put("externalStorageFree", Long.valueOf(jArrA2[1]));
                    this.f4697a.f4696c.put("externalStorageAvailable", Long.valueOf(jArrA2[2]));
                }
                this.f4697a.f4696c.put("isInstallOnSDCard", Boolean.valueOf(a.m45b(context)));
                this.f4697a.f4696c.put("country", map.get(com.alibaba.sdk.android.man.crashreporter.global.a.COUNTRY));
                this.f4697a.f4696c.put("language", map.get(com.alibaba.sdk.android.man.crashreporter.global.a.LANGUAGE));
                com.alibaba.sdk.android.man.crashreporter.b.a.e("start buildOtherMessage");
                this.f4697a.f4696c.put("parentProcessName", "launchd [1]");
                this.f4697a.f4696c.put("processName", a.m42a(context));
                this.f4697a.f4696c.put("isRoot", Boolean.valueOf(a.b()));
                this.f4697a.f4696c.put("isBackground", Boolean.valueOf(zM43a));
                this.f4697a.f4696c.put("clientIp", a.c(context));
                this.f4697a.f4696c.put(DispatchConstants.CARRIER, map.get(com.alibaba.sdk.android.man.crashreporter.global.a.CARRIER));
                this.f4697a.f4696c.put("access", map.get(com.alibaba.sdk.android.man.crashreporter.global.a.ACCESS));
                this.f4697a.f4696c.put("accessSubtype", map.get(com.alibaba.sdk.android.man.crashreporter.global.a.ACCESS_SUBTYPE));
                this.f4697a.f4696c.put("view", strM44b);
                this.f4697a.f4696c.put(TTLiveConstants.BUNDLE_KEY, map.get(com.alibaba.sdk.android.man.crashreporter.global.a.BUNDLE));
                this.f4697a.f4696c.put("operations", "");
                com.alibaba.sdk.android.man.crashreporter.b.a.e("start buildCrashMessage");
                try {
                    String str5 = map.get(com.alibaba.sdk.android.man.crashreporter.global.a.SYS_LOG);
                    if (str5 != null) {
                        if (str5.contains("I/CrashReport") || str5.contains("D/CrashReport")) {
                            this.f4697a.f4696c.put("sysLog", "");
                        } else {
                            this.f4697a.f4696c.put("sysLog", str5);
                        }
                    }
                } catch (Exception unused) {
                }
                this.f4697a.f4696c.put("eventLog", map.get(com.alibaba.sdk.android.man.crashreporter.global.a.EVENTS_LOG));
                this.f4697a.f4696c.put("radioLog", map.get(com.alibaba.sdk.android.man.crashreporter.global.a.RADIO_LOG));
                bArrA = this.f4697a.a();
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("Build data error.", e2);
                bArrA = null;
            }
        }
        com.alibaba.sdk.android.man.crashreporter.b.a.e("end build crash file");
        return bArrA;
    }
}
