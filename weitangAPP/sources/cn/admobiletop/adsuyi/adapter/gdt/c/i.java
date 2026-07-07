package cn.admobiletop.adsuyi.adapter.gdt.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import com.qq.e.ads.splash.SplashAD;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SplashAD f3708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f3709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f3710i;
    public int j;
    public int k;

    public interface a {
        void a();

        void a(int i2);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static i f3711a = new i(null);
    }

    public /* synthetic */ i(h hVar) {
        this();
    }

    public i() {
        this.f3710i = new int[2];
        Context applicationContext = ADSuyiSdk.getInstance().getContext().getApplicationContext();
        this.f3702a = Math.round(Math.min(cn.admobiletop.adsuyi.adapter.gdt.e.c.a(applicationContext), cn.admobiletop.adsuyi.adapter.gdt.e.c.b(applicationContext)) * 0.3f);
        this.f3703b = Math.round((r1 * 16) / 9);
        this.f3704c = cn.admobiletop.adsuyi.adapter.gdt.e.c.a(applicationContext, 6);
        this.f3705d = cn.admobiletop.adsuyi.adapter.gdt.e.c.a(applicationContext, 100);
        this.f3706e = 1;
        this.f3707f = 300;
    }

    public static i b() {
        return b.f3711a;
    }

    public void a() {
        this.f3708g = null;
        this.f3709h = null;
    }

    public ViewGroup a(View view, ViewGroup viewGroup, ViewGroup viewGroup2, a aVar) {
        a();
        if (view == null || viewGroup2 == null) {
            return null;
        }
        Context context = viewGroup2.getContext();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        int width2 = viewGroup.getWidth();
        int height2 = viewGroup.getHeight();
        if (width2 == 0) {
            width2 = this.j;
        }
        if (height2 == 0) {
            height2 = this.k;
        }
        float f2 = this.f3702a / width;
        int i2 = this.f3703b;
        float f3 = i2 / height;
        float f4 = this.f3706e == 0 ? this.f3704c : (width2 - this.f3704c) - r7;
        float f5 = (height2 - this.f3705d) - i2;
        Log.d("SplashZoomOutManager", "zoomOut animationContainerWidth:" + width2 + " animationContainerHeight:" + height2);
        Log.d("SplashZoomOutManager", "zoomOut splashScreenX:" + iArr[0] + " splashScreenY:" + iArr[1]);
        Log.d("SplashZoomOutManager", "zoomOut splashWidth:" + width + " splashHeight:" + height);
        Log.d("SplashZoomOutManager", "zoomOut width:" + this.f3702a + " height:" + this.f3703b);
        Log.d("SplashZoomOutManager", "zoomOut animationDistX:" + f4 + " animationDistY:" + f5);
        cn.admobiletop.adsuyi.adapter.gdt.e.f.a(view);
        viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
        g gVar = new g(context, this.f3704c);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.animate().scaleX(f2).scaleY(f3).x(f4).y(f5).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(this.f3707f).setListener(new h(this, aVar, view, viewGroup2, f4, iArr, f5, gVar));
        return gVar;
    }
}
