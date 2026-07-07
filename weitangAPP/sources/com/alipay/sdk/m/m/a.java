package com.alipay.sdk.m.m;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.j;
import com.alipay.sdk.m.u.n;
import com.vivo.identifier.IdentifierConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String A0 = "cfg_max_time";
    public static final String B0 = "get_oa_id";
    public static final String C0 = "notifyFailApp";
    public static final String D0 = "startactivity_in_ui_thread";
    public static final String E = "DynCon";
    public static final String E0 = "scheme_pay_2";
    public static final int F = 10000;
    public static final String F0 = "intercept_batch";
    public static final String G = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final String G0 = "bind_with_startActivity";
    public static final int H = 10;
    public static final String H0 = "startActivity_InsteadOf_Scheme";
    public static final boolean I = false;
    public static final String I0 = "enableStartActivityFallback";
    public static final boolean J = true;
    public static final String J0 = "enableBindExFallback";
    public static final boolean K = false;
    public static a K0 = null;
    public static final boolean L = true;
    public static final boolean M = true;
    public static final String N = "";
    public static final boolean O = false;
    public static final boolean P = false;
    public static final boolean Q = false;
    public static final boolean R = false;
    public static final boolean S = true;
    public static final String T = "";
    public static final boolean U = false;
    public static final boolean V = false;
    public static final boolean W = false;
    public static final int X = 1000;
    public static final boolean Y = true;
    public static final String Z = "";
    public static final boolean a0 = false;
    public static final boolean b0 = false;
    public static final boolean c0 = false;
    public static final int d0 = 1000;
    public static final int e0 = 20000;
    public static final boolean f0 = false;
    public static final String g0 = "alipay_cashier_dynamic_config";
    public static final String h0 = "timeout";
    public static final String i0 = "h5_port_degrade";
    public static final String j0 = "st_sdk_config";
    public static final String k0 = "tbreturl";
    public static final String l0 = "launchAppSwitch";
    public static final String m0 = "configQueryInterval";
    public static final String n0 = "deg_log_mcgw";
    public static final String o0 = "deg_start_srv_first";
    public static final String p0 = "prev_jump_dual";
    public static final String q0 = "use_sc_only";
    public static final String r0 = "retry_aidl_activity_not_start";
    public static final String s0 = "bind_use_imp";
    public static final String t0 = "retry_bnd_once";
    public static final String u0 = "skip_trans";
    public static final String v0 = "start_trans";
    public static final String w0 = "up_before_pay";
    public static final String x0 = "lck_k";
    public static final String y0 = "use_sc_lck_a";
    public static final String z0 = "utdid_factor";
    public JSONObject A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5484a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5485b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5486c = G;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5487d = 10;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5488e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5489f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5490g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5491h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5492i = false;
    public boolean j = true;
    public boolean k = true;
    public String l = "";
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5493q = true;
    public String r = "";
    public String s = "";
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public int y = 1000;
    public boolean z = false;
    public boolean B = true;
    public List<b> C = null;
    public int D = -1;

    /* JADX INFO: renamed from: com.alipay.sdk.m.m.a$a, reason: collision with other inner class name */
    public class RunnableC0084a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.s.a f5494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f5495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f5496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f5497d;

        public RunnableC0084a(com.alipay.sdk.m.s.a aVar, Context context, boolean z, int i2) {
            this.f5494a = aVar;
            this.f5495b = context;
            this.f5496c = z;
            this.f5497d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alipay.sdk.m.p.b bVarA = new com.alipay.sdk.m.q.b().a(this.f5494a, this.f5495b);
                if (bVarA != null) {
                    a.this.a(this.f5494a, bVarA.a());
                    a.this.a(com.alipay.sdk.m.s.a.h());
                    com.alipay.sdk.m.k.a.a(this.f5494a, com.alipay.sdk.m.k.b.l, "offcfg|" + this.f5496c + "|" + this.f5497d);
                }
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    private int C() {
        return this.y;
    }

    public static a D() {
        if (K0 == null) {
            a aVar = new a();
            K0 = aVar;
            aVar.t();
        }
        return K0;
    }

    private JSONObject E() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(h0, k());
        jSONObject.put(i0, y());
        jSONObject.put(k0, r());
        jSONObject.put(m0, d());
        jSONObject.put(l0, b.a(l()));
        jSONObject.put(E0, i());
        jSONObject.put(F0, h());
        jSONObject.put(n0, e());
        jSONObject.put(o0, f());
        jSONObject.put(p0, m());
        jSONObject.put(q0, g());
        jSONObject.put(s0, b());
        jSONObject.put(t0, n());
        jSONObject.put(u0, p());
        jSONObject.put(v0, B());
        jSONObject.put(w0, s());
        jSONObject.put(y0, o());
        jSONObject.put(x0, j());
        jSONObject.put(G0, c());
        jSONObject.put(H0, q());
        jSONObject.put(r0, A());
        jSONObject.put(A0, C());
        jSONObject.put(B0, x());
        jSONObject.put(C0, v());
        jSONObject.put(I0, w());
        jSONObject.put(J0, u());
        jSONObject.put(D0, z());
        jSONObject.put(com.alipay.sdk.m.u.a.f5657b, a());
        return jSONObject;
    }

    public boolean A() {
        return this.x;
    }

    public boolean B() {
        return this.p;
    }

    public boolean b() {
        return this.m;
    }

    public String c() {
        return this.s;
    }

    public int d() {
        return this.f5487d;
    }

    public boolean e() {
        return this.f5492i;
    }

    public boolean f() {
        return this.j;
    }

    public String g() {
        return this.l;
    }

    public boolean h() {
        return this.f5489f;
    }

    public boolean i() {
        return this.f5488e;
    }

    public String j() {
        return this.r;
    }

    public int k() {
        int i2 = this.f5484a;
        if (i2 < 1000 || i2 > 20000) {
            e.b(E, "time(def) = 10000");
            return 10000;
        }
        e.b(E, "time = " + this.f5484a);
        return this.f5484a;
    }

    public List<b> l() {
        return this.C;
    }

    public boolean m() {
        return this.k;
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.w;
    }

    public boolean p() {
        return this.o;
    }

    public boolean q() {
        return this.t;
    }

    public String r() {
        return this.f5486c;
    }

    public boolean s() {
        return this.f5493q;
    }

    public void t() {
        Context contextB = com.alipay.sdk.m.s.b.d().b();
        String strA = j.a(com.alipay.sdk.m.s.a.h(), contextB, g0, null);
        try {
            this.D = Integer.parseInt(j.a(com.alipay.sdk.m.s.a.h(), contextB, z0, IdentifierConstant.OAID_STATE_DEFAULT));
        } catch (Exception unused) {
        }
        a(strA);
    }

    public boolean u() {
        return this.v;
    }

    public boolean v() {
        return this.z;
    }

    public boolean w() {
        return this.u;
    }

    public boolean x() {
        return this.B;
    }

    public boolean y() {
        return this.f5485b;
    }

    public boolean z() {
        return this.f5490g;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f5501c;

        public b(String str, int i2, String str2) {
            this.f5499a = str;
            this.f5500b = i2;
            this.f5501c = str2;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<b> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                b bVarA = a(jSONArray.optJSONObject(i2));
                if (bVarA != null) {
                    arrayList.add(bVarA);
                }
            }
            return arrayList;
        }

        public static JSONObject a(b bVar) {
            if (bVar == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", bVar.f5499a).put("v", bVar.f5500b).put("pk", bVar.f5501c);
            } catch (JSONException e2) {
                e.a(e2);
                return null;
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            return jSONArray;
        }
    }

    public JSONObject a() {
        return this.A;
    }

    public void a(boolean z) {
        this.f5491h = z;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Throwable th) {
            e.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.m.s.a aVar) {
        try {
            JSONObject jSONObjectE = E();
            j.b(aVar, com.alipay.sdk.m.s.b.d().b(), g0, jSONObjectE.toString());
        } catch (Exception e2) {
            e.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.m.s.a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(j0);
            com.alipay.sdk.m.u.a.a(aVar, jSONObjectOptJSONObject, com.alipay.sdk.m.u.a.a(aVar, jSONObject));
            if (jSONObjectOptJSONObject != null) {
                a(jSONObjectOptJSONObject);
            } else {
                e.e(E, "empty config");
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    private void a(JSONObject jSONObject) {
        this.f5484a = jSONObject.optInt(h0, 10000);
        this.f5485b = jSONObject.optBoolean(i0, false);
        this.f5486c = jSONObject.optString(k0, G).trim();
        this.f5487d = jSONObject.optInt(m0, 10);
        this.C = b.a(jSONObject.optJSONArray(l0));
        this.f5488e = jSONObject.optBoolean(E0, false);
        this.f5489f = jSONObject.optBoolean(F0, true);
        this.f5492i = jSONObject.optBoolean(n0, false);
        this.j = jSONObject.optBoolean(o0, true);
        this.k = jSONObject.optBoolean(p0, true);
        this.l = jSONObject.optString(q0, "");
        this.m = jSONObject.optBoolean(s0, false);
        this.n = jSONObject.optBoolean(t0, false);
        this.o = jSONObject.optBoolean(u0, false);
        this.p = jSONObject.optBoolean(v0, false);
        this.f5493q = jSONObject.optBoolean(w0, true);
        this.r = jSONObject.optString(x0, "");
        this.w = jSONObject.optBoolean(y0, false);
        this.x = jSONObject.optBoolean(r0, false);
        this.z = jSONObject.optBoolean(C0, false);
        this.s = jSONObject.optString(G0, "");
        this.t = jSONObject.optBoolean(H0, false);
        this.y = jSONObject.optInt(A0, 1000);
        this.B = jSONObject.optBoolean(B0, true);
        this.u = jSONObject.optBoolean(I0, false);
        this.v = jSONObject.optBoolean(J0, false);
        this.f5490g = jSONObject.optBoolean(D0, false);
        this.A = jSONObject.optJSONObject(com.alipay.sdk.m.u.a.f5657b);
    }

    public void a(com.alipay.sdk.m.s.a aVar, Context context, boolean z, int i2) {
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "oncfg|" + z + "|" + i2);
        RunnableC0084a runnableC0084a = new RunnableC0084a(aVar, context, z, i2);
        if (z && !n.h()) {
            int iC = C();
            if (n.a(iC, runnableC0084a, "AlipayDCPBlok")) {
                return;
            }
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.m0, "" + iC);
            return;
        }
        Thread thread = new Thread(runnableC0084a);
        thread.setName("AlipayDCP");
        thread.start();
    }

    public boolean a(Context context, int i2) {
        if (this.D == -1) {
            this.D = n.a();
            j.b(com.alipay.sdk.m.s.a.h(), context, z0, String.valueOf(this.D));
        }
        return this.D < i2;
    }
}
