package com.ss.android.socialbase.appdownloader.n;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.widget.RemoteViews;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.n;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ok extends com.ss.android.socialbase.downloader.notification.ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9946a;
    private final Resources bl;
    private String kf;
    private String n;
    private String s;

    public ok(Context context, int i2, String str, String str2, String str3, String str4) {
        super(i2, str);
        this.n = str2;
        this.s = str3;
        this.kf = str4;
        Context applicationContext = context.getApplicationContext();
        this.f9946a = applicationContext;
        this.bl = applicationContext.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0446  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification a(com.ss.android.socialbase.downloader.exception.BaseException r25, boolean r26) {
        /*
            Method dump skipped, instruction units count: 1425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.n.ok.a(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private androidx.core.app.NotificationCompat.Builder k() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.s r0 = com.ss.android.socialbase.appdownloader.s.k()
            java.lang.String r0 = r0.q()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f9946a
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.f9946a
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.bl.a(r0)
        L22:
            com.ss.android.socialbase.appdownloader.s r1 = com.ss.android.socialbase.appdownloader.s.k()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.bl.z r1 = r1.z()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.s r1 = com.ss.android.socialbase.appdownloader.s.k()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.bl.z r1 = r1.z()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f9946a     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.ok(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f9946a     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f9946a
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.n.ok.k():androidx.core.app.NotificationCompat$Builder");
    }

    private RemoteViews q() {
        RemoteViews remoteViews = new RemoteViews(this.f9946a.getPackageName(), n.ok());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.bl.ok(this.f9946a)) {
                    remoteViews.setInt(n.kf(), "setBackgroundColor", this.f9946a.getResources().getColor(n.td()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    @Override // com.ss.android.socialbase.downloader.notification.ok
    public void ok(DownloadInfo downloadInfo) {
        super.ok(downloadInfo);
        this.n = downloadInfo.getSavePath();
        this.s = downloadInfo.getName();
        this.kf = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.ok
    public void ok(BaseException baseException, boolean z) {
        if (this.f9946a == null) {
            return;
        }
        try {
            Notification notificationA = a(baseException, z);
            this.ok = notificationA;
            ok(notificationA);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean ok(BaseException baseException, com.ss.android.socialbase.downloader.h.ok okVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && okVar.ok("notification_text_opt", 0) == 1;
    }

    private int ok(int i2, int i3) {
        if (com.ss.android.socialbase.downloader.h.ok.ok(i3).a("notification_opt_2") == 1) {
            return n.ul();
        }
        if (i2 == 1 || i2 == 4) {
            return n.u();
        }
        if (i2 == 2) {
            return n.io();
        }
        if (i2 == 3) {
            return n.ul();
        }
        return 0;
    }

    private PendingIntent ok(String str, int i2, int i3) {
        Intent intent = new Intent(this.f9946a, (Class<?>) DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i3);
        intent.putExtra("extra_click_download_type", i2);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f9946a, i3, intent, 201326592);
    }

    private int ok(int i2) {
        if (com.ss.android.socialbase.downloader.h.ok.ok(i2).a("enable_notification_ui") >= 1) {
            return n.p();
        }
        return n.h();
    }
}
