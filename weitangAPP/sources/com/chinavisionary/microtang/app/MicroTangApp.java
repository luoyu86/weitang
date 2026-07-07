package com.chinavisionary.microtang.app;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;
import c.e.a.a.b;
import c.e.a.d.f;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.e.a.x.g;
import c.e.e.a.x.i;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.sdk.android.man.MANService;
import com.alibaba.sdk.android.man.MANServiceProvider;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.chinavisionary.core.app.ad.manager.OAIDManager;
import com.chinavisionary.microtang.vo.ExitAppEvent;
import com.chinavisionary.microtang.vo.InitAuthSuccessVo;
import com.lzy.imagepicker.view.CropImageView;
import com.lzy.ninegrid.NineGridView;
import com.tom_roush.fontbox.ttf.OS2WindowsMetricsTable;
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader;
import g.b.a.c;
import g.b.a.m;

/* JADX INFO: loaded from: classes.dex */
public class MicroTangApp extends Application implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f6815a = false;

    public class a implements CommonCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CloudPushService f6816a;

        public a(CloudPushService cloudPushService) {
            this.f6816a = cloudPushService;
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onFailed(String str, String str2) {
            q.e(MicroTangApp.class.getSimpleName(), "init cloudchannel failed -- errorcode:" + str + " -- errorMessage:" + str2);
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onSuccess(String str) {
            q.i(MicroTangApp.class.getSimpleName(), "init cloudchannel success");
            w.getInstance().putString("device_id_key", this.f6816a.getDeviceId());
        }
    }

    public final boolean a() {
        return getPackageName().equals(b.getProcessName(this, Process.myPid()));
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        q.d(getClass().getSimpleName(), "attachBaseContext start startTime:" + jCurrentTimeMillis);
        MultiDex.install(this);
        q.d(getClass().getSimpleName(), "attachBaseContext endTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public final boolean b() {
        return (getPackageName() + ":channel").equals(b.getProcessName(this, Process.myPid()));
    }

    public final void c() {
        try {
            if (this.f6815a) {
                return;
            }
            this.f6815a = true;
            new OAIDManager().init(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        h();
    }

    public final void e() {
    }

    @m
    public void exitExitAppEvent(ExitAppEvent exitAppEvent) {
        System.exit(0);
    }

    public final void f() {
        d();
        i(this);
        c();
        q.d(getClass().getSimpleName(), "initEMASSdk");
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public final void g() {
        if (c.getDefault().isRegistered(this)) {
            return;
        }
        c.getDefault().register(this);
    }

    public final void h() {
        try {
            boolean zTurnoffCrashReporter = MotuCrashReporter.getInstance().turnoffCrashReporter();
            q.i(MicroTangApp.class.getSimpleName(), "initManService isTurn = " + zTurnoffCrashReporter);
            MANService service = MANServiceProvider.getService();
            service.getMANAnalytics().setAppVersion(b.getInstance().getAppVersionName());
            service.getMANAnalytics().init(this, getApplicationContext());
            service.getMANAnalytics().turnOffAutoPageTrack();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void i(Context context) {
        try {
            CloudPushService cloudPushService = PushServiceFactory.getCloudPushService();
            if (cloudPushService != null) {
                cloudPushService.register(context, new a(cloudPushService));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @m
    public void initAliService(EventApp eventApp) {
        k();
        if (w.getInstance().getBoolean("isFirstLoginAppKey", true)) {
            return;
        }
        q.d(getClass().getSimpleName(), "initAliService IS_INIT_FIRST_LOGIN_APP_KEY");
        f();
    }

    @m
    public void initEMASSdk(InitAuthSuccessVo initAuthSuccessVo) {
        f();
    }

    public final void j() {
        if (c.e.a.a.a.getInstance().isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    public final void k() {
        NineGridView.setImageLoader(new c.e.a.d.c0.b());
        c.k.a.a aVar = c.k.a.a.getInstance();
        aVar.setImageLoader(new c.e.a.d.c0.a());
        aVar.setShowCamera(true);
        aVar.setCrop(true);
        aVar.setSaveRectangle(true);
        aVar.setSelectLimit(9);
        aVar.setStyle(CropImageView.e.RECTANGLE);
        aVar.setFocusWidth(OS2WindowsMetricsTable.WEIGHT_CLASS_EXTRA_BOLD);
        aVar.setFocusHeight(OS2WindowsMetricsTable.WEIGHT_CLASS_EXTRA_BOLD);
        aVar.setOutPutX(1000);
        aVar.setOutPutY(1000);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBackground() {
        c.e.c.m0.c.getInstance().updateAppBackground();
        q.d(getClass().getSimpleName(), "onAppBackground");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppForeground() {
        q.d(getClass().getSimpleName(), "onAppForeground");
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        g.getInstance().setAppContext(this);
        b.getInstance().setAppContext(this);
        c.e.a.a.a.getInstance().setH5Model(true);
        c.e.a.a.a.getInstance().setIMModel(true);
        c.e.a.a.a.getInstance().setDebug(false);
        c.e.a.a.a.getInstance().setQQAppStory(false);
        i.f2493a = c.e.a.a.a.getInstance().isDebug();
        i.setupLog();
        c.e.a.a.a.getInstance().setNewVersionModel(true);
        boolean z = !w.getInstance().getBoolean("isFirstLoginAppKey", true);
        j();
        g();
        PDFBoxResourceLoader.init(this);
        f fVar = new f();
        fVar.init(this);
        Thread.setDefaultUncaughtExceptionHandler(fVar);
        PushServiceFactory.init(this);
        if (a()) {
            if (z) {
                c();
            }
            q.d(getClass().getSimpleName(), "checkIsMainProcess");
        }
        e();
        if (!b() || w.getInstance().getBoolean("isFirstLoginAppKey", true)) {
            return;
        }
        i(this);
        c();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        if (c.getDefault().isRegistered(this)) {
            c.getDefault().unregister(this);
        }
        q.d(getClass().getSimpleName(), "onTerminate");
    }
}
