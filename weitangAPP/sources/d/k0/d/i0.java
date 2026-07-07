package d.k0.d;

import d.k0.d.n0.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class i0 {
    public static <T extends Throwable> T a(T t) {
        return (T) t.c(t, i0.class.getName());
    }

    public static Collection asMutableCollection(Object obj) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.b)) {
            throwCce(obj, "kotlin.collections.MutableCollection");
        }
        return castToCollection(obj);
    }

    public static Iterable asMutableIterable(Object obj) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.c)) {
            throwCce(obj, "kotlin.collections.MutableIterable");
        }
        return castToIterable(obj);
    }

    public static Iterator asMutableIterator(Object obj) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.d)) {
            throwCce(obj, "kotlin.collections.MutableIterator");
        }
        return castToIterator(obj);
    }

    public static List asMutableList(Object obj) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.e)) {
            throwCce(obj, "kotlin.collections.MutableList");
        }
        return castToList(obj);
    }

    public static ListIterator asMutableListIterator(Object obj) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.f)) {
            throwCce(obj, "kotlin.collections.MutableListIterator");
        }
        return castToListIterator(obj);
    }

    public static Map asMutableMap(Object obj) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.g)) {
            throwCce(obj, "kotlin.collections.MutableMap");
        }
        return castToMap(obj);
    }

    public static Map.Entry asMutableMapEntry(Object obj) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof g.a)) {
            throwCce(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return castToMapEntry(obj);
    }

    public static Set asMutableSet(Object obj) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.h)) {
            throwCce(obj, "kotlin.collections.MutableSet");
        }
        return castToSet(obj);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int i2) {
        if (obj != null && !isFunctionOfArity(obj, i2)) {
            throwCce(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    public static Collection castToCollection(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            throw throwCce(e2);
        }
    }

    public static Iterable castToIterable(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e2) {
            throw throwCce(e2);
        }
    }

    public static Iterator castToIterator(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e2) {
            throw throwCce(e2);
        }
    }

    public static List castToList(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw throwCce(e2);
        }
    }

    public static ListIterator castToListIterator(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e2) {
            throw throwCce(e2);
        }
    }

    public static Map castToMap(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            throw throwCce(e2);
        }
    }

    public static Map.Entry castToMapEntry(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e2) {
            throw throwCce(e2);
        }
    }

    public static Set castToSet(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e2) {
            throw throwCce(e2);
        }
    }

    public static int getFunctionArity(Object obj) {
        if (obj instanceof q) {
            return ((q) obj).getArity();
        }
        if (obj instanceof d.k0.c.a) {
            return 0;
        }
        if (obj instanceof d.k0.c.l) {
            return 1;
        }
        if (obj instanceof d.k0.c.p) {
            return 2;
        }
        if (obj instanceof d.k0.c.q) {
            return 3;
        }
        if (obj instanceof d.k0.c.r) {
            return 4;
        }
        if (obj instanceof d.k0.c.s) {
            return 5;
        }
        if (obj instanceof d.k0.c.t) {
            return 6;
        }
        if (obj instanceof d.k0.c.u) {
            return 7;
        }
        if (obj instanceof d.k0.c.v) {
            return 8;
        }
        if (obj instanceof d.k0.c.w) {
            return 9;
        }
        if (obj instanceof d.k0.c.b) {
            return 10;
        }
        if (obj instanceof d.k0.c.c) {
            return 11;
        }
        if (obj instanceof d.k0.c.d) {
            return 12;
        }
        if (obj instanceof d.k0.c.e) {
            return 13;
        }
        if (obj instanceof d.k0.c.f) {
            return 14;
        }
        if (obj instanceof d.k0.c.g) {
            return 15;
        }
        if (obj instanceof d.k0.c.h) {
            return 16;
        }
        if (obj instanceof d.k0.c.i) {
            return 17;
        }
        if (obj instanceof d.k0.c.j) {
            return 18;
        }
        if (obj instanceof d.k0.c.k) {
            return 19;
        }
        if (obj instanceof d.k0.c.m) {
            return 20;
        }
        if (obj instanceof d.k0.c.n) {
            return 21;
        }
        return obj instanceof d.k0.c.o ? 22 : -1;
    }

    public static boolean isFunctionOfArity(Object obj, int i2) {
        return (obj instanceof d.a) && getFunctionArity(obj) == i2;
    }

    public static boolean isMutableCollection(Object obj) {
        return (obj instanceof Collection) && (!(obj instanceof d.k0.d.n0.a) || (obj instanceof d.k0.d.n0.b));
    }

    public static boolean isMutableIterable(Object obj) {
        return (obj instanceof Iterable) && (!(obj instanceof d.k0.d.n0.a) || (obj instanceof d.k0.d.n0.c));
    }

    public static boolean isMutableIterator(Object obj) {
        return (obj instanceof Iterator) && (!(obj instanceof d.k0.d.n0.a) || (obj instanceof d.k0.d.n0.d));
    }

    public static boolean isMutableList(Object obj) {
        return (obj instanceof List) && (!(obj instanceof d.k0.d.n0.a) || (obj instanceof d.k0.d.n0.e));
    }

    public static boolean isMutableListIterator(Object obj) {
        return (obj instanceof ListIterator) && (!(obj instanceof d.k0.d.n0.a) || (obj instanceof d.k0.d.n0.f));
    }

    public static boolean isMutableMap(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof d.k0.d.n0.a) || (obj instanceof d.k0.d.n0.g));
    }

    public static boolean isMutableMapEntry(Object obj) {
        return (obj instanceof Map.Entry) && (!(obj instanceof d.k0.d.n0.a) || (obj instanceof g.a));
    }

    public static boolean isMutableSet(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof d.k0.d.n0.a) || (obj instanceof d.k0.d.n0.h));
    }

    public static void throwCce(Object obj, String str) {
        throwCce((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int i2, String str) {
        if (obj != null && !isFunctionOfArity(obj, i2)) {
            throwCce(str);
        }
        return obj;
    }

    public static void throwCce(String str) {
        throw throwCce(new ClassCastException(str));
    }

    public static Collection asMutableCollection(Object obj, String str) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.b)) {
            throwCce(str);
        }
        return castToCollection(obj);
    }

    public static Iterable asMutableIterable(Object obj, String str) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.c)) {
            throwCce(str);
        }
        return castToIterable(obj);
    }

    public static Iterator asMutableIterator(Object obj, String str) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.d)) {
            throwCce(str);
        }
        return castToIterator(obj);
    }

    public static List asMutableList(Object obj, String str) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.e)) {
            throwCce(str);
        }
        return castToList(obj);
    }

    public static ListIterator asMutableListIterator(Object obj, String str) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.f)) {
            throwCce(str);
        }
        return castToListIterator(obj);
    }

    public static Map asMutableMap(Object obj, String str) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.g)) {
            throwCce(str);
        }
        return castToMap(obj);
    }

    public static Map.Entry asMutableMapEntry(Object obj, String str) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof g.a)) {
            throwCce(str);
        }
        return castToMapEntry(obj);
    }

    public static Set asMutableSet(Object obj, String str) {
        if ((obj instanceof d.k0.d.n0.a) && !(obj instanceof d.k0.d.n0.h)) {
            throwCce(str);
        }
        return castToSet(obj);
    }

    public static ClassCastException throwCce(ClassCastException classCastException) {
        throw ((ClassCastException) a(classCastException));
    }
}
