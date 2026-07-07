package h;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public interface e<F, T> {

    public static abstract class a {
        @Nullable
        public e<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
            return null;
        }

        @Nullable
        public e<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, m mVar) {
            return null;
        }

        @Nullable
        public e<?, String> stringConverter(Type type, Annotation[] annotationArr, m mVar) {
            return null;
        }
    }

    T convert(F f2) throws IOException;
}
