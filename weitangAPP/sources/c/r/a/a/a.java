package c.r.a.a;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import anet.channel.entity.ConnType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Camera.AutoFocusCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3133a = a.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Collection<String> f3134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Camera f3136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AsyncTask<?, ?, ?> f3139g;

    public final class b extends AsyncTask<Object, Object, Object> {
        public b() {
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            a.this.start();
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f3134b = arrayList;
        arrayList.add(ConnType.PK_AUTO);
        arrayList.add("macro");
    }

    public a(Camera camera) {
        this.f3136d = camera;
        this.f3135c = f3134b.contains(camera.getParameters().getFocusMode());
        start();
    }

    @SuppressLint({"NewApi"})
    public final synchronized void a() {
        if (!this.f3137e && this.f3139g == null) {
            b bVar = new b();
            try {
                bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f3139g = bVar;
            } catch (RejectedExecutionException e2) {
                Log.w(f3133a, "Could not request auto focus", e2);
            }
        }
    }

    public final synchronized void b() {
        AsyncTask<?, ?, ?> asyncTask = this.f3139g;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.f3139g.cancel(true);
            }
            this.f3139g = null;
        }
    }

    public synchronized void c() {
        this.f3137e = true;
        if (this.f3135c) {
            b();
            try {
                this.f3136d.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.w(f3133a, "Unexpected exception while cancelling focusing", e2);
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f3138f = false;
        a();
    }

    public synchronized void start() {
        if (this.f3135c) {
            this.f3139g = null;
            if (!this.f3137e && !this.f3138f) {
                try {
                    this.f3136d.autoFocus(this);
                    Log.w(f3133a, "自动对焦");
                    this.f3138f = true;
                } catch (RuntimeException e2) {
                    Log.w(f3133a, "Unexpected exception while focusing", e2);
                    a();
                }
            }
        }
    }
}
