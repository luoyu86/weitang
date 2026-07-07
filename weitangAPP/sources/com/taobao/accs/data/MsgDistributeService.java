package com.taobao.accs.data;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class MsgDistributeService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Messenger f10277a = new Messenger(new i(this));

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f10277a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        try {
            ALog.i("MsgDistributeService", "onStartCommand", "action", intent.getAction());
            if (TextUtils.isEmpty(intent.getAction()) || !TextUtils.equals(intent.getAction(), Constants.ACTION_SEND)) {
                ALog.i("MsgDistributeService", "onStartCommand distribute message", new Object[0]);
                g.a(getApplicationContext(), intent);
            } else if (getPackageName().equals(intent.getStringExtra("packageName"))) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(new j(this, intent));
            }
        } catch (Throwable th) {
            ALog.e("MsgDistributeService", "onStartCommand", th, new Object[0]);
        }
        return 2;
    }
}
