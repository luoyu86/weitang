package com.alibaba.sdk.android.push.b;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.push.channel.KeepChannelService;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AmsLogger f4850a = AmsLogger.getLogger("MPS:KeepLiveManager");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f4851b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f4852c = null;

    private a() {
    }

    public static a a() {
        if (f4852c == null) {
            f4852c = new a();
        }
        return f4852c;
    }

    public static void a(Context context) {
        f4851b = context;
        if (f4852c == null) {
            f4852c = a();
        }
    }

    public void b() {
        if (f4851b != null) {
            f4850a.d("Check KeepChannelService");
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    JobScheduler jobScheduler = (JobScheduler) f4851b.getSystemService("jobscheduler");
                    for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                        if (jobInfo.getId() == 900715 && jobInfo.getService().equals(new ComponentName(f4851b.getPackageName(), KeepChannelService.class.getName()))) {
                            f4850a.d("cancel Keep Channel Service");
                            jobScheduler.cancel(jobInfo.getId());
                            return;
                        }
                    }
                } catch (Throwable th) {
                    f4850a.e("start KeepChannelService failed.", th);
                }
            }
        }
    }
}
