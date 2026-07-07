package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0313s<T extends ADSuyiAdListener> extends ADSuyiAdapterBaseAdListener<T> {
    public C0313s(String str, T t) {
        super(str, t);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public String getPlatform() {
        return ADSuyiIniter.PLATFORM;
    }
}
