package com.chinavisionary.jslibrary.jsbridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import c.e.a.d.q;
import c.e.b.a.b;
import c.e.b.a.c;
import c.e.b.a.d;
import c.e.b.a.e;
import c.e.b.a.f;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SetJavaScriptEnabled"})
public class BridgeWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, d> f6771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, c.e.b.a.a> f6772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.e.b.a.a f6773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<f> f6774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6775f;

    public class a implements d {

        /* JADX INFO: renamed from: com.chinavisionary.jslibrary.jsbridge.BridgeWebView$a$a, reason: collision with other inner class name */
        public class C0116a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f6777a;

            public C0116a(String str) {
                this.f6777a = str;
            }

            @Override // c.e.b.a.d
            public void onCallBack(String str) {
                f fVar = new f();
                fVar.setResponseId(this.f6777a);
                fVar.setResponseData(str);
                BridgeWebView.this.h(fVar);
            }
        }

        public class b implements d {
            public b() {
            }

            @Override // c.e.b.a.d
            public void onCallBack(String str) {
            }
        }

        public a() {
        }

        @Override // c.e.b.a.d
        public void onCallBack(String str) {
            q.d(a.class.getSimpleName(), "onCallBack data = " + str);
            try {
                List<f> arrayList = f.toArrayList(str);
                if (arrayList == null || arrayList.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    f fVar = arrayList.get(i2);
                    String responseId = fVar.getResponseId();
                    if (TextUtils.isEmpty(responseId)) {
                        String callbackId = fVar.getCallbackId();
                        d c0116a = !TextUtils.isEmpty(callbackId) ? new C0116a(callbackId) : new b();
                        c.e.b.a.a aVar = !TextUtils.isEmpty(fVar.getHandlerName()) ? BridgeWebView.this.f6772c.get(fVar.getHandlerName()) : BridgeWebView.this.f6773d;
                        if (aVar != null) {
                            aVar.handler(fVar.getData(), c0116a);
                        }
                    } else {
                        BridgeWebView.this.f6771b.get(responseId).onCallBack(fVar.getResponseData());
                        BridgeWebView.this.f6771b.remove(responseId);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6770a = "BridgeWebView";
        this.f6771b = new HashMap();
        this.f6772c = new HashMap();
        this.f6773d = new e();
        this.f6774e = new ArrayList();
        this.f6775f = 0L;
        g();
    }

    public void b(f fVar) {
        String str = String.format("javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", fVar.toJson().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"").replaceAll("(?<=[^\\\\])(')", "\\\\'").replaceAll("%7B", URLEncoder.encode("%7B")).replaceAll("%7D", URLEncoder.encode("%7D")).replaceAll("%22", URLEncoder.encode("%22")));
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(str);
        }
    }

    public final void c(String str, String str2, d dVar) {
        f fVar = new f();
        if (!TextUtils.isEmpty(str2)) {
            fVar.setData(str2);
        }
        if (dVar != null) {
            StringBuilder sb = new StringBuilder();
            long j = this.f6775f + 1;
            this.f6775f = j;
            sb.append(j);
            sb.append("_");
            sb.append(SystemClock.currentThreadTimeMillis());
            String str3 = String.format("JAVA_CB_%s", sb.toString());
            this.f6771b.put(str3, dVar);
            fVar.setCallbackId(str3);
        }
        if (!TextUtils.isEmpty(str)) {
            fVar.setHandlerName(str);
        }
        h(fVar);
    }

    public void callHandler(String str, String str2, d dVar) {
        c(str, str2, dVar);
    }

    public void d() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl("javascript:WebViewJavascriptBridge._fetchQueue();", new a());
        }
    }

    public c e() {
        return new c(this);
    }

    public void f(String str) {
        String functionFromReturnUrl = b.getFunctionFromReturnUrl(str);
        d dVar = this.f6771b.get(functionFromReturnUrl);
        String dataFromReturnUrl = b.getDataFromReturnUrl(str);
        if (dVar != null) {
            dVar.onCallBack(dataFromReturnUrl);
            this.f6771b.remove(functionFromReturnUrl);
        }
    }

    public final void g() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setWebViewClient(e());
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setUserAgentString(settings.getUserAgentString() + "vtapp");
        settings.setCacheMode(2);
        settings.setAppCacheEnabled(false);
        settings.setDatabaseEnabled(true);
        settings.setGeolocationEnabled(true);
        if (getContext() != null) {
            settings.setGeolocationDatabasePath(getContext().getDir("database", 0).getAbsolutePath());
        }
    }

    public List<f> getStartupMessage() {
        return this.f6774e;
    }

    public final void h(f fVar) {
        List<f> list = this.f6774e;
        if (list != null) {
            list.add(fVar);
        } else {
            b(fVar);
        }
    }

    public void loadUrl(String str, d dVar) {
        loadUrl(str);
        this.f6771b.put(b.parseFunctionName(str), dVar);
    }

    public void registerHandler(String str, c.e.b.a.a aVar) {
        if (aVar != null) {
            this.f6772c.put(str, aVar);
        }
    }

    public void send(String str) {
        send(str, null);
    }

    public void sendHandleName(String str) {
        c(str, "{}", null);
    }

    public void setDefaultHandler(c.e.b.a.a aVar) {
        this.f6773d = aVar;
    }

    public void setStartupMessage(List<f> list) {
        this.f6774e = list;
    }

    public void unregisterHandler(String str) {
        if (str != null) {
            this.f6772c.remove(str);
        }
    }

    public void send(String str, d dVar) {
        c(null, str, dVar);
    }

    public BridgeWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6770a = "BridgeWebView";
        this.f6771b = new HashMap();
        this.f6772c = new HashMap();
        this.f6773d = new e();
        this.f6774e = new ArrayList();
        this.f6775f = 0L;
        g();
    }

    public BridgeWebView(Context context) {
        super(context);
        this.f6770a = "BridgeWebView";
        this.f6771b = new HashMap();
        this.f6772c = new HashMap();
        this.f6773d = new e();
        this.f6774e = new ArrayList();
        this.f6775f = 0L;
        g();
    }
}
