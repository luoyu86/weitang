package c.i.b;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Excluder f2604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f2605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f2606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Type, h<?>> f2607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<w> f2608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<w> f2609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2612i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    public g() {
        this.f2604a = Excluder.f8978a;
        this.f2605b = u.DEFAULT;
        this.f2606c = d.IDENTITY;
        this.f2607d = new HashMap();
        this.f2608e = new ArrayList();
        this.f2609f = new ArrayList();
        this.f2610g = false;
        this.f2612i = 2;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
    }

    public final void a(String str, int i2, int i3, List<w> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a((Class<? extends Date>) Date.class, str);
            aVar2 = new a((Class<? extends Date>) Timestamp.class, str);
            aVar3 = new a((Class<? extends Date>) java.sql.Date.class, str);
        } else {
            if (i2 == 2 || i3 == 2) {
                return;
            }
            a aVar4 = new a(Date.class, i2, i3);
            a aVar5 = new a(Timestamp.class, i2, i3);
            a aVar6 = new a(java.sql.Date.class, i2, i3);
            aVar = aVar4;
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(TypeAdapters.newFactory(Date.class, aVar));
        list.add(TypeAdapters.newFactory(Timestamp.class, aVar2));
        list.add(TypeAdapters.newFactory(java.sql.Date.class, aVar3));
    }

    public g addDeserializationExclusionStrategy(b bVar) {
        this.f2604a = this.f2604a.withExclusionStrategy(bVar, false, true);
        return this;
    }

    public g addSerializationExclusionStrategy(b bVar) {
        this.f2604a = this.f2604a.withExclusionStrategy(bVar, true, false);
        return this;
    }

    public f create() {
        List<w> arrayList = new ArrayList<>(this.f2608e.size() + this.f2609f.size() + 3);
        arrayList.addAll(this.f2608e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f2609f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f2611h, this.f2612i, this.j, arrayList);
        return new f(this.f2604a, this.f2606c, this.f2607d, this.f2610g, this.k, this.o, this.m, this.n, this.p, this.l, this.f2605b, this.f2611h, this.f2612i, this.j, this.f2608e, this.f2609f, arrayList);
    }

    public g disableHtmlEscaping() {
        this.m = false;
        return this;
    }

    public g disableInnerClassSerialization() {
        this.f2604a = this.f2604a.disableInnerClassSerialization();
        return this;
    }

    public g enableComplexMapKeySerialization() {
        this.k = true;
        return this;
    }

    public g excludeFieldsWithModifiers(int... iArr) {
        this.f2604a = this.f2604a.withModifiers(iArr);
        return this;
    }

    public g excludeFieldsWithoutExposeAnnotation() {
        this.f2604a = this.f2604a.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public g generateNonExecutableJson() {
        this.o = true;
        return this;
    }

    public g registerTypeAdapter(Type type, Object obj) {
        boolean z = obj instanceof s;
        c.i.b.y.a.checkArgument(z || (obj instanceof k) || (obj instanceof h) || (obj instanceof v));
        if (obj instanceof h) {
            this.f2607d.put(type, (h) obj);
        }
        if (z || (obj instanceof k)) {
            this.f2608e.add(TreeTypeAdapter.newFactoryWithMatchRawType(c.i.b.z.a.get(type), obj));
        }
        if (obj instanceof v) {
            this.f2608e.add(TypeAdapters.newFactory(c.i.b.z.a.get(type), (v) obj));
        }
        return this;
    }

    public g registerTypeAdapterFactory(w wVar) {
        this.f2608e.add(wVar);
        return this;
    }

    public g registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        boolean z = obj instanceof s;
        c.i.b.y.a.checkArgument(z || (obj instanceof k) || (obj instanceof v));
        if ((obj instanceof k) || z) {
            this.f2609f.add(TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
        }
        if (obj instanceof v) {
            this.f2608e.add(TypeAdapters.newTypeHierarchyFactory(cls, (v) obj));
        }
        return this;
    }

    public g serializeNulls() {
        this.f2610g = true;
        return this;
    }

    public g serializeSpecialFloatingPointValues() {
        this.l = true;
        return this;
    }

    public g setDateFormat(String str) {
        this.f2611h = str;
        return this;
    }

    public g setExclusionStrategies(b... bVarArr) {
        for (b bVar : bVarArr) {
            this.f2604a = this.f2604a.withExclusionStrategy(bVar, true, true);
        }
        return this;
    }

    public g setFieldNamingPolicy(d dVar) {
        this.f2606c = dVar;
        return this;
    }

    public g setFieldNamingStrategy(e eVar) {
        this.f2606c = eVar;
        return this;
    }

    public g setLenient() {
        this.p = true;
        return this;
    }

    public g setLongSerializationPolicy(u uVar) {
        this.f2605b = uVar;
        return this;
    }

    public g setPrettyPrinting() {
        this.n = true;
        return this;
    }

    public g setVersion(double d2) {
        this.f2604a = this.f2604a.withVersion(d2);
        return this;
    }

    public g setDateFormat(int i2) {
        this.f2612i = i2;
        this.f2611h = null;
        return this;
    }

    public g setDateFormat(int i2, int i3) {
        this.f2612i = i2;
        this.j = i3;
        this.f2611h = null;
        return this;
    }

    public g(f fVar) {
        this.f2604a = Excluder.f8978a;
        this.f2605b = u.DEFAULT;
        this.f2606c = d.IDENTITY;
        HashMap map = new HashMap();
        this.f2607d = map;
        ArrayList arrayList = new ArrayList();
        this.f2608e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f2609f = arrayList2;
        this.f2610g = false;
        this.f2612i = 2;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.f2604a = fVar.f2595g;
        this.f2606c = fVar.f2596h;
        map.putAll(fVar.f2597i);
        this.f2610g = fVar.j;
        this.k = fVar.k;
        this.o = fVar.l;
        this.m = fVar.m;
        this.n = fVar.n;
        this.p = fVar.o;
        this.l = fVar.p;
        this.f2605b = fVar.t;
        this.f2611h = fVar.f2598q;
        this.f2612i = fVar.r;
        this.j = fVar.s;
        arrayList.addAll(fVar.u);
        arrayList2.addAll(fVar.v);
    }
}
