package com.google.gson.internal.bind;

import c.i.b.f;
import c.i.b.k;
import c.i.b.s;
import c.i.b.v;
import c.i.b.w;
import c.i.b.x.b;
import c.i.b.y.c;
import c.i.b.z.a;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8999a;

    public JsonAdapterAnnotationTypeAdapterFactory(c cVar) {
        this.f8999a = cVar;
    }

    public v<?> a(c cVar, f fVar, a<?> aVar, b bVar) {
        v<?> treeTypeAdapter;
        Object objConstruct = cVar.get(a.get((Class) bVar.value())).construct();
        if (objConstruct instanceof v) {
            treeTypeAdapter = (v) objConstruct;
        } else if (objConstruct instanceof w) {
            treeTypeAdapter = ((w) objConstruct).create(fVar, aVar);
        } else {
            boolean z = objConstruct instanceof s;
            if (!z && !(objConstruct instanceof k)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objConstruct.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z ? (s) objConstruct : null, objConstruct instanceof k ? (k) objConstruct : null, fVar, aVar, null);
        }
        return (treeTypeAdapter == null || !bVar.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // c.i.b.w
    public <T> v<T> create(f fVar, a<T> aVar) {
        b bVar = (b) aVar.getRawType().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return (v<T>) a(this.f8999a, fVar, aVar, bVar);
    }
}
