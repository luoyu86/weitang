package cn.admobiletop.adsuyi.a.b;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.g.i;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoSkipListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.android.live.base.api.push.ILivePush;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<K extends cn.admobiletop.adsuyi.a.g.i, T extends ADSuyiAdInfo, R extends ADSuyiAdInfoSkipListener<T>, E extends ADSuyiAd<R>> extends b<K, T, R, E> implements ADSuyiAdInfoSkipListener<T> {
    public c(E e2, Handler handler) {
        super(e2, handler);
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoSkipListener
    public void onAdSkip(T t) {
        K kO;
        if (t == null || E() == null || (kO = o(t)) == null || kO.e() || y0(kO)) {
            return;
        }
        kO.e(true);
        cn.admobiletop.adsuyi.a.a.f.a(ILivePush.ClickType.CLOSE, i(), 1, N(), V(), g());
        if (ADSuyiAdUtil.canCallBack(f0())) {
            a0().onAdSkip(t);
        }
    }

    public boolean y0(cn.admobiletop.adsuyi.a.g.i iVar) {
        return false;
    }
}
