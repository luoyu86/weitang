package d.g0.j1;

import d.a0;
import d.b0;
import d.f0;
import d.g0.m;
import d.t;
import d.u;
import d.v;
import d.w;
import d.x;
import d.y;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d.g0.j1.a$a, reason: collision with other inner class name */
    public static final class C0234a extends d.g0.d<v> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f12498b;

        public C0234a(int[] iArr) {
            this.f12498b = iArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof v) {
                return m154containsWZ4Q5Ns(((v) obj).m429unboximpl());
            }
            return false;
        }

        /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
        public boolean m154containsWZ4Q5Ns(int i2) {
            return w.m433containsWZ4Q5Ns(this.f12498b, i2);
        }

        @Override // d.g0.d, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i2) {
            return v.m423boximpl(m155getpVg5ArA(i2));
        }

        /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
        public int m155getpVg5ArA(int i2) {
            return w.m437getpVg5ArA(this.f12498b, i2);
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return w.m438getSizeimpl(this.f12498b);
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof v) {
                return m156indexOfWZ4Q5Ns(((v) obj).m429unboximpl());
            }
            return -1;
        }

        /* JADX INFO: renamed from: indexOf-WZ4Q5Ns, reason: not valid java name */
        public int m156indexOfWZ4Q5Ns(int i2) {
            return m.indexOf(this.f12498b, i2);
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return w.m440isEmptyimpl(this.f12498b);
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof v) {
                return m157lastIndexOfWZ4Q5Ns(((v) obj).m429unboximpl());
            }
            return -1;
        }

        /* JADX INFO: renamed from: lastIndexOf-WZ4Q5Ns, reason: not valid java name */
        public int m157lastIndexOfWZ4Q5Ns(int i2) {
            return m.lastIndexOf(this.f12498b, i2);
        }
    }

    public static final class b extends d.g0.d<x> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f12499b;

        public b(long[] jArr) {
            this.f12499b = jArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof x) {
                return m158containsVKZWuLQ(((x) obj).m453unboximpl());
            }
            return false;
        }

        /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
        public boolean m158containsVKZWuLQ(long j) {
            return y.m457containsVKZWuLQ(this.f12499b, j);
        }

        @Override // d.g0.d, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i2) {
            return x.m447boximpl(m159getsVKNKU(i2));
        }

        /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
        public long m159getsVKNKU(int i2) {
            return y.m461getsVKNKU(this.f12499b, i2);
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return y.m462getSizeimpl(this.f12499b);
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof x) {
                return m160indexOfVKZWuLQ(((x) obj).m453unboximpl());
            }
            return -1;
        }

        /* JADX INFO: renamed from: indexOf-VKZWuLQ, reason: not valid java name */
        public int m160indexOfVKZWuLQ(long j) {
            return m.indexOf(this.f12499b, j);
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return y.m464isEmptyimpl(this.f12499b);
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof x) {
                return m161lastIndexOfVKZWuLQ(((x) obj).m453unboximpl());
            }
            return -1;
        }

        /* JADX INFO: renamed from: lastIndexOf-VKZWuLQ, reason: not valid java name */
        public int m161lastIndexOfVKZWuLQ(long j) {
            return m.lastIndexOf(this.f12499b, j);
        }
    }

    public static final class c extends d.g0.d<t> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f12500b;

        public c(byte[] bArr) {
            this.f12500b = bArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof t) {
                return m162contains7apg3OU(((t) obj).m405unboximpl());
            }
            return false;
        }

        /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
        public boolean m162contains7apg3OU(byte b2) {
            return u.m409contains7apg3OU(this.f12500b, b2);
        }

        @Override // d.g0.d, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i2) {
            return t.m399boximpl(m163getw2LRezQ(i2));
        }

        /* JADX INFO: renamed from: get-w2LRezQ, reason: not valid java name */
        public byte m163getw2LRezQ(int i2) {
            return u.m413getw2LRezQ(this.f12500b, i2);
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return u.m414getSizeimpl(this.f12500b);
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof t) {
                return m164indexOf7apg3OU(((t) obj).m405unboximpl());
            }
            return -1;
        }

        /* JADX INFO: renamed from: indexOf-7apg3OU, reason: not valid java name */
        public int m164indexOf7apg3OU(byte b2) {
            return m.indexOf(this.f12500b, b2);
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return u.m416isEmptyimpl(this.f12500b);
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof t) {
                return m165lastIndexOf7apg3OU(((t) obj).m405unboximpl());
            }
            return -1;
        }

        /* JADX INFO: renamed from: lastIndexOf-7apg3OU, reason: not valid java name */
        public int m165lastIndexOf7apg3OU(byte b2) {
            return m.lastIndexOf(this.f12500b, b2);
        }
    }

    public static final class d extends d.g0.d<a0> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ short[] f12501b;

        public d(short[] sArr) {
            this.f12501b = sArr;
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof a0) {
                return m166containsxj2QHRw(((a0) obj).m100unboximpl());
            }
            return false;
        }

        /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
        public boolean m166containsxj2QHRw(short s) {
            return b0.m104containsxj2QHRw(this.f12501b, s);
        }

        @Override // d.g0.d, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i2) {
            return a0.m94boximpl(m167getMh2AYeg(i2));
        }

        /* JADX INFO: renamed from: get-Mh2AYeg, reason: not valid java name */
        public short m167getMh2AYeg(int i2) {
            return b0.m108getMh2AYeg(this.f12501b, i2);
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return b0.m109getSizeimpl(this.f12501b);
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof a0) {
                return m168indexOfxj2QHRw(((a0) obj).m100unboximpl());
            }
            return -1;
        }

        /* JADX INFO: renamed from: indexOf-xj2QHRw, reason: not valid java name */
        public int m168indexOfxj2QHRw(short s) {
            return m.indexOf(this.f12501b, s);
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return b0.m111isEmptyimpl(this.f12501b);
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof a0) {
                return m169lastIndexOfxj2QHRw(((a0) obj).m100unboximpl());
            }
            return -1;
        }

        /* JADX INFO: renamed from: lastIndexOf-xj2QHRw, reason: not valid java name */
        public int m169lastIndexOfxj2QHRw(short s) {
            return m.lastIndexOf(this.f12501b, s);
        }
    }

    /* JADX INFO: renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<v> m142asListajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$asList");
        return new C0234a(iArr);
    }

    /* JADX INFO: renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<t> m143asListGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$asList");
        return new c(bArr);
    }

    /* JADX INFO: renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<x> m144asListQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$asList");
        return new b(jArr);
    }

    /* JADX INFO: renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<a0> m145asListrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$asList");
        return new d(sArr);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m146binarySearch2fe2U9s(int[] iArr, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$binarySearch");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i3, i4, w.m438getSizeimpl(iArr));
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int iUintCompare = f0.uintCompare(iArr[i6], i2);
            if (iUintCompare < 0) {
                i3 = i6 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ int m147binarySearch2fe2U9s$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = w.m438getSizeimpl(iArr);
        }
        return m146binarySearch2fe2U9s(iArr, i2, i3, i4);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m148binarySearchEtDCXyQ(short[] sArr, short s, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$binarySearch");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, b0.m109getSizeimpl(sArr));
        int i4 = s & 65535;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int iUintCompare = f0.uintCompare(sArr[i6], i4);
            if (iUintCompare < 0) {
                i2 = i6 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ int m149binarySearchEtDCXyQ$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = b0.m109getSizeimpl(sArr);
        }
        return m148binarySearchEtDCXyQ(sArr, s, i2, i3);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m150binarySearchK6DWlUc(long[] jArr, long j, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$binarySearch");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, y.m462getSizeimpl(jArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iUlongCompare = f0.ulongCompare(jArr[i5], j);
            if (iUlongCompare < 0) {
                i2 = i5 + 1;
            } else {
                if (iUlongCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ int m151binarySearchK6DWlUc$default(long[] jArr, long j, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = y.m462getSizeimpl(jArr);
        }
        return m150binarySearchK6DWlUc(jArr, j, i2, i3);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m152binarySearchWpHrYlw(byte[] bArr, byte b2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$binarySearch");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, u.m414getSizeimpl(bArr));
        int i4 = b2 & 255;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int iUintCompare = f0.uintCompare(bArr[i6], i4);
            if (iUintCompare < 0) {
                i2 = i6 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ int m153binarySearchWpHrYlw$default(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = u.m414getSizeimpl(bArr);
        }
        return m152binarySearchWpHrYlw(bArr, b2, i2, i3);
    }
}
