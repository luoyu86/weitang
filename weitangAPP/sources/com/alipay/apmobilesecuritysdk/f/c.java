package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f5167a;

    public c(b bVar) {
        this.f5167a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.f5167a.f5166c.isEmpty()) {
                Runnable runnable = (Runnable) this.f5167a.f5166c.get(0);
                this.f5167a.f5166c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            b.b(this.f5167a);
            throw th;
        }
        b.b(this.f5167a);
    }
}
