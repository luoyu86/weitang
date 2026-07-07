package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.w;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements IBaseService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, com.taobao.accs.net.b> f10324a = new ConcurrentHashMap<>(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f10325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Service f10326c;

    public d(Service service) {
        this.f10326c = null;
        this.f10326c = service;
        this.f10325b = service.getApplicationContext();
    }

    private void a(boolean z) {
        for (String str : AccsClientConfig.tags()) {
            try {
                if (!AccsClientConfig.getConfigByTag(str).getDisableChannel()) {
                    a(this.f10325b, str, z);
                }
            } catch (Throwable th) {
                ALog.w("ElectionServiceImpl", "tryStartAllConnections " + str, th, new Object[0]);
            }
        }
    }

    private void b(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            String stringExtra4 = intent.getStringExtra("app_sercet");
            String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
            int intExtra = intent.getIntExtra(Constants.KEY_MODE, 0);
            ALog.i("ElectionServiceImpl", "handleStartCommand", Constants.KEY_CONFIG_TAG, stringExtra5, "appkey", stringExtra2, "appSecret", stringExtra4, Constants.KEY_TTID, stringExtra3, "pkg", stringExtra);
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || !stringExtra.equals(this.f10325b.getPackageName())) {
                return;
            }
            Utils.setMode(intExtra);
            com.taobao.accs.net.b bVarA = a(this.f10325b, stringExtra5, false);
            if (bVarA != null) {
                bVarA.f10351a = stringExtra3;
            } else {
                ALog.e("ElectionServiceImpl", "handleStartCommand start action, no connection", Constants.KEY_CONFIG_TAG, stringExtra5);
            }
            UtilityImpl.e(this.f10325b, stringExtra2);
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "handleStartCommand", th, new Object[0]);
        }
    }

    public abstract int a(Intent intent);

    @Override // com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onCreate() {
        ALog.i("ElectionServiceImpl", "onCreate,", Constants.KEY_SDK_VERSION, Integer.valueOf(Constants.SDK_VERSION_CODE));
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onDestroy() {
        ALog.e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.f10325b = null;
        this.f10326c = null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        ALog.i("ElectionServiceImpl", "onStartCommand begin", "action", action);
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            b(intent);
        } else if (TextUtils.isEmpty(action)) {
            a(true);
        } else {
            a(false);
        }
        return a(intent);
    }

    @Override // com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    public static com.taobao.accs.net.b a(Context context, String str, boolean z) {
        com.taobao.accs.net.b wVar = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (TextUtils.isEmpty(str)) {
            ALog.w("ElectionServiceImpl", "getConnection configTag null or env invalid", "conns.size", Integer.valueOf(f10324a.size()));
            if (f10324a.size() > 0) {
                return f10324a.elements().nextElement();
            }
            return null;
        }
        ALog.i("ElectionServiceImpl", "getConnection", Constants.KEY_CONFIG_TAG, str, RequestBannerParamBo.GET_SPLASH_TYPE, Boolean.valueOf(z));
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag != null && configByTag.getDisableChannel()) {
            ALog.e("ElectionServiceImpl", "getConnection channel disabled!", Constants.KEY_CONFIG_TAG, str);
            return null;
        }
        int mode = Utils.getMode();
        String str2 = str + "|" + mode;
        com.taobao.accs.net.b bVar = f10324a.get(str2);
        if (bVar != null) {
            return bVar;
        }
        try {
            AccsClientConfig.mEnv = mode;
            wVar = new w(context, 0, str);
            if (z) {
                wVar.a();
            }
            if (f10324a.size() < 10) {
                f10324a.put(str2, wVar);
            } else {
                ALog.e("ElectionServiceImpl", "getConnection fail as exist too many conns!!!", new Object[0]);
            }
        } catch (Throwable th2) {
            th = th2;
            wVar = bVar;
            ALog.e("ElectionServiceImpl", "getConnection", th, new Object[0]);
        }
        return wVar;
    }
}
