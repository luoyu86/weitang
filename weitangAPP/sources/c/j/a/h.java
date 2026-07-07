package c.j.a;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f2739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Fragment f2740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public android.app.Fragment f2741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Dialog f2742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Window f2743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f2744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f2745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f2746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c.j.a.a f2747i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public f o;
    public Map<String, c> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2748q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f2749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f2751c;

        public a(ViewGroup.LayoutParams layoutParams, View view, Activity activity) {
            this.f2749a = layoutParams;
            this.f2750b = view;
            this.f2751c = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2749a.height = this.f2750b.getHeight() + h.getStatusBarHeight(this.f2751c);
            View view = this.f2750b;
            view.setPadding(view.getPaddingLeft(), this.f2750b.getPaddingTop() + h.getStatusBarHeight(this.f2751c), this.f2750b.getPaddingRight(), this.f2750b.getPaddingBottom());
            this.f2750b.setLayoutParams(this.f2749a);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2752a;

        static {
            int[] iArr = new int[c.j.a.b.values().length];
            f2752a = iArr;
            try {
                iArr[c.j.a.b.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2752a[c.j.a.b.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2752a[c.j.a.b.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2752a[c.j.a.b.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public h(Activity activity) {
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = new HashMap();
        this.f2748q = false;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.l = true;
        this.f2739a = activity;
        t(activity.getWindow());
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void destroy(@NonNull Activity activity, @NonNull Dialog dialog) {
        p().destroy(activity, dialog);
    }

    @TargetApi(14)
    public static int getActionBarHeight(@NonNull Activity activity) {
        return new c.j.a.a(activity).a();
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(@NonNull Activity activity) {
        return new c.j.a.a(activity).d();
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(@NonNull Activity activity) {
        return new c.j.a.a(activity).f();
    }

    @TargetApi(14)
    public static int getStatusBarHeight(@NonNull Activity activity) {
        return new c.j.a.a(activity).i();
    }

    @TargetApi(14)
    public static boolean hasNavigationBar(@NonNull Activity activity) {
        return new c.j.a.a(activity).k();
    }

    public static boolean hasNotchScreen(@NonNull Activity activity) {
        return new c.j.a.a(activity).l();
    }

    public static void hideStatusBar(@NonNull Window window) {
        window.setFlags(1024, 1024);
    }

    @TargetApi(14)
    public static boolean isNavigationAtBottom(@NonNull Activity activity) {
        return new c.j.a.a(activity).m();
    }

    public static boolean isSupportNavigationIconDark() {
        return m.isMIUI6Later() || Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportStatusBarDarkFont() {
        return m.isMIUI6Later() || m.isFlymeOS4Later() || Build.VERSION.SDK_INT >= 23;
    }

    public static p p() {
        return p.d();
    }

    public static void setFitsSystemWindows(Activity activity) {
        if (activity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof ViewGroup) && !(childAt instanceof DrawerLayout)) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static void setStatusBarView(Activity activity, View view) {
        if (activity == null || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, 0);
        }
        layoutParams.height = getStatusBarHeight(activity);
        view.setLayoutParams(layoutParams);
    }

    public static void setTitleBar(Activity activity, View... viewArr) {
        for (View view : viewArr) {
            if (activity == null || view == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, -2);
                }
                int i2 = layoutParams.height;
                if (i2 == -2 || i2 == -1) {
                    view.post(new a(layoutParams, view, activity));
                } else {
                    layoutParams.height = i2 + getStatusBarHeight(activity);
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(activity), view.getPaddingRight(), view.getPaddingBottom());
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public static void setTitleBarMarginTop(Activity activity, View... viewArr) {
        for (View view : viewArr) {
            if (activity == null || view == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public static void showStatusBar(@NonNull Window window) {
        window.clearFlags(1024);
    }

    public static boolean v(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static h with(@NonNull Activity activity) {
        return p().get(activity);
    }

    public final void A(int i2, int i3, int i4, int i5) {
        ViewGroup viewGroup = this.f2745g;
        if (viewGroup != null) {
            viewGroup.setPadding(i2, i3, i4, i5);
        }
        this.w = i2;
        this.x = i3;
        this.y = i4;
        this.z = i5;
    }

    public final int B(int i2) {
        return (Build.VERSION.SDK_INT < 23 || !this.f2746h.f2718i) ? i2 : i2 | 8192;
    }

    public final void C() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.f2744f;
        int i2 = d.f2721b;
        View viewFindViewById = viewGroup.findViewById(i2);
        if (viewFindViewById == null) {
            viewFindViewById = new View(this.f2739a);
            viewFindViewById.setId(i2);
            this.f2744f.addView(viewFindViewById);
        }
        if (this.f2747i.m()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f2747i.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f2747i.f(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        viewFindViewById.setLayoutParams(layoutParams);
        c cVar = this.f2746h;
        viewFindViewById.setBackgroundColor(ColorUtils.blendARGB(cVar.f2711b, cVar.f2719q, cVar.f2714e));
        c cVar2 = this.f2746h;
        if (cVar2.D && cVar2.E && !cVar2.f2716g) {
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(8);
        }
    }

    public final void D() {
        ViewGroup viewGroup = this.f2744f;
        int i2 = d.f2720a;
        View viewFindViewById = viewGroup.findViewById(i2);
        if (viewFindViewById == null) {
            viewFindViewById = new View(this.f2739a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f2747i.i());
            layoutParams.gravity = 48;
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById.setVisibility(0);
            viewFindViewById.setId(i2);
            this.f2744f.addView(viewFindViewById);
        }
        c cVar = this.f2746h;
        if (cVar.o) {
            viewFindViewById.setBackgroundColor(ColorUtils.blendARGB(cVar.f2710a, cVar.p, cVar.f2713d));
        } else {
            viewFindViewById.setBackgroundColor(ColorUtils.blendARGB(cVar.f2710a, 0, cVar.f2713d));
        }
    }

    public final void E() {
        if (this.f2746h.r.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.f2746h.r.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer numValueOf = Integer.valueOf(this.f2746h.f2710a);
                Integer numValueOf2 = Integer.valueOf(this.f2746h.p);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    numValueOf2 = entry2.getValue();
                    numValueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.f2746h.s - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(numValueOf.intValue(), numValueOf2.intValue(), this.f2746h.f2713d));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(numValueOf.intValue(), numValueOf2.intValue(), this.f2746h.s));
                    }
                }
            }
        }
    }

    public final void F() {
        h hVarWith;
        h hVarWith2;
        a();
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2747i = new c.j.a.a(this.f2739a);
            if (this.m && (hVarWith2 = with(this.f2739a)) != null) {
                hVarWith2.f2746h = this.f2746h;
            }
            if (this.n && (hVarWith = with(this.f2739a)) != null && hVarWith.v) {
                hVarWith.f2746h.B = false;
            }
        }
    }

    public final void a() {
        int i2;
        int i3;
        c cVar = this.f2746h;
        if (cVar.k && (i3 = cVar.f2710a) != 0) {
            statusBarDarkFont(i3 > -4539718, cVar.m);
        }
        c cVar2 = this.f2746h;
        if (!cVar2.l || (i2 = cVar2.f2711b) == 0) {
            return;
        }
        navigationBarDarkIcon(i2 > -4539718, cVar2.n);
    }

    public h addTag(String str) {
        if (v(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        this.p.put(str, this.f2746h.clone());
        return this;
    }

    public h addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.f2746h.p);
    }

    public h addViewSupportTransformColorInt(View view, @ColorInt int i2) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap map = new HashMap();
        map.put(Integer.valueOf(this.f2746h.f2710a), Integer.valueOf(i2));
        this.f2746h.r.put(view, map);
        return this;
    }

    public h autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.0f);
    }

    public h autoNavigationBarDarkModeEnable(boolean z) {
        return autoNavigationBarDarkModeEnable(z, 0.0f);
    }

    public h autoStatusBarDarkModeEnable(boolean z) {
        return autoStatusBarDarkModeEnable(z, 0.0f);
    }

    public final void b() {
        if (this.f2739a != null) {
            f fVar = this.o;
            if (fVar != null) {
                fVar.a();
                this.o = null;
            }
            e.b().d(this);
            k.b().d(this.f2746h.H);
        }
    }

    public h barAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.f2713d = f2;
        cVar.f2714e = f2;
        return this;
    }

    public h barColor(@ColorRes int i2) {
        return barColorInt(ContextCompat.getColor(this.f2739a, i2));
    }

    public h barColorInt(@ColorInt int i2) {
        c cVar = this.f2746h;
        cVar.f2710a = i2;
        cVar.f2711b = i2;
        return this;
    }

    public h barColorTransform(@ColorRes int i2) {
        return barColorTransformInt(ContextCompat.getColor(this.f2739a, i2));
    }

    public h barColorTransformInt(@ColorInt int i2) {
        c cVar = this.f2746h;
        cVar.p = i2;
        cVar.f2719q = i2;
        return this;
    }

    public final void c() {
        if (with(this.f2739a).u()) {
            return;
        }
        with(this.f2739a).init();
    }

    public void d() {
        h hVarWith;
        b();
        if (this.n && (hVarWith = with(this.f2739a)) != null) {
            hVarWith.f2746h.B = hVarWith.v;
        }
        this.u = false;
    }

    public final void e() {
        if (Build.VERSION.SDK_INT >= 19) {
            if (!this.m) {
                if (this.f2746h.B) {
                    if (this.o == null) {
                        this.o = new f(this, this.f2739a, this.f2743e);
                    }
                    this.o.c(this.f2746h.C);
                    return;
                } else {
                    f fVar = this.o;
                    if (fVar != null) {
                        fVar.b();
                        return;
                    }
                    return;
                }
            }
            h hVarWith = with(this.f2739a);
            if (hVarWith != null) {
                if (hVarWith.f2746h.B) {
                    if (hVarWith.o == null) {
                        hVarWith.o = new f(hVarWith, hVarWith.f2739a, hVarWith.f2743e);
                    }
                    hVarWith.o.c(hVarWith.f2746h.C);
                } else {
                    f fVar2 = hVarWith.o;
                    if (fVar2 != null) {
                        fVar2.b();
                    }
                }
            }
        }
    }

    public final void f() {
        if (Build.VERSION.SDK_INT < 19 || this.f2748q) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            setTitleBar(this.f2739a, this.f2746h.x);
            this.f2748q = true;
        } else if (i2 == 2) {
            setTitleBarMarginTop(this.f2739a, this.f2746h.x);
            this.f2748q = true;
        } else {
            if (i2 != 3) {
                return;
            }
            setStatusBarView(this.f2739a, this.f2746h.y);
            this.f2748q = true;
        }
    }

    public h fitsSystemWindows(boolean z) {
        this.f2746h.w = z;
        if (!z) {
            this.r = 0;
        } else if (this.r == 0) {
            this.r = 4;
        }
        return this;
    }

    public h fitsSystemWindowsInt(boolean z, @ColorInt int i2) {
        return fitsSystemWindowsInt(z, i2, -16777216, 0.0f);
    }

    public h flymeOSStatusBarFontColor(@ColorRes int i2) {
        this.f2746h.z = ContextCompat.getColor(this.f2739a, i2);
        return this;
    }

    public h flymeOSStatusBarFontColorInt(@ColorInt int i2) {
        this.f2746h.z = i2;
        return this;
    }

    public h fullScreen(boolean z) {
        this.f2746h.f2715f = z;
        return this;
    }

    public final void g() {
        if (Build.VERSION.SDK_INT < 28 || this.t) {
            return;
        }
        WindowManager.LayoutParams attributes = this.f2743e.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        this.f2743e.setAttributes(attributes);
        this.t = true;
    }

    public c getBarParams() {
        return this.f2746h;
    }

    public h getTag(String str) {
        if (v(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        c cVar = this.p.get(str);
        if (cVar != null) {
            this.f2746h = cVar.clone();
        }
        return this;
    }

    public final void h() {
        if (Build.VERSION.SDK_INT >= 21 && !m.isEMUI3_x()) {
            i();
            return;
        }
        j();
        if (this.m || !m.isEMUI3_x()) {
            return;
        }
        k();
    }

    public h hideBar(c.j.a.b bVar) {
        this.f2746h.f2717h = bVar;
        if (Build.VERSION.SDK_INT == 19 || m.isEMUI3_x()) {
            c cVar = this.f2746h;
            c.j.a.b bVar2 = cVar.f2717h;
            if (bVar2 == c.j.a.b.FLAG_HIDE_NAVIGATION_BAR || bVar2 == c.j.a.b.FLAG_HIDE_BAR) {
                cVar.f2716g = true;
            } else {
                cVar.f2716g = false;
            }
        }
        return this;
    }

    public final void i() {
        if (checkFitsSystemWindows(this.f2744f.findViewById(R.id.content))) {
            if (this.f2746h.A) {
                A(0, this.f2747i.a(), 0, 0);
            }
        } else {
            int i2 = (this.f2746h.w && this.r == 4) ? this.f2747i.i() : 0;
            if (this.f2746h.A) {
                i2 = this.f2747i.i() + this.f2747i.a();
            }
            A(0, i2, 0, 0);
        }
    }

    public void init() {
        F();
        x();
        f();
        e();
        E();
        this.u = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.f2744f
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)
            boolean r0 = checkFitsSystemWindows(r0)
            r1 = 0
            if (r0 == 0) goto L20
            c.j.a.c r0 = r5.f2746h
            boolean r0 = r0.A
            if (r0 == 0) goto L1f
            c.j.a.a r0 = r5.f2747i
            int r0 = r0.a()
            r5.A(r1, r0, r1, r1)
        L1f:
            return
        L20:
            c.j.a.c r0 = r5.f2746h
            boolean r0 = r0.w
            if (r0 == 0) goto L32
            int r0 = r5.r
            r2 = 4
            if (r0 != r2) goto L32
            c.j.a.a r0 = r5.f2747i
            int r0 = r0.i()
            goto L33
        L32:
            r0 = 0
        L33:
            c.j.a.c r2 = r5.f2746h
            boolean r2 = r2.A
            if (r2 == 0) goto L46
            c.j.a.a r0 = r5.f2747i
            int r0 = r0.i()
            c.j.a.a r2 = r5.f2747i
            int r2 = r2.a()
            int r0 = r0 + r2
        L46:
            c.j.a.a r2 = r5.f2747i
            boolean r2 = r2.k()
            if (r2 == 0) goto L96
            c.j.a.c r2 = r5.f2746h
            boolean r3 = r2.D
            if (r3 == 0) goto L96
            boolean r3 = r2.E
            if (r3 == 0) goto L96
            boolean r2 = r2.f2715f
            if (r2 != 0) goto L74
            c.j.a.a r2 = r5.f2747i
            boolean r2 = r2.m()
            if (r2 == 0) goto L6d
            c.j.a.a r2 = r5.f2747i
            int r2 = r2.d()
            r3 = r2
            r2 = 0
            goto L76
        L6d:
            c.j.a.a r2 = r5.f2747i
            int r2 = r2.f()
            goto L75
        L74:
            r2 = 0
        L75:
            r3 = 0
        L76:
            c.j.a.c r4 = r5.f2746h
            boolean r4 = r4.f2716g
            if (r4 == 0) goto L87
            c.j.a.a r4 = r5.f2747i
            boolean r4 = r4.m()
            if (r4 == 0) goto L85
            goto L97
        L85:
            r2 = 0
            goto L98
        L87:
            c.j.a.a r4 = r5.f2747i
            boolean r4 = r4.m()
            if (r4 != 0) goto L98
            c.j.a.a r2 = r5.f2747i
            int r2 = r2.f()
            goto L98
        L96:
            r2 = 0
        L97:
            r3 = 0
        L98:
            r5.A(r1, r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.j.a.h.j():void");
    }

    public final void k() {
        View viewFindViewById = this.f2744f.findViewById(d.f2721b);
        c cVar = this.f2746h;
        if (!cVar.D || !cVar.E) {
            e.b().d(this);
            viewFindViewById.setVisibility(8);
        } else if (viewFindViewById != null) {
            e.b().a(this);
            e.b().c(this.f2739a.getApplication());
        }
    }

    public h keyboardEnable(boolean z) {
        return keyboardEnable(z, this.f2746h.C);
    }

    public h keyboardMode(int i2) {
        this.f2746h.C = i2;
        return this;
    }

    public int l() {
        return this.z;
    }

    public int m() {
        return this.w;
    }

    public int n() {
        return this.y;
    }

    public h navigationBarAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f2746h.f2714e = f2;
        return this;
    }

    public h navigationBarColor(@ColorRes int i2) {
        return navigationBarColorInt(ContextCompat.getColor(this.f2739a, i2));
    }

    public h navigationBarColorInt(@ColorInt int i2) {
        this.f2746h.f2711b = i2;
        return this;
    }

    public h navigationBarColorTransform(@ColorRes int i2) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.f2739a, i2));
    }

    public h navigationBarColorTransformInt(@ColorInt int i2) {
        this.f2746h.f2719q = i2;
        return this;
    }

    public h navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.0f);
    }

    public h navigationBarEnable(boolean z) {
        this.f2746h.D = z;
        return this;
    }

    public h navigationBarWithEMUI3Enable(boolean z) {
        if (m.isEMUI3_x()) {
            c cVar = this.f2746h;
            cVar.F = z;
            cVar.E = z;
        }
        return this;
    }

    public h navigationBarWithKitkatEnable(boolean z) {
        this.f2746h.E = z;
        return this;
    }

    public int o() {
        return this.x;
    }

    @Override // c.j.a.i, c.j.a.o
    public void onNavigationBarChange(boolean z) {
        View viewFindViewById = this.f2744f.findViewById(d.f2721b);
        if (viewFindViewById != null) {
            this.f2747i = new c.j.a.a(this.f2739a);
            int paddingBottom = this.f2745g.getPaddingBottom();
            int paddingRight = this.f2745g.getPaddingRight();
            if (z) {
                viewFindViewById.setVisibility(0);
                if (!checkFitsSystemWindows(this.f2744f.findViewById(R.id.content))) {
                    if (this.j == 0) {
                        this.j = this.f2747i.d();
                    }
                    if (this.k == 0) {
                        this.k = this.f2747i.f();
                    }
                    if (!this.f2746h.f2716g) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
                        if (this.f2747i.m()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.j;
                            layoutParams.height = paddingBottom;
                            if (this.f2746h.f2715f) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            int i2 = this.k;
                            layoutParams.width = i2;
                            if (this.f2746h.f2715f) {
                                i2 = 0;
                            }
                            paddingRight = i2;
                            paddingBottom = 0;
                        }
                        viewFindViewById.setLayoutParams(layoutParams);
                    }
                }
                A(0, this.f2745g.getPaddingTop(), paddingRight, paddingBottom);
            }
            viewFindViewById.setVisibility(8);
            paddingBottom = 0;
            paddingRight = 0;
            A(0, this.f2745g.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    public final int q(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i3 = b.f2752a[this.f2746h.f2717h.ordinal()];
            if (i3 == 1) {
                i2 |= 518;
            } else if (i3 == 2) {
                i2 |= 1028;
            } else if (i3 == 3) {
                i2 |= 514;
            } else if (i3 == 4) {
                i2 |= 0;
            }
        }
        return i2 | 4096;
    }

    @RequiresApi(api = 21)
    public final int r(int i2) {
        if (!this.s) {
            this.f2746h.f2712c = this.f2743e.getNavigationBarColor();
            this.s = true;
        }
        int i3 = i2 | 1024;
        c cVar = this.f2746h;
        if (cVar.f2715f && cVar.D) {
            i3 |= 512;
        }
        this.f2743e.clearFlags(67108864);
        if (this.f2747i.k()) {
            this.f2743e.clearFlags(134217728);
        }
        this.f2743e.addFlags(Integer.MIN_VALUE);
        c cVar2 = this.f2746h;
        if (cVar2.o) {
            this.f2743e.setStatusBarColor(ColorUtils.blendARGB(cVar2.f2710a, cVar2.p, cVar2.f2713d));
        } else {
            this.f2743e.setStatusBarColor(ColorUtils.blendARGB(cVar2.f2710a, 0, cVar2.f2713d));
        }
        c cVar3 = this.f2746h;
        if (cVar3.D) {
            this.f2743e.setNavigationBarColor(ColorUtils.blendARGB(cVar3.f2711b, cVar3.f2719q, cVar3.f2714e));
        } else {
            this.f2743e.setNavigationBarColor(cVar3.f2712c);
        }
        return i3;
    }

    public h removeSupportAllView() {
        if (this.f2746h.r.size() != 0) {
            this.f2746h.r.clear();
        }
        return this;
    }

    public h removeSupportView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        Map<Integer, Integer> map = this.f2746h.r.get(view);
        if (map != null && map.size() != 0) {
            this.f2746h.r.remove(view);
        }
        return this;
    }

    public h reset() {
        this.f2746h = new c();
        this.r = 0;
        return this;
    }

    public final void s() {
        this.f2743e.addFlags(67108864);
        D();
        if (this.f2747i.k() || m.isEMUI3_x()) {
            c cVar = this.f2746h;
            if (cVar.D && cVar.E) {
                this.f2743e.addFlags(134217728);
            } else {
                this.f2743e.clearFlags(134217728);
            }
            if (this.j == 0) {
                this.j = this.f2747i.d();
            }
            if (this.k == 0) {
                this.k = this.f2747i.f();
            }
            C();
        }
    }

    public h setOnKeyboardListener(@Nullable n nVar) {
        c cVar = this.f2746h;
        if (cVar.G == null) {
            cVar.G = nVar;
        }
        return this;
    }

    public h setOnNavigationBarListener(o oVar) {
        if (oVar != null) {
            c cVar = this.f2746h;
            if (cVar.H == null) {
                cVar.H = oVar;
                k.b().a(this.f2746h.H);
            }
        } else if (this.f2746h.H != null) {
            k.b().d(this.f2746h.H);
            this.f2746h.H = null;
        }
        return this;
    }

    public h statusBarAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f2746h.f2713d = f2;
        return this;
    }

    public h statusBarColor(@ColorRes int i2) {
        return statusBarColorInt(ContextCompat.getColor(this.f2739a, i2));
    }

    public h statusBarColorInt(@ColorInt int i2) {
        this.f2746h.f2710a = i2;
        return this;
    }

    public h statusBarColorTransform(@ColorRes int i2) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.f2739a, i2));
    }

    public h statusBarColorTransformEnable(boolean z) {
        this.f2746h.o = z;
        return this;
    }

    public h statusBarColorTransformInt(@ColorInt int i2) {
        this.f2746h.p = i2;
        return this;
    }

    public h statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.0f);
    }

    public h statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.f2746h.y = view;
        if (this.r == 0) {
            this.r = 3;
        }
        return this;
    }

    public h supportActionBar(boolean z) {
        this.f2746h.A = z;
        return this;
    }

    public final void t(Window window) {
        this.f2743e = window;
        this.f2746h = new c();
        ViewGroup viewGroup = (ViewGroup) this.f2743e.getDecorView();
        this.f2744f = viewGroup;
        this.f2745g = (ViewGroup) viewGroup.findViewById(R.id.content);
    }

    public h titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public h titleBarMarginTop(@IdRes int i2) {
        Fragment fragment = this.f2740b;
        if (fragment != null && fragment.getView() != null) {
            return titleBarMarginTop(this.f2740b.getView().findViewById(i2));
        }
        android.app.Fragment fragment2 = this.f2741c;
        return (fragment2 == null || fragment2.getView() == null) ? titleBarMarginTop(this.f2739a.findViewById(i2)) : titleBarMarginTop(this.f2741c.getView().findViewById(i2));
    }

    public h transparentBar() {
        c cVar = this.f2746h;
        cVar.f2710a = 0;
        cVar.f2711b = 0;
        cVar.f2715f = true;
        return this;
    }

    public h transparentNavigationBar() {
        c cVar = this.f2746h;
        cVar.f2711b = 0;
        cVar.f2715f = true;
        return this;
    }

    public h transparentStatusBar() {
        this.f2746h.f2710a = 0;
        return this;
    }

    public boolean u() {
        return this.u;
    }

    public h viewAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f2746h.s = f2;
        return this;
    }

    public boolean w() {
        return this.m;
    }

    public final void x() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            int iZ = 256;
            if (i2 < 21 || m.isEMUI3_x()) {
                s();
            } else {
                g();
                iZ = z(B(r(256)));
            }
            int iQ = q(iZ);
            h();
            this.f2744f.setSystemUiVisibility(iQ);
        }
        if (m.isMIUI6Later()) {
            y(this.f2743e, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.f2746h.f2718i);
            c cVar = this.f2746h;
            if (cVar.D) {
                y(this.f2743e, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", cVar.j);
            }
        }
        if (m.isFlymeOS4Later()) {
            c cVar2 = this.f2746h;
            int i3 = cVar2.z;
            if (i3 != 0) {
                g.setStatusBarDarkIcon(this.f2739a, i3);
            } else {
                g.setStatusBarDarkIcon(this.f2739a, cVar2.f2718i);
            }
        }
        if (this.f2746h.H != null) {
            k.b().c(this.f2739a.getApplication());
        }
    }

    @SuppressLint({"PrivateApi"})
    public final void y(Window window, String str, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField(str).getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z) {
                    method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i2));
                }
            } catch (Exception unused) {
            }
        }
    }

    public final int z(int i2) {
        return (Build.VERSION.SDK_INT < 26 || !this.f2746h.j) ? i2 : i2 | 16;
    }

    public static h with(@NonNull Fragment fragment) {
        return p().get(fragment);
    }

    public h addViewSupportTransformColor(View view, @ColorRes int i2) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.f2739a, i2));
    }

    public h autoDarkModeEnable(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.k = z;
        cVar.m = f2;
        cVar.l = z;
        cVar.n = f2;
        return this;
    }

    public h autoNavigationBarDarkModeEnable(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.l = z;
        cVar.n = f2;
        return this;
    }

    public h autoStatusBarDarkModeEnable(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.k = z;
        cVar.m = f2;
        return this;
    }

    public h barColor(@ColorRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return barColorInt(ContextCompat.getColor(this.f2739a, i2), i2);
    }

    public h barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public h fitsSystemWindowsInt(boolean z, @ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.w = z;
        cVar.t = i2;
        cVar.u = i3;
        cVar.v = f2;
        if (!z) {
            this.r = 0;
        } else if (this.r == 0) {
            this.r = 4;
        }
        this.f2745g.setBackgroundColor(ColorUtils.blendARGB(i2, i3, f2));
        return this;
    }

    public h flymeOSStatusBarFontColor(String str) {
        this.f2746h.z = Color.parseColor(str);
        return this;
    }

    public h keyboardEnable(boolean z, int i2) {
        c cVar = this.f2746h;
        cVar.B = z;
        cVar.C = i2;
        this.v = z;
        return this;
    }

    public h navigationBarColor(@ColorRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return navigationBarColorInt(ContextCompat.getColor(this.f2739a, i2), f2);
    }

    public h navigationBarColorInt(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.f2711b = i2;
        cVar.f2714e = f2;
        return this;
    }

    public h navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public h navigationBarDarkIcon(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f2746h.j = z;
        if (!z || isSupportNavigationIconDark()) {
            this.f2746h.f2714e = 0.0f;
        } else {
            this.f2746h.f2714e = f2;
        }
        return this;
    }

    public h statusBarColor(@ColorRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return statusBarColorInt(ContextCompat.getColor(this.f2739a, i2), f2);
    }

    public h statusBarColorInt(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.f2710a = i2;
        cVar.f2713d = f2;
        return this;
    }

    public h statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public h statusBarDarkFont(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f2746h.f2718i = z;
        if (!z || isSupportStatusBarDarkFont()) {
            c cVar = this.f2746h;
            cVar.z = 0;
            cVar.f2713d = 0.0f;
        } else {
            this.f2746h.f2713d = f2;
        }
        return this;
    }

    public h titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.r == 0) {
            this.r = 1;
        }
        c cVar = this.f2746h;
        cVar.x = view;
        cVar.o = z;
        return this;
    }

    public static boolean hasNotchScreen(@NonNull View view) {
        return l.hasNotchScreen(view);
    }

    public static h with(@NonNull android.app.Fragment fragment) {
        return p().get(fragment);
    }

    public h addViewSupportTransformColor(View view, @ColorRes int i2, @ColorRes int i3) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.f2739a, i2), ContextCompat.getColor(this.f2739a, i3));
    }

    public h barColor(@ColorRes int i2, @ColorRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return barColorInt(ContextCompat.getColor(this.f2739a, i2), ContextCompat.getColor(this.f2739a, i3), f2);
    }

    public h barColorInt(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.f2710a = i2;
        cVar.f2711b = i2;
        cVar.f2713d = f2;
        cVar.f2714e = f2;
        return this;
    }

    public h navigationBarColor(@ColorRes int i2, @ColorRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return navigationBarColorInt(ContextCompat.getColor(this.f2739a, i2), ContextCompat.getColor(this.f2739a, i3), f2);
    }

    public h statusBarColor(@ColorRes int i2, @ColorRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return statusBarColorInt(ContextCompat.getColor(this.f2739a, i2), ContextCompat.getColor(this.f2739a, i3), f2);
    }

    public static h with(@NonNull DialogFragment dialogFragment) {
        return p().get(dialogFragment);
    }

    public h navigationBarColorInt(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.f2711b = i2;
        cVar.f2719q = i3;
        cVar.f2714e = f2;
        return this;
    }

    public h statusBarColorInt(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.f2710a = i2;
        cVar.p = i3;
        cVar.f2713d = f2;
        return this;
    }

    public h statusBarView(@IdRes int i2) {
        return statusBarView(this.f2739a.findViewById(i2));
    }

    public static h with(@NonNull android.app.DialogFragment dialogFragment) {
        return p().get(dialogFragment);
    }

    public h addViewSupportTransformColorInt(View view, @ColorInt int i2, @ColorInt int i3) {
        if (view != null) {
            HashMap map = new HashMap();
            map.put(Integer.valueOf(i2), Integer.valueOf(i3));
            this.f2746h.r.put(view, map);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public h fitsSystemWindows(boolean z, @ColorRes int i2) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.f2739a, i2));
    }

    public h statusBarView(@IdRes int i2, View view) {
        return statusBarView(view.findViewById(i2));
    }

    public static h with(@NonNull Activity activity, @NonNull Dialog dialog) {
        return p().get(activity, dialog);
    }

    public h barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public h fitsSystemWindows(boolean z, @ColorRes int i2, @ColorRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.f2739a, i2), ContextCompat.getColor(this.f2739a, i3), f2);
    }

    public h navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public h statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public h titleBar(@IdRes int i2) {
        return titleBar(i2, true);
    }

    public h titleBarMarginTop(@IdRes int i2, View view) {
        return titleBarMarginTop(view.findViewById(i2));
    }

    public h addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public h barColor(String str, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return barColorInt(Color.parseColor(str), f2);
    }

    public h barColorInt(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c cVar = this.f2746h;
        cVar.f2710a = i2;
        cVar.f2711b = i2;
        cVar.p = i3;
        cVar.f2719q = i3;
        cVar.f2713d = f2;
        cVar.f2714e = f2;
        return this;
    }

    public h navigationBarColor(String str, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return navigationBarColorInt(Color.parseColor(str), f2);
    }

    public h statusBarColor(String str, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return statusBarColorInt(Color.parseColor(str), f2);
    }

    public h titleBar(@IdRes int i2, boolean z) {
        Fragment fragment = this.f2740b;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.f2740b.getView().findViewById(i2), z);
        }
        android.app.Fragment fragment2 = this.f2741c;
        if (fragment2 != null && fragment2.getView() != null) {
            return titleBar(this.f2741c.getView().findViewById(i2), z);
        }
        return titleBar(this.f2739a.findViewById(i2), z);
    }

    public h titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.r == 0) {
            this.r = 2;
        }
        this.f2746h.x = view;
        return this;
    }

    public h addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public h barColor(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public h navigationBarColor(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public h statusBarColor(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public static void setTitleBarMarginTop(Fragment fragment, View... viewArr) {
        setTitleBarMarginTop(fragment.getActivity(), viewArr);
    }

    public static void setTitleBarMarginTop(android.app.Fragment fragment, View... viewArr) {
        setTitleBarMarginTop(fragment.getActivity(), viewArr);
    }

    public static void setTitleBar(Fragment fragment, View... viewArr) {
        setTitleBar(fragment.getActivity(), viewArr);
    }

    public h titleBar(@IdRes int i2, View view) {
        return titleBar(view.findViewById(i2), true);
    }

    public static void setTitleBar(android.app.Fragment fragment, View... viewArr) {
        setTitleBar(fragment.getActivity(), viewArr);
    }

    public h titleBar(@IdRes int i2, View view, boolean z) {
        return titleBar(view.findViewById(i2), z);
    }

    public h(Fragment fragment) {
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = new HashMap();
        this.f2748q = false;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.m = true;
        this.f2739a = fragment.getActivity();
        this.f2740b = fragment;
        c();
        t(this.f2739a.getWindow());
    }

    public h(android.app.Fragment fragment) {
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = new HashMap();
        this.f2748q = false;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.m = true;
        this.f2739a = fragment.getActivity();
        this.f2741c = fragment;
        c();
        t(this.f2739a.getWindow());
    }

    public h(DialogFragment dialogFragment) {
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = new HashMap();
        this.f2748q = false;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.n = true;
        this.f2739a = dialogFragment.getActivity();
        this.f2740b = dialogFragment;
        this.f2742d = dialogFragment.getDialog();
        c();
        t(this.f2742d.getWindow());
    }

    public h(android.app.DialogFragment dialogFragment) {
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = new HashMap();
        this.f2748q = false;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.n = true;
        this.f2739a = dialogFragment.getActivity();
        this.f2741c = dialogFragment;
        this.f2742d = dialogFragment.getDialog();
        c();
        t(this.f2742d.getWindow());
    }

    public h(Activity activity, Dialog dialog) {
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = new HashMap();
        this.f2748q = false;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.n = true;
        this.f2739a = activity;
        this.f2742d = dialog;
        c();
        t(this.f2742d.getWindow());
    }
}
