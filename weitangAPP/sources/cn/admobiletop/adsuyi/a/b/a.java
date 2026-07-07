package cn.admobiletop.adsuyi.a.b;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.b.o;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<K extends o, T extends ADSuyiAdInfo, R extends ADSuyiAdInfoListListener<T>, E extends ADSuyiAd<R>> extends k<K, T, R, E> implements ADSuyiAdInfoListListener<T> {
    public a(E e2, Handler handler) {
        super(e2, handler);
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListListener
    public void onAdReceive(List<T> list) {
        if (!i0() && !D(list)) {
            if (list == null || list.isEmpty()) {
                onAdFailed(ADSuyiError.createErrorDesc(S(), Y(), ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
                return;
            }
            o0();
            n0();
            for (int i2 = 0; i2 < list.size(); i2++) {
                E().put(Integer.valueOf(list.get(i2).hashCode()), n());
            }
            cn.admobiletop.adsuyi.a.a.e.a(com.taobao.agoo.a.a.b.JSON_SUCCESS, i(), list.size(), N(), g(), d0());
            cn.admobiletop.adsuyi.a.a.f.a(com.taobao.agoo.a.a.b.JSON_SUCCESS, i(), list.size(), N(), V(), g(), d0());
            k0();
            if (ADSuyiAdUtil.canCallBack(f0())) {
                a0().onAdReceive(list);
            }
        }
    }
}
