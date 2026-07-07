package org.android.agoo.control;

import com.taobao.accs.client.AdapterGlobalClientInfo;

/* JADX INFO: loaded from: classes2.dex */
public class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseIntentService f14966a;

    public k(BaseIntentService baseIntentService) {
        this.f14966a = baseIntentService;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
        BaseIntentService baseIntentService = this.f14966a;
        baseIntentService.agooFactory = AgooFactory.getInstance(baseIntentService.getApplicationContext());
        BaseIntentService baseIntentService2 = this.f14966a;
        baseIntentService2.notifyManager = baseIntentService2.agooFactory.getNotifyManager();
        BaseIntentService baseIntentService3 = this.f14966a;
        baseIntentService3.messageService = baseIntentService3.agooFactory.getMessageService();
    }
}
