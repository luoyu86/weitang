package com.tianmu.apilib.adapter;

import com.tianmu.apilib.adapter.iiterface.IAdapterApiLoader;

/* JADX INFO: loaded from: classes2.dex */
public class AdapterApiLoaderManager {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AdapterApiLoaderManager f10789a = new AdapterApiLoaderManager();
    }

    public static AdapterApiLoaderManager getInstance() {
        return b.f10789a;
    }

    public IAdapterApiLoader getAdapterApiLoader() {
        return com.tianmu.apilib.adapter.a.a.b();
    }

    private AdapterApiLoaderManager() {
    }
}
