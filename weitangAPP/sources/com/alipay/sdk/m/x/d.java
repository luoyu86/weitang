package com.alipay.sdk.m.x;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.alipay.sdk.m.j.d;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.m.x.e;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.alipay.sdk.m.x.c implements e.f, e.g, e.h {
    public static final String A = "action";
    public static final String B = "pushWindow";
    public static final String C = "h5JsFuncCallback";
    public static final String D = "sdkInfo";
    public static final String E = "canUseTaoLogin";
    public static final String F = "taoLogin";
    public static final String l = "sdk_result_code:";
    public static final String m = "alipayjsbridge://";
    public static final String n = "onBack";
    public static final String o = "setTitle";
    public static final String p = "onRefresh";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f5762q = "showBackButton";
    public static final String r = "onExit";
    public static final String s = "onLoadJs";
    public static final String t = "callNativeFunc";
    public static final String u = "back";
    public static final String v = "title";
    public static final String w = "refresh";
    public static final String x = "backButton";
    public static final String y = "refreshButton";
    public static final String z = "exit";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.alipay.sdk.m.s.a f5766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5767i;
    public com.alipay.sdk.m.x.e j;
    public com.alipay.sdk.m.x.f k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f5760a.finish();
        }
    }

    public class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.x.e f5769a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.alipay.sdk.m.x.e eVar) {
            super(null);
            this.f5769a = eVar;
        }

        @Override // com.alipay.sdk.m.x.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5769a.a();
            d.this.f5765g = false;
        }
    }

    public class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.x.e f5771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5772b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.alipay.sdk.m.x.e eVar, String str) {
            super(null);
            this.f5771a = eVar;
            this.f5772b = str;
        }

        @Override // com.alipay.sdk.m.x.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.removeView(this.f5771a);
            d.this.j.a(this.f5772b);
            d.this.f5765g = false;
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.x.d$d, reason: collision with other inner class name */
    public class RunnableC0094d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f5775b;

        /* JADX INFO: renamed from: com.alipay.sdk.m.x.d$d$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                RunnableC0094d.this.f5775b.cancel();
                com.alipay.sdk.m.k.a.b(d.this.f5766h, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.A, "2");
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
                RunnableC0094d.this.f5774a.finish();
            }
        }

        public RunnableC0094d(Activity activity, SslErrorHandler sslErrorHandler) {
            this.f5774a = activity;
            this.f5775b = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alipay.sdk.m.x.b.a(this.f5774a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new a(), null, null);
        }
    }

    public static abstract class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static class g implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f5783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5784b;

        public g(f fVar, String str) {
            this.f5783a = fVar;
            this.f5784b = str;
        }

        @Override // com.alipay.sdk.m.j.d.a
        public void a(boolean z, JSONObject jSONObject, String str) {
            try {
                this.f5783a.a(new JSONObject().put(com.taobao.agoo.a.a.b.JSON_SUCCESS, z).put("random", this.f5784b).put("code", jSONObject).put("status", str));
            } catch (JSONException unused) {
            }
        }
    }

    public d(Activity activity, com.alipay.sdk.m.s.a aVar, String str) {
        super(activity, str);
        this.f5763e = true;
        this.f5764f = "GET";
        this.f5765g = false;
        this.j = null;
        this.k = new com.alipay.sdk.m.x.f();
        this.f5766h = aVar;
        g();
    }

    private synchronized boolean e() {
        if (this.k.b()) {
            this.f5760a.finish();
        } else {
            this.f5765g = true;
            com.alipay.sdk.m.x.e eVar = this.j;
            this.j = this.k.c();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new b(eVar));
            eVar.setAnimation(translateAnimation);
            removeView(eVar);
            addView(this.j);
        }
        return true;
    }

    private synchronized void f() {
        Activity activity = this.f5760a;
        com.alipay.sdk.m.x.e eVar = this.j;
        if (activity != null && eVar != null) {
            if (this.f5763e) {
                activity.finish();
            } else {
                eVar.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
            }
        }
    }

    private synchronized boolean g() {
        try {
            com.alipay.sdk.m.x.e eVar = new com.alipay.sdk.m.x.e(this.f5760a, this.f5766h, new e.C0096e(!a(), !a()));
            this.j = eVar;
            eVar.setChromeProxy(this);
            this.j.setWebClientProxy(this);
            this.j.setWebEventProxy(this);
            addView(this.j);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    private void h() {
        com.alipay.sdk.m.x.e eVar = this.j;
        if (eVar != null) {
            eVar.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    private synchronized void i() {
        WebView webView = this.j.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            com.alipay.sdk.m.x.f fVar = this.k;
            if (fVar == null || fVar.b()) {
                a(false);
            } else {
                e();
            }
        }
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized void c() {
        this.j.a();
        this.k.a();
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean d(com.alipay.sdk.m.x.e eVar, String str) {
        com.alipay.sdk.m.k.a.a(this.f5766h, com.alipay.sdk.m.k.b.l, "h5ld", SystemClock.elapsedRealtime() + "|" + n.i(str));
        if (!TextUtils.isEmpty(str) && !str.endsWith(".apk")) {
            h();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5765g ? true : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized boolean b() {
        Activity activity = this.f5760a;
        if (activity == null) {
            return true;
        }
        if (!a()) {
            if (!this.f5765g) {
                f();
            }
            return true;
        }
        com.alipay.sdk.m.x.e eVar = this.j;
        if (eVar != null && eVar.getWebView() != null) {
            if (!eVar.getWebView().canGoBack()) {
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
                activity.finish();
            } else if (d()) {
                com.alipay.sdk.m.j.c cVarB = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(cVarB.b(), cVarB.a(), ""));
                activity.finish();
            }
            return true;
        }
        activity.finish();
        return true;
    }

    public synchronized void a(String str, String str2, boolean z2) {
        this.f5764f = str2;
        this.j.getTitle().setText(str);
        this.f5763e = z2;
    }

    @Override // com.alipay.sdk.m.x.e.f
    public synchronized void c(com.alipay.sdk.m.x.e eVar, String str) {
        if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
            this.j.getTitle().setText(str);
        }
    }

    public boolean d() {
        return this.f5767i;
    }

    private synchronized void a(boolean z2) {
        com.alipay.sdk.m.j.b.a(z2);
        this.f5760a.finish();
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<com.alipay.sdk.m.x.e> f5778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f5780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f5781d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f5782e = false;

        public f(com.alipay.sdk.m.x.e eVar, String str, String str2, JSONObject jSONObject) {
            this.f5778a = new WeakReference<>(eVar);
            this.f5779b = str;
            this.f5780c = str2;
            this.f5781d = jSONObject;
        }

        public void a(JSONObject jSONObject) {
            com.alipay.sdk.m.x.e eVar;
            if (this.f5782e || (eVar = (com.alipay.sdk.m.x.e) n.a(this.f5778a)) == null) {
                return;
            }
            this.f5782e = true;
            eVar.a(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.f5780c), a(jSONObject.toString())));
        }

        public static String a(String str) {
            return TextUtils.isEmpty(str) ? "" : str.replace(OperatorName.SHOW_TEXT_LINE, "");
        }
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized void a(String str) {
        if ("POST".equals(this.f5764f)) {
            this.j.a(str, (byte[]) null);
        } else {
            this.j.a(str);
        }
        com.alipay.sdk.m.x.c.a(this.j.getWebView());
    }

    @Override // com.alipay.sdk.m.x.e.f
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(l)) {
            this.f5760a.runOnUiThread(new a());
        }
        jsPromptResult.cancel();
        return true;
    }

    private synchronized boolean b(String str, String str2) {
        com.alipay.sdk.m.x.e eVar = this.j;
        try {
            com.alipay.sdk.m.x.e eVar2 = new com.alipay.sdk.m.x.e(this.f5760a, this.f5766h, new e.C0096e(!a(), !a()));
            this.j = eVar2;
            eVar2.setChromeProxy(this);
            this.j.setWebClientProxy(this);
            this.j.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.j.getTitle().setText(str2);
            }
            this.f5765g = true;
            this.k.a(eVar);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new c(eVar, str));
            this.j.setAnimation(translateAnimation);
            addView(this.j);
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity activity = this.f5760a;
        if (activity == null) {
            return true;
        }
        if (n.a(this.f5766h, str, activity)) {
            return true;
        }
        if (str.startsWith(m)) {
            b(str.substring(17));
        } else if (TextUtils.equals(str, com.alipay.sdk.m.l.a.f5445q)) {
            a(false);
        } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f5766h, com.alipay.sdk.m.k.b.l, th);
            }
        } else {
            this.j.a(str);
        }
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, int i2, String str, String str2) {
        this.f5767i = true;
        com.alipay.sdk.m.k.a.b(this.f5766h, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.y, "onReceivedError:" + i2 + "|" + str2);
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean b(com.alipay.sdk.m.x.e eVar, String str) {
        com.alipay.sdk.m.k.a.a(this.f5766h, com.alipay.sdk.m.k.b.l, "h5ldd", SystemClock.elapsedRealtime() + "|" + n.i(str));
        h();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f5760a;
        if (activity == null) {
            return true;
        }
        com.alipay.sdk.m.k.a.b(this.f5766h, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.z, "2-" + sslError);
        activity.runOnUiThread(new RunnableC0094d(activity, sslErrorHandler));
        return true;
    }

    private synchronized void b(String str) {
        Map<String, String> mapB = n.b(this.f5766h, str);
        if (str.startsWith(t)) {
            a(mapB.get("func"), mapB.get("cbId"), mapB.get("data"));
        } else if (str.startsWith(n)) {
            i();
        } else if (str.startsWith(o) && mapB.containsKey("title")) {
            this.j.getTitle().setText(mapB.get("title"));
        } else if (str.startsWith(p)) {
            this.j.getWebView().reload();
        } else if (str.startsWith(f5762q) && mapB.containsKey("bshow")) {
            this.j.getBackButton().setVisibility(TextUtils.equals("true", mapB.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(r)) {
            com.alipay.sdk.m.j.b.a(mapB.get("result"));
            a(TextUtils.equals("true", mapB.get("bsucc")));
        } else if (str.startsWith(s)) {
            this.j.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    private synchronized void a(String str, String str2, String str3) {
        com.alipay.sdk.m.x.e eVar = this.j;
        if (eVar == null) {
            return;
        }
        JSONObject jSONObjectH = n.h(str3);
        f fVar = new f(eVar, str, str2, jSONObjectH);
        Context context = eVar.getContext();
        try {
            switch (fVar.f5779b) {
                case "title":
                    if (jSONObjectH.has("title")) {
                        eVar.getTitle().setText(jSONObjectH.optString("title", ""));
                        break;
                    }
                    break;
                case "refresh":
                    eVar.getWebView().reload();
                    break;
                case "back":
                    i();
                    break;
                case "exit":
                    com.alipay.sdk.m.j.b.a(jSONObjectH.optString("result", null));
                    a(jSONObjectH.optBoolean(com.taobao.agoo.a.a.b.JSON_SUCCESS, false));
                    break;
                case "backButton":
                    eVar.getBackButton().setVisibility(jSONObjectH.optBoolean("show", true) ? 0 : 4);
                    break;
                case "refreshButton":
                    eVar.getRefreshButton().setVisibility(jSONObjectH.optBoolean("show", true) ? 0 : 4);
                    break;
                case "pushWindow":
                    b(jSONObjectH.optString(AgooConstants.OPEN_URL), jSONObjectH.optString("title", ""));
                    break;
                case "sdkInfo":
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PluginConstants.KEY_SDK_VERSION, "15.8.15");
                    jSONObject.put("app_name", this.f5766h.b());
                    jSONObject.put(Config.PROPERTY_APP_VERSION, this.f5766h.c());
                    fVar.a(jSONObject);
                    break;
                case "canUseTaoLogin":
                    String url = eVar.getUrl();
                    if (!n.a(this.f5766h, url)) {
                        com.alipay.sdk.m.k.a.b(this.f5766h, com.alipay.sdk.m.k.b.l, "jsUrlErr", url);
                        break;
                    } else {
                        JSONObject jSONObject2 = new JSONObject();
                        boolean zA = com.alipay.sdk.m.j.d.a(this.f5766h, context);
                        jSONObject2.put("enabled", zA);
                        com.alipay.sdk.m.k.a.a(this.f5766h, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.t0, String.valueOf(zA));
                        fVar.a(jSONObject2);
                        break;
                    }
                    break;
                case "taoLogin":
                    String url2 = eVar.getUrl();
                    if (!n.a(this.f5766h, url2)) {
                        com.alipay.sdk.m.k.a.b(this.f5766h, com.alipay.sdk.m.k.b.l, "jsUrlErr", url2);
                        break;
                    } else {
                        String strOptString = jSONObjectH.optString("random");
                        JSONObject jSONObjectOptJSONObject = jSONObjectH.optJSONObject("options");
                        if (!TextUtils.isEmpty("random") && jSONObjectOptJSONObject != null) {
                            String strOptString2 = jSONObjectOptJSONObject.optString(AgooConstants.OPEN_URL);
                            String strOptString3 = jSONObjectOptJSONObject.optString("action");
                            if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && (context instanceof Activity)) {
                                com.alipay.sdk.m.j.d.a(this.f5766h, (Activity) context, 1010, strOptString2, strOptString3, new g(fVar, strOptString));
                            }
                        }
                        break;
                    }
                    break;
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this.f5766h, com.alipay.sdk.m.k.b.l, "jInfoErr", th, str);
        }
    }

    @Override // com.alipay.sdk.m.x.e.h
    public synchronized void b(com.alipay.sdk.m.x.e eVar) {
        f();
    }

    @Override // com.alipay.sdk.m.x.e.h
    public synchronized void a(com.alipay.sdk.m.x.e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }
}
