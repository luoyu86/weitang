package a.a.p;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.CookieMonitorStat;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import java.net.HttpCookie;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f194b;

    public d(String str, String str2) {
        this.f193a = str;
        this.f194b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.f185d == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(a.f185d.f187a) || !HttpCookie.domainMatches(a.f185d.f190d, HttpUrl.parse(this.f193a).host()) || TextUtils.isEmpty(this.f194b)) {
                return;
            }
            if (this.f194b.contains(a.f185d.f187a + "=")) {
                return;
            }
            CookieMonitorStat cookieMonitorStat = new CookieMonitorStat(this.f193a);
            cookieMonitorStat.cookieName = a.f185d.f187a;
            cookieMonitorStat.cookieText = a.f185d.f188b;
            cookieMonitorStat.setCookie = a.f185d.f189c;
            cookieMonitorStat.missType = 1;
            AppMonitor.getInstance().commitStat(cookieMonitorStat);
        } catch (Exception e2) {
            ALog.e("anet.CookieManager", "cookieMonitorReport error.", null, e2, new Object[0]);
        }
    }
}
