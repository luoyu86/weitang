package g.a.a.y3;

import g.a.a.a0;
import g.a.a.a2;
import g.a.a.g2;
import g.a.a.s1;
import g.a.a.u1;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class r extends v {
    @Override // g.a.a.y3.v
    public a0 getConvertedValue(g.a.a.v vVar, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return (vVar.equals((a0) u.D) || vVar.equals((a0) u.H)) ? new u1(str) : vVar.equals((a0) u.t) ? new s1(str) : (vVar.equals((a0) u.f13542a) || vVar.equals((a0) u.f13547f) || vVar.equals((a0) u.r) || vVar.equals((a0) u.B)) ? new a2(str) : new g2(str);
        }
        try {
            return a(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + vVar.getId());
        }
    }
}
