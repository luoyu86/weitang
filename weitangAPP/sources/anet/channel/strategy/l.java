package anet.channel.strategy;

import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.taobao.accs.utl.BaseMonitor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f667g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f668h;

        public a(JSONObject jSONObject) {
            this.f661a = jSONObject.optInt("port");
            this.f662b = jSONObject.optString("protocol");
            this.f663c = jSONObject.optInt("cto");
            this.f664d = jSONObject.optInt("rto");
            this.f665e = jSONObject.optInt("retry");
            this.f666f = jSONObject.optInt("heartbeat");
            this.f667g = jSONObject.optString("rtt", "");
            this.f668h = jSONObject.optString("publickey");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f673e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f674f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String[] f675g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a[] f676h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final e[] f677i;
        public final boolean j;
        public final boolean k;
        public final int l;

        public b(JSONObject jSONObject) {
            this.f669a = jSONObject.optString("host");
            this.f670b = jSONObject.optInt("ttl");
            this.f671c = jSONObject.optString("safeAisles");
            this.f672d = jSONObject.optString("cname", null);
            this.f673e = jSONObject.optString("unit", null);
            this.j = jSONObject.optInt("clear") == 1;
            this.k = jSONObject.optBoolean("effectNow");
            this.l = jSONObject.optInt("version");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.f674f = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f674f[i2] = jSONArrayOptJSONArray.optString(i2);
                }
            } else {
                this.f674f = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sips");
            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                this.f675g = null;
            } else {
                int length2 = jSONArrayOptJSONArray2.length();
                this.f675g = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f675g[i3] = jSONArrayOptJSONArray2.optString(i3);
                }
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("aisles");
            if (jSONArrayOptJSONArray3 != null) {
                int length3 = jSONArrayOptJSONArray3.length();
                this.f676h = new a[length3];
                for (int i4 = 0; i4 < length3; i4++) {
                    this.f676h[i4] = new a(jSONArrayOptJSONArray3.optJSONObject(i4));
                }
            } else {
                this.f676h = null;
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("strategies");
            if (jSONArrayOptJSONArray4 == null || jSONArrayOptJSONArray4.length() <= 0) {
                this.f677i = null;
                return;
            }
            int length4 = jSONArrayOptJSONArray4.length();
            this.f677i = new e[length4];
            for (int i5 = 0; i5 < length4; i5++) {
                this.f677i[i5] = new e(jSONArrayOptJSONArray4.optJSONObject(i5));
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e[] f679b;

        public c(JSONObject jSONObject) {
            this.f678a = jSONObject.optString("host");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("strategies");
            if (jSONArrayOptJSONArray == null) {
                this.f679b = null;
                return;
            }
            int length = jSONArrayOptJSONArray.length();
            this.f679b = new e[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.f679b[i2] = new e(jSONArrayOptJSONArray.optJSONObject(i2));
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c[] f682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f683d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f684e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f685f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f686g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f687h;

        public d(JSONObject jSONObject) {
            this.f680a = jSONObject.optString("ip");
            this.f683d = jSONObject.optString("uid", null);
            this.f684e = jSONObject.optString("utdid", null);
            this.f685f = jSONObject.optInt(DispatchConstants.CONFIG_VERSION);
            this.f686g = jSONObject.optInt("fcl");
            this.f687h = jSONObject.optInt("fct");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.f681b = new b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f681b[i2] = new b(jSONArrayOptJSONArray.optJSONObject(i2));
                }
            } else {
                this.f681b = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (jSONArrayOptJSONArray2 == null) {
                this.f682c = null;
                return;
            }
            int length2 = jSONArrayOptJSONArray2.length();
            this.f682c = new c[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                this.f682c[i3] = new c(jSONArrayOptJSONArray2.optJSONObject(i3));
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f690c;

        public e(JSONObject jSONObject) {
            this.f688a = jSONObject.optString("ip");
            this.f690c = jSONObject.optString("path");
            this.f689b = new a(jSONObject);
        }
    }

    public static d a(JSONObject jSONObject) {
        try {
            return new d(jSONObject);
        } catch (Exception e2) {
            ALog.e("StrategyResultParser", "Parse HttpDns response failed.", null, e2, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
