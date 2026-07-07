package d.m0;

import d.k0.d.t;

/* JADX INFO: loaded from: classes2.dex */
public class o {
    public static final void checkStepIsPositive(boolean z, Number number) {
        t.checkNotNullParameter(number, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }

    public static final <T extends Comparable<? super T>> g<T> rangeTo(T t, T t2) {
        t.checkNotNullParameter(t, "$this$rangeTo");
        t.checkNotNullParameter(t2, "that");
        return new h(t, t2);
    }

    public static final f<Double> rangeTo(double d2, double d3) {
        return new d(d2, d3);
    }

    public static final f<Float> rangeTo(float f2, float f3) {
        return new e(f2, f3);
    }
}
