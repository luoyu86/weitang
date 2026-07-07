package g.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class a0 extends d0 {
    public a0() {
        super(3);
    }

    @Override // g.a.c.d0, g.a.j.m
    public Object clone() {
        return new a0();
    }

    public boolean equals(Object obj) {
        return obj instanceof a0;
    }

    public int hashCode() {
        return 3;
    }

    @Override // g.a.c.d0, g.a.j.m
    public boolean match(Object obj) {
        return obj instanceof b0;
    }
}
