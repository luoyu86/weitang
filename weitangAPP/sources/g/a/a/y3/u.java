package g.a.a.y3;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import com.tom_roush.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import g.a.a.a0;
import g.a.a.b2;
import g.a.a.c2;
import g.a.a.d0;
import g.a.a.f0;
import g.a.a.i0;
import g.a.a.l0;
import g.a.a.q0;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class u extends g.a.a.t {
    public static final g.a.a.v A;
    public static final g.a.a.v B;
    public static final g.a.a.v C;
    public static final g.a.a.v D;
    public static final g.a.a.v E;
    public static final g.a.a.v F;
    public static final g.a.a.v G;
    public static final g.a.a.v H;
    public static final g.a.a.v I;
    public static boolean J;
    public static final Hashtable K;
    public static final Hashtable L;
    public static final Hashtable M;
    public static final Hashtable N;
    public static final Hashtable O;
    public static final Hashtable P;
    public static final Boolean Q;
    public static final Boolean R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g.a.a.v f13542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g.a.a.v f13543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g.a.a.v f13544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.a.a.v f13545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g.a.a.v f13546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g.a.a.v f13547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g.a.a.v f13548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g.a.a.v f13549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g.a.a.v f13550i;
    public static final g.a.a.v j;
    public static final g.a.a.v k;
    public static final g.a.a.v l;
    public static final g.a.a.v m;
    public static final g.a.a.v n;
    public static final g.a.a.v o;
    public static final g.a.a.v p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g.a.a.v f13551q;
    public static final g.a.a.v r;
    public static final g.a.a.v s;
    public static final g.a.a.v t;
    public static final g.a.a.v u;
    public static final g.a.a.v v;
    public static final g.a.a.v w;
    public static final g.a.a.v x;
    public static final g.a.a.v y;
    public static final g.a.a.v z;
    public int A0;
    public v S;
    public Vector T;
    public Vector U;
    public Vector V;
    public d0 W;
    public boolean c0;

    static {
        g.a.a.v vVar = new g.a.a.v("2.5.4.6");
        f13542a = vVar;
        g.a.a.v vVar2 = new g.a.a.v("2.5.4.10");
        f13543b = vVar2;
        g.a.a.v vVar3 = new g.a.a.v("2.5.4.11");
        f13544c = vVar3;
        g.a.a.v vVar4 = new g.a.a.v("2.5.4.12");
        f13545d = vVar4;
        g.a.a.v vVar5 = new g.a.a.v("2.5.4.3");
        f13546e = vVar5;
        g.a.a.v vVar6 = new g.a.a.v("2.5.4.5");
        f13547f = vVar6;
        g.a.a.v vVar7 = new g.a.a.v("2.5.4.9");
        f13548g = vVar7;
        f13549h = vVar6;
        g.a.a.v vVar8 = new g.a.a.v("2.5.4.7");
        f13550i = vVar8;
        g.a.a.v vVar9 = new g.a.a.v("2.5.4.8");
        j = vVar9;
        g.a.a.v vVar10 = new g.a.a.v("2.5.4.4");
        k = vVar10;
        g.a.a.v vVar11 = new g.a.a.v("2.5.4.42");
        l = vVar11;
        g.a.a.v vVar12 = new g.a.a.v("2.5.4.43");
        m = vVar12;
        g.a.a.v vVar13 = new g.a.a.v("2.5.4.44");
        n = vVar13;
        g.a.a.v vVar14 = new g.a.a.v("2.5.4.45");
        o = vVar14;
        g.a.a.v vVar15 = new g.a.a.v("2.5.4.15");
        p = vVar15;
        g.a.a.v vVar16 = new g.a.a.v("2.5.4.17");
        f13551q = vVar16;
        g.a.a.v vVar17 = new g.a.a.v("2.5.4.46");
        r = vVar17;
        g.a.a.v vVar18 = new g.a.a.v("2.5.4.65");
        s = vVar18;
        g.a.a.v vVar19 = new g.a.a.v("1.3.6.1.5.5.7.9.1");
        t = vVar19;
        g.a.a.v vVar20 = new g.a.a.v("1.3.6.1.5.5.7.9.2");
        u = vVar20;
        g.a.a.v vVar21 = new g.a.a.v("1.3.6.1.5.5.7.9.3");
        v = vVar21;
        g.a.a.v vVar22 = new g.a.a.v("1.3.6.1.5.5.7.9.4");
        w = vVar22;
        g.a.a.v vVar23 = new g.a.a.v("1.3.6.1.5.5.7.9.5");
        x = vVar23;
        g.a.a.v vVar24 = new g.a.a.v("1.3.36.8.3.14");
        y = vVar24;
        g.a.a.v vVar25 = new g.a.a.v("2.5.4.16");
        z = vVar25;
        A = new g.a.a.v("2.5.4.54");
        g.a.a.v vVar26 = x.B3;
        B = vVar26;
        g.a.a.v vVar27 = x.C3;
        C = vVar27;
        g.a.a.v vVar28 = g.a.a.t3.a.t1;
        D = vVar28;
        g.a.a.v vVar29 = g.a.a.t3.a.u1;
        E = vVar29;
        g.a.a.v vVar30 = g.a.a.t3.a.B1;
        F = vVar30;
        G = vVar28;
        g.a.a.v vVar31 = new g.a.a.v("0.9.2342.19200300.100.1.25");
        H = vVar31;
        g.a.a.v vVar32 = new g.a.a.v("0.9.2342.19200300.100.1.1");
        I = vVar32;
        J = false;
        Hashtable hashtable = new Hashtable();
        K = hashtable;
        Hashtable hashtable2 = new Hashtable();
        L = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        M = hashtable3;
        Hashtable hashtable4 = new Hashtable();
        N = hashtable4;
        O = hashtable;
        P = hashtable4;
        Q = new Boolean(true);
        R = new Boolean(false);
        hashtable.put(vVar, "C");
        hashtable.put(vVar2, PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
        hashtable.put(vVar4, PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE);
        hashtable.put(vVar3, "OU");
        hashtable.put(vVar5, "CN");
        hashtable.put(vVar8, "L");
        hashtable.put(vVar9, "ST");
        hashtable.put(vVar6, "SERIALNUMBER");
        hashtable.put(vVar28, "E");
        hashtable.put(vVar31, "DC");
        hashtable.put(vVar32, "UID");
        hashtable.put(vVar7, "STREET");
        hashtable.put(vVar10, "SURNAME");
        hashtable.put(vVar11, "GIVENNAME");
        hashtable.put(vVar12, "INITIALS");
        hashtable.put(vVar13, "GENERATION");
        hashtable.put(vVar30, "unstructuredAddress");
        hashtable.put(vVar29, "unstructuredName");
        hashtable.put(vVar14, "UniqueIdentifier");
        hashtable.put(vVar17, "DN");
        hashtable.put(vVar18, "Pseudonym");
        hashtable.put(vVar25, "PostalAddress");
        hashtable.put(vVar24, "NameAtBirth");
        hashtable.put(vVar22, "CountryOfCitizenship");
        hashtable.put(vVar23, "CountryOfResidence");
        hashtable.put(vVar21, "Gender");
        hashtable.put(vVar20, "PlaceOfBirth");
        hashtable.put(vVar19, "DateOfBirth");
        hashtable.put(vVar16, "PostalCode");
        hashtable.put(vVar15, "BusinessCategory");
        hashtable.put(vVar26, "TelephoneNumber");
        hashtable.put(vVar27, "Name");
        hashtable2.put(vVar, "C");
        hashtable2.put(vVar2, PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
        hashtable2.put(vVar3, "OU");
        hashtable2.put(vVar5, "CN");
        hashtable2.put(vVar8, "L");
        hashtable2.put(vVar9, "ST");
        hashtable2.put(vVar7, "STREET");
        hashtable2.put(vVar31, "DC");
        hashtable2.put(vVar32, "UID");
        hashtable3.put(vVar, "C");
        hashtable3.put(vVar2, PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
        hashtable3.put(vVar3, "OU");
        hashtable3.put(vVar5, "CN");
        hashtable3.put(vVar8, "L");
        hashtable3.put(vVar9, "ST");
        hashtable3.put(vVar7, "STREET");
        hashtable4.put(OperatorName.CURVE_TO, vVar);
        hashtable4.put("o", vVar2);
        hashtable4.put(DispatchConstants.TIMESTAMP, vVar4);
        hashtable4.put("ou", vVar3);
        hashtable4.put("cn", vVar5);
        hashtable4.put(OperatorName.LINE_TO, vVar8);
        hashtable4.put("st", vVar9);
        hashtable4.put("sn", vVar6);
        hashtable4.put("serialnumber", vVar6);
        hashtable4.put("street", vVar7);
        hashtable4.put("emailaddress", vVar28);
        hashtable4.put("dc", vVar31);
        hashtable4.put("e", vVar28);
        hashtable4.put("uid", vVar32);
        hashtable4.put("surname", vVar10);
        hashtable4.put("givenname", vVar11);
        hashtable4.put("initials", vVar12);
        hashtable4.put("generation", vVar13);
        hashtable4.put("unstructuredaddress", vVar30);
        hashtable4.put("unstructuredname", vVar29);
        hashtable4.put("uniqueidentifier", vVar14);
        hashtable4.put("dn", vVar17);
        hashtable4.put("pseudonym", vVar18);
        hashtable4.put("postaladdress", vVar25);
        hashtable4.put("nameofbirth", vVar24);
        hashtable4.put("countryofcitizenship", vVar22);
        hashtable4.put("countryofresidence", vVar23);
        hashtable4.put("gender", vVar21);
        hashtable4.put("placeofbirth", vVar20);
        hashtable4.put("dateofbirth", vVar19);
        hashtable4.put("postalcode", vVar16);
        hashtable4.put("businesscategory", vVar15);
        hashtable4.put("telephonenumber", vVar26);
        hashtable4.put("name", vVar27);
    }

    public u() {
        this.S = null;
        this.T = new Vector();
        this.U = new Vector();
        this.V = new Vector();
    }

    public u(d0 d0Var) {
        Vector vector;
        this.S = null;
        this.T = new Vector();
        this.U = new Vector();
        this.V = new Vector();
        this.W = d0Var;
        Enumeration objects = d0Var.getObjects();
        while (objects.hasMoreElements()) {
            f0 f0Var = f0.getInstance(((g.a.a.g) objects.nextElement()).toASN1Primitive());
            int i2 = 0;
            while (i2 < f0Var.size()) {
                d0 d0Var2 = d0.getInstance(f0Var.getObjectAt(i2).toASN1Primitive());
                if (d0Var2.size() != 2) {
                    throw new IllegalArgumentException("badly sized pair");
                }
                this.T.addElement(g.a.a.v.getInstance(d0Var2.getObjectAt(0)));
                g.a.a.g objectAt = d0Var2.getObjectAt(1);
                if (!(objectAt instanceof i0) || (objectAt instanceof q0)) {
                    try {
                        this.U.addElement("#" + c(g.a.j.r.c.encode(objectAt.toASN1Primitive().getEncoded("DER"))));
                    } catch (IOException unused) {
                        throw new IllegalArgumentException("cannot encode value");
                    }
                } else {
                    String string = ((i0) objectAt).getString();
                    if (string.length() <= 0 || string.charAt(0) != '#') {
                        vector = this.U;
                    } else {
                        vector = this.U;
                        string = "\\" + string;
                    }
                    vector.addElement(string);
                }
                this.V.addElement(i2 != 0 ? Q : R);
                i2++;
            }
        }
    }

    public u(String str) {
        this(J, N, str);
    }

    public u(String str, v vVar) {
        this(J, N, str, vVar);
    }

    public u(Hashtable hashtable) {
        this((Vector) null, hashtable);
    }

    public u(Vector vector, Hashtable hashtable) {
        this(vector, hashtable, new r());
    }

    public u(Vector vector, Hashtable hashtable, v vVar) {
        this.S = null;
        this.T = new Vector();
        this.U = new Vector();
        this.V = new Vector();
        this.S = vVar;
        if (vector != null) {
            for (int i2 = 0; i2 != vector.size(); i2++) {
                this.T.addElement(vector.elementAt(i2));
                this.V.addElement(R);
            }
        } else {
            Enumeration enumerationKeys = hashtable.keys();
            while (enumerationKeys.hasMoreElements()) {
                this.T.addElement(enumerationKeys.nextElement());
                this.V.addElement(R);
            }
        }
        for (int i3 = 0; i3 != this.T.size(); i3++) {
            g.a.a.v vVar2 = (g.a.a.v) this.T.elementAt(i3);
            if (hashtable.get(vVar2) == null) {
                throw new IllegalArgumentException("No attribute for object id - " + vVar2.getId() + " - passed to distinguished name");
            }
            this.U.addElement(hashtable.get(vVar2));
        }
    }

    public u(Vector vector, Vector vector2) {
        this(vector, vector2, new r());
    }

    public u(Vector vector, Vector vector2, v vVar) {
        this.S = null;
        this.T = new Vector();
        this.U = new Vector();
        this.V = new Vector();
        this.S = vVar;
        if (vector.size() != vector2.size()) {
            throw new IllegalArgumentException("oids vector must be same length as values.");
        }
        for (int i2 = 0; i2 < vector.size(); i2++) {
            this.T.addElement(vector.elementAt(i2));
            this.U.addElement(vector2.elementAt(i2));
            this.V.addElement(R);
        }
    }

    public u(boolean z2, String str) {
        this(z2, N, str);
    }

    public u(boolean z2, String str, v vVar) {
        this(z2, N, str, vVar);
    }

    public u(boolean z2, Hashtable hashtable, String str) {
        this(z2, hashtable, str, new r());
    }

    public u(boolean z2, Hashtable hashtable, String str, v vVar) {
        this.S = null;
        this.T = new Vector();
        this.U = new Vector();
        this.V = new Vector();
        this.S = vVar;
        w wVar = new w(str);
        while (wVar.hasMoreTokens()) {
            String strNextToken = wVar.nextToken();
            if (strNextToken.indexOf(43) > 0) {
                w wVar2 = new w(strNextToken, '+');
                String strNextToken2 = wVar2.nextToken();
                Boolean bool = R;
                while (true) {
                    a(hashtable, strNextToken2, bool);
                    if (wVar2.hasMoreTokens()) {
                        strNextToken2 = wVar2.nextToken();
                        bool = Q;
                    }
                }
            } else {
                a(hashtable, strNextToken, R);
            }
        }
        if (z2) {
            Vector vector = new Vector();
            Vector vector2 = new Vector();
            Vector vector3 = new Vector();
            int i2 = 1;
            for (int i3 = 0; i3 < this.T.size(); i3++) {
                if (((Boolean) this.V.elementAt(i3)).booleanValue()) {
                    vector.insertElementAt(this.T.elementAt(i3), i2);
                    vector2.insertElementAt(this.U.elementAt(i3), i2);
                    vector3.insertElementAt(this.V.elementAt(i3), i2);
                    i2++;
                } else {
                    vector.insertElementAt(this.T.elementAt(i3), 0);
                    vector2.insertElementAt(this.U.elementAt(i3), 0);
                    vector3.insertElementAt(this.V.elementAt(i3), 0);
                    i2 = 1;
                }
            }
            this.T = vector;
            this.U = vector2;
            this.V = vector3;
        }
    }

    public static u getInstance(l0 l0Var, boolean z2) {
        return getInstance(d0.getInstance(l0Var, z2));
    }

    public static u getInstance(Object obj) {
        if (obj instanceof u) {
            return (u) obj;
        }
        if (obj instanceof g.a.a.x3.c) {
            return new u(d0.getInstance(((g.a.a.x3.c) obj).toASN1Primitive()));
        }
        if (obj != null) {
            return new u(d0.getInstance(obj));
        }
        return null;
    }

    public final void a(Hashtable hashtable, String str, Boolean bool) {
        w wVar = new w(str, com.alipay.sdk.m.n.a.f5521h);
        String strNextToken = wVar.nextToken();
        if (!wVar.hasMoreTokens()) {
            throw new IllegalArgumentException("badly formatted directory string");
        }
        String strNextToken2 = wVar.nextToken();
        this.T.addElement(e(strNextToken, hashtable));
        this.U.addElement(i(strNextToken2));
        this.V.addElement(bool);
    }

    public final void b(StringBuffer stringBuffer, Hashtable hashtable, g.a.a.v vVar, String str) {
        String id = (String) hashtable.get(vVar);
        if (id == null) {
            id = vVar.getId();
        }
        stringBuffer.append(id);
        stringBuffer.append(com.alipay.sdk.m.n.a.f5521h);
        int length = stringBuffer.length();
        stringBuffer.append(str);
        int length2 = stringBuffer.length();
        if (str.length() >= 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
            length += 2;
        }
        while (length < length2 && stringBuffer.charAt(length) == ' ') {
            stringBuffer.insert(length, "\\");
            length += 2;
            length2++;
        }
        while (true) {
            length2--;
            if (length2 <= length || stringBuffer.charAt(length2) != ' ') {
                break;
            } else {
                stringBuffer.insert(length2, '\\');
            }
        }
        while (length <= length2) {
            char cCharAt = stringBuffer.charAt(length);
            if (cCharAt != '\"' && cCharAt != '\\' && cCharAt != '+' && cCharAt != ',') {
                switch (cCharAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        length++;
                        break;
                }
            }
            stringBuffer.insert(length, "\\");
            length += 2;
            length2++;
        }
    }

    public final String c(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 != length; i2++) {
            cArr[i2] = (char) (bArr[i2] & 255);
        }
        return new String(cArr);
    }

    public final String d(String str) {
        String lowerCase = g.a.j.q.toLowerCase(str.trim());
        if (lowerCase.length() <= 0 || lowerCase.charAt(0) != '#') {
            return lowerCase;
        }
        g.a.j.d dVarF = f(lowerCase);
        return dVarF instanceof i0 ? g.a.j.q.toLowerCase(((i0) dVarF).getString().trim()) : lowerCase;
    }

    public final g.a.a.v e(String str, Hashtable hashtable) {
        String strTrim = str.trim();
        if (g.a.j.q.toUpperCase(strTrim).startsWith("OID.")) {
            return new g.a.a.v(strTrim.substring(4));
        }
        if (strTrim.charAt(0) >= '0' && strTrim.charAt(0) <= '9') {
            return new g.a.a.v(strTrim);
        }
        g.a.a.v vVar = (g.a.a.v) hashtable.get(g.a.j.q.toLowerCase(strTrim));
        if (vVar != null) {
            return vVar;
        }
        throw new IllegalArgumentException("Unknown object id - " + strTrim + " - passed to distinguished name");
    }

    @Override // g.a.a.t
    public boolean equals(Object obj) {
        int i2;
        int i3;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u) && !(obj instanceof d0)) {
            return false;
        }
        if (toASN1Primitive().equals(((g.a.a.g) obj).toASN1Primitive())) {
            return true;
        }
        try {
            u uVar = getInstance(obj);
            int size = this.T.size();
            if (size != uVar.T.size()) {
                return false;
            }
            boolean[] zArr = new boolean[size];
            int i4 = -1;
            if (this.T.elementAt(0).equals(uVar.T.elementAt(0))) {
                i4 = size;
                i2 = 0;
                i3 = 1;
            } else {
                i2 = size - 1;
                i3 = -1;
            }
            while (i2 != i4) {
                g.a.a.v vVar = (g.a.a.v) this.T.elementAt(i2);
                String str = (String) this.U.elementAt(i2);
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        z2 = false;
                        break;
                    }
                    if (!zArr[i5] && vVar.equals((a0) uVar.T.elementAt(i5)) && g(str, (String) uVar.U.elementAt(i5))) {
                        zArr[i5] = true;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    return false;
                }
                i2 += i3;
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean equals(Object obj, boolean z2) {
        if (!z2) {
            return equals(obj);
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u) && !(obj instanceof d0)) {
            return false;
        }
        if (toASN1Primitive().equals(((g.a.a.g) obj).toASN1Primitive())) {
            return true;
        }
        try {
            u uVar = getInstance(obj);
            int size = this.T.size();
            if (size != uVar.T.size()) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (!((g.a.a.v) this.T.elementAt(i2)).equals((a0) uVar.T.elementAt(i2)) || !g((String) this.U.elementAt(i2), (String) uVar.U.elementAt(i2))) {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final a0 f(String str) {
        try {
            return a0.fromByteArray(g.a.j.r.c.decodeStrict(str, 1, str.length() - 1));
        } catch (IOException e2) {
            throw new IllegalStateException("unknown encoding in name: " + e2);
        }
    }

    public final boolean g(String str, String str2) {
        String strD = d(str);
        String strD2 = d(str2);
        return strD.equals(strD2) || h(strD).equals(h(strD2));
    }

    public Vector getOIDs() {
        Vector vector = new Vector();
        for (int i2 = 0; i2 != this.T.size(); i2++) {
            vector.addElement(this.T.elementAt(i2));
        }
        return vector;
    }

    public Vector getValues() {
        Vector vector = new Vector();
        for (int i2 = 0; i2 != this.U.size(); i2++) {
            vector.addElement(this.U.elementAt(i2));
        }
        return vector;
    }

    public Vector getValues(g.a.a.v vVar) {
        Vector vector = new Vector();
        for (int i2 = 0; i2 != this.U.size(); i2++) {
            if (this.T.elementAt(i2).equals(vVar)) {
                String strSubstring = (String) this.U.elementAt(i2);
                if (strSubstring.length() > 2 && strSubstring.charAt(0) == '\\' && strSubstring.charAt(1) == '#') {
                    strSubstring = strSubstring.substring(1);
                }
                vector.addElement(strSubstring);
            }
        }
        return vector;
    }

    public final String h(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char cCharAt = str.charAt(0);
            stringBuffer.append(cCharAt);
            int i2 = 1;
            while (i2 < str.length()) {
                char cCharAt2 = str.charAt(i2);
                if (cCharAt != ' ' || cCharAt2 != ' ') {
                    stringBuffer.append(cCharAt2);
                }
                i2++;
                cCharAt = cCharAt2;
            }
        }
        return stringBuffer.toString();
    }

    @Override // g.a.a.t
    public int hashCode() {
        if (this.c0) {
            return this.A0;
        }
        this.c0 = true;
        for (int i2 = 0; i2 != this.T.size(); i2++) {
            String strH = h(d((String) this.U.elementAt(i2)));
            int iHashCode = this.A0 ^ this.T.elementAt(i2).hashCode();
            this.A0 = iHashCode;
            this.A0 = strH.hashCode() ^ iHashCode;
        }
        return this.A0;
    }

    public final String i(String str) {
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
        boolean z2 = false;
        int length = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i2 != charArray.length) {
            char c2 = charArray[i2];
            if (c2 != ' ') {
                z4 = true;
            }
            if (c2 == '\"') {
                if (!z2) {
                    z3 = !z3;
                }
                z2 = false;
                i2++;
            } else {
                if (c2 == '\\' && !z2 && !z3) {
                    length = stringBuffer.length();
                    z2 = true;
                } else if (c2 == ' ' && !z2 && !z4) {
                }
                i2++;
            }
            stringBuffer.append(c2);
            z2 = false;
            i2++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && length != stringBuffer.length() - 1) {
                stringBuffer.setLength(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        b2 b2Var;
        if (this.W == null) {
            g.a.a.h hVar = new g.a.a.h();
            g.a.a.h hVar2 = new g.a.a.h();
            g.a.a.v vVar = null;
            int i2 = 0;
            while (i2 != this.T.size()) {
                g.a.a.h hVar3 = new g.a.a.h(2);
                g.a.a.v vVar2 = (g.a.a.v) this.T.elementAt(i2);
                hVar3.add(vVar2);
                hVar3.add(this.S.getConvertedValue(vVar2, (String) this.U.elementAt(i2)));
                if (vVar == null || ((Boolean) this.V.elementAt(i2)).booleanValue()) {
                    b2Var = new b2(hVar3);
                } else {
                    hVar.add(new c2(hVar2));
                    hVar2 = new g.a.a.h();
                    b2Var = new b2(hVar3);
                }
                hVar2.add(b2Var);
                i2++;
                vVar = vVar2;
            }
            hVar.add(new c2(hVar2));
            this.W = new b2(hVar);
        }
        return this.W;
    }

    public String toString() {
        return toString(J, K);
    }

    public String toString(boolean z2, Hashtable hashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        StringBuffer stringBuffer2 = null;
        for (int i2 = 0; i2 < this.T.size(); i2++) {
            if (((Boolean) this.V.elementAt(i2)).booleanValue()) {
                stringBuffer2.append('+');
                b(stringBuffer2, hashtable, (g.a.a.v) this.T.elementAt(i2), (String) this.U.elementAt(i2));
            } else {
                stringBuffer2 = new StringBuffer();
                b(stringBuffer2, hashtable, (g.a.a.v) this.T.elementAt(i2), (String) this.U.elementAt(i2));
                vector.addElement(stringBuffer2);
            }
        }
        boolean z3 = true;
        if (z2) {
            for (int size = vector.size() - 1; size >= 0; size--) {
                if (z3) {
                    z3 = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(size).toString());
            }
        } else {
            for (int i3 = 0; i3 < vector.size(); i3++) {
                if (z3) {
                    z3 = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(i3).toString());
            }
        }
        return stringBuffer.toString();
    }
}
