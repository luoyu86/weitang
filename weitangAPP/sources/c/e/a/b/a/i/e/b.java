package c.e.a.b.a.i.e;

import android.content.Context;
import android.hardware.Camera;
import c.e.a.b.a.i.e.a;

/* JADX INFO: loaded from: classes.dex */
public class b implements a.InterfaceC0022a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1117a;

    public b(Context context) {
        this.f1117a = context;
    }

    public final boolean a() {
        return this.f1117a.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public void getCameraInfo(int i2, a.b bVar) {
        bVar.f1115a = 0;
        bVar.f1116b = 90;
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public int getNumberOfCameras() {
        return a() ? 1 : 0;
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public boolean hasCamera(int i2) {
        if (i2 == 0) {
            return a();
        }
        return false;
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public Camera openCamera(int i2) {
        return Camera.open();
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public Camera openCameraFacing(int i2) {
        if (i2 == 0) {
            return Camera.open();
        }
        return null;
    }

    @Override // c.e.a.b.a.i.e.a.InterfaceC0022a
    public Camera openDefaultCamera() {
        return Camera.open();
    }
}
