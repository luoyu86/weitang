package com.alipay.sdk.m.x;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.sdk.m.u.k;
import com.alipay.sdk.m.u.n;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class e extends LinearLayout {
    public static Handler m = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f5785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f5786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f5787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ProgressBar f5788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WebView f5789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0096e f5790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f5791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f5792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f5793i;
    public final com.alipay.sdk.m.s.a j;
    public View.OnClickListener k;
    public final float l;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.alipay.sdk.m.x.e$a$a, reason: collision with other inner class name */
        public class RunnableC0095a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f5795a;

            public RunnableC0095a(View view) {
                this.f5795a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f5795a.setEnabled(true);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = e.this.f5793i;
            if (hVar != null) {
                view.setEnabled(false);
                e.m.postDelayed(new RunnableC0095a(view), 256L);
                if (view == e.this.f5785a) {
                    hVar.b(e.this);
                } else if (view == e.this.f5787c) {
                    hVar.a(e.this);
                }
            }
        }
    }

    public class b implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5797a;

        public b(Context context) {
            this.f5797a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.f5797a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return e.this.f5791g.a(e.this, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            if (!e.this.f5790f.f5802b) {
                e.this.f5788d.setVisibility(8);
            } else {
                if (i2 > 90) {
                    e.this.f5788d.setVisibility(4);
                    return;
                }
                if (e.this.f5788d.getVisibility() == 4) {
                    e.this.f5788d.setVisibility(0);
                }
                e.this.f5788d.setProgress(i2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            e.this.f5791g.c(e.this, str);
        }
    }

    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (e.this.f5792h.b(e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (e.this.f5792h.d(e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            if (e.this.f5792h.a(e.this, i2, str, str2)) {
                return;
            }
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (e.this.f5792h.a(e.this, sslErrorHandler, sslError)) {
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (e.this.f5792h.a(e.this, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.x.e$e, reason: collision with other inner class name */
    public static final class C0096e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5802b;

        public C0096e(boolean z, boolean z2) {
            this.f5801a = z;
            this.f5802b = z2;
        }
    }

    public interface f {
        boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);

        void c(e eVar, String str);
    }

    public interface g {
        boolean a(e eVar, int i2, String str, String str2);

        boolean a(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean a(e eVar, String str);

        boolean b(e eVar, String str);

        boolean d(e eVar, String str);
    }

    public interface h {
        void a(e eVar);

        void b(e eVar);
    }

    public e(Context context, com.alipay.sdk.m.s.a aVar, C0096e c0096e) {
        this(context, null, aVar, c0096e);
    }

    public ImageView getBackButton() {
        return this.f5785a;
    }

    public ProgressBar getProgressbar() {
        return this.f5788d;
    }

    public ImageView getRefreshButton() {
        return this.f5787c;
    }

    public TextView getTitle() {
        return this.f5786b;
    }

    public String getUrl() {
        return this.f5789e.getUrl();
    }

    public WebView getWebView() {
        return this.f5789e;
    }

    public void setChromeProxy(f fVar) {
        this.f5791g = fVar;
        if (fVar == null) {
            this.f5789e.setWebChromeClient(null);
        } else {
            this.f5789e.setWebChromeClient(new c());
        }
    }

    public void setWebClientProxy(g gVar) {
        this.f5792h = gVar;
        if (gVar == null) {
            this.f5789e.setWebViewClient(null);
        } else {
            this.f5789e.setWebViewClient(new d());
        }
    }

    public void setWebEventProxy(h hVar) {
        this.f5793i = hVar;
    }

    public e(Context context, AttributeSet attributeSet, com.alipay.sdk.m.s.a aVar, C0096e c0096e) {
        super(context, attributeSet);
        this.k = new a();
        this.f5790f = c0096e == null ? new C0096e(false, false) : c0096e;
        this.j = aVar;
        this.l = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f5790f.f5801a ? 0 : 8);
        ImageView imageView = new ImageView(context);
        this.f5785a = imageView;
        imageView.setOnClickListener(this.k);
        this.f5785a.setScaleType(ImageView.ScaleType.CENTER);
        this.f5785a.setImageDrawable(k.a(k.f5704a, context));
        this.f5785a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f5785a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.f5786b = textView;
        textView.setTextColor(-15658735);
        this.f5786b.setTextSize(17.0f);
        this.f5786b.setMaxLines(1);
        this.f5786b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f5786b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.f5787c = imageView2;
        imageView2.setOnClickListener(this.k);
        this.f5787c.setScaleType(ImageView.ScaleType.CENTER);
        this.f5787c.setImageDrawable(k.a(k.f5705b, context));
        this.f5787c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f5787c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    private void c(Context context) {
        WebView webView = new WebView(context);
        this.f5789e = webView;
        webView.setVerticalScrollbarOverlay(true);
        a(this.f5789e, context);
        WebSettings settings = this.f5789e.getSettings();
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(false);
        this.f5789e.setVerticalScrollbarOverlay(true);
        this.f5789e.setDownloadListener(new b(context));
        try {
            try {
                this.f5789e.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f5789e.removeJavascriptInterface("accessibility");
                this.f5789e.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception unused) {
                Method method = this.f5789e.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.f5789e, "searchBoxJavaBridge_");
                    method.invoke(this.f5789e, "accessibility");
                    method.invoke(this.f5789e, "accessibilityTraversal");
                }
            }
        } catch (Throwable unused2) {
        }
        com.alipay.sdk.m.x.c.a(this.f5789e);
        addView(this.f5789e, new LinearLayout.LayoutParams(-1, -1));
    }

    private void b(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        this.f5788d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_horizontal));
        this.f5788d.setMax(100);
        this.f5788d.setBackgroundColor(-218103809);
        addView(this.f5788d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    public void a(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        webView.getSettings().setUserAgentString(userAgentString + n.g(context));
    }

    public void a(String str) {
        this.f5789e.loadUrl(str);
        com.alipay.sdk.m.x.c.a(this.f5789e);
    }

    public void a(String str, byte[] bArr) {
        this.f5789e.postUrl(str, bArr);
    }

    public void a() {
        removeAllViews();
        this.f5789e.removeAllViews();
        this.f5789e.setWebViewClient(null);
        this.f5789e.setWebChromeClient(null);
        this.f5789e.destroy();
    }

    private int a(int i2) {
        return (int) (i2 * this.l);
    }
}
