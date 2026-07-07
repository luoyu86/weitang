package d.g0;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @d.i0.f.a.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    public static final class a<T> extends d.i0.f.a.k implements d.k0.c.p<d.o0.o<? super List<? extends T>>, d.i0.a<? super d.d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12439d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f12440e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12441f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12442g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f12443h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f12444i;
        public final /* synthetic */ Iterator j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ boolean l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, int i3, Iterator it, boolean z, boolean z2, d.i0.a aVar) {
            super(2, aVar);
            this.f12443h = i2;
            this.f12444i = i3;
            this.j = it;
            this.k = z;
            this.l = z2;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d.d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            a aVar2 = new a(this.f12443h, this.f12444i, this.j, this.k, this.l, aVar);
            aVar2.f12438c = obj;
            return aVar2;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d.d0> aVar) {
            return ((a) create(obj, aVar)).invokeSuspend(d.d0.f12421a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v20, types: [d.g0.a, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r1v21, types: [d.g0.x0] */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5, types: [d.o0.o, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v17 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v3, types: [d.g0.a, d.g0.x0, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5, types: [d.g0.x0] */
        /* JADX WARN: Type inference failed for: r5v6, types: [d.g0.x0] */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v8, types: [d.o0.o, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please report as a decompilation issue!!! */
        @Override // d.i0.f.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 363
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: d.g0.b1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements d.o0.m<List<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f12448d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f12449e;

        public b(d.o0.m mVar, int i2, int i3, boolean z, boolean z2) {
            this.f12445a = mVar;
            this.f12446b = i2;
            this.f12447c = i3;
            this.f12448d = z;
            this.f12449e = z2;
        }

        @Override // d.o0.m
        public Iterator<List<? extends T>> iterator() {
            return b1.windowedIterator(this.f12445a.iterator(), this.f12446b, this.f12447c, this.f12448d, this.f12449e);
        }
    }

    public static final void checkWindowSizeStep(int i2, int i3) {
        String str;
        if (i2 > 0 && i3 > 0) {
            return;
        }
        if (i2 != i3) {
            str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
        } else {
            str = "size " + i2 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int i2, int i3, boolean z, boolean z2) {
        d.k0.d.t.checkNotNullParameter(it, "iterator");
        return !it.hasNext() ? c0.f12452a : d.o0.p.iterator(new a(i2, i3, it, z2, z, null));
    }

    public static final <T> d.o0.m<List<T>> windowedSequence(d.o0.m<? extends T> mVar, int i2, int i3, boolean z, boolean z2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$windowedSequence");
        checkWindowSizeStep(i2, i3);
        return new b(mVar, i2, i3, z, z2);
    }
}
