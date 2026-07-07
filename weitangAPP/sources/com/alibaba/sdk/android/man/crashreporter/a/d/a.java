package com.alibaba.sdk.android.man.crashreporter.a.d;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Map<String, String> map, Context context) {
        if (context != null) {
            try {
                if (!map.containsKey("pt")) {
                    String strA = a(context, "package_type");
                    if (!TextUtils.isEmpty(strA)) {
                        map.put("pt", strA);
                    }
                }
                if (!map.containsKey("pid")) {
                    String strA2 = a(context, "project_id");
                    if (!TextUtils.isEmpty(strA2)) {
                        map.put("pid", strA2);
                    }
                }
                if (!map.containsKey("bid")) {
                    String strA3 = a(context, "build_id");
                    if (!TextUtils.isEmpty(strA3)) {
                        map.put("bid", strA3);
                    }
                }
                if (map.containsKey("bv")) {
                    return;
                }
                String strA4 = a(context, "base_version");
                if (TextUtils.isEmpty(strA4)) {
                    return;
                }
                map.put("bv", strA4);
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("get MetaData err", e2);
            }
        }
    }

    public static byte[] b(Map map) {
        try {
            if (map == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("serializeMetaData err,map is null!");
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("serializeMetaData err!", e2);
            return null;
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return null;
        }
        String strA = a(context, "base_version");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA;
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        int identifier = 0;
        try {
            identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getString Id error", e2);
        }
        if (identifier != 0) {
            return context.getString(identifier);
        }
        return null;
    }
}
