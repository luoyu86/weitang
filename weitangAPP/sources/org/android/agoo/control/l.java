package org.android.agoo.control;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f14967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseIntentService f14968b;

    public l(BaseIntentService baseIntentService, Intent intent) {
        this.f14968b = baseIntentService;
        this.f14967a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14968b.onHandleIntent(this.f14967a);
    }
}
