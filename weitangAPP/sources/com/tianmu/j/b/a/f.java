package com.tianmu.j.b.a;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: classes2.dex */
public class f extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f12276b;

    public interface a {
        void a(int i2);
    }

    public f(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f12276b = aVar;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f12275a < 300) {
            return;
        }
        a aVar = this.f12276b;
        if (aVar != null) {
            aVar.a(i2);
        }
        this.f12275a = jCurrentTimeMillis;
    }
}
