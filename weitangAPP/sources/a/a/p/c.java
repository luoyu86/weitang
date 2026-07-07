package a.a.p;

import anet.channel.util.ALog;
import java.net.HttpCookie;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f192a;

    public c(String str) {
        this.f192a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.f185d == null) {
            return;
        }
        try {
            for (HttpCookie httpCookie : HttpCookie.parse(this.f192a)) {
                if (httpCookie.getName().equals(a.f185d.f187a)) {
                    a.f185d.f188b = httpCookie.toString();
                    a.f185d.f190d = httpCookie.getDomain();
                    a.f185d.f189c = this.f192a;
                    a.f185d.a();
                    return;
                }
            }
        } catch (Exception e2) {
            ALog.e("anet.CookieManager", "cookieMonitorSave error.", null, e2, new Object[0]);
        }
    }
}
