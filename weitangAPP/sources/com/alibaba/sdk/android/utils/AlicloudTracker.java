package com.alibaba.sdk.android.utils;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f5024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5025b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Map<String, String> f127b = new HashMap();

    public AlicloudTracker(c cVar, String str, String str2) {
        this.f5024a = cVar;
        this.f126a = str;
        this.f5025b = str2;
    }

    public void removeGlobalProperty(String str) {
        if (TextUtils.isEmpty(str) || !this.f127b.containsKey(str)) {
            Log.e("AlicloudTracker", "key is null or key is empty,please check it!");
        } else {
            this.f127b.remove(str);
        }
    }

    public void sendCustomHit(String str, long j, Map<String, String> map) {
        try {
            if (this.f5024a == null) {
                Log.e("AlicloudTracker", "dataTracker is null, can not sendCustomHit");
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(this.f127b);
            map.put("sdkId", this.f126a);
            map.put(Constants.KEY_SDK_VERSION, this.f5025b);
            this.f5024a.sendCustomHit(this.f126a + "_" + str, j, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            Log.e("AlicloudTracker", "key is null or key is empty or value is null,please check it!");
            return;
        }
        if (this.f127b.containsKey(str)) {
            this.f127b.remove(str);
        }
        this.f127b.put(str, str2);
    }

    public void sendCustomHit(String str, Map<String, String> map) {
        sendCustomHit(str, 0L, map);
    }
}
