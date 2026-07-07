package a.a.w;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class e implements Future<a.a.l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f245b;

    public e(l lVar) {
        this.f244a = lVar;
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a.a.l get() throws ExecutionException, InterruptedException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public a.a.l b() throws ExecutionException, InterruptedException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!this.f245b) {
            this.f244a.c();
            this.f245b = true;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f245b;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ a.a.l get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return b();
    }
}
