package d.p0;

import com.chinavisionary.microtang.comment.vo.ScoresBean;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements d.o0.m<d.m0.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f12906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d.k0.c.p<CharSequence, Integer, d.m<Integer, Integer>> f12909d;

    public static final class a implements Iterator<d.m0.k>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12910a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d.m0.k f12913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12914e;

        public a() {
            int iCoerceIn = d.m0.p.coerceIn(f.this.f12907b, 0, f.this.f12906a.length());
            this.f12911b = iCoerceIn;
            this.f12912c = iCoerceIn;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r6 = this;
                int r0 = r6.f12912c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f12910a = r1
                r0 = 0
                r6.f12913d = r0
                goto L9e
            Lc:
                d.p0.f r0 = d.p0.f.this
                int r0 = d.p0.f.access$getLimit$p(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f12914e
                int r0 = r0 + r3
                r6.f12914e = r0
                d.p0.f r4 = d.p0.f.this
                int r4 = d.p0.f.access$getLimit$p(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f12912c
                d.p0.f r4 = d.p0.f.this
                java.lang.CharSequence r4 = d.p0.f.access$getInput$p(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                int r0 = r6.f12911b
                d.m0.k r1 = new d.m0.k
                d.p0.f r4 = d.p0.f.this
                java.lang.CharSequence r4 = d.p0.f.access$getInput$p(r4)
                int r4 = d.p0.y.getLastIndex(r4)
                r1.<init>(r0, r4)
                r6.f12913d = r1
                r6.f12912c = r2
                goto L9c
            L47:
                d.p0.f r0 = d.p0.f.this
                d.k0.c.p r0 = d.p0.f.access$getGetNextMatch$p(r0)
                d.p0.f r4 = d.p0.f.this
                java.lang.CharSequence r4 = d.p0.f.access$getInput$p(r4)
                int r5 = r6.f12912c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                d.m r0 = (d.m) r0
                if (r0 != 0) goto L77
                int r0 = r6.f12911b
                d.m0.k r1 = new d.m0.k
                d.p0.f r4 = d.p0.f.this
                java.lang.CharSequence r4 = d.p0.f.access$getInput$p(r4)
                int r4 = d.p0.y.getLastIndex(r4)
                r1.<init>(r0, r4)
                r6.f12913d = r1
                r6.f12912c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f12911b
                d.m0.k r4 = d.m0.p.until(r4, r2)
                r6.f12913d = r4
                int r2 = r2 + r0
                r6.f12911b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f12912c = r2
            L9c:
                r6.f12910a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.p0.f.a.a():void");
        }

        public final int getCounter() {
            return this.f12914e;
        }

        public final int getCurrentStartIndex() {
            return this.f12911b;
        }

        public final d.m0.k getNextItem() {
            return this.f12913d;
        }

        public final int getNextSearchIndex() {
            return this.f12912c;
        }

        public final int getNextState() {
            return this.f12910a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12910a == -1) {
                a();
            }
            return this.f12910a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setCounter(int i2) {
            this.f12914e = i2;
        }

        public final void setCurrentStartIndex(int i2) {
            this.f12911b = i2;
        }

        public final void setNextItem(d.m0.k kVar) {
            this.f12913d = kVar;
        }

        public final void setNextSearchIndex(int i2) {
            this.f12912c = i2;
        }

        public final void setNextState(int i2) {
            this.f12910a = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public d.m0.k next() {
            if (this.f12910a == -1) {
                a();
            }
            if (this.f12910a == 0) {
                throw new NoSuchElementException();
            }
            d.m0.k kVar = this.f12913d;
            Objects.requireNonNull(kVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f12913d = null;
            this.f12910a = -1;
            return kVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(CharSequence charSequence, int i2, int i3, d.k0.c.p<? super CharSequence, ? super Integer, d.m<Integer, Integer>> pVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        d.k0.d.t.checkNotNullParameter(pVar, "getNextMatch");
        this.f12906a = charSequence;
        this.f12907b = i2;
        this.f12908c = i3;
        this.f12909d = pVar;
    }

    @Override // d.o0.m
    public Iterator<d.m0.k> iterator() {
        return new a();
    }
}
