package com.taobao.accs.messenger;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f10333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f10334b;

    public c(b bVar, Intent intent) {
        this.f10334b = bVar;
        this.f10333a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessengerService.a();
    }
}
