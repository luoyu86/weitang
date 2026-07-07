package g.a.h.o;

import g.a.h.g;
import java.security.Key;

/* JADX INFO: loaded from: classes3.dex */
public class b extends g {
    public b(g.a.a.y3.a aVar, Key key) {
        super(aVar, a(key));
    }

    public static Object a(Key key) {
        byte[] encoded = key.getEncoded();
        return encoded != null ? encoded : key;
    }
}
