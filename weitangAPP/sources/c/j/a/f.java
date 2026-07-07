package c.j.a;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: classes2.dex */
public class f implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f2728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Activity f2729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Window f2730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f2731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f2732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f2733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2734i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;

    public f(h hVar, Activity activity, Window window) {
        this.f2734i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f2728c = hVar;
        this.f2729d = activity;
        this.f2730e = window;
        View decorView = window.getDecorView();
        this.f2731f = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        View childAt = frameLayout.getChildAt(0);
        this.f2733h = childAt;
        if (childAt != null) {
            if (childAt instanceof DrawerLayout) {
                this.f2733h = ((DrawerLayout) childAt).getChildAt(0);
            }
            View view = this.f2733h;
            if (view != null) {
                this.f2734i = view.getPaddingLeft();
                this.j = this.f2733h.getPaddingTop();
                this.k = this.f2733h.getPaddingRight();
                this.l = this.f2733h.getPaddingBottom();
            }
        }
        View view2 = this.f2733h;
        this.f2732g = view2 != null ? view2 : frameLayout;
        a aVar = new a(this.f2729d);
        this.f2726a = aVar.i();
        this.f2727b = aVar.a();
    }

    public void a() {
        if (Build.VERSION.SDK_INT < 19 || !this.n) {
            return;
        }
        this.f2731f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.n = false;
    }

    public void b() {
        if (Build.VERSION.SDK_INT < 19 || !this.n) {
            return;
        }
        if (this.f2733h != null) {
            this.f2732g.setPadding(this.f2734i, this.j, this.k, this.l);
        } else {
            this.f2732g.setPadding(this.f2728c.m(), this.f2728c.o(), this.f2728c.n(), this.f2728c.l());
        }
    }

    public void c(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2730e.setSoftInputMode(i2);
            if (this.n) {
                return;
            }
            this.f2731f.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.n = true;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i2;
        h hVar = this.f2728c;
        if (hVar == null || hVar.getBarParams() == null || !this.f2728c.getBarParams().B) {
            return;
        }
        int navigationBarHeight = h.getNavigationBarHeight(this.f2729d);
        Rect rect = new Rect();
        this.f2731f.getWindowVisibleDisplayFrame(rect);
        int height = this.f2732g.getHeight() - rect.bottom;
        if (height != this.m) {
            this.m = height;
            boolean z = true;
            if (h.checkFitsSystemWindows(this.f2730e.getDecorView().findViewById(R.id.content))) {
                height -= navigationBarHeight;
                if (height <= navigationBarHeight) {
                    z = false;
                }
            } else if (this.f2733h != null) {
                if (this.f2728c.getBarParams().A) {
                    height += this.f2727b + this.f2726a;
                }
                if (this.f2728c.getBarParams().w) {
                    height += this.f2726a;
                }
                if (height > navigationBarHeight) {
                    i2 = this.l + height;
                } else {
                    i2 = 0;
                    z = false;
                }
                this.f2732g.setPadding(this.f2734i, this.j, this.k, i2);
            } else {
                int iL = this.f2728c.l();
                height -= navigationBarHeight;
                if (height > navigationBarHeight) {
                    iL = height + navigationBarHeight;
                } else {
                    z = false;
                }
                this.f2732g.setPadding(this.f2728c.m(), this.f2728c.o(), this.f2728c.n(), iL);
            }
            int i3 = height >= 0 ? height : 0;
            if (this.f2728c.getBarParams().G != null) {
                this.f2728c.getBarParams().G.onKeyboardChange(z, i3);
            }
        }
    }
}
