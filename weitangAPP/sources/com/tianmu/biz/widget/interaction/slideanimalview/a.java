package com.tianmu.biz.widget.interaction.slideanimalview;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tianmu.biz.utils.h;
import com.tianmu.biz.utils.z;
import com.tianmu.biz.widget.n.a;
import com.tianmu.c.f.q0;
import com.tianmu.utils.TianmuDisplayUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.tianmu.biz.widget.n.a implements View.OnTouchListener {
    public static final float F = com.tianmu.c.f.a.f11251a;
    private com.tianmu.biz.widget.interaction.slideanimalview.b.a A;
    private ValueAnimator B;
    private View C;
    private View D;
    private ValueAnimator.AnimatorUpdateListener E;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f11037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11038i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashMap<String, Float> f11039q;
    private FrameLayout r;
    private DottedLineView s;
    private ImageView t;
    private TextView u;
    private boolean v;
    private boolean w;
    private View x;
    private int y;
    private int z;

    /* JADX INFO: renamed from: com.tianmu.biz.widget.interaction.slideanimalview.a$a, reason: collision with other inner class name */
    public class C0192a implements TypeEvaluator {
        public C0192a() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f2, Object obj, Object obj2) {
            return a.this.A == null ? h.a(f2, new PointF(a.this.f11038i, a.this.j), new PointF(a.this.k, a.this.l), new PointF(a.this.m, a.this.n)) : h.a(f2, new PointF(a.this.f11038i - a.this.A.c(), a.this.j + a.this.A.d()), new PointF(a.this.k - a.this.A.c(), a.this.l + a.this.A.d()), new PointF(a.this.m - a.this.A.c(), a.this.n + a.this.A.d()));
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (a.this.t != null) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                a.this.t.setX(pointF.x);
                a.this.t.setY(pointF.y);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f11110b != null) {
                a.this.f11110b.onClick(a.this, 2);
            }
        }
    }

    public a(Context context, int i2, int i3, int i4, int i5, View view, boolean z, com.tianmu.biz.widget.interaction.slideanimalview.b.a aVar, String str) {
        super(context, z);
        this.f11037h = new Handler(Looper.getMainLooper());
        this.o = 23;
        this.f11039q = new HashMap<>();
        this.E = new b();
        c(i2);
        b(i3);
        String strA = a(2, 22, str, i4);
        this.p = strA;
        a(strA);
        this.y = i5;
        this.x = view;
        this.A = aVar;
        this.f11114f = str;
        f();
    }

    private boolean n() {
        return true;
    }

    private void o() {
        ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
        layoutParams.width = this.f11036g;
        com.tianmu.biz.widget.interaction.slideanimalview.b.a aVar = this.A;
        if (aVar != null) {
            layoutParams.height = aVar.i() + this.A.f();
        } else {
            layoutParams.height = this.y + this.u.getHeight();
        }
        this.r.setLayoutParams(layoutParams);
        View viewFindViewById = this.C.findViewById(q0.f11494f);
        ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
        com.tianmu.biz.widget.interaction.slideanimalview.b.a aVar2 = this.A;
        if (aVar2 == null || !aVar2.j()) {
            return;
        }
        layoutParams2.width = layoutParams.width - (this.A.e() * 2);
        layoutParams2.height = layoutParams.height;
        viewFindViewById.setLayoutParams(layoutParams2);
        viewFindViewById.setVisibility(0);
    }

    private void p() {
        if (this.o == 23) {
            this.z = 70;
        } else {
            this.z = 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && n()) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void k() {
        try {
            ValueAnimator valueAnimator = this.B;
            if (valueAnimator != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    valueAnimator.resume();
                } else {
                    valueAnimator.start();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void l() {
        if (this.w) {
            m();
            this.w = false;
        }
    }

    public void m() {
        try {
            ValueAnimator valueAnimator = this.B;
            if (valueAnimator != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    valueAnimator.pause();
                } else {
                    valueAnimator.cancel();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f11039q.put("downX", Float.valueOf(x));
            this.f11039q.put("downY", Float.valueOf(y));
            if (n() && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 1) {
            if (action == 2) {
                float fFloatValue = this.f11039q.get("downX").floatValue();
                float fFloatValue2 = this.f11039q.get("downY").floatValue();
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                int i2 = this.o;
                if ((i2 == 22 || i2 == 23) && x2 - fFloatValue > F) {
                    this.v = true;
                } else {
                    a(fFloatValue2, y2);
                    this.v = false;
                }
            }
        } else if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
            float fFloatValue3 = this.f11039q.get("downX").floatValue();
            float fFloatValue4 = this.f11039q.get("downY").floatValue();
            if (Math.abs(fFloatValue3 - motionEvent.getX()) <= 10.0f && Math.abs(fFloatValue4 - motionEvent.getY()) <= 10.0f) {
                if (this.C != null && motionEvent.getX() >= this.C.getLeft() && motionEvent.getX() <= this.C.getRight() && motionEvent.getY() >= this.C.getTop() && motionEvent.getY() <= this.C.getBottom()) {
                    if (this.D != null) {
                        z.a((int) fFloatValue3, (int) fFloatValue4, (int) motionEvent.getX(), (int) motionEvent.getY(), this.D, true);
                    } else {
                        a.InterfaceC0198a interfaceC0198a = this.f11110b;
                        if (interfaceC0198a != null) {
                            interfaceC0198a.onClick(this, 0);
                        }
                    }
                    return true;
                }
                this.v = true;
            }
            if (this.v && this.f11110b != null) {
                this.f11037h.post(new c());
            }
            this.v = false;
            this.f11039q.clear();
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8) {
            l();
        } else if (this.f11036g > 0) {
            j();
        }
    }

    private void a(float f2, float f3) {
        if (f2 - f3 > 80.0f) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (f3 - f2 > 80.0f) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    private void c(int i2) {
        com.tianmu.biz.widget.interaction.slideanimalview.b.a aVar = this.A;
        if (aVar != null) {
            this.f11036g = i2 + aVar.g() + this.A.h();
        } else {
            this.f11036g = i2;
        }
    }

    public void b(int i2) {
        if (i2 != 23 && i2 != 22) {
            i2 = 22;
        }
        this.o = i2;
        p();
    }

    public void e() {
        View view = this.x;
        if (view != null) {
            view.setOnTouchListener(null);
        } else {
            setOnTouchListener(null);
        }
    }

    public void f() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(q0.f11489a, (ViewGroup) this, true);
        this.C = viewInflate;
        this.r = (FrameLayout) viewInflate.findViewById(q0.f11490b);
        ImageView imageView = (ImageView) this.C.findViewById(q0.f11491c);
        this.t = imageView;
        if (this.A != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.A.b();
            layoutParams.height = this.A.a();
            this.t.setLayoutParams(layoutParams);
        }
        this.s = (DottedLineView) this.C.findViewById(q0.f11492d);
        TextView textView = (TextView) this.C.findViewById(q0.f11493e);
        this.u = textView;
        textView.setText(TextUtils.isEmpty(this.p) ? "滑动了解更多" : this.p);
        if (this.f11112d) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        a(this.x);
        g();
        i();
        o();
    }

    public void g() {
        com.tianmu.biz.widget.interaction.slideanimalview.b.a aVar = this.A;
        if (aVar != null) {
            this.f11038i = aVar.g();
            this.j = this.A.i();
            this.m = this.f11036g - this.A.h();
            this.n = this.A.i();
            int i2 = this.m;
            int i3 = this.f11038i;
            this.k = ((i2 - i3) / 2) + i3;
            this.l = this.z + this.A.i();
        }
        DottedLineView dottedLineView = this.s;
        if (dottedLineView != null) {
            dottedLineView.a(this.o, this.f11038i, this.j, this.k, this.l, this.m, this.n);
        }
        if (this.B == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.B = valueAnimator;
            valueAnimator.setDuration(1500L);
            this.B.setObjectValues(new PointF(0.0f, 0.0f));
            this.B.setRepeatCount(-1);
            this.B.setInterpolator(new AccelerateDecelerateInterpolator());
            this.B.addUpdateListener(this.E);
            this.B.setEvaluator(new C0192a());
            this.B.start();
        }
    }

    public void h() {
        View view = this.x;
        if (view != null) {
            view.setOnTouchListener(this);
        } else {
            setOnTouchListener(this);
        }
    }

    public void i() {
        if (this.u != null) {
            int i2 = this.o;
            if (i2 == 23) {
                if (this.y == 0) {
                    int iDp2px = TianmuDisplayUtil.dp2px(30);
                    com.tianmu.biz.widget.interaction.slideanimalview.b.a aVar = this.A;
                    this.y = iDp2px + (aVar != null ? aVar.i() : 0);
                }
            } else if (i2 == 22 && this.y == 0) {
                int iDp2px2 = TianmuDisplayUtil.dp2px(18);
                com.tianmu.biz.widget.interaction.slideanimalview.b.a aVar2 = this.A;
                this.y = iDp2px2 + (aVar2 != null ? aVar2.i() : 0);
            }
            this.u.setY(this.y);
        }
    }

    public void j() {
        if (this.w) {
            return;
        }
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        k();
        this.w = true;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this);
        } else {
            setOnTouchListener(this);
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b() {
        m();
        ValueAnimator valueAnimator = this.B;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.B = null;
        }
        this.E = null;
        HashMap<String, Float> map = this.f11039q;
        if (map != null) {
            map.clear();
            this.f11039q = null;
        }
        DottedLineView dottedLineView = this.s;
        if (dottedLineView != null) {
            dottedLineView.a();
            this.s = null;
        }
        Handler handler = this.f11037h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11037h = null;
        }
    }

    public void b(String str) {
        TextView textView = this.u;
        if (textView != null) {
            textView.setTextColor(Color.parseColor(str));
        }
    }
}
