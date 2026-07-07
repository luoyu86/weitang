package com.tianmu.c.c;

import android.os.Handler;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.listener.AdInfoSkipListener;
import com.tianmu.c.i.n;
import com.tianmu.utils.TianmuAdUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<K extends n, T extends BaseAdInfo, R extends AdInfoSkipListener<T>, E extends BaseAd<R>> extends c<K, T, R, E> implements AdInfoSkipListener<T> {
    public d(E e2, Handler handler) {
        super(e2, handler);
    }

    public abstract boolean a(n nVar);

    @Override // com.tianmu.ad.listener.AdInfoSkipListener
    public void onAdSkip(T t) {
        K k;
        if (t == null || c() == null || (k = c().get(t)) == null || k.e() || a(k)) {
            return;
        }
        k.e(true);
        com.tianmu.c.b.g.a(ILivePush.ClickType.CLOSE, 1, e());
        if (TianmuAdUtil.canCallBack(d())) {
            ((AdInfoSkipListener) d().getListener()).onAdSkip(t);
        }
    }
}
