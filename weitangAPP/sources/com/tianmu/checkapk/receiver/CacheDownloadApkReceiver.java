package com.tianmu.checkapk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.d;
import com.tianmu.c.h.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class CacheDownloadApkReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.d.a.a f11934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f11935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f11936c;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CacheDownloadApkReceiver.this.a();
        }
    }

    public CacheDownloadApkReceiver(com.tianmu.d.a.a aVar, c cVar) {
        this.f11934a = aVar;
        this.f11935b = cVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f11936c = handler;
        handler.postDelayed(new a(), 60000L);
    }

    public void a() {
        TianmuSDK.getInstance().getContext().unregisterReceiver(this);
        Handler handler = this.f11936c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11936c = null;
        }
        this.f11934a = null;
        this.f11935b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String strK;
        c cVar;
        try {
            if (intent.getAction() == null || intent.getData() == null || !"android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            com.tianmu.d.a.a aVar = this.f11934a;
            if (aVar != null) {
                com.tianmu.d.d.a.a(aVar.j());
                com.tianmu.c.g.f.a.a().b(this.f11934a.j());
                strK = this.f11934a.k();
            } else {
                strK = "";
            }
            c cVar2 = this.f11935b;
            if (cVar2 != null) {
                cVar2.e();
            }
            if (d.a(schemeSpecificPart, strK) && (cVar = this.f11935b) != null) {
                cVar.b();
            }
            a();
        } catch (Exception unused) {
        }
    }
}
