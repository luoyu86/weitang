package g.a.a.y3;

import g.a.a.a0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v {
    public a0 a(String str, int i2) throws IOException {
        return a0.fromByteArray(g.a.j.r.c.decodeStrict(str, i2, str.length() - i2));
    }

    public abstract a0 getConvertedValue(g.a.a.v vVar, String str);
}
