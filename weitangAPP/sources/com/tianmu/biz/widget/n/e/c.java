package com.tianmu.biz.widget.n.e;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.biz.widget.n.a;
import com.tianmu.biz.widget.shimmer.ShimmerFrameLayout;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.t0;
import com.tianmu.utils.TianmuDisplayUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.tianmu.biz.widget.n.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f11137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ShimmerFrameLayout f11138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TranslateAnimation f11139i;
    public float j;
    public int k;
    private boolean l;
    private boolean m;
    public HashMap<String, Float> n;
    private boolean o;
    private Handler p;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: com.tianmu.biz.widget.n.e.c$a$a, reason: collision with other inner class name */
        public class RunnableC0201a implements Runnable {
            public RunnableC0201a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.l) {
                    return;
                }
                c.this.g();
            }
        }

        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.l) {
                return;
            }
            c.this.d();
            if (c.this.p != null) {
                c.this.p.postDelayed(new RunnableC0201a(), 1000L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f11142a;

        public b(boolean z) {
            this.f11142a = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.n == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                c.this.n.put("downX", Float.valueOf(x));
                c.this.n.put("downY", Float.valueOf(y));
            }
            if (motionEvent.getAction() == 1) {
                float fFloatValue = c.this.n.get("downX").floatValue();
                float fFloatValue2 = c.this.n.get("downY").floatValue();
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                c cVar = c.this;
                int i2 = cVar.k;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 5 && (Math.abs(x2 - fFloatValue) >= c.this.j || Math.abs(y2 - fFloatValue2) >= c.this.j)) {
                                    c.this.f();
                                }
                            } else if (x2 - fFloatValue >= cVar.j) {
                                cVar.f();
                            }
                        } else if (fFloatValue - x2 >= cVar.j) {
                            cVar.f();
                        }
                    } else if (y2 - fFloatValue2 >= cVar.j) {
                        cVar.f();
                    }
                } else if (fFloatValue2 - y2 >= cVar.j) {
                    cVar.f();
                }
                if (this.f11142a && fFloatValue == x2 && fFloatValue2 == y2) {
                    c.this.f();
                }
            }
            return false;
        }
    }

    public c(Context context, boolean z, boolean z2) {
        super(context, z2);
        this.j = com.tianmu.c.f.a.f11251a;
        this.k = 1;
        this.n = new HashMap<>();
        this.p = new Handler();
        this.o = z;
        this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        e();
    }

    private void h() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, TianmuDisplayUtil.dp2px(110), 0.0f);
        this.f11139i = translateAnimation;
        translateAnimation.setDuration(800L);
        this.f11139i.setAnimationListener(new a());
    }

    @Override // com.tianmu.biz.widget.n.a
    public void d() {
        if (this.m) {
            this.m = false;
            View view = this.f11137g;
            if (view != null) {
                view.setVisibility(8);
            }
            ShimmerFrameLayout shimmerFrameLayout = this.f11138h;
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.setVisibility(4);
                this.f11138h.b();
            }
        }
    }

    public void e() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(t0.f11517a, (ViewGroup) this, true);
        this.f11109a = viewInflate;
        this.f11137g = viewInflate.findViewById(t0.f11518b);
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f11109a.findViewById(t0.f11519c);
        this.f11138h = shimmerFrameLayout;
        if (this.o) {
            ViewGroup.LayoutParams layoutParams = shimmerFrameLayout.getLayoutParams();
            layoutParams.width = TianmuDisplayUtil.dp2px(35);
            layoutParams.height = TianmuDisplayUtil.dp2px(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL);
            this.f11138h.setLayoutParams(layoutParams);
            View viewFindViewById = this.f11109a.findViewById(t0.f11520d);
            ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
            layoutParams2.height = TianmuDisplayUtil.dp2px(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL);
            viewFindViewById.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.f11137g.getLayoutParams();
            layoutParams3.width = TianmuDisplayUtil.dp2px(70);
            layoutParams3.height = TianmuDisplayUtil.dp2px(70);
            this.f11137g.setLayoutParams(layoutParams3);
        }
        a(a(2, 21, this.f11114f, c1.f11294b));
        h();
    }

    public void f() {
        a.InterfaceC0198a interfaceC0198a = this.f11110b;
        if (interfaceC0198a != null) {
            interfaceC0198a.onClick(this, 2);
        }
        d();
    }

    public void g() {
        if (this.m) {
            return;
        }
        this.m = true;
        View view = this.f11137g;
        if (view != null && this.f11139i != null) {
            view.setVisibility(0);
            this.f11137g.startAnimation(this.f11139i);
        }
        ShimmerFrameLayout shimmerFrameLayout = this.f11138h;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.setVisibility(0);
            this.f11138h.a();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.l = false;
            g();
        } else {
            this.l = true;
            d();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8) {
            this.l = true;
            d();
        } else {
            this.l = false;
            g();
        }
    }

    public void a(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setClickable(true);
        view.setOnTouchListener(new b(z));
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b(boolean z) {
        if (z) {
            this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        } else {
            this.f11113e = 32;
        }
    }

    public void a(View view) {
        if (view != null) {
            view.setClickable(false);
            view.setOnTouchListener(null);
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b() {
        super.b();
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.p = null;
        }
        TranslateAnimation translateAnimation = this.f11139i;
        if (translateAnimation != null) {
            translateAnimation.cancel();
            this.f11139i = null;
        }
        HashMap<String, Float> map = this.n;
        if (map != null) {
            map.clear();
            this.n = null;
        }
    }

    public c(Context context, boolean z, boolean z2, String str) {
        super(context, z2);
        this.j = com.tianmu.c.f.a.f11251a;
        this.k = 1;
        this.n = new HashMap<>();
        this.p = new Handler();
        this.o = z;
        this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        this.f11114f = str;
        e();
    }

    public void b(int i2) {
        this.k = i2;
    }
}
