package com.tianmu.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.biz.web.d;
import com.tianmu.c.f.b1;
import com.tianmu.c.l.a;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f10604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProgressBar f10605b;

    public static void openHtml(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtra("KEY_WEB_HTML", str);
        intent.putExtra("KEY_WEB_TITLE", str2);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void openUrl(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtra("KEY_WEB_URL", str);
        intent.putExtra("KEY_WEB_TITLE", str2);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b1.f11270a);
        this.f10604a = (WebView) findViewById(b1.f11271b);
        this.f10605b = (ProgressBar) findViewById(b1.f11272c);
        WebSettings settings = this.f10604a.getSettings();
        this.f10604a.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f10604a.removeJavascriptInterface("accessibility");
        this.f10604a.removeJavascriptInterface("accessibilityTraversal");
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
        this.f10604a.clearHistory();
        this.f10604a.clearFormData();
        this.f10604a.clearCache(true);
        this.f10604a.getSettings().setDisplayZoomControls(false);
        this.f10604a.getSettings().setSupportMultipleWindows(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            this.f10604a.getSettings().setMixedContentMode(0);
        }
        if (i2 >= 23) {
            settings.setOffscreenPreRaster(false);
        }
        this.f10604a.setWebViewClient(new WebViewClient(this) { // from class: com.tianmu.ad.activity.WebViewActivity.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.f10604a.setWebChromeClient(new WebChromeClient() { // from class: com.tianmu.ad.activity.WebViewActivity.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i3) {
                super.onProgressChanged(webView, i3);
                WebViewActivity.this.f10605b.setProgress(i3);
                WebViewActivity.this.f10605b.setVisibility(i3 == 100 ? 8 : 0);
            }
        });
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("KEY_WEB_URL"))) {
            this.f10604a.loadUrl(intent.getStringExtra("KEY_WEB_URL"));
        } else if (TextUtils.isEmpty(intent.getStringExtra("KEY_WEB_HTML"))) {
            finish();
        } else {
            this.f10604a.loadData("<html xmlns=\"http://www.w3.org/1999/xhtml\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/><style type=\"text/css\"></style>    <body>       <p style='font-size: 18px; word-wrap: break-word; color: #555555'>" + intent.getStringExtra("KEY_WEB_HTML") + "</p>    </body></html>", "text/html", "UTF-8");
        }
        ((TextView) findViewById(b1.f11273d)).setText(intent.getStringExtra("KEY_WEB_TITLE"));
        findViewById(b1.f11274e).setOnClickListener(new a() { // from class: com.tianmu.ad.activity.WebViewActivity.3
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                WebViewActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b(this.f10604a);
        this.f10604a = null;
    }
}
