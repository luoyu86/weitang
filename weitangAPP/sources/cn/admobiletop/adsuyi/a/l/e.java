package cn.admobiletop.adsuyi.a.l;

import android.os.Handler;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class e extends cn.admobiletop.adsuyi.a.h.a.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f3379d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str, Handler handler) {
        super(str, handler);
        this.f3379d = hVar;
    }

    @Override // cn.admobiletop.adsuyi.a.h.a.e
    public void e(cn.admobiletop.adsuyi.a.g.a aVar) {
        ADSuyiLogUtil.d("init data request success...");
        this.f3379d.w(aVar, false);
    }

    @Override // cn.admobiletop.adsuyi.a.h.a.e
    public void f(boolean z, int i2, String str) {
        ADSuyiLogUtil.d("init data request failed--> code : " + i2 + ", error : " + str);
        if (i2 == -1003 && d.b().e() && d.b().a() > 0) {
            d.b().f();
            this.f3379d.K();
            return;
        }
        this.f3379d.u = z;
        this.f3379d.v = str;
        this.f3379d.N();
        ADSuyiSdk.getInstance().setInitListenerFailed("init data request failed--> code : " + i2 + ", error : " + str);
    }
}
