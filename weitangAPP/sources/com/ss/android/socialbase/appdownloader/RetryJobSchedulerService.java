package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.td;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class RetryJobSchedulerService extends JobService {
    public static void ok(DownloadInfo downloadInfo, long j, boolean z, int i2) {
        Context contextL;
        long j2;
        td reserveWifiStatusListener;
        td reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (contextL = com.ss.android.socialbase.downloader.downloader.bl.l()) == null) {
            return;
        }
        int i3 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.ok(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) contextL.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (i2 == 0 || (z && i2 != 2)) {
                j = 1000;
                j2 = 0;
            } else {
                j2 = 60000 + j;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(contextL.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (!z) {
                i3 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i3).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j2);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener.ok(downloadInfo, 3, 3);
            }
            if (iSchedule <= 0) {
                com.ss.android.socialbase.downloader.bl.ok.s("RetrySchedulerService", "schedule err errCode = " + iSchedule);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.bl.ok(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int iOnStartCommand = super.onStartCommand(intent, i2, i3);
        if (com.ss.android.socialbase.downloader.downloader.bl.k()) {
            return 2;
        }
        return iOnStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.ss.android.socialbase.downloader.bl.ok.bl("RetrySchedulerService", "onStartJob, id = " + jobId);
        com.ss.android.socialbase.downloader.impls.td.ok().ok(jobId);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
