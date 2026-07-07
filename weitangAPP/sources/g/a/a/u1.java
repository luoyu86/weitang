package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class u1 extends o {
    public u1(String str) {
        this(str, false);
    }

    public u1(String str, boolean z) {
        super(str, z);
    }

    public u1(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static u1 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof u1)) ? getInstance((Object) object) : new u1(w.getInstance(object).getOctets(), true);
    }

    public static u1 getInstance(Object obj) {
        if (obj == null || (obj instanceof u1)) {
            return (u1) obj;
        }
        if (obj instanceof o) {
            return new u1(((o) obj).f13270b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (u1) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
