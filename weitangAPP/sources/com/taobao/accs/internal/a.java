package com.taobao.accs.internal;

import android.content.Context;
import com.taobao.accs.ACCSClient;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ACCSManagerImpl f10320c;

    public a(ACCSManagerImpl aCCSManagerImpl, String str, Context context) {
        this.f10320c = aCCSManagerImpl;
        this.f10318a = str;
        this.f10319b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ACCSClient.getAccsClient(this.f10318a).addConnectionListener(new b(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
