package com.ta.a.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10187a = -1;
    public long timestamp = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f142a = "";
    public byte[] data = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10188b = 0;

    public static boolean a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                com.ta.a.c.f.b("", "result", str, "signature", str2);
                if (str2.equals(com.ta.utdid2.a.a.a.encodeToString(com.ta.a.c.b.d(str).getBytes(), 2))) {
                    com.ta.a.c.f.m80a("", "signature is ok");
                    return true;
                }
                com.ta.a.c.f.m80a("", "signature is error");
            }
        } catch (Exception e2) {
            com.ta.a.c.f.m80a("", e2);
        }
        return false;
    }
}
