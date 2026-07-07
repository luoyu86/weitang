package d.n0;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a<R> {
    R call(Object... objArr);

    R callBy(Map<j, ? extends Object> map);

    /* synthetic */ List<Annotation> getAnnotations();

    String getName();

    List<j> getParameters();

    o getReturnType();

    List<p> getTypeParameters();

    t getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
