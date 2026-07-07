package d.g0;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class m extends d.g0.l {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f12516a;

        public a(Object[] objArr) {
            this.f12516a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return d.k0.d.h.iterator(this.f12516a);
        }
    }

    public static final class a0 extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Boolean>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f12517b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(boolean[] zArr) {
            super(0);
            this.f12517b = zArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Boolean> invoke() {
            return d.k0.d.i.iterator(this.f12517b);
        }
    }

    public static final class b implements Iterable<Byte>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f12518a;

        public b(byte[] bArr) {
            this.f12518a = bArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Byte> iterator() {
            return d.k0.d.i.iterator(this.f12518a);
        }
    }

    public static final class b0 extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Character>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ char[] f12519b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(char[] cArr) {
            super(0);
            this.f12519b = cArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Character> invoke() {
            return d.k0.d.i.iterator(this.f12519b);
        }
    }

    public static final class c implements Iterable<Short>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ short[] f12520a;

        public c(short[] sArr) {
            this.f12520a = sArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Short> iterator() {
            return d.k0.d.i.iterator(this.f12520a);
        }
    }

    public static final class d implements Iterable<Integer>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f12521a;

        public d(int[] iArr) {
            this.f12521a = iArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Integer> iterator() {
            return d.k0.d.i.iterator(this.f12521a);
        }
    }

    public static final class e implements Iterable<Long>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f12522a;

        public e(long[] jArr) {
            this.f12522a = jArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Long> iterator() {
            return d.k0.d.i.iterator(this.f12522a);
        }
    }

    public static final class f implements Iterable<Float>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float[] f12523a;

        public f(float[] fArr) {
            this.f12523a = fArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Float> iterator() {
            return d.k0.d.i.iterator(this.f12523a);
        }
    }

    public static final class g implements Iterable<Double>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double[] f12524a;

        public g(double[] dArr) {
            this.f12524a = dArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Double> iterator() {
            return d.k0.d.i.iterator(this.f12524a);
        }
    }

    public static final class h implements Iterable<Boolean>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f12525a;

        public h(boolean[] zArr) {
            this.f12525a = zArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Boolean> iterator() {
            return d.k0.d.i.iterator(this.f12525a);
        }
    }

    public static final class i implements Iterable<Character>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f12526a;

        public i(char[] cArr) {
            this.f12526a = cArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Character> iterator() {
            return d.k0.d.i.iterator(this.f12526a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class j<T> implements d.o0.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f12527a;

        public j(Object[] objArr) {
            this.f12527a = objArr;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            return d.k0.d.h.iterator(this.f12527a);
        }
    }

    public static final class k implements d.o0.m<Byte> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f12528a;

        public k(byte[] bArr) {
            this.f12528a = bArr;
        }

        @Override // d.o0.m
        public Iterator<Byte> iterator() {
            return d.k0.d.i.iterator(this.f12528a);
        }
    }

    public static final class l implements d.o0.m<Short> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ short[] f12529a;

        public l(short[] sArr) {
            this.f12529a = sArr;
        }

        @Override // d.o0.m
        public Iterator<Short> iterator() {
            return d.k0.d.i.iterator(this.f12529a);
        }
    }

    /* JADX INFO: renamed from: d.g0.m$m, reason: collision with other inner class name */
    public static final class C0236m implements d.o0.m<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f12530a;

        public C0236m(int[] iArr) {
            this.f12530a = iArr;
        }

        @Override // d.o0.m
        public Iterator<Integer> iterator() {
            return d.k0.d.i.iterator(this.f12530a);
        }
    }

    public static final class n implements d.o0.m<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f12531a;

        public n(long[] jArr) {
            this.f12531a = jArr;
        }

        @Override // d.o0.m
        public Iterator<Long> iterator() {
            return d.k0.d.i.iterator(this.f12531a);
        }
    }

    public static final class o implements d.o0.m<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float[] f12532a;

        public o(float[] fArr) {
            this.f12532a = fArr;
        }

        @Override // d.o0.m
        public Iterator<Float> iterator() {
            return d.k0.d.i.iterator(this.f12532a);
        }
    }

    public static final class p implements d.o0.m<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double[] f12533a;

        public p(double[] dArr) {
            this.f12533a = dArr;
        }

        @Override // d.o0.m
        public Iterator<Double> iterator() {
            return d.k0.d.i.iterator(this.f12533a);
        }
    }

    public static final class q implements d.o0.m<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f12534a;

        public q(boolean[] zArr) {
            this.f12534a = zArr;
        }

        @Override // d.o0.m
        public Iterator<Boolean> iterator() {
            return d.k0.d.i.iterator(this.f12534a);
        }
    }

    public static final class r implements d.o0.m<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f12535a;

        public r(char[] cArr) {
            this.f12535a = cArr;
        }

        @Override // d.o0.m
        public Iterator<Character> iterator() {
            return d.k0.d.i.iterator(this.f12535a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public static final class s<K, T> implements h0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f12536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.l f12537b;

        public s(T[] tArr, d.k0.c.l lVar) {
            this.f12536a = tArr;
            this.f12537b = lVar;
        }

        @Override // d.g0.h0
        public K keyOf(T t) {
            return (K) this.f12537b.invoke(t);
        }

        @Override // d.g0.h0
        public Iterator<T> sourceIterator() {
            return d.k0.d.h.iterator(this.f12536a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class t<T> extends d.k0.d.u implements d.k0.c.a<Iterator<? extends T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object[] f12538b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Object[] objArr) {
            super(0);
            this.f12538b = objArr;
        }

        @Override // d.k0.c.a
        public final Iterator<T> invoke() {
            return d.k0.d.h.iterator(this.f12538b);
        }
    }

    public static final class u extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Byte>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f12539b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(byte[] bArr) {
            super(0);
            this.f12539b = bArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Byte> invoke() {
            return d.k0.d.i.iterator(this.f12539b);
        }
    }

    public static final class v extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Short>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ short[] f12540b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(short[] sArr) {
            super(0);
            this.f12540b = sArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Short> invoke() {
            return d.k0.d.i.iterator(this.f12540b);
        }
    }

    public static final class w extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Integer>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f12541b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(int[] iArr) {
            super(0);
            this.f12541b = iArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Integer> invoke() {
            return d.k0.d.i.iterator(this.f12541b);
        }
    }

    public static final class x extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Long>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f12542b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(long[] jArr) {
            super(0);
            this.f12542b = jArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Long> invoke() {
            return d.k0.d.i.iterator(this.f12542b);
        }
    }

    public static final class y extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Float>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float[] f12543b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(float[] fArr) {
            super(0);
            this.f12543b = fArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Float> invoke() {
            return d.k0.d.i.iterator(this.f12543b);
        }
    }

    public static final class z extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Double>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double[] f12544b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(double[] dArr) {
            super(0);
            this.f12544b = dArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Double> invoke() {
            return d.k0.d.i.iterator(this.f12544b);
        }
    }

    public static final <T> boolean all(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t2 : tArr) {
            if (!lVar.invoke(t2).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$any");
        return !(tArr.length == 0);
    }

    public static final <T> Iterable<T> asIterable(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$asIterable");
        return tArr.length == 0 ? d.g0.s.emptyList() : new a(tArr);
    }

    public static final <T> d.o0.m<T> asSequence(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$asSequence");
        return tArr.length == 0 ? d.o0.r.emptySequence() : new j(tArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(T[] tArr, d.k0.c.l<? super T, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(tArr.length), 16));
        for (a.a.a aVar : tArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(aVar);
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <T, K> Map<K, T> associateBy(T[] tArr, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(tArr.length), 16));
        for (T t2 : tArr) {
            linkedHashMap.put(lVar.invoke(t2), t2);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(T[] tArr, M m, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (T t2 : tArr) {
            m.put(lVar.invoke(t2), t2);
        }
        return m;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(T[] tArr, M m, d.k0.c.l<? super T, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (T t2 : tArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(t2);
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final <K, V> Map<K, V> associateWith(K[] kArr, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(kArr, "$this$associateWith");
        d.k0.d.t.checkNotNullParameter(lVar, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(kArr.length), 16));
        for (K k2 : kArr) {
            linkedHashMap.put(k2, lVar.invoke(k2));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(K[] kArr, M m, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(kArr, "$this$associateWithTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "valueSelector");
        for (K k2 : kArr) {
            m.put(k2, lVar.invoke(k2));
        }
        return m;
    }

    public static final double average(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (byte b2 : bArr) {
            d2 += (double) b2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final double averageOfByte(Byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$average");
        double dByteValue = 0.0d;
        int i2 = 0;
        for (Byte b2 : bArr) {
            dByteValue += (double) b2.byteValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i2);
    }

    public static final double averageOfDouble(Double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$average");
        double dDoubleValue = 0.0d;
        int i2 = 0;
        for (Double d2 : dArr) {
            dDoubleValue += d2.doubleValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i2);
    }

    public static final double averageOfFloat(Float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$average");
        double dFloatValue = 0.0d;
        int i2 = 0;
        for (Float f2 : fArr) {
            dFloatValue += (double) f2.floatValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i2);
    }

    public static final double averageOfInt(Integer[] numArr) {
        d.k0.d.t.checkNotNullParameter(numArr, "$this$average");
        double dIntValue = 0.0d;
        int i2 = 0;
        for (Integer num : numArr) {
            dIntValue += (double) num.intValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i2);
    }

    public static final double averageOfLong(Long[] lArr) {
        d.k0.d.t.checkNotNullParameter(lArr, "$this$average");
        double dLongValue = 0.0d;
        int i2 = 0;
        for (Long l2 : lArr) {
            dLongValue += l2.longValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i2);
    }

    public static final double averageOfShort(Short[] shArr) {
        d.k0.d.t.checkNotNullParameter(shArr, "$this$average");
        double dShortValue = 0.0d;
        int i2 = 0;
        for (Short sh : shArr) {
            dShortValue += (double) sh.shortValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i2);
    }

    public static final <T> boolean contains(T[] tArr, T t2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$contains");
        return indexOf(tArr, t2) >= 0;
    }

    public static final <T> int count(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (T t2 : tArr) {
            if (lVar.invoke(t2).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final <T> List<T> distinct(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(tArr));
    }

    public static final <T, K> List<T> distinctBy(T[] tArr, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            if (hashSet.add(lVar.invoke(t2))) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> drop(T[] tArr, int i2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(tArr, d.m0.p.coerceAtLeast(tArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final <T> List<T> dropLast(T[] tArr, int i2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(tArr, d.m0.p.coerceAtLeast(tArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final <T> List<T> dropLastWhile(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(tArr[lastIndex]).booleanValue()) {
                return take(tArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final <T> List<T> dropWhile(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (T t2 : tArr) {
            if (z2) {
                arrayList.add(t2);
            } else if (!lVar.invoke(t2).booleanValue()) {
                arrayList.add(t2);
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filter(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            if (lVar.invoke(t2).booleanValue()) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterIndexed(T[] tArr, d.k0.c.p<? super Integer, ? super T, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            T t2 = tArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), t2).booleanValue()) {
                arrayList.add(t2);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(T[] tArr, C c2, d.k0.c.p<? super Integer, ? super T, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            T t2 = tArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), t2).booleanValue()) {
                c2.add(t2);
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Object[] objArr) {
        d.k0.d.t.checkNotNullParameter(objArr, "$this$filterIsInstance");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            d.k0.d.t.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Object[] objArr, C c2) {
        d.k0.d.t.checkNotNullParameter(objArr, "$this$filterIsInstanceTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (Object obj : objArr) {
            d.k0.d.t.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T> List<T> filterNot(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            if (!lVar.invoke(t2).booleanValue()) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterNotNull(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$filterNotNull");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C c2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$filterNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (T t2 : tArr) {
            if (t2 != null) {
                c2.add(t2);
            }
        }
        return c2;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(T[] tArr, C c2, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t2 : tArr) {
            if (!lVar.invoke(t2).booleanValue()) {
                c2.add(t2);
            }
        }
        return c2;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(T[] tArr, C c2, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t2 : tArr) {
            if (lVar.invoke(t2).booleanValue()) {
                c2.add(t2);
            }
        }
        return c2;
    }

    public static final <T> T first(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$first");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    public static final <T> T firstOrNull(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$firstOrNull");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <T, R> List<R> flatMap(T[] tArr, d.k0.c.l<? super T, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(t2));
        }
        return arrayList;
    }

    public static final <T, R> List<R> flatMapSequence(T[] tArr, d.k0.c.l<? super T, ? extends d.o0.m<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(t2));
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(T[] tArr, C c2, d.k0.c.l<? super T, ? extends d.o0.m<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (T t2 : tArr) {
            d.g0.x.addAll(c2, lVar.invoke(t2));
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(T[] tArr, C c2, d.k0.c.l<? super T, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (T t2 : tArr) {
            d.g0.x.addAll(c2, lVar.invoke(t2));
        }
        return c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R fold(T[] tArr, R r2, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (a.a.a aVar : tArr) {
            r2 = pVar.invoke(r2, aVar);
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldIndexed(T[] tArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (a.a.a aVar : tArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, aVar);
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldRight(T[] tArr, R r2, d.k0.c.p<? super T, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(tArr[lastIndex], r2);
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldRightIndexed(T[] tArr, R r2, d.k0.c.q<? super Integer, ? super T, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), tArr[lastIndex], r2);
        }
        return r2;
    }

    public static final <T> void forEach(T[] tArr, d.k0.c.l<? super T, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (T t2 : tArr) {
            lVar.invoke(t2);
        }
    }

    public static final <T> void forEachIndexed(T[] tArr, d.k0.c.p<? super Integer, ? super T, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (T t2 : tArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, t2);
        }
    }

    public static final <T> d.m0.k getIndices(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(tArr));
    }

    public static final <T> int getLastIndex(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$lastIndex");
        return tArr.length - 1;
    }

    public static final <T> T getOrNull(T[] tArr, int i2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(tArr)) {
            return null;
        }
        return tArr[i2];
    }

    public static final <T, K> Map<K, List<T>> groupBy(T[] tArr, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t2 : tArr) {
            K kInvoke = lVar.invoke(t2);
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(t2);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(T[] tArr, M m, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (T t2 : tArr) {
            K kInvoke = lVar.invoke(t2);
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(t2);
        }
        return m;
    }

    public static final <T, K> h0<T, K> groupingBy(T[] tArr, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$groupingBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        return new s(tArr, lVar);
    }

    public static final <T> int indexOf(T[] tArr, T t2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$indexOf");
        int i2 = 0;
        if (t2 == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (d.k0.d.t.areEqual(t2, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(tArr[i2]).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final <T> int indexOfLast(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = tArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(tArr[length]).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final <T> Set<T> intersect(T[] tArr, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super T, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (T t2 : tArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            d.p0.p.appendElement(a2, t2, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String joinToString(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super T, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(objArr, charSequence, charSequence5, charSequence6, i4, charSequence7, lVar);
    }

    public static final <T> T last(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$last");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[getLastIndex(tArr)];
    }

    public static final <T> int lastIndexOf(T[] tArr, T t2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$lastIndexOf");
        if (t2 == null) {
            for (int length = tArr.length - 1; length >= 0; length--) {
                if (tArr[length] == null) {
                    return length;
                }
            }
        } else {
            for (int length2 = tArr.length - 1; length2 >= 0; length2--) {
                if (d.k0.d.t.areEqual(t2, tArr[length2])) {
                    return length2;
                }
            }
        }
        return -1;
    }

    public static final <T> T lastOrNull(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$lastOrNull");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    public static final <T, R> List<R> map(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t2 : tArr) {
            arrayList.add(lVar.invoke(t2));
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexed(T[] tArr, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int i2 = 0;
        for (T t2 : tArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, t2));
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexedNotNull(T[] tArr, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$mapIndexedNotNull");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i3), tArr[i2]);
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(T[] tArr, C c2, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$mapIndexedNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i3), tArr[i2]);
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(T[] tArr, C c2, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (T t2 : tArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, t2));
        }
        return c2;
    }

    public static final <T, R> List<R> mapNotNull(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$mapNotNull");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            R rInvoke = lVar.invoke(t2);
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(T[] tArr, C c2, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$mapNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (T t2 : tArr) {
            R rInvoke = lVar.invoke(t2);
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(T[] tArr, C c2, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (T t2 : tArr) {
            c2.add(lVar.invoke(t2));
        }
        return c2;
    }

    public static final Double max(Double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$max");
        return maxOrNull(dArr);
    }

    public static final <T, R extends Comparable<? super R>> T maxBy(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            R rInvoke = lVar.invoke(t2);
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i2];
                    R rInvoke2 = lVar.invoke(t3);
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        t2 = t3;
                        rInvoke = rInvoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return t2;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrNull(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t2;
        }
        R rInvoke = lVar.invoke(t2);
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i2];
                R rInvoke2 = lVar.invoke(t3);
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    t2 = t3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t2;
    }

    public static final Double maxOrNull(Double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$maxOrNull");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, dArr[i2].doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T maxWith(T[] tArr, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (T) maxWithOrNull(tArr, comparator);
    }

    public static final <T> T maxWithOrNull(T[] tArr, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i2];
                if (comparator.compare(t2, t3) < 0) {
                    t2 = t3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t2;
    }

    public static final Double min(Double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$min");
        return minOrNull(dArr);
    }

    public static final <T, R extends Comparable<? super R>> T minBy(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            R rInvoke = lVar.invoke(t2);
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i2];
                    R rInvoke2 = lVar.invoke(t3);
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        t2 = t3;
                        rInvoke = rInvoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return t2;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrNull(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t2;
        }
        R rInvoke = lVar.invoke(t2);
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i2];
                R rInvoke2 = lVar.invoke(t3);
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    t2 = t3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t2;
    }

    public static final Double minOrNull(Double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$minOrNull");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, dArr[i2].doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T minWith(T[] tArr, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (T) minWithOrNull(tArr, comparator);
    }

    public static final <T> T minWithOrNull(T[] tArr, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i2];
                if (comparator.compare(t2, t3) > 0) {
                    t2 = t3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t2;
    }

    public static final <T> boolean none(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$none");
        return tArr.length == 0;
    }

    public static final <T> d.m<List<T>, List<T>> partition(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : tArr) {
            if (lVar.invoke(t2).booleanValue()) {
                arrayList.add(t2);
            } else {
                arrayList2.add(t2);
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final <T> T random(T[] tArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[fVar.nextInt(tArr.length)];
    }

    public static final <T> T randomOrNull(T[] tArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[fVar.nextInt(tArr.length)];
    }

    public static final <S, T extends S> S reduce(T[] tArr, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sInvoke = (Object) tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                sInvoke = pVar.invoke(sInvoke, (Object) tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return sInvoke;
    }

    public static final <S, T extends S> S reduceIndexed(T[] tArr, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sInvoke = (Object) tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                sInvoke = qVar.invoke(Integer.valueOf(i2), sInvoke, (Object) tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return sInvoke;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(T[] tArr, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        S sInvoke = (Object) tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                sInvoke = qVar.invoke(Integer.valueOf(i2), sInvoke, (Object) tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return sInvoke;
    }

    public static final <S, T extends S> S reduceOrNull(T[] tArr, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        S sInvoke = (Object) tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                sInvoke = pVar.invoke(sInvoke, (Object) tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return sInvoke;
    }

    public static final <S, T extends S> S reduceRight(T[] tArr, d.k0.c.p<? super T, ? super S, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sInvoke = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            sInvoke = pVar.invoke((Object) tArr[i2], sInvoke);
        }
        return sInvoke;
    }

    public static final <S, T extends S> S reduceRightIndexed(T[] tArr, d.k0.c.q<? super Integer, ? super T, ? super S, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sInvoke = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            sInvoke = qVar.invoke(Integer.valueOf(i2), (Object) tArr[i2], sInvoke);
        }
        return sInvoke;
    }

    public static final <S, T extends S> S reduceRightIndexedOrNull(T[] tArr, d.k0.c.q<? super Integer, ? super T, ? super S, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S sInvoke = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            sInvoke = qVar.invoke(Integer.valueOf(i2), (Object) tArr[i2], sInvoke);
        }
        return sInvoke;
    }

    public static final <S, T extends S> S reduceRightOrNull(T[] tArr, d.k0.c.p<? super T, ? super S, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S sInvoke = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            sInvoke = pVar.invoke((Object) tArr[i2], sInvoke);
        }
        return sInvoke;
    }

    public static final <T> T[] requireNoNulls(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$requireNoNulls");
        for (T t2 : tArr) {
            if (t2 == null) {
                throw new IllegalArgumentException("null element found in " + tArr + '.');
            }
        }
        return tArr;
    }

    public static final <T> void reverse(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reverse");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(tArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            T t2 = tArr[i2];
            tArr[i2] = tArr[lastIndex];
            tArr[lastIndex] = t2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final <T> List<T> reversed(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reversed");
        if (tArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<T> mutableList = toMutableList(tArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final <T> T[] reversedArray(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reversedArray");
        int i2 = 0;
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) d.g0.j.arrayOfNulls(tArr, tArr.length);
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            while (true) {
                tArr2[lastIndex - i2] = tArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return tArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> List<R> runningFold(T[] tArr, R r2, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$runningFold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (tArr.length == 0) {
            return d.g0.r.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        for (a.a.a aVar : tArr) {
            r2 = pVar.invoke(r2, aVar);
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> List<R> runningFoldIndexed(T[] tArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$runningFoldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (tArr.length == 0) {
            return d.g0.r.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = qVar.invoke(Integer.valueOf(i2), r2, tArr[i2]);
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduce(T[] tArr, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$runningReduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (tArr.length == 0) {
            return d.g0.s.emptyList();
        }
        S sInvoke = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sInvoke);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            sInvoke = pVar.invoke(sInvoke, (Object) tArr[i2]);
            arrayList.add(sInvoke);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduceIndexed(T[] tArr, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$runningReduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (tArr.length == 0) {
            return d.g0.s.emptyList();
        }
        S sInvoke = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sInvoke);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            sInvoke = qVar.invoke(Integer.valueOf(i2), sInvoke, (Object) tArr[i2]);
            arrayList.add(sInvoke);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> List<R> scan(T[] tArr, R r2, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$scan");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (tArr.length == 0) {
            return d.g0.r.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        for (a.a.a aVar : tArr) {
            r2 = pVar.invoke(r2, aVar);
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> List<R> scanIndexed(T[] tArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$scanIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (tArr.length == 0) {
            return d.g0.r.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = qVar.invoke(Integer.valueOf(i2), r2, tArr[i2]);
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> scanReduce(T[] tArr, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$scanReduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (tArr.length == 0) {
            return d.g0.s.emptyList();
        }
        S sInvoke = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sInvoke);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            sInvoke = pVar.invoke(sInvoke, (Object) tArr[i2]);
            arrayList.add(sInvoke);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> scanReduceIndexed(T[] tArr, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$scanReduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (tArr.length == 0) {
            return d.g0.s.emptyList();
        }
        S sInvoke = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sInvoke);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            sInvoke = qVar.invoke(Integer.valueOf(i2), sInvoke, (Object) tArr[i2]);
            arrayList.add(sInvoke);
        }
        return arrayList;
    }

    public static final <T> void shuffle(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$shuffle");
        shuffle(tArr, d.l0.f.f12668b);
    }

    public static final <T> T single(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$single");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final <T> T singleOrNull(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> List<T> slice(T[] tArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(tArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final <T> T[] sliceArray(T[] tArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        T[] tArr2 = (T[]) d.g0.j.arrayOfNulls(tArr, collection.size());
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            tArr2[i2] = tArr[it.next().intValue()];
            i2++;
        }
        return tArr2;
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        if (tArr.length > 1) {
            d.g0.l.sortWith(tArr, new d.h0.b(lVar));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        if (tArr.length > 1) {
            d.g0.l.sortWith(tArr, new d.h0.c(lVar));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortDescending");
        d.g0.l.sortWith(tArr, d.h0.a.reverseOrder());
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sorted");
        return d.g0.l.asList(sortedArray(tArr));
    }

    public static final <T extends Comparable<? super T>> T[] sortedArray(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortedArray");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        d.k0.d.t.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        Objects.requireNonNull(tArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        d.g0.l.sort(tArr2);
        return tArr2;
    }

    public static final <T extends Comparable<? super T>> T[] sortedArrayDescending(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortedArrayDescending");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        d.k0.d.t.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        d.g0.l.sortWith(tArr2, d.h0.a.reverseOrder());
        return tArr2;
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortedArrayWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        d.k0.d.t.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(tArr, new d.h0.b(lVar));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(T[] tArr, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(tArr, new d.h0.c(lVar));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortedDescending");
        return sortedWith(tArr, d.h0.a.reverseOrder());
    }

    public static final <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return d.g0.l.asList(sortedArrayWith(tArr, comparator));
    }

    public static final <T> Set<T> subtract(T[] tArr, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sum(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sum");
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 += b2;
        }
        return i2;
    }

    public static final <T> int sumBy(T[] tArr, d.k0.c.l<? super T, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (T t2 : tArr) {
            iIntValue += lVar.invoke(t2).intValue();
        }
        return iIntValue;
    }

    public static final <T> double sumByDouble(T[] tArr, d.k0.c.l<? super T, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (T t2 : tArr) {
            dDoubleValue += lVar.invoke(t2).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfByte(Byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sum");
        int iByteValue = 0;
        for (Byte b2 : bArr) {
            iByteValue += b2.byteValue();
        }
        return iByteValue;
    }

    public static final double sumOfDouble(Double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sum");
        double dDoubleValue = 0.0d;
        for (Double d2 : dArr) {
            dDoubleValue += d2.doubleValue();
        }
        return dDoubleValue;
    }

    public static final float sumOfFloat(Float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sum");
        float fFloatValue = 0.0f;
        for (Float f2 : fArr) {
            fFloatValue += f2.floatValue();
        }
        return fFloatValue;
    }

    public static final int sumOfInt(Integer[] numArr) {
        d.k0.d.t.checkNotNullParameter(numArr, "$this$sum");
        int iIntValue = 0;
        for (Integer num : numArr) {
            iIntValue += num.intValue();
        }
        return iIntValue;
    }

    public static final long sumOfLong(Long[] lArr) {
        d.k0.d.t.checkNotNullParameter(lArr, "$this$sum");
        long jLongValue = 0;
        for (Long l2 : lArr) {
            jLongValue += l2.longValue();
        }
        return jLongValue;
    }

    public static final int sumOfShort(Short[] shArr) {
        d.k0.d.t.checkNotNullParameter(shArr, "$this$sum");
        int iShortValue = 0;
        for (Short sh : shArr) {
            iShortValue += sh.shortValue();
        }
        return iShortValue;
    }

    public static final <T> List<T> take(T[] tArr, int i2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= tArr.length) {
            return toList(tArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (T t2 : tArr) {
            arrayList.add(t2);
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final <T> List<T> takeLast(T[] tArr, int i2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = tArr.length;
        if (i2 >= length) {
            return toList(tArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(tArr[i3]);
        }
        return arrayList;
    }

    public static final <T> List<T> takeLastWhile(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(tArr[lastIndex]).booleanValue()) {
                return drop(tArr, lastIndex + 1);
            }
        }
        return toList(tArr);
    }

    public static final <T> List<T> takeWhile(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            if (!lVar.invoke(t2).booleanValue()) {
                break;
            }
            arrayList.add(t2);
        }
        return arrayList;
    }

    public static final boolean[] toBooleanArray(Boolean[] boolArr) {
        d.k0.d.t.checkNotNullParameter(boolArr, "$this$toBooleanArray");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = boolArr[i2].booleanValue();
        }
        return zArr;
    }

    public static final byte[] toByteArray(Byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toByteArray");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = bArr[i2].byteValue();
        }
        return bArr2;
    }

    public static final char[] toCharArray(Character[] chArr) {
        d.k0.d.t.checkNotNullParameter(chArr, "$this$toCharArray");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = chArr[i2].charValue();
        }
        return cArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C c2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (T t2 : tArr) {
            c2.add(t2);
        }
        return c2;
    }

    public static final double[] toDoubleArray(Double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toDoubleArray");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr2[i2] = dArr[i2].doubleValue();
        }
        return dArr2;
    }

    public static final float[] toFloatArray(Float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toFloatArray");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = fArr[i2].floatValue();
        }
        return fArr2;
    }

    public static final <T> HashSet<T> toHashSet(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$toHashSet");
        return (HashSet) toCollection(tArr, new HashSet(q0.mapCapacity(tArr.length)));
    }

    public static final int[] toIntArray(Integer[] numArr) {
        d.k0.d.t.checkNotNullParameter(numArr, "$this$toIntArray");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public static final <T> List<T> toList(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$toList");
        int length = tArr.length;
        return length != 0 ? length != 1 ? toMutableList(tArr) : d.g0.r.listOf(tArr[0]) : d.g0.s.emptyList();
    }

    public static final long[] toLongArray(Long[] lArr) {
        d.k0.d.t.checkNotNullParameter(lArr, "$this$toLongArray");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = lArr[i2].longValue();
        }
        return jArr;
    }

    public static final <T> List<T> toMutableList(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$toMutableList");
        return new ArrayList(d.g0.s.asCollection(tArr));
    }

    public static final <T> Set<T> toMutableSet(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$toMutableSet");
        return (Set) toCollection(tArr, new LinkedHashSet(q0.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> toSet(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$toSet");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) toCollection(tArr, new LinkedHashSet(q0.mapCapacity(tArr.length))) : y0.setOf(tArr[0]) : z0.emptySet();
    }

    public static final short[] toShortArray(Short[] shArr) {
        d.k0.d.t.checkNotNullParameter(shArr, "$this$toShortArray");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i2 = 0; i2 < length; i2++) {
            sArr[i2] = shArr[i2].shortValue();
        }
        return sArr;
    }

    public static final <T> Set<T> union(T[] tArr, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final <T> Iterable<i0<T>> withIndex(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$withIndex");
        return new j0(new t(tArr));
    }

    public static final <T, R, V> List<V> zip(T[] tArr, R[] rArr, d.k0.c.p<? super T, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(tArr[i2], rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean all(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (byte b2 : bArr) {
            if (!lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$any");
        return !(bArr.length == 0);
    }

    public static final double average(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (short s2 : sArr) {
            d2 += (double) s2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(byte[] bArr, byte b2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$contains");
        return indexOf(bArr, b2) >= 0;
    }

    public static final int count(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final List<Byte> distinct(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(bArr));
    }

    public static final <C extends Collection<? super Byte>> C filterNotTo(byte[] bArr, C c2, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (byte b2 : bArr) {
            if (!lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                c2.add(Byte.valueOf(b2));
            }
        }
        return c2;
    }

    public static final <C extends Collection<? super Byte>> C filterTo(byte[] bArr, C c2, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                c2.add(Byte.valueOf(b2));
            }
        }
        return c2;
    }

    public static final Byte firstOrNull(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$firstOrNull");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    public static final <R> R fold(byte[] bArr, R r2, d.k0.c.p<? super R, ? super Byte, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (byte b2 : bArr) {
            r2 = pVar.invoke(r2, Byte.valueOf(b2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(byte[] bArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super Byte, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (byte b2 : bArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, Byte.valueOf(b2));
        }
        return r2;
    }

    public static final void forEach(byte[] bArr, d.k0.c.l<? super Byte, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (byte b2 : bArr) {
            lVar.invoke(Byte.valueOf(b2));
        }
    }

    public static final void forEachIndexed(byte[] bArr, d.k0.c.p<? super Integer, ? super Byte, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (byte b2 : bArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Byte.valueOf(b2));
        }
    }

    public static final d.m0.k getIndices(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(bArr));
    }

    public static final int getLastIndex(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$lastIndex");
        return bArr.length - 1;
    }

    public static final Byte getOrNull(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(bArr)) {
            return null;
        }
        return Byte.valueOf(bArr[i2]);
    }

    public static final String joinToString(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Byte, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(bArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (d.k0.c.l<? super Byte, ? extends CharSequence>) lVar);
    }

    public static final Byte lastOrNull(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$lastOrNull");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    public static final Float max(Float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$max");
        return maxOrNull(fArr);
    }

    public static final Byte maxWith(byte[] bArr, Comparator<? super Byte> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(bArr, comparator);
    }

    public static final Float min(Float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$min");
        return minOrNull(fArr);
    }

    public static final Byte minWith(byte[] bArr, Comparator<? super Byte> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(bArr, comparator);
    }

    public static final boolean none(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$none");
        return bArr.length == 0;
    }

    public static final void shuffle(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$shuffle");
        shuffle(bArr, (d.l0.f) d.l0.f.f12668b);
    }

    public static final Byte singleOrNull(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$singleOrNull");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final void sortDescending(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortDescending");
        if (bArr.length > 1) {
            d.g0.l.sort(bArr);
            reverse(bArr);
        }
    }

    public static final List<Byte> sorted(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sorted");
        Byte[] typedArray = d.g0.l.toTypedArray(bArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        d.g0.l.sort(typedArray);
        return d.g0.l.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Byte> sortedBy(byte[] bArr, d.k0.c.l<? super Byte, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new d.h0.b(lVar));
    }

    public static final <R extends Comparable<? super R>> List<Byte> sortedByDescending(byte[] bArr, d.k0.c.l<? super Byte, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new d.h0.c(lVar));
    }

    public static final List<Byte> sortedDescending(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(bArrCopyOf);
        return reversed(bArrCopyOf);
    }

    public static final List<Byte> sortedWith(byte[] bArr, Comparator<? super Byte> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Byte[] typedArray = d.g0.l.toTypedArray(bArr);
        d.g0.l.sortWith(typedArray, comparator);
        return d.g0.l.asList(typedArray);
    }

    public static final int sum(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sum");
        int i2 = 0;
        for (short s2 : sArr) {
            i2 += s2;
        }
        return i2;
    }

    public static final HashSet<Byte> toHashSet(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toHashSet");
        return (HashSet) toCollection(bArr, new HashSet(q0.mapCapacity(bArr.length)));
    }

    public static final List<Byte> toMutableList(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static final Set<Byte> toMutableSet(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toMutableSet");
        return (Set) toCollection(bArr, new LinkedHashSet(q0.mapCapacity(bArr.length)));
    }

    public static final Iterable<i0<Byte>> withIndex(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$withIndex");
        return new j0(new u(bArr));
    }

    public static final boolean all(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (short s2 : sArr) {
            if (!lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$any");
        return !(sArr.length == 0);
    }

    public static final Iterable<Byte> asIterable(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$asIterable");
        return bArr.length == 0 ? d.g0.s.emptyList() : new b(bArr);
    }

    public static final d.o0.m<Byte> asSequence(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$asSequence");
        return bArr.length == 0 ? d.o0.r.emptySequence() : new k(bArr);
    }

    public static final <K, M extends Map<? super K, ? super Byte>> M associateByTo(byte[] bArr, M m, d.k0.c.l<? super Byte, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (byte b2 : bArr) {
            m.put(lVar.invoke(Byte.valueOf(b2)), Byte.valueOf(b2));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(byte[] bArr, M m, d.k0.c.l<? super Byte, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (byte b2 : bArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Byte.valueOf(b2));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final double average(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (int i3 : iArr) {
            d2 += (double) i3;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(short[] sArr, short s2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$contains");
        return indexOf(sArr, s2) >= 0;
    }

    public static final int count(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final List<Short> distinct(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(sArr));
    }

    public static final List<Byte> drop(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(bArr, d.m0.p.coerceAtLeast(bArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Byte> dropLast(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(bArr, d.m0.p.coerceAtLeast(bArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Byte> filter(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Byte>> C filterIndexedTo(byte[] bArr, C c2, d.k0.c.p<? super Integer, ? super Byte, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Byte.valueOf(b2)).booleanValue()) {
                c2.add(Byte.valueOf(b2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final List<Byte> filterNot(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (!lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C filterNotTo(short[] sArr, C c2, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (short s2 : sArr) {
            if (!lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                c2.add(Short.valueOf(s2));
            }
        }
        return c2;
    }

    public static final <C extends Collection<? super Short>> C filterTo(short[] sArr, C c2, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                c2.add(Short.valueOf(s2));
            }
        }
        return c2;
    }

    public static final Short firstOrNull(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$firstOrNull");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    public static final <R> R fold(short[] sArr, R r2, d.k0.c.p<? super R, ? super Short, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (short s2 : sArr) {
            r2 = pVar.invoke(r2, Short.valueOf(s2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(short[] sArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super Short, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (short s2 : sArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, Short.valueOf(s2));
        }
        return r2;
    }

    public static final <R> R foldRight(byte[] bArr, R r2, d.k0.c.p<? super Byte, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(Byte.valueOf(bArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(byte[] bArr, R r2, d.k0.c.q<? super Integer, ? super Byte, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), Byte.valueOf(bArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(short[] sArr, d.k0.c.l<? super Short, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (short s2 : sArr) {
            lVar.invoke(Short.valueOf(s2));
        }
    }

    public static final void forEachIndexed(short[] sArr, d.k0.c.p<? super Integer, ? super Short, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (short s2 : sArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Short.valueOf(s2));
        }
    }

    public static final d.m0.k getIndices(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(sArr));
    }

    public static final int getLastIndex(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$lastIndex");
        return sArr.length - 1;
    }

    public static final Short getOrNull(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(sArr)) {
            return null;
        }
        return Short.valueOf(sArr[i2]);
    }

    public static final int indexOfFirst(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Byte.valueOf(bArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(Byte.valueOf(bArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final Set<Byte> intersect(byte[] bArr, Iterable<Byte> iterable) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final String joinToString(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Short, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(sArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(sArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (d.k0.c.l<? super Short, ? extends CharSequence>) lVar);
    }

    public static final Short lastOrNull(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$lastOrNull");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(byte[] bArr, C c2, d.k0.c.p<? super Integer, ? super Byte, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (byte b2 : bArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Byte.valueOf(b2)));
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(byte[] bArr, C c2, d.k0.c.l<? super Byte, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (byte b2 : bArr) {
            c2.add(lVar.invoke(Byte.valueOf(b2)));
        }
        return c2;
    }

    public static final <T extends Comparable<? super T>> T max(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$max");
        return (T) maxOrNull(tArr);
    }

    public static final Short maxWith(short[] sArr, Comparator<? super Short> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(sArr, comparator);
    }

    public static final <T extends Comparable<? super T>> T min(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$min");
        return (T) minOrNull(tArr);
    }

    public static final Short minWith(short[] sArr, Comparator<? super Short> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(sArr, comparator);
    }

    public static final boolean none(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$none");
        return sArr.length == 0;
    }

    public static final Byte randomOrNull(byte[] bArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[fVar.nextInt(bArr.length)]);
    }

    public static final void shuffle(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$shuffle");
        shuffle(sArr, (d.l0.f) d.l0.f.f12668b);
    }

    public static final Short singleOrNull(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$singleOrNull");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    public static final List<Byte> slice(byte[] bArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(bArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final List<Short> sorted(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sorted");
        Short[] typedArray = d.g0.l.toTypedArray(sArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        d.g0.l.sort(typedArray);
        return d.g0.l.asList(typedArray);
    }

    public static final byte[] sortedArray(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedArray");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final byte[] sortedArrayDescending(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedArrayDescending");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Short> sortedBy(short[] sArr, d.k0.c.l<? super Short, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new d.h0.b(lVar));
    }

    public static final <R extends Comparable<? super R>> List<Short> sortedByDescending(short[] sArr, d.k0.c.l<? super Short, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new d.h0.c(lVar));
    }

    public static final List<Short> sortedDescending(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(sArrCopyOf);
        return reversed(sArrCopyOf);
    }

    public static final List<Short> sortedWith(short[] sArr, Comparator<? super Short> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Short[] typedArray = d.g0.l.toTypedArray(sArr);
        d.g0.l.sortWith(typedArray, comparator);
        return d.g0.l.asList(typedArray);
    }

    public static final Set<Byte> subtract(byte[] bArr, Iterable<Byte> iterable) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sum(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sum");
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    public static final int sumBy(byte[] bArr, d.k0.c.l<? super Byte, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (byte b2 : bArr) {
            iIntValue += lVar.invoke(Byte.valueOf(b2)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(byte[] bArr, d.k0.c.l<? super Byte, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (byte b2 : bArr) {
            dDoubleValue += lVar.invoke(Byte.valueOf(b2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final <C extends Collection<? super Byte>> C toCollection(byte[] bArr, C c2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (byte b2 : bArr) {
            c2.add(Byte.valueOf(b2));
        }
        return c2;
    }

    public static final HashSet<Short> toHashSet(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toHashSet");
        return (HashSet) toCollection(sArr, new HashSet(q0.mapCapacity(sArr.length)));
    }

    public static final Set<Short> toMutableSet(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toMutableSet");
        return (Set) toCollection(sArr, new LinkedHashSet(q0.mapCapacity(sArr.length)));
    }

    public static final Set<Byte> union(byte[] bArr, Iterable<Byte> iterable) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final Iterable<i0<Short>> withIndex(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$withIndex");
        return new j0(new v(sArr));
    }

    public static final boolean all(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 : iArr) {
            if (!lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$any");
        return !(iArr.length == 0);
    }

    public static final double average(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (long j2 : jArr) {
            d2 += j2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$contains");
        return indexOf(iArr, i2) >= 0;
    }

    public static final int count(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (int i3 : iArr) {
            if (lVar.invoke(Integer.valueOf(i3)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final List<Integer> distinct(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(iArr));
    }

    public static final List<Byte> filterIndexed(byte[] bArr, d.k0.c.p<? super Integer, ? super Byte, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Integer>> C filterNotTo(int[] iArr, C c2, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 : iArr) {
            if (!lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                c2.add(Integer.valueOf(i2));
            }
        }
        return c2;
    }

    public static final <C extends Collection<? super Integer>> C filterTo(int[] iArr, C c2, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                c2.add(Integer.valueOf(i2));
            }
        }
        return c2;
    }

    public static final byte first(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$first");
        if (!(bArr.length == 0)) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer firstOrNull(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$firstOrNull");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(byte[] bArr, C c2, d.k0.c.l<? super Byte, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (byte b2 : bArr) {
            d.g0.x.addAll(c2, lVar.invoke(Byte.valueOf(b2)));
        }
        return c2;
    }

    public static final <R> R fold(int[] iArr, R r2, d.k0.c.p<? super R, ? super Integer, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int i2 : iArr) {
            r2 = pVar.invoke(r2, Integer.valueOf(i2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(int[] iArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super Integer, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (int i3 : iArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, Integer.valueOf(i3));
        }
        return r2;
    }

    public static final void forEach(int[] iArr, d.k0.c.l<? super Integer, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (int i2 : iArr) {
            lVar.invoke(Integer.valueOf(i2));
        }
    }

    public static final void forEachIndexed(int[] iArr, d.k0.c.p<? super Integer, ? super Integer, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (int i3 : iArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Integer.valueOf(i3));
        }
    }

    public static final d.m0.k getIndices(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(iArr));
    }

    public static final int getLastIndex(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$lastIndex");
        return iArr.length - 1;
    }

    public static final Integer getOrNull(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i2]);
    }

    public static final String joinToString(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Integer, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(iArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(iArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (d.k0.c.l<? super Integer, ? extends CharSequence>) lVar);
    }

    public static final byte last(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$last");
        if (!(bArr.length == 0)) {
            return bArr[getLastIndex(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer lastOrNull(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$lastOrNull");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    public static final <R> List<R> map(byte[] bArr, d.k0.c.l<? super Byte, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(lVar.invoke(Byte.valueOf(b2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(byte[] bArr, d.k0.c.p<? super Integer, ? super Byte, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int i2 = 0;
        for (byte b2 : bArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Byte.valueOf(b2)));
        }
        return arrayList;
    }

    public static final Byte max(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$max");
        return maxOrNull(bArr);
    }

    public static final Integer maxWith(int[] iArr, Comparator<? super Integer> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(iArr, comparator);
    }

    public static final Byte min(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$min");
        return minOrNull(bArr);
    }

    public static final Integer minWith(int[] iArr, Comparator<? super Integer> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(iArr, comparator);
    }

    public static final boolean none(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$none");
        return iArr.length == 0;
    }

    public static final byte random(byte[] bArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (!(bArr.length == 0)) {
            return bArr[fVar.nextInt(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Byte reduceRightIndexedOrNull(byte[] bArr, d.k0.c.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte bByteValue = bArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            bByteValue = qVar.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i2]), Byte.valueOf(bByteValue)).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    public static final Byte reduceRightOrNull(byte[] bArr, d.k0.c.p<? super Byte, ? super Byte, Byte> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte bByteValue = bArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            bByteValue = pVar.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(bByteValue)).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    public static final List<Byte> reversed(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reversed");
        if (bArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<Byte> mutableList = toMutableList(bArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final void shuffle(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$shuffle");
        shuffle(iArr, (d.l0.f) d.l0.f.f12668b);
    }

    public static final Integer singleOrNull(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$singleOrNull");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static final byte[] sliceArray(byte[] bArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        byte[] bArr2 = new byte[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            bArr2[i2] = bArr[it.next().intValue()];
            i2++;
        }
        return bArr2;
    }

    public static final List<Integer> sorted(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sorted");
        Integer[] typedArray = d.g0.l.toTypedArray(iArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        d.g0.l.sort(typedArray);
        return d.g0.l.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Integer> sortedBy(int[] iArr, d.k0.c.l<? super Integer, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new d.h0.b(lVar));
    }

    public static final <R extends Comparable<? super R>> List<Integer> sortedByDescending(int[] iArr, d.k0.c.l<? super Integer, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new d.h0.c(lVar));
    }

    public static final List<Integer> sortedDescending(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(iArrCopyOf);
        return reversed(iArrCopyOf);
    }

    public static final List<Integer> sortedWith(int[] iArr, Comparator<? super Integer> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Integer[] typedArray = d.g0.l.toTypedArray(iArr);
        d.g0.l.sortWith(typedArray, comparator);
        return d.g0.l.asList(typedArray);
    }

    public static final long sum(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sum");
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += j3;
        }
        return j2;
    }

    public static final HashSet<Integer> toHashSet(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toHashSet");
        return (HashSet) toCollection(iArr, new HashSet(q0.mapCapacity(iArr.length)));
    }

    public static final List<Short> toMutableList(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s2 : sArr) {
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    public static final Set<Integer> toMutableSet(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toMutableSet");
        return (Set) toCollection(iArr, new LinkedHashSet(q0.mapCapacity(iArr.length)));
    }

    public static final Iterable<i0<Integer>> withIndex(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$withIndex");
        return new j0(new w(iArr));
    }

    public static final <R, V> List<V> zip(byte[] bArr, R[] rArr, d.k0.c.p<? super Byte, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Byte.valueOf(bArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean all(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (long j2 : jArr) {
            if (!lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$any");
        return !(jArr.length == 0);
    }

    public static final Iterable<Short> asIterable(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$asIterable");
        return sArr.length == 0 ? d.g0.s.emptyList() : new c(sArr);
    }

    public static final d.o0.m<Short> asSequence(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$asSequence");
        return sArr.length == 0 ? d.o0.r.emptySequence() : new l(sArr);
    }

    public static final <K, V> Map<K, V> associate(byte[] bArr, d.k0.c.l<? super Byte, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(bArr.length), 16));
        for (byte b2 : bArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Byte.valueOf(b2));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Byte> associateBy(byte[] bArr, d.k0.c.l<? super Byte, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(bArr.length), 16));
        for (byte b2 : bArr) {
            linkedHashMap.put(lVar.invoke(Byte.valueOf(b2)), Byte.valueOf(b2));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, ? super Short>> M associateByTo(short[] sArr, M m, d.k0.c.l<? super Short, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (short s2 : sArr) {
            m.put(lVar.invoke(Short.valueOf(s2)), Short.valueOf(s2));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(short[] sArr, M m, d.k0.c.l<? super Short, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (short s2 : sArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Short.valueOf(s2));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final double average(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (float f2 : fArr) {
            d2 += (double) f2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(long[] jArr, long j2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$contains");
        return indexOf(jArr, j2) >= 0;
    }

    public static final int count(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final List<Long> distinct(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(jArr));
    }

    public static final List<Short> drop(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(sArr, d.m0.p.coerceAtLeast(sArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Short> dropLast(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(sArr, d.m0.p.coerceAtLeast(sArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Byte> dropLastWhile(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Byte.valueOf(bArr[lastIndex])).booleanValue()) {
                return take(bArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final List<Short> filter(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C filterIndexedTo(short[] sArr, C c2, d.k0.c.p<? super Integer, ? super Short, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            short s2 = sArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Short.valueOf(s2)).booleanValue()) {
                c2.add(Short.valueOf(s2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final List<Short> filterNot(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (!lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C filterNotTo(long[] jArr, C c2, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (long j2 : jArr) {
            if (!lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                c2.add(Long.valueOf(j2));
            }
        }
        return c2;
    }

    public static final <C extends Collection<? super Long>> C filterTo(long[] jArr, C c2, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                c2.add(Long.valueOf(j2));
            }
        }
        return c2;
    }

    public static final Long firstOrNull(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$firstOrNull");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    public static final <R> List<R> flatMap(byte[] bArr, d.k0.c.l<? super Byte, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(Byte.valueOf(b2)));
        }
        return arrayList;
    }

    public static final <R> R fold(long[] jArr, R r2, d.k0.c.p<? super R, ? super Long, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (long j2 : jArr) {
            r2 = pVar.invoke(r2, Long.valueOf(j2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(long[] jArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super Long, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (long j2 : jArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, Long.valueOf(j2));
        }
        return r2;
    }

    public static final <R> R foldRight(short[] sArr, R r2, d.k0.c.p<? super Short, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(Short.valueOf(sArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(short[] sArr, R r2, d.k0.c.q<? super Integer, ? super Short, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), Short.valueOf(sArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(long[] jArr, d.k0.c.l<? super Long, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (long j2 : jArr) {
            lVar.invoke(Long.valueOf(j2));
        }
    }

    public static final void forEachIndexed(long[] jArr, d.k0.c.p<? super Integer, ? super Long, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (long j2 : jArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Long.valueOf(j2));
        }
    }

    public static final d.m0.k getIndices(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(jArr));
    }

    public static final int getLastIndex(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$lastIndex");
        return jArr.length - 1;
    }

    public static final Long getOrNull(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(jArr)) {
            return null;
        }
        return Long.valueOf(jArr[i2]);
    }

    public static final int indexOf(byte[] bArr, byte b2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$indexOf");
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (b2 == bArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Short.valueOf(sArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = sArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(Short.valueOf(sArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final Set<Short> intersect(short[] sArr, Iterable<Short> iterable) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final String joinToString(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Long, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(jArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(jArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (d.k0.c.l<? super Long, ? extends CharSequence>) lVar);
    }

    public static final int lastIndexOf(byte[] bArr, byte b2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$lastIndexOf");
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (b2 == bArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final Long lastOrNull(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$lastOrNull");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(short[] sArr, C c2, d.k0.c.p<? super Integer, ? super Short, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (short s2 : sArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Short.valueOf(s2)));
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(short[] sArr, C c2, d.k0.c.l<? super Short, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (short s2 : sArr) {
            c2.add(lVar.invoke(Short.valueOf(s2)));
        }
        return c2;
    }

    public static final Short max(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$max");
        return maxOrNull(sArr);
    }

    public static final Long maxWith(long[] jArr, Comparator<? super Long> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(jArr, comparator);
    }

    public static final Short min(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$min");
        return minOrNull(sArr);
    }

    public static final Long minWith(long[] jArr, Comparator<? super Long> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(jArr, comparator);
    }

    public static final boolean none(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$none");
        return jArr.length == 0;
    }

    public static final Short randomOrNull(short[] sArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[fVar.nextInt(sArr.length)]);
    }

    public static final Byte reduceIndexedOrNull(byte[] bArr, d.k0.c.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                bByteValue = qVar.invoke(Integer.valueOf(i2), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i2])).byteValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(bByteValue);
    }

    public static final Byte reduceOrNull(byte[] bArr, d.k0.c.p<? super Byte, ? super Byte, Byte> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                bByteValue = pVar.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i2])).byteValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(bByteValue);
    }

    public static final byte reduceRight(byte[] bArr, d.k0.c.p<? super Byte, ? super Byte, Byte> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte bByteValue = bArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                bByteValue = pVar.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(bByteValue)).byteValue();
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceRightIndexed(byte[] bArr, d.k0.c.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte bByteValue = bArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                bByteValue = qVar.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i2]), Byte.valueOf(bByteValue)).byteValue();
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte[] reversedArray(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reversedArray");
        int i2 = 0;
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            while (true) {
                bArr2[lastIndex - i2] = bArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return bArr2;
    }

    public static final void shuffle(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$shuffle");
        shuffle(jArr, (d.l0.f) d.l0.f.f12668b);
    }

    public static final byte single(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$single");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return bArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Long singleOrNull(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$singleOrNull");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    public static final List<Short> slice(short[] sArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(sArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortDescending");
        if (sArr.length > 1) {
            d.g0.l.sort(sArr);
            reverse(sArr);
        }
    }

    public static final List<Long> sorted(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sorted");
        Long[] typedArray = d.g0.l.toTypedArray(jArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        d.g0.l.sort(typedArray);
        return d.g0.l.asList(typedArray);
    }

    public static final short[] sortedArray(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedArray");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(sArrCopyOf);
        return sArrCopyOf;
    }

    public static final short[] sortedArrayDescending(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedArrayDescending");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(sArrCopyOf);
        return sArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Long> sortedBy(long[] jArr, d.k0.c.l<? super Long, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new d.h0.b(lVar));
    }

    public static final <R extends Comparable<? super R>> List<Long> sortedByDescending(long[] jArr, d.k0.c.l<? super Long, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new d.h0.c(lVar));
    }

    public static final List<Long> sortedDescending(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(jArrCopyOf);
        return reversed(jArrCopyOf);
    }

    public static final List<Long> sortedWith(long[] jArr, Comparator<? super Long> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Long[] typedArray = d.g0.l.toTypedArray(jArr);
        d.g0.l.sortWith(typedArray, comparator);
        return d.g0.l.asList(typedArray);
    }

    public static final Set<Short> subtract(short[] sArr, Iterable<Short> iterable) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final float sum(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sum");
        float f2 = 0.0f;
        for (float f3 : fArr) {
            f2 += f3;
        }
        return f2;
    }

    public static final int sumBy(short[] sArr, d.k0.c.l<? super Short, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (short s2 : sArr) {
            iIntValue += lVar.invoke(Short.valueOf(s2)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(short[] sArr, d.k0.c.l<? super Short, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (short s2 : sArr) {
            dDoubleValue += lVar.invoke(Short.valueOf(s2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final List<Byte> takeLastWhile(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Byte.valueOf(bArr[lastIndex])).booleanValue()) {
                return drop(bArr, lastIndex + 1);
            }
        }
        return toList(bArr);
    }

    public static final List<Byte> takeWhile(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (!lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C toCollection(short[] sArr, C c2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (short s2 : sArr) {
            c2.add(Short.valueOf(s2));
        }
        return c2;
    }

    public static final HashSet<Long> toHashSet(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toHashSet");
        return (HashSet) toCollection(jArr, new HashSet(q0.mapCapacity(jArr.length)));
    }

    public static final List<Byte> toList(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toList");
        int length = bArr.length;
        if (length == 0) {
            return d.g0.s.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return d.g0.r.listOf(Byte.valueOf(bArr[0]));
    }

    public static final Set<Long> toMutableSet(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toMutableSet");
        return (Set) toCollection(jArr, new LinkedHashSet(q0.mapCapacity(jArr.length)));
    }

    public static final Set<Byte> toSet(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toSet");
        int length = bArr.length;
        if (length == 0) {
            return z0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(bArr, new LinkedHashSet(q0.mapCapacity(bArr.length)));
        }
        return y0.setOf(Byte.valueOf(bArr[0]));
    }

    public static final Set<Short> union(short[] sArr, Iterable<Short> iterable) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final Iterable<i0<Long>> withIndex(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$withIndex");
        return new j0(new x(jArr));
    }

    public static final boolean all(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (float f2 : fArr) {
            if (!lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$any");
        return !(fArr.length == 0);
    }

    public static final double average(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (double d3 : dArr) {
            d2 += d3;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(float[] fArr, float f2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$contains");
        return indexOf(fArr, f2) >= 0;
    }

    public static final int count(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final List<Float> distinct(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(fArr));
    }

    public static final List<Byte> dropWhile(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (byte b2 : bArr) {
            if (z2) {
                arrayList.add(Byte.valueOf(b2));
            } else if (!lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Float>> C filterNotTo(float[] fArr, C c2, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (float f2 : fArr) {
            if (!lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                c2.add(Float.valueOf(f2));
            }
        }
        return c2;
    }

    public static final <C extends Collection<? super Float>> C filterTo(float[] fArr, C c2, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                c2.add(Float.valueOf(f2));
            }
        }
        return c2;
    }

    public static final Float firstOrNull(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$firstOrNull");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final <R> R fold(float[] fArr, R r2, d.k0.c.p<? super R, ? super Float, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (float f2 : fArr) {
            r2 = pVar.invoke(r2, Float.valueOf(f2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(float[] fArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super Float, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (float f2 : fArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, Float.valueOf(f2));
        }
        return r2;
    }

    public static final void forEach(float[] fArr, d.k0.c.l<? super Float, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (float f2 : fArr) {
            lVar.invoke(Float.valueOf(f2));
        }
    }

    public static final void forEachIndexed(float[] fArr, d.k0.c.p<? super Integer, ? super Float, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (float f2 : fArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Float.valueOf(f2));
        }
    }

    public static final d.m0.k getIndices(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(fArr));
    }

    public static final int getLastIndex(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$lastIndex");
        return fArr.length - 1;
    }

    public static final Float getOrNull(float[] fArr, int i2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(fArr)) {
            return null;
        }
        return Float.valueOf(fArr[i2]);
    }

    public static final String joinToString(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Float, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(fArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(fArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (d.k0.c.l<? super Float, ? extends CharSequence>) lVar);
    }

    public static final Float lastOrNull(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$lastOrNull");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    public static final Integer max(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$max");
        return maxOrNull(iArr);
    }

    public static final Float maxWith(float[] fArr, Comparator<? super Float> comparator) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(fArr, comparator);
    }

    public static final Byte maxWithOrNull(byte[] bArr, Comparator<? super Byte> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (comparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) < 0) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final Integer min(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$min");
        return minOrNull(iArr);
    }

    public static final Float minWith(float[] fArr, Comparator<? super Float> comparator) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(fArr, comparator);
    }

    public static final Byte minWithOrNull(byte[] bArr, Comparator<? super Byte> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (comparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) > 0) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final boolean none(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$none");
        return fArr.length == 0;
    }

    public static final byte reduce(byte[] bArr, d.k0.c.p<? super Byte, ? super Byte, Byte> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (!(bArr.length == 0)) {
            byte bByteValue = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    bByteValue = pVar.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i2])).byteValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceIndexed(byte[] bArr, d.k0.c.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (!(bArr.length == 0)) {
            byte bByteValue = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    bByteValue = qVar.invoke(Integer.valueOf(i2), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i2])).byteValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reverse");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(bArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[lastIndex];
            bArr[lastIndex] = b2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final void shuffle(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$shuffle");
        shuffle(fArr, (d.l0.f) d.l0.f.f12668b);
    }

    public static final Float singleOrNull(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$singleOrNull");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    public static final List<Float> sorted(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sorted");
        Float[] typedArray = d.g0.l.toTypedArray(fArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        d.g0.l.sort(typedArray);
        return d.g0.l.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Float> sortedBy(float[] fArr, d.k0.c.l<? super Float, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new d.h0.b(lVar));
    }

    public static final <R extends Comparable<? super R>> List<Float> sortedByDescending(float[] fArr, d.k0.c.l<? super Float, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new d.h0.c(lVar));
    }

    public static final List<Float> sortedDescending(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sortedDescending");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        d.k0.d.t.checkNotNullExpressionValue(fArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(fArrCopyOf);
        return reversed(fArrCopyOf);
    }

    public static final List<Float> sortedWith(float[] fArr, Comparator<? super Float> comparator) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Float[] typedArray = d.g0.l.toTypedArray(fArr);
        d.g0.l.sortWith(typedArray, comparator);
        return d.g0.l.asList(typedArray);
    }

    public static final double sum(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sum");
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += d3;
        }
        return d2;
    }

    public static final HashSet<Float> toHashSet(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toHashSet");
        return (HashSet) toCollection(fArr, new HashSet(q0.mapCapacity(fArr.length)));
    }

    public static final List<Integer> toMutableList(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    public static final Set<Float> toMutableSet(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toMutableSet");
        return (Set) toCollection(fArr, new LinkedHashSet(q0.mapCapacity(fArr.length)));
    }

    public static final Iterable<i0<Float>> withIndex(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$withIndex");
        return new j0(new y(fArr));
    }

    public static final boolean all(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (double d2 : dArr) {
            if (!lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$any");
        return !(dArr.length == 0);
    }

    public static final Iterable<Integer> asIterable(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$asIterable");
        return iArr.length == 0 ? d.g0.s.emptyList() : new d(iArr);
    }

    public static final d.o0.m<Integer> asSequence(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$asSequence");
        return iArr.length == 0 ? d.o0.r.emptySequence() : new C0236m(iArr);
    }

    public static final <K, M extends Map<? super K, ? super Integer>> M associateByTo(int[] iArr, M m, d.k0.c.l<? super Integer, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (int i2 : iArr) {
            m.put(lVar.invoke(Integer.valueOf(i2)), Integer.valueOf(i2));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(int[] iArr, M m, d.k0.c.l<? super Integer, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (int i2 : iArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Integer.valueOf(i2));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final boolean contains(double[] dArr, double d2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$contains");
        return indexOf(dArr, d2) >= 0;
    }

    public static final int count(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final List<Double> distinct(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(dArr));
    }

    public static final <K> List<Byte> distinctBy(byte[] bArr, d.k0.c.l<? super Byte, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (hashSet.add(lVar.invoke(Byte.valueOf(b2)))) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    public static final List<Integer> drop(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(iArr, d.m0.p.coerceAtLeast(iArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Integer> dropLast(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(iArr, d.m0.p.coerceAtLeast(iArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Integer> filter(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    public static final List<Short> filterIndexed(short[] sArr, d.k0.c.p<? super Integer, ? super Short, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            short s2 = sArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Integer>> C filterIndexedTo(int[] iArr, C c2, d.k0.c.p<? super Integer, ? super Integer, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Integer.valueOf(i4)).booleanValue()) {
                c2.add(Integer.valueOf(i4));
            }
            i2++;
            i3 = i5;
        }
        return c2;
    }

    public static final List<Integer> filterNot(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (!lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C filterNotTo(double[] dArr, C c2, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (double d2 : dArr) {
            if (!lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                c2.add(Double.valueOf(d2));
            }
        }
        return c2;
    }

    public static final <C extends Collection<? super Double>> C filterTo(double[] dArr, C c2, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                c2.add(Double.valueOf(d2));
            }
        }
        return c2;
    }

    public static final short first(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$first");
        if (!(sArr.length == 0)) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double firstOrNull(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$firstOrNull");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(short[] sArr, C c2, d.k0.c.l<? super Short, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (short s2 : sArr) {
            d.g0.x.addAll(c2, lVar.invoke(Short.valueOf(s2)));
        }
        return c2;
    }

    public static final <R> R fold(double[] dArr, R r2, d.k0.c.p<? super R, ? super Double, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (double d2 : dArr) {
            r2 = pVar.invoke(r2, Double.valueOf(d2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(double[] dArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super Double, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (double d2 : dArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, Double.valueOf(d2));
        }
        return r2;
    }

    public static final <R> R foldRight(int[] iArr, R r2, d.k0.c.p<? super Integer, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(Integer.valueOf(iArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(int[] iArr, R r2, d.k0.c.q<? super Integer, ? super Integer, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), Integer.valueOf(iArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(double[] dArr, d.k0.c.l<? super Double, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (double d2 : dArr) {
            lVar.invoke(Double.valueOf(d2));
        }
    }

    public static final void forEachIndexed(double[] dArr, d.k0.c.p<? super Integer, ? super Double, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (double d2 : dArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Double.valueOf(d2));
        }
    }

    public static final d.m0.k getIndices(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(dArr));
    }

    public static final int getLastIndex(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$lastIndex");
        return dArr.length - 1;
    }

    public static final Double getOrNull(double[] dArr, int i2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(dArr)) {
            return null;
        }
        return Double.valueOf(dArr[i2]);
    }

    public static final int indexOf(short[] sArr, short s2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$indexOf");
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (s2 == sArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Integer.valueOf(iArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(Integer.valueOf(iArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final Set<Integer> intersect(int[] iArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final <A extends Appendable> A joinTo(byte[] bArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Byte, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (byte b2 : bArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Byte.valueOf(b2)));
            } else {
                a2.append(String.valueOf((int) b2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final String joinToString(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Double, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(dArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(dArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (d.k0.c.l<? super Double, ? extends CharSequence>) lVar);
    }

    public static final short last(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$last");
        if (!(sArr.length == 0)) {
            return sArr[getLastIndex(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int lastIndexOf(short[] sArr, short s2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$lastIndexOf");
        for (int length = sArr.length - 1; length >= 0; length--) {
            if (s2 == sArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final Double lastOrNull(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$lastOrNull");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    public static final <R> List<R> map(short[] sArr, d.k0.c.l<? super Short, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s2 : sArr) {
            arrayList.add(lVar.invoke(Short.valueOf(s2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(short[] sArr, d.k0.c.p<? super Integer, ? super Short, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int i2 = 0;
        for (short s2 : sArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Short.valueOf(s2)));
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(int[] iArr, C c2, d.k0.c.p<? super Integer, ? super Integer, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (int i3 : iArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Integer.valueOf(i3)));
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(int[] iArr, C c2, d.k0.c.l<? super Integer, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (int i2 : iArr) {
            c2.add(lVar.invoke(Integer.valueOf(i2)));
        }
        return c2;
    }

    public static final Long max(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$max");
        return maxOrNull(jArr);
    }

    public static final Float maxOrNull(Float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$maxOrNull");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, fArr[i2].floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Double maxWith(double[] dArr, Comparator<? super Double> comparator) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(dArr, comparator);
    }

    public static final Long min(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$min");
        return minOrNull(jArr);
    }

    public static final Float minOrNull(Float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$minOrNull");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, fArr[i2].floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Double minWith(double[] dArr, Comparator<? super Double> comparator) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(dArr, comparator);
    }

    public static final boolean none(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$none");
        return dArr.length == 0;
    }

    public static final short random(short[] sArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (!(sArr.length == 0)) {
            return sArr[fVar.nextInt(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer randomOrNull(int[] iArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[fVar.nextInt(iArr.length)]);
    }

    public static final List<Short> reversed(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reversed");
        if (sArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<Short> mutableList = toMutableList(sArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final void shuffle(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$shuffle");
        shuffle(dArr, d.l0.f.f12668b);
    }

    public static final Double singleOrNull(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$singleOrNull");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    public static final List<Integer> slice(int[] iArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(iArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final short[] sliceArray(short[] sArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        short[] sArr2 = new short[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            sArr2[i2] = sArr[it.next().intValue()];
            i2++;
        }
        return sArr2;
    }

    public static final List<Double> sorted(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sorted");
        Double[] typedArray = d.g0.l.toTypedArray(dArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        d.g0.l.sort(typedArray);
        return d.g0.l.asList(typedArray);
    }

    public static final int[] sortedArray(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedArray");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(iArrCopyOf);
        return iArrCopyOf;
    }

    public static final int[] sortedArrayDescending(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedArrayDescending");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(iArrCopyOf);
        return iArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Double> sortedBy(double[] dArr, d.k0.c.l<? super Double, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(dArr, new d.h0.b(lVar));
    }

    public static final <R extends Comparable<? super R>> List<Double> sortedByDescending(double[] dArr, d.k0.c.l<? super Double, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(dArr, new d.h0.c(lVar));
    }

    public static final List<Double> sortedDescending(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sortedDescending");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        d.k0.d.t.checkNotNullExpressionValue(dArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(dArrCopyOf);
        return reversed(dArrCopyOf);
    }

    public static final List<Double> sortedWith(double[] dArr, Comparator<? super Double> comparator) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Double[] typedArray = d.g0.l.toTypedArray(dArr);
        d.g0.l.sortWith(typedArray, comparator);
        return d.g0.l.asList(typedArray);
    }

    public static final Set<Integer> subtract(int[] iArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(int[] iArr, d.k0.c.l<? super Integer, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (int i2 : iArr) {
            iIntValue += lVar.invoke(Integer.valueOf(i2)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(int[] iArr, d.k0.c.l<? super Integer, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i2 : iArr) {
            dDoubleValue += lVar.invoke(Integer.valueOf(i2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final <C extends Collection<? super Integer>> C toCollection(int[] iArr, C c2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (int i2 : iArr) {
            c2.add(Integer.valueOf(i2));
        }
        return c2;
    }

    public static final HashSet<Double> toHashSet(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toHashSet");
        return (HashSet) toCollection(dArr, new HashSet(q0.mapCapacity(dArr.length)));
    }

    public static final Set<Double> toMutableSet(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toMutableSet");
        return (Set) toCollection(dArr, new LinkedHashSet(q0.mapCapacity(dArr.length)));
    }

    public static final Set<Integer> union(int[] iArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final Iterable<i0<Double>> withIndex(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$withIndex");
        return new j0(new z(dArr));
    }

    public static final <R, V> List<V> zip(short[] sArr, R[] rArr, d.k0.c.p<? super Short, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Short.valueOf(sArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean all(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (boolean z2 : zArr) {
            if (!lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$any");
        return !(zArr.length == 0);
    }

    public static final boolean contains(boolean[] zArr, boolean z2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$contains");
        return indexOf(zArr, z2) >= 0;
    }

    public static final int count(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (boolean z2 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final List<Boolean> distinct(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(zArr));
    }

    public static final <C extends Collection<? super Boolean>> C filterNotTo(boolean[] zArr, C c2, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (boolean z2 : zArr) {
            if (!lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                c2.add(Boolean.valueOf(z2));
            }
        }
        return c2;
    }

    public static final <C extends Collection<? super Boolean>> C filterTo(boolean[] zArr, C c2, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (boolean z2 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                c2.add(Boolean.valueOf(z2));
            }
        }
        return c2;
    }

    public static final Boolean firstOrNull(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$firstOrNull");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    public static final <R> R fold(boolean[] zArr, R r2, d.k0.c.p<? super R, ? super Boolean, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (boolean z2 : zArr) {
            r2 = pVar.invoke(r2, Boolean.valueOf(z2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(boolean[] zArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super Boolean, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (boolean z2 : zArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, Boolean.valueOf(z2));
        }
        return r2;
    }

    public static final void forEach(boolean[] zArr, d.k0.c.l<? super Boolean, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (boolean z2 : zArr) {
            lVar.invoke(Boolean.valueOf(z2));
        }
    }

    public static final void forEachIndexed(boolean[] zArr, d.k0.c.p<? super Integer, ? super Boolean, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (boolean z2 : zArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Boolean.valueOf(z2));
        }
    }

    public static final d.m0.k getIndices(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(zArr));
    }

    public static final int getLastIndex(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$lastIndex");
        return zArr.length - 1;
    }

    public static final Boolean getOrNull(boolean[] zArr, int i2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(zArr)) {
            return null;
        }
        return Boolean.valueOf(zArr[i2]);
    }

    public static final <K, M extends Map<? super K, List<Byte>>> M groupByTo(byte[] bArr, M m, d.k0.c.l<? super Byte, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (byte b2 : bArr) {
            K kInvoke = lVar.invoke(Byte.valueOf(b2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Byte.valueOf(b2));
        }
        return m;
    }

    public static final String joinToString(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Boolean, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(zArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(zArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (d.k0.c.l<? super Boolean, ? extends CharSequence>) lVar);
    }

    public static final Boolean lastOrNull(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$lastOrNull");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    public static final Float max(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$max");
        return maxOrNull(fArr);
    }

    public static final <R extends Comparable<? super R>> Byte maxBy(byte[] bArr, d.k0.c.l<? super Byte, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                R rInvoke2 = lVar.invoke(Byte.valueOf(b3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    b2 = b3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final <R extends Comparable<? super R>> Byte maxByOrNull(byte[] bArr, d.k0.c.l<? super Byte, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                R rInvoke2 = lVar.invoke(Byte.valueOf(b3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    b2 = b3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final Boolean maxWith(boolean[] zArr, Comparator<? super Boolean> comparator) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(zArr, comparator);
    }

    public static final Float min(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$min");
        return minOrNull(fArr);
    }

    public static final <R extends Comparable<? super R>> Byte minBy(byte[] bArr, d.k0.c.l<? super Byte, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                R rInvoke2 = lVar.invoke(Byte.valueOf(b3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    b2 = b3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final <R extends Comparable<? super R>> Byte minByOrNull(byte[] bArr, d.k0.c.l<? super Byte, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                R rInvoke2 = lVar.invoke(Byte.valueOf(b3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    b2 = b3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final Boolean minWith(boolean[] zArr, Comparator<? super Boolean> comparator) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(zArr, comparator);
    }

    public static final boolean none(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$none");
        return zArr.length == 0;
    }

    public static final d.m<List<Byte>, List<Byte>> partition(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            } else {
                arrayList2.add(Byte.valueOf(b2));
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final Short reduceRightIndexedOrNull(short[] sArr, d.k0.c.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short sShortValue = sArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            sShortValue = qVar.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i2]), Short.valueOf(sShortValue)).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    public static final Short reduceRightOrNull(short[] sArr, d.k0.c.p<? super Short, ? super Short, Short> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short sShortValue = sArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            sShortValue = pVar.invoke(Short.valueOf(sArr[i2]), Short.valueOf(sShortValue)).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    public static final void shuffle(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$shuffle");
        shuffle(zArr, d.l0.f.f12668b);
    }

    public static final Boolean singleOrNull(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$singleOrNull");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    public static final void sortDescending(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortDescending");
        if (iArr.length > 1) {
            d.g0.l.sort(iArr);
            reverse(iArr);
        }
    }

    public static final List<Character> sorted(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sorted");
        Character[] typedArray = d.g0.l.toTypedArray(cArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        d.g0.l.sort(typedArray);
        return d.g0.l.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Boolean> sortedBy(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(zArr, new d.h0.b(lVar));
    }

    public static final <R extends Comparable<? super R>> List<Boolean> sortedByDescending(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(zArr, new d.h0.c(lVar));
    }

    public static final List<Character> sortedDescending(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sortedDescending");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        d.k0.d.t.checkNotNullExpressionValue(cArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(cArrCopyOf);
        return reversed(cArrCopyOf);
    }

    public static final List<Boolean> sortedWith(boolean[] zArr, Comparator<? super Boolean> comparator) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Boolean[] typedArray = d.g0.l.toTypedArray(zArr);
        d.g0.l.sortWith(typedArray, comparator);
        return d.g0.l.asList(typedArray);
    }

    public static final List<Byte> take(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= bArr.length) {
            return toList(bArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (byte b2 : bArr) {
            arrayList.add(Byte.valueOf(b2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Byte> takeLast(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = bArr.length;
        if (i2 >= length) {
            return toList(bArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Byte.valueOf(bArr[i3]));
        }
        return arrayList;
    }

    public static final HashSet<Boolean> toHashSet(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$toHashSet");
        return (HashSet) toCollection(zArr, new HashSet(q0.mapCapacity(zArr.length)));
    }

    public static final List<Long> toMutableList(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j2 : jArr) {
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    public static final Set<Boolean> toMutableSet(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$toMutableSet");
        return (Set) toCollection(zArr, new LinkedHashSet(q0.mapCapacity(zArr.length)));
    }

    public static final Iterable<i0<Boolean>> withIndex(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$withIndex");
        return new j0(new a0(zArr));
    }

    public static final boolean all(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (char c2 : cArr) {
            if (!lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$any");
        return !(cArr.length == 0);
    }

    public static final Iterable<Long> asIterable(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$asIterable");
        return jArr.length == 0 ? d.g0.s.emptyList() : new e(jArr);
    }

    public static final d.o0.m<Long> asSequence(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$asSequence");
        return jArr.length == 0 ? d.o0.r.emptySequence() : new n(jArr);
    }

    public static final <K, V> Map<K, V> associate(short[] sArr, d.k0.c.l<? super Short, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(sArr.length), 16));
        for (short s2 : sArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Short.valueOf(s2));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Short> associateBy(short[] sArr, d.k0.c.l<? super Short, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(sArr.length), 16));
        for (short s2 : sArr) {
            linkedHashMap.put(lVar.invoke(Short.valueOf(s2)), Short.valueOf(s2));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, ? super Long>> M associateByTo(long[] jArr, M m, d.k0.c.l<? super Long, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (long j2 : jArr) {
            m.put(lVar.invoke(Long.valueOf(j2)), Long.valueOf(j2));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(long[] jArr, M m, d.k0.c.l<? super Long, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (long j2 : jArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Long.valueOf(j2));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final boolean contains(char[] cArr, char c2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$contains");
        return indexOf(cArr, c2) >= 0;
    }

    public static final int count(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final List<Character> distinct(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$distinct");
        return d.g0.a0.toList(toMutableSet(cArr));
    }

    public static final List<Long> drop(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(jArr, d.m0.p.coerceAtLeast(jArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Long> dropLast(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(jArr, d.m0.p.coerceAtLeast(jArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Short> dropLastWhile(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Short.valueOf(sArr[lastIndex])).booleanValue()) {
                return take(sArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final List<Long> filter(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C filterIndexedTo(long[] jArr, C c2, d.k0.c.p<? super Integer, ? super Long, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            long j2 = jArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Long.valueOf(j2)).booleanValue()) {
                c2.add(Long.valueOf(j2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final List<Long> filterNot(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            if (!lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C filterNotTo(char[] cArr, C c2, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (char c3 : cArr) {
            if (!lVar.invoke(Character.valueOf(c3)).booleanValue()) {
                c2.add(Character.valueOf(c3));
            }
        }
        return c2;
    }

    public static final <C extends Collection<? super Character>> C filterTo(char[] cArr, C c2, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (char c3 : cArr) {
            if (lVar.invoke(Character.valueOf(c3)).booleanValue()) {
                c2.add(Character.valueOf(c3));
            }
        }
        return c2;
    }

    public static final Character firstOrNull(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$firstOrNull");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    public static final <R> List<R> flatMap(short[] sArr, d.k0.c.l<? super Short, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(Short.valueOf(s2)));
        }
        return arrayList;
    }

    public static final <R> R fold(char[] cArr, R r2, d.k0.c.p<? super R, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (char c2 : cArr) {
            r2 = pVar.invoke(r2, Character.valueOf(c2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(char[] cArr, R r2, d.k0.c.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (char c2 : cArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r2 = qVar.invoke(numValueOf, r2, Character.valueOf(c2));
        }
        return r2;
    }

    public static final <R> R foldRight(long[] jArr, R r2, d.k0.c.p<? super Long, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(Long.valueOf(jArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(long[] jArr, R r2, d.k0.c.q<? super Integer, ? super Long, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), Long.valueOf(jArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(char[] cArr, d.k0.c.l<? super Character, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (char c2 : cArr) {
            lVar.invoke(Character.valueOf(c2));
        }
    }

    public static final void forEachIndexed(char[] cArr, d.k0.c.p<? super Integer, ? super Character, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (char c2 : cArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Character.valueOf(c2));
        }
    }

    public static final d.m0.k getIndices(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$indices");
        return new d.m0.k(0, getLastIndex(cArr));
    }

    public static final int getLastIndex(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$lastIndex");
        return cArr.length - 1;
    }

    public static final Character getOrNull(char[] cArr, int i2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(cArr)) {
            return null;
        }
        return Character.valueOf(cArr[i2]);
    }

    public static final <K> Map<K, List<Byte>> groupBy(byte[] bArr, d.k0.c.l<? super Byte, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b2 : bArr) {
            K kInvoke = lVar.invoke(Byte.valueOf(b2));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Byte.valueOf(b2));
        }
        return linkedHashMap;
    }

    public static final int indexOf(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$indexOf");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 == iArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Long.valueOf(jArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = jArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(Long.valueOf(jArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final Set<Long> intersect(long[] jArr, Iterable<Long> iterable) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final String joinToString(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Character, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(cArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(cArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (d.k0.c.l<? super Character, ? extends CharSequence>) lVar);
    }

    public static final int lastIndexOf(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$lastIndexOf");
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (i2 == iArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final Character lastOrNull(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$lastOrNull");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(long[] jArr, C c2, d.k0.c.p<? super Integer, ? super Long, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (long j2 : jArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Long.valueOf(j2)));
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(long[] jArr, C c2, d.k0.c.l<? super Long, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (long j2 : jArr) {
            c2.add(lVar.invoke(Long.valueOf(j2)));
        }
        return c2;
    }

    public static final Double max(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$max");
        return maxOrNull(dArr);
    }

    public static final Character maxWith(char[] cArr, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(cArr, comparator);
    }

    public static final Double min(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$min");
        return minOrNull(dArr);
    }

    public static final Character minWith(char[] cArr, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(cArr, comparator);
    }

    public static final boolean none(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$none");
        return cArr.length == 0;
    }

    public static final Long randomOrNull(long[] jArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[fVar.nextInt(jArr.length)]);
    }

    public static final short reduceRight(short[] sArr, d.k0.c.p<? super Short, ? super Short, Short> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short sShortValue = sArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                sShortValue = pVar.invoke(Short.valueOf(sArr[i2]), Short.valueOf(sShortValue)).shortValue();
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceRightIndexed(short[] sArr, d.k0.c.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short sShortValue = sArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                sShortValue = qVar.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i2]), Short.valueOf(sShortValue)).shortValue();
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short[] reversedArray(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reversedArray");
        int i2 = 0;
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            while (true) {
                sArr2[lastIndex - i2] = sArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return sArr2;
    }

    public static final void shuffle(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$shuffle");
        shuffle(cArr, (d.l0.f) d.l0.f.f12668b);
    }

    public static final short single(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$single");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Character singleOrNull(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$singleOrNull");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final List<Long> slice(long[] jArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(jArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final long[] sortedArray(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedArray");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final long[] sortedArrayDescending(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedArrayDescending");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Character> sortedBy(char[] cArr, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new d.h0.b(lVar));
    }

    public static final <R extends Comparable<? super R>> List<Character> sortedByDescending(char[] cArr, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new d.h0.c(lVar));
    }

    public static final List<Character> sortedWith(char[] cArr, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Character[] typedArray = d.g0.l.toTypedArray(cArr);
        d.g0.l.sortWith(typedArray, comparator);
        return d.g0.l.asList(typedArray);
    }

    public static final Set<Long> subtract(long[] jArr, Iterable<Long> iterable) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(long[] jArr, d.k0.c.l<? super Long, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (long j2 : jArr) {
            iIntValue += lVar.invoke(Long.valueOf(j2)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(long[] jArr, d.k0.c.l<? super Long, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (long j2 : jArr) {
            dDoubleValue += lVar.invoke(Long.valueOf(j2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final List<Short> takeLastWhile(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Short.valueOf(sArr[lastIndex])).booleanValue()) {
                return drop(sArr, lastIndex + 1);
            }
        }
        return toList(sArr);
    }

    public static final List<Short> takeWhile(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (!lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C toCollection(long[] jArr, C c2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (long j2 : jArr) {
            c2.add(Long.valueOf(j2));
        }
        return c2;
    }

    public static final HashSet<Character> toHashSet(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$toHashSet");
        return (HashSet) toCollection(cArr, new HashSet(q0.mapCapacity(d.m0.p.coerceAtMost(cArr.length, 128))));
    }

    public static final List<Short> toList(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toList");
        int length = sArr.length;
        if (length == 0) {
            return d.g0.s.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return d.g0.r.listOf(Short.valueOf(sArr[0]));
    }

    public static final Set<Character> toMutableSet(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$toMutableSet");
        return (Set) toCollection(cArr, new LinkedHashSet(q0.mapCapacity(d.m0.p.coerceAtMost(cArr.length, 128))));
    }

    public static final Set<Short> toSet(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toSet");
        int length = sArr.length;
        if (length == 0) {
            return z0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(sArr, new LinkedHashSet(q0.mapCapacity(sArr.length)));
        }
        return y0.setOf(Short.valueOf(sArr[0]));
    }

    public static final Set<Long> union(long[] jArr, Iterable<Long> iterable) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final Iterable<i0<Character>> withIndex(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$withIndex");
        return new j0(new b0(cArr));
    }

    public static final <T> boolean any(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t2 : tArr) {
            if (lVar.invoke(t2).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final List<Integer> filterIndexed(int[] iArr, d.k0.c.p<? super Integer, ? super Integer, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Integer.valueOf(i4)).booleanValue()) {
                arrayList.add(Integer.valueOf(i4));
            }
            i2++;
            i3 = i5;
        }
        return arrayList;
    }

    public static final int first(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$first");
        if (!(iArr.length == 0)) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T firstOrNull(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t2 : tArr) {
            if (lVar.invoke(t2).booleanValue()) {
                return t2;
            }
        }
        return null;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(int[] iArr, C c2, d.k0.c.l<? super Integer, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (int i2 : iArr) {
            d.g0.x.addAll(c2, lVar.invoke(Integer.valueOf(i2)));
        }
        return c2;
    }

    public static final int last(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$last");
        if (!(iArr.length == 0)) {
            return iArr[getLastIndex(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T lastOrNull(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        T t2;
        d.k0.d.t.checkNotNullParameter(tArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = tArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            t2 = tArr[length];
        } while (!lVar.invoke(t2).booleanValue());
        return t2;
    }

    public static final <R> List<R> map(int[] iArr, d.k0.c.l<? super Integer, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(lVar.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(int[] iArr, d.k0.c.p<? super Integer, ? super Integer, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int i2 = 0;
        for (int i3 : iArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Integer.valueOf(i3)));
        }
        return arrayList;
    }

    public static final Character max(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$max");
        return maxOrNull(cArr);
    }

    public static final Character min(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$min");
        return minOrNull(cArr);
    }

    public static final <T> boolean none(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t2 : tArr) {
            if (lVar.invoke(t2).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final int random(int[] iArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (!(iArr.length == 0)) {
            return iArr[fVar.nextInt(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Short reduceIndexedOrNull(short[] sArr, d.k0.c.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                sShortValue = qVar.invoke(Integer.valueOf(i2), Short.valueOf(sShortValue), Short.valueOf(sArr[i2])).shortValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(sShortValue);
    }

    public static final Short reduceOrNull(short[] sArr, d.k0.c.p<? super Short, ? super Short, Short> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                sShortValue = pVar.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i2])).shortValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(sShortValue);
    }

    public static final List<Integer> reversed(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reversed");
        if (iArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<Integer> mutableList = toMutableList(iArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final <T> void shuffle(T[] tArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            T t2 = tArr[lastIndex];
            tArr[lastIndex] = tArr[iNextInt];
            tArr[iNextInt] = t2;
        }
    }

    public static final <T> T singleOrNull(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        T t2 = null;
        boolean z2 = false;
        for (T t3 : tArr) {
            if (lVar.invoke(t3).booleanValue()) {
                if (z2) {
                    return null;
                }
                z2 = true;
                t2 = t3;
            }
        }
        if (z2) {
            return t2;
        }
        return null;
    }

    public static final int[] sliceArray(int[] iArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        int[] iArr2 = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr2[i2] = iArr[it.next().intValue()];
            i2++;
        }
        return iArr2;
    }

    public static final List<Float> toMutableList(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(int[] iArr, R[] rArr, d.k0.c.p<? super Integer, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Integer.valueOf(iArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean any(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Float> asIterable(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$asIterable");
        return fArr.length == 0 ? d.g0.s.emptyList() : new f(fArr);
    }

    public static final d.o0.m<Float> asSequence(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$asSequence");
        return fArr.length == 0 ? d.o0.r.emptySequence() : new o(fArr);
    }

    public static final <K, M extends Map<? super K, ? super Float>> M associateByTo(float[] fArr, M m, d.k0.c.l<? super Float, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (float f2 : fArr) {
            m.put(lVar.invoke(Float.valueOf(f2)), Float.valueOf(f2));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(float[] fArr, M m, d.k0.c.l<? super Float, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (float f2 : fArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Float.valueOf(f2));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final List<Float> drop(float[] fArr, int i2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(fArr, d.m0.p.coerceAtLeast(fArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Float> dropLast(float[] fArr, int i2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(fArr, d.m0.p.coerceAtLeast(fArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Short> dropWhile(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (short s2 : sArr) {
            if (z2) {
                arrayList.add(Short.valueOf(s2));
            } else if (!lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final List<Float> filter(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Float>> C filterIndexedTo(float[] fArr, C c2, d.k0.c.p<? super Integer, ? super Float, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f2 = fArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Float.valueOf(f2)).booleanValue()) {
                c2.add(Float.valueOf(f2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final List<Float> filterNot(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (!lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    public static final Byte firstOrNull(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                return Byte.valueOf(b2);
            }
        }
        return null;
    }

    public static final <R> R foldRight(float[] fArr, R r2, d.k0.c.p<? super Float, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(Float.valueOf(fArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(float[] fArr, R r2, d.k0.c.q<? super Integer, ? super Float, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), Float.valueOf(fArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final int indexOf(long[] jArr, long j2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$indexOf");
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (j2 == jArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Float.valueOf(fArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = fArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(Float.valueOf(fArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final Set<Float> intersect(float[] fArr, Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int lastIndexOf(long[] jArr, long j2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$lastIndexOf");
        for (int length = jArr.length - 1; length >= 0; length--) {
            if (j2 == jArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(float[] fArr, C c2, d.k0.c.p<? super Integer, ? super Float, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (float f2 : fArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Float.valueOf(f2)));
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(float[] fArr, C c2, d.k0.c.l<? super Float, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (float f2 : fArr) {
            c2.add(lVar.invoke(Float.valueOf(f2)));
        }
        return c2;
    }

    public static final boolean none(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Float randomOrNull(float[] fArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fVar.nextInt(fArr.length)]);
    }

    public static final short reduce(short[] sArr, d.k0.c.p<? super Short, ? super Short, Short> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (!(sArr.length == 0)) {
            short sShortValue = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (1 <= lastIndex) {
                while (true) {
                    sShortValue = pVar.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i2])).shortValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceIndexed(short[] sArr, d.k0.c.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (!(sArr.length == 0)) {
            short sShortValue = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (1 <= lastIndex) {
                while (true) {
                    sShortValue = qVar.invoke(Integer.valueOf(i2), Short.valueOf(sShortValue), Short.valueOf(sArr[i2])).shortValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reverse");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(sArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            short s2 = sArr[i2];
            sArr[i2] = sArr[lastIndex];
            sArr[lastIndex] = s2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final List<Float> slice(float[] fArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(fArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortDescending");
        if (jArr.length > 1) {
            d.g0.l.sort(jArr);
            reverse(jArr);
        }
    }

    public static final float[] sortedArray(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sortedArray");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        d.k0.d.t.checkNotNullExpressionValue(fArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final float[] sortedArrayDescending(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sortedArrayDescending");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        d.k0.d.t.checkNotNullExpressionValue(fArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final Set<Float> subtract(float[] fArr, Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(float[] fArr, d.k0.c.l<? super Float, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (float f2 : fArr) {
            iIntValue += lVar.invoke(Float.valueOf(f2)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(float[] fArr, d.k0.c.l<? super Float, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (float f2 : fArr) {
            dDoubleValue += lVar.invoke(Float.valueOf(f2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final <C extends Collection<? super Float>> C toCollection(float[] fArr, C c2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (float f2 : fArr) {
            c2.add(Float.valueOf(f2));
        }
        return c2;
    }

    public static final Set<Float> union(float[] fArr, Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final boolean any(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Short firstOrNull(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                return Short.valueOf(s2);
            }
        }
        return null;
    }

    public static final Short maxWithOrNull(short[] sArr, Comparator<? super Short> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) < 0) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final Short minWithOrNull(short[] sArr, Comparator<? super Short> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) > 0) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final boolean none(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Integer reduceRightIndexedOrNull(int[] iArr, d.k0.c.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int iIntValue = iArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            iIntValue = qVar.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Integer.valueOf(iIntValue)).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Integer reduceRightOrNull(int[] iArr, d.k0.c.p<? super Integer, ? super Integer, Integer> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int iIntValue = iArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            iIntValue = pVar.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(iIntValue)).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Byte singleOrNull(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Byte bValueOf = null;
        boolean z2 = false;
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                if (z2) {
                    return null;
                }
                bValueOf = Byte.valueOf(b2);
                z2 = true;
            }
        }
        if (z2) {
            return bValueOf;
        }
        return null;
    }

    public static final List<Double> toMutableList(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d2 : dArr) {
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    public static final boolean any(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Double> asIterable(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$asIterable");
        return dArr.length == 0 ? d.g0.s.emptyList() : new g(dArr);
    }

    public static final d.o0.m<Double> asSequence(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$asSequence");
        return dArr.length == 0 ? d.o0.r.emptySequence() : new p(dArr);
    }

    public static final <K, V> Map<K, V> associate(int[] iArr, d.k0.c.l<? super Integer, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(iArr.length), 16));
        for (int i2 : iArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Integer.valueOf(i2));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Integer> associateBy(int[] iArr, d.k0.c.l<? super Integer, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(iArr.length), 16));
        for (int i2 : iArr) {
            linkedHashMap.put(lVar.invoke(Integer.valueOf(i2)), Integer.valueOf(i2));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, ? super Double>> M associateByTo(double[] dArr, M m, d.k0.c.l<? super Double, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (double d2 : dArr) {
            m.put(lVar.invoke(Double.valueOf(d2)), Double.valueOf(d2));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(double[] dArr, M m, d.k0.c.l<? super Double, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (double d2 : dArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Double.valueOf(d2));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final <K> List<Short> distinctBy(short[] sArr, d.k0.c.l<? super Short, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (hashSet.add(lVar.invoke(Short.valueOf(s2)))) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final List<Double> drop(double[] dArr, int i2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(dArr, d.m0.p.coerceAtLeast(dArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Double> dropLast(double[] dArr, int i2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(dArr, d.m0.p.coerceAtLeast(dArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Integer> dropLastWhile(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Integer.valueOf(iArr[lastIndex])).booleanValue()) {
                return take(iArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final List<Double> filter(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    public static final List<Long> filterIndexed(long[] jArr, d.k0.c.p<? super Integer, ? super Long, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            long j2 = jArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C filterIndexedTo(double[] dArr, C c2, d.k0.c.p<? super Integer, ? super Double, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            double d2 = dArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Double.valueOf(d2)).booleanValue()) {
                c2.add(Double.valueOf(d2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final List<Double> filterNot(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (!lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    public static final long first(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$first");
        if (!(jArr.length == 0)) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer firstOrNull(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                return Integer.valueOf(i2);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(int[] iArr, d.k0.c.l<? super Integer, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(long[] jArr, C c2, d.k0.c.l<? super Long, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (long j2 : jArr) {
            d.g0.x.addAll(c2, lVar.invoke(Long.valueOf(j2)));
        }
        return c2;
    }

    public static final <R> R foldRight(double[] dArr, R r2, d.k0.c.p<? super Double, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(Double.valueOf(dArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(double[] dArr, R r2, d.k0.c.q<? super Integer, ? super Double, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), Double.valueOf(dArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final int indexOf(float[] fArr, float f2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$indexOf");
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (f2 == fArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Double.valueOf(dArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = dArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(Double.valueOf(dArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final Set<Double> intersect(double[] dArr, Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final long last(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$last");
        if (!(jArr.length == 0)) {
            return jArr[getLastIndex(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int lastIndexOf(float[] fArr, float f2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$lastIndexOf");
        for (int length = fArr.length - 1; length >= 0; length--) {
            if (f2 == fArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final Byte lastOrNull(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        byte b2;
        d.k0.d.t.checkNotNullParameter(bArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = bArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            b2 = bArr[length];
        } while (!lVar.invoke(Byte.valueOf(b2)).booleanValue());
        return Byte.valueOf(b2);
    }

    public static final <R> List<R> map(long[] jArr, d.k0.c.l<? super Long, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j2 : jArr) {
            arrayList.add(lVar.invoke(Long.valueOf(j2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(long[] jArr, d.k0.c.p<? super Integer, ? super Long, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int i2 = 0;
        for (long j2 : jArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Long.valueOf(j2)));
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(double[] dArr, C c2, d.k0.c.p<? super Integer, ? super Double, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (double d2 : dArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Double.valueOf(d2)));
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(double[] dArr, C c2, d.k0.c.l<? super Double, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (double d2 : dArr) {
            c2.add(lVar.invoke(Double.valueOf(d2)));
        }
        return c2;
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$maxOrNull");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i2];
                if (t2.compareTo(t3) < 0) {
                    t2 = t3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t2;
    }

    public static final <T extends Comparable<? super T>> T minOrNull(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$minOrNull");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i2];
                if (t2.compareTo(t3) > 0) {
                    t2 = t3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t2;
    }

    public static final boolean none(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final long random(long[] jArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (!(jArr.length == 0)) {
            return jArr[fVar.nextInt(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double randomOrNull(double[] dArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[fVar.nextInt(dArr.length)]);
    }

    public static final int reduceRight(int[] iArr, d.k0.c.p<? super Integer, ? super Integer, Integer> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int iIntValue = iArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                iIntValue = pVar.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(iIntValue)).intValue();
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceRightIndexed(int[] iArr, d.k0.c.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int iIntValue = iArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                iIntValue = qVar.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Integer.valueOf(iIntValue)).intValue();
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final List<Long> reversed(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reversed");
        if (jArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<Long> mutableList = toMutableList(jArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final int[] reversedArray(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reversedArray");
        int i2 = 0;
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            while (true) {
                iArr2[lastIndex - i2] = iArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return iArr2;
    }

    public static final int single(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$single");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Double> slice(double[] dArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(dArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final long[] sliceArray(long[] jArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        long[] jArr2 = new long[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr2[i2] = jArr[it.next().intValue()];
            i2++;
        }
        return jArr2;
    }

    public static final double[] sortedArray(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sortedArray");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        d.k0.d.t.checkNotNullExpressionValue(dArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final double[] sortedArrayDescending(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sortedArrayDescending");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        d.k0.d.t.checkNotNullExpressionValue(dArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final Set<Double> subtract(double[] dArr, Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(double[] dArr, d.k0.c.l<? super Double, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (double d2 : dArr) {
            iIntValue += lVar.invoke(Double.valueOf(d2)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(double[] dArr, d.k0.c.l<? super Double, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (double d2 : dArr) {
            dDoubleValue += lVar.invoke(Double.valueOf(d2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final List<Integer> takeLastWhile(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Integer.valueOf(iArr[lastIndex])).booleanValue()) {
                return drop(iArr, lastIndex + 1);
            }
        }
        return toList(iArr);
    }

    public static final List<Integer> takeWhile(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (!lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C toCollection(double[] dArr, C c2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (double d2 : dArr) {
            c2.add(Double.valueOf(d2));
        }
        return c2;
    }

    public static final List<Integer> toList(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toList");
        int length = iArr.length;
        if (length == 0) {
            return d.g0.s.emptyList();
        }
        if (length != 1) {
            return toMutableList(iArr);
        }
        return d.g0.r.listOf(Integer.valueOf(iArr[0]));
    }

    public static final Set<Integer> toSet(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toSet");
        int length = iArr.length;
        if (length == 0) {
            return z0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(iArr, new LinkedHashSet(q0.mapCapacity(iArr.length)));
        }
        return y0.setOf(Integer.valueOf(iArr[0]));
    }

    public static final Set<Double> union(double[] dArr, Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final <R, V> List<V> zip(long[] jArr, R[] rArr, d.k0.c.p<? super Long, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Long.valueOf(jArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean any(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Long firstOrNull(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                return Long.valueOf(j2);
            }
        }
        return null;
    }

    public static final <A extends Appendable> A joinTo(short[] sArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Short, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (short s2 : sArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Short.valueOf(s2)));
            } else {
                a2.append(String.valueOf((int) s2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final boolean none(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final void sortDescending(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sortDescending");
        if (fArr.length > 1) {
            d.g0.l.sort(fArr);
            reverse(fArr);
        }
    }

    public static final List<Boolean> toMutableList(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z2 : zArr) {
            arrayList.add(Boolean.valueOf(z2));
        }
        return arrayList;
    }

    public static final boolean any(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Boolean> asIterable(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$asIterable");
        return zArr.length == 0 ? d.g0.s.emptyList() : new h(zArr);
    }

    public static final d.o0.m<Boolean> asSequence(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$asSequence");
        return zArr.length == 0 ? d.o0.r.emptySequence() : new q(zArr);
    }

    public static final <K, M extends Map<? super K, ? super Boolean>> M associateByTo(boolean[] zArr, M m, d.k0.c.l<? super Boolean, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (boolean z2 : zArr) {
            m.put(lVar.invoke(Boolean.valueOf(z2)), Boolean.valueOf(z2));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(boolean[] zArr, M m, d.k0.c.l<? super Boolean, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (boolean z2 : zArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Boolean.valueOf(z2));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final List<Boolean> drop(boolean[] zArr, int i2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(zArr, d.m0.p.coerceAtLeast(zArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Boolean> dropLast(boolean[] zArr, int i2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(zArr, d.m0.p.coerceAtLeast(zArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Boolean> filter(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Boolean>> C filterIndexedTo(boolean[] zArr, C c2, d.k0.c.p<? super Integer, ? super Boolean, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            boolean z2 = zArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Boolean.valueOf(z2)).booleanValue()) {
                c2.add(Boolean.valueOf(z2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final List<Boolean> filterNot(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (!lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
            }
        }
        return arrayList;
    }

    public static final Float firstOrNull(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                return Float.valueOf(f2);
            }
        }
        return null;
    }

    public static final <R> R foldRight(boolean[] zArr, R r2, d.k0.c.p<? super Boolean, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(Boolean.valueOf(zArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(boolean[] zArr, R r2, d.k0.c.q<? super Integer, ? super Boolean, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), Boolean.valueOf(zArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <K, M extends Map<? super K, List<Short>>> M groupByTo(short[] sArr, M m, d.k0.c.l<? super Short, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (short s2 : sArr) {
            K kInvoke = lVar.invoke(Short.valueOf(s2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Short.valueOf(s2));
        }
        return m;
    }

    public static final int indexOf(double[] dArr, double d2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$indexOf");
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (d2 == dArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Boolean.valueOf(zArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = zArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(Boolean.valueOf(zArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final Set<Boolean> intersect(boolean[] zArr, Iterable<Boolean> iterable) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int lastIndexOf(double[] dArr, double d2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$lastIndexOf");
        for (int length = dArr.length - 1; length >= 0; length--) {
            if (d2 == dArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(boolean[] zArr, C c2, d.k0.c.p<? super Integer, ? super Boolean, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (boolean z2 : zArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Boolean.valueOf(z2)));
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(boolean[] zArr, C c2, d.k0.c.l<? super Boolean, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (boolean z2 : zArr) {
            c2.add(lVar.invoke(Boolean.valueOf(z2)));
        }
        return c2;
    }

    public static final boolean none(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final d.m<List<Short>, List<Short>> partition(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            } else {
                arrayList2.add(Short.valueOf(s2));
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final Boolean randomOrNull(boolean[] zArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[fVar.nextInt(zArr.length)]);
    }

    public static final Integer reduceIndexedOrNull(int[] iArr, d.k0.c.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                iIntValue = qVar.invoke(Integer.valueOf(i2), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i2])).intValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Integer reduceOrNull(int[] iArr, d.k0.c.p<? super Integer, ? super Integer, Integer> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                iIntValue = pVar.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i2])).intValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(iIntValue);
    }

    public static final void shuffle(byte[] bArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            byte b2 = bArr[lastIndex];
            bArr[lastIndex] = bArr[iNextInt];
            bArr[iNextInt] = b2;
        }
    }

    public static final Short singleOrNull(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Short shValueOf = null;
        boolean z2 = false;
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                if (z2) {
                    return null;
                }
                shValueOf = Short.valueOf(s2);
                z2 = true;
            }
        }
        if (z2) {
            return shValueOf;
        }
        return null;
    }

    public static final List<Boolean> slice(boolean[] zArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(zArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final char[] sortedArray(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sortedArray");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        d.k0.d.t.checkNotNullExpressionValue(cArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        d.g0.l.sort(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final char[] sortedArrayDescending(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sortedArrayDescending");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        d.k0.d.t.checkNotNullExpressionValue(cArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final Set<Boolean> subtract(boolean[] zArr, Iterable<Boolean> iterable) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(boolean[] zArr, d.k0.c.l<? super Boolean, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (boolean z2 : zArr) {
            iIntValue += lVar.invoke(Boolean.valueOf(z2)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(boolean[] zArr, d.k0.c.l<? super Boolean, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z2 : zArr) {
            dDoubleValue += lVar.invoke(Boolean.valueOf(z2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final List<Short> take(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= sArr.length) {
            return toList(sArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (short s2 : sArr) {
            arrayList.add(Short.valueOf(s2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Short> takeLast(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = sArr.length;
        if (i2 >= length) {
            return toList(sArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Short.valueOf(sArr[i3]));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Boolean>> C toCollection(boolean[] zArr, C c2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (boolean z2 : zArr) {
            c2.add(Boolean.valueOf(z2));
        }
        return c2;
    }

    public static final Set<Boolean> union(boolean[] zArr, Iterable<Boolean> iterable) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final boolean any(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final List<Integer> dropWhile(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (int i2 : iArr) {
            if (z2) {
                arrayList.add(Integer.valueOf(i2));
            } else if (!lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final List<Float> filterIndexed(float[] fArr, d.k0.c.p<? super Integer, ? super Float, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f2 = fArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final float first(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$first");
        if (!(fArr.length == 0)) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double firstOrNull(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                return Double.valueOf(d2);
            }
        }
        return null;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(float[] fArr, C c2, d.k0.c.l<? super Float, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (float f2 : fArr) {
            d.g0.x.addAll(c2, lVar.invoke(Float.valueOf(f2)));
        }
        return c2;
    }

    public static final float last(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$last");
        if (!(fArr.length == 0)) {
            return fArr[getLastIndex(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Short lastOrNull(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        short s2;
        d.k0.d.t.checkNotNullParameter(sArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = sArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            s2 = sArr[length];
        } while (!lVar.invoke(Short.valueOf(s2)).booleanValue());
        return Short.valueOf(s2);
    }

    public static final <R> List<R> map(float[] fArr, d.k0.c.l<? super Float, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(lVar.invoke(Float.valueOf(f2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(float[] fArr, d.k0.c.p<? super Integer, ? super Float, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int i2 = 0;
        for (float f2 : fArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Float.valueOf(f2)));
        }
        return arrayList;
    }

    public static final boolean none(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final float random(float[] fArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (!(fArr.length == 0)) {
            return fArr[fVar.nextInt(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int reduce(int[] iArr, d.k0.c.p<? super Integer, ? super Integer, Integer> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (!(iArr.length == 0)) {
            int iIntValue = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    iIntValue = pVar.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i2])).intValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceIndexed(int[] iArr, d.k0.c.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (!(iArr.length == 0)) {
            int iIntValue = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    iIntValue = qVar.invoke(Integer.valueOf(i2), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i2])).intValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Long reduceRightIndexedOrNull(long[] jArr, d.k0.c.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long jLongValue = jArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            jLongValue = qVar.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i2]), Long.valueOf(jLongValue)).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static final Long reduceRightOrNull(long[] jArr, d.k0.c.p<? super Long, ? super Long, Long> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long jLongValue = jArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            jLongValue = pVar.invoke(Long.valueOf(jArr[i2]), Long.valueOf(jLongValue)).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static final void reverse(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reverse");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(iArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            int i3 = iArr[i2];
            iArr[i2] = iArr[lastIndex];
            iArr[lastIndex] = i3;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final List<Float> reversed(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reversed");
        if (fArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<Float> mutableList = toMutableList(fArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final float[] sliceArray(float[] fArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        float[] fArr2 = new float[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            fArr2[i2] = fArr[it.next().intValue()];
            i2++;
        }
        return fArr2;
    }

    public static final List<Character> toMutableList(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c2 : cArr) {
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(float[] fArr, R[] rArr, d.k0.c.p<? super Float, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(fArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Float.valueOf(fArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean any(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (boolean z2 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Character> asIterable(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$asIterable");
        return cArr.length == 0 ? d.g0.s.emptyList() : new i(cArr);
    }

    public static final d.o0.m<Character> asSequence(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$asSequence");
        return cArr.length == 0 ? d.o0.r.emptySequence() : new r(cArr);
    }

    public static final <K, V> Map<K, V> associate(long[] jArr, d.k0.c.l<? super Long, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(jArr.length), 16));
        for (long j2 : jArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Long.valueOf(j2));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Long> associateBy(long[] jArr, d.k0.c.l<? super Long, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(jArr.length), 16));
        for (long j2 : jArr) {
            linkedHashMap.put(lVar.invoke(Long.valueOf(j2)), Long.valueOf(j2));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(char[] cArr, M m, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (char c2 : cArr) {
            m.put(lVar.invoke(Character.valueOf(c2)), Character.valueOf(c2));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(char[] cArr, M m, d.k0.c.l<? super Character, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (char c2 : cArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Character.valueOf(c2));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final List<Character> drop(char[] cArr, int i2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(cArr, d.m0.p.coerceAtLeast(cArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Character> dropLast(char[] cArr, int i2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(cArr, d.m0.p.coerceAtLeast(cArr.length - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Long> dropLastWhile(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Long.valueOf(jArr[lastIndex])).booleanValue()) {
                return take(jArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final List<Character> filter(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C filterIndexedTo(char[] cArr, C c2, d.k0.c.p<? super Integer, ? super Character, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c3 = cArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Character.valueOf(c3)).booleanValue()) {
                c2.add(Character.valueOf(c3));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final List<Character> filterNot(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (!lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    public static final Boolean firstOrNull(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (boolean z2 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                return Boolean.valueOf(z2);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(long[] jArr, d.k0.c.l<? super Long, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(Long.valueOf(j2)));
        }
        return arrayList;
    }

    public static final <R> R foldRight(char[] cArr, R r2, d.k0.c.p<? super Character, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r2 = pVar.invoke(Character.valueOf(cArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(char[] cArr, R r2, d.k0.c.q<? super Integer, ? super Character, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r2 = qVar.invoke(Integer.valueOf(lastIndex), Character.valueOf(cArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <K> Map<K, List<Short>> groupBy(short[] sArr, d.k0.c.l<? super Short, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s2 : sArr) {
            K kInvoke = lVar.invoke(Short.valueOf(s2));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Short.valueOf(s2));
        }
        return linkedHashMap;
    }

    public static final int indexOf(boolean[] zArr, boolean z2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$indexOf");
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (z2 == zArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Character.valueOf(cArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = cArr.length - 1; length >= 0; length--) {
            if (lVar.invoke(Character.valueOf(cArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final Set<Character> intersect(char[] cArr, Iterable<Character> iterable) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        d.g0.x.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int lastIndexOf(boolean[] zArr, boolean z2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$lastIndexOf");
        for (int length = zArr.length - 1; length >= 0; length--) {
            if (z2 == zArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(char[] cArr, C c2, d.k0.c.p<? super Integer, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (char c3 : cArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Character.valueOf(c3)));
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(char[] cArr, C c2, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (char c3 : cArr) {
            c2.add(lVar.invoke(Character.valueOf(c3)));
        }
        return c2;
    }

    public static final <R extends Comparable<? super R>> Short maxBy(short[] sArr, d.k0.c.l<? super Short, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        R rInvoke = lVar.invoke(Short.valueOf(s2));
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                R rInvoke2 = lVar.invoke(Short.valueOf(s3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    s2 = s3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <R extends Comparable<? super R>> Short maxByOrNull(short[] sArr, d.k0.c.l<? super Short, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        R rInvoke = lVar.invoke(Short.valueOf(s2));
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                R rInvoke2 = lVar.invoke(Short.valueOf(s3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    s2 = s3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <R extends Comparable<? super R>> Short minBy(short[] sArr, d.k0.c.l<? super Short, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        R rInvoke = lVar.invoke(Short.valueOf(s2));
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                R rInvoke2 = lVar.invoke(Short.valueOf(s3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    s2 = s3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <R extends Comparable<? super R>> Short minByOrNull(short[] sArr, d.k0.c.l<? super Short, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        R rInvoke = lVar.invoke(Short.valueOf(s2));
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                R rInvoke2 = lVar.invoke(Short.valueOf(s3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    s2 = s3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final boolean none(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (boolean z2 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Character randomOrNull(char[] cArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[fVar.nextInt(cArr.length)]);
    }

    public static final long reduceRight(long[] jArr, d.k0.c.p<? super Long, ? super Long, Long> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long jLongValue = jArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                jLongValue = pVar.invoke(Long.valueOf(jArr[i2]), Long.valueOf(jLongValue)).longValue();
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceRightIndexed(long[] jArr, d.k0.c.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long jLongValue = jArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                jLongValue = qVar.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i2]), Long.valueOf(jLongValue)).longValue();
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long[] reversedArray(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reversedArray");
        int i2 = 0;
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            while (true) {
                jArr2[lastIndex - i2] = jArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return jArr2;
    }

    public static final long single(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$single");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Character> slice(char[] cArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? d.g0.s.emptyList() : d.g0.l.asList(d.g0.l.copyOfRange(cArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sortDescending");
        if (dArr.length > 1) {
            d.g0.l.sort(dArr);
            reverse(dArr);
        }
    }

    public static final Set<Character> subtract(char[] cArr, Iterable<Character> iterable) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        d.g0.x.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(char[] cArr, d.k0.c.l<? super Character, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (char c2 : cArr) {
            iIntValue += lVar.invoke(Character.valueOf(c2)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(char[] cArr, d.k0.c.l<? super Character, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (char c2 : cArr) {
            dDoubleValue += lVar.invoke(Character.valueOf(c2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final List<Long> takeLastWhile(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Long.valueOf(jArr[lastIndex])).booleanValue()) {
                return drop(jArr, lastIndex + 1);
            }
        }
        return toList(jArr);
    }

    public static final List<Long> takeWhile(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            if (!lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C toCollection(char[] cArr, C c2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (char c3 : cArr) {
            c2.add(Character.valueOf(c3));
        }
        return c2;
    }

    public static final List<Long> toList(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toList");
        int length = jArr.length;
        if (length == 0) {
            return d.g0.s.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return d.g0.r.listOf(Long.valueOf(jArr[0]));
    }

    public static final Set<Long> toSet(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toSet");
        int length = jArr.length;
        if (length == 0) {
            return z0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(jArr, new LinkedHashSet(q0.mapCapacity(jArr.length)));
        }
        return y0.setOf(Long.valueOf(jArr[0]));
    }

    public static final Set<Character> union(char[] cArr, Iterable<Character> iterable) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        d.g0.x.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final boolean any(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Character firstOrNull(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                return Character.valueOf(c2);
            }
        }
        return null;
    }

    public static final Byte maxOrNull(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$maxOrNull");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (b2 < b3) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final Integer maxWithOrNull(int[] iArr, Comparator<? super Integer> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i4)) < 0) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final Byte minOrNull(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$minOrNull");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (b2 > b3) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final Integer minWithOrNull(int[] iArr, Comparator<? super Integer> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i4)) > 0) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final boolean none(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Integer singleOrNull(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Integer numValueOf = null;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                if (z2) {
                    return null;
                }
                numValueOf = Integer.valueOf(i2);
                z2 = true;
            }
        }
        if (z2) {
            return numValueOf;
        }
        return null;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(T[] tArr, M m, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (T t2 : tArr) {
            m.put(lVar.invoke(t2), lVar2.invoke(t2));
        }
        return m;
    }

    public static final <K> List<Integer> distinctBy(int[] iArr, d.k0.c.l<? super Integer, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (hashSet.add(lVar.invoke(Integer.valueOf(i2)))) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    public static final List<Double> filterIndexed(double[] dArr, d.k0.c.p<? super Integer, ? super Double, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            double d2 = dArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final double first(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$first");
        if (!(dArr.length == 0)) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(double[] dArr, C c2, d.k0.c.l<? super Double, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (double d2 : dArr) {
            d.g0.x.addAll(c2, lVar.invoke(Double.valueOf(d2)));
        }
        return c2;
    }

    public static final int indexOf(char[] cArr, char c2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$indexOf");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (c2 == cArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final double last(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$last");
        if (!(dArr.length == 0)) {
            return dArr[getLastIndex(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int lastIndexOf(char[] cArr, char c2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$lastIndexOf");
        for (int length = cArr.length - 1; length >= 0; length--) {
            if (c2 == cArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final Integer lastOrNull(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        int i2;
        d.k0.d.t.checkNotNullParameter(iArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = iArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            i2 = iArr[length];
        } while (!lVar.invoke(Integer.valueOf(i2)).booleanValue());
        return Integer.valueOf(i2);
    }

    public static final <R> List<R> map(double[] dArr, d.k0.c.l<? super Double, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d2 : dArr) {
            arrayList.add(lVar.invoke(Double.valueOf(d2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(double[] dArr, d.k0.c.p<? super Integer, ? super Double, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int i2 = 0;
        for (double d2 : dArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Double.valueOf(d2)));
        }
        return arrayList;
    }

    public static final double random(double[] dArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (!(dArr.length == 0)) {
            return dArr[fVar.nextInt(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List<Double> reversed(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reversed");
        if (dArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<Double> mutableList = toMutableList(dArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final <T> List<T> slice(T[] tArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(tArr[it.next().intValue()]);
        }
        return arrayList;
    }

    public static final double[] sliceArray(double[] dArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        double[] dArr2 = new double[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            dArr2[i2] = dArr[it.next().intValue()];
            i2++;
        }
        return dArr2;
    }

    public static final <R, V> List<V> zip(double[] dArr, R[] rArr, d.k0.c.p<? super Double, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(dArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Double.valueOf(dArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final Long reduceIndexedOrNull(long[] jArr, d.k0.c.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                jLongValue = qVar.invoke(Integer.valueOf(i2), Long.valueOf(jLongValue), Long.valueOf(jArr[i2])).longValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(jLongValue);
    }

    public static final Long reduceOrNull(long[] jArr, d.k0.c.p<? super Long, ? super Long, Long> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                jLongValue = pVar.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i2])).longValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(jLongValue);
    }

    public static final Float reduceRightIndexedOrNull(float[] fArr, d.k0.c.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float fFloatValue = fArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            fFloatValue = qVar.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i2]), Float.valueOf(fFloatValue)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Float reduceRightOrNull(float[] fArr, d.k0.c.p<? super Float, ? super Float, Float> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float fFloatValue = fArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            fFloatValue = pVar.invoke(Float.valueOf(fArr[i2]), Float.valueOf(fFloatValue)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static final void shuffle(short[] sArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            short s2 = sArr[lastIndex];
            sArr[lastIndex] = sArr[iNextInt];
            sArr[iNextInt] = s2;
        }
    }

    public static final void sortDescending(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sortDescending");
        if (cArr.length > 1) {
            d.g0.l.sort(cArr);
            reverse(cArr);
        }
    }

    public static final <K, V> Map<K, V> associate(float[] fArr, d.k0.c.l<? super Float, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(fArr.length), 16));
        for (float f2 : fArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Float.valueOf(f2));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Float> associateBy(float[] fArr, d.k0.c.l<? super Float, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(fArr.length), 16));
        for (float f2 : fArr) {
            linkedHashMap.put(lVar.invoke(Float.valueOf(f2)), Float.valueOf(f2));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(byte[] bArr, M m, d.k0.c.l<? super Byte, ? extends K> lVar, d.k0.c.l<? super Byte, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (byte b2 : bArr) {
            m.put(lVar.invoke(Byte.valueOf(b2)), lVar2.invoke(Byte.valueOf(b2)));
        }
        return m;
    }

    public static final List<Float> dropLastWhile(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Float.valueOf(fArr[lastIndex])).booleanValue()) {
                return take(fArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final List<Long> dropWhile(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (long j2 : jArr) {
            if (z2) {
                arrayList.add(Long.valueOf(j2));
            } else if (!lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <R> List<R> flatMap(float[] fArr, d.k0.c.l<? super Float, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(Float.valueOf(f2)));
        }
        return arrayList;
    }

    public static final <A extends Appendable> A joinTo(int[] iArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Integer, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (int i4 : iArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Integer.valueOf(i4)));
            } else {
                a2.append(String.valueOf(i4));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final long reduce(long[] jArr, d.k0.c.p<? super Long, ? super Long, Long> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (!(jArr.length == 0)) {
            long jLongValue = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    jLongValue = pVar.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i2])).longValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceIndexed(long[] jArr, d.k0.c.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (!(jArr.length == 0)) {
            long jLongValue = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    jLongValue = qVar.invoke(Integer.valueOf(i2), Long.valueOf(jLongValue), Long.valueOf(jArr[i2])).longValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRight(float[] fArr, d.k0.c.p<? super Float, ? super Float, Float> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float fFloatValue = fArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                fFloatValue = pVar.invoke(Float.valueOf(fArr[i2]), Float.valueOf(fFloatValue)).floatValue();
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRightIndexed(float[] fArr, d.k0.c.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float fFloatValue = fArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                fFloatValue = qVar.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i2]), Float.valueOf(fFloatValue)).floatValue();
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reverse");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(jArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            long j2 = jArr[i2];
            jArr[i2] = jArr[lastIndex];
            jArr[lastIndex] = j2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final float[] reversedArray(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reversedArray");
        int i2 = 0;
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            while (true) {
                fArr2[lastIndex - i2] = fArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return fArr2;
    }

    public static final float single(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$single");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return fArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Long singleOrNull(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Long lValueOf = null;
        boolean z2 = false;
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                if (z2) {
                    return null;
                }
                lValueOf = Long.valueOf(j2);
                z2 = true;
            }
        }
        if (z2) {
            return lValueOf;
        }
        return null;
    }

    public static final List<Float> takeLastWhile(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Float.valueOf(fArr[lastIndex])).booleanValue()) {
                return drop(fArr, lastIndex + 1);
            }
        }
        return toList(fArr);
    }

    public static final List<Float> takeWhile(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (!lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    public static final List<Float> toList(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toList");
        int length = fArr.length;
        if (length == 0) {
            return d.g0.s.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return d.g0.r.listOf(Float.valueOf(fArr[0]));
    }

    public static final Set<Float> toSet(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toSet");
        int length = fArr.length;
        if (length == 0) {
            return z0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(fArr, new LinkedHashSet(q0.mapCapacity(fArr.length)));
        }
        return y0.setOf(Float.valueOf(fArr[0]));
    }

    public static final List<Boolean> filterIndexed(boolean[] zArr, d.k0.c.p<? super Integer, ? super Boolean, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            boolean z2 = zArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Boolean.valueOf(z2)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final boolean first(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$first");
        if (!(zArr.length == 0)) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(boolean[] zArr, C c2, d.k0.c.l<? super Boolean, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (boolean z2 : zArr) {
            d.g0.x.addAll(c2, lVar.invoke(Boolean.valueOf(z2)));
        }
        return c2;
    }

    public static final <K, M extends Map<? super K, List<Integer>>> M groupByTo(int[] iArr, M m, d.k0.c.l<? super Integer, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (int i2 : iArr) {
            K kInvoke = lVar.invoke(Integer.valueOf(i2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Integer.valueOf(i2));
        }
        return m;
    }

    public static final boolean last(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$last");
        if (!(zArr.length == 0)) {
            return zArr[getLastIndex(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Long lastOrNull(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        long j2;
        d.k0.d.t.checkNotNullParameter(jArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = jArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            j2 = jArr[length];
        } while (!lVar.invoke(Long.valueOf(j2)).booleanValue());
        return Long.valueOf(j2);
    }

    public static final <R> List<R> map(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z2 : zArr) {
            arrayList.add(lVar.invoke(Boolean.valueOf(z2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(boolean[] zArr, d.k0.c.p<? super Integer, ? super Boolean, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int i2 = 0;
        for (boolean z2 : zArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Boolean.valueOf(z2)));
        }
        return arrayList;
    }

    public static final d.m<List<Integer>, List<Integer>> partition(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            } else {
                arrayList2.add(Integer.valueOf(i2));
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final boolean random(boolean[] zArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (!(zArr.length == 0)) {
            return zArr[fVar.nextInt(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List<Boolean> reversed(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reversed");
        if (zArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<Boolean> mutableList = toMutableList(zArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final boolean[] sliceArray(boolean[] zArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        boolean[] zArr2 = new boolean[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            zArr2[i2] = zArr[it.next().intValue()];
            i2++;
        }
        return zArr2;
    }

    public static final List<Integer> take(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= iArr.length) {
            return toList(iArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (int i4 : iArr) {
            arrayList.add(Integer.valueOf(i4));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Integer> takeLast(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = iArr.length;
        if (i2 >= length) {
            return toList(iArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Integer.valueOf(iArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Integer.valueOf(iArr[i3]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(boolean[] zArr, R[] rArr, d.k0.c.p<? super Boolean, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(zArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Boolean.valueOf(zArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(short[] sArr, M m, d.k0.c.l<? super Short, ? extends K> lVar, d.k0.c.l<? super Short, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (short s2 : sArr) {
            m.put(lVar.invoke(Short.valueOf(s2)), lVar2.invoke(Short.valueOf(s2)));
        }
        return m;
    }

    public static final Short maxOrNull(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$maxOrNull");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (s2 < s3) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final Short minOrNull(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$minOrNull");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (s2 > s3) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <T extends Comparable<? super T>> void sortDescending(T[] tArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortDescending");
        d.g0.l.sortWith(tArr, d.h0.a.reverseOrder(), i2, i3);
    }

    public static final Long maxWithOrNull(long[] jArr, Comparator<? super Long> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (comparator.compare(Long.valueOf(j2), Long.valueOf(j3)) < 0) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final Long minWithOrNull(long[] jArr, Comparator<? super Long> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (comparator.compare(Long.valueOf(j2), Long.valueOf(j3)) > 0) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final Double reduceRightIndexedOrNull(double[] dArr, d.k0.c.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double dDoubleValue = dArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            dDoubleValue = qVar.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i2]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Double reduceRightOrNull(double[] dArr, d.k0.c.p<? super Double, ? super Double, Double> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double dDoubleValue = dArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            dDoubleValue = pVar.invoke(Double.valueOf(dArr[i2]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Float singleOrNull(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Float fValueOf = null;
        boolean z2 = false;
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                if (z2) {
                    return null;
                }
                fValueOf = Float.valueOf(f2);
                z2 = true;
            }
        }
        if (z2) {
            return fValueOf;
        }
        return null;
    }

    public static final List<Byte> slice(byte[] bArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final void sortDescending(byte[] bArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortDescending");
        d.g0.l.sort(bArr, i2, i3);
        reverse(bArr, i2, i3);
    }

    public static final <K, V> Map<K, V> associate(double[] dArr, d.k0.c.l<? super Double, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(dArr.length), 16));
        for (double d2 : dArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Double.valueOf(d2));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Double> associateBy(double[] dArr, d.k0.c.l<? super Double, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(dArr.length), 16));
        for (double d2 : dArr) {
            linkedHashMap.put(lVar.invoke(Double.valueOf(d2)), Double.valueOf(d2));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(int[] iArr, M m, d.k0.c.l<? super Integer, ? extends K> lVar, d.k0.c.l<? super Integer, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (int i2 : iArr) {
            m.put(lVar.invoke(Integer.valueOf(i2)), lVar2.invoke(Integer.valueOf(i2)));
        }
        return m;
    }

    public static final <K> List<Long> distinctBy(long[] jArr, d.k0.c.l<? super Long, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            if (hashSet.add(lVar.invoke(Long.valueOf(j2)))) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        return arrayList;
    }

    public static final List<Double> dropLastWhile(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Double.valueOf(dArr[lastIndex])).booleanValue()) {
                return take(dArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final List<Character> filterIndexed(char[] cArr, d.k0.c.p<? super Integer, ? super Character, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c2 = cArr[i2];
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final char first(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$first");
        if (!(cArr.length == 0)) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <R> List<R> flatMap(double[] dArr, d.k0.c.l<? super Double, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(Double.valueOf(d2)));
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(char[] cArr, C c2, d.k0.c.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (char c3 : cArr) {
            d.g0.x.addAll(c2, lVar.invoke(Character.valueOf(c3)));
        }
        return c2;
    }

    public static final <K> Map<K, List<Integer>> groupBy(int[] iArr, d.k0.c.l<? super Integer, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 : iArr) {
            K kInvoke = lVar.invoke(Integer.valueOf(i2));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Integer.valueOf(i2));
        }
        return linkedHashMap;
    }

    public static final char last(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$last");
        if (!(cArr.length == 0)) {
            return cArr[getLastIndex(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Float lastOrNull(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        float f2;
        d.k0.d.t.checkNotNullParameter(fArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = fArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            f2 = fArr[length];
        } while (!lVar.invoke(Float.valueOf(f2)).booleanValue());
        return Float.valueOf(f2);
    }

    public static final <R> List<R> map(char[] cArr, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c2 : cArr) {
            arrayList.add(lVar.invoke(Character.valueOf(c2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(char[] cArr, d.k0.c.p<? super Integer, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int i2 = 0;
        for (char c2 : cArr) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Character.valueOf(c2)));
        }
        return arrayList;
    }

    public static final char random(char[] cArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (!(cArr.length == 0)) {
            return cArr[fVar.nextInt(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Float reduceIndexedOrNull(float[] fArr, d.k0.c.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = qVar.invoke(Integer.valueOf(i2), Float.valueOf(fFloatValue), Float.valueOf(fArr[i2])).floatValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Float reduceOrNull(float[] fArr, d.k0.c.p<? super Float, ? super Float, Float> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = pVar.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i2])).floatValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final double reduceRight(double[] dArr, d.k0.c.p<? super Double, ? super Double, Double> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double dDoubleValue = dArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                dDoubleValue = pVar.invoke(Double.valueOf(dArr[i2]), Double.valueOf(dDoubleValue)).doubleValue();
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceRightIndexed(double[] dArr, d.k0.c.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double dDoubleValue = dArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                dDoubleValue = qVar.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i2]), Double.valueOf(dDoubleValue)).doubleValue();
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final List<Character> reversed(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reversed");
        if (cArr.length == 0) {
            return d.g0.s.emptyList();
        }
        List<Character> mutableList = toMutableList(cArr);
        d.g0.z.reverse(mutableList);
        return mutableList;
    }

    public static final double[] reversedArray(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reversedArray");
        int i2 = 0;
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            while (true) {
                dArr2[lastIndex - i2] = dArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return dArr2;
    }

    public static final void shuffle(int[] iArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            int i2 = iArr[lastIndex];
            iArr[lastIndex] = iArr[iNextInt];
            iArr[iNextInt] = i2;
        }
    }

    public static final double single(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$single");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return dArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final char[] sliceArray(char[] cArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        char[] cArr2 = new char[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            cArr2[i2] = cArr[it.next().intValue()];
            i2++;
        }
        return cArr2;
    }

    public static final List<Double> takeLastWhile(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Double.valueOf(dArr[lastIndex])).booleanValue()) {
                return drop(dArr, lastIndex + 1);
            }
        }
        return toList(dArr);
    }

    public static final List<Double> takeWhile(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (!lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    public static final List<Double> toList(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toList");
        int length = dArr.length;
        if (length == 0) {
            return d.g0.s.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return d.g0.r.listOf(Double.valueOf(dArr[0]));
    }

    public static final Set<Double> toSet(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toSet");
        int length = dArr.length;
        if (length == 0) {
            return z0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(dArr, new LinkedHashSet(q0.mapCapacity(dArr.length)));
        }
        return y0.setOf(Double.valueOf(dArr[0]));
    }

    public static final <R, V> List<V> zip(char[] cArr, R[] rArr, d.k0.c.p<? super Character, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(cArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Character.valueOf(cArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final List<Float> dropWhile(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (float f2 : fArr) {
            if (z2) {
                arrayList.add(Float.valueOf(f2));
            } else if (!lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> Integer maxBy(int[] iArr, d.k0.c.l<? super Integer, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                R rInvoke2 = lVar.invoke(Integer.valueOf(i4));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    i3 = i4;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final <R extends Comparable<? super R>> Integer maxByOrNull(int[] iArr, d.k0.c.l<? super Integer, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                R rInvoke2 = lVar.invoke(Integer.valueOf(i4));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    i3 = i4;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final <R extends Comparable<? super R>> Integer minBy(int[] iArr, d.k0.c.l<? super Integer, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                R rInvoke2 = lVar.invoke(Integer.valueOf(i4));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    i3 = i4;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final <R extends Comparable<? super R>> Integer minByOrNull(int[] iArr, d.k0.c.l<? super Integer, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                R rInvoke2 = lVar.invoke(Integer.valueOf(i4));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    i3 = i4;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final float reduce(float[] fArr, d.k0.c.p<? super Float, ? super Float, Float> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (!(fArr.length == 0)) {
            float fFloatValue = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = pVar.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i2])).floatValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceIndexed(float[] fArr, d.k0.c.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (!(fArr.length == 0)) {
            float fFloatValue = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = qVar.invoke(Integer.valueOf(i2), Float.valueOf(fFloatValue), Float.valueOf(fArr[i2])).floatValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reverse");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(fArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            float f2 = fArr[i2];
            fArr[i2] = fArr[lastIndex];
            fArr[lastIndex] = f2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final void sortDescending(short[] sArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortDescending");
        d.g0.l.sort(sArr, i2, i3);
        reverse(sArr, i2, i3);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(long[] jArr, M m, d.k0.c.l<? super Long, ? extends K> lVar, d.k0.c.l<? super Long, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (long j2 : jArr) {
            m.put(lVar.invoke(Long.valueOf(j2)), lVar2.invoke(Long.valueOf(j2)));
        }
        return m;
    }

    public static final Double singleOrNull(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Double dValueOf = null;
        boolean z2 = false;
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                if (z2) {
                    return null;
                }
                dValueOf = Double.valueOf(d2);
                z2 = true;
            }
        }
        if (z2) {
            return dValueOf;
        }
        return null;
    }

    public static final <T> T first(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t2 : tArr) {
            if (lVar.invoke(t2).booleanValue()) {
                return t2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <A extends Appendable> A joinTo(long[] jArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Long, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (long j2 : jArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Long.valueOf(j2)));
            } else {
                a2.append(String.valueOf(j2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> T last(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        T t2;
        d.k0.d.t.checkNotNullParameter(tArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = tArr.length;
        do {
            length--;
            if (length >= 0) {
                t2 = tArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(t2).booleanValue());
        return t2;
    }

    public static final Double lastOrNull(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        double d2;
        d.k0.d.t.checkNotNullParameter(dArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = dArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            d2 = dArr[length];
        } while (!lVar.invoke(Double.valueOf(d2)).booleanValue());
        return Double.valueOf(d2);
    }

    public static final Integer maxOrNull(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$maxOrNull");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (i3 < i4) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final Integer minOrNull(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$minOrNull");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (i3 > i4) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final Boolean reduceRightIndexedOrNull(boolean[] zArr, d.k0.c.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            zBooleanValue = qVar.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i2]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final Boolean reduceRightOrNull(boolean[] zArr, d.k0.c.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            zBooleanValue = pVar.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final <T> T[] sliceArray(T[] tArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? (T[]) d.g0.l.copyOfRange(tArr, 0, 0) : (T[]) d.g0.l.copyOfRange(tArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final void sortDescending(int[] iArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortDescending");
        d.g0.l.sort(iArr, i2, i3);
        reverse(iArr, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R, V> List<V> zip(T[] tArr, Iterable<? extends R> iterable, d.k0.c.p<? super T, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(tArr[i2], r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associate(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(zArr.length), 16));
        for (boolean z2 : zArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Boolean.valueOf(z2));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Boolean> associateBy(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(zArr.length), 16));
        for (boolean z2 : zArr) {
            linkedHashMap.put(lVar.invoke(Boolean.valueOf(z2)), Boolean.valueOf(z2));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(float[] fArr, M m, d.k0.c.l<? super Float, ? extends K> lVar, d.k0.c.l<? super Float, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (float f2 : fArr) {
            m.put(lVar.invoke(Float.valueOf(f2)), lVar2.invoke(Float.valueOf(f2)));
        }
        return m;
    }

    public static final List<Boolean> dropLastWhile(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Boolean.valueOf(zArr[lastIndex])).booleanValue()) {
                return take(zArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final <R> List<R> flatMap(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(Boolean.valueOf(z2)));
        }
        return arrayList;
    }

    public static final <K, M extends Map<? super K, List<Long>>> M groupByTo(long[] jArr, M m, d.k0.c.l<? super Long, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (long j2 : jArr) {
            K kInvoke = lVar.invoke(Long.valueOf(j2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(j2));
        }
        return m;
    }

    public static final d.m<List<Long>, List<Long>> partition(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
            } else {
                arrayList2.add(Long.valueOf(j2));
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final boolean reduceRight(boolean[] zArr, d.k0.c.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean zBooleanValue = zArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                zBooleanValue = pVar.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(zBooleanValue)).booleanValue();
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceRightIndexed(boolean[] zArr, d.k0.c.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean zBooleanValue = zArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                zBooleanValue = qVar.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i2]), Boolean.valueOf(zBooleanValue)).booleanValue();
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean[] reversedArray(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reversedArray");
        int i2 = 0;
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            while (true) {
                zArr2[lastIndex - i2] = zArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return zArr2;
    }

    public static final boolean single(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$single");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Short> slice(short[] sArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Long> take(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= jArr.length) {
            return toList(jArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (long j2 : jArr) {
            arrayList.add(Long.valueOf(j2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Long> takeLast(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = jArr.length;
        if (i2 >= length) {
            return toList(jArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Long.valueOf(jArr[i3]));
        }
        return arrayList;
    }

    public static final List<Boolean> takeLastWhile(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Boolean.valueOf(zArr[lastIndex])).booleanValue()) {
                return drop(zArr, lastIndex + 1);
            }
        }
        return toList(zArr);
    }

    public static final List<Boolean> takeWhile(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (!lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z2));
        }
        return arrayList;
    }

    public static final List<Boolean> toList(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$toList");
        int length = zArr.length;
        if (length == 0) {
            return d.g0.s.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return d.g0.r.listOf(Boolean.valueOf(zArr[0]));
    }

    public static final Set<Boolean> toSet(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$toSet");
        int length = zArr.length;
        if (length == 0) {
            return z0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(zArr, new LinkedHashSet(q0.mapCapacity(zArr.length)));
        }
        return y0.setOf(Boolean.valueOf(zArr[0]));
    }

    public static final byte first(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                return b2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Float maxWithOrNull(float[] fArr, Comparator<? super Float> comparator) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                if (comparator.compare(Float.valueOf(f2), Float.valueOf(f3)) < 0) {
                    f2 = f3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final Float minWithOrNull(float[] fArr, Comparator<? super Float> comparator) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                if (comparator.compare(Float.valueOf(f2), Float.valueOf(f3)) > 0) {
                    f2 = f3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final Double reduceIndexedOrNull(double[] dArr, d.k0.c.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = qVar.invoke(Integer.valueOf(i2), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i2])).doubleValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Double reduceOrNull(double[] dArr, d.k0.c.p<? super Double, ? super Double, Double> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = pVar.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i2])).doubleValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final void shuffle(long[] jArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            long j2 = jArr[lastIndex];
            jArr[lastIndex] = jArr[iNextInt];
            jArr[iNextInt] = j2;
        }
    }

    public static final Boolean singleOrNull(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Boolean boolValueOf = null;
        boolean z2 = false;
        for (boolean z3 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z3)).booleanValue()) {
                if (z2) {
                    return null;
                }
                boolValueOf = Boolean.valueOf(z3);
                z2 = true;
            }
        }
        if (z2) {
            return boolValueOf;
        }
        return null;
    }

    public static final byte[] sliceArray(byte[] bArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? new byte[0] : d.g0.l.copyOfRange(bArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final void sortDescending(long[] jArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortDescending");
        d.g0.l.sort(jArr, i2, i3);
        reverse(jArr, i2, i3);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(double[] dArr, M m, d.k0.c.l<? super Double, ? extends K> lVar, d.k0.c.l<? super Double, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (double d2 : dArr) {
            m.put(lVar.invoke(Double.valueOf(d2)), lVar2.invoke(Double.valueOf(d2)));
        }
        return m;
    }

    public static final <K> List<Float> distinctBy(float[] fArr, d.k0.c.l<? super Float, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (hashSet.add(lVar.invoke(Float.valueOf(f2)))) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    public static final List<Double> dropWhile(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (double d2 : dArr) {
            if (z2) {
                arrayList.add(Double.valueOf(d2));
            } else if (!lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final Boolean lastOrNull(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        boolean z2;
        d.k0.d.t.checkNotNullParameter(zArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = zArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            z2 = zArr[length];
        } while (!lVar.invoke(Boolean.valueOf(z2)).booleanValue());
        return Boolean.valueOf(z2);
    }

    public static final double reduce(double[] dArr, d.k0.c.p<? super Double, ? super Double, Double> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (!(dArr.length == 0)) {
            double dDoubleValue = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = pVar.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i2])).doubleValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceIndexed(double[] dArr, d.k0.c.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (!(dArr.length == 0)) {
            double dDoubleValue = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = qVar.invoke(Integer.valueOf(i2), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i2])).doubleValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reverse");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(dArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            double d2 = dArr[i2];
            dArr[i2] = dArr[lastIndex];
            dArr[lastIndex] = d2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final short first(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                return s2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final byte last(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        byte b2;
        d.k0.d.t.checkNotNullParameter(bArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = bArr.length;
        do {
            length--;
            if (length >= 0) {
                b2 = bArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(Byte.valueOf(b2)).booleanValue());
        return b2;
    }

    public static final Character reduceRightIndexedOrNull(char[] cArr, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char cCharValue = cArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            cCharValue = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i2]), Character.valueOf(cCharValue)).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static final Character reduceRightOrNull(char[] cArr, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char cCharValue = cArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            cCharValue = pVar.invoke(Character.valueOf(cArr[i2]), Character.valueOf(cCharValue)).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static final short[] sliceArray(short[] sArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? new short[0] : d.g0.l.copyOfRange(sArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final void sortDescending(float[] fArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sortDescending");
        d.g0.l.sort(fArr, i2, i3);
        reverse(fArr, i2, i3);
    }

    public static final <R, V> List<V> zip(byte[] bArr, Iterable<? extends R> iterable, d.k0.c.p<? super Byte, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Byte.valueOf(bArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associate(char[] cArr, d.k0.c.l<? super Character, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(cArr.length), 16));
        for (char c2 : cArr) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Character.valueOf(c2));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Character> associateBy(char[] cArr, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(cArr.length), 16));
        for (char c2 : cArr) {
            linkedHashMap.put(lVar.invoke(Character.valueOf(c2)), Character.valueOf(c2));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(boolean[] zArr, M m, d.k0.c.l<? super Boolean, ? extends K> lVar, d.k0.c.l<? super Boolean, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (boolean z2 : zArr) {
            m.put(lVar.invoke(Boolean.valueOf(z2)), lVar2.invoke(Boolean.valueOf(z2)));
        }
        return m;
    }

    public static final List<Character> dropLastWhile(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Character.valueOf(cArr[lastIndex])).booleanValue()) {
                return take(cArr, lastIndex + 1);
            }
        }
        return d.g0.s.emptyList();
    }

    public static final <R> List<R> flatMap(char[] cArr, d.k0.c.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            d.g0.x.addAll(arrayList, lVar.invoke(Character.valueOf(c2)));
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Long>> groupBy(long[] jArr, d.k0.c.l<? super Long, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j2 : jArr) {
            K kInvoke = lVar.invoke(Long.valueOf(j2));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(j2));
        }
        return linkedHashMap;
    }

    public static final Long maxOrNull(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$maxOrNull");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (j2 < j3) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final Long minOrNull(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$minOrNull");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (j2 > j3) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final char reduceRight(char[] cArr, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char cCharValue = cArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                cCharValue = pVar.invoke(Character.valueOf(cArr[i2]), Character.valueOf(cCharValue)).charValue();
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceRightIndexed(char[] cArr, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char cCharValue = cArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                cCharValue = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i2]), Character.valueOf(cCharValue)).charValue();
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char[] reversedArray(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reversedArray");
        int i2 = 0;
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            while (true) {
                cArr2[lastIndex - i2] = cArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return cArr2;
    }

    public static final char single(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Character singleOrNull(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Character chValueOf = null;
        boolean z2 = false;
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                if (z2) {
                    return null;
                }
                chValueOf = Character.valueOf(c2);
                z2 = true;
            }
        }
        if (z2) {
            return chValueOf;
        }
        return null;
    }

    public static final List<Character> takeLastWhile(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Character.valueOf(cArr[lastIndex])).booleanValue()) {
                return drop(cArr, lastIndex + 1);
            }
        }
        return toList(cArr);
    }

    public static final List<Character> takeWhile(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (!lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public static final List<Character> toList(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$toList");
        int length = cArr.length;
        if (length == 0) {
            return d.g0.s.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return d.g0.r.listOf(Character.valueOf(cArr[0]));
    }

    public static final Set<Character> toSet(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$toSet");
        int length = cArr.length;
        if (length == 0) {
            return z0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(cArr, new LinkedHashSet(q0.mapCapacity(d.m0.p.coerceAtMost(cArr.length, 128))));
        }
        return y0.setOf(Character.valueOf(cArr[0]));
    }

    public static final int first(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                return i2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character lastOrNull(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        char c2;
        d.k0.d.t.checkNotNullParameter(cArr, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = cArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            c2 = cArr[length];
        } while (!lVar.invoke(Character.valueOf(c2)).booleanValue());
        return Character.valueOf(c2);
    }

    public static final List<Integer> slice(int[] iArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final int[] sliceArray(int[] iArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? new int[0] : d.g0.l.copyOfRange(iArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final void sortDescending(double[] dArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sortDescending");
        d.g0.l.sort(dArr, i2, i3);
        reverse(dArr, i2, i3);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(char[] cArr, M m, d.k0.c.l<? super Character, ? extends K> lVar, d.k0.c.l<? super Character, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (char c2 : cArr) {
            m.put(lVar.invoke(Character.valueOf(c2)), lVar2.invoke(Character.valueOf(c2)));
        }
        return m;
    }

    public static final <A extends Appendable> A joinTo(float[] fArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Float, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (float f2 : fArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Float.valueOf(f2)));
            } else {
                a2.append(String.valueOf(f2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <R extends Comparable<? super R>> Long maxBy(long[] jArr, d.k0.c.l<? super Long, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j2);
        }
        R rInvoke = lVar.invoke(Long.valueOf(j2));
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                R rInvoke2 = lVar.invoke(Long.valueOf(j3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    j2 = j3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <R extends Comparable<? super R>> Long maxByOrNull(long[] jArr, d.k0.c.l<? super Long, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j2);
        }
        R rInvoke = lVar.invoke(Long.valueOf(j2));
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                R rInvoke2 = lVar.invoke(Long.valueOf(j3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    j2 = j3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <R extends Comparable<? super R>> Long minBy(long[] jArr, d.k0.c.l<? super Long, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j2);
        }
        R rInvoke = lVar.invoke(Long.valueOf(j2));
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                R rInvoke2 = lVar.invoke(Long.valueOf(j3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    j2 = j3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <R extends Comparable<? super R>> Long minByOrNull(long[] jArr, d.k0.c.l<? super Long, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j2);
        }
        R rInvoke = lVar.invoke(Long.valueOf(j2));
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                R rInvoke2 = lVar.invoke(Long.valueOf(j3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    j2 = j3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final Boolean reduceIndexedOrNull(boolean[] zArr, d.k0.c.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                zBooleanValue = qVar.invoke(Integer.valueOf(i2), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i2])).booleanValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final Boolean reduceOrNull(boolean[] zArr, d.k0.c.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                zBooleanValue = pVar.invoke(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i2])).booleanValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final void shuffle(float[] fArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            float f2 = fArr[lastIndex];
            fArr[lastIndex] = fArr[iNextInt];
            fArr[iNextInt] = f2;
        }
    }

    public static final List<Boolean> dropWhile(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (boolean z3 : zArr) {
            if (z2) {
                arrayList.add(Boolean.valueOf(z3));
            } else if (!lVar.invoke(Boolean.valueOf(z3)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z3));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final long first(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                return j2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <K, M extends Map<? super K, List<Float>>> M groupByTo(float[] fArr, M m, d.k0.c.l<? super Float, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (float f2 : fArr) {
            K kInvoke = lVar.invoke(Float.valueOf(f2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f2));
        }
        return m;
    }

    public static final short last(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        short s2;
        d.k0.d.t.checkNotNullParameter(sArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = sArr.length;
        do {
            length--;
            if (length >= 0) {
                s2 = sArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(Short.valueOf(s2)).booleanValue());
        return s2;
    }

    public static final Double maxWithOrNull(double[] dArr, Comparator<? super Double> comparator) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                if (comparator.compare(Double.valueOf(d2), Double.valueOf(d3)) < 0) {
                    d2 = d3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final Double minWithOrNull(double[] dArr, Comparator<? super Double> comparator) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                if (comparator.compare(Double.valueOf(d2), Double.valueOf(d3)) > 0) {
                    d2 = d3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final d.m<List<Float>, List<Float>> partition(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            } else {
                arrayList2.add(Float.valueOf(f2));
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final boolean reduce(boolean[] zArr, d.k0.c.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (!(zArr.length == 0)) {
            boolean zBooleanValue = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (1 <= lastIndex) {
                while (true) {
                    zBooleanValue = pVar.invoke(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i2])).booleanValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceIndexed(boolean[] zArr, d.k0.c.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (!(zArr.length == 0)) {
            boolean zBooleanValue = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (1 <= lastIndex) {
                while (true) {
                    zBooleanValue = qVar.invoke(Integer.valueOf(i2), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i2])).booleanValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reverse");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(zArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            boolean z2 = zArr[i2];
            zArr[i2] = zArr[lastIndex];
            zArr[lastIndex] = z2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final long[] sliceArray(long[] jArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? new long[0] : d.g0.l.copyOfRange(jArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final void sortDescending(char[] cArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sortDescending");
        d.g0.l.sort(cArr, i2, i3);
        reverse(cArr, i2, i3);
    }

    public static final List<Float> take(float[] fArr, int i2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= fArr.length) {
            return toList(fArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (float f2 : fArr) {
            arrayList.add(Float.valueOf(f2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Float> takeLast(float[] fArr, int i2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = fArr.length;
        if (i2 >= length) {
            return toList(fArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Float.valueOf(fArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Float.valueOf(fArr[i3]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(short[] sArr, Iterable<? extends R> iterable, d.k0.c.p<? super Short, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Short.valueOf(sArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <T, K, V> Map<K, V> associateBy(T[] tArr, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(tArr.length), 16));
        for (T t2 : tArr) {
            linkedHashMap.put(lVar.invoke(t2), lVar2.invoke(t2));
        }
        return linkedHashMap;
    }

    public static final <K> List<Double> distinctBy(double[] dArr, d.k0.c.l<? super Double, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (hashSet.add(lVar.invoke(Double.valueOf(d2)))) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    public static final <T> T single(T[] tArr, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        T t2 = null;
        boolean z2 = false;
        for (T t3 : tArr) {
            if (lVar.invoke(t3).booleanValue()) {
                if (z2) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                z2 = true;
                t2 = t3;
            }
        }
        if (z2) {
            return t2;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float first(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                return f2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Float maxOrNull(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$maxOrNull");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float fMax = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                fMax = Math.max(fMax, fArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(fMax);
    }

    public static final Float minOrNull(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$minOrNull");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float fMin = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                fMin = Math.min(fMin, fArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(fMin);
    }

    public static final float[] sliceArray(float[] fArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? new float[0] : d.g0.l.copyOfRange(fArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final List<Long> slice(long[] jArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final double first(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                return d2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int last(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        int i2;
        d.k0.d.t.checkNotNullParameter(iArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = iArr.length;
        do {
            length--;
            if (length >= 0) {
                i2 = iArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(Integer.valueOf(i2)).booleanValue());
        return i2;
    }

    public static final Character reduceIndexedOrNull(char[] cArr, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                cCharValue = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cCharValue), Character.valueOf(cArr[i2])).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharValue);
    }

    public static final Character reduceOrNull(char[] cArr, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                cCharValue = pVar.invoke(Character.valueOf(cCharValue), Character.valueOf(cArr[i2])).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharValue);
    }

    public static final void shuffle(double[] dArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            double d2 = dArr[lastIndex];
            dArr[lastIndex] = dArr[iNextInt];
            dArr[iNextInt] = d2;
        }
    }

    public static final double[] sliceArray(double[] dArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? new double[0] : d.g0.l.copyOfRange(dArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final <R, V> List<V> zip(int[] iArr, Iterable<? extends R> iterable, d.k0.c.p<? super Integer, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Integer.valueOf(iArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(byte[] bArr, d.k0.c.l<? super Byte, ? extends K> lVar, d.k0.c.l<? super Byte, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(bArr.length), 16));
        for (byte b2 : bArr) {
            linkedHashMap.put(lVar.invoke(Byte.valueOf(b2)), lVar2.invoke(Byte.valueOf(b2)));
        }
        return linkedHashMap;
    }

    public static final List<Character> dropWhile(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (char c2 : cArr) {
            if (z2) {
                arrayList.add(Character.valueOf(c2));
            } else if (!lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Float>> groupBy(float[] fArr, d.k0.c.l<? super Float, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f2 : fArr) {
            K kInvoke = lVar.invoke(Float.valueOf(f2));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f2));
        }
        return linkedHashMap;
    }

    public static final char reduce(char[] cArr, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (!(cArr.length == 0)) {
            char cCharValue = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    cCharValue = pVar.invoke(Character.valueOf(cCharValue), Character.valueOf(cArr[i2])).charValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceIndexed(char[] cArr, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (!(cArr.length == 0)) {
            char cCharValue = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    cCharValue = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cCharValue), Character.valueOf(cArr[i2])).charValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reverse");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(cArr);
        int i2 = 0;
        if (length < 0) {
            return;
        }
        while (true) {
            char c2 = cArr[i2];
            cArr[i2] = cArr[lastIndex];
            cArr[lastIndex] = c2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final byte single(byte[] bArr, d.k0.c.l<? super Byte, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Byte bValueOf = null;
        boolean z2 = false;
        for (byte b2 : bArr) {
            if (lVar.invoke(Byte.valueOf(b2)).booleanValue()) {
                if (!z2) {
                    bValueOf = Byte.valueOf(b2);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Objects.requireNonNull(bValueOf, "null cannot be cast to non-null type kotlin.Byte");
            return bValueOf.byteValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean first(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (boolean z2 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                return z2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <A extends Appendable> A joinTo(double[] dArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Double, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (double d2 : dArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Double.valueOf(d2)));
            } else {
                a2.append(String.valueOf(d2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final Boolean maxWithOrNull(boolean[] zArr, Comparator<? super Boolean> comparator) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                if (comparator.compare(Boolean.valueOf(z2), Boolean.valueOf(z3)) < 0) {
                    z2 = z3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final Boolean minWithOrNull(boolean[] zArr, Comparator<? super Boolean> comparator) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                if (comparator.compare(Boolean.valueOf(z2), Boolean.valueOf(z3)) > 0) {
                    z2 = z3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final boolean[] sliceArray(boolean[] zArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? new boolean[0] : d.g0.l.copyOfRange(zArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final <K> List<Boolean> distinctBy(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (hashSet.add(lVar.invoke(Boolean.valueOf(z2)))) {
                arrayList.add(Boolean.valueOf(z2));
            }
        }
        return arrayList;
    }

    public static final <K, M extends Map<? super K, List<Double>>> M groupByTo(double[] dArr, M m, d.k0.c.l<? super Double, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (double d2 : dArr) {
            K kInvoke = lVar.invoke(Double.valueOf(d2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Double.valueOf(d2));
        }
        return m;
    }

    public static final d.m<List<Double>, List<Double>> partition(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            } else {
                arrayList2.add(Double.valueOf(d2));
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final List<Double> take(double[] dArr, int i2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= dArr.length) {
            return toList(dArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Double.valueOf(dArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (double d2 : dArr) {
            arrayList.add(Double.valueOf(d2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Double> takeLast(double[] dArr, int i2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = dArr.length;
        if (i2 >= length) {
            return toList(dArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Double.valueOf(dArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Double.valueOf(dArr[i3]));
        }
        return arrayList;
    }

    public static final char first(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                return c2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long last(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        long j2;
        d.k0.d.t.checkNotNullParameter(jArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = jArr.length;
        do {
            length--;
            if (length >= 0) {
                j2 = jArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(Long.valueOf(j2)).booleanValue());
        return j2;
    }

    public static final <R extends Comparable<? super R>> Float maxBy(float[] fArr, d.k0.c.l<? super Float, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        R rInvoke = lVar.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                R rInvoke2 = lVar.invoke(Float.valueOf(f3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    f2 = f3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final <R extends Comparable<? super R>> Float maxByOrNull(float[] fArr, d.k0.c.l<? super Float, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        R rInvoke = lVar.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                R rInvoke2 = lVar.invoke(Float.valueOf(f3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    f2 = f3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final Double maxOrNull(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$maxOrNull");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double dMax = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                dMax = Math.max(dMax, dArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(dMax);
    }

    public static final <R extends Comparable<? super R>> Float minBy(float[] fArr, d.k0.c.l<? super Float, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        R rInvoke = lVar.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                R rInvoke2 = lVar.invoke(Float.valueOf(f3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    f2 = f3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final <R extends Comparable<? super R>> Float minByOrNull(float[] fArr, d.k0.c.l<? super Float, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        R rInvoke = lVar.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                R rInvoke2 = lVar.invoke(Float.valueOf(f3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    f2 = f3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final Double minOrNull(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$minOrNull");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double dMin = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                dMin = Math.min(dMin, dArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(dMin);
    }

    public static final List<Float> slice(float[] fArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final char[] sliceArray(char[] cArr, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? new char[0] : d.g0.l.copyOfRange(cArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final <R, V> List<V> zip(long[] jArr, Iterable<? extends R> iterable, d.k0.c.p<? super Long, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Long.valueOf(jArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(short[] sArr, d.k0.c.l<? super Short, ? extends K> lVar, d.k0.c.l<? super Short, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(sArr.length), 16));
        for (short s2 : sArr) {
            linkedHashMap.put(lVar.invoke(Short.valueOf(s2)), lVar2.invoke(Short.valueOf(s2)));
        }
        return linkedHashMap;
    }

    public static final void shuffle(boolean[] zArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            boolean z2 = zArr[lastIndex];
            zArr[lastIndex] = zArr[iNextInt];
            zArr[iNextInt] = z2;
        }
    }

    public static final <T> void reverse(T[] tArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, tArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            T t2 = tArr[i2];
            tArr[i2] = tArr[i5];
            tArr[i5] = t2;
            i5--;
            i2++;
        }
    }

    public static final short single(short[] sArr, d.k0.c.l<? super Short, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Short shValueOf = null;
        boolean z2 = false;
        for (short s2 : sArr) {
            if (lVar.invoke(Short.valueOf(s2)).booleanValue()) {
                if (!z2) {
                    shValueOf = Short.valueOf(s2);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Objects.requireNonNull(shValueOf, "null cannot be cast to non-null type kotlin.Short");
            return shValueOf.shortValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float last(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        float f2;
        d.k0.d.t.checkNotNullParameter(fArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = fArr.length;
        do {
            length--;
            if (length >= 0) {
                f2 = fArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(Float.valueOf(f2)).booleanValue());
        return f2;
    }

    public static final Character maxWithOrNull(char[] cArr, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (comparator.compare(Character.valueOf(c2), Character.valueOf(c3)) < 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final Character minWithOrNull(char[] cArr, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (comparator.compare(Character.valueOf(c2), Character.valueOf(c3)) > 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final <R, V> List<V> zip(float[] fArr, Iterable<? extends R> iterable, d.k0.c.p<? super Float, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Float.valueOf(fArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(int[] iArr, d.k0.c.l<? super Integer, ? extends K> lVar, d.k0.c.l<? super Integer, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(iArr.length), 16));
        for (int i2 : iArr) {
            linkedHashMap.put(lVar.invoke(Integer.valueOf(i2)), lVar2.invoke(Integer.valueOf(i2)));
        }
        return linkedHashMap;
    }

    public static final <K> List<Character> distinctBy(char[] cArr, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (hashSet.add(lVar.invoke(Character.valueOf(c2)))) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Double>> groupBy(double[] dArr, d.k0.c.l<? super Double, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d2 : dArr) {
            K kInvoke = lVar.invoke(Double.valueOf(d2));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Double.valueOf(d2));
        }
        return linkedHashMap;
    }

    public static final <A extends Appendable> A joinTo(boolean[] zArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Boolean, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (boolean z2 : zArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Boolean.valueOf(z2)));
            } else {
                a2.append(String.valueOf(z2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final List<Double> slice(double[] dArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final <K, M extends Map<? super K, List<Boolean>>> M groupByTo(boolean[] zArr, M m, d.k0.c.l<? super Boolean, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (boolean z2 : zArr) {
            K kInvoke = lVar.invoke(Boolean.valueOf(z2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Boolean.valueOf(z2));
        }
        return m;
    }

    public static final Character maxOrNull(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$maxOrNull");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (d.k0.d.t.compare((int) c2, (int) c3) < 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final Character minOrNull(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$minOrNull");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (d.k0.d.t.compare((int) c2, (int) c3) > 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final d.m<List<Boolean>, List<Boolean>> partition(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z2 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z2)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
            } else {
                arrayList2.add(Boolean.valueOf(z2));
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final void shuffle(char[] cArr, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            char c2 = cArr[lastIndex];
            cArr[lastIndex] = cArr[iNextInt];
            cArr[iNextInt] = c2;
        }
    }

    public static final List<Boolean> take(boolean[] zArr, int i2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= zArr.length) {
            return toList(zArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (boolean z2 : zArr) {
            arrayList.add(Boolean.valueOf(z2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Boolean> takeLast(boolean[] zArr, int i2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = zArr.length;
        if (i2 >= length) {
            return toList(zArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Boolean.valueOf(zArr[i3]));
        }
        return arrayList;
    }

    public static final void reverse(byte[] bArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, bArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i5];
            bArr[i5] = b2;
            i5--;
            i2++;
        }
    }

    public static final double last(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        double d2;
        d.k0.d.t.checkNotNullParameter(dArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = dArr.length;
        do {
            length--;
            if (length >= 0) {
                d2 = dArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(Double.valueOf(d2)).booleanValue());
        return d2;
    }

    public static final <R, V> List<V> zip(double[] dArr, Iterable<? extends R> iterable, d.k0.c.p<? super Double, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Double.valueOf(dArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(long[] jArr, d.k0.c.l<? super Long, ? extends K> lVar, d.k0.c.l<? super Long, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(jArr.length), 16));
        for (long j2 : jArr) {
            linkedHashMap.put(lVar.invoke(Long.valueOf(j2)), lVar2.invoke(Long.valueOf(j2)));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> Double maxBy(double[] dArr, d.k0.c.l<? super Double, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        R rInvoke = lVar.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                R rInvoke2 = lVar.invoke(Double.valueOf(d3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    d2 = d3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final <R extends Comparable<? super R>> Double maxByOrNull(double[] dArr, d.k0.c.l<? super Double, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        R rInvoke = lVar.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                R rInvoke2 = lVar.invoke(Double.valueOf(d3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    d2 = d3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final <R extends Comparable<? super R>> Double minBy(double[] dArr, d.k0.c.l<? super Double, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        R rInvoke = lVar.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                R rInvoke2 = lVar.invoke(Double.valueOf(d3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    d2 = d3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final <R extends Comparable<? super R>> Double minByOrNull(double[] dArr, d.k0.c.l<? super Double, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        R rInvoke = lVar.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                R rInvoke2 = lVar.invoke(Double.valueOf(d3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    d2 = d3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final int single(int[] iArr, d.k0.c.l<? super Integer, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Integer numValueOf = null;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (lVar.invoke(Integer.valueOf(i2)).booleanValue()) {
                if (!z2) {
                    numValueOf = Integer.valueOf(i2);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Objects.requireNonNull(numValueOf, "null cannot be cast to non-null type kotlin.Int");
            return numValueOf.intValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final List<Boolean> slice(boolean[] zArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final <A extends Appendable> A joinTo(char[] cArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super Character, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (char c2 : cArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Character.valueOf(c2)));
            } else {
                a2.append(c2);
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final boolean last(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        boolean z2;
        d.k0.d.t.checkNotNullParameter(zArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = zArr.length;
        do {
            length--;
            if (length >= 0) {
                z2 = zArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(Boolean.valueOf(z2)).booleanValue());
        return z2;
    }

    public static final void reverse(short[] sArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, sArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            short s2 = sArr[i2];
            sArr[i2] = sArr[i5];
            sArr[i5] = s2;
            i5--;
            i2++;
        }
    }

    public static final <R, V> List<V> zip(boolean[] zArr, Iterable<? extends R> iterable, d.k0.c.p<? super Boolean, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Boolean.valueOf(zArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(float[] fArr, d.k0.c.l<? super Float, ? extends K> lVar, d.k0.c.l<? super Float, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(fArr.length), 16));
        for (float f2 : fArr) {
            linkedHashMap.put(lVar.invoke(Float.valueOf(f2)), lVar2.invoke(Float.valueOf(f2)));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Boolean>> groupBy(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z2 : zArr) {
            K kInvoke = lVar.invoke(Boolean.valueOf(z2));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Boolean.valueOf(z2));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(char[] cArr, M m, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (char c2 : cArr) {
            K kInvoke = lVar.invoke(Character.valueOf(c2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c2));
        }
        return m;
    }

    public static final d.m<List<Character>, List<Character>> partition(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            } else {
                arrayList2.add(Character.valueOf(c2));
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final List<Character> take(char[] cArr, int i2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        if (i2 >= cArr.length) {
            return toList(cArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Character.valueOf(cArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (char c2 : cArr) {
            arrayList.add(Character.valueOf(c2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Character> takeLast(char[] cArr, int i2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return d.g0.s.emptyList();
        }
        int length = cArr.length;
        if (i2 >= length) {
            return toList(cArr);
        }
        if (i2 == 1) {
            return d.g0.r.listOf(Character.valueOf(cArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Character.valueOf(cArr[i3]));
        }
        return arrayList;
    }

    public static final long single(long[] jArr, d.k0.c.l<? super Long, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Long lValueOf = null;
        boolean z2 = false;
        for (long j2 : jArr) {
            if (lVar.invoke(Long.valueOf(j2)).booleanValue()) {
                if (!z2) {
                    lValueOf = Long.valueOf(j2);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type kotlin.Long");
            return lValueOf.longValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final List<Character> slice(char[] cArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final char last(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        char c2;
        d.k0.d.t.checkNotNullParameter(cArr, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = cArr.length;
        do {
            length--;
            if (length >= 0) {
                c2 = cArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!lVar.invoke(Character.valueOf(c2)).booleanValue());
        return c2;
    }

    public static final <R, V> List<V> zip(char[] cArr, Iterable<? extends R> iterable, d.k0.c.p<? super Character, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Character.valueOf(cArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(double[] dArr, d.k0.c.l<? super Double, ? extends K> lVar, d.k0.c.l<? super Double, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(dArr.length), 16));
        for (double d2 : dArr) {
            linkedHashMap.put(lVar.invoke(Double.valueOf(d2)), lVar2.invoke(Double.valueOf(d2)));
        }
        return linkedHashMap;
    }

    public static final void reverse(int[] iArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, iArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            int i6 = iArr[i2];
            iArr[i2] = iArr[i5];
            iArr[i5] = i6;
            i5--;
            i2++;
        }
    }

    public static final <R extends Comparable<? super R>> Boolean maxBy(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z2));
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                R rInvoke2 = lVar.invoke(Boolean.valueOf(z3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    z2 = z3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final <R extends Comparable<? super R>> Boolean maxByOrNull(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z2));
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                R rInvoke2 = lVar.invoke(Boolean.valueOf(z3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    z2 = z3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final <R extends Comparable<? super R>> Boolean minBy(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z2));
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                R rInvoke2 = lVar.invoke(Boolean.valueOf(z3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    z2 = z3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final <R extends Comparable<? super R>> Boolean minByOrNull(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z2));
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                R rInvoke2 = lVar.invoke(Boolean.valueOf(z3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    z2 = z3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(T[] tArr, M m, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (T t2 : tArr) {
            K kInvoke = lVar.invoke(t2);
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(t2));
        }
        return m;
    }

    public static final <V> List<V> zip(byte[] bArr, byte[] bArr2, d.k0.c.p<? super Byte, ? super Byte, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(bArr2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(bArr2[i2])));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends K> lVar, d.k0.c.l<? super Boolean, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(zArr.length), 16));
        for (boolean z2 : zArr) {
            linkedHashMap.put(lVar.invoke(Boolean.valueOf(z2)), lVar2.invoke(Boolean.valueOf(z2)));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Character>> groupBy(char[] cArr, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c2 : cArr) {
            K kInvoke = lVar.invoke(Character.valueOf(c2));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c2));
        }
        return linkedHashMap;
    }

    public static final float single(float[] fArr, d.k0.c.l<? super Float, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Float fValueOf = null;
        boolean z2 = false;
        for (float f2 : fArr) {
            if (lVar.invoke(Float.valueOf(f2)).booleanValue()) {
                if (!z2) {
                    fValueOf = Float.valueOf(f2);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Objects.requireNonNull(fValueOf, "null cannot be cast to non-null type kotlin.Float");
            return fValueOf.floatValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final void reverse(long[] jArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, jArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            long j2 = jArr[i2];
            jArr[i2] = jArr[i5];
            jArr[i5] = j2;
            i5--;
            i2++;
        }
    }

    public static final <V> List<V> zip(short[] sArr, short[] sArr2, d.k0.c.p<? super Short, ? super Short, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(sArr2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Short.valueOf(sArr[i2]), Short.valueOf(sArr2[i2])));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(char[] cArr, d.k0.c.l<? super Character, ? extends K> lVar, d.k0.c.l<? super Character, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(cArr.length), 16));
        for (char c2 : cArr) {
            linkedHashMap.put(lVar.invoke(Character.valueOf(c2)), lVar2.invoke(Character.valueOf(c2)));
        }
        return linkedHashMap;
    }

    public static final <V> List<V> zip(int[] iArr, int[] iArr2, d.k0.c.p<? super Integer, ? super Integer, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iArr2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(iArr2[i2])));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(byte[] bArr, M m, d.k0.c.l<? super Byte, ? extends K> lVar, d.k0.c.l<? super Byte, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (byte b2 : bArr) {
            K kInvoke = lVar.invoke(Byte.valueOf(b2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Byte.valueOf(b2)));
        }
        return m;
    }

    public static final <R extends Comparable<? super R>> Character maxBy(char[] cArr, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        R rInvoke = lVar.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                R rInvoke2 = lVar.invoke(Character.valueOf(c3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    c2 = c3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final <R extends Comparable<? super R>> Character maxByOrNull(char[] cArr, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        R rInvoke = lVar.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                R rInvoke2 = lVar.invoke(Character.valueOf(c3));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    c2 = c3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final <R extends Comparable<? super R>> Character minBy(char[] cArr, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        R rInvoke = lVar.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                R rInvoke2 = lVar.invoke(Character.valueOf(c3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    c2 = c3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final <R extends Comparable<? super R>> Character minByOrNull(char[] cArr, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        R rInvoke = lVar.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                R rInvoke2 = lVar.invoke(Character.valueOf(c3));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    c2 = c3;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final void reverse(float[] fArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, fArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            float f2 = fArr[i2];
            fArr[i2] = fArr[i5];
            fArr[i5] = f2;
            i5--;
            i2++;
        }
    }

    public static final double single(double[] dArr, d.k0.c.l<? super Double, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Double dValueOf = null;
        boolean z2 = false;
        for (double d2 : dArr) {
            if (lVar.invoke(Double.valueOf(d2)).booleanValue()) {
                if (!z2) {
                    dValueOf = Double.valueOf(d2);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Objects.requireNonNull(dValueOf, "null cannot be cast to non-null type kotlin.Double");
            return dValueOf.doubleValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, List<V>> groupBy(T[] tArr, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a.a.a aVar : tArr) {
            K kInvoke = lVar.invoke(aVar);
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(aVar));
        }
        return linkedHashMap;
    }

    public static final <V> List<V> zip(long[] jArr, long[] jArr2, d.k0.c.p<? super Long, ? super Long, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(jArr2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Long.valueOf(jArr[i2]), Long.valueOf(jArr2[i2])));
        }
        return arrayList;
    }

    public static final void reverse(double[] dArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, dArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            double d2 = dArr[i2];
            dArr[i2] = dArr[i5];
            dArr[i5] = d2;
            i5--;
            i2++;
        }
    }

    public static final <V> List<V> zip(float[] fArr, float[] fArr2, d.k0.c.p<? super Float, ? super Float, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(fArr2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(fArr.length, fArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Float.valueOf(fArr[i2]), Float.valueOf(fArr2[i2])));
        }
        return arrayList;
    }

    public static final boolean single(boolean[] zArr, d.k0.c.l<? super Boolean, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Boolean boolValueOf = null;
        boolean z2 = false;
        for (boolean z3 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z3)).booleanValue()) {
                if (!z2) {
                    boolValueOf = Boolean.valueOf(z3);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Objects.requireNonNull(boolValueOf, "null cannot be cast to non-null type kotlin.Boolean");
            return boolValueOf.booleanValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(short[] sArr, M m, d.k0.c.l<? super Short, ? extends K> lVar, d.k0.c.l<? super Short, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (short s2 : sArr) {
            K kInvoke = lVar.invoke(Short.valueOf(s2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Short.valueOf(s2)));
        }
        return m;
    }

    public static final <V> List<V> zip(double[] dArr, double[] dArr2, d.k0.c.p<? super Double, ? super Double, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(dArr2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(dArr.length, dArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Double.valueOf(dArr[i2]), Double.valueOf(dArr2[i2])));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(byte[] bArr, d.k0.c.l<? super Byte, ? extends K> lVar, d.k0.c.l<? super Byte, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b2 : bArr) {
            K kInvoke = lVar.invoke(Byte.valueOf(b2));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Byte.valueOf(b2)));
        }
        return linkedHashMap;
    }

    public static final void reverse(boolean[] zArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, zArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            boolean z2 = zArr[i2];
            zArr[i2] = zArr[i5];
            zArr[i5] = z2;
            i5--;
            i2++;
        }
    }

    public static final <V> List<V> zip(boolean[] zArr, boolean[] zArr2, d.k0.c.p<? super Boolean, ? super Boolean, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(zArr2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(zArr.length, zArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(zArr2[i2])));
        }
        return arrayList;
    }

    public static final char single(char[] cArr, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Character chValueOf = null;
        boolean z2 = false;
        for (char c2 : cArr) {
            if (lVar.invoke(Character.valueOf(c2)).booleanValue()) {
                if (!z2) {
                    chValueOf = Character.valueOf(c2);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Objects.requireNonNull(chValueOf, "null cannot be cast to non-null type kotlin.Char");
            return chValueOf.charValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(int[] iArr, M m, d.k0.c.l<? super Integer, ? extends K> lVar, d.k0.c.l<? super Integer, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (int i2 : iArr) {
            K kInvoke = lVar.invoke(Integer.valueOf(i2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Integer.valueOf(i2)));
        }
        return m;
    }

    public static final <V> List<V> zip(char[] cArr, char[] cArr2, d.k0.c.p<? super Character, ? super Character, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(cArr2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(cArr.length, cArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Character.valueOf(cArr[i2]), Character.valueOf(cArr2[i2])));
        }
        return arrayList;
    }

    public static final void reverse(char[] cArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$reverse");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, cArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            char c2 = cArr[i2];
            cArr[i2] = cArr[i5];
            cArr[i5] = c2;
            i5--;
            i2++;
        }
    }

    public static final <T, R> List<d.m<T, R>> zip(T[] tArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(tArr[i2], rArr[i2]));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(short[] sArr, d.k0.c.l<? super Short, ? extends K> lVar, d.k0.c.l<? super Short, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s2 : sArr) {
            K kInvoke = lVar.invoke(Short.valueOf(s2));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Short.valueOf(s2)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(long[] jArr, M m, d.k0.c.l<? super Long, ? extends K> lVar, d.k0.c.l<? super Long, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (long j2 : jArr) {
            K kInvoke = lVar.invoke(Long.valueOf(j2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Long.valueOf(j2)));
        }
        return m;
    }

    public static final <R> List<d.m<Byte, R>> zip(byte[] bArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            byte b2 = bArr[i2];
            arrayList.add(d.s.to(Byte.valueOf(b2), rArr[i2]));
        }
        return arrayList;
    }

    public static final <R> List<d.m<Short, R>> zip(short[] sArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            short s2 = sArr[i2];
            arrayList.add(d.s.to(Short.valueOf(s2), rArr[i2]));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(int[] iArr, d.k0.c.l<? super Integer, ? extends K> lVar, d.k0.c.l<? super Integer, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 : iArr) {
            K kInvoke = lVar.invoke(Integer.valueOf(i2));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Integer.valueOf(i2)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(float[] fArr, M m, d.k0.c.l<? super Float, ? extends K> lVar, d.k0.c.l<? super Float, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (float f2 : fArr) {
            K kInvoke = lVar.invoke(Float.valueOf(f2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Float.valueOf(f2)));
        }
        return m;
    }

    public static final <R> List<d.m<Integer, R>> zip(int[] iArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = iArr[i2];
            arrayList.add(d.s.to(Integer.valueOf(i3), rArr[i2]));
        }
        return arrayList;
    }

    public static final <R> List<d.m<Long, R>> zip(long[] jArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            long j2 = jArr[i2];
            arrayList.add(d.s.to(Long.valueOf(j2), rArr[i2]));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(long[] jArr, d.k0.c.l<? super Long, ? extends K> lVar, d.k0.c.l<? super Long, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j2 : jArr) {
            K kInvoke = lVar.invoke(Long.valueOf(j2));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Long.valueOf(j2)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(double[] dArr, M m, d.k0.c.l<? super Double, ? extends K> lVar, d.k0.c.l<? super Double, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (double d2 : dArr) {
            K kInvoke = lVar.invoke(Double.valueOf(d2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Double.valueOf(d2)));
        }
        return m;
    }

    public static final <R> List<d.m<Float, R>> zip(float[] fArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(fArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            float f2 = fArr[i2];
            arrayList.add(d.s.to(Float.valueOf(f2), rArr[i2]));
        }
        return arrayList;
    }

    public static final <R> List<d.m<Double, R>> zip(double[] dArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(dArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            double d2 = dArr[i2];
            arrayList.add(d.s.to(Double.valueOf(d2), rArr[i2]));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(float[] fArr, d.k0.c.l<? super Float, ? extends K> lVar, d.k0.c.l<? super Float, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f2 : fArr) {
            K kInvoke = lVar.invoke(Float.valueOf(f2));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Float.valueOf(f2)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(boolean[] zArr, M m, d.k0.c.l<? super Boolean, ? extends K> lVar, d.k0.c.l<? super Boolean, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (boolean z2 : zArr) {
            K kInvoke = lVar.invoke(Boolean.valueOf(z2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Boolean.valueOf(z2)));
        }
        return m;
    }

    public static final <R> List<d.m<Boolean, R>> zip(boolean[] zArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(zArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            boolean z2 = zArr[i2];
            arrayList.add(d.s.to(Boolean.valueOf(z2), rArr[i2]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(char[] cArr, M m, d.k0.c.l<? super Character, ? extends K> lVar, d.k0.c.l<? super Character, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (char c2 : cArr) {
            K kInvoke = lVar.invoke(Character.valueOf(c2));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Character.valueOf(c2)));
        }
        return m;
    }

    public static final <R> List<d.m<Character, R>> zip(char[] cArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(cArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            char c2 = cArr[i2];
            arrayList.add(d.s.to(Character.valueOf(c2), rArr[i2]));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(double[] dArr, d.k0.c.l<? super Double, ? extends K> lVar, d.k0.c.l<? super Double, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d2 : dArr) {
            K kInvoke = lVar.invoke(Double.valueOf(d2));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Double.valueOf(d2)));
        }
        return linkedHashMap;
    }

    public static final <T, R> List<d.m<T, R>> zip(T[] tArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(tArr[i2], r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(boolean[] zArr, d.k0.c.l<? super Boolean, ? extends K> lVar, d.k0.c.l<? super Boolean, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z2 : zArr) {
            K kInvoke = lVar.invoke(Boolean.valueOf(z2));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Boolean.valueOf(z2)));
        }
        return linkedHashMap;
    }

    public static final <R> List<d.m<Byte, R>> zip(byte[] bArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(Byte.valueOf(bArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<d.m<Short, R>> zip(short[] sArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(Short.valueOf(sArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(char[] cArr, d.k0.c.l<? super Character, ? extends K> lVar, d.k0.c.l<? super Character, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c2 : cArr) {
            K kInvoke = lVar.invoke(Character.valueOf(c2));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Character.valueOf(c2)));
        }
        return linkedHashMap;
    }

    public static final <R> List<d.m<Integer, R>> zip(int[] iArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(Integer.valueOf(iArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<d.m<Long, R>> zip(long[] jArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(Long.valueOf(jArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<d.m<Float, R>> zip(float[] fArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(Float.valueOf(fArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<d.m<Double, R>> zip(double[] dArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(Double.valueOf(dArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<d.m<Boolean, R>> zip(boolean[] zArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(Boolean.valueOf(zArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<d.m<Character, R>> zip(char[] cArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (R r2 : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(Character.valueOf(cArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final List<d.m<Byte, Byte>> zip(byte[] bArr, byte[] bArr2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(bArr2, "other");
        int iMin = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Byte.valueOf(bArr[i2]), Byte.valueOf(bArr2[i2])));
        }
        return arrayList;
    }

    public static final List<d.m<Short, Short>> zip(short[] sArr, short[] sArr2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(sArr2, "other");
        int iMin = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Short.valueOf(sArr[i2]), Short.valueOf(sArr2[i2])));
        }
        return arrayList;
    }

    public static final List<d.m<Integer, Integer>> zip(int[] iArr, int[] iArr2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iArr2, "other");
        int iMin = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Integer.valueOf(iArr[i2]), Integer.valueOf(iArr2[i2])));
        }
        return arrayList;
    }

    public static final List<d.m<Long, Long>> zip(long[] jArr, long[] jArr2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(jArr2, "other");
        int iMin = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Long.valueOf(jArr[i2]), Long.valueOf(jArr2[i2])));
        }
        return arrayList;
    }

    public static final List<d.m<Float, Float>> zip(float[] fArr, float[] fArr2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(fArr2, "other");
        int iMin = Math.min(fArr.length, fArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Float.valueOf(fArr[i2]), Float.valueOf(fArr2[i2])));
        }
        return arrayList;
    }

    public static final List<d.m<Double, Double>> zip(double[] dArr, double[] dArr2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(dArr2, "other");
        int iMin = Math.min(dArr.length, dArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Double.valueOf(dArr[i2]), Double.valueOf(dArr2[i2])));
        }
        return arrayList;
    }

    public static final List<d.m<Boolean, Boolean>> zip(boolean[] zArr, boolean[] zArr2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(zArr2, "other");
        int iMin = Math.min(zArr.length, zArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Boolean.valueOf(zArr[i2]), Boolean.valueOf(zArr2[i2])));
        }
        return arrayList;
    }

    public static final List<d.m<Character, Character>> zip(char[] cArr, char[] cArr2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(cArr2, "other");
        int iMin = Math.min(cArr.length, cArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Character.valueOf(cArr[i2]), Character.valueOf(cArr2[i2])));
        }
        return arrayList;
    }
}
