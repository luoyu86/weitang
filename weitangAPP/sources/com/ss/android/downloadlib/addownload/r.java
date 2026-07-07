package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.i;
import com.ss.android.download.api.config.io;
import com.ss.android.download.api.config.rh;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.config.x;
import com.ss.android.download.api.config.zz;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.ok;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f9830a;
    private static com.ss.android.download.api.config.h bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static com.ss.android.download.api.config.q f9831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static io f9832i;
    private static x io;
    private static com.ss.android.download.api.config.s j;
    private static com.ss.android.download.api.config.a k;
    private static com.ss.android.download.api.config.p kf;
    private static com.ss.android.download.api.config.j n;
    public static final JSONObject ok = new JSONObject();
    private static com.ss.android.download.api.config.k p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static com.ss.android.download.api.model.ok f9833q;
    private static com.ss.android.socialbase.appdownloader.bl.p r;
    private static t rh;
    private static com.ss.android.download.api.config.bl s;
    private static com.ss.android.download.api.config.r t;
    private static com.ss.android.download.api.config.z td;
    private static com.ss.android.download.api.a.ok u;
    private static zz ul;
    private static rh x;
    private static com.ss.android.download.api.config.n z;
    private static i zz;

    public static void a(Context context) {
        if (f9830a != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f9830a = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.j bl() {
        if (n == null) {
            n = new com.ss.android.download.api.ok.ok();
        }
        return n;
    }

    public static Context getContext() {
        Context context = f9830a;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static t h() {
        return rh;
    }

    public static com.ss.android.download.api.config.n i() {
        return z;
    }

    @NonNull
    public static zz io() {
        if (ul == null) {
            ul = new zz() { // from class: com.ss.android.downloadlib.addownload.r.5
                @Override // com.ss.android.download.api.config.zz
                public void ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
                }
            };
        }
        return ul;
    }

    @Nullable
    public static com.ss.android.download.api.config.a j() {
        return k;
    }

    @NonNull
    public static com.ss.android.download.api.model.ok k() {
        if (f9833q == null) {
            f9833q = new ok.C0129ok().ok();
        }
        return f9833q;
    }

    public static com.ss.android.socialbase.appdownloader.bl.p kf() {
        if (r == null) {
            r = new com.ss.android.socialbase.appdownloader.bl.p() { // from class: com.ss.android.downloadlib.addownload.r.2
                @Override // com.ss.android.socialbase.appdownloader.bl.p
                public void ok(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                }
            };
        }
        return r;
    }

    @NonNull
    public static com.ss.android.download.api.config.q n() {
        if (f9831h == null) {
            f9831h = new com.ss.android.download.api.ok.a();
        }
        return f9831h;
    }

    public static boolean o() {
        return (bl == null || kf == null || p == null || k == null || io == null) ? false : true;
    }

    public static void ok(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f9830a = context.getApplicationContext();
    }

    @NonNull
    public static i p() {
        if (zz == null) {
            zz = new i() { // from class: com.ss.android.downloadlib.addownload.r.3
                @Override // com.ss.android.download.api.config.i
                public void ok(String str, int i2, JSONObject jSONObject) {
                }
            };
        }
        return zz;
    }

    @NonNull
    public static JSONObject q() {
        com.ss.android.download.api.config.k kVar = p;
        return (kVar == null || kVar.ok() == null) ? ok : p.ok();
    }

    public static com.ss.android.download.api.config.z r() {
        return td;
    }

    public static String rh() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.p s() {
        return kf;
    }

    public static com.ss.android.download.api.config.s t() {
        return j;
    }

    @NonNull
    public static x td() {
        return io;
    }

    @NonNull
    public static com.ss.android.download.api.a.ok u() {
        if (u == null) {
            u = new com.ss.android.download.api.a.ok() { // from class: com.ss.android.downloadlib.addownload.r.4
                @Override // com.ss.android.download.api.a.ok
                public void ok(Throwable th, String str) {
                }
            };
        }
        return u;
    }

    public static String ul() {
        try {
            int i2 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + q().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static com.ss.android.download.api.config.r x() {
        return t;
    }

    @Nullable
    public static rh z() {
        return x;
    }

    public static io zz() {
        return f9832i;
    }

    @NonNull
    public static com.ss.android.download.api.config.bl a() {
        if (s == null) {
            s = new com.ss.android.download.api.config.bl() { // from class: com.ss.android.downloadlib.addownload.r.1
                @Override // com.ss.android.download.api.config.bl
                public void ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.bl
                public void ok(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return s;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.h hVar) {
        bl = hVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.j jVar) {
        n = jVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.p pVar) {
        kf = pVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.q qVar) {
        f9831h = qVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.k kVar) {
        p = kVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.model.ok okVar) {
        f9833q = okVar;
    }

    public static void ok(@NonNull com.ss.android.download.api.config.a aVar) {
        k = aVar;
    }

    public static com.ss.android.download.api.config.h ok() {
        return bl;
    }

    public static void ok(String str) {
        com.ss.android.socialbase.appdownloader.s.k().ok(str);
    }

    public static void ok(x xVar) {
        io = xVar;
    }

    public static void ok(com.ss.android.download.api.a.ok okVar) {
        u = okVar;
    }
}
