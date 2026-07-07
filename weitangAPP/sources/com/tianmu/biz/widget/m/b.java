package com.tianmu.biz.widget.m;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.biz.utils.v;
import com.tianmu.biz.widget.m.a;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.w;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f11099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RelativeLayout f11100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f11101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f11102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f11103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11105i;
    private String j;
    private com.tianmu.biz.widget.m.a k;
    private ObjectAnimator l;
    private ObjectAnimator m;
    private AnimatorSet n;
    private InterfaceC0197b o;
    private float[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float[] f11106q;

    public class a implements a.InterfaceC0195a {

        /* JADX INFO: renamed from: com.tianmu.biz.widget.m.b$a$a, reason: collision with other inner class name */
        public class RunnableC0196a implements Runnable {
            public RunnableC0196a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f11105i = true;
                b.this.e();
                if (b.this.k != null) {
                    b.this.k.c();
                    b.this.k = null;
                }
            }
        }

        public a() {
        }

        @Override // com.tianmu.biz.widget.m.a.InterfaceC0195a
        public void a() {
        }

        @Override // com.tianmu.biz.widget.m.a.InterfaceC0195a
        public void b() {
            if (b.this.o != null) {
                b.this.o.onClick(b.this);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0196a(), 1000L);
        }

        @Override // com.tianmu.biz.widget.m.a.InterfaceC0195a
        public void c() {
        }
    }

    /* JADX INFO: renamed from: com.tianmu.biz.widget.m.b$b, reason: collision with other inner class name */
    public interface InterfaceC0197b {
        void onClick(ViewGroup viewGroup);
    }

    public b(Context context, String str) {
        super(context);
        this.p = new float[0];
        this.f11106q = new float[0];
        this.j = str;
        f();
    }

    private void d() {
        this.f11104h = false;
        com.tianmu.biz.widget.m.a aVar = this.k;
        if (aVar != null) {
            aVar.c();
            this.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        i();
        RelativeLayout relativeLayout = this.f11100d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            TianmuViewUtil.removeSelfFromParent(this.f11100d);
            this.f11100d = null;
        }
    }

    private void f() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(w.f11527a, (ViewGroup) this, true);
        this.f11099c = (FrameLayout) viewInflate.findViewById(w.f11528b);
        this.f11100d = (RelativeLayout) viewInflate.findViewById(w.f11529c);
        this.f11101e = (ImageView) viewInflate.findViewById(w.f11530d);
        this.f11102f = (TextView) viewInflate.findViewById(w.f11531e);
        this.f11102f.setText(a(4, c1.l));
    }

    private void g() {
        if (this.f11105i || this.f11103g == null || this.f11104h) {
            return;
        }
        this.f11104h = true;
        com.tianmu.biz.widget.m.a aVar = new com.tianmu.biz.widget.m.a(getContext());
        this.k = aVar;
        aVar.a(this.f11103g, this.f11098b, this.f11097a);
        this.k.a(new a());
        this.f11099c.addView(this.k, new FrameLayout.LayoutParams(-1, -1));
    }

    private void h() {
        i();
        RelativeLayout relativeLayout = this.f11100d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        this.l = ObjectAnimator.ofFloat(this.f11101e, "translationX", a());
        this.m = ObjectAnimator.ofFloat(this.f11101e, "translationY", b());
        this.l.setRepeatCount(-1);
        this.m.setRepeatCount(-1);
        this.l.setDuration(3500L);
        this.m.setDuration(3500L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.n = animatorSet;
        animatorSet.playTogether(this.l, this.m);
        this.n.start();
    }

    private void i() {
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8) {
            i();
            d();
        } else if (this.f11097a > 0 || this.f11098b > 0) {
            h();
            g();
        }
    }

    public float[] b() {
        if (this.f11106q.length == 0) {
            float fDp2px = TianmuDisplayUtil.dp2px(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH);
            this.f11106q = new float[]{(1.0f * fDp2px) / 100.0f, (14.0f * fDp2px) / 100.0f, (10.0f * fDp2px) / 100.0f, (29.0f * fDp2px) / 100.0f, (17.0f * fDp2px) / 100.0f, (fDp2px * 35.0f) / 100.0f};
        }
        return this.f11106q;
    }

    public void c() {
        i();
        com.tianmu.biz.widget.m.a aVar = this.k;
        if (aVar != null) {
            aVar.c();
            this.k = null;
        }
        TianmuViewUtil.removeSelfFromParent(this);
    }

    public void a(Bitmap bitmap, int i2, int i3, InterfaceC0197b interfaceC0197b) {
        this.f11098b = i2;
        this.f11097a = i3;
        this.f11103g = bitmap;
        this.o = interfaceC0197b;
        if (this.f11099c == null) {
            return;
        }
        h();
        g();
    }

    public float[] a() {
        if (this.p.length == 0) {
            float fDp2px = TianmuDisplayUtil.dp2px(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME);
            this.p = new float[]{(57.0f * fDp2px) / 100.0f, (12.0f * fDp2px) / 100.0f, (61.0f * fDp2px) / 100.0f, (10.0f * fDp2px) / 100.0f, (66.0f * fDp2px) / 100.0f, (fDp2px * 28.0f) / 100.0f};
        }
        return this.p;
    }

    private String a(int i2, int i3) {
        return v.a(getContext(), i2, 0, this.j, i3);
    }
}
