package g.a.a.x3;

import g.a.a.g;
import g.a.a.v;

/* JADX INFO: loaded from: classes2.dex */
public interface e {
    boolean areEqual(c cVar, c cVar2);

    v attrNameToOID(String str);

    int calculateHashCode(c cVar);

    b[] fromString(String str);

    String[] oidToAttrNames(v vVar);

    String oidToDisplayName(v vVar);

    g stringToValue(v vVar, String str);

    String toString(c cVar);
}
