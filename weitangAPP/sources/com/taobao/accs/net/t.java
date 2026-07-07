package com.taobao.accs.net;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.taobao.accs.internal.AccsJobService;

/* JADX INFO: loaded from: classes2.dex */
public class t extends f {
    public static final int DEAMON_JOB_ID = 2051;
    public static final int HB_JOB_ID = 2050;

    public t(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.f
    public void a(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j = ((long) i2) * 1000;
            ((JobScheduler) this.f10369a.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(HB_JOB_ID, new ComponentName(this.f10369a.getPackageName(), AccsJobService.class.getName())).setMinimumLatency(j).setOverrideDeadline(j).setRequiredNetworkType(1).build());
        }
    }
}
