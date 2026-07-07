package c.e.a.b.a.i.e;

import android.annotation.TargetApi;
import android.hardware.Camera;
import c.e.a.b.a.i.e.a;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(9)
public class c implements a.InterfaceC0022a {
    public final int a(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == i2) {
                return i3;
            }
        }
        return -1;
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public void getCameraInfo(int i2, a.b bVar) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        bVar.f1115a = cameraInfo.facing;
        bVar.f1116b = cameraInfo.orientation;
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public int getNumberOfCameras() {
        return Camera.getNumberOfCameras();
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public boolean hasCamera(int i2) {
        return a(i2) != -1;
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public Camera openCamera(int i2) {
        return Camera.open(i2);
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public Camera openCameraFacing(int i2) {
        return Camera.open(a(i2));
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public Camera openDefaultCamera() {
        return Camera.open(0);
    }
}
