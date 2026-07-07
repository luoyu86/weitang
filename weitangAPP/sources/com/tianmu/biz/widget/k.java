package com.tianmu.biz.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tianmu.biz.utils.v;
import com.tianmu.biz.widget.n.a;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.u0;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuLogUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class k extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f11052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObjectAnimator f11053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f11055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f11056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageView f11057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f11058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<String, Float> f11059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f11060i;
    public a.InterfaceC0198a j;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: com.tianmu.biz.widget.k$a$a, reason: collision with other inner class name */
        public class RunnableC0193a implements Runnable {
            public RunnableC0193a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (k.this.f11053b == null || k.this.f11053b.isRunning()) {
                    return;
                }
                k.this.f11053b.start();
            }
        }

        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            k.this.f11056e.postDelayed(new RunnableC0193a(), 500L);
        }
    }

    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f11063a;

        public b(boolean z) {
            this.f11063a = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                k.this.f11059h.put("downX", Float.valueOf(x));
                k.this.f11059h.put("downY", Float.valueOf(y));
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            float fFloatValue = k.this.f11059h.get("downX").floatValue();
            float fFloatValue2 = k.this.f11059h.get("downY").floatValue();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (fFloatValue2 - y2 >= k.this.f11060i) {
                k.this.d();
            }
            if (!this.f11063a || fFloatValue != x2 || fFloatValue2 != y2) {
                return false;
            }
            k.this.d();
            return false;
        }
    }

    public k(Context context) {
        super(context);
        this.f11054c = 800L;
        this.f11056e = new Handler(Looper.getMainLooper());
        this.f11059h = new HashMap<>();
        this.f11060i = com.tianmu.c.f.a.f11251a;
        a();
    }

    private void e() {
        ObjectAnimator objectAnimator = this.f11053b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f11053b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a.InterfaceC0198a interfaceC0198a = this.j;
        if (interfaceC0198a != null) {
            interfaceC0198a.onClick(this, 2);
        }
        e();
    }

    public void a() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(u0.f11522a, (ViewGroup) this, false);
        this.f11052a = viewInflate;
        this.f11057f = (ImageView) viewInflate.findViewById(u0.f11523b);
        addView(this.f11052a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = TianmuDisplayUtil.dp2px(104);
        TextView textView = new TextView(getContext());
        this.f11058g = textView;
        textView.setTextColor(-1);
        this.f11058g.setTextSize(14.0f);
        this.f11058g.setLayoutParams(layoutParams);
        this.f11058g.setText(v.a(getContext(), 2, 21, "splash", c1.f11294b));
        this.f11058g.setVisibility(8);
        addView(this.f11058g);
    }

    public void b() {
        TianmuLogUtil.iD("splash arc view release");
        e();
        Handler handler = this.f11056e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11056e = null;
        }
    }

    public void c() {
        if (this.f11053b != null) {
            b();
        }
        View view = this.f11052a;
        if (view == null) {
            return;
        }
        view.setTranslationY(this.f11055d);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f11052a, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, this.f11055d, 0.0f);
        this.f11053b = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(this.f11054c);
        this.f11053b.setInterpolator(new LinearInterpolator());
        this.f11053b.addListener(new a());
        this.f11053b.start();
    }

    public void a(long j) {
        this.f11055d = j;
    }

    public void a(int i2) {
        ImageView imageView = this.f11057f;
        if (imageView != null) {
            imageView.setVisibility(i2);
        }
        TextView textView = this.f11058g;
        if (textView != null) {
            textView.setVisibility(i2);
        }
    }

    public void a(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.setClickable(true);
        viewGroup.setOnTouchListener(new b(z));
    }

    public void a(a.InterfaceC0198a interfaceC0198a) {
        this.j = interfaceC0198a;
    }
}
