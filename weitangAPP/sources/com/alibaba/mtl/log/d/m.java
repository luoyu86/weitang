package com.alibaba.mtl.log.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Random f4568a = new Random();

    public static String getImei(Context context) {
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_ie", "");
                if (!TextUtils.isEmpty(string)) {
                    String str = new String(c.decode(string.getBytes(), 2), "UTF-8");
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
            }
        }
        String uniqueID = TextUtils.isEmpty(null) ? getUniqueID() : null;
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("UTCommon", 0).edit();
                editorEdit.putString("_ie", new String(c.encode(uniqueID.getBytes("UTF-8"), 2)));
                editorEdit.commit();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return uniqueID;
    }

    public static String getImsi(Context context) {
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_is", "");
                if (!TextUtils.isEmpty(string)) {
                    String str = new String(c.decode(string.getBytes(), 2), "UTF-8");
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
            }
        }
        String uniqueID = TextUtils.isEmpty(null) ? getUniqueID() : null;
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("UTCommon", 0).edit();
                editorEdit.putString("_is", new String(c.encode(uniqueID.getBytes("UTF-8"), 2)));
                editorEdit.commit();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return uniqueID;
    }

    public static final String getUniqueID() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        Random random = f4568a;
        int iNextInt = random.nextInt();
        int iNextInt2 = random.nextInt();
        byte[] bytes = f.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = f.getBytes(iNanoTime);
        byte[] bytes3 = f.getBytes(iNextInt);
        byte[] bytes4 = f.getBytes(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return c.encodeToString(bArr, 2);
    }
}
