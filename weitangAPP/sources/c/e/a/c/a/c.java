package c.e.a.c.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f1130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f1131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f1132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f1133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f1135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f1136i;
    public Camera j;
    public Rect k;
    public Rect l;
    public boolean m;
    public boolean n;
    public int o = 1;
    public Camera.Parameters p;

    static {
        int i2;
        try {
            i2 = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            i2 = 10000;
        }
        f1128a = i2;
        f1129b = c.class.getSimpleName();
        f1130c = 228;
    }

    public c(Context context) {
        this.f1132e = context;
        b bVar = new b(context);
        this.f1133f = bVar;
        f1130c = (int) (context.getResources().getDisplayMetrics().density * 114.0f);
        Log.d(f1129b + ".CameraManager", "MARGIN_TOP = " + f1130c);
        boolean z = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.f1134g = z;
        this.f1135h = new f(bVar, z);
        this.f1136i = new a();
    }

    public static int a(int i2, int i3, int i4) {
        int i5 = (i2 * 5) / 8;
        return i5 < i3 ? i3 : Math.min(i5, i4);
    }

    public static c get() {
        return f1131d;
    }

    public static void init(Context context) {
        if (f1131d == null) {
            f1131d = new c(context);
        }
    }

    public e buildLuminanceSource(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        String str = f1129b;
        sb.append(str);
        sb.append(".buildLuminanceSource");
        Log.d(sb.toString(), "width = " + i2);
        Log.d(str + ".buildLuminanceSource", "height = " + i3);
        Rect framingRectInPreview = getFramingRectInPreview();
        int iD = this.f1133f.d();
        String strE = this.f1133f.e();
        Log.d(str + ".buildLuminanceSource", "rect = " + framingRectInPreview);
        if (iD == 16 || iD == 17) {
            return new e(bArr, i2, i3, framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height());
        }
        if ("yuv420p".equals(strE)) {
            return new e(bArr, i2, i3, framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height());
        }
        throw new IllegalArgumentException("Unsupported picture format: " + iD + '/' + strE);
    }

    public void closeDriver() {
        if (this.j != null) {
            try {
                d.a();
                this.j.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.j = null;
        }
    }

    public synchronized Rect getFramingRect() {
        if (this.k == null) {
            if (this.j == null) {
                return null;
            }
            Point pointF = this.f1133f.f();
            if (pointF == null) {
                return null;
            }
            int iA = a(pointF.x, 240, 1200);
            int iA2 = a(pointF.y, 240, 675);
            int i2 = (pointF.x - iA) / 2;
            int i3 = (pointF.y - iA2) / 2;
            this.k = new Rect(i2, i3, iA + i2, iA2 + i3);
            Log.d(f1129b, "Calculated framing rect: " + this.k);
        }
        return this.k;
    }

    public Rect getFramingRectInPreview() {
        Rect rect = new Rect(getLocalFramingRect());
        Point pointB = this.f1133f.b();
        Point pointF = this.f1133f.f();
        int i2 = rect.left;
        int i3 = pointB.y;
        int i4 = pointF.x;
        rect.left = (i2 * i3) / i4;
        rect.right = (rect.right * i3) / i4;
        int i5 = rect.top;
        int i6 = pointB.x;
        int i7 = pointF.y;
        rect.top = (i5 * i6) / i7;
        rect.bottom = (rect.bottom * i6) / i7;
        this.l = rect;
        return rect;
    }

    public Rect getLocalFramingRect() {
        Point pointF = this.f1133f.f();
        if (this.j == null) {
            return null;
        }
        int i2 = pointF.x;
        int i3 = 540;
        int i4 = 1000;
        if (i2 < 320) {
            i3 = 160;
            i4 = 160;
        } else if (i2 >= 320 && i2 < 480) {
            i3 = 240;
            i4 = 240;
        } else if (i2 >= 480 && i2 < 640) {
            i3 = 320;
            i4 = 320;
        } else if (i2 >= 640 && i2 < 720) {
            i3 = 360;
            i4 = 360;
        } else if (i2 < 720 || i2 >= 1080) {
            if (i2 >= 1080) {
            }
            i3 = 1000;
        } else {
            i4 = 540;
        }
        int i5 = (i2 - i3) / 2;
        int i6 = f1130c;
        Rect rect = new Rect(i5, i6, i3 + i5, i4 + i6);
        this.k = rect;
        return rect;
    }

    public void offLight() {
        Camera camera = this.j;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            this.p = parameters;
            parameters.setFlashMode(PDPrintFieldAttributeObject.CHECKED_STATE_OFF);
            this.j.setParameters(this.p);
        }
    }

    public void openDriver(SurfaceHolder surfaceHolder) throws IOException {
        if (this.j == null) {
            Camera cameraOpen = Camera.open();
            this.j = cameraOpen;
            if (cameraOpen == null) {
                throw new IOException();
            }
            cameraOpen.setPreviewDisplay(surfaceHolder);
            if (!this.m) {
                this.m = true;
                this.f1133f.g(this.j);
            }
            this.f1133f.h(this.j);
        }
    }

    public void openLight() {
        Camera camera = this.j;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            this.p = parameters;
            parameters.setFlashMode("torch");
            this.j.setParameters(this.p);
        }
    }

    public void requestAutoFocus(Handler handler, int i2) {
        if (this.j == null || !this.n) {
            return;
        }
        this.f1136i.a(handler, i2);
        try {
            this.j.autoFocus(this.f1136i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void requestPreviewFrame(Handler handler, int i2) {
        if (this.j == null || !this.n) {
            return;
        }
        this.f1135h.a(handler, i2);
        if (this.f1134g) {
            this.j.setOneShotPreviewCallback(this.f1135h);
        } else {
            this.j.setPreviewCallback(this.f1135h);
        }
    }

    public void startPreview() {
        Camera camera = this.j;
        if (camera == null || this.n) {
            return;
        }
        camera.startPreview();
        this.n = true;
    }

    public void stopPreview() {
        Camera camera = this.j;
        if (camera == null || !this.n) {
            return;
        }
        if (!this.f1134g) {
            camera.setPreviewCallback(null);
        }
        this.j.stopPreview();
        this.f1135h.a(null, 0);
        this.f1136i.a(null, 0);
        this.n = false;
    }

    public Rect getFramingRect(int i2) {
        Point pointF = this.f1133f.f();
        if (this.j == null) {
            return null;
        }
        int i3 = pointF.x;
        int i4 = 540;
        int i5 = 360;
        if (i3 < 320) {
            if (1 == i2) {
                i4 = 160;
                i5 = 80;
            } else {
                i4 = 160;
                i5 = 160;
            }
        } else if (i3 < 320 || i3 >= 480) {
            if (i3 < 480 || i3 >= 640) {
                if (i3 < 640 || i3 >= 720) {
                    if (i3 >= 720 && i3 < 1080) {
                        i5 = 1 == i2 ? 270 : 540;
                    } else if (i3 < 1080 || i3 >= 1440) {
                        if (1 == i2) {
                            i4 = 1000;
                            i5 = 500;
                        } else {
                            i4 = 1000;
                            i5 = 1000;
                        }
                    } else if (1 == i2) {
                        i4 = 720;
                    } else {
                        i4 = 720;
                        i5 = 720;
                    }
                } else if (1 == i2) {
                    i4 = 360;
                    i5 = BaseTransientBottomBar.ANIMATION_FADE_DURATION;
                } else {
                    i4 = 360;
                }
            } else if (1 == i2) {
                i4 = 320;
                i5 = 160;
            } else {
                i4 = 320;
                i5 = 320;
            }
        } else if (1 == i2) {
            i4 = 240;
            i5 = 120;
        } else {
            i4 = 240;
            i5 = 240;
        }
        int i6 = (i3 - i4) / 2;
        int i7 = f1130c;
        this.k = new Rect(i6, i7, i4 + i6, i5 + i7);
        Log.d(f1129b + ".getFramingRect", "Calculated framing rect: " + this.k);
        return this.k;
    }
}
