package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class t1 extends n {
    public t1(byte[] bArr) {
        this(bArr, true);
    }

    public t1(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static t1 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof t1)) ? getInstance((Object) object) : new t1(w.getInstance(object).getOctets());
    }

    public static t1 getInstance(Object obj) {
        if (obj == null || (obj instanceof t1)) {
            return (t1) obj;
        }
        if (obj instanceof n) {
            return new t1(((n) obj).f13252b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (t1) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
