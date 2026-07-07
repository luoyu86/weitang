package c.e.a.c.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Camera.PreviewCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1145a = f.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f1148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1149e;

    public f(b bVar, boolean z) {
        this.f1146b = bVar;
        this.f1147c = z;
    }

    public void a(Handler handler, int i2) {
        this.f1148d = handler;
        this.f1149e = i2;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointB = this.f1146b.b();
        if (!this.f1147c) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.f1148d;
        if (handler == null) {
            Log.d(f1145a, "Got preview callback, but no handler for it");
        } else {
            handler.obtainMessage(this.f1149e, pointB.x, pointB.y, bArr).sendToTarget();
            this.f1148d = null;
        }
    }
}
