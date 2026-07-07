package d.p0;

import d.d0;
import d.g0.b1;
import d.g0.h0;
import d.g0.i0;
import d.g0.j0;
import d.g0.q0;
import d.g0.y0;
import d.g0.z0;
import java.io.IOException;
import java.util.ArrayList;
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
public class a0 extends z {

    public static final class a implements Iterable<Character>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12884a;

        public a(CharSequence charSequence) {
            this.f12884a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<Character> iterator() {
            return y.iterator(this.f12884a);
        }
    }

    public static final class b implements d.o0.m<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12885a;

        public b(CharSequence charSequence) {
            this.f12885a = charSequence;
        }

        @Override // d.o0.m
        public Iterator<Character> iterator() {
            return y.iterator(this.f12885a);
        }
    }

    public static final class c extends d.k0.d.u implements d.k0.c.l<CharSequence, String> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // d.k0.c.l
        public final String invoke(CharSequence charSequence) {
            d.k0.d.t.checkNotNullParameter(charSequence, "it");
            return charSequence.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K] */
    public static final class d<K> implements h0<Character, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.l f12887b;

        public d(CharSequence charSequence, d.k0.c.l lVar) {
            this.f12886a = charSequence;
            this.f12887b = lVar;
        }

        @Override // d.g0.h0
        public /* bridge */ /* synthetic */ Object keyOf(Character ch) {
            return keyOf(ch.charValue());
        }

        @Override // d.g0.h0
        public Iterator<Character> sourceIterator() {
            return y.iterator(this.f12886a);
        }

        public K keyOf(char c2) {
            return (K) this.f12887b.invoke(Character.valueOf(c2));
        }
    }

    public static final class e extends d.k0.d.u implements d.k0.c.l<CharSequence, String> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // d.k0.c.l
        public final String invoke(CharSequence charSequence) {
            d.k0.d.t.checkNotNullParameter(charSequence, "it");
            return charSequence.toString();
        }
    }

    public static final class f extends d.k0.d.u implements d.k0.c.l<CharSequence, String> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // d.k0.c.l
        public final String invoke(CharSequence charSequence) {
            d.k0.d.t.checkNotNullParameter(charSequence, "it");
            return charSequence.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class g<R> extends d.k0.d.u implements d.k0.c.l<Integer, R> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.l f12890d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(CharSequence charSequence, int i2, d.k0.c.l lVar) {
            super(1);
            this.f12888b = charSequence;
            this.f12889c = i2;
            this.f12890d = lVar;
        }

        public final R invoke(int i2) {
            int length = this.f12889c + i2;
            if (length < 0 || length > this.f12888b.length()) {
                length = this.f12888b.length();
            }
            return (R) this.f12890d.invoke(this.f12888b.subSequence(i2, length));
        }

        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    public static final class h extends d.k0.d.u implements d.k0.c.a<Iterator<? extends Character>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12891b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(CharSequence charSequence) {
            super(0);
            this.f12891b = charSequence;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends Character> invoke() {
            return y.iterator(this.f12891b);
        }
    }

    public static final boolean all(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$any");
        return !(charSequence.length() == 0);
    }

    public static final Iterable<Character> asIterable(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$asIterable");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return d.g0.s.emptyList();
            }
        }
        return new a(charSequence);
    }

    public static final d.o0.m<Character> asSequence(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$asSequence");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return d.o0.r.emptySequence();
            }
        }
        return new b(charSequence);
    }

    public static final <K, V> Map<K, V> associate(CharSequence charSequence, d.k0.c.l<? super Character, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(charSequence.length()), 16));
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Character> associateBy(CharSequence charSequence, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(charSequence.length()), 16));
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            linkedHashMap.put(lVar.invoke(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(CharSequence charSequence, M m, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            m.put(lVar.invoke(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(CharSequence charSequence, M m, d.k0.c.l<? super Character, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final <V> Map<Character, V> associateWith(CharSequence charSequence, d.k0.c.l<? super Character, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$associateWith");
        d.k0.d.t.checkNotNullParameter(lVar, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(d.m0.p.coerceAtMost(charSequence.length(), 128)), 16));
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            linkedHashMap.put(Character.valueOf(cCharAt), lVar.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    public static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(CharSequence charSequence, M m, d.k0.c.l<? super Character, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$associateWithTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "valueSelector");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            m.put(Character.valueOf(cCharAt), lVar.invoke(Character.valueOf(cCharAt)));
        }
        return m;
    }

    public static final List<String> chunked(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$chunked");
        return windowed(charSequence, i2, i2, true);
    }

    public static final d.o0.m<String> chunkedSequence(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$chunkedSequence");
        return chunkedSequence(charSequence, i2, c.INSTANCE);
    }

    public static final int count(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(i3))).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final CharSequence drop(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$drop");
        if (i2 >= 0) {
            return charSequence.subSequence(d.m0.p.coerceAtMost(i2, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final CharSequence dropLast(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$dropLast");
        if (i2 >= 0) {
            return take(charSequence, d.m0.p.coerceAtLeast(charSequence.length() - i2, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final CharSequence dropLastWhile(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = y.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(lastIndex))).booleanValue()) {
                return charSequence.subSequence(0, lastIndex + 1);
            }
        }
        return "";
    }

    public static final CharSequence dropWhile(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    public static final CharSequence filter(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    public static final CharSequence filterIndexed(CharSequence charSequence, d.k0.c.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i2);
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
            i2++;
            i3 = i4;
        }
        return sb;
    }

    public static final <C extends Appendable> C filterIndexedTo(CharSequence charSequence, C c2, d.k0.c.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i2);
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Character.valueOf(cCharAt)).booleanValue()) {
                c2.append(cCharAt);
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final CharSequence filterNot(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    public static final <C extends Appendable> C filterNotTo(CharSequence charSequence, C c2, d.k0.c.l<? super Character, Boolean> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                c2.append(cCharAt);
            }
        }
        return c2;
    }

    public static final <C extends Appendable> C filterTo(CharSequence charSequence, C c2, d.k0.c.l<? super Character, Boolean> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                c2.append(cCharAt);
            }
        }
        return c2;
    }

    public static final char first(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$first");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static final Character firstOrNull(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$firstOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    public static final <R> List<R> flatMap(CharSequence charSequence, d.k0.c.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            d.g0.x.addAll(arrayList, lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(CharSequence charSequence, C c2, d.k0.c.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            d.g0.x.addAll(c2, lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return c2;
    }

    public static final <R> R fold(CharSequence charSequence, R r, d.k0.c.p<? super R, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            r = pVar.invoke(r, Character.valueOf(charSequence.charAt(i2)));
        }
        return r;
    }

    public static final <R> R foldIndexed(CharSequence charSequence, R r, d.k0.c.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char cCharAt = charSequence.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r = qVar.invoke(numValueOf, r, Character.valueOf(cCharAt));
        }
        return r;
    }

    public static final <R> R foldRight(CharSequence charSequence, R r, d.k0.c.p<? super Character, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        for (int lastIndex = y.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r = pVar.invoke(Character.valueOf(charSequence.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(CharSequence charSequence, R r, d.k0.c.q<? super Integer, ? super Character, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        for (int lastIndex = y.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r = qVar.invoke(Integer.valueOf(lastIndex), Character.valueOf(charSequence.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final void forEach(CharSequence charSequence, d.k0.c.l<? super Character, d0> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
        }
    }

    public static final void forEachIndexed(CharSequence charSequence, d.k0.c.p<? super Integer, ? super Character, d0> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char cCharAt = charSequence.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Character.valueOf(cCharAt));
        }
    }

    public static final Character getOrNull(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$getOrNull");
        if (i2 < 0 || i2 > y.getLastIndex(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i2));
    }

    public static final <K> Map<K, List<Character>> groupBy(CharSequence charSequence, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(CharSequence charSequence, M m, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(cCharAt));
        }
        return m;
    }

    public static final <K> h0<Character, K> groupingBy(CharSequence charSequence, d.k0.c.l<? super Character, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$groupingBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        return new d(charSequence, lVar);
    }

    public static final int indexOfFirst(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final char last(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$last");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(y.getLastIndex(charSequence));
    }

    public static final Character lastOrNull(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lastOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static final <R> List<R> map(CharSequence charSequence, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            arrayList.add(lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(CharSequence charSequence, d.k0.c.p<? super Integer, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char cCharAt = charSequence.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Character.valueOf(cCharAt)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexedNotNull(CharSequence charSequence, d.k0.c.p<? super Integer, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$mapIndexedNotNull");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            int i4 = i3 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i3), Character.valueOf(charSequence.charAt(i2)));
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(CharSequence charSequence, C c2, d.k0.c.p<? super Integer, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$mapIndexedNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            int i4 = i3 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i3), Character.valueOf(charSequence.charAt(i2)));
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(CharSequence charSequence, C c2, d.k0.c.p<? super Integer, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char cCharAt = charSequence.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Character.valueOf(cCharAt)));
        }
        return c2;
    }

    public static final <R> List<R> mapNotNull(CharSequence charSequence, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$mapNotNull");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapNotNullTo(CharSequence charSequence, C c2, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$mapNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
        }
        return c2;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(CharSequence charSequence, C c2, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            c2.add(lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return c2;
    }

    public static final Character max(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$max");
        return maxOrNull(charSequence);
    }

    public static final <R extends Comparable<? super R>> Character maxBy(CharSequence charSequence, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    cCharAt = cCharAt2;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final <R extends Comparable<? super R>> Character maxByOrNull(CharSequence charSequence, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    cCharAt = cCharAt2;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character maxOrNull(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$maxOrNull");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                if (d.k0.d.t.compare((int) cCharAt, (int) cCharAt2) < 0) {
                    cCharAt = cCharAt2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character maxWith(CharSequence charSequence, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(charSequence, comparator);
    }

    public static final Character maxWithOrNull(CharSequence charSequence, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                    cCharAt = cCharAt2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character min(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$min");
        return minOrNull(charSequence);
    }

    public static final <R extends Comparable<? super R>> Character minBy(CharSequence charSequence, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    cCharAt = cCharAt2;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final <R extends Comparable<? super R>> Character minByOrNull(CharSequence charSequence, d.k0.c.l<? super Character, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    cCharAt = cCharAt2;
                    rInvoke = rInvoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character minOrNull(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$minOrNull");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                if (d.k0.d.t.compare((int) cCharAt, (int) cCharAt2) > 0) {
                    cCharAt = cCharAt2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character minWith(CharSequence charSequence, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(charSequence, comparator);
    }

    public static final Character minWithOrNull(CharSequence charSequence, Comparator<? super Character> comparator) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                    cCharAt = cCharAt2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final boolean none(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$none");
        return charSequence.length() == 0;
    }

    public static final <S extends CharSequence> S onEach(S s, d.k0.c.l<? super Character, d0> lVar) {
        d.k0.d.t.checkNotNullParameter(s, "$this$onEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        for (int i2 = 0; i2 < s.length(); i2++) {
            lVar.invoke(Character.valueOf(s.charAt(i2)));
        }
        return s;
    }

    public static final <S extends CharSequence> S onEachIndexed(S s, d.k0.c.p<? super Integer, ? super Character, d0> pVar) {
        d.k0.d.t.checkNotNullParameter(s, "$this$onEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (int i3 = 0; i3 < s.length(); i3++) {
            char cCharAt = s.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Character.valueOf(cCharAt));
        }
        return s;
    }

    public static final d.m<CharSequence, CharSequence> partition(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        return new d.m<>(sb, sb2);
    }

    public static final char random(CharSequence charSequence, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(fVar.nextInt(charSequence.length()));
    }

    public static final Character randomOrNull(CharSequence charSequence, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(fVar.nextInt(charSequence.length())));
    }

    public static final char reduce(CharSequence charSequence, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return cCharAt;
    }

    public static final char reduceIndexed(CharSequence charSequence, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return cCharAt;
    }

    public static final Character reduceIndexedOrNull(CharSequence charSequence, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character reduceOrNull(CharSequence charSequence, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = y.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final char reduceRight(CharSequence charSequence, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = y.getLastIndex(charSequence);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(lastIndex);
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            cCharAt = pVar.invoke(Character.valueOf(charSequence.charAt(i2)), Character.valueOf(cCharAt)).charValue();
        }
        return cCharAt;
    }

    public static final char reduceRightIndexed(CharSequence charSequence, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = y.getLastIndex(charSequence);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(lastIndex);
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i2)), Character.valueOf(cCharAt)).charValue();
        }
        return cCharAt;
    }

    public static final Character reduceRightIndexedOrNull(CharSequence charSequence, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int lastIndex = y.getLastIndex(charSequence);
        if (lastIndex < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(lastIndex);
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i2)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character reduceRightOrNull(CharSequence charSequence, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int lastIndex = y.getLastIndex(charSequence);
        if (lastIndex < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(lastIndex);
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            cCharAt = pVar.invoke(Character.valueOf(charSequence.charAt(i2)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    public static final CharSequence reversed(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$reversed");
        StringBuilder sbReverse = new StringBuilder(charSequence).reverse();
        d.k0.d.t.checkNotNullExpressionValue(sbReverse, "StringBuilder(this).reverse()");
        return sbReverse;
    }

    public static final <R> List<R> runningFold(CharSequence charSequence, R r, d.k0.c.p<? super R, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$runningFold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (charSequence.length() == 0) {
            return d.g0.r.listOf(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            r = pVar.invoke(r, Character.valueOf(charSequence.charAt(i2)));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <R> List<R> runningFoldIndexed(CharSequence charSequence, R r, d.k0.c.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$runningFoldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (charSequence.length() == 0) {
            return d.g0.r.listOf(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            r = qVar.invoke(Integer.valueOf(i2), r, Character.valueOf(charSequence.charAt(i2)));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final List<Character> runningReduce(CharSequence charSequence, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$runningReduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (charSequence.length() == 0) {
            return d.g0.s.emptyList();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i2 = 1; i2 < length; i2++) {
            cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    public static final List<Character> runningReduceIndexed(CharSequence charSequence, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$runningReduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (charSequence.length() == 0) {
            return d.g0.s.emptyList();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i2 = 1; i2 < length; i2++) {
            cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    public static final <R> List<R> scan(CharSequence charSequence, R r, d.k0.c.p<? super R, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$scan");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (charSequence.length() == 0) {
            return d.g0.r.listOf(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            r = pVar.invoke(r, Character.valueOf(charSequence.charAt(i2)));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <R> List<R> scanIndexed(CharSequence charSequence, R r, d.k0.c.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$scanIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (charSequence.length() == 0) {
            return d.g0.r.listOf(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            r = qVar.invoke(Integer.valueOf(i2), r, Character.valueOf(charSequence.charAt(i2)));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final List<Character> scanReduce(CharSequence charSequence, d.k0.c.p<? super Character, ? super Character, Character> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$scanReduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (charSequence.length() == 0) {
            return d.g0.s.emptyList();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i2 = 1; i2 < length; i2++) {
            cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    public static final List<Character> scanReduceIndexed(CharSequence charSequence, d.k0.c.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$scanReduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (charSequence.length() == 0) {
            return d.g0.s.emptyList();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i2 = 1; i2 < length; i2++) {
            cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    public static final char single(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$single");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static final Character singleOrNull(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$singleOrNull");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    public static final CharSequence slice(CharSequence charSequence, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? "" : y.subSequence(charSequence, kVar);
    }

    public static final int sumBy(CharSequence charSequence, d.k0.c.l<? super Character, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        int iIntValue = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            iIntValue += lVar.invoke(Character.valueOf(charSequence.charAt(i2))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(CharSequence charSequence, d.k0.c.l<? super Character, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            dDoubleValue += lVar.invoke(Character.valueOf(charSequence.charAt(i2))).doubleValue();
        }
        return dDoubleValue;
    }

    public static final CharSequence take(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$take");
        if (i2 >= 0) {
            return charSequence.subSequence(0, d.m0.p.coerceAtMost(i2, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final CharSequence takeLast(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$takeLast");
        if (i2 >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - d.m0.p.coerceAtMost(i2, length), length);
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final CharSequence takeLastWhile(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = y.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(lastIndex))).booleanValue()) {
                return charSequence.subSequence(lastIndex + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence takeWhile(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(0, i2);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final <C extends Collection<? super Character>> C toCollection(CharSequence charSequence, C c2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            c2.add(Character.valueOf(charSequence.charAt(i2)));
        }
        return c2;
    }

    public static final HashSet<Character> toHashSet(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$toHashSet");
        return (HashSet) toCollection(charSequence, new HashSet(q0.mapCapacity(d.m0.p.coerceAtMost(charSequence.length(), 128))));
    }

    public static final List<Character> toList(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$toList");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? toMutableList(charSequence) : d.g0.r.listOf(Character.valueOf(charSequence.charAt(0))) : d.g0.s.emptyList();
    }

    public static final List<Character> toMutableList(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$toMutableList");
        return (List) toCollection(charSequence, new ArrayList(charSequence.length()));
    }

    public static final Set<Character> toSet(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$toSet");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? (Set) toCollection(charSequence, new LinkedHashSet(q0.mapCapacity(d.m0.p.coerceAtMost(charSequence.length(), 128)))) : y0.setOf(Character.valueOf(charSequence.charAt(0))) : z0.emptySet();
    }

    public static final List<String> windowed(CharSequence charSequence, int i2, int i3, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$windowed");
        return windowed(charSequence, i2, i3, z, e.INSTANCE);
    }

    public static /* synthetic */ List windowed$default(CharSequence charSequence, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i2, i3, z);
    }

    public static final d.o0.m<String> windowedSequence(CharSequence charSequence, int i2, int i3, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$windowedSequence");
        return windowedSequence(charSequence, i2, i3, z, f.INSTANCE);
    }

    public static /* synthetic */ d.o0.m windowedSequence$default(CharSequence charSequence, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i2, i3, z);
    }

    public static final Iterable<i0<Character>> withIndex(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$withIndex");
        return new j0(new h(charSequence));
    }

    public static final <V> List<V> zip(CharSequence charSequence, CharSequence charSequence2, d.k0.c.p<? super Character, ? super Character, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$zip");
        d.k0.d.t.checkNotNullParameter(charSequence2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Character.valueOf(charSequence.charAt(i2)), Character.valueOf(charSequence2.charAt(i2))));
        }
        return arrayList;
    }

    public static final <R> List<R> zipWithNext(CharSequence charSequence, d.k0.c.p<? super Character, ? super Character, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$zipWithNext");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i2 = 0;
        while (i2 < length) {
            Character chValueOf = Character.valueOf(charSequence.charAt(i2));
            i2++;
            arrayList.add(pVar.invoke(chValueOf, Character.valueOf(charSequence.charAt(i2))));
        }
        return arrayList;
    }

    public static final boolean any(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <R> List<R> chunked(CharSequence charSequence, int i2, d.k0.c.l<? super CharSequence, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$chunked");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return windowed(charSequence, i2, i2, true, lVar);
    }

    public static final <R> d.o0.m<R> chunkedSequence(CharSequence charSequence, int i2, d.k0.c.l<? super CharSequence, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$chunkedSequence");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return windowedSequence(charSequence, i2, i2, true, lVar);
    }

    public static final Character firstOrNull(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    public static final Character lastOrNull(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        char cCharAt;
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            cCharAt = charSequence.charAt(length);
        } while (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue());
        return Character.valueOf(cCharAt);
    }

    public static final boolean none(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Character singleOrNull(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Character chValueOf = null;
        boolean z = false;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                if (z) {
                    return null;
                }
                chValueOf = Character.valueOf(cCharAt);
                z = true;
            }
        }
        if (z) {
            return chValueOf;
        }
        return null;
    }

    public static final <R> List<R> windowed(CharSequence charSequence, int i2, int i3, boolean z, d.k0.c.l<? super CharSequence, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$windowed");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        b1.checkWindowSizeStep(i2, i3);
        int length = charSequence.length();
        int i4 = 0;
        ArrayList arrayList = new ArrayList((length / i3) + (length % i3 == 0 ? 0 : 1));
        while (i4 >= 0 && length > i4) {
            int i5 = i4 + i2;
            if (i5 < 0 || i5 > length) {
                if (!z) {
                    break;
                }
                i5 = length;
            }
            arrayList.add(lVar.invoke(charSequence.subSequence(i4, i5)));
            i4 += i3;
        }
        return arrayList;
    }

    public static /* synthetic */ List windowed$default(CharSequence charSequence, int i2, int i3, boolean z, d.k0.c.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i2, i3, z, lVar);
    }

    public static final <R> d.o0.m<R> windowedSequence(CharSequence charSequence, int i2, int i3, boolean z, d.k0.c.l<? super CharSequence, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$windowedSequence");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        b1.checkWindowSizeStep(i2, i3);
        return d.o0.t.map(d.g0.a0.asSequence(d.m0.p.step(z ? y.getIndices(charSequence) : d.m0.p.until(0, (charSequence.length() - i2) + 1), i3)), new g(charSequence, i2, lVar));
    }

    public static /* synthetic */ d.o0.m windowedSequence$default(CharSequence charSequence, int i2, int i3, boolean z, d.k0.c.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i2, i3, z, lVar);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(CharSequence charSequence, M m, d.k0.c.l<? super Character, ? extends K> lVar, d.k0.c.l<? super Character, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            m.put(lVar.invoke(Character.valueOf(cCharAt)), lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return m;
    }

    public static final String drop(String str, int i2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$drop");
        if (i2 >= 0) {
            String strSubstring = str.substring(d.m0.p.coerceAtMost(i2, str.length()));
            d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final String dropLast(String str, int i2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$dropLast");
        if (i2 >= 0) {
            return take(str, d.m0.p.coerceAtLeast(str.length() - i2, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final String filterNot(String str, d.k0.c.l<? super Character, Boolean> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(str, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "filterNotTo(StringBuilder(), predicate).toString()");
        return string;
    }

    public static final String slice(String str, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(str, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? "" : y.substring(str, kVar);
    }

    public static final String take(String str, int i2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$take");
        if (i2 >= 0) {
            String strSubstring = str.substring(0, d.m0.p.coerceAtMost(i2, str.length()));
            d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final String dropLastWhile(String str, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(str, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = y.getLastIndex(str); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Character.valueOf(str.charAt(lastIndex))).booleanValue()) {
                String strSubstring = str.substring(0, lastIndex + 1);
                d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return "";
    }

    public static final String dropWhile(String str, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(str, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
                String strSubstring = str.substring(i2);
                d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        return "";
    }

    public static final String filterIndexed(String str, d.k0.c.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(str, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
            i2++;
            i3 = i4;
        }
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "filterIndexedTo(StringBu…(), predicate).toString()");
        return string;
    }

    public static final char first(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return cCharAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final char last(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        char cCharAt;
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length >= 0) {
                cCharAt = charSequence.charAt(length);
            } else {
                throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
            }
        } while (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue());
        return cCharAt;
    }

    public static final String takeLast(String str, int i2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$takeLast");
        if (i2 >= 0) {
            int length = str.length();
            String strSubstring = str.substring(length - d.m0.p.coerceAtMost(i2, length));
            d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final List<d.m<Character, Character>> zip(CharSequence charSequence, CharSequence charSequence2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$zip");
        d.k0.d.t.checkNotNullParameter(charSequence2, "other");
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(Character.valueOf(charSequence.charAt(i2)), Character.valueOf(charSequence2.charAt(i2))));
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(CharSequence charSequence, d.k0.c.l<? super Character, ? extends K> lVar, d.k0.c.l<? super Character, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(charSequence.length()), 16));
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            linkedHashMap.put(lVar.invoke(Character.valueOf(cCharAt)), lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    public static final String filter(String str, d.k0.c.l<? super Character, Boolean> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(str, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "filterTo(StringBuilder(), predicate).toString()");
        return string;
    }

    public static final char single(CharSequence charSequence, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Character chValueOf = null;
        boolean z = false;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                if (!z) {
                    chValueOf = Character.valueOf(cCharAt);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(chValueOf, "null cannot be cast to non-null type kotlin.Char");
            return chValueOf.charValue();
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final CharSequence slice(CharSequence charSequence, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(charSequence.charAt(it.next().intValue()));
        }
        return sb;
    }

    public static final String takeLastWhile(String str, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(str, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (int lastIndex = y.getLastIndex(str); lastIndex >= 0; lastIndex--) {
            if (!lVar.invoke(Character.valueOf(str.charAt(lastIndex))).booleanValue()) {
                String strSubstring = str.substring(lastIndex + 1);
                d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        return str;
    }

    public static final String takeWhile(String str, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(str, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
                String strSubstring = str.substring(0, i2);
                d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return str;
    }

    public static final List<d.m<Character, Character>> zipWithNext(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$zipWithNext");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return d.g0.s.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            i2++;
            arrayList.add(d.s.to(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(CharSequence charSequence, M m, d.k0.c.l<? super Character, ? extends K> lVar, d.k0.c.l<? super Character, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return m;
    }

    public static final d.m<String, String> partition(String str, d.k0.c.l<? super Character, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(str, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "first.toString()");
        String string2 = sb2.toString();
        d.k0.d.t.checkNotNullExpressionValue(string2, "second.toString()");
        return new d.m<>(string, string2);
    }

    public static final <K, V> Map<K, List<V>> groupBy(CharSequence charSequence, d.k0.c.l<? super Character, ? extends K> lVar, d.k0.c.l<? super Character, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }
}
