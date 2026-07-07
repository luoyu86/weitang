package cn.admobiletop.adsuyi.a.m;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.l.s;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static p f3438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3439b;

    public static p a() {
        if (f3438a == null) {
            synchronized (p.class) {
                if (f3438a == null) {
                    f3438a = new p();
                }
            }
        }
        return f3438a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f3439b)) {
            String strB = s.a().b("SUYI_CACHE_UA");
            if (TextUtils.isEmpty(strB)) {
                String strC = c();
                try {
                    if (!TextUtils.isEmpty(strC) && !strC.startsWith("Dalvik")) {
                        this.f3439b = strC;
                        s.a().d("SUYI_CACHE_UA", strC);
                    }
                } catch (Exception unused) {
                }
            } else {
                this.f3439b = strB;
            }
        }
        return this.f3439b;
    }

    public final String c() {
        if (Build.VERSION.SDK_INT < 17) {
            return d();
        }
        try {
            return WebSettings.getDefaultUserAgent(ADSuyiSdk.getInstance().getContext());
        } catch (Exception unused) {
            return d();
        }
    }

    public final String d() {
        String userAgentString = "";
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                return System.getProperty("http.agent");
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        try {
            WebView webView = new WebView(ADSuyiSdk.getInstance().getContext());
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
        } catch (Exception e3) {
            e3.printStackTrace();
            try {
                return System.getProperty("http.agent");
            } catch (Exception e4) {
                e4.printStackTrace();
                return userAgentString;
            }
        }
    }
}
