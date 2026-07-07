package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class j2 extends v0 {
    public j2(String str) {
        super(str);
    }

    public j2(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static j2 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof j2)) ? getInstance((Object) object) : new j2(w.getInstance(object).getOctets(), true);
    }

    public static j2 getInstance(Object obj) {
        if (obj == null || (obj instanceof j2)) {
            return (j2) obj;
        }
        if (obj instanceof v0) {
            return new j2(((v0) obj).f13367b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (j2) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
