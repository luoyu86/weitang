package c.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class b implements c.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f838b;

    public b(int i2, int i3) {
        this.f837a = i2;
        this.f838b = i3;
    }

    @Override // c.f.a.a
    public Object getItem(int i2) {
        if (i2 < 0 || i2 >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.f837a + i2);
    }

    @Override // c.f.a.a
    public int getItemsCount() {
        return (this.f838b - this.f837a) + 1;
    }

    @Override // c.f.a.a
    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.f837a;
        } catch (Exception unused) {
            return -1;
        }
    }
}
