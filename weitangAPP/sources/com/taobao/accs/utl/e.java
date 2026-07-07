package com.taobao.accs.utl;

/* JADX INFO: loaded from: classes2.dex */
public class e extends RomInfoCollector {
    @Override // com.taobao.accs.utl.RomInfoCollector
    public String collect() {
        RomInfoCollector romInfoCollector;
        String strG = UtilityImpl.g();
        return (strG != null || (romInfoCollector = this.mNextCollector) == null) ? strG : romInfoCollector.collect();
    }
}
