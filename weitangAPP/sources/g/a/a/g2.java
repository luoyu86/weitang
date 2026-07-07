package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class g2 extends p0 {
    public g2(String str) {
        super(str);
    }

    public g2(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static g2 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof g2)) ? getInstance((Object) object) : new g2(w.getInstance(object).getOctets(), true);
    }

    public static g2 getInstance(Object obj) {
        if (obj == null || (obj instanceof g2)) {
            return (g2) obj;
        }
        if (obj instanceof p0) {
            return new g2(((p0) obj).f13281b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (g2) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
