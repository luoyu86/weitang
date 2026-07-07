package cn.admobiletop.adsuyi.a.f;

import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f3249a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f3250b;

    public static synchronized void a(cn.admobiletop.adsuyi.a.f.a.a aVar) {
        try {
            f3250b--;
            if (f3250b <= 0) {
                if (aVar != null) {
                    ADSuyiLogUtil.d(String.format("zero instances, closing helper %s", aVar));
                    aVar.close();
                    f3249a = true;
                }
                if (f3250b < 0) {
                    ADSuyiLogUtil.d(String.format("too many calls to release helper, instance count = %s", Integer.valueOf(f3250b)));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void a() {
        f3249a = false;
        f3250b++;
    }
}
