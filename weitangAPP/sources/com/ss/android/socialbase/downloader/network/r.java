package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    private static final String ok = "r";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f10138a;
    private volatile boolean bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10139h;
    private final ArrayList<a> kf;
    private AtomicReference<j> n;
    private final AtomicReference<j> s;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.r$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] ok;

        static {
            int[] iArr = new int[j.values().length];
            ok = iArr;
            try {
                iArr[j.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ok[j.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ok[j.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ok[j.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface a {
        void ok(j jVar);
    }

    public static class ok {
        public static final r ok = new r(null);
    }

    public /* synthetic */ r(AnonymousClass1 anonymousClass1) {
        this();
    }

    private boolean bl() {
        if (this.f10138a == null) {
            return false;
        }
        try {
            int i2 = AnonymousClass1.ok[this.s.get().ordinal()];
            double d2 = 2000.0d;
            double d3 = 550.0d;
            if (i2 == 1) {
                d3 = 0.0d;
                d2 = 150.0d;
            } else if (i2 == 2) {
                d2 = 550.0d;
                d3 = 150.0d;
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d3 = 2000.0d;
            }
            double dOk = this.f10138a.ok();
            if (dOk > d2) {
                if (dOk > d2 * 1.25d) {
                    return true;
                }
            } else if (dOk < d3 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static r ok() {
        return ok.ok;
    }

    private void s() {
        try {
            int size = this.kf.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.kf.get(i2).ok(this.s.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized j a() {
        s sVar = this.f10138a;
        if (sVar == null) {
            return j.UNKNOWN;
        }
        try {
            return ok(sVar.ok());
        } catch (Throwable th) {
            th.printStackTrace();
            return j.UNKNOWN;
        }
    }

    private r() {
        this.f10138a = new s(0.05d);
        this.bl = false;
        this.s = new AtomicReference<>(j.UNKNOWN);
        this.kf = new ArrayList<>();
    }

    public synchronized void ok(long j, long j2) {
        j jVarA;
        double d2 = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d2 < 3.0d) {
            return;
        }
        try {
            this.f10138a.ok(d2);
            jVarA = a();
        } catch (Throwable unused) {
        }
        if (!this.bl) {
            if (this.s.get() != jVarA) {
                this.bl = true;
                this.n = new AtomicReference<>(jVarA);
            }
            return;
        }
        this.f10139h++;
        if (jVarA != this.n.get()) {
            this.bl = false;
            this.f10139h = 1;
        }
        if (this.f10139h >= 5.0d && bl()) {
            this.bl = false;
            this.f10139h = 1;
            this.s.set(this.n.get());
            s();
        }
    }

    private j ok(double d2) {
        if (d2 < 0.0d) {
            return j.UNKNOWN;
        }
        if (d2 < 150.0d) {
            return j.POOR;
        }
        if (d2 < 550.0d) {
            return j.MODERATE;
        }
        if (d2 < 2000.0d) {
            return j.GOOD;
        }
        return j.EXCELLENT;
    }
}
