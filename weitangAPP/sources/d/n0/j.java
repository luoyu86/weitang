package d.n0;

import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface j {

    public enum a {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    /* synthetic */ List<Annotation> getAnnotations();

    int getIndex();

    a getKind();

    String getName();

    o getType();

    boolean isOptional();

    boolean isVararg();
}
