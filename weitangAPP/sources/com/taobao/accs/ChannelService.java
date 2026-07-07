package com.taobao.accs;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.taobao.accs.base.BaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class ChannelService extends BaseService {
    public static final int DEFAULT_FOREGROUND_V = 24;
    public static final int NOTIFY_ID = 9371;
    public static int SDK_VERSION_CODE = 222;
    public static final String SUPPORT_FOREGROUND_VERSION_KEY = "support_foreground_v";
    public static final String TAG = "ChannelService";
    private static ChannelService mInstance;
    private boolean mFirstStarted = true;

    public static class KernelService extends Service {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static KernelService f10235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f10236b;

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            f10235a = this;
            this.f10236b = getApplicationContext();
        }

        @Override // android.app.Service
        public void onDestroy() {
            try {
                stopForeground(true);
            } catch (Throwable th) {
                ALog.e(ChannelService.TAG, "onDestroy", th, new Object[0]);
            }
            f10235a = null;
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i2, int i3) {
            try {
                ThreadPoolExecutorFactory.execute(new b(this));
            } catch (Throwable th) {
                ALog.e(ChannelService.TAG, " onStartCommand", th, new Object[0]);
            }
            return super.onStartCommand(intent, i2, i3);
        }
    }

    public static ChannelService getInstance() {
        return mInstance;
    }

    public static int getSupportForegroundVer(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(SUPPORT_FOREGROUND_VERSION_KEY, 24);
        } catch (Throwable th) {
            ALog.e(TAG, "getSupportForegroundVer fail:", th, "key", SUPPORT_FOREGROUND_VERSION_KEY);
            return 24;
        }
    }

    public static void startKernel(Context context) {
        try {
            if (Build.VERSION.SDK_INT < getSupportForegroundVer(context)) {
                Intent intent = new Intent(context, (Class<?>) KernelService.class);
                intent.setPackage(context.getPackageName());
                context.startService(intent);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "startKernel", th, new Object[0]);
        }
    }

    public static void stopKernel(Context context) {
        try {
            if (Build.VERSION.SDK_INT < getSupportForegroundVer(context)) {
                Intent intent = new Intent(context, (Class<?>) KernelService.class);
                intent.setPackage(context.getPackageName());
                context.stopService(intent);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "stopKernel", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.base.BaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        if (Build.VERSION.SDK_INT < 18) {
            try {
                startForeground(NOTIFY_ID, new Notification());
            } catch (Throwable th) {
                ALog.e(TAG, "ChannelService onCreate", th, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.base.BaseService, android.app.Service
    public void onDestroy() {
        if (Build.VERSION.SDK_INT < 18) {
            try {
                stopForeground(true);
            } catch (Throwable th) {
                ALog.e(TAG, "ChannelService onDestroy", th, new Object[0]);
            }
        }
        stopKernel(getApplicationContext());
        super.onDestroy();
    }

    @Override // com.taobao.accs.base.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.mFirstStarted) {
            this.mFirstStarted = false;
            startKernel(getApplicationContext());
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
