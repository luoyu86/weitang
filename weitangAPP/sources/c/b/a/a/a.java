package c.b.a.a;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a<T> implements c.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<T> f836a;

    public a(List<T> list) {
        this.f836a = list;
    }

    @Override // c.f.a.a
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.f836a.size()) ? "" : this.f836a.get(i2);
    }

    @Override // c.f.a.a
    public int getItemsCount() {
        return this.f836a.size();
    }

    @Override // c.f.a.a
    public int indexOf(Object obj) {
        return this.f836a.indexOf(obj);
    }
}
