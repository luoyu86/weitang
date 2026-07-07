package d.g0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class l extends k {

    public static final class a extends d.g0.d<Byte> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f12508b;

        public a(byte[] bArr) {
            this.f12508b = bArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return contains(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12508b.length;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return indexOf(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12508b.length == 0;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return lastIndexOf(((Number) obj).byteValue());
            }
            return -1;
        }

        public boolean contains(byte b2) {
            return m.contains(this.f12508b, b2);
        }

        @Override // d.g0.d, java.util.List
        public Byte get(int i2) {
            return Byte.valueOf(this.f12508b[i2]);
        }

        public int indexOf(byte b2) {
            return m.indexOf(this.f12508b, b2);
        }

        public int lastIndexOf(byte b2) {
            return m.lastIndexOf(this.f12508b, b2);
        }
    }

    public static final class b extends d.g0.d<Short> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ short[] f12509b;

        public b(short[] sArr) {
            this.f12509b = sArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Short) {
                return contains(((Number) obj).shortValue());
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12509b.length;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Short) {
                return indexOf(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12509b.length == 0;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Short) {
                return lastIndexOf(((Number) obj).shortValue());
            }
            return -1;
        }

        public boolean contains(short s) {
            return m.contains(this.f12509b, s);
        }

        @Override // d.g0.d, java.util.List
        public Short get(int i2) {
            return Short.valueOf(this.f12509b[i2]);
        }

        public int indexOf(short s) {
            return m.indexOf(this.f12509b, s);
        }

        public int lastIndexOf(short s) {
            return m.lastIndexOf(this.f12509b, s);
        }
    }

    public static final class c extends d.g0.d<Integer> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f12510b;

        public c(int[] iArr) {
            this.f12510b = iArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return contains(((Number) obj).intValue());
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12510b.length;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return indexOf(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12510b.length == 0;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return lastIndexOf(((Number) obj).intValue());
            }
            return -1;
        }

        public boolean contains(int i2) {
            return m.contains(this.f12510b, i2);
        }

        @Override // d.g0.d, java.util.List
        public Integer get(int i2) {
            return Integer.valueOf(this.f12510b[i2]);
        }

        public int indexOf(int i2) {
            return m.indexOf(this.f12510b, i2);
        }

        public int lastIndexOf(int i2) {
            return m.lastIndexOf(this.f12510b, i2);
        }
    }

    public static final class d extends d.g0.d<Long> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f12511b;

        public d(long[] jArr) {
            this.f12511b = jArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Long) {
                return contains(((Number) obj).longValue());
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12511b.length;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Long) {
                return indexOf(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12511b.length == 0;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return lastIndexOf(((Number) obj).longValue());
            }
            return -1;
        }

        public boolean contains(long j) {
            return m.contains(this.f12511b, j);
        }

        @Override // d.g0.d, java.util.List
        public Long get(int i2) {
            return Long.valueOf(this.f12511b[i2]);
        }

        public int indexOf(long j) {
            return m.indexOf(this.f12511b, j);
        }

        public int lastIndexOf(long j) {
            return m.lastIndexOf(this.f12511b, j);
        }
    }

    public static final class e extends d.g0.d<Float> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float[] f12512b;

        public e(float[] fArr) {
            this.f12512b = fArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return contains(((Number) obj).floatValue());
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12512b.length;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return indexOf(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12512b.length == 0;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return lastIndexOf(((Number) obj).floatValue());
            }
            return -1;
        }

        public boolean contains(float f2) {
            for (float f3 : this.f12512b) {
                if (Float.floatToIntBits(f3) == Float.floatToIntBits(f2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // d.g0.d, java.util.List
        public Float get(int i2) {
            return Float.valueOf(this.f12512b[i2]);
        }

        public int indexOf(float f2) {
            float[] fArr = this.f12512b;
            int length = fArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (Float.floatToIntBits(fArr[i2]) == Float.floatToIntBits(f2)) {
                    return i2;
                }
            }
            return -1;
        }

        public int lastIndexOf(float f2) {
            float[] fArr = this.f12512b;
            for (int length = fArr.length - 1; length >= 0; length--) {
                if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f2)) {
                    return length;
                }
            }
            return -1;
        }
    }

    public static final class f extends d.g0.d<Double> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double[] f12513b;

        public f(double[] dArr) {
            this.f12513b = dArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Double) {
                return contains(((Number) obj).doubleValue());
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12513b.length;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Double) {
                return indexOf(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12513b.length == 0;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return lastIndexOf(((Number) obj).doubleValue());
            }
            return -1;
        }

        public boolean contains(double d2) {
            for (double d3 : this.f12513b) {
                if (Double.doubleToLongBits(d3) == Double.doubleToLongBits(d2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // d.g0.d, java.util.List
        public Double get(int i2) {
            return Double.valueOf(this.f12513b[i2]);
        }

        public int indexOf(double d2) {
            double[] dArr = this.f12513b;
            int length = dArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (Double.doubleToLongBits(dArr[i2]) == Double.doubleToLongBits(d2)) {
                    return i2;
                }
            }
            return -1;
        }

        public int lastIndexOf(double d2) {
            double[] dArr = this.f12513b;
            for (int length = dArr.length - 1; length >= 0; length--) {
                if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d2)) {
                    return length;
                }
            }
            return -1;
        }
    }

    public static final class g extends d.g0.d<Boolean> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f12514b;

        public g(boolean[] zArr) {
            this.f12514b = zArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                return contains(((Boolean) obj).booleanValue());
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12514b.length;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                return indexOf(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12514b.length == 0;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Boolean) {
                return lastIndexOf(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        public boolean contains(boolean z) {
            return m.contains(this.f12514b, z);
        }

        @Override // d.g0.d, java.util.List
        public Boolean get(int i2) {
            return Boolean.valueOf(this.f12514b[i2]);
        }

        public int indexOf(boolean z) {
            return m.indexOf(this.f12514b, z);
        }

        public int lastIndexOf(boolean z) {
            return m.lastIndexOf(this.f12514b, z);
        }
    }

    public static final class h extends d.g0.d<Character> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ char[] f12515b;

        public h(char[] cArr) {
            this.f12515b = cArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Character) {
                return contains(((Character) obj).charValue());
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12515b.length;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Character) {
                return indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return this.f12515b.length == 0;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public boolean contains(char c2) {
            return m.contains(this.f12515b, c2);
        }

        @Override // d.g0.d, java.util.List
        public Character get(int i2) {
            return Character.valueOf(this.f12515b[i2]);
        }

        public int indexOf(char c2) {
            return m.indexOf(this.f12515b, c2);
        }

        public int lastIndexOf(char c2) {
            return m.lastIndexOf(this.f12515b, c2);
        }
    }

    public static final <T> List<T> asList(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$asList");
        List<T> listA = n.a(tArr);
        d.k0.d.t.checkNotNullExpressionValue(listA, "ArraysUtilJVM.asList(this)");
        return listA;
    }

    public static final <T> int binarySearch(T[] tArr, T t, Comparator<? super T> comparator, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$binarySearch");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return Arrays.binarySearch(tArr, i2, i3, t, comparator);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return binarySearch(objArr, obj, comparator, i2, i3);
    }

    public static final <T> T[] copyInto(T[] tArr, T[] tArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(tArr2, "destination");
        System.arraycopy(tArr, i3, tArr2, i2, i4 - i3);
        return tArr2;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return copyInto(objArr, objArr2, i2, i3, i4);
    }

    public static final <T> T[] copyOfRange(T[] tArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> void fill(T[] tArr, T t, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$fill");
        Arrays.fill(tArr, i2, i3, t);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        fill(objArr, obj, i2, i3);
    }

    public static final <R> List<R> filterIsInstance(Object[] objArr, Class<R> cls) {
        d.k0.d.t.checkNotNullParameter(objArr, "$this$filterIsInstance");
        d.k0.d.t.checkNotNullParameter(cls, "klass");
        return (List) filterIsInstanceTo(objArr, new ArrayList(), cls);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Object[] objArr, C c2, Class<R> cls) {
        d.k0.d.t.checkNotNullParameter(objArr, "$this$filterIsInstanceTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(cls, "klass");
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T> T[] plus(T[] tArr, T t) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$plus");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t;
        d.k0.d.t.checkNotNullExpressionValue(tArr2, "result");
        return tArr2;
    }

    public static final void sort(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sort");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static /* synthetic */ void sort$default(Comparable[] comparableArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = comparableArr.length;
        }
        sort(comparableArr, i2, i3);
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ void sortWith$default(Object[] objArr, Comparator comparator, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        sortWith(objArr, comparator, i2, i3);
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(tArr, new TreeSet());
    }

    public static final Byte[] toTypedArray(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toTypedArray");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    public static final List<Byte> asList(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$asList");
        return new a(bArr);
    }

    public static final <T> int binarySearch(T[] tArr, T t, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$binarySearch");
        return Arrays.binarySearch(tArr, i2, i3, t);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        return binarySearch(objArr, obj, i2, i3);
    }

    public static final byte[] copyInto(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(bArr2, "destination");
        System.arraycopy(bArr, i3, bArr2, i2, i4 - i3);
        return bArr2;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        return copyInto(bArr, bArr2, i2, i3, i4);
    }

    public static final void fill(byte[] bArr, byte b2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$fill");
        Arrays.fill(bArr, i2, i3, b2);
    }

    public static /* synthetic */ void fill$default(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        fill(bArr, b2, i2, i3);
    }

    public static final void sort(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sort");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    public static /* synthetic */ void sort$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        sort(bArr, i2, i3);
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sortWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Arrays.sort(tArr, i2, i3, comparator);
    }

    public static final SortedSet<Byte> toSortedSet(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(bArr, new TreeSet());
    }

    public static final List<Short> asList(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$asList");
        return new b(sArr);
    }

    public static final int binarySearch(byte[] bArr, byte b2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$binarySearch");
        return Arrays.binarySearch(bArr, i2, i3, b2);
    }

    public static /* synthetic */ int binarySearch$default(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        return binarySearch(bArr, b2, i2, i3);
    }

    public static final short[] copyInto(short[] sArr, short[] sArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(sArr2, "destination");
        System.arraycopy(sArr, i3, sArr2, i2, i4 - i3);
        return sArr2;
    }

    public static /* synthetic */ short[] copyInto$default(short[] sArr, short[] sArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sArr.length;
        }
        return copyInto(sArr, sArr2, i2, i3, i4);
    }

    public static final byte[] copyOfRange(byte[] bArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    public static final void fill(short[] sArr, short s, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$fill");
        Arrays.fill(sArr, i2, i3, s);
    }

    public static /* synthetic */ void fill$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        fill(sArr, s, i2, i3);
    }

    public static final void sort(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sort");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    public static /* synthetic */ void sort$default(short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = sArr.length;
        }
        sort(sArr, i2, i3);
    }

    public static final SortedSet<Short> toSortedSet(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(sArr, new TreeSet());
    }

    public static final List<Integer> asList(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$asList");
        return new c(iArr);
    }

    public static final int binarySearch(short[] sArr, short s, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$binarySearch");
        return Arrays.binarySearch(sArr, i2, i3, s);
    }

    public static /* synthetic */ int binarySearch$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        return binarySearch(sArr, s, i2, i3);
    }

    public static final int[] copyInto(int[] iArr, int[] iArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(iArr2, "destination");
        System.arraycopy(iArr, i3, iArr2, i2, i4 - i3);
        return iArr2;
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = iArr.length;
        }
        return copyInto(iArr, iArr2, i2, i3, i4);
    }

    public static final void fill(int[] iArr, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$fill");
        Arrays.fill(iArr, i3, i4, i2);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        fill(iArr, i2, i3, i4);
    }

    public static final void sort(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sort");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    public static /* synthetic */ void sort$default(int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = iArr.length;
        }
        sort(iArr, i2, i3);
    }

    public static final SortedSet<Integer> toSortedSet(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(iArr, new TreeSet());
    }

    public static final Short[] toTypedArray(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toTypedArray");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            shArr[i2] = Short.valueOf(sArr[i2]);
        }
        return shArr;
    }

    public static final List<Long> asList(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$asList");
        return new d(jArr);
    }

    public static final int binarySearch(int[] iArr, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$binarySearch");
        return Arrays.binarySearch(iArr, i3, i4, i2);
    }

    public static /* synthetic */ int binarySearch$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        return binarySearch(iArr, i2, i3, i4);
    }

    public static final long[] copyInto(long[] jArr, long[] jArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(jArr2, "destination");
        System.arraycopy(jArr, i3, jArr2, i2, i4 - i3);
        return jArr2;
    }

    public static /* synthetic */ long[] copyInto$default(long[] jArr, long[] jArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = jArr.length;
        }
        return copyInto(jArr, jArr2, i2, i3, i4);
    }

    public static final short[] copyOfRange(short[] sArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, sArr.length);
        short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return sArrCopyOfRange;
    }

    public static final void fill(long[] jArr, long j, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$fill");
        Arrays.fill(jArr, i2, i3, j);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        fill(jArr, j, i2, i3);
    }

    public static final byte[] plus(byte[] bArr, byte b2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$plus");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + 1);
        bArrCopyOf[length] = b2;
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "result");
        return bArrCopyOf;
    }

    public static final void sort(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sort");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    public static /* synthetic */ void sort$default(long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = jArr.length;
        }
        sort(jArr, i2, i3);
    }

    public static final SortedSet<Long> toSortedSet(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(jArr, new TreeSet());
    }

    public static final List<Float> asList(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$asList");
        return new e(fArr);
    }

    public static final int binarySearch(long[] jArr, long j, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$binarySearch");
        return Arrays.binarySearch(jArr, i2, i3, j);
    }

    public static /* synthetic */ int binarySearch$default(long[] jArr, long j, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        return binarySearch(jArr, j, i2, i3);
    }

    public static final float[] copyInto(float[] fArr, float[] fArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(fArr2, "destination");
        System.arraycopy(fArr, i3, fArr2, i2, i4 - i3);
        return fArr2;
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = fArr.length;
        }
        return copyInto(fArr, fArr2, i2, i3, i4);
    }

    public static final void fill(float[] fArr, float f2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$fill");
        Arrays.fill(fArr, i2, i3, f2);
    }

    public static /* synthetic */ void fill$default(float[] fArr, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        fill(fArr, f2, i2, i3);
    }

    public static final void sort(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sort");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    public static /* synthetic */ void sort$default(float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = fArr.length;
        }
        sort(fArr, i2, i3);
    }

    public static final SortedSet<Float> toSortedSet(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(fArr, new TreeSet());
    }

    public static final List<Double> asList(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$asList");
        return new f(dArr);
    }

    public static final int binarySearch(float[] fArr, float f2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$binarySearch");
        return Arrays.binarySearch(fArr, i2, i3, f2);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        return binarySearch(fArr, f2, i2, i3);
    }

    public static final double[] copyInto(double[] dArr, double[] dArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(dArr2, "destination");
        System.arraycopy(dArr, i3, dArr2, i2, i4 - i3);
        return dArr2;
    }

    public static /* synthetic */ double[] copyInto$default(double[] dArr, double[] dArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = dArr.length;
        }
        return copyInto(dArr, dArr2, i2, i3, i4);
    }

    public static final int[] copyOfRange(int[] iArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, iArr.length);
        int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return iArrCopyOfRange;
    }

    public static final void fill(double[] dArr, double d2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$fill");
        Arrays.fill(dArr, i2, i3, d2);
    }

    public static /* synthetic */ void fill$default(double[] dArr, double d2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        fill(dArr, d2, i2, i3);
    }

    public static final void sort(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sort");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    public static /* synthetic */ void sort$default(double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = dArr.length;
        }
        sort(dArr, i2, i3);
    }

    public static final SortedSet<Double> toSortedSet(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(dArr, new TreeSet());
    }

    public static final Integer[] toTypedArray(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toTypedArray");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    public static final List<Boolean> asList(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$asList");
        return new g(zArr);
    }

    public static final int binarySearch(double[] dArr, double d2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$binarySearch");
        return Arrays.binarySearch(dArr, i2, i3, d2);
    }

    public static /* synthetic */ int binarySearch$default(double[] dArr, double d2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        return binarySearch(dArr, d2, i2, i3);
    }

    public static final boolean[] copyInto(boolean[] zArr, boolean[] zArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(zArr2, "destination");
        System.arraycopy(zArr, i3, zArr2, i2, i4 - i3);
        return zArr2;
    }

    public static /* synthetic */ boolean[] copyInto$default(boolean[] zArr, boolean[] zArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = zArr.length;
        }
        return copyInto(zArr, zArr2, i2, i3, i4);
    }

    public static final void fill(boolean[] zArr, boolean z, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$fill");
        Arrays.fill(zArr, i2, i3, z);
    }

    public static /* synthetic */ void fill$default(boolean[] zArr, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = zArr.length;
        }
        fill(zArr, z, i2, i3);
    }

    public static final <T> void sort(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sort");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static /* synthetic */ void sort$default(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        sort(cArr, i2, i3);
    }

    public static final SortedSet<Boolean> toSortedSet(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(zArr, new TreeSet());
    }

    public static final List<Character> asList(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$asList");
        return new h(cArr);
    }

    public static final int binarySearch(char[] cArr, char c2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$binarySearch");
        return Arrays.binarySearch(cArr, i2, i3, c2);
    }

    public static /* synthetic */ int binarySearch$default(char[] cArr, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        return binarySearch(cArr, c2, i2, i3);
    }

    public static final char[] copyInto(char[] cArr, char[] cArr2, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$copyInto");
        d.k0.d.t.checkNotNullParameter(cArr2, "destination");
        System.arraycopy(cArr, i3, cArr2, i2, i4 - i3);
        return cArr2;
    }

    public static /* synthetic */ char[] copyInto$default(char[] cArr, char[] cArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = cArr.length;
        }
        return copyInto(cArr, cArr2, i2, i3, i4);
    }

    public static final long[] copyOfRange(long[] jArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, jArr.length);
        long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return jArrCopyOfRange;
    }

    public static final void fill(char[] cArr, char c2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$fill");
        Arrays.fill(cArr, i2, i3, c2);
    }

    public static /* synthetic */ void fill$default(char[] cArr, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        fill(cArr, c2, i2, i3);
    }

    public static final short[] plus(short[] sArr, short s) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$plus");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + 1);
        sArrCopyOf[length] = s;
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "result");
        return sArrCopyOf;
    }

    public static final <T extends Comparable<? super T>> void sort(T[] tArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sort");
        Arrays.sort(tArr, i2, i3);
    }

    public static /* synthetic */ void sort$default(Object[] objArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = objArr.length;
        }
        sort(objArr, i2, i3);
    }

    public static final SortedSet<Character> toSortedSet(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$toSortedSet");
        return (SortedSet) m.toCollection(cArr, new TreeSet());
    }

    public static final void sort(byte[] bArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sort");
        Arrays.sort(bArr, i2, i3);
    }

    public static final <T> SortedSet<T> toSortedSet(T[] tArr, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$toSortedSet");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) m.toCollection(tArr, new TreeSet(comparator));
    }

    public static final Long[] toTypedArray(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toTypedArray");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    public static final float[] copyOfRange(float[] fArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(fArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return fArrCopyOfRange;
    }

    public static final void sort(short[] sArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sort");
        Arrays.sort(sArr, i2, i3);
    }

    public static final void sort(int[] iArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sort");
        Arrays.sort(iArr, i2, i3);
    }

    public static final double[] copyOfRange(double[] dArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, dArr.length);
        double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(dArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return dArrCopyOfRange;
    }

    public static final int[] plus(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$plus");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i2;
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "result");
        return iArrCopyOf;
    }

    public static final void sort(long[] jArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sort");
        Arrays.sort(jArr, i2, i3);
    }

    public static final Float[] toTypedArray(float[] fArr) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$toTypedArray");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    public static final void sort(float[] fArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$sort");
        Arrays.sort(fArr, i2, i3);
    }

    public static final boolean[] copyOfRange(boolean[] zArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, zArr.length);
        boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(zArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return zArrCopyOfRange;
    }

    public static final void sort(double[] dArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$sort");
        Arrays.sort(dArr, i2, i3);
    }

    public static final void sort(char[] cArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$sort");
        Arrays.sort(cArr, i2, i3);
    }

    public static final Double[] toTypedArray(double[] dArr) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$toTypedArray");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    public static final char[] copyOfRange(char[] cArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$copyOfRangeImpl");
        j.copyOfRangeToIndexCheck(i3, cArr.length);
        char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i2, i3);
        d.k0.d.t.checkNotNullExpressionValue(cArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return cArrCopyOfRange;
    }

    public static final long[] plus(long[] jArr, long j) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$plus");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + 1);
        jArrCopyOf[length] = j;
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "result");
        return jArrCopyOf;
    }

    public static final <T> void sort(T[] tArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$sort");
        Arrays.sort(tArr, i2, i3);
    }

    public static final Boolean[] toTypedArray(boolean[] zArr) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$toTypedArray");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
        }
        return boolArr;
    }

    public static final float[] plus(float[] fArr, float f2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$plus");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + 1);
        fArrCopyOf[length] = f2;
        d.k0.d.t.checkNotNullExpressionValue(fArrCopyOf, "result");
        return fArrCopyOf;
    }

    public static final Character[] toTypedArray(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$toTypedArray");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            chArr[i2] = Character.valueOf(cArr[i2]);
        }
        return chArr;
    }

    public static final double[] plus(double[] dArr, double d2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$plus");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + 1);
        dArrCopyOf[length] = d2;
        d.k0.d.t.checkNotNullExpressionValue(dArrCopyOf, "result");
        return dArrCopyOf;
    }

    public static final boolean[] plus(boolean[] zArr, boolean z) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$plus");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + 1);
        zArrCopyOf[length] = z;
        d.k0.d.t.checkNotNullExpressionValue(zArrCopyOf, "result");
        return zArrCopyOf;
    }

    public static final char[] plus(char[] cArr, char c2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$plus");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + 1);
        cArrCopyOf[length] = c2;
        d.k0.d.t.checkNotNullExpressionValue(cArrCopyOf, "result");
        return cArrCopyOf;
    }

    public static final <T> T[] plus(T[] tArr, Collection<? extends T> collection) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, collection.size() + length);
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(tArr2, "result");
        return tArr2;
    }

    public static final byte[] plus(byte[] bArr, Collection<Byte> collection) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, collection.size() + length);
        Iterator<Byte> it = collection.iterator();
        while (it.hasNext()) {
            bArrCopyOf[length] = it.next().byteValue();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "result");
        return bArrCopyOf;
    }

    public static final short[] plus(short[] sArr, Collection<Short> collection) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, collection.size() + length);
        Iterator<Short> it = collection.iterator();
        while (it.hasNext()) {
            sArrCopyOf[length] = it.next().shortValue();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "result");
        return sArrCopyOf;
    }

    public static final int[] plus(int[] iArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, collection.size() + length);
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            iArrCopyOf[length] = it.next().intValue();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "result");
        return iArrCopyOf;
    }

    public static final long[] plus(long[] jArr, Collection<Long> collection) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, collection.size() + length);
        Iterator<Long> it = collection.iterator();
        while (it.hasNext()) {
            jArrCopyOf[length] = it.next().longValue();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "result");
        return jArrCopyOf;
    }

    public static final float[] plus(float[] fArr, Collection<Float> collection) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, collection.size() + length);
        Iterator<Float> it = collection.iterator();
        while (it.hasNext()) {
            fArrCopyOf[length] = it.next().floatValue();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(fArrCopyOf, "result");
        return fArrCopyOf;
    }

    public static final double[] plus(double[] dArr, Collection<Double> collection) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, collection.size() + length);
        Iterator<Double> it = collection.iterator();
        while (it.hasNext()) {
            dArrCopyOf[length] = it.next().doubleValue();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(dArrCopyOf, "result");
        return dArrCopyOf;
    }

    public static final boolean[] plus(boolean[] zArr, Collection<Boolean> collection) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, collection.size() + length);
        Iterator<Boolean> it = collection.iterator();
        while (it.hasNext()) {
            zArrCopyOf[length] = it.next().booleanValue();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(zArrCopyOf, "result");
        return zArrCopyOf;
    }

    public static final char[] plus(char[] cArr, Collection<Character> collection) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, collection.size() + length);
        Iterator<Character> it = collection.iterator();
        while (it.hasNext()) {
            cArrCopyOf[length] = it.next().charValue();
            length++;
        }
        d.k0.d.t.checkNotNullExpressionValue(cArrCopyOf, "result");
        return cArrCopyOf;
    }

    public static final <T> T[] plus(T[] tArr, T[] tArr2) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(tArr2, "elements");
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(tArr3, "result");
        return tArr3;
    }

    public static final byte[] plus(byte[] bArr, byte[] bArr2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "result");
        return bArrCopyOf;
    }

    public static final short[] plus(short[] sArr, short[] sArr2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(sArr2, "elements");
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, sArrCopyOf, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "result");
        return sArrCopyOf;
    }

    public static final int[] plus(int[] iArr, int[] iArr2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(iArr2, "elements");
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, iArrCopyOf, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "result");
        return iArrCopyOf;
    }

    public static final long[] plus(long[] jArr, long[] jArr2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(jArr2, "elements");
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, jArrCopyOf, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "result");
        return jArrCopyOf;
    }

    public static final float[] plus(float[] fArr, float[] fArr2) {
        d.k0.d.t.checkNotNullParameter(fArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(fArr2, "elements");
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, fArrCopyOf, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(fArrCopyOf, "result");
        return fArrCopyOf;
    }

    public static final double[] plus(double[] dArr, double[] dArr2) {
        d.k0.d.t.checkNotNullParameter(dArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(dArr2, "elements");
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, dArrCopyOf, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(dArrCopyOf, "result");
        return dArrCopyOf;
    }

    public static final boolean[] plus(boolean[] zArr, boolean[] zArr2) {
        d.k0.d.t.checkNotNullParameter(zArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(zArr2, "elements");
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, zArrCopyOf, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(zArrCopyOf, "result");
        return zArrCopyOf;
    }

    public static final char[] plus(char[] cArr, char[] cArr2) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(cArr2, "elements");
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, cArrCopyOf, length, length2);
        d.k0.d.t.checkNotNullExpressionValue(cArrCopyOf, "result");
        return cArrCopyOf;
    }
}
