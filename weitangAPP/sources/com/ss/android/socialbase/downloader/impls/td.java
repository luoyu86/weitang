package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class td implements Handler.Callback, ok.InterfaceC0174ok {
    private static volatile td ok;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static a f10067q;
    private long kf;
    private final boolean n;
    private ConnectivityManager p;
    private final Handler bl = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<ok> s = new SparseArray<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10069h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10068a = com.ss.android.socialbase.downloader.downloader.bl.l();

    public interface a {
        void ok(DownloadInfo downloadInfo, long j, boolean z, int i2);
    }

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10072a;
        public final int bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f10073h;
        private boolean j;
        private boolean k;
        public final boolean kf;
        public final int n;
        public final int ok;
        private int p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f10074q;
        private long r;
        public final int s;

        public ok(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
            i5 = i5 < 3000 ? 3000 : i5;
            i6 = i6 < 5000 ? 5000 : i6;
            this.ok = i2;
            this.f10072a = i3;
            this.bl = i4;
            this.s = i5;
            this.n = i6;
            this.kf = z;
            this.f10073h = iArr;
            this.p = i5;
        }

        public void bl() {
            this.p = this.s;
        }

        public int s() {
            return this.p;
        }

        public synchronized void a() {
            this.f10074q++;
        }

        public boolean ok(long j, int i2, int i3, boolean z) {
            if (!this.j) {
                com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.f10072a < i2 || this.f10074q >= this.bl) {
                return false;
            }
            if (!this.k || i3 == 2) {
                return z || j - this.r >= ((long) this.s);
            }
            return false;
        }

        public synchronized void ok() {
            this.p += this.n;
        }

        public synchronized void ok(long j) {
            this.r = j;
        }
    }

    private td() {
        kf();
        this.n = com.ss.android.socialbase.downloader.q.kf.bl();
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        try {
            if (this.p == null) {
                this.p = (ConnectivityManager) this.f10068a.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.p.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private void kf() {
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (td.this.f10068a == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    td tdVar = td.this;
                    tdVar.p = (ConnectivityManager) tdVar.f10068a.getApplicationContext().getSystemService("connectivity");
                    td.this.p.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.td.1.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            com.ss.android.socialbase.downloader.bl.ok.a("RetryScheduler", "network onAvailable: ");
                            td.this.ok(1, true);
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            a(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            ok(message.what);
        }
        return true;
    }

    private void a(final int i2, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.2
            @Override // java.lang.Runnable
            public void run() {
                int iH;
                try {
                    if (td.this.f10069h > 0 && (iH = td.this.h()) != 0) {
                        com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + td.this.f10069h);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (td.this.s) {
                            for (int i3 = 0; i3 < td.this.s.size(); i3++) {
                                ok okVar = (ok) td.this.s.valueAt(i3);
                                if (okVar != null && okVar.ok(jCurrentTimeMillis, i2, iH, z)) {
                                    if (z) {
                                        okVar.bl();
                                    }
                                    arrayList.add(okVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                td.this.ok(((ok) it.next()).ok, iH, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void bl(int i2) {
        synchronized (this.s) {
            this.s.remove(i2);
        }
    }

    private ok s(int i2) {
        int[] iArrOk;
        int i3;
        int i4;
        boolean z;
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(i2);
        boolean z2 = false;
        int iOk = okVarOk.ok("retry_schedule", 0);
        JSONObject jSONObjectS = okVarOk.s("retry_schedule_config");
        int i5 = 60;
        if (jSONObjectS != null) {
            int iOptInt = jSONObjectS.optInt("max_count", 60);
            int iOptInt2 = jSONObjectS.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectS.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && f10067q != null && jSONObjectS.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArrOk = ok(jSONObjectS.optString("allow_error_code"));
            i3 = iOptInt3;
            z = z2;
            i4 = iOptInt;
            i5 = iOptInt2;
        } else {
            iArrOk = null;
            i3 = 60;
            i4 = 60;
            z = false;
        }
        return new ok(i2, iOk, i4, i5 * 1000, i3 * 1000, z, iArrOk);
    }

    public void n() {
        ok(5, false);
    }

    private ok a(int i2) {
        ok okVarS = this.s.get(i2);
        if (okVarS == null) {
            synchronized (this.s) {
                okVarS = this.s.get(i2);
                if (okVarS == null) {
                    okVarS = s(i2);
                }
                this.s.put(i2, okVarS);
            }
        }
        return okVarS;
    }

    public static td ok() {
        if (ok == null) {
            synchronized (td.class) {
                if (ok == null) {
                    ok = new td();
                }
            }
        }
        return ok;
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
    public void bl() {
        ok(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
    public void a() {
        ok(4, false);
    }

    public static void ok(a aVar) {
        f10067q = aVar;
    }

    public void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.n.ok) || !com.ss.android.socialbase.downloader.constants.n.ok.equals(downloadInfo.getMimeType())) {
            return;
        }
        ok(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), h());
    }

    public void s() {
        ok(2, true);
    }

    private void ok(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        ok okVarA = a(downloadInfo.getId());
        if (okVarA.f10074q > okVarA.bl) {
            com.ss.android.socialbase.downloader.bl.ok.s("RetryScheduler", "tryStartScheduleRetry, id = " + okVarA.ok + ", mRetryCount = " + okVarA.f10074q + ", maxCount = " + okVarA.bl);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.q.kf.p(failedException) && !com.ss.android.socialbase.downloader.q.kf.q(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!ok(okVarA, errorCode)) {
                return;
            }
            com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "allow error code, id = " + okVarA.ok + ", error code = " + errorCode);
        }
        okVarA.k = z;
        synchronized (this.s) {
            if (!okVarA.j) {
                okVarA.j = true;
                this.f10069h++;
            }
        }
        int iS = okVarA.s();
        com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "tryStartScheduleRetry: id = " + okVarA.ok + ", delayTimeMills = " + iS + ", mWaitingRetryTasks = " + this.f10069h);
        if (!okVarA.kf) {
            if (z) {
                return;
            }
            this.bl.removeMessages(downloadInfo.getId());
            this.bl.sendEmptyMessageDelayed(downloadInfo.getId(), iS);
            return;
        }
        if (i2 == 0) {
            okVarA.bl();
        }
        a aVar = f10067q;
        if (aVar != null) {
            aVar.ok(downloadInfo, iS, z, i2);
        }
        if (this.n) {
            okVarA.ok(System.currentTimeMillis());
            okVarA.a();
            okVarA.ok();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, boolean z) {
        if (this.f10069h <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (jCurrentTimeMillis - this.kf < 10000) {
                    return;
                }
            }
            this.kf = jCurrentTimeMillis;
            com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + "]");
            if (z) {
                this.bl.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i2;
            messageObtain.arg2 = z ? 1 : 0;
            this.bl.sendMessageDelayed(messageObtain, 2000L);
        }
    }

    public void ok(final int i2) {
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    td tdVar = td.this;
                    tdVar.ok(i2, tdVar.h(), true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, int i3, boolean z) {
        com.ss.android.socialbase.downloader.downloader.td reserveWifiStatusListener;
        boolean zOk;
        Context context = this.f10068a;
        if (context == null) {
            return;
        }
        synchronized (this.s) {
            ok okVar = this.s.get(i2);
            if (okVar == null) {
                return;
            }
            boolean z2 = true;
            if (okVar.j) {
                okVar.j = false;
                int i4 = this.f10069h - 1;
                this.f10069h = i4;
                if (i4 < 0) {
                    this.f10069h = 0;
                }
            }
            com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + okVar.f10074q + ", mWaitingRetryTasksCount = " + this.f10069h);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo == null) {
                bl(i2);
                return;
            }
            com.ss.android.socialbase.downloader.bl.ok.n("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.ok(downloadInfo, 4, 3);
                    }
                    com.ss.android.socialbase.downloader.downloader.j jVarY = com.ss.android.socialbase.downloader.downloader.bl.y();
                    if (jVarY != null) {
                        jVarY.ok(Collections.singletonList(downloadInfo), 3);
                    }
                    bl(i2);
                    return;
                }
                if (realStatus != -1) {
                    return;
                }
                if (i3 != 0) {
                    zOk = true;
                } else if (!okVar.kf) {
                    return;
                } else {
                    zOk = false;
                }
                BaseException failedException = downloadInfo.getFailedException();
                if (zOk && com.ss.android.socialbase.downloader.q.kf.p(failedException)) {
                    zOk = ok(downloadInfo, failedException);
                }
                okVar.a();
                if (zOk) {
                    com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + okVar.ok);
                    okVar.ok(System.currentTimeMillis());
                    if (z) {
                        okVar.ok();
                    }
                    downloadInfo.setRetryScheduleCount(okVar.f10074q);
                    if (downloadInfo.getStatus() == -1) {
                        Downloader.getInstance(context).restart(downloadInfo.getId());
                        return;
                    }
                    return;
                }
                if (z) {
                    okVar.ok();
                }
                if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                    z2 = false;
                }
                ok(downloadInfo, z2, i3);
                return;
            }
            bl(i2);
        }
    }

    private boolean ok(ok okVar, int i2) {
        int[] iArr = okVar.f10073h;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length <= 0) {
                return null;
            }
            int[] iArr = new int[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                iArr[i2] = Integer.parseInt(strArrSplit[i2]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean ok(DownloadInfo downloadInfo, BaseException baseException) {
        long jS;
        long totalBytes;
        try {
            jS = com.ss.android.socialbase.downloader.q.kf.s(downloadInfo.getTempPath());
        } catch (BaseException e2) {
            e2.printStackTrace();
            jS = 0;
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.s) {
            totalBytes = ((com.ss.android.socialbase.downloader.exception.s) baseException).a();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (jS < totalBytes) {
            com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
            if (okVarOk.ok("space_fill_part_download", 0) == 1) {
                if (jS > 0) {
                    int iOk = okVarOk.ok("space_fill_min_keep_mb", 100);
                    if (iOk > 0) {
                        long j = jS - (((long) iOk) * 1048576);
                        com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.q.kf.ok(jS) + "MB, minKeep = " + iOk + "MB, canDownload = " + com.ss.android.socialbase.downloader.q.kf.ok(j) + "MB");
                        if (j <= 0) {
                            com.ss.android.socialbase.downloader.bl.ok.s("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (okVarOk.ok("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
