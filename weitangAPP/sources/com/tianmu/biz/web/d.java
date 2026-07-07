package com.tianmu.biz.web;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void a(WebView webView) {
        a(webView, new WebViewClient(), null, null);
    }

    public static void b(WebView webView) {
        if (webView != null) {
            try {
                ViewParent parent = webView.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeAllViews();
                }
                webView.setVisibility(8);
                webView.clearHistory();
                webView.clearView();
                webView.removeAllViews();
                webView.setWebChromeClient(null);
                webView.setWebViewClient(null);
                webView.destroy();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static void a(WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, DownloadListener downloadListener) {
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(2);
            settings.setDomStorageEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setSupportZoom(false);
            settings.setDatabaseEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setBuiltInZoomControls(false);
            settings.setLoadsImagesAutomatically(true);
            settings.setDisplayZoomControls(false);
            settings.setUseWideViewPort(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(2);
            }
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            if (downloadListener != null) {
                webView.setDownloadListener(downloadListener);
            }
            if (webViewClient != null) {
                webView.setWebViewClient(webViewClient);
            }
            if (webChromeClient != null) {
                webView.setWebChromeClient(webChromeClient);
            }
            webView.setHorizontalScrollBarEnabled(false);
            webView.setVerticalScrollBarEnabled(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
