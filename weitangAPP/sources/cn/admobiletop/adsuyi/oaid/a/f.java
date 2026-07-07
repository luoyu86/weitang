package cn.admobiletop.adsuyi.oaid.a;

import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class f implements cn.admobiletop.adsuyi.oaid.b {
    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.onOAIDGetError(new cn.admobiletop.adsuyi.oaid.c("Unsupported"));
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        return false;
    }
}
