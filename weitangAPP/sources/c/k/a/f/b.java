package c.k.a.f;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0042b f2809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f2814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f2815h;

    /* JADX INFO: renamed from: c.k.a.f.b$b, reason: collision with other inner class name */
    public static class C0042b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2819d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f2820e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f2821f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f2822g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f2823h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f2824i;

        @TargetApi(14)
        public final int a(Context context) {
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        public final int b(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", DispatchConstants.ANDROID);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        public final int c(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !f(context)) {
                return 0;
            }
            return b(resources, this.f2823h ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        @TargetApi(14)
        public final int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !f(context)) {
                return 0;
            }
            return b(resources, "navigation_bar_width");
        }

        @SuppressLint({"NewApi"})
        public final float e(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f2 = displayMetrics.widthPixels;
            float f3 = displayMetrics.density;
            return Math.min(f2 / f3, displayMetrics.heightPixels / f3);
        }

        @TargetApi(14)
        public final boolean f(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", DispatchConstants.ANDROID);
            if (identifier == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(b.f2808a)) {
                return false;
            }
            if ("0".equals(b.f2808a)) {
                return true;
            }
            return z;
        }

        public int getActionBarHeight() {
            return this.f2819d;
        }

        public int getNavigationBarHeight() {
            return this.f2821f;
        }

        public int getNavigationBarWidth() {
            return this.f2822g;
        }

        public int getPixelInsetBottom() {
            if (this.f2817b && isNavigationAtBottom()) {
                return this.f2821f;
            }
            return 0;
        }

        public int getPixelInsetRight() {
            if (!this.f2817b || isNavigationAtBottom()) {
                return 0;
            }
            return this.f2822g;
        }

        public int getPixelInsetTop(boolean z) {
            return (this.f2816a ? this.f2818c : 0) + (z ? this.f2819d : 0);
        }

        public int getStatusBarHeight() {
            return this.f2818c;
        }

        public boolean hasNavigtionBar() {
            return this.f2820e;
        }

        public boolean isNavigationAtBottom() {
            return this.f2824i >= 600.0f || this.f2823h;
        }

        public C0042b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f2823h = resources.getConfiguration().orientation == 1;
            this.f2824i = e(activity);
            this.f2818c = b(resources, "status_bar_height");
            this.f2819d = a(activity);
            int iC = c(activity);
            this.f2821f = iC;
            this.f2822g = d(activity);
            this.f2820e = iC > 0;
            this.f2816a = z;
            this.f2817b = z2;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f2808a = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f2808a = null;
            }
        }
    }

    @TargetApi(19)
    public b(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(new int[]{R.attr.windowTranslucentStatus, R.attr.windowTranslucentNavigation});
            try {
                this.f2810c = typedArrayObtainStyledAttributes.getBoolean(0, false);
                this.f2811d = typedArrayObtainStyledAttributes.getBoolean(1, false);
                typedArrayObtainStyledAttributes.recycle();
                int i2 = window.getAttributes().flags;
                if ((67108864 & i2) != 0) {
                    this.f2810c = true;
                }
                if ((i2 & 134217728) != 0) {
                    this.f2811d = true;
                }
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        C0042b c0042b = new C0042b(activity, this.f2810c, this.f2811d);
        this.f2809b = c0042b;
        if (!c0042b.hasNavigtionBar()) {
            this.f2811d = false;
        }
        if (this.f2810c) {
            c(activity, viewGroup);
        }
        if (this.f2811d) {
            b(activity, viewGroup);
        }
    }

    public final void b(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f2815h = new View(context);
        if (this.f2809b.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f2809b.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f2809b.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.f2815h.setLayoutParams(layoutParams);
        this.f2815h.setBackgroundColor(-1728053248);
        this.f2815h.setVisibility(8);
        viewGroup.addView(this.f2815h);
    }

    public final void c(Context context, ViewGroup viewGroup) {
        this.f2814g = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f2809b.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.f2811d && !this.f2809b.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.f2809b.getNavigationBarWidth();
        }
        this.f2814g.setLayoutParams(layoutParams);
        this.f2814g.setBackgroundColor(-1728053248);
        this.f2814g.setVisibility(8);
        viewGroup.addView(this.f2814g);
    }

    public C0042b getConfig() {
        return this.f2809b;
    }

    public boolean isNavBarTintEnabled() {
        return this.f2813f;
    }

    public boolean isStatusBarTintEnabled() {
        return this.f2812e;
    }

    @TargetApi(11)
    public void setNavigationBarAlpha(float f2) {
        if (!this.f2811d || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.f2815h.setAlpha(f2);
    }

    public void setNavigationBarTintColor(int i2) {
        if (this.f2811d) {
            this.f2815h.setBackgroundColor(i2);
        }
    }

    public void setNavigationBarTintDrawable(Drawable drawable) {
        if (this.f2811d) {
            this.f2815h.setBackgroundDrawable(drawable);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        this.f2813f = z;
        if (this.f2811d) {
            this.f2815h.setVisibility(z ? 0 : 8);
        }
    }

    public void setNavigationBarTintResource(int i2) {
        if (this.f2811d) {
            this.f2815h.setBackgroundResource(i2);
        }
    }

    @TargetApi(11)
    public void setStatusBarAlpha(float f2) {
        if (!this.f2810c || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.f2814g.setAlpha(f2);
    }

    public void setStatusBarTintColor(int i2) {
        if (this.f2810c) {
            this.f2814g.setBackgroundColor(i2);
        }
    }

    public void setStatusBarTintDrawable(Drawable drawable) {
        if (this.f2810c) {
            this.f2814g.setBackgroundDrawable(drawable);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.f2812e = z;
        if (this.f2810c) {
            this.f2814g.setVisibility(z ? 0 : 8);
        }
    }

    public void setStatusBarTintResource(int i2) {
        if (this.f2810c) {
            this.f2814g.setBackgroundResource(i2);
        }
    }

    public void setTintAlpha(float f2) {
        setStatusBarAlpha(f2);
        setNavigationBarAlpha(f2);
    }

    public void setTintColor(int i2) {
        setStatusBarTintColor(i2);
        setNavigationBarTintColor(i2);
    }

    public void setTintDrawable(Drawable drawable) {
        setStatusBarTintDrawable(drawable);
        setNavigationBarTintDrawable(drawable);
    }

    public void setTintResource(int i2) {
        setStatusBarTintResource(i2);
        setNavigationBarTintResource(i2);
    }
}
