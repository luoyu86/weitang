package com.taobao.accs.messenger;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f10345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f10346c;

    public f(e eVar, String str, Intent intent) {
        this.f10346c = eVar;
        this.f10344a = str;
        this.f10345b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10346c.b(this.f10344a, this.f10345b);
    }
}
