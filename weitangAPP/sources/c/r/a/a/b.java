package c.r.a.a;

import android.content.Context;
import android.hardware.Camera;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Camera f3141a;

    public static Camera getCamera() {
        return f3141a;
    }

    public static boolean hasCamera(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public static boolean hasFlash(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public static Camera openCamera() {
        f3141a = null;
        try {
            f3141a = Camera.open();
        } catch (Exception unused) {
        }
        return f3141a;
    }
}
