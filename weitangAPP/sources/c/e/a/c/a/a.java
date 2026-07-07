package c.e.a.c.a;

import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Camera.AutoFocusCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1118a = a.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f1119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1120c;

    public void a(Handler handler, int i2) {
        this.f1119b = handler;
        this.f1120c = i2;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        Handler handler = this.f1119b;
        if (handler == null) {
            Log.d(f1118a, "Got auto-focus callback, but no handler for it");
            return;
        }
        this.f1119b.sendMessageDelayed(handler.obtainMessage(this.f1120c, Boolean.valueOf(z)), 1500L);
        this.f1119b = null;
    }
}
