package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.alipay.sdk.m.p0.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.downloadlib.addownload.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9727a;
    private final String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f9728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f9729i;
    private final Object j;
    private final List<String> k;
    private final String kf;
    private final long n;
    private String ok;
    private final JSONObject p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final JSONObject f9730q;
    private final int r;
    private final boolean rh;
    private final boolean s;
    private final String t;
    private final String z;

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9731a;
        private String bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f9732h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f9733i;
        private int j;
        private Map<String, Object> k;
        private String kf;
        private long n;
        private String ok;
        private JSONObject p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private JSONObject f9734q;
        private List<String> r;
        private String rh;
        private boolean s = false;
        private boolean t = false;
        private JSONObject x;
        private Object z;

        public ok a(String str) {
            this.bl = str;
            return this;
        }

        public ok bl(String str) {
            this.kf = str;
            return this;
        }

        public ok ok(boolean z) {
            this.t = z;
            return this;
        }

        public ok s(String str) {
            this.rh = str;
            return this;
        }

        public ok a(long j) {
            this.f9732h = j;
            return this;
        }

        public ok ok(String str) {
            this.f9731a = str;
            return this;
        }

        public ok a(boolean z) {
            this.s = z;
            return this;
        }

        public ok ok(long j) {
            this.n = j;
            return this;
        }

        public ok a(JSONObject jSONObject) {
            this.f9734q = jSONObject;
            return this;
        }

        public ok ok(JSONObject jSONObject) {
            this.p = jSONObject;
            return this;
        }

        public ok ok(List<String> list) {
            this.r = list;
            return this;
        }

        public ok ok(int i2) {
            this.j = i2;
            return this;
        }

        public ok ok(Object obj) {
            this.z = obj;
            return this;
        }

        public bl ok() {
            if (TextUtils.isEmpty(this.ok)) {
                this.ok = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.p == null) {
                this.p = new JSONObject();
            }
            try {
                Map<String, Object> map = this.k;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.k.entrySet()) {
                        if (!this.p.has(entry.getKey())) {
                            this.p.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.t) {
                    this.f9733i = this.bl;
                    JSONObject jSONObject2 = new JSONObject();
                    this.x = jSONObject2;
                    if (this.s) {
                        jSONObject2.put("ad_extra_data", this.p.toString());
                    } else {
                        Iterator<String> itKeys = this.p.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.x.put(next, this.p.get(next));
                        }
                    }
                    this.x.put("category", this.ok);
                    this.x.put("tag", this.f9731a);
                    this.x.put(b.f5579d, this.n);
                    this.x.put("ext_value", this.f9732h);
                    if (!TextUtils.isEmpty(this.rh)) {
                        this.x.put(TTDownloadField.TT_REFER, this.rh);
                    }
                    JSONObject jSONObject3 = this.f9734q;
                    if (jSONObject3 != null) {
                        this.x = com.ss.android.download.api.bl.a.ok(jSONObject3, this.x);
                    }
                    if (this.s) {
                        if (!this.x.has("log_extra") && !TextUtils.isEmpty(this.kf)) {
                            this.x.put("log_extra", this.kf);
                        }
                        this.x.put("is_ad_event", "1");
                    }
                }
                if (this.s) {
                    jSONObject.put("ad_extra_data", this.p.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.kf)) {
                        jSONObject.put("log_extra", this.kf);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.p);
                }
                if (!TextUtils.isEmpty(this.rh)) {
                    jSONObject.putOpt(TTDownloadField.TT_REFER, this.rh);
                }
                JSONObject jSONObject4 = this.f9734q;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.bl.a.ok(jSONObject4, jSONObject);
                }
                this.p = jSONObject;
            } catch (Exception e2) {
                r.u().ok(e2, "DownloadEventModel build");
            }
            return new bl(this);
        }
    }

    public bl(ok okVar) {
        this.ok = okVar.ok;
        this.f9727a = okVar.f9731a;
        this.bl = okVar.bl;
        this.s = okVar.s;
        this.n = okVar.n;
        this.kf = okVar.kf;
        this.f9728h = okVar.f9732h;
        this.p = okVar.p;
        this.f9730q = okVar.f9734q;
        this.k = okVar.r;
        this.r = okVar.j;
        this.j = okVar.z;
        this.rh = okVar.t;
        this.t = okVar.f9733i;
        this.f9729i = okVar.x;
        this.z = okVar.rh;
    }

    public String a() {
        return this.f9727a;
    }

    public String bl() {
        return this.bl;
    }

    public long h() {
        return this.f9728h;
    }

    public Object j() {
        return this.j;
    }

    public List<String> k() {
        return this.k;
    }

    public String kf() {
        return this.kf;
    }

    public long n() {
        return this.n;
    }

    public String ok() {
        return this.ok;
    }

    public JSONObject p() {
        return this.p;
    }

    public JSONObject q() {
        return this.f9730q;
    }

    public int r() {
        return this.r;
    }

    public String rh() {
        return this.t;
    }

    public boolean s() {
        return this.s;
    }

    public JSONObject t() {
        return this.f9729i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.ok);
        sb.append("\ttag: ");
        sb.append(this.f9727a);
        sb.append("\tlabel: ");
        sb.append(this.bl);
        sb.append("\nisAd: ");
        sb.append(this.s);
        sb.append("\tadId: ");
        sb.append(this.n);
        sb.append("\tlogExtra: ");
        sb.append(this.kf);
        sb.append("\textValue: ");
        sb.append(this.f9728h);
        sb.append("\nextJson: ");
        sb.append(this.p);
        sb.append("\nparamsJson: ");
        sb.append(this.f9730q);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.k;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.r);
        sb.append("\textraObject: ");
        Object obj = this.j;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.rh);
        sb.append("\tV3EventName: ");
        sb.append(this.t);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f9729i;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public boolean z() {
        return this.rh;
    }
}
