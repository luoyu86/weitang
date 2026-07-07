package d.n0;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface b<T> extends d, c {
    boolean equals(Object obj);

    /* synthetic */ List<Annotation> getAnnotations();

    Collection<e<T>> getConstructors();

    @Override // d.n0.d
    Collection<a<?>> getMembers();

    Collection<b<?>> getNestedClasses();

    T getObjectInstance();

    String getQualifiedName();

    List<b<? extends T>> getSealedSubclasses();

    String getSimpleName();

    List<o> getSupertypes();

    List<p> getTypeParameters();

    t getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isFun();

    boolean isInner();

    boolean isInstance(Object obj);

    boolean isOpen();

    boolean isSealed();
}
