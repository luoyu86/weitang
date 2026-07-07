package c.i.b.y.n;

import c.i.b.m;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class f2695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2696c = b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Field f2697d = a();

    public static Field a() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static Object b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f2695b = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean c(AccessibleObject accessibleObject) {
        if (this.f2696c != null && this.f2697d != null) {
            try {
                f2695b.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f2696c, accessibleObject, Long.valueOf(((Long) f2695b.getMethod("objectFieldOffset", Field.class).invoke(this.f2696c, this.f2697d)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // c.i.b.y.n.b
    public void makeAccessible(AccessibleObject accessibleObject) {
        if (c(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new m("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }
}
