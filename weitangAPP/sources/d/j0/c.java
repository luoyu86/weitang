package d.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final int a(int i2, int i3, int i4) {
        return c(c(i2, i4) - c(i3, i4), i4);
    }

    public static final long b(long j, long j2, long j3) {
        return d(d(j, j3) - d(j2, j3), j3);
    }

    public static final int c(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    public static final long d(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    public static final int getProgressionLastElement(int i2, int i3, int i4) {
        if (i4 > 0) {
            return i2 >= i3 ? i3 : i3 - a(i3, i2, i4);
        }
        if (i4 < 0) {
            return i2 <= i3 ? i3 : i3 + a(i2, i3, -i4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long getProgressionLastElement(long j, long j2, long j3) {
        if (j3 > 0) {
            return j >= j2 ? j2 : j2 - b(j2, j, j3);
        }
        if (j3 < 0) {
            return j <= j2 ? j2 : j2 + b(j, j2, -j3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
