package h;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import h.c;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f14809a = b();

    public static class a extends j {

        /* JADX INFO: renamed from: h.j$a$a, reason: collision with other inner class name */
        public static class ExecutorC0269a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Handler f14810a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f14810a.post(runnable);
            }
        }

        @Override // h.j
        public c.a a(@Nullable Executor executor) {
            if (executor != null) {
                return new g(executor);
            }
            throw new AssertionError();
        }

        @Override // h.j
        public Executor defaultCallbackExecutor() {
            return new ExecutorC0269a();
        }
    }

    @IgnoreJRERequirement
    public static class b extends j {
        @Override // h.j
        public Object d(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // h.j
        public boolean e(Method method) {
            return method.isDefault();
        }
    }

    public static j b() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new j();
        }
    }

    public static j c() {
        return f14809a;
    }

    public c.a a(@Nullable Executor executor) {
        return executor != null ? new g(executor) : f.f14756a;
    }

    @Nullable
    public Object d(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    public boolean e(Method method) {
        return false;
    }
}
