package cn.admobiletop.adsuyi.c;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StringBuilder f4207a = new StringBuilder();

    @TargetApi(11)
    public static class a {
        public static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    public static class b {
        public static int a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    public static class c extends Thread {
        public c(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public static class d implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new c(runnable);
        }
    }

    public static int a(Context context) {
        ActivityManager activityManager = (ActivityManager) f(context, "activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z && Build.VERSION.SDK_INT >= 11) {
            memoryClass = a.a(activityManager);
        }
        return (memoryClass * 1048576) / 7;
    }

    public static int b(Resources resources, G g2) throws FileNotFoundException {
        Uri uri;
        int i2 = g2.f4154f;
        if (i2 != 0 || (uri = g2.f4153e) == null) {
            return i2;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + g2.f4153e);
        }
        List<String> pathSegments = g2.f4153e.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + g2.f4153e);
        }
        if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + g2.f4153e);
            }
        }
        if (pathSegments.size() == 2) {
            return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        }
        throw new FileNotFoundException("More than two path segments: " + g2.f4153e);
    }

    public static int c(Bitmap bitmap) {
        int iA = Build.VERSION.SDK_INT >= 12 ? b.a(bitmap) : bitmap.getRowBytes() * bitmap.getHeight();
        if (iA >= 0) {
            return iA;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static long d(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            blockCount = 5242880;
        }
        return Math.max(Math.min(blockCount, 52428800L), 5242880L);
    }

    public static Resources e(Context context, G g2) throws FileNotFoundException {
        Uri uri;
        if (g2.f4154f != 0 || (uri = g2.f4153e) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + g2.f4153e);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + g2.f4153e);
        }
    }

    public static <T> T f(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    public static <T> T g(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static String h(G g2) {
        StringBuilder sb = f4207a;
        String strI = i(g2, sb);
        sb.setLength(0);
        return strI;
    }

    public static String i(G g2, StringBuilder sb) {
        String str = g2.f4155g;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(g2.f4155g);
        } else {
            Uri uri = g2.f4153e;
            if (uri != null) {
                String string = uri.toString();
                sb.ensureCapacity(string.length() + 50);
                sb.append(string);
            } else {
                sb.ensureCapacity(50);
                sb.append(g2.f4154f);
            }
        }
        sb.append('\n');
        if (g2.n != 0.0f) {
            sb.append("rotation:");
            sb.append(g2.n);
            if (g2.f4158q) {
                sb.append('@');
                sb.append(g2.o);
                sb.append('x');
                sb.append(g2.p);
            }
            sb.append('\n');
        }
        if (g2.c()) {
            sb.append("resize:");
            sb.append(g2.f4157i);
            sb.append('x');
            sb.append(g2.j);
            sb.append('\n');
        }
        if (g2.k) {
            sb.append("centerCrop");
            sb.append('\n');
        } else if (g2.l) {
            sb.append("centerInside");
            sb.append('\n');
        }
        List<N> list = g2.f4156h;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(g2.f4156h.get(i2).a());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static String j(RunnableC0329i runnableC0329i) {
        return k(runnableC0329i, "");
    }

    public static String k(RunnableC0329i runnableC0329i, String str) {
        StringBuilder sb = new StringBuilder(str);
        AbstractC0321a abstractC0321aJ = runnableC0329i.j();
        if (abstractC0321aJ != null) {
            sb.append(abstractC0321aJ.f4209b.d());
        }
        List<AbstractC0321a> listL = runnableC0329i.l();
        if (listL != null) {
            int size = listL.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || abstractC0321aJ != null) {
                    sb.append(", ");
                }
                sb.append(listL.get(i2).f4209b.d());
            }
        }
        return sb.toString();
    }

    public static void l() {
        if (!s()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static void m(Looper looper) {
        Q q2 = new Q(looper);
        q2.sendMessageDelayed(q2.obtainMessage(), 1000L);
    }

    public static void n(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    public static void o(String str, String str2, String str3) {
        p(str, str2, str3, "");
    }

    public static void p(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    public static boolean q(String str) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split(" ", 2);
        if ("CACHE".equals(strArrSplit[0])) {
            return true;
        }
        if (strArrSplit.length == 1) {
            return false;
        }
        try {
            if ("CONDITIONAL_CACHE".equals(strArrSplit[0])) {
                return Integer.parseInt(strArrSplit[1]) == 304;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static File r(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean s() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean t(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean u(InputStream inputStream) {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, CharEncoding.US_ASCII)) && "WEBP".equals(new String(bArr, 8, 4, CharEncoding.US_ASCII));
    }

    public static InterfaceC0337q v(Context context) {
        return new P(context);
    }

    public static byte[] w(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static boolean x(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException unused) {
            return false;
        }
    }
}
