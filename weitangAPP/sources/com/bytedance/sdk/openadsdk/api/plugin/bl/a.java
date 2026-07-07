package com.bytedance.sdk.openadsdk.api.plugin.bl;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.taobao.accs.common.Constants;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a() {
        String strOk = ok(8);
        if (strOk == null || strOk.length() != 16) {
            return null;
        }
        return strOk;
    }

    private static SecureRandom bl() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    @JProtect
    public static String ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strOk = ok();
        String strOk2 = ok(strOk, 32);
        String strA = a();
        String strOk3 = null;
        if (strOk2 != null && strA != null) {
            strOk3 = ok.ok(str, strA, strOk2);
        }
        return 3 + strOk + strA + strOk3;
    }

    @JProtect
    public static JSONObject ok(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strOk = ok(jSONObject.toString());
                if (!TextUtils.isEmpty(strOk)) {
                    jSONObject2.put(Constants.SHARED_MESSAGE_ID_FILE, strOk);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put(Constants.SHARED_MESSAGE_ID_FILE, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put(Constants.SHARED_MESSAGE_ID_FILE, jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static String ok() {
        String strOk = ok(16);
        if (strOk == null || strOk.length() != 32) {
            return null;
        }
        return strOk;
    }

    public static String ok(String str, int i2) {
        if (str == null || str.length() != i2) {
            return null;
        }
        int i3 = i2 / 2;
        return str.substring(i3, i2) + str.substring(0, i3);
    }

    public static String ok(int i2) {
        try {
            byte[] bArr = new byte[i2];
            bl().nextBytes(bArr);
            return bl.ok(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
