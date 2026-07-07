package d.n0;

import d.d0;
import d.n0.k;
import d.n0.l;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface g<V> extends l<V>, k {

    public interface a<V> extends f<V>, d.k0.c.l<V, d0> {
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

        @Override // d.k0.c.l
        /* synthetic */ R invoke(P1 p1);

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

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ R call(Object... objArr);

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ R callBy(Map<j, ? extends Object> map);

    @Override // d.n0.l
    /* synthetic */ V get();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ List<Annotation> getAnnotations();

    @Override // d.n0.l
    /* synthetic */ Object getDelegate();

    @Override // d.n0.l
    /* synthetic */ k.a<V> getGetter();

    @Override // d.n0.l, d.n0.k, d.n0.l
    /* synthetic */ l.a<V> getGetter();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ String getName();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ List<j> getParameters();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ o getReturnType();

    /* synthetic */ f<V> getSetter();

    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    a<V> m388getSetter();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ List<p> getTypeParameters();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ t getVisibility();

    @Override // d.n0.l, d.k0.c.a
    /* synthetic */ R invoke();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ boolean isAbstract();

    @Override // d.n0.l, d.n0.k
    /* synthetic */ boolean isConst();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ boolean isFinal();

    @Override // d.n0.l, d.n0.k
    /* synthetic */ boolean isLateinit();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ boolean isOpen();

    @Override // d.n0.l, d.n0.k, d.n0.a
    /* synthetic */ boolean isSuspend();

    void set(V v);
}
