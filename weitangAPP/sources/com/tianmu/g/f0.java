package com.tianmu.g;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StringBuilder f12064a = new StringBuilder();

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000L);
        }
    }

    @TargetApi(11)
    public static class b {
        public static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    public static class c {
        public static int a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    public static class d extends Thread {
        public d(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public static class e implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new d(runnable);
        }
    }

    public static int a(Bitmap bitmap) {
        int iA = Build.VERSION.SDK_INT >= 12 ? c.a(bitmap) : bitmap.getRowBytes() * bitmap.getHeight();
        if (iA >= 0) {
            return iA;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static i c(Context context) {
        return new e0(context);
    }

    public static boolean d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static byte[] c(InputStream inputStream) {
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

    public static <T> T a(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void a() {
        if (!b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static boolean b(InputStream inputStream) {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, CharEncoding.US_ASCII)) && "WEBP".equals(new String(bArr, 8, 4, CharEncoding.US_ASCII));
    }

    public static String a(com.tianmu.g.c cVar) {
        return a(cVar, "");
    }

    public static String a(com.tianmu.g.c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        com.tianmu.g.a aVarB = cVar.b();
        if (aVarB != null) {
            sb.append(aVarB.f12024b.d());
        }
        List<com.tianmu.g.a> listC = cVar.c();
        if (listC != null) {
            int size = listC.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || aVarB != null) {
                    sb.append(", ");
                }
                sb.append(listC.get(i2).f12024b.d());
            }
        }
        return sb.toString();
    }

    public static void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    public static void a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    public static String a(v vVar) {
        StringBuilder sb = f12064a;
        String strA = a(vVar, sb);
        sb.setLength(0);
        return strA;
    }

    public static String a(v vVar, StringBuilder sb) {
        String str = vVar.f12161f;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(vVar.f12161f);
        } else {
            Uri uri = vVar.f12159d;
            if (uri != null) {
                String string = uri.toString();
                sb.ensureCapacity(string.length() + 50);
                sb.append(string);
            } else {
                sb.ensureCapacity(50);
                sb.append(vVar.f12160e);
            }
        }
        sb.append('\n');
        if (vVar.m != 0.0f) {
            sb.append("rotation:");
            sb.append(vVar.m);
            if (vVar.p) {
                sb.append('@');
                sb.append(vVar.n);
                sb.append('x');
                sb.append(vVar.o);
            }
            sb.append('\n');
        }
        if (vVar.c()) {
            sb.append("resize:");
            sb.append(vVar.f12163h);
            sb.append('x');
            sb.append(vVar.f12164i);
            sb.append('\n');
        }
        if (vVar.j) {
            sb.append("centerCrop");
            sb.append('\n');
        } else if (vVar.k) {
            sb.append("centerInside");
            sb.append('\n');
        }
        List<d0> list = vVar.f12162g;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(vVar.f12162g.get(i2).a());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static void a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    public static boolean a(String str) {
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

    public static long a(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            blockCount = 5242880;
        }
        return Math.max(Math.min(blockCount, 52428800L), 5242880L);
    }

    public static int a(Context context) {
        ActivityManager activityManager = (ActivityManager) a(context, "activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z && Build.VERSION.SDK_INT >= 11) {
            memoryClass = b.a(activityManager);
        }
        return (memoryClass * 1048576) / 7;
    }

    public static <T> T a(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    public static int a(Resources resources, v vVar) throws FileNotFoundException {
        Uri uri;
        int i2 = vVar.f12160e;
        if (i2 != 0 || (uri = vVar.f12159d) == null) {
            return i2;
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            List<String> pathSegments = vVar.f12159d.getPathSegments();
            if (pathSegments != null && !pathSegments.isEmpty()) {
                if (pathSegments.size() == 1) {
                    try {
                        return Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                        throw new FileNotFoundException("Last path segment is not a resource ID: " + vVar.f12159d);
                    }
                }
                if (pathSegments.size() == 2) {
                    return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                }
                throw new FileNotFoundException("More than two path segments: " + vVar.f12159d);
            }
            throw new FileNotFoundException("No path segments: " + vVar.f12159d);
        }
        throw new FileNotFoundException("No package provided: " + vVar.f12159d);
    }

    public static Resources a(Context context, v vVar) throws FileNotFoundException {
        Uri uri;
        if (vVar.f12160e == 0 && (uri = vVar.f12159d) != null) {
            String authority = uri.getAuthority();
            if (authority != null) {
                try {
                    return context.getPackageManager().getResourcesForApplication(authority);
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new FileNotFoundException("Unable to obtain resources for package: " + vVar.f12159d);
                }
            }
            throw new FileNotFoundException("No package provided: " + vVar.f12159d);
        }
        return context.getResources();
    }

    public static void a(Looper looper) {
        a aVar = new a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000L);
    }
}
