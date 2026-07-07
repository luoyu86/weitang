package cn.admobiletop.adsuyi.a.b;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.b.o;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<K extends o, T extends ADSuyiAdInfo, R extends ADSuyiAdInfoListener<T>, E extends ADSuyiAd<R>> extends k<K, T, R, E> implements ADSuyiAdInfoListener<T> {
    public b(E e2, Handler handler) {
        super(e2, handler);
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener
    public void onAdReceive(T t) {
        if (t == null) {
            onAdFailed(ADSuyiError.createErrorDesc(S(), Y(), ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
            return;
        }
        if (i0() || C(Integer.valueOf(t.hashCode()))) {
            return;
        }
        o0();
        n0();
        E().put(Integer.valueOf(t.hashCode()), n());
        x0();
        cn.admobiletop.adsuyi.a.a.e.a(com.taobao.agoo.a.a.b.JSON_SUCCESS, i(), 1, N(), g(), d0());
        cn.admobiletop.adsuyi.a.a.f.a(com.taobao.agoo.a.a.b.JSON_SUCCESS, i(), 1, N(), V(), g(), d0());
        k0();
        if (ADSuyiAdUtil.canCallBack(f0())) {
            a0().onAdReceive(t);
            this.o = false;
        }
    }

    public void x0() {
    }
}
