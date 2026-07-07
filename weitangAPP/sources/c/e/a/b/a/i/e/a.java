package c.e.a.b.a.i.e;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0022a f1114a;

    /* JADX INFO: renamed from: c.e.a.b.a.i.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0022a {
        void getCameraInfo(int i2, b bVar);

        int getNumberOfCameras();

        boolean hasCamera(int i2);

        Camera openCamera(int i2);

        Camera openCameraFacing(int i2);

        Camera openDefaultCamera();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1116b;
    }

    public a(Context context) {
        if (Build.VERSION.SDK_INT >= 9) {
            this.f1114a = new c();
        } else {
            this.f1114a = new c.e.a.b.a.i.e.b(context);
        }
    }

    public int getCameraDisplayOrientation(Activity activity, int i2) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = BaseTransientBottomBar.ANIMATION_FADE_DURATION;
            } else if (rotation == 3) {
                i3 = 270;
            }
        }
        b bVar = new b();
        getCameraInfo(i2, bVar);
        return bVar.f1115a == 1 ? (bVar.f1116b + i3) % 360 : ((bVar.f1116b - i3) + 360) % 360;
    }

    public void getCameraInfo(int i2, b bVar) {
        this.f1114a.getCameraInfo(i2, bVar);
    }

    public int getNumberOfCameras() {
        return this.f1114a.getNumberOfCameras();
    }

    public boolean hasBackCamera() {
        return this.f1114a.hasCamera(0);
    }

    public boolean hasFrontCamera() {
        return this.f1114a.hasCamera(1);
    }

    public Camera openBackCamera() {
        return this.f1114a.openCameraFacing(0);
    }

    public Camera openCamera(int i2) {
        return this.f1114a.openCamera(i2);
    }

    public Camera openDefaultCamera() {
        return this.f1114a.openDefaultCamera();
    }

    public Camera openFrontCamera() {
        return this.f1114a.openCameraFacing(1);
    }

    public void setCameraDisplayOrientation(Activity activity, int i2, Camera camera) {
        camera.setDisplayOrientation(getCameraDisplayOrientation(activity, i2));
    }
}
