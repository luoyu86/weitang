package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AMDC" + a.f695a.incrementAndGet());
        ALog.i(anet.channel.strategy.dispatch.a.TAG, "thread created!", null, "name", thread.getName());
        thread.setPriority(5);
        return thread;
    }
}
