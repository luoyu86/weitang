package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class d2 extends j0 {
    public d2(String str) {
        super(str);
    }

    public d2(byte[] bArr) {
        this(bArr, true);
    }

    public d2(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static d2 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof d2)) ? getInstance((Object) object) : new d2(w.getInstance(object).getOctets(), true);
    }

    public static d2 getInstance(Object obj) {
        if (obj == null || (obj instanceof d2)) {
            return (d2) obj;
        }
        if (obj instanceof j0) {
            return new d2(((j0) obj).f13181b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (d2) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
