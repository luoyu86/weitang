package com.chinavisionary.twlib.open.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.Nullable;
import c.e.a.a.d.e;
import c.e.a.d.q;
import c.e.e.a.r.j.k;
import c.e.e.a.x.d;
import c.e.e.a.x.f;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.p0.b;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
public class OpenDoorService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f8819b = e.obtain();

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void c(Intent intent) {
        int intExtra = intent.getIntExtra("type", 0);
        String stringExtra = intent.getStringExtra(b.f5579d);
        d dVar = (d) JSON.parseObject(stringExtra, d.class);
        q.d(getClass().getSimpleName(), "handleOpenDoor json value :" + stringExtra);
        if (dVar == null || intExtra != 0) {
            return;
        }
        d(dVar);
    }

    public final void d(d dVar) {
        if (f.isConnectModel()) {
            return;
        }
        dVar.setBluetoothCookie("");
        dVar.setBluetoothPassword("");
        k.getInstance().setScanOnly(true).startScanTimeOut(TTAdConstant.AD_MAX_EVENT_TIME).openDoorContext(dVar, getApplicationContext(), null);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f8819b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i2, int i3) {
        if (intent != null) {
            this.f8818a = System.currentTimeMillis();
            this.f8819b.postDelayed(new Runnable() { // from class: c.e.e.a.w.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2482a.c(intent);
                }
            }, 500L);
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
