package com.tianmu.c.h.b;

import android.text.TextUtils;
import com.tianmu.biz.utils.n0;
import com.tianmu.c.i.j;
import com.tianmu.http.listener.SimpleHttpListener;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.biz.web.c f11627a = com.tianmu.c.k.d.d().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f11629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f11630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f11631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f11632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f11633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f11634h;

    public class a extends SimpleHttpListener {
        public a() {
        }

        @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
        public void onRequestFailed(int i2, String str, String str2) {
            if (i2 != -2001 || TextUtils.isEmpty(str2) || c.this.f11627a == null) {
                return;
            }
            c.this.f11627a.a(str2, null, null);
        }
    }

    public c(String str) {
        try {
            com.tianmu.c.h.a.b bVarB = com.tianmu.c.h.d.a.c().b(str);
            if (bVarB != null) {
                this.f11628b = bVarB.b();
                this.f11632f = bVarB.e();
                this.f11629c = bVarB.j();
                this.f11630d = bVarB.d();
                this.f11633g = bVarB.g();
                this.f11631e = bVarB.k();
                this.f11634h = bVarB.c();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        try {
            List<String> list = this.f11633g;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f11633g.size(); i2++) {
                a(this.f11633g.get(i2));
            }
            this.f11633g.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c() {
        try {
            List<String> list = this.f11631e;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f11631e.size(); i2++) {
                a(this.f11631e.get(i2));
            }
            this.f11631e.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d() {
        List<String> list = this.f11630d;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f11630d.size(); i2++) {
            try {
                a(this.f11630d.get(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        this.f11630d.clear();
    }

    public void e() {
        List<String> list = this.f11632f;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f11632f.size(); i2++) {
            try {
                a(this.f11632f.get(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        this.f11632f.clear();
    }

    public void f() {
        try {
            List<String> list = this.f11629c;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f11629c.size(); i2++) {
                a(this.f11629c.get(i2));
            }
            this.f11629c.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str) {
        if (str == null || this.f11627a == null) {
            return;
        }
        String str2 = this.f11628b;
        if (str2 != null) {
            str = str.replace("__CLICK_ID__", str2);
        }
        this.f11627a.a(n0.a(str, this.f11634h).replace(" ", ""), null, new a());
    }

    public void a() {
        com.tianmu.biz.web.c cVar = this.f11627a;
        if (cVar != null) {
            cVar.a();
            this.f11627a = null;
        }
    }

    public c(com.tianmu.d.a.a aVar) {
        this.f11628b = aVar.a();
        this.f11631e = aVar.l();
        this.f11632f = aVar.d();
        this.f11633g = aVar.g();
    }
}
