package com.tianmu.danikula.videocache;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 2.2.0.1";

    public ProxyCacheException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 2.2.0.1", th);
    }
}
