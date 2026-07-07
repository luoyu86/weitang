package com.tianmu.apilib.utils;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.i0;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static j f10801c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10803b;

    public static j b() {
        if (f10801c == null) {
            synchronized (j.class) {
                if (f10801c == null) {
                    f10801c = new j();
                }
            }
        }
        return f10801c;
    }

    private String c() {
        if (Build.VERSION.SDK_INT < 17) {
            return d();
        }
        try {
            return WebSettings.getDefaultUserAgent(TianmuSDK.getInstance().getContext());
        } catch (Exception unused) {
            return d();
        }
    }

    private String d() {
        String property;
        String userAgentString = "";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                WebView webView = new WebView(TianmuSDK.getInstance().getContext());
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
                webView.getSettings().setSavePassword(false);
                webView.getSettings().setAllowFileAccess(false);
                userAgentString = webView.getSettings().getUserAgentString();
                ViewParent parent = webView.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(webView);
                }
                webView.stopLoading();
                webView.clearView();
                webView.removeAllViews();
                webView.destroy();
                return userAgentString;
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    property = System.getProperty("http.agent");
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return userAgentString;
                }
            }
        } else {
            try {
                property = System.getProperty("http.agent");
            } catch (Exception e4) {
                e4.printStackTrace();
                return "";
            }
        }
        return property;
    }

    public void a(String str) {
        if (this.f10803b || TextUtils.isEmpty(str) || str.startsWith("Dalvik")) {
            return;
        }
        this.f10803b = true;
        this.f10802a = str;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f10802a)) {
            String strC = i0.a().c("SP_CACHE_UA");
            if (TextUtils.isEmpty(strC)) {
                String strC2 = c();
                try {
                    if (!TextUtils.isEmpty(strC2) && !strC2.startsWith("Dalvik")) {
                        this.f10802a = strC2;
                        i0.a().d("SP_CACHE_UA", strC2);
                    }
                } catch (Exception unused) {
                }
            } else {
                this.f10802a = strC;
            }
        }
        return this.f10802a;
    }
}
