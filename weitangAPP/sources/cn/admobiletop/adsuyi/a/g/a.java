package cn.admobiletop.adsuyi.a.g;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f3267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONArray f3268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, ADSuyiPlatform> f3269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, ADSuyiPosId> f3270i;
    public ADSuyiPosId j;
    public String k;
    public JSONArray l;
    public long m;
    public int n;
    public int o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3271q;
    public String r;
    public int s;
    public List<String> t;
    public List<String> u;
    public List<String> v;
    public int w;
    public boolean x;

    public a(int i2, int i3, int i4, String str, String str2, double d2, JSONArray jSONArray, String str3, JSONArray jSONArray2, long j, int i5, int i6, int i7, String str4, int i8, int i9) {
        this.f3262a = i2;
        this.f3263b = i3;
        this.f3264c = i4;
        this.f3265d = str;
        this.f3266e = str2;
        this.f3267f = d2;
        this.f3268g = jSONArray;
        this.k = str3;
        this.l = jSONArray2;
        this.m = j;
        this.n = i5;
        this.o = i6;
        this.f3271q = i7;
        this.r = str4;
        this.s = i8;
        this.w = i9;
    }

    public void a(ADSuyiPosId aDSuyiPosId) {
        this.j = aDSuyiPosId;
    }

    public void b(Map<String, ADSuyiPosId> map) {
        this.f3270i = map;
    }

    public int c() {
        return this.f3263b;
    }

    public int d() {
        return this.f3262a;
    }

    public ADSuyiPosId e() {
        return this.j;
    }

    public int f() {
        return this.f3264c;
    }

    public String g() {
        return this.f3265d;
    }

    public String h() {
        return this.k;
    }

    public String i() {
        return this.f3266e;
    }

    public Map<String, ADSuyiPlatform> j() {
        return this.f3269h;
    }

    public Map<String, ADSuyiPosId> k() {
        return this.f3270i;
    }

    public JSONArray l() {
        return this.f3268g;
    }

    public List<String> m() {
        return this.v;
    }

    public int n() {
        return this.s;
    }

    public String o() {
        return this.r;
    }

    public JSONArray p() {
        return this.l;
    }

    public List<String> q() {
        return this.u;
    }

    public List<String> r() {
        return this.t;
    }

    public long s() {
        return this.m;
    }

    public boolean t() {
        return this.x;
    }

    public boolean u() {
        return n() == 1;
    }

    public boolean v() {
        return this.w == 1;
    }

    public double a() {
        return this.f3267f;
    }

    public int b() {
        return this.f3271q;
    }

    public void c(List<String> list) {
        this.t = list;
    }

    public void a(Map<String, ADSuyiPlatform> map) {
        this.f3269h = map;
    }

    public void b(List<String> list) {
        this.u = list;
    }

    public void a(int i2) {
        this.p = i2;
    }

    public void a(List<String> list) {
        this.v = list;
    }

    public void a(boolean z) {
        this.x = z;
    }
}
