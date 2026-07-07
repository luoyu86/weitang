package c.i.b.y;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f2679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f2680b;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        a(map, map2, Boolean.TYPE, Boolean.class);
        a(map, map2, Byte.TYPE, Byte.class);
        a(map, map2, Character.TYPE, Character.class);
        a(map, map2, Double.TYPE, Double.class);
        a(map, map2, Float.TYPE, Float.class);
        a(map, map2, Integer.TYPE, Integer.class);
        a(map, map2, Long.TYPE, Long.class);
        a(map, map2, Short.TYPE, Short.class);
        a(map, map2, Void.TYPE, Void.class);
        f2679a = Collections.unmodifiableMap(map);
        f2680b = Collections.unmodifiableMap(map2);
    }

    public static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean isPrimitive(Type type) {
        return f2679a.containsKey(type);
    }

    public static boolean isWrapperType(Type type) {
        return f2680b.containsKey(a.checkNotNull(type));
    }

    public static <T> Class<T> unwrap(Class<T> cls) {
        Class<T> cls2 = (Class) f2680b.get(a.checkNotNull(cls));
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> wrap(Class<T> cls) {
        Class<T> cls2 = (Class) f2679a.get(a.checkNotNull(cls));
        return cls2 == null ? cls : cls2;
    }
}
