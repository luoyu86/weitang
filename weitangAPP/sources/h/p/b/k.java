package h.p.b;

import h.e;
import h.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends e.a {
    public static k create() {
        return new k();
    }

    @Override // h.e.a
    public h.e<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        if (type == String.class || type == Boolean.TYPE || type == Boolean.class || type == Byte.TYPE || type == Byte.class || type == Character.TYPE || type == Character.class || type == Double.TYPE || type == Double.class || type == Float.TYPE || type == Float.class || type == Integer.TYPE || type == Integer.class || type == Long.TYPE || type == Long.class || type == Short.TYPE || type == Short.class) {
            return a.f14875a;
        }
        return null;
    }

    @Override // h.e.a
    public h.e<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, m mVar) {
        if (type == String.class) {
            return j.f14885a;
        }
        if (type == Boolean.class || type == Boolean.TYPE) {
            return b.f14877a;
        }
        if (type == Byte.class || type == Byte.TYPE) {
            return c.f14878a;
        }
        if (type == Character.class || type == Character.TYPE) {
            return d.f14879a;
        }
        if (type == Double.class || type == Double.TYPE) {
            return e.f14880a;
        }
        if (type == Float.class || type == Float.TYPE) {
            return f.f14881a;
        }
        if (type == Integer.class || type == Integer.TYPE) {
            return g.f14882a;
        }
        if (type == Long.class || type == Long.TYPE) {
            return h.f14883a;
        }
        if (type == Short.class || type == Short.TYPE) {
            return i.f14884a;
        }
        return null;
    }
}
