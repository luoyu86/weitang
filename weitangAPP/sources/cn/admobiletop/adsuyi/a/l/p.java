package cn.admobiletop.adsuyi.a.l;

import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static p f3423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3424b;

    public static p a() {
        if (f3423a == null) {
            synchronized (p.class) {
                if (f3423a == null) {
                    f3423a = new p();
                }
            }
        }
        return f3423a;
    }

    public String b() {
        if (!TextUtils.isEmpty(this.f3424b)) {
            return this.f3424b;
        }
        String strC = s.a().c(DispatchConstants.MACHINE, "ADSUYI_MACHINE_ID");
        this.f3424b = strC;
        if (!TextUtils.isEmpty(strC)) {
            return this.f3424b;
        }
        this.f3424b = c();
        s.a().a(DispatchConstants.MACHINE, "ADSUYI_MACHINE_ID", this.f3424b);
        return this.f3424b;
    }

    public final String c() {
        try {
            return cn.admobiletop.adsuyi.a.m.j.a(cn.admobiletop.adsuyi.a.m.q.a(32) + SystemClock.elapsedRealtime());
        } catch (Exception unused) {
            return cn.admobiletop.adsuyi.a.m.j.a(cn.admobiletop.adsuyi.a.m.q.a(32));
        }
    }
}
