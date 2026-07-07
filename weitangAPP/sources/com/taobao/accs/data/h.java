package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f10301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.taobao.accs.net.b f10302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Intent f10303c;

    public h(Context context, com.taobao.accs.net.b bVar, Intent intent) {
        this.f10301a = context;
        this.f10302b = bVar;
        this.f10303c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        g.a().b(this.f10301a, this.f10302b, this.f10303c);
    }
}
