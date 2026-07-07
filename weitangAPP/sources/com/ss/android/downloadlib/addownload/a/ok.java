package com.ss.android.downloadlib.addownload.a;

import com.ss.android.downloadlib.h.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9776a;
    public long bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9777h;
    public String kf;
    public String n;
    public long ok;
    public volatile long p;
    public String s;

    public ok() {
    }

    public JSONObject ok() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.ok);
            jSONObject.put("mAdId", this.f9776a);
            jSONObject.put("mExtValue", this.bl);
            jSONObject.put("mPackageName", this.s);
            jSONObject.put("mAppName", this.n);
            jSONObject.put("mLogExtra", this.kf);
            jSONObject.put("mFileName", this.f9777h);
            jSONObject.put("mTimeStamp", this.p);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public ok(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.ok = j;
        this.f9776a = j2;
        this.bl = j3;
        this.s = str;
        this.n = str2;
        this.kf = str3;
        this.f9777h = str4;
    }

    public static ok ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ok okVar = new ok();
        try {
            okVar.ok = j.ok(jSONObject, "mDownloadId");
            okVar.f9776a = j.ok(jSONObject, "mAdId");
            okVar.bl = j.ok(jSONObject, "mExtValue");
            okVar.s = jSONObject.optString("mPackageName");
            okVar.n = jSONObject.optString("mAppName");
            okVar.kf = jSONObject.optString("mLogExtra");
            okVar.f9777h = jSONObject.optString("mFileName");
            okVar.p = j.ok(jSONObject, "mTimeStamp");
            return okVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
