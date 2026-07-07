package d.g0;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class u extends t {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterator<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Enumeration f12552a;

        public a(Enumeration<T> enumeration) {
            this.f12552a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12552a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f12552a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final <T> Iterator<T> iterator(Enumeration<T> enumeration) {
        d.k0.d.t.checkNotNullParameter(enumeration, "$this$iterator");
        return new a(enumeration);
    }
}
