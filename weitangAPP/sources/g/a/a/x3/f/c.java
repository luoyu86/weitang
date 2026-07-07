package g.a.a.x3.f;

import g.a.a.a0;
import g.a.a.g;
import g.a.a.i0;
import g.a.a.q0;
import g.a.a.v;
import g.a.a.x3.e;
import g.a.j.q;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static boolean a(g.a.a.x3.a aVar, g.a.a.x3.a aVar2) {
        if (aVar == aVar2) {
            return true;
        }
        return aVar != null && aVar2 != null && aVar.getType().equals((a0) aVar2.getType()) && canonicalString(aVar.getValue()).equals(canonicalString(aVar2.getValue()));
    }

    public static void appendRDN(StringBuffer stringBuffer, g.a.a.x3.b bVar, Hashtable hashtable) {
        if (!bVar.isMultiValued()) {
            if (bVar.getFirst() != null) {
                appendTypeAndValue(stringBuffer, bVar.getFirst(), hashtable);
                return;
            }
            return;
        }
        g.a.a.x3.a[] typesAndValues = bVar.getTypesAndValues();
        boolean z = true;
        for (int i2 = 0; i2 != typesAndValues.length; i2++) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append('+');
            }
            appendTypeAndValue(stringBuffer, typesAndValues[i2], hashtable);
        }
    }

    public static void appendTypeAndValue(StringBuffer stringBuffer, g.a.a.x3.a aVar, Hashtable hashtable) {
        String id = (String) hashtable.get(aVar.getType());
        if (id == null) {
            id = aVar.getType().getId();
        }
        stringBuffer.append(id);
        stringBuffer.append(com.alipay.sdk.m.n.a.f5521h);
        stringBuffer.append(valueToString(aVar.getValue()));
    }

    public static int b(char c2) {
        if ('0' > c2 || c2 > '9') {
            return (('a' > c2 || c2 > 'f') ? c2 - 'A' : c2 - 'a') + 10;
        }
        return c2 - '0';
    }

    public static a0 c(String str) {
        try {
            return a0.fromByteArray(g.a.j.r.c.decodeStrict(str, 1, str.length() - 1));
        } catch (IOException e2) {
            throw new IllegalStateException("unknown encoding in name: " + e2);
        }
    }

    public static String canonicalString(g gVar) {
        return canonicalize(valueToString(gVar));
    }

    public static String canonicalize(String str) {
        int i2 = 0;
        if (str.length() > 0 && str.charAt(0) == '#') {
            g.a.j.d dVarC = c(str);
            if (dVarC instanceof i0) {
                str = ((i0) dVarC).getString();
            }
        }
        String lowerCase = q.toLowerCase(str);
        int length = lowerCase.length();
        if (length < 2) {
            return lowerCase;
        }
        int i3 = length - 1;
        while (i2 < i3 && lowerCase.charAt(i2) == '\\' && lowerCase.charAt(i2 + 1) == ' ') {
            i2 += 2;
        }
        int i4 = i2 + 1;
        int i5 = i3;
        while (i5 > i4 && lowerCase.charAt(i5 - 1) == '\\' && lowerCase.charAt(i5) == ' ') {
            i5 -= 2;
        }
        if (i2 > 0 || i5 < i3) {
            lowerCase = lowerCase.substring(i2, i5 + 1);
        }
        return stripInternalSpaces(lowerCase);
    }

    public static boolean d(char c2) {
        return ('0' <= c2 && c2 <= '9') || ('a' <= c2 && c2 <= 'f') || ('A' <= c2 && c2 <= 'F');
    }

    public static v decodeAttrName(String str, Hashtable hashtable) {
        if (q.toUpperCase(str).startsWith("OID.")) {
            return new v(str.substring(4));
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return new v(str);
        }
        v vVar = (v) hashtable.get(q.toLowerCase(str));
        if (vVar != null) {
            return vVar;
        }
        throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
    }

    public static v[] e(Vector vector) {
        int size = vector.size();
        v[] vVarArr = new v[size];
        for (int i2 = 0; i2 != size; i2++) {
            vVarArr[i2] = (v) vector.elementAt(i2);
        }
        return vVarArr;
    }

    public static String[] f(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 != size; i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    public static String[] findAttrNamesForOID(v vVar, Hashtable hashtable) {
        Enumeration enumerationElements = hashtable.elements();
        int i2 = 0;
        int i3 = 0;
        while (enumerationElements.hasMoreElements()) {
            if (vVar.equals(enumerationElements.nextElement())) {
                i3++;
            }
        }
        String[] strArr = new String[i3];
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            if (vVar.equals(hashtable.get(str))) {
                strArr[i2] = str;
                i2++;
            }
        }
        return strArr;
    }

    public static String g(String str) {
        int i2;
        if (str.length() == 0 || (str.indexOf(92) < 0 && str.indexOf(34) < 0)) {
            return str.trim();
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(str.length());
        if (charArray[0] == '\\' && charArray[1] == '#') {
            i2 = 2;
            stringBuffer.append("\\#");
        } else {
            i2 = 0;
        }
        boolean z = false;
        int length = 0;
        boolean z2 = false;
        boolean z3 = false;
        char c2 = 0;
        while (i2 != charArray.length) {
            char c3 = charArray[i2];
            if (c3 != ' ') {
                z3 = true;
            }
            if (c3 == '\"') {
                if (!z) {
                    z2 = !z2;
                }
                z = false;
                i2++;
            } else {
                if (c3 == '\\' && !z && !z2) {
                    length = stringBuffer.length();
                    z = true;
                } else if (c3 != ' ' || z || z3) {
                    if (z && d(c3)) {
                        if (c2 != 0) {
                            stringBuffer.append((char) ((b(c2) * 16) + b(c3)));
                            z = false;
                            c2 = 0;
                        } else {
                            c2 = c3;
                        }
                    }
                }
                i2++;
            }
            stringBuffer.append(c3);
            z = false;
            i2++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && length != stringBuffer.length() - 1) {
                stringBuffer.setLength(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean rDNAreEqual(g.a.a.x3.b bVar, g.a.a.x3.b bVar2) {
        if (bVar.size() != bVar2.size()) {
            return false;
        }
        g.a.a.x3.a[] typesAndValues = bVar.getTypesAndValues();
        g.a.a.x3.a[] typesAndValues2 = bVar2.getTypesAndValues();
        if (typesAndValues.length != typesAndValues2.length) {
            return false;
        }
        for (int i2 = 0; i2 != typesAndValues.length; i2++) {
            if (!a(typesAndValues[i2], typesAndValues2[i2])) {
                return false;
            }
        }
        return true;
    }

    public static g.a.a.x3.b[] rDNsFromString(String str, e eVar) {
        d dVar = new d(str);
        g.a.a.x3.d dVar2 = new g.a.a.x3.d(eVar);
        while (dVar.hasMoreTokens()) {
            String strNextToken = dVar.nextToken();
            if (strNextToken.indexOf(43) > 0) {
                d dVar3 = new d(strNextToken, '+');
                d dVar4 = new d(dVar3.nextToken(), com.alipay.sdk.m.n.a.f5521h);
                String strNextToken2 = dVar4.nextToken();
                if (!dVar4.hasMoreTokens()) {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
                String strNextToken3 = dVar4.nextToken();
                v vVarAttrNameToOID = eVar.attrNameToOID(strNextToken2.trim());
                if (dVar3.hasMoreTokens()) {
                    Vector vector = new Vector();
                    Vector vector2 = new Vector();
                    while (true) {
                        vector.addElement(vVarAttrNameToOID);
                        vector2.addElement(g(strNextToken3));
                        if (!dVar3.hasMoreTokens()) {
                            dVar2.addMultiValuedRDN(e(vector), f(vector2));
                            break;
                        }
                        d dVar5 = new d(dVar3.nextToken(), com.alipay.sdk.m.n.a.f5521h);
                        String strNextToken4 = dVar5.nextToken();
                        if (!dVar5.hasMoreTokens()) {
                            throw new IllegalArgumentException("badly formatted directory string");
                        }
                        strNextToken3 = dVar5.nextToken();
                        vVarAttrNameToOID = eVar.attrNameToOID(strNextToken4.trim());
                    }
                } else {
                    dVar2.addRDN(vVarAttrNameToOID, g(strNextToken3));
                }
            } else {
                d dVar6 = new d(strNextToken, com.alipay.sdk.m.n.a.f5521h);
                String strNextToken5 = dVar6.nextToken();
                if (!dVar6.hasMoreTokens()) {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
                dVar2.addRDN(eVar.attrNameToOID(strNextToken5.trim()), g(dVar6.nextToken()));
            }
        }
        return dVar2.build().getRDNs();
    }

    public static String stripInternalSpaces(String str) {
        if (str.indexOf("  ") < 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char cCharAt = str.charAt(0);
        stringBuffer.append(cCharAt);
        for (int i2 = 1; i2 < str.length(); i2++) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt != ' ' || cCharAt2 != ' ') {
                stringBuffer.append(cCharAt2);
                cCharAt = cCharAt2;
            }
        }
        return stringBuffer.toString();
    }

    public static g valueFromHexString(String str, int i2) throws IOException {
        int length = (str.length() - i2) / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 != length; i3++) {
            int i4 = (i3 * 2) + i2;
            char cCharAt = str.charAt(i4);
            char cCharAt2 = str.charAt(i4 + 1);
            bArr[i3] = (byte) (b(cCharAt2) | (b(cCharAt) << 4));
        }
        return a0.fromByteArray(bArr);
    }

    public static String valueToString(g gVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!(gVar instanceof i0) || (gVar instanceof q0)) {
            try {
                stringBuffer.append('#');
                stringBuffer.append(g.a.j.r.c.toHexString(gVar.toASN1Primitive().getEncoded("DER")));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String string = ((i0) gVar).getString();
            if (string.length() > 0 && string.charAt(0) == '#') {
                stringBuffer.append('\\');
            }
            stringBuffer.append(string);
        }
        int length = stringBuffer.length();
        int i2 = (stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#') ? 2 : 0;
        while (i2 != length) {
            char cCharAt = stringBuffer.charAt(i2);
            if (cCharAt != '\"' && cCharAt != '\\' && cCharAt != '+' && cCharAt != ',') {
                switch (cCharAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        i2++;
                        break;
                }
            }
            stringBuffer.insert(i2, "\\");
            i2 += 2;
            length++;
        }
        if (stringBuffer.length() > 0) {
            for (int i3 = 0; stringBuffer.length() > i3 && stringBuffer.charAt(i3) == ' '; i3 += 2) {
                stringBuffer.insert(i3, "\\");
            }
        }
        for (int length2 = stringBuffer.length() - 1; length2 >= 0 && stringBuffer.charAt(length2) == ' '; length2--) {
            stringBuffer.insert(length2, '\\');
        }
        return stringBuffer.toString();
    }
}
