package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class m1 extends b {
    public m1(String str) {
        super(str);
    }

    public m1(byte[] bArr) {
        super(bArr);
    }

    public m1(char[] cArr) {
        super(cArr);
    }

    public static m1 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof m1)) ? getInstance((Object) object) : new m1(w.getInstance(object).getOctets());
    }

    public static m1 getInstance(Object obj) {
        if (obj == null || (obj instanceof m1)) {
            return (m1) obj;
        }
        if (obj instanceof b) {
            return new m1(((b) obj).f13037b);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (m1) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
