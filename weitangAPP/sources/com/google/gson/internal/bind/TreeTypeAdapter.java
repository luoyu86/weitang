package com.google.gson.internal.bind;

import c.i.b.a0.c;
import c.i.b.f;
import c.i.b.j;
import c.i.b.k;
import c.i.b.l;
import c.i.b.p;
import c.i.b.r;
import c.i.b.s;
import c.i.b.v;
import c.i.b.w;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s<T> f9029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k<T> f9030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f9031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.i.b.z.a<T> f9032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f9033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TreeTypeAdapter<T>.b f9034f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v<T> f9035g;

    public static final class SingleTypeFactory implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c.i.b.z.a<?> f9036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f9037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<?> f9038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final s<?> f9039d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final k<?> f9040e;

        public SingleTypeFactory(Object obj, c.i.b.z.a<?> aVar, boolean z, Class<?> cls) {
            s<?> sVar = obj instanceof s ? (s) obj : null;
            this.f9039d = sVar;
            k<?> kVar = obj instanceof k ? (k) obj : null;
            this.f9040e = kVar;
            c.i.b.y.a.checkArgument((sVar == null && kVar == null) ? false : true);
            this.f9036a = aVar;
            this.f9037b = z;
            this.f9038c = cls;
        }

        @Override // c.i.b.w
        public <T> v<T> create(f fVar, c.i.b.z.a<T> aVar) {
            c.i.b.z.a<?> aVar2 = this.f9036a;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.f9037b && this.f9036a.getType() == aVar.getRawType()) : this.f9038c.isAssignableFrom(aVar.getRawType())) {
                return new TreeTypeAdapter(this.f9039d, this.f9040e, fVar, aVar, this);
            }
            return null;
        }
    }

    public final class b implements r, j {
        public b() {
        }

        @Override // c.i.b.j
        public <R> R deserialize(l lVar, Type type) throws p {
            return (R) TreeTypeAdapter.this.f9031c.fromJson(lVar, type);
        }

        @Override // c.i.b.r
        public l serialize(Object obj) {
            return TreeTypeAdapter.this.f9031c.toJsonTree(obj);
        }

        @Override // c.i.b.r
        public l serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.f9031c.toJsonTree(obj, type);
        }
    }

    public TreeTypeAdapter(s<T> sVar, k<T> kVar, f fVar, c.i.b.z.a<T> aVar, w wVar) {
        this.f9029a = sVar;
        this.f9030b = kVar;
        this.f9031c = fVar;
        this.f9032d = aVar;
        this.f9033e = wVar;
    }

    public static w newFactory(c.i.b.z.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, false, null);
    }

    public static w newFactoryWithMatchRawType(c.i.b.z.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    public static w newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    public final v<T> a() {
        v<T> vVar = this.f9035g;
        if (vVar != null) {
            return vVar;
        }
        v<T> delegateAdapter = this.f9031c.getDelegateAdapter(this.f9033e, this.f9032d);
        this.f9035g = delegateAdapter;
        return delegateAdapter;
    }

    @Override // c.i.b.v
    public T read(c.i.b.a0.a aVar) throws IOException {
        if (this.f9030b == null) {
            return a().read(aVar);
        }
        l lVar = c.i.b.y.k.parse(aVar);
        if (lVar.isJsonNull()) {
            return null;
        }
        return this.f9030b.deserialize(lVar, this.f9032d.getType(), this.f9034f);
    }

    @Override // c.i.b.v
    public void write(c cVar, T t) throws IOException {
        s<T> sVar = this.f9029a;
        if (sVar == null) {
            a().write(cVar, t);
        } else if (t == null) {
            cVar.nullValue();
        } else {
            c.i.b.y.k.write(sVar.serialize(t, this.f9032d.getType(), this.f9034f), cVar);
        }
    }
}
