package anet.channel.request;

import anet.channel.util.ALog;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class b implements Cancelable {
    public static final b NULL = new b(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<?> f548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f549b;

    public b(Future<?> future, String str) {
        this.f548a = future;
        this.f549b = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        if (this.f548a != null) {
            ALog.i("awcn.FutureCancelable", "cancel request", this.f549b, new Object[0]);
            this.f548a.cancel(true);
        }
    }
}
