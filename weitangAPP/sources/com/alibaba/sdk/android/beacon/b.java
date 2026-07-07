package com.alibaba.sdk.android.beacon;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.beacon.Beacon;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4609b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Beacon f75a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Beacon.Config> f4610c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final a f76a = new a();

    public final class a {
        private a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00bb A[Catch: IOException -> 0x00be, TRY_LEAVE, TryCatch #7 {IOException -> 0x00be, blocks: (B:44:0x00b6, B:46:0x00bb), top: B:57:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String a(java.lang.String r7, byte[] r8) throws java.lang.Throwable {
            /*
                r6 = this;
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                r1.<init>(r7)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                r1 = 10000(0x2710, float:1.4013E-41)
                r7.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                r7.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                java.lang.String r1 = "POST"
                r7.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                r1 = 1
                r7.setDoOutput(r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                r7.setDoInput(r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                r1 = 0
                r7.setUseCaches(r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                boolean r1 = com.alibaba.sdk.android.beacon.a.f4607a     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                if (r1 == 0) goto L2f
                java.lang.String r1 = "Host"
                java.lang.String r2 = "beacon-api.aliyuncs.com"
                r7.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
            L2f:
                java.io.OutputStream r1 = r7.getOutputStream()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
                r1.write(r8)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                r1.flush()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                int r8 = r7.getResponseCode()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                boolean r2 = r6.a(r8)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                if (r2 == 0) goto L48
                java.io.InputStream r7 = r7.getInputStream()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                goto L4c
            L48:
                java.io.InputStream r7 = r7.getErrorStream()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
            L4c:
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                java.lang.String r5 = "UTF-8"
                r4.<init>(r7, r5)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
                r7.<init>()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            L5d:
                java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
                if (r0 == 0) goto L67
                r7.append(r0)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
                goto L5d
            L67:
                if (r2 != 0) goto L76
                com.alibaba.sdk.android.beacon.b r0 = com.alibaba.sdk.android.beacon.b.this     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
                java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
                java.lang.String r2 = r7.toString()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
                com.alibaba.sdk.android.beacon.b.a(r0, r8, r2)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            L76:
                java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
                r1.close()     // Catch: java.io.IOException -> L80
                r3.close()     // Catch: java.io.IOException -> L80
            L80:
                return r7
            L81:
                r7 = move-exception
                goto L87
            L83:
                r7 = move-exception
                goto L8b
            L85:
                r7 = move-exception
                r3 = r0
            L87:
                r0 = r1
                goto Lb4
            L89:
                r7 = move-exception
                r3 = r0
            L8b:
                r0 = r1
                goto L92
            L8d:
                r7 = move-exception
                r3 = r0
                goto Lb4
            L90:
                r7 = move-exception
                r3 = r0
            L92:
                java.lang.String r8 = "beacon"
                java.lang.String r1 = r7.getMessage()     // Catch: java.lang.Throwable -> Lb3
                android.util.Log.i(r8, r1, r7)     // Catch: java.lang.Throwable -> Lb3
                com.alibaba.sdk.android.beacon.b r8 = com.alibaba.sdk.android.beacon.b.this     // Catch: java.lang.Throwable -> Lb3
                java.lang.String r1 = "-100"
                java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> Lb3
                com.alibaba.sdk.android.beacon.b.a(r8, r1, r7)     // Catch: java.lang.Throwable -> Lb3
                if (r0 == 0) goto Lab
                r0.close()     // Catch: java.io.IOException -> Lb0
            Lab:
                if (r3 == 0) goto Lb0
                r3.close()     // Catch: java.io.IOException -> Lb0
            Lb0:
                java.lang.String r7 = ""
                return r7
            Lb3:
                r7 = move-exception
            Lb4:
                if (r0 == 0) goto Lb9
                r0.close()     // Catch: java.io.IOException -> Lbe
            Lb9:
                if (r3 == 0) goto Lbe
                r3.close()     // Catch: java.io.IOException -> Lbe
            Lbe:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.beacon.b.a.a(java.lang.String, byte[]):java.lang.String");
        }

        public boolean a(int i2) {
            return i2 >= 200 && i2 < 300;
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.beacon.b$b, reason: collision with other inner class name */
    public static final class C0057b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f4612a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f4613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f4614d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f4615e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f4616f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f4617g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f4618h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f4619i;
        public final String mAppKey;
        public final Map<String, String> mExtras;

        /* JADX INFO: renamed from: com.alibaba.sdk.android.beacon.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Map<String, String> f4620b = new HashMap();
            public String j;
            public String k;
            public String l;
            public String m;
            public String n;
            public String o;
            public String p;

            public a a(String str) {
                this.j = str;
                return this;
            }

            public a a(Map<String, String> map) {
                this.f4620b.putAll(map);
                return this;
            }

            public C0057b a() {
                return new C0057b(this);
            }

            public a b(String str) {
                this.k = str;
                return this;
            }

            public a c(String str) {
                this.l = str;
                return this;
            }

            public a d(String str) {
                this.m = str;
                return this;
            }

            public a e(String str) {
                this.n = str;
                return this;
            }

            public a f(String str) {
                this.o = str;
                return this;
            }

            public a g(String str) {
                this.p = str;
                return this;
            }
        }

        private C0057b(a aVar) {
            this.f4612a = new TreeMap();
            this.mAppKey = aVar.j;
            this.f4613c = aVar.k;
            this.f4614d = aVar.l;
            this.f4615e = aVar.m;
            this.f4616f = aVar.n;
            this.f4617g = aVar.o;
            this.f4618h = aVar.p;
            this.mExtras = aVar.f4620b;
            this.f4619i = a();
        }

        private String a() {
            this.f4612a.put(Constants.KEY_APP_KEY, this.mAppKey);
            this.f4612a.put("appVer", this.f4614d);
            this.f4612a.put(Constants.KEY_OS_TYPE, this.f4615e);
            this.f4612a.put("osVer", this.f4616f);
            this.f4612a.put("deviceId", this.f4617g);
            this.f4612a.put("beaconVer", this.f4618h);
            for (String str : this.mExtras.keySet()) {
                this.f4612a.put(str, this.mExtras.get(str));
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : this.f4612a.keySet()) {
                sb.append(str2);
                sb.append(this.f4612a.get(str2));
            }
            String strA = c.a(this.f4613c, sb.toString());
            this.f4612a.put("sign", strA);
            return strA;
        }
    }

    static {
        String str = com.alibaba.sdk.android.beacon.a.f4607a ? "100.67.64.54" : "beacon-api.aliyuncs.com";
        f4608a = str;
        f4609b = "http://" + str + "/beacon/fetch/config";
    }

    public b(Beacon beacon) {
        this.f75a = beacon;
    }

    private C0057b a(Context context, String str, String str2, Map<String, String> map) {
        return new C0057b.a().a(str).b(str2).c(c.a(context)).d("Android").e(String.valueOf(Build.VERSION.SDK_INT)).f(UTDevice.getUtdid(context)).g("1.0").a(map).a();
    }

    private String a(C0057b c0057b) {
        Map<String, String> map = c0057b.f4612a;
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append(encode(str));
            sb.append("=");
            sb.append(encode(map.get(str)));
            sb.append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void a(String str) {
        b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        this.f75a.a(new Beacon.Error(str, str2));
    }

    private void b(String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            if (TextUtils.isEmpty(str) || (jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("result")) == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            this.f4610c.clear();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i2);
                this.f4610c.add(new Beacon.Config(jSONObject.optString("key"), jSONObject.optString(com.alipay.sdk.m.p0.b.f5579d)));
            }
        } catch (Exception unused) {
        }
    }

    private String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public List<Beacon.Config> a() {
        return Collections.unmodifiableList(this.f4610c);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m35a(Context context, String str, String str2, Map<String, String> map) {
        C0057b c0057bA = a(context, str, str2, map);
        String str3 = f4609b + "/byappkey";
        Log.i("beacon", "url=" + str3);
        String strA = this.f76a.a(str3, a(c0057bA).getBytes());
        Log.i("beacon", "[fetchByAppKey] result: " + strA);
        a(strA);
    }
}
