package com.ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.h.r;

/* JADX INFO: loaded from: classes2.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f9788a;
    private long bl;
    private String n;
    private ImageView ok;
    private long s;

    private void a() {
        this.ok = (ImageView) findViewById(R.id.iv_privacy_back);
        this.f9788a = (WebView) findViewById(R.id.privacy_webview);
        this.ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.ok("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.s);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.f9788a.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.f9788a.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            private boolean ok(Uri uri) {
                String scheme = uri.getScheme();
                return ("http".equals(scheme) || "https".equals(scheme)) ? false : true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (renderProcessGoneDetail.didCrash()) {
                    r.ok("The WebView rendering process crashed!");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                r.ok("System killed the WebView rendering process to reclaim memory. Recreating...");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return ok(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ok(Uri.parse(str));
            }
        });
        ok(this.f9788a);
        this.f9788a.setScrollBarStyle(0);
        this.f9788a.loadUrl(this.n);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.ok("lp_app_privacy_click_close", this.s);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (ok()) {
            a();
        } else {
            com.ss.android.socialbase.appdownloader.bl.ok((Activity) this);
        }
    }

    public static void ok(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean ok() {
        this.bl = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.a.a aVarOk = bl.ok().ok(this.bl);
        if (aVarOk == null) {
            return false;
        }
        this.s = aVarOk.f9767a;
        String str = aVarOk.f9769q;
        this.n = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.n = com.ss.android.downloadlib.addownload.r.q().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void ok(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}
