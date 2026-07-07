package com.tianmu.biz.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {
    public static String a(Context context) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String string = stringBuffer.toString();
            return string.substring(0, string.length() - 1);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
