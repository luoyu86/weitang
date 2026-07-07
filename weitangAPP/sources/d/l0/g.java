package d.l0;

import androidx.recyclerview.widget.RecyclerView;
import d.k0.d.t;
import d.m0.k;
import d.m0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final f Random(int i2) {
        return new h(i2, i2 >> 31);
    }

    public static final String boundsErrorMessage(Object obj, Object obj2) {
        t.checkNotNullParameter(obj, "from");
        t.checkNotNullParameter(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void checkRangeBounds(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final int fastLog2(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static final int nextInt(f fVar, k kVar) {
        t.checkNotNullParameter(fVar, "$this$nextInt");
        t.checkNotNullParameter(kVar, "range");
        if (!kVar.isEmpty()) {
            return kVar.getLast() < Integer.MAX_VALUE ? fVar.nextInt(kVar.getFirst(), kVar.getLast() + 1) : kVar.getFirst() > Integer.MIN_VALUE ? fVar.nextInt(kVar.getFirst() - 1, kVar.getLast()) + 1 : fVar.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + kVar);
    }

    public static final long nextLong(f fVar, n nVar) {
        t.checkNotNullParameter(fVar, "$this$nextLong");
        t.checkNotNullParameter(nVar, "range");
        if (!nVar.isEmpty()) {
            return nVar.getLast() < RecyclerView.FOREVER_NS ? fVar.nextLong(nVar.getFirst(), nVar.getLast() + 1) : nVar.getFirst() > Long.MIN_VALUE ? fVar.nextLong(nVar.getFirst() - 1, nVar.getLast()) + 1 : fVar.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + nVar);
    }

    public static final int takeUpperBits(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }

    public static final f Random(long j) {
        return new h((int) j, (int) (j >> 32));
    }

    public static final void checkRangeBounds(long j, long j2) {
        if (!(j2 > j)) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final void checkRangeBounds(double d2, double d3) {
        if (!(d3 > d2)) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d2), Double.valueOf(d3)).toString());
        }
    }
}
