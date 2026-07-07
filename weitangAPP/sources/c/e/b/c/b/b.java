package c.e.b.c.b;

import c.e.b.c.d.j;
import c.e.b.c.d.m;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.p;
import d.k0.d.t;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c.e.b.c.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1273b = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(p pVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: c.e.b.c.b.b$b, reason: collision with other inner class name */
    public static final class C0025b implements c.e.b.a.a {
        public C0025b() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                try {
                    j jVar = (j) JSON.parseObject(str, j.class);
                    c.e.b.c.c.a aVarA = b.this.a();
                    t.checkNotNullExpressionValue(jVar, "phoneBridgeVo");
                    String phoneNumber = jVar.getPhoneNumber();
                    t.checkNotNullExpressionValue(phoneNumber, "phoneBridgeVo.phoneNumber");
                    aVarA.performCallPhone(phoneNumber);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                c.e.b.b.a.d(b.this.getClass().getSimpleName(), "CALL_PHONE_BRIDGE: " + str);
            }
        }
    }

    public static final class c implements c.e.b.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f1275a = new c();

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            t.checkNotNullParameter(dVar, "function");
            c.e.a.a.b bVar = c.e.a.a.b.getInstance();
            t.checkNotNullExpressionValue(bVar, "AppHelper.getInstance()");
            dVar.onCallBack(String.valueOf(bVar.getAppVersion()));
        }
    }

    public static final class d implements c.e.b.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f1276a = new d();

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            t.checkNotNullParameter(dVar, "function");
            Locale locale = Locale.getDefault();
            t.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            dVar.onCallBack(locale.getLanguage());
        }
    }

    public static final class e implements c.e.b.a.a {
        public e() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            if (str != null) {
                try {
                    m mVar = (m) JSON.parseObject(str, m.class);
                    c.e.b.c.c.a aVarA = b.this.a();
                    t.checkNotNullExpressionValue(mVar, "reportAbnormalBo");
                    aVarA.performReportAbnormalBo(mVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                c.e.b.b.a.d(b.this.getClass().getSimpleName(), "registerReportAbnormalBridge: " + str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.e.b.c.c.a aVar) {
        super(aVar);
        t.checkNotNullParameter(aVar, "view");
    }

    public final void b(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("makePhoneCall", new C0025b());
    }

    public final void c(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("getAppCode", c.f1275a);
    }

    public final void d(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("getLanguage", d.f1276a);
    }

    public final void e(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("abnormalInfo", new e());
    }

    @Override // c.e.b.c.b.a
    public void registerBridge(BridgeWebView bridgeWebView) {
        t.checkNotNullParameter(bridgeWebView, "webView");
        d(bridgeWebView);
        c(bridgeWebView);
        b(bridgeWebView);
        e(bridgeWebView);
    }
}
