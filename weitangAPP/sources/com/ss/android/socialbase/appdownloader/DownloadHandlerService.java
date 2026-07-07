package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadHandlerService extends Service {
    private static final String ok = DownloadHandlerService.class.getSimpleName();

    private void a(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.bl.s sVar, ep epVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.a.ok().ok(id);
        downloadInfo.updateDownloadTime();
        if (sVar != null) {
            sVar.ok(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (epVar != null) {
            epVar.ok(7, downloadInfo, "", "");
        }
    }

    private boolean ok(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.bl.s sVarA = s.k().a();
        ep downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.h.ok.ok(intExtra).a("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.a.ok().kf(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            ok(downloadInfo, sVarA, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            ok(this, downloadInfo, sVarA, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            ok(this, downloadInfo, sVarA, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.h.ok.ok(intExtra).ok("no_hide_notification", 0) == 0) {
                if (!(com.ss.android.socialbase.downloader.h.ok.ok(intExtra).a("enable_notification_ui") >= 2 && downloadInfo.getStatus() == -1)) {
                    com.ss.android.socialbase.downloader.notification.a.ok().ok(intExtra);
                    com.ss.android.socialbase.downloader.notification.a.ok().kf(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            a(downloadInfo, sVarA, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.a.ok().ok(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.bl.ok(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "onStartCommand");
        }
        ok(intent);
        stopSelf();
        return 2;
    }

    private static void ok(Context context, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.q.kf.a(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void ok(Context context, final com.ss.android.socialbase.appdownloader.bl.s sVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final ep downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (sVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                File file;
                PackageInfo packageInfoOk;
                try {
                    file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (file.exists()) {
                    try {
                        String str = (com.ss.android.socialbase.downloader.downloader.bl.l() == null || (packageInfoOk = bl.ok(downloadInfo, file)) == null) ? "" : packageInfoOk.packageName;
                        com.ss.android.socialbase.appdownloader.bl.s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.ok(downloadInfo.getId(), 3, str, -3, downloadInfo.getDownloadTime());
                        }
                        ep epVar = downloadNotificationEventListener;
                        if (epVar != null) {
                            epVar.ok(3, downloadInfo, str, "");
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                    e2.printStackTrace();
                }
            }
        });
    }

    private void ok(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.bl.s sVar, ep epVar) {
        boolean zOk;
        int id = downloadInfo.getId();
        v vVarZ = com.ss.android.socialbase.downloader.downloader.s.ok().z(id);
        if (vVarZ != null) {
            try {
                zOk = vVarZ.ok(downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                zOk = false;
            }
        } else {
            zOk = false;
        }
        if (zOk) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.a.ok().ok(id);
        downloadInfo.updateDownloadTime();
        if (sVar != null) {
            sVar.ok(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (epVar != null) {
            epVar.ok(7, downloadInfo, "", "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void ok(android.content.Context r2, int r3, boolean r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.s r4 = com.ss.android.socialbase.downloader.downloader.s.ok()
            com.ss.android.socialbase.downloader.depend.v r4 = r4.z(r3)
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.Downloader r1 = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(r2)     // Catch: java.lang.Throwable -> L1c
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r1.getDownloadInfo(r3)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L20
            boolean r4 = r4.a(r1)     // Catch: java.lang.Throwable -> L1c
            goto L21
        L1c:
            r4 = move-exception
            r4.printStackTrace()
        L20:
            r4 = 0
        L21:
            if (r4 == 0) goto L24
            return
        L24:
            r4 = 1
            int r3 = com.ss.android.socialbase.appdownloader.bl.ok(r2, r3, r4)
            if (r3 != 0) goto L34
            java.lang.String r3 = "Open Fail!"
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.ok(android.content.Context, int, boolean):void");
    }

    public static void ok(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.bl.s sVar, ep epVar) {
        com.ss.android.socialbase.downloader.notification.ok okVarN;
        int id = downloadInfo.getId();
        v vVarZ = com.ss.android.socialbase.downloader.downloader.s.ok().z(id);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && vVarZ != null && bl.ok(context, downloadInfo) && vVarZ.bl(downloadInfo)) {
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.h.ok.ok(id).a("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                ok(com.ss.android.socialbase.downloader.downloader.bl.l(), id, true);
                ok(context, sVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.h.ok.ok(id).ok("notification_click_install_auto_cancel", 1) != 0 || (okVarN = com.ss.android.socialbase.downloader.notification.a.ok().n(id)) == null) {
                    z = true;
                } else {
                    okVarN.h();
                    okVarN.ok(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.a.ok().ok(id);
                }
                break;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.s.ok().n(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    bl.ok(downloadInfo, true, false);
                }
                if (sVar != null) {
                    sVar.ok(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (epVar != null) {
                    epVar.ok(6, downloadInfo, "", "");
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                ok(context, downloadInfo);
                if (sVar != null) {
                    sVar.ok(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (epVar != null) {
                    epVar.ok(5, downloadInfo, "", "");
                }
                break;
        }
    }
}
