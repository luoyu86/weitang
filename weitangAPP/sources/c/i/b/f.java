package c.i.b;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.i.b.z.a<?> f2589a = c.i.b.z.a.get(Object.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal<Map<c.i.b.z.a<?>, C0034f<?>>> f2590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<c.i.b.z.a<?>, v<?>> f2591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.i.b.y.c f2592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f2593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<w> f2594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Excluder f2595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c.i.b.e f2596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Type, h<?>> f2597i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f2598q;
    public final int r;
    public final int s;
    public final u t;
    public final List<w> u;
    public final List<w> v;

    public class a extends v<Number> {
        public a() {
        }

        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return Double.valueOf(aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.nullValue();
            } else {
                f.d(number.doubleValue());
                cVar.value(number);
            }
        }
    }

    public class b extends v<Number> {
        public b() {
        }

        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return Float.valueOf((float) aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.nullValue();
            } else {
                f.d(number.floatValue());
                cVar.value(number);
            }
        }
    }

    public static class c extends v<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return Long.valueOf(aVar.nextLong());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.nullValue();
            } else {
                cVar.value(number.toString());
            }
        }
    }

    public static class d extends v<AtomicLong> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f2601a;

        public d(v vVar) {
            this.f2601a = vVar;
        }

        @Override // c.i.b.v
        public AtomicLong read(c.i.b.a0.a aVar) throws IOException {
            return new AtomicLong(((Number) this.f2601a.read(aVar)).longValue());
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, AtomicLong atomicLong) throws IOException {
            this.f2601a.write(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    public static class e extends v<AtomicLongArray> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f2602a;

        public e(v vVar) {
            this.f2602a = vVar;
        }

        @Override // c.i.b.v
        public AtomicLongArray read(c.i.b.a0.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.beginArray();
            while (aVar.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.f2602a.read(aVar)).longValue()));
            }
            aVar.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.beginArray();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.f2602a.write(cVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            cVar.endArray();
        }
    }

    /* JADX INFO: renamed from: c.i.b.f$f, reason: collision with other inner class name */
    public static class C0034f<T> extends v<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public v<T> f2603a;

        @Override // c.i.b.v
        public T read(c.i.b.a0.a aVar) throws IOException {
            v<T> vVar = this.f2603a;
            if (vVar != null) {
                return vVar.read(aVar);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(v<T> vVar) {
            if (this.f2603a != null) {
                throw new AssertionError();
            }
            this.f2603a = vVar;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, T t) throws IOException {
            v<T> vVar = this.f2603a;
            if (vVar == null) {
                throw new IllegalStateException();
            }
            vVar.write(cVar, t);
        }
    }

    public f() {
        this(Excluder.f8978a, c.i.b.d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, u.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public static void a(Object obj, c.i.b.a0.a aVar) {
        if (obj != null) {
            try {
                if (aVar.peek() == c.i.b.a0.b.END_DOCUMENT) {
                } else {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (c.i.b.a0.d e2) {
                throw new t(e2);
            } catch (IOException e3) {
                throw new m(e3);
            }
        }
    }

    public static v<AtomicLong> b(v<Number> vVar) {
        return new d(vVar).nullSafe();
    }

    public static v<AtomicLongArray> c(v<Number> vVar) {
        return new e(vVar).nullSafe();
    }

    public static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static v<Number> g(u uVar) {
        return uVar == u.DEFAULT ? TypeAdapters.t : new c();
    }

    public final v<Number> e(boolean z) {
        return z ? TypeAdapters.v : new a();
    }

    public Excluder excluder() {
        return this.f2595g;
    }

    public final v<Number> f(boolean z) {
        return z ? TypeAdapters.u : new b();
    }

    public c.i.b.e fieldNamingStrategy() {
        return this.f2596h;
    }

    public <T> T fromJson(String str, Class<T> cls) throws t {
        return (T) c.i.b.y.j.wrap(cls).cast(fromJson(str, (Type) cls));
    }

    public <T> v<T> getAdapter(c.i.b.z.a<T> aVar) {
        v<T> vVar = (v) this.f2591c.get(aVar == null ? f2589a : aVar);
        if (vVar != null) {
            return vVar;
        }
        Map<c.i.b.z.a<?>, C0034f<?>> map = this.f2590b.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f2590b.set(map);
            z = true;
        }
        C0034f<?> c0034f = map.get(aVar);
        if (c0034f != null) {
            return c0034f;
        }
        try {
            C0034f<?> c0034f2 = new C0034f<>();
            map.put(aVar, c0034f2);
            Iterator<w> it = this.f2594f.iterator();
            while (it.hasNext()) {
                v<T> vVarCreate = it.next().create(this, aVar);
                if (vVarCreate != null) {
                    c0034f2.setDelegate(vVarCreate);
                    this.f2591c.put(aVar, vVarCreate);
                    return vVarCreate;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.f2590b.remove();
            }
        }
    }

    public <T> v<T> getDelegateAdapter(w wVar, c.i.b.z.a<T> aVar) {
        if (!this.f2594f.contains(wVar)) {
            wVar = this.f2593e;
        }
        boolean z = false;
        for (w wVar2 : this.f2594f) {
            if (z) {
                v<T> vVarCreate = wVar2.create(this, aVar);
                if (vVarCreate != null) {
                    return vVarCreate;
                }
            } else if (wVar2 == wVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public boolean htmlSafe() {
        return this.m;
    }

    public g newBuilder() {
        return new g(this);
    }

    public c.i.b.a0.a newJsonReader(Reader reader) {
        c.i.b.a0.a aVar = new c.i.b.a0.a(reader);
        aVar.setLenient(this.o);
        return aVar;
    }

    public c.i.b.a0.c newJsonWriter(Writer writer) throws IOException {
        if (this.l) {
            writer.write(")]}'\n");
        }
        c.i.b.a0.c cVar = new c.i.b.a0.c(writer);
        if (this.n) {
            cVar.setIndent("  ");
        }
        cVar.setSerializeNulls(this.j);
        return cVar;
    }

    public boolean serializeNulls() {
        return this.j;
    }

    public String toJson(Object obj) {
        return obj == null ? toJson((l) n.f2614a) : toJson(obj, obj.getClass());
    }

    public l toJsonTree(Object obj) {
        return obj == null ? n.f2614a : toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.j + ",factories:" + this.f2594f + ",instanceCreators:" + this.f2592d + com.alipay.sdk.m.u.i.f5699d;
    }

    public <T> T fromJson(String str, Type type) throws t {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type);
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public l toJsonTree(Object obj, Type type) {
        c.i.b.y.m.b bVar = new c.i.b.y.m.b();
        toJson(obj, type, bVar);
        return bVar.get();
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws m, t {
        c.i.b.a0.a aVarNewJsonReader = newJsonReader(reader);
        Object objFromJson = fromJson(aVarNewJsonReader, cls);
        a(objFromJson, aVarNewJsonReader);
        return (T) c.i.b.y.j.wrap(cls).cast(objFromJson);
    }

    public f(Excluder excluder, c.i.b.e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, u uVar, String str, int i2, int i3, List<w> list, List<w> list2, List<w> list3) {
        this.f2590b = new ThreadLocal<>();
        this.f2591c = new ConcurrentHashMap();
        this.f2595g = excluder;
        this.f2596h = eVar;
        this.f2597i = map;
        c.i.b.y.c cVar = new c.i.b.y.c(map);
        this.f2592d = cVar;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
        this.o = z6;
        this.p = z7;
        this.t = uVar;
        this.f2598q = str;
        this.r = i2;
        this.s = i3;
        this.u = list;
        this.v = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.Y);
        arrayList.add(ObjectTypeAdapter.f9006a);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.D);
        arrayList.add(TypeAdapters.m);
        arrayList.add(TypeAdapters.f9048g);
        arrayList.add(TypeAdapters.f9050i);
        arrayList.add(TypeAdapters.k);
        v<Number> vVarG = g(uVar);
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, vVarG));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, e(z7)));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, f(z7)));
        arrayList.add(TypeAdapters.x);
        arrayList.add(TypeAdapters.o);
        arrayList.add(TypeAdapters.f9051q);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, b(vVarG)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, c(vVarG)));
        arrayList.add(TypeAdapters.s);
        arrayList.add(TypeAdapters.z);
        arrayList.add(TypeAdapters.F);
        arrayList.add(TypeAdapters.H);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.C));
        arrayList.add(TypeAdapters.J);
        arrayList.add(TypeAdapters.L);
        arrayList.add(TypeAdapters.P);
        arrayList.add(TypeAdapters.R);
        arrayList.add(TypeAdapters.W);
        arrayList.add(TypeAdapters.N);
        arrayList.add(TypeAdapters.f9045d);
        arrayList.add(DateTypeAdapter.f8997a);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TimeTypeAdapter.f9027a);
        arrayList.add(SqlDateTypeAdapter.f9025a);
        arrayList.add(TypeAdapters.S);
        arrayList.add(ArrayTypeAdapter.f8991a);
        arrayList.add(TypeAdapters.f9043b);
        arrayList.add(new CollectionTypeAdapterFactory(cVar));
        arrayList.add(new MapTypeAdapterFactory(cVar, z2));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(cVar);
        this.f2593e = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(cVar, eVar, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f2594f = Collections.unmodifiableList(arrayList);
    }

    public void toJson(Object obj, Appendable appendable) throws m {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((l) n.f2614a, appendable);
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws m {
        try {
            toJson(obj, type, newJsonWriter(c.i.b.y.k.writerForAppendable(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public <T> T fromJson(Reader reader, Type type) throws m, t {
        c.i.b.a0.a aVarNewJsonReader = newJsonReader(reader);
        T t = (T) fromJson(aVarNewJsonReader, type);
        a(t, aVarNewJsonReader);
        return t;
    }

    public void toJson(Object obj, Type type, c.i.b.a0.c cVar) throws m {
        v adapter = getAdapter(c.i.b.z.a.get(type));
        boolean zIsLenient = cVar.isLenient();
        cVar.setLenient(true);
        boolean zIsHtmlSafe = cVar.isHtmlSafe();
        cVar.setHtmlSafe(this.m);
        boolean serializeNulls = cVar.getSerializeNulls();
        cVar.setSerializeNulls(this.j);
        try {
            try {
                adapter.write(cVar, obj);
            } catch (IOException e2) {
                throw new m(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            cVar.setLenient(zIsLenient);
            cVar.setHtmlSafe(zIsHtmlSafe);
            cVar.setSerializeNulls(serializeNulls);
        }
    }

    public <T> T fromJson(c.i.b.a0.a aVar, Type type) throws m, t {
        boolean zIsLenient = aVar.isLenient();
        boolean z = true;
        aVar.setLenient(true);
        try {
            try {
                try {
                    aVar.peek();
                    z = false;
                    T t = getAdapter(c.i.b.z.a.get(type)).read(aVar);
                    aVar.setLenient(zIsLenient);
                    return t;
                } catch (EOFException e2) {
                    if (z) {
                        aVar.setLenient(zIsLenient);
                        return null;
                    }
                    throw new t(e2);
                } catch (AssertionError e3) {
                    throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
                }
            } catch (IOException e4) {
                throw new t(e4);
            } catch (IllegalStateException e5) {
                throw new t(e5);
            }
        } catch (Throwable th) {
            aVar.setLenient(zIsLenient);
            throw th;
        }
    }

    public <T> v<T> getAdapter(Class<T> cls) {
        return getAdapter(c.i.b.z.a.get((Class) cls));
    }

    public <T> T fromJson(l lVar, Class<T> cls) throws t {
        return (T) c.i.b.y.j.wrap(cls).cast(fromJson(lVar, (Type) cls));
    }

    public <T> T fromJson(l lVar, Type type) throws t {
        if (lVar == null) {
            return null;
        }
        return (T) fromJson(new c.i.b.y.m.a(lVar), type);
    }

    public String toJson(l lVar) {
        StringWriter stringWriter = new StringWriter();
        toJson(lVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void toJson(l lVar, Appendable appendable) throws m {
        try {
            toJson(lVar, newJsonWriter(c.i.b.y.k.writerForAppendable(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public void toJson(l lVar, c.i.b.a0.c cVar) throws m {
        boolean zIsLenient = cVar.isLenient();
        cVar.setLenient(true);
        boolean zIsHtmlSafe = cVar.isHtmlSafe();
        cVar.setHtmlSafe(this.m);
        boolean serializeNulls = cVar.getSerializeNulls();
        cVar.setSerializeNulls(this.j);
        try {
            try {
                c.i.b.y.k.write(lVar, cVar);
            } catch (IOException e2) {
                throw new m(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            cVar.setLenient(zIsLenient);
            cVar.setHtmlSafe(zIsHtmlSafe);
            cVar.setSerializeNulls(serializeNulls);
        }
    }
}
