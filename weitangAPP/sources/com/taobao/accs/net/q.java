package com.taobao.accs.net;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f10403a;

    public q(j jVar) {
        this.f10403a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            j jVar = this.f10403a;
            if (jVar.f10354d == null || TextUtils.isEmpty(jVar.i())) {
                return;
            }
            this.f10403a.t.i("mTryStartServiceRunnable bindApp");
            j jVar2 = this.f10403a;
            jVar2.b(jVar2.f10354d);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
