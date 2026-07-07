package c.n.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<V> f2921b;

    public d(Class<V> cls, String str) {
        this.f2920a = str;
        this.f2921b = cls;
    }

    public static <T, V> d<T, V> of(Class<T> cls, Class<V> cls2, String str) {
        return new e(cls, cls2, str);
    }

    public abstract V get(T t);

    public String getName() {
        return this.f2920a;
    }

    public Class<V> getType() {
        return this.f2921b;
    }

    public boolean isReadOnly() {
        return false;
    }

    public void set(T t, V v) {
        throw new UnsupportedOperationException("Property " + getName() + " is read-only");
    }
}
