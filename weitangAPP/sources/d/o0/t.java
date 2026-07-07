package d.o0;

import com.alibaba.mtl.appmonitor.AppMonitorDelegate;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import d.d0;
import d.g0.b1;
import d.g0.h0;
import d.g0.i0;
import d.g0.z0;
import d.k0.d.e0;
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
public class t extends d.o0.s {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12793a;

        public a(d.o0.m mVar) {
            this.f12793a = mVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f12793a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a0<T> extends d.k0.d.u implements d.k0.c.p<T, T, d.m<? extends T, ? extends T>> {
        public static final a0 INSTANCE = new a0();

        public a0() {
            super(2);
        }

        @Override // d.k0.c.p
        public final d.m<T, T> invoke(T t, T t2) {
            return d.s.to(t, t2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends d.k0.d.u implements d.k0.c.l<T, T> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // d.k0.c.l
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @d.i0.f.a.f(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2666}, m = "invokeSuspend", n = {"$this$result", "iterator", "next"}, s = {"L$0", "L$1", "L$2"})
    public static final class b0<R> extends d.i0.f.a.k implements d.k0.c.p<d.o0.o<? super R>, d.i0.a<? super d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f12796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12797f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12798g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.p f12799h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(d.o0.m mVar, d.k0.c.p pVar, d.i0.a aVar) {
            super(2, aVar);
            this.f12798g = mVar;
            this.f12799h = pVar;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            b0 b0Var = new b0(this.f12798g, this.f12799h, aVar);
            b0Var.f12794c = obj;
            return b0Var;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d0> aVar) {
            return ((b0) create(obj, aVar)).invokeSuspend(d0.f12421a);
        }

        @Override // d.i0.f.a.a
        public final Object invokeSuspend(Object obj) {
            d.o0.o oVar;
            Object next;
            Iterator it;
            Object coroutine_suspended = d.i0.e.c.getCOROUTINE_SUSPENDED();
            int i2 = this.f12797f;
            if (i2 == 0) {
                d.o.throwOnFailure(obj);
                d.o0.o oVar2 = (d.o0.o) this.f12794c;
                Iterator it2 = this.f12798g.iterator();
                if (!it2.hasNext()) {
                    return d0.f12421a;
                }
                oVar = oVar2;
                next = it2.next();
                it = it2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj2 = this.f12796e;
                it = (Iterator) this.f12795d;
                oVar = (d.o0.o) this.f12794c;
                d.o.throwOnFailure(obj);
                next = obj2;
            }
            while (it.hasNext()) {
                Object next2 = it.next();
                Object objInvoke = this.f12799h.invoke(next, next2);
                this.f12794c = oVar;
                this.f12795d = it;
                this.f12796e = next2;
                this.f12797f = 1;
                if (oVar.yield(objInvoke, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                next = next2;
            }
            return d0.f12421a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> extends d.k0.d.u implements d.k0.c.l<Integer, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12800b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2) {
            super(1);
            this.f12800b = i2;
        }

        public final T invoke(int i2) {
            throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.f12800b + '.');
        }

        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> extends d.k0.d.u implements d.k0.c.l<i0<? extends T>, Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.p f12801b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d.k0.c.p pVar) {
            super(1);
            this.f12801b = pVar;
        }

        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((i0) obj));
        }

        public final boolean invoke(i0<? extends T> i0Var) {
            d.k0.d.t.checkNotNullParameter(i0Var, "it");
            return ((Boolean) this.f12801b.invoke(Integer.valueOf(i0Var.getIndex()), i0Var.getValue())).booleanValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class e<T> extends d.k0.d.u implements d.k0.c.l<i0<? extends T>, T> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // d.k0.c.l
        public final T invoke(i0<? extends T> i0Var) {
            d.k0.d.t.checkNotNullParameter(i0Var, "it");
            return i0Var.getValue();
        }
    }

    public static final class f extends d.k0.d.u implements d.k0.c.l<Object, Boolean> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Object obj) {
            d.k0.d.t.reifiedOperationMarker(3, "R");
            return obj instanceof Object;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class g<T> extends d.k0.d.u implements d.k0.c.l<T, Boolean> {
        public static final g INSTANCE = new g();

        public g() {
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(T t) {
            return t == null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final /* synthetic */ class h<R> extends d.k0.d.s implements d.k0.c.l<Iterable<? extends R>, Iterator<? extends R>> {
        public static final h INSTANCE = new h();

        public h() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // d.k0.c.l
        public final Iterator<R> invoke(Iterable<? extends R> iterable) {
            d.k0.d.t.checkNotNullParameter(iterable, "p1");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final /* synthetic */ class i<R> extends d.k0.d.s implements d.k0.c.l<d.o0.m<? extends R>, Iterator<? extends R>> {
        public static final i INSTANCE = new i();

        public i() {
            super(1, d.o0.m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // d.k0.c.l
        public final Iterator<R> invoke(d.o0.m<? extends R> mVar) {
            d.k0.d.t.checkNotNullParameter(mVar, "p1");
            return mVar.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final /* synthetic */ class j<R> extends d.k0.d.s implements d.k0.c.l<Iterable<? extends R>, Iterator<? extends R>> {
        public static final j INSTANCE = new j();

        public j() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // d.k0.c.l
        public final Iterator<R> invoke(Iterable<? extends R> iterable) {
            d.k0.d.t.checkNotNullParameter(iterable, "p1");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final /* synthetic */ class k<R> extends d.k0.d.s implements d.k0.c.l<d.o0.m<? extends R>, Iterator<? extends R>> {
        public static final k INSTANCE = new k();

        public k() {
            super(1, d.o0.m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // d.k0.c.l
        public final Iterator<R> invoke(d.o0.m<? extends R> mVar) {
            d.k0.d.t.checkNotNullParameter(mVar, "p1");
            return mVar.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public static final class l<K, T> implements h0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.l f12803b;

        public l(d.o0.m<? extends T> mVar, d.k0.c.l lVar) {
            this.f12802a = mVar;
            this.f12803b = lVar;
        }

        @Override // d.g0.h0
        public K keyOf(T t) {
            return (K) this.f12803b.invoke(t);
        }

        @Override // d.g0.h0
        public Iterator<T> sourceIterator() {
            return this.f12802a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class m<T> implements d.o0.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f12805b;

        public static final class a extends d.k0.d.u implements d.k0.c.l<T, Boolean> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e0 f12807c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e0 e0Var) {
                super(1);
                this.f12807c = e0Var;
            }

            @Override // d.k0.c.l
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke2(obj));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(T t) {
                if (this.f12807c.element || !d.k0.d.t.areEqual(t, m.this.f12805b)) {
                    return true;
                }
                this.f12807c.element = true;
                return false;
            }
        }

        public m(d.o0.m<? extends T> mVar, Object obj) {
            this.f12804a = mVar;
            this.f12805b = obj;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            e0 e0Var = new e0();
            e0Var.element = false;
            return t.filter(this.f12804a, new a(e0Var)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class n<T> implements d.o0.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object[] f12809b;

        public static final class a extends d.k0.d.u implements d.k0.c.l<T, Boolean> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HashSet f12810b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(HashSet hashSet) {
                super(1);
                this.f12810b = hashSet;
            }

            @Override // d.k0.c.l
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke2(obj));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(T t) {
                return this.f12810b.contains(t);
            }
        }

        public n(d.o0.m<? extends T> mVar, Object[] objArr) {
            this.f12808a = mVar;
            this.f12809b = objArr;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            return t.filterNot(this.f12808a, new a(d.g0.m.toHashSet(this.f12809b))).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class o<T> implements d.o0.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f12812b;

        public static final class a extends d.k0.d.u implements d.k0.c.l<T, Boolean> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Collection f12813b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Collection collection) {
                super(1);
                this.f12813b = collection;
            }

            @Override // d.k0.c.l
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke2(obj));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(T t) {
                return this.f12813b.contains(t);
            }
        }

        public o(d.o0.m<? extends T> mVar, Iterable iterable) {
            this.f12811a = mVar;
            this.f12812b = iterable;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            Collection collectionConvertToSetForSetOperation = d.g0.t.convertToSetForSetOperation(this.f12812b);
            return collectionConvertToSetForSetOperation.isEmpty() ? this.f12811a.iterator() : t.filterNot(this.f12811a, new a(collectionConvertToSetForSetOperation)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class p<T> implements d.o0.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12815b;

        public static final class a extends d.k0.d.u implements d.k0.c.l<T, Boolean> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HashSet f12816b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(HashSet hashSet) {
                super(1);
                this.f12816b = hashSet;
            }

            @Override // d.k0.c.l
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke2(obj));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(T t) {
                return this.f12816b.contains(t);
            }
        }

        public p(d.o0.m<? extends T> mVar, d.o0.m mVar2) {
            this.f12814a = mVar;
            this.f12815b = mVar2;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            HashSet hashSet = t.toHashSet(this.f12815b);
            return hashSet.isEmpty() ? this.f12814a.iterator() : t.filterNot(this.f12814a, new a(hashSet)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class q<T> extends d.k0.d.u implements d.k0.c.l<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.l f12817b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(d.k0.c.l lVar) {
            super(1);
            this.f12817b = lVar;
        }

        @Override // d.k0.c.l
        public final T invoke(T t) {
            this.f12817b.invoke(t);
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class r<T> extends d.k0.d.u implements d.k0.c.p<Integer, T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.p f12818b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(d.k0.c.p pVar) {
            super(2);
            this.f12818b = pVar;
        }

        public final T invoke(int i2, T t) {
            this.f12818b.invoke(Integer.valueOf(i2), t);
            return t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.k0.c.p
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
            return invoke(num.intValue(), obj);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class s<T> extends d.k0.d.u implements d.k0.c.l<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12819b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(d.o0.m mVar) {
            super(1);
            this.f12819b = mVar;
        }

        @Override // d.k0.c.l
        public final T invoke(T t) {
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException("null element found in " + this.f12819b + '.');
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: d.o0.t$t, reason: collision with other inner class name */
    @d.i0.f.a.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2081, 2085}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
    public static final class C0241t<R> extends d.i0.f.a.k implements d.k0.c.p<d.o0.o<? super R>, d.i0.a<? super d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f12822e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12823f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12824g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Object f12825h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.p f12826i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0241t(d.o0.m mVar, Object obj, d.k0.c.p pVar, d.i0.a aVar) {
            super(2, aVar);
            this.f12824g = mVar;
            this.f12825h = obj;
            this.f12826i = pVar;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            C0241t c0241t = new C0241t(this.f12824g, this.f12825h, this.f12826i, aVar);
            c0241t.f12820c = obj;
            return c0241t;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d0> aVar) {
            return ((C0241t) create(obj, aVar)).invokeSuspend(d0.f12421a);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
        @Override // d.i0.f.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = d.i0.e.c.getCOROUTINE_SUSPENDED()
                int r1 = r7.f12823f
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2d
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r7.f12822e
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r3 = r7.f12821d
                java.lang.Object r4 = r7.f12820c
                d.o0.o r4 = (d.o0.o) r4
                d.o.throwOnFailure(r8)
                r8 = r3
                goto L4c
            L1d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L25:
                java.lang.Object r1 = r7.f12820c
                d.o0.o r1 = (d.o0.o) r1
                d.o.throwOnFailure(r8)
                goto L42
            L2d:
                d.o.throwOnFailure(r8)
                java.lang.Object r8 = r7.f12820c
                r1 = r8
                d.o0.o r1 = (d.o0.o) r1
                java.lang.Object r8 = r7.f12825h
                r7.f12820c = r1
                r7.f12823f = r3
                java.lang.Object r8 = r1.yield(r8, r7)
                if (r8 != r0) goto L42
                return r0
            L42:
                java.lang.Object r8 = r7.f12825h
                d.o0.m r3 = r7.f12824g
                java.util.Iterator r3 = r3.iterator()
                r4 = r1
                r1 = r3
            L4c:
                r3 = r7
            L4d:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L6c
                java.lang.Object r5 = r1.next()
                d.k0.c.p r6 = r3.f12826i
                java.lang.Object r8 = r6.invoke(r8, r5)
                r3.f12820c = r4
                r3.f12821d = r8
                r3.f12822e = r1
                r3.f12823f = r2
                java.lang.Object r5 = r4.yield(r8, r3)
                if (r5 != r0) goto L4d
                return r0
            L6c:
                d.d0 r8 = d.d0.f12421a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: d.o0.t.C0241t.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @d.i0.f.a.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2109, 2114}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
    public static final class u<R> extends d.i0.f.a.k implements d.k0.c.p<d.o0.o<? super R>, d.i0.a<? super d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12828d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f12829e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12830f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12831g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12832h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Object f12833i;
        public final /* synthetic */ d.k0.c.q j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(d.o0.m mVar, Object obj, d.k0.c.q qVar, d.i0.a aVar) {
            super(2, aVar);
            this.f12832h = mVar;
            this.f12833i = obj;
            this.j = qVar;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            u uVar = new u(this.f12832h, this.f12833i, this.j, aVar);
            uVar.f12827c = obj;
            return uVar;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d0> aVar) {
            return ((u) create(obj, aVar)).invokeSuspend(d0.f12421a);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
        @Override // d.i0.f.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = d.i0.e.c.getCOROUTINE_SUSPENDED()
                int r1 = r9.f12831g
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L30
                if (r1 == r3) goto L28
                if (r1 != r2) goto L20
                int r1 = r9.f12830f
                java.lang.Object r3 = r9.f12829e
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r9.f12828d
                java.lang.Object r5 = r9.f12827c
                d.o0.o r5 = (d.o0.o) r5
                d.o.throwOnFailure(r10)
                r10 = r1
                r1 = r4
                goto L51
            L20:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L28:
                java.lang.Object r1 = r9.f12827c
                d.o0.o r1 = (d.o0.o) r1
                d.o.throwOnFailure(r10)
                goto L45
            L30:
                d.o.throwOnFailure(r10)
                java.lang.Object r10 = r9.f12827c
                r1 = r10
                d.o0.o r1 = (d.o0.o) r1
                java.lang.Object r10 = r9.f12833i
                r9.f12827c = r1
                r9.f12831g = r3
                java.lang.Object r10 = r1.yield(r10, r9)
                if (r10 != r0) goto L45
                return r0
            L45:
                r10 = 0
                java.lang.Object r3 = r9.f12833i
                d.o0.m r4 = r9.f12832h
                java.util.Iterator r4 = r4.iterator()
                r5 = r1
                r1 = r3
                r3 = r4
            L51:
                r4 = r9
            L52:
                boolean r6 = r3.hasNext()
                if (r6 == 0) goto L81
                java.lang.Object r6 = r3.next()
                d.k0.c.q r7 = r4.j
                int r8 = r10 + 1
                if (r10 >= 0) goto L65
                d.g0.s.throwIndexOverflow()
            L65:
                java.lang.Integer r10 = d.i0.f.a.b.boxInt(r10)
                java.lang.Object r10 = r7.invoke(r10, r1, r6)
                r4.f12827c = r5
                r4.f12828d = r10
                r4.f12829e = r3
                r4.f12830f = r8
                r4.f12831g = r2
                java.lang.Object r1 = r5.yield(r10, r4)
                if (r1 != r0) goto L7e
                return r0
            L7e:
                r1 = r10
                r10 = r8
                goto L52
            L81:
                d.d0 r10 = d.d0.f12421a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: d.o0.t.u.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    @d.i0.f.a.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2139, 2142}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class v<S> extends d.i0.f.a.k implements d.k0.c.p<d.o0.o<? super S>, d.i0.a<? super d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12835d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f12836e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12837f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12838g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.p f12839h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(d.o0.m mVar, d.k0.c.p pVar, d.i0.a aVar) {
            super(2, aVar);
            this.f12838g = mVar;
            this.f12839h = pVar;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            v vVar = new v(this.f12838g, this.f12839h, aVar);
            vVar.f12834c = obj;
            return vVar;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d0> aVar) {
            return ((v) create(obj, aVar)).invokeSuspend(d0.f12421a);
        }

        @Override // d.i0.f.a.a
        public final Object invokeSuspend(Object obj) {
            d.o0.o oVar;
            Object next;
            Iterator it;
            Object coroutine_suspended = d.i0.e.c.getCOROUTINE_SUSPENDED();
            int i2 = this.f12837f;
            if (i2 == 0) {
                d.o.throwOnFailure(obj);
                oVar = (d.o0.o) this.f12834c;
                Iterator it2 = this.f12838g.iterator();
                if (it2.hasNext()) {
                    next = it2.next();
                    this.f12834c = oVar;
                    this.f12835d = it2;
                    this.f12836e = next;
                    this.f12837f = 1;
                    if (oVar.yield(next, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = it2;
                }
                return d0.f12421a;
            }
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            next = this.f12836e;
            it = (Iterator) this.f12835d;
            oVar = (d.o0.o) this.f12834c;
            d.o.throwOnFailure(obj);
            while (it.hasNext()) {
                next = this.f12839h.invoke(next, it.next());
                this.f12834c = oVar;
                this.f12835d = it;
                this.f12836e = next;
                this.f12837f = 2;
                if (oVar.yield(next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return d0.f12421a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    @d.i0.f.a.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2168, 2172}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    public static final class w<S> extends d.i0.f.a.k implements d.k0.c.p<d.o0.o<? super S>, d.i0.a<? super d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f12842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12843f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12844g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12845h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.q f12846i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(d.o0.m mVar, d.k0.c.q qVar, d.i0.a aVar) {
            super(2, aVar);
            this.f12845h = mVar;
            this.f12846i = qVar;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            w wVar = new w(this.f12845h, this.f12846i, aVar);
            wVar.f12840c = obj;
            return wVar;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d0> aVar) {
            return ((w) create(obj, aVar)).invokeSuspend(d0.f12421a);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
        @Override // d.i0.f.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = d.i0.e.c.getCOROUTINE_SUSPENDED()
                int r1 = r10.f12844g
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L38
                if (r1 == r3) goto L2a
                if (r1 != r2) goto L22
                int r1 = r10.f12843f
                java.lang.Object r3 = r10.f12842e
                java.lang.Object r4 = r10.f12841d
                java.util.Iterator r4 = (java.util.Iterator) r4
                java.lang.Object r5 = r10.f12840c
                d.o0.o r5 = (d.o0.o) r5
                d.o.throwOnFailure(r11)
                r11 = r10
                r9 = r3
                r3 = r1
                r1 = r9
                goto L60
            L22:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L2a:
                java.lang.Object r1 = r10.f12842e
                java.lang.Object r4 = r10.f12841d
                java.util.Iterator r4 = (java.util.Iterator) r4
                java.lang.Object r5 = r10.f12840c
                d.o0.o r5 = (d.o0.o) r5
                d.o.throwOnFailure(r11)
                goto L5f
            L38:
                d.o.throwOnFailure(r11)
                java.lang.Object r11 = r10.f12840c
                r5 = r11
                d.o0.o r5 = (d.o0.o) r5
                d.o0.m r11 = r10.f12845h
                java.util.Iterator r4 = r11.iterator()
                boolean r11 = r4.hasNext()
                if (r11 == 0) goto L8f
                java.lang.Object r1 = r4.next()
                r10.f12840c = r5
                r10.f12841d = r4
                r10.f12842e = r1
                r10.f12844g = r3
                java.lang.Object r11 = r5.yield(r1, r10)
                if (r11 != r0) goto L5f
                return r0
            L5f:
                r11 = r10
            L60:
                boolean r6 = r4.hasNext()
                if (r6 == 0) goto L8f
                d.k0.c.q r6 = r11.f12846i
                int r7 = r3 + 1
                if (r3 >= 0) goto L6f
                d.g0.s.throwIndexOverflow()
            L6f:
                java.lang.Integer r3 = d.i0.f.a.b.boxInt(r3)
                java.lang.Object r8 = r4.next()
                java.lang.Object r3 = r6.invoke(r3, r1, r8)
                r11.f12840c = r5
                r11.f12841d = r4
                r11.f12842e = r3
                r11.f12843f = r7
                r11.f12844g = r2
                java.lang.Object r1 = r5.yield(r3, r11)
                if (r1 != r0) goto L8c
                return r0
            L8c:
                r1 = r3
                r3 = r7
                goto L60
            L8f:
                d.d0 r11 = d.d0.f12421a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: d.o0.t.w.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class x<T> implements d.o0.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12847a;

        public x(d.o0.m<? extends T> mVar) {
            this.f12847a = mVar;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            List mutableList = t.toMutableList(this.f12847a);
            d.g0.w.sort(mutableList);
            return mutableList.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class y<T> implements d.o0.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.o0.m f12848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator f12849b;

        public y(d.o0.m<? extends T> mVar, Comparator comparator) {
            this.f12848a = mVar;
            this.f12849b = comparator;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            List mutableList = t.toMutableList(this.f12848a);
            d.g0.w.sortWith(mutableList, this.f12849b);
            return mutableList.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    public static final class z<R, T> extends d.k0.d.u implements d.k0.c.p<T, R, d.m<? extends T, ? extends R>> {
        public static final z INSTANCE = new z();

        public z() {
            super(2);
        }

        @Override // d.k0.c.p
        public final d.m<T, R> invoke(T t, R r) {
            return d.s.to(t, r);
        }
    }

    public static final <T> boolean all(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (!lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$any");
        return mVar.iterator().hasNext();
    }

    public static final <T> Iterable<T> asIterable(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$asIterable");
        return new a(mVar);
    }

    public static final <T, K, V> Map<K, V> associate(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(it.next());
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <T, K> Map<K, T> associateBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : mVar) {
            linkedHashMap.put(lVar.invoke(t), t);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(d.o0.m<? extends T> mVar, M m2, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (T t : mVar) {
            m2.put(lVar.invoke(t), t);
        }
        return m2;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(d.o0.m<? extends T> mVar, M m2, d.k0.c.l<? super T, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(it.next());
            m2.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m2;
    }

    public static final <K, V> Map<K, V> associateWith(d.o0.m<? extends K> mVar, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$associateWith");
        d.k0.d.t.checkNotNullParameter(lVar, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k2 : mVar) {
            linkedHashMap.put(k2, lVar.invoke(k2));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(d.o0.m<? extends K> mVar, M m2, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$associateWithTo");
        d.k0.d.t.checkNotNullParameter(m2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "valueSelector");
        for (K k2 : mVar) {
            m2.put(k2, lVar.invoke(k2));
        }
        return m2;
    }

    public static final double averageOfByte(d.o0.m<Byte> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$average");
        Iterator<Byte> it = mVar.iterator();
        double dByteValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dByteValue += (double) it.next().byteValue();
            i2++;
            if (i2 < 0) {
                d.g0.s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i2);
    }

    public static final double averageOfDouble(d.o0.m<Double> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$average");
        Iterator<Double> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i2++;
            if (i2 < 0) {
                d.g0.s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i2);
    }

    public static final double averageOfFloat(d.o0.m<Float> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$average");
        Iterator<Float> it = mVar.iterator();
        double dFloatValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i2++;
            if (i2 < 0) {
                d.g0.s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i2);
    }

    public static final double averageOfInt(d.o0.m<Integer> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$average");
        Iterator<Integer> it = mVar.iterator();
        double dIntValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i2++;
            if (i2 < 0) {
                d.g0.s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i2);
    }

    public static final double averageOfLong(d.o0.m<Long> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$average");
        Iterator<Long> it = mVar.iterator();
        double dLongValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i2++;
            if (i2 < 0) {
                d.g0.s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i2);
    }

    public static final double averageOfShort(d.o0.m<Short> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$average");
        Iterator<Short> it = mVar.iterator();
        double dShortValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dShortValue += (double) it.next().shortValue();
            i2++;
            if (i2 < 0) {
                d.g0.s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i2);
    }

    public static final <T> d.o0.m<List<T>> chunked(d.o0.m<? extends T> mVar, int i2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$chunked");
        return windowed(mVar, i2, i2, true);
    }

    public static final <T> boolean contains(d.o0.m<? extends T> mVar, T t) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$contains");
        return indexOf(mVar, t) >= 0;
    }

    public static final <T> int count(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$count");
        Iterator<? extends T> it = mVar.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                d.g0.s.throwCountOverflow();
            }
        }
        return i2;
    }

    public static final <T> d.o0.m<T> distinct(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$distinct");
        return distinctBy(mVar, b.INSTANCE);
    }

    public static final <T, K> d.o0.m<T> distinctBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return new d.o0.c(mVar, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d.o0.m<T> drop(d.o0.m<? extends T> mVar, int i2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$drop");
        if (i2 >= 0) {
            return i2 == 0 ? mVar : mVar instanceof d.o0.e ? ((d.o0.e) mVar).drop(i2) : new d.o0.d(mVar, i2);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final <T> d.o0.m<T> dropWhile(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        return new d.o0.f(mVar, lVar);
    }

    public static final <T> T elementAt(d.o0.m<? extends T> mVar, int i2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$elementAt");
        return (T) elementAtOrElse(mVar, i2, new c(i2));
    }

    public static final <T> T elementAtOrElse(d.o0.m<? extends T> mVar, int i2, d.k0.c.l<? super Integer, ? extends T> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$elementAtOrElse");
        d.k0.d.t.checkNotNullParameter(lVar, AppMonitorDelegate.DEFAULT_VALUE);
        if (i2 < 0) {
            return lVar.invoke(Integer.valueOf(i2));
        }
        int i3 = 0;
        for (T t : mVar) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return lVar.invoke(Integer.valueOf(i2));
    }

    public static final <T> T elementAtOrNull(d.o0.m<? extends T> mVar, int i2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$elementAtOrNull");
        if (i2 < 0) {
            return null;
        }
        int i3 = 0;
        for (T t : mVar) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return null;
    }

    public static final <T> d.o0.m<T> filter(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        return new d.o0.h(mVar, true, lVar);
    }

    public static final <T> d.o0.m<T> filterIndexed(d.o0.m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        return new d.o0.y(new d.o0.h(new d.o0.k(mVar), true, new d(pVar)), e.INSTANCE);
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.p<? super Integer, ? super T, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int i2 = 0;
        for (T t : mVar) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            if (pVar.invoke(Integer.valueOf(i2), t).booleanValue()) {
                c2.add(t);
            }
            i2 = i3;
        }
        return c2;
    }

    public static final /* synthetic */ <R> d.o0.m<R> filterIsInstance(d.o0.m<?> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterIsInstance");
        d.k0.d.t.needClassReification();
        d.o0.m<R> mVarFilter = filter(mVar, f.INSTANCE);
        Objects.requireNonNull(mVarFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return mVarFilter;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(d.o0.m<?> mVar, C c2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterIsInstanceTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (Object obj : mVar) {
            d.k0.d.t.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T> d.o0.m<T> filterNot(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        return new d.o0.h(mVar, false, lVar);
    }

    public static final <T> d.o0.m<T> filterNotNull(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterNotNull");
        d.o0.m<T> mVarFilterNot = filterNot(mVar, g.INSTANCE);
        Objects.requireNonNull(mVarFilterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return mVarFilterNot;
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(d.o0.m<? extends T> mVar, C c2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (T t : mVar) {
            if (t != null) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t : mVar) {
            if (!lVar.invoke(t).booleanValue()) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t : mVar) {
            if (lVar.invoke(t).booleanValue()) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T> T first(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$first");
        Iterator<? extends T> it = mVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> T firstOrNull(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$firstOrNull");
        Iterator<? extends T> it = mVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T, R> d.o0.m<R> flatMap(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends d.o0.m<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return new d.o0.i(mVar, lVar, i.INSTANCE);
    }

    public static final <T, R> d.o0.m<R> flatMapIndexedIterable(d.o0.m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, ? extends Iterable<? extends R>> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$flatMapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        return d.o0.r.flatMapIndexed(mVar, pVar, j.INSTANCE);
    }

    public static final <T, R> d.o0.m<R> flatMapIndexedSequence(d.o0.m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, ? extends d.o0.m<? extends R>> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$flatMapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        return d.o0.r.flatMapIndexed(mVar, pVar, k.INSTANCE);
    }

    public static final <T, R> d.o0.m<R> flatMapIterable(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return new d.o0.i(mVar, lVar, h.INSTANCE);
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapIterableTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.l<? super T, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            d.g0.x.addAll(c2, lVar.invoke(it.next()));
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.l<? super T, ? extends d.o0.m<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            d.g0.x.addAll(c2, lVar.invoke(it.next()));
        }
        return c2;
    }

    public static final <T, R> R fold(d.o0.m<? extends T> mVar, R r2, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            r2 = pVar.invoke(r2, it.next());
        }
        return r2;
    }

    public static final <T, R> R foldIndexed(d.o0.m<? extends T> mVar, R r2, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (T t : mVar) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            r2 = qVar.invoke(Integer.valueOf(i2), r2, t);
            i2 = i3;
        }
        return r2;
    }

    public static final <T> void forEach(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, d0> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    public static final <T> void forEachIndexed(d.o0.m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, d0> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (T t : mVar) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            pVar.invoke(Integer.valueOf(i2), t);
            i2 = i3;
        }
    }

    public static final <T, K> Map<K, List<T>> groupBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : mVar) {
            K kInvoke = lVar.invoke(t);
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(t);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(d.o0.m<? extends T> mVar, M m2, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (T t : mVar) {
            K kInvoke = lVar.invoke(t);
            Object arrayList = m2.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m2.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(t);
        }
        return m2;
    }

    public static final <T, K> h0<T, K> groupingBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$groupingBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        return new l(mVar, lVar);
    }

    public static final <T> int indexOf(d.o0.m<? extends T> mVar, T t) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$indexOf");
        int i2 = 0;
        for (T t2 : mVar) {
            if (i2 < 0) {
                d.g0.s.throwIndexOverflow();
            }
            if (d.k0.d.t.areEqual(t, t2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (T t : mVar) {
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            if (lVar.invoke(t).booleanValue()) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = -1;
        int i3 = 0;
        for (T t : mVar) {
            if (i3 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            if (lVar.invoke(t).booleanValue()) {
                i2 = i3;
            }
            i3++;
        }
        return i2;
    }

    public static final <T, A extends Appendable> A joinTo(d.o0.m<? extends T> mVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super T, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (T t : mVar) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            d.p0.p.appendElement(a2, t, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String joinToString(d.o0.m<? extends T> mVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super T, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(mVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(d.o0.m mVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
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
        return joinToString(mVar, charSequence, charSequence5, charSequence6, i4, charSequence7, lVar);
    }

    public static final <T> T last(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$last");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> int lastIndexOf(d.o0.m<? extends T> mVar, T t) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$lastIndexOf");
        int i2 = -1;
        int i3 = 0;
        for (T t2 : mVar) {
            if (i3 < 0) {
                d.g0.s.throwIndexOverflow();
            }
            if (d.k0.d.t.areEqual(t, t2)) {
                i2 = i3;
            }
            i3++;
        }
        return i2;
    }

    public static final <T> T lastOrNull(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$lastOrNull");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T, R> d.o0.m<R> map(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return new d.o0.y(mVar, lVar);
    }

    public static final <T, R> d.o0.m<R> mapIndexed(d.o0.m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        return new d.o0.x(mVar, pVar);
    }

    public static final <T, R> d.o0.m<R> mapIndexedNotNull(d.o0.m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$mapIndexedNotNull");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        return filterNotNull(new d.o0.x(mVar, pVar));
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$mapIndexedNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (T t : mVar) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            R rInvoke = pVar.invoke(Integer.valueOf(i2), t);
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
            i2 = i3;
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (T t : mVar) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            c2.add(pVar.invoke(Integer.valueOf(i2), t));
            i2 = i3;
        }
        return c2;
    }

    public static final <T, R> d.o0.m<R> mapNotNull(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$mapNotNull");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return filterNotNull(new d.o0.y(mVar, lVar));
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$mapNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(d.o0.m<? extends T> mVar, C c2, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            c2.add(lVar.invoke(it.next()));
        }
        return c2;
    }

    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final Double m391max(d.o0.m<Double> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$max");
        return m393maxOrNull(mVar);
    }

    public static final <T, R extends Comparable<? super R>> T maxBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R rInvoke = lVar.invoke(next);
            do {
                T next2 = it.next();
                R rInvoke2 = lVar.invoke(next2);
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    next = next2;
                    rInvoke = rInvoke2;
                }
            } while (it.hasNext());
        }
        return (T) next;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rInvoke = lVar.invoke(next);
        do {
            T next2 = it.next();
            R rInvoke2 = lVar.invoke(next2);
            next = next;
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Double m393maxOrNull(d.o0.m<Double> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$maxOrNull");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T maxWith(d.o0.m<? extends T> mVar, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (T) maxWithOrNull(mVar, comparator);
    }

    public static final <T> T maxWithOrNull(d.o0.m<? extends T> mVar, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final Double m395min(d.o0.m<Double> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$min");
        return m397minOrNull(mVar);
    }

    public static final <T, R extends Comparable<? super R>> T minBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R rInvoke = lVar.invoke(next);
            do {
                T next2 = it.next();
                R rInvoke2 = lVar.invoke(next2);
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    next = next2;
                    rInvoke = rInvoke2;
                }
            } while (it.hasNext());
        }
        return (T) next;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    public static final <T, R extends Comparable<? super R>> T minByOrNull(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rInvoke = lVar.invoke(next);
        do {
            T next2 = it.next();
            R rInvoke2 = lVar.invoke(next2);
            next = next;
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Double m397minOrNull(d.o0.m<Double> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minOrNull");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T minWith(d.o0.m<? extends T> mVar, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (T) minWithOrNull(mVar, comparator);
    }

    public static final <T> T minWithOrNull(d.o0.m<? extends T> mVar, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> d.o0.m<T> minus(d.o0.m<? extends T> mVar, T t) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minus");
        return new m(mVar, t);
    }

    public static final <T> boolean none(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$none");
        return !mVar.iterator().hasNext();
    }

    public static final <T> d.o0.m<T> onEach(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, d0> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$onEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        return map(mVar, new q(lVar));
    }

    public static final <T> d.o0.m<T> onEachIndexed(d.o0.m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, d0> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$onEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        return mapIndexed(mVar, new r(pVar));
    }

    public static final <T> d.m<List<T>, List<T>> partition(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : mVar) {
            if (lVar.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final <T> d.o0.m<T> plus(d.o0.m<? extends T> mVar, T t) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$plus");
        return d.o0.r.flatten(d.o0.r.sequenceOf(mVar, d.o0.r.sequenceOf(t)));
    }

    public static final <S, T extends S> S reduce(d.o0.m<? extends T> mVar, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it.next();
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
        }
        return next;
    }

    public static final <S, T extends S> S reduceIndexed(d.o0.m<? extends T> mVar, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it.next();
        int i2 = 1;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            next = qVar.invoke(Integer.valueOf(i2), next, it.next());
            i2 = i3;
        }
        return next;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(d.o0.m<? extends T> mVar, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i2 = 1;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                d.g0.s.throwIndexOverflow();
            }
            next = qVar.invoke(Integer.valueOf(i2), next, it.next());
            i2 = i3;
        }
        return next;
    }

    public static final <S, T extends S> S reduceOrNull(d.o0.m<? extends T> mVar, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
        }
        return next;
    }

    public static final <T> d.o0.m<T> requireNoNulls(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$requireNoNulls");
        return map(mVar, new s(mVar));
    }

    public static final <T, R> d.o0.m<R> runningFold(d.o0.m<? extends T> mVar, R r2, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$runningFold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        return d.o0.p.sequence(new C0241t(mVar, r2, pVar, null));
    }

    public static final <T, R> d.o0.m<R> runningFoldIndexed(d.o0.m<? extends T> mVar, R r2, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$runningFoldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        return d.o0.p.sequence(new u(mVar, r2, qVar, null));
    }

    public static final <S, T extends S> d.o0.m<S> runningReduce(d.o0.m<? extends T> mVar, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$runningReduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        return d.o0.p.sequence(new v(mVar, pVar, null));
    }

    public static final <S, T extends S> d.o0.m<S> runningReduceIndexed(d.o0.m<? extends T> mVar, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$runningReduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        return d.o0.p.sequence(new w(mVar, qVar, null));
    }

    public static final <T, R> d.o0.m<R> scan(d.o0.m<? extends T> mVar, R r2, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$scan");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        return runningFold(mVar, r2, pVar);
    }

    public static final <T, R> d.o0.m<R> scanIndexed(d.o0.m<? extends T> mVar, R r2, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$scanIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        return runningFoldIndexed(mVar, r2, qVar);
    }

    public static final <S, T extends S> d.o0.m<S> scanReduce(d.o0.m<? extends T> mVar, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$scanReduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        return runningReduce(mVar, pVar);
    }

    public static final <S, T extends S> d.o0.m<S> scanReduceIndexed(d.o0.m<? extends T> mVar, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$scanReduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        return runningReduceIndexed(mVar, qVar);
    }

    public static final <T> T single(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$single");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        return next;
    }

    public static final <T> T singleOrNull(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$singleOrNull");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static final <T extends Comparable<? super T>> d.o0.m<T> sorted(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sorted");
        return new x(mVar);
    }

    public static final <T, R extends Comparable<? super R>> d.o0.m<T> sortedBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(mVar, new d.h0.b(lVar));
    }

    public static final <T, R extends Comparable<? super R>> d.o0.m<T> sortedByDescending(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(mVar, new d.h0.c(lVar));
    }

    public static final <T extends Comparable<? super T>> d.o0.m<T> sortedDescending(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sortedDescending");
        return sortedWith(mVar, d.h0.a.reverseOrder());
    }

    public static final <T> d.o0.m<T> sortedWith(d.o0.m<? extends T> mVar, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return new y(mVar, comparator);
    }

    public static final <T> int sumBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += lVar.invoke(it.next()).intValue();
        }
        return iIntValue;
    }

    public static final <T> double sumByDouble(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += lVar.invoke(it.next()).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfByte(d.o0.m<Byte> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sum");
        Iterator<Byte> it = mVar.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += it.next().byteValue();
        }
        return iByteValue;
    }

    public static final double sumOfDouble(d.o0.m<Double> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sum");
        Iterator<Double> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue;
    }

    public static final float sumOfFloat(d.o0.m<Float> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sum");
        Iterator<Float> it = mVar.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    public static final int sumOfInt(d.o0.m<Integer> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sum");
        Iterator<Integer> it = mVar.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    public static final long sumOfLong(d.o0.m<Long> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sum");
        Iterator<Long> it = mVar.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public static final int sumOfShort(d.o0.m<Short> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$sum");
        Iterator<Short> it = mVar.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += it.next().shortValue();
        }
        return iShortValue;
    }

    public static final <T> d.o0.m<T> take(d.o0.m<? extends T> mVar, int i2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$take");
        if (i2 >= 0) {
            return i2 == 0 ? d.o0.r.emptySequence() : mVar instanceof d.o0.e ? ((d.o0.e) mVar).take(i2) : new d.o0.v(mVar, i2);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final <T> d.o0.m<T> takeWhile(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        return new d.o0.w(mVar, lVar);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(d.o0.m<? extends T> mVar, C c2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T> HashSet<T> toHashSet(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toHashSet");
        return (HashSet) toCollection(mVar, new HashSet());
    }

    public static final <T> List<T> toList(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toList");
        return d.g0.s.optimizeReadOnlyList(toMutableList(mVar));
    }

    public static final <T> List<T> toMutableList(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toMutableList");
        return (List) toCollection(mVar, new ArrayList());
    }

    public static final <T> Set<T> toMutableSet(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toMutableSet");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static final <T> Set<T> toSet(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toSet");
        return z0.optimizeReadOnlySet((Set) toCollection(mVar, new LinkedHashSet()));
    }

    public static final <T> d.o0.m<List<T>> windowed(d.o0.m<? extends T> mVar, int i2, int i3, boolean z2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$windowed");
        return b1.windowedSequence(mVar, i2, i3, z2, false);
    }

    public static /* synthetic */ d.o0.m windowed$default(d.o0.m mVar, int i2, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        return windowed(mVar, i2, i3, z2);
    }

    public static final <T> d.o0.m<i0<T>> withIndex(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$withIndex");
        return new d.o0.k(mVar);
    }

    public static final <T, R> d.o0.m<d.m<T, R>> zip(d.o0.m<? extends T> mVar, d.o0.m<? extends R> mVar2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$zip");
        d.k0.d.t.checkNotNullParameter(mVar2, "other");
        return new d.o0.l(mVar, mVar2, z.INSTANCE);
    }

    public static final <T> d.o0.m<d.m<T, T>> zipWithNext(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$zipWithNext");
        return zipWithNext(mVar, a0.INSTANCE);
    }

    public static final <T> boolean any(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T, R> d.o0.m<R> chunked(d.o0.m<? extends T> mVar, int i2, d.k0.c.l<? super List<? extends T>, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$chunked");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return windowed(mVar, i2, i2, true, lVar);
    }

    public static final <T> int count(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() && (i2 = i2 + 1) < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
                d.g0.s.throwCountOverflow();
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final Float m392max(d.o0.m<Float> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$max");
        return m394maxOrNull(mVar);
    }

    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final Float m396min(d.o0.m<Float> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$min");
        return m398minOrNull(mVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d.o0.m<T> minus(d.o0.m<? extends T> mVar, T[] tArr) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minus");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? mVar : new n(mVar, tArr);
    }

    public static final <T> boolean none(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> d.o0.m<T> plus(d.o0.m<? extends T> mVar, T[] tArr) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$plus");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return plus((d.o0.m) mVar, (Iterable) d.g0.l.asList(tArr));
    }

    public static final <T, R> d.o0.m<R> windowed(d.o0.m<? extends T> mVar, int i2, int i3, boolean z2, d.k0.c.l<? super List<? extends T>, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$windowed");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return map(b1.windowedSequence(mVar, i2, i3, z2, true), lVar);
    }

    public static /* synthetic */ d.o0.m windowed$default(d.o0.m mVar, int i2, int i3, boolean z2, d.k0.c.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        return windowed(mVar, i2, i3, z2, lVar);
    }

    public static final <T, R, V> d.o0.m<V> zip(d.o0.m<? extends T> mVar, d.o0.m<? extends R> mVar2, d.k0.c.p<? super T, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$zip");
        d.k0.d.t.checkNotNullParameter(mVar2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        return new d.o0.l(mVar, mVar2, pVar);
    }

    public static final <T, R> d.o0.m<R> zipWithNext(d.o0.m<? extends T> mVar, d.k0.c.p<? super T, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$zipWithNext");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        return d.o0.p.sequence(new b0(mVar, pVar, null));
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(d.o0.m<? extends T> mVar, M m2, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (T t : mVar) {
            m2.put(lVar.invoke(t), lVar2.invoke(t));
        }
        return m2;
    }

    public static final <T extends Comparable<? super T>> T max(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$max");
        return (T) maxOrNull(mVar);
    }

    public static final <T extends Comparable<? super T>> T min(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$min");
        return (T) minOrNull(mVar);
    }

    public static final <T> d.o0.m<T> plus(d.o0.m<? extends T> mVar, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$plus");
        d.k0.d.t.checkNotNullParameter(iterable, "elements");
        return d.o0.r.flatten(d.o0.r.sequenceOf(mVar, d.g0.a0.asSequence(iterable)));
    }

    public static final <T, K, V> Map<K, V> associateBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : mVar) {
            linkedHashMap.put(lVar.invoke(t), lVar2.invoke(t));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T firstOrNull(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t : mVar) {
            if (lVar.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    public static final <T> d.o0.m<T> minus(d.o0.m<? extends T> mVar, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minus");
        d.k0.d.t.checkNotNullParameter(iterable, "elements");
        return new o(mVar, iterable);
    }

    public static final <T> d.o0.m<T> plus(d.o0.m<? extends T> mVar, d.o0.m<? extends T> mVar2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$plus");
        d.k0.d.t.checkNotNullParameter(mVar2, "elements");
        return d.o0.r.flatten(d.o0.r.sequenceOf(mVar, mVar2));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T first(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t : mVar) {
            if (lVar.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> d.o0.m<T> minus(d.o0.m<? extends T> mVar, d.o0.m<? extends T> mVar2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minus");
        d.k0.d.t.checkNotNullParameter(mVar2, "elements");
        return new p(mVar, mVar2);
    }

    public static final <T> T singleOrNull(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        boolean z2 = false;
        T t = null;
        for (T t2 : mVar) {
            if (lVar.invoke(t2).booleanValue()) {
                if (z2) {
                    return null;
                }
                z2 = true;
                t = t2;
            }
        }
        if (z2) {
            return t;
        }
        return null;
    }

    public static final <T> T lastOrNull(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        T t = null;
        for (T t2 : mVar) {
            if (lVar.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    public static final <T> T last(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        T t = null;
        boolean z2 = false;
        for (T t2 : mVar) {
            if (lVar.invoke(t2).booleanValue()) {
                t = t2;
                z2 = true;
            }
        }
        if (z2) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> T single(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        T t = null;
        boolean z2 = false;
        for (T t2 : mVar) {
            if (lVar.invoke(t2).booleanValue()) {
                if (z2) {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
                t = t2;
                z2 = true;
            }
        }
        if (z2) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(d.o0.m<? extends T> mVar, M m2, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (T t : mVar) {
            K kInvoke = lVar.invoke(t);
            Object arrayList = m2.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m2.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(t));
        }
        return m2;
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m394maxOrNull(d.o0.m<Float> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$maxOrNull");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Float m398minOrNull(d.o0.m<Float> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minOrNull");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <T, K, V> Map<K, List<V>> groupBy(d.o0.m<? extends T> mVar, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : mVar) {
            K kInvoke = lVar.invoke(t);
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(t));
        }
        return linkedHashMap;
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$maxOrNull");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T extends Comparable<? super T>> T minOrNull(d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$minOrNull");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }
}
