package com.tianmu.c.h.f;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.activity.AdDownloadDetailActivity;
import com.tianmu.ad.activity.AppPermissionsActivity;
import com.tianmu.biz.utils.k;
import com.tianmu.biz.utils.s0;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.y;
import com.tianmu.c.n.m;
import com.tianmu.config.TianmuImageLoader;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b extends FrameLayout {
    private int A;
    private final String B;
    private boolean C;
    private BroadcastReceiver D;
    private ProgressBar E;
    private TextView F;
    private RelativeLayout G;
    private TextView H;
    private RelativeLayout I;
    private TextView J;
    private LinearLayout K;
    private TextView L;
    private WebView M;
    private ProgressBar N;
    private int O;
    private AdDownloadDetailActivity P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f11665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f11666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f11667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f11668i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f11669q;
    private final String r;
    private final String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private String x;
    private final boolean y;
    private final int z;

    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            b.this.N.setProgress(i2);
            b.this.N.setVisibility(i2 == 100 ? 8 : 0);
        }
    }

    /* JADX INFO: renamed from: com.tianmu.c.h.f.b$b, reason: collision with other inner class name */
    public class C0208b extends BroadcastReceiver {
        public C0208b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (com.tianmu.c.h.d.a.c().b(b.this.f11661b, b.this.o) != null) {
                b.this.a(intent);
            }
        }
    }

    public class c extends com.tianmu.c.l.a {
        public c() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            if (b.this.A == 0) {
                b.this.b();
                return;
            }
            if (b.this.A == 4) {
                b.this.c();
            } else if (b.this.P != null) {
                b.this.P.initDownloadAndNoticeService();
                b bVar = b.this;
                bVar.a((Activity) bVar.P, true);
            }
        }
    }

    public class d extends com.tianmu.c.l.a {
        public d() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            if (b.this.A == 4) {
                b.this.c();
            }
        }
    }

    public class e extends com.tianmu.c.l.a {
        public e() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            if (b.this.A == 0) {
                b.this.b();
            }
        }
    }

    public class f extends com.tianmu.c.l.a {
        public f() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            b.this.M.setVisibility(0);
            b.this.K.setVisibility(0);
            b.this.M.loadUrl(b.this.p);
        }
    }

    public class g extends com.tianmu.c.l.a {
        public g() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            AppPermissionsActivity.start(b.this.P, b.this.r);
        }
    }

    public class h extends com.tianmu.c.l.a {
        public h() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            b.this.M.setVisibility(0);
            b.this.K.setVisibility(0);
            b.this.M.loadUrl(b.this.f11669q);
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.M.setVisibility(8);
            b.this.K.setVisibility(8);
        }
    }

    public class j extends WebViewClient {
        public j(b bVar) {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public b(AdDownloadDetailActivity adDownloadDetailActivity, String str, String str2, com.tianmu.c.i.c cVar, boolean z, String str3, com.tianmu.c.i.a aVar) {
        super(adDownloadDetailActivity);
        this.C = true;
        this.D = new C0208b();
        this.P = adDownloadDetailActivity;
        String packageName = adDownloadDetailActivity.getPackageName();
        this.f11660a = str;
        this.f11661b = str2;
        this.w = cVar != null ? cVar.getAppIconUrl() : "";
        this.v = cVar != null ? cVar.getTitle() : "";
        this.B = str3;
        String str4 = packageName + ".tianmu.action.download.failed";
        this.f11662c = str4;
        String str5 = packageName + ".tianmu.action.download.success";
        this.f11663d = str5;
        String str6 = packageName + ".tianmu.action.download.installed";
        this.f11664e = str6;
        String str7 = packageName + ".tianmu.action.download.loading";
        this.f11665f = str7;
        String str8 = packageName + ".tianmu.action.download.opened";
        this.f11666g = str8;
        String str9 = packageName + ".tianmu.action.download.idel";
        this.f11667h = str9;
        String str10 = packageName + ".tianmu.action.download.pause";
        this.f11668i = str10;
        String str11 = packageName + ".tianmu.action.download.start";
        this.j = str11;
        String str12 = packageName + ".tianmu.action.download.stop";
        this.k = str12;
        String str13 = packageName + ".tianmu.action.download.progress.update";
        this.l = str13;
        String str14 = packageName + ".tianmu.action.download.notice.stop.click";
        this.m = str14;
        this.y = z;
        this.n = aVar.d();
        this.o = aVar.b();
        this.z = aVar.g();
        this.u = aVar.f();
        this.t = aVar.e();
        this.s = aVar.a();
        this.r = aVar.i();
        this.f11669q = aVar.j();
        this.p = aVar.h();
        d();
        k.a(this.D, str5, str6, str4, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    private void b(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.o));
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
            }
            intent.addFlags(268435456);
            getContext().startActivity(intent);
            com.tianmu.c.i.c cVarB = m.b().b(this.f11661b);
            if (cVarB == null || cVarB.H()) {
                return;
            }
            com.tianmu.c.n.j.b().a(cVarB.g(), false);
            cVarB.a(true);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            com.tianmu.c.h.d.b.a().b(this.f11661b, this.n, this.o, true);
        } catch (Throwable th) {
            s0.a("下载出错了~");
            th.printStackTrace();
        }
    }

    private void d() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(y.f11544a, (ViewGroup) this, false);
        RoundedImageView roundedImageView = (RoundedImageView) viewInflate.findViewById(y.f11545b);
        roundedImageView.a(TianmuDisplayUtil.dp2px(16));
        TextView textView = (TextView) viewInflate.findViewById(y.f11546c);
        TextView textView2 = (TextView) viewInflate.findViewById(y.f11547d);
        TextView textView3 = (TextView) viewInflate.findViewById(y.f11548e);
        TextView textView4 = (TextView) viewInflate.findViewById(y.f11549f);
        TextView textView5 = (TextView) viewInflate.findViewById(y.f11550g);
        TextView textView6 = (TextView) viewInflate.findViewById(y.f11551h);
        this.F = (TextView) viewInflate.findViewById(y.f11552i);
        this.G = (RelativeLayout) viewInflate.findViewById(y.j);
        this.H = (TextView) viewInflate.findViewById(y.k);
        this.I = (RelativeLayout) viewInflate.findViewById(y.l);
        this.J = (TextView) viewInflate.findViewById(y.m);
        this.E = (ProgressBar) viewInflate.findViewById(y.n);
        this.K = (LinearLayout) viewInflate.findViewById(y.o);
        this.L = (TextView) viewInflate.findViewById(y.p);
        this.M = (WebView) viewInflate.findViewById(y.f11553q);
        this.N = (ProgressBar) viewInflate.findViewById(y.r);
        a(this.M);
        TianmuImageLoader imageLoader = TianmuSDK.getInstance().getImageLoader();
        if (imageLoader == null || TextUtils.isEmpty(this.w)) {
            roundedImageView.setImageResource(com.tianmu.c.f.c.r);
        } else {
            imageLoader.loadImage(getContext(), this.w, roundedImageView);
        }
        if (!TextUtils.isEmpty(this.n)) {
            textView.setText(this.n);
        }
        if (TextUtils.isEmpty(this.v)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.v);
        }
        if (!TextUtils.isEmpty(this.u)) {
            if (TextUtils.isEmpty(this.t)) {
                textView3.setText("版本号：" + this.u);
            } else {
                textView3.setText("版本号：" + this.u + "（" + this.t + "）");
            }
        }
        if (!TextUtils.isEmpty(this.s)) {
            textView4.setText("开发者：" + this.s);
        }
        this.F.setOnClickListener(new c());
        this.G.setOnClickListener(new d());
        this.I.setOnClickListener(new e());
        if (!TextUtils.isEmpty(this.p)) {
            textView5.setOnClickListener(new f());
        } else if (!TextUtils.isEmpty(this.r)) {
            textView5.setOnClickListener(new g());
        }
        if (!TextUtils.isEmpty(this.f11669q)) {
            textView6.setOnClickListener(new h());
        }
        this.L.setOnClickListener(new i());
        addView(viewInflate);
    }

    private void e() {
        this.F.setVisibility(0);
        this.G.setVisibility(8);
        this.I.setVisibility(8);
    }

    private void f() {
        this.G.setVisibility(0);
        this.F.setVisibility(8);
        this.I.setVisibility(8);
    }

    private void g() {
        this.I.setVisibility(0);
        this.F.setVisibility(8);
        this.G.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("extraCurrentAdKey");
        String stringExtra2 = intent.getStringExtra("extraAppPackageName");
        String stringExtra3 = intent.getStringExtra("extraRealAppPackageName");
        TextUtils.isEmpty(stringExtra2);
        String str = this.f11661b;
        if ((str != null && str.equals(stringExtra)) || ((!TextUtils.isEmpty(this.o) && this.o.equals(stringExtra2)) || (!TextUtils.isEmpty(this.x) && this.x.equals(stringExtra3)))) {
            this.x = stringExtra3;
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (this.f11662c.equals(action)) {
                com.tianmu.c.h.d.a.c().c(stringExtra, stringExtra2);
                this.A = -1;
                e();
                this.E.setMax(0);
                this.F.setText("下载或安装失败了，点击重试");
                return;
            }
            if (this.f11663d.equals(action)) {
                this.A = 1;
                e();
                this.F.setText("下载完成，点击安装");
                this.E.setVisibility(8);
                return;
            }
            if (this.f11664e.equals(action)) {
                this.A = 2;
                e();
                this.F.setText("应用已安装，点击打开应用");
                this.E.setVisibility(8);
                return;
            }
            if (this.f11666g.equalsIgnoreCase(action)) {
                this.A = 3;
                e();
                this.F.setText("应用已安装，点击打开应用");
                this.E.setVisibility(8);
                return;
            }
            if (this.f11667h.equals(action)) {
                this.A = -2;
                e();
                this.F.setText("立即下载");
                return;
            }
            if (this.f11665f.equals(action)) {
                g();
                this.A = 0;
                if (this.O != 0) {
                    this.J.setText("正在下载 (" + this.O + "%）");
                    return;
                }
                this.J.setText("正在下载");
                return;
            }
            if (this.f11668i.equals(action)) {
                this.A = 4;
                f();
                if (this.O != 0) {
                    this.H.setText("继续下载 (" + this.O + "%）");
                } else {
                    this.H.setText("继续下载");
                }
                com.tianmu.c.h.a.c cVarB = com.tianmu.c.h.d.a.c().b(stringExtra, stringExtra2);
                if (cVarB != null) {
                    if (this.E.getVisibility() == 4) {
                        this.E.setVisibility(0);
                    }
                    this.E.setMax((int) cVarB.i());
                    this.E.setProgress((int) cVarB.e());
                    return;
                }
                this.E.setMax(0);
                this.E.setProgress(0);
                return;
            }
            if (this.k.equals(action)) {
                this.A = -1;
                e();
                this.E.setMax(0);
                this.F.setText("下载或安装失败了，点击重试");
                return;
            }
            if (this.l.equals(action)) {
                long longExtra = intent.getLongExtra("extraCurPos", 0L);
                long longExtra2 = intent.getLongExtra("extraMaxPos", 0L);
                int i2 = longExtra2 != 0 ? (int) ((longExtra / (longExtra2 * 1.0f)) * 100.0f) : 0;
                if (this.E.getVisibility() == 4) {
                    this.E.setVisibility(0);
                    this.F.setText("暂停下载");
                }
                this.E.setMax(100);
                this.E.setProgress(i2);
                g();
                if (longExtra2 != 0) {
                    this.O = (int) ((longExtra / (longExtra2 * 1.0f)) * 100.0f);
                } else {
                    this.O = 0;
                }
                this.J.setText("正在下载 (" + this.O + "%）");
                return;
            }
            if (this.m.equals(action)) {
                ((Activity) getContext()).finish();
                return;
            }
            return;
        }
        if (this.f11667h.equals(action)) {
            this.A = -2;
            e();
            this.F.setText("立即下载");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            com.tianmu.c.h.d.b.a().a(this.f11661b, this.n, this.o, true);
        } catch (Throwable th) {
            s0.a("下载出错了~");
            th.printStackTrace();
        }
    }

    private void a(WebView webView) {
        WebSettings settings = webView.getSettings();
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setDatabaseEnabled(true);
        settings.setGeolocationEnabled(true);
        webView.clearHistory();
        webView.clearFormData();
        webView.clearCache(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportMultipleWindows(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
        if (i2 >= 23) {
            settings.setOffscreenPreRaster(false);
        }
        webView.setWebViewClient(new j(this));
        webView.setWebChromeClient(new a());
    }

    public void a(Activity activity) {
        a(activity, this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, boolean z) {
        if (!TextUtils.isEmpty(this.o) && this.C && com.tianmu.biz.utils.d.c(this.o) == null && 1 == this.z) {
            this.C = false;
            if (com.tianmu.biz.utils.y.l()) {
                a(this.o);
            } else {
                b(com.tianmu.biz.utils.y.a(TianmuSDK.getInstance().getContext()));
            }
        }
        try {
            com.tianmu.c.h.d.b.a().a(this.f11660a, this.f11661b, this.n, this.o, z, this.B);
        } catch (Throwable th) {
            s0.a("下载出错了~");
            th.printStackTrace();
        }
    }

    public void a(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.samsungapps.com/appquery/appDetail.as?appId=" + str));
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.addFlags(268435456);
            getContext().startActivity(intent);
            com.tianmu.c.i.c cVarB = m.b().b(this.f11661b);
            if (cVarB == null || cVarB.H()) {
                return;
            }
            com.tianmu.c.n.j.b().a(cVarB.g(), false);
            cVarB.a(true);
        } catch (Exception unused) {
        }
    }

    public void a(int i2) {
        if (1111 == i2) {
            com.tianmu.c.h.d.b.a().a(this.f11660a, this.f11661b, this.n, this.o, this.y, this.B);
        }
    }

    public void a() {
        BroadcastReceiver broadcastReceiver = this.D;
        if (broadcastReceiver != null) {
            k.a(broadcastReceiver);
            this.D = null;
        }
    }
}
