package c.e.a.b.a.f;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import anet.channel.entity.ConnType;
import c.e.a.d.q;
import com.tom_roush.fontbox.ttf.OS2WindowsMetricsTable;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1077a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f1078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f1079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SurfaceView f1080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextureView f1081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.e.a.b.a.i.e.a f1082f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1085i;
    public int j;
    public int k;
    public float l;
    public String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1086q;
    public boolean r;
    public c.e.a.b.a.f.a s;
    public c.e.a.b.a.f.c t;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Camera.Parameters f1083g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Camera f1084h = null;
    public int m = 1;
    public Camera.Size n = null;
    public Camera.Size o = null;
    public int u = 0;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            b.this.f1079c.getViewTreeObserver().removeOnPreDrawListener(this);
            b bVar = b.this;
            bVar.f1085i = bVar.f1079c.getWidth();
            b bVar2 = b.this;
            bVar2.j = bVar2.f1079c.getHeight();
            return false;
        }
    }

    /* JADX INFO: renamed from: c.e.a.b.a.f.b$b, reason: collision with other inner class name */
    public class TextureViewSurfaceTextureListenerC0020b implements TextureView.SurfaceTextureListener {
        public TextureViewSurfaceTextureListenerC0020b() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            if (b.this.f1084h == null) {
                try {
                    b bVar = b.this;
                    bVar.f1084h = bVar.x(bVar.m);
                    b.this.f1084h.setPreviewTexture(surfaceTexture);
                    b.this.z();
                    b.this.f1084h.startPreview();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            try {
                if (b.this.f1084h == null) {
                    return true;
                }
                b.this.f1084h.stopPreview();
                b.this.f1084h.release();
                b.this.f1084h = null;
                return true;
            } catch (Exception unused) {
                return true;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            b.this.s();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.s();
        }
    }

    public class c implements SurfaceHolder.Callback {
        public c() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            b.this.s();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (b.this.f1084h == null) {
                try {
                    b bVar = b.this;
                    bVar.f1084h = bVar.x(bVar.m);
                    b.this.f1084h.setPreviewDisplay(surfaceHolder);
                    b.this.z();
                    b.this.f1084h.startPreview();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            try {
                if (b.this.f1084h != null) {
                    b.this.f1084h.stopPreview();
                    b.this.f1084h.release();
                    b.this.f1084h = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                b.this.k = 1;
                b.this.f1086q = false;
            } else if (action == 1) {
                b.this.t(motionEvent.getX(), motionEvent.getY());
            } else if (action != 2) {
                if (action == 5) {
                    b bVar = b.this;
                    bVar.l = bVar.H(motionEvent);
                    if (b.this.H(motionEvent) > 10.0f) {
                        b.this.k = 2;
                    }
                } else if (action == 6) {
                    b.this.k = 1;
                }
            } else if (b.this.k == 2) {
                b.this.f1086q = true;
                b.this.u(motionEvent);
            }
            return true;
        }
    }

    public class e implements Comparator<Camera.Size> {
        public e() {
        }

        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            int i2 = size.height * size.width;
            int i3 = size2.height * size2.width;
            if (i3 < i2) {
                return -1;
            }
            return i3 > i2 ? 1 : 0;
        }
    }

    public class f implements Comparator<Camera.Size> {
        public f() {
        }

        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            int i2 = size.height * size.width;
            int i3 = size2.height * size2.width;
            if (i3 < i2) {
                return -1;
            }
            return i3 > i2 ? 1 : 0;
        }
    }

    public class g extends Thread {

        public class a implements Camera.AutoFocusCallback {
            public a() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
            }
        }

        public g() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (b.this.f1084h == null) {
                return;
            }
            b.this.f1084h.autoFocus(new a());
        }
    }

    public class h implements Camera.PictureCallback {
        public h() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (b.this.t != null) {
                b.this.t.onTake(bArr);
                camera.stopPreview();
            }
        }
    }

    public b(Activity activity, ViewGroup viewGroup) {
        this.f1078b = activity;
        this.f1079c = viewGroup;
    }

    public final void A(int i2, int i3) {
        this.f1084h.cancelAutoFocus();
        this.f1083g = this.f1084h.getParameters();
        if (Build.VERSION.SDK_INT >= 14) {
            G(i2, i3);
        }
        this.f1084h.setParameters(this.f1083g);
        s();
    }

    public final void B() {
        Camera camera = this.f1084h;
        if (camera != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    camera.setPreviewTexture(null);
                } catch (Exception unused) {
                }
            }
            this.f1084h.setPreviewCallback(null);
            this.f1084h.release();
            this.f1084h = null;
        }
        this.n = null;
        this.o = null;
    }

    public final void C(Camera camera) {
        if (camera == null || camera.getParameters() == null || camera.getParameters().getSupportedFlashModes() == null) {
            c.e.a.b.a.f.a aVar = this.s;
            if (aVar != null) {
                aVar.onFlashLigChange(false, this.p);
                return;
            }
            return;
        }
        c.e.a.b.a.f.a aVar2 = this.s;
        if (aVar2 != null) {
            aVar2.onFlashLigChange(true, this.p);
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(this.p);
        camera.setParameters(parameters);
    }

    public final void D(int i2) {
        Camera cameraX = x(i2);
        this.f1084h = cameraX;
        if (cameraX != null) {
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    cameraX.setPreviewTexture(this.f1081e.getSurfaceTexture());
                } else if (this.f1081e != null) {
                    cameraX.setPreviewDisplay(this.f1080d.getHolder());
                }
                z();
                this.f1084h.startPreview();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void E() {
        if (this.n != null) {
            return;
        }
        this.n = v();
        q.v(f1077a, "setUpPicSize Camera Size width: " + this.n.width + ",height:" + this.n.height);
    }

    public final void F() {
        if (this.o != null) {
            return;
        }
        this.o = w();
        q.v(f1077a, "setUpPreviewSize Camera Size width: " + this.o.width + ",height:" + this.o.height);
    }

    @TargetApi(14)
    public final void G(int i2, int i3) {
        if (this.f1083g.getMaxNumMeteringAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            int i4 = (((-i2) * 2000) / this.f1085i) + 1000;
            int i5 = ((i3 * 2000) / this.j) - 1000;
            arrayList.add(new Camera.Area(new Rect(i5 < -900 ? -1000 : i5 - 100, i4 >= -900 ? i4 - 100 : -1000, i5 > 900 ? 1000 : i5 + 100, i4 <= 900 ? i4 + 100 : 1000), OS2WindowsMetricsTable.WEIGHT_CLASS_EXTRA_BOLD));
            this.f1083g.setMeteringAreas(arrayList);
        }
        this.f1083g.setFocusMode("continuous-picture");
    }

    public final float H(MotionEvent motionEvent) {
        if (motionEvent == null && motionEvent.getPointerCount() > 1) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public final void I(Camera camera) {
        if (camera == null || camera.getParameters() == null || camera.getParameters().getSupportedFlashModes() == null) {
            return;
        }
        String flashMode = camera.getParameters().getFlashMode();
        List<String> supportedFlashModes = camera.getParameters().getSupportedFlashModes();
        if (PDPrintFieldAttributeObject.CHECKED_STATE_OFF.equals(flashMode) && supportedFlashModes.contains("torch")) {
            this.p = "torch";
        } else if ("torch".equals(flashMode)) {
            if (supportedFlashModes.contains(ConnType.PK_AUTO)) {
                this.p = ConnType.PK_AUTO;
            } else if (supportedFlashModes.contains(PDPrintFieldAttributeObject.CHECKED_STATE_OFF)) {
                this.p = PDPrintFieldAttributeObject.CHECKED_STATE_OFF;
            }
        } else if (ConnType.PK_AUTO.equals(flashMode) && supportedFlashModes.contains(PDPrintFieldAttributeObject.CHECKED_STATE_OFF)) {
            this.p = PDPrintFieldAttributeObject.CHECKED_STATE_OFF;
        }
        C(camera);
    }

    public void create() {
        c.e.a.b.a.i.e.a aVar = new c.e.a.b.a.i.e.a(this.f1078b);
        this.f1082f = aVar;
        try {
            this.r = aVar.hasFrontCamera() && this.f1082f.hasBackCamera();
        } catch (Exception unused) {
        }
        c.e.a.b.a.f.a aVar2 = this.s;
        if (aVar2 != null) {
            aVar2.onCameraChange(this.r, this.m);
        }
        y();
    }

    public void destory() {
        B();
    }

    public Camera.Size getAdapterSize() {
        return this.n;
    }

    public Camera.Size getPreviewSize() {
        return this.o;
    }

    public int getisplayOrientation() {
        return this.f1082f.getCameraDisplayOrientation(this.f1078b, this.m) % 360;
    }

    public final void r(int i2) {
        try {
            Camera.Parameters parameters = this.f1084h.getParameters();
            if (parameters.isZoomSupported()) {
                int i3 = this.u + i2;
                this.u = i3;
                if (i3 < 0) {
                    this.u = 0;
                } else if (i3 > parameters.getMaxZoom()) {
                    this.u = parameters.getMaxZoom();
                }
                if (parameters.isSmoothZoomSupported()) {
                    this.f1084h.startSmoothZoom(this.u);
                } else {
                    parameters.setZoom(this.u);
                    this.f1084h.setParameters(parameters);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void reset() {
        try {
            this.f1084h.startPreview();
        } catch (Exception unused) {
        }
    }

    public final void s() {
        new g();
    }

    public void setCameraListener(c.e.a.b.a.f.a aVar) {
        this.s = aVar;
    }

    public void setTakePictureCallback(c.e.a.b.a.f.c cVar) {
        this.t = cVar;
    }

    public void switchCamera() {
        this.m = (this.m + 1) % this.f1082f.getNumberOfCameras();
        B();
        D(this.m);
        C(this.f1084h);
        C(this.f1084h);
        c.e.a.b.a.f.a aVar = this.s;
        if (aVar != null) {
            aVar.onCameraChange(this.r, this.m);
        }
    }

    public final void t(float f2, float f3) {
        if (this.k == 2 || this.f1086q) {
            return;
        }
        try {
            A((int) f2, (int) f3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c.e.a.b.a.f.a aVar = this.s;
        if (aVar != null) {
            aVar.onFocusIndex(f2, f3);
        }
    }

    public void takePicture() {
        c.e.a.b.a.f.c cVar = this.t;
        if (cVar != null) {
            cVar.prepareTake();
        }
        if (Build.VERSION.SDK_INT < 14) {
            try {
                this.f1084h.takePicture(null, null, new h());
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                Toast.makeText(this.f1078b, "拍照失败，请重试！", 0).show();
                try {
                    this.f1084h.startPreview();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
        }
        Bitmap bitmap = this.f1081e.getBitmap();
        c.e.a.b.a.f.c cVar2 = this.t;
        if (cVar2 != null) {
            cVar2.onTake(bitmap);
            Camera camera = this.f1084h;
            if (camera != null) {
                camera.stopPreview();
            }
        }
    }

    public void turnLight() {
        I(this.f1084h);
    }

    public final void u(MotionEvent motionEvent) {
        float fH = H(motionEvent);
        if (fH > 10.0f) {
            float f2 = this.l;
            float f3 = (fH - f2) / f2;
            if (f3 < 0.0f) {
                f3 *= 10.0f;
            }
            r((int) f3);
        }
    }

    public final Camera.Size v() {
        Camera.Parameters parameters = this.f1084h.getParameters();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        StringBuilder sb = new StringBuilder();
        for (Camera.Size size : supportedPictureSizes) {
            sb.append(size.width);
            sb.append('x');
            sb.append(size.height);
            sb.append(" ");
        }
        String str = f1077a;
        Log.d(str, "Supported picture resolutions: " + ((Object) sb));
        Camera.Size pictureSize = parameters.getPictureSize();
        Log.d(str, "default picture resolution " + pictureSize.width + "x" + pictureSize.height);
        ArrayList arrayList = new ArrayList(supportedPictureSizes);
        Collections.sort(arrayList, new f());
        double d2 = ((double) this.f1085i) / ((double) this.j);
        q.d(str, "findBestPictureResolution screenWidth:" + this.f1085i + ", screenHeight:" + this.j + ",screenAspectRatio:" + d2);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size size2 = (Camera.Size) it.next();
            int i2 = size2.width;
            int i3 = size2.height;
            boolean z = i2 > i3;
            int i4 = z ? i3 : i2;
            if (!z) {
                i2 = i3;
            }
            if (Math.abs((((double) i4) / ((double) i2)) - d2) > 0.15d) {
                it.remove();
            }
        }
        return !arrayList.isEmpty() ? (Camera.Size) arrayList.get(0) : pictureSize;
    }

    public final Camera.Size w() {
        Camera.Parameters parameters = this.f1084h.getParameters();
        Camera.Size previewSize = parameters.getPreviewSize();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            return previewSize;
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new e());
        StringBuilder sb = new StringBuilder();
        for (Camera.Size size : arrayList) {
            sb.append(size.width);
            sb.append('x');
            sb.append(size.height);
            sb.append(' ');
        }
        q.v(f1077a, "Supported preview resolutions: " + ((Object) sb));
        double d2 = ((double) this.f1085i) / ((double) this.j);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                return !arrayList.isEmpty() ? (Camera.Size) arrayList.get(0) : previewSize;
            }
            Camera.Size size2 = (Camera.Size) it.next();
            int i2 = size2.width;
            int i3 = size2.height;
            q.v(f1077a, "Supported Camera Size width: " + i2 + ",height:" + i3 + ",ro:" + (i3 / i2));
            if (i2 * i3 < 153600) {
                it.remove();
            } else {
                boolean z = i2 > i3;
                int i4 = z ? i3 : i2;
                if (!z) {
                    i2 = i3;
                }
                if (Math.abs((((double) i4) / ((double) i2)) - d2) > 0.15d) {
                    it.remove();
                } else if (i4 == this.f1085i && i2 == this.j) {
                    return size2;
                }
            }
        }
    }

    public final Camera x(int i2) {
        try {
            return this.f1082f.openCamera(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void y() {
        this.f1079c.getViewTreeObserver().addOnPreDrawListener(new a());
        if (Build.VERSION.SDK_INT >= 14) {
            TextureView textureView = new TextureView(this.f1078b);
            this.f1081e = textureView;
            textureView.setSurfaceTextureListener(new TextureViewSurfaceTextureListenerC0020b());
            this.f1079c.addView(this.f1081e);
        } else {
            SurfaceView surfaceView = new SurfaceView(this.f1078b);
            this.f1080d = surfaceView;
            SurfaceHolder holder = surfaceView.getHolder();
            holder.setType(3);
            holder.setKeepScreenOn(true);
            this.f1080d.getHolder().addCallback(new c());
            this.f1079c.addView(this.f1080d);
        }
        this.f1079c.setOnTouchListener(new d());
    }

    public final void z() {
        this.f1083g = this.f1084h.getParameters();
        if (TextUtils.isEmpty(this.p) && this.f1083g.getSupportedFlashModes() != null) {
            this.p = ConnType.PK_AUTO;
            C(this.f1084h);
        }
        this.f1083g.setPictureFormat(256);
        E();
        F();
        Camera.Size size = this.n;
        if (size != null) {
            this.f1083g.setPictureSize(size.width, size.height);
        }
        Camera.Size size2 = this.o;
        if (size2 != null) {
            this.f1083g.setPreviewSize(size2.width, size2.height);
        }
        this.f1083g.setJpegQuality(50);
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1083g.setFocusMode("continuous-picture");
        } else {
            this.f1083g.setFocusMode(ConnType.PK_AUTO);
        }
        this.f1084h.setDisplayOrientation(90);
        try {
            this.f1084h.setParameters(this.f1083g);
        } catch (Exception e2) {
            Log.i(c.e.b.c.d.d.SOURCE_TYPE_CAMERA, "set params ! ", e2);
        }
        this.f1084h.startPreview();
        this.f1084h.cancelAutoFocus();
    }
}
