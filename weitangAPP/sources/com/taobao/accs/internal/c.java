package com.taobao.accs.internal;

import android.app.job.JobParameters;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JobParameters f10322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AccsJobService f10323b;

    public c(AccsJobService accsJobService, JobParameters jobParameters) {
        this.f10323b = accsJobService;
        this.f10322a = jobParameters;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10323b.jobFinished(this.f10322a, false);
    }
}
