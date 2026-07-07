package d;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.RecyclerView;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {
    public static final int doubleToUInt(double d2) {
        if (Double.isNaN(d2) || d2 <= uintToDouble(0)) {
            return 0;
        }
        if (d2 >= uintToDouble(-1)) {
            return -1;
        }
        double d3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        return d2 <= d3 ? v.m424constructorimpl((int) d2) : v.m424constructorimpl(v.m424constructorimpl((int) (d2 - d3)) + v.m424constructorimpl(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
    }

    public static final long doubleToULong(double d2) {
        if (Double.isNaN(d2) || d2 <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d2 >= ulongToDouble(-1L)) {
            return -1L;
        }
        return d2 < ((double) RecyclerView.FOREVER_NS) ? x.m448constructorimpl((long) d2) : x.m448constructorimpl(x.m448constructorimpl((long) (d2 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    public static final int uintCompare(int i2, int i3) {
        return d.k0.d.t.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m119uintDivideJ1ME1BU(int i2, int i3) {
        return v.m424constructorimpl((int) ((((long) i2) & UIDFolder.MAXUID) / (((long) i3) & UIDFolder.MAXUID)));
    }

    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m120uintRemainderJ1ME1BU(int i2, int i3) {
        return v.m424constructorimpl((int) ((((long) i2) & UIDFolder.MAXUID) % (((long) i3) & UIDFolder.MAXUID)));
    }

    public static final double uintToDouble(int i2) {
        return ((double) (Integer.MAX_VALUE & i2)) + (((double) ((i2 >>> 31) << 30)) * ((double) 2));
    }

    public static final int ulongCompare(long j, long j2) {
        return ((j ^ Long.MIN_VALUE) > (j2 ^ Long.MIN_VALUE) ? 1 : ((j ^ Long.MIN_VALUE) == (j2 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m121ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? x.m448constructorimpl(0L) : x.m448constructorimpl(1L);
        }
        if (j >= 0) {
            return x.m448constructorimpl(j / j2);
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return x.m448constructorimpl(j3 + ((long) (ulongCompare(x.m448constructorimpl(j - (j3 * j2)), x.m448constructorimpl(j2)) < 0 ? 0 : 1)));
    }

    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m122ulongRemaindereb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? j : x.m448constructorimpl(j - j2);
        }
        if (j >= 0) {
            return x.m448constructorimpl(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (ulongCompare(x.m448constructorimpl(j3), x.m448constructorimpl(j2)) < 0) {
            j2 = 0;
        }
        return x.m448constructorimpl(j3 - j2);
    }

    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * ((double) 2048)) + (j & 2047);
    }

    public static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    public static final String ulongToString(long j, int i2) {
        if (j >= 0) {
            String string = Long.toString(j, d.p0.c.checkRadix(i2));
            d.k0.d.t.checkNotNullExpressionValue(string, "java.lang.Long.toString(this, checkRadix(radix))");
            return string;
        }
        long j2 = i2;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j3, d.p0.c.checkRadix(i2));
        d.k0.d.t.checkNotNullExpressionValue(string2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(string2);
        String string3 = Long.toString(j4, d.p0.c.checkRadix(i2));
        d.k0.d.t.checkNotNullExpressionValue(string3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(string3);
        return sb.toString();
    }
}
