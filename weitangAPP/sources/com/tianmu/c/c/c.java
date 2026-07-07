package com.tianmu.c.c;

import android.os.Handler;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.AdInfoListener;
import com.tianmu.c.c.f;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuAdUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<K extends f, T extends BaseAdInfo, R extends AdInfoListener<T>, E extends BaseAd<R>> extends e<K, T, R, E> implements AdInfoListener<T> {
    public c(E e2, Handler handler) {
        super(e2, handler);
    }

    @Override // com.tianmu.ad.listener.AdInfoListener
    public void onAdReceive(T t) {
        if (g() || h()) {
            return;
        }
        if (t == null) {
            a(new TianmuError(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
            return;
        }
        o();
        c().put(t, a());
        q();
        com.tianmu.c.b.g.a(com.taobao.agoo.a.a.b.JSON_SUCCESS, 1, e());
        i();
        if (TianmuAdUtil.canCallBack(d())) {
            ((AdInfoListener) d().getListener()).onAdReceive(t);
        }
    }

    public void q() {
    }
}
