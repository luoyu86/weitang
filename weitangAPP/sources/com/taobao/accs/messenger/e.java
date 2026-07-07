package com.taobao.accs.messenger;

import android.content.Intent;
import android.os.RemoteException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10341a = e.class.getName() + ".TRY_COUNT";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f10342b = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10343c;

    public e(a aVar) {
        this.f10343c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Intent intent) {
        d dVarA = this.f10343c.a(str);
        if (dVarA == null) {
            this.f10343c.a(str, intent);
            c(str, intent);
            return;
        }
        try {
            dVarA.a(intent);
        } catch (RemoteException unused) {
            this.f10343c.b(str, dVarA);
            this.f10343c.a(str, intent);
            c(str, intent);
        }
    }

    private void c(String str, Intent intent) {
        String str2 = f10341a;
        int intExtra = intent.getIntExtra(str2, 0);
        if (intExtra > 10) {
            return;
        }
        intent.putExtra(str2, intExtra + 1);
        this.f10342b.schedule(new f(this, str, intent), 1000L, TimeUnit.MILLISECONDS);
    }

    public void a(String str, Intent intent) {
        b(str, intent);
    }
}
