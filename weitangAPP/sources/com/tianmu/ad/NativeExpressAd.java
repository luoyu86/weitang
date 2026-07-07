package com.tianmu.ad;

import android.content.Context;
import com.tianmu.ad.base.BaseNativeAd;
import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.entity.TianmuAdSize;
import com.tianmu.ad.listener.NativeExpressAdListener;
import com.tianmu.c.c.e;
import com.tianmu.c.i.l;
import com.tianmu.c.m.d;
import com.tianmu.c.n.n;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressAd extends BaseNativeAd<NativeExpressAdListener, NativeExpressAdInfo, d> {
    private TianmuAdSize w;

    public NativeExpressAd(Context context, TianmuAdSize tianmuAdSize) {
        super(context);
        this.w = tianmuAdSize;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public e a() {
        this.f10661q = n.D().a(getPosId());
        d dVar = new d(this, this.f10621a);
        this.r = dVar;
        return dVar;
    }

    public TianmuAdSize getAdSize() {
        return this.w;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public String getAdType() {
        return "flow";
    }

    @Override // com.tianmu.ad.base.BaseAd
    public int getRenderType() {
        return 1;
    }

    public void loadAd(String str) {
        loadAd(str, 1);
    }

    public void setAdSize(TianmuAdSize tianmuAdSize) {
        this.w = tianmuAdSize;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void loadAd(String str, int i2) {
        super.loadAd(str, i2);
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void setListener(NativeExpressAdListener nativeExpressAdListener) {
        super.setListener(nativeExpressAdListener);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.tianmu.ad.base.BaseNativeAd
    public void a(l lVar) {
        NativeExpressAdInfo nativeExpressAdInfo = new NativeExpressAdInfo(lVar, this, getContext(), this.n, this.m, (d) this.r, Integer.valueOf(hashCode()));
        List<E> list = this.o;
        if (list != 0) {
            list.add(nativeExpressAdInfo);
        }
    }
}
