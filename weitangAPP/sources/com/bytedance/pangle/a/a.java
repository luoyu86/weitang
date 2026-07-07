package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f5939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f5940b;

    /* JADX INFO: renamed from: com.bytedance.pangle.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0099a {
        void a();
    }

    private a(InterfaceC0099a[] interfaceC0099aArr) {
        this.f5939a = new CountDownLatch(interfaceC0099aArr.length);
        for (final InterfaceC0099a interfaceC0099a : interfaceC0099aArr) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0099a.a();
                    } catch (Throwable th) {
                        a.this.f5940b = th;
                    }
                    a.this.f5939a.countDown();
                }
            });
        }
    }

    public static void a(InterfaceC0099a... interfaceC0099aArr) throws Throwable {
        a aVar = new a(interfaceC0099aArr);
        try {
            aVar.f5939a.await();
            Throwable th = aVar.f5940b;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
