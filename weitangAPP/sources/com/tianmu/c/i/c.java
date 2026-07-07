package com.tianmu.c.i;

import android.text.TextUtils;
import android.view.View;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.model.INativeAd;
import com.tianmu.biz.utils.u0;
import com.tianmu.c.f.c1;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class c implements INativeAd {
    public String A;
    public String B;
    public List<String> C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f11697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f11698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o f11701i;
    public p j;
    public com.tianmu.c.i.a l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f11702q;
    public int r;
    public int s;
    public int t;
    public int u;
    public String v;
    public String w;
    public String x;
    public int y;
    public int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11693a = u0.a(32);
    public com.tianmu.c.o.a k = G();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f11703a = new c();

        public a a(o oVar) {
            this.f11703a.f11701i = oVar;
            return this;
        }

        public a b(List<String> list) {
            this.f11703a.f11698f = list;
            return this;
        }

        public a c(String str) {
            this.f11703a.f11702q = str;
            return this;
        }

        public a d(String str) {
            this.f11703a.f11699g = str;
            return this;
        }

        public a e(String str) {
            this.f11703a.f11696d = str;
            return this;
        }

        public a f(String str) {
            this.f11703a.f11697e = str;
            return this;
        }

        public a g(String str) {
            this.f11703a.f11700h = str;
            return this;
        }

        public a h(String str) {
            this.f11703a.w = str;
            return this;
        }

        public a i(String str) {
            this.f11703a.A = str;
            return this;
        }

        public a j(String str) {
            this.f11703a.f11695c = str;
            return this;
        }

        public a k(String str) {
            this.f11703a.v = str;
            return this;
        }

        public a a(p pVar) {
            this.f11703a.j = pVar;
            return this;
        }

        public a b(int i2) {
            this.f11703a.u = i2;
            return this;
        }

        public a c(int i2) {
            this.f11703a.t = i2;
            return this;
        }

        public a d(int i2) {
            this.f11703a.y = i2;
            return this;
        }

        public a e(int i2) {
            this.f11703a.z = i2;
            return this;
        }

        public a f(int i2) {
            this.f11703a.f11694b = i2;
            return this;
        }

        public a g(int i2) {
            this.f11703a.r = i2;
            return this;
        }

        public a a(com.tianmu.c.i.a aVar) {
            this.f11703a.l = aVar;
            return this;
        }

        public a b(String str) {
            this.f11703a.B = str;
            return this;
        }

        public a a(int i2) {
            this.f11703a.s = i2;
            return this;
        }

        public a a(String str) {
            this.f11703a.x = str;
            return this;
        }

        public a a(List<String> list) {
            this.f11703a.C = list;
            return this;
        }

        public a a(boolean z) {
            this.f11703a.E = z;
            return this;
        }

        public c a() {
            return this.f11703a;
        }
    }

    public String A() {
        return !TextUtils.isEmpty(getDeepLinkUrl()) ? "点击前往查看更多" : I() ? "点击下载查看更多" : "点击查看详情";
    }

    public double B() {
        if (TextUtils.isEmpty(this.A)) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(this.A);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public String C() {
        return !TextUtils.isEmpty(getDeepLinkUrl()) ? "点击前往第三方应用" : I() ? "点击开始下载应用" : "点击前往查看详情";
    }

    public p D() {
        return this.j;
    }

    public List<String> E() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.y();
        }
        return null;
    }

    public String F() {
        return this.v;
    }

    public com.tianmu.c.o.a G() {
        return new com.tianmu.c.o.a();
    }

    public boolean H() {
        return this.p;
    }

    public boolean I() {
        return a() == 3;
    }

    public boolean J() {
        return this.f11694b == 1;
    }

    public boolean K() {
        return false;
    }

    public boolean L() {
        return this.m;
    }

    public boolean M() {
        return this.n;
    }

    public boolean N() {
        return this.y == 2;
    }

    public boolean O() {
        return this.E;
    }

    public boolean P() {
        return this.o;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public String b() {
        return !TextUtils.isEmpty(getDeepLinkUrl()) ? "点击前往" : I() ? "立即下载" : "查看详情";
    }

    public void c(boolean z) {
        this.m = z;
    }

    public void d(boolean z) {
        this.n = z;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public void destroy() {
        this.k = null;
    }

    public void e(boolean z) {
        this.o = z;
    }

    public com.tianmu.c.i.a f() {
        return this.l;
    }

    public List<String> g() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.a();
        }
        return null;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public String getAppIconUrl() {
        com.tianmu.c.i.a aVar = this.l;
        return (aVar == null || TextUtils.isEmpty(aVar.c())) ? this.f11697e : this.l.c();
    }

    @Override // com.tianmu.ad.model.INativeAd
    public String getAppName() {
        com.tianmu.c.i.a aVar = this.l;
        return (aVar == null || TextUtils.isEmpty(aVar.d())) ? this.f11695c : this.l.d();
    }

    @Override // com.tianmu.ad.model.INativeAd
    public String getDeepLinkUrl() {
        return this.f11699g;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public String getDesc() {
        return this.f11696d;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public String getImageUrl() {
        List<String> list;
        return (!TextUtils.isEmpty(this.f11697e) || (list = this.f11698f) == null || list.size() <= 0) ? this.f11697e : this.f11698f.get(0);
    }

    @Override // com.tianmu.ad.model.INativeAd
    public List<String> getImageUrlList() {
        return this.f11698f;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public String getLandingPageUrl() {
        return this.f11700h;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public String getTitle() {
        return this.f11695c;
    }

    public int h() {
        return this.u;
    }

    public int i() {
        int iA;
        return (!com.tianmu.biz.utils.i.b() || (iA = com.tianmu.biz.utils.i.a()) <= 0) ? this.t : iA;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public boolean isLandscape() {
        return this.D;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public boolean isVideo() {
        return false;
    }

    public List<String> j() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public List<String> k() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public List<String> l() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.d();
        }
        return null;
    }

    public List<String> m() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.e();
        }
        return null;
    }

    public List<String> n() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.f();
        }
        return null;
    }

    public List<String> o() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.g();
        }
        return null;
    }

    public List<String> p() {
        return this.C;
    }

    public List<String> q() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.h();
        }
        return null;
    }

    public List<String> r() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.i();
        }
        return null;
    }

    @Override // com.tianmu.ad.model.INativeAd
    public void readyTouch(View view) {
        com.tianmu.c.o.a aVar = this.k;
        if (aVar != null) {
            aVar.a(view);
        }
    }

    public int s() {
        return this.y;
    }

    public int t() {
        return this.z;
    }

    public String u() {
        return this.f11693a;
    }

    public String v() {
        return this.w;
    }

    public int w() {
        return this.r;
    }

    public List<String> x() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.j();
        }
        return null;
    }

    public String y() {
        com.tianmu.c.i.a aVar = this.l;
        return (aVar == null || TextUtils.isEmpty(aVar.b())) ? "" : this.l.b();
    }

    public com.tianmu.c.o.a z() {
        return this.k;
    }

    public int a() {
        return this.s;
    }

    public String c() {
        if (TextUtils.isEmpty(this.x) || this.x.length() <= 0) {
            return this.x;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.x.length(); i4++) {
            i2 = Pattern.compile("[一-龥]").matcher(String.valueOf(this.x.charAt(i4))).find() ? i2 + 2 : i2 + 1;
            if (i2 > 10) {
                break;
            }
            i3++;
        }
        return i3 >= this.x.length() ? this.x : this.x.substring(0, i3);
    }

    public g d() {
        return new g(this.B);
    }

    public String e() {
        return TextUtils.isEmpty(this.x) ? TianmuSDK.getInstance().getContext().getString(c1.j) : TianmuSDK.getInstance().getContext().getString(c1.k);
    }

    public void a(int i2) {
        o oVar = this.f11701i;
        if (oVar != null) {
            oVar.a(i2);
        }
    }

    public void b(boolean z) {
        this.D = z;
    }
}
