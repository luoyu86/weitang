package d.g0.j1;

import d.a0;
import d.b0;
import d.f0;
import d.g0.d1;
import d.g0.i0;
import d.g0.j0;
import d.g0.l;
import d.g0.m;
import d.g0.r;
import d.g0.s;
import d.g0.z;
import d.k0.d.u;
import d.l0.f;
import d.m0.k;
import d.m0.p;
import d.t;
import d.v;
import d.w;
import d.x;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d.g0.j1.a {

    public static final class a extends u implements d.k0.c.a<Iterator<? extends v>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f12502b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int[] iArr) {
            super(0);
            this.f12502b = iArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends v> invoke() {
            return w.m441iteratorimpl(this.f12502b);
        }
    }

    /* JADX INFO: renamed from: d.g0.j1.b$b, reason: collision with other inner class name */
    public static final class C0235b extends u implements d.k0.c.a<Iterator<? extends x>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f12503b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0235b(long[] jArr) {
            super(0);
            this.f12503b = jArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends x> invoke() {
            return y.m465iteratorimpl(this.f12503b);
        }
    }

    public static final class c extends u implements d.k0.c.a<Iterator<? extends t>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f12504b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(byte[] bArr) {
            super(0);
            this.f12504b = bArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends t> invoke() {
            return d.u.m417iteratorimpl(this.f12504b);
        }
    }

    public static final class d extends u implements d.k0.c.a<Iterator<? extends a0>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ short[] f12505b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(short[] sArr) {
            super(0);
            this.f12505b = sArr;
        }

        @Override // d.k0.c.a
        public final Iterator<? extends a0> invoke() {
            return b0.m112iteratorimpl(this.f12505b);
        }
    }

    /* JADX INFO: renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static final boolean m170contentEqualsFGO6Aew(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    /* JADX INFO: renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static final boolean m171contentEqualsKJPZfPQ(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    /* JADX INFO: renamed from: contentEquals-ctEhBpI, reason: not valid java name */
    public static final /* synthetic */ boolean m172contentEqualsctEhBpI(int[] iArr, int[] iArr2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$contentEquals");
        d.k0.d.t.checkNotNullParameter(iArr2, "other");
        return m171contentEqualsKJPZfPQ(iArr, iArr2);
    }

    /* JADX INFO: renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static final boolean m173contentEqualskV0jMPg(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    /* JADX INFO: renamed from: contentEquals-kdPth3s, reason: not valid java name */
    public static final /* synthetic */ boolean m174contentEqualskdPth3s(byte[] bArr, byte[] bArr2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$contentEquals");
        d.k0.d.t.checkNotNullParameter(bArr2, "other");
        return m173contentEqualskV0jMPg(bArr, bArr2);
    }

    /* JADX INFO: renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static final boolean m175contentEqualslec5QzE(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    /* JADX INFO: renamed from: contentEquals-mazbYpA, reason: not valid java name */
    public static final /* synthetic */ boolean m176contentEqualsmazbYpA(short[] sArr, short[] sArr2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$contentEquals");
        d.k0.d.t.checkNotNullParameter(sArr2, "other");
        return m170contentEqualsFGO6Aew(sArr, sArr2);
    }

    /* JADX INFO: renamed from: contentEquals-us8wMrg, reason: not valid java name */
    public static final /* synthetic */ boolean m177contentEqualsus8wMrg(long[] jArr, long[] jArr2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$contentEquals");
        d.k0.d.t.checkNotNullParameter(jArr2, "other");
        return m175contentEqualslec5QzE(jArr, jArr2);
    }

    /* JADX INFO: renamed from: contentHashCode--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ int m178contentHashCodeajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$contentHashCode");
        return m182contentHashCodeXUkPCBk(iArr);
    }

    /* JADX INFO: renamed from: contentHashCode-2csIQuQ, reason: not valid java name */
    public static final int m179contentHashCode2csIQuQ(byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    /* JADX INFO: renamed from: contentHashCode-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ int m180contentHashCodeGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$contentHashCode");
        return m179contentHashCode2csIQuQ(bArr);
    }

    /* JADX INFO: renamed from: contentHashCode-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ int m181contentHashCodeQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$contentHashCode");
        return m185contentHashCodeuLth9ew(jArr);
    }

    /* JADX INFO: renamed from: contentHashCode-XUkPCBk, reason: not valid java name */
    public static final int m182contentHashCodeXUkPCBk(int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: contentHashCode-d-6D3K8, reason: not valid java name */
    public static final int m183contentHashCoded6D3K8(short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    /* JADX INFO: renamed from: contentHashCode-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ int m184contentHashCoderL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$contentHashCode");
        return m183contentHashCoded6D3K8(sArr);
    }

    /* JADX INFO: renamed from: contentHashCode-uLth9ew, reason: not valid java name */
    public static final int m185contentHashCodeuLth9ew(long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    /* JADX INFO: renamed from: contentToString--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ String m186contentToStringajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$contentToString");
        return m190contentToStringXUkPCBk(iArr);
    }

    /* JADX INFO: renamed from: contentToString-2csIQuQ, reason: not valid java name */
    public static final String m187contentToString2csIQuQ(byte[] bArr) {
        String strJoinToString$default;
        return (bArr == null || (strJoinToString$default = d.g0.a0.joinToString$default(d.u.m406boximpl(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ String m188contentToStringGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$contentToString");
        return m187contentToString2csIQuQ(bArr);
    }

    /* JADX INFO: renamed from: contentToString-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ String m189contentToStringQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$contentToString");
        return m193contentToStringuLth9ew(jArr);
    }

    /* JADX INFO: renamed from: contentToString-XUkPCBk, reason: not valid java name */
    public static final String m190contentToStringXUkPCBk(int[] iArr) {
        String strJoinToString$default;
        return (iArr == null || (strJoinToString$default = d.g0.a0.joinToString$default(w.m430boximpl(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-d-6D3K8, reason: not valid java name */
    public static final String m191contentToStringd6D3K8(short[] sArr) {
        String strJoinToString$default;
        return (sArr == null || (strJoinToString$default = d.g0.a0.joinToString$default(b0.m101boximpl(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: contentToString-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ String m192contentToStringrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$contentToString");
        return m191contentToStringd6D3K8(sArr);
    }

    /* JADX INFO: renamed from: contentToString-uLth9ew, reason: not valid java name */
    public static final String m193contentToStringuLth9ew(long[] jArr) {
        String strJoinToString$default;
        return (jArr == null || (strJoinToString$default = d.g0.a0.joinToString$default(y.m454boximpl(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: drop-PpDY95g, reason: not valid java name */
    public static final List<t> m194dropPpDY95g(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$drop");
        if (i2 >= 0) {
            return m354takeLastPpDY95g(bArr, p.coerceAtLeast(d.u.m414getSizeimpl(bArr) - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: drop-nggk6HY, reason: not valid java name */
    public static final List<a0> m195dropnggk6HY(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$drop");
        if (i2 >= 0) {
            return m355takeLastnggk6HY(sArr, p.coerceAtLeast(b0.m109getSizeimpl(sArr) - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: drop-qFRl0hI, reason: not valid java name */
    public static final List<v> m196dropqFRl0hI(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$drop");
        if (i2 >= 0) {
            return m356takeLastqFRl0hI(iArr, p.coerceAtLeast(w.m438getSizeimpl(iArr) - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: drop-r7IrZao, reason: not valid java name */
    public static final List<x> m197dropr7IrZao(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$drop");
        if (i2 >= 0) {
            return m357takeLastr7IrZao(jArr, p.coerceAtLeast(y.m462getSizeimpl(jArr) - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLast-PpDY95g, reason: not valid java name */
    public static final List<t> m198dropLastPpDY95g(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$dropLast");
        if (i2 >= 0) {
            return m350takePpDY95g(bArr, p.coerceAtLeast(d.u.m414getSizeimpl(bArr) - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLast-nggk6HY, reason: not valid java name */
    public static final List<a0> m199dropLastnggk6HY(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$dropLast");
        if (i2 >= 0) {
            return m351takenggk6HY(sArr, p.coerceAtLeast(b0.m109getSizeimpl(sArr) - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLast-qFRl0hI, reason: not valid java name */
    public static final List<v> m200dropLastqFRl0hI(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$dropLast");
        if (i2 >= 0) {
            return m352takeqFRl0hI(iArr, p.coerceAtLeast(w.m438getSizeimpl(iArr) - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: dropLast-r7IrZao, reason: not valid java name */
    public static final List<x> m201dropLastr7IrZao(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$dropLast");
        if (i2 >= 0) {
            return m353taker7IrZao(jArr, p.coerceAtLeast(y.m462getSizeimpl(jArr) - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX INFO: renamed from: fill-2fe2U9s, reason: not valid java name */
    public static final void m202fill2fe2U9s(int[] iArr, int i2, int i3, int i4) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$fill");
        l.fill(iArr, i2, i3, i4);
    }

    /* JADX INFO: renamed from: fill-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ void m203fill2fe2U9s$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = w.m438getSizeimpl(iArr);
        }
        m202fill2fe2U9s(iArr, i2, i3, i4);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ, reason: not valid java name */
    public static final void m204fillEtDCXyQ(short[] sArr, short s, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$fill");
        l.fill(sArr, s, i2, i3);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ void m205fillEtDCXyQ$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = b0.m109getSizeimpl(sArr);
        }
        m204fillEtDCXyQ(sArr, s, i2, i3);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc, reason: not valid java name */
    public static final void m206fillK6DWlUc(long[] jArr, long j, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$fill");
        l.fill(jArr, j, i2, i3);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ void m207fillK6DWlUc$default(long[] jArr, long j, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = y.m462getSizeimpl(jArr);
        }
        m206fillK6DWlUc(jArr, j, i2, i3);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw, reason: not valid java name */
    public static final void m208fillWpHrYlw(byte[] bArr, byte b2, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$fill");
        l.fill(bArr, b2, i2, i3);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ void m209fillWpHrYlw$default(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = d.u.m414getSizeimpl(bArr);
        }
        m208fillWpHrYlw(bArr, b2, i2, i3);
    }

    /* JADX INFO: renamed from: firstOrNull--ajY-9A, reason: not valid java name */
    public static final v m210firstOrNullajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$firstOrNull");
        if (w.m440isEmptyimpl(iArr)) {
            return null;
        }
        return v.m423boximpl(w.m437getpVg5ArA(iArr, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-GBYM_sE, reason: not valid java name */
    public static final t m211firstOrNullGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$firstOrNull");
        if (d.u.m416isEmptyimpl(bArr)) {
            return null;
        }
        return t.m399boximpl(d.u.m413getw2LRezQ(bArr, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-QwZRm1k, reason: not valid java name */
    public static final x m212firstOrNullQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$firstOrNull");
        if (y.m464isEmptyimpl(jArr)) {
            return null;
        }
        return x.m447boximpl(y.m461getsVKNKU(jArr, 0));
    }

    /* JADX INFO: renamed from: firstOrNull-rL5Bavg, reason: not valid java name */
    public static final a0 m213firstOrNullrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$firstOrNull");
        if (b0.m111isEmptyimpl(sArr)) {
            return null;
        }
        return a0.m94boximpl(b0.m108getMh2AYeg(sArr, 0));
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A, reason: not valid java name */
    public static final k m214getIndicesajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$indices");
        return m.getIndices(iArr);
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m215getIndicesajY9A$annotations(int[] iArr) {
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE, reason: not valid java name */
    public static final k m216getIndicesGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$indices");
        return m.getIndices(bArr);
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m217getIndicesGBYM_sE$annotations(byte[] bArr) {
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k, reason: not valid java name */
    public static final k m218getIndicesQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$indices");
        return m.getIndices(jArr);
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m219getIndicesQwZRm1k$annotations(long[] jArr) {
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg, reason: not valid java name */
    public static final k m220getIndicesrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$indices");
        return m.getIndices(sArr);
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m221getIndicesrL5Bavg$annotations(short[] sArr) {
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A, reason: not valid java name */
    public static final int m222getLastIndexajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$lastIndex");
        return m.getLastIndex(iArr);
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m223getLastIndexajY9A$annotations(int[] iArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE, reason: not valid java name */
    public static final int m224getLastIndexGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$lastIndex");
        return m.getLastIndex(bArr);
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m225getLastIndexGBYM_sE$annotations(byte[] bArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k, reason: not valid java name */
    public static final int m226getLastIndexQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$lastIndex");
        return m.getLastIndex(jArr);
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m227getLastIndexQwZRm1k$annotations(long[] jArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg, reason: not valid java name */
    public static final int m228getLastIndexrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$lastIndex");
        return m.getLastIndex(sArr);
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m229getLastIndexrL5Bavg$annotations(short[] sArr) {
    }

    /* JADX INFO: renamed from: getOrNull-PpDY95g, reason: not valid java name */
    public static final t m230getOrNullPpDY95g(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$getOrNull");
        if (i2 < 0 || i2 > m.getLastIndex(bArr)) {
            return null;
        }
        return t.m399boximpl(d.u.m413getw2LRezQ(bArr, i2));
    }

    /* JADX INFO: renamed from: getOrNull-nggk6HY, reason: not valid java name */
    public static final a0 m231getOrNullnggk6HY(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$getOrNull");
        if (i2 < 0 || i2 > m.getLastIndex(sArr)) {
            return null;
        }
        return a0.m94boximpl(b0.m108getMh2AYeg(sArr, i2));
    }

    /* JADX INFO: renamed from: getOrNull-qFRl0hI, reason: not valid java name */
    public static final v m232getOrNullqFRl0hI(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$getOrNull");
        if (i2 < 0 || i2 > m.getLastIndex(iArr)) {
            return null;
        }
        return v.m423boximpl(w.m437getpVg5ArA(iArr, i2));
    }

    /* JADX INFO: renamed from: getOrNull-r7IrZao, reason: not valid java name */
    public static final x m233getOrNullr7IrZao(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$getOrNull");
        if (i2 < 0 || i2 > m.getLastIndex(jArr)) {
            return null;
        }
        return x.m447boximpl(y.m461getsVKNKU(jArr, i2));
    }

    /* JADX INFO: renamed from: lastOrNull--ajY-9A, reason: not valid java name */
    public static final v m234lastOrNullajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$lastOrNull");
        if (w.m440isEmptyimpl(iArr)) {
            return null;
        }
        return v.m423boximpl(w.m437getpVg5ArA(iArr, w.m438getSizeimpl(iArr) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-GBYM_sE, reason: not valid java name */
    public static final t m235lastOrNullGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$lastOrNull");
        if (d.u.m416isEmptyimpl(bArr)) {
            return null;
        }
        return t.m399boximpl(d.u.m413getw2LRezQ(bArr, d.u.m414getSizeimpl(bArr) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-QwZRm1k, reason: not valid java name */
    public static final x m236lastOrNullQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$lastOrNull");
        if (y.m464isEmptyimpl(jArr)) {
            return null;
        }
        return x.m447boximpl(y.m461getsVKNKU(jArr, y.m462getSizeimpl(jArr) - 1));
    }

    /* JADX INFO: renamed from: lastOrNull-rL5Bavg, reason: not valid java name */
    public static final a0 m237lastOrNullrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$lastOrNull");
        if (b0.m111isEmptyimpl(sArr)) {
            return null;
        }
        return a0.m94boximpl(b0.m108getMh2AYeg(sArr, b0.m109getSizeimpl(sArr) - 1));
    }

    /* JADX INFO: renamed from: max--ajY-9A, reason: not valid java name */
    public static final v m238maxajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$max");
        return m242maxOrNullajY9A(iArr);
    }

    /* JADX INFO: renamed from: max-GBYM_sE, reason: not valid java name */
    public static final t m239maxGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$max");
        return m243maxOrNullGBYM_sE(bArr);
    }

    /* JADX INFO: renamed from: max-QwZRm1k, reason: not valid java name */
    public static final x m240maxQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$max");
        return m244maxOrNullQwZRm1k(jArr);
    }

    /* JADX INFO: renamed from: max-rL5Bavg, reason: not valid java name */
    public static final a0 m241maxrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$max");
        return m245maxOrNullrL5Bavg(sArr);
    }

    /* JADX INFO: renamed from: maxOrNull--ajY-9A, reason: not valid java name */
    public static final v m242maxOrNullajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$maxOrNull");
        if (w.m440isEmptyimpl(iArr)) {
            return null;
        }
        int iM437getpVg5ArA = w.m437getpVg5ArA(iArr, 0);
        int lastIndex = m.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM437getpVg5ArA2 = w.m437getpVg5ArA(iArr, i2);
                if (f0.uintCompare(iM437getpVg5ArA, iM437getpVg5ArA2) < 0) {
                    iM437getpVg5ArA = iM437getpVg5ArA2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return v.m423boximpl(iM437getpVg5ArA);
    }

    /* JADX INFO: renamed from: maxOrNull-GBYM_sE, reason: not valid java name */
    public static final t m243maxOrNullGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$maxOrNull");
        if (d.u.m416isEmptyimpl(bArr)) {
            return null;
        }
        byte bM413getw2LRezQ = d.u.m413getw2LRezQ(bArr, 0);
        int lastIndex = m.getLastIndex(bArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM413getw2LRezQ2 = d.u.m413getw2LRezQ(bArr, i2);
                if (d.k0.d.t.compare(bM413getw2LRezQ & 255, bM413getw2LRezQ2 & 255) < 0) {
                    bM413getw2LRezQ = bM413getw2LRezQ2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t.m399boximpl(bM413getw2LRezQ);
    }

    /* JADX INFO: renamed from: maxOrNull-QwZRm1k, reason: not valid java name */
    public static final x m244maxOrNullQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$maxOrNull");
        if (y.m464isEmptyimpl(jArr)) {
            return null;
        }
        long jM461getsVKNKU = y.m461getsVKNKU(jArr, 0);
        int lastIndex = m.getLastIndex(jArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM461getsVKNKU2 = y.m461getsVKNKU(jArr, i2);
                if (f0.ulongCompare(jM461getsVKNKU, jM461getsVKNKU2) < 0) {
                    jM461getsVKNKU = jM461getsVKNKU2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return x.m447boximpl(jM461getsVKNKU);
    }

    /* JADX INFO: renamed from: maxOrNull-rL5Bavg, reason: not valid java name */
    public static final a0 m245maxOrNullrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$maxOrNull");
        if (b0.m111isEmptyimpl(sArr)) {
            return null;
        }
        short sM108getMh2AYeg = b0.m108getMh2AYeg(sArr, 0);
        int lastIndex = m.getLastIndex(sArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM108getMh2AYeg2 = b0.m108getMh2AYeg(sArr, i2);
                if (d.k0.d.t.compare(sM108getMh2AYeg & 65535, 65535 & sM108getMh2AYeg2) < 0) {
                    sM108getMh2AYeg = sM108getMh2AYeg2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return a0.m94boximpl(sM108getMh2AYeg);
    }

    /* JADX INFO: renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final t m246maxWithXMRcp5o(byte[] bArr, Comparator<? super t> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return m250maxWithOrNullXMRcp5o(bArr, comparator);
    }

    /* JADX INFO: renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final v m247maxWithYmdZ_VM(int[] iArr, Comparator<? super v> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return m251maxWithOrNullYmdZ_VM(iArr, comparator);
    }

    /* JADX INFO: renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final a0 m248maxWitheOHTfZs(short[] sArr, Comparator<? super a0> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return m252maxWithOrNulleOHTfZs(sArr, comparator);
    }

    /* JADX INFO: renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final x m249maxWithzrEWJaI(long[] jArr, Comparator<? super x> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return m253maxWithOrNullzrEWJaI(jArr, comparator);
    }

    /* JADX INFO: renamed from: maxWithOrNull-XMRcp5o, reason: not valid java name */
    public static final t m250maxWithOrNullXMRcp5o(byte[] bArr, Comparator<? super t> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (d.u.m416isEmptyimpl(bArr)) {
            return null;
        }
        byte bM413getw2LRezQ = d.u.m413getw2LRezQ(bArr, 0);
        int lastIndex = m.getLastIndex(bArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM413getw2LRezQ2 = d.u.m413getw2LRezQ(bArr, i2);
                if (comparator.compare(t.m399boximpl(bM413getw2LRezQ), t.m399boximpl(bM413getw2LRezQ2)) < 0) {
                    bM413getw2LRezQ = bM413getw2LRezQ2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t.m399boximpl(bM413getw2LRezQ);
    }

    /* JADX INFO: renamed from: maxWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final v m251maxWithOrNullYmdZ_VM(int[] iArr, Comparator<? super v> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (w.m440isEmptyimpl(iArr)) {
            return null;
        }
        int iM437getpVg5ArA = w.m437getpVg5ArA(iArr, 0);
        int lastIndex = m.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM437getpVg5ArA2 = w.m437getpVg5ArA(iArr, i2);
                if (comparator.compare(v.m423boximpl(iM437getpVg5ArA), v.m423boximpl(iM437getpVg5ArA2)) < 0) {
                    iM437getpVg5ArA = iM437getpVg5ArA2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return v.m423boximpl(iM437getpVg5ArA);
    }

    /* JADX INFO: renamed from: maxWithOrNull-eOHTfZs, reason: not valid java name */
    public static final a0 m252maxWithOrNulleOHTfZs(short[] sArr, Comparator<? super a0> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (b0.m111isEmptyimpl(sArr)) {
            return null;
        }
        short sM108getMh2AYeg = b0.m108getMh2AYeg(sArr, 0);
        int lastIndex = m.getLastIndex(sArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM108getMh2AYeg2 = b0.m108getMh2AYeg(sArr, i2);
                if (comparator.compare(a0.m94boximpl(sM108getMh2AYeg), a0.m94boximpl(sM108getMh2AYeg2)) < 0) {
                    sM108getMh2AYeg = sM108getMh2AYeg2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return a0.m94boximpl(sM108getMh2AYeg);
    }

    /* JADX INFO: renamed from: maxWithOrNull-zrEWJaI, reason: not valid java name */
    public static final x m253maxWithOrNullzrEWJaI(long[] jArr, Comparator<? super x> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (y.m464isEmptyimpl(jArr)) {
            return null;
        }
        long jM461getsVKNKU = y.m461getsVKNKU(jArr, 0);
        int lastIndex = m.getLastIndex(jArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM461getsVKNKU2 = y.m461getsVKNKU(jArr, i2);
                if (comparator.compare(x.m447boximpl(jM461getsVKNKU), x.m447boximpl(jM461getsVKNKU2)) < 0) {
                    jM461getsVKNKU = jM461getsVKNKU2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return x.m447boximpl(jM461getsVKNKU);
    }

    /* JADX INFO: renamed from: min--ajY-9A, reason: not valid java name */
    public static final v m254minajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$min");
        return m258minOrNullajY9A(iArr);
    }

    /* JADX INFO: renamed from: min-GBYM_sE, reason: not valid java name */
    public static final t m255minGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$min");
        return m259minOrNullGBYM_sE(bArr);
    }

    /* JADX INFO: renamed from: min-QwZRm1k, reason: not valid java name */
    public static final x m256minQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$min");
        return m260minOrNullQwZRm1k(jArr);
    }

    /* JADX INFO: renamed from: min-rL5Bavg, reason: not valid java name */
    public static final a0 m257minrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$min");
        return m261minOrNullrL5Bavg(sArr);
    }

    /* JADX INFO: renamed from: minOrNull--ajY-9A, reason: not valid java name */
    public static final v m258minOrNullajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$minOrNull");
        if (w.m440isEmptyimpl(iArr)) {
            return null;
        }
        int iM437getpVg5ArA = w.m437getpVg5ArA(iArr, 0);
        int lastIndex = m.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM437getpVg5ArA2 = w.m437getpVg5ArA(iArr, i2);
                if (f0.uintCompare(iM437getpVg5ArA, iM437getpVg5ArA2) > 0) {
                    iM437getpVg5ArA = iM437getpVg5ArA2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return v.m423boximpl(iM437getpVg5ArA);
    }

    /* JADX INFO: renamed from: minOrNull-GBYM_sE, reason: not valid java name */
    public static final t m259minOrNullGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$minOrNull");
        if (d.u.m416isEmptyimpl(bArr)) {
            return null;
        }
        byte bM413getw2LRezQ = d.u.m413getw2LRezQ(bArr, 0);
        int lastIndex = m.getLastIndex(bArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM413getw2LRezQ2 = d.u.m413getw2LRezQ(bArr, i2);
                if (d.k0.d.t.compare(bM413getw2LRezQ & 255, bM413getw2LRezQ2 & 255) > 0) {
                    bM413getw2LRezQ = bM413getw2LRezQ2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t.m399boximpl(bM413getw2LRezQ);
    }

    /* JADX INFO: renamed from: minOrNull-QwZRm1k, reason: not valid java name */
    public static final x m260minOrNullQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$minOrNull");
        if (y.m464isEmptyimpl(jArr)) {
            return null;
        }
        long jM461getsVKNKU = y.m461getsVKNKU(jArr, 0);
        int lastIndex = m.getLastIndex(jArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM461getsVKNKU2 = y.m461getsVKNKU(jArr, i2);
                if (f0.ulongCompare(jM461getsVKNKU, jM461getsVKNKU2) > 0) {
                    jM461getsVKNKU = jM461getsVKNKU2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return x.m447boximpl(jM461getsVKNKU);
    }

    /* JADX INFO: renamed from: minOrNull-rL5Bavg, reason: not valid java name */
    public static final a0 m261minOrNullrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$minOrNull");
        if (b0.m111isEmptyimpl(sArr)) {
            return null;
        }
        short sM108getMh2AYeg = b0.m108getMh2AYeg(sArr, 0);
        int lastIndex = m.getLastIndex(sArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM108getMh2AYeg2 = b0.m108getMh2AYeg(sArr, i2);
                if (d.k0.d.t.compare(sM108getMh2AYeg & 65535, 65535 & sM108getMh2AYeg2) > 0) {
                    sM108getMh2AYeg = sM108getMh2AYeg2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return a0.m94boximpl(sM108getMh2AYeg);
    }

    /* JADX INFO: renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final t m262minWithXMRcp5o(byte[] bArr, Comparator<? super t> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return m266minWithOrNullXMRcp5o(bArr, comparator);
    }

    /* JADX INFO: renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final v m263minWithYmdZ_VM(int[] iArr, Comparator<? super v> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return m267minWithOrNullYmdZ_VM(iArr, comparator);
    }

    /* JADX INFO: renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final a0 m264minWitheOHTfZs(short[] sArr, Comparator<? super a0> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return m268minWithOrNulleOHTfZs(sArr, comparator);
    }

    /* JADX INFO: renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final x m265minWithzrEWJaI(long[] jArr, Comparator<? super x> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return m269minWithOrNullzrEWJaI(jArr, comparator);
    }

    /* JADX INFO: renamed from: minWithOrNull-XMRcp5o, reason: not valid java name */
    public static final t m266minWithOrNullXMRcp5o(byte[] bArr, Comparator<? super t> comparator) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (d.u.m416isEmptyimpl(bArr)) {
            return null;
        }
        byte bM413getw2LRezQ = d.u.m413getw2LRezQ(bArr, 0);
        int lastIndex = m.getLastIndex(bArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM413getw2LRezQ2 = d.u.m413getw2LRezQ(bArr, i2);
                if (comparator.compare(t.m399boximpl(bM413getw2LRezQ), t.m399boximpl(bM413getw2LRezQ2)) > 0) {
                    bM413getw2LRezQ = bM413getw2LRezQ2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t.m399boximpl(bM413getw2LRezQ);
    }

    /* JADX INFO: renamed from: minWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final v m267minWithOrNullYmdZ_VM(int[] iArr, Comparator<? super v> comparator) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (w.m440isEmptyimpl(iArr)) {
            return null;
        }
        int iM437getpVg5ArA = w.m437getpVg5ArA(iArr, 0);
        int lastIndex = m.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM437getpVg5ArA2 = w.m437getpVg5ArA(iArr, i2);
                if (comparator.compare(v.m423boximpl(iM437getpVg5ArA), v.m423boximpl(iM437getpVg5ArA2)) > 0) {
                    iM437getpVg5ArA = iM437getpVg5ArA2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return v.m423boximpl(iM437getpVg5ArA);
    }

    /* JADX INFO: renamed from: minWithOrNull-eOHTfZs, reason: not valid java name */
    public static final a0 m268minWithOrNulleOHTfZs(short[] sArr, Comparator<? super a0> comparator) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (b0.m111isEmptyimpl(sArr)) {
            return null;
        }
        short sM108getMh2AYeg = b0.m108getMh2AYeg(sArr, 0);
        int lastIndex = m.getLastIndex(sArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM108getMh2AYeg2 = b0.m108getMh2AYeg(sArr, i2);
                if (comparator.compare(a0.m94boximpl(sM108getMh2AYeg), a0.m94boximpl(sM108getMh2AYeg2)) > 0) {
                    sM108getMh2AYeg = sM108getMh2AYeg2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return a0.m94boximpl(sM108getMh2AYeg);
    }

    /* JADX INFO: renamed from: minWithOrNull-zrEWJaI, reason: not valid java name */
    public static final x m269minWithOrNullzrEWJaI(long[] jArr, Comparator<? super x> comparator) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (y.m464isEmptyimpl(jArr)) {
            return null;
        }
        long jM461getsVKNKU = y.m461getsVKNKU(jArr, 0);
        int lastIndex = m.getLastIndex(jArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM461getsVKNKU2 = y.m461getsVKNKU(jArr, i2);
                if (comparator.compare(x.m447boximpl(jM461getsVKNKU), x.m447boximpl(jM461getsVKNKU2)) > 0) {
                    jM461getsVKNKU = jM461getsVKNKU2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return x.m447boximpl(jM461getsVKNKU);
    }

    /* JADX INFO: renamed from: plus-CFIt9YE, reason: not valid java name */
    public static final int[] m270plusCFIt9YE(int[] iArr, Collection<v> collection) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int iM438getSizeimpl = w.m438getSizeimpl(iArr);
        int[] iArrCopyOf = Arrays.copyOf(iArr, w.m438getSizeimpl(iArr) + collection.size());
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        Iterator<v> it = collection.iterator();
        while (it.hasNext()) {
            iArrCopyOf[iM438getSizeimpl] = it.next().m429unboximpl();
            iM438getSizeimpl++;
        }
        return w.m432constructorimpl(iArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-kzHmqpY, reason: not valid java name */
    public static final long[] m271pluskzHmqpY(long[] jArr, Collection<x> collection) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int iM462getSizeimpl = y.m462getSizeimpl(jArr);
        long[] jArrCopyOf = Arrays.copyOf(jArr, y.m462getSizeimpl(jArr) + collection.size());
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        Iterator<x> it = collection.iterator();
        while (it.hasNext()) {
            jArrCopyOf[iM462getSizeimpl] = it.next().m453unboximpl();
            iM462getSizeimpl++;
        }
        return y.m456constructorimpl(jArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-ojwP5H8, reason: not valid java name */
    public static final short[] m272plusojwP5H8(short[] sArr, Collection<a0> collection) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int iM109getSizeimpl = b0.m109getSizeimpl(sArr);
        short[] sArrCopyOf = Arrays.copyOf(sArr, b0.m109getSizeimpl(sArr) + collection.size());
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        Iterator<a0> it = collection.iterator();
        while (it.hasNext()) {
            sArrCopyOf[iM109getSizeimpl] = it.next().m100unboximpl();
            iM109getSizeimpl++;
        }
        return b0.m103constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-xo_DsdI, reason: not valid java name */
    public static final byte[] m273plusxo_DsdI(byte[] bArr, Collection<t> collection) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$plus");
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        int iM414getSizeimpl = d.u.m414getSizeimpl(bArr);
        byte[] bArrCopyOf = Arrays.copyOf(bArr, d.u.m414getSizeimpl(bArr) + collection.size());
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        Iterator<t> it = collection.iterator();
        while (it.hasNext()) {
            bArrCopyOf[iM414getSizeimpl] = it.next().m405unboximpl();
            iM414getSizeimpl++;
        }
        return d.u.m408constructorimpl(bArrCopyOf);
    }

    /* JADX INFO: renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m274random2D5oskM(int[] iArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (w.m440isEmptyimpl(iArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return w.m437getpVg5ArA(iArr, fVar.nextInt(w.m438getSizeimpl(iArr)));
    }

    /* JADX INFO: renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m275randomJzugnMA(long[] jArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (y.m464isEmptyimpl(jArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return y.m461getsVKNKU(jArr, fVar.nextInt(y.m462getSizeimpl(jArr)));
    }

    /* JADX INFO: renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m276randomoSF2wD8(byte[] bArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (d.u.m416isEmptyimpl(bArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return d.u.m413getw2LRezQ(bArr, fVar.nextInt(d.u.m414getSizeimpl(bArr)));
    }

    /* JADX INFO: renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m277randoms5X_as8(short[] sArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (b0.m111isEmptyimpl(sArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return b0.m108getMh2AYeg(sArr, fVar.nextInt(b0.m109getSizeimpl(sArr)));
    }

    /* JADX INFO: renamed from: randomOrNull-2D5oskM, reason: not valid java name */
    public static final v m278randomOrNull2D5oskM(int[] iArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (w.m440isEmptyimpl(iArr)) {
            return null;
        }
        return v.m423boximpl(w.m437getpVg5ArA(iArr, fVar.nextInt(w.m438getSizeimpl(iArr))));
    }

    /* JADX INFO: renamed from: randomOrNull-JzugnMA, reason: not valid java name */
    public static final x m279randomOrNullJzugnMA(long[] jArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (y.m464isEmptyimpl(jArr)) {
            return null;
        }
        return x.m447boximpl(y.m461getsVKNKU(jArr, fVar.nextInt(y.m462getSizeimpl(jArr))));
    }

    /* JADX INFO: renamed from: randomOrNull-oSF2wD8, reason: not valid java name */
    public static final t m280randomOrNulloSF2wD8(byte[] bArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (d.u.m416isEmptyimpl(bArr)) {
            return null;
        }
        return t.m399boximpl(d.u.m413getw2LRezQ(bArr, fVar.nextInt(d.u.m414getSizeimpl(bArr))));
    }

    /* JADX INFO: renamed from: randomOrNull-s5X_as8, reason: not valid java name */
    public static final a0 m281randomOrNulls5X_as8(short[] sArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (b0.m111isEmptyimpl(sArr)) {
            return null;
        }
        return a0.m94boximpl(b0.m108getMh2AYeg(sArr, fVar.nextInt(b0.m109getSizeimpl(sArr))));
    }

    /* JADX INFO: renamed from: reversed--ajY-9A, reason: not valid java name */
    public static final List<v> m282reversedajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$reversed");
        if (w.m440isEmptyimpl(iArr)) {
            return s.emptyList();
        }
        List<v> mutableList = d.g0.a0.toMutableList((Collection) w.m430boximpl(iArr));
        z.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-GBYM_sE, reason: not valid java name */
    public static final List<t> m283reversedGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$reversed");
        if (d.u.m416isEmptyimpl(bArr)) {
            return s.emptyList();
        }
        List<t> mutableList = d.g0.a0.toMutableList((Collection) d.u.m406boximpl(bArr));
        z.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-QwZRm1k, reason: not valid java name */
    public static final List<x> m284reversedQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$reversed");
        if (y.m464isEmptyimpl(jArr)) {
            return s.emptyList();
        }
        List<x> mutableList = d.g0.a0.toMutableList((Collection) y.m454boximpl(jArr));
        z.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-rL5Bavg, reason: not valid java name */
    public static final List<a0> m285reversedrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$reversed");
        if (b0.m111isEmptyimpl(sArr)) {
            return s.emptyList();
        }
        List<a0> mutableList = d.g0.a0.toMutableList((Collection) b0.m101boximpl(sArr));
        z.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: shuffle--ajY-9A, reason: not valid java name */
    public static final void m286shuffleajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$shuffle");
        m287shuffle2D5oskM(iArr, f.f12668b);
    }

    /* JADX INFO: renamed from: shuffle-2D5oskM, reason: not valid java name */
    public static final void m287shuffle2D5oskM(int[] iArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = m.getLastIndex(iArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            int iM437getpVg5ArA = w.m437getpVg5ArA(iArr, lastIndex);
            w.m442setVXSXFK8(iArr, lastIndex, w.m437getpVg5ArA(iArr, iNextInt));
            w.m442setVXSXFK8(iArr, iNextInt, iM437getpVg5ArA);
        }
    }

    /* JADX INFO: renamed from: shuffle-GBYM_sE, reason: not valid java name */
    public static final void m288shuffleGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$shuffle");
        m291shuffleoSF2wD8(bArr, f.f12668b);
    }

    /* JADX INFO: renamed from: shuffle-JzugnMA, reason: not valid java name */
    public static final void m289shuffleJzugnMA(long[] jArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = m.getLastIndex(jArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            long jM461getsVKNKU = y.m461getsVKNKU(jArr, lastIndex);
            y.m466setk8EXiF4(jArr, lastIndex, y.m461getsVKNKU(jArr, iNextInt));
            y.m466setk8EXiF4(jArr, iNextInt, jM461getsVKNKU);
        }
    }

    /* JADX INFO: renamed from: shuffle-QwZRm1k, reason: not valid java name */
    public static final void m290shuffleQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$shuffle");
        m289shuffleJzugnMA(jArr, f.f12668b);
    }

    /* JADX INFO: renamed from: shuffle-oSF2wD8, reason: not valid java name */
    public static final void m291shuffleoSF2wD8(byte[] bArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = m.getLastIndex(bArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            byte bM413getw2LRezQ = d.u.m413getw2LRezQ(bArr, lastIndex);
            d.u.m418setVurrAj0(bArr, lastIndex, d.u.m413getw2LRezQ(bArr, iNextInt));
            d.u.m418setVurrAj0(bArr, iNextInt, bM413getw2LRezQ);
        }
    }

    /* JADX INFO: renamed from: shuffle-rL5Bavg, reason: not valid java name */
    public static final void m292shufflerL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$shuffle");
        m293shuffles5X_as8(sArr, f.f12668b);
    }

    /* JADX INFO: renamed from: shuffle-s5X_as8, reason: not valid java name */
    public static final void m293shuffles5X_as8(short[] sArr, f fVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = m.getLastIndex(sArr); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            short sM108getMh2AYeg = b0.m108getMh2AYeg(sArr, lastIndex);
            b0.m113set01HTLdE(sArr, lastIndex, b0.m108getMh2AYeg(sArr, iNextInt));
            b0.m113set01HTLdE(sArr, iNextInt, sM108getMh2AYeg);
        }
    }

    /* JADX INFO: renamed from: singleOrNull--ajY-9A, reason: not valid java name */
    public static final v m294singleOrNullajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$singleOrNull");
        if (w.m438getSizeimpl(iArr) == 1) {
            return v.m423boximpl(w.m437getpVg5ArA(iArr, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-GBYM_sE, reason: not valid java name */
    public static final t m295singleOrNullGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$singleOrNull");
        if (d.u.m414getSizeimpl(bArr) == 1) {
            return t.m399boximpl(d.u.m413getw2LRezQ(bArr, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-QwZRm1k, reason: not valid java name */
    public static final x m296singleOrNullQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$singleOrNull");
        if (y.m462getSizeimpl(jArr) == 1) {
            return x.m447boximpl(y.m461getsVKNKU(jArr, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-rL5Bavg, reason: not valid java name */
    public static final a0 m297singleOrNullrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$singleOrNull");
        if (b0.m109getSizeimpl(sArr) == 1) {
            return a0.m94boximpl(b0.m108getMh2AYeg(sArr, 0));
        }
        return null;
    }

    /* JADX INFO: renamed from: slice-F7u83W8, reason: not valid java name */
    public static final List<x> m298sliceF7u83W8(long[] jArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(x.m447boximpl(y.m461getsVKNKU(jArr, it.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-HwE9HBo, reason: not valid java name */
    public static final List<v> m299sliceHwE9HBo(int[] iArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(v.m423boximpl(w.m437getpVg5ArA(iArr, it.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-JGPC0-M, reason: not valid java name */
    public static final List<a0> m300sliceJGPC0M(short[] sArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(a0.m94boximpl(b0.m108getMh2AYeg(sArr, it.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-JQknh5Q, reason: not valid java name */
    public static final List<t> m301sliceJQknh5Q(byte[] bArr, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = d.g0.t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(t.m399boximpl(d.u.m413getw2LRezQ(bArr, it.next().intValue())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-Q6IL4kU, reason: not valid java name */
    public static final List<a0> m302sliceQ6IL4kU(short[] sArr, k kVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? s.emptyList() : d.g0.j1.a.m145asListrL5Bavg(b0.m103constructorimpl(l.copyOfRange(sArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static final List<x> m303sliceZRhS8yI(long[] jArr, k kVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? s.emptyList() : d.g0.j1.a.m144asListQwZRm1k(y.m456constructorimpl(l.copyOfRange(jArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-c0bezYM, reason: not valid java name */
    public static final List<t> m304slicec0bezYM(byte[] bArr, k kVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? s.emptyList() : d.g0.j1.a.m143asListGBYM_sE(d.u.m408constructorimpl(l.copyOfRange(bArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-tAntMlw, reason: not valid java name */
    public static final List<v> m305slicetAntMlw(int[] iArr, k kVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? s.emptyList() : d.g0.j1.a.m142asListajY9A(w.m432constructorimpl(l.copyOfRange(iArr, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: sliceArray-CFIt9YE, reason: not valid java name */
    public static final int[] m306sliceArrayCFIt9YE(int[] iArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        return w.m432constructorimpl(m.sliceArray(iArr, collection));
    }

    /* JADX INFO: renamed from: sliceArray-Q6IL4kU, reason: not valid java name */
    public static final short[] m307sliceArrayQ6IL4kU(short[] sArr, k kVar) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return b0.m103constructorimpl(m.sliceArray(sArr, kVar));
    }

    /* JADX INFO: renamed from: sliceArray-ZRhS8yI, reason: not valid java name */
    public static final long[] m308sliceArrayZRhS8yI(long[] jArr, k kVar) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return y.m456constructorimpl(m.sliceArray(jArr, kVar));
    }

    /* JADX INFO: renamed from: sliceArray-c0bezYM, reason: not valid java name */
    public static final byte[] m309sliceArrayc0bezYM(byte[] bArr, k kVar) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return d.u.m408constructorimpl(m.sliceArray(bArr, kVar));
    }

    /* JADX INFO: renamed from: sliceArray-kzHmqpY, reason: not valid java name */
    public static final long[] m310sliceArraykzHmqpY(long[] jArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        return y.m456constructorimpl(m.sliceArray(jArr, collection));
    }

    /* JADX INFO: renamed from: sliceArray-ojwP5H8, reason: not valid java name */
    public static final short[] m311sliceArrayojwP5H8(short[] sArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        return b0.m103constructorimpl(m.sliceArray(sArr, collection));
    }

    /* JADX INFO: renamed from: sliceArray-tAntMlw, reason: not valid java name */
    public static final int[] m312sliceArraytAntMlw(int[] iArr, k kVar) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return w.m432constructorimpl(m.sliceArray(iArr, kVar));
    }

    /* JADX INFO: renamed from: sliceArray-xo_DsdI, reason: not valid java name */
    public static final byte[] m313sliceArrayxo_DsdI(byte[] bArr, Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sliceArray");
        d.k0.d.t.checkNotNullParameter(collection, "indices");
        return d.u.m408constructorimpl(m.sliceArray(bArr, collection));
    }

    /* JADX INFO: renamed from: sort--ajY-9A, reason: not valid java name */
    public static final void m314sortajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sort");
        if (w.m438getSizeimpl(iArr) > 1) {
            d1.m134sortArrayoBK06Vg(iArr, 0, w.m438getSizeimpl(iArr));
        }
    }

    /* JADX INFO: renamed from: sort--nroSd4, reason: not valid java name */
    public static final void m315sortnroSd4(long[] jArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sort");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, y.m462getSizeimpl(jArr));
        d1.m131sortArraynroSd4(jArr, i2, i3);
    }

    /* JADX INFO: renamed from: sort--nroSd4$default, reason: not valid java name */
    public static /* synthetic */ void m316sortnroSd4$default(long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = y.m462getSizeimpl(jArr);
        }
        m315sortnroSd4(jArr, i2, i3);
    }

    /* JADX INFO: renamed from: sort-4UcCI2c, reason: not valid java name */
    public static final void m317sort4UcCI2c(byte[] bArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sort");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, d.u.m414getSizeimpl(bArr));
        d1.m132sortArray4UcCI2c(bArr, i2, i3);
    }

    /* JADX INFO: renamed from: sort-4UcCI2c$default, reason: not valid java name */
    public static /* synthetic */ void m318sort4UcCI2c$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = d.u.m414getSizeimpl(bArr);
        }
        m317sort4UcCI2c(bArr, i2, i3);
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o, reason: not valid java name */
    public static final void m319sortAa5vz7o(short[] sArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sort");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, b0.m109getSizeimpl(sArr));
        d1.m133sortArrayAa5vz7o(sArr, i2, i3);
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o$default, reason: not valid java name */
    public static /* synthetic */ void m320sortAa5vz7o$default(short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = b0.m109getSizeimpl(sArr);
        }
        m319sortAa5vz7o(sArr, i2, i3);
    }

    /* JADX INFO: renamed from: sort-GBYM_sE, reason: not valid java name */
    public static final void m321sortGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sort");
        if (d.u.m414getSizeimpl(bArr) > 1) {
            d1.m132sortArray4UcCI2c(bArr, 0, d.u.m414getSizeimpl(bArr));
        }
    }

    /* JADX INFO: renamed from: sort-QwZRm1k, reason: not valid java name */
    public static final void m322sortQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sort");
        if (y.m462getSizeimpl(jArr) > 1) {
            d1.m131sortArraynroSd4(jArr, 0, y.m462getSizeimpl(jArr));
        }
    }

    /* JADX INFO: renamed from: sort-oBK06Vg, reason: not valid java name */
    public static final void m323sortoBK06Vg(int[] iArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sort");
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, w.m438getSizeimpl(iArr));
        d1.m134sortArrayoBK06Vg(iArr, i2, i3);
    }

    /* JADX INFO: renamed from: sort-oBK06Vg$default, reason: not valid java name */
    public static /* synthetic */ void m324sortoBK06Vg$default(int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = w.m438getSizeimpl(iArr);
        }
        m323sortoBK06Vg(iArr, i2, i3);
    }

    /* JADX INFO: renamed from: sort-rL5Bavg, reason: not valid java name */
    public static final void m325sortrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sort");
        if (b0.m109getSizeimpl(sArr) > 1) {
            d1.m133sortArrayAa5vz7o(sArr, 0, b0.m109getSizeimpl(sArr));
        }
    }

    /* JADX INFO: renamed from: sortDescending--ajY-9A, reason: not valid java name */
    public static final void m326sortDescendingajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortDescending");
        if (w.m438getSizeimpl(iArr) > 1) {
            m314sortajY9A(iArr);
            m.reverse(iArr);
        }
    }

    /* JADX INFO: renamed from: sortDescending--nroSd4, reason: not valid java name */
    public static final void m327sortDescendingnroSd4(long[] jArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortDescending");
        m315sortnroSd4(jArr, i2, i3);
        m.reverse(jArr, i2, i3);
    }

    /* JADX INFO: renamed from: sortDescending-4UcCI2c, reason: not valid java name */
    public static final void m328sortDescending4UcCI2c(byte[] bArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortDescending");
        m317sort4UcCI2c(bArr, i2, i3);
        m.reverse(bArr, i2, i3);
    }

    /* JADX INFO: renamed from: sortDescending-Aa5vz7o, reason: not valid java name */
    public static final void m329sortDescendingAa5vz7o(short[] sArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortDescending");
        m319sortAa5vz7o(sArr, i2, i3);
        m.reverse(sArr, i2, i3);
    }

    /* JADX INFO: renamed from: sortDescending-GBYM_sE, reason: not valid java name */
    public static final void m330sortDescendingGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortDescending");
        if (d.u.m414getSizeimpl(bArr) > 1) {
            m321sortGBYM_sE(bArr);
            m.reverse(bArr);
        }
    }

    /* JADX INFO: renamed from: sortDescending-QwZRm1k, reason: not valid java name */
    public static final void m331sortDescendingQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortDescending");
        if (y.m462getSizeimpl(jArr) > 1) {
            m322sortQwZRm1k(jArr);
            m.reverse(jArr);
        }
    }

    /* JADX INFO: renamed from: sortDescending-oBK06Vg, reason: not valid java name */
    public static final void m332sortDescendingoBK06Vg(int[] iArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortDescending");
        m323sortoBK06Vg(iArr, i2, i3);
        m.reverse(iArr, i2, i3);
    }

    /* JADX INFO: renamed from: sortDescending-rL5Bavg, reason: not valid java name */
    public static final void m333sortDescendingrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortDescending");
        if (b0.m109getSizeimpl(sArr) > 1) {
            m325sortrL5Bavg(sArr);
            m.reverse(sArr);
        }
    }

    /* JADX INFO: renamed from: sorted--ajY-9A, reason: not valid java name */
    public static final List<v> m334sortedajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sorted");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        int[] iArrM432constructorimpl = w.m432constructorimpl(iArrCopyOf);
        m314sortajY9A(iArrM432constructorimpl);
        return d.g0.j1.a.m142asListajY9A(iArrM432constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-GBYM_sE, reason: not valid java name */
    public static final List<t> m335sortedGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sorted");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] bArrM408constructorimpl = d.u.m408constructorimpl(bArrCopyOf);
        m321sortGBYM_sE(bArrM408constructorimpl);
        return d.g0.j1.a.m143asListGBYM_sE(bArrM408constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-QwZRm1k, reason: not valid java name */
    public static final List<x> m336sortedQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sorted");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        long[] jArrM456constructorimpl = y.m456constructorimpl(jArrCopyOf);
        m322sortQwZRm1k(jArrM456constructorimpl);
        return d.g0.j1.a.m144asListQwZRm1k(jArrM456constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-rL5Bavg, reason: not valid java name */
    public static final List<a0> m337sortedrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sorted");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        short[] sArrM103constructorimpl = b0.m103constructorimpl(sArrCopyOf);
        m325sortrL5Bavg(sArrM103constructorimpl);
        return d.g0.j1.a.m145asListrL5Bavg(sArrM103constructorimpl);
    }

    /* JADX INFO: renamed from: sortedArray--ajY-9A, reason: not valid java name */
    public static final int[] m338sortedArrayajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedArray");
        if (w.m440isEmptyimpl(iArr)) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        int[] iArrM432constructorimpl = w.m432constructorimpl(iArrCopyOf);
        m314sortajY9A(iArrM432constructorimpl);
        return iArrM432constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-GBYM_sE, reason: not valid java name */
    public static final byte[] m339sortedArrayGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedArray");
        if (d.u.m416isEmptyimpl(bArr)) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] bArrM408constructorimpl = d.u.m408constructorimpl(bArrCopyOf);
        m321sortGBYM_sE(bArrM408constructorimpl);
        return bArrM408constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-QwZRm1k, reason: not valid java name */
    public static final long[] m340sortedArrayQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedArray");
        if (y.m464isEmptyimpl(jArr)) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        long[] jArrM456constructorimpl = y.m456constructorimpl(jArrCopyOf);
        m322sortQwZRm1k(jArrM456constructorimpl);
        return jArrM456constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-rL5Bavg, reason: not valid java name */
    public static final short[] m341sortedArrayrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedArray");
        if (b0.m111isEmptyimpl(sArr)) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        short[] sArrM103constructorimpl = b0.m103constructorimpl(sArrCopyOf);
        m325sortrL5Bavg(sArrM103constructorimpl);
        return sArrM103constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending--ajY-9A, reason: not valid java name */
    public static final int[] m342sortedArrayDescendingajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedArrayDescending");
        if (w.m440isEmptyimpl(iArr)) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        int[] iArrM432constructorimpl = w.m432constructorimpl(iArrCopyOf);
        m326sortDescendingajY9A(iArrM432constructorimpl);
        return iArrM432constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-GBYM_sE, reason: not valid java name */
    public static final byte[] m343sortedArrayDescendingGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedArrayDescending");
        if (d.u.m416isEmptyimpl(bArr)) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] bArrM408constructorimpl = d.u.m408constructorimpl(bArrCopyOf);
        m330sortDescendingGBYM_sE(bArrM408constructorimpl);
        return bArrM408constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-QwZRm1k, reason: not valid java name */
    public static final long[] m344sortedArrayDescendingQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedArrayDescending");
        if (y.m464isEmptyimpl(jArr)) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        long[] jArrM456constructorimpl = y.m456constructorimpl(jArrCopyOf);
        m331sortDescendingQwZRm1k(jArrM456constructorimpl);
        return jArrM456constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-rL5Bavg, reason: not valid java name */
    public static final short[] m345sortedArrayDescendingrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedArrayDescending");
        if (b0.m111isEmptyimpl(sArr)) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        short[] sArrM103constructorimpl = b0.m103constructorimpl(sArrCopyOf);
        m333sortDescendingrL5Bavg(sArrM103constructorimpl);
        return sArrM103constructorimpl;
    }

    /* JADX INFO: renamed from: sortedDescending--ajY-9A, reason: not valid java name */
    public static final List<v> m346sortedDescendingajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        d.k0.d.t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        int[] iArrM432constructorimpl = w.m432constructorimpl(iArrCopyOf);
        m314sortajY9A(iArrM432constructorimpl);
        return m282reversedajY9A(iArrM432constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-GBYM_sE, reason: not valid java name */
    public static final List<t> m347sortedDescendingGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        d.k0.d.t.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] bArrM408constructorimpl = d.u.m408constructorimpl(bArrCopyOf);
        m321sortGBYM_sE(bArrM408constructorimpl);
        return m283reversedGBYM_sE(bArrM408constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-QwZRm1k, reason: not valid java name */
    public static final List<x> m348sortedDescendingQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        d.k0.d.t.checkNotNullExpressionValue(jArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        long[] jArrM456constructorimpl = y.m456constructorimpl(jArrCopyOf);
        m322sortQwZRm1k(jArrM456constructorimpl);
        return m284reversedQwZRm1k(jArrM456constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-rL5Bavg, reason: not valid java name */
    public static final List<a0> m349sortedDescendingrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        d.k0.d.t.checkNotNullExpressionValue(sArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        short[] sArrM103constructorimpl = b0.m103constructorimpl(sArrCopyOf);
        m325sortrL5Bavg(sArrM103constructorimpl);
        return m285reversedrL5Bavg(sArrM103constructorimpl);
    }

    public static final int sumOfUByte(t[] tVarArr) {
        d.k0.d.t.checkNotNullParameter(tVarArr, "$this$sum");
        int iM424constructorimpl = 0;
        for (t tVar : tVarArr) {
            iM424constructorimpl = v.m424constructorimpl(iM424constructorimpl + v.m424constructorimpl(tVar.m405unboximpl() & 255));
        }
        return iM424constructorimpl;
    }

    public static final int sumOfUInt(v[] vVarArr) {
        d.k0.d.t.checkNotNullParameter(vVarArr, "$this$sum");
        int iM424constructorimpl = 0;
        for (v vVar : vVarArr) {
            iM424constructorimpl = v.m424constructorimpl(iM424constructorimpl + vVar.m429unboximpl());
        }
        return iM424constructorimpl;
    }

    public static final long sumOfULong(x[] xVarArr) {
        d.k0.d.t.checkNotNullParameter(xVarArr, "$this$sum");
        long jM448constructorimpl = 0;
        for (x xVar : xVarArr) {
            jM448constructorimpl = x.m448constructorimpl(jM448constructorimpl + xVar.m453unboximpl());
        }
        return jM448constructorimpl;
    }

    public static final int sumOfUShort(a0[] a0VarArr) {
        d.k0.d.t.checkNotNullParameter(a0VarArr, "$this$sum");
        int iM424constructorimpl = 0;
        for (a0 a0Var : a0VarArr) {
            iM424constructorimpl = v.m424constructorimpl(iM424constructorimpl + v.m424constructorimpl(a0Var.m100unboximpl() & 65535));
        }
        return iM424constructorimpl;
    }

    /* JADX INFO: renamed from: take-PpDY95g, reason: not valid java name */
    public static final List<t> m350takePpDY95g(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        if (i2 >= d.u.m414getSizeimpl(bArr)) {
            return d.g0.a0.toList(d.u.m406boximpl(bArr));
        }
        if (i2 == 1) {
            return r.listOf(t.m399boximpl(d.u.m413getw2LRezQ(bArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (byte b2 : bArr) {
            arrayList.add(t.m399boximpl(b2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-nggk6HY, reason: not valid java name */
    public static final List<a0> m351takenggk6HY(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        if (i2 >= b0.m109getSizeimpl(sArr)) {
            return d.g0.a0.toList(b0.m101boximpl(sArr));
        }
        if (i2 == 1) {
            return r.listOf(a0.m94boximpl(b0.m108getMh2AYeg(sArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (short s : sArr) {
            arrayList.add(a0.m94boximpl(s));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-qFRl0hI, reason: not valid java name */
    public static final List<v> m352takeqFRl0hI(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        if (i2 >= w.m438getSizeimpl(iArr)) {
            return d.g0.a0.toList(w.m430boximpl(iArr));
        }
        if (i2 == 1) {
            return r.listOf(v.m423boximpl(w.m437getpVg5ArA(iArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (int i4 : iArr) {
            arrayList.add(v.m423boximpl(i4));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-r7IrZao, reason: not valid java name */
    public static final List<x> m353taker7IrZao(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        if (i2 >= y.m462getSizeimpl(jArr)) {
            return d.g0.a0.toList(y.m454boximpl(jArr));
        }
        if (i2 == 1) {
            return r.listOf(x.m447boximpl(y.m461getsVKNKU(jArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (long j : jArr) {
            arrayList.add(x.m447boximpl(j));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-PpDY95g, reason: not valid java name */
    public static final List<t> m354takeLastPpDY95g(byte[] bArr, int i2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        int iM414getSizeimpl = d.u.m414getSizeimpl(bArr);
        if (i2 >= iM414getSizeimpl) {
            return d.g0.a0.toList(d.u.m406boximpl(bArr));
        }
        if (i2 == 1) {
            return r.listOf(t.m399boximpl(d.u.m413getw2LRezQ(bArr, iM414getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = iM414getSizeimpl - i2; i3 < iM414getSizeimpl; i3++) {
            arrayList.add(t.m399boximpl(d.u.m413getw2LRezQ(bArr, i3)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-nggk6HY, reason: not valid java name */
    public static final List<a0> m355takeLastnggk6HY(short[] sArr, int i2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        int iM109getSizeimpl = b0.m109getSizeimpl(sArr);
        if (i2 >= iM109getSizeimpl) {
            return d.g0.a0.toList(b0.m101boximpl(sArr));
        }
        if (i2 == 1) {
            return r.listOf(a0.m94boximpl(b0.m108getMh2AYeg(sArr, iM109getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = iM109getSizeimpl - i2; i3 < iM109getSizeimpl; i3++) {
            arrayList.add(a0.m94boximpl(b0.m108getMh2AYeg(sArr, i3)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-qFRl0hI, reason: not valid java name */
    public static final List<v> m356takeLastqFRl0hI(int[] iArr, int i2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        int iM438getSizeimpl = w.m438getSizeimpl(iArr);
        if (i2 >= iM438getSizeimpl) {
            return d.g0.a0.toList(w.m430boximpl(iArr));
        }
        if (i2 == 1) {
            return r.listOf(v.m423boximpl(w.m437getpVg5ArA(iArr, iM438getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = iM438getSizeimpl - i2; i3 < iM438getSizeimpl; i3++) {
            arrayList.add(v.m423boximpl(w.m437getpVg5ArA(iArr, i3)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-r7IrZao, reason: not valid java name */
    public static final List<x> m357takeLastr7IrZao(long[] jArr, int i2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        int iM462getSizeimpl = y.m462getSizeimpl(jArr);
        if (i2 >= iM462getSizeimpl) {
            return d.g0.a0.toList(y.m454boximpl(jArr));
        }
        if (i2 == 1) {
            return r.listOf(x.m447boximpl(y.m461getsVKNKU(jArr, iM462getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = iM462getSizeimpl - i2; i3 < iM462getSizeimpl; i3++) {
            arrayList.add(x.m447boximpl(y.m461getsVKNKU(jArr, i3)));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final v[] m358toTypedArrayajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$toTypedArray");
        int iM438getSizeimpl = w.m438getSizeimpl(iArr);
        v[] vVarArr = new v[iM438getSizeimpl];
        for (int i2 = 0; i2 < iM438getSizeimpl; i2++) {
            vVarArr[i2] = v.m423boximpl(w.m437getpVg5ArA(iArr, i2));
        }
        return vVarArr;
    }

    /* JADX INFO: renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final t[] m359toTypedArrayGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$toTypedArray");
        int iM414getSizeimpl = d.u.m414getSizeimpl(bArr);
        t[] tVarArr = new t[iM414getSizeimpl];
        for (int i2 = 0; i2 < iM414getSizeimpl; i2++) {
            tVarArr[i2] = t.m399boximpl(d.u.m413getw2LRezQ(bArr, i2));
        }
        return tVarArr;
    }

    /* JADX INFO: renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final x[] m360toTypedArrayQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$toTypedArray");
        int iM462getSizeimpl = y.m462getSizeimpl(jArr);
        x[] xVarArr = new x[iM462getSizeimpl];
        for (int i2 = 0; i2 < iM462getSizeimpl; i2++) {
            xVarArr[i2] = x.m447boximpl(y.m461getsVKNKU(jArr, i2));
        }
        return xVarArr;
    }

    /* JADX INFO: renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final a0[] m361toTypedArrayrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$toTypedArray");
        int iM109getSizeimpl = b0.m109getSizeimpl(sArr);
        a0[] a0VarArr = new a0[iM109getSizeimpl];
        for (int i2 = 0; i2 < iM109getSizeimpl; i2++) {
            a0VarArr[i2] = a0.m94boximpl(b0.m108getMh2AYeg(sArr, i2));
        }
        return a0VarArr;
    }

    public static final byte[] toUByteArray(t[] tVarArr) {
        d.k0.d.t.checkNotNullParameter(tVarArr, "$this$toUByteArray");
        int length = tVarArr.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = tVarArr[i2].m405unboximpl();
        }
        return d.u.m408constructorimpl(bArr);
    }

    public static final int[] toUIntArray(v[] vVarArr) {
        d.k0.d.t.checkNotNullParameter(vVarArr, "$this$toUIntArray");
        int length = vVarArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = vVarArr[i2].m429unboximpl();
        }
        return w.m432constructorimpl(iArr);
    }

    public static final long[] toULongArray(x[] xVarArr) {
        d.k0.d.t.checkNotNullParameter(xVarArr, "$this$toULongArray");
        int length = xVarArr.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = xVarArr[i2].m453unboximpl();
        }
        return y.m456constructorimpl(jArr);
    }

    public static final short[] toUShortArray(a0[] a0VarArr) {
        d.k0.d.t.checkNotNullParameter(a0VarArr, "$this$toUShortArray");
        int length = a0VarArr.length;
        short[] sArr = new short[length];
        for (int i2 = 0; i2 < length; i2++) {
            sArr[i2] = a0VarArr[i2].m100unboximpl();
        }
        return b0.m103constructorimpl(sArr);
    }

    /* JADX INFO: renamed from: withIndex--ajY-9A, reason: not valid java name */
    public static final Iterable<i0<v>> m362withIndexajY9A(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$withIndex");
        return new j0(new a(iArr));
    }

    /* JADX INFO: renamed from: withIndex-GBYM_sE, reason: not valid java name */
    public static final Iterable<i0<t>> m363withIndexGBYM_sE(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$withIndex");
        return new j0(new c(bArr));
    }

    /* JADX INFO: renamed from: withIndex-QwZRm1k, reason: not valid java name */
    public static final Iterable<i0<x>> m364withIndexQwZRm1k(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$withIndex");
        return new j0(new C0235b(jArr));
    }

    /* JADX INFO: renamed from: withIndex-rL5Bavg, reason: not valid java name */
    public static final Iterable<i0<a0>> m365withIndexrL5Bavg(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$withIndex");
        return new j0(new d(sArr));
    }

    /* JADX INFO: renamed from: zip-C-E_24M, reason: not valid java name */
    public static final <R> List<d.m<v, R>> m366zipCE_24M(int[] iArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(w.m438getSizeimpl(iArr), rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            int iM437getpVg5ArA = w.m437getpVg5ArA(iArr, i2);
            arrayList.add(d.s.to(v.m423boximpl(iM437getpVg5ArA), rArr[i2]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-F7u83W8, reason: not valid java name */
    public static final <R> List<d.m<x, R>> m367zipF7u83W8(long[] jArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int iM462getSizeimpl = y.m462getSizeimpl(jArr);
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), iM462getSizeimpl));
        int i2 = 0;
        for (R r : iterable) {
            if (i2 >= iM462getSizeimpl) {
                break;
            }
            arrayList.add(d.s.to(x.m447boximpl(y.m461getsVKNKU(jArr, i2)), r));
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-HwE9HBo, reason: not valid java name */
    public static final <R> List<d.m<v, R>> m368zipHwE9HBo(int[] iArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int iM438getSizeimpl = w.m438getSizeimpl(iArr);
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), iM438getSizeimpl));
        int i2 = 0;
        for (R r : iterable) {
            if (i2 >= iM438getSizeimpl) {
                break;
            }
            arrayList.add(d.s.to(v.m423boximpl(w.m437getpVg5ArA(iArr, i2)), r));
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JGPC0-M, reason: not valid java name */
    public static final <R> List<d.m<a0, R>> m369zipJGPC0M(short[] sArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int iM109getSizeimpl = b0.m109getSizeimpl(sArr);
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), iM109getSizeimpl));
        int i2 = 0;
        for (R r : iterable) {
            if (i2 >= iM109getSizeimpl) {
                break;
            }
            arrayList.add(d.s.to(a0.m94boximpl(b0.m108getMh2AYeg(sArr, i2)), r));
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JQknh5Q, reason: not valid java name */
    public static final <R> List<d.m<t, R>> m370zipJQknh5Q(byte[] bArr, Iterable<? extends R> iterable) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable, "other");
        int iM414getSizeimpl = d.u.m414getSizeimpl(bArr);
        ArrayList arrayList = new ArrayList(Math.min(d.g0.t.collectionSizeOrDefault(iterable, 10), iM414getSizeimpl));
        int i2 = 0;
        for (R r : iterable) {
            if (i2 >= iM414getSizeimpl) {
                break;
            }
            arrayList.add(d.s.to(t.m399boximpl(d.u.m413getw2LRezQ(bArr, i2)), r));
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ctEhBpI, reason: not valid java name */
    public static final List<d.m<v, v>> m371zipctEhBpI(int[] iArr, int[] iArr2) {
        d.k0.d.t.checkNotNullParameter(iArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iArr2, "other");
        int iMin = Math.min(w.m438getSizeimpl(iArr), w.m438getSizeimpl(iArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(v.m423boximpl(w.m437getpVg5ArA(iArr, i2)), v.m423boximpl(w.m437getpVg5ArA(iArr2, i2))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-f7H3mmw, reason: not valid java name */
    public static final <R> List<d.m<x, R>> m372zipf7H3mmw(long[] jArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(y.m462getSizeimpl(jArr), rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            long jM461getsVKNKU = y.m461getsVKNKU(jArr, i2);
            arrayList.add(d.s.to(x.m447boximpl(jM461getsVKNKU), rArr[i2]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-kdPth3s, reason: not valid java name */
    public static final List<d.m<t, t>> m373zipkdPth3s(byte[] bArr, byte[] bArr2) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(bArr2, "other");
        int iMin = Math.min(d.u.m414getSizeimpl(bArr), d.u.m414getSizeimpl(bArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(t.m399boximpl(d.u.m413getw2LRezQ(bArr, i2)), t.m399boximpl(d.u.m413getw2LRezQ(bArr2, i2))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-mazbYpA, reason: not valid java name */
    public static final List<d.m<a0, a0>> m374zipmazbYpA(short[] sArr, short[] sArr2) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(sArr2, "other");
        int iMin = Math.min(b0.m109getSizeimpl(sArr), b0.m109getSizeimpl(sArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(a0.m94boximpl(b0.m108getMh2AYeg(sArr, i2)), a0.m94boximpl(b0.m108getMh2AYeg(sArr2, i2))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-nl983wc, reason: not valid java name */
    public static final <R> List<d.m<t, R>> m375zipnl983wc(byte[] bArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(d.u.m414getSizeimpl(bArr), rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            byte bM413getw2LRezQ = d.u.m413getw2LRezQ(bArr, i2);
            arrayList.add(d.s.to(t.m399boximpl(bM413getw2LRezQ), rArr[i2]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-uaTIQ5s, reason: not valid java name */
    public static final <R> List<d.m<a0, R>> m376zipuaTIQ5s(short[] sArr, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(b0.m109getSizeimpl(sArr), rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            short sM108getMh2AYeg = b0.m108getMh2AYeg(sArr, i2);
            arrayList.add(d.s.to(a0.m94boximpl(sM108getMh2AYeg), rArr[i2]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-us8wMrg, reason: not valid java name */
    public static final List<d.m<x, x>> m377zipus8wMrg(long[] jArr, long[] jArr2) {
        d.k0.d.t.checkNotNullParameter(jArr, "$this$zip");
        d.k0.d.t.checkNotNullParameter(jArr2, "other");
        int iMin = Math.min(y.m462getSizeimpl(jArr), y.m462getSizeimpl(jArr2));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(d.s.to(x.m447boximpl(y.m461getsVKNKU(jArr, i2)), x.m447boximpl(y.m461getsVKNKU(jArr2, i2))));
        }
        return arrayList;
    }
}
