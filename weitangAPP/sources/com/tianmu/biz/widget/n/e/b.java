package com.tianmu.biz.widget.n.e;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.biz.utils.l0;
import com.tianmu.biz.utils.o0;
import com.tianmu.c.f.s0;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.tianmu.biz.widget.n.e.c {
    private boolean A;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f11132q;
    private ImageView r;
    private int s;
    private int t;
    private int u;
    private int v;
    private AnimatorSet w;
    private l0 x;
    private o0 y;
    private Handler z;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 2) {
                if (i2 == 3 && b.this.f11110b != null) {
                    b.this.f11110b.onClick(b.this, 5);
                }
            } else if (b.this.f11110b != null) {
                b.this.f11110b.onClick(b.this, 1);
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: renamed from: com.tianmu.biz.widget.n.e.b$b, reason: collision with other inner class name */
    public class ViewOnTouchListenerC0200b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f11134a;

        public ViewOnTouchListenerC0200b(boolean z) {
            this.f11134a = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.n == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                if (b.this.h() && b.this.getParent() != null) {
                    b.this.getParent().requestDisallowInterceptTouchEvent(true);
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                b.this.n.put("downX", Float.valueOf(x));
                b.this.n.put("downY", Float.valueOf(y));
            }
            if (motionEvent.getAction() == 1) {
                if (b.this.getParent() != null) {
                    b.this.getParent().requestDisallowInterceptTouchEvent(false);
                }
                float fFloatValue = b.this.n.get("downX").floatValue();
                float fFloatValue2 = b.this.n.get("downY").floatValue();
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (Math.abs(fFloatValue2 - y2) >= b.this.j || Math.abs(fFloatValue - x2) >= b.this.j) {
                    b.this.f();
                }
                if (this.f11134a && fFloatValue == x2 && fFloatValue2 == y2) {
                    b.this.f();
                }
            }
            return false;
        }
    }

    public class c implements l0.b {
        public c() {
        }

        @Override // com.tianmu.biz.utils.l0.b
        public void a() {
            b.this.d(2);
        }
    }

    public b(Context context, boolean z, String str) {
        super(context, false, z);
        this.s = TianmuDisplayUtil.dp2px(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME);
        this.t = TianmuDisplayUtil.dp2px(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME);
        this.u = TianmuDisplayUtil.dp2px(27);
        this.v = TianmuDisplayUtil.dp2px(27);
        this.z = new a(Looper.getMainLooper());
        this.f11114f = str;
        b(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.A;
    }

    @Override // com.tianmu.biz.widget.n.e.c
    public void g() {
        if (this.w == null) {
            ImageView imageView = this.r;
            float f2 = this.s / 2;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", f2, f2, r3 - this.u);
            ImageView imageView2 = this.r;
            float f3 = this.t / 2;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "translationY", this.v / 2, f3, f3);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat2.setRepeatCount(-1);
            objectAnimatorOfFloat.setRepeatMode(2);
            objectAnimatorOfFloat2.setRepeatMode(2);
            AnimatorSet animatorSet = new AnimatorSet();
            this.w = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.w.setDuration(2000L);
        }
        this.w.start();
    }

    @Override // com.tianmu.biz.widget.n.e.c, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l0 l0Var = this.x;
        if (l0Var != null) {
            if (z) {
                l0Var.b();
            } else {
                l0Var.e();
            }
        }
    }

    @Override // com.tianmu.biz.widget.n.e.c, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        l0 l0Var = this.x;
        if (l0Var != null) {
            if (i2 == 8) {
                l0Var.e();
            } else {
                l0Var.b();
            }
        }
    }

    public void b(String str) {
        if (str != null) {
            a(str);
        }
    }

    public void c(int i2) {
        if (i2 > 0) {
            TextView textView = (TextView) this.f11109a.findViewById(s0.f11514d);
            Drawable drawable = getResources().getDrawable(i2);
            drawable.setBounds(0, 0, TianmuDisplayUtil.dp2px(20), TianmuDisplayUtil.dp2px(20));
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setCompoundDrawablePadding(TianmuDisplayUtil.dp2px(10));
        }
    }

    @Override // com.tianmu.biz.widget.n.e.c, com.tianmu.biz.widget.n.a
    public void d() {
        super.d();
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.tianmu.biz.widget.n.e.c
    public void e() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(s0.f11511a, (ViewGroup) this, true);
        this.f11109a = viewInflate;
        this.f11132q = (ImageView) viewInflate.findViewById(s0.f11512b);
        this.r = (ImageView) this.f11109a.findViewById(s0.f11513c);
    }

    public void a(int i2, int i3) {
        this.s = i2;
        this.t = i3;
        ImageView imageView = this.f11132q;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.s;
            layoutParams.height = this.t;
            this.f11132q.setLayoutParams(layoutParams);
        }
    }

    public void b(int i2, int i3) {
        this.u = i2;
        this.v = i3;
        ImageView imageView = this.r;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.u;
            layoutParams.height = this.v;
            this.r.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        Handler handler = this.z;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(i2, 100L);
            l0 l0Var = this.x;
            if (l0Var != null) {
                l0Var.d();
            }
            o0 o0Var = this.y;
            if (o0Var != null) {
                o0Var.e();
            }
        }
    }

    public void c(boolean z) {
        this.A = z;
    }

    @Override // com.tianmu.biz.widget.n.e.c
    public void a(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setClickable(true);
        view.setOnTouchListener(new ViewOnTouchListenerC0200b(z));
    }

    @Override // com.tianmu.biz.widget.n.e.c, com.tianmu.biz.widget.n.a
    public void b() {
        super.b();
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.clearAnimation();
            this.r = null;
        }
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.w = null;
        }
        l0 l0Var = this.x;
        if (l0Var != null) {
            l0Var.a();
            this.x = null;
        }
    }

    public void b(double d2) {
        l0 l0Var = new l0(getContext(), l0.a(d2), new c());
        this.x = l0Var;
        l0Var.c();
    }
}
