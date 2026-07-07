package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class w1 extends s {
    public w1(String str) {
        this(str, false);
    }

    public w1(String str, boolean z) {
        super(str, z);
    }

    public w1(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static w1 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof w1)) ? getInstance((Object) object) : new w1(w.getInstance(object).getOctets(), true);
    }

    public static w1 getInstance(Object obj) {
        if (obj == null || (obj instanceof w1)) {
            return (w1) obj;
        }
        if (obj instanceof s) {
            return new w1(((s) obj).f13319b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (w1) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
