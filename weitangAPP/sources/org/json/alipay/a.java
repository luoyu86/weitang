package org.json.alipay;

import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f14992a;

    public a() {
        this.f14992a = new ArrayList();
    }

    public a(Object obj) throws JSONException {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f14992a.add(Array.get(obj, i2));
        }
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.f14992a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) throws JSONException {
        char c2;
        ArrayList arrayList;
        Object objD;
        this();
        char c3 = cVar.c();
        if (c3 == '[') {
            c2 = ']';
        } else {
            if (c3 != '(') {
                throw cVar.a("A JSONArray text must start with '['");
            }
            c2 = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c4 = cVar.c();
            cVar.a();
            if (c4 == ',') {
                arrayList = this.f14992a;
                objD = null;
            } else {
                arrayList = this.f14992a;
                objD = cVar.d();
            }
            arrayList.add(objD);
            char c5 = cVar.c();
            if (c5 != ')') {
                if (c5 != ',' && c5 != ';') {
                    if (c5 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c2 == c5) {
                return;
            }
            throw cVar.a("Expected a '" + new Character(c2) + OperatorName.SHOW_TEXT_LINE);
        } while (cVar.c() != ']');
    }

    private String a(String str) {
        int size = this.f14992a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f14992a.get(i2)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.f14992a.size();
    }

    public final Object a(int i2) throws JSONException {
        Object obj = (i2 < 0 || i2 >= this.f14992a.size()) ? null : this.f14992a.get(i2);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i2 + "] not found.");
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }
}
