package com.tianmu.biz.widget.o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tianmu.g.b0;
import com.tianmu.g.r;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuViewUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<com.tianmu.biz.widget.o.b> f11152i;
    private com.tianmu.c.l.c j;
    private long k;
    private List<String> l;
    private List<Bitmap> m;
    private int n;
    private double o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RelativeLayout f11153q;
    private ObjectAnimator r;

    /* JADX INFO: renamed from: com.tianmu.biz.widget.o.a$a, reason: collision with other inner class name */
    public class C0202a extends com.tianmu.c.l.a {
        public C0202a() {
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            if (a.this.j != null) {
                a.this.j.onClick(view, 999);
                a.this.b();
            }
        }
    }

    public class b implements b0 {
        public b() {
        }

        @Override // com.tianmu.g.b0
        public void onBitmapFailed(Drawable drawable) {
            if (a.this.p) {
                return;
            }
            a.c(a.this);
            a.this.a();
        }

        @Override // com.tianmu.g.b0
        public void onBitmapLoaded(Bitmap bitmap, r.e eVar) {
            if (a.this.p) {
                return;
            }
            a.c(a.this);
            if (a.this.m == null) {
                a.this.m = new ArrayList();
            }
            a.this.m.add(bitmap);
            a.this.a();
        }

        @Override // com.tianmu.g.b0
        public void onPrepareLoad(Drawable drawable) {
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            a.this.b();
        }
    }

    public a(Context context) {
        super(context);
        this.f11150g = 0;
        this.f11151h = 0;
        this.k = 3800L;
        this.o = 0.05d;
        this.p = false;
        this.f11148e = TianmuDisplayUtil.dp2px(88);
        this.f11149f = TianmuDisplayUtil.dp2px(88);
        ArrayList arrayList = new ArrayList();
        this.f11152i = arrayList;
        arrayList.add(new com.tianmu.biz.widget.o.b(0.5d, 0.8d));
        this.f11152i.add(new com.tianmu.biz.widget.o.b(0.9d - this.o, 0.7d));
        this.f11152i.add(new com.tianmu.biz.widget.o.b(this.o + 0.1d, 0.6d));
        this.f11152i.add(new com.tianmu.biz.widget.o.b(0.5d, 0.5d));
        this.f11152i.add(new com.tianmu.biz.widget.o.b(0.9d - this.o, 0.4d));
        this.f11152i.add(new com.tianmu.biz.widget.o.b(this.o + 0.1d, 0.3d));
        this.f11152i.add(new com.tianmu.biz.widget.o.b(0.5d, 0.2d));
        this.f11152i.add(new com.tianmu.biz.widget.o.b(0.9d - this.o, 0.1d));
        this.f11152i.add(new com.tianmu.biz.widget.o.b(this.o + 0.1d, 0.0d));
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.n;
        aVar.n = i2 + 1;
        return i2;
    }

    private boolean e() {
        List<com.tianmu.biz.widget.o.b> list = this.f11152i;
        return (list == null || list.size() == 0) ? false : true;
    }

    private void f() {
        if (this.f11147d) {
            return;
        }
        this.f11147d = true;
        h();
    }

    private void g() {
        for (int i2 = 0; i2 < this.f11152i.size(); i2++) {
            com.tianmu.biz.widget.o.b bVar = this.f11152i.get(i2);
            int iC = (int) (bVar.c() * ((double) this.f11145b));
            if (Math.abs(iC) > this.f11150g) {
                this.f11150g = Math.abs(iC);
            }
            int i3 = this.f11151h;
            if (i3 == 0 || i3 > Math.abs(iC)) {
                this.f11151h = Math.abs(iC);
            }
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.a(imageView);
        }
    }

    private void h() {
        g();
        List<com.tianmu.biz.widget.o.b> list = this.f11152i;
        if (list == null || list.size() == 0) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f11153q = relativeLayout;
        relativeLayout.setX(0.0f);
        this.f11153q.setY(0.0f);
        for (int i2 = 0; i2 < this.f11152i.size(); i2++) {
            com.tianmu.biz.widget.o.b bVar = this.f11152i.get(i2);
            if (bVar.a() != null) {
                this.f11153q.addView(bVar.a(), new RelativeLayout.LayoutParams(this.f11148e, this.f11149f));
                bVar.a().setOnClickListener(new C0202a());
                bVar.a().setX((float) ((((double) this.f11144a) * bVar.b()) - ((double) (this.f11148e / 2))));
                bVar.a().setY(Math.abs((int) (bVar.c() * ((double) this.f11145b))));
            }
        }
        this.f11146c = true;
        List<String> list2 = this.l;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        a();
    }

    private boolean i() {
        return this.n == this.l.size();
    }

    private boolean j() {
        return this.f11146c;
    }

    private void k() {
        List<String> list = this.l;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            r.a(getContext()).a(this.l.get(i2)).a(Bitmap.Config.RGB_565).a().a(this.f11148e, this.f11149f).a(new b());
        }
    }

    private void l() {
        if (d() && e()) {
            for (int i2 = 0; i2 < this.f11152i.size(); i2++) {
                ImageView imageViewA = this.f11152i.get(i2).a();
                List<Bitmap> list = this.m;
                imageViewA.setImageBitmap(list.get(i2 % list.size()));
            }
        }
    }

    private void m() {
        RelativeLayout relativeLayout = this.f11153q;
        if (relativeLayout == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(relativeLayout, (Property<RelativeLayout, Float>) View.TRANSLATION_Y, -(this.f11150g + this.f11149f), (this.f11145b * 2) / 3);
        this.r = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(this.k);
        this.r.setInterpolator(new LinearInterpolator());
        this.r.addListener(new c());
        this.r.start();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f11144a = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f11145b = measuredHeight;
        if (this.f11144a <= 0 || measuredHeight <= 0) {
            return;
        }
        f();
    }

    private boolean d() {
        List<Bitmap> list = this.m;
        return (list == null || list.size() == 0) ? false : true;
    }

    public void b() {
        TianmuLogUtil.iD("rain view release");
        this.p = true;
        c();
        List<com.tianmu.biz.widget.o.b> list = this.f11152i;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.f11152i.size(); i2++) {
                if (this.f11152i.get(i2) != null) {
                    this.f11152i.get(i2).d();
                }
            }
            this.f11152i = null;
        }
        RelativeLayout relativeLayout = this.f11153q;
        if (relativeLayout != null) {
            TianmuViewUtil.removeSelfFromParent(relativeLayout);
        }
        this.m = null;
        this.l = null;
    }

    public void c() {
        ObjectAnimator objectAnimator = this.r;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.r = null;
        }
    }

    public void a(List<String> list) {
        this.l = list;
        k();
    }

    public void a(com.tianmu.c.l.c cVar) {
        this.j = cVar;
    }

    public void a() {
        try {
            if (j() && i() && d() && e()) {
                l();
                m();
                RelativeLayout relativeLayout = this.f11153q;
                if (relativeLayout != null) {
                    addView(relativeLayout, new RelativeLayout.LayoutParams(this.f11144a, this.f11150g + this.f11149f));
                }
            }
        } catch (Exception e2) {
            b();
            e2.printStackTrace();
        }
    }
}
