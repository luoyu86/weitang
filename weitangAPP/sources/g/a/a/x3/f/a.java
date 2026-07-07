package g.a.a.x3.f;

import g.a.a.a0;
import g.a.a.g;
import g.a.a.g2;
import g.a.a.v;
import g.a.a.x3.e;
import g.a.a.z;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements e {
    public static Hashtable copyHashTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable2.put(objNextElement, hashtable.get(objNextElement));
        }
        return hashtable2;
    }

    public final int a(g gVar) {
        return c.canonicalString(gVar).hashCode();
    }

    @Override // g.a.a.x3.e
    public boolean areEqual(g.a.a.x3.c cVar, g.a.a.x3.c cVar2) {
        g.a.a.x3.b[] rDNs = cVar.getRDNs();
        g.a.a.x3.b[] rDNs2 = cVar2.getRDNs();
        if (rDNs.length != rDNs2.length) {
            return false;
        }
        boolean z = (rDNs[0].getFirst() == null || rDNs2[0].getFirst() == null) ? false : !rDNs[0].getFirst().getType().equals((a0) rDNs2[0].getFirst().getType());
        for (int i2 = 0; i2 != rDNs.length; i2++) {
            if (!c(z, rDNs[i2], rDNs2)) {
                return false;
            }
        }
        return true;
    }

    @Override // g.a.a.x3.e
    public abstract /* synthetic */ v attrNameToOID(String str);

    public g b(v vVar, String str) {
        return new g2(str);
    }

    public final boolean c(boolean z, g.a.a.x3.b bVar, g.a.a.x3.b[] bVarArr) {
        if (z) {
            for (int length = bVarArr.length - 1; length >= 0; length--) {
                if (bVarArr[length] != null && d(bVar, bVarArr[length])) {
                    bVarArr[length] = null;
                    return true;
                }
            }
        } else {
            for (int i2 = 0; i2 != bVarArr.length; i2++) {
                if (bVarArr[i2] != null && d(bVar, bVarArr[i2])) {
                    bVarArr[i2] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // g.a.a.x3.e
    public int calculateHashCode(g.a.a.x3.c cVar) {
        g.a.a.x3.b[] rDNs = cVar.getRDNs();
        int iHashCode = 0;
        for (int i2 = 0; i2 != rDNs.length; i2++) {
            if (rDNs[i2].isMultiValued()) {
                g.a.a.x3.a[] typesAndValues = rDNs[i2].getTypesAndValues();
                for (int i3 = 0; i3 != typesAndValues.length; i3++) {
                    iHashCode = (iHashCode ^ typesAndValues[i3].getType().hashCode()) ^ a(typesAndValues[i3].getValue());
                }
            } else {
                iHashCode = (iHashCode ^ rDNs[i2].getFirst().getType().hashCode()) ^ a(rDNs[i2].getFirst().getValue());
            }
        }
        return iHashCode;
    }

    public boolean d(g.a.a.x3.b bVar, g.a.a.x3.b bVar2) {
        return c.rDNAreEqual(bVar, bVar2);
    }

    @Override // g.a.a.x3.e
    public abstract /* synthetic */ g.a.a.x3.b[] fromString(String str);

    @Override // g.a.a.x3.e
    public abstract /* synthetic */ String[] oidToAttrNames(v vVar);

    @Override // g.a.a.x3.e
    public abstract /* synthetic */ String oidToDisplayName(v vVar);

    @Override // g.a.a.x3.e
    public g stringToValue(v vVar, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return b(vVar, str);
        }
        try {
            return c.valueFromHexString(str, 1);
        } catch (IOException unused) {
            throw new z("can't recode value for oid " + vVar.getId());
        }
    }

    @Override // g.a.a.x3.e
    public abstract /* synthetic */ String toString(g.a.a.x3.c cVar);
}
