package c.e.a.d;

import java.io.File;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile i f1210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f1211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile BigDecimal f1212c;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jD = i.this.d();
            l.deleteFolder(c.e.a.a.b.getInstance().getContext().getApplicationContext().getCacheDir().getAbsolutePath());
            if (i.this.f1211b != null) {
                i.this.f1211b.clearCacheOver(jD);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jD = i.this.d();
            if (i.this.f1211b != null) {
                i.this.f1211b.updateCacheSize(jD);
            }
        }
    }

    public interface c {
        void clearCacheOver(long j);

        void updateCacheSize(long j);
    }

    public static i getInstance() {
        if (f1210a == null) {
            synchronized (i.class) {
                if (f1210a == null) {
                    f1210a = new i();
                }
            }
        }
        return f1210a;
    }

    public final long c(File file) {
        long jC = 0;
        if (!file.isDirectory()) {
            if (file.isFile()) {
                return 0 + file.length();
            }
            return 0L;
        }
        for (File file2 : file.listFiles()) {
            jC += file2.isDirectory() ? c(file2) : file2.length();
        }
        return jC;
    }

    public void clearCache() {
        y.get().addRunnable(new a());
    }

    public final long d() {
        return (c(c.e.a.a.b.getInstance().getContext().getApplicationContext().getCacheDir()) / 1024) / 1024;
    }

    public void getCacheSize() {
        y.get().addRunnable(new b());
    }

    public BigDecimal getWalletBalance() {
        return this.f1212c;
    }

    public void setICacheSizeCallback(c cVar) {
        this.f1211b = cVar;
    }

    public void setWalletBalance(BigDecimal bigDecimal) {
        this.f1212c = bigDecimal;
    }
}
