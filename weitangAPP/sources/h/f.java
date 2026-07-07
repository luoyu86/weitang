package h;

import h.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.a f14756a = new f();

    public class a implements c<Object, b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f14757a;

        public a(Type type) {
            this.f14757a = type;
        }

        @Override // h.c
        /* JADX INFO: renamed from: adapt, reason: merged with bridge method [inline-methods] */
        public b<?> adapt2(b<Object> bVar) {
            return bVar;
        }

        @Override // h.c
        public Type responseType() {
            return this.f14757a;
        }
    }

    @Override // h.c.a
    public c<?, ?> get(Type type, Annotation[] annotationArr, m mVar) {
        if (c.a.a(type) != b.class) {
            return null;
        }
        return new a(o.f(type));
    }
}
