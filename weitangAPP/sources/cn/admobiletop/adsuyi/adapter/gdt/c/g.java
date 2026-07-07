package cn.admobiletop.adsuyi.adapter.gdt.c;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3693h;

    public g(Context context, int i2) {
        super(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10.0f);
        setBackgroundDrawable(gradientDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(true);
        }
        this.f3688c = i2;
        this.f3693h = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new f(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[PHI: r4
  0x005a: PHI (r4v12 int) = (r4v11 int), (r4v14 int) binds: [B:16:0x0050, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            if (r0 == 0) goto La4
            r1 = 0
            r3 = 1
            if (r0 == r3) goto L6f
            r3 = 2
            if (r0 == r3) goto L10
            goto Lbf
        L10:
            float r0 = r8.getRawX()
            float r3 = r7.f3686a
            float r0 = r0 + r3
            float r3 = r8.getRawY()
            float r4 = r7.f3687b
            float r3 = r3 + r4
            float r4 = r7.f3691f
            float r5 = r7.getX()
            float r5 = r0 - r5
            float r5 = java.lang.Math.abs(r5)
            float r4 = r4 + r5
            r7.f3691f = r4
            float r4 = r7.f3692g
            float r5 = r7.getY()
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            float r4 = r4 + r5
            r7.f3692g = r4
            int r4 = r7.f3688c
            float r5 = (float) r4
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 >= 0) goto L45
            r5 = r4
            goto L4c
        L45:
            int r5 = r7.f3689d
            float r6 = (float) r5
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 <= 0) goto L4d
        L4c:
            float r0 = (float) r5
        L4d:
            float r5 = (float) r4
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L53
            goto L5a
        L53:
            int r4 = r7.f3690e
            float r5 = (float) r4
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L5b
        L5a:
            float r3 = (float) r4
        L5b:
            android.view.ViewPropertyAnimator r4 = r7.animate()
            android.view.ViewPropertyAnimator r0 = r4.x(r0)
            android.view.ViewPropertyAnimator r0 = r0.y(r3)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r1)
            r0.start()
            goto Lbf
        L6f:
            float r0 = r8.getRawX()
            float r4 = r7.f3686a
            float r0 = r0 + r4
            r4 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 * r4
            int r4 = r7.f3689d
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L82
            goto L85
        L82:
            int r0 = r7.f3688c
            float r4 = (float) r0
        L85:
            android.view.ViewPropertyAnimator r0 = r7.animate()
            android.view.ViewPropertyAnimator r0 = r0.x(r4)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r1)
            r0.start()
            float r0 = r7.f3691f
            int r1 = r7.f3693h
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto La3
            float r0 = r7.f3692g
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto Lbf
        La3:
            return r3
        La4:
            float r0 = r7.getX()
            float r1 = r8.getRawX()
            float r0 = r0 - r1
            r7.f3686a = r0
            float r0 = r7.getY()
            float r1 = r8.getRawY()
            float r0 = r0 - r1
            r7.f3687b = r0
            r0 = 0
            r7.f3691f = r0
            r7.f3692g = r0
        Lbf:
            boolean r8 = super.onInterceptTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.admobiletop.adsuyi.adapter.gdt.c.g.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
