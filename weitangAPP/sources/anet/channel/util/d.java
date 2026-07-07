package anet.channel.util;

import anet.channel.statist.NetTypeStat;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetTypeStat f722b;

    public d(String str, NetTypeStat netTypeStat) {
        this.f721a = str;
        this.f722b = netTypeStat;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(new e(this), ThreadPoolExecutorFactory.Priority.LOW);
    }
}
