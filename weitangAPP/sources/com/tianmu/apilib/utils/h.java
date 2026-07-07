package com.tianmu.apilib.utils;

import android.os.Build;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static final void a(WebView webView) {
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 11 || i2 >= 17) {
                return;
            }
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
    }
}
