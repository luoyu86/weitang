package com.tianmu.ad;

import android.content.Context;
import com.tianmu.ad.base.BaseNativeAd;
import com.tianmu.ad.bean.NativeAdInfo;
import com.tianmu.ad.listener.NativeAdListener;
import com.tianmu.c.c.e;
import com.tianmu.c.i.l;
import com.tianmu.c.m.c;
import com.tianmu.c.n.n;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAd extends BaseNativeAd<NativeAdListener, NativeAdInfo, c> {
    public NativeAd(Context context) {
        super(context);
    }

    @Override // com.tianmu.ad.base.BaseAd
    public e a() {
        this.f10661q = n.D().a(getPosId());
        c cVar = new c(this, this.f10621a);
        this.r = cVar;
        return cVar;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public String getAdType() {
        return "flow";
    }

    @Override // com.tianmu.ad.base.BaseAd
    public int getRenderType() {
        return 2;
    }

    public void loadAd(String str) {
        loadAd(str, 1);
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void loadAd(String str, int i2) {
        super.loadAd(str, i2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.tianmu.ad.base.BaseNativeAd
    public void a(l lVar) {
        NativeAdInfo nativeAdInfo = new NativeAdInfo(lVar, this, getContext(), this.n, this.m, (c) this.r);
        List<E> list = this.o;
        if (list != 0) {
            list.add(nativeAdInfo);
        }
    }
}
