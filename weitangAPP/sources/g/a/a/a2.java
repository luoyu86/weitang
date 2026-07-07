package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class a2 extends b0 {
    public a2(String str) {
        this(str, false);
    }

    public a2(String str, boolean z) {
        super(str, z);
    }

    public a2(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static a2 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof a2)) ? getInstance((Object) object) : new a2(w.getInstance(object).getOctets(), true);
    }

    public static a2 getInstance(Object obj) {
        if (obj == null || (obj instanceof a2)) {
            return (a2) obj;
        }
        if (obj instanceof b0) {
            return new a2(((b0) obj).f13039b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (a2) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
