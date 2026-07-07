package c.e.b.c.b;

import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.e.b.c.c.a f1272a;

    public a(c.e.b.c.c.a aVar) {
        t.checkNotNullParameter(aVar, "iView");
        this.f1272a = aVar;
    }

    public final c.e.b.c.c.a a() {
        return this.f1272a;
    }

    public abstract void registerBridge(BridgeWebView bridgeWebView);
}
