package com.ss.android.socialbase.downloader.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.q.p;
import com.taobao.accs.AccsClientConfig;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {
    private static JSONObject bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ok f10044h;
    private static boolean kf;
    private static Boolean n;
    private static JSONObject s;
    private final Boolean k;
    private final JSONObject p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final JSONObject f10045q;
    private int r;
    private static final p<Integer, ok> ok = new p<>(16, 16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ok f10043a = new ok(null);

    static {
        ok();
    }

    private ok(JSONObject jSONObject) {
        Boolean bool;
        this.p = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || kf("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(AccsClientConfig.DEFAULT_CONFIG_TAG) && !kf(AccsClientConfig.DEFAULT_CONFIG_TAG)) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt(AccsClientConfig.DEFAULT_CONFIG_TAG, 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.f10045q = jSONObject2;
        this.k = bool;
    }

    @NonNull
    public static JSONObject a() {
        return bl.v();
    }

    @NonNull
    public static ok bl() {
        return f10043a;
    }

    public static boolean kf(String str) {
        JSONObject jSONObject = bl;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static void ok() {
        JSONObject jSONObjectV = bl.v();
        kf = jSONObjectV.optInt("disable_task_setting", 0) == 1;
        bl = jSONObjectV.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectV.optJSONObject("bugfix");
        Boolean boolValueOf = null;
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(AccsClientConfig.DEFAULT_CONFIG_TAG)) {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt(AccsClientConfig.DEFAULT_CONFIG_TAG, 0) == 1);
        }
        s = jSONObjectOptJSONObject;
        n = boolValueOf;
    }

    public JSONArray n(String str) {
        JSONObject jSONObject = this.p;
        return (jSONObject == null || !jSONObject.has(str) || kf(str)) ? a().optJSONArray(str) : this.p.optJSONArray(str);
    }

    public JSONObject s(String str) {
        JSONObject jSONObject = this.p;
        return (jSONObject == null || !jSONObject.has(str) || kf(str)) ? a().optJSONObject(str) : this.p.optJSONObject(str);
    }

    public boolean a(String str, boolean z) {
        if (this.f10045q != null && !kf(str)) {
            if (this.f10045q.has(str)) {
                return this.f10045q.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.k;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = s;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return s.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = n;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String bl(String str) {
        return ok(str, "");
    }

    private static ok bl(int i2) {
        DownloadInfo downloadInfo;
        if (kf) {
            return f10043a;
        }
        Context contextL = bl.l();
        if (contextL != null && (downloadInfo = Downloader.getInstance(contextL).getDownloadInfo(i2)) != null) {
            return a(downloadInfo);
        }
        return f10043a;
    }

    public static void ok(String str, boolean z) {
        try {
            if (s == null) {
                s = new JSONObject();
            }
            s.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static ok ok(int i2) {
        return ok(i2, (DownloadInfo) null);
    }

    public int a(String str) {
        return ok(str, 0);
    }

    public static void a(int i2) {
        ok okVar = f10044h;
        if (okVar != null && okVar.r == i2) {
            f10044h = null;
        }
        p<Integer, ok> pVar = ok;
        synchronized (pVar) {
            pVar.remove(Integer.valueOf(i2));
        }
    }

    @NonNull
    public static ok ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f10043a;
        }
        return ok(downloadInfo.getId(), downloadInfo);
    }

    private static ok ok(int i2, DownloadInfo downloadInfo) {
        ok okVarBl;
        ok okVar = f10044h;
        if (okVar != null && okVar.r == i2) {
            return okVar;
        }
        p<Integer, ok> pVar = ok;
        synchronized (pVar) {
            okVarBl = pVar.get(Integer.valueOf(i2));
        }
        if (okVarBl == null) {
            okVarBl = downloadInfo == null ? bl(i2) : a(downloadInfo);
            synchronized (pVar) {
                pVar.put(Integer.valueOf(i2), okVarBl);
            }
        }
        okVarBl.r = i2;
        f10044h = okVarBl;
        return okVarBl;
    }

    private static ok a(DownloadInfo downloadInfo) {
        if (kf) {
            return f10043a;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new ok(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f10043a;
    }

    public boolean ok(String str) {
        return a(str, false);
    }

    public int ok(String str, int i2) {
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.p.optInt(str, i2);
        }
        return a().optInt(str, i2);
    }

    public long ok(String str, long j) {
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.p.optLong(str, j);
        }
        return a().optLong(str, j);
    }

    public double ok(String str, double d2) {
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.p.optDouble(str, d2);
        }
        return a().optDouble(str, d2);
    }

    public String ok(String str, String str2) {
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.p.optString(str, str2);
        }
        return a().optString(str, str2);
    }

    @NonNull
    public static ok ok(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != a() && !kf) {
            ok okVar = f10044h;
            if (okVar != null && okVar.p == jSONObject) {
                return okVar;
            }
            p<Integer, ok> pVar = ok;
            synchronized (pVar) {
                for (ok okVar2 : pVar.values()) {
                    if (okVar2.p == jSONObject) {
                        f10044h = okVar2;
                        return okVar2;
                    }
                }
                ok okVar3 = new ok(jSONObject);
                f10044h = okVar3;
                return okVar3;
            }
        }
        return f10043a;
    }

    public static void ok(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == a() || kf) {
            return;
        }
        p<Integer, ok> pVar = ok;
        synchronized (pVar) {
            ok okVar = f10044h;
            if (okVar != null && okVar.p == jSONObject) {
                okVar.r = i2;
            } else {
                okVar = null;
                Iterator<ok> it = pVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ok next = it.next();
                    if (next.p == jSONObject) {
                        next.r = i2;
                        okVar = next;
                        break;
                    }
                }
                if (okVar == null) {
                    okVar = new ok(jSONObject);
                    okVar.r = i2;
                }
                f10044h = okVar;
            }
            ok.put(Integer.valueOf(i2), okVar);
        }
    }
}
