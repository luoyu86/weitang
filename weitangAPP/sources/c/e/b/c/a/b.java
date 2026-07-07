package c.e.b.c.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import anet.channel.util.HttpConstant;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.t;
import d.p0.x;
import d.p0.y;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.e.b.c.c.b f1264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.e.b.a.c f1265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BridgeWebView f1266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f1267d;

    public b(BridgeWebView bridgeWebView, Activity activity) {
        t.checkNotNullParameter(bridgeWebView, "mWebView");
        t.checkNotNullParameter(activity, "mActivity");
        this.f1266c = bridgeWebView;
        this.f1267d = activity;
        this.f1265b = new a(bridgeWebView);
    }

    public final boolean a(String str) {
        return false;
    }

    public final boolean b(String str) {
        if (str == null) {
            str = "";
        }
        if (!x.startsWith$default(str, "tel:", false, 2, null)) {
            return false;
        }
        if (c()) {
            this.f1267d.startActivity(new Intent("android.intent.action.CALL", Uri.parse(str)));
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        this.f1267d.requestPermissions(new String[]{"android.permission.CALL_PHONE"}, 200);
        return true;
    }

    public final boolean c() {
        return ContextCompat.checkSelfPermission(this.f1267d, "android.permission.CALL_PHONE") == 0;
    }

    public final boolean checkIsInterceptUrl(String str) {
        t.checkNotNullParameter(str, "httpUrl");
        boolean zB = b(str);
        return !zB ? e(str) : zB;
    }

    public final boolean d(String str) {
        return !TextUtils.isEmpty(str);
    }

    public final boolean e(String str) {
        if (!y.contains((CharSequence) str, (CharSequence) "http", true) && !x.startsWith$default(str, "yy", false, 2, null)) {
            try {
                Intent intent = new Intent();
                intent.setFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.f1267d.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
        if (!x.endsWith$default(str, ".apk", false, 2, null)) {
            return a(str);
        }
        try {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setAction("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str));
            this.f1267d.startActivity(intent2);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return true;
    }

    public final HashMap<String, String> getHttpHead(String str) {
        t.checkNotNullParameter(str, AgooConstants.OPEN_URL);
        if (d(str)) {
            Uri uri = Uri.parse(str);
            t.checkNotNullExpressionValue(uri, "uri");
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (d(scheme) && d(host)) {
                HashMap<String, String> map = new HashMap<>();
                map.put("Referer", scheme + HttpConstant.SCHEME_SPLIT + host);
                c.e.b.b.a.d(b.class.getClass().getSimpleName(), "getHttpHead  scheme：" + scheme + ",host:" + host);
                return map;
            }
        }
        return new HashMap<>();
    }

    public final c.e.b.a.c getMBridgeWebViewClient() {
        return this.f1265b;
    }

    public final void setupIWebFragmentCallback(c.e.b.c.c.b bVar) {
        t.checkNotNullParameter(bVar, "callback");
        this.f1264a = bVar;
    }

    public static final class a extends c.e.b.a.c {
        public a(BridgeWebView bridgeWebView) {
            super(bridgeWebView);
        }

        @Override // c.e.b.a.c
        public boolean b(String str) {
            t.checkNotNullParameter(str, AgooConstants.OPEN_URL);
            if (b.this.checkIsInterceptUrl(str)) {
                return true;
            }
            return super.b(str);
        }

        @Override // c.e.b.a.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) throws Throwable {
            t.checkNotNullParameter(webView, "view");
            t.checkNotNullParameter(str, AgooConstants.OPEN_URL);
            super.onPageFinished(webView, str);
            y.indexOf$default((CharSequence) str, "http", 0, false, 6, (Object) null);
            b.this.checkIsInterceptUrl(str);
            c.e.b.c.c.b bVar = b.this.f1264a;
            if (bVar != null) {
                bVar.handlerFddSignSuccess(str);
            }
            c.e.b.b.a.d(b.class.getSimpleName(), "onPageFinished url" + str);
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            StringBuilder sb = new StringBuilder();
            sb.append("handle404Page description = ");
            sb.append(webResourceError != null ? webResourceError.getDescription() : null);
            sb.append(", code = ");
            sb.append(webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : null);
            c.e.b.b.a.d("WebFragmentHandle", sb.toString());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            t.checkNotNullParameter(sslErrorHandler, "handler");
            sslErrorHandler.proceed();
            c.e.b.b.a.d(b.class.getSimpleName(), "onReceivedSslError");
        }

        @Override // c.e.b.a.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            t.checkNotNullParameter(str, AgooConstants.OPEN_URL);
            c.e.b.b.a.d(b.class.getSimpleName(), "shouldOverrideUrlLoading  url：" + str);
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // c.e.b.a.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            t.checkNotNullParameter(webResourceRequest, "request");
            b bVar = b.this;
            String string = webResourceRequest.getUrl().toString();
            t.checkNotNullExpressionValue(string, "request.url.toString()");
            if (bVar.checkIsInterceptUrl(string)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }
}
