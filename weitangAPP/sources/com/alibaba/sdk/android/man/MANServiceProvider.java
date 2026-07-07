package com.alibaba.sdk.android.man;

/* JADX INFO: loaded from: classes.dex */
public class MANServiceProvider implements MANService {

    public static class Singleton {
        public static MANService instance = new MANServiceProvider();

        private Singleton() {
        }
    }

    public static MANService getService() {
        return Singleton.instance;
    }

    @Override // com.alibaba.sdk.android.man.MANService
    public MANAnalytics getMANAnalytics() {
        return MANAnalytics.getInstance();
    }

    @Override // com.alibaba.sdk.android.man.MANService
    public MANPageHitHelper getMANPageHitHelper() {
        return MANPageHitHelper.getInstance();
    }

    private MANServiceProvider() {
    }
}
