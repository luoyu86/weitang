package com.tianmu.ad.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tianmu.biz.utils.g0;
import com.tianmu.biz.utils.s0;
import com.tianmu.biz.web.BaseWebActivity;
import com.tianmu.biz.web.a;
import com.tianmu.biz.web.b;
import com.tianmu.c.f.c1;
import com.tianmu.c.i.c;
import com.tianmu.c.k.d;
import com.tianmu.c.n.m;
import com.tianmu.c.n.s;
import com.tianmu.http.listener.SimpleHttpListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdDetailActivity extends BaseWebActivity implements a.b, b.f {
    public static String KEY_ADKEY = "adKey";
    public static String KEY_WEB_URL = "webUrl";
    public String n;
    public String o;
    public c p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10553q;
    private boolean r;
    private com.tianmu.biz.web.c s;
    private String t;
    public String u;
    private String v;
    private String w;
    private boolean x;

    private void f() {
        finish();
    }

    private boolean g() {
        return this.x;
    }

    private void h() {
        if (this.r) {
            return;
        }
        this.r = true;
        a(0);
        com.tianmu.biz.web.c cVarA = d.d().a();
        this.s = cVarA;
        cVarA.b(this.o, null, new SimpleHttpListener() { // from class: com.tianmu.ad.activity.AdDetailActivity.1
            @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
            public void onRequestFailed(int i2, String str) {
                s0.a("获取落地页信息失败!");
                AdDetailActivity.this.finish();
            }

            @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
            public void onRequestSuccess(String str) {
                try {
                    AdDetailActivity.this.o = g0.a(str);
                    com.tianmu.c.h.d.a.c().d(AdDetailActivity.this.n, new JSONObject(str).optJSONObject("data").optString("clickid"));
                    AdDetailActivity.this.a(8);
                    AdDetailActivity.this.c();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    s0.a("获取落地页信息失败!");
                    AdDetailActivity.this.finish();
                }
            }
        });
    }

    private void i() {
        if (TextUtils.isEmpty(this.o)) {
            finish();
            return;
        }
        c cVar = this.p;
        if (cVar == null || !cVar.J()) {
            c();
        } else {
            h();
        }
    }

    @Override // com.tianmu.biz.web.BaseWebActivity
    public b b() {
        b bVar = new b(this);
        bVar.a(this.n);
        bVar.a(this);
        return bVar;
    }

    @Override // com.tianmu.biz.web.b.f
    public void checkStartDownload(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    public void d() {
    }

    public boolean e() {
        return false;
    }

    @Override // com.tianmu.biz.web.a.b
    public void getTitle(String str) {
        this.f10914e.setText(str);
    }

    @Override // com.tianmu.biz.web.BaseWebActivity
    public String getWebUrl() {
        return this.o;
    }

    @Override // com.tianmu.biz.web.BaseWebActivity
    public void initData() {
        this.n = getIntent().getStringExtra(KEY_ADKEY);
        this.o = getIntent().getStringExtra(KEY_WEB_URL);
        c cVarA = com.tianmu.c.n.a.a().a(this.n);
        this.p = cVarA;
        if (cVarA == null) {
            a(c1.r, c1.s);
            return;
        }
        String deepLinkUrl = cVarA.getDeepLinkUrl();
        this.t = deepLinkUrl;
        this.u = deepLinkUrl;
        if (this.p.D() != null) {
            this.v = this.p.D().a();
            this.w = this.p.D().b();
        }
        d();
        super.initData();
    }

    @Override // com.tianmu.biz.web.BaseWebActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f10553q = true;
        com.tianmu.biz.web.c cVar = this.s;
        if (cVar != null) {
            cVar.a();
            this.s = null;
        }
        com.tianmu.c.n.b.a().a(this.n);
        com.tianmu.c.n.a.a().b(this.n);
        super.onDestroy();
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        checkStartDownload(str, false);
    }

    @Override // com.tianmu.biz.web.a.b
    public void onProgressChanged(int i2) {
        this.f10917h.setProgress(i2);
        this.f10917h.setVisibility(i2 == 100 ? 8 : 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.p == null) {
            return;
        }
        if (g()) {
            com.tianmu.c.n.b.a().a(this.n, 1);
            if (com.tianmu.c.n.b.a().c(this.n)) {
                f();
                return;
            }
        }
        if (TextUtils.isEmpty(this.t)) {
            if (TextUtils.isEmpty(this.v)) {
                this.x = false;
                i();
                return;
            }
            boolean zA = s.d().a(this.v, this.w, this.n);
            this.v = null;
            this.w = null;
            if (zA) {
                f();
                return;
            } else {
                i();
                return;
            }
        }
        boolean zA2 = m.b().a(this, this.t, this.n);
        this.x = zA2;
        this.t = null;
        if (zA2) {
            return;
        }
        boolean zA3 = s.d().a(this.v, this.w, this.n);
        this.v = null;
        this.w = null;
        if (zA3) {
            f();
        } else {
            i();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        m.b().a(this.n);
        if (this.x) {
            com.tianmu.c.n.b.a().a(this.n, 2);
        }
    }

    @Override // com.tianmu.biz.web.a.b
    public void toggledFullscreen(boolean z) {
        if (z) {
            this.f10916g.setVisibility(8);
            getWindow().setFlags(1024, 1024);
        } else {
            this.f10916g.setVisibility(0);
            getWindow().setFlags(2048, 1024);
        }
        setRequestedOrientation(-1);
    }

    @Override // com.tianmu.biz.web.BaseWebActivity
    public a a() {
        a aVar = new a(this.f10913d, this);
        aVar.a(this);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        View view = this.l;
        if (view != null) {
            view.setVisibility(i2);
        }
    }
}
