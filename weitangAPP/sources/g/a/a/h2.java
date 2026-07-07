package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class h2 extends q0 {
    public h2(byte[] bArr) {
        this(bArr, true);
    }

    public h2(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static h2 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof h2)) ? getInstance((Object) object) : new h2(w.getInstance(object).getOctets(), true);
    }

    public static h2 getInstance(Object obj) {
        if (obj == null || (obj instanceof h2)) {
            return (h2) obj;
        }
        if (obj instanceof q0) {
            return new h2(((q0) obj).f13293c, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (h2) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error getInstance: " + e2.toString());
        }
    }
}
