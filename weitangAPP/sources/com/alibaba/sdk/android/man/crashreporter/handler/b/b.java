package com.alibaba.sdk.android.man.crashreporter.handler.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;

/* JADX INFO: loaded from: classes.dex */
public class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4745a = new a() { // from class: com.alibaba.sdk.android.man.crashreporter.handler.b.b.1
        @Override // com.alibaba.sdk.android.man.crashreporter.handler.b.b.a
        public void a(String str, int i2) {
        }

        @Override // com.alibaba.sdk.android.man.crashreporter.handler.b.b.a
        public void c(String str) {
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final InterfaceC0066b f116a = new InterfaceC0066b() { // from class: com.alibaba.sdk.android.man.crashreporter.handler.b.b.2
        @Override // com.alibaba.sdk.android.man.crashreporter.handler.b.b.InterfaceC0066b
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private static final int y = 5000;
    private volatile int A;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Handler f117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Runnable f118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4746b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private InterfaceC0066b f119b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f120b;
    private String s;
    private final int z;

    public interface a {
        void a(String str, int i2);

        void c(String str);
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.man.crashreporter.handler.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0066b {
        void a(InterruptedException interruptedException);
    }

    public b() {
        this(5000);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("ANR-WatchDog");
        int i2 = 1;
        while (!isInterrupted()) {
            int i3 = this.A;
            this.f117a.post(this.f118a);
            try {
                int i4 = this.z / 1000;
                int i5 = 1;
                while (true) {
                    if (i5 > i4) {
                        break;
                    }
                    Thread.sleep(1000L);
                    if (this.A != i3) {
                        this.f4746b.a(String.valueOf(i5), 1);
                        i2++;
                        if (i2 > 3) {
                            Thread.sleep(60000L);
                            i2 = 1;
                        } else {
                            Thread.sleep((i4 - i5) * 1000);
                        }
                    } else {
                        i5++;
                    }
                }
                if (this.A == i3 && MotuCrashReporter.getInstance().getCrashReporterState() == -1) {
                    this.f4746b.c(this.s);
                    return;
                }
            } catch (InterruptedException e2) {
                this.f119b.a(e2);
                return;
            }
        }
    }

    public b(int i2) {
        this.f4746b = f4745a;
        this.f119b = f116a;
        this.f117a = new Handler(Looper.getMainLooper());
        this.s = "";
        this.f120b = false;
        this.A = 0;
        this.f118a = new Runnable() { // from class: com.alibaba.sdk.android.man.crashreporter.handler.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.A = (bVar.A + 1) % 10;
            }
        };
        this.z = i2;
    }

    public b a(a aVar) {
        if (aVar == null) {
            this.f4746b = f4745a;
        } else {
            this.f4746b = aVar;
        }
        return this;
    }

    public b a(InterfaceC0066b interfaceC0066b) {
        if (interfaceC0066b == null) {
            this.f119b = f116a;
        } else {
            this.f119b = interfaceC0066b;
        }
        return this;
    }

    public b a(String str) {
        if (str == null) {
            str = "";
        }
        this.s = str;
        return this;
    }

    public b a() {
        this.s = null;
        return this;
    }

    public void a(boolean z) {
        this.f120b = z;
    }
}
