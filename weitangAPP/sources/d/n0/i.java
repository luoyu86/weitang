package d.n0;

import d.d0;
import d.n0.k;
import d.n0.n;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface i<D, E, V> extends n<D, E, V>, k {

    public interface a<D, E, V> extends f<V>, d.k0.c.q<D, E, V, d0> {
        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ R call(Object... objArr);

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ R callBy(Map<j, ? extends Object> map);

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ List<Annotation> getAnnotations();

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ String getName();

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ List<j> getParameters();

        @Override // d.n0.f
        /* synthetic */ k<V> getProperty();

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ o getReturnType();

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ List<p> getTypeParameters();

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ t getVisibility();

        @Override // d.k0.c.q
        /* synthetic */ R invoke(P1 p1, P2 p2, P3 p3);

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ boolean isAbstract();

        @Override // d.n0.f, d.n0.e
        /* synthetic */ boolean isExternal();

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ boolean isFinal();

        @Override // d.n0.f, d.n0.e
        /* synthetic */ boolean isInfix();

        @Override // d.n0.f, d.n0.e
        /* synthetic */ boolean isInline();

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ boolean isOpen();

        @Override // d.n0.f, d.n0.e
        /* synthetic */ boolean isOperator();

        @Override // d.n0.f, d.n0.e, d.n0.a
        /* synthetic */ boolean isSuspend();
    }

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ R call(Object... objArr);

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ R callBy(Map<j, ? extends Object> map);

    @Override // d.n0.n
    /* synthetic */ V get(D d2, E e2);

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ List<Annotation> getAnnotations();

    @Override // d.n0.n
    /* synthetic */ Object getDelegate(D d2, E e2);

    @Override // d.n0.n, d.n0.k, d.n0.l
    /* synthetic */ k.a<V> getGetter();

    @Override // d.n0.n, d.n0.k, d.n0.l
    /* synthetic */ n.a<D, E, V> getGetter();

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ String getName();

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ List<j> getParameters();

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ o getReturnType();

    /* synthetic */ f<V> getSetter();

    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    a<D, E, V> m390getSetter();

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ List<p> getTypeParameters();

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ t getVisibility();

    @Override // d.n0.n, d.k0.c.p
    /* synthetic */ R invoke(P1 p1, P2 p2);

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ boolean isAbstract();

    @Override // d.n0.n, d.n0.k
    /* synthetic */ boolean isConst();

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ boolean isFinal();

    @Override // d.n0.n, d.n0.k
    /* synthetic */ boolean isLateinit();

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ boolean isOpen();

    @Override // d.n0.n, d.n0.k, d.n0.a
    /* synthetic */ boolean isSuspend();

    void set(D d2, E e2, V v);
}
