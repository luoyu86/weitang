package com.intelligoo.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AutoOpenService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ScanCallBackSort f9120a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f9121c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f9122f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f9123b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f9125e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9126g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f9124d = b.START;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f9127h = new BroadcastReceiver() { // from class: com.intelligoo.sdk.AutoOpenService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                AutoOpenService.this.f9126g = true;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                AutoOpenService.this.f9126g = false;
            }
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f9128i = new Handler() { // from class: com.intelligoo.sdk.AutoOpenService.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private ScanCallBackSort j = new ScanCallBackSort() { // from class: com.intelligoo.sdk.AutoOpenService.3
        @Override // com.intelligoo.sdk.ScanCallBackSort
        public void onScanResult(ArrayList<Map<String, Integer>> arrayList) {
            int i2;
            if (arrayList.size() == 0) {
                i2 = 5000;
            } else {
                if (!AutoOpenService.f9122f || AutoOpenService.this.f9126g) {
                    AutoOpenService.f9120a.onScanResult(arrayList);
                }
                i2 = 7000;
            }
            AutoOpenService.this.f9124d = b.START;
            AutoOpenService.this.f9125e.sendEmptyMessageDelayed(272, i2);
        }

        @Override // com.intelligoo.sdk.ScanCallBackSort
        public void onScanResultAtOnce(String str, int i2) {
        }
    };

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (AutoOpenService.this.f9124d == b.FINISHED) {
                return false;
            }
            AutoOpenService.this.f9124d = b.SCANNING;
            int iScanDeviceSort = LibDevModel.scanDeviceSort(AutoOpenService.f9121c, false, 1000, AutoOpenService.this.j);
            Log.e("bensontest", "ChildCallback正常执行 scanDeviceSort ret: " + iScanDeviceSort);
            if (iScanDeviceSort != 0) {
                AutoOpenService.this.f9124d = b.START;
                AutoOpenService.this.f9125e.sendEmptyMessageDelayed(272, 5000L);
            }
            return false;
        }
    }

    public enum b {
        START,
        STOP,
        SCANNING,
        OPEN_START,
        OPEN_END,
        FINISHED
    }

    private void d() {
        if (f9122f) {
            e();
            this.f9126g = ((PowerManager) f9121c.getSystemService("power")).isScreenOn();
        }
        HandlerThread handlerThread = new HandlerThread("autoOpenDoor");
        this.f9123b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.f9123b.getLooper(), new a());
        this.f9125e = handler;
        handler.sendEmptyMessageDelayed(272, 1000L);
        this.f9124d = b.START;
    }

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.f9127h, intentFilter);
    }

    private void f() {
        BroadcastReceiver broadcastReceiver = this.f9127h;
        if (broadcastReceiver == null || !f9122f) {
            return;
        }
        try {
            unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public static void startBackgroudMode(Activity activity, ScanCallBackSort scanCallBackSort) {
        f9121c = activity.getApplicationContext();
        f9122f = false;
        f9120a = scanCallBackSort;
    }

    public static void startBackgroundModeWithBrightScreen(Activity activity, ScanCallBackSort scanCallBackSort) {
        f9122f = true;
        startBackgroudMode(activity, scanCallBackSort);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.e("bensontest", "AutoOpenService onCreate 调用startServer");
        if (f9121c == null) {
            Context contextA = d.a();
            f9121c = contextA;
            if (contextA == null) {
                return;
            }
        }
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f9123b != null) {
            this.f9124d = b.FINISHED;
            Log.e("bensontest", "停止mHandlerThread");
            this.f9123b.quit();
        }
        f();
        stopSelf();
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 1;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        if (this.f9123b != null) {
            this.f9124d = b.FINISHED;
            Log.e("bensontest", "停止mHandlerThread");
            this.f9123b.quit();
        }
        f9122f = false;
        stopForeground(true);
        return super.stopService(intent);
    }
}
