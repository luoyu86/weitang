package com.tianmu.c.e;

import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public String a(String str) {
        try {
            return !TextUtils.isEmpty(str) ? new String(Base64.decode(str, 2), "UTF-8") : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
