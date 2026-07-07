package c.i.b.z;

import c.i.b.y.b;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? super T> f2698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f2699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2700c;

    public a() {
        Type typeB = b(a.class);
        this.f2699b = typeB;
        this.f2698a = (Class<? super T>) b.getRawType(typeB);
        this.f2700c = typeB.hashCode();
    }

    public static AssertionError a(Type type, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class<?> cls : clsArr) {
            sb.append(cls.getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type.toString());
        sb.append('.');
        return new AssertionError(sb.toString());
    }

    public static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static boolean c(Type type, GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return d(type, (ParameterizedType) genericComponentType, new HashMap());
    }

    public static boolean d(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> rawType = b.getRawType(type);
        ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeParameters = rawType.getTypeParameters();
            for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                Type type2 = actualTypeArguments[i2];
                TypeVariable<Class<?>> typeVariable = typeParameters[i2];
                while (type2 instanceof TypeVariable) {
                    type2 = map.get(((TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (f(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (Type type3 : rawType.getGenericInterfaces()) {
            if (d(type3, parameterizedType, new HashMap(map))) {
                return true;
            }
        }
        return d(rawType.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }

    public static boolean e(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    public static boolean f(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
            if (!e(actualTypeArguments[i2], actualTypeArguments2[i2], map)) {
                return false;
            }
        }
        return true;
    }

    public static a<?> get(Type type) {
        return new a<>(type);
    }

    public static a<?> getArray(Type type) {
        return new a<>(b.arrayOf(type));
    }

    public static a<?> getParameterized(Type type, Type... typeArr) {
        return new a<>(b.newParameterizedTypeWithOwner(null, type, typeArr));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.equals(this.f2699b, ((a) obj).f2699b);
    }

    public final Class<? super T> getRawType() {
        return this.f2698a;
    }

    public final Type getType() {
        return this.f2699b;
    }

    public final int hashCode() {
        return this.f2700c;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    public final String toString() {
        return b.typeToString(this.f2699b);
    }

    public static <T> a<T> get(Class<T> cls) {
        return new a<>(cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.f2699b.equals(type)) {
            return true;
        }
        Type type2 = this.f2699b;
        if (type2 instanceof Class) {
            return this.f2698a.isAssignableFrom(b.getRawType(type));
        }
        if (type2 instanceof ParameterizedType) {
            return d(type, (ParameterizedType) type2, new HashMap());
        }
        if (type2 instanceof GenericArrayType) {
            return this.f2698a.isAssignableFrom(b.getRawType(type)) && c(type, (GenericArrayType) this.f2699b);
        }
        throw a(type2, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    public a(Type type) {
        Type typeCanonicalize = b.canonicalize((Type) c.i.b.y.a.checkNotNull(type));
        this.f2699b = typeCanonicalize;
        this.f2698a = (Class<? super T>) b.getRawType(typeCanonicalize);
        this.f2700c = typeCanonicalize.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(a<?> aVar) {
        return isAssignableFrom(aVar.getType());
    }
}
