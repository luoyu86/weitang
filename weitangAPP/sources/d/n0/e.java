package d.n0;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface e<R> extends a<R>, d.a<R> {
    @Override // d.n0.a
    /* synthetic */ R call(Object... objArr);

    @Override // d.n0.a
    /* synthetic */ R callBy(Map<j, ? extends Object> map);

    @Override // d.n0.a
    /* synthetic */ List<Annotation> getAnnotations();

    @Override // d.n0.a
    /* synthetic */ String getName();

    @Override // d.n0.a
    /* synthetic */ List<j> getParameters();

    @Override // d.n0.a
    /* synthetic */ o getReturnType();

    @Override // d.n0.a
    /* synthetic */ List<p> getTypeParameters();

    @Override // d.n0.a
    /* synthetic */ t getVisibility();

    @Override // d.n0.a
    /* synthetic */ boolean isAbstract();

    boolean isExternal();

    @Override // d.n0.a
    /* synthetic */ boolean isFinal();

    boolean isInfix();

    boolean isInline();

    @Override // d.n0.a
    /* synthetic */ boolean isOpen();

    boolean isOperator();

    @Override // d.n0.a
    boolean isSuspend();
}
