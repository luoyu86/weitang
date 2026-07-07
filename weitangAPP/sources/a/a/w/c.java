package a.a.w;

import android.text.TextUtils;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f239c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Request f242f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f237a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Cancelable f238b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f240d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f241e = 0;

    public c(k kVar) {
        this.f239c = kVar;
        this.f242f = kVar.f275a.a();
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.f241e;
        cVar.f241e = i2 + 1;
        return i2;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f237a = true;
        if (this.f238b != null) {
            this.f238b.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f237a) {
            return;
        }
        if (this.f239c.f275a.i()) {
            String cookie = a.a.p.a.getCookie(this.f239c.f275a.g());
            if (!TextUtils.isEmpty(cookie)) {
                Request.Builder builderNewBuilder = this.f242f.newBuilder();
                String str = this.f242f.getHeaders().get(HttpConstant.COOKIE);
                if (!TextUtils.isEmpty(str)) {
                    cookie = StringUtils.concatString(str, "; ", cookie);
                }
                builderNewBuilder.addHeader(HttpConstant.COOKIE, cookie);
                this.f242f = builderNewBuilder.build();
            }
        }
        this.f242f.f528a.degraded = 2;
        this.f242f.f528a.sendBeforeTime = System.currentTimeMillis() - this.f242f.f528a.reqStart;
        anet.channel.session.b.a(this.f242f, new d(this));
    }
}
