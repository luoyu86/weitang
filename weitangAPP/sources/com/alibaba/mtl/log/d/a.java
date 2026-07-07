package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.alibaba.mtl.log.d.a$a, reason: collision with other inner class name */
    public static class C0054a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static C0054a f4551a = new C0054a();
        public boolean I = false;
        public String ah = null;

        public boolean g() {
            return "E0102".equalsIgnoreCase(this.ah);
        }

        public boolean h() {
            return "E0111".equalsIgnoreCase(this.ah) || "E0112".equalsIgnoreCase(this.ah);
        }
    }

    public static C0054a a(String str) {
        C0054a c0054a = new C0054a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(com.taobao.agoo.a.a.b.JSON_SUCCESS)) {
                String string = jSONObject.getString(com.taobao.agoo.a.a.b.JSON_SUCCESS);
                if (!TextUtils.isEmpty(string) && string.equals(com.taobao.agoo.a.a.b.JSON_SUCCESS)) {
                    c0054a.I = true;
                }
            }
            if (jSONObject.has("ret")) {
                c0054a.ah = jSONObject.getString("ret");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return c0054a;
    }
}
