package org.android.agoo.control;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f14963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f14964b;

    public i(h hVar, Intent intent) {
        this.f14964b = hVar;
        this.f14963a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14964b.f14962a.onHandleIntent(this.f14963a);
    }
}
