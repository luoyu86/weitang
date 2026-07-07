package c.e.b.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import anet.channel.strategy.dispatch.DispatchConstants;
import c.e.a.d.q;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WindowManager f1257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f1258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout.LayoutParams f1261e;

    /* JADX INFO: renamed from: c.e.b.c.a.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalLayoutListenerC0024a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1262a;

        public ViewTreeObserverOnGlobalLayoutListenerC0024a(int i2) {
            this.f1262a = i2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a.this.d(this.f1262a);
        }
    }

    public a(View view, Activity activity, int i2) {
        this.f1258b = view;
        this.f1259c = i2;
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            this.f1258b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0024a(isShowNavBar(activity) ? getStatusBarHeight() : 0));
            this.f1261e = (FrameLayout.LayoutParams) this.f1258b.getLayoutParams();
        }
    }

    public static void assistActivity(View view, Activity activity, int i2) {
        new a(view, activity, i2);
    }

    public static int c() {
        Resources resources = c.e.a.a.b.getInstance().getContext().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static int getRealHeight() {
        if (f1257a == null) {
            f1257a = (WindowManager) c.e.a.a.b.getInstance().getContext().getSystemService("window");
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            f1257a.getDefaultDisplay().getRealSize(point);
        } else {
            f1257a.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }

    public static int getStatusBarHeight() {
        int identifier = c.e.a.a.b.getInstance().getContext().getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return c.e.a.a.b.getInstance().getContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean isShowNavBar(Context context) {
        if (context == null) {
            return false;
        }
        Rect rect = new Rect();
        try {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height();
            int statusBarHeight = getStatusBarHeight();
            int iC = c();
            int realHeight = getRealHeight() - statusBarHeight;
            q.d(a.class.getSimpleName(), "isShowNavBar statuBarHeight = " + statusBarHeight + ",activityHeight = " + iHeight + ",remainHeight = " + realHeight + ",navigationBarHeight = " + iC);
            return iHeight != realHeight;
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final int b() {
        Rect rect = new Rect();
        this.f1258b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public final void d(int i2) {
        int iB = b();
        if (iB != this.f1260d) {
            int height = this.f1258b.getRootView().getHeight();
            int i3 = height / 3;
            if (height - iB > i3) {
                this.f1261e.height = (height - i3) - i2;
            } else {
                FrameLayout.LayoutParams layoutParams = this.f1261e;
                int i4 = this.f1259c;
                if (i4 <= 0) {
                    i4 = height - i2;
                }
                layoutParams.height = i4;
            }
            this.f1258b.requestLayout();
            this.f1260d = iB;
            q.d(a.class.getSimpleName(), "possiblyResizeChildOfContent usableHeightNow =" + iB + ",viewHeight = " + this.f1259c + ",keyboardHeight = " + i3);
        }
    }
}
