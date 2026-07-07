package com.tianmu.biz.widget.n;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.biz.utils.o0;
import com.tianmu.biz.widget.n.a;
import com.tianmu.biz.widget.sway.SwayProgressBar;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.x0;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.tianmu.biz.widget.n.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f11120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SwayProgressBar f11121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FrameLayout f11122i;
    private ObjectAnimator j;
    private o0 k;
    private double l;
    private Handler m;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar;
            a.InterfaceC0198a interfaceC0198a;
            if (message.what == 2 && (interfaceC0198a = (cVar = c.this).f11110b) != null) {
                interfaceC0198a.onClick(cVar, 5);
            }
            super.handleMessage(message);
        }
    }

    public class b implements o0.b {
        public b() {
        }

        @Override // com.tianmu.biz.utils.o0.b
        public void a() {
            c.this.j();
        }

        @Override // com.tianmu.biz.utils.o0.b
        public void a(float f2) {
            c.this.a(f2);
        }
    }

    public c(Context context, boolean z, String str) {
        super(context, z);
        this.l = 0.0d;
        this.m = new a(Looper.getMainLooper());
        this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        this.f11114f = str;
        e();
    }

    private float f() {
        double d2 = this.l;
        if (d2 > 0.0d) {
            return (float) d2;
        }
        return 24.0f;
    }

    private void g() {
        o0 o0Var = this.k;
        if (o0Var != null) {
            o0Var.c();
        }
        SwayProgressBar swayProgressBar = this.f11121h;
        if (swayProgressBar != null) {
            swayProgressBar.a(0.0f);
            this.f11121h.postInvalidate();
        }
    }

    private void h() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f11120g, (Property<ImageView, Float>) View.ROTATION, -15.0f, -25.0f, -30.0f, -30.0f, 0.0f, 3.0f, -3.0f, 2.0f, -2.0f, 1.0f, -1.0f, 0.0f, 0.0f, 5.0f, 15.0f, 25.0f, 30.0f, 30.0f, 0.0f, -3.0f, 3.0f, -2.0f, 2.0f, -1.0f, 1.0f, 0.0f, 0.0f);
        this.j = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.j.setRepeatCount(-1);
        this.j.setDuration(3000L);
        this.j.start();
    }

    private void i() {
        if (this.k == null) {
            this.k = new o0(getContext(), this.l, new b());
        }
        this.k.d();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Handler handler = this.m;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(2, 100L);
            o0 o0Var = this.k;
            if (o0Var != null) {
                o0Var.e();
            }
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b(boolean z) {
        if (z) {
            this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        } else {
            this.f11113e = 61;
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void c() {
        try {
            this.f11113e = 95;
            FrameLayout frameLayout = this.f11122i;
            if (frameLayout != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.width = TianmuDisplayUtil.dp2px(92);
                layoutParams.height = TianmuDisplayUtil.dp2px(92);
                this.f11122i.setLayoutParams(layoutParams);
                this.f11122i.setBackground(null);
            }
            ImageView imageView = this.f11120g;
            if (imageView != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.bottomMargin = TianmuDisplayUtil.dp2px(10);
                this.f11120g.setLayoutParams(layoutParams2);
            }
            TextView textView = this.f11111c;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams3.topMargin = 0;
                this.f11111c.setLayoutParams(layoutParams3);
                this.f11111c.setPadding(TianmuDisplayUtil.dp2px(4), 0, TianmuDisplayUtil.dp2px(4), TianmuDisplayUtil.dp2px(4));
                this.f11111c.setTextSize(14.0f);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void d() {
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.j.end();
        }
        this.f11120g.clearAnimation();
        this.j = null;
    }

    public void e() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(x0.f11540a, (ViewGroup) this, true);
        this.f11109a = viewInflate;
        this.f11120g = (ImageView) viewInflate.findViewById(x0.f11541b);
        SwayProgressBar swayProgressBar = (SwayProgressBar) this.f11109a.findViewById(x0.f11542c);
        this.f11121h = swayProgressBar;
        swayProgressBar.b(f());
        a(a(5, 0, this.f11114f, c1.f11295c));
        this.f11122i = (FrameLayout) this.f11109a.findViewById(x0.f11543d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        o0 o0Var = this.k;
        if (o0Var != null) {
            if (z) {
                g();
            } else {
                o0Var.f();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        o0 o0Var = this.k;
        if (o0Var != null) {
            if (i2 == 8) {
                o0Var.f();
            } else {
                g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        if (Math.abs(f2) <= 0.5d) {
            return;
        }
        this.f11121h.a(Math.abs(f2));
        this.f11121h.a(f2 > 0.0f ? 1 : 0);
        this.f11121h.postInvalidate();
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b() {
        super.b();
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.m = null;
        }
        o0 o0Var = this.k;
        if (o0Var != null) {
            o0Var.b();
            this.k = null;
        }
        d();
    }

    @Override // com.tianmu.biz.widget.n.a
    public void a(double d2) {
        this.l = o0.a(d2);
        SwayProgressBar swayProgressBar = this.f11121h;
        if (swayProgressBar != null) {
            swayProgressBar.b(f());
        }
    }
}
