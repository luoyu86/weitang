package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class i2 extends u0 {
    public i2(byte[] bArr) {
        this(bArr, true);
    }

    public i2(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static i2 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof i2)) ? getInstance((Object) object) : new i2(w.getInstance(object).getOctets());
    }

    public static i2 getInstance(Object obj) {
        if (obj == null || (obj instanceof i2)) {
            return (i2) obj;
        }
        if (obj instanceof u0) {
            return new i2(((u0) obj).f13349b, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (i2) a0.fromByteArray((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }
}
