package h;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface c<R, T> {

    public static abstract class a {
        public static Class<?> a(Type type) {
            return o.i(type);
        }

        @Nullable
        public abstract c<?, ?> get(Type type, Annotation[] annotationArr, m mVar);
    }

    T adapt(b<R> bVar);

    Type responseType();
}
