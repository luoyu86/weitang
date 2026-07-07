package d.k0.d;

import d.g0.q0;
import d.g0.r0;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements d.n0.b<Object>, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<? extends d.a<?>>, Integer> f12650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f12651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, String> f12652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, String> f12653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f12654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12655f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class<?> f12656g;

    public static final class a {
        public a() {
        }

        public final String getClassQualifiedName(Class<?> cls) {
            String str;
            t.checkNotNullParameter(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) n.f12653d.get(cls.getName());
                return str3 != null ? str3 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            t.checkNotNullExpressionValue(componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) n.f12653d.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 != null ? str2 : "kotlin.Array";
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String getClassSimpleName(java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                d.k0.d.t.checkNotNullParameter(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L11
            Le:
                r1 = r2
                goto Lc1
            L11:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L73
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r1 = r8.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L43
                d.k0.d.t.checkNotNullExpressionValue(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = r1.getName()
                r6.append(r1)
                r6.append(r3)
                java.lang.String r1 = r6.toString()
                java.lang.String r1 = d.p0.y.substringAfter$default(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L43
                goto L66
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L65
                d.k0.d.t.checkNotNullExpressionValue(r0, r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r8 = r8.getName()
                r1.append(r8)
                r1.append(r3)
                java.lang.String r8 = r1.toString()
                java.lang.String r8 = d.p0.y.substringAfter$default(r0, r8, r2, r4, r2)
                r1 = r8
                goto L66
            L65:
                r1 = r2
            L66:
                if (r1 == 0) goto L69
                goto Lc1
            L69:
                d.k0.d.t.checkNotNullExpressionValue(r0, r5)
                r8 = 36
                java.lang.String r1 = d.p0.y.substringAfter$default(r0, r8, r2, r4, r2)
                goto Lc1
            L73:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto Lab
                java.lang.Class r8 = r8.getComponentType()
                java.lang.String r0 = "componentType"
                d.k0.d.t.checkNotNullExpressionValue(r8, r0)
                boolean r0 = r8.isPrimitive()
                if (r0 == 0) goto La7
                java.util.Map r0 = d.k0.d.n.access$getSimpleNames$cp()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto La7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r1)
                java.lang.String r2 = r0.toString()
            La7:
                if (r2 == 0) goto Lc1
                goto Le
            Lab:
                java.util.Map r0 = d.k0.d.n.access$getSimpleNames$cp()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto Lbd
                goto Lc1
            Lbd:
                java.lang.String r1 = r8.getSimpleName()
            Lc1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: d.k0.d.n.a.getClassSimpleName(java.lang.Class):java.lang.String");
        }

        public final boolean isInstance(Object obj, Class<?> cls) {
            t.checkNotNullParameter(cls, "jClass");
            Map map = n.f12650a;
            Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return i0.isFunctionOfArity(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = d.k0.a.getJavaObjectType(d.k0.a.getKotlinClass(cls));
            }
            return cls.isInstance(obj);
        }

        public /* synthetic */ a(p pVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i2 = 0;
        List listListOf = d.g0.s.listOf((Object[]) new Class[]{d.k0.c.a.class, d.k0.c.l.class, d.k0.c.p.class, d.k0.c.q.class, d.k0.c.r.class, d.k0.c.s.class, d.k0.c.t.class, d.k0.c.u.class, d.k0.c.v.class, d.k0.c.w.class, d.k0.c.b.class, d.k0.c.c.class, d.k0.c.d.class, d.k0.c.e.class, d.k0.c.f.class, d.k0.c.g.class, d.k0.c.h.class, d.k0.c.i.class, d.k0.c.j.class, d.k0.c.k.class, d.k0.c.m.class, d.k0.c.n.class, d.k0.c.o.class});
        ArrayList arrayList = new ArrayList(d.g0.t.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                d.g0.s.throwIndexOverflow();
            }
            arrayList.add(d.s.to((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f12650a = r0.toMap(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f12651b = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f12652c = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        t.checkNotNullExpressionValue(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            t.checkNotNullExpressionValue(str, "kotlinName");
            sb.append(d.p0.y.substringAfterLast$default(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            d.m mVar = d.s.to(sb.toString(), str + ".Companion");
            map3.put(mVar.getFirst(), mVar.getSecond());
        }
        for (Map.Entry<Class<? extends d.a<?>>, Integer> entry : f12650a.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f12653d = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(q0.mapCapacity(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), d.p0.y.substringAfterLast$default((String) entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
        f12654e = linkedHashMap;
    }

    public n(Class<?> cls) {
        t.checkNotNullParameter(cls, "jClass");
        this.f12656g = cls;
    }

    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    public static /* synthetic */ void getSupertypes$annotations() {
    }

    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    public static /* synthetic */ void getVisibility$annotations() {
    }

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isFun$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public final Void a() {
        throw new d.k0.b();
    }

    @Override // d.n0.b
    public boolean equals(Object obj) {
        return (obj instanceof n) && t.areEqual(d.k0.a.getJavaObjectType(this), d.k0.a.getJavaObjectType((d.n0.b) obj));
    }

    @Override // d.n0.b
    public List<Annotation> getAnnotations() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public Collection<d.n0.e<Object>> getConstructors() {
        a();
        throw new d.c();
    }

    @Override // d.k0.d.m
    public Class<?> getJClass() {
        return this.f12656g;
    }

    @Override // d.n0.b, d.n0.d
    public Collection<d.n0.a<?>> getMembers() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public Collection<d.n0.b<?>> getNestedClasses() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public Object getObjectInstance() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public String getQualifiedName() {
        return f12655f.getClassQualifiedName(getJClass());
    }

    @Override // d.n0.b
    public List<d.n0.b<? extends Object>> getSealedSubclasses() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public String getSimpleName() {
        return f12655f.getClassSimpleName(getJClass());
    }

    @Override // d.n0.b
    public List<d.n0.o> getSupertypes() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public List<d.n0.p> getTypeParameters() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public d.n0.t getVisibility() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public int hashCode() {
        return d.k0.a.getJavaObjectType(this).hashCode();
    }

    @Override // d.n0.b
    public boolean isAbstract() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public boolean isCompanion() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public boolean isData() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public boolean isFinal() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public boolean isFun() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public boolean isInner() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public boolean isInstance(Object obj) {
        return f12655f.isInstance(obj, getJClass());
    }

    @Override // d.n0.b
    public boolean isOpen() {
        a();
        throw new d.c();
    }

    @Override // d.n0.b
    public boolean isSealed() {
        a();
        throw new d.c();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
