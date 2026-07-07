package c.e.b.c.b;

import c.e.b.c.d.o;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.p;
import d.k0.d.t;

/* JADX INFO: loaded from: classes.dex */
public final class g extends c.e.b.c.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1297b = new a(null);

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
            o oVar;
            if (str == null || (oVar = (o) JSON.parseObject(str, o.class)) == null) {
                return;
            }
            g.this.b(oVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.e.b.c.c.a aVar) {
        super(aVar);
        t.checkNotNullParameter(aVar, "view");
    }

    public final void b(o oVar) {
        a().performWeChartShared(oVar);
    }

    public final void c(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("onShareWechat", new b());
    }

    @Override // c.e.b.c.b.a
    public void registerBridge(BridgeWebView bridgeWebView) {
        t.checkNotNullParameter(bridgeWebView, "webView");
        c(bridgeWebView);
    }
}
