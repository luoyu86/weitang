package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.taobao.accs.ServiceReceiver;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f10367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f10368c = {270, 360, 480};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10369a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10372f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f10373g = {0, 0, 0};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10374h;

    public f(Context context) {
        this.f10374h = true;
        try {
            this.f10369a = context;
            this.f10370d = 0;
            this.f10371e = System.currentTimeMillis();
            this.f10374h = OrangeAdapter.isSmartHb();
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    public static f a(Context context) {
        if (f10367b == null) {
            synchronized (f.class) {
                if (f10367b == null) {
                    if (Build.VERSION.SDK_INT >= 21 && b(context)) {
                        ALog.i("HeartbeatManager", "hb use job", new Object[0]);
                        f10367b = new t(context);
                    } else if (c(context)) {
                        ALog.i("HeartbeatManager", "hb use alarm", new Object[0]);
                        f10367b = new a(context);
                    } else {
                        ALog.i("HeartbeatManager", "hb use thread", new Object[0]);
                        f10367b = new u(context);
                    }
                }
            }
        }
        return f10367b;
    }

    private static boolean b(Context context) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context.getPackageName(), AccsJobService.class.getName())) == 1;
    }

    private static boolean c(Context context) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context.getPackageName(), ServiceReceiver.class.getName())) == 1;
    }

    public abstract void a(int i2);

    public void d() {
        this.f10371e = -1L;
        ALog.d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void e() {
        ALog.d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.f10371e <= 7199000) {
            this.f10372f = false;
            this.f10373g[this.f10370d] = 0;
            return;
        }
        int i2 = this.f10370d;
        if (i2 >= f10368c.length - 1 || this.f10373g[i2] > 2) {
            return;
        }
        ALog.d("HeartbeatManager", "upgrade", new Object[0]);
        this.f10370d++;
        this.f10372f = true;
        this.f10371e = System.currentTimeMillis();
    }

    public void f() {
        this.f10370d = 0;
        this.f10371e = System.currentTimeMillis();
        ALog.d("HeartbeatManager", "resetLevel", new Object[0]);
    }

    public int b() {
        int i2 = this.f10374h ? f10368c[this.f10370d] : 270;
        this.f10374h = OrangeAdapter.isSmartHb();
        return i2;
    }

    public void c() {
        this.f10371e = -1L;
        if (this.f10372f) {
            int[] iArr = this.f10373g;
            int i2 = this.f10370d;
            iArr[i2] = iArr[i2] + 1;
        }
        int i3 = this.f10370d;
        this.f10370d = i3 > 0 ? i3 - 1 : 0;
        ALog.d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public synchronized void a() {
        try {
            if (this.f10371e < 0) {
                this.f10371e = System.currentTimeMillis();
            }
            int iB = b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("HeartbeatManager", "set " + iB, new Object[0]);
            }
            a(iB);
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "set", th, new Object[0]);
        }
    }
}
