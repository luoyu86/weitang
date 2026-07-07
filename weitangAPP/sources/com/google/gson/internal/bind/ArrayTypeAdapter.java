package com.google.gson.internal.bind;

import c.i.b.f;
import c.i.b.v;
import c.i.b.w;
import c.i.b.y.b;
import c.i.b.y.m.c;
import c.i.b.z.a;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayTypeAdapter<E> extends v<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f8991a = new w() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // c.i.b.w
        public <T> v<T> create(f fVar, a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type arrayComponentType = b.getArrayComponentType(type);
            return new ArrayTypeAdapter(fVar, fVar.getAdapter(a.get(arrayComponentType)), b.getRawType(arrayComponentType));
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<E> f8992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v<E> f8993c;

    public ArrayTypeAdapter(f fVar, v<E> vVar, Class<E> cls) {
        this.f8993c = new c(fVar, vVar, cls);
        this.f8992b = cls;
    }

    @Override // c.i.b.v
    public Object read(c.i.b.a0.a aVar) throws IOException {
        if (aVar.peek() == c.i.b.a0.b.NULL) {
            aVar.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.beginArray();
        while (aVar.hasNext()) {
            arrayList.add(this.f8993c.read(aVar));
        }
        aVar.endArray();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f8992b, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // c.i.b.v
    public void write(c.i.b.a0.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.nullValue();
            return;
        }
        cVar.beginArray();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f8993c.write(cVar, (E) Array.get(obj, i2));
        }
        cVar.endArray();
    }
}
