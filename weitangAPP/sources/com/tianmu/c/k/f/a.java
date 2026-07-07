package com.tianmu.c.k.f;

import android.os.Handler;
import com.tianmu.utils.TianmuPackageUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f11789a;

    /* JADX INFO: renamed from: com.tianmu.c.k.f.a$a, reason: collision with other inner class name */
    public class RunnableC0211a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11791b;

        public RunnableC0211a(int i2, String str) {
            this.f11790a = i2;
            this.f11791b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f11790a, this.f11791b);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    public a(Handler handler) {
        this.f11789a = handler;
    }

    public abstract void a();

    public abstract void a(int i2, String str);

    @Override // com.tianmu.c.k.f.d
    public void a(String str, String str2) {
    }

    @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
    public final void onRequestFailed(int i2, String str) {
        if (TianmuPackageUtil.isMainThread()) {
            a(i2, str);
            return;
        }
        Handler handler = this.f11789a;
        if (handler != null) {
            handler.post(new RunnableC0211a(i2, str));
        }
    }

    @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
    public void onRequestSuccess(String str) {
        Handler handler = this.f11789a;
        if (handler != null) {
            handler.post(new b());
        }
    }
}
