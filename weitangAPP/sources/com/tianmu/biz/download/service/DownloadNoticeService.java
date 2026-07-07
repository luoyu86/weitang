package com.tianmu.biz.download.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.download.receiver.DownloadNoticeReceiver;
import com.tianmu.c.h.d.c;
import com.tianmu.c.h.d.d;
import com.tianmu.c.h.f.a;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadNoticeService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadNoticeReceiver f10845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10846b;

    private void a(String str, Intent intent) {
        c.c().a(str, intent);
        c.c().a(str, -1);
    }

    public void b() {
        d.c().b();
        c.c().b();
        DownloadNoticeReceiver downloadNoticeReceiver = this.f10845a;
        if (downloadNoticeReceiver != null) {
            unregisterReceiver(downloadNoticeReceiver);
            this.f10845a.a();
            this.f10845a = null;
        }
    }

    public void c(String str) {
        c.c().d(str);
        d(str);
    }

    public void d(String str) {
        c.c().a(str, 0);
        d.c().e(str);
    }

    public void e(String str) {
        c.c().f(str);
        f(str);
    }

    public void f(String str) {
        d.c().d(str);
    }

    public void g(String str) {
        d(str);
        d.c().b(str);
    }

    public void h(String str) {
        d.c().c(str);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            a();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        try {
            this.f10846b = TianmuSDK.getInstance().getContext().getPackageName();
            String stringExtra = intent.getStringExtra("adKey");
            String stringExtra2 = intent.getStringExtra("appPackageName");
            if (!TextUtils.isEmpty(stringExtra2)) {
                stringExtra = stringExtra2;
            }
            if (c.c().a(stringExtra) == null) {
                a(stringExtra, intent);
            }
        } catch (Exception unused) {
        }
        return super.onStartCommand(intent, i2, i3);
    }

    public void a(String str) {
        try {
            if (d.c().a(str) != null) {
                f(str);
                return;
            }
            Intent intentA = c.c().a(str);
            int iC = c.c().c(str);
            String stringExtra = intentA.getStringExtra("appPackageName");
            String stringExtra2 = intentA.getStringExtra("appLogoUrl");
            a aVar = new a(getApplication(), iC, str, this.f10846b, stringExtra, intentA.getStringExtra("appName"), stringExtra2);
            d.c().a(str, aVar);
            aVar.d();
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        c.c().a(str, 1);
        d.c().a(str, 100);
        if (c.c().a(str) != null) {
            d.c().c(str);
        } else {
            d.c().a();
        }
        c.c().e(str);
    }

    public void a() {
        this.f10845a = new DownloadNoticeReceiver(this, TianmuSDK.getInstance().getContext().getPackageName(), this);
    }

    public void a(String str, int i2) {
        if (i2 >= 100) {
            c.c().a(str, 1);
            d.c().a(str, 100);
        } else {
            c.c().a(str, 2);
            d.c().a(str, i2);
        }
    }
}
