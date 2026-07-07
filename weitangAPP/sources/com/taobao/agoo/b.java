package com.taobao.agoo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final String TAG = "LocalStorage";

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            ALog.d(TAG, "saveAliasToken input invalid", new Object[0]);
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        if (TextUtils.isEmpty(str2)) {
            editorEdit.remove(b(str));
            String string = defaultSharedPreferences.getString("alicloud-third-push-alias-list", "");
            String strA = a(str);
            if (string.contains(strA)) {
                editorEdit.putString("alicloud-third-push-alias-list", string.replace(strA, ""));
            }
        } else {
            editorEdit.putString(b(str), str2);
            String string2 = defaultSharedPreferences.getString("alicloud-third-push-alias-list", "");
            String strA2 = a(str);
            if (!string2.contains(strA2)) {
                editorEdit.putString("alicloud-third-push-alias-list", string2 + strA2);
            }
        }
        editorEdit.apply();
    }

    private static String b(String str) {
        return "alicloud-third-push-pat-" + str;
    }

    private static String a(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return "#&#" + str + "#&#";
    }

    public static String a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            return PreferenceManager.getDefaultSharedPreferences(context).getString(b(str), null);
        }
        ALog.d(TAG, "getAliasToken input invalid", new Object[0]);
        return null;
    }

    public static ArrayList<String> a(Context context) {
        String[] strArrSplit = PreferenceManager.getDefaultSharedPreferences(context).getString("alicloud-third-push-alias-list", "").split("#&#");
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (strArrSplit[i2] != null && !strArrSplit[i2].isEmpty()) {
                arrayList.add(strArrSplit[i2]);
            }
        }
        return arrayList;
    }
}
