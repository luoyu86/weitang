package com.ss.android.downloadlib.addownload.ok;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.a;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.p;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ok f9825a = null;
    private static final String ok = "ok";

    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> bl;
    private a kf;
    private String n;
    private boolean s = false;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.ok.ok$ok, reason: collision with other inner class name */
    public interface InterfaceC0133ok {
        void ok();
    }

    private ok() {
        a aVar = new a();
        this.kf = aVar;
        this.bl = aVar.ok("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static ok ok() {
        if (f9825a == null) {
            f9825a = new ok();
        }
        return f9825a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.n = "";
        } else if (TextUtils.equals(this.n, str)) {
            this.n = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:21:0x0051, B:22:0x005e, B:23:0x0068, B:25:0x006e, B:28:0x0077, B:30:0x0083, B:33:0x008c, B:35:0x009b, B:38:0x00c1, B:36:0x009f), top: B:42:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:21:0x0051, B:22:0x005e, B:23:0x0068, B:25:0x006e, B:28:0x0077, B:30:0x0083, B:33:0x008c, B:35:0x009b, B:38:0x00c1, B:36:0x009f), top: B:42:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ok(android.app.Activity r22, com.ss.android.socialbase.downloader.model.DownloadInfo r23, boolean r24, com.ss.android.downloadlib.addownload.ok.ok.InterfaceC0133ok r25) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.ok.ok.ok(android.app.Activity, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, com.ss.android.downloadlib.addownload.ok.ok$ok):boolean");
    }

    @MainThread
    public boolean ok(Activity activity, boolean z, InterfaceC0133ok interfaceC0133ok) {
        if (r.q().optInt("disable_install_app_dialog") == 1 || this.s) {
            return false;
        }
        return ok(activity, ok(activity), z, interfaceC0133ok);
    }

    public void ok(Context context, com.ss.android.downloadlib.addownload.a.ok okVar, boolean z, InterfaceC0133ok interfaceC0133ok) {
        this.bl.clear();
        ok(context, okVar, interfaceC0133ok, z);
        this.s = true;
        p.ok(context).bl();
        this.kf.a("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.h.r.ok(ok, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo ok(Context context) {
        long jA;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            jA = p.ok(context).a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (r.q().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !j.n(context, downloadInfo2.getPackageName()) && j.ok(downloadInfo2.getTargetFilePath())) {
                    long jLastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (jLastModified >= jA && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || jLastModified > j)) {
                                downloadInfo = downloadInfo2;
                                j = jLastModified;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void ok(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i2 = 0; i2 < this.bl.size(); i2++) {
            com.ss.android.downloadlib.addownload.a.ok okVar = this.bl.get(i2);
            if (okVar != null && okVar.f9776a == j2) {
                this.bl.set(i2, new com.ss.android.downloadlib.addownload.a.ok(j, j2, j3, str, str2, str3, str4));
                this.kf.ok("sp_ad_install_back_dialog", "key_uninstalled_list", this.bl);
                return;
            }
        }
        this.bl.add(new com.ss.android.downloadlib.addownload.a.ok(j, j2, j3, str, str2, str3, str4));
        this.kf.ok("sp_ad_install_back_dialog", "key_uninstalled_list", this.bl);
    }

    private void ok(final Context context, final com.ss.android.downloadlib.addownload.a.ok okVar, final InterfaceC0133ok interfaceC0133ok, boolean z) {
        final com.ss.android.downloadad.api.ok.a aVarS = kf.ok().s(okVar.f9776a);
        if (aVarS == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.j jVarBl = r.bl();
        a.ok okVarOk = new a.ok(context).ok(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(okVar.n) ? "刚刚下载的应用" : okVar.n;
        jVarBl.a(okVarOk.a(String.format("%1$s下载完成，是否立即安装？", objArr)).bl("立即安装").s(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).ok(false).ok(j.ok(context, okVar.f9777h)).ok(new a.InterfaceC0128a() { // from class: com.ss.android.downloadlib.addownload.ok.ok.1
            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.s.ok.ok().a("backdialog_exit", aVarS);
                InterfaceC0133ok interfaceC0133ok2 = interfaceC0133ok;
                if (interfaceC0133ok2 != null) {
                    interfaceC0133ok2.ok();
                }
                ok.this.a("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void bl(DialogInterface dialogInterface) {
                ok.this.a("");
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void ok(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.s.ok.ok().a("backdialog_install", aVarS);
                com.ss.android.socialbase.appdownloader.s.ok(context, (int) okVar.ok);
                dialogInterface.dismiss();
            }
        }).ok(1).ok());
        com.ss.android.downloadlib.s.ok.ok().a("backdialog_show", aVarS);
        this.n = okVar.s;
    }

    public boolean ok(String str) {
        return TextUtils.equals(this.n, str);
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar) {
        if (r.q().optInt("enable_open_app_dialog", 0) == 1 && !aVar.cf() && aVar.x() && Build.VERSION.SDK_INT < 34) {
            aVar.r(true);
            TTDelegateActivity.ok(aVar);
        }
    }
}
