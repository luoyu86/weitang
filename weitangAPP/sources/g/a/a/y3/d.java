package g.a.a.y3;

import g.a.a.a0;
import g.a.a.e2;
import g.a.a.f0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class d extends g.a.a.t implements g.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.g f13460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13461b;

    public d(int i2, g.a.a.g gVar) {
        this.f13461b = i2;
        this.f13460a = gVar;
    }

    public d(l0 l0Var) {
        int tagNo = l0Var.getTagNo();
        this.f13461b = tagNo;
        this.f13460a = tagNo == 0 ? h.getInstance(l0Var, false) : f0.getInstance(l0Var, false);
    }

    public d(h hVar) {
        this(0, hVar);
    }

    public static d getInstance(l0 l0Var, boolean z) {
        return getInstance(l0.getInstance(l0Var, true));
    }

    public static d getInstance(Object obj) {
        if (obj == null || (obj instanceof d)) {
            return (d) obj;
        }
        if (obj instanceof l0) {
            return new d((l0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public final void a(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    public g.a.a.g getName() {
        return this.f13460a;
    }

    public int getType() {
        return this.f13461b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return new e2(false, this.f13461b, this.f13460a);
    }

    public String toString() {
        String string;
        String str;
        String strLineSeparator = g.a.j.q.lineSeparator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPointName: [");
        stringBuffer.append(strLineSeparator);
        if (this.f13461b == 0) {
            string = this.f13460a.toString();
            str = "fullName";
        } else {
            string = this.f13460a.toString();
            str = "nameRelativeToCRLIssuer";
        }
        a(stringBuffer, strLineSeparator, str, string);
        stringBuffer.append("]");
        stringBuffer.append(strLineSeparator);
        return stringBuffer.toString();
    }
}
