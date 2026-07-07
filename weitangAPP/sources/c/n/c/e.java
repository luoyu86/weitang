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
public class e extends c.n.c.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.n.c.f.a f2944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<View> f2945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2946d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Interpolator f2950h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2947e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2948f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2949g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2951i = false;
    public a.InterfaceC0045a j = null;
    public b k = new b(this, null);
    public ArrayList<c> l = new ArrayList<>();
    public Runnable m = new a();
    public HashMap<c.n.a.a, d> n = new HashMap<>();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.l();
        }
    }

    public class b implements a.InterfaceC0045a, l.g {
        public b() {
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationCancel(c.n.a.a aVar) {
            if (e.this.j != null) {
                e.this.j.onAnimationCancel(aVar);
            }
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationEnd(c.n.a.a aVar) {
            if (e.this.j != null) {
                e.this.j.onAnimationEnd(aVar);
            }
            e.this.n.remove(aVar);
            if (e.this.n.isEmpty()) {
                e.this.j = null;
            }
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationRepeat(c.n.a.a aVar) {
            if (e.this.j != null) {
                e.this.j.onAnimationRepeat(aVar);
            }
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationStart(c.n.a.a aVar) {
            if (e.this.j != null) {
                e.this.j.onAnimationStart(aVar);
            }
        }

        @Override // c.n.a.l.g
        public void onAnimationUpdate(l lVar) {
            View view;
            float animatedFraction = lVar.getAnimatedFraction();
            d dVar = (d) e.this.n.get(lVar);
            if ((dVar.f2957a & FrameMetricsAggregator.EVERY_DURATION) != 0 && (view = (View) e.this.f2945c.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.f2958b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c cVar = arrayList.get(i2);
                    e.this.k(cVar.f2954a, cVar.f2955b + (cVar.f2956c * animatedFraction));
                }
            }
            View view2 = (View) e.this.f2945c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2956c;

        public c(int i2, float f2, float f3) {
            this.f2954a = i2;
            this.f2955b = f2;
            this.f2956c = f3;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<c> f2958b;

        public d(int i2, ArrayList<c> arrayList) {
            this.f2957a = i2;
            this.f2958b = arrayList;
        }

        public boolean a(int i2) {
            ArrayList<c> arrayList;
            if ((this.f2957a & i2) != 0 && (arrayList = this.f2958b) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.f2958b.get(i3).f2954a == i2) {
                        this.f2958b.remove(i3);
                        this.f2957a = (~i2) & this.f2957a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public e(View view) {
        this.f2945c = new WeakReference<>(view);
        this.f2944b = c.n.c.f.a.wrap(view);
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
        if (this.n.size() > 0) {
            Iterator it = ((HashMap) this.n.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((c.n.a.a) it.next()).cancel();
            }
        }
        this.l.clear();
        View view = this.f2945c.get();
        if (view != null) {
            view.removeCallbacks(this.m);
        }
    }

    public final void g(int i2, float f2) {
        float fJ = j(i2);
        i(i2, fJ, f2 - fJ);
    }

    @Override // c.n.c.b
    public long getDuration() {
        return this.f2947e ? this.f2946d : new l().getDuration();
    }

    @Override // c.n.c.b
    public long getStartDelay() {
        if (this.f2949g) {
            return this.f2948f;
        }
        return 0L;
    }

    public final void h(int i2, float f2) {
        i(i2, j(i2), f2);
    }

    public final void i(int i2, float f2, float f3) {
        if (this.n.size() > 0) {
            c.n.a.a aVar = null;
            Iterator<c.n.a.a> it = this.n.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.n.a.a next = it.next();
                d dVar = this.n.get(next);
                if (dVar.a(i2) && dVar.f2957a == 0) {
                    aVar = next;
                    break;
                }
            }
            if (aVar != null) {
                aVar.cancel();
            }
        }
        this.l.add(new c(i2, f2, f3));
        View view = this.f2945c.get();
        if (view != null) {
            view.removeCallbacks(this.m);
            view.post(this.m);
        }
    }

    public final float j(int i2) {
        if (i2 == 1) {
            return this.f2944b.getTranslationX();
        }
        if (i2 == 2) {
            return this.f2944b.getTranslationY();
        }
        if (i2 == 4) {
            return this.f2944b.getScaleX();
        }
        if (i2 == 8) {
            return this.f2944b.getScaleY();
        }
        if (i2 == 16) {
            return this.f2944b.getRotation();
        }
        if (i2 == 32) {
            return this.f2944b.getRotationX();
        }
        if (i2 == 64) {
            return this.f2944b.getRotationY();
        }
        if (i2 == 128) {
            return this.f2944b.getX();
        }
        if (i2 == 256) {
            return this.f2944b.getY();
        }
        if (i2 != 512) {
            return 0.0f;
        }
        return this.f2944b.getAlpha();
    }

    public final void k(int i2, float f2) {
        if (i2 == 1) {
            this.f2944b.setTranslationX(f2);
            return;
        }
        if (i2 == 2) {
            this.f2944b.setTranslationY(f2);
            return;
        }
        if (i2 == 4) {
            this.f2944b.setScaleX(f2);
            return;
        }
        if (i2 == 8) {
            this.f2944b.setScaleY(f2);
            return;
        }
        if (i2 == 16) {
            this.f2944b.setRotation(f2);
            return;
        }
        if (i2 == 32) {
            this.f2944b.setRotationX(f2);
            return;
        }
        if (i2 == 64) {
            this.f2944b.setRotationY(f2);
            return;
        }
        if (i2 == 128) {
            this.f2944b.setX(f2);
        } else if (i2 == 256) {
            this.f2944b.setY(f2);
        } else {
            if (i2 != 512) {
                return;
            }
            this.f2944b.setAlpha(f2);
        }
    }

    public final void l() {
        l lVarOfFloat = l.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.l.clone();
        this.l.clear();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 |= ((c) arrayList.get(i3)).f2954a;
        }
        this.n.put(lVarOfFloat, new d(i2, arrayList));
        lVarOfFloat.addUpdateListener(this.k);
        lVarOfFloat.addListener(this.k);
        if (this.f2949g) {
            lVarOfFloat.setStartDelay(this.f2948f);
        }
        if (this.f2947e) {
            lVarOfFloat.setDuration(this.f2946d);
        }
        if (this.f2951i) {
            lVarOfFloat.setInterpolator(this.f2950h);
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
            this.f2947e = true;
            this.f2946d = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // c.n.c.b
    public c.n.c.b setInterpolator(Interpolator interpolator) {
        this.f2951i = true;
        this.f2950h = interpolator;
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b setListener(a.InterfaceC0045a interfaceC0045a) {
        this.j = interfaceC0045a;
        return this;
    }

    @Override // c.n.c.b
    public c.n.c.b setStartDelay(long j) {
        if (j >= 0) {
            this.f2949g = true;
            this.f2948f = j;
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
