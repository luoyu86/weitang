package d.o0;

import com.alibaba.mtl.appmonitor.AppMonitorDelegate;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import d.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class r extends q {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f12773a;

        public a(Iterator it) {
            this.f12773a = it;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            return this.f12773a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @d.i0.f.a.f(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
    public static final class b<R> extends d.i0.f.a.k implements d.k0.c.p<o<? super R>, d.i0.a<? super d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12775d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12776e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12777f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ m f12778g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.p f12779h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.l f12780i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m mVar, d.k0.c.p pVar, d.k0.c.l lVar, d.i0.a aVar) {
            super(2, aVar);
            this.f12778g = mVar;
            this.f12779h = pVar;
            this.f12780i = lVar;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            b bVar = new b(this.f12778g, this.f12779h, this.f12780i, aVar);
            bVar.f12774c = obj;
            return bVar;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d0> aVar) {
            return ((b) create(obj, aVar)).invokeSuspend(d0.f12421a);
        }

        @Override // d.i0.f.a.a
        public final Object invokeSuspend(Object obj) {
            int i2;
            Iterator it;
            o oVar;
            Object coroutine_suspended = d.i0.e.c.getCOROUTINE_SUSPENDED();
            int i3 = this.f12777f;
            if (i3 == 0) {
                d.o.throwOnFailure(obj);
                o oVar2 = (o) this.f12774c;
                i2 = 0;
                it = this.f12778g.iterator();
                oVar = oVar2;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.f12776e;
                it = (Iterator) this.f12775d;
                oVar = (o) this.f12774c;
                d.o.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                d.k0.c.p pVar = this.f12779h;
                int i4 = i2 + 1;
                if (i2 < 0) {
                    d.g0.s.throwIndexOverflow();
                }
                Iterator it2 = (Iterator) this.f12780i.invoke(pVar.invoke(d.i0.f.a.b.boxInt(i2), next));
                this.f12774c = oVar;
                this.f12775d = it;
                this.f12776e = i4;
                this.f12777f = 1;
                if (oVar.yieldAll(it2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i2 = i4;
            }
            return d0.f12421a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> extends d.k0.d.u implements d.k0.c.l<m<? extends T>, Iterator<? extends T>> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // d.k0.c.l
        public final Iterator<T> invoke(m<? extends T> mVar) {
            d.k0.d.t.checkNotNullParameter(mVar, "it");
            return mVar.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> extends d.k0.d.u implements d.k0.c.l<Iterable<? extends T>, Iterator<? extends T>> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // d.k0.c.l
        public final Iterator<T> invoke(Iterable<? extends T> iterable) {
            d.k0.d.t.checkNotNullParameter(iterable, "it");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class e<T> extends d.k0.d.u implements d.k0.c.l<T, T> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // d.k0.c.l
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class f<T> extends d.k0.d.u implements d.k0.c.l<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.a f12781b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d.k0.c.a aVar) {
            super(1);
            this.f12781b = aVar;
        }

        @Override // d.k0.c.l
        public final T invoke(T t) {
            d.k0.d.t.checkNotNullParameter(t, "it");
            return (T) this.f12781b.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class g<T> extends d.k0.d.u implements d.k0.c.a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f12782b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Object obj) {
            super(0);
            this.f12782b = obj;
        }

        @Override // d.k0.c.a
        public final T invoke() {
            return (T) this.f12782b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @d.i0.f.a.f(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
    public static final class h<T> extends d.i0.f.a.k implements d.k0.c.p<o<? super T>, d.i0.a<? super d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ m f12785e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.a f12786f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(m mVar, d.k0.c.a aVar, d.i0.a aVar2) {
            super(2, aVar2);
            this.f12785e = mVar;
            this.f12786f = aVar;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            h hVar = new h(this.f12785e, this.f12786f, aVar);
            hVar.f12783c = obj;
            return hVar;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d0> aVar) {
            return ((h) create(obj, aVar)).invokeSuspend(d0.f12421a);
        }

        @Override // d.i0.f.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = d.i0.e.c.getCOROUTINE_SUSPENDED();
            int i2 = this.f12784d;
            if (i2 == 0) {
                d.o.throwOnFailure(obj);
                o oVar = (o) this.f12783c;
                Iterator<? extends T> it = this.f12785e.iterator();
                if (it.hasNext()) {
                    this.f12784d = 1;
                    if (oVar.yieldAll(it, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    m<? extends T> mVar = (m) this.f12786f.invoke();
                    this.f12784d = 2;
                    if (oVar.yieldAll(mVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i2 != 1 && i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.o.throwOnFailure(obj);
            }
            return d0.f12421a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @d.i0.f.a.f(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
    public static final class i<T> extends d.i0.f.a.k implements d.k0.c.p<o<? super T>, d.i0.a<? super d0>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12789e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ m f12790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d.l0.f f12791g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(m mVar, d.l0.f fVar, d.i0.a aVar) {
            super(2, aVar);
            this.f12790f = mVar;
            this.f12791g = fVar;
        }

        @Override // d.i0.f.a.a
        public final d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
            d.k0.d.t.checkNotNullParameter(aVar, "completion");
            i iVar = new i(this.f12790f, this.f12791g, aVar);
            iVar.f12787c = obj;
            return iVar;
        }

        @Override // d.k0.c.p
        public final Object invoke(Object obj, d.i0.a<? super d0> aVar) {
            return ((i) create(obj, aVar)).invokeSuspend(d0.f12421a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.i0.f.a.a
        public final Object invokeSuspend(Object obj) {
            List mutableList;
            o oVar;
            Object coroutine_suspended = d.i0.e.c.getCOROUTINE_SUSPENDED();
            int i2 = this.f12789e;
            if (i2 == 0) {
                d.o.throwOnFailure(obj);
                o oVar2 = (o) this.f12787c;
                mutableList = t.toMutableList(this.f12790f);
                oVar = oVar2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableList = (List) this.f12788d;
                o oVar3 = (o) this.f12787c;
                d.o.throwOnFailure(obj);
                oVar = oVar3;
            }
            while (!mutableList.isEmpty()) {
                int iNextInt = this.f12791g.nextInt(mutableList.size());
                Object objRemoveLast = d.g0.x.removeLast(mutableList);
                if (iNextInt < mutableList.size()) {
                    objRemoveLast = mutableList.set(iNextInt, objRemoveLast);
                }
                this.f12787c = oVar;
                this.f12788d = mutableList;
                this.f12789e = 1;
                if (oVar.yield(objRemoveLast, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return d0.f12421a;
        }
    }

    public static final <T, R> m<R> a(m<? extends T> mVar, d.k0.c.l<? super T, ? extends Iterator<? extends R>> lVar) {
        return mVar instanceof y ? ((y) mVar).flatten$kotlin_stdlib(lVar) : new d.o0.i(mVar, e.INSTANCE, lVar);
    }

    public static final <T> m<T> asSequence(Iterator<? extends T> it) {
        d.k0.d.t.checkNotNullParameter(it, "$this$asSequence");
        return constrainOnce(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> m<T> constrainOnce(m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$constrainOnce");
        return mVar instanceof d.o0.a ? mVar : new d.o0.a(mVar);
    }

    public static final <T> m<T> emptySequence() {
        return d.o0.g.f12739a;
    }

    public static final <T, C, R> m<R> flatMapIndexed(m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, ? extends C> pVar, d.k0.c.l<? super C, ? extends Iterator<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "source");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        d.k0.d.t.checkNotNullParameter(lVar, "iterator");
        return p.sequence(new b(mVar, pVar, lVar, null));
    }

    public static final <T> m<T> flatten(m<? extends m<? extends T>> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$flatten");
        return a(mVar, c.INSTANCE);
    }

    public static final <T> m<T> flattenSequenceOfIterable(m<? extends Iterable<? extends T>> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$flatten");
        return a(mVar, d.INSTANCE);
    }

    public static final <T> m<T> generateSequence(d.k0.c.a<? extends T> aVar) {
        d.k0.d.t.checkNotNullParameter(aVar, "nextFunction");
        return constrainOnce(new j(aVar, new f(aVar)));
    }

    public static final <T> m<T> ifEmpty(m<? extends T> mVar, d.k0.c.a<? extends m<? extends T>> aVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$ifEmpty");
        d.k0.d.t.checkNotNullParameter(aVar, AppMonitorDelegate.DEFAULT_VALUE);
        return p.sequence(new h(mVar, aVar, null));
    }

    public static final <T> m<T> sequenceOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? emptySequence() : d.g0.m.asSequence(tArr);
    }

    public static final <T> m<T> shuffled(m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$shuffled");
        return shuffled(mVar, d.l0.f.f12668b);
    }

    public static final <T, R> d.m<List<T>, List<R>> unzip(m<? extends d.m<? extends T, ? extends R>> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$unzip");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (d.m<? extends T, ? extends R> mVar2 : mVar) {
            arrayList.add(mVar2.getFirst());
            arrayList2.add(mVar2.getSecond());
        }
        return d.s.to(arrayList, arrayList2);
    }

    public static final <T> m<T> generateSequence(T t, d.k0.c.l<? super T, ? extends T> lVar) {
        d.k0.d.t.checkNotNullParameter(lVar, "nextFunction");
        return t == null ? d.o0.g.f12739a : new j(new g(t), lVar);
    }

    public static final <T> m<T> shuffled(m<? extends T> mVar, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$shuffled");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        return p.sequence(new i(mVar, fVar, null));
    }

    public static final <T> m<T> generateSequence(d.k0.c.a<? extends T> aVar, d.k0.c.l<? super T, ? extends T> lVar) {
        d.k0.d.t.checkNotNullParameter(aVar, "seedFunction");
        d.k0.d.t.checkNotNullParameter(lVar, "nextFunction");
        return new j(aVar, lVar);
    }
}
