package com.ss.android.downloadlib.addownload.compliance;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.h.j;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ok f9795a;
    private int bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9796h;
    private String j;
    private String k;
    private int kf;
    private int n = 15;
    private boolean ok;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9797q;
    private long r;
    private a rh;
    private int s;
    private String t;
    private String z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9798a;
        private int ok;

        public void ok(int i2) {
            this.ok = i2;
        }

        public void ok(String str) {
            this.f9798a = str;
        }
    }

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9799a;
        private long bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<C0132ok> f9800h;
        private String j;
        private String k;
        private String kf;
        private String n;
        private String ok;
        private String p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f9801q;
        private String r;
        private long s;

        /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.compliance.n$ok$ok, reason: collision with other inner class name */
        public static class C0132ok {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f9802a;
            private String ok;

            public void a(String str) {
                this.f9802a = str;
            }

            public void ok(String str) {
                this.ok = str;
            }
        }

        public void a(String str) {
            this.f9799a = str;
        }

        public void bl(String str) {
            this.n = str;
        }

        public void h(String str) {
            this.k = str;
        }

        public void kf(String str) {
            this.f9801q = str;
        }

        public void n(String str) {
            this.p = str;
        }

        public void ok(String str) {
            this.ok = str;
        }

        public void p(String str) {
            this.r = str;
        }

        public void q(String str) {
            this.j = str;
        }

        public void s(String str) {
            this.kf = str;
        }

        public void a(long j) {
            this.s = j;
        }

        public void ok(long j) {
            this.bl = j;
        }

        public void ok(List<C0132ok> list) {
            this.f9800h = list;
        }
    }

    public static n h(String str) {
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ok okVarOk = ok(jSONObject);
            a aVarA = a(jSONObject);
            nVar.ok(okVarOk);
            nVar.ok(aVarA);
            nVar.ok(jSONObject.optInt("show_auth", 0) == 1);
            nVar.ok(jSONObject.optInt("download_permit"));
            nVar.a(jSONObject.optInt("appstore_permit"));
            nVar.bl(jSONObject.optInt("market_online_status", 15));
            nVar.s(jSONObject.optInt("hijack_permit"));
            nVar.ok(jSONObject.optString("package_name"));
            nVar.a(jSONObject.optString("hijack_url"));
            nVar.n(jSONObject.optInt("code"));
            nVar.bl(jSONObject.optString(Constants.SHARED_MESSAGE_ID_FILE));
            nVar.ok(jSONObject.optLong("request_duration", 0L));
            nVar.s(jSONObject.optString("back_web_url"));
            nVar.n(jSONObject.optString("hw_app_id"));
            nVar.kf(jSONObject.optString("deep_link"));
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "ComplianceResult fromJson");
        }
        return nVar;
    }

    public void a(int i2) {
        this.s = i2;
    }

    public void bl(int i2) {
        this.n = i2;
    }

    public void kf(String str) {
        this.z = str;
    }

    public void n(int i2) {
        this.f9797q = i2;
    }

    public void ok(boolean z) {
        this.ok = z;
    }

    public void s(int i2) {
        this.kf = i2;
    }

    public String toString() {
        return ok(this);
    }

    public void a(String str) {
        this.p = str;
    }

    public void bl(String str) {
        this.k = str;
    }

    public void n(String str) {
        this.j = str;
    }

    public void ok(ok okVar) {
        this.f9795a = okVar;
    }

    public void s(String str) {
        this.t = str;
    }

    private static JSONArray bl(ok okVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<ok.C0132ok> list = okVar.f9800h;
        if (list != null && list.size() > 0) {
            for (ok.C0132ok c0132ok : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0132ok.ok);
                jSONObject.putOpt("permission_desc", c0132ok.f9802a);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public String a() {
        return this.z;
    }

    public void ok(int i2) {
        this.bl = i2;
    }

    private static JSONObject a(ok okVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (okVar != null) {
            jSONObject.putOpt("app_name", okVar.ok);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, okVar.f9799a);
            jSONObject.putOpt("update_time", Long.valueOf(okVar.bl));
            jSONObject.putOpt("size", Long.valueOf(okVar.s));
            jSONObject.putOpt("developer_name", okVar.n);
            jSONObject.putOpt("policy_url", okVar.f9801q);
            jSONObject.putOpt("icon_url", okVar.k);
            jSONObject.putOpt("download_url", okVar.r);
            jSONObject.putOpt("permissions", bl(okVar));
            jSONObject.putOpt("permission_classify_url", okVar.p);
            jSONObject.putOpt("desc_url", okVar.j);
        }
        return jSONObject;
    }

    public void ok(String str) {
        this.f9796h = str;
    }

    public int ok() {
        return this.f9797q;
    }

    public void ok(long j) {
        this.r = j;
    }

    public void ok(a aVar) {
        this.rh = aVar;
    }

    public static String ok(n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(nVar.ok ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(nVar.bl));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(nVar.s));
            jSONObject.putOpt("market_online_status", Integer.valueOf(nVar.n));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(nVar.kf));
            jSONObject.putOpt("package_name", nVar.f9796h);
            jSONObject.putOpt("hijack_url", nVar.p);
            jSONObject.putOpt("code", Integer.valueOf(nVar.f9797q));
            jSONObject.putOpt(Constants.SHARED_MESSAGE_ID_FILE, nVar.k);
            jSONObject.putOpt("request_duration", Long.valueOf(nVar.r));
            jSONObject.putOpt("auth_info", a(nVar.f9795a));
            jSONObject.putOpt("status", a(nVar.rh));
            jSONObject.putOpt("back_web_url", nVar.t);
            jSONObject.putOpt("hw_app_id", nVar.j);
            jSONObject.putOpt("deep_link", nVar.z);
        } catch (JSONException e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static a a(JSONObject jSONObject) {
        a aVar = new a();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
            if (jSONObjectOptJSONObject != null) {
                aVar.ok(jSONObjectOptJSONObject.optInt("status"));
                aVar.ok(jSONObjectOptJSONObject.optString(Constants.SHARED_MESSAGE_ID_FILE));
            }
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "ComplianceResult getStatus");
        }
        return aVar;
    }

    private static JSONObject a(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(aVar.ok));
            jSONObject.putOpt(Constants.SHARED_MESSAGE_ID_FILE, aVar.f9798a);
        }
        return jSONObject;
    }

    private static ok ok(JSONObject jSONObject) {
        ok okVar = new ok();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                okVar.ok(jSONObjectOptJSONObject.optString("app_name"));
                okVar.a(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                okVar.ok(j.ok(jSONObjectOptJSONObject, "update_time"));
                okVar.a(j.ok(jSONObjectOptJSONObject, "size"));
                okVar.bl(jSONObjectOptJSONObject.optString("developer_name"));
                okVar.s(jSONObjectOptJSONObject.optString("package_name"));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    ok(jSONArrayOptJSONArray, arrayList);
                    okVar.ok(arrayList);
                }
                okVar.n(jSONObjectOptJSONObject.optString("permission_classify_url"));
                okVar.kf(jSONObjectOptJSONObject.optString("policy_url"));
                okVar.h(jSONObjectOptJSONObject.optString("icon_url"));
                okVar.p(jSONObjectOptJSONObject.optString("download_url"));
                okVar.q(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "ComplianceResult getAuthInfo");
        }
        return okVar;
    }

    private static void ok(JSONArray jSONArray, List<ok.C0132ok> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                ok.C0132ok c0132ok = new ok.C0132ok();
                c0132ok.ok(jSONObjectOptJSONObject.optString("permission_name"));
                c0132ok.a(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0132ok);
            }
        }
    }
}
