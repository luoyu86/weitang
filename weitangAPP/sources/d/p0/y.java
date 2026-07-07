package d.p0;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.intelligoo.sdk.utils.BleLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class y extends x {

    public static final class a extends d.g0.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12943b;

        public a(CharSequence charSequence) {
            this.f12943b = charSequence;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12942a < this.f12943b.length();
        }

        @Override // d.g0.q
        public char nextChar() {
            CharSequence charSequence = this.f12943b;
            int i2 = this.f12942a;
            this.f12942a = i2 + 1;
            return charSequence.charAt(i2);
        }
    }

    public static final class b extends d.k0.d.u implements d.k0.c.p<CharSequence, Integer, d.m<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ char[] f12944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f12945c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(char[] cArr, boolean z) {
            super(2);
            this.f12944b = cArr;
            this.f12945c = z;
        }

        public final d.m<Integer, Integer> invoke(CharSequence charSequence, int i2) {
            d.k0.d.t.checkNotNullParameter(charSequence, "$receiver");
            int iIndexOfAny = y.indexOfAny(charSequence, this.f12944b, i2, this.f12945c);
            if (iIndexOfAny < 0) {
                return null;
            }
            return d.s.to(Integer.valueOf(iIndexOfAny), 1);
        }

        @Override // d.k0.c.p
        public /* bridge */ /* synthetic */ d.m<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }
    }

    public static final class c extends d.k0.d.u implements d.k0.c.p<CharSequence, Integer, d.m<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f12946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f12947c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list, boolean z) {
            super(2);
            this.f12946b = list;
            this.f12947c = z;
        }

        public final d.m<Integer, Integer> invoke(CharSequence charSequence, int i2) {
            d.k0.d.t.checkNotNullParameter(charSequence, "$receiver");
            d.m mVarC = y.c(charSequence, this.f12946b, i2, this.f12947c, false);
            if (mVarC != null) {
                return d.s.to(mVarC.getFirst(), Integer.valueOf(((String) mVarC.getSecond()).length()));
            }
            return null;
        }

        @Override // d.k0.c.p
        public /* bridge */ /* synthetic */ d.m<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }
    }

    public static final class d extends d.k0.d.u implements d.k0.c.l<d.m0.k, String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12948b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CharSequence charSequence) {
            super(1);
            this.f12948b = charSequence;
        }

        @Override // d.k0.c.l
        public final String invoke(d.m0.k kVar) {
            d.k0.d.t.checkNotNullParameter(kVar, "it");
            return y.substring(this.f12948b, kVar);
        }
    }

    public static final class e extends d.k0.d.u implements d.k0.c.l<d.m0.k, String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12949b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(CharSequence charSequence) {
            super(1);
            this.f12949b = charSequence;
        }

        @Override // d.k0.c.l
        public final String invoke(d.m0.k kVar) {
            d.k0.d.t.checkNotNullParameter(kVar, "it");
            return y.substring(this.f12949b, kVar);
        }
    }

    public static final d.m<Integer, String> c(CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        Object next;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) d.g0.a0.single(collection);
            int iIndexOf$default = !z2 ? indexOf$default(charSequence, str, i2, false, 4, (Object) null) : lastIndexOf$default(charSequence, str, i2, false, 4, (Object) null);
            if (iIndexOf$default < 0) {
                return null;
            }
            return d.s.to(Integer.valueOf(iIndexOf$default), str);
        }
        d.m0.i kVar = !z2 ? new d.m0.k(d.m0.p.coerceAtLeast(i2, 0), charSequence.length()) : d.m0.p.downTo(d.m0.p.coerceAtMost(i2, getLastIndex(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = kVar.getFirst();
            int last = kVar.getLast();
            int step = kVar.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (x.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return d.s.to(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = kVar.getFirst();
            int last2 = kVar.getLast();
            int step2 = kVar.getStep();
            if (step2 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return d.s.to(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static final String commonPrefixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$commonPrefixWith");
        d.k0.d.t.checkNotNullParameter(charSequence2, "other");
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < iMin && d.p0.d.equals(charSequence.charAt(i2), charSequence2.charAt(i2), z)) {
            i2++;
        }
        int i3 = i2 - 1;
        if (hasSurrogatePairAt(charSequence, i3) || hasSurrogatePairAt(charSequence2, i3)) {
            i2--;
        }
        return charSequence.subSequence(0, i2).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$commonSuffixWith");
        d.k0.d.t.checkNotNullParameter(charSequence2, "other");
        int length = charSequence.length();
        int iMin = Math.min(length, charSequence2.length());
        int i2 = 0;
        while (i2 < iMin && d.p0.d.equals(charSequence.charAt((length - i2) - 1), charSequence2.charAt((r1 - i2) - 1), z)) {
            i2++;
        }
        if (hasSurrogatePairAt(charSequence, (length - i2) - 1) || hasSurrogatePairAt(charSequence2, (r1 - i2) - 1)) {
            i2--;
        }
        return charSequence.subSequence(length - i2, length).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$contains");
        d.k0.d.t.checkNotNullParameter(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (e(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final int d(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        d.m0.i kVar = !z2 ? new d.m0.k(d.m0.p.coerceAtLeast(i2, 0), d.m0.p.coerceAtMost(i3, charSequence.length())) : d.m0.p.downTo(d.m0.p.coerceAtMost(i2, getLastIndex(charSequence)), d.m0.p.coerceAtLeast(i3, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = kVar.getFirst();
            int last = kVar.getLast();
            int step = kVar.getStep();
            if (step >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!x.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = kVar.getFirst();
        int last2 = kVar.getLast();
        int step2 = kVar.getStep();
        if (step2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    public static /* synthetic */ int e(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return d(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    public static final boolean endsWith(CharSequence charSequence, char c2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$endsWith");
        return charSequence.length() > 0 && d.p0.d.equals(charSequence.charAt(getLastIndex(charSequence)), c2, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c2, z);
    }

    public static final d.o0.m<d.m0.k> f(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new f(charSequence, i2, i3, new b(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    public static final d.m<Integer, String> findAnyOf(CharSequence charSequence, Collection<String> collection, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$findAnyOf");
        d.k0.d.t.checkNotNullParameter(collection, "strings");
        return c(charSequence, collection, i2, z, false);
    }

    public static /* synthetic */ d.m findAnyOf$default(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return findAnyOf(charSequence, collection, i2, z);
    }

    public static final d.m<Integer, String> findLastAnyOf(CharSequence charSequence, Collection<String> collection, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$findLastAnyOf");
        d.k0.d.t.checkNotNullParameter(collection, "strings");
        return c(charSequence, collection, i2, z, true);
    }

    public static /* synthetic */ d.m findLastAnyOf$default(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return findLastAnyOf(charSequence, collection, i2, z);
    }

    public static final d.o0.m<d.m0.k> g(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new f(charSequence, i2, i3, new c(d.g0.l.asList(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    public static final d.m0.k getIndices(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$indices");
        return new d.m0.k(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ d.o0.m h(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return f(charSequence, cArr, i2, z, i3);
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$hasSurrogatePairAt");
        return i2 >= 0 && charSequence.length() + (-2) >= i2 && Character.isHighSurrogate(charSequence.charAt(i2)) && Character.isLowSurrogate(charSequence.charAt(i2 + 1));
    }

    public static /* synthetic */ d.o0.m i(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return g(charSequence, strArr, i2, z, i3);
    }

    public static final int indexOf(CharSequence charSequence, char c2, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c2}, i2, z) : ((String) charSequence).indexOf(c2, i2);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c2, i2, z);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        boolean z2;
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$indexOfAny");
        d.k0.d.t.checkNotNullParameter(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(d.g0.m.single(cArr), i2);
        }
        int iCoerceAtLeast = d.m0.p.coerceAtLeast(i2, 0);
        int lastIndex = getLastIndex(charSequence);
        if (iCoerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iCoerceAtLeast);
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (d.p0.d.equals(cArr[i3], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return iCoerceAtLeast;
            }
            if (iCoerceAtLeast == lastIndex) {
                return -1;
            }
            iCoerceAtLeast++;
        }
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i2, z);
    }

    public static final d.g0.q iterator(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$iterator");
        return new a(charSequence);
    }

    public static final List<String> j(CharSequence charSequence, String str, boolean z, int i2) {
        int length = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        int iIndexOf = indexOf(charSequence, str, 0, z);
        if (iIndexOf == -1 || i2 == 1) {
            return d.g0.r.listOf(charSequence.toString());
        }
        boolean z2 = i2 > 0;
        ArrayList arrayList = new ArrayList(z2 ? d.m0.p.coerceAtMost(i2, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z2 && arrayList.size() == i2 - 1) {
                break;
            }
            iIndexOf = indexOf(charSequence, str, length, z);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static final int lastIndexOf(CharSequence charSequence, char c2, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        return (z || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c2}, i2, z) : ((String) charSequence).lastIndexOf(c2, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c2, i2, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lastIndexOfAny");
        d.k0.d.t.checkNotNullParameter(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(d.g0.m.single(cArr), i2);
        }
        for (int iCoerceAtMost = d.m0.p.coerceAtMost(i2, getLastIndex(charSequence)); iCoerceAtMost >= 0; iCoerceAtMost--) {
            char cCharAt = charSequence.charAt(iCoerceAtMost);
            int length = cArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (d.p0.d.equals(cArr[i3], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return iCoerceAtMost;
            }
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, cArr, i2, z);
    }

    public static final d.o0.m<String> lineSequence(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lineSequence");
        return splitToSequence$default(charSequence, new String[]{BleLog.LINE_BREAK, "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> lines(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lines");
        return d.o0.t.toList(lineSequence(charSequence));
    }

    public static final CharSequence padEnd(CharSequence charSequence, int i2, char c2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$padEnd");
        if (i2 < 0) {
            throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
        }
        if (i2 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(charSequence);
        int length = i2 - charSequence.length();
        int i3 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c2);
                if (i3 == length) {
                    break;
                }
                i3++;
            }
        }
        return sb;
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return padEnd(charSequence, i2, c2);
    }

    public static final CharSequence padStart(CharSequence charSequence, int i2, char c2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$padStart");
        if (i2 < 0) {
            throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
        }
        if (i2 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i2);
        int length = i2 - charSequence.length();
        int i3 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c2);
                if (i3 == length) {
                    break;
                }
                i3++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return padStart(charSequence, i2, c2);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$regionMatchesImpl");
        d.k0.d.t.checkNotNullParameter(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!d.p0.d.equals(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence charSequence2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$removePrefix");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        return startsWith$default(charSequence, charSequence2, false, 2, (Object) null) ? charSequence.subSequence(charSequence2.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeRange(CharSequence charSequence, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$removeRange");
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
        }
        if (i3 == i2) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i3 - i2));
        sb.append(charSequence, 0, i2);
        d.k0.d.t.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
        sb.append(charSequence, i3, charSequence.length());
        d.k0.d.t.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence charSequence2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$removeSuffix");
        d.k0.d.t.checkNotNullParameter(charSequence2, "suffix");
        return endsWith$default(charSequence, charSequence2, false, 2, (Object) null) ? charSequence.subSequence(0, charSequence.length() - charSequence2.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$removeSurrounding");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "suffix");
        return (charSequence.length() >= charSequence2.length() + charSequence3.length() && startsWith$default(charSequence, charSequence2, false, 2, (Object) null) && endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) ? charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final String replaceAfter(String str, char c2, String str2, String str3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceAfter");
        d.k0.d.t.checkNotNullParameter(str2, "replacement");
        d.k0.d.t.checkNotNullParameter(str3, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str3 : replaceRange(str, iIndexOf$default + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c2, str2, str3);
    }

    public static final String replaceAfterLast(String str, String str2, String str3, String str4) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceAfterLast");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.DELIMITER);
        d.k0.d.t.checkNotNullParameter(str3, "replacement");
        d.k0.d.t.checkNotNullParameter(str4, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str4 : replaceRange(str, iLastIndexOf$default + str2.length(), str.length(), str3).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    public static final String replaceBefore(String str, char c2, String str2, String str3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceBefore");
        d.k0.d.t.checkNotNullParameter(str2, "replacement");
        d.k0.d.t.checkNotNullParameter(str3, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str3 : replaceRange(str, 0, iIndexOf$default, str2).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c2, str2, str3);
    }

    public static final String replaceBeforeLast(String str, char c2, String str2, String str3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceBeforeLast");
        d.k0.d.t.checkNotNullParameter(str2, "replacement");
        d.k0.d.t.checkNotNullParameter(str3, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str3 : replaceRange(str, 0, iLastIndexOf$default, str2).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c2, str2, str3);
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i2, int i3, CharSequence charSequence2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$replaceRange");
        d.k0.d.t.checkNotNullParameter(charSequence2, "replacement");
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i2);
            d.k0.d.t.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i3, charSequence.length());
            d.k0.d.t.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$split");
        d.k0.d.t.checkNotNullParameter(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return j(charSequence, str, z, i2);
            }
        }
        Iterable iterableAsIterable = d.o0.t.asIterable(i(charSequence, strArr, 0, z, i2, 2, null));
        ArrayList arrayList = new ArrayList(d.g0.t.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (d.m0.k) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return split(charSequence, strArr, z, i2);
    }

    public static final d.o0.m<String> splitToSequence(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$splitToSequence");
        d.k0.d.t.checkNotNullParameter(strArr, "delimiters");
        return d.o0.t.map(i(charSequence, strArr, 0, z, i2, 2, null), new d(charSequence));
    }

    public static /* synthetic */ d.o0.m splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return splitToSequence(charSequence, strArr, z, i2);
    }

    public static final boolean startsWith(CharSequence charSequence, char c2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$startsWith");
        return charSequence.length() > 0 && d.p0.d.equals(charSequence.charAt(0), c2, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c2, z);
    }

    public static final CharSequence subSequence(CharSequence charSequence, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$subSequence");
        d.k0.d.t.checkNotNullParameter(kVar, "range");
        return charSequence.subSequence(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final String substring(String str, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substring");
        d.k0.d.t.checkNotNullParameter(kVar, "range");
        String strSubstring = str.substring(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String substringAfter(String str, char c2, String str2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substringAfter");
        d.k0.d.t.checkNotNullParameter(str2, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(iIndexOf$default + 1, str.length());
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c2, str2);
    }

    public static final String substringAfterLast(String str, char c2, String str2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substringAfterLast");
        d.k0.d.t.checkNotNullParameter(str2, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1, str.length());
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c2, str2);
    }

    public static final String substringBefore(String str, char c2, String str2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substringBefore");
        d.k0.d.t.checkNotNullParameter(str2, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c2, str2);
    }

    public static final String substringBeforeLast(String str, char c2, String str2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substringBeforeLast");
        d.k0.d.t.checkNotNullParameter(str2, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c2, str2);
    }

    public static final CharSequence trim(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trim");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zBooleanValue = lVar.invoke(Character.valueOf(charSequence.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trimEnd");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (lVar.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trimStart");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c2, z);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$endsWith");
        d.k0.d.t.checkNotNullParameter(charSequence2, "suffix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? x.endsWith$default((String) charSequence, (String) charSequence2, false, 2, null) : regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i2, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, (Collection<String>) collection, i2, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i2, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, (Collection<String>) collection, i2, z);
    }

    public static /* synthetic */ String padEnd$default(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return padEnd(str, i2, c2);
    }

    public static /* synthetic */ String padStart$default(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return padStart(str, i2, c2);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c2, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return split(charSequence, cArr, z, i2);
    }

    public static final d.o0.m<String> splitToSequence(CharSequence charSequence, char[] cArr, boolean z, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$splitToSequence");
        d.k0.d.t.checkNotNullParameter(cArr, "delimiters");
        return d.o0.t.map(h(charSequence, cArr, 0, z, i2, 2, null), new e(charSequence));
    }

    public static /* synthetic */ d.o0.m splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return splitToSequence(charSequence, cArr, z, i2);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$startsWith");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? x.startsWith$default((String) charSequence, (String) charSequence2, false, 2, null) : regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    public static final String substring(CharSequence charSequence, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$substring");
        d.k0.d.t.checkNotNullParameter(kVar, "range");
        return charSequence.subSequence(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    public static final String replaceAfter(String str, String str2, String str3, String str4) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceAfter");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.DELIMITER);
        d.k0.d.t.checkNotNullParameter(str3, "replacement");
        d.k0.d.t.checkNotNullParameter(str4, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str4 : replaceRange(str, iIndexOf$default + str2.length(), str.length(), str3).toString();
    }

    public static final String replaceAfterLast(String str, char c2, String str2, String str3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceAfterLast");
        d.k0.d.t.checkNotNullParameter(str2, "replacement");
        d.k0.d.t.checkNotNullParameter(str3, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str3 : replaceRange(str, iLastIndexOf$default + 1, str.length(), str2).toString();
    }

    public static final String replaceBefore(String str, String str2, String str3, String str4) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceBefore");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.DELIMITER);
        d.k0.d.t.checkNotNullParameter(str3, "replacement");
        d.k0.d.t.checkNotNullParameter(str4, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str4 : replaceRange(str, 0, iIndexOf$default, str3).toString();
    }

    public static final String replaceBeforeLast(String str, String str2, String str3, String str4) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceBeforeLast");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.DELIMITER);
        d.k0.d.t.checkNotNullParameter(str3, "replacement");
        d.k0.d.t.checkNotNullParameter(str4, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str4 : replaceRange(str, 0, iLastIndexOf$default, str3).toString();
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i2, z);
    }

    public static final String substringAfter(String str, String str2, String str3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substringAfter");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.DELIMITER);
        d.k0.d.t.checkNotNullParameter(str3, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(iIndexOf$default + str2.length(), str.length());
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String substringAfterLast(String str, String str2, String str3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substringAfterLast");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.DELIMITER);
        d.k0.d.t.checkNotNullParameter(str3, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(iLastIndexOf$default + str2.length(), str.length());
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String substringBefore(String str, String str2, String str3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substringBefore");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.DELIMITER);
        d.k0.d.t.checkNotNullParameter(str3, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String substringBeforeLast(String str, String str2, String str3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$substringBeforeLast");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.DELIMITER);
        d.k0.d.t.checkNotNullParameter(str3, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean contains(CharSequence charSequence, char c2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$contains");
        return indexOf$default(charSequence, c2, 0, z, 2, (Object) null) >= 0;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$indexOf");
        d.k0.d.t.checkNotNullParameter(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return e(charSequence, str, i2, charSequence.length(), z, false, 16, null);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        d.k0.d.t.checkNotNullParameter(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i2);
        }
        return d(charSequence, str, i2, 0, z, true);
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(str, "$this$removePrefix");
        d.k0.d.t.checkNotNullParameter(charSequence, RequestParameters.PREFIX);
        if (!startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final String removeSuffix(String str, CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(str, "$this$removeSuffix");
        d.k0.d.t.checkNotNullParameter(charSequence, "suffix");
        if (!endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$removeSurrounding");
        d.k0.d.t.checkNotNullParameter(charSequence, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) || !endsWith$default((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String trim(String str, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(str, "$this$trim");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zBooleanValue = lVar.invoke(Character.valueOf(str.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static final String trimEnd(String str, d.k0.c.l<? super Character, Boolean> lVar) {
        CharSequence charSequenceSubSequence;
        d.k0.d.t.checkNotNullParameter(str, "$this$trimEnd");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequenceSubSequence = "";
                break;
            }
            if (!lVar.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequenceSubSequence.toString();
    }

    public static final String trimStart(String str, d.k0.c.l<? super Character, Boolean> lVar) {
        CharSequence charSequenceSubSequence;
        d.k0.d.t.checkNotNullParameter(str, "$this$trimStart");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!lVar.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(i2, str.length());
                break;
            }
            i2++;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$startsWith");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return x.startsWith$default((String) charSequence, (String) charSequence2, i2, false, 4, null);
        }
        return regionMatchesImpl(charSequence, i2, charSequence2, 0, charSequence2.length(), z);
    }

    public static final CharSequence removeRange(CharSequence charSequence, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$removeRange");
        d.k0.d.t.checkNotNullParameter(kVar, "range");
        return removeRange(charSequence, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$removeSurrounding");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.DELIMITER);
        return removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    public static final CharSequence replaceRange(CharSequence charSequence, d.m0.k kVar, CharSequence charSequence2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$replaceRange");
        d.k0.d.t.checkNotNullParameter(kVar, "range");
        d.k0.d.t.checkNotNullParameter(charSequence2, "replacement");
        return replaceRange(charSequence, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1, charSequence2);
    }

    public static final String removeSurrounding(String str, CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(str, "$this$removeSurrounding");
        d.k0.d.t.checkNotNullParameter(charSequence, RequestParameters.DELIMITER);
        return removeSurrounding(str, charSequence, charSequence);
    }

    public static final int indexOfAny(CharSequence charSequence, Collection<String> collection, int i2, boolean z) {
        Integer first;
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$indexOfAny");
        d.k0.d.t.checkNotNullParameter(collection, "strings");
        d.m<Integer, String> mVarC = c(charSequence, collection, i2, z, false);
        if (mVarC == null || (first = mVarC.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final int lastIndexOfAny(CharSequence charSequence, Collection<String> collection, int i2, boolean z) {
        Integer first;
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lastIndexOfAny");
        d.k0.d.t.checkNotNullParameter(collection, "strings");
        d.m<Integer, String> mVarC = c(charSequence, collection, i2, z, true);
        if (mVarC == null || (first = mVarC.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final String padEnd(String str, int i2, char c2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$padEnd");
        return padEnd((CharSequence) str, i2, c2).toString();
    }

    public static final String padStart(String str, int i2, char c2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$padStart");
        return padStart((CharSequence) str, i2, c2).toString();
    }

    public static final CharSequence trim(CharSequence charSequence, char... cArr) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trim");
        d.k0.d.t.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zContains = d.g0.m.contains(cArr, charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence, char... cArr) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trimEnd");
        d.k0.d.t.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (d.g0.m.contains(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence, char... cArr) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trimStart");
        d.k0.d.t.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!d.g0.m.contains(cArr, charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    public static final List<String> split(CharSequence charSequence, char[] cArr, boolean z, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$split");
        d.k0.d.t.checkNotNullParameter(cArr, "delimiters");
        if (cArr.length == 1) {
            return j(charSequence, String.valueOf(cArr[0]), z, i2);
        }
        Iterable iterableAsIterable = d.o0.t.asIterable(h(charSequence, cArr, 0, z, i2, 2, null));
        ArrayList arrayList = new ArrayList(d.g0.t.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (d.m0.k) it.next()));
        }
        return arrayList;
    }

    public static final String trim(String str, char... cArr) {
        d.k0.d.t.checkNotNullParameter(str, "$this$trim");
        d.k0.d.t.checkNotNullParameter(cArr, "chars");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zContains = d.g0.m.contains(cArr, str.charAt(!z ? i2 : length));
            if (z) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static final String trimEnd(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        d.k0.d.t.checkNotNullParameter(str, "$this$trimEnd");
        d.k0.d.t.checkNotNullParameter(cArr, "chars");
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequenceSubSequence = "";
                break;
            }
            if (!d.g0.m.contains(cArr, str.charAt(length))) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequenceSubSequence.toString();
    }

    public static final String trimStart(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        d.k0.d.t.checkNotNullParameter(str, "$this$trimStart");
        d.k0.d.t.checkNotNullParameter(cArr, "chars");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!d.g0.m.contains(cArr, str.charAt(i2))) {
                charSequenceSubSequence = str.subSequence(i2, str.length());
                break;
            }
            i2++;
        }
        return charSequenceSubSequence.toString();
    }

    public static final CharSequence trim(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zIsWhitespace = d.p0.c.isWhitespace(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trimEnd");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (d.p0.c.isWhitespace(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$trimStart");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!d.p0.c.isWhitespace(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }
}
