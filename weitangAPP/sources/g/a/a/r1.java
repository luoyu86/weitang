package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class r1 extends l {
    public r1(String str) {
        super(str);
    }

    public r1(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static r1 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof r1)) ? getInstance((Object) object) : new r1(w.getInstance(object).getOctets(), true);
    }

    public static r1 getInstance(Object obj) {
        if (obj == null || (obj instanceof r1)) {
            return (r1) obj;
        }
        if (obj instanceof l) {
            return new r1(((l) obj).f13227b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (r1) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
