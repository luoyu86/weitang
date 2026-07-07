package c.n.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> extends d<T, Integer> {
    public b(String str) {
        super(Integer.class, str);
    }

    public abstract void setValue(T t, int i2);

    @Override // c.n.b.d
    public final void set(T t, Integer num) {
        set((Object) t, Integer.valueOf(num.intValue()));
    }
}
