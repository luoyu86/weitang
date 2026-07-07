package cn.admobiletop.adsuyi.a.h.a;

import android.os.Handler;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f3336a;

    public h(Handler handler) {
        this.f3336a = handler;
    }

    @Override // cn.admobiletop.adsuyi.a.h.a.b
    public void c(String str, String str2) {
    }

    public abstract void e();

    public abstract void f(int i2, String str);

    @Override // com.ciba.http.listener.SimpleHttpListener, com.ciba.http.listener.HttpListener
    public final void onRequestFailed(int i2, String str) {
        if (ADSuyiPackageUtil.isMainThread()) {
            f(i2, str);
            return;
        }
        Handler handler = this.f3336a;
        if (handler != null) {
            handler.post(new f(this, i2, str));
        }
    }

    @Override // com.ciba.http.listener.SimpleHttpListener, com.ciba.http.listener.HttpListener
    public void onRequestSuccess(String str) {
        Handler handler = this.f3336a;
        if (handler != null) {
            handler.post(new g(this));
        }
    }
}
