package com.tianmu.j.b.a;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.j.b.a.f;
import com.tianmu.j.b.c.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends FrameLayout implements d, f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tianmu.j.b.a.b f12261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Activity f12262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f12266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f12268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12269i;
    private boolean j;
    public LinkedHashMap<com.tianmu.j.b.a.c, Boolean> k;
    private Animation l;
    private Animation m;
    public final Runnable n;
    public Runnable o;
    private int p;

    /* JADX INFO: renamed from: com.tianmu.j.b.a.a$a, reason: collision with other inner class name */
    public class RunnableC0228a implements Runnable {
        public RunnableC0228a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iK = a.this.k();
            if (!a.this.f12261a.e()) {
                a.this.j = false;
            } else {
                a aVar = a.this;
                aVar.postDelayed(this, (long) ((1000 - (iK % 1000)) / aVar.f12261a.d()));
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f12266f.enable();
        }
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.k = new LinkedHashMap<>();
        this.n = new RunnableC0228a();
        this.o = new b();
        this.p = 0;
        e();
    }

    private void j() {
        if (this.f12267g) {
            Activity activity = this.f12262b;
            if (activity != null && this.f12268h == null) {
                Boolean boolValueOf = Boolean.valueOf(com.tianmu.j.b.e.a.a(activity));
                this.f12268h = boolValueOf;
                if (boolValueOf.booleanValue()) {
                    this.f12269i = (int) com.tianmu.j.b.e.b.b(this.f12262b);
                }
            }
            com.tianmu.j.b.e.c.a("hasCutout: " + this.f12268h + " cutout height: " + this.f12269i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        int iJ = (int) this.f12261a.j();
        b((int) this.f12261a.h(), iJ);
        return iJ;
    }

    public abstract void a(int i2, int i3);

    public abstract void a(boolean z, Animation animation);

    @Override // com.tianmu.j.b.a.d
    public void b() {
        if (this.j) {
            return;
        }
        post(this.o);
        this.j = true;
    }

    public abstract int c();

    public void c(Activity activity) {
        activity.setRequestedOrientation(8);
        if (this.f12261a.i()) {
            g(11);
        } else {
            this.f12261a.c();
        }
    }

    @CallSuper
    public void d(int i2) {
        f(i2);
    }

    public void e() {
        if (c() != 0) {
            LayoutInflater.from(getContext()).inflate(c(), (ViewGroup) this, true);
        }
        this.f12266f = new f(getContext().getApplicationContext());
        this.f12265e = k.b().f12307b;
        this.f12267g = k.b().f12314i;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.l = alphaAnimation;
        alphaAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.m = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f12262b = com.tianmu.j.b.e.b.c(getContext());
    }

    @Override // com.tianmu.j.b.a.d
    public void f() {
        if (this.j) {
            removeCallbacks(this.o);
            this.j = false;
        }
    }

    public void g() {
        Iterator<Map.Entry<com.tianmu.j.b.a.c, Boolean>> it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                it.remove();
            }
        }
    }

    public boolean h() {
        return com.tianmu.j.b.e.b.a(getContext()) == 4 && !k.c().a();
    }

    public void i() {
        removeCallbacks(this.n);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f12261a.e()) {
            if (this.f12265e || this.f12261a.i()) {
                if (z) {
                    postDelayed(new c(), 800L);
                } else {
                    this.f12266f.disable();
                }
            }
        }
    }

    public void d() {
        if (this.f12263c) {
            i();
            b(false, this.m);
            this.f12263c = false;
        }
    }

    @CallSuper
    public void a(e eVar) {
        this.f12261a = new com.tianmu.j.b.a.b(eVar, this);
        Iterator<Map.Entry<com.tianmu.j.b.a.c, Boolean>> it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().a(this.f12261a);
        }
        this.f12266f.a(this);
    }

    private void f(int i2) {
        Iterator<Map.Entry<com.tianmu.j.b.a.c, Boolean>> it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().a(i2);
        }
        b(i2);
    }

    public void b(Activity activity) {
        if (!this.f12264d && this.f12265e) {
            activity.setRequestedOrientation(1);
            this.f12261a.k();
        }
    }

    @CallSuper
    public void c(int i2) {
        switch (i2) {
            case 10:
                if (this.f12265e) {
                    this.f12266f.enable();
                } else {
                    this.f12266f.disable();
                }
                if (a()) {
                    com.tianmu.j.b.e.a.a(getContext(), false);
                }
                break;
            case 11:
                this.f12266f.enable();
                if (a()) {
                    com.tianmu.j.b.e.a.a(getContext(), true);
                }
                break;
            case 12:
                this.f12266f.disable();
                break;
        }
    }

    private void g(int i2) {
        Iterator<Map.Entry<com.tianmu.j.b.a.c, Boolean>> it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().b(i2);
        }
        c(i2);
    }

    private void b(boolean z, Animation animation) {
        if (!this.f12264d) {
            Iterator<Map.Entry<com.tianmu.j.b.a.c, Boolean>> it = this.k.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().a(z, animation);
            }
        }
        a(z, animation);
    }

    public void a(com.tianmu.j.b.a.c... cVarArr) {
        for (com.tianmu.j.b.a.c cVar : cVarArr) {
            a(cVar, false);
        }
    }

    public void a(com.tianmu.j.b.a.c cVar, boolean z) {
        this.k.put(cVar, Boolean.valueOf(z));
        com.tianmu.j.b.a.b bVar = this.f12261a;
        if (bVar != null) {
            cVar.a(bVar);
        }
        View viewA = cVar.a();
        if (viewA == null || z) {
            return;
        }
        addView(viewA, 0);
    }

    @CallSuper
    public void e(int i2) {
        g(i2);
    }

    @CallSuper
    public void b(int i2) {
        if (i2 == -1) {
            this.f12263c = false;
            return;
        }
        if (i2 != 0) {
            if (i2 != 5) {
                return;
            }
            this.f12264d = false;
            this.f12263c = false;
            return;
        }
        this.f12266f.disable();
        this.p = 0;
        this.f12264d = false;
        this.f12263c = false;
        g();
    }

    @Override // com.tianmu.j.b.a.d
    public boolean a() {
        Boolean bool = this.f12268h;
        return bool != null && bool.booleanValue();
    }

    public void a(boolean z) {
        this.f12265e = z;
    }

    @Override // com.tianmu.j.b.a.f.a
    @CallSuper
    public void a(int i2) {
        Activity activity = this.f12262b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        int i3 = this.p;
        if (i2 == -1) {
            this.p = -1;
            return;
        }
        if (i2 > 350 || i2 < 10) {
            if ((this.f12262b.getRequestedOrientation() == 0 && i3 == 0) || this.p == 0) {
                return;
            }
            this.p = 0;
            b(this.f12262b);
            return;
        }
        if (i2 > 80 && i2 < 100) {
            if ((this.f12262b.getRequestedOrientation() == 1 && i3 == 90) || this.p == 90) {
                return;
            }
            this.p = 90;
            c(this.f12262b);
            return;
        }
        if (i2 <= 260 || i2 >= 280) {
            return;
        }
        if ((this.f12262b.getRequestedOrientation() == 1 && i3 == 270) || this.p == 270) {
            return;
        }
        this.p = 270;
        a(this.f12262b);
    }

    private void b(int i2, int i3) {
        Iterator<Map.Entry<com.tianmu.j.b.a.c, Boolean>> it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().a(i2, i3);
        }
        a(i2, i3);
    }

    public void a(Activity activity) {
        activity.setRequestedOrientation(0);
        if (this.f12261a.i()) {
            g(11);
        } else {
            this.f12261a.c();
        }
    }
}
