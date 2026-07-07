package a.a.p;

import a.a.p.a;
import android.text.TextUtils;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(a.i())) {
                return;
            }
            a.C0001a unused = a.f185d = new a.C0001a(a.i());
        } catch (Exception e2) {
            ALog.e("anet.CookieManager", "", null, e2, new Object[0]);
        }
    }
}
