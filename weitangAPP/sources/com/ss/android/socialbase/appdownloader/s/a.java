package com.ss.android.socialbase.appdownloader.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.bl.h;
import com.ss.android.socialbase.appdownloader.s;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.q.kf;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f9961a;
    private List<Integer> ok;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h hVarRh = s.k().rh();
        if (hVarRh != null) {
            hVarRh.ok(list);
        }
        Context contextL = bl.l();
        if (contextL == null) {
            return;
        }
        boolean zA = kf.a(contextL);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            ok(contextL, it.next(), zA, i2);
        }
        List<Integer> list2 = this.ok;
        if (list2 == null || list2.isEmpty() || this.f9961a != null) {
            return;
        }
        this.f9961a = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.s.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (kf.a(applicationContext)) {
                    com.ss.android.socialbase.downloader.bl.ok.a("LaunchResume", "onReceive : wifi connected !!!");
                    bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (a.this.ok != null && !a.this.ok.isEmpty()) {
                                    int size = a.this.ok.size();
                                    Integer[] numArr = new Integer[size];
                                    a.this.ok.toArray(numArr);
                                    a.this.ok.clear();
                                    for (int i3 = 0; i3 < size; i3++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i3].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            a.this.ok(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(a.this.f9961a);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    a.this.f9961a = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextL.registerReceiver(this.f9961a, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.f9961a = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<String> ok() {
        return com.ss.android.socialbase.appdownloader.bl.bl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void ok(final List<DownloadInfo> list, final int i2) {
        if (kf.s()) {
            bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.a(list, i2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            a(list, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ok(android.content.Context r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, boolean r23, int r24) {
        /*
            Method dump skipped, instruction units count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.s.a.ok(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    private void ok(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        int iOk = okVarOk.ok("paused_resume_max_count", 0);
        double dOk = okVarOk.ok("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < iOk && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < dOk * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.ok okVarN = com.ss.android.socialbase.downloader.notification.a.ok().n(downloadInfo.getId());
            if (okVarN == null) {
                okVarN = new com.ss.android.socialbase.appdownloader.n.ok(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.a.ok().ok(okVarN);
            } else {
                okVarN.ok(downloadInfo);
            }
            okVarN.a(downloadInfo.getTotalBytes());
            okVarN.ok(downloadInfo.getCurBytes());
            okVarN.ok(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean ok(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("uninstall_can_not_resume_for_force_task", false)) {
            return kf.ok(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
