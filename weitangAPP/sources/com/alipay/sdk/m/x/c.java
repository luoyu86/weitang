package com.alipay.sdk.m.x;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5758c = "v1";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5759d = "v2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f5760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5761b;

    public c(Activity activity, String str) {
        super(activity);
        this.f5760a = activity;
        this.f5761b = str;
    }

    public abstract void a(String str);

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.f5760a.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public abstract boolean b();

    public abstract void c();

    public boolean a() {
        return f5758c.equals(this.f5761b);
    }

    public static void a(WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (Throwable unused) {
            }
        }
    }
}
