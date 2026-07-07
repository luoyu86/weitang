package com.alibaba.sdk.android.utils;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudTrackerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AlicloudTrackerManager f5026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private c f128a = new c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.b f129a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, AlicloudTracker> f5027c;

    private AlicloudTrackerManager(Application application) {
        this.f129a = null;
        HashMap map = new HashMap(4);
        map.put("kVersion", "1.1.4");
        map.put("packageName", application.getPackageName());
        this.f128a.a(application, map);
        this.f5027c = new HashMap();
        this.f129a = com.alibaba.sdk.android.utils.crashdefend.b.a(application, this.f128a);
    }

    public static synchronized AlicloudTrackerManager getInstance(Application application) {
        if (application == null) {
            return null;
        }
        if (f5026a == null) {
            f5026a = new AlicloudTrackerManager(application);
        }
        return f5026a;
    }

    public AlicloudTracker getTracker(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("AlicloudTrackerManager", "sdkId or sdkVersion is null");
            return null;
        }
        String str3 = str + str2;
        if (this.f5027c.containsKey(str3)) {
            return this.f5027c.get(str3);
        }
        AlicloudTracker alicloudTracker = new AlicloudTracker(this.f128a, str, str2);
        this.f5027c.put(str3, alicloudTracker);
        return alicloudTracker;
    }

    public boolean registerCrashDefend(String str, String str2, int i2, int i3, SDKMessageCallback sDKMessageCallback) {
        if (this.f129a == null) {
            return false;
        }
        com.alibaba.sdk.android.utils.crashdefend.c cVar = new com.alibaba.sdk.android.utils.crashdefend.c();
        cVar.f138a = str;
        cVar.f140b = str2;
        cVar.f5037a = i2;
        cVar.f5038b = i3;
        return this.f129a.m61a(cVar, sDKMessageCallback);
    }

    public void unregisterCrashDefend(String str, String str2) {
        this.f129a.d(str, str2);
    }
}
