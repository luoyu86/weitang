package com.alipay.sdk.m.r;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f5616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f5618c;

    public b(String str) {
        this.f5617b = str;
    }

    public static void a(b bVar) {
        String[] strArrC = bVar.c();
        if (strArrC.length == 3 && TextUtils.equals("tid", strArrC[0])) {
            com.alipay.sdk.m.t.a aVarA = com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b());
            if (TextUtils.isEmpty(strArrC[1]) || TextUtils.isEmpty(strArrC[2])) {
                return;
            }
            aVarA.a(strArrC[1], strArrC[2]);
        }
    }

    public static String[] b(String str) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = str.indexOf(40);
        int iLastIndexOf = str.lastIndexOf(41);
        if (iIndexOf == -1 || iLastIndexOf == -1 || iLastIndexOf <= iIndexOf) {
            return null;
        }
        for (String str2 : str.substring(iIndexOf + 1, iLastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll(OperatorName.SHOW_TEXT_LINE, "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String[] c() {
        return this.f5618c;
    }

    public b(String str, a aVar) {
        this.f5617b = str;
        this.f5616a = aVar;
    }

    public static List<b> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] strArrA = a(jSONObject.optString("name", ""));
        for (int i2 = 0; i2 < strArrA.length; i2++) {
            a aVarA = a.a(strArrA[i2]);
            if (aVarA != a.None) {
                b bVar = new b(strArrA[i2], aVarA);
                bVar.f5618c = b(strArrA[i2]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public String b() {
        return this.f5617b;
    }

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(i.f5697b);
    }

    public a a() {
        return this.f5616a;
    }
}
