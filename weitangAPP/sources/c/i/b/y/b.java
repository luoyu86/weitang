package c.i.b.y;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f2620a = new Type[0];

    public static final class a implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f2621a;

        public a(Type type) {
            this.f2621a = b.canonicalize(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && b.equals(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f2621a;
        }

        public int hashCode() {
            return this.f2621a.hashCode();
        }

        public String toString() {
            return b.typeToString(this.f2621a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: renamed from: c.i.b.y.b$b, reason: collision with other inner class name */
    public static final class C0035b implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f2622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f2623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Type[] f2624c;

        public C0035b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                c.i.b.y.a.checkArgument(z);
            }
            this.f2622a = type == null ? null : b.canonicalize(type);
            this.f2623b = b.canonicalize(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.f2624c = typeArr2;
            int length = typeArr2.length;
            for (int i2 = 0; i2 < length; i2++) {
                c.i.b.y.a.checkNotNull(this.f2624c[i2]);
                b.a(this.f2624c[i2]);
                Type[] typeArr3 = this.f2624c;
                typeArr3[i2] = b.canonicalize(typeArr3[i2]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && b.equals(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f2624c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f2622a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f2623b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f2624c) ^ this.f2623b.hashCode()) ^ b.f(this.f2622a);
        }

        public String toString() {
            int length = this.f2624c.length;
            if (length == 0) {
                return b.typeToString(this.f2623b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(b.typeToString(this.f2623b));
            sb.append("<");
            sb.append(b.typeToString(this.f2624c[0]));
            for (int i2 = 1; i2 < length; i2++) {
                sb.append(", ");
                sb.append(b.typeToString(this.f2624c[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    public static final class c implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f2625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f2626b;

        public c(Type[] typeArr, Type[] typeArr2) {
            c.i.b.y.a.checkArgument(typeArr2.length <= 1);
            c.i.b.y.a.checkArgument(typeArr.length == 1);
            if (typeArr2.length != 1) {
                c.i.b.y.a.checkNotNull(typeArr[0]);
                b.a(typeArr[0]);
                this.f2626b = null;
                this.f2625a = b.canonicalize(typeArr[0]);
                return;
            }
            c.i.b.y.a.checkNotNull(typeArr2[0]);
            b.a(typeArr2[0]);
            c.i.b.y.a.checkArgument(typeArr[0] == Object.class);
            this.f2626b = b.canonicalize(typeArr2[0]);
            this.f2625a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && b.equals(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f2626b;
            return type != null ? new Type[]{type} : b.f2620a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f2625a};
        }

        public int hashCode() {
            Type type = this.f2626b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f2625a.hashCode() + 31);
        }

        public String toString() {
            if (this.f2626b != null) {
                return "? super " + b.typeToString(this.f2626b);
            }
            if (this.f2625a == Object.class) {
                return "?";
            }
            return "? extends " + b.typeToString(this.f2625a);
        }
    }

    public static void a(Type type) {
        c.i.b.y.a.checkArgument(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static GenericArrayType arrayOf(Type type) {
        return new a(type);
    }

    public static Class<?> b(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(canonicalize(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0035b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static Type d(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (interfaces[i2] == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(interfaces[i2])) {
                    return d(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return d(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type e(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        c.i.b.y.a.checkArgument(cls2.isAssignableFrom(cls));
        return resolve(type, cls, d(type, cls, cls2));
    }

    public static boolean equals(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return c(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static int f(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int g(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    public static Type getArrayComponentType(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        Type typeE = e(type, cls, Collection.class);
        if (typeE instanceof WildcardType) {
            typeE = ((WildcardType) typeE).getUpperBounds()[0];
        }
        return typeE instanceof ParameterizedType ? ((ParameterizedType) typeE).getActualTypeArguments()[0] : Object.class;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type typeE = e(type, cls, Map.class);
        return typeE instanceof ParameterizedType ? ((ParameterizedType) typeE).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            c.i.b.y.a.checkArgument(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static Type h(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        while (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            if (collection.contains(typeVariable)) {
                return type2;
            }
            collection.add(typeVariable);
            type2 = i(type, cls, typeVariable);
            if (type2 == typeVariable) {
                return type2;
            }
        }
        if (type2 instanceof Class) {
            Class cls2 = (Class) type2;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type typeH = h(type, cls, componentType, collection);
                return componentType == typeH ? cls2 : arrayOf(typeH);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeH2 = h(type, cls, genericComponentType, collection);
            return genericComponentType == typeH2 ? genericArrayType : arrayOf(typeH2);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeH3 = h(type, cls, ownerType, collection);
            boolean z = typeH3 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i2 = 0; i2 < length; i2++) {
                Type typeH4 = h(type, cls, actualTypeArguments[i2], collection);
                if (typeH4 != actualTypeArguments[i2]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i2] = typeH4;
                }
            }
            return z ? newParameterizedTypeWithOwner(typeH3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z2 = type2 instanceof WildcardType;
        Type type3 = type2;
        if (z2) {
            WildcardType wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeH5 = h(type, cls, lowerBounds[0], collection);
                type3 = wildcardType;
                if (typeH5 != lowerBounds[0]) {
                    return supertypeOf(typeH5);
                }
            } else {
                type3 = wildcardType;
                if (upperBounds.length == 1) {
                    Type typeH6 = h(type, cls, upperBounds[0], collection);
                    type3 = wildcardType;
                    if (typeH6 != upperBounds[0]) {
                        return subtypeOf(typeH6);
                    }
                }
            }
        }
        return type3;
    }

    public static Type i(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsB = b(typeVariable);
        if (clsB == null) {
            return typeVariable;
        }
        Type typeD = d(type, cls, clsB);
        if (!(typeD instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeD).getActualTypeArguments()[g(clsB.getTypeParameters(), typeVariable)];
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new C0035b(type, type2, typeArr);
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        return h(type, cls, type2, new HashSet());
    }

    public static WildcardType subtypeOf(Type type) {
        return new c(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f2620a);
    }

    public static WildcardType supertypeOf(Type type) {
        return new c(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
