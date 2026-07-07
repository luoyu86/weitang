package c.n.a;

import android.view.View;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2892a = new f("alpha");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2893b = new g("pivotX");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2894c = new h("pivotY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2895d = new C0046i("translationX");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2896e = new j("translationY");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2897f = new k("rotation");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2898g = new l("rotationX");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2899h = new m("rotationY");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static c.n.b.d<View, Float> f2900i = new n("scaleX");
    public static c.n.b.d<View, Float> j = new a("scaleY");
    public static c.n.b.d<View, Integer> k = new b("scrollX");
    public static c.n.b.d<View, Integer> l = new c("scrollY");
    public static c.n.b.d<View, Float> m = new d("x");
    public static c.n.b.d<View, Float> n = new e(OperatorName.CURVE_TO_REPLICATE_FINAL_POINT);

    public static class a extends c.n.b.a<View> {
        public a(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getScaleY());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setScaleY(f2);
        }
    }

    public static class b extends c.n.b.b<View> {
        public b(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Integer get(View view) {
            return Integer.valueOf(c.n.c.f.a.wrap(view).getScrollX());
        }

        @Override // c.n.b.b
        public void setValue(View view, int i2) {
            c.n.c.f.a.wrap(view).setScrollX(i2);
        }
    }

    public static class c extends c.n.b.b<View> {
        public c(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Integer get(View view) {
            return Integer.valueOf(c.n.c.f.a.wrap(view).getScrollY());
        }

        @Override // c.n.b.b
        public void setValue(View view, int i2) {
            c.n.c.f.a.wrap(view).setScrollY(i2);
        }
    }

    public static class d extends c.n.b.a<View> {
        public d(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getX());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setX(f2);
        }
    }

    public static class e extends c.n.b.a<View> {
        public e(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getY());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setY(f2);
        }
    }

    public static class f extends c.n.b.a<View> {
        public f(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getAlpha());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setAlpha(f2);
        }
    }

    public static class g extends c.n.b.a<View> {
        public g(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getPivotX());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setPivotX(f2);
        }
    }

    public static class h extends c.n.b.a<View> {
        public h(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getPivotY());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setPivotY(f2);
        }
    }

    /* JADX INFO: renamed from: c.n.a.i$i, reason: collision with other inner class name */
    public static class C0046i extends c.n.b.a<View> {
        public C0046i(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getTranslationX());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setTranslationX(f2);
        }
    }

    public static class j extends c.n.b.a<View> {
        public j(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getTranslationY());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setTranslationY(f2);
        }
    }

    public static class k extends c.n.b.a<View> {
        public k(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getRotation());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setRotation(f2);
        }
    }

    public static class l extends c.n.b.a<View> {
        public l(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getRotationX());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setRotationX(f2);
        }
    }

    public static class m extends c.n.b.a<View> {
        public m(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getRotationY());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setRotationY(f2);
        }
    }

    public static class n extends c.n.b.a<View> {
        public n(String str) {
            super(str);
        }

        @Override // c.n.b.d
        public Float get(View view) {
            return Float.valueOf(c.n.c.f.a.wrap(view).getScaleX());
        }

        @Override // c.n.b.a
        public void setValue(View view, float f2) {
            c.n.c.f.a.wrap(view).setScaleX(f2);
        }
    }
}
