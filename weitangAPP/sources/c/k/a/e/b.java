package c.k.a.e;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f2793b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f2796e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2794c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f2792a = new Rect();

    public interface a {
        void onNavigationBarHide(int i2);

        void onNavigationBarShow(int i2, int i3);
    }

    public b(View view, int i2) {
        this.f2793b = view;
        this.f2795d = i2;
    }

    public static b with(View view) {
        return with(view, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onGlobalLayout() {
        /*
            r6 = this;
            android.graphics.Rect r0 = r6.f2792a
            r0.setEmpty()
            android.view.View r0 = r6.f2793b
            android.graphics.Rect r1 = r6.f2792a
            r0.getWindowVisibleDisplayFrame(r1)
            int r0 = r6.f2795d
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 != r2) goto L22
            android.view.View r0 = r6.f2793b
            int r0 = r0.getHeight()
            android.graphics.Rect r4 = r6.f2792a
            int r5 = r4.bottom
            int r4 = r4.top
        L1f:
            int r5 = r5 - r4
            int r0 = r0 - r5
            goto L32
        L22:
            if (r0 != r1) goto L31
            android.view.View r0 = r6.f2793b
            int r0 = r0.getWidth()
            android.graphics.Rect r4 = r6.f2792a
            int r5 = r4.right
            int r4 = r4.left
            goto L1f
        L31:
            r0 = 0
        L32:
            android.view.View r4 = r6.f2793b
            android.content.Context r4 = r4.getContext()
            boolean r4 = c.k.a.e.d.hasVirtualNavigationBar(r4)
            if (r4 == 0) goto L49
            android.view.View r4 = r6.f2793b
            android.content.Context r4 = r4.getContext()
            int r4 = c.k.a.e.d.getNavigationBarHeight(r4)
            goto L4a
        L49:
            r4 = 0
        L4a:
            if (r0 < r4) goto L60
            int r4 = r4 * 2
            if (r0 >= r4) goto L60
            boolean r1 = r6.f2794c
            if (r1 != 0) goto L5d
            c.k.a.e.b$a r1 = r6.f2796e
            if (r1 == 0) goto L5d
            int r3 = r6.f2795d
            r1.onNavigationBarShow(r3, r0)
        L5d:
            r6.f2794c = r2
            goto L6f
        L60:
            boolean r0 = r6.f2794c
            if (r0 == 0) goto L6d
            c.k.a.e.b$a r0 = r6.f2796e
            if (r0 == 0) goto L6d
            int r1 = r6.f2795d
            r0.onNavigationBarHide(r1)
        L6d:
            r6.f2794c = r3
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.a.e.b.onGlobalLayout():void");
    }

    public void setListener(a aVar) {
        this.f2796e = aVar;
    }

    public static b with(Activity activity) {
        return with(activity.findViewById(R.id.content), 1);
    }

    public static b with(View view, int i2) {
        b bVar = new b(view, i2);
        view.getViewTreeObserver().addOnGlobalLayoutListener(bVar);
        return bVar;
    }

    public static b with(Activity activity, int i2) {
        return with(activity.findViewById(R.id.content), i2);
    }
}
