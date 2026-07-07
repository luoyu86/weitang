package com.google.gson.internal.bind;

import c.i.b.a0.b;
import c.i.b.f;
import c.i.b.l;
import c.i.b.q;
import c.i.b.t;
import c.i.b.v;
import c.i.b.w;
import c.i.b.y.c;
import c.i.b.y.e;
import c.i.b.y.h;
import c.i.b.y.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9001b;

    public final class a<K, V> extends v<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v<K> f9002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v<V> f9003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h<? extends Map<K, V>> f9004c;

        public a(f fVar, Type type, v<K> vVar, Type type2, v<V> vVar2, h<? extends Map<K, V>> hVar) {
            this.f9002a = new c.i.b.y.m.c(fVar, vVar, type);
            this.f9003b = new c.i.b.y.m.c(fVar, vVar2, type2);
            this.f9004c = hVar;
        }

        public final String a(l lVar) {
            if (!lVar.isJsonPrimitive()) {
                if (lVar.isJsonNull()) {
                    return "null";
                }
                throw new AssertionError();
            }
            q asJsonPrimitive = lVar.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                return String.valueOf(asJsonPrimitive.getAsNumber());
            }
            if (asJsonPrimitive.isBoolean()) {
                return Boolean.toString(asJsonPrimitive.getAsBoolean());
            }
            if (asJsonPrimitive.isString()) {
                return asJsonPrimitive.getAsString();
            }
            throw new AssertionError();
        }

        @Override // c.i.b.v
        public Map<K, V> read(c.i.b.a0.a aVar) throws IOException {
            b bVarPeek = aVar.peek();
            if (bVarPeek == b.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> mapConstruct = this.f9004c.construct();
            if (bVarPeek == b.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K k = this.f9002a.read(aVar);
                    if (mapConstruct.put(k, this.f9003b.read(aVar)) != null) {
                        throw new t("duplicate key: " + k);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
            } else {
                aVar.beginObject();
                while (aVar.hasNext()) {
                    e.f2653a.promoteNameToValue(aVar);
                    K k2 = this.f9002a.read(aVar);
                    if (mapConstruct.put(k2, this.f9003b.read(aVar)) != null) {
                        throw new t("duplicate key: " + k2);
                    }
                }
                aVar.endObject();
            }
            return mapConstruct;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.nullValue();
                return;
            }
            if (!MapTypeAdapterFactory.this.f9001b) {
                cVar.beginObject();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.name(String.valueOf(entry.getKey()));
                    this.f9003b.write(cVar, entry.getValue());
                }
                cVar.endObject();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                l jsonTree = this.f9002a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (!z) {
                cVar.beginObject();
                int size = arrayList.size();
                while (i2 < size) {
                    cVar.name(a((l) arrayList.get(i2)));
                    this.f9003b.write(cVar, (V) arrayList2.get(i2));
                    i2++;
                }
                cVar.endObject();
                return;
            }
            cVar.beginArray();
            int size2 = arrayList.size();
            while (i2 < size2) {
                cVar.beginArray();
                k.write((l) arrayList.get(i2), cVar);
                this.f9003b.write(cVar, (V) arrayList2.get(i2));
                cVar.endArray();
                i2++;
            }
            cVar.endArray();
        }
    }

    public MapTypeAdapterFactory(c cVar, boolean z) {
        this.f9000a = cVar;
        this.f9001b = z;
    }

    public final v<?> a(f fVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f9047f : fVar.getAdapter(c.i.b.z.a.get(type));
    }

    @Override // c.i.b.w
    public <T> v<T> create(f fVar, c.i.b.z.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] mapKeyAndValueTypes = c.i.b.y.b.getMapKeyAndValueTypes(type, c.i.b.y.b.getRawType(type));
        return new a(fVar, mapKeyAndValueTypes[0], a(fVar, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], fVar.getAdapter(c.i.b.z.a.get(mapKeyAndValueTypes[1])), this.f9000a.get(aVar));
    }
}
