package cn.admobiletop.adsuyi.a.f;

import android.content.SharedPreferences;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f3248a;

    public static d a() {
        if (f3248a == null) {
            synchronized (d.class) {
                if (f3248a == null) {
                    f3248a = new d();
                }
            }
        }
        return f3248a;
    }

    public final void b(String str, String str2) {
        try {
            c().edit().putString(str, str2).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final SharedPreferences c() {
        return ADSuyiSdk.getInstance().getContext().getSharedPreferences("cn.admobiletop.adsuyi.frequency", 0);
    }

    public final String d(String str) {
        try {
            return c().getString(str, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(String str, List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        b(str, jSONArray.toString());
    }

    public List<String> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(d(str));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.get(i2).toString());
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}
