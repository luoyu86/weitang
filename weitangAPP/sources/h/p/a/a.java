package h.p.a;

import c.i.b.f;
import h.e;
import h.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f14868a;

    public a(f fVar) {
        this.f14868a = fVar;
    }

    public static a create() {
        return create(new f());
    }

    @Override // h.e.a
    public e<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        return new b(this.f14868a, this.f14868a.getAdapter(c.i.b.z.a.get(type)));
    }

    @Override // h.e.a
    public e<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, m mVar) {
        return new c(this.f14868a, this.f14868a.getAdapter(c.i.b.z.a.get(type)));
    }

    public static a create(f fVar) {
        Objects.requireNonNull(fVar, "gson == null");
        return new a(fVar);
    }
}
