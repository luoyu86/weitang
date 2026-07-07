package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;

/* JADX INFO: loaded from: classes.dex */
public class c<T extends ADSuyiAdListener> extends ADSuyiAdapterBaseAdListener<T> {
    public c(String str, T t) {
        super(str, t);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public String getPlatform() {
        return "gdt";
    }
}
