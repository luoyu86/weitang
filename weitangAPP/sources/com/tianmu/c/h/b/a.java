package com.tianmu.c.h.b;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a(String str, Context context) {
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strA);
        if (!a(stringBuffer.toString())) {
            return null;
        }
        return stringBuffer.toString() + File.separator + str;
    }

    public static String a(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath();
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return "";
        }
        return cacheDir.getAbsolutePath() + File.separator + Environment.DIRECTORY_DOWNLOADS;
    }

    private static boolean a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }
}
