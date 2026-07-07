package d.m0;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.RecyclerView;
import d.k0.d.t;
import d.m0.a;
import d.m0.i;
import d.m0.l;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class p extends o {
    public static final boolean byteRangeContains(g<Byte> gVar, double d2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(d2);
        if (byteExactOrNull != null) {
            return gVar.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b2, byte b3) {
        return b2 < b3 ? b3 : b2;
    }

    public static final double coerceAtLeast(double d2, double d3) {
        return d2 < d3 ? d3 : d2;
    }

    public static final float coerceAtLeast(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    public static final int coerceAtLeast(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static final long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T t, T t2) {
        t.checkNotNullParameter(t, "$this$coerceAtLeast");
        t.checkNotNullParameter(t2, "minimumValue");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    public static final short coerceAtLeast(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final byte coerceAtMost(byte b2, byte b3) {
        return b2 > b3 ? b3 : b2;
    }

    public static final double coerceAtMost(double d2, double d3) {
        return d2 > d3 ? d3 : d2;
    }

    public static final float coerceAtMost(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public static final int coerceAtMost(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static final long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T t, T t2) {
        t.checkNotNullParameter(t, "$this$coerceAtMost");
        t.checkNotNullParameter(t2, "maximumValue");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    public static final short coerceAtMost(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, T t2, T t3) {
        t.checkNotNullParameter(t, "$this$coerceIn");
        if (t2 == null || t3 == null) {
            if (t2 != null && t.compareTo(t2) < 0) {
                return t2;
            }
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        } else {
            if (t2.compareTo(t3) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
            if (t.compareTo(t2) < 0) {
                return t2;
            }
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    public static final boolean doubleRangeContains(g<Double> gVar, byte b2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(b2));
    }

    public static final i downTo(int i2, byte b2) {
        return i.f12693a.fromClosedRange(i2, b2, -1);
    }

    public static final boolean floatRangeContains(g<Float> gVar, byte b2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Float.valueOf(b2));
    }

    public static final boolean intRangeContains(g<Integer> gVar, byte b2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Integer.valueOf(b2));
    }

    public static final boolean longRangeContains(g<Long> gVar, byte b2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Long.valueOf(b2));
    }

    public static final int random(k kVar, d.l0.f fVar) {
        t.checkNotNullParameter(kVar, "$this$random");
        t.checkNotNullParameter(fVar, "random");
        try {
            return d.l0.g.nextInt(fVar, kVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static final Integer randomOrNull(k kVar, d.l0.f fVar) {
        t.checkNotNullParameter(kVar, "$this$randomOrNull");
        t.checkNotNullParameter(fVar, "random");
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(d.l0.g.nextInt(fVar, kVar));
    }

    public static final i reversed(i iVar) {
        t.checkNotNullParameter(iVar, "$this$reversed");
        return i.f12693a.fromClosedRange(iVar.getLast(), iVar.getFirst(), -iVar.getStep());
    }

    public static final boolean shortRangeContains(g<Short> gVar, byte b2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Short.valueOf(b2));
    }

    public static final i step(i iVar, int i2) {
        t.checkNotNullParameter(iVar, "$this$step");
        o.checkStepIsPositive(i2 > 0, Integer.valueOf(i2));
        i.a aVar = i.f12693a;
        int first = iVar.getFirst();
        int last = iVar.getLast();
        if (iVar.getStep() <= 0) {
            i2 = -i2;
        }
        return aVar.fromClosedRange(first, last, i2);
    }

    public static final Byte toByteExactOrNull(int i2) {
        if (-128 <= i2 && 127 >= i2) {
            return Byte.valueOf((byte) i2);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(long j) {
        long j2 = Integer.MIN_VALUE;
        long j3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if (j2 <= j && j3 >= j) {
            return Integer.valueOf((int) j);
        }
        return null;
    }

    public static final Long toLongExactOrNull(double d2) {
        double d3 = Long.MIN_VALUE;
        double d4 = RecyclerView.FOREVER_NS;
        if (d2 < d3 || d2 > d4) {
            return null;
        }
        return Long.valueOf((long) d2);
    }

    public static final Short toShortExactOrNull(int i2) {
        if (-32768 <= i2 && 32767 >= i2) {
            return Short.valueOf((short) i2);
        }
        return null;
    }

    public static final k until(int i2, byte b2) {
        return new k(i2, b2 - 1);
    }

    public static final boolean byteRangeContains(g<Byte> gVar, float f2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(f2);
        if (byteExactOrNull != null) {
            return gVar.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(g<Double> gVar, float f2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(f2));
    }

    public static final l downTo(long j, byte b2) {
        return l.f12703a.fromClosedRange(j, b2, -1L);
    }

    public static final boolean floatRangeContains(g<Float> gVar, double d2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Float.valueOf((float) d2));
    }

    public static final boolean intRangeContains(g<Integer> gVar, double d2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(d2);
        if (intExactOrNull != null) {
            return gVar.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean longRangeContains(g<Long> gVar, double d2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Long longExactOrNull = toLongExactOrNull(d2);
        if (longExactOrNull != null) {
            return gVar.contains(longExactOrNull);
        }
        return false;
    }

    public static final l reversed(l lVar) {
        t.checkNotNullParameter(lVar, "$this$reversed");
        return l.f12703a.fromClosedRange(lVar.getLast(), lVar.getFirst(), -lVar.getStep());
    }

    public static final boolean shortRangeContains(g<Short> gVar, double d2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(d2);
        if (shortExactOrNull != null) {
            return gVar.contains(shortExactOrNull);
        }
        return false;
    }

    public static final Byte toByteExactOrNull(long j) {
        long j2 = 127;
        if (com.alipay.sdk.m.n.a.f5520g <= j && j2 >= j) {
            return Byte.valueOf((byte) j);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(double d2) {
        double d3 = Integer.MIN_VALUE;
        double d4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if (d2 < d3 || d2 > d4) {
            return null;
        }
        return Integer.valueOf((int) d2);
    }

    public static final Long toLongExactOrNull(float f2) {
        float f3 = Long.MIN_VALUE;
        float f4 = RecyclerView.FOREVER_NS;
        if (f2 < f3 || f2 > f4) {
            return null;
        }
        return Long.valueOf((long) f2);
    }

    public static final Short toShortExactOrNull(long j) {
        long j2 = 32767;
        if (-32768 <= j && j2 >= j) {
            return Short.valueOf((short) j);
        }
        return null;
    }

    public static final n until(long j, byte b2) {
        return new n(j, ((long) b2) - 1);
    }

    public static final boolean byteRangeContains(g<Byte> gVar, int i2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(i2);
        if (byteExactOrNull != null) {
            return gVar.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(g<Double> gVar, int i2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(i2));
    }

    public static final i downTo(byte b2, byte b3) {
        return i.f12693a.fromClosedRange(b2, b3, -1);
    }

    public static final boolean floatRangeContains(g<Float> gVar, int i2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Float.valueOf(i2));
    }

    public static final boolean intRangeContains(g<Integer> gVar, float f2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(f2);
        if (intExactOrNull != null) {
            return gVar.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean longRangeContains(g<Long> gVar, float f2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Long longExactOrNull = toLongExactOrNull(f2);
        if (longExactOrNull != null) {
            return gVar.contains(longExactOrNull);
        }
        return false;
    }

    public static final long random(n nVar, d.l0.f fVar) {
        t.checkNotNullParameter(nVar, "$this$random");
        t.checkNotNullParameter(fVar, "random");
        try {
            return d.l0.g.nextLong(fVar, nVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static final Long randomOrNull(n nVar, d.l0.f fVar) {
        t.checkNotNullParameter(nVar, "$this$randomOrNull");
        t.checkNotNullParameter(fVar, "random");
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(d.l0.g.nextLong(fVar, nVar));
    }

    public static final a reversed(a aVar) {
        t.checkNotNullParameter(aVar, "$this$reversed");
        return a.f12677a.fromClosedRange(aVar.getLast(), aVar.getFirst(), -aVar.getStep());
    }

    public static final boolean shortRangeContains(g<Short> gVar, float f2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(f2);
        if (shortExactOrNull != null) {
            return gVar.contains(shortExactOrNull);
        }
        return false;
    }

    public static final l step(l lVar, long j) {
        t.checkNotNullParameter(lVar, "$this$step");
        o.checkStepIsPositive(j > 0, Long.valueOf(j));
        l.a aVar = l.f12703a;
        long first = lVar.getFirst();
        long last = lVar.getLast();
        if (lVar.getStep() <= 0) {
            j = -j;
        }
        return aVar.fromClosedRange(first, last, j);
    }

    public static final Byte toByteExactOrNull(short s) {
        short s2 = (short) 127;
        if (((short) com.alipay.sdk.m.n.a.f5520g) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(float f2) {
        float f3 = Integer.MIN_VALUE;
        float f4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if (f2 < f3 || f2 > f4) {
            return null;
        }
        return Integer.valueOf((int) f2);
    }

    public static final Short toShortExactOrNull(double d2) {
        double d3 = 32767;
        if (d2 < -32768 || d2 > d3) {
            return null;
        }
        return Short.valueOf((short) d2);
    }

    public static final k until(byte b2, byte b3) {
        return new k(b2, b3 - 1);
    }

    public static final boolean byteRangeContains(g<Byte> gVar, long j) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return gVar.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(g<Double> gVar, long j) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(j));
    }

    public static final i downTo(short s, byte b2) {
        return i.f12693a.fromClosedRange(s, b2, -1);
    }

    public static final boolean floatRangeContains(g<Float> gVar, long j) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Float.valueOf(j));
    }

    public static final boolean intRangeContains(g<Integer> gVar, long j) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return gVar.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean longRangeContains(g<Long> gVar, int i2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Long.valueOf(i2));
    }

    public static final boolean shortRangeContains(g<Short> gVar, int i2) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(i2);
        if (shortExactOrNull != null) {
            return gVar.contains(shortExactOrNull);
        }
        return false;
    }

    public static final Byte toByteExactOrNull(double d2) {
        double d3 = 127;
        if (d2 < com.alipay.sdk.m.n.a.f5520g || d2 > d3) {
            return null;
        }
        return Byte.valueOf((byte) d2);
    }

    public static final Short toShortExactOrNull(float f2) {
        float f3 = 32767;
        if (f2 < -32768 || f2 > f3) {
            return null;
        }
        return Short.valueOf((short) f2);
    }

    public static final k until(short s, byte b2) {
        return new k(s, b2 - 1);
    }

    public static final boolean byteRangeContains(g<Byte> gVar, short s) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return gVar.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(g<Double> gVar, short s) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Double.valueOf(s));
    }

    public static final a downTo(char c2, char c3) {
        return a.f12677a.fromClosedRange(c2, c3, -1);
    }

    public static final boolean floatRangeContains(g<Float> gVar, short s) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Float.valueOf(s));
    }

    public static final boolean intRangeContains(g<Integer> gVar, short s) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Integer.valueOf(s));
    }

    public static final boolean longRangeContains(g<Long> gVar, short s) {
        t.checkNotNullParameter(gVar, "$this$contains");
        return gVar.contains(Long.valueOf(s));
    }

    public static final char random(c cVar, d.l0.f fVar) {
        t.checkNotNullParameter(cVar, "$this$random");
        t.checkNotNullParameter(fVar, "random");
        try {
            return (char) fVar.nextInt(cVar.getFirst(), cVar.getLast() + 1);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static final Character randomOrNull(c cVar, d.l0.f fVar) {
        t.checkNotNullParameter(cVar, "$this$randomOrNull");
        t.checkNotNullParameter(fVar, "random");
        if (cVar.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) fVar.nextInt(cVar.getFirst(), cVar.getLast() + 1));
    }

    public static final boolean shortRangeContains(g<Short> gVar, long j) {
        t.checkNotNullParameter(gVar, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return gVar.contains(shortExactOrNull);
        }
        return false;
    }

    public static final a step(a aVar, int i2) {
        t.checkNotNullParameter(aVar, "$this$step");
        o.checkStepIsPositive(i2 > 0, Integer.valueOf(i2));
        a.C0240a c0240a = a.f12677a;
        char first = aVar.getFirst();
        char last = aVar.getLast();
        if (aVar.getStep() <= 0) {
            i2 = -i2;
        }
        return c0240a.fromClosedRange(first, last, i2);
    }

    public static final Byte toByteExactOrNull(float f2) {
        float f3 = 127;
        if (f2 < com.alipay.sdk.m.n.a.f5520g || f2 > f3) {
            return null;
        }
        return Byte.valueOf((byte) f2);
    }

    public static final c until(char c2, char c3) {
        return t.compare((int) c3, 0) <= 0 ? c.f12686f.getEMPTY() : new c(c2, (char) (c3 - 1));
    }

    public static final i downTo(int i2, int i3) {
        return i.f12693a.fromClosedRange(i2, i3, -1);
    }

    public static final byte coerceIn(byte b2, byte b3, byte b4) {
        if (b3 <= b4) {
            return b2 < b3 ? b3 : b2 > b4 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b4) + " is less than minimum " + ((int) b3) + '.');
    }

    public static final l downTo(long j, int i2) {
        return l.f12703a.fromClosedRange(j, i2, -1L);
    }

    public static final k until(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return k.f12702f.getEMPTY();
        }
        return new k(i2, i3 - 1);
    }

    public static final short coerceIn(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + '.');
    }

    public static final i downTo(byte b2, int i2) {
        return i.f12693a.fromClosedRange(b2, i2, -1);
    }

    public static final int coerceIn(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static final i downTo(short s, int i2) {
        return i.f12693a.fromClosedRange(s, i2, -1);
    }

    public static final n until(long j, int i2) {
        return new n(j, ((long) i2) - 1);
    }

    public static final long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static final l downTo(int i2, long j) {
        return l.f12703a.fromClosedRange(i2, j, -1L);
    }

    public static final k until(byte b2, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return k.f12702f.getEMPTY();
        }
        return new k(b2, i2 - 1);
    }

    public static final float coerceIn(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + '.');
    }

    public static final l downTo(long j, long j2) {
        return l.f12703a.fromClosedRange(j, j2, -1L);
    }

    public static final double coerceIn(double d2, double d3, double d4) {
        if (d3 <= d4) {
            return d2 < d3 ? d3 : d2 > d4 ? d4 : d2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d4 + " is less than minimum " + d3 + '.');
    }

    public static final l downTo(byte b2, long j) {
        return l.f12703a.fromClosedRange(b2, j, -1L);
    }

    public static final k until(short s, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return k.f12702f.getEMPTY();
        }
        return new k(s, i2 - 1);
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, f<T> fVar) {
        t.checkNotNullParameter(t, "$this$coerceIn");
        t.checkNotNullParameter(fVar, "range");
        if (!fVar.isEmpty()) {
            return (!fVar.lessThanOrEquals(t, fVar.getStart()) || fVar.lessThanOrEquals(fVar.getStart(), t)) ? (!fVar.lessThanOrEquals(fVar.getEndInclusive(), t) || fVar.lessThanOrEquals(t, fVar.getEndInclusive())) ? t : (T) fVar.getEndInclusive() : (T) fVar.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + fVar + '.');
    }

    public static final l downTo(short s, long j) {
        return l.f12703a.fromClosedRange(s, j, -1L);
    }

    public static final i downTo(int i2, short s) {
        return i.f12693a.fromClosedRange(i2, s, -1);
    }

    public static final n until(int i2, long j) {
        if (j <= Long.MIN_VALUE) {
            return n.f12712f.getEMPTY();
        }
        return new n(i2, j - 1);
    }

    public static final l downTo(long j, short s) {
        return l.f12703a.fromClosedRange(j, s, -1L);
    }

    public static final i downTo(byte b2, short s) {
        return i.f12693a.fromClosedRange(b2, s, -1);
    }

    public static final n until(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return n.f12712f.getEMPTY();
        }
        return new n(j, j2 - 1);
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, g<T> gVar) {
        t.checkNotNullParameter(t, "$this$coerceIn");
        t.checkNotNullParameter(gVar, "range");
        if (gVar instanceof f) {
            return (T) coerceIn((Comparable) t, (f) gVar);
        }
        if (!gVar.isEmpty()) {
            return t.compareTo(gVar.getStart()) < 0 ? (T) gVar.getStart() : t.compareTo(gVar.getEndInclusive()) > 0 ? (T) gVar.getEndInclusive() : t;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    public static final i downTo(short s, short s2) {
        return i.f12693a.fromClosedRange(s, s2, -1);
    }

    public static final n until(byte b2, long j) {
        if (j <= Long.MIN_VALUE) {
            return n.f12712f.getEMPTY();
        }
        return new n(b2, j - 1);
    }

    public static final n until(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return n.f12712f.getEMPTY();
        }
        return new n(s, j - 1);
    }

    public static final k until(int i2, short s) {
        return new k(i2, s - 1);
    }

    public static final int coerceIn(int i2, g<Integer> gVar) {
        t.checkNotNullParameter(gVar, "range");
        if (gVar instanceof f) {
            return ((Number) coerceIn(Integer.valueOf(i2), (f<Integer>) gVar)).intValue();
        }
        if (!gVar.isEmpty()) {
            return i2 < ((Number) gVar.getStart()).intValue() ? ((Number) gVar.getStart()).intValue() : i2 > ((Number) gVar.getEndInclusive()).intValue() ? ((Number) gVar.getEndInclusive()).intValue() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    public static final n until(long j, short s) {
        return new n(j, ((long) s) - 1);
    }

    public static final k until(byte b2, short s) {
        return new k(b2, s - 1);
    }

    public static final k until(short s, short s2) {
        return new k(s, s2 - 1);
    }

    public static final long coerceIn(long j, g<Long> gVar) {
        t.checkNotNullParameter(gVar, "range");
        if (gVar instanceof f) {
            return ((Number) coerceIn(Long.valueOf(j), (f<Long>) gVar)).longValue();
        }
        if (!gVar.isEmpty()) {
            return j < ((Number) gVar.getStart()).longValue() ? ((Number) gVar.getStart()).longValue() : j > ((Number) gVar.getEndInclusive()).longValue() ? ((Number) gVar.getEndInclusive()).longValue() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }
}
