package com.ta.utdid2.device;

import com.ta.a.c.f;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean a(com.ta.a.b.a aVar) {
        String str = "";
        try {
            str = new String(aVar.data, "UTF-8");
        } catch (Exception e2) {
            f.m80a("", e2);
        }
        if (com.ta.a.b.a.a(str, aVar.f142a)) {
            return b.a(b.a(str).f10218d);
        }
        return false;
    }
}
