package c.n.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends d<T, Float> {
    public a(String str) {
        super(Float.class, str);
    }

    public abstract void setValue(T t, float f2);

    @Override // c.n.b.d
    public final void set(T t, Float f2) {
        setValue(t, f2.floatValue());
    }
}
