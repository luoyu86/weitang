package com.taobao.accs.utl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RomInfoCollector {
    public RomInfoCollector mNextCollector;

    public static RomInfoCollector getCollector() {
        return new e();
    }

    public abstract String collect();
}
