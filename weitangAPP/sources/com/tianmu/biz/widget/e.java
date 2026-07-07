package com.tianmu.biz.widget;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tianmu.biz.bean.InterstitialStyleBean;
import com.tianmu.biz.widget.n.a;
import com.tianmu.c.f.c1;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f10968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.tianmu.biz.widget.n.a f10969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout.LayoutParams f10970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10976i;
    public double j;
    public boolean k;
    public com.tianmu.biz.widget.interaction.slideanimalview.b.a l;
    public int n;
    public String o;
    public View p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10977q;
    public String r;
    public InterstitialStyleBean s;
    public com.tianmu.c.l.c x;
    public int m = 0;
    public boolean t = true;
    public boolean u = true;
    public boolean v = false;
    public boolean w = false;

    public class a implements a.InterfaceC0198a {
        public a() {
        }

        @Override // com.tianmu.biz.widget.n.a.InterfaceC0198a
        public void onClick(ViewGroup viewGroup, int i2) {
            com.tianmu.c.l.c cVar = e.this.x;
            if (cVar != null) {
                cVar.onClick(viewGroup, i2);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tianmu.c.l.c cVar = e.this.x;
            if (cVar != null) {
                cVar.onClick(view, 0);
            }
        }
    }

    public static class c<T extends e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<T> f10980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private T f10981b;

        public c(Class<T> cls) {
            this.f10980a = cls;
            try {
                this.f10981b = cls.newInstance();
            } catch (Exception unused) {
                throw new IllegalStateException("InteractionView is not initialized.");
            }
        }

        public c a(ViewGroup viewGroup) {
            this.f10981b.f10968a = viewGroup;
            return this;
        }

        public c b(int i2) {
            this.f10981b.f10972e = i2;
            return this;
        }

        public c c(int i2) {
            this.f10981b.f10973f = i2;
            return this;
        }

        public c d(int i2) {
            T t = this.f10981b;
            t.f10974g = i2;
            t.n = i2 / 3;
            return this;
        }

        public c e(int i2) {
            if (i2 > 0) {
                this.f10981b.m = i2;
            }
            return this;
        }

        public c f(boolean z) {
            this.f10981b.u = z;
            return this;
        }

        public c g(int i2) {
            if (i2 > 0) {
                this.f10981b.n = i2;
            }
            return this;
        }

        public c a(String str) {
            this.f10981b.f10971d = str;
            return this;
        }

        public c b(boolean z) {
            this.f10981b.k = z;
            return this;
        }

        public c c(boolean z) {
            this.f10981b.f10976i = z;
            return this;
        }

        public c e(boolean z) {
            this.f10981b.v = z;
            return this;
        }

        public c f(int i2) {
            this.f10981b.f10977q = i2;
            return this;
        }

        public c a(int i2) {
            this.f10981b.f10975h = i2;
            return this;
        }

        public c b(String str) {
            this.f10981b.o = str;
            return this;
        }

        public c c(String str) {
            this.f10981b.r = str;
            return this;
        }

        public c d(boolean z) {
            this.f10981b.t = z;
            return this;
        }

        public c a(com.tianmu.c.l.c cVar) {
            this.f10981b.x = cVar;
            return this;
        }

        public c a(double d2) {
            this.f10981b.j = d2;
            return this;
        }

        public c a(InterstitialStyleBean interstitialStyleBean) {
            this.f10981b.s = interstitialStyleBean;
            return this;
        }

        public c a(View view) {
            this.f10981b.p = view;
            return this;
        }

        public c a(com.tianmu.biz.widget.interaction.slideanimalview.b.a aVar) {
            this.f10981b.l = aVar;
            return this;
        }

        public c a(boolean z) {
            this.f10981b.w = z;
            return this;
        }

        public T a() {
            return this.f10981b;
        }
    }

    public void a() {
        int i2 = this.f10972e;
        if (i2 == 1) {
            d();
        } else if (i2 == 2) {
            e();
            if (this.f10969b != null && !TextUtils.isEmpty(this.o)) {
                com.tianmu.biz.widget.n.a aVar = this.f10969b;
                if (aVar instanceof com.tianmu.biz.widget.interaction.slideanimalview.a) {
                    ((com.tianmu.biz.widget.interaction.slideanimalview.a) aVar).b(this.o);
                }
            }
        } else if (i2 == 3) {
            c();
        } else if (i2 == 5) {
            f();
        } else if (i2 == 6) {
            b();
        }
        com.tianmu.biz.widget.n.a aVar2 = this.f10969b;
        if (aVar2 != null) {
            aVar2.b(this.f10976i);
            this.f10969b.a(this.j);
            this.f10969b.a(j(), Color.parseColor(h()), o(), i(), k());
            this.f10969b.a(this.m);
            if (this.v) {
                this.f10969b.c();
            }
            this.f10969b.a(new a());
            RelativeLayout.LayoutParams customInterstitialLayoutParams = TianmuViewUtil.getCustomInterstitialLayoutParams(-2, -2, TianmuDisplayUtil.dp2px(this.f10969b.a()));
            this.f10970c = customInterstitialLayoutParams;
            this.f10968a.addView(this.f10969b, customInterstitialLayoutParams);
        }
    }

    public void b() {
        com.tianmu.biz.widget.n.e.b bVar = new com.tianmu.biz.widget.n.e.b(this.f10968a.getContext(), n(), this.f10971d);
        this.f10969b = bVar;
        bVar.a((View) this.f10968a, true);
        com.tianmu.biz.widget.n.e.b bVar2 = (com.tianmu.biz.widget.n.e.b) this.f10969b;
        int i2 = this.n;
        bVar2.a(i2, i2);
        if (this.k) {
            ((com.tianmu.biz.widget.n.e.b) this.f10969b).b("滑动或" + this.r);
            return;
        }
        ((com.tianmu.biz.widget.n.e.b) this.f10969b).b(this.j);
        ((com.tianmu.biz.widget.n.e.b) this.f10969b).b("摇一摇或" + this.r);
        ((com.tianmu.biz.widget.n.e.b) this.f10969b).c(com.tianmu.c.f.c.w);
    }

    public void c() {
        a(this.f10968a);
    }

    public void d() {
        if (this.k) {
            return;
        }
        com.tianmu.biz.widget.n.b bVar = new com.tianmu.biz.widget.n.b(this.f10968a.getContext(), n(), this.f10971d);
        this.f10969b = bVar;
        if (this.w) {
            a(bVar);
        }
    }

    public void e() {
        int i2;
        if ("splash".equals(this.f10971d) && ((i2 = this.f10973f) == 22 || i2 == 23)) {
            this.f10973f = 21;
        }
        int i3 = this.f10973f;
        if (i3 == 22 || i3 == 23) {
            if (this.l == null) {
                this.l = new com.tianmu.biz.widget.interaction.slideanimalview.b.a();
            }
            this.f10969b = new com.tianmu.biz.widget.interaction.slideanimalview.a(this.f10968a.getContext(), this.n, this.f10973f, c1.f11300h, 0, this.p, n(), this.l, this.f10971d);
            return;
        }
        if (this.f10977q == com.tianmu.biz.widget.n.e.a.s) {
            this.f10969b = new com.tianmu.biz.widget.n.e.a(this.f10968a.getContext(), this.f10971d);
        } else {
            this.f10969b = new com.tianmu.biz.widget.n.e.c(this.f10968a.getContext(), false, n(), this.f10971d);
        }
        View view = this.p;
        if (view == null) {
            ((com.tianmu.biz.widget.n.e.c) this.f10969b).a(this.f10968a, true);
        } else {
            ((com.tianmu.biz.widget.n.e.c) this.f10969b).a(view, true);
        }
    }

    public void f() {
        if (this.k) {
            return;
        }
        if (this.f10973f == 51) {
            this.f10969b = new com.tianmu.biz.widget.n.c(this.f10968a.getContext(), n(), this.f10971d);
        } else {
            this.f10969b = new com.tianmu.biz.widget.n.d(this.f10968a.getContext(), this.u, n(), this.f10971d);
        }
        if (this.w) {
            a(this.f10969b);
        }
    }

    public RelativeLayout.LayoutParams g() {
        return this.f10970c;
    }

    public String h() {
        InterstitialStyleBean interstitialStyleBean = this.s;
        return interstitialStyleBean != null ? interstitialStyleBean.getTipsColor() : "#ffffff";
    }

    public int i() {
        InterstitialStyleBean interstitialStyleBean = this.s;
        return interstitialStyleBean != null ? TianmuDisplayUtil.dp2px(interstitialStyleBean.getTipsMargin()) : TianmuDisplayUtil.dp2px(8);
    }

    public int j() {
        InterstitialStyleBean interstitialStyleBean = this.s;
        if (interstitialStyleBean != null) {
            return interstitialStyleBean.getTipsSize();
        }
        return 16;
    }

    public Typeface k() {
        InterstitialStyleBean interstitialStyleBean = this.s;
        return interstitialStyleBean != null ? interstitialStyleBean.getTipsStyle() : Typeface.DEFAULT;
    }

    public com.tianmu.biz.widget.n.a l() {
        return this.f10969b;
    }

    public void m() {
    }

    public boolean n() {
        return this.t;
    }

    public boolean o() {
        InterstitialStyleBean interstitialStyleBean = this.s;
        if (interstitialStyleBean != null) {
            return interstitialStyleBean.isShade();
        }
        return true;
    }

    public void p() {
        TianmuLogUtil.iD("InteractionView release");
        com.tianmu.biz.widget.n.a aVar = this.f10969b;
        if (aVar != null) {
            aVar.b();
            this.f10969b = null;
        }
        ViewGroup viewGroup = this.f10968a;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(null);
            this.f10968a.removeAllViews();
            TianmuViewUtil.removeSelfFromParent(this.f10968a);
            this.f10968a = null;
        }
    }

    public void q() {
        a();
    }

    public void r() {
        com.tianmu.biz.widget.n.a aVar = this.f10969b;
        if (aVar != null) {
            aVar.d();
        }
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }
}
