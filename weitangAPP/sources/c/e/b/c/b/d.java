package c.e.b.c.b;

import com.alibaba.fastjson.JSON;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.p;
import d.k0.d.t;

/* JADX INFO: loaded from: classes.dex */
public final class d extends c.e.b.c.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1284b = new a(null);

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
                c.e.b.b.a.d(d.this.getClass().getSimpleName(), "registerNavigationBridge : " + str);
                try {
                    c.e.b.c.d.h hVar = (c.e.b.c.d.h) JSON.parseObject(str, c.e.b.c.d.h.class);
                    c.e.b.c.c.a aVarA = d.this.a();
                    t.checkNotNullExpressionValue(hVar, "lngVo");
                    aVarA.performMap(hVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.e.b.c.c.a aVar) {
        super(aVar);
        t.checkNotNullParameter(aVar, "view");
    }

    public final void b(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("nativeToMap", new b());
    }

    @Override // c.e.b.c.b.a
    public void registerBridge(BridgeWebView bridgeWebView) {
        t.checkNotNullParameter(bridgeWebView, "webView");
        b(bridgeWebView);
    }
}
