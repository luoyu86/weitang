package com.taobao.accs.net;

import android.content.Context;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class u extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledFuture<?> f10407c;

    public u(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.f
    public void a(int i2) {
        ScheduledFuture<?> scheduledFuture = this.f10407c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f10407c = null;
        }
        long j = i2;
        this.f10407c = ThreadPoolExecutorFactory.getScheduledExecutor().scheduleAtFixedRate(new v(this), j, j, TimeUnit.SECONDS);
    }
}
