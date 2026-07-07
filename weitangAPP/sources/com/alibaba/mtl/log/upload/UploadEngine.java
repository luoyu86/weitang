package com.alibaba.mtl.log.upload;

import com.alibaba.mtl.log.d.b;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.s;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class UploadEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static UploadEngine f4583a = new UploadEngine();
    private int B;
    public long z = com.alibaba.mtl.log.a.a.a();
    private boolean G = false;

    /* JADX INFO: Access modifiers changed from: private */
    public long c() {
        long jA;
        int i2;
        i.a("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(com.alibaba.mtl.log.a.o), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(b.b(com.alibaba.mtl.log.a.getContext())));
        boolean z = !b.b(com.alibaba.mtl.log.a.getContext());
        com.alibaba.mtl.log.a.o = z;
        com.alibaba.mtl.log.a.a.a();
        if (z) {
            jA = com.alibaba.mtl.log.a.a.b();
            i2 = this.B;
        } else {
            jA = com.alibaba.mtl.log.a.a.a();
            i2 = this.B;
        }
        this.z = jA + ((long) i2);
        if (com.alibaba.mtl.log.a.a.e()) {
            this.z = 3000L;
        }
        return this.z;
    }

    public static UploadEngine getInstance() {
        return f4583a;
    }

    public void refreshInterval() {
        if (this.B == 0) {
            this.B = 7000;
        } else {
            this.B = 0;
        }
    }

    public synchronized void start() {
        this.G = true;
        if (s.a().b(2)) {
            s.a().f(2);
        }
        c();
        Random random = new Random();
        if (!a.isRunning()) {
            s.a().a(2, new a() { // from class: com.alibaba.mtl.log.upload.UploadEngine.1
                @Override // com.alibaba.mtl.log.upload.a
                public void G() {
                    if (UploadEngine.this.G) {
                        com.alibaba.mtl.log.b.a.C();
                        UploadEngine.this.c();
                        i.a("UploadTask", "mPeriod:", Long.valueOf(UploadEngine.this.z));
                        if (s.a().b(2)) {
                            s.a().f(2);
                        }
                        if (a.isRunning()) {
                            return;
                        }
                        s.a().a(2, this, UploadEngine.this.z);
                    }
                }

                @Override // com.alibaba.mtl.log.upload.a
                public void H() {
                    UploadEngine.this.refreshInterval();
                }
            }, random.nextInt((int) this.z));
        }
    }

    public synchronized void stop() {
        this.G = false;
        s.a().f(2);
    }
}
