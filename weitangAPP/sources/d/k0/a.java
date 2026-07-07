package d.k0;

import com.tom_roush.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import d.k0.d.f0;
import d.k0.d.m;
import d.k0.d.t;
import java.lang.annotation.Annotation;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final <T extends Annotation> d.n0.b<? extends T> getAnnotationClass(T t) {
        t.checkNotNullParameter(t, "$this$annotationClass");
        Class<? extends Annotation> clsAnnotationType = t.annotationType();
        t.checkNotNullExpressionValue(clsAnnotationType, "(this as java.lang.annot…otation).annotationType()");
        d.n0.b<? extends T> kotlinClass = getKotlinClass(clsAnnotationType);
        Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
        return kotlinClass;
    }

    public static final <T> Class<T> getJavaClass(d.n0.b<T> bVar) {
        t.checkNotNullParameter(bVar, "$this$java");
        Class<T> cls = (Class<T>) ((m) bVar).getJClass();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<T>");
        return cls;
    }

    public static /* synthetic */ void getJavaClass$annotations(d.n0.b bVar) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final <T> Class<T> getJavaObjectType(d.n0.b<T> bVar) {
        t.checkNotNullParameter(bVar, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((m) bVar).getJClass();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                }
                break;
            case 104431:
                if (name.equals("int")) {
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                }
                break;
        }
        return cls;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final <T> Class<T> getJavaPrimitiveType(d.n0.b<T> bVar) {
        t.checkNotNullParameter(bVar, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((m) bVar).getJClass();
        if (cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final <T> d.n0.b<T> getKotlinClass(Class<T> cls) {
        t.checkNotNullParameter(cls, "$this$kotlin");
        return f0.getOrCreateKotlinClass(cls);
    }

    public static final <T> Class<d.n0.b<T>> getRuntimeClassOfKClassInstance(d.n0.b<T> bVar) {
        t.checkNotNullParameter(bVar, "$this$javaClass");
        Class<d.n0.b<T>> cls = (Class<d.n0.b<T>>) bVar.getClass();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
        return cls;
    }

    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(d.n0.b bVar) {
    }

    public static final /* synthetic */ <T> boolean isArrayOf(Object[] objArr) {
        t.checkNotNullParameter(objArr, "$this$isArrayOf");
        t.reifiedOperationMarker(4, PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE);
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    public static final <T> Class<T> getJavaClass(T t) {
        t.checkNotNullParameter(t, "$this$javaClass");
        Class<T> cls = (Class<T>) t.getClass();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<T>");
        return cls;
    }
}
