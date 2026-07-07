package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class a implements IGDTAdManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ExecutorService f9661g = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f9662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f9663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Context f9664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile PM f9665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile DevTools f9666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile String f9667f;

    /* JADX INFO: renamed from: com.qq.e.comm.managers.a$a, reason: collision with other inner class name */
    public class RunnableC0127a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GDTAdSdk.OnStartListener f9668a;

        public RunnableC0127a(GDTAdSdk.OnStartListener onStartListener) {
            this.f9668a = onStartListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                POFactory pOFactory = a.this.f9665d.getPOFactory(false, false);
                if (pOFactory != null) {
                    pOFactory.start(a.this.f9665d.getStartCaller(1));
                    GDTAdSdk.OnStartListener onStartListener = this.f9668a;
                    if (onStartListener != null) {
                        onStartListener.onStartSuccess();
                    }
                } else {
                    GDTAdSdk.OnStartListener onStartListener2 = this.f9668a;
                    if (onStartListener2 != null) {
                        onStartListener2.onStartFailed(new Exception("GDTAdSdk start异常"));
                    }
                }
            } catch (e e2) {
                GDTLogger.e(e2.getMessage(), e2);
                GDTAdSdk.OnStartListener onStartListener3 = this.f9668a;
                if (onStartListener3 != null) {
                    onStartListener3.onStartFailed(e2);
                }
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f9670a = new a(null);
    }

    public a() {
        this.f9662a = false;
        this.f9663b = false;
    }

    public /* synthetic */ a(RunnableC0127a runnableC0127a) {
        this();
    }

    public static a b() {
        return b.f9670a;
    }

    public String a() {
        return this.f9667f;
    }

    public synchronized void b(GDTAdSdk.OnStartListener onStartListener) {
        if (this.f9662a) {
            f9661g.submit(new RunnableC0127a(onStartListener));
            return;
        }
        GDTLogger.e("在调用start方法前请先调用initWithoutStart方法");
        if (onStartListener != null) {
            onStartListener.onStartFailed(new Exception("在调用start方法前请先调用initWithoutStart方法"));
        }
    }

    public PM c() {
        return this.f9665d;
    }

    public synchronized boolean c(Context context, String str, boolean z) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
            return false;
        }
        if (this.f9662a) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            this.f9667f = str;
            this.f9664c = context.getApplicationContext();
            this.f9665d = new PM(this.f9664c, null);
            f9661g.submit(new com.qq.e.comm.managers.b(this, z));
            this.f9662a = true;
            return true;
        } catch (Throwable th) {
            GDTLogger.e("GDTADManager初始化错误", th);
            return false;
        }
    }

    public boolean d() {
        if (this.f9662a) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.initWithoutStart() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.f9665d.getPOFactory().getBuyerId(map);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f9666e == null) {
            this.f9666e = new DevTools();
        }
        return this.f9666e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.f9665d.getPOFactory().getSDKInfo(str);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.f9663b) {
            return 0;
        }
        try {
            return this.f9665d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return 0;
        }
    }
}
