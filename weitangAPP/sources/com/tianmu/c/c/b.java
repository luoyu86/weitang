package com.tianmu.c.c;

import android.os.Handler;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.listener.AdInfoListListener;
import com.tianmu.c.c.f;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<K extends f, T extends BaseAdInfo, R extends AdInfoListListener<T>, E extends BaseAd<R>> extends e<K, T, R, E> implements AdInfoListListener<T> {
    public b(E e2, Handler handler) {
        super(e2, handler);
    }

    @Override // com.tianmu.ad.listener.AdInfoListListener
    public abstract void onAdReceive(List<T> list);
}
