package c.i.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f2587a;

    public c(Field field) {
        c.i.b.y.a.checkNotNull(field);
        this.f2587a = field;
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.f2587a.getAnnotation(cls);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.f2587a.getAnnotations());
    }

    public Class<?> getDeclaredClass() {
        return this.f2587a.getType();
    }

    public Type getDeclaredType() {
        return this.f2587a.getGenericType();
    }

    public Class<?> getDeclaringClass() {
        return this.f2587a.getDeclaringClass();
    }

    public String getName() {
        return this.f2587a.getName();
    }

    public boolean hasModifier(int i2) {
        return (i2 & this.f2587a.getModifiers()) != 0;
    }
}
