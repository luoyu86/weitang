package c.j.a;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import anet.channel.strategy.dispatch.DispatchConstants;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f2707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2708h;

    public a(Activity activity) {
        this.f2706f = activity.getResources().getConfiguration().orientation == 1;
        this.f2707g = h(activity);
        this.f2701a = c(activity, "status_bar_height");
        this.f2702b = b(activity);
        int iE = e(activity);
        this.f2704d = iE;
        this.f2705e = g(activity);
        this.f2703c = iE > 0;
        this.f2708h = l.hasNotchScreen(activity);
    }

    public int a() {
        return this.f2702b;
    }

    @TargetApi(14)
    public final int b(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    public final int c(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", DispatchConstants.ANDROID);
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                return Math.round((dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    public int d() {
        return this.f2704d;
    }

    @TargetApi(14)
    public final int e(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !j((Activity) context)) {
            return 0;
        }
        return c(context, this.f2706f ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    public int f() {
        return this.f2705e;
    }

    @TargetApi(14)
    public final int g(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !j((Activity) context)) {
            return 0;
        }
        return c(context, "navigation_bar_width");
    }

    @SuppressLint({"NewApi"})
    public final float h(Activity activity) {
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

    public int i() {
        return this.f2701a;
    }

    @TargetApi(14)
    public final boolean j(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            if (Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                return false;
            }
            if (m.isEMUI()) {
                if (m.isEMUI3_x() || i2 < 21) {
                    if (Settings.System.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                        return false;
                    }
                } else if (Settings.Global.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                    return false;
                }
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (i2 >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i3 = displayMetrics.heightPixels;
        int i4 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i4 - displayMetrics2.widthPixels > 0 || i3 - displayMetrics2.heightPixels > 0;
    }

    public boolean k() {
        return this.f2703c;
    }

    public boolean l() {
        return this.f2708h;
    }

    public boolean m() {
        return this.f2707g >= 600.0f || this.f2706f;
    }
}
