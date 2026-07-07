package c.i.b.y.m;

import c.i.b.f;
import c.i.b.v;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v<T> f2691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f2692c;

    public c(f fVar, v<T> vVar, Type type) {
        this.f2690a = fVar;
        this.f2691b = vVar;
        this.f2692c = type;
    }

    public final Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // c.i.b.v
    public T read(c.i.b.a0.a aVar) throws IOException {
        return this.f2691b.read(aVar);
    }

    @Override // c.i.b.v
    public void write(c.i.b.a0.c cVar, T t) throws IOException {
        v<T> adapter = this.f2691b;
        Type typeA = a(this.f2692c, t);
        if (typeA != this.f2692c) {
            adapter = this.f2690a.getAdapter(c.i.b.z.a.get(typeA));
            if (adapter instanceof ReflectiveTypeAdapterFactory.b) {
                v<T> vVar = this.f2691b;
                if (!(vVar instanceof ReflectiveTypeAdapterFactory.b)) {
                    adapter = vVar;
                }
            }
        }
        adapter.write(cVar, t);
    }
}
