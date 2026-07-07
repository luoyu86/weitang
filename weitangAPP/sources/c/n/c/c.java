package c.n.c;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.app.FrameMetricsAggregator;
import c.n.a.a;
import c.n.a.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class c extends c.n.c.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f2926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2927c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Interpolator f2931g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2928d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2929e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2930f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2932h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a.InterfaceC0045a f2933i = null;
    public b j = new b(this, null);
    public ArrayList<C0048c> k = new ArrayList<>();
    public Runnable l = new a();
    public HashMap<c.n.a.a, d> m = new HashMap<>();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.l();
        }
    }

    public class b implements a.InterfaceC0045a, l.g {
        public b() {
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationCancel(c.n.a.a aVar) {
            if (c.this.f2933i != null) {
                c.this.f2933i.onAnimationCancel(aVar);
            }
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationEnd(c.n.a.a aVar) {
            if (c.this.f2933i != null) {
                c.this.f2933i.onAnimationEnd(aVar);
            }
            c.this.m.remove(aVar);
            if (c.this.m.isEmpty()) {
                c.this.f2933i = null;
            }
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationRepeat(c.n.a.a aVar) {
            if (c.this.f2933i != null) {
                c.this.f2933i.onAnimationRepeat(aVar);
            }
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationStart(c.n.a.a aVar) {
            if (c.this.f2933i != null) {
                c.this.f2933i.onAnimationStart(aVar);
            }
        }

        @Override // c.n.a.l.g
        public void onAnimationUpdate(l lVar) {
            View view;
            float animatedFraction = lVar.getAnimatedFraction();
            d dVar = (d) c.this.m.get(lVar);
            if ((dVar.f2939a & FrameMetricsAggregator.EVERY_DURATION) != 0 && (view = (View) c.this.f2926b.get()) != null) {
                view.invalidate();
            }
            ArrayList<C0048c> arrayList = dVar.f2940b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    C0048c c0048c = arrayList.get(i2);
                    c.this.k(c0048c.f2936a, c0048c.f2937b + (c0048c.f2938c * animatedFraction));
                }
            }
            View view2 = (View) c.this.f2926b.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: c.n.c.c$c, reason: collision with other inner class name */
    public static class C0048c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2938c;

        public C0048c(int i2, float f2, float f3) {
            this.f2936a = i2;
            this.f2937b = f2;
            this.f2938c = f3;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<C0048c> f2940b;

        public d(int i2, ArrayList<C0048c> arrayList) {
            this.f2939a = i2;
            this.f2940b = arrayList;
        }

        public boolean a(int i2) {
            ArrayList<C0048c> arrayList;
            if ((this.f2939a & i2) != 0 && (arrayList = this.f2940b) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.f2940b.get(i3).f2936a == i2) {
                        this.f2940b.remove(i3);
                        this.f2939a = (~i2) & this.f2939a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public c(View view) {
        this.f2926b = new WeakReference<>(view);
    }

    @Override // c.n.c.b
    public c.n.c.b alpha(float f2) {
        g(512, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b alphaBy(float f2) {
        h(512, f2);
        return this;
    }

    @Override // c.n.c.b
    public void cancel() {
        if (this.m.size() > 0) {
            Iterator it = ((HashMap) this.m.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((c.n.a.a) it.next()).cancel();
            }
        }
        this.k.clear();
        View view = this.f2926b.get();
        if (view != null) {
            view.removeCallbacks(this.l);
        }
    }

    public final void g(int i2, float f2) {
        float fJ = j(i2);
        i(i2, fJ, f2 - fJ);
    }

    @Override // c.n.c.b
    public long getDuration() {
        return this.f2928d ? this.f2927c : new l().getDuration();
    }

    @Override // c.n.c.b
    public long getStartDelay() {
        if (this.f2930f) {
            return this.f2929e;
        }
        return 0L;
    }

    public final void h(int i2, float f2) {
        i(i2, j(i2), f2);
    }

    public final void i(int i2, float f2, float f3) {
        if (this.m.size() > 0) {
            c.n.a.a aVar = null;
            Iterator<c.n.a.a> it = this.m.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.n.a.a next = it.next();
                d dVar = this.m.get(next);
                if (dVar.a(i2) && dVar.f2939a == 0) {
                    aVar = next;
                    break;
                }
            }
            if (aVar != null) {
                aVar.cancel();
            }
        }
        this.k.add(new C0048c(i2, f2, f3));
        View view = this.f2926b.get();
        if (view != null) {
            view.removeCallbacks(this.l);
            view.post(this.l);
        }
    }

    public final float j(int i2) {
        View view = this.f2926b.get();
        if (view == null) {
            return 0.0f;
        }
        if (i2 == 1) {
            return view.getTranslationX();
        }
        if (i2 == 2) {
            return view.getTranslationY();
        }
        if (i2 == 4) {
            return view.getScaleX();
        }
        if (i2 == 8) {
            return view.getScaleY();
        }
        if (i2 == 16) {
            return view.getRotation();
        }
        if (i2 == 32) {
            return view.getRotationX();
        }
        if (i2 == 64) {
            return view.getRotationY();
        }
        if (i2 == 128) {
            return view.getX();
        }
        if (i2 == 256) {
            return view.getY();
        }
        if (i2 != 512) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    public final void k(int i2, float f2) {
        View view = this.f2926b.get();
        if (view != null) {
            if (i2 == 1) {
                view.setTranslationX(f2);
                return;
            }
            if (i2 == 2) {
                view.setTranslationY(f2);
                return;
            }
            if (i2 == 4) {
                view.setScaleX(f2);
                return;
            }
            if (i2 == 8) {
                view.setScaleY(f2);
                return;
            }
            if (i2 == 16) {
                view.setRotation(f2);
                return;
            }
            if (i2 == 32) {
                view.setRotationX(f2);
                return;
            }
            if (i2 == 64) {
                view.setRotationY(f2);
                return;
            }
            if (i2 == 128) {
                view.setX(f2);
            } else if (i2 == 256) {
                view.setY(f2);
            } else {
                if (i2 != 512) {
                    return;
                }
                view.setAlpha(f2);
            }
        }
    }

    public final void l() {
        l lVarOfFloat = l.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.k.clone();
        this.k.clear();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 |= ((C0048c) arrayList.get(i3)).f2936a;
        }
        this.m.put(lVarOfFloat, new d(i2, arrayList));
        lVarOfFloat.addUpdateListener(this.j);
        lVarOfFloat.addListener(this.j);
        if (this.f2930f) {
            lVarOfFloat.setStartDelay(this.f2929e);
        }
        if (this.f2928d) {
            lVarOfFloat.setDuration(this.f2927c);
        }
        if (this.f2932h) {
            lVarOfFloat.setInterpolator(this.f2931g);
        }
        lVarOfFloat.start();
    }

    @Override // c.n.c.b
    public c.n.c.b rotation(float f2) {
        g(16, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b rotationBy(float f2) {
        h(16, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b rotationX(float f2) {
        g(32, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b rotationXBy(float f2) {
        h(32, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b rotationY(float f2) {
        g(64, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b rotationYBy(float f2) {
        h(64, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b scaleX(float f2) {
        g(4, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b scaleXBy(float f2) {
        h(4, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b scaleY(float f2) {
        g(8, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b scaleYBy(float f2) {
        h(8, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b setDuration(long j) {
        if (j >= 0) {
            this.f2928d = true;
            this.f2927c = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // c.n.c.b
    public c.n.c.b setInterpolator(Interpolator interpolator) {
        this.f2932h = true;
        this.f2931g = interpolator;
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b setListener(a.InterfaceC0045a interfaceC0045a) {
        this.f2933i = interfaceC0045a;
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b setStartDelay(long j) {
        if (j >= 0) {
            this.f2930f = true;
            this.f2929e = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // c.n.c.b
    public void start() {
        l();
    }

    @Override // c.n.c.b
    public c.n.c.b translationX(float f2) {
        g(1, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b translationXBy(float f2) {
        h(1, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b translationY(float f2) {
        g(2, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b translationYBy(float f2) {
        h(2, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b x(float f2) {
        g(128, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b xBy(float f2) {
        h(128, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b y(float f2) {
        g(256, f2);
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b yBy(float f2) {
        h(256, f2);
        return this;
    }
}
