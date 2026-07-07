package com.google.gson.internal.bind;

import c.i.b.e;
import c.i.b.f;
import c.i.b.t;
import c.i.b.v;
import c.i.b.w;
import c.i.b.y.h;
import c.i.b.y.j;
import com.google.gson.internal.Excluder;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.i.b.y.c f9009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f9010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Excluder f9011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f9012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c.i.b.y.n.b f9013e = c.i.b.y.n.b.getInstance();

    public class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Field f9014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f9015e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ v f9016f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ f f9017g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ c.i.b.z.a f9018h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f9019i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z, boolean z2, Field field, boolean z3, v vVar, f fVar, c.i.b.z.a aVar, boolean z4) {
            super(str, z, z2);
            this.f9014d = field;
            this.f9015e = z3;
            this.f9016f = vVar;
            this.f9017g = fVar;
            this.f9018h = aVar;
            this.f9019i = z4;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c
        public void a(c.i.b.a0.a aVar, Object obj) throws IllegalAccessException, IOException {
            Object obj2 = this.f9016f.read(aVar);
            if (obj2 == null && this.f9019i) {
                return;
            }
            this.f9014d.set(obj, obj2);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c
        public void b(c.i.b.a0.c cVar, Object obj) throws IllegalAccessException, IOException {
            (this.f9015e ? this.f9016f : new c.i.b.y.m.c(this.f9017g, this.f9016f, this.f9018h.getType())).write(cVar, this.f9014d.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c
        public boolean writeField(Object obj) throws IllegalAccessException, IOException {
            return this.f9023b && this.f9014d.get(obj) != obj;
        }
    }

    public static final class b<T> extends v<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h<T> f9020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, c> f9021b;

        public b(h<T> hVar, Map<String, c> map) {
            this.f9020a = hVar;
            this.f9021b = map;
        }

        @Override // c.i.b.v
        public T read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            T tConstruct = this.f9020a.construct();
            try {
                aVar.beginObject();
                while (aVar.hasNext()) {
                    c cVar = this.f9021b.get(aVar.nextName());
                    if (cVar == null || !cVar.f9024c) {
                        aVar.skipValue();
                    } else {
                        cVar.a(aVar, tConstruct);
                    }
                }
                aVar.endObject();
                return tConstruct;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new t(e3);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.nullValue();
                return;
            }
            cVar.beginObject();
            try {
                for (c cVar2 : this.f9021b.values()) {
                    if (cVar2.writeField(t)) {
                        cVar.name(cVar2.f9022a);
                        cVar2.b(cVar, t);
                    }
                }
                cVar.endObject();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f9023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f9024c;

        public c(String str, boolean z, boolean z2) {
            this.f9022a = str;
            this.f9023b = z;
            this.f9024c = z2;
        }

        public abstract void a(c.i.b.a0.a aVar, Object obj) throws IllegalAccessException, IOException;

        public abstract void b(c.i.b.a0.c cVar, Object obj) throws IllegalAccessException, IOException;

        public abstract boolean writeField(Object obj) throws IllegalAccessException, IOException;
    }

    public ReflectiveTypeAdapterFactory(c.i.b.y.c cVar, e eVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f9009a = cVar;
        this.f9010b = eVar;
        this.f9011c = excluder;
        this.f9012d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public static boolean b(Field field, boolean z, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }

    public final c a(f fVar, Field field, String str, c.i.b.z.a<?> aVar, boolean z, boolean z2) {
        boolean zIsPrimitive = j.isPrimitive(aVar.getRawType());
        c.i.b.x.b bVar = (c.i.b.x.b) field.getAnnotation(c.i.b.x.b.class);
        v<?> vVarA = bVar != null ? this.f9012d.a(this.f9009a, fVar, aVar, bVar) : null;
        boolean z3 = vVarA != null;
        if (vVarA == null) {
            vVarA = fVar.getAdapter(aVar);
        }
        return new a(str, z, z2, field, z3, vVarA, fVar, aVar, zIsPrimitive);
    }

    public final Map<String, c> c(f fVar, c.i.b.z.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        c.i.b.z.a<?> aVar2 = aVar;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean zExcludeField = excludeField(field, true);
                boolean zExcludeField2 = excludeField(field, z);
                if (zExcludeField || zExcludeField2) {
                    this.f9013e.makeAccessible(field);
                    Type typeResolve = c.i.b.y.b.resolve(aVar2.getType(), rawType, field.getGenericType());
                    List<String> listD = d(field);
                    int size = listD.size();
                    c cVar = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = listD.get(i3);
                        boolean z2 = i3 != 0 ? false : zExcludeField;
                        int i4 = i3;
                        c cVar2 = cVar;
                        int i5 = size;
                        List<String> list = listD;
                        Field field2 = field;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, a(fVar, field, str, c.i.b.z.a.get(typeResolve), z2, zExcludeField2)) : cVar2;
                        i3 = i4 + 1;
                        zExcludeField = z2;
                        listD = list;
                        size = i5;
                        field = field2;
                    }
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar3.f9022a);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = c.i.b.z.a.get(c.i.b.y.b.resolve(aVar2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    @Override // c.i.b.w
    public <T> v<T> create(f fVar, c.i.b.z.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new b(this.f9009a.get(aVar), c(fVar, aVar, rawType));
        }
        return null;
    }

    public final List<String> d(Field field) {
        c.i.b.x.c cVar = (c.i.b.x.c) field.getAnnotation(c.i.b.x.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f9010b.translateName(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public boolean excludeField(Field field, boolean z) {
        return b(field, z, this.f9011c);
    }
}
