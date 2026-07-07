package d.m0;

import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import d.k0.d.t;
import d.m0.g;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes2.dex */
public class h<T extends Comparable<? super T>> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f12691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f12692b;

    public h(T t, T t2) {
        t.checkNotNullParameter(t, RequestBannerParamBo.GET_SPLASH_TYPE);
        t.checkNotNullParameter(t2, "endInclusive");
        this.f12691a = t;
        this.f12692b = t2;
    }

    @Override // d.m0.g
    public boolean contains(T t) {
        t.checkNotNullParameter(t, com.alipay.sdk.m.p0.b.f5579d);
        return g.a.contains(this, t);
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (!t.areEqual(getStart(), hVar.getStart()) || !t.areEqual(getEndInclusive(), hVar.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d.m0.g
    public T getEndInclusive() {
        return this.f12692b;
    }

    @Override // d.m0.g
    public T getStart() {
        return this.f12691a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // d.m0.g
    public boolean isEmpty() {
        return g.a.isEmpty(this);
    }

    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
