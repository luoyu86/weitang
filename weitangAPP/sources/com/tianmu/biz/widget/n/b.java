package com.tianmu.biz.widget.n;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.biz.utils.l0;
import com.tianmu.biz.widget.n.a;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.o0;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public class b extends com.tianmu.biz.widget.n.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f11115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ObjectAnimator f11116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l0 f11117i;
    private double j;
    private Handler k;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar;
            a.InterfaceC0198a interfaceC0198a;
            if (message.what == 2 && (interfaceC0198a = (bVar = b.this).f11110b) != null) {
                interfaceC0198a.onClick(bVar, 1);
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: renamed from: com.tianmu.biz.widget.n.b$b, reason: collision with other inner class name */
    public class C0199b implements l0.b {
        public C0199b() {
        }

        @Override // com.tianmu.biz.utils.l0.b
        public void a() {
            b.this.f();
        }
    }

    public b(Context context, boolean z, String str) {
        super(context, z);
        this.j = 0.0d;
        this.k = new a(Looper.getMainLooper());
        this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        this.f11114f = str;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Handler handler = this.k;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(2, 100L);
            l0 l0Var = this.f11117i;
            if (l0Var != null) {
                l0Var.d();
            }
        }
    }

    private void g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f11115g, (Property<ImageView, Float>) View.ROTATION, 12.0f, -12.0f, 12.0f);
        this.f11116h = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f11116h.setRepeatCount(-1);
        this.f11116h.setDuration(400L);
        this.f11116h.start();
    }

    private void h() {
        if (this.f11117i == null) {
            this.f11117i = new l0(getContext(), this.j, new C0199b());
        }
        this.f11117i.c();
        g();
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b(boolean z) {
        if (z) {
            this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        } else {
            this.f11113e = 32;
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void c() {
        try {
            this.f11113e = 95;
            ImageView imageView = this.f11115g;
            if (imageView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.width = TianmuDisplayUtil.dp2px(80);
                layoutParams.height = TianmuDisplayUtil.dp2px(80);
                this.f11115g.setLayoutParams(layoutParams);
                this.f11115g.setPadding(TianmuDisplayUtil.dp2px(10), TianmuDisplayUtil.dp2px(10), TianmuDisplayUtil.dp2px(10), 0);
                this.f11115g.setBackground(null);
            }
            TextView textView = this.f11111c;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams2.topMargin = TianmuDisplayUtil.dp2px(2);
                this.f11111c.setLayoutParams(layoutParams2);
                this.f11111c.setTextSize(14.0f);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void d() {
        ObjectAnimator objectAnimator = this.f11116h;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f11116h.end();
        }
        this.f11116h = null;
    }

    public void e() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(o0.f11470a, (ViewGroup) this, true);
        this.f11109a = viewInflate;
        this.f11115g = (ImageView) viewInflate.findViewById(o0.f11471b);
        a(a(1, 0, this.f11114f, c1.f11293a));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l0 l0Var = this.f11117i;
        if (l0Var != null) {
            if (z) {
                l0Var.b();
            } else {
                l0Var.e();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        l0 l0Var = this.f11117i;
        if (l0Var != null) {
            if (i2 == 8) {
                l0Var.e();
            } else {
                l0Var.b();
            }
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void a(double d2) {
        this.j = l0.a(d2);
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b() {
        super.b();
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.k = null;
        }
        l0 l0Var = this.f11117i;
        if (l0Var != null) {
            l0Var.a();
            this.f11117i = null;
        }
        d();
    }
}
