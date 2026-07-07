package c.e.b.c.b;

import android.content.Intent;
import c.e.b.c.d.l;
import c.e.b.c.d.r;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.p;
import d.k0.d.t;
import d.p0.y;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c.e.b.c.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1286b = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(p pVar) {
            this();
        }
    }

    public static final class b implements c.e.b.a.a {
        public b() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                c.e.b.b.a.d(e.this.getClass().getSimpleName(), "setNavigationBar : " + str);
                c.e.b.c.d.b bVar = (c.e.b.c.d.b) JSON.parseObject(str, c.e.b.c.d.b.class);
                if (bVar != null) {
                    e.this.a().setupAppBarStyle(bVar);
                }
            }
        }
    }

    public static final class c implements c.e.b.a.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BridgeWebView f1289b;

        public c(BridgeWebView bridgeWebView) {
            this.f1289b = bridgeWebView;
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                try {
                    r rVar = (r) JSON.parseObject(str, r.class);
                    t.checkNotNullExpressionValue(rVar, "backVo");
                    Integer delta = rVar.getDelta();
                    if (delta != null && delta.intValue() != 0) {
                        if (this.f1289b.canGoBack()) {
                            this.f1289b.goBack();
                        } else {
                            e.this.a().performFinishActivity();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static final class d implements c.e.b.a.a {
        public d() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            c.e.b.c.d.p pVar;
            String url;
            if (str != null) {
                c.e.b.b.a.d("NavigationBridgeManager", "nativeTo : " + str);
                try {
                    pVar = (c.e.b.c.d.p) JSON.parseObject(str, c.e.b.c.d.p.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (pVar == null || (url = pVar.getUrl()) == null) {
                    return;
                }
                switch (url.hashCode()) {
                    case -1030196734:
                        if (url.equals("room_source_details")) {
                            e.this.a().performRoomSourceActivity(pVar.getData(), pVar.getSignNextUrl());
                        }
                        break;
                    case -941179628:
                        if (url.equals("open_activity_evaluate")) {
                            e.this.a().performActivityEvaluateActivity(pVar.getData());
                        }
                        break;
                    case -296876302:
                        if (url.equals("product_details")) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("nativeTo couponId : ");
                            c.e.b.c.d.e coupon = pVar.getCoupon();
                            sb.append(coupon != null ? coupon.getCouponId() : null);
                            c.e.b.b.a.d("NavigationBridgeManager", sb.toString());
                            c.e.b.c.c.a aVarA = e.this.a();
                            String data = pVar.getData();
                            t.checkNotNullExpressionValue(data, "webViewToRec.data");
                            aVarA.performProductDetailsActivity(data, pVar.getCoupon());
                        }
                        break;
                    case 3015911:
                        if (url.equals(com.alipay.sdk.m.x.d.u)) {
                            e.this.a().performFinishActivity();
                        }
                        break;
                    case 100346066:
                        if (url.equals("index")) {
                            e.this.a().performMainActivity();
                        }
                        break;
                    case 103149417:
                        if (url.equals("login")) {
                            e.this.a().performLogin();
                        }
                        break;
                    case 1070926878:
                        if (url.equals("contract_detail")) {
                            c.e.b.c.c.a aVarA2 = e.this.a();
                            String data2 = pVar.getData();
                            t.checkNotNullExpressionValue(data2, "webViewToRec.data");
                            aVarA2.performContractActivity(data2);
                        }
                        break;
                    case 1193602673:
                        if (url.equals("open_mini_program")) {
                            c.e.b.c.c.a aVarA3 = e.this.a();
                            String data3 = pVar.getData();
                            t.checkNotNullExpressionValue(data3, "webViewToRec.data");
                            aVarA3.performWxMiniProgram(data3);
                        }
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c.e.b.c.b.e$e, reason: collision with other inner class name */
    public static final class C0027e implements c.e.b.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0027e f1291a = new C0027e();

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                try {
                    l lVar = (l) JSON.parseObject(str, l.class);
                    t.checkNotNullExpressionValue(lVar, "backVo");
                    if (lVar.getRefresh() != null) {
                        g.b.a.c.getDefault().post(lVar);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static final class f implements c.e.b.a.a {
        public f() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            String url;
            if (str != null) {
                c.e.b.b.a.d("NavigationBridgeManager", "webviewTo : " + str);
                c.e.b.c.d.t tVar = (c.e.b.c.d.t) JSON.parseObject(str, c.e.b.c.d.t.class);
                StringBuilder sb = new StringBuilder();
                sb.append("registerWebViewToBridge webViewToRec : ");
                sb.append(tVar != null ? tVar.getUrl() : null);
                c.e.b.b.a.d("NavigationBridgeManager", sb.toString());
                if (tVar == null || (url = tVar.getUrl()) == null) {
                    return;
                }
                if (y.contains$default((CharSequence) url, (CharSequence) "needLogin=1", false, 2, (Object) null)) {
                    e.this.a().performLogin();
                } else {
                    e.this.b(url);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.e.b.c.c.a aVar) {
        super(aVar);
        t.checkNotNullParameter(aVar, "iView");
    }

    public final void b(String str) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("key", str);
        c.e.b.b.a.d("NavigationBridgeManager", "registerWebViewToBridge openWebViewActivity : " + str);
        a().performStartActivity(intent);
    }

    public final void c(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("setNavigationBar", new b());
    }

    public final void d(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("webviewBack", new c(bridgeWebView));
    }

    public final void e(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("nativeTo", new d());
    }

    public final void f(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("refreshApp", C0027e.f1291a);
    }

    public final void g(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("webviewTo", new f());
    }

    @Override // c.e.b.c.b.a
    public void registerBridge(BridgeWebView bridgeWebView) {
        t.checkNotNullParameter(bridgeWebView, "webView");
        g(bridgeWebView);
        c(bridgeWebView);
        d(bridgeWebView);
        e(bridgeWebView);
        f(bridgeWebView);
    }
}
