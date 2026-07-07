package com.huawei.hms.ads.identifier;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f9094a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9095b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f9096c = new LinkedBlockingQueue<>(1);

    public IBinder a() {
        if (this.f9095b) {
            throw new IllegalStateException();
        }
        this.f9095b = true;
        return this.f9096c.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        Log.d("PPSSerivceConnection", "onServiceConnected");
        f9094a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
                    a.this.f9096c.offer(iBinder);
                } catch (Throwable th) {
                    Log.w("PPSSerivceConnection", "onServiceConnected  " + th.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
