package a.a.w;

import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: loaded from: classes.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f258a;

    public g(f fVar) {
        this.f258a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(this.f258a, ThreadPoolExecutorFactory.Priority.HIGH);
    }
}
