package c.n.c;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c.n.c.a$a, reason: collision with other inner class name */
    public static final class C0047a {
        public static void A(View view, float f2) {
            view.setX(f2);
        }

        public static void B(View view, float f2) {
            view.setY(f2);
        }

        public static float a(View view) {
            return view.getAlpha();
        }

        public static float b(View view) {
            return view.getPivotX();
        }

        public static float c(View view) {
            return view.getPivotY();
        }

        public static float d(View view) {
            return view.getRotation();
        }

        public static float e(View view) {
            return view.getRotationX();
        }

        public static float f(View view) {
            return view.getRotationY();
        }

        public static float g(View view) {
            return view.getScaleX();
        }

        public static float h(View view) {
            return view.getScaleY();
        }

        public static float i(View view) {
            return view.getScrollX();
        }

        public static float j(View view) {
            return view.getScrollY();
        }

        public static float k(View view) {
            return view.getTranslationX();
        }

        public static float l(View view) {
            return view.getTranslationY();
        }

        public static float m(View view) {
            return view.getX();
        }

        public static float n(View view) {
            return view.getY();
        }

        public static void o(View view, float f2) {
            view.setAlpha(f2);
        }

        public static void p(View view, float f2) {
            view.setPivotX(f2);
        }

        public static void q(View view, float f2) {
            view.setPivotY(f2);
        }

        public static void r(View view, float f2) {
            view.setRotation(f2);
        }

        public static void s(View view, float f2) {
            view.setRotationX(f2);
        }

        public static void t(View view, float f2) {
            view.setRotationY(f2);
        }

        public static void u(View view, float f2) {
            view.setScaleX(f2);
        }

        public static void v(View view, float f2) {
            view.setScaleY(f2);
        }

        public static void w(View view, int i2) {
            view.setScrollX(i2);
        }

        public static void x(View view, int i2) {
            view.setScrollY(i2);
        }

        public static void y(View view, float f2) {
            view.setTranslationX(f2);
        }

        public static void z(View view, float f2) {
            view.setTranslationY(f2);
        }
    }

    public static float getAlpha(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getAlpha() : C0047a.a(view);
    }

    public static float getPivotX(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getPivotX() : C0047a.b(view);
    }

    public static float getPivotY(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getPivotY() : C0047a.c(view);
    }

    public static float getRotation(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getRotation() : C0047a.d(view);
    }

    public static float getRotationX(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getRotationX() : C0047a.e(view);
    }

    public static float getRotationY(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getRotationY() : C0047a.f(view);
    }

    public static float getScaleX(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getScaleX() : C0047a.g(view);
    }

    public static float getScaleY(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getScaleY() : C0047a.h(view);
    }

    public static float getScrollX(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getScrollX() : C0047a.i(view);
    }

    public static float getScrollY(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getScrollY() : C0047a.j(view);
    }

    public static float getTranslationX(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getTranslationX() : C0047a.k(view);
    }

    public static float getTranslationY(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getTranslationY() : C0047a.l(view);
    }

    public static float getX(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getX() : C0047a.m(view);
    }

    public static float getY(View view) {
        return c.n.c.f.a.f2959a ? c.n.c.f.a.wrap(view).getY() : C0047a.n(view);
    }

    public static void setAlpha(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setAlpha(f2);
        } else {
            C0047a.o(view, f2);
        }
    }

    public static void setPivotX(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setPivotX(f2);
        } else {
            C0047a.p(view, f2);
        }
    }

    public static void setPivotY(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setPivotY(f2);
        } else {
            C0047a.q(view, f2);
        }
    }

    public static void setRotation(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setRotation(f2);
        } else {
            C0047a.r(view, f2);
        }
    }

    public static void setRotationX(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setRotationX(f2);
        } else {
            C0047a.s(view, f2);
        }
    }

    public static void setRotationY(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setRotationY(f2);
        } else {
            C0047a.t(view, f2);
        }
    }

    public static void setScaleX(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setScaleX(f2);
        } else {
            C0047a.u(view, f2);
        }
    }

    public static void setScaleY(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setScaleY(f2);
        } else {
            C0047a.v(view, f2);
        }
    }

    public static void setScrollX(View view, int i2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setScrollX(i2);
        } else {
            C0047a.w(view, i2);
        }
    }

    public static void setScrollY(View view, int i2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setScrollY(i2);
        } else {
            C0047a.x(view, i2);
        }
    }

    public static void setTranslationX(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setTranslationX(f2);
        } else {
            C0047a.y(view, f2);
        }
    }

    public static void setTranslationY(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setTranslationY(f2);
        } else {
            C0047a.z(view, f2);
        }
    }

    public static void setX(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setX(f2);
        } else {
            C0047a.A(view, f2);
        }
    }

    public static void setY(View view, float f2) {
        if (c.n.c.f.a.f2959a) {
            c.n.c.f.a.wrap(view).setY(f2);
        } else {
            C0047a.B(view, f2);
        }
    }
}
