package com.wildma.idcardcamera.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import c.r.a.a.b;
import c.r.a.a.d;
import c.r.a.d.e;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f12395a = CameraPreview.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Camera f12396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.r.a.a.a f12397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f12398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f12399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SurfaceHolder f12400f;

    public class a implements d.a {
        public a() {
        }

        @Override // c.r.a.a.d.a
        public void onFocus() {
            CameraPreview.this.focus();
        }
    }

    public CameraPreview(Context context) {
        super(context);
        b(context);
    }

    public final Camera.Size a(List<Camera.Size> list, int i2, int i3) {
        double d2 = ((double) i2) / ((double) i3);
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d2) <= 0.1d && Math.abs(size2.height - i3) < dAbs2) {
                dAbs2 = Math.abs(size2.height - i3);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i3) < dAbs) {
                    size = size3;
                    dAbs = Math.abs(size3.height - i3);
                }
            }
        }
        return size;
    }

    public void addCallback() {
        SurfaceHolder surfaceHolder = this.f12400f;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this);
        }
    }

    public final void b(Context context) {
        this.f12399e = context;
        SurfaceHolder holder = getHolder();
        this.f12400f = holder;
        holder.addCallback(this);
        this.f12400f.setKeepScreenOn(true);
        this.f12400f.setType(3);
        this.f12398d = d.getInstance(context.getApplicationContext());
    }

    public final void c() {
        Camera camera = this.f12396b;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.f12396b.stopPreview();
            this.f12396b.release();
            this.f12396b = null;
            c.r.a.a.a aVar = this.f12397c;
            if (aVar != null) {
                aVar.c();
                this.f12397c = null;
            }
        }
    }

    public void focus() {
        Camera camera = this.f12396b;
        if (camera != null) {
            try {
                camera.autoFocus(null);
            } catch (Exception e2) {
                Log.d(f12395a, "takePhoto " + e2);
            }
        }
    }

    public void onStart() {
        addCallback();
        d dVar = this.f12398d;
        if (dVar != null) {
            dVar.onStart();
            this.f12398d.setCameraFocusListener(new a());
        }
    }

    public void onStop() {
        d dVar = this.f12398d;
        if (dVar != null) {
            dVar.onStop();
        }
    }

    public void startPreview() {
        Camera camera = this.f12396b;
        if (camera != null) {
            camera.startPreview();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Camera cameraOpenCamera = b.openCamera();
        this.f12396b = cameraOpenCamera;
        if (cameraOpenCamera != null) {
            try {
                cameraOpenCamera.setPreviewDisplay(surfaceHolder);
                Camera.Parameters parameters = this.f12396b.getParameters();
                if (getResources().getConfiguration().orientation == 1) {
                    this.f12396b.setDisplayOrientation(90);
                    parameters.setRotation(90);
                } else {
                    this.f12396b.setDisplayOrientation(0);
                    parameters.setRotation(0);
                }
                Camera.Size sizeA = a(parameters.getSupportedPreviewSizes(), e.getScreenWidth(this.f12399e), e.getScreenHeight(this.f12399e));
                parameters.setPreviewSize(sizeA.width, sizeA.height);
                this.f12396b.setParameters(parameters);
                this.f12396b.startPreview();
                focus();
            } catch (Exception e2) {
                Log.d(f12395a, "Error setting camera preview: " + e2.getMessage());
                try {
                    Camera.Parameters parameters2 = this.f12396b.getParameters();
                    if (getResources().getConfiguration().orientation == 1) {
                        this.f12396b.setDisplayOrientation(90);
                        parameters2.setRotation(90);
                    } else {
                        this.f12396b.setDisplayOrientation(0);
                        parameters2.setRotation(0);
                    }
                    this.f12396b.setParameters(parameters2);
                    this.f12396b.startPreview();
                    focus();
                } catch (Exception unused) {
                    e2.printStackTrace();
                    this.f12396b = null;
                }
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        surfaceHolder.removeCallback(this);
        c();
    }

    public boolean switchFlashLight() {
        Camera camera = this.f12396b;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode().equals(PDPrintFieldAttributeObject.CHECKED_STATE_OFF)) {
                parameters.setFlashMode("torch");
                this.f12396b.setParameters(parameters);
                return true;
            }
            parameters.setFlashMode(PDPrintFieldAttributeObject.CHECKED_STATE_OFF);
            this.f12396b.setParameters(parameters);
        }
        return false;
    }

    public void takePhoto(Camera.PictureCallback pictureCallback) {
        Camera camera = this.f12396b;
        if (camera != null) {
            try {
                camera.takePicture(null, null, pictureCallback);
            } catch (Exception e2) {
                Log.d(f12395a, "takePhoto " + e2);
            }
        }
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context);
    }

    @TargetApi(21)
    public CameraPreview(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        b(context);
    }
}
