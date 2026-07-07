package com.google.gson.internal.bind;

import c.i.b.a0.b;
import c.i.b.f;
import c.i.b.v;
import c.i.b.w;
import c.i.b.y.c;
import c.i.b.y.h;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8994a;

    public static final class a<E> extends v<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v<E> f8995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h<? extends Collection<E>> f8996b;

        public a(f fVar, Type type, v<E> vVar, h<? extends Collection<E>> hVar) {
            this.f8995a = new c.i.b.y.m.c(fVar, vVar, type);
            this.f8996b = hVar;
        }

        @Override // c.i.b.v
        public Collection<E> read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == b.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> collectionConstruct = this.f8996b.construct();
            aVar.beginArray();
            while (aVar.hasNext()) {
                collectionConstruct.add(this.f8995a.read(aVar));
            }
            aVar.endArray();
            return collectionConstruct;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.nullValue();
                return;
            }
            cVar.beginArray();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f8995a.write(cVar, it.next());
            }
            cVar.endArray();
        }
    }

    public CollectionTypeAdapterFactory(c cVar) {
        this.f8994a = cVar;
    }

    @Override // c.i.b.w
    public <T> v<T> create(f fVar, c.i.b.z.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = c.i.b.y.b.getCollectionElementType(type, rawType);
        return new a(fVar, collectionElementType, fVar.getAdapter(c.i.b.z.a.get(collectionElementType)), this.f8994a.get(aVar));
    }
}
