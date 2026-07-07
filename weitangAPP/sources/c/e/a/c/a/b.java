package c.e.a.c.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1121a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f1122b = Pattern.compile(",");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f1123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Point f1124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Point f1125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1127g;

    public b(Context context) {
        this.f1123c = context;
    }

    public static Point a(CharSequence charSequence, Point point) {
        String[] strArrSplit = f1122b.split(charSequence);
        int length = strArrSplit.length;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String strTrim = strArrSplit[i3].trim();
            int iIndexOf = strTrim.indexOf(120);
            if (iIndexOf >= 0) {
                try {
                    int i6 = Integer.parseInt(strTrim.substring(0, iIndexOf));
                    int i7 = Integer.parseInt(strTrim.substring(iIndexOf + 1));
                    int iAbs = Math.abs(i6 - point.x) + Math.abs(i7 - point.y);
                    if (iAbs == 0) {
                        i5 = i7;
                        i4 = i6;
                        break;
                    }
                    if (iAbs < i2) {
                        i5 = i7;
                        i2 = iAbs;
                        i4 = i6;
                    }
                } catch (NumberFormatException unused) {
                    continue;
                }
            }
            i3++;
        }
        if (i4 <= 0 || i5 <= 0) {
            return null;
        }
        return new Point(i4, i5);
    }

    public static Point c(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point pointA = null;
        if (str != null) {
            Log.d(f1121a + ".getCameraResolution", "preview-size-values parameter: " + str);
            pointA = a(str, point);
        }
        return pointA == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : pointA;
    }

    public Point b() {
        return this.f1125e;
    }

    public int d() {
        return this.f1126f;
    }

    public String e() {
        return this.f1127g;
    }

    public Point f() {
        return this.f1124d;
    }

    public void g(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.f1126f = parameters.getPreviewFormat();
        this.f1127g = parameters.get("preview-format");
        Display defaultDisplay = ((WindowManager) this.f1123c.getSystemService("window")).getDefaultDisplay();
        this.f1124d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Point point = new Point();
        Point point2 = this.f1124d;
        point.x = point2.x;
        point.y = point2.y;
        int i2 = point2.x;
        int i3 = point2.y;
        if (i2 < i3) {
            point.x = i3;
            point.y = point2.x;
        }
        this.f1125e = c(parameters, point);
    }

    public void h(Camera camera) {
        i(camera, 90);
        Camera.Parameters parameters = camera.getParameters();
        Point point = this.f1125e;
        parameters.setPreviewSize(point.x, point.y);
        camera.setParameters(parameters);
    }

    public void i(Camera camera, int i2) {
        try {
            Method method = camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
                method.invoke(camera, Integer.valueOf(i2));
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }
}
