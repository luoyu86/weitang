package d.n0;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface k<V> extends d.n0.a<V> {

    public interface a<V> extends e<V> {
        @Override // d.n0.e, d.n0.a
        /* synthetic */ R call(Object... objArr);

        @Override // d.n0.e, d.n0.a
        /* synthetic */ R callBy(Map<j, ? extends Object> map);

        @Override // d.n0.e, d.n0.a
        /* synthetic */ List<Annotation> getAnnotations();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ String getName();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ List<j> getParameters();

        /* synthetic */ k<V> getProperty();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ o getReturnType();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ List<p> getTypeParameters();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ t getVisibility();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ boolean isAbstract();

        @Override // d.n0.e
        /* synthetic */ boolean isExternal();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ boolean isFinal();

        @Override // d.n0.e
        /* synthetic */ boolean isInfix();

        @Override // d.n0.e
        /* synthetic */ boolean isInline();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ boolean isOpen();

        @Override // d.n0.e
        /* synthetic */ boolean isOperator();

        @Override // d.n0.e, d.n0.a
        /* synthetic */ boolean isSuspend();
    }

    /* synthetic */ R call(Object... objArr);

    /* synthetic */ R callBy(Map<j, ? extends Object> map);

    /* synthetic */ List<Annotation> getAnnotations();

    a<V> getGetter();

    /* synthetic */ String getName();

    /* synthetic */ List<j> getParameters();

    /* synthetic */ o getReturnType();

    /* synthetic */ List<p> getTypeParameters();

    /* synthetic */ t getVisibility();

    /* synthetic */ boolean isAbstract();

    boolean isConst();

    /* synthetic */ boolean isFinal();

    boolean isLateinit();

    /* synthetic */ boolean isOpen();

    /* synthetic */ boolean isSuspend();
}
