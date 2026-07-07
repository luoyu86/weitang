package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ButterKnife {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f781a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public static final Map<Class<?>, Constructor<? extends Unbinder>> f782b = new LinkedHashMap();

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @CheckResult
    @UiThread
    public static Constructor<? extends Unbinder> a(Class<?> cls) {
        Constructor<? extends Unbinder> constructorA;
        Map<Class<?>, Constructor<? extends Unbinder>> map = f782b;
        Constructor<? extends Unbinder> constructor = map.get(cls);
        if (constructor != null || map.containsKey(cls)) {
            if (f781a) {
                Log.d("ButterKnife", "HIT: Cached in binding map.");
            }
            return constructor;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("androidx.")) {
            if (!f781a) {
                return null;
            }
            Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            return null;
        }
        try {
            constructorA = cls.getClassLoader().loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
            if (f781a) {
                Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
            }
        } catch (ClassNotFoundException unused) {
            if (f781a) {
                Log.d("ButterKnife", "Not found. Trying superclass " + cls.getSuperclass().getName());
            }
            constructorA = a(cls.getSuperclass());
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Unable to find binding constructor for " + name, e2);
        }
        f782b.put(cls, constructorA);
        return constructorA;
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Activity activity) {
        return bind(activity, activity.getWindow().getDecorView());
    }

    public static void setDebug(boolean z) {
        f781a = z;
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull View view) {
        return bind(view, view);
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Dialog dialog) {
        return bind(dialog, dialog.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull Activity activity) {
        return bind(obj, activity.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull Dialog dialog) {
        return bind(obj, dialog.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull View view) {
        Class<?> cls = obj.getClass();
        if (f781a) {
            Log.d("ButterKnife", "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> constructorA = a(cls);
        if (constructorA == null) {
            return Unbinder.f786a;
        }
        try {
            return constructorA.newInstance(obj, view);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to invoke " + constructorA, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Unable to invoke " + constructorA, e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }
}
