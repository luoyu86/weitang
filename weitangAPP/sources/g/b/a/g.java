package g.b.a;

import android.util.Log;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public interface g {

    public static class b implements g {
        @Override // g.b.a.g
        public void log(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // g.b.a.g
        public void log(Level level, String str, Throwable th) {
            System.out.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void log(Level level, String str);

    void log(Level level, String str, Throwable th);

    public static class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f14710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f14711b;

        static {
            boolean z;
            try {
                Class.forName("android.util.Log");
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            f14710a = z;
        }

        public a(String str) {
            this.f14711b = str;
        }

        public static boolean isAndroidLogAvailable() {
            return f14710a;
        }

        public int a(Level level) {
            int iIntValue = level.intValue();
            if (iIntValue < 800) {
                return iIntValue < 500 ? 2 : 3;
            }
            if (iIntValue < 900) {
                return 4;
            }
            return iIntValue < 1000 ? 5 : 6;
        }

        @Override // g.b.a.g
        public void log(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f14711b, str);
            }
        }

        @Override // g.b.a.g
        public void log(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f14711b, str + "\n" + Log.getStackTraceString(th));
            }
        }
    }
}
